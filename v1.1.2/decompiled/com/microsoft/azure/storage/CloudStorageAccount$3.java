package com.microsoft.azure.storage;

import java.util.HashMap;
import java.util.Map;

public final class CloudStorageAccount$3
  implements CloudStorageAccount.ConnectionStringFilter
{
  public CloudStorageAccount$3(String[] paramArrayOfString) {}
  
  public Map<String, String> apply(Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap(paramMap);
    int i = 0;
    paramMap = Boolean.valueOf(false);
    String[] arrayOfString = val$settingNames;
    int j = arrayOfString.length;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (localHashMap.containsKey(str))
      {
        localHashMap.remove(str);
        paramMap = Boolean.valueOf(true);
      }
      i++;
    }
    if (paramMap.booleanValue()) {
      paramMap = localHashMap;
    } else {
      paramMap = null;
    }
    return paramMap;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.CloudStorageAccount.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */