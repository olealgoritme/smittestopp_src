package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectoryb2c;

import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationRequest;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationRequest.Builder;

public class AzureActiveDirectoryB2CAuthorizationRequest
  extends MicrosoftAuthorizationRequest<AzureActiveDirectoryB2CAuthorizationRequest>
{
  public String mPrompt;
  
  public AzureActiveDirectoryB2CAuthorizationRequest(Builder paramBuilder)
  {
    super(paramBuilder);
  }
  
  public String getAuthorizationEndpoint()
  {
    throw new UnsupportedOperationException("Not implemented.");
  }
  
  public String getPrompt()
  {
    return mPrompt;
  }
  
  public static final class Builder
    extends MicrosoftAuthorizationRequest.Builder<Builder>
  {
    public String mPrompt;
    
    public AzureActiveDirectoryB2CAuthorizationRequest build()
    {
      return new AzureActiveDirectoryB2CAuthorizationRequest(this, null);
    }
    
    public Builder self()
    {
      return this;
    }
    
    public Builder setPrompt(String paramString)
    {
      mPrompt = paramString;
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectoryb2c.AzureActiveDirectoryB2CAuthorizationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */