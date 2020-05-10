package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import e.c.c.s;
import e.c.c.v.a;
import e.c.c.v.c;
import e.c.c.w.t;
import java.util.Map;

public class ConfigurationMetricsParser
{
  public static final String QUERIES_NAME = "queries";
  public static final String RESULTS_NAME = "results";
  public static transient Gson gson = new Gson();
  @a(deserialize=true, serialize=true)
  @c("queries")
  public Map<String, String> queries;
  @a(deserialize=true, serialize=true)
  @c("results")
  public Map<String, Long> results;
  
  public ConfigurationMetricsParser() {}
  
  public ConfigurationMetricsParser(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      try
      {
        paramString = gson.a(paramString, ConfigurationMetricsParser.class);
        paramString = (ConfigurationMetricsParser)t.a(ConfigurationMetricsParser.class).cast(paramString);
        results = results;
        queries = queries;
        return;
      }
      catch (s paramString)
      {
        throw new IllegalArgumentException("The provided json could not be parsed");
      }
    }
    throw new IllegalArgumentException("The provided json cannot be null or empty");
  }
  
  public Map<String, String> getQueries()
  {
    return queries;
  }
  
  public Map<String, Long> getResults()
  {
    return results;
  }
  
  public void setQueries(Map<String, String> paramMap)
  {
    queries = paramMap;
  }
  
  public void setResults(Map<String, Long> paramMap)
  {
    results = paramMap;
  }
  
  public String toJson()
  {
    return gson.a(this);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.serializer.ConfigurationMetricsParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */