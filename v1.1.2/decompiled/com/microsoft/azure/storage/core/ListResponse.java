package com.microsoft.azure.storage.core;

import java.util.ArrayList;

public class ListResponse<T>
{
  public static final String ENUMERATION_RESULTS = "EnumerationResults";
  public String marker;
  public Integer maxResults;
  public String nextMarker;
  public String prefix;
  public ArrayList<T> results = new ArrayList();
  
  public String getMarker()
  {
    return marker;
  }
  
  public Integer getMaxResults()
  {
    return maxResults;
  }
  
  public String getNextMarker()
  {
    return nextMarker;
  }
  
  public String getPrefix()
  {
    return prefix;
  }
  
  public ArrayList<T> getResults()
  {
    return results;
  }
  
  public void setMarker(String paramString)
  {
    marker = paramString;
  }
  
  public void setMaxResults(Integer paramInteger)
  {
    maxResults = paramInteger;
  }
  
  public void setNextMarker(String paramString)
  {
    nextMarker = paramString;
  }
  
  public void setPrefix(String paramString)
  {
    prefix = paramString;
  }
  
  public void setResults(ArrayList<T> paramArrayList)
  {
    results = paramArrayList;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.core.ListResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */