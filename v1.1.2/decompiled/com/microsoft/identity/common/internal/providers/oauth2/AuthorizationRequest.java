package com.microsoft.identity.common.internal.providers.oauth2;

import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Pair;
import com.microsoft.identity.common.internal.net.ObjectMapper;
import e.c.c.v.c;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public abstract class AuthorizationRequest<T extends AuthorizationRequest<T>>
  implements Serializable
{
  public static final long serialVersionUID = 6171895895590170062L;
  @e.c.c.v.a
  @c("claims")
  public String mClaims;
  @e.c.c.v.a
  @c("client_id")
  public String mClientId;
  public transient List<Pair<String, String>> mExtraQueryParams;
  @c("redirect_uri")
  public String mRedirectUri;
  public transient HashMap<String, String> mRequestHeaders;
  @e.c.c.v.a
  @c("response_type")
  public String mResponseType;
  @e.c.c.v.a
  @c("scope")
  public String mScope;
  @e.c.c.v.a
  @c("state")
  public String mState;
  @e.c.c.v.a
  @c("web_view_zoom_controls_enabled")
  public boolean webViewZoomControlsEnabled;
  @e.c.c.v.a
  @c("web_view_zoom_enabled")
  public boolean webViewZoomEnabled;
  
  public AuthorizationRequest(Builder paramBuilder)
  {
    mResponseType = Builder.access$000(paramBuilder);
    mClientId = Builder.access$100(paramBuilder);
    mRedirectUri = Builder.access$200(paramBuilder);
    mState = Builder.access$300(paramBuilder);
    mScope = Builder.access$400(paramBuilder);
    mExtraQueryParams = mExtraQueryParams;
    mClaims = Builder.access$500(paramBuilder);
    mRequestHeaders = Builder.access$600(paramBuilder);
    webViewZoomEnabled = Builder.access$700(paramBuilder);
    webViewZoomControlsEnabled = Builder.access$800(paramBuilder);
  }
  
  public abstract String getAuthorizationEndpoint();
  
  public Uri getAuthorizationRequestAsHttpRequest()
  {
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).putAll(ObjectMapper.serializeObjectHashMap(this));
    Object localObject2 = mExtraQueryParams;
    Object localObject3;
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      localObject2 = mExtraQueryParams.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Pair)((Iterator)localObject2).next();
        if (!((HashMap)localObject1).containsKey(first)) {
          ((HashMap)localObject1).put(first, second);
        }
      }
    }
    localObject2 = Uri.parse(getAuthorizationEndpoint()).buildUpon();
    localObject1 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject1).next();
      if ((((Map.Entry)localObject3).getKey() != null) && (((Map.Entry)localObject3).getValue() != null)) {
        ((Uri.Builder)localObject2).appendQueryParameter((String)((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue().toString());
      }
    }
    return ((Uri.Builder)localObject2).build();
  }
  
  public String getClaims()
  {
    return mClaims;
  }
  
  public String getClientId()
  {
    return mClientId;
  }
  
  public List<Pair<String, String>> getExtraQueryParams()
  {
    return mExtraQueryParams;
  }
  
  public String getRedirectUri()
  {
    return mRedirectUri;
  }
  
  public HashMap<String, String> getRequestHeaders()
  {
    return mRequestHeaders;
  }
  
  public String getResponseType()
  {
    return mResponseType;
  }
  
  public String getScope()
  {
    return mScope;
  }
  
  public String getState()
  {
    return mState;
  }
  
  public boolean isWebViewZoomControlsEnabled()
  {
    return webViewZoomControlsEnabled;
  }
  
  public boolean isWebViewZoomEnabled()
  {
    return webViewZoomEnabled;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("AuthorizationRequest{mResponseType='");
    e.a.a.a.a.a(localStringBuilder, mResponseType, '\'', ", mClientId='");
    e.a.a.a.a.a(localStringBuilder, mClientId, '\'', ", mRedirectUri='");
    e.a.a.a.a.a(localStringBuilder, mRedirectUri, '\'', ", mScope='");
    e.a.a.a.a.a(localStringBuilder, mScope, '\'', ", mState='");
    localStringBuilder.append(mState);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static abstract class Builder<B extends Builder<B>>
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
  
  public static final class ResponseType
  {
    public static final String CODE = "code";
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */