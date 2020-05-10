package com.microsoft.appcenter.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils
{
  public static final char[] HEXADECIMAL_OUTPUT = "0123456789abcdef".toCharArray();
  
  public static String encodeHex(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[paramArrayOfByte.length * 2];
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      int k = i * 2;
      char[] arrayOfChar2 = HEXADECIMAL_OUTPUT;
      arrayOfChar1[k] = ((char)arrayOfChar2[(j >>> 4)]);
      arrayOfChar1[(k + 1)] = ((char)arrayOfChar2[(j & 0xF)]);
    }
    return new String(arrayOfChar1);
  }
  
  public static String sha256(String paramString)
  {
    return sha256(paramString, "UTF-8");
  }
  
  public static String sha256(String paramString1, String paramString2)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      localMessageDigest.update(paramString1.getBytes(paramString2));
      paramString1 = encodeHex(localMessageDigest.digest());
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1) {}catch (NoSuchAlgorithmException paramString1) {}
    throw new RuntimeException(paramString1);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.utils.HashUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */