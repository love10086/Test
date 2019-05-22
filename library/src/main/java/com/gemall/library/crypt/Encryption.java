package com.gemall.library.crypt;

import android.content.Context;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;


public class Encryption {

	public String Key="ahuyiyjkshfksjgsgks1234";
	public String getPin(String strToEncode,String imsi,String key,Context context)
	{
		if(null==key)key=Key;
//		DialogUtils dialogUtils=DialogUtils.getInstance();
//		dialogUtils.initSubmitDialog(context);
//		dialogUtils.setSubmitContent(strToEncode+imsi+key);
//		dialogUtils.showDialog();
		String Md5=MD5(strToEncode+imsi+key);
//		String Md5=MD5("13717481224,201501210999,2015-05-18 15:25:1151hvOK029B9fRqrWy4v8CWFKs5t5WoKpIwdSov15ahuyiyjkshfksjgsgks1234");
		
		byte buff[] = null;
        buff = Md5.getBytes(StandardCharsets.UTF_8);
        byte bufret[];
		//下面的循环是不断进行异或，让每一个数据都参与运算，直到长度小于3，，则输出整数
		while(buff.length>3)
		{
			int length=buff.length;
			int yu=length%2;
			int shang=length/2;
			
			bufret=new byte[yu+shang];
			for(int i=0;i<yu+shang;i++)
			{
				if(i!=length-1-i&&i<length-1-i)
				{
					bufret[i]=(byte) (buff[i]^buff[length-1-i]);
				}
				else
				{
					bufret[i]=buff[i];
				}
			}
			
			buff=bufret;
		}
		String ret="";
		for(int i=0;i<buff.length;i++)
		{
			long i1=buff[i]&0xff;
			i1=i1*i1*i1*19%999;
			String temp=((int)i1)+"";
		    while(temp.length()<3)
		    {
		    	temp="0"+temp;
		    }
		    ret+=temp;
		}
		
		return ret;
	}


	//md5加密
	public static String MD5(String s) {
		char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

	}

}
