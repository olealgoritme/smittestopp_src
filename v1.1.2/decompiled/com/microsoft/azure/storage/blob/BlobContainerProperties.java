package com.microsoft.azure.storage.blob;

import java.util.Date;

public final class BlobContainerProperties
{
  public String etag;
  public Boolean hasImmutabilityPolicy;
  public Boolean hasLegalHold;
  public Date lastModified;
  public LeaseDuration leaseDuration;
  public LeaseState leaseState;
  public LeaseStatus leaseStatus;
  public BlobContainerPublicAccessType publicAccess;
  
  public String getEtag()
  {
    return etag;
  }
  
  public Date getLastModified()
  {
    return lastModified;
  }
  
  public LeaseDuration getLeaseDuration()
  {
    return leaseDuration;
  }
  
  public LeaseState getLeaseState()
  {
    return leaseState;
  }
  
  public LeaseStatus getLeaseStatus()
  {
    return leaseStatus;
  }
  
  public BlobContainerPublicAccessType getPublicAccess()
  {
    return publicAccess;
  }
  
  public Boolean hasImmutabilityPolicy()
  {
    return hasImmutabilityPolicy;
  }
  
  public Boolean hasLegalHold()
  {
    return hasLegalHold;
  }
  
  public void setEtag(String paramString)
  {
    etag = paramString;
  }
  
  public void setHasImmutabilityPolicy(Boolean paramBoolean)
  {
    hasImmutabilityPolicy = paramBoolean;
  }
  
  public void setHasLegalHold(Boolean paramBoolean)
  {
    hasLegalHold = paramBoolean;
  }
  
  public void setLastModified(Date paramDate)
  {
    lastModified = paramDate;
  }
  
  public void setLeaseDuration(LeaseDuration paramLeaseDuration)
  {
    leaseDuration = paramLeaseDuration;
  }
  
  public void setLeaseState(LeaseState paramLeaseState)
  {
    leaseState = paramLeaseState;
  }
  
  public void setLeaseStatus(LeaseStatus paramLeaseStatus)
  {
    leaseStatus = paramLeaseStatus;
  }
  
  public void setPublicAccess(BlobContainerPublicAccessType paramBlobContainerPublicAccessType)
  {
    publicAccess = paramBlobContainerPublicAccessType;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.BlobContainerProperties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */