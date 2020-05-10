package com.microsoft.identity.client;

import com.microsoft.identity.client.internal.controllers.MsalExceptionAdapter;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.internal.controllers.CommandCallback;

public class SingleAccountPublicClientApplication$4
  implements CommandCallback<Boolean, BaseException>
{
  public SingleAccountPublicClientApplication$4(SingleAccountPublicClientApplication paramSingleAccountPublicClientApplication, ISingleAccountPublicClientApplication.SignOutCallback paramSignOutCallback) {}
  
  public void onCancel() {}
  
  public void onError(BaseException paramBaseException)
  {
    val$callback.onError(MsalExceptionAdapter.msalExceptionFromBaseException(paramBaseException));
  }
  
  public void onTaskCompleted(Boolean paramBoolean)
  {
    SingleAccountPublicClientApplication.access$400(this$0, null);
    val$callback.onSignOut();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.SingleAccountPublicClientApplication.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */