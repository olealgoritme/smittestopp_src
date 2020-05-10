package com.microsoft.appcenter.analytics;

import e.a.a.a.a;

public enum AuthenticationProvider$Type
{
  public final String mTokenPrefix;
  
  static
  {
    Type localType = new Type("MSA_DELEGATE", 1, "d");
    MSA_DELEGATE = localType;
    $VALUES = new Type[] { MSA_COMPACT, localType };
  }
  
  public AuthenticationProvider$Type(String paramString)
  {
    mTokenPrefix = a.b(paramString, ":");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.analytics.AuthenticationProvider.Type
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */