package com.microsoft.azure.storage;

import java.util.HashMap;

public abstract class Permissions<T extends SharedAccessPolicy>
{
  public HashMap<String, T> sharedAccessPolicies = new HashMap();
  
  public HashMap<String, T> getSharedAccessPolicies()
  {
    return sharedAccessPolicies;
  }
  
  public void setSharedAccessPolicies(HashMap<String, T> paramHashMap)
  {
    sharedAccessPolicies = paramHashMap;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.Permissions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */