package com.tester.config;/**
 * Created by admin on 2019/6/21.
 */

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * @author Zxh
 * @createTime 2019/6/21 15:12
 * @description
 */


//配置文件相关信息
public class ApplicationConfig {

    public static String simulationEaglewoodApiUrl;
    public static String simulationHbBankPubKey;//梅州银行公钥
    public static String simulationHBSignType;//RSA
    public static String simulationHBMerchId;//对接梅州商户EW20181107155448
    public static String simulationHBPriKey;//梅州商户EW20181107155448私钥
    public static String simulationHBMerchId1;//对接梅州商户EW20181101181709
    public static String simulationHBPriKey1;//梅州商户EW20181101181709私钥
    public static String simulationPassword;//梅州商户EW20181101181709密码

    public static DefaultHttpClient defaultHttpClient;
    public static CookieStore cookieStore;

}























    