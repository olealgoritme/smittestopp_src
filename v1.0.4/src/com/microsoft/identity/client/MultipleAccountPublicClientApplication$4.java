package com.microsoft.identity.client;

import com.microsoft.identity.client.internal.controllers.MsalExceptionAdapter;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.controllers.CommandCallback;
import com.microsoft.identity.common.internal.logging.Logger;
import java.util.Iterator;
import java.util.List;

public class MultipleAccountPublicClientApplication$4
  implements CommandCallback<List<ICacheRecord>, BaseException>
{
  public MultipleAccountPublicClientApplication$4(MultipleAccountPublicClientApplication paramMultipleAccountPublicClientApplication, IMultipleAccountPublicClientApplication.GetAccountCallback paramGetAccountCallback, String paramString) {}
  
  public void onCancel() {}
  
  public void onError(BaseException paramBaseException)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(MultipleAccountPublicClientApplication.access$000());
    localStringBuilder.append(":getAccount");
    Logger.error(localStringBuilder.toString(), paramBaseException.getMessage(), paramBaseException);
    val$callback.onError(MsalExceptionAdapter.msalExceptionFromBaseException(paramBaseException));
  }
  
  public void onTaskCompleted(List<ICacheRecord> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      Object localObject1 = AccountAdapter.adapt(paramList);
      paramList = val$identifier.trim();
      Object localObject2 = this$0;
      localObject2 = new PublicClientApplication.AccountMatcher((PublicClientApplication)localObject2, new PublicClientApplication.AccountMatcher[] { homeAccountMatcher, localAccountMatcher, usernameMatcher });
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (IAccount)localIterator.next();
        if (((PublicClientApplication.AccountMatcher)localObject2).matches(paramList, (IAccount)localObject1))
        {
          val$callback.onTaskCompleted((IAccount)localObject1);
          return;
        }
      }
      val$callback.onTaskCompleted(null);
    }
    else
    {
      paramList = new StringBuilder();
      paramList.append(MultipleAccountPublicClientApplication.access$000());
      paramList.append(":getAccount");
      Logger.verbose(paramList.toString(), "No account found.");
      val$callback.onTaskCompleted(null);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.MultipleAccountPublicClientApplication.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */