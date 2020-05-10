package com.microsoft.azure.sdk.iot.device.net;

import com.microsoft.azure.sdk.iot.device.transport.TransportUtils;
import e.a.a.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class IotHubUri
{
  public static final String API_VERSION;
  public static final Charset IOTHUB_URL_ENCODING_CHARSET = StandardCharsets.UTF_8;
  public static final String PATH_FORMAT = "/devices/%s%s";
  public static final String PATH_FORMAT_WITH_MODULEID = "/devices/%s/modules/%s/%s";
  public String hostname;
  public String path;
  public String uri;
  
  static
  {
    StringBuilder localStringBuilder = a.a("api-version=");
    localStringBuilder.append(TransportUtils.IOTHUB_API_VERSION);
    API_VERSION = localStringBuilder.toString();
  }
  
  public IotHubUri() {}
  
  public IotHubUri(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this(paramString1, paramString2, paramString3, null, paramString4);
  }
  
  public IotHubUri(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap, String paramString4)
  {
    hostname = paramString1;
    if ((paramString4 != null) && (!paramString4.isEmpty())) {
      paramString1 = String.format("/devices/%s/modules/%s/%s", new Object[] { paramString2, paramString4, paramString3 });
    } else {
      paramString1 = String.format("/devices/%s%s", new Object[] { paramString2, paramString3 });
    }
    path = urlEncodePath(paramString1);
    paramString1 = new StringBuilder(hostname);
    paramString1.append(path);
    paramString1.append("?");
    paramString1.append(API_VERSION);
    if (paramMap != null)
    {
      paramString2 = paramMap.entrySet().iterator();
      while (paramString2.hasNext())
      {
        paramString3 = (Map.Entry)paramString2.next();
        paramString1.append("&");
        appendQueryParam(paramString1, (String)paramString3.getKey(), (String)paramString3.getValue());
      }
    }
    uri = paramString1.toString();
  }
  
  public static void appendQueryParam(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    try
    {
      paramString1 = URLEncoder.encode(paramString1, IOTHUB_URL_ENCODING_CHARSET.name());
      paramString2 = URLEncoder.encode(paramString2, IOTHUB_URL_ENCODING_CHARSET.name());
      paramStringBuilder.append(paramString1);
      paramStringBuilder.append("=");
      paramStringBuilder.append(paramString2);
      return;
    }
    catch (UnsupportedEncodingException paramStringBuilder)
    {
      throw new IllegalStateException(paramStringBuilder);
    }
  }
  
  public static String getApiVersionString()
  {
    return API_VERSION;
  }
  
  public static String getResourceUri(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new IotHubUri(paramString1, paramString2, "", paramString3);
    paramString2 = new StringBuilder();
    paramString2.append(paramString1.getHostname());
    paramString2.append(paramString1.getPath());
    return paramString2.toString();
  }
  
  public static String urlEncodePath(String paramString)
  {
    String[] arrayOfString = paramString.split("/");
    paramString = new StringBuilder();
    try
    {
      int i = arrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        String str = arrayOfString[j];
        if (str.length() > 0)
        {
          str = URLEncoder.encode(str, IOTHUB_URL_ENCODING_CHARSET.name());
          paramString.append("/");
          paramString.append(str);
        }
      }
      return paramString.toString();
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new IllegalStateException(paramString);
    }
  }
  
  public String getHostname()
  {
    return hostname;
  }
  
  public String getPath()
  {
    return path;
  }
  
  public String toString()
  {
    return uri;
  }
  
  public String toStringWithoutApiVersion()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(hostname);
    localStringBuilder.append(path);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.net.IotHubUri
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */