package com.tester.mybatis.ext;/**
 * Created by admin on 2019/6/24.
 */

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tester.mybatis.dao.TransfercaseMapper;
import com.tester.mybatis.pojo.Transfercase;
import com.tester.utils.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * @author zxh
 * @createTime 2019/6/24 19:03
 * @description
 */

@Service
public class TransferCaseService {

    private static Logger logger = LoggerFactory.getLogger(TransferCaseService.class);

    @Autowired
    TransfercaseMapper transfercaseMapper;

    /**
     * 生成参数方法
     * @return
     */
    public List<String> getParams() throws Exception {
        List<String> params = new ArrayList<String>();

        //读取transfer.json文件
        String jsonStr = FileUtil.readFileByLines("/Users/admin/Documents/workspace/svn/newsettle/yisecpay/branches/EaglewoodApi/eaglewood/src/main/java/com/tester/jsondata/transfer.json");
        JSONArray jsonArray = (JSONArray) JSONArray.parse(jsonStr);
        for(int i=0;i<jsonArray.size();i++){
            JSONObject paramJson = (JSONObject) jsonArray.get(i);
            System.out.println(paramJson);
             //生成订单号和seqNo
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmssS");
            String orderId = "EA" + dateFormat.format(Calendar.getInstance().getTime());
            String seqNo = "SeqNo" + dateFormat.format(Calendar.getInstance().getTime());
            //生成timestamp
            SimpleDateFormat timesFormat = new SimpleDateFormat("yyyyMMddhhmmss");
            String times = timesFormat.format(Calendar.getInstance().getTime());

            JSONObject dataObj = new JSONObject();
            dataObj.put("orderId", orderId);
            dataObj.put("bizType", paramJson.get("bizType"));  //01-11
            dataObj.put("txnType", paramJson.get("txnType"));//03-普通转账、24-消费即时到账、25-消费担保交易、26-普通分账
            dataObj.put("payExAccNo", paramJson.get("payExAccNo"));
            dataObj.put("recvExAccNo", paramJson.get("recvExAccNo"));
            dataObj.put("amount", paramJson.get("amount"));
            dataObj.put("feeAmt", paramJson.get("feeAmt"));
            String password;
            if("encryptMode"=="01"){//加密模式,默认00不加密   ApplicationConfig.simulationHbBankPubKey
                password = RSAUtil.publicEncrypt(ConfigFile.getPublicParam(PublicParam.SIMULATIONPASSWORD), ConfigFile.getPublicParam(PublicParam.SIMULATIONHBBANKPUBKEY));
            }
            else {password = ConfigFile.getPublicParam(PublicParam.SIMULATIONPASSWORD); }
            dataObj.put("password", password);
            dataObj.put("encryptMode", paramJson.get("encryptMode"));
            dataObj.put("extend1", paramJson.get("extend1"));

            String content = seqNo + dataObj.toJSONString();

            JSONObject newObj = new JSONObject();
            newObj.put("versionNo", paramJson.get("versionNo"));
            newObj.put("serviceId", paramJson.get("serviceId"));
            newObj.put("merchId", ConfigFile.getPublicParam(PublicParam.SIMULATIONHBMERCHID1));
            newObj.put("signType", paramJson.get("signType"));

            newObj.put("sign", RSAUtil.sign(content, ConfigFile.getPublicParam(PublicParam.SIMULATIONHBPRIKEY1)));
            newObj.put("timestamp", times);
            newObj.put("seqNo", seqNo);
            newObj.put("data", dataObj.toJSONString());
            params.add(i,newObj.toJSONString());

//            params = newObj.toJSONString();
        }

        return  params;
    }

    /**
     * 获取请求结果
     * @return
     * @throws Exception
     */
    public List<String> getResult() throws Exception {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        //请求的URL
        HttpPost post = new HttpPost(ConfigFile.getPublicParam(PublicParam.SIMULATIONEAGLEWOODAPIURL));
        List<String> result = new ArrayList<String>();//存放返回结果

        //请求参数
        List<String> params = getParams();

        for(int i=0;i<params.size();i++){
            //设置头信息
            post.setHeader("content-type","application/json");
            StringEntity entity = new StringEntity(params.get(i),"utf-8");
            post.setEntity(entity);

            //执行post方法
            HttpResponse response = httpClient.execute(post);
            //获取响应结果
            result.add(i,EntityUtils.toString(response.getEntity(),"utf-8"));
        }
//        //设置头信息
//        post.setHeader("content-type","application/json");
//        StringEntity entity = new StringEntity(params,"utf-8");
//        post.setEntity(entity);
//        String result;//存放返回结果
//        //执行post方法
//        HttpResponse response = httpClient.execute(post);
//        //获取响应结果
//        result = EntityUtils.toString(response.getEntity(),"utf-8");
//        System.out.println(result);
        return result;

    }

    /**
     * 获取返回结果中的msg
     * @return
     * @throws Exception
     */
    public List<String> getResultMsg() throws Exception{
//        JSONObject result = JSONObject.parseObject(getResult());//存放返回结果
//        String resultMsg = (String) result.get("msg");
//
//        System.out.println(result.get("data"));
//        JSONObject resultData =JSONObject.parseObject((String) result.get("data"));
//        String retMsg = (String) resultData.get("retMsg");
//        return resultMsg+","+retMsg;
        List<String> resultExpect = new ArrayList<String>();
        List<String> str = getResult();
        for(int i=0;i<str.size();i++){
            JSONObject result = JSONObject.parseObject(str.get(i));
            String resultMsg = (String) result.get("msg");
            JSONObject resultData =JSONObject.parseObject((String) result.get("data"));
            String retMsg = (String) resultData.get("retMsg");
            resultExpect.add(i,resultMsg+","+retMsg);

        }
        return resultExpect;
    }


    /**
     * 往数据库插入用例
     * @throws Exception
     */

    public void insertTransfercase(Transfercase transfercase) throws Exception {

        //得到sqlsession对象，这个对象就能执行配置文件中的sql语句啦
        SqlSession session = DatabaseUtil.getSqlSession();
        transfercaseMapper= session.getMapper(TransfercaseMapper.class);
//        int i = transfercaseMapper.insert(transfercase);
//        System.out.println(i);
        transfercaseMapper.insert(transfercase);

    }



    public static void main(String[] args) throws Exception {
//        TransferCaseService test = new TransferCaseService();
//
//
//        String paramStr = test.getParams();//请求参数信息
//        String resultStr = test.getResult();//返回结果信息
//        String expect = test.getResultMsg();//返回结果状态码
//
//
//        Transfercase transfercase = new Transfercase();
//        transfercase.setId("transfer"+ UUID.randomUUID().toString().replace("-", "").toLowerCase());
//        transfercase.setParamjson(paramStr);
//        transfercase.setResultjson(resultStr);
//        transfercase.setExcept(expect);
//        transfercase.setCreateTime(new Date());
//
//        test.insertTransfercase(transfercase);
    }


}
 
    