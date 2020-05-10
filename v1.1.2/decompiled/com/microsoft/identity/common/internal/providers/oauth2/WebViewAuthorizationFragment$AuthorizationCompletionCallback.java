package com.microsoft.identity.common.internal.providers.oauth2;

import android.content.Intent;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.ui.webview.challengehandlers.IAuthorizationCompletionCallback;

public class WebViewAuthorizationFragment$AuthorizationCompletionCallback
  implements IAuthorizationCompletionCallback
{
  public WebViewAuthorizationFragment$AuthorizationCompletionCallback(WebViewAuthorizationFragment paramWebViewAuthorizationFragment) {}
  
  public void onChallengeResponseReceived(int paramInt, Intent paramIntent)
  {
    String str = WebViewAuthorizationFragment.access$300();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onChallengeResponseReceived:");
    localStringBuilder.append(paramInt);
    Logger.info(str, null, localStringBuilder.toString());
    this$0.sendResult(paramInt, paramIntent);
    this$0.finish();
  }
  
  public void setPKeyAuthStatus(boolean paramBoolean)
  {
    WebViewAuthorizationFragment.access$602(this$0, paramBoolean);
    String str = WebViewAuthorizationFragment.access$300();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPKeyAuthStatus:");
    localStringBuilder.append(paramBoolean);
    Logger.info(str, null, localStringBuilder.toString());
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.oauth2.WebViewAuthorizationFragment.AuthorizationCompletionCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */