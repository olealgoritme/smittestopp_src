package com.microsoft.azure.storage;

import java.util.ArrayList;
import java.util.List;

public final class CorsProperties
{
  public List<CorsRule> corsRules = new ArrayList();
  
  public List<CorsRule> getCorsRules()
  {
    return corsRules;
  }
  
  public void setCorsRules(List<CorsRule> paramList)
  {
    corsRules = paramList;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.CorsProperties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */