package com.microsoft.identity.common.adal.internal.tokensharing;

import android.net.Uri;
import android.util.Pair;
import com.microsoft.identity.common.internal.cache.ITokenCacheItem;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.migration.AdalMigrationAdapter;
import com.microsoft.identity.common.internal.migration.TokenCacheItemMigrationAdapter;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftRefreshToken;
import java.util.concurrent.Callable;

public class TokenShareUtility$2
  implements Callable<Pair<MicrosoftAccount, MicrosoftRefreshToken>>
{
  public TokenShareUtility$2(TokenShareUtility paramTokenShareUtility, String paramString) {}
  
  public Pair<MicrosoftAccount, MicrosoftRefreshToken> call()
  {
    Object localObject = Uri.parse(TokenShareUtility.access$300(this$0)).getPath();
    if (localObject != null) {
      localObject = TokenShareUtility.access$300(this$0).replace((CharSequence)localObject, "/consumers");
    } else {
      localObject = TokenShareUtility.access$300(this$0);
    }
    localObject = TokenShareUtility.access$400(this$0, val$refreshToken, (String)localObject);
    if (!AdalMigrationAdapter.loadCloudDiscoveryMetadata())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(TokenShareUtility.access$100());
      ((StringBuilder)localObject).append("saveMsaFamilyRefreshToken");
      Logger.warn(((StringBuilder)localObject).toString(), "Failed to load cloud metadata, aborting.");
      return null;
    }
    return TokenCacheItemMigrationAdapter.renewToken(TokenShareUtility.access$200(this$0), (ITokenCacheItem)localObject);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.adal.internal.tokensharing.TokenShareUtility.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */