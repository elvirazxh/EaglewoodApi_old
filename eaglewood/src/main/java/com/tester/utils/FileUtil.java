package com.tester.utils;/**
 * Created by admin on 2019/6/27.
 */

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author zxh
 * @createTime 2019/6/27 19:37
 * @description
 */
public class FileUtil {

    public static String  readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        // 读取一行
        String line = null;
        StringBuffer strBuffer = new StringBuffer();
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            // 一次读入一行，直到读入null为文件结束
            while ((line = reader.readLine()) != null) {
                strBuffer.append(line);// 显示行号
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return String.valueOf(strBuffer);
    }

    public static void main(String[] args) {
        String str = readFileByLines("/Users/admin/Documents/workspace/svn/newsettle/yisecpay/branches/EaglewoodApi/eaglewood/src/main/java/com/tester/jsondata/transfer.json");
        System.out.println(str);
        System.out.println("-------------------");
//        JSONObject jsonObject = JSONObject.parseObject(str);
//        System.out.println(jsonObject.get("paramData"));

        JSONArray jsonArray = (JSONArray) JSONArray.parse(str);




        for(int i=0;i<jsonArray.size();i++){
            JSONObject paramJson = (JSONObject) jsonArray.get(i);
            paramJson.get("");

//            JSONObject paramJson = JSONObject.parseObject(jsonArray.get(i).toString());
            System.out.println( jsonArray.get(i).getClass());


        }

    }

}
 
    