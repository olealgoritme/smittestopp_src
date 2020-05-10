package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.Permissions;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.SharedAccessPolicyHandler;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CloudFileShare$4
  extends StorageRequest<CloudFileClient, CloudFileShare, FileSharePermissions>
{
  public CloudFileShare$4(CloudFileShare paramCloudFileShare, RequestOptions paramRequestOptions, StorageUri paramStorageUri, FileRequestOptions paramFileRequestOptions, AccessCondition paramAccessCondition)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudFileClient paramCloudFileClient, CloudFileShare paramCloudFileShare, OperationContext paramOperationContext)
  {
    return FileRequest.getAcl(CloudFileShare.access$000(paramCloudFileShare).getUri(getCurrentLocation()), val$options, val$accessCondition, paramOperationContext);
  }
  
  public FileSharePermissions postProcessResponse(HttpURLConnection paramHttpURLConnection, CloudFileShare paramCloudFileShare, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext, FileSharePermissions paramFileSharePermissions)
  {
    paramHttpURLConnection = SharedAccessPolicyHandler.getAccessIdentifiers(getConnection().getInputStream(), SharedAccessFilePolicy.class);
    paramCloudFileClient = paramHttpURLConnection.keySet().iterator();
    while (paramCloudFileClient.hasNext())
    {
      paramCloudFileShare = (String)paramCloudFileClient.next();
      paramFileSharePermissions.getSharedAccessPolicies().put(paramCloudFileShare, paramHttpURLConnection.get(paramCloudFileShare));
    }
    return paramFileSharePermissions;
  }
  
  public FileSharePermissions preProcessResponse(CloudFileShare paramCloudFileShare, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 200) {
      setNonExceptionedRetryableFailure(true);
    }
    CloudFileShare.access$200(paramCloudFileShare, getConnection());
    return new FileSharePermissions();
  }
  
  public void setRequestLocationMode()
  {
    setRequestLocationMode(RequestLocationMode.PRIMARY_OR_SECONDARY);
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudFileClient paramCloudFileClient, OperationContext paramOperationContext)
  {
    StorageRequest.signBlobQueueAndFileRequest(paramHttpURLConnection, paramCloudFileClient, -1L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.file.CloudFileShare.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */