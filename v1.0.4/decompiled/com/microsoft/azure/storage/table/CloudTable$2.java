package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.Permissions;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.SharedAccessPolicyHandler;
import com.microsoft.azure.storage.StorageExtendedErrorInformation;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.RequestLocationMode;
import com.microsoft.azure.storage.core.StorageRequest;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CloudTable$2
  extends StorageRequest<CloudTableClient, CloudTable, TablePermissions>
{
  public CloudTable$2(CloudTable paramCloudTable, RequestOptions paramRequestOptions, StorageUri paramStorageUri, TableRequestOptions paramTableRequestOptions)
  {
    super(paramRequestOptions, paramStorageUri);
  }
  
  public HttpURLConnection buildRequest(CloudTableClient paramCloudTableClient, CloudTable paramCloudTable, OperationContext paramOperationContext)
  {
    return TableRequest.getAcl(paramCloudTable.getStorageUri().getUri(getCurrentLocation()), val$options, paramOperationContext);
  }
  
  public StorageExtendedErrorInformation parseErrorDetails()
  {
    return TableStorageErrorDeserializer.parseErrorDetails(this);
  }
  
  public TablePermissions postProcessResponse(HttpURLConnection paramHttpURLConnection, CloudTable paramCloudTable, CloudTableClient paramCloudTableClient, OperationContext paramOperationContext, TablePermissions paramTablePermissions)
  {
    paramCloudTableClient = SharedAccessPolicyHandler.getAccessIdentifiers(getConnection().getInputStream(), SharedAccessTablePolicy.class);
    paramCloudTable = paramCloudTableClient.keySet().iterator();
    while (paramCloudTable.hasNext())
    {
      paramHttpURLConnection = (String)paramCloudTable.next();
      paramTablePermissions.getSharedAccessPolicies().put(paramHttpURLConnection, paramCloudTableClient.get(paramHttpURLConnection));
    }
    return paramTablePermissions;
  }
  
  public TablePermissions preProcessResponse(CloudTable paramCloudTable, CloudTableClient paramCloudTableClient, OperationContext paramOperationContext)
  {
    if (getResult().getStatusCode() != 200) {
      setNonExceptionedRetryableFailure(true);
    }
    return new TablePermissions();
  }
  
  public void setRequestLocationMode()
  {
    setRequestLocationMode(RequestLocationMode.PRIMARY_OR_SECONDARY);
  }
  
  public void signRequest(HttpURLConnection paramHttpURLConnection, CloudTableClient paramCloudTableClient, OperationContext paramOperationContext)
  {
    StorageRequest.signTableRequest(paramHttpURLConnection, paramCloudTableClient, -1L, paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.table.CloudTable.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */