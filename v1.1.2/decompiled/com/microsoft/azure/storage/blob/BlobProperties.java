package com.microsoft.azure.storage.blob;

import java.util.Date;

public final class BlobProperties
{
  public Integer appendBlobCommittedBlockCount;
  public BlobType blobType = BlobType.UNSPECIFIED;
  public String cacheControl;
  public String contentDisposition;
  public String contentEncoding;
  public String contentLanguage;
  public String contentMD5;
  public String contentType;
  public CopyState copyState;
  public Date createdTime;
  public Date deletedTime;
  public String etag;
  public Boolean isBlobTierInferredTier;
  public boolean isIncrementalCopy;
  public Date lastModified;
  public LeaseDuration leaseDuration;
  public LeaseState leaseState;
  public LeaseStatus leaseStatus = LeaseStatus.UNLOCKED;
  public long length;
  public Long pageBlobSequenceNumber;
  public PremiumPageBlobTier premiumPageBlobTier;
  public RehydrationStatus rehydrationStatus;
  public Integer remainingRetentionDays;
  public boolean serverEncrypted;
  public StandardBlobTier standardBlobTier;
  public Date tierChangeTime;
  
  public BlobProperties() {}
  
  public BlobProperties(BlobProperties paramBlobProperties)
  {
    appendBlobCommittedBlockCount = appendBlobCommittedBlockCount;
    blobType = blobType;
    cacheControl = cacheControl;
    contentDisposition = contentDisposition;
    contentEncoding = contentEncoding;
    contentLanguage = contentLanguage;
    contentMD5 = contentMD5;
    contentType = contentType;
    copyState = copyState;
    createdTime = createdTime;
    etag = etag;
    isBlobTierInferredTier = isBlobTierInferredTier;
    isIncrementalCopy = isIncrementalCopy;
    leaseStatus = leaseStatus;
    leaseState = leaseState;
    leaseDuration = leaseDuration;
    length = length;
    lastModified = lastModified;
    pageBlobSequenceNumber = pageBlobSequenceNumber;
    premiumPageBlobTier = premiumPageBlobTier;
    serverEncrypted = serverEncrypted;
    standardBlobTier = standardBlobTier;
    rehydrationStatus = rehydrationStatus;
    tierChangeTime = tierChangeTime;
    deletedTime = deletedTime;
    remainingRetentionDays = remainingRetentionDays;
  }
  
  public BlobProperties(BlobType paramBlobType)
  {
    blobType = paramBlobType;
  }
  
  public Integer getAppendBlobCommittedBlockCount()
  {
    return appendBlobCommittedBlockCount;
  }
  
  public BlobType getBlobType()
  {
    return blobType;
  }
  
  public String getCacheControl()
  {
    return cacheControl;
  }
  
  public String getContentDisposition()
  {
    return contentDisposition;
  }
  
  public String getContentEncoding()
  {
    return contentEncoding;
  }
  
  public String getContentLanguage()
  {
    return contentLanguage;
  }
  
  public String getContentMD5()
  {
    return contentMD5;
  }
  
  public String getContentType()
  {
    return contentType;
  }
  
  public CopyState getCopyState()
  {
    return copyState;
  }
  
  public Date getCreatedTime()
  {
    return createdTime;
  }
  
  public Date getDeletedTime()
  {
    return deletedTime;
  }
  
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
  
  public long getLength()
  {
    return length;
  }
  
  public Long getPageBlobSequenceNumber()
  {
    return pageBlobSequenceNumber;
  }
  
  public PremiumPageBlobTier getPremiumPageBlobTier()
  {
    return premiumPageBlobTier;
  }
  
  public RehydrationStatus getRehydrationStatus()
  {
    return rehydrationStatus;
  }
  
  public Integer getRemainingRetentionDays()
  {
    return remainingRetentionDays;
  }
  
  public StandardBlobTier getStandardBlobTier()
  {
    return standardBlobTier;
  }
  
  public Date getTierChangeTime()
  {
    return tierChangeTime;
  }
  
  public Boolean isBlobTierInferred()
  {
    return isBlobTierInferredTier;
  }
  
  public boolean isIncrementalCopy()
  {
    return isIncrementalCopy;
  }
  
  public boolean isServerEncrypted()
  {
    return serverEncrypted;
  }
  
  public void setAppendBlobCommittedBlockCount(Integer paramInteger)
  {
    appendBlobCommittedBlockCount = paramInteger;
  }
  
  public void setBlobTierInferred(Boolean paramBoolean)
  {
    isBlobTierInferredTier = paramBoolean;
  }
  
  public void setBlobType(BlobType paramBlobType)
  {
    blobType = paramBlobType;
  }
  
  public void setCacheControl(String paramString)
  {
    cacheControl = paramString;
  }
  
  public void setContentDisposition(String paramString)
  {
    contentDisposition = paramString;
  }
  
  public void setContentEncoding(String paramString)
  {
    contentEncoding = paramString;
  }
  
  public void setContentLanguage(String paramString)
  {
    contentLanguage = paramString;
  }
  
  public void setContentMD5(String paramString)
  {
    contentMD5 = paramString;
  }
  
  public void setContentType(String paramString)
  {
    contentType = paramString;
  }
  
  public void setCopyState(CopyState paramCopyState)
  {
    copyState = paramCopyState;
  }
  
  public void setCreatedTime(Date paramDate)
  {
    createdTime = paramDate;
  }
  
  public void setDeletedTime(Date paramDate)
  {
    deletedTime = paramDate;
  }
  
  public void setEtag(String paramString)
  {
    etag = paramString;
  }
  
  public void setIncrementalCopy(boolean paramBoolean)
  {
    isIncrementalCopy = paramBoolean;
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
  
  public void setLength(long paramLong)
  {
    length = paramLong;
  }
  
  public void setPageBlobSequenceNumber(Long paramLong)
  {
    pageBlobSequenceNumber = paramLong;
  }
  
  public void setPremiumPageBlobTier(PremiumPageBlobTier paramPremiumPageBlobTier)
  {
    premiumPageBlobTier = paramPremiumPageBlobTier;
  }
  
  public void setRehydrationStatus(RehydrationStatus paramRehydrationStatus)
  {
    rehydrationStatus = paramRehydrationStatus;
  }
  
  public void setRemainingRetentionDays(Integer paramInteger)
  {
    remainingRetentionDays = paramInteger;
  }
  
  public void setServerEncrypted(boolean paramBoolean)
  {
    serverEncrypted = paramBoolean;
  }
  
  public void setStandardBlobTier(StandardBlobTier paramStandardBlobTier)
  {
    standardBlobTier = paramStandardBlobTier;
  }
  
  public void setTierChangeTime(Date paramDate)
  {
    tierChangeTime = paramDate;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.BlobProperties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */