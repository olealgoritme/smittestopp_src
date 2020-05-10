package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.Constants;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.core.BaseRequest;
import com.microsoft.azure.storage.core.ListingContext;
import com.microsoft.azure.storage.core.UriQueryBuilder;
import com.microsoft.azure.storage.core.Utility;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.EnumSet;
import java.util.Map;

public final class FileRequest
{
  public static final String RANGE_LIST_QUERY_ELEMENT_NAME = "rangelist";
  public static final String RANGE_QUERY_ELEMENT_NAME = "range";
  public static final String SNAPSHOTS_QUERY_ELEMENT_NAME = "snapshots";
  
  public static HttpURLConnection abortCopy(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, String paramString)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("comp", "copy");
    localUriQueryBuilder.add("copyid", paramString);
    paramURI = BaseRequest.createURLConnection(paramURI, paramFileRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setFixedLengthStreamingMode(0);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    paramURI.setRequestProperty("x-ms-copy-action", "abort");
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    return paramURI;
  }
  
  public static void addMetadata(HttpURLConnection paramHttpURLConnection, Map<String, String> paramMap, OperationContext paramOperationContext)
  {
    BaseRequest.addMetadata(paramHttpURLConnection, paramMap, paramOperationContext);
  }
  
  public static void addProperties(HttpURLConnection paramHttpURLConnection, FileProperties paramFileProperties)
  {
    BaseRequest.addOptionalHeader(paramHttpURLConnection, "x-ms-cache-control", paramFileProperties.getCacheControl());
    BaseRequest.addOptionalHeader(paramHttpURLConnection, "x-ms-content-disposition", paramFileProperties.getContentDisposition());
    BaseRequest.addOptionalHeader(paramHttpURLConnection, "x-ms-content-encoding", paramFileProperties.getContentEncoding());
    BaseRequest.addOptionalHeader(paramHttpURLConnection, "x-ms-content-language", paramFileProperties.getContentLanguage());
    BaseRequest.addOptionalHeader(paramHttpURLConnection, "x-ms-content-md5", paramFileProperties.getContentMD5());
    BaseRequest.addOptionalHeader(paramHttpURLConnection, "x-ms-content-type", paramFileProperties.getContentType());
  }
  
  public static void addProperties(HttpURLConnection paramHttpURLConnection, FileShareProperties paramFileShareProperties)
  {
    paramFileShareProperties = paramFileShareProperties.getShareQuota();
    if (paramFileShareProperties == null) {
      paramFileShareProperties = null;
    } else {
      paramFileShareProperties = paramFileShareProperties.toString();
    }
    BaseRequest.addOptionalHeader(paramHttpURLConnection, "x-ms-share-quota", paramFileShareProperties);
  }
  
  public static void addShareSnapshot(UriQueryBuilder paramUriQueryBuilder, String paramString)
  {
    if (paramString != null) {
      paramUriQueryBuilder.add("sharesnapshot", paramString);
    }
  }
  
  public static HttpURLConnection copyFrom(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition1, AccessCondition paramAccessCondition2, String paramString)
  {
    paramURI = BaseRequest.createURLConnection(paramURI, paramFileRequestOptions, null, paramOperationContext);
    paramURI.setFixedLengthStreamingMode(0);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    paramURI.setRequestProperty("x-ms-copy-source", paramString);
    if (paramAccessCondition1 != null) {
      paramAccessCondition1.applyConditionToRequest(paramURI);
    }
    if (paramAccessCondition2 != null) {
      paramAccessCondition2.applyConditionToRequest(paramURI);
    }
    return paramURI;
  }
  
  public static HttpURLConnection createDirectory(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    return BaseRequest.create(paramURI, paramFileRequestOptions, getDirectoryUriQueryBuilder(), paramOperationContext);
  }
  
  public static HttpURLConnection createShare(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, FileShareProperties paramFileShareProperties)
  {
    paramURI = BaseRequest.create(paramURI, paramFileRequestOptions, getShareUriQueryBuilder(), paramOperationContext);
    addProperties(paramURI, paramFileShareProperties);
    return paramURI;
  }
  
  public static HttpURLConnection deleteDirectory(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition)
  {
    paramURI = BaseRequest.delete(paramURI, paramFileRequestOptions, getDirectoryUriQueryBuilder(), paramOperationContext);
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    return paramURI;
  }
  
  public static HttpURLConnection deleteFile(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition)
  {
    paramURI = BaseRequest.delete(paramURI, paramFileRequestOptions, new UriQueryBuilder(), paramOperationContext);
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    return paramURI;
  }
  
  public static HttpURLConnection deleteShare(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, String paramString, DeleteShareSnapshotsOption paramDeleteShareSnapshotsOption)
  {
    UriQueryBuilder localUriQueryBuilder = getShareUriQueryBuilder();
    addShareSnapshot(localUriQueryBuilder, paramString);
    paramURI = BaseRequest.delete(paramURI, paramFileRequestOptions, localUriQueryBuilder, paramOperationContext);
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    if (paramDeleteShareSnapshotsOption.ordinal() == 0) {
      paramURI.setRequestProperty("x-ms-delete-snapshots", "include");
    }
    return paramURI;
  }
  
  public static HttpURLConnection getAcl(URI paramURI, FileRequestOptions paramFileRequestOptions, AccessCondition paramAccessCondition, OperationContext paramOperationContext)
  {
    UriQueryBuilder localUriQueryBuilder = getShareUriQueryBuilder();
    localUriQueryBuilder.add("comp", "acl");
    paramURI = BaseRequest.createURLConnection(paramURI, paramFileRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setRequestMethod("GET");
    if ((paramAccessCondition != null) && (!Utility.isNullOrEmpty(paramAccessCondition.getLeaseID()))) {
      paramAccessCondition.applyLeaseConditionToRequest(paramURI);
    }
    return paramURI;
  }
  
  public static HttpURLConnection getDirectoryProperties(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, String paramString)
  {
    return getProperties(paramURI, paramFileRequestOptions, paramOperationContext, paramAccessCondition, getDirectoryUriQueryBuilder(), paramString);
  }
  
  public static UriQueryBuilder getDirectoryUriQueryBuilder()
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    try
    {
      localUriQueryBuilder.add("restype", "directory");
      return localUriQueryBuilder;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw Utility.generateNewUnexpectedStorageException(localIllegalArgumentException);
    }
  }
  
  public static HttpURLConnection getFile(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, String paramString, Long paramLong1, Long paramLong2, boolean paramBoolean)
  {
    if ((paramLong1 != null) && (paramBoolean))
    {
      Utility.assertNotNull("count", paramLong2);
      Utility.assertInBounds("count", paramLong2.longValue(), 1L, Constants.MAX_RANGE_CONTENT_MD5);
    }
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    addShareSnapshot(localUriQueryBuilder, paramString);
    paramURI = BaseRequest.createURLConnection(paramURI, paramFileRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setRequestMethod("GET");
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    if (paramLong1 != null)
    {
      long l1 = paramLong1.longValue();
      if (paramLong2 != null)
      {
        long l2 = paramLong1.longValue();
        long l3 = paramLong2.longValue();
        paramURI.setRequestProperty("x-ms-range", String.format(Utility.LOCALE_US, "bytes=%d-%d", new Object[] { Long.valueOf(l1), Long.valueOf(l3 + l2 - 1L) }));
      }
      else
      {
        paramURI.setRequestProperty("x-ms-range", String.format(Utility.LOCALE_US, "bytes=%d-", new Object[] { Long.valueOf(l1) }));
      }
    }
    if ((paramLong1 != null) && (paramBoolean)) {
      paramURI.setRequestProperty("x-ms-range-get-content-md5", "true");
    }
    return paramURI;
  }
  
  public static HttpURLConnection getFileProperties(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, String paramString)
  {
    return getProperties(paramURI, paramFileRequestOptions, paramOperationContext, paramAccessCondition, new UriQueryBuilder(), paramString);
  }
  
  public static HttpURLConnection getFileRanges(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, String paramString)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    addShareSnapshot(localUriQueryBuilder, paramString);
    localUriQueryBuilder.add("comp", "rangelist");
    paramURI = BaseRequest.createURLConnection(paramURI, paramFileRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setRequestMethod("GET");
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    return paramURI;
  }
  
  public static HttpURLConnection getProperties(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, UriQueryBuilder paramUriQueryBuilder, String paramString)
  {
    addShareSnapshot(paramUriQueryBuilder, paramString);
    paramURI = BaseRequest.getProperties(paramURI, paramFileRequestOptions, paramUriQueryBuilder, paramOperationContext);
    if (paramAccessCondition != null) {
      paramAccessCondition.applyLeaseConditionToRequest(paramURI);
    }
    return paramURI;
  }
  
  public static HttpURLConnection getShareProperties(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, String paramString)
  {
    return getProperties(paramURI, paramFileRequestOptions, paramOperationContext, paramAccessCondition, getShareUriQueryBuilder(), paramString);
  }
  
  public static HttpURLConnection getShareStats(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext)
  {
    UriQueryBuilder localUriQueryBuilder = getShareUriQueryBuilder();
    localUriQueryBuilder.add("comp", "stats");
    paramURI = BaseRequest.createURLConnection(paramURI, paramFileRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setRequestMethod("GET");
    return paramURI;
  }
  
  public static UriQueryBuilder getShareUriQueryBuilder()
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    try
    {
      localUriQueryBuilder.add("restype", "share");
      return localUriQueryBuilder;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw Utility.generateNewUnexpectedStorageException(localIllegalArgumentException);
    }
  }
  
  public static HttpURLConnection listFilesAndDirectories(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, ListingContext paramListingContext, String paramString)
  {
    UriQueryBuilder localUriQueryBuilder = getDirectoryUriQueryBuilder();
    addShareSnapshot(localUriQueryBuilder, paramString);
    localUriQueryBuilder.add("comp", "list");
    if (paramListingContext != null)
    {
      if (!Utility.isNullOrEmpty(paramListingContext.getMarker())) {
        localUriQueryBuilder.add("marker", paramListingContext.getMarker());
      }
      if ((paramListingContext.getMaxResults() != null) && (paramListingContext.getMaxResults().intValue() > 0)) {
        localUriQueryBuilder.add("maxresults", paramListingContext.getMaxResults().toString());
      }
      if (!Utility.isNullOrEmpty(paramListingContext.getPrefix())) {
        localUriQueryBuilder.add("prefix", paramListingContext.getPrefix().toString());
      }
    }
    paramURI = BaseRequest.createURLConnection(paramURI, paramFileRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setRequestMethod("GET");
    return paramURI;
  }
  
  public static HttpURLConnection listShares(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, ListingContext paramListingContext, EnumSet<ShareListingDetails> paramEnumSet)
  {
    paramListingContext = BaseRequest.getListUriQueryBuilder(paramListingContext);
    if ((paramEnumSet != null) && (paramEnumSet.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      if (paramEnumSet.contains(ShareListingDetails.SNAPSHOTS))
      {
        i = 1;
        localStringBuilder.append("snapshots");
      }
      if (paramEnumSet.contains(ShareListingDetails.METADATA))
      {
        if (i != 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append("metadata");
      }
      paramListingContext.add("include", localStringBuilder.toString());
    }
    paramURI = BaseRequest.createURLConnection(paramURI, paramFileRequestOptions, paramListingContext, paramOperationContext);
    paramURI.setRequestMethod("GET");
    return paramURI;
  }
  
  public static HttpURLConnection putFile(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, FileProperties paramFileProperties, long paramLong)
  {
    paramURI = BaseRequest.createURLConnection(paramURI, paramFileRequestOptions, null, paramOperationContext);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    addProperties(paramURI, paramFileProperties);
    paramURI.setFixedLengthStreamingMode(0);
    paramURI.setRequestProperty("Content-Length", "0");
    paramURI.setRequestProperty("x-ms-type", "File");
    paramURI.setRequestProperty("x-ms-content-length", String.valueOf(paramLong));
    paramFileProperties.setLength(paramLong);
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    return paramURI;
  }
  
  public static HttpURLConnection putRange(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, FileRange paramFileRange, FileRangeOperationType paramFileRangeOperationType)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("comp", "range");
    paramURI = BaseRequest.createURLConnection(paramURI, paramFileRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    if (paramFileRangeOperationType == FileRangeOperationType.CLEAR) {
      paramURI.setFixedLengthStreamingMode(0);
    }
    paramURI.setRequestProperty("x-ms-write", paramFileRangeOperationType.toString());
    paramURI.setRequestProperty("x-ms-range", paramFileRange.toString());
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    return paramURI;
  }
  
  public static HttpURLConnection resize(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, Long paramLong)
  {
    paramURI = setFileProperties(paramURI, paramFileRequestOptions, paramOperationContext, paramAccessCondition, null);
    if (paramLong != null) {
      paramURI.setRequestProperty("x-ms-content-length", paramLong.toString());
    }
    return paramURI;
  }
  
  public static HttpURLConnection setAcl(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition)
  {
    UriQueryBuilder localUriQueryBuilder = getShareUriQueryBuilder();
    localUriQueryBuilder.add("comp", "acl");
    paramURI = BaseRequest.createURLConnection(paramURI, paramFileRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setRequestMethod("PUT");
    paramURI.setDoOutput(true);
    if ((paramAccessCondition != null) && (!Utility.isNullOrEmpty(paramAccessCondition.getLeaseID()))) {
      paramAccessCondition.applyLeaseConditionToRequest(paramURI);
    }
    return paramURI;
  }
  
  public static HttpURLConnection setDirectoryMetadata(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition)
  {
    return setMetadata(paramURI, paramFileRequestOptions, paramOperationContext, paramAccessCondition, getDirectoryUriQueryBuilder());
  }
  
  public static HttpURLConnection setFileMetadata(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition)
  {
    return setMetadata(paramURI, paramFileRequestOptions, paramOperationContext, paramAccessCondition, null);
  }
  
  public static HttpURLConnection setFileProperties(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, FileProperties paramFileProperties)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("comp", "properties");
    paramURI = BaseRequest.createURLConnection(paramURI, paramFileRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setFixedLengthStreamingMode(0);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    if (paramFileProperties != null) {
      addProperties(paramURI, paramFileProperties);
    }
    return paramURI;
  }
  
  public static HttpURLConnection setMetadata(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, UriQueryBuilder paramUriQueryBuilder)
  {
    paramURI = BaseRequest.setMetadata(paramURI, paramFileRequestOptions, paramUriQueryBuilder, paramOperationContext);
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    return paramURI;
  }
  
  public static HttpURLConnection setShareMetadata(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition)
  {
    return setMetadata(paramURI, paramFileRequestOptions, paramOperationContext, paramAccessCondition, getShareUriQueryBuilder());
  }
  
  public static HttpURLConnection setShareProperties(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, FileShareProperties paramFileShareProperties)
  {
    UriQueryBuilder localUriQueryBuilder = getShareUriQueryBuilder();
    localUriQueryBuilder.add("comp", "properties");
    paramURI = BaseRequest.createURLConnection(paramURI, paramFileRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setFixedLengthStreamingMode(0);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    if (paramFileShareProperties != null) {
      addProperties(paramURI, paramFileShareProperties);
    }
    return paramURI;
  }
  
  public static HttpURLConnection snapshotShare(URI paramURI, FileRequestOptions paramFileRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("restype", "share");
    localUriQueryBuilder.add("comp", "snapshot");
    paramURI = BaseRequest.createURLConnection(paramURI, paramFileRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setFixedLengthStreamingMode(0);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    return paramURI;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.file.FileRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */