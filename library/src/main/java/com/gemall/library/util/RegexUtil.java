package com.gemall.library.util;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * 创建人：guojun.li
 * 创建时间：2016/11/11
 * 类描述：正则判断工具类
 */

public class RegexUtil {
    /**
     * 平台帐号验证
     * 以GW(gw)开头后加至少8位数字
     *
     * @param gwNumber
     * @return
     */
    public static boolean checkGW(String gwNumber) {
        if (TextUtils.isEmpty(gwNumber)) return false;
        return gwNumber.matches("[G|g][W|w]\\d{8,9}");
    }

    /**
     * 用户密码验证
     * 限制为长度6-20位，且必须字母+数字组合（不含标点等特殊字符）
     *
     * @param pwd
     * @return
     */
    public static boolean checkPwd(String pwd) {
        String regex = "(?!^\\d+$)(?!^[a-zA-Z]+$)[0-9a-zA-Z]{6,20}";
        return Pattern.matches(regex, pwd);
    }

    /**
     * 验证手机号码（支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））
     *
     * @param mobile 移动、联通、电信运营商的号码段
     *               <p>
     *               移动的号段：134(0-8)、135、136、137、138、139、147（预计用于TD上网卡）
     *               、150、151、152、157（TD专用）、158、159、187（未启用）、188（TD专用）
     *               </p>
     *               <p>
     *               联通的号段：130、131、132、155、156（世界风专用）、185（未启用）、186（3g）
     *               </p>
     *               <p>
     *               电信的号段：133、153、180（未启用）、189
     *               </p>
     * @return 验证成功返回true，验证失败返回false
     */
    /**
     *
     手机号开头集合
     166，
     176，177，178
     180，181，182，183，184，185，186，187，188，189
     145，147
     130，131，132，133，134，135，136，137，138，139
     150，151，152，153，155，156，157，158，159
     198，199
     */
    public static boolean checkMobile(String mobile) throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(166)|(17[0-8])|(18[0-9])|(19[8-9])|(147,145))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(mobile);
        return m.matches();
    }

    /**
     * 替换手机号(18600000000 -> 186****0000)
     *
     * @param phoneNum
     * @return
     */
    public static String replaceMobileNum(String phoneNum) {
        if (!TextUtils.isEmpty(phoneNum)) {
            String regex = "(\\d{3})\\d{4}(\\d{4})";
            Matcher matcher = Pattern.compile(regex).matcher(phoneNum);
            return matcher.replaceAll("$1****$2");
        } else {
            return phoneNum;
        }
    }

    /**
     * 匹配网址
     *
     * @param uri
     * @return
     */
    public static boolean matchWebsite(String uri) {
        boolean isMatch = false;
        if (!TextUtils.isEmpty(uri)) {
            String regex = "(http://|ftp://|https://|www){0,1}[^\u4e00-\u9fa5\\s]*?\\.(com|net|cn|me|tw|fr)[^\u4e00-\u9fa5\\s]*";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(uri);
            isMatch = matcher.matches();
        }

        return isMatch;
    }

    /**
     * 判断是否匹配正则
     *
     * @param regex 正则表达式
     * @param input 要匹配的字符串
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isMatch(String regex, CharSequence input) {
        return input != null && input.length() > 0 && Pattern.matches(regex, input);
    }
//
//    /**
//     * 验证香港身份证号码
//     * 一个英文+6个数字+（一个校验码0~9或A-z）
//     * @param input 待验证文本
//     * @return {@code true}: 匹配<br>{@code false}: 不匹配
//     */
//    public static boolean isHK_IDCard(CharSequence input) {
//        return isMatch(Constant.REGEX_HK_ID_CARD, input);
//    }
//
//    /**
//     * 验证澳门身份证号码
//     * 第一位1、5、7，后面7个数字，最后带括号的一位校验码【不知道有没有字母】
//     * @param input 待验证文本
//     * @return {@code true}: 匹配<br>{@code false}: 不匹配
//     */
//    public static boolean isMacau_IDCard(CharSequence input) {
//        return isMatch(Constant.REGEX_MACAU_ID_CARD, input);
//    }
//
//    /**
//     * 验证护照格式
//     * @param input 待验证文本
//     * @return {@code true}: 匹配<br>{@code false}: 不匹配
//     */
//    public static boolean isPassport(CharSequence input) {
//        if (input != null && input.length() > 0) {
//            if (Pattern.matches(Constant.PASSPORT1, input)) {
//                return true;
//            } else {
//                return false;
//            }
//        } else {
//            return false;
//        }
//    }

//    /**
//     * 验证台湾身份证号码
//     * 1个英文+9个数字
//     * @param input 待验证文本
//     * @return {@code true}: 匹配<br>{@code false}: 不匹配
//     */
//    public static boolean isTW_IDCard(CharSequence input) {
//        return isMatch(Constant.REGEX_TW_ID_CARD, input);
//    }
}
