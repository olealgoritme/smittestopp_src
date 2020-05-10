package com.microsoft.appcenter.http;

import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.NetworkStateHelper;
import com.microsoft.appcenter.utils.NetworkStateHelper.Listener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HttpClientNetworkStateHandler
  extends HttpClientDecorator
  implements NetworkStateHelper.Listener
{
  public final Set<HttpClientNetworkStateHandler.Call> mCalls = new HashSet();
  public final NetworkStateHelper mNetworkStateHelper;
  
  public HttpClientNetworkStateHandler(HttpClient paramHttpClient, NetworkStateHelper paramNetworkStateHelper)
  {
    super(paramHttpClient);
    mNetworkStateHelper = paramNetworkStateHelper;
    paramNetworkStateHelper.addListener(this);
  }
  
  private void cancelCall(HttpClientNetworkStateHandler.Call paramCall)
  {
    try
    {
      if (mServiceCall != null) {
        mServiceCall.cancel();
      }
      mCalls.remove(paramCall);
      return;
    }
    finally {}
  }
  
  public ServiceCall callAsync(String paramString1, String paramString2, Map<String, String> paramMap, HttpClient.CallTemplate paramCallTemplate, ServiceCallback paramServiceCallback)
  {
    try
    {
      HttpClientNetworkStateHandler.Call localCall = new com/microsoft/appcenter/http/HttpClientNetworkStateHandler$Call;
      localCall.<init>(this, mDecoratedApi, paramString1, paramString2, paramMap, paramCallTemplate, paramServiceCallback);
      if (mNetworkStateHelper.isNetworkConnected())
      {
        localCall.run();
      }
      else
      {
        mCalls.add(localCall);
        AppCenterLog.debug("AppCenter", "Call triggered with no network connectivity, waiting network to become available...");
      }
      return localCall;
    }
    finally {}
  }
  
  public void close()
  {
    try
    {
      mNetworkStateHelper.removeListener(this);
      mCalls.clear();
      super.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void onNetworkStateUpdated(boolean paramBoolean)
  {
    if (paramBoolean) {
      try
      {
        if (mCalls.size() > 0)
        {
          Object localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          ((StringBuilder)localObject1).append("Network is available. ");
          ((StringBuilder)localObject1).append(mCalls.size());
          ((StringBuilder)localObject1).append(" pending call(s) to submit now.");
          AppCenterLog.debug("AppCenter", ((StringBuilder)localObject1).toString());
          localObject1 = mCalls.iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((HttpClientNetworkStateHandler.Call)((Iterator)localObject1).next()).run();
          }
          mCalls.clear();
        }
      }
      finally {}
    }
  }
  
  public void reopen()
  {
    mNetworkStateHelper.addListener(this);
    super.reopen();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.http.HttpClientNetworkStateHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */