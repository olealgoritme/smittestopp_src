package com.microsoft.azure.sdk.iot.device.DeviceTwin;

public class Pair<Type1, Type2>
{
  public final Type1 key;
  public Type2 value;
  
  public Pair(Type1 paramType1, Type2 paramType2)
  {
    key = paramType1;
    value = paramType2;
  }
  
  public Type1 getKey()
  {
    return (Type1)key;
  }
  
  public Type2 getValue()
  {
    return (Type2)value;
  }
  
  public Type2 setValue(Type2 paramType2)
  {
    Object localObject = value;
    value = paramType2;
    return (Type2)localObject;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.DeviceTwin.Pair
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */