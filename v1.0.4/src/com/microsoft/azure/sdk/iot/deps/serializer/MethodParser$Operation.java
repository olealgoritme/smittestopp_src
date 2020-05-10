package com.microsoft.azure.sdk.iot.deps.serializer;

public enum MethodParser$Operation
{
  static
  {
    payload = new Operation("payload", 2);
    Operation localOperation = new Operation("none", 3);
    none = localOperation;
    $VALUES = new Operation[] { invoke, response, payload, localOperation };
  }
  
  public MethodParser$Operation() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.serializer.MethodParser.Operation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */