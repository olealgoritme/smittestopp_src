package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

import java.util.List;

public class PKeyAuthChallenge$Builder
{
  public List<String> mCertAuthorities;
  public String mContext = "";
  public String mNonce = "";
  public String mSubmitUrl;
  public String mThumbprint = "";
  public String mVersion;
  
  public PKeyAuthChallenge build()
  {
    return new PKeyAuthChallenge(this);
  }
  
  public Builder self()
  {
    return this;
  }
  
  public Builder setCertAuthorities(List<String> paramList)
  {
    mCertAuthorities = paramList;
    return self();
  }
  
  public Builder setContext(String paramString)
  {
    mContext = paramString;
    return self();
  }
  
  public Builder setNonce(String paramString)
  {
    mNonce = paramString;
    return self();
  }
  
  public Builder setSubmitUrl(String paramString)
  {
    mSubmitUrl = paramString;
    return self();
  }
  
  public Builder setThumbprint(String paramString)
  {
    mThumbprint = paramString;
    return self();
  }
  
  public Builder setVersion(String paramString)
  {
    mVersion = paramString;
    return self();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.ui.webview.challengehandlers.PKeyAuthChallenge.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */