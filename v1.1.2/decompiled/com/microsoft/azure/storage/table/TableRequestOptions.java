package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.core.Utility;

public class TableRequestOptions
  extends RequestOptions
{
  public Boolean dateBackwardCompatibility;
  public TableEncryptionPolicy encryptionPolicy;
  public EncryptionResolver encryptionResolver;
  public TablePayloadFormat payloadFormat;
  public PropertyResolver propertyResolver;
  
  public TableRequestOptions() {}
  
  public TableRequestOptions(TableRequestOptions paramTableRequestOptions)
  {
    super(paramTableRequestOptions);
    if (paramTableRequestOptions != null)
    {
      setTablePayloadFormat(paramTableRequestOptions.getTablePayloadFormat());
      setPropertyResolver(paramTableRequestOptions.getPropertyResolver());
      setDateBackwardCompatibility(paramTableRequestOptions.getDateBackwardCompatibility());
      setEncryptionPolicy(paramTableRequestOptions.getEncryptionPolicy());
      setEncryptionResolver(paramTableRequestOptions.getEncryptionResolver());
    }
  }
  
  public static void applyDefaults(TableRequestOptions paramTableRequestOptions)
  {
    Utility.assertNotNull("modifiedOptions", paramTableRequestOptions);
    RequestOptions.applyBaseDefaultsInternal(paramTableRequestOptions);
    if (paramTableRequestOptions.getTablePayloadFormat() == null) {
      paramTableRequestOptions.setTablePayloadFormat(TablePayloadFormat.Json);
    }
    if (paramTableRequestOptions.getDateBackwardCompatibility() == null) {
      paramTableRequestOptions.setDateBackwardCompatibility(Boolean.valueOf(false));
    }
  }
  
  public static void populate(TableRequestOptions paramTableRequestOptions1, TableRequestOptions paramTableRequestOptions2)
  {
    RequestOptions.populateRequestOptions(paramTableRequestOptions1, paramTableRequestOptions2, true);
    if (paramTableRequestOptions1.getTablePayloadFormat() == null) {
      paramTableRequestOptions1.setTablePayloadFormat(paramTableRequestOptions2.getTablePayloadFormat());
    }
    if (paramTableRequestOptions1.getPropertyResolver() == null) {
      paramTableRequestOptions1.setPropertyResolver(paramTableRequestOptions2.getPropertyResolver());
    }
    if (paramTableRequestOptions1.getDateBackwardCompatibility() == null) {
      paramTableRequestOptions1.setDateBackwardCompatibility(paramTableRequestOptions2.getDateBackwardCompatibility());
    }
    if (paramTableRequestOptions1.getEncryptionPolicy() == null) {
      paramTableRequestOptions1.setEncryptionPolicy(paramTableRequestOptions2.getEncryptionPolicy());
    }
    if (paramTableRequestOptions1.getEncryptionResolver() == null) {
      paramTableRequestOptions1.setEncryptionResolver(paramTableRequestOptions2.getEncryptionResolver());
    }
  }
  
  public static final TableRequestOptions populateAndApplyDefaults(TableRequestOptions paramTableRequestOptions, CloudTableClient paramCloudTableClient)
  {
    paramTableRequestOptions = new TableRequestOptions(paramTableRequestOptions);
    populate(paramTableRequestOptions, paramCloudTableClient.getDefaultRequestOptions());
    applyDefaults(paramTableRequestOptions);
    return paramTableRequestOptions;
  }
  
  public void assertNoEncryptionPolicyOrStrictMode()
  {
    if (getEncryptionPolicy() == null)
    {
      assertPolicyIfRequired();
      return;
    }
    throw new IllegalArgumentException("Encryption is not supported for the current operation. Please ensure that EncryptionPolicy is not set on RequestOptions.");
  }
  
  public void assertPolicyIfRequired()
  {
    if ((requireEncryption() != null) && (requireEncryption().booleanValue()) && (getEncryptionPolicy() == null)) {
      throw new IllegalArgumentException("Encryption Policy is mandatory when RequireEncryption is set to true. If you do not want to encrypt/decrypt data, please set RequireEncryption to false in request options.");
    }
  }
  
  public void clearEncryption()
  {
    setRequireEncryption(Boolean.valueOf(false));
    setEncryptionPolicy(null);
    setEncryptionResolver(null);
  }
  
  public Boolean getDateBackwardCompatibility()
  {
    return dateBackwardCompatibility;
  }
  
  public TableEncryptionPolicy getEncryptionPolicy()
  {
    return encryptionPolicy;
  }
  
  public EncryptionResolver getEncryptionResolver()
  {
    return encryptionResolver;
  }
  
  public PropertyResolver getPropertyResolver()
  {
    return propertyResolver;
  }
  
  public TablePayloadFormat getTablePayloadFormat()
  {
    return payloadFormat;
  }
  
  public void setDateBackwardCompatibility(Boolean paramBoolean)
  {
    dateBackwardCompatibility = paramBoolean;
  }
  
  public void setEncryptionPolicy(TableEncryptionPolicy paramTableEncryptionPolicy)
  {
    encryptionPolicy = paramTableEncryptionPolicy;
  }
  
  public void setEncryptionResolver(EncryptionResolver paramEncryptionResolver)
  {
    encryptionResolver = paramEncryptionResolver;
  }
  
  public void setPropertyResolver(PropertyResolver paramPropertyResolver)
  {
    propertyResolver = paramPropertyResolver;
  }
  
  public void setTablePayloadFormat(TablePayloadFormat paramTablePayloadFormat)
  {
    payloadFormat = paramTablePayloadFormat;
  }
  
  public static abstract interface EncryptionResolver
  {
    public abstract boolean encryptionResolver(String paramString1, String paramString2, String paramString3);
  }
  
  public static abstract interface PropertyResolver
  {
    public abstract EdmType propertyResolver(String paramString1, String paramString2, String paramString3, String paramString4);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.table.TableRequestOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */