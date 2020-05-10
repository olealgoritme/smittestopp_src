package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import e.c.c.e;
import e.c.c.m;
import e.c.c.s;
import e.c.c.w.t;
import java.util.LinkedList;
import java.util.List;

public class QueryResponseParser
{
  public transient Gson gson;
  public m[] jsonItems = null;
  
  public QueryResponseParser() {}
  
  public QueryResponseParser(String paramString)
  {
    Object localObject = new e();
    l = false;
    gson = ((e)localObject).a();
    if ((paramString != null) && (!paramString.isEmpty())) {
      try
      {
        paramString = gson.a(paramString, m[].class);
        jsonItems = ((m[])t.a(m[].class).cast(paramString));
        return;
      }
      catch (s paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Malformed json:");
        ((StringBuilder)localObject).append(paramString);
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    throw new IllegalArgumentException("parameter is null or empty");
  }
  
  public List<String> getJsonItems()
  {
    LinkedList localLinkedList = new LinkedList();
    for (m localm : jsonItems) {
      localLinkedList.add(gson.a(localm));
    }
    return localLinkedList;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.serializer.QueryResponseParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */