package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import e.c.c.e;
import e.c.c.v.a;
import e.c.c.v.c;

public class QueryRequestParser
{
  public static final String QUERY_TAG = "query";
  @a(deserialize=false, serialize=true)
  @c("query")
  public String query = null;
  
  public QueryRequestParser() {}
  
  public QueryRequestParser(String paramString)
  {
    ParserUtility.validateQuery(paramString);
    query = paramString;
  }
  
  public String toJson()
  {
    e locale = new e();
    l = false;
    return locale.a().a(this);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.serializer.QueryRequestParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */