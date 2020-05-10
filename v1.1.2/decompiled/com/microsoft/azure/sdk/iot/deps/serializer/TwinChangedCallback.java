package com.microsoft.azure.sdk.iot.deps.serializer;

import java.util.Map;

@Deprecated
public abstract interface TwinChangedCallback
{
  public abstract void execute(Map<String, Object> paramMap);
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.serializer.TwinChangedCallback
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */