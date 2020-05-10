package com.microsoft.azure.storage;

import java.util.HashMap;
import java.util.Map;

public final class CloudStorageAccount$6
  implements CloudStorageAccount.ConnectionStringFilter
{
  public CloudStorageAccount$6(CloudStorageAccount.ConnectionStringFilter[] paramArrayOfConnectionStringFilter) {}
  
  public Map<String, String> apply(Map<String, String> paramMap)
  {
    CloudStorageAccount.ConnectionStringFilter[] arrayOfConnectionStringFilter = val$filters;
    int i = arrayOfConnectionStringFilter.length;
    int j = 0;
    Object localObject2;
    for (Object localObject1 = null; j < i; localObject1 = localObject2)
    {
      Map localMap = arrayOfConnectionStringFilter[j].apply(new HashMap(paramMap));
      localObject2 = localObject1;
      if (localMap != null) {
        if (localObject1 == null) {
          localObject2 = localMap;
        } else {
          return null;
        }
      }
      j++;
    }
    return (Map<String, String>)localObject1;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.CloudStorageAccount.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */