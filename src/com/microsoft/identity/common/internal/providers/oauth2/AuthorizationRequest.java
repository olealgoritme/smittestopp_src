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
  
  public AuthorizationRequest(AuthorizationRequest.Builder paramBuilder)
  {
    mResponseType = AuthorizationRequest.Builder.access$000(paramBuilder);
    mClientId = AuthorizationRequest.Builder.access$100(paramBuilder);
    mRedirectUri = AuthorizationRequest.Builder.access$200(paramBuilder);
    mState = AuthorizationRequest.Builder.access$300(paramBuilder);
    mScope = AuthorizationRequest.Builder.access$400(paramBuilder);
    mExtraQueryParams = mExtraQueryParams;
    mClaims = AuthorizationRequest.Builder.access$500(paramBuilder);
    mRequestHeaders = AuthorizationRequest.Builder.access$600(paramBuilder);
    webViewZoomEnabled = AuthorizationRequest.Builder.access$700(paramBuilder);
    webViewZoomControlsEnabled = AuthorizationRequest.Builder.access$800(paramBuilder);
  }
  
  public abstract String getAuthorizationEndpoint();
  
  public Uri getAuthorizationRequestAsHttpRequest()
  {
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).putAll(ObjectMapper.serializeObjectHashMap(this));
    Object localObject2 = mExtraQueryParams;
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
    Object localObject3 = ((HashMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (Map.Entry)((Iterator)localObject3).next();
      if ((((Map.Entry)localObject1).getKey() != null) && (((Map.Entry)localObject1).getValue() != null)) {
        ((Uri.Builder)localObject2).appendQueryParameter((String)((Map.Entry)localObject1).getKey(), ((Map.Entry)localObject1).getValue().toString());
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
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */