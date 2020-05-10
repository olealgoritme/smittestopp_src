package com.microsoft.identity.common.internal.providers.microsoft.microsoftsts;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Pair;
import com.microsoft.identity.common.internal.net.ObjectMapper;
import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationRequest;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectorySlice;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationRequest.Builder;
import e.c.c.v.a;
import e.c.c.v.c;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MicrosoftStsAuthorizationRequest
  extends MicrosoftAuthorizationRequest<MicrosoftStsAuthorizationRequest>
{
  public static final String AUTHORIZATION_ENDPOINT = "/oAuth2/v2.0/authorize";
  public static final long serialVersionUID = 6545759826515911472L;
  public transient String mDisplayableId;
  @a
  @c("prompt")
  public String mPrompt;
  public transient String mTokenScope;
  @c("login_req")
  public String mUid;
  @c("domain_req")
  public String mUtid;
  
  public MicrosoftStsAuthorizationRequest(MicrosoftStsAuthorizationRequest.Builder paramBuilder)
  {
    super(paramBuilder);
    mPrompt = mPrompt;
    mUid = MicrosoftStsAuthorizationRequest.Builder.access$000(paramBuilder);
    mUtid = MicrosoftStsAuthorizationRequest.Builder.access$100(paramBuilder);
    mDisplayableId = MicrosoftStsAuthorizationRequest.Builder.access$200(paramBuilder);
    mTokenScope = MicrosoftStsAuthorizationRequest.Builder.access$300(paramBuilder);
  }
  
  public String getAuthorizationEndpoint()
  {
    return Uri.parse(getAuthority().toString()).buildUpon().appendPath("/oAuth2/v2.0/authorize").build().toString();
  }
  
  public Uri getAuthorizationRequestAsHttpRequest()
  {
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).putAll(ObjectMapper.serializeObjectHashMap(this));
    Object localObject2 = mFlightParameters.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((HashMap)localObject1).put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
    }
    localObject2 = mSlice;
    if (localObject2 != null)
    {
      if (!TextUtils.isEmpty(((AzureActiveDirectorySlice)localObject2).getSlice())) {
        ((HashMap)localObject1).put("slice", mSlice.getSlice());
      }
      if (!TextUtils.isEmpty(mSlice.getDC())) {
        ((HashMap)localObject1).put("dc", mSlice.getDC());
      }
    }
    if ((getExtraQueryParams() != null) && (!getExtraQueryParams().isEmpty()))
    {
      localObject2 = getExtraQueryParams().iterator();
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
  
  public String getDisplayableId()
  {
    return mDisplayableId;
  }
  
  public String getPrompt()
  {
    return mPrompt;
  }
  
  public String getTokenScope()
  {
    return mTokenScope;
  }
  
  public String getUid()
  {
    return mUid;
  }
  
  public String getUtid()
  {
    return mUtid;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */