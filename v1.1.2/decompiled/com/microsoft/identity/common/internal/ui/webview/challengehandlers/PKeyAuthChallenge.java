package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

import java.io.Serializable;
import java.util.List;

public class PKeyAuthChallenge
  implements Serializable
{
  public static final long serialVersionUID = 1035116074451575588L;
  public List<String> mCertAuthorities;
  public String mContext;
  public String mNonce;
  public String mSubmitUrl;
  public String mThumbprint;
  public String mVersion;
  
  public PKeyAuthChallenge(Builder paramBuilder)
  {
    mNonce = Builder.access$000(paramBuilder);
    mContext = Builder.access$100(paramBuilder);
    mCertAuthorities = Builder.access$200(paramBuilder);
    mThumbprint = Builder.access$300(paramBuilder);
    mVersion = Builder.access$400(paramBuilder);
    mSubmitUrl = Builder.access$500(paramBuilder);
  }
  
  public List<String> getCertAuthorities()
  {
    return mCertAuthorities;
  }
  
  public String getContext()
  {
    return mContext;
  }
  
  public String getNonce()
  {
    return mNonce;
  }
  
  public String getSubmitUrl()
  {
    return mSubmitUrl;
  }
  
  public String getThumbprint()
  {
    return mThumbprint;
  }
  
  public String getVersion()
  {
    return mVersion;
  }
  
  public static class Builder
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
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.ui.webview.challengehandlers.PKeyAuthChallenge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */