package com.microsoft.azure.storage;

import java.util.HashMap;
import java.util.Map;

public final class CloudStorageAccount$2
  implements CloudStorageAccount.ConnectionStringFilter
{
  public CloudStorageAccount$2(String[] paramArrayOfString) {}
  
  public Map<String, String> apply(Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap(paramMap);
    for (paramMap : val$settingNames) {
      if (localHashMap.containsKey(paramMap)) {
        localHashMap.remove(paramMap);
      }
    }
    return localHashMap;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.CloudStorageAccount.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */