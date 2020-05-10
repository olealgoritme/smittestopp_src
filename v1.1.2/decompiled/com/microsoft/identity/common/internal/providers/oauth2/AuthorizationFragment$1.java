package com.microsoft.identity.common.internal.providers.oauth2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AuthorizationFragment$1
  extends BroadcastReceiver
{
  public AuthorizationFragment$1(AuthorizationFragment paramAuthorizationFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this$0.cancelAuthorization(paramIntent.getBooleanExtra("com.microsoft.identity.client.request.cancelled.by.user", false));
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.oauth2.AuthorizationFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */