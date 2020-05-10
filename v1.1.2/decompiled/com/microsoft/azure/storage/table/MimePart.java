package com.microsoft.azure.storage.table;

import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class MimePart
{
  public HashMap<String, String> headers = new HashMap();
  public int httpStatusCode = -1;
  public String httpStatusMessage;
  public TableOperationType op;
  public String payload;
  public URI requestIdentity;
  
  public static void appendHeader(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("Content-Type: application/http\r\n");
    paramStringBuilder.append("Content-Transfer-Encoding: binary\r\n\r\n");
  }
  
  public static String getHttpVerbForOperation(TableOperationType paramTableOperationType)
  {
    if (paramTableOperationType == TableOperationType.INSERT) {
      return "POST";
    }
    if (paramTableOperationType == TableOperationType.DELETE) {
      return "DELETE";
    }
    if ((paramTableOperationType != TableOperationType.MERGE) && (paramTableOperationType != TableOperationType.INSERT_OR_MERGE))
    {
      if ((paramTableOperationType != TableOperationType.REPLACE) && (paramTableOperationType != TableOperationType.INSERT_OR_REPLACE))
      {
        if (paramTableOperationType == TableOperationType.RETRIEVE) {
          return "GET";
        }
        throw new IllegalArgumentException("Unknown table operation.");
      }
      return "PUT";
    }
    return "MERGE";
  }
  
  public String toRequestString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    appendHeader(localStringBuilder);
    localStringBuilder.append(String.format("%s %s HTTP/1.1\r\n", new Object[] { getHttpVerbForOperation(op), requestIdentity.toString() }));
    Object localObject = headers.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      localStringBuilder.append(String.format("%s: %s\r\n", new Object[] { localEntry.getKey(), localEntry.getValue() }));
    }
    localStringBuilder.append("\r\n");
    localObject = payload;
    if (localObject != null) {
      localStringBuilder.append((String)localObject);
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.table.MimePart
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */