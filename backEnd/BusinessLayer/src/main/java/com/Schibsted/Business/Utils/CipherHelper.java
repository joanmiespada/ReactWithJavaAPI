package com.Schibsted.Business.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by joanmi on 15/6/17.
 */
public class CipherHelper {

    private static String convertByteArrayToHexString(byte[] arrayBytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayBytes.length; i++) {
            stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return stringBuffer.toString();
    }


    public static String Encript(String origen) throws Exception
    {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hashedBytes = digest.digest(origen.getBytes("UTF-8"));

            return convertByteArrayToHexString(hashedBytes);

        }catch (NoSuchAlgorithmException ex)
        {
            throw new Exception("no cipher");
        }
    }
}
