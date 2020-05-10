package com.microsoft.azure.sdk.iot.device.auth;

import com.microsoft.azure.sdk.iot.deps.util.Base64;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class SignatureHelper
{
  public static final String RAW_SIGNATURE_FORMAT = "%s\n%s";
  public static final Charset SIGNATURE_CHARSET = StandardCharsets.UTF_8;
  
  public static byte[] buildRawSignature(String paramString, long paramLong)
  {
    return String.format("%s\n%s", new Object[] { paramString, Long.valueOf(paramLong) }).getBytes(SIGNATURE_CHARSET);
  }
  
  public static byte[] decodeDeviceKeyBase64(String paramString)
  {
    return Base64.decodeBase64Local(paramString.getBytes());
  }
  
  public static byte[] encodeSignatureBase64(byte[] paramArrayOfByte)
  {
    return Base64.encodeBase64Local(paramArrayOfByte);
  }
  
  public static String encodeSignatureUtf8(byte[] paramArrayOfByte)
  {
    return new String(paramArrayOfByte, SIGNATURE_CHARSET);
  }
  
  public static String encodeSignatureWebSafe(String paramString)
  {
    try
    {
      paramString = URLEncoder.encode(paramString, SIGNATURE_CHARSET.name());
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalStateException(paramString);
    }
  }
  
  public static byte[] encryptSignatureHmacSha256(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte2 = new SecretKeySpec(paramArrayOfByte2, "HmacSHA256");
    try
    {
      Mac localMac = Mac.getInstance("HmacSHA256");
      localMac.init(paramArrayOfByte2);
      paramArrayOfByte1 = localMac.doFinal(paramArrayOfByte1);
    }
    catch (NoSuchAlgorithmException|InvalidKeyException paramArrayOfByte1)
    {
      paramArrayOfByte1 = null;
    }
    return paramArrayOfByte1;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.auth.SignatureHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */