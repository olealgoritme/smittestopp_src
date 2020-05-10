package com.microsoft.identity.common.adal.internal.tokensharing;

import android.util.Pair;
import com.microsoft.identity.common.internal.cache.ADALTokenCacheItem;
import com.microsoft.identity.common.internal.cache.ITokenCacheItem;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.migration.AdalMigrationAdapter;
import com.microsoft.identity.common.internal.migration.TokenCacheItemMigrationAdapter;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftRefreshToken;
import java.util.concurrent.Callable;

public class TokenShareUtility$1
  implements Callable<Pair<MicrosoftAccount, MicrosoftRefreshToken>>
{
  public TokenShareUtility$1(TokenShareUtility paramTokenShareUtility, String paramString) {}
  
  public Pair<MicrosoftAccount, MicrosoftRefreshToken> call()
  {
    Object localObject = SSOStateSerializer.deserialize(val$ssoStateSerializerBlob);
    ((ADALTokenCacheItem)localObject).setClientId(TokenShareUtility.access$000(this$0));
    ((ADALTokenCacheItem)localObject).setResource(null);
    if (!AdalMigrationAdapter.loadCloudDiscoveryMetadata())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TokenShareUtility.access$100());
      ((StringBuilder)localObject).append("saveOrgIdFamilyRefreshToken");
      Logger.warn(((StringBuilder)localObject).toString(), "Failed to load cloud metadata, aborting.");
      return null;
    }
    return TokenCacheItemMigrationAdapter.renewToken(TokenShareUtility.access$200(this$0), (ITokenCacheItem)localObject);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.adal.internal.tokensharing.TokenShareUtility.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */