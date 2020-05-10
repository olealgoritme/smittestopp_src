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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TokenMigrationUtility<T extends BaseAccount, U extends RefreshToken>
{
  public static final String TAG = "com.microsoft.identity.common.internal.migration.TokenMigrationUtility";
  public static final ExecutorService sBackgroundExecutor = ;
  
  public void _import(final IMigrationAdapter<T, U> paramIMigrationAdapter, final Map<String, String> paramMap, final IShareSingleSignOnState<T, U> paramIShareSingleSignOnState, final TokenMigrationCallback paramTokenMigrationCallback)
  {
    sBackgroundExecutor.execute(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = paramIMigrationAdapter.adapt(paramMap).iterator();
        int i = 0;
        while (localIterator.hasNext())
        {
          Pair localPair = (Pair)localIterator.next();
          try
          {
            paramIShareSingleSignOnState.setSingleSignOnState((BaseAccount)first, (RefreshToken)second);
            i++;
          }
          catch (ClientException localClientException)
          {
            Logger.warn(TokenMigrationUtility.access$000(), "Failed to save account/refresh token . Skipping ");
          }
        }
        paramTokenMigrationCallback.onMigrationFinished(i);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.migration.TokenMigrationUtility
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */