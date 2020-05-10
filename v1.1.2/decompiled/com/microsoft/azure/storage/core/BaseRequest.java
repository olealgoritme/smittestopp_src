package com.microsoft.azure.storage.core;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestOptions;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class BaseRequest
{
  public static final String ACCOUNT = "account";
  public static final String METADATA = "metadata";
  public static final String SERVICE = "service";
  public static final String STATS = "stats";
  public static final String TIMEOUT = "timeout";
  public static String userAgent;
  
  public static void addMetadata(HttpURLConnection paramHttpURLConnection, String paramString1, String paramString2, OperationContext paramOperationContext)
  {
    if (!Utility.isNullOrEmptyOrWhitespace(paramString1))
    {
      if (!Utility.isNullOrEmptyOrWhitespace(paramString2))
      {
        paramOperationContext = new StringBuilder();
        paramOperationContext.append("x-ms-meta-");
        paramOperationContext.append(paramString1);
        paramHttpURLConnection.setRequestProperty(paramOperationContext.toString(), paramString2);
        return;
      }
      throw new IllegalArgumentException("The value for one of the metadata key-value pairs is null, empty, or whitespace.");
    }
    throw new IllegalArgumentException("The key for one of the metadata key-value pairs is null, empty, or whitespace.");
  }
  
  public static void addMetadata(HttpURLConnection paramHttpURLConnection, Map<String, String> paramMap, OperationContext paramOperationContext)
  {
    if (paramMap != null)
    {
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        addMetadata(paramHttpURLConnection, (String)paramMap.getKey(), (String)paramMap.getValue(), paramOperationContext);
      }
    }
  }
  
  public static void addOptionalHeader(HttpURLConnection paramHttpURLConnection, String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (!paramString2.equals(""))) {
      paramHttpURLConnection.setRequestProperty(paramString1, paramString2);
    }
  }
  
  public static HttpURLConnection create(URI paramURI, RequestOptions paramRequestOptions, UriQueryBuilder paramUriQueryBuilder, OperationContext paramOperationContext)
  {
    UriQueryBuilder localUriQueryBuilder = paramUriQueryBuilder;
    if (paramUriQueryBuilder == null) {
      localUriQueryBuilder = new UriQueryBuilder();
    }
    paramURI = createURLConnection(paramURI, paramRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setFixedLengthStreamingMode(0);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    return paramURI;
  }
  
  public static HttpURLConnection createURLConnection(URI paramURI, RequestOptions paramRequestOptions, UriQueryBuilder paramUriQueryBuilder, OperationContext paramOperationContext)
  {
    Object localObject = paramUriQueryBuilder;
    if (paramUriQueryBuilder == null) {
      localObject = new UriQueryBuilder();
    }
    if ((paramRequestOptions.getTimeoutIntervalInMs() != null) && (paramRequestOptions.getTimeoutIntervalInMs().intValue() != 0)) {
      ((UriQueryBuilder)localObject).add("timeout", String.valueOf(paramRequestOptions.getTimeoutIntervalInMs().intValue() / 1000));
    }
    localObject = ((UriQueryBuilder)localObject).addToURI(paramURI).toURL();
    paramUriQueryBuilder = OperationContext.getDefaultProxy();
    paramURI = paramUriQueryBuilder;
    if (paramOperationContext != null)
    {
      paramURI = paramUriQueryBuilder;
      if (paramOperationContext.getProxy() != null) {
        paramURI = paramOperationContext.getProxy();
      }
    }
    if (paramURI != null) {
      paramURI = (HttpURLConnection)((URL)localObject).openConnection(paramURI);
    } else {
      paramURI = (HttpURLConnection)((URL)localObject).openConnection();
    }
    int i = Utility.getRemainingTimeout(paramRequestOptions.getOperationExpiryTimeInMs(), paramRequestOptions.getTimeoutIntervalInMs());
    paramURI.setReadTimeout(i);
    paramURI.setConnectTimeout(i);
    paramURI.setRequestProperty("Accept", "application/xml");
    paramURI.setRequestProperty("Accept-Charset", "UTF-8");
    paramURI.setRequestProperty("Content-Type", "");
    paramURI.setRequestProperty("x-ms-version", "2018-03-28");
    paramURI.setRequestProperty("User-Agent", getUserAgent());
    paramURI.setRequestProperty("x-ms-client-request-id", paramOperationContext.getClientRequestID());
    return paramURI;
  }
  
  public static HttpURLConnection delete(URI paramURI, RequestOptions paramRequestOptions, UriQueryBuilder paramUriQueryBuilder, OperationContext paramOperationContext)
  {
    UriQueryBuilder localUriQueryBuilder = paramUriQueryBuilder;
    if (paramUriQueryBuilder == null) {
      localUriQueryBuilder = new UriQueryBuilder();
    }
    paramURI = createURLConnection(paramURI, paramRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setRequestMethod("DELETE");
    return paramURI;
  }
  
  public static HttpURLConnection getAccountInfo(URI paramURI, RequestOptions paramRequestOptions, UriQueryBuilder paramUriQueryBuilder, OperationContext paramOperationContext)
  {
    UriQueryBuilder localUriQueryBuilder = paramUriQueryBuilder;
    if (paramUriQueryBuilder == null) {
      localUriQueryBuilder = new UriQueryBuilder();
    }
    localUriQueryBuilder.add("restype", "account");
    localUriQueryBuilder.add("comp", "properties");
    paramURI = createURLConnection(paramURI, paramRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setRequestMethod("HEAD");
    return paramURI;
  }
  
  public static UriQueryBuilder getListUriQueryBuilder(ListingContext paramListingContext)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("comp", "list");
    if (paramListingContext != null)
    {
      if (!Utility.isNullOrEmpty(paramListingContext.getPrefix())) {
        localUriQueryBuilder.add("prefix", paramListingContext.getPrefix());
      }
      if (!Utility.isNullOrEmpty(paramListingContext.getMarker())) {
        localUriQueryBuilder.add("marker", paramListingContext.getMarker());
      }
      if ((paramListingContext.getMaxResults() != null) && (paramListingContext.getMaxResults().intValue() > 0)) {
        localUriQueryBuilder.add("maxresults", paramListingContext.getMaxResults().toString());
      }
    }
    return localUriQueryBuilder;
  }
  
  public static HttpURLConnection getProperties(URI paramURI, RequestOptions paramRequestOptions, UriQueryBuilder paramUriQueryBuilder, OperationContext paramOperationContext)
  {
    UriQueryBuilder localUriQueryBuilder = paramUriQueryBuilder;
    if (paramUriQueryBuilder == null) {
      localUriQueryBuilder = new UriQueryBuilder();
    }
    paramURI = createURLConnection(paramURI, paramRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setRequestMethod("HEAD");
    return paramURI;
  }
  
  public static HttpURLConnection getServiceProperties(URI paramURI, RequestOptions paramRequestOptions, UriQueryBuilder paramUriQueryBuilder, OperationContext paramOperationContext)
  {
    UriQueryBuilder localUriQueryBuilder = paramUriQueryBuilder;
    if (paramUriQueryBuilder == null) {
      localUriQueryBuilder = new UriQueryBuilder();
    }
    localUriQueryBuilder.add("comp", "properties");
    localUriQueryBuilder.add("restype", "service");
    paramURI = createURLConnection(paramURI, paramRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setRequestMethod("GET");
    return paramURI;
  }
  
  public static HttpURLConnection getServiceStats(URI paramURI, RequestOptions paramRequestOptions, UriQueryBuilder paramUriQueryBuilder, OperationContext paramOperationContext)
  {
    UriQueryBuilder localUriQueryBuilder = paramUriQueryBuilder;
    if (paramUriQueryBuilder == null) {
      localUriQueryBuilder = new UriQueryBuilder();
    }
    localUriQueryBuilder.add("comp", "stats");
    localUriQueryBuilder.add("restype", "service");
    paramURI = createURLConnection(paramURI, paramRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setRequestMethod("GET");
    return paramURI;
  }
  
  public static String getUserAgent()
  {
    if (userAgent == null) {
      userAgent = String.format("%s/%s %s", new Object[] { "Azure-Storage", "8.1.0", String.format(Utility.LOCALE_US, "(JavaJRE %s; %s %s)", new Object[] { System.getProperty("java.version"), System.getProperty("os.name").replaceAll(" ", ""), System.getProperty("os.version") }) });
    }
    return userAgent;
  }
  
  public static HttpURLConnection setMetadata(URI paramURI, RequestOptions paramRequestOptions, UriQueryBuilder paramUriQueryBuilder, OperationContext paramOperationContext)
  {
    UriQueryBuilder localUriQueryBuilder = paramUriQueryBuilder;
    if (paramUriQueryBuilder == null) {
      localUriQueryBuilder = new UriQueryBuilder();
    }
    localUriQueryBuilder.add("comp", "metadata");
    paramURI = createURLConnection(paramURI, paramRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setFixedLengthStreamingMode(0);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    return paramURI;
  }
  
  public static HttpURLConnection setServiceProperties(URI paramURI, RequestOptions paramRequestOptions, UriQueryBuilder paramUriQueryBuilder, OperationContext paramOperationContext)
  {
    UriQueryBuilder localUriQueryBuilder = paramUriQueryBuilder;
    if (paramUriQueryBuilder == null) {
      localUriQueryBuilder = new UriQueryBuilder();
    }
    localUriQueryBuilder.add("comp", "properties");
    localUriQueryBuilder.add("restype", "service");
    paramURI = createURLConnection(paramURI, paramRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    return paramURI;
  }
  
  public static HttpURLConnection undelete(URI paramURI, RequestOptions paramRequestOptions, UriQueryBuilder paramUriQueryBuilder, OperationContext paramOperationContext)
  {
    UriQueryBuilder localUriQueryBuilder = paramUriQueryBuilder;
    if (paramUriQueryBuilder == null) {
      localUriQueryBuilder = new UriQueryBuilder();
    }
    localUriQueryBuilder.add("comp", "undelete");
    paramURI = createURLConnection(paramURI, paramRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setFixedLengthStreamingMode(0);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    return paramURI;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.core.BaseRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */