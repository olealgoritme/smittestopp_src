package com.microsoft.identity.client;

import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.migration.TokenMigrationCallback;

public class MultipleAccountPublicClientApplication$1
  implements TokenMigrationCallback
{
  public MultipleAccountPublicClientApplication$1(MultipleAccountPublicClientApplication paramMultipleAccountPublicClientApplication) {}
  
  public void onMigrationFinished(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(MultipleAccountPublicClientApplication.access$000());
    ((StringBuilder)localObject).append(":getAccounts");
    ((StringBuilder)localObject).append(":onMigrationFinished");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Migrated [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("] accounts");
    Logger.info((String)localObject, localStringBuilder.toString());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.MultipleAccountPublicClientApplication.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */