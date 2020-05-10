package com.microsoft.azure.proton.transport.proxy.impl;

public class StringUtils
{
  public static boolean isNullOrEmpty(String paramString)
  {
    boolean bool;
    if ((paramString != null) && (!paramString.isEmpty())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.proton.transport.proxy.impl.StringUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */