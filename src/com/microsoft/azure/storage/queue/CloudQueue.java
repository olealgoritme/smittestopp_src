package com.microsoft.azure.storage.queue;

import com.microsoft.azure.storage.DoesServiceRequest;
import com.microsoft.azure.storage.IPRange;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.Permissions;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.ServiceClient;
import com.microsoft.azure.storage.SharedAccessPolicySerializer;
import com.microsoft.azure.storage.SharedAccessProtocols;
import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.ExecutionEngine;
import com.microsoft.azure.storage.core.PathUtility;
import com.microsoft.azure.storage.core.SharedAccessSignatureHelper;
import com.microsoft.azure.storage.core.StorageCredentialsHelper;
import com.microsoft.azure.storage.core.StorageRequest;
import com.microsoft.azure.storage.core.UriQueryBuilder;
import com.microsoft.azure.storage.core.Utility;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import javax.xml.stream.XMLStreamException;

public final class CloudQueue
{
  public long approximateMessageCount;
  public StorageUri messageRequestAddress;
  public HashMap<String, String> metadata;
  public String name;
  public CloudQueueClient queueServiceClient;
  public boolean shouldEncodeMessage;
  public StorageUri storageUri;
  
  public CloudQueue(StorageUri paramStorageUri)
  {
    this(paramStorageUri, null);
  }
  
  public CloudQueue(StorageUri paramStorageUri, StorageCredentials paramStorageCredentials)
  {
    shouldEncodeMessage = true;
    parseQueryAndVerify(paramStorageUri, paramStorageCredentials);
  }
  
  public CloudQueue(String paramString, CloudQueueClient paramCloudQueueClient)
  {
    Utility.assertNotNull("client", paramCloudQueueClient);
    Utility.assertNotNull("queueName", paramString);
    storageUri = PathUtility.appendPathToUri(paramCloudQueueClient.getStorageUri(), paramString);
    name = paramString;
    queueServiceClient = paramCloudQueueClient;
    shouldEncodeMessage = true;
  }
  
  public CloudQueue(URI paramURI)
  {
    this(new StorageUri(paramURI, null));
  }
  
  public CloudQueue(URI paramURI, StorageCredentials paramStorageCredentials)
  {
    this(new StorageUri(paramURI), paramStorageCredentials);
  }
  
  private StorageRequest<CloudQueueClient, CloudQueue, Void> addMessageImpl(CloudQueueMessage paramCloudQueueMessage, int paramInt1, int paramInt2, QueueRequestOptions paramQueueRequestOptions)
  {
    Object localObject = paramCloudQueueMessage.getMessageContentForTransfer(shouldEncodeMessage, paramQueueRequestOptions);
    try
    {
      localObject = QueueMessageSerializer.generateMessageRequestBody((String)localObject);
      paramCloudQueueMessage = new CloudQueue.1(this, paramQueueRequestOptions, getStorageUri(), (byte[])localObject, paramQueueRequestOptions, paramInt2, paramInt1, paramCloudQueueMessage);
      return paramCloudQueueMessage;
    }
    catch (XMLStreamException paramCloudQueueMessage)
    {
      throw StorageException.translateClientException(paramCloudQueueMessage);
    }
  }
  
  private StorageRequest<CloudQueueClient, CloudQueue, Void> clearImpl(QueueRequestOptions paramQueueRequestOptions)
  {
    return new CloudQueue.2(this, paramQueueRequestOptions, getStorageUri(), paramQueueRequestOptions);
  }
  
  private StorageRequest<CloudQueueClient, CloudQueue, Void> createImpl(QueueRequestOptions paramQueueRequestOptions)
  {
    return new CloudQueue.3(this, paramQueueRequestOptions, getStorageUri(), paramQueueRequestOptions);
  }
  
  private StorageRequest<CloudQueueClient, CloudQueue, Void> deleteImpl(QueueRequestOptions paramQueueRequestOptions)
  {
    return new CloudQueue.4(this, paramQueueRequestOptions, getStorageUri(), paramQueueRequestOptions);
  }
  
  private StorageRequest<CloudQueueClient, CloudQueue, Void> deleteMessageImpl(CloudQueueMessage paramCloudQueueMessage, QueueRequestOptions paramQueueRequestOptions)
  {
    String str = paramCloudQueueMessage.getId();
    paramCloudQueueMessage = paramCloudQueueMessage.getPopReceipt();
    return new CloudQueue.5(this, paramQueueRequestOptions, getStorageUri(), str, paramQueueRequestOptions, paramCloudQueueMessage);
  }
  
  private StorageRequest<CloudQueueClient, CloudQueue, Void> downloadAttributesImpl(QueueRequestOptions paramQueueRequestOptions)
  {
    return new CloudQueue.6(this, paramQueueRequestOptions, getStorageUri(), paramQueueRequestOptions);
  }
  
  private StorageRequest<CloudQueueClient, CloudQueue, QueuePermissions> downloadPermissionsImpl(QueueRequestOptions paramQueueRequestOptions)
  {
    return new CloudQueue.13(this, paramQueueRequestOptions, getStorageUri(), paramQueueRequestOptions);
  }
  
  @DoesServiceRequest
  private boolean exists(boolean paramBoolean, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramQueueRequestOptions = QueueRequestOptions.populateAndApplyDefaults(paramQueueRequestOptions, queueServiceClient);
    return ((Boolean)ExecutionEngine.executeWithRetry(queueServiceClient, this, existsImpl(paramBoolean, paramQueueRequestOptions), paramQueueRequestOptions.getRetryPolicyFactory(), localOperationContext)).booleanValue();
  }
  
  private StorageRequest<CloudQueueClient, CloudQueue, Boolean> existsImpl(boolean paramBoolean, QueueRequestOptions paramQueueRequestOptions)
  {
    return new CloudQueue.7(this, paramQueueRequestOptions, getStorageUri(), paramBoolean, paramQueueRequestOptions);
  }
  
  public static CloudQueueMessage getFirstOrNull(Iterable<CloudQueueMessage> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    if (paramIterable.hasNext()) {
      return (CloudQueueMessage)paramIterable.next();
    }
    return null;
  }
  
  private StorageUri getIndividualMessageAddress(String paramString, OperationContext paramOperationContext)
  {
    return PathUtility.appendPathToUri(getMessageRequestAddress(paramOperationContext), paramString);
  }
  
  private StorageUri getMessageRequestAddress(OperationContext paramOperationContext)
  {
    if (messageRequestAddress == null) {
      messageRequestAddress = PathUtility.appendPathToUri(getTransformedAddress(paramOperationContext), "messages");
    }
    return messageRequestAddress;
  }
  
  private String getSharedAccessCanonicalName()
  {
    return String.format("/%s/%s/%s", new Object[] { "queue", getServiceClient().getCredentials().getAccountName(), getName() });
  }
  
  private final StorageUri getTransformedAddress(OperationContext paramOperationContext)
  {
    return queueServiceClient.getCredentials().transformUri(getStorageUri(), paramOperationContext);
  }
  
  private void parseQueryAndVerify(StorageUri paramStorageUri, StorageCredentials paramStorageCredentials)
  {
    Utility.assertNotNull("completeUri", paramStorageUri);
    if (paramStorageUri.isAbsolute())
    {
      storageUri = PathUtility.stripURIQueryAndFragment(paramStorageUri);
      paramStorageUri = SharedAccessSignatureHelper.parseQuery(paramStorageUri);
      if ((paramStorageCredentials != null) && (paramStorageUri != null)) {
        throw new IllegalArgumentException("Cannot provide credentials as part of the address and as constructor parameter. Either pass in the address or use a different constructor.");
      }
      try
      {
        boolean bool = Utility.determinePathStyleFromUri(storageUri.getPrimaryUri());
        CloudQueueClient localCloudQueueClient = new com/microsoft/azure/storage/queue/CloudQueueClient;
        StorageUri localStorageUri = PathUtility.getServiceClientBaseAddress(getStorageUri(), bool);
        if (paramStorageCredentials != null) {
          paramStorageUri = paramStorageCredentials;
        }
        localCloudQueueClient.<init>(localStorageUri, paramStorageUri);
        queueServiceClient = localCloudQueueClient;
        name = PathUtility.getContainerNameFromUri(storageUri.getPrimaryUri(), bool);
        return;
      }
      catch (URISyntaxException paramStorageUri)
      {
        throw Utility.generateNewUnexpectedStorageException(paramStorageUri);
      }
    }
    throw new IllegalArgumentException(String.format("Address %s is a relative address. Only absolute addresses are permitted.", new Object[] { paramStorageUri.toString() }));
  }
  
  private StorageRequest<CloudQueueClient, CloudQueue, ArrayList<CloudQueueMessage>> peekMessagesImpl(int paramInt, QueueRequestOptions paramQueueRequestOptions)
  {
    return new CloudQueue.8(this, paramQueueRequestOptions, getStorageUri(), paramQueueRequestOptions, paramInt);
  }
  
  private StorageRequest<CloudQueueClient, CloudQueue, ArrayList<CloudQueueMessage>> retrieveMessagesImpl(int paramInt1, int paramInt2, QueueRequestOptions paramQueueRequestOptions)
  {
    return new CloudQueue.9(this, paramQueueRequestOptions, getStorageUri(), paramQueueRequestOptions, paramInt1, paramInt2);
  }
  
  private StorageRequest<CloudQueueClient, CloudQueue, Void> updateMessageImpl(CloudQueueMessage paramCloudQueueMessage, int paramInt, EnumSet<MessageUpdateFields> paramEnumSet, QueueRequestOptions paramQueueRequestOptions)
  {
    String str = paramCloudQueueMessage.getMessageContentForTransfer(shouldEncodeMessage, paramQueueRequestOptions);
    return new CloudQueue.10(this, paramQueueRequestOptions, getStorageUri(), paramEnumSet, str, paramCloudQueueMessage, paramQueueRequestOptions, paramInt);
  }
  
  private StorageRequest<CloudQueueClient, CloudQueue, Void> uploadMetadataImpl(QueueRequestOptions paramQueueRequestOptions)
  {
    return new CloudQueue.11(this, paramQueueRequestOptions, getStorageUri(), paramQueueRequestOptions);
  }
  
  private StorageRequest<CloudQueueClient, CloudQueue, Void> uploadPermissionsImpl(QueuePermissions paramQueuePermissions, QueueRequestOptions paramQueueRequestOptions)
  {
    StringWriter localStringWriter = new StringWriter();
    try
    {
      SharedAccessPolicySerializer.writeSharedAccessIdentifiersToStream(paramQueuePermissions.getSharedAccessPolicies(), localStringWriter);
      paramQueuePermissions = localStringWriter.toString().getBytes("UTF-8");
      paramQueuePermissions = new CloudQueue.12(this, paramQueueRequestOptions, getStorageUri(), paramQueuePermissions, paramQueueRequestOptions);
      return paramQueuePermissions;
    }
    catch (UnsupportedEncodingException paramQueuePermissions)
    {
      throw StorageException.translateClientException(paramQueuePermissions);
    }
    catch (XMLStreamException paramQueuePermissions)
    {
      throw StorageException.translateClientException(paramQueuePermissions);
    }
    catch (IllegalArgumentException paramQueuePermissions)
    {
      throw StorageException.translateClientException(paramQueuePermissions);
    }
  }
  
  @DoesServiceRequest
  public void addMessage(CloudQueueMessage paramCloudQueueMessage)
  {
    addMessage(paramCloudQueueMessage, 0, 0, null, null);
  }
  
  @DoesServiceRequest
  public void addMessage(CloudQueueMessage paramCloudQueueMessage, int paramInt1, int paramInt2, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("message", paramCloudQueueMessage);
    Utility.assertNotNull("messageContent", paramCloudQueueMessage.getMessageContentAsByte());
    if ((paramInt1 != -1) && (paramInt1 < 0)) {
      throw new IllegalArgumentException(String.format("The argument is out of range. Argument name: %s, Value passed: %s.", new Object[] { "timeToLiveInSeconds", Integer.valueOf(paramInt1) }));
    }
    int i = 604800;
    int j = paramInt1;
    if (paramInt1 == 0) {
      j = 604800;
    }
    paramInt1 = i;
    if (j >= 0)
    {
      paramInt1 = j - 1;
      if (paramInt1 > 604800) {
        paramInt1 = i;
      }
    }
    Utility.assertInBounds("initialVisibilityDelayInSeconds", paramInt2, 0L, paramInt1);
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramQueueRequestOptions = QueueRequestOptions.populateAndApplyDefaults(paramQueueRequestOptions, queueServiceClient);
    paramQueueRequestOptions.assertPolicyIfRequired();
    ExecutionEngine.executeWithRetry(queueServiceClient, this, addMessageImpl(paramCloudQueueMessage, j, paramInt2, paramQueueRequestOptions), paramQueueRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public void clear()
  {
    clear(null, null);
  }
  
  @DoesServiceRequest
  public void clear(QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramQueueRequestOptions = QueueRequestOptions.populateAndApplyDefaults(paramQueueRequestOptions, queueServiceClient);
    ExecutionEngine.executeWithRetry(queueServiceClient, this, clearImpl(paramQueueRequestOptions), paramQueueRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public void create()
  {
    create(null, null);
  }
  
  @DoesServiceRequest
  public void create(QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramQueueRequestOptions = QueueRequestOptions.populateAndApplyDefaults(paramQueueRequestOptions, queueServiceClient);
    ExecutionEngine.executeWithRetry(queueServiceClient, this, createImpl(paramQueueRequestOptions), paramQueueRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public boolean createIfNotExists()
  {
    return createIfNotExists(null, null);
  }
  
  @DoesServiceRequest
  public boolean createIfNotExists(QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    paramQueueRequestOptions = QueueRequestOptions.populateAndApplyDefaults(paramQueueRequestOptions, queueServiceClient);
    if (exists(true, paramQueueRequestOptions, paramOperationContext)) {
      return false;
    }
    try
    {
      create(paramQueueRequestOptions, paramOperationContext);
      return true;
    }
    catch (StorageException paramQueueRequestOptions)
    {
      if ((paramQueueRequestOptions.getHttpStatusCode() == 409) && ("QueueAlreadyExists".equals(paramQueueRequestOptions.getErrorCode()))) {
        return false;
      }
      throw paramQueueRequestOptions;
    }
  }
  
  @DoesServiceRequest
  public void delete()
  {
    delete(null, null);
  }
  
  @DoesServiceRequest
  public void delete(QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramQueueRequestOptions = QueueRequestOptions.populateAndApplyDefaults(paramQueueRequestOptions, queueServiceClient);
    ExecutionEngine.executeWithRetry(queueServiceClient, this, deleteImpl(paramQueueRequestOptions), paramQueueRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public boolean deleteIfExists()
  {
    return deleteIfExists(null, null);
  }
  
  @DoesServiceRequest
  public boolean deleteIfExists(QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    paramQueueRequestOptions = QueueRequestOptions.populateAndApplyDefaults(paramQueueRequestOptions, queueServiceClient);
    if (exists(true, paramQueueRequestOptions, paramOperationContext)) {
      try
      {
        delete(paramQueueRequestOptions, paramOperationContext);
        return true;
      }
      catch (StorageException paramQueueRequestOptions)
      {
        if ((paramQueueRequestOptions.getHttpStatusCode() == 404) && ("QueueNotFound".equals(paramQueueRequestOptions.getErrorCode()))) {
          return false;
        }
        throw paramQueueRequestOptions;
      }
    }
    return false;
  }
  
  @DoesServiceRequest
  public void deleteMessage(CloudQueueMessage paramCloudQueueMessage)
  {
    deleteMessage(paramCloudQueueMessage, null, null);
  }
  
  @DoesServiceRequest
  public void deleteMessage(CloudQueueMessage paramCloudQueueMessage, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("message", paramCloudQueueMessage);
    Utility.assertNotNullOrEmpty("messageId", paramCloudQueueMessage.getId());
    Utility.assertNotNullOrEmpty("popReceipt", paramCloudQueueMessage.getPopReceipt());
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramQueueRequestOptions = QueueRequestOptions.populateAndApplyDefaults(paramQueueRequestOptions, queueServiceClient);
    ExecutionEngine.executeWithRetry(queueServiceClient, this, deleteMessageImpl(paramCloudQueueMessage, paramQueueRequestOptions), paramQueueRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public void downloadAttributes()
  {
    downloadAttributes(null, null);
  }
  
  @DoesServiceRequest
  public void downloadAttributes(QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramQueueRequestOptions = QueueRequestOptions.populateAndApplyDefaults(paramQueueRequestOptions, queueServiceClient);
    ExecutionEngine.executeWithRetry(queueServiceClient, this, downloadAttributesImpl(paramQueueRequestOptions), paramQueueRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public QueuePermissions downloadPermissions()
  {
    return downloadPermissions(null, null);
  }
  
  @DoesServiceRequest
  public QueuePermissions downloadPermissions(QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramQueueRequestOptions = QueueRequestOptions.populateAndApplyDefaults(paramQueueRequestOptions, queueServiceClient);
    return (QueuePermissions)ExecutionEngine.executeWithRetry(queueServiceClient, this, downloadPermissionsImpl(paramQueueRequestOptions), paramQueueRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public boolean exists()
  {
    return exists(null, null);
  }
  
  @DoesServiceRequest
  public boolean exists(QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    return exists(false, paramQueueRequestOptions, paramOperationContext);
  }
  
  public String generateSharedAccessSignature(SharedAccessQueuePolicy paramSharedAccessQueuePolicy, String paramString)
  {
    return generateSharedAccessSignature(paramSharedAccessQueuePolicy, paramString, null, null);
  }
  
  public String generateSharedAccessSignature(SharedAccessQueuePolicy paramSharedAccessQueuePolicy, String paramString, IPRange paramIPRange, SharedAccessProtocols paramSharedAccessProtocols)
  {
    if (StorageCredentialsHelper.canCredentialsSignRequest(queueServiceClient.getCredentials())) {
      return SharedAccessSignatureHelper.generateSharedAccessSignatureForQueue(paramSharedAccessQueuePolicy, paramString, paramIPRange, paramSharedAccessProtocols, SharedAccessSignatureHelper.generateSharedAccessSignatureHashForQueue(paramSharedAccessQueuePolicy, paramString, getSharedAccessCanonicalName(), paramIPRange, paramSharedAccessProtocols, queueServiceClient)).toString();
    }
    throw new IllegalArgumentException("Cannot create Shared Access Signature unless the Account Key credentials are used by the ServiceClient.");
  }
  
  public long getApproximateMessageCount()
  {
    return approximateMessageCount;
  }
  
  public HashMap<String, String> getMetadata()
  {
    return metadata;
  }
  
  public String getName()
  {
    return name;
  }
  
  public CloudQueueClient getServiceClient()
  {
    return queueServiceClient;
  }
  
  public boolean getShouldEncodeMessage()
  {
    return shouldEncodeMessage;
  }
  
  public final StorageUri getStorageUri()
  {
    return storageUri;
  }
  
  public URI getUri()
  {
    return storageUri.getPrimaryUri();
  }
  
  @DoesServiceRequest
  public CloudQueueMessage peekMessage()
  {
    return peekMessage(null, null);
  }
  
  @DoesServiceRequest
  public CloudQueueMessage peekMessage(QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    return getFirstOrNull(peekMessages(1, null, null));
  }
  
  @DoesServiceRequest
  public Iterable<CloudQueueMessage> peekMessages(int paramInt)
  {
    return peekMessages(paramInt, null, null);
  }
  
  @DoesServiceRequest
  public Iterable<CloudQueueMessage> peekMessages(int paramInt, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertInBounds("numberOfMessages", paramInt, 1L, 32L);
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramQueueRequestOptions = QueueRequestOptions.populateAndApplyDefaults(paramQueueRequestOptions, queueServiceClient);
    paramQueueRequestOptions.assertPolicyIfRequired();
    return (Iterable)ExecutionEngine.executeWithRetry(queueServiceClient, this, peekMessagesImpl(paramInt, paramQueueRequestOptions), paramQueueRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public CloudQueueMessage retrieveMessage()
  {
    return retrieveMessage(30, null, null);
  }
  
  @DoesServiceRequest
  public CloudQueueMessage retrieveMessage(int paramInt, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    return getFirstOrNull(retrieveMessages(1, paramInt, paramQueueRequestOptions, paramOperationContext));
  }
  
  @DoesServiceRequest
  public Iterable<CloudQueueMessage> retrieveMessages(int paramInt)
  {
    return retrieveMessages(paramInt, 30, null, null);
  }
  
  @DoesServiceRequest
  public Iterable<CloudQueueMessage> retrieveMessages(int paramInt1, int paramInt2, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertInBounds("numberOfMessages", paramInt1, 1L, 32L);
    Utility.assertInBounds("visibilityTimeoutInSeconds", paramInt2, 0L, 604800L);
    if (paramOperationContext == null) {
      paramOperationContext = new OperationContext();
    }
    paramOperationContext.initialize();
    paramQueueRequestOptions = QueueRequestOptions.populateAndApplyDefaults(paramQueueRequestOptions, queueServiceClient);
    paramQueueRequestOptions.assertPolicyIfRequired();
    return (Iterable)ExecutionEngine.executeWithRetry(queueServiceClient, this, retrieveMessagesImpl(paramInt1, paramInt2, paramQueueRequestOptions), paramQueueRequestOptions.getRetryPolicyFactory(), paramOperationContext);
  }
  
  public void setMetadata(HashMap<String, String> paramHashMap)
  {
    metadata = paramHashMap;
  }
  
  public void setShouldEncodeMessage(boolean paramBoolean)
  {
    shouldEncodeMessage = paramBoolean;
  }
  
  public void updateMessage(CloudQueueMessage paramCloudQueueMessage, int paramInt)
  {
    updateMessage(paramCloudQueueMessage, paramInt, EnumSet.of(MessageUpdateFields.VISIBILITY), null, null);
  }
  
  @DoesServiceRequest
  public void updateMessage(CloudQueueMessage paramCloudQueueMessage, int paramInt, EnumSet<MessageUpdateFields> paramEnumSet, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("message", paramCloudQueueMessage);
    Utility.assertNotNullOrEmpty("messageId", paramCloudQueueMessage.getId());
    Utility.assertNotNullOrEmpty("popReceipt", paramCloudQueueMessage.getPopReceipt());
    Utility.assertInBounds("visibilityTimeoutInSeconds", paramInt, 0L, 604800L);
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramQueueRequestOptions = QueueRequestOptions.populateAndApplyDefaults(paramQueueRequestOptions, queueServiceClient);
    paramQueueRequestOptions.assertPolicyIfRequired();
    ExecutionEngine.executeWithRetry(queueServiceClient, this, updateMessageImpl(paramCloudQueueMessage, paramInt, paramEnumSet, paramQueueRequestOptions), paramQueueRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public void uploadMetadata()
  {
    uploadMetadata(null, null);
  }
  
  @DoesServiceRequest
  public void uploadMetadata(QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramQueueRequestOptions = QueueRequestOptions.populateAndApplyDefaults(paramQueueRequestOptions, queueServiceClient);
    ExecutionEngine.executeWithRetry(queueServiceClient, this, uploadMetadataImpl(paramQueueRequestOptions), paramQueueRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
  
  @DoesServiceRequest
  public void uploadPermissions(QueuePermissions paramQueuePermissions)
  {
    uploadPermissions(paramQueuePermissions, null, null);
  }
  
  @DoesServiceRequest
  public void uploadPermissions(QueuePermissions paramQueuePermissions, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    OperationContext localOperationContext = paramOperationContext;
    if (paramOperationContext == null) {
      localOperationContext = new OperationContext();
    }
    localOperationContext.initialize();
    paramQueueRequestOptions = QueueRequestOptions.populateAndApplyDefaults(paramQueueRequestOptions, queueServiceClient);
    ExecutionEngine.executeWithRetry(queueServiceClient, this, uploadPermissionsImpl(paramQueuePermissions, paramQueueRequestOptions), paramQueueRequestOptions.getRetryPolicyFactory(), localOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.queue.CloudQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */