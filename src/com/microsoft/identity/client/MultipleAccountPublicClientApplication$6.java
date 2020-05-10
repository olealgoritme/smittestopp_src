package com.microsoft.identity.client;

import com.microsoft.identity.client.internal.controllers.MsalExceptionAdapter;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.internal.controllers.CommandCallback;

public class MultipleAccountPublicClientApplication$6
  implements CommandCallback<Boolean, BaseException>
{
  public MultipleAccountPublicClientApplication$6(MultipleAccountPublicClientApplication paramMultipleAccountPublicClientApplication, IMultipleAccountPublicClientApplication.RemoveAccountCallback paramRemoveAccountCallback) {}
  
  public void onCancel() {}
  
  public void onError(BaseException paramBaseException)
  {
    val$callback.onError(MsalExceptionAdapter.msalExceptionFromBaseException(paramBaseException));
  }
  
  public void onTaskCompleted(Boolean paramBoolean)
  {
    val$callback.onRemoved();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.MultipleAccountPublicClientApplication.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */