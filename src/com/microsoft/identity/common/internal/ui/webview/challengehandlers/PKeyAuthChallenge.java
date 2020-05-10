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
  
  public PKeyAuthChallenge(PKeyAuthChallenge.Builder paramBuilder)
  {
    mNonce = PKeyAuthChallenge.Builder.access$000(paramBuilder);
    mContext = PKeyAuthChallenge.Builder.access$100(paramBuilder);
    mCertAuthorities = PKeyAuthChallenge.Builder.access$200(paramBuilder);
    mThumbprint = PKeyAuthChallenge.Builder.access$300(paramBuilder);
    mVersion = PKeyAuthChallenge.Builder.access$400(paramBuilder);
    mSubmitUrl = PKeyAuthChallenge.Builder.access$500(paramBuilder);
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
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.ui.webview.challengehandlers.PKeyAuthChallenge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */