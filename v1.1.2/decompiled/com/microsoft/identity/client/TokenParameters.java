package com.microsoft.identity.client;

import com.microsoft.identity.client.claims.ClaimsRequest;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import com.microsoft.identity.common.internal.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

public abstract class TokenParameters
{
  public IAccount mAccount;
  public AccountRecord mAccountRecord;
  public AuthenticationScheme mAuthenticationScheme;
  public String mAuthority;
  public ClaimsRequest mClaimsRequest;
  public List<String> mScopes;
  
  public TokenParameters(Builder paramBuilder)
  {
    mAccount = Builder.access$000(paramBuilder);
    mAuthority = Builder.access$100(paramBuilder);
    mClaimsRequest = Builder.access$200(paramBuilder);
    mScopes = Builder.access$300(paramBuilder);
    mAuthenticationScheme = Builder.access$400(paramBuilder);
  }
  
  public IAccount getAccount()
  {
    return mAccount;
  }
  
  public AccountRecord getAccountRecord()
  {
    return mAccountRecord;
  }
  
  public AuthenticationScheme getAuthenticationScheme()
  {
    return mAuthenticationScheme;
  }
  
  public String getAuthority()
  {
    return mAuthority;
  }
  
  public ClaimsRequest getClaimsRequest()
  {
    return mClaimsRequest;
  }
  
  public List<String> getScopes()
  {
    return mScopes;
  }
  
  public void setAccount(IAccount paramIAccount)
  {
    mAccount = paramIAccount;
  }
  
  public void setAccountRecord(AccountRecord paramAccountRecord)
  {
    mAccountRecord = paramAccountRecord;
  }
  
  public void setAuthority(String paramString)
  {
    mAuthority = paramString;
  }
  
  public void setScopes(List<String> paramList)
  {
    mScopes = paramList;
  }
  
  public static abstract class Builder<B extends Builder<B>>
  {
    public IAccount mAccount;
    public AuthenticationScheme mAuthenticationScheme;
    public String mAuthority;
    public ClaimsRequest mClaimsRequest;
    public List<String> mScopes;
    
    public abstract TokenParameters build();
    
    public B forAccount(IAccount paramIAccount)
    {
      mAccount = paramIAccount;
      return self();
    }
    
    public B fromAuthority(String paramString)
    {
      mAuthority = paramString;
      return self();
    }
    
    public abstract B self();
    
    public B withAuthenticationScheme(AuthenticationScheme paramAuthenticationScheme)
    {
      mAuthenticationScheme = paramAuthenticationScheme;
      return self();
    }
    
    public B withClaims(ClaimsRequest paramClaimsRequest)
    {
      mClaimsRequest = paramClaimsRequest;
      return self();
    }
    
    public B withResource(final String paramString)
    {
      if (mScopes == null)
      {
        if (!StringUtil.isEmpty(paramString))
        {
          mScopes = new ArrayList() {};
          return self();
        }
        throw new IllegalArgumentException("Empty resource string.");
      }
      throw new IllegalArgumentException("Scopes is already set. Scopes and resources cannot be combined in a single request.");
    }
    
    public B withScopes(List<String> paramList)
    {
      if (mScopes == null)
      {
        if ((paramList != null) && (!paramList.isEmpty()))
        {
          mScopes = paramList;
          return self();
        }
        throw new IllegalArgumentException("Empty scopes list.");
      }
      throw new IllegalArgumentException("Scopes is already set.");
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.TokenParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */