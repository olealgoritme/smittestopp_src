package com.microsoft.azure.storage.core;

public class ListingContext
{
  public String marker;
  public Integer maxResults;
  public String prefix;
  
  public ListingContext(String paramString, Integer paramInteger)
  {
    setPrefix(paramString);
    setMaxResults(paramInteger);
    setMarker(null);
  }
  
  public final String getMarker()
  {
    return marker;
  }
  
  public final Integer getMaxResults()
  {
    return maxResults;
  }
  
  public final String getPrefix()
  {
    return prefix;
  }
  
  public final void setMarker(String paramString)
  {
    marker = paramString;
  }
  
  public final void setMaxResults(Integer paramInteger)
  {
    if (paramInteger != null) {
      Utility.assertGreaterThanOrEqual("maxResults", paramInteger.intValue(), 1L);
    }
    maxResults = paramInteger;
  }
  
  public final void setPrefix(String paramString)
  {
    prefix = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.core.ListingContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */