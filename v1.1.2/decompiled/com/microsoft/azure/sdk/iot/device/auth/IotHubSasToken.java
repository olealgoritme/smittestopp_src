package com.microsoft.azure.sdk.iot.device.auth;

import com.microsoft.azure.sdk.iot.device.net.IotHubUri;
import e.a.a.a.a;
import java.util.HashMap;
import java.util.Map;

public final class IotHubSasToken
{
  public static final int ExpectedNumberOfFieldParts = 2;
  public static final int ExpectedSASTokenSegments = 2;
  public static final String ExpiryTimeFieldKey = "se";
  public static final String FieldKeyValueSeparator = "=";
  public static final String FieldPairSeparator = "&";
  public static final int KeyValuePairKeyIndex = 0;
  public static final int KeyValuePairValueIndex = 1;
  public static final String ResourceURIFieldKey = "sr";
  public static final int SASTokenConstantSegmentIndex = 0;
  public static final int SASTokenFieldSegmentIndex = 1;
  public static final String SASTokenSegmentSeparator = " ";
  public static final String SharedAccessSignature = "SharedAccessSignature";
  public static final String SignatureFieldKey = "sig";
  public static final String TOKEN_FORMAT = "SharedAccessSignature sig=%s&se=%s&sr=%s";
  public long expiryTime = 0L;
  public String sasToken = null;
  public String scope = null;
  public String signature = null;
  
  public IotHubSasToken()
  {
    signature = null;
    expiryTime = 0L;
    scope = null;
    sasToken = null;
  }
  
  public IotHubSasToken(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    if (paramString3 != null)
    {
      paramString1 = IotHubUri.getResourceUri(paramString1, paramString2, paramString5);
      scope = paramString1;
      expiryTime = paramLong;
      signature = new Signature(paramString1, paramLong, paramString3).toString();
    }
    else
    {
      if (paramString4 == null) {
        break label129;
      }
      sasToken = paramString4;
      expiryTime = getExpiryTimeFromToken(paramString4).longValue();
      if (!isSasFormat()) {
        break label119;
      }
      if (isExpired(sasToken)) {
        break label109;
      }
    }
    return;
    label109:
    throw new SecurityException("Your SasToken has expired");
    label119:
    throw new IllegalArgumentException("SasToken format is invalid");
    label129:
    throw new IllegalArgumentException("deviceKey and sharedAccessToken may not both be null");
  }
  
  private String buildSasToken()
  {
    return String.format("SharedAccessSignature sig=%s&se=%s&sr=%s", new Object[] { signature, Long.valueOf(expiryTime), scope });
  }
  
  public static String buildSharedAccessToken(String paramString1, String paramString2, long paramLong)
  {
    if ((paramString1 != null) && (!paramString1.isEmpty()) && (paramString2 != null) && (!paramString2.isEmpty()))
    {
      if (paramLong >= 0L) {
        return String.format("%s %s=%s&%s=%s&%s=%d", new Object[] { "SharedAccessSignature", "sr", paramString1, "sig", paramString2, "se", Long.valueOf(paramLong) });
      }
      throw new IllegalArgumentException("expiry time must be a non-negative integer");
    }
    throw new IllegalArgumentException("neither audience nor signature can be null or empty");
  }
  
  public static Map<String, String> extractFieldValues(String paramString)
  {
    String[] arrayOfString1 = paramString.split(" ");
    boolean bool = arrayOfString1[0].trim().toUpperCase().equals("SharedAccessSignature".toUpperCase());
    if ((arrayOfString1.length == 2) && (bool))
    {
      paramString = new HashMap();
      for (String str : arrayOfString1[1].trim().split("&")) {
        if (!str.equals(""))
        {
          String[] arrayOfString2 = str.split("=");
          if (arrayOfString2.length == 2) {
            paramString.put(arrayOfString2[0], arrayOfString2[1]);
          } else {
            throw new IllegalArgumentException(a.b("SasToken format is invalid: missing a key or value tied to your field: ", str));
          }
        }
      }
      return paramString;
    }
    throw new IllegalArgumentException("Malformed signature");
  }
  
  public static Long getExpiryTimeFromToken(String paramString)
  {
    return Long.valueOf(Long.parseLong((String)extractFieldValues(paramString).get("se")));
  }
  
  public static boolean isExpired(String paramString)
  {
    long l = System.currentTimeMillis() / 1000L;
    paramString = getExpiryTimeFromToken(paramString);
    boolean bool;
    if (Long.valueOf(l).longValue() >= paramString.longValue()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean isSasFormat()
  {
    Object localObject = sasToken;
    if ((localObject != null) && (((String)localObject).startsWith("SharedAccessSignature")))
    {
      localObject = extractFieldValues(sasToken);
      if ((((Map)localObject).containsKey("se")) && (((Map)localObject).containsKey("sig")) && (((Map)localObject).containsKey("sr"))) {
        return true;
      }
    }
    return false;
  }
  
  public String getSasToken()
  {
    return sasToken;
  }
  
  public boolean isExpired()
  {
    boolean bool;
    if (System.currentTimeMillis() / 1000L >= expiryTime) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    if (sasToken != null)
    {
      if (isSasFormat()) {
        return sasToken;
      }
      throw new IllegalArgumentException("SasToken format is invalid");
    }
    if ((signature != null) && (expiryTime != 0L) && (scope != null)) {
      return buildSasToken();
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.auth.IotHubSasToken
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */