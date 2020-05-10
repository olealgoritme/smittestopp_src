package com.microsoft.azure.sdk.iot.device.auth;

public final class Signature
{
  public final String sig;
  
  public Signature(String paramString1, long paramLong, String paramString2)
  {
    sig = SignatureHelper.encodeSignatureWebSafe(SignatureHelper.encodeSignatureUtf8(SignatureHelper.encodeSignatureBase64(SignatureHelper.encryptSignatureHmacSha256(SignatureHelper.buildRawSignature(paramString1, paramLong), SignatureHelper.decodeDeviceKeyBase64(paramString2)))));
  }
  
  public String toString()
  {
    return sig;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.auth.Signature
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */