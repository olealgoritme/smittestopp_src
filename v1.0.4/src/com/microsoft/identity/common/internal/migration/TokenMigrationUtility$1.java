package com.microsoft.identity.common.internal.migration;

import android.util.Pair;
import com.microsoft.identity.common.BaseAccount;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.cache.IShareSingleSignOnState;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.oauth2.RefreshToken;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TokenMigrationUtility$1
  implements Runnable
{
  public TokenMigrationUtility$1(TokenMigrationUtility paramTokenMigrationUtility, IMigrationAdapter paramIMigrationAdapter, Map paramMap, IShareSingleSignOnState paramIShareSingleSignOnState, TokenMigrationCallback paramTokenMigrationCallback) {}
  
  public void run()
  {
    Iterator localIterator = val$adapter.adapt(val$credentials).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      try
      {
        val$destination.setSingleSignOnState((BaseAccount)first, (RefreshToken)second);
        i++;
      }
      catch (ClientException localClientException)
      {
        Logger.warn(TokenMigrationUtility.access$000(), "Failed to save account/refresh token . Skipping ");
      }
    }
    val$callback.onMigrationFinished(i);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.migration.TokenMigrationUtility.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */