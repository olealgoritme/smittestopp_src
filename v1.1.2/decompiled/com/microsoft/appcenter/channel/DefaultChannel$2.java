package com.microsoft.appcenter.channel;

import android.os.Handler;
import com.microsoft.appcenter.http.HttpResponse;
import com.microsoft.appcenter.http.ServiceCallback;

public class DefaultChannel$2
  implements ServiceCallback
{
  public DefaultChannel$2(DefaultChannel paramDefaultChannel, DefaultChannel.GroupState paramGroupState, String paramString) {}
  
  public void onCallFailed(final Exception paramException)
  {
    DefaultChannel.access$200(this$0).post(new Runnable()
    {
      public void run()
      {
        DefaultChannel.2 local2 = DefaultChannel.2.this;
        DefaultChannel.access$300(this$0, val$groupState, val$batchId, paramException);
      }
    });
  }
  
  public void onCallSucceeded(HttpResponse paramHttpResponse)
  {
    DefaultChannel.access$200(this$0).post(new Runnable()
    {
      public void run()
      {
        DefaultChannel.2 local2 = DefaultChannel.2.this;
        DefaultChannel.access$100(this$0, val$groupState, val$batchId);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.channel.DefaultChannel.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */