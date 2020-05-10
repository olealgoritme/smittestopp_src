package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.core.Utility;

public final class BlobRequestOptions
  extends RequestOptions
{
  public Boolean absorbConditionalErrorsOnRetry = null;
  public Integer concurrentRequestCount = null;
  public Boolean disableContentMD5Validation = null;
  public BlobEncryptionPolicy encryptionPolicy;
  public Integer singleBlobPutThresholdInBytes = null;
  public boolean skipEtagLocking = false;
  public Boolean storeBlobContentMD5 = null;
  public Boolean useTransactionalContentMD5 = null;
  public boolean validateEncryptionPolicy = true;
  
  public BlobRequestOptions() {}
  
  public BlobRequestOptions(BlobRequestOptions paramBlobRequestOptions)
  {
    super(paramBlobRequestOptions);
    if (paramBlobRequestOptions != null)
    {
      setAbsorbConditionalErrorsOnRetry(paramBlobRequestOptions.getAbsorbConditionalErrorsOnRetry());
      setConcurrentRequestCount(paramBlobRequestOptions.getConcurrentRequestCount());
      setUseTransactionalContentMD5(paramBlobRequestOptions.getUseTransactionalContentMD5());
      setStoreBlobContentMD5(paramBlobRequestOptions.getStoreBlobContentMD5());
      setDisableContentMD5Validation(paramBlobRequestOptions.getDisableContentMD5Validation());
      setSingleBlobPutThresholdInBytes(paramBlobRequestOptions.getSingleBlobPutThresholdInBytes());
      setEncryptionPolicy(paramBlobRequestOptions.getEncryptionPolicy());
      setValidateEncryptionPolicy(paramBlobRequestOptions.getValidateEncryptionPolicy());
      setSkipEtagLocking(paramBlobRequestOptions.getSkipEtagLocking());
    }
  }
  
  public static void applyDefaults(BlobRequestOptions paramBlobRequestOptions, BlobType paramBlobType)
  {
    Utility.assertNotNull("modifiedOptions", paramBlobRequestOptions);
    RequestOptions.applyBaseDefaultsInternal(paramBlobRequestOptions);
    Boolean localBoolean1 = paramBlobRequestOptions.getAbsorbConditionalErrorsOnRetry();
    boolean bool = false;
    Boolean localBoolean2 = Boolean.valueOf(false);
    if (localBoolean1 == null) {
      paramBlobRequestOptions.setAbsorbConditionalErrorsOnRetry(localBoolean2);
    }
    if (paramBlobType == BlobType.APPEND_BLOB) {
      paramBlobRequestOptions.setConcurrentRequestCount(Integer.valueOf(1));
    } else if (paramBlobRequestOptions.getConcurrentRequestCount() == null) {
      paramBlobRequestOptions.setConcurrentRequestCount(Integer.valueOf(1));
    }
    if (paramBlobRequestOptions.getSingleBlobPutThresholdInBytes() == null) {
      paramBlobRequestOptions.setSingleBlobPutThresholdInBytes(Integer.valueOf(134217728));
    }
    if (paramBlobRequestOptions.getUseTransactionalContentMD5() == null) {
      paramBlobRequestOptions.setUseTransactionalContentMD5(localBoolean2);
    }
    if ((paramBlobRequestOptions.getStoreBlobContentMD5() == null) && (paramBlobType != BlobType.UNSPECIFIED))
    {
      if (paramBlobType == BlobType.BLOCK_BLOB) {
        bool = true;
      }
      paramBlobRequestOptions.setStoreBlobContentMD5(Boolean.valueOf(bool));
    }
    if (paramBlobRequestOptions.getDisableContentMD5Validation() == null) {
      paramBlobRequestOptions.setDisableContentMD5Validation(localBoolean2);
    }
  }
  
  public static final BlobRequestOptions populateAndApplyDefaults(BlobRequestOptions paramBlobRequestOptions, BlobType paramBlobType, CloudBlobClient paramCloudBlobClient)
  {
    return populateAndApplyDefaults(paramBlobRequestOptions, paramBlobType, paramCloudBlobClient, true);
  }
  
  public static final BlobRequestOptions populateAndApplyDefaults(BlobRequestOptions paramBlobRequestOptions, BlobType paramBlobType, CloudBlobClient paramCloudBlobClient, boolean paramBoolean)
  {
    paramBlobRequestOptions = new BlobRequestOptions(paramBlobRequestOptions);
    populateRequestOptions(paramBlobRequestOptions, paramCloudBlobClient.getDefaultRequestOptions(), paramBoolean);
    applyDefaults(paramBlobRequestOptions, paramBlobType);
    return paramBlobRequestOptions;
  }
  
  public static void populateRequestOptions(BlobRequestOptions paramBlobRequestOptions1, BlobRequestOptions paramBlobRequestOptions2, boolean paramBoolean)
  {
    RequestOptions.populateRequestOptions(paramBlobRequestOptions1, paramBlobRequestOptions2, paramBoolean);
    if (paramBlobRequestOptions1.getAbsorbConditionalErrorsOnRetry() == null) {
      paramBlobRequestOptions1.setAbsorbConditionalErrorsOnRetry(paramBlobRequestOptions2.getAbsorbConditionalErrorsOnRetry());
    }
    if (paramBlobRequestOptions1.getConcurrentRequestCount() == null) {
      paramBlobRequestOptions1.setConcurrentRequestCount(paramBlobRequestOptions2.getConcurrentRequestCount());
    }
    if (paramBlobRequestOptions1.getSingleBlobPutThresholdInBytes() == null) {
      paramBlobRequestOptions1.setSingleBlobPutThresholdInBytes(paramBlobRequestOptions2.getSingleBlobPutThresholdInBytes());
    }
    if (paramBlobRequestOptions1.getUseTransactionalContentMD5() == null) {
      paramBlobRequestOptions1.setUseTransactionalContentMD5(paramBlobRequestOptions2.getUseTransactionalContentMD5());
    }
    if (paramBlobRequestOptions1.getStoreBlobContentMD5() == null) {
      paramBlobRequestOptions1.setStoreBlobContentMD5(paramBlobRequestOptions2.getStoreBlobContentMD5());
    }
    if (paramBlobRequestOptions1.getDisableContentMD5Validation() == null) {
      paramBlobRequestOptions1.setDisableContentMD5Validation(paramBlobRequestOptions2.getDisableContentMD5Validation());
    }
    if (paramBlobRequestOptions1.getEncryptionPolicy() == null) {
      paramBlobRequestOptions1.setEncryptionPolicy(paramBlobRequestOptions2.getEncryptionPolicy());
    }
  }
  
  public void assertNoEncryptionPolicyOrStrictMode()
  {
    if ((getEncryptionPolicy() != null) && (getValidateEncryptionPolicy())) {
      throw new IllegalArgumentException("Encryption is not supported for the current operation. Please ensure that EncryptionPolicy is not set on RequestOptions.");
    }
    assertPolicyIfRequired();
  }
  
  public void assertPolicyIfRequired()
  {
    if ((requireEncryption() != null) && (requireEncryption().booleanValue()) && (getEncryptionPolicy() == null)) {
      throw new IllegalArgumentException("Encryption Policy is mandatory when RequireEncryption is set to true. If you do not want to encrypt/decrypt data, please set RequireEncryption to false in request options.");
    }
  }
  
  public Boolean getAbsorbConditionalErrorsOnRetry()
  {
    return absorbConditionalErrorsOnRetry;
  }
  
  public Integer getConcurrentRequestCount()
  {
    return concurrentRequestCount;
  }
  
  public Boolean getDisableContentMD5Validation()
  {
    return disableContentMD5Validation;
  }
  
  public BlobEncryptionPolicy getEncryptionPolicy()
  {
    return encryptionPolicy;
  }
  
  public Integer getSingleBlobPutThresholdInBytes()
  {
    return singleBlobPutThresholdInBytes;
  }
  
  public boolean getSkipEtagLocking()
  {
    return skipEtagLocking;
  }
  
  public Boolean getStoreBlobContentMD5()
  {
    return storeBlobContentMD5;
  }
  
  public Boolean getUseTransactionalContentMD5()
  {
    return useTransactionalContentMD5;
  }
  
  public boolean getValidateEncryptionPolicy()
  {
    return validateEncryptionPolicy;
  }
  
  public void setAbsorbConditionalErrorsOnRetry(Boolean paramBoolean)
  {
    absorbConditionalErrorsOnRetry = paramBoolean;
  }
  
  public void setConcurrentRequestCount(Integer paramInteger)
  {
    concurrentRequestCount = paramInteger;
  }
  
  public void setDisableContentMD5Validation(Boolean paramBoolean)
  {
    disableContentMD5Validation = paramBoolean;
  }
  
  public void setEncryptionPolicy(BlobEncryptionPolicy paramBlobEncryptionPolicy)
  {
    encryptionPolicy = paramBlobEncryptionPolicy;
  }
  
  public void setSingleBlobPutThresholdInBytes(Integer paramInteger)
  {
    if ((paramInteger != null) && ((paramInteger.intValue() > 268435456) || (paramInteger.intValue() < 1048576))) {
      throw new IllegalArgumentException(String.format(Utility.LOCALE_US, "The argument is out of range. Argument name: %s, Value passed: %s.", new Object[] { "singleBlobPutThresholdInBytes", paramInteger.toString() }));
    }
    singleBlobPutThresholdInBytes = paramInteger;
  }
  
  public void setSkipEtagLocking(boolean paramBoolean)
  {
    skipEtagLocking = paramBoolean;
  }
  
  public void setStoreBlobContentMD5(Boolean paramBoolean)
  {
    storeBlobContentMD5 = paramBoolean;
  }
  
  public void setUseTransactionalContentMD5(Boolean paramBoolean)
  {
    useTransactionalContentMD5 = paramBoolean;
  }
  
  public void setValidateEncryptionPolicy(boolean paramBoolean)
  {
    validateEncryptionPolicy = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.BlobRequestOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */