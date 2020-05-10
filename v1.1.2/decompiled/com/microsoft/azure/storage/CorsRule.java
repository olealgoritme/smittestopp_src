package com.microsoft.azure.storage;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class CorsRule
{
  public List<String> allowedHeaders = new ArrayList();
  public EnumSet<CorsHttpMethods> allowedMethods = EnumSet.noneOf(CorsHttpMethods.class);
  public List<String> allowedOrigins = new ArrayList();
  public List<String> exposedHeaders = new ArrayList();
  public int maxAgeInSeconds = 0;
  
  public List<String> getAllowedHeaders()
  {
    return allowedHeaders;
  }
  
  public EnumSet<CorsHttpMethods> getAllowedMethods()
  {
    return allowedMethods;
  }
  
  public List<String> getAllowedOrigins()
  {
    return allowedOrigins;
  }
  
  public List<String> getExposedHeaders()
  {
    return exposedHeaders;
  }
  
  public int getMaxAgeInSeconds()
  {
    return maxAgeInSeconds;
  }
  
  public void setAllowedHeaders(List<String> paramList)
  {
    allowedHeaders = paramList;
  }
  
  public void setAllowedMethods(EnumSet<CorsHttpMethods> paramEnumSet)
  {
    allowedMethods = paramEnumSet;
  }
  
  public void setAllowedOrigins(List<String> paramList)
  {
    allowedOrigins = paramList;
  }
  
  public void setExposedHeaders(List<String> paramList)
  {
    exposedHeaders = paramList;
  }
  
  public void setMaxAgeInSeconds(int paramInt)
  {
    maxAgeInSeconds = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.CorsRule
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */