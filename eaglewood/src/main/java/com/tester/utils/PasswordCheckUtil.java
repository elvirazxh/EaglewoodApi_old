package com.tester.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 密码强度检测
 */
public class PasswordCheckUtil {

    private static final String[] DEFAULT_SPECIAL_CHARS = new String[]{"!", "@", "#", "$", "%", "`", "^", "&", "*", "(", ")", "-" //
            , "_", "+", "=", "<", ">", "?", "/", "\\", "{", "}", "[", "]", ":", ";", "\"", "'", "|", "~", ".", ","};
    private static String DEFAULT_SPECIAL_STRING;

    static {
        StringBuffer specialBuf = new StringBuffer(10);
        for (String s : DEFAULT_SPECIAL_CHARS) {
            specialBuf.append("\\" + s);
        }
        DEFAULT_SPECIAL_STRING = specialBuf.toString();
    }


    /**
     * 复杂校验(数字 + 字母 + 特殊字符)
     *
     * @param password
     * @return
     */
    public static boolean numAlphaSpecialCharCheck(String password) {
        if (password == null) {
            return false;
        }
        int count = 0;
        if (allowCharCheck(password, "0-9", "a-zA-Z", DEFAULT_SPECIAL_STRING)){
            return true;
        }
        if (numberCheck(password)){
            count += 1;
        }
        if (alphaCheck(password)){
            count += 1;
        }
        if (specialCharCheck(password, DEFAULT_SPECIAL_STRING)){
            count += 1;
        }
        if (count >= 2){
            return true;
        }
        return false;
    }

    /**
     * 复杂校验(数字 + 字母 + 特殊字符)
     *
     * @param password
     * @param specialCharArray 自定义特殊字符数组
     * @return
     */
    public static boolean numAlphaSpecialCharCheck(String password, String[] specialCharArray) {
        if (password == null) {
            return false;
        }

        StringBuffer specialBuf = new StringBuffer(10);
        if (specialCharArray != null && specialCharArray.length > 0) {
            for (String s : DEFAULT_SPECIAL_CHARS) {
                specialBuf.append("\\" + s);
            }
        }
        String specialStr = specialBuf.toString();
        return allowCharCheck(password, "0-9", "a-zA-Z", specialStr) //
                && numberCheck(password) //
                && alphaCheck(password) //
                && specialCharCheck(password, specialStr);
    }


    /**
     * 长度校验
     *
     * @param password
     * @param lenMin   最小长度
     * @param lenMax   最大长度 -1不校验
     * @return
     */
    public static boolean lengthCheck(String password, int lenMin, int lenMax) {
        if (StringUtils.isBlank(password)
                || password.length() < lenMin
                || (lenMax != -1 && password.length() > lenMax)) {
            return false;
        }
        return true;
    }

    /**
     * 允许字符校验
     */
    protected static boolean allowCharCheck(String password, String number, String alpha, String specialRegexStr) {
        return password.matches("^[" + number + alpha + specialRegexStr + "]+$");
    }

    /**
     * 包含数字
     */
    protected static boolean numberCheck(String password) {
        return password.matches("^.*([0-9]+).*$");
    }

    /**
     * 包含字母
     */
    protected static boolean alphaCheck(String password) {
        return password.matches("^.*([a-zA-Z]+).*$");
    }

    /**
     * 包含特殊字符
     */
    protected static boolean specialCharCheck(String password, String specialRegexStr) {
        if (StringUtils.isNotBlank(specialRegexStr)) {
            return password.matches("^.*([" + specialRegexStr + "]+).*$");
        }
        return true;
    }
}
