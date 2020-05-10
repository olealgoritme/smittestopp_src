package com.microsoft.azure.storage.queue;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.core.BaseRequest;
import com.microsoft.azure.storage.core.ListingContext;
import com.microsoft.azure.storage.core.UriQueryBuilder;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.HashMap;

public final class QueueRequest
{
  public static final String MESSAGE_TTL = "messagettl";
  public static final String METADATA = "metadata";
  public static final String NUMBER_OF_MESSAGES = "numofmessages";
  public static final String PEEK_ONLY = "peekonly";
  public static final String POP_RECEIPT = "popreceipt";
  public static final String VISIBILITY_TIMEOUT = "visibilitytimeout";
  
  public static void addMetadata(HttpURLConnection paramHttpURLConnection, HashMap<String, String> paramHashMap, OperationContext paramOperationContext)
  {
    BaseRequest.addMetadata(paramHttpURLConnection, paramHashMap, paramOperationContext);
  }
  
  public static HttpURLConnection clearMessages(URI paramURI, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    paramURI = BaseRequest.createURLConnection(paramURI, paramQueueRequestOptions, null, paramOperationContext);
    paramURI.setRequestMethod("DELETE");
    return paramURI;
  }
  
  public static HttpURLConnection create(URI paramURI, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    return BaseRequest.create(paramURI, paramQueueRequestOptions, null, paramOperationContext);
  }
  
  public static HttpURLConnection delete(URI paramURI, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    return BaseRequest.delete(paramURI, paramQueueRequestOptions, null, paramOperationContext);
  }
  
  public static HttpURLConnection deleteMessage(URI paramURI, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext, String paramString)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("popreceipt", paramString);
    paramURI = BaseRequest.createURLConnection(paramURI, paramQueueRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setRequestMethod("DELETE");
    return paramURI;
  }
  
  public static HttpURLConnection downloadAttributes(URI paramURI, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("comp", "metadata");
    paramURI = BaseRequest.createURLConnection(paramURI, paramQueueRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setRequestMethod("HEAD");
    return paramURI;
  }
  
  public static HttpURLConnection getAcl(URI paramURI, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("comp", "acl");
    paramURI = BaseRequest.createURLConnection(paramURI, paramQueueRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setRequestMethod("GET");
    return paramURI;
  }
  
  public static HttpURLConnection list(URI paramURI, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext, ListingContext paramListingContext, QueueListingDetails paramQueueListingDetails)
  {
    paramListingContext = BaseRequest.getListUriQueryBuilder(paramListingContext);
    if ((paramQueueListingDetails == QueueListingDetails.ALL) || (paramQueueListingDetails == QueueListingDetails.METADATA)) {
      paramListingContext.add("include", "metadata");
    }
    paramURI = BaseRequest.createURLConnection(paramURI, paramQueueRequestOptions, paramListingContext, paramOperationContext);
    paramURI.setRequestMethod("GET");
    return paramURI;
  }
  
  public static HttpURLConnection peekMessages(URI paramURI, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext, int paramInt)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("peekonly", "true");
    if (paramInt != 0) {
      localUriQueryBuilder.add("numofmessages", Integer.toString(paramInt));
    }
    paramURI = BaseRequest.createURLConnection(paramURI, paramQueueRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setRequestMethod("GET");
    return paramURI;
  }
  
  public static HttpURLConnection putMessage(URI paramURI, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext, int paramInt1, int paramInt2)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    if (paramInt1 != 0) {
      localUriQueryBuilder.add("visibilitytimeout", Integer.toString(paramInt1));
    }
    if (paramInt2 != 0) {
      localUriQueryBuilder.add("messagettl", Integer.toString(paramInt2));
    }
    paramURI = BaseRequest.createURLConnection(paramURI, paramQueueRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("POST");
    return paramURI;
  }
  
  public static HttpURLConnection retrieveMessages(URI paramURI, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext, int paramInt1, int paramInt2)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    if (paramInt1 != 0) {
      localUriQueryBuilder.add("numofmessages", Integer.toString(paramInt1));
    }
    localUriQueryBuilder.add("visibilitytimeout", Integer.toString(paramInt2));
    paramURI = BaseRequest.createURLConnection(paramURI, paramQueueRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setRequestMethod("GET");
    return paramURI;
  }
  
  public static HttpURLConnection setAcl(URI paramURI, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("comp", "acl");
    paramURI = BaseRequest.createURLConnection(paramURI, paramQueueRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    return paramURI;
  }
  
  public static HttpURLConnection setMetadata(URI paramURI, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext)
  {
    return BaseRequest.setMetadata(paramURI, paramQueueRequestOptions, null, paramOperationContext);
  }
  
  public static HttpURLConnection updateMessage(URI paramURI, QueueRequestOptions paramQueueRequestOptions, OperationContext paramOperationContext, String paramString, int paramInt)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("popreceipt", paramString);
    localUriQueryBuilder.add("visibilitytimeout", Integer.toString(paramInt));
    paramURI = BaseRequest.createURLConnection(paramURI, paramQueueRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    return paramURI;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.queue.QueueRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */