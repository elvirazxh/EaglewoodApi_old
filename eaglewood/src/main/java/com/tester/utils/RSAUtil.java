package com.tester.utils;


import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSAUtil {

    /**
     * RSA2
     */
    public static final String RSA2_SIGN_ALGORITHMS = "SHA256WithRSA";
    public static final String RSA_SIGN_ALGORITHMS = "SHA1WithRSA";
    private static final String _CHARSET_NAME = "UTF-8";


    private static final String SIGN_ALGORITHMS = "SHA1WithRSA";
//    public static final String RSA2_SIGN_ALGORITHMS = "SHA256WithRSA";
//    public static final String _CHARSET_NAME = "UTF-8";
    private static final int DECRPT_MAX_LEN = 128;
    private static final int ENCRPT_MAX_LEN = 117;

    /**
     * 加密类型
     */
    public interface Transformation {
        String ECB_PKCS1PADDING = "RSA/ECB/PKCS1Padding";
    }

    /**
     * RSA签名
     *
     * @param content         待签名数据
     * @param privateKey      商户私钥
//     * @param input_charset   编码格式
//     * @param SIGN_ALGORITHMS 签名算法
     * @return 签名值
     */
//    public static String sign(String content, String privateKey, String input_charset, String SIGN_ALGORITHMS) throws Exception {
//        PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKey));
//        KeyFactory keyf = KeyFactory.getInstance("RSA");
//        PrivateKey priKey = keyf.generatePrivate(priPKCS8);
//
//        java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);
//
//        signature.initSign(priKey);
//        signature.update(content.getBytes(input_charset));
//
//        byte[] signed = signature.sign();
//        return Base64.encode(signed);
//    }

    public static String sign(String content, String privateKey) throws Exception {
        PrivateKey priKey = getPrivateKey(privateKey);
        Signature signature = Signature.getInstance("SHA1WithRSA");
        signature.initSign(priKey);
        signature.update(content.getBytes("UTF-8"));
        byte[] signed = signature.sign();
        return Base64.encode(signed);
    }

    private static PrivateKey getPrivateKey(String priKey) throws Exception {
        byte[] priKeyBytes = Base64.decode(priKey);
        PKCS8EncodedKeySpec priKeySpec = new PKCS8EncodedKeySpec(priKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(priKeySpec);
    }

    /**
     * RSA验签名检查
     *
     * @param content         待签名数据
     * @param sign            签名值
     * @param publicKey       RSA公钥
     * @param input_charset   编码格式
     * @param SIGN_ALGORITHMS 签名算法
     * @return 布尔值
     */
    public static boolean verify(String content, String sign, String publicKey, String input_charset, String SIGN_ALGORITHMS) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] encodedKey = Base64.decode(publicKey);
        PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

        Signature signature = Signature.getInstance(SIGN_ALGORITHMS);

        signature.initVerify(pubKey);
        signature.update(content.getBytes(input_charset));

        boolean bverify = signature.verify(Base64.decode(sign));
        return bverify;
    }

    /**
     * 公钥加密
     *
     * @param content      密文
     * @param publicKeyStr 商户私钥
     * @return 解密后的字符串
     */
    public static String publicEncrypt(String content, String publicKeyStr) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        byte[] encodedKey = Base64.decode(publicKeyStr);
        PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));

        byte[] data = content.getBytes(_CHARSET_NAME);
        byte[] encryptData = encryptOrDecrypt(pubKey, data, Cipher.ENCRYPT_MODE);
        return Base64.encode(encryptData);
    }

    /**
     * 私钥解密
     *
     * @param base64Content BASE64加密后的字符串 密文
     * @param privateKeyStr 商户私钥
     * @return 解密后的字符串
     */
    public static String privateDecrypt(String base64Content, String privateKeyStr) throws Exception {
        PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKeyStr));
        KeyFactory keyf = KeyFactory.getInstance("RSA");
        PrivateKey priKey = keyf.generatePrivate(priPKCS8);

        byte[] data = Base64.decode(base64Content);
        byte[] decryptData = encryptOrDecrypt(priKey, data, Cipher.DECRYPT_MODE);
        return new String(decryptData, _CHARSET_NAME);
    }

    /**
     * 加解密
     * @param key
     * @param data
     * @param mode
     * @return
     * @throws Exception
     */
    private static byte[] encryptOrDecrypt(Key key, byte[] data, int mode) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        //提供者
        Provider provider = new BouncyCastleProvider();
        Cipher cipher = Cipher.getInstance(Transformation.ECB_PKCS1PADDING, provider);
        cipher.init(mode, key);
        int blockSize = cipher.getBlockSize();
        int length = data.length;
        int num = length / blockSize + 1;
        int cache = blockSize;
        byte[] bytes = null;
        for (int i = 0; i < num; i++) {
            if (i == num - 1) {
                cache = length % blockSize;
                if (cache == 0) {
                    return out.toByteArray();
                }
            }
            bytes = cipher.doFinal(data, i * blockSize, cache);
            out.write(bytes);
        }
        return out.toByteArray();
    }

}
