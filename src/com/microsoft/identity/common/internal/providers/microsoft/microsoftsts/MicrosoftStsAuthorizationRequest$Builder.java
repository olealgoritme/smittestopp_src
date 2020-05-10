package com.microsoft.identity.common.internal.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationRequest.Builder;

public class MicrosoftStsAuthorizationRequest$Builder
  extends MicrosoftAuthorizationRequest.Builder<Builder>
{
  public String mDisplayableId;
  public String mTokenScope;
  public String mUid;
  public String mUtid;
  
  public MicrosoftStsAuthorizationRequest build()
  {
    return new MicrosoftStsAuthorizationRequest(this);
  }
  
  public Builder self()
  {
    return this;
  }
  
  public Builder setDisplayableId(String paramString)
  {
    mDisplayableId = paramString;
    return self();
  }
  
  public Builder setTokenScope(String paramString)
  {
    mTokenScope = paramString;
    return self();
  }
  
  public Builder setUid(String paramString)
  {
    mUid = paramString;
    return self();
  }
  
  public Builder setUtid(String paramString)
  {
    mUtid = paramString;
    return self();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */