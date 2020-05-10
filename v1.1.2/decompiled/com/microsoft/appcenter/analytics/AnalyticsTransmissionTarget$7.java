package com.microsoft.appcenter.analytics;

import com.microsoft.appcenter.channel.AbstractChannelListener;
import com.microsoft.appcenter.ingestion.models.Log;

public final class AnalyticsTransmissionTarget$7
  extends AbstractChannelListener
{
  public void onPreparingLog(Log paramLog, String paramString)
  {
    AnalyticsTransmissionTarget.access$600(paramLog);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.analytics.AnalyticsTransmissionTarget.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */