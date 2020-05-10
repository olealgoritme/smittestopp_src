package com.microsoft.identity.client.claims;

import com.google.gson.Gson;
import e.c.c.e;
import e.c.c.w.t;
import java.util.ArrayList;
import java.util.List;

public class ClaimsRequest
{
  public static final String ACCESS_TOKEN = "access_token";
  public static final String ID_TOKEN = "id_token";
  public static final String USERINFO = "userinfo";
  public List<RequestedClaim> mAccessTokenClaimsRequested = new ArrayList();
  public List<RequestedClaim> mIdTokenClaimsRequested = new ArrayList();
  public List<RequestedClaim> mUserInfoClaimsRequested = new ArrayList();
  
  public static ClaimsRequest deserializeClaimsRequest(String paramString)
  {
    e locale = new e();
    locale.a(ClaimsRequest.class, new ClaimsRequestDeserializer());
    paramString = locale.a().a(paramString, ClaimsRequest.class);
    return (ClaimsRequest)t.a(ClaimsRequest.class).cast(paramString);
  }
  
  public static ClaimsRequest getClaimsRequestFromJsonString(String paramString)
  {
    return deserializeClaimsRequest(paramString);
  }
  
  public static String getJsonStringFromClaimsRequest(ClaimsRequest paramClaimsRequest)
  {
    return serializeClaimsRequest(paramClaimsRequest);
  }
  
  private void requestClaimIn(List<RequestedClaim> paramList, String paramString, RequestedClaimAdditionalInformation paramRequestedClaimAdditionalInformation)
  {
    RequestedClaim localRequestedClaim = new RequestedClaim();
    localRequestedClaim.setName(paramString);
    localRequestedClaim.setAdditionalInformation(paramRequestedClaimAdditionalInformation);
    paramList.add(localRequestedClaim);
  }
  
  public static String serializeClaimsRequest(ClaimsRequest paramClaimsRequest)
  {
    e locale = new e();
    ClaimsRequestSerializer localClaimsRequestSerializer = new ClaimsRequestSerializer();
    Object localObject = new RequestClaimAdditionalInformationSerializer();
    locale.a(ClaimsRequest.class, localClaimsRequestSerializer);
    locale.a(RequestedClaimAdditionalInformation.class, localObject);
    g = true;
    localObject = locale.a();
    if (paramClaimsRequest != null) {
      paramClaimsRequest = ((Gson)localObject).a(paramClaimsRequest);
    } else {
      paramClaimsRequest = null;
    }
    return paramClaimsRequest;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ClaimsRequest)) {
      return false;
    }
    paramObject = (ClaimsRequest)paramObject;
    List localList = mUserInfoClaimsRequested;
    if (localList != null ? !localList.equals(mUserInfoClaimsRequested) : mUserInfoClaimsRequested != null) {
      return false;
    }
    localList = mAccessTokenClaimsRequested;
    if (localList != null ? !localList.equals(mAccessTokenClaimsRequested) : mAccessTokenClaimsRequested != null) {
      return false;
    }
    localList = mIdTokenClaimsRequested;
    paramObject = mIdTokenClaimsRequested;
    if (localList != null) {
      bool = localList.equals(paramObject);
    } else if (paramObject != null) {
      bool = false;
    }
    return bool;
  }
  
  public List<RequestedClaim> getAccessTokenClaimsRequested()
  {
    return mAccessTokenClaimsRequested;
  }
  
  public List<RequestedClaim> getIdTokenClaimsRequested()
  {
    return mIdTokenClaimsRequested;
  }
  
  public List<RequestedClaim> getUserInfoClaimsRequested()
  {
    return mUserInfoClaimsRequested;
  }
  
  public int hashCode()
  {
    List localList = mUserInfoClaimsRequested;
    int i = 0;
    int j;
    if (localList != null) {
      j = localList.hashCode();
    } else {
      j = 0;
    }
    localList = mAccessTokenClaimsRequested;
    int k;
    if (localList != null) {
      k = localList.hashCode();
    } else {
      k = 0;
    }
    localList = mIdTokenClaimsRequested;
    if (localList != null) {
      i = localList.hashCode();
    }
    return (j * 31 + k) * 31 + i;
  }
  
  public void requestClaimInAccessToken(String paramString, RequestedClaimAdditionalInformation paramRequestedClaimAdditionalInformation)
  {
    requestClaimIn(mAccessTokenClaimsRequested, paramString, paramRequestedClaimAdditionalInformation);
  }
  
  public void requestClaimInIdToken(String paramString, RequestedClaimAdditionalInformation paramRequestedClaimAdditionalInformation)
  {
    requestClaimIn(mIdTokenClaimsRequested, paramString, paramRequestedClaimAdditionalInformation);
  }
  
  public void requestClaimInUserInfo(String paramString, RequestedClaimAdditionalInformation paramRequestedClaimAdditionalInformation)
  {
    requestClaimIn(mUserInfoClaimsRequested, paramString, paramRequestedClaimAdditionalInformation);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.claims.ClaimsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */