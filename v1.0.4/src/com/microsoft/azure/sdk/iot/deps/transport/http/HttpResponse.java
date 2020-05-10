package com.microsoft.azure.sdk.iot.deps.transport.http;

import e.a.a.a.a;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HttpResponse
{
  public final byte[] body;
  public final byte[] errorReason;
  public final Map<String, String> headerFields;
  public final int status;
  
  public HttpResponse()
  {
    status = 0;
    body = null;
    headerFields = null;
    errorReason = null;
  }
  
  public HttpResponse(int paramInt, byte[] paramArrayOfByte1, Map<String, List<String>> paramMap, byte[] paramArrayOfByte2)
  {
    status = paramInt;
    body = Arrays.copyOf(paramArrayOfByte1, paramArrayOfByte1.length);
    errorReason = paramArrayOfByte2;
    headerFields = new HashMap();
    paramArrayOfByte1 = paramMap.entrySet().iterator();
    while (paramArrayOfByte1.hasNext())
    {
      paramMap = (Map.Entry)paramArrayOfByte1.next();
      paramArrayOfByte2 = (String)paramMap.getKey();
      if (paramArrayOfByte2 != null)
      {
        paramArrayOfByte2 = canonicalizeFieldName(paramArrayOfByte2);
        paramMap = flattenValuesList((List)paramMap.getValue());
        headerFields.put(paramArrayOfByte2, paramMap);
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
    Iterator localIterator = paramList.iterator();
    for (paramList = ""; localIterator.hasNext(); paramList = a.a(paramList, (String)localIterator.next(), ",")) {}
    return paramList.substring(0, Math.max(0, paramList.length() - 1));
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
    throw new IllegalArgumentException(String.format("Could not find a value associated with the header field name '%s'.\n", new Object[] { paramString }));
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
  
  public boolean isFieldAvailable(String paramString)
  {
    paramString = canonicalizeFieldName(paramString);
    return headerFields.containsKey(paramString);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.transport.http.HttpResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */