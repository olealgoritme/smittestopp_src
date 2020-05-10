package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

import android.content.Intent;

public abstract interface IAuthorizationCompletionCallback
{
  public abstract void onChallengeResponseReceived(int paramInt, Intent paramIntent);
  
  public abstract void setPKeyAuthStatus(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.ui.webview.challengehandlers.IAuthorizationCompletionCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */