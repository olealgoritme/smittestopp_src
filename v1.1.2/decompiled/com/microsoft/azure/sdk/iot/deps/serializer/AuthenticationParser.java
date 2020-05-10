package com.microsoft.azure.sdk.iot.deps.serializer;

import e.c.c.v.a;
import e.c.c.v.c;

public class AuthenticationParser
{
  public static final String AUTHENTICATION_TYPE_NAME = "type";
  public static final String SYMMETRIC_KEY_NAME = "symmetricKey";
  public static final String X509_THUMBPRINT_NAME = "x509Thumbprint";
  @a(deserialize=true, serialize=true)
  @c("symmetricKey")
  public SymmetricKeyParser symmetricKey;
  @a(deserialize=true, serialize=true)
  @c("x509Thumbprint")
  public X509ThumbprintParser thumbprint;
  @a(deserialize=true, serialize=true)
  @c("type")
  public AuthenticationTypeParser type;
  
  public SymmetricKeyParser getSymmetricKey()
  {
    return symmetricKey;
  }
  
  public X509ThumbprintParser getThumbprint()
  {
    return thumbprint;
  }
  
  public AuthenticationTypeParser getType()
  {
    return type;
  }
  
  public void setSymmetricKey(SymmetricKeyParser paramSymmetricKeyParser)
  {
    symmetricKey = paramSymmetricKeyParser;
  }
  
  public void setThumbprint(X509ThumbprintParser paramX509ThumbprintParser)
  {
    thumbprint = paramX509ThumbprintParser;
  }
  
  public void setType(AuthenticationTypeParser paramAuthenticationTypeParser)
  {
    if (paramAuthenticationTypeParser != null)
    {
      type = paramAuthenticationTypeParser;
      return;
    }
    throw new IllegalArgumentException("Type may not be set to null");
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.serializer.AuthenticationParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */