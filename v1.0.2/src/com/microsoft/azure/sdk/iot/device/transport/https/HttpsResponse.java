package com.microsoft.azure.sdk.iot.device.transport.https;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HttpsResponse
{
  public final byte[] body;
  public final byte[] errorReason;
  public final Map<String, String> headerFields;
  public final int status;
  
  public HttpsResponse()
  {
    status = 0;
    body = null;
    headerFields = null;
    errorReason = null;
  }
  
  public HttpsResponse(int paramInt, byte[] paramArrayOfByte1, Map<String, List<String>> paramMap, byte[] paramArrayOfByte2)
  {
    status = paramInt;
    body = Arrays.copyOf(paramArrayOfByte1, paramArrayOfByte1.length);
    errorReason = paramArrayOfByte2;
    headerFields = new HashMap();
    paramArrayOfByte1 = paramMap.entrySet().iterator();
    while (paramArrayOfByte1.hasNext())
    {
      paramArrayOfByte2 = (Map.Entry)paramArrayOfByte1.next();
      paramMap = (String)paramArrayOfByte2.getKey();
      if (paramMap != null)
      {
        paramMap = canonicalizeFieldName(paramMap);
        paramArrayOfByte2 = flattenValuesList((List)paramArrayOfByte2.getValue());
        headerFields.put(paramMap, paramArrayOfByte2);
      }
    }
  }
  
  public static String canonicalizeFieldName(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString.toLowerCase();
    }
    return str;
  }
  
  public static String flattenValuesList(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localStringBuilder.append((String)paramList.next());
      localStringBuilder.append(",");
    }
    return localStringBuilder.substring(0, Math.max(0, localStringBuilder.length() - 1));
  }
  
  public byte[] getBody()
  {
    byte[] arrayOfByte = body;
    return Arrays.copyOf(arrayOfByte, arrayOfByte.length);
  }
  
  public byte[] getErrorReason()
  {
    return errorReason;
  }
  
  public String getHeaderField(String paramString)
  {
    String str = canonicalizeFieldName(paramString);
    str = (String)headerFields.get(str);
    if (str != null) {
      return str;
    }
    throw new IllegalArgumentException(String.format("Could not find a value associated with the header field name '%s'.%n", new Object[] { paramString }));
  }
  
  public Map<String, String> getHeaderFields()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = headerFields.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    return localHashMap;
  }
  
  public int getStatus()
  {
    return status;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.https.HttpsResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */