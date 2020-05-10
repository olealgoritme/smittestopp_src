package com.microsoft.appcenter.channel;

import android.os.Handler;
import com.microsoft.appcenter.http.HttpResponse;
import com.microsoft.appcenter.http.ServiceCallback;

public class DefaultChannel$2
  implements ServiceCallback
{
  public DefaultChannel$2(DefaultChannel paramDefaultChannel, DefaultChannel.GroupState paramGroupState, String paramString) {}
  
  public void onCallFailed(Exception paramException)
  {
    DefaultChannel.access$200(this$0).post(new DefaultChannel.2.2(this, paramException));
  }
  
  public void onCallSucceeded(HttpResponse paramHttpResponse)
  {
    DefaultChannel.access$200(this$0).post(new DefaultChannel.2.1(this));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.channel.DefaultChannel.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */