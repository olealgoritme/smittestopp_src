package com.microsoft.identity.client;

import com.microsoft.identity.client.internal.controllers.MsalExceptionAdapter;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.controllers.CommandCallback;
import java.util.List;

public final class PublicClientApplication$8
  implements CommandCallback<List<ICacheRecord>, BaseException>
{
  public PublicClientApplication$8(IPublicClientApplication.LoadAccountsCallback paramLoadAccountsCallback) {}
  
  public void onCancel() {}
  
  public void onError(BaseException paramBaseException)
  {
    val$loadAccountsCallback.onError(MsalExceptionAdapter.msalExceptionFromBaseException(paramBaseException));
  }
  
  public void onTaskCompleted(List<ICacheRecord> paramList)
  {
    if (paramList == null) {
      val$loadAccountsCallback.onTaskCompleted(null);
    } else {
      val$loadAccountsCallback.onTaskCompleted(AccountAdapter.adapt(paramList));
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.PublicClientApplication.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */