package com.microsoft.identity.common.internal.migration;

import com.microsoft.identity.common.internal.cache.ADALTokenCacheItem;
import com.microsoft.identity.common.internal.cache.ITokenCacheItem;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public final class TokenCacheItemMigrationAdapter$1
  implements Runnable
{
  public TokenCacheItemMigrationAdapter$1(List paramList1, int paramInt, Map paramMap, List paramList2, CountDownLatch paramCountDownLatch) {}
  
  public void run()
  {
    Object localObject = (ADALTokenCacheItem)val$filteredTokens.get(val$subIndex);
    localObject = TokenCacheItemMigrationAdapter.renewToken((String)val$redirects.get(((ADALTokenCacheItem)localObject).getClientId()), (ITokenCacheItem)localObject);
    if (localObject != null) {
      val$result.add(localObject);
    }
    val$latch.countDown();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.migration.TokenCacheItemMigrationAdapter.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */