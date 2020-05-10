package com.microsoft.identity.client.claims;

public class RequestedClaim
{
  public RequestedClaimAdditionalInformation mInformation;
  public String mName;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof RequestedClaim)) {
      return false;
    }
    Object localObject = (RequestedClaim)paramObject;
    if (!mName.equals(mName)) {
      return false;
    }
    paramObject = mInformation;
    localObject = mInformation;
    if (paramObject != null) {
      bool = ((RequestedClaimAdditionalInformation)paramObject).equals(localObject);
    } else if (localObject != null) {
      bool = false;
    }
    return bool;
  }
  
  public RequestedClaimAdditionalInformation getAdditionalInformation()
  {
    return mInformation;
  }
  
  public String getName()
  {
    return mName;
  }
  
  public int hashCode()
  {
    int i = mName.hashCode();
    RequestedClaimAdditionalInformation localRequestedClaimAdditionalInformation = mInformation;
    int j;
    if (localRequestedClaimAdditionalInformation != null) {
      j = localRequestedClaimAdditionalInformation.hashCode();
    } else {
      j = 0;
    }
    return i * 31 + j;
  }
  
  public void setAdditionalInformation(RequestedClaimAdditionalInformation paramRequestedClaimAdditionalInformation)
  {
    mInformation = paramRequestedClaimAdditionalInformation;
  }
  
  public void setName(String paramString)
  {
    mName = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.claims.RequestedClaim
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */