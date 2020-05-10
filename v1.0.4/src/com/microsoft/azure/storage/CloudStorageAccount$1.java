package com.microsoft.azure.storage;

import java.util.HashMap;
import java.util.Map;

public final class CloudStorageAccount$1
  implements CloudStorageAccount.ConnectionStringFilter
{
  public CloudStorageAccount$1(String[] paramArrayOfString) {}
  
  public Map<String, String> apply(Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap(paramMap);
    String[] arrayOfString = val$settingNames;
    int i = arrayOfString.length;
    int j = 0;
    while (j < i)
    {
      paramMap = arrayOfString[j];
      if (localHashMap.containsKey(paramMap))
      {
        localHashMap.remove(paramMap);
        j++;
      }
      else
      {
        return null;
      }
    }
    return localHashMap;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.CloudStorageAccount.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */