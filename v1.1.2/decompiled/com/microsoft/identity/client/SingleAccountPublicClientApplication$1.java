package com.microsoft.identity.client;

import com.microsoft.identity.client.internal.controllers.MsalExceptionAdapter;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.controllers.CommandCallback;
import java.util.List;

public class SingleAccountPublicClientApplication$1
  implements CommandCallback<List<ICacheRecord>, BaseException>
{
  public SingleAccountPublicClientApplication$1(SingleAccountPublicClientApplication paramSingleAccountPublicClientApplication, ISingleAccountPublicClientApplication.CurrentAccountCallback paramCurrentAccountCallback) {}
  
  public void onCancel() {}
  
  public void onError(BaseException paramBaseException)
  {
    val$callback.onError(MsalExceptionAdapter.msalExceptionFromBaseException(paramBaseException));
  }
  
  public void onTaskCompleted(List<ICacheRecord> paramList)
  {
    SingleAccountPublicClientApplication.access$000(this$0, val$callback, paramList);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.SingleAccountPublicClientApplication.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */