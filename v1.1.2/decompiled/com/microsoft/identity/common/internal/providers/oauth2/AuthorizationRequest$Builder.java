package com.microsoft.identity.common.internal.providers.oauth2;

import android.util.Pair;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public abstract class AuthorizationRequest$Builder<B extends Builder<B>>
{
  public String mClaims;
  public String mClientId;
  public UUID mCorrelationId;
  public List<Pair<String, String>> mExtraQueryParams;
  public String mLoginHint;
  public String mPrompt;
  public String mRedirectUri;
  public HashMap<String, String> mRequestHeaders;
  public String mResponseType = "code";
  public String mScope;
  public String mState;
  public boolean webViewZoomControlsEnabled;
  public boolean webViewZoomEnabled;
  
  public abstract AuthorizationRequest build();
  
  public abstract B self();
  
  public B setClaims(String paramString)
  {
    mClaims = paramString;
    return self();
  }
  
  public B setClientId(String paramString)
  {
    mClientId = paramString;
    return self();
  }
  
  public B setCorrelationId(UUID paramUUID)
  {
    mCorrelationId = paramUUID;
    return self();
  }
  
  public B setExtraQueryParams(List<Pair<String, String>> paramList)
  {
    mExtraQueryParams = paramList;
    return self();
  }
  
  public B setLoginHint(String paramString)
  {
    mLoginHint = paramString;
    return self();
  }
  
  public B setPrompt(String paramString)
  {
    mPrompt = paramString;
    return self();
  }
  
  public B setRedirectUri(String paramString)
  {
    mRedirectUri = paramString;
    return self();
  }
  
  public B setRequestHeaders(HashMap<String, String> paramHashMap)
  {
    mRequestHeaders = paramHashMap;
    return self();
  }
  
  public B setResponseType(String paramString)
  {
    mResponseType = paramString;
    return self();
  }
  
  public B setScope(String paramString)
  {
    mScope = paramString;
    return self();
  }
  
  public B setState(String paramString)
  {
    mState = paramString;
    return self();
  }
  
  public Builder<B> setWebViewZoomControlsEnabled(boolean paramBoolean)
  {
    webViewZoomControlsEnabled = paramBoolean;
    return self();
  }
  
  public Builder<B> setWebViewZoomEnabled(boolean paramBoolean)
  {
    webViewZoomEnabled = paramBoolean;
    return self();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */