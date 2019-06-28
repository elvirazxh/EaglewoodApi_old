package com.tester.utils;/**
 * Created by admin on 2019/6/21.
 */

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author zxh
 * @createTime 2019/6/21 15:20
 * @description 处理配置文件的类,获取公共参数值
 */


public class ConfigFile {

    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getPublicParam(PublicParam paramName){

        String param="";

        if(paramName==PublicParam.SIMULATIONEAGLEWOODAPIURL){
            param = bundle.getString("simulation.eaglewood_api.url");
        }

        if(paramName==PublicParam.SIMULATIONHBBANKPUBKEY){
            param = bundle.getString("simulation.bank_pub_key");
        }

        if(paramName==PublicParam.SIMULATIONHBMERCHID){
            param = bundle.getString("simulation.merch_id");
        }

        if(paramName==PublicParam.SIMULATIONHBSIGNTYPE){
            param = bundle.getString("simulation.sign_typ");
        }

        if(paramName==PublicParam.SIMULATIONHBPRIKEY){
            param = bundle.getString("simulation.pri_key");
        }

        if(paramName==PublicParam.SIMULATIONHBMERCHID1){
            param = bundle.getString("simulation.merch_id1");
        }

        if(paramName==PublicParam.SIMULATIONHBPRIKEY1){
            param = bundle.getString("simulation.pri_key1");
        }

        if(paramName==PublicParam.SIMULATIONPASSWORD){
            param = bundle.getString("simulation.password");
        }

        return param;
    }
}
 
    