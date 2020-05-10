package com.microsoft.identity.common.internal.request;

public enum SdkType
{
  static
  {
    SdkType localSdkType = new SdkType("MSAL", 1);
    MSAL = localSdkType;
    $VALUES = new SdkType[] { ADAL, localSdkType };
  }
  
  public SdkType() {}
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.request.SdkType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */