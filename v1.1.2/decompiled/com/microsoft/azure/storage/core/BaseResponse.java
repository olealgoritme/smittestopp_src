package com.microsoft.azure.storage.core;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BaseResponse
{
  public static String getContentMD5(HttpURLConnection paramHttpURLConnection)
  {
    return paramHttpURLConnection.getHeaderField("Content-MD5");
  }
  
  public static String getDate(HttpURLConnection paramHttpURLConnection)
  {
    String str1 = paramHttpURLConnection.getHeaderField("Date");
    String str2 = str1;
    if (str1 == null) {
      str2 = paramHttpURLConnection.getHeaderField("x-ms-date");
    }
    return str2;
  }
  
  public static String getErrorCode(HttpURLConnection paramHttpURLConnection)
  {
    return paramHttpURLConnection.getHeaderField("x-ms-error-code");
  }
  
  public static String getEtag(HttpURLConnection paramHttpURLConnection)
  {
    return paramHttpURLConnection.getHeaderField("ETag");
  }
  
  public static HashMap<String, String> getMetadata(HttpURLConnection paramHttpURLConnection)
  {
    return getValuesByHeaderPrefix(paramHttpURLConnection, "x-ms-meta-");
  }
  
  public static String getRequestId(HttpURLConnection paramHttpURLConnection)
  {
    return paramHttpURLConnection.getHeaderField("x-ms-request-id");
  }
  
  public static HashMap<String, String> getValuesByHeaderPrefix(HttpURLConnection paramHttpURLConnection, String paramString)
  {
    HashMap localHashMap = new HashMap();
    paramHttpURLConnection = paramHttpURLConnection.getHeaderFields();
    int i = paramString.length();
    paramHttpURLConnection = paramHttpURLConnection.entrySet().iterator();
    while (paramHttpURLConnection.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHttpURLConnection.next();
      if ((localEntry.getKey() != null) && (((String)localEntry.getKey()).startsWith(paramString)))
      {
        List localList = (List)localEntry.getValue();
        localHashMap.put(((String)localEntry.getKey()).substring(i), localList.get(0));
      }
    }
    return localHashMap;
  }
  
  public static boolean isServerRequestEncrypted(HttpURLConnection paramHttpURLConnection)
  {
    return "true".equals(paramHttpURLConnection.getHeaderField("x-ms-request-server-encrypted"));
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.core.BaseResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */