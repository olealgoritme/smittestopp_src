package com.microsoft.azure.storage.core;

public final class Base64
{
  public static final String BASE_64_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
  public static final byte[] DECODE_64 = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1 };
  
  public static byte[] decode(String paramString)
  {
    if (paramString != null)
    {
      int i = paramString.length() * 3 / 4;
      if (paramString.endsWith("=="))
      {
        j = i - 2;
      }
      else
      {
        j = i;
        if (paramString.endsWith("=")) {
          j = i - 1;
        }
      }
      byte[] arrayOfByte = new byte[j];
      i = 0;
      int j = 0;
      while (i < paramString.length())
      {
        int k = DECODE_64[((byte)paramString.charAt(i))];
        int m = DECODE_64[((byte)paramString.charAt(i + 1))];
        int n = DECODE_64[((byte)paramString.charAt(i + 2))];
        int i1 = DECODE_64[((byte)paramString.charAt(i + 3))];
        if ((k >= 0) && (m >= 0) && (n != -1) && (i1 != -1))
        {
          m = (k << 18) + (m << 12) + ((n & 0xFF) << 6) + (i1 & 0xFF);
          if (n == -2)
          {
            n = j + 1;
            arrayOfByte[j] = ((byte)(byte)((m & 0xFFF000) >> 16 & 0xFF));
            j = n;
          }
          for (;;)
          {
            break;
            if (i1 == -2)
            {
              m &= 0xFFFFC0;
              n = j + 1;
              arrayOfByte[j] = ((byte)(byte)(m >> 16 & 0xFF));
              j = n + 1;
              arrayOfByte[n] = ((byte)(byte)(m >> 8 & 0xFF));
            }
            else
            {
              i1 = j + 1;
              arrayOfByte[j] = ((byte)(byte)(m >> 16 & 0xFF));
              n = i1 + 1;
              arrayOfByte[i1] = ((byte)(byte)(m >> 8 & 0xFF));
              j = n + 1;
              arrayOfByte[n] = ((byte)(byte)(m & 0xFF));
            }
          }
          i += 4;
        }
        else
        {
          throw new IllegalArgumentException("The String is not a valid Base64-encoded string.");
        }
      }
      return arrayOfByte;
    }
    throw new IllegalArgumentException("The String is not a valid Base64-encoded string.");
  }
  
  public static Byte[] decodeAsByteObjectArray(String paramString)
  {
    int i = paramString.length() * 3 / 4;
    if (paramString.endsWith("=="))
    {
      j = i - 2;
    }
    else
    {
      j = i;
      if (paramString.endsWith("=")) {
        j = i - 1;
      }
    }
    Byte[] arrayOfByte = new Byte[j];
    i = 0;
    int j = 0;
    while (i < paramString.length())
    {
      int k = DECODE_64[((byte)paramString.charAt(i))];
      int m = DECODE_64[((byte)paramString.charAt(i + 1))];
      int n = DECODE_64[((byte)paramString.charAt(i + 2))];
      int i1 = DECODE_64[((byte)paramString.charAt(i + 3))];
      if ((k >= 0) && (m >= 0) && (n != -1) && (i1 != -1))
      {
        m = (k << 18) + (m << 12) + ((n & 0xFF) << 6) + (i1 & 0xFF);
        if (n == -2)
        {
          i1 = j + 1;
          arrayOfByte[j] = Byte.valueOf((byte)((m & 0xFFF000) >> 16 & 0xFF));
          j = i1;
        }
        for (;;)
        {
          break;
          if (i1 == -2)
          {
            m &= 0xFFFFC0;
            i1 = j + 1;
            arrayOfByte[j] = Byte.valueOf((byte)(m >> 16 & 0xFF));
            j = i1 + 1;
            arrayOfByte[i1] = Byte.valueOf((byte)(m >> 8 & 0xFF));
          }
          else
          {
            n = j + 1;
            arrayOfByte[j] = Byte.valueOf((byte)(m >> 16 & 0xFF));
            i1 = n + 1;
            arrayOfByte[n] = Byte.valueOf((byte)(m >> 8 & 0xFF));
            j = i1 + 1;
            arrayOfByte[i1] = Byte.valueOf((byte)(m & 0xFF));
          }
        }
        i += 4;
      }
      else
      {
        throw new IllegalArgumentException("The String is not a valid Base64-encoded string.");
      }
    }
    return arrayOfByte;
  }
  
  public static String encode(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramArrayOfByte.length % 3;
    int j = 0;
    int k = 0;
    while (j < paramArrayOfByte.length)
    {
      if (j < paramArrayOfByte.length - i) {
        k = ((paramArrayOfByte[j] & 0xFF) << 16) + ((paramArrayOfByte[(j + 1)] & 0xFF) << 8);
      }
      for (int m = paramArrayOfByte[(j + 2)] & 0xFF;; m = (paramArrayOfByte[(j + 1)] & 0xFF) << 8)
      {
        k += m;
        break;
        if (i == 1)
        {
          k = (paramArrayOfByte[j] & 0xFF) << 16;
          break;
        }
        if (i != 2) {
          break;
        }
        k = (paramArrayOfByte[j] & 0xFF) << 16;
      }
      localStringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((byte)(k >>> 18 & 0x3F)));
      localStringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((byte)(k >>> 12 & 0x3F)));
      localStringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((byte)(k >>> 6 & 0x3F)));
      localStringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((byte)(k & 0x3F)));
      j += 3;
    }
    k = localStringBuilder.length();
    if (paramArrayOfByte.length % 3 == 1) {
      localStringBuilder.replace(k - 2, k, "==");
    } else if (paramArrayOfByte.length % 3 == 2) {
      localStringBuilder.replace(k - 1, k, "=");
    }
    return localStringBuilder.toString();
  }
  
  public static String encode(Byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramArrayOfByte.length % 3;
    int j = 0;
    int k = 0;
    while (j < paramArrayOfByte.length)
    {
      if (j < paramArrayOfByte.length - i) {
        k = ((paramArrayOfByte[j].byteValue() & 0xFF) << 16) + ((paramArrayOfByte[(j + 1)].byteValue() & 0xFF) << 8);
      }
      for (int m = paramArrayOfByte[(j + 2)].byteValue() & 0xFF;; m = (paramArrayOfByte[(j + 1)].byteValue() & 0xFF) << 8)
      {
        k += m;
        break;
        if (i == 1)
        {
          k = (paramArrayOfByte[j].byteValue() & 0xFF) << 16;
          break;
        }
        if (i != 2) {
          break;
        }
        k = (paramArrayOfByte[j].byteValue() & 0xFF) << 16;
      }
      localStringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((byte)(k >>> 18 & 0x3F)));
      localStringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((byte)(k >>> 12 & 0x3F)));
      localStringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((byte)(k >>> 6 & 0x3F)));
      localStringBuilder.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((byte)(k & 0x3F)));
      j += 3;
    }
    k = localStringBuilder.length();
    if (paramArrayOfByte.length % 3 == 1) {
      localStringBuilder.replace(k - 2, k, "==");
    } else if (paramArrayOfByte.length % 3 == 2) {
      localStringBuilder.replace(k - 1, k, "=");
    }
    return localStringBuilder.toString();
  }
  
  public static boolean validateIsBase64String(String paramString)
  {
    if ((paramString != null) && (paramString.length() % 4 == 0))
    {
      int i = 0;
      while (i < paramString.length())
      {
        int j = (byte)paramString.charAt(i);
        if (DECODE_64[j] == -2)
        {
          if (i < paramString.length() - 2) {
            return false;
          }
          if ((i == paramString.length() - 2) && (DECODE_64[((byte)paramString.charAt(i + 1))] != -2)) {
            return false;
          }
        }
        if ((j >= 0) && (DECODE_64[j] != -1)) {
          i++;
        } else {
          return false;
        }
      }
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.core.Base64
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */