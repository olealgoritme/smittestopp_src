package com.microsoft.appcenter.crashes;

import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.crashes.ingestion.models.HandledErrorLog;
import com.microsoft.appcenter.ingestion.models.AbstractLog;
import com.microsoft.appcenter.ingestion.models.LogWithProperties;
import java.util.Map;
import java.util.UUID;

public class Crashes$9
  implements Runnable
{
  public Crashes$9(Crashes paramCrashes, UUID paramUUID, String paramString, Crashes.ExceptionModelBuilder paramExceptionModelBuilder, Map paramMap, Iterable paramIterable) {}
  
  public void run()
  {
    HandledErrorLog localHandledErrorLog = new HandledErrorLog();
    localHandledErrorLog.setId(val$errorId);
    localHandledErrorLog.setUserId(val$userId);
    localHandledErrorLog.setException(val$exceptionModelBuilder.buildExceptionModel());
    localHandledErrorLog.setProperties(val$validatedProperties);
    Crashes.access$800(this$0).enqueue(localHandledErrorLog, "groupErrors", 1);
    Crashes.access$900(this$0, val$errorId, val$attachments);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.crashes.Crashes.9
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */