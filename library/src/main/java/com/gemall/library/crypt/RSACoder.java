package com.gemall.library.crypt;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

import sun.miscc.BASE64Decoder;
import sun.miscc.BASE64Encoder;

@SuppressWarnings("unused")
public class RSACoder {
    private static final int MAX_ENCRYPT_BLOCK = 117;
    // 算法
    public static String KEY_ALGORITHM = "RSA";

    // 私钥
    private static String Private_Key = "RSAPrivateKey";
    // 公钥

    public static String Public_Key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDk1q4KFj4D/vroePYBsBC3qtVE\n" +
            "dwYUuszirH7eTgesB4EY0jdGBsHjeJHHt1Fo+q15brTYMAFxbKxXLSZ/ctUa1jb5\n" +
            "A7d8EbPhuqHfnfd8BOrSB5//xkJsLvCpBZobnC4Ir7Oec2W7aNlyViWnrPHfBIFT\n" +
            "kzU8IBUzKncOFdgoUwIDAQAB\n"; // base64//BCD//Hex//测试环境KEY/206/bit

    public static String ICCS_Public_Key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCTLC0mrDUexLyqByvowkdA3k+Z"
            + "EaRddyTSmIcjZnl+3sUUqIk3ciXuB9Yo9+D/XhGy3+Q2ELaqNMhEP8ROnSzS5Zd5"
            + "bRkroXKgFGmRSNp/KJQ5R+B6RKFnDasu+78vpwqm5HZFdz/ykhAXQEcKQ9h29ZW8"
            + "S3wlR1LfXd3uueH18QIDAQAB\n";

    // 密钥长度
    public static int Key_Size = 512;


    /**
     * 公钥加密
     *
     * @param data
     * @return
     */
    public static String encryptBySkuPubkeyToBase64(String publicKey, String data) {
        try {
            return encryptByPublicKeyToBase64(publicKey, data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * RSA加密公钥后转base64
     *
     * @param strKey
     * @param strData
     * @return
     * @throws Exception
     */
    public static String encryptByPublicKeyToBase64(String strKey, String strData) throws Exception {
        byte data[] = strData.getBytes(StandardCharsets.UTF_8);
        byte key[];
        BASE64Decoder decoder = new BASE64Decoder();
        key = decoder.decodeBuffer(strKey);
        //实例化公钥材料
        X509EncodedKeySpec x509spec = new X509EncodedKeySpec(key);
        //实例化公钥工厂
        KeyFactory keyfactory = KeyFactory.getInstance(KEY_ALGORITHM);
        //生成公钥
        PublicKey pubKey = keyfactory.generatePublic(x509spec);
        //公钥加密
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(cipher.doFinal(data));
    }



}
