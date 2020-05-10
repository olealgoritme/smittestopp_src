package com.microsoft.identity.client;

import com.microsoft.identity.client.configuration.AccountMode;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.internal.controllers.MsalExceptionAdapter;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.internal.controllers.CommandCallback;

public final class PublicClientApplication$2
  implements CommandCallback<Boolean, BaseException>
{
  public PublicClientApplication$2(IPublicClientApplication.ApplicationCreatedListener paramApplicationCreatedListener, PublicClientApplicationConfiguration paramPublicClientApplicationConfiguration) {}
  
  public void onCancel() {}
  
  public void onError(BaseException paramBaseException)
  {
    val$listener.onError(MsalExceptionAdapter.msalExceptionFromBaseException(paramBaseException));
  }
  
  public void onTaskCompleted(Boolean paramBoolean)
  {
    val$config.setIsSharedDevice(paramBoolean.booleanValue());
    try
    {
      Object localObject;
      if ((val$config.getAccountMode() != AccountMode.SINGLE) && (!paramBoolean.booleanValue()))
      {
        localObject = val$listener;
        paramBoolean = new com/microsoft/identity/client/MultipleAccountPublicClientApplication;
        paramBoolean.<init>(val$config);
        ((IPublicClientApplication.ApplicationCreatedListener)localObject).onCreated(paramBoolean);
      }
      else
      {
        paramBoolean = val$listener;
        localObject = new com/microsoft/identity/client/SingleAccountPublicClientApplication;
        ((SingleAccountPublicClientApplication)localObject).<init>(val$config);
        paramBoolean.onCreated((IPublicClientApplication)localObject);
      }
    }
    catch (MsalClientException paramBoolean)
    {
      val$listener.onError(paramBoolean);
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.PublicClientApplication.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */