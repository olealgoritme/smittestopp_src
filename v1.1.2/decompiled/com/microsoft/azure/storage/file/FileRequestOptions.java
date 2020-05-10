package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.LocationMode;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.core.Utility;

public final class FileRequestOptions
  extends RequestOptions
{
  public Integer concurrentRequestCount = null;
  public Boolean disableContentMD5Validation = null;
  public Boolean storeFileContentMD5 = null;
  public Boolean useTransactionalContentMD5 = null;
  
  public FileRequestOptions() {}
  
  public FileRequestOptions(FileRequestOptions paramFileRequestOptions)
  {
    super(paramFileRequestOptions);
    if (paramFileRequestOptions != null)
    {
      setConcurrentRequestCount(paramFileRequestOptions.getConcurrentRequestCount());
      setDisableContentMD5Validation(paramFileRequestOptions.getDisableContentMD5Validation());
      setStoreFileContentMD5(paramFileRequestOptions.getStoreFileContentMD5());
      setUseTransactionalContentMD5(paramFileRequestOptions.getUseTransactionalContentMD5());
    }
  }
  
  public static void applyDefaults(FileRequestOptions paramFileRequestOptions)
  {
    Utility.assertNotNull("modifiedOptions", paramFileRequestOptions);
    RequestOptions.applyBaseDefaultsInternal(paramFileRequestOptions);
    if (paramFileRequestOptions.getConcurrentRequestCount() == null) {
      paramFileRequestOptions.setConcurrentRequestCount(Integer.valueOf(1));
    }
    if (paramFileRequestOptions.getUseTransactionalContentMD5() == null) {
      paramFileRequestOptions.setUseTransactionalContentMD5(Boolean.valueOf(false));
    }
    if (paramFileRequestOptions.getStoreFileContentMD5() == null) {
      paramFileRequestOptions.setStoreFileContentMD5(Boolean.valueOf(false));
    }
    if (paramFileRequestOptions.getDisableContentMD5Validation() == null) {
      paramFileRequestOptions.setDisableContentMD5Validation(Boolean.valueOf(false));
    }
  }
  
  public static final FileRequestOptions populateAndApplyDefaults(FileRequestOptions paramFileRequestOptions, CloudFileClient paramCloudFileClient)
  {
    return populateAndApplyDefaults(paramFileRequestOptions, paramCloudFileClient, true);
  }
  
  public static final FileRequestOptions populateAndApplyDefaults(FileRequestOptions paramFileRequestOptions, CloudFileClient paramCloudFileClient, boolean paramBoolean)
  {
    paramFileRequestOptions = new FileRequestOptions(paramFileRequestOptions);
    populateRequestOptions(paramFileRequestOptions, paramCloudFileClient.getDefaultRequestOptions(), paramBoolean);
    applyDefaults(paramFileRequestOptions);
    return paramFileRequestOptions;
  }
  
  public static void populateRequestOptions(FileRequestOptions paramFileRequestOptions1, FileRequestOptions paramFileRequestOptions2, boolean paramBoolean)
  {
    RequestOptions.populateRequestOptions(paramFileRequestOptions1, paramFileRequestOptions2, paramBoolean);
    if (paramFileRequestOptions1.getConcurrentRequestCount() == null) {
      paramFileRequestOptions1.setConcurrentRequestCount(paramFileRequestOptions2.getConcurrentRequestCount());
    }
  }
  
  public Integer getConcurrentRequestCount()
  {
    return concurrentRequestCount;
  }
  
  public Boolean getDisableContentMD5Validation()
  {
    return disableContentMD5Validation;
  }
  
  public Boolean getStoreFileContentMD5()
  {
    return storeFileContentMD5;
  }
  
  public Boolean getUseTransactionalContentMD5()
  {
    return useTransactionalContentMD5;
  }
  
  public void setConcurrentRequestCount(Integer paramInteger)
  {
    concurrentRequestCount = paramInteger;
  }
  
  public void setDisableContentMD5Validation(Boolean paramBoolean)
  {
    disableContentMD5Validation = paramBoolean;
  }
  
  public final void setLocationMode(LocationMode paramLocationMode)
  {
    if ((paramLocationMode != null) && (!paramLocationMode.equals(LocationMode.PRIMARY_ONLY))) {
      throw new UnsupportedOperationException("This operation can only be executed against the primary storage location.");
    }
    super.setLocationMode(paramLocationMode);
  }
  
  public void setRequireEncryption(Boolean paramBoolean)
  {
    if ((paramBoolean != null) && (paramBoolean.booleanValue() == true)) {
      throw new UnsupportedOperationException("Encryption is not supported for files.");
    }
  }
  
  public void setStoreFileContentMD5(Boolean paramBoolean)
  {
    storeFileContentMD5 = paramBoolean;
  }
  
  public void setUseTransactionalContentMD5(Boolean paramBoolean)
  {
    useTransactionalContentMD5 = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.file.FileRequestOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */