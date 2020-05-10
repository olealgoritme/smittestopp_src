package com.microsoft.identity.common.internal.providers.oauth2;

public abstract class ClientAssertion
{
  public static final String DEFAULT_CLIENT_ASSERTION_TYPE = "urn:ietf:params:oauth:client-assertion-type:jwt-bearer";
  public String mClientAssertion;
  public String mClientAssertionType = "urn:ietf:params:oauth:client-assertion-type:jwt-bearer";
  
  public String getClientAssertion()
  {
    return mClientAssertion;
  }
  
  public String getClientAssertionType()
  {
    return mClientAssertionType;
  }
  
  public void setClientAssertion(String paramString)
  {
    mClientAssertion = paramString;
  }
  
  public void setClientAssertionType(String paramString)
  {
    mClientAssertionType = paramString;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.oauth2.ClientAssertion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */