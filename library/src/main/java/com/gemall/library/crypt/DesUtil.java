package com.gemall.library.crypt;

import android.text.TextUtils;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.logging.LogManager;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/****
 * @Project_Name: GWT
 * @Copyright: Copyright © gatewang.com
 * @Version: 1.0.0.1
 * @File_Name: DesUtil.java
 * @CreateDate: 2014年5月4日 下午4:44:10
 * @Designer: Wiket.Zhou
 * @Desc
 ****/

@SuppressWarnings("unused")
public class DesUtil {
    // private final static String DESKey = "33367077";
    public final static String DESKey = "20140506";
    public final static String DESPosKey = "12345678";
    private final static String DES = "DES";

    public static void main(String[] args) {
        String data = "laiyingbing";
        String key = DESKey;
    }

    /**
     * Description 根据键值进行加密
     *
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static String encrypt(String data, String key) throws Exception {
        byte[] bt = encrypt(data.getBytes(), key.getBytes());
        String strs = new sun.miscc.BASE64Encoder().encode(bt);
        return strs;
    }



    public static String encryptDes(String str) {
        String s = "";
        try {
            s = DesUtil.encryptDES(str, DesUtil.DESKey);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return s;
    }

    public static String decryptDes(String str) {
        String decrypt = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                decrypt = DesUtil.decryptDES(str, DesUtil.DESKey);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decrypt;
    }

    /**
     * Description 根据键值进行解密
     *
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws IOException
     * @throws Exception
     */
    private static String decrypt(String data, String key) throws Exception {
        if (data == null)
            return null;
        sun.miscc.BASE64Decoder decoder = new sun.miscc.BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(data);
        byte[] bt = decrypt(buf, key.getBytes());
        return new String(bt);
    }

    /**
     * Description 根据键值进行加密
     *
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    /**
     * Description 根据键值进行解密
     *
     * @param data
     * @param key  加密键byte数组
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();

        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);

        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);

        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);

        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

        return cipher.doFinal(data);
    }

    private static byte[] iv = {1, 2, 3, 4, 5, 6, 7, 8};

    public static String encryptDES(String encryptString, String encryptKey) throws Exception {
        IvParameterSpec zeroIv = new IvParameterSpec(iv);
        SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
        byte[] encryptedData = cipher.doFinal(encryptString.getBytes());
        sun.miscc.BASE64Encoder encoder = new sun.miscc.BASE64Encoder();
        return encoder.encode(encryptedData);
    }

    public static String decryptDES(String decryptString, String decryptKey) throws Exception {
        sun.miscc.BASE64Decoder decoder = new sun.miscc.BASE64Decoder();
        byte[] byteMi = decoder.decodeBuffer(decryptString);
        IvParameterSpec zeroIv = new IvParameterSpec(iv);
        SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
        byte decryptedData[] = cipher.doFinal(byteMi);

        return new String(decryptedData);
    }

    //针对网页传输的加密方式,用在盖付通推荐者、微小企商品，由于微信打开URL的方式是GET，采用DES加密+转码
    public static String encryptDESByECB(String encryptString, String encryptKey) throws Exception {
        SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(encryptString.getBytes());
        sun.miscc.BASE64Encoder encoder = new sun.miscc.BASE64Encoder();
        return encoder.encode(encryptedData);
    }

    public static String decryptDESByECB(String decryptString, String decryptKey) throws Exception {
        sun.miscc.BASE64Decoder decoder = new sun.miscc.BASE64Decoder();
        byte[] byteMi = decoder.decodeBuffer(decryptString);
        SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), "DES");
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte decryptedData[] = cipher.doFinal(byteMi);
        String data = new String(decryptedData);
        return data;
    }
}
