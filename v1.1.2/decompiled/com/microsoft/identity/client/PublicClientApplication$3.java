package com.microsoft.identity.client;

import com.microsoft.identity.client.configuration.AccountMode;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.exception.MsalException;

public final class PublicClientApplication$3
  implements IPublicClientApplication.ApplicationCreatedListener
{
  public PublicClientApplication$3(IPublicClientApplication.IMultipleAccountApplicationCreatedListener paramIMultipleAccountApplicationCreatedListener) {}
  
  public void onCreated(IPublicClientApplication paramIPublicClientApplication)
  {
    if ((paramIPublicClientApplication instanceof IMultipleAccountPublicClientApplication))
    {
      val$listener.onCreated((IMultipleAccountPublicClientApplication)paramIPublicClientApplication);
    }
    else
    {
      if ((paramIPublicClientApplication.getConfiguration().getAccountMode() == AccountMode.MULTIPLE) && (paramIPublicClientApplication.isSharedDevice()))
      {
        val$listener.onError(new MsalClientException("multiple_account_pca_init_fail_on_shared_device", "AccountMode in configuration is set to multiple. However, the device is marked as shared (which requires single account mode)."));
        return;
      }
      val$listener.onError(new MsalClientException("multiple_account_pca_init_fail_unknown_reason", "Multiple account PublicClientApplication could not be created for unknown reasons"));
    }
  }
  
  public void onError(MsalException paramMsalException)
  {
    val$listener.onError(paramMsalException);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.PublicClientApplication.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */