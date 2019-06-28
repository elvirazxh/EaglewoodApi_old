package com.tester.cases;/**
 * Created by admin on 2019/6/21.
 */

import com.tester.mybatis.ext.TransferCaseService;
import com.tester.mybatis.pojo.Transfercase;
import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 * @author zxh
 * @createTime 2019/6/21 17:52
 * @description
 */
public class TransferTest {

//    @Autowired
//    TransferCaseService transferCaseService;

    @Test(groups = "transfer",description = "通用转账接口")
    public void testTransfer() throws Exception {

        TransferCaseService transferCaseService = new TransferCaseService();

        List<String> paramStr = transferCaseService.getParams();//请求参数信息
        List<String> resultStr = transferCaseService.getResult();//返回结果信息
        List<String> expect = transferCaseService.getResultMsg();//返回结果状态码

        Transfercase transfercase = new Transfercase();

        for(int i=0;i<paramStr.size();i++){
            transfercase.setId("transfer"+ UUID.randomUUID().toString().replace("-", "").toLowerCase());
            transfercase.setParamjson(paramStr.get(i));
            transfercase.setResultjson(resultStr.get(i));
            transfercase.setExcept(expect.get(i));
            transfercase.setCreateTime(new Date());

            transferCaseService.insertTransfercase(transfercase);

        }
//        transfercase.setId("transfer"+ UUID.randomUUID().toString().replace("-", "").toLowerCase());
//        transfercase.setParamjson(paramStr);
//        transfercase.setResultjson(resultStr);
//        transfercase.setExcept(expect);
//        transfercase.setCreateTime(new Date());
//
//        transferCaseService.insertTransfercase(transfercase);


    }





}
































 
    