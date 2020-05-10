package com.microsoft.identity.client;

import com.microsoft.identity.client.claims.ClaimsRequest;
import com.microsoft.identity.common.internal.dto.AccountRecord;
import java.util.List;

public abstract class TokenParameters
{
  public IAccount mAccount;
  public AccountRecord mAccountRecord;
  public AuthenticationScheme mAuthenticationScheme;
  public String mAuthority;
  public ClaimsRequest mClaimsRequest;
  public List<String> mScopes;
  
  public TokenParameters(TokenParameters.Builder paramBuilder)
  {
    mAccount = TokenParameters.Builder.access$000(paramBuilder);
    mAuthority = TokenParameters.Builder.access$100(paramBuilder);
    mClaimsRequest = TokenParameters.Builder.access$200(paramBuilder);
    mScopes = TokenParameters.Builder.access$300(paramBuilder);
    mAuthenticationScheme = TokenParameters.Builder.access$400(paramBuilder);
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
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.TokenParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */