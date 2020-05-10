package com.microsoft.azure.sdk.iot.deps.util;

public final class Base64
{
  public static final int[] BASE64D16_CONVERSION_TABLE = { 1296647489, 1666798929, 1936681831, 942944375 };
  public static final int BASE64D8_CONVERSION_TABLE = 2003259713;
  public static final int BASE64_END_LOWERCASE = 52;
  public static final int BASE64_END_NUMBER = 62;
  public static final int BASE64_END_UPPERCASE = 26;
  public static final int BASE64_GROUP_SIZE = 4;
  public static final byte BASE64_PAD = 61;
  public static final int BASE64_PLUS = 62;
  public static final int BASE64_SLASH = 63;
  public static final byte BYTE_END_LOWERCASE = 122;
  public static final byte BYTE_END_NUMBER = 57;
  public static final byte BYTE_END_UPPERCASE = 90;
  public static final int BYTE_GROUP_SIZE = 3;
  public static final byte BYTE_PLUS = 43;
  public static final byte BYTE_SLASH = 47;
  public static final byte BYTE_START_LOWERCASE = 97;
  public static final byte BYTE_START_NUMBER = 48;
  public static final byte BYTE_START_UPPERCASE = 65;
  public static final int HALF_NIBBLE = 2;
  public static final int ISOLATE_BASE64 = 63;
  public static final int ISOLATE_BYTE = 255;
  public static final int ISOLATE_LSB_BASE64 = 15;
  public static final int ISOLATE_MSB_BASE64 = 3;
  public static final int ONE_AND_HALF_NIBBLE = 6;
  public static final int ONE_BYTE = 8;
  public static final int ONE_NIBBLE = 4;
  public static final int THREE_BYTES = 24;
  public static final int TWO_BYTES = 16;
  
  public static int base64EstimatedLength(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 0) {
      return 0;
    }
    int i = paramArrayOfByte.length / 4 * 3;
    int j = i;
    if (paramArrayOfByte[(paramArrayOfByte.length - 1)] == 61)
    {
      j = i;
      if (paramArrayOfByte[(paramArrayOfByte.length - 2)] == 61) {
        j = i - 1;
      }
      j--;
    }
    return j;
  }
  
  public static byte base64ToByte(byte paramByte)
  {
    if (paramByte < 26) {
      paramByte += 65;
    }
    for (;;)
    {
      return (byte)paramByte;
      if (paramByte < 52)
      {
        paramByte = paramByte - 26 + 97;
      }
      else
      {
        if (paramByte >= 62) {
          break;
        }
        paramByte = paramByte - 52 + 48;
      }
    }
    if (paramByte == 62) {
      return 43;
    }
    return 47;
  }
  
  public static byte base64d16ToByte(byte paramByte)
  {
    return extractBase64FromInteger(BASE64D16_CONVERSION_TABLE[(paramByte >> 2)], paramByte & 0x3);
  }
  
  public static byte base64d8ToByte(byte paramByte)
  {
    return extractBase64FromInteger(2003259713, paramByte);
  }
  
  public static byte byteToBase64(byte paramByte)
  {
    if ((paramByte >= 65) && (paramByte <= 90)) {
      paramByte -= 65;
    }
    for (;;)
    {
      return (byte)paramByte;
      if ((paramByte >= 97) && (paramByte <= 122))
      {
        paramByte = paramByte - 97 + 26;
      }
      else
      {
        if ((paramByte < 48) || (paramByte > 57)) {
          break;
        }
        paramByte = paramByte - 48 + 52;
      }
    }
    if (paramByte == 43) {
      return 62;
    }
    if (paramByte == 47) {
      return 63;
    }
    throw new IllegalArgumentException("provided byte value out of base64 range");
  }
  
  public static byte[] decodeBase64Local(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      int i = paramArrayOfByte.length;
      int j = 0;
      if (i == 0) {
        return new byte[0];
      }
      if (paramArrayOfByte.length % 4 == 0)
      {
        int k = numberOfValidBase64BytesWithoutPad(paramArrayOfByte);
        byte[] arrayOfByte = new byte[base64EstimatedLength(paramArrayOfByte)];
        i = 0;
        int n;
        int i2;
        while (k >= 4)
        {
          m = j + 1;
          n = byteToBase64(paramArrayOfByte[j]);
          i1 = m + 1;
          m = byteToBase64(paramArrayOfByte[m]);
          j = i1 + 1;
          i2 = byteToBase64(paramArrayOfByte[i1]);
          i1 = byteToBase64(paramArrayOfByte[j]);
          int i3 = i + 1;
          arrayOfByte[i] = ((byte)(byte)(n << 2 | m >> 4));
          n = i3 + 1;
          arrayOfByte[i3] = ((byte)(byte)(m << 4 | i2 >> 2));
          i = n + 1;
          arrayOfByte[n] = ((byte)(byte)(i2 << 6 | i1));
          k -= 4;
          j++;
        }
        int m = j;
        int i1 = i;
        if (k == 3)
        {
          i1 = j + 1;
          j = byteToBase64(paramArrayOfByte[j]);
          m = i1 + 1;
          i2 = byteToBase64(paramArrayOfByte[i1]);
          n = byteToBase64(paramArrayOfByte[m]);
          i1 = i + 1;
          arrayOfByte[i] = ((byte)(byte)(j << 2 | i2 >> 4));
          arrayOfByte[i1] = ((byte)(byte)(i2 << 4 | n >> 2));
        }
        if (k == 2)
        {
          i = byteToBase64(paramArrayOfByte[m]);
          arrayOfByte[i1] = ((byte)(byte)(byteToBase64(paramArrayOfByte[(m + 1)]) >> 4 | i << 2));
        }
        return arrayOfByte;
      }
      throw new IllegalArgumentException("invalid base64Values length");
    }
    throw new IllegalArgumentException("null or empty base64Values");
  }
  
  public static byte[] encodeBase64Internal(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[((paramArrayOfByte.length - 1) / 3 + 1) * 4];
    int i = 0;
    int j = 0;
    int m;
    int n;
    while (paramArrayOfByte.length - i >= 3)
    {
      k = j + 1;
      arrayOfByte[j] = base64ToByte((byte)(paramArrayOfByte[i] >> 2 & 0x3F));
      j = k + 1;
      m = paramArrayOfByte[i];
      n = i + 1;
      arrayOfByte[k] = base64ToByte((byte)(m << 4 & 0x3F | paramArrayOfByte[n] >> 4 & 0xF));
      k = j + 1;
      m = paramArrayOfByte[n];
      n = i + 2;
      arrayOfByte[j] = base64ToByte((byte)(m << 2 & 0x3F | paramArrayOfByte[n] >> 6 & 0x3));
      j = k + 1;
      arrayOfByte[k] = base64ToByte((byte)(paramArrayOfByte[n] & 0x3F));
      i += 3;
    }
    int k = j;
    if (paramArrayOfByte.length - i == 2)
    {
      k = j + 1;
      arrayOfByte[j] = base64ToByte((byte)(paramArrayOfByte[i] >> 2 & 0x3F));
      j = k + 1;
      m = paramArrayOfByte[i];
      n = i + 1;
      arrayOfByte[k] = base64ToByte((byte)(m << 4 & 0x3F | paramArrayOfByte[n] >> 4 & 0xF));
      k = j + 1;
      arrayOfByte[j] = base64d16ToByte((byte)(paramArrayOfByte[n] & 0xF));
      arrayOfByte[k] = ((byte)61);
    }
    if (paramArrayOfByte.length - i == 1)
    {
      j = k + 1;
      arrayOfByte[k] = base64ToByte((byte)(paramArrayOfByte[i] >> 2 & 0x3F));
      k = j + 1;
      arrayOfByte[j] = base64d8ToByte((byte)(paramArrayOfByte[i] & 0x3));
      arrayOfByte[k] = ((byte)61);
      arrayOfByte[(k + 1)] = ((byte)61);
    }
    return arrayOfByte;
  }
  
  public static byte[] encodeBase64Local(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return new byte[0];
      }
      return encodeBase64Internal(paramArrayOfByte);
    }
    throw new IllegalArgumentException("null or empty dataValues");
  }
  
  public static String encodeBase64StringLocal(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return new String();
      }
      return new String(encodeBase64Internal(paramArrayOfByte));
    }
    throw new IllegalArgumentException("null or empty dataValues");
  }
  
  public static byte extractBase64FromInteger(int paramInt1, int paramInt2)
  {
    return (byte)(paramInt1 >> (paramInt2 << 3) & 0xFF);
  }
  
  public static int numberOfValidBase64BytesWithoutPad(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = i;
    if (paramArrayOfByte[(i - 1)] == 61) {
      j = i - 1;
    }
    i = j;
    if (paramArrayOfByte[(j - 1)] == 61) {
      i = j - 1;
    }
    return i;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.util.Base64
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */