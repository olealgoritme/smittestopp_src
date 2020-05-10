package com.microsoft.identity.common.internal.migration;

import com.microsoft.identity.common.BaseAccount;
import com.microsoft.identity.common.internal.cache.IShareSingleSignOnState;
import com.microsoft.identity.common.internal.providers.oauth2.RefreshToken;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TokenMigrationUtility<T extends BaseAccount, U extends RefreshToken>
{
  public static final String TAG = "com.microsoft.identity.common.internal.migration.TokenMigrationUtility";
  public static final ExecutorService sBackgroundExecutor = ;
  
  public void _import(IMigrationAdapter<T, U> paramIMigrationAdapter, Map<String, String> paramMap, IShareSingleSignOnState<T, U> paramIShareSingleSignOnState, TokenMigrationCallback paramTokenMigrationCallback)
  {
    sBackgroundExecutor.execute(new TokenMigrationUtility.1(this, paramIMigrationAdapter, paramMap, paramIShareSingleSignOnState, paramTokenMigrationCallback));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.migration.TokenMigrationUtility
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */