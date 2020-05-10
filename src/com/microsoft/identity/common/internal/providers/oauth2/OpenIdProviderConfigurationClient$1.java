package com.microsoft.identity.common.internal.providers.oauth2;

import com.microsoft.identity.common.exception.ServiceException;
import com.microsoft.identity.common.internal.controllers.TaskCompletedCallback;
import com.microsoft.identity.common.internal.controllers.TaskCompletedCallbackWithError;

public class OpenIdProviderConfigurationClient$1
  implements Runnable
{
  public OpenIdProviderConfigurationClient$1(OpenIdProviderConfigurationClient paramOpenIdProviderConfigurationClient, OpenIdProviderConfigurationClient.OpenIdProviderConfigurationCallback paramOpenIdProviderConfigurationCallback) {}
  
  public void run()
  {
    try
    {
      val$callback.onTaskCompleted(this$0.loadOpenIdProviderConfiguration());
    }
    catch (ServiceException localServiceException)
    {
      val$callback.onError(localServiceException);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.oauth2.OpenIdProviderConfigurationClient.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */