package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.StorageExtendedErrorInformation;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;

public class TableBatchOperation$1
  extends StorageRequest<CloudTableClient, TableBatchOperation, ArrayList<TableResult>>
{
  public TableBatchOperation$1(TableBatchOperation paramTableBatchOperation, RequestOptions paramRequestOptions, StorageUri paramStorageUri, byte[] paramArrayOfByte, TableRequestOptions paramTableRequestOptions, String paramString, OperationContext paramOperationContext)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudTableClient paramCloudTableClient, TableBatchOperation paramTableBatchOperation, OperationContext paramOperationContext)
  {
    setSendStream(new ByteArrayInputStream(val$batchBytes));
    setLength(Long.valueOf(val$batchBytes.length));
    return TableRequest.batch(paramCloudTableClient.getTransformedEndPoint(paramOperationContext).getUri(getCurrentLocation()), val$options, null, paramOperationContext, val$batchID);
  }
  
  public StorageExtendedErrorInformation parseErrorDetails()
  {
    return TableStorageErrorDeserializer.parseErrorDetails(this);
  }
  
  public ArrayList<TableResult> postProcessResponse(HttpURLConnection paramHttpURLConnection, TableBatchOperation paramTableBatchOperation, CloudTableClient paramCloudTableClient, OperationContext paramOperationContext, ArrayList<TableResult> paramArrayList)
  {
    paramCloudTableClient = paramHttpURLConnection.getInputStream();
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Content-Type").split("multipart/mixed; boundary=");
    if ((paramHttpURLConnection != null) && (paramHttpURLConnection.length == 2))
    {
      ArrayList localArrayList = MimeHelper.readBatchResponseStream(paramCloudTableClient, paramHttpURLConnection[1], val$opContext, val$options.getTablePayloadFormat());
      paramOperationContext = new ArrayList();
      int i = 0;
      while (i < paramTableBatchOperation.size())
      {
        paramCloudTableClient = (TableOperation)paramTableBatchOperation.get(i);
        paramArrayList = (MimePart)localArrayList.get(i);
        if (paramCloudTableClient.getOperationType() == TableOperationType.INSERT)
        {
          if ((!paramCloudTableClient.getEchoContent()) || (httpStatusCode == 201)) {
            if ((paramCloudTableClient.getEchoContent()) || (httpStatusCode == 204)) {
              break label213;
            }
          }
        }
        else if (paramCloudTableClient.getOperationType() == TableOperationType.RETRIEVE)
        {
          j = httpStatusCode;
          if (j == 404)
          {
            paramOperationContext.add(new TableResult(j));
            return paramOperationContext;
          }
          if (j == 200) {
            break label213;
          }
        }
        else
        {
          if (httpStatusCode == 204) {
            break label213;
          }
        }
        int j = 1;
        break label216;
        label213:
        j = 0;
        label216:
        if (j == 0)
        {
          paramHttpURLConnection = null;
          if (((paramCloudTableClient.getOperationType() == TableOperationType.INSERT) && (paramCloudTableClient.getEchoContent())) || (paramCloudTableClient.getOperationType() == TableOperationType.RETRIEVE)) {
            paramHttpURLConnection = new ByteArrayInputStream(payload.getBytes());
          }
          paramOperationContext.add(paramCloudTableClient.parseResponse(paramHttpURLConnection, httpStatusCode, (String)headers.get("ETag"), val$opContext, val$options));
          i++;
        }
        else
        {
          throw new TableServiceException(httpStatusCode, httpStatusMessage, paramCloudTableClient, new StringReader(payload), val$options.getTablePayloadFormat());
        }
      }
      return paramOperationContext;
    }
    throw new StorageException("OutOfRangeInput", "An incorrect Content-Type was returned from the server.", 306, null, null);
  }
  
  public ArrayList<TableResult> preProcessResponse(TableBatchOperation paramTableBatchOperation, CloudTableClient paramCloudTableClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 202) {
      setNonExceptionedRetryableFailure(true);
    }
    return null;
  }
  
  public void setRequestLocationMode()
  {
    RequestLocationMode localRequestLocationMode;
    if (TableBatchOperation.access$000(this$0)) {
      localRequestLocationMode = RequestLocationMode.PRIMARY_ONLY;
    } else {
      localRequestLocationMode = RequestLocationMode.PRIMARY_OR_SECONDARY;
    }
    setRequestLocationMode(localRequestLocationMode);
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudTableClient paramCloudTableClient, OperationContext paramOperationContext)
  {
    StorageRequest.signTableRequest(paramHttpURLConnection, paramCloudTableClient, -1L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.table.TableBatchOperation.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */