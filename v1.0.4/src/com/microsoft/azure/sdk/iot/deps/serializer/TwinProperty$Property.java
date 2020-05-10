package com.microsoft.azure.sdk.iot.deps.serializer;

public class TwinProperty$Property
{
  public TwinMetadata metadata;
  public Object value;
  
  public TwinProperty$Property(TwinProperty paramTwinProperty, Object paramObject, Integer paramInteger)
  {
    value = paramObject;
    metadata = new TwinMetadata(paramInteger);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.serializer.TwinProperty.Property
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */