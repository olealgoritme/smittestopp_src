package com.microsoft.identity.client;

import com.microsoft.identity.client.internal.controllers.MsalExceptionAdapter;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.internal.controllers.CommandCallback;
import com.microsoft.identity.common.internal.result.ILocalAuthenticationResult;

public class PublicClientApplication$9
  implements CommandCallback<ILocalAuthenticationResult, BaseException>
{
  public PublicClientApplication$9(PublicClientApplication paramPublicClientApplication, TokenParameters paramTokenParameters, SilentAuthenticationCallback paramSilentAuthenticationCallback) {}
  
  public void onCancel()
  {
    SilentAuthenticationCallback localSilentAuthenticationCallback = val$authenticationCallback;
    if ((localSilentAuthenticationCallback instanceof AuthenticationCallback))
    {
      ((AuthenticationCallback)localSilentAuthenticationCallback).onCancel();
      return;
    }
    throw new IllegalStateException("Silent requests cannot be cancelled.");
  }
  
  public void onError(BaseException paramBaseException)
  {
    paramBaseException = MsalExceptionAdapter.msalExceptionFromBaseException(paramBaseException);
    SilentAuthenticationCallback localSilentAuthenticationCallback = val$authenticationCallback;
    if (localSilentAuthenticationCallback != null)
    {
      localSilentAuthenticationCallback.onError(paramBaseException);
      return;
    }
    throw new IllegalStateException("callback cannot be null or empty");
  }
  
  public void onTaskCompleted(ILocalAuthenticationResult paramILocalAuthenticationResult)
  {
    this$0.postAuthResult(paramILocalAuthenticationResult, val$tokenParameters, val$authenticationCallback);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.PublicClientApplication.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */