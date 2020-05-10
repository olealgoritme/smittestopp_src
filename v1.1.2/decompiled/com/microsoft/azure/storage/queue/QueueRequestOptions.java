package com.microsoft.azure.storage.queue;

import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.core.Utility;

public final class QueueRequestOptions
  extends RequestOptions
{
  public QueueEncryptionPolicy encryptionPolicy;
  
  public QueueRequestOptions() {}
  
  public QueueRequestOptions(QueueRequestOptions paramQueueRequestOptions)
  {
    super(paramQueueRequestOptions);
    if (paramQueueRequestOptions != null) {
      setEncryptionPolicy(paramQueueRequestOptions.getEncryptionPolicy());
    }
  }
  
  public static void applyDefaults(QueueRequestOptions paramQueueRequestOptions)
  {
    Utility.assertNotNull("modifiedOptions", paramQueueRequestOptions);
    RequestOptions.applyBaseDefaultsInternal(paramQueueRequestOptions);
  }
  
  public static final QueueRequestOptions populateAndApplyDefaults(QueueRequestOptions paramQueueRequestOptions, CloudQueueClient paramCloudQueueClient)
  {
    paramQueueRequestOptions = new QueueRequestOptions(paramQueueRequestOptions);
    populateRequestOptions(paramQueueRequestOptions, paramCloudQueueClient.getDefaultRequestOptions());
    applyDefaults(paramQueueRequestOptions);
    return paramQueueRequestOptions;
  }
  
  public static void populateRequestOptions(QueueRequestOptions paramQueueRequestOptions1, QueueRequestOptions paramQueueRequestOptions2)
  {
    RequestOptions.populateRequestOptions(paramQueueRequestOptions1, paramQueueRequestOptions2, true);
    if (paramQueueRequestOptions1.getEncryptionPolicy() == null) {
      paramQueueRequestOptions1.setEncryptionPolicy(paramQueueRequestOptions2.getEncryptionPolicy());
    }
  }
  
  public void assertPolicyIfRequired()
  {
    if ((requireEncryption() != null) && (requireEncryption().booleanValue()) && (getEncryptionPolicy() == null)) {
      throw new IllegalArgumentException("Encryption Policy is mandatory when RequireEncryption is set to true. If you do not want to encrypt/decrypt data, please set RequireEncryption to false in request options.");
    }
  }
  
  public QueueEncryptionPolicy getEncryptionPolicy()
  {
    return encryptionPolicy;
  }
  
  public void setEncryptionPolicy(QueueEncryptionPolicy paramQueueEncryptionPolicy)
  {
    encryptionPolicy = paramQueueEncryptionPolicy;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.queue.QueueRequestOptions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */