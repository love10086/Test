package com.gemall.library.crypt;

/**
 * author : g-emall
 * time   : 2019/4/3
 * desc   :
 */
public class JniCrypt4A {
    private static JniCrypt4A mInstance;

    private JniCrypt4A(){

    }

    public synchronized static JniCrypt4A getInstance(){
        if(null == mInstance){
            mInstance = new JniCrypt4A();
        }
        return mInstance;
    }

    /**
     * 对密钥的首尾添加公钥描述
     * @param pubKey    公钥
     * @return
     */
    public static String addBeginEnd4Pubkey(String pubKey){
        StringBuilder pubKeyB = new StringBuilder();
        pubKeyB.append(pubKey);
        pubKeyB.insert(0, "-----BEGIN PUBLIC KEY-----\n");
        pubKeyB.append("-----END PUBLIC KEY-----\n");
        return pubKeyB.toString();
    }

    public native  String MD5(String msg);

    //默认key是1234567812345678
    public native  String encodeAES(String msg);
    public native  String decodeAES(String msg);

    //des默认key是12345678
    public native  String encryptDES(String msg, int type);
    public native  String decryptDES(String msg, int type);


    public native  String decryptRSA(String msg);
    public native  String encryptRSA(String msg);

    /**
     * 支持传入公钥进行加密，方便测试环境使用
     * @param msg       待加密明文
     * @param pubKey    公钥
     * @return
     */
    public native  String encryptRSA4test(String msg, String pubKey);

    public native  String encryptBase64(String msg);
    public native  String decryptBase64(String msg);

    /**
     * 使用前需要先进行init初始化验证应用的合法性和识别key类型
     * @param contextObject
     * @param rsaUtilMode 1为开启Base64转换，2为开启Hex转换
     * @return
     */
    public native  String initEncrypt(Object contextObject, int rsaUtilMode);

    //关闭应用时需要关闭函数释放内存
    public native  String exitEncrypt();

    //获取使用的openssl库版本号
    public native  String getOpensslVersion();

    //校验应用签名是否合法
    public static native String getAuthResultFromC(Object contextObject);

    /**
     * 设置使用的RSA加密处理模式
     * @param rsaUtilMode 1为Base64模式；2为Hex模式
     */
    public native  void setRsaUtilMode(int rsaUtilMode);

    static {
        System.loadLibrary("nativecrypt");
    }

}