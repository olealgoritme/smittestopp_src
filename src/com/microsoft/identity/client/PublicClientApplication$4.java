package com.microsoft.identity.client;

import com.microsoft.identity.client.configuration.AccountMode;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.exception.MsalException;

public final class PublicClientApplication$4
  implements IPublicClientApplication.ApplicationCreatedListener
{
  public PublicClientApplication$4(IPublicClientApplication.ISingleAccountApplicationCreatedListener paramISingleAccountApplicationCreatedListener) {}
  
  public void onCreated(IPublicClientApplication paramIPublicClientApplication)
  {
    if ((paramIPublicClientApplication instanceof ISingleAccountPublicClientApplication))
    {
      val$listener.onCreated((ISingleAccountPublicClientApplication)paramIPublicClientApplication);
    }
    else
    {
      if (paramIPublicClientApplication.getConfiguration().getAccountMode() != AccountMode.SINGLE)
      {
        val$listener.onError(new MsalClientException("single_account_pca_init_fail_account_mode", "AccountMode in configuration is not set to single. Cannot initialize single account PublicClientApplication."));
        return;
      }
      val$listener.onError(new MsalClientException("single_account_pca_init_fail_unknown_reason", "A single account public client application could not be created for unknown reasons."));
    }
  }
  
  public void onError(MsalException paramMsalException)
  {
    val$listener.onError(paramMsalException);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.PublicClientApplication.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */