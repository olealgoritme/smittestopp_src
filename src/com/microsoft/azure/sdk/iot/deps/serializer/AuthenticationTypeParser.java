package com.microsoft.azure.sdk.iot.deps.serializer;

import e.c.c.v.c;

public enum AuthenticationTypeParser
{
  static
  {
    AuthenticationTypeParser localAuthenticationTypeParser = new AuthenticationTypeParser("CERTIFICATE_AUTHORITY", 2);
    CERTIFICATE_AUTHORITY = localAuthenticationTypeParser;
    $VALUES = new AuthenticationTypeParser[] { SAS, SELF_SIGNED, localAuthenticationTypeParser };
  }
  
  public AuthenticationTypeParser() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.serializer.AuthenticationTypeParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */