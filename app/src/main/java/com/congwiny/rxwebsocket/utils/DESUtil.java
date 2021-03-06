package com.congwiny.rxwebsocket.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
public class DESUtil {
    private static final String Key = "d4odQA#5";
    private static final String Algorithm = "DES";  //定义 加密算法,可用 DES,DESede,Blowfish
    // 加密字符串
    public static String encryptMode(String src) {
        String hexStr = "";
        try {
            Cipher c1 = Cipher.getInstance("DES/ECB/NoPadding");
            SecretKey key = new SecretKeySpec(Key.getBytes(), Algorithm);//生成加密解密需要的Key
            c1.init(Cipher.ENCRYPT_MODE, key);
            byte[] bytes = c1.doFinal(getByte(src));
            hexStr = bytesToHexString(bytes);
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return hexStr;
    }
    // 解密字符串
    public static String decryptMode(String hexStr) {
        String src = "";
        try {
            Cipher c1 = Cipher.getInstance("DES/ECB/NoPadding");
            SecretKey deskey = new SecretKeySpec(Key.getBytes(), Algorithm);//生成加密解密需要的Key
            c1.init(Cipher.DECRYPT_MODE , deskey);
            byte[] bytes = c1.doFinal(hexString2Bytes(hexStr));
            src = new String(bytes).trim();
        } catch (java.security.NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        } catch (javax.crypto.NoSuchPaddingException e2) {
            e2.printStackTrace();
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
        return src;
    }
    public static String bytesToHexString(byte[] digestByte) {
        byte[] rtChar = new byte[digestByte.length * 2];
        for (int i = 0; i < digestByte.length; i++) {
            byte b1 = (byte) (digestByte[i] >> 4 & 0x0f);
            byte b2 = (byte) (digestByte[i] & 0x0f);
            rtChar[i * 2] = (byte) (b1 < 10 ? b1 + 48 : b1 + 55);
            rtChar[i * 2 + 1] = (byte) (b2 < 10 ? b2 + 48 : b2 + 55);
        }
        return new String(rtChar).toLowerCase();
    }
    public static byte[] getByte(String szSrc){
        int length = szSrc.length();
        int a = length % 8;
        int b = length / 8;
        int len = 0;
        if (a == 0){
            len = b*8;
        }else{
            len = (b+1)*8;
        }
        byte[] src = new byte[len];
        byte[] bytes = szSrc.getBytes();
        for (int i = 0;i<bytes.length;i++){
            src[i] = bytes[i];
        }
        return src;
    }
    public static byte[] hexString2Bytes(String src)
    {
        int len = src.length();
        byte[] ret = new byte[len/2];
        byte[] tmp = src.getBytes();
        for(int i=0; i<len/2; ++i )
        {
            ret[i] = uniteBytes(tmp[i*2], tmp[i*2+1]);
        }
        return ret;
    }
    private static byte uniteBytes(byte src0, byte src1) {
        byte _b0 = Byte.decode("0x" + new String(new byte[]{src0})).byteValue();
        _b0 = (byte) (_b0 << 4);
        byte _b1 = Byte.decode("0x" + new String(new byte[]{src1})).byteValue();
        byte ret = (byte) (_b0 | _b1);
        return ret;
    }
    public static void main(String[] args) {
        String szSrc = "root";
        System.out.println("加密前的字符串:" + szSrc);
        String s = encryptMode(szSrc);
        System.out.println("加密后的字符串:" + s);
        String s1 = decryptMode(s);
        System.out.println("解密后的字符串:" + s1);
    }
}