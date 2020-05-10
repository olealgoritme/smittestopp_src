package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.ResultContinuation;
import com.microsoft.azure.storage.core.BaseRequest;
import com.microsoft.azure.storage.core.PathUtility;
import com.microsoft.azure.storage.core.UriQueryBuilder;
import com.microsoft.azure.storage.core.Utility;
import java.net.HttpURLConnection;
import java.net.URI;

public final class TableRequest
{
  public static void applyContinuationToQueryBuilder(UriQueryBuilder paramUriQueryBuilder, ResultContinuation paramResultContinuation)
  {
    if (paramResultContinuation != null)
    {
      if (paramResultContinuation.getNextPartitionKey() != null) {
        paramUriQueryBuilder.add("NextPartitionKey", paramResultContinuation.getNextPartitionKey());
      }
      if (paramResultContinuation.getNextRowKey() != null) {
        paramUriQueryBuilder.add("NextRowKey", paramResultContinuation.getNextRowKey());
      }
      if (paramResultContinuation.getNextTableName() != null) {
        paramUriQueryBuilder.add("NextTableName", paramResultContinuation.getNextTableName());
      }
    }
  }
  
  public static HttpURLConnection batch(URI paramURI, TableRequestOptions paramTableRequestOptions, UriQueryBuilder paramUriQueryBuilder, OperationContext paramOperationContext, String paramString)
  {
    paramURI = BaseRequest.createURLConnection(PathUtility.appendPathToSingleUri(paramURI, "$batch"), paramTableRequestOptions, paramUriQueryBuilder, paramOperationContext);
    setAcceptHeaderForHttpWebRequest(paramURI, paramTableRequestOptions.getTablePayloadFormat());
    paramURI.setRequestProperty("Content-Type", String.format("multipart/mixed; boundary=%s", new Object[] { paramString }));
    paramURI.setRequestProperty("MaxDataServiceVersion", "3.0");
    paramURI.setRequestMethod("POST");
    paramURI.setDoOutput(true);
    return paramURI;
  }
  
  public static HttpURLConnection coreCreate(URI paramURI, TableRequestOptions paramTableRequestOptions, UriQueryBuilder paramUriQueryBuilder, OperationContext paramOperationContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!Utility.isNullOrEmpty(paramString3)) {
      paramURI = PathUtility.appendPathToSingleUri(paramURI, paramString1.concat(String.format("(%s)", new Object[] { paramString3 })));
    } else {
      paramURI = PathUtility.appendPathToSingleUri(paramURI, paramString1);
    }
    paramURI = BaseRequest.createURLConnection(paramURI, paramTableRequestOptions, paramUriQueryBuilder, paramOperationContext);
    setAcceptHeaderForHttpWebRequest(paramURI, paramTableRequestOptions.getTablePayloadFormat());
    paramURI.setRequestProperty("Content-Type", "application/json");
    paramURI.setRequestProperty("MaxDataServiceVersion", "3.0");
    if (!Utility.isNullOrEmpty(paramString2)) {
      paramURI.setRequestProperty("If-Match", paramString2);
    }
    paramURI.setRequestMethod(paramString4);
    return paramURI;
  }
  
  public static HttpURLConnection delete(URI paramURI, TableRequestOptions paramTableRequestOptions, UriQueryBuilder paramUriQueryBuilder, OperationContext paramOperationContext, String paramString1, String paramString2, String paramString3)
  {
    return coreCreate(paramURI, paramTableRequestOptions, paramUriQueryBuilder, paramOperationContext, paramString1, paramString3, paramString2, "DELETE");
  }
  
  public static HttpURLConnection getAcl(URI paramURI, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("comp", "acl");
    paramURI = BaseRequest.createURLConnection(paramURI, paramTableRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setRequestMethod("GET");
    return paramURI;
  }
  
  public static HttpURLConnection insert(URI paramURI, TableRequestOptions paramTableRequestOptions, UriQueryBuilder paramUriQueryBuilder, OperationContext paramOperationContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, TableUpdateType paramTableUpdateType)
  {
    if (paramTableUpdateType == null)
    {
      paramTableRequestOptions = coreCreate(paramURI, paramTableRequestOptions, paramUriQueryBuilder, paramOperationContext, paramString1, paramString3, null, "POST");
      if (paramBoolean) {
        paramURI = "return-content";
      } else {
        paramURI = "return-no-content";
      }
      paramTableRequestOptions.setRequestProperty("Prefer", paramURI);
      paramURI = paramTableRequestOptions;
    }
    else if (paramTableUpdateType == TableUpdateType.MERGE)
    {
      paramTableRequestOptions.assertNoEncryptionPolicyOrStrictMode();
      paramURI = coreCreate(paramURI, paramTableRequestOptions, paramUriQueryBuilder, paramOperationContext, paramString1, null, paramString2, "POST");
      paramURI.setRequestProperty("X-HTTP-Method", "MERGE");
    }
    else if (paramTableUpdateType == TableUpdateType.REPLACE)
    {
      paramURI = coreCreate(paramURI, paramTableRequestOptions, paramUriQueryBuilder, paramOperationContext, paramString1, null, paramString2, "PUT");
    }
    else
    {
      paramURI = null;
    }
    paramURI.setDoOutput(true);
    return paramURI;
  }
  
  public static HttpURLConnection merge(URI paramURI, TableRequestOptions paramTableRequestOptions, UriQueryBuilder paramUriQueryBuilder, OperationContext paramOperationContext, String paramString1, String paramString2, String paramString3)
  {
    paramTableRequestOptions.assertNoEncryptionPolicyOrStrictMode();
    paramURI = coreCreate(paramURI, paramTableRequestOptions, paramUriQueryBuilder, paramOperationContext, paramString1, paramString3, paramString2, "POST");
    paramURI.setRequestProperty("X-HTTP-Method", "MERGE");
    paramURI.setDoOutput(true);
    return paramURI;
  }
  
  public static HttpURLConnection query(URI paramURI, TableRequestOptions paramTableRequestOptions, UriQueryBuilder paramUriQueryBuilder, OperationContext paramOperationContext, String paramString1, String paramString2, ResultContinuation paramResultContinuation)
  {
    UriQueryBuilder localUriQueryBuilder = paramUriQueryBuilder;
    if (paramUriQueryBuilder == null) {
      localUriQueryBuilder = new UriQueryBuilder();
    }
    applyContinuationToQueryBuilder(localUriQueryBuilder, paramResultContinuation);
    return coreCreate(paramURI, paramTableRequestOptions, localUriQueryBuilder, paramOperationContext, paramString1, null, paramString2, "GET");
  }
  
  public static void setAcceptHeaderForHttpWebRequest(HttpURLConnection paramHttpURLConnection, TablePayloadFormat paramTablePayloadFormat)
  {
    if (paramTablePayloadFormat == TablePayloadFormat.JsonFullMetadata) {
      paramHttpURLConnection.setRequestProperty("Accept", "application/json;odata=fullmetadata");
    } else if (paramTablePayloadFormat == TablePayloadFormat.Json) {
      paramHttpURLConnection.setRequestProperty("Accept", "application/json;odata=minimalmetadata");
    } else if (paramTablePayloadFormat == TablePayloadFormat.JsonNoMetadata) {
      paramHttpURLConnection.setRequestProperty("Accept", "application/json;odata=nometadata");
    }
  }
  
  public static HttpURLConnection setAcl(URI paramURI, TableRequestOptions paramTableRequestOptions, OperationContext paramOperationContext)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("comp", "acl");
    paramURI = BaseRequest.createURLConnection(paramURI, paramTableRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setRequestMethod("PUT");
    paramURI.setDoOutput(true);
    return paramURI;
  }
  
  public static HttpURLConnection update(URI paramURI, TableRequestOptions paramTableRequestOptions, UriQueryBuilder paramUriQueryBuilder, OperationContext paramOperationContext, String paramString1, String paramString2, String paramString3)
  {
    paramURI = coreCreate(paramURI, paramTableRequestOptions, paramUriQueryBuilder, paramOperationContext, paramString1, paramString3, paramString2, "PUT");
    paramURI.setDoOutput(true);
    return paramURI;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.table.TableRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */