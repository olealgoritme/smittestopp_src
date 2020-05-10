package com.microsoft.azure.storage;

import java.util.HashMap;
import java.util.Map;

public final class CloudStorageAccount$7
  implements CloudStorageAccount.ConnectionStringFilter
{
  public CloudStorageAccount$7(CloudStorageAccount.ConnectionStringFilter paramConnectionStringFilter) {}
  
  public Map<String, String> apply(Map<String, String> paramMap)
  {
    paramMap = new HashMap(paramMap);
    paramMap = val$filter.apply(paramMap);
    if ((paramMap != null) && (paramMap.isEmpty())) {
      return paramMap;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.CloudStorageAccount.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */