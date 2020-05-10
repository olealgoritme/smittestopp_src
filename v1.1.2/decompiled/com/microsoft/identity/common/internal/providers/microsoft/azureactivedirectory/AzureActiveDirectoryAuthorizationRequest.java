package com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory;

import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationRequest;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationRequest.Builder;
import e.c.c.v.c;

public class AzureActiveDirectoryAuthorizationRequest
  extends MicrosoftAuthorizationRequest
{
  @c("claims")
  public String mClaimsChallenge;
  @c("prompt")
  public String mPrompt;
  @c("resource")
  public String mResource;
  
  public AzureActiveDirectoryAuthorizationRequest(Builder paramBuilder)
  {
    super(paramBuilder);
    mResource = Builder.access$000(paramBuilder);
    mPrompt = Builder.access$100(paramBuilder);
    mClaimsChallenge = Builder.access$200(paramBuilder);
  }
  
  public String getAuthorizationEndpoint()
  {
    return null;
  }
  
  public String getClaimsChallenge()
  {
    return mClaimsChallenge;
  }
  
  public String getPrompt()
  {
    return mPrompt;
  }
  
  public String getResource()
  {
    return mResource;
  }
  
  public static class Builder
    extends MicrosoftAuthorizationRequest.Builder<Builder>
  {
    public String mClaimsChallenge;
    public String mPrompt;
    public String mResource;
    
    public AzureActiveDirectoryAuthorizationRequest build()
    {
      setLibraryName("ADAL.Android");
      setLibraryVersion("1.15.2");
      return new AzureActiveDirectoryAuthorizationRequest(this);
    }
    
    public Builder self()
    {
      return this;
    }
    
    public Builder setClaimsChallenge(String paramString)
    {
      mClaimsChallenge = paramString;
      return this;
    }
    
    public Builder setPrompt(String paramString)
    {
      mPrompt = paramString;
      return this;
    }
    
    public Builder setResource(String paramString)
    {
      mResource = paramString;
      return this;
    }
  }
  
  public static final class Prompt
  {
    public static final String ADMIN_CONSENT = "admin_consent";
    public static final String ALWAYS = "login";
    public static final String AUTO = "none";
    public static final String CONSENT = "consent";
    public static final String FORCE_PROMPT = "login";
    public static final String REFRESH_SESSION = "refresh_session";
    public static final String SELECT_ACCOUNT = "select_account";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryAuthorizationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */