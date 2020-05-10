package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageExtendedErrorInformation;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.StorageRequest;
import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;

public class CloudTable$1
  extends StorageRequest<CloudTableClient, CloudTable, Void>
{
  public CloudTable$1(CloudTable paramCloudTable, RequestOptions paramRequestOptions, StorageUri paramStorageUri, byte[] paramArrayOfByte, TableRequestOptions paramTableRequestOptions)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudTableClient paramCloudTableClient, CloudTable paramCloudTable, OperationContext paramOperationContext)
  {
    setSendStream(new ByteArrayInputStream(val$aclBytes));
    setLength(Long.valueOf(val$aclBytes.length));
    return TableRequest.setAcl(paramCloudTable.getStorageUri().getUri(getCurrentLocation()), val$options, paramOperationContext);
  }
  
  public StorageExtendedErrorInformation parseErrorDetails()
  {
    return TableStorageErrorDeserializer.parseErrorDetails(this);
  }
  
  public Void preProcessResponse(CloudTable paramCloudTable, CloudTableClient paramCloudTableClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 204) {
      setNonExceptionedRetryableFailure(true);
    }
    return null;
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudTableClient paramCloudTableClient, OperationContext paramOperationContext)
  {
    StorageRequest.signTableRequest(paramHttpURLConnection, paramCloudTableClient, val$aclBytes.length, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.table.CloudTable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */