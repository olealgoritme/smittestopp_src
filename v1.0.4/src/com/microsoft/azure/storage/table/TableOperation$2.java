package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageExtendedErrorInformation;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.StorageRequest;
import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;

public class TableOperation$2
  extends StorageRequest<CloudTableClient, TableOperation, TableResult>
{
  public TableOperation$2(TableOperation paramTableOperation, RequestOptions paramRequestOptions, StorageUri paramStorageUri, byte[] paramArrayOfByte, OperationContext paramOperationContext, TableRequestOptions paramTableRequestOptions, String paramString1, boolean paramBoolean, String paramString2)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudTableClient paramCloudTableClient, TableOperation paramTableOperation, OperationContext paramOperationContext)
  {
    setSendStream(new ByteArrayInputStream(val$entityBytes));
    setLength(Long.valueOf(val$entityBytes.length));
    paramOperationContext = paramCloudTableClient.getTransformedEndPoint(val$opContext).getUri(getCurrentLocation());
    TableRequestOptions localTableRequestOptions = val$options;
    OperationContext localOperationContext = val$opContext;
    String str1 = val$tableName;
    String str2 = this$0.generateRequestIdentity(val$isTableEntry, val$tableIdentity);
    if (TableOperation.access$000(paramTableOperation) != TableOperationType.INSERT) {
      paramCloudTableClient = paramTableOperation.getEntity().getEtag();
    } else {
      paramCloudTableClient = null;
    }
    return TableRequest.insert(paramOperationContext, localTableRequestOptions, null, localOperationContext, str1, str2, paramCloudTableClient, paramTableOperation.getEchoContent(), TableOperation.access$000(paramTableOperation).getUpdateType());
  }
  
  public StorageExtendedErrorInformation parseErrorDetails()
  {
    return TableStorageErrorDeserializer.parseErrorDetails(this);
  }
  
  public TableResult postProcessResponse(HttpURLConnection paramHttpURLConnection, TableOperation paramTableOperation, CloudTableClient paramCloudTableClient, OperationContext paramOperationContext, TableResult paramTableResult)
  {
    paramHttpURLConnection = paramTableResult;
    if (TableOperation.access$000(paramTableOperation) == TableOperationType.INSERT)
    {
      paramHttpURLConnection = paramTableResult;
      if (paramTableOperation.getEchoContent()) {
        paramHttpURLConnection = paramTableOperation.parseResponse(getConnection().getInputStream(), getResult().getStatusCode(), getConnection().getHeaderField("ETag"), val$opContext, val$options);
      }
    }
    return paramHttpURLConnection;
  }
  
  public TableResult preProcessResponse(TableOperation paramTableOperation, CloudTableClient paramCloudTableClient, OperationContext paramOperationContext)
  {
    if (TableOperation.access$000(paramTableOperation) == TableOperationType.INSERT)
    {
      if ((paramTableOperation.getEchoContent()) && (getResult().getStatusCode() == 201)) {
        return new TableResult();
      }
      if ((!paramTableOperation.getEchoContent()) && (getResult().getStatusCode() == 204)) {
        return paramTableOperation.parseResponse(null, getResult().getStatusCode(), getConnection().getHeaderField("ETag"), val$opContext, val$options);
      }
    }
    else if (getResult().getStatusCode() == 204)
    {
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
 * Qualified Name:     base.com.microsoft.azure.storage.table.TableOperation.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */