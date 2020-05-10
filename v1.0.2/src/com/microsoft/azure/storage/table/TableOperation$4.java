package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageExtendedErrorInformation;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.StorageRequest;
import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;

public class TableOperation$4
  extends StorageRequest<CloudTableClient, TableOperation, TableResult>
{
  public TableOperation$4(TableOperation paramTableOperation, RequestOptions paramRequestOptions, StorageUri paramStorageUri, byte[] paramArrayOfByte, TableRequestOptions paramTableRequestOptions, String paramString, OperationContext paramOperationContext)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudTableClient paramCloudTableClient, TableOperation paramTableOperation, OperationContext paramOperationContext)
  {
    setSendStream(new ByteArrayInputStream(val$entityBytes));
    setLength(Long.valueOf(val$entityBytes.length));
    return TableRequest.update(paramCloudTableClient.getTransformedEndPoint(paramOperationContext).getUri(getCurrentLocation()), val$options, null, paramOperationContext, val$tableName, this$0.generateRequestIdentity(false, null), paramTableOperation.getEntity().getEtag());
  }
  
  public StorageExtendedErrorInformation parseErrorDetails()
  {
    return TableStorageErrorDeserializer.parseErrorDetails(this);
  }
  
  public TableResult preProcessResponse(TableOperation paramTableOperation, CloudTableClient paramCloudTableClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() == 204) {
      return paramTableOperation.parseResponse(null, getResult().getStatusCode(), getConnection().getHeaderField("ETag"), val$opContext, val$options);
    }
    throw TableServiceException.generateTableServiceException(getResult(), paramTableOperation, getConnection().getErrorStream(), val$options.getTablePayloadFormat());
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudTableClient paramCloudTableClient, OperationContext paramOperationContext)
  {
    StorageRequest.signTableRequest(paramHttpURLConnection, paramCloudTableClient, -1L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.table.TableOperation.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */