package com.microsoft.appcenter.channel;

public class DefaultChannel$GroupState$1
  implements Runnable
{
  public DefaultChannel$GroupState$1(DefaultChannel.GroupState paramGroupState) {}
  
  public void run()
  {
    DefaultChannel.GroupState localGroupState = this$1;
    mScheduled = false;
    DefaultChannel.access$500(this$0, localGroupState);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.channel.DefaultChannel.GroupState.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */