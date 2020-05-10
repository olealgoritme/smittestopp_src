package com.microsoft.azure.sdk.iot.deps.serializer;

import java.util.Map;

@Deprecated
public abstract interface TwinPropertiesChangeCallback
{
  public abstract void execute(Map<String, Object> paramMap);
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.serializer.TwinPropertiesChangeCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */