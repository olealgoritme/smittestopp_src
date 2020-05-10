package com.microsoft.azure.sdk.iot.device;

public enum FeedbackStatusCodeEnum
{
  static
  {
    expired = new FeedbackStatusCodeEnum("expired", 2);
    deliveryCountExceeded = new FeedbackStatusCodeEnum("deliveryCountExceeded", 3);
    FeedbackStatusCodeEnum localFeedbackStatusCodeEnum = new FeedbackStatusCodeEnum("rejected", 4);
    rejected = localFeedbackStatusCodeEnum;
    $VALUES = new FeedbackStatusCodeEnum[] { none, success, expired, deliveryCountExceeded, localFeedbackStatusCodeEnum };
  }
  
  public FeedbackStatusCodeEnum() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.FeedbackStatusCodeEnum
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */