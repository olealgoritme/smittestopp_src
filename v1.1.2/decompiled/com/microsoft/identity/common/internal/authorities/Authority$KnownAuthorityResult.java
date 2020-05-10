package com.microsoft.identity.common.internal.authorities;

import com.microsoft.identity.common.exception.ClientException;

public class Authority$KnownAuthorityResult
{
  public ClientException mClientException;
  public boolean mKnown;
  
  public Authority$KnownAuthorityResult(boolean paramBoolean, ClientException paramClientException)
  {
    mKnown = paramBoolean;
    mClientException = paramClientException;
  }
  
  public ClientException getClientException()
  {
    return mClientException;
  }
  
  public boolean getKnown()
  {
    return mKnown;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.authorities.Authority.KnownAuthorityResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */