package com.microsoft.identity.client;

import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.internal.controllers.MsalExceptionAdapter;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.internal.controllers.CommandCallback;
import com.microsoft.identity.common.internal.result.ILocalAuthenticationResult;

public class SingleAccountPublicClientApplication$3
  implements CommandCallback<ILocalAuthenticationResult, BaseException>
{
  public SingleAccountPublicClientApplication$3(SingleAccountPublicClientApplication paramSingleAccountPublicClientApplication, SilentAuthenticationCallback paramSilentAuthenticationCallback, TokenParameters paramTokenParameters) {}
  
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
    if (val$authenticationCallback != null)
    {
      MultiTenantAccount localMultiTenantAccount = SingleAccountPublicClientApplication.access$100(this$0, paramILocalAuthenticationResult.getCacheRecordWithTenantProfileData());
      if (SingleAccountPublicClientApplication.access$200(this$0, localMultiTenantAccount))
      {
        if (SingleAccountPublicClientApplication.access$300(this$0) != null)
        {
          val$authenticationCallback.onError(new MsalClientException("returned_account_does_not_match_current_account"));
          return;
        }
        SingleAccountPublicClientApplication.access$400(this$0, paramILocalAuthenticationResult.getCacheRecordWithTenantProfileData());
      }
      else
      {
        SingleAccountPublicClientApplication.access$400(this$0, paramILocalAuthenticationResult.getCacheRecordWithTenantProfileData());
      }
      this$0.postAuthResult(paramILocalAuthenticationResult, val$tokenParameters, val$authenticationCallback);
      return;
    }
    throw new IllegalStateException("callback cannot be null or empty");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.SingleAccountPublicClientApplication.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */