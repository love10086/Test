package com.gemall.library.util;

import com.gemall.library.BuildConfig;
import com.gemall.library.crypt.JniCrypt4A;
import com.gemall.library.crypt.RSACoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static String EncryptRSA(String encryptStr) {
        if (BuildConfig.DEBUG){
            //test use
            return JniCrypt4A.getInstance().encryptRSA4test(encryptStr, JniCrypt4A.addBeginEnd4Pubkey(RSACoder.Public_Key));
        }else {
            return JniCrypt4A.getInstance().encryptRSA(encryptStr);
        }
    }

    /**
     * 判断字符串是否含有空白符
     *
     * @param str
     * @return
     */
    public static boolean isContainSpace(String str) {

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isWhitespace(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 产生随机字符串
     */
    private static Random randGen = null;
    private static char[] numbersAndLetters = null;

    public static final String randomString(int length) {
        if (length < 1) {
            return null;
        }
        if (randGen == null) {
            randGen = new Random();
            numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz" + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ")
                    .toCharArray();
        }
        char[] randBuffer = new char[length];
        for (int i = 0; i < randBuffer.length; i++) {
            randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
        }
        return new String(randBuffer);
    }


    /**
     * 后台返回的字符串是否为null
     * @param str
     * @return
     */
    public static boolean isNull(String str){
        return str == null || str.equals("") || str.equals("null");
    }

    public static boolean isDouble(String str){
        String strPattern = "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?";
        Pattern p = Pattern.compile(strPattern);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     *  判断是否为有效字符串
     */
    public static boolean isUsefulString(String values){
        return null != values && 0 < values.length();
    }

    /**
     *  判断是否为有效字List
     */
    public static boolean isUsefulList(List list){
        return null != list && 0 < list.size();
    }


    public static List<String> regexMapValue(String s) {
        List<String> mapValues = new ArrayList<>();
        if (s.contains(",")) {
            String[] split = s.split(",");
            for (String str : split) {
                String[] split1 = str.split(":");
                mapValues.add(split1[1]);
            }
        } else {
            String[] strings = s.split(":");
            mapValues.add(strings[1]);
        }
        return mapValues;
    }

    /**
     * map迭代
     * @param json
     * @return
     */
    public static List<String> getMapValue(String json) {
        Map map = SkuUtils.gson.fromJson(json, Map.class);
        List<String> mapValues = new ArrayList<>();
        for (Object key : map.keySet()) {
            System.out.println("key= " + key + " and value= " + map.get(key));
            mapValues.add(map.get(key).toString());
        }
        return mapValues;
    }

    /**
     * 拼接集合元素，去除最后一个逗号
     * @param list
     * @return
     */
    public static String getListStr(List<String> list){
        StringBuffer buffer  = new StringBuffer();
        for(String str : list){
            buffer.append(str).append(",");
        }
        buffer.delete(buffer.length()-1,buffer.length());
        return buffer.toString();
    }
}
