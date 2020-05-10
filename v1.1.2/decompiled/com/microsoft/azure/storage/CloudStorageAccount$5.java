package com.microsoft.azure.storage;

import java.util.HashMap;
import java.util.Map;

public final class CloudStorageAccount$5
  implements CloudStorageAccount.ConnectionStringFilter
{
  public CloudStorageAccount$5(CloudStorageAccount.ConnectionStringFilter[] paramArrayOfConnectionStringFilter) {}
  
  public Map<String, String> apply(Map<String, String> paramMap)
  {
    paramMap = new HashMap(paramMap);
    for (CloudStorageAccount.ConnectionStringFilter localConnectionStringFilter : val$filters)
    {
      if (paramMap == null) {
        break;
      }
      paramMap = localConnectionStringFilter.apply(paramMap);
    }
    return paramMap;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.CloudStorageAccount.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */