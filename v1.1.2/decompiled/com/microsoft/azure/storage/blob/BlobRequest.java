package com.microsoft.azure.storage.blob;

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
import java.util.HashMap;

public final class BlobRequest
{
  public static final String APPEND_BLOCK_QUERY_ELEMENT_NAME = "appendblock";
  public static final String BLOCK_ID_QUERY_ELEMENT_NAME = "blockid";
  public static final String BLOCK_LIST_QUERY_ELEMENT_NAME = "blocklist";
  public static final String BLOCK_LIST_TYPE_QUERY_ELEMENT_NAME = "blocklisttype";
  public static final String BLOCK_QUERY_ELEMENT_NAME = "block";
  public static final String COPY_QUERY_ELEMENT_NAME = "copy";
  public static final String DELETED_QUERY_ELEMENT_NAME = "deleted";
  public static final String PAGE_LIST_QUERY_ELEMENT_NAME = "pagelist";
  public static final String PAGE_QUERY_ELEMENT_NAME = "page";
  public static final String SNAPSHOTS_QUERY_ELEMENT_NAME = "snapshots";
  public static final String TIER_QUERY_ELEMENT_NAME = "tier";
  public static final String UNCOMMITTED_BLOBS_QUERY_ELEMENT_NAME = "uncommittedblobs";
  
  public static HttpURLConnection abortCopy(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, String paramString)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("comp", "copy");
    localUriQueryBuilder.add("copyid", paramString);
    paramURI = BaseRequest.createURLConnection(paramURI, paramBlobRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setFixedLengthStreamingMode(0);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    paramURI.setRequestProperty("x-ms-copy-action", "abort");
    if (paramAccessCondition != null) {
      paramAccessCondition.applyLeaseConditionToRequest(paramURI);
    }
    return paramURI;
  }
  
  public static void addMetadata(HttpURLConnection paramHttpURLConnection, HashMap<String, String> paramHashMap, OperationContext paramOperationContext)
  {
    BaseRequest.addMetadata(paramHttpURLConnection, paramHashMap, paramOperationContext);
  }
  
  public static void addProperties(HttpURLConnection paramHttpURLConnection, BlobProperties paramBlobProperties)
  {
    BaseRequest.addOptionalHeader(paramHttpURLConnection, "x-ms-blob-cache-control", paramBlobProperties.getCacheControl());
    BaseRequest.addOptionalHeader(paramHttpURLConnection, "x-ms-blob-content-disposition", paramBlobProperties.getContentDisposition());
    BaseRequest.addOptionalHeader(paramHttpURLConnection, "x-ms-blob-content-encoding", paramBlobProperties.getContentEncoding());
    BaseRequest.addOptionalHeader(paramHttpURLConnection, "x-ms-blob-content-language", paramBlobProperties.getContentLanguage());
    BaseRequest.addOptionalHeader(paramHttpURLConnection, "x-ms-blob-content-md5", paramBlobProperties.getContentMD5());
    BaseRequest.addOptionalHeader(paramHttpURLConnection, "x-ms-blob-content-type", paramBlobProperties.getContentType());
  }
  
  public static void addRange(HttpURLConnection paramHttpURLConnection, Long paramLong1, Long paramLong2)
  {
    addRangeImpl("x-ms-range", paramHttpURLConnection, paramLong1, paramLong2);
  }
  
  public static void addRangeImpl(String paramString, HttpURLConnection paramHttpURLConnection, Long paramLong1, Long paramLong2)
  {
    if (paramLong2 != null)
    {
      Utility.assertNotNull("offset", paramLong1);
      Utility.assertInBounds("count", paramLong2.longValue(), 1L, Long.MAX_VALUE);
    }
    if (paramLong1 != null)
    {
      long l1 = paramLong1.longValue();
      if (paramLong2 != null)
      {
        long l2 = paramLong1.longValue();
        long l3 = paramLong2.longValue();
        paramHttpURLConnection.setRequestProperty(paramString, String.format(Utility.LOCALE_US, "bytes=%d-%d", new Object[] { Long.valueOf(l1), Long.valueOf(l3 + l2 - 1L) }));
      }
      else
      {
        paramHttpURLConnection.setRequestProperty(paramString, String.format(Utility.LOCALE_US, "bytes=%d-", new Object[] { Long.valueOf(l1) }));
      }
    }
  }
  
  public static void addSnapshot(UriQueryBuilder paramUriQueryBuilder, String paramString)
  {
    if (paramString != null) {
      paramUriQueryBuilder.add("snapshot", paramString);
    }
  }
  
  public static void addSourceRange(HttpURLConnection paramHttpURLConnection, Long paramLong1, Long paramLong2)
  {
    addRangeImpl("x-ms-source-range", paramHttpURLConnection, paramLong1, paramLong2);
  }
  
  public static HttpURLConnection appendBlock(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("comp", "appendblock");
    paramURI = createURLConnection(paramURI, localUriQueryBuilder, paramBlobRequestOptions, paramOperationContext);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    if (paramAccessCondition != null)
    {
      paramAccessCondition.applyConditionToRequest(paramURI);
      paramAccessCondition.applyAppendConditionToRequest(paramURI);
    }
    return paramURI;
  }
  
  public static HttpURLConnection copyFrom(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition1, AccessCondition paramAccessCondition2, String paramString1, String paramString2, boolean paramBoolean, PremiumPageBlobTier paramPremiumPageBlobTier)
  {
    return copyFrom(paramURI, paramBlobRequestOptions, paramOperationContext, paramAccessCondition1, paramAccessCondition2, paramString1, paramString2, paramBoolean, false, null, paramPremiumPageBlobTier);
  }
  
  public static HttpURLConnection copyFrom(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition1, AccessCondition paramAccessCondition2, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, String paramString3, PremiumPageBlobTier paramPremiumPageBlobTier)
  {
    if ((!paramBoolean2) && (!Utility.isNullOrEmpty(paramString3))) {
      throw new IllegalArgumentException("MD5 can only be specified with a synchronous copy operation.");
    }
    String str = paramString1;
    if (paramString2 != null) {
      str = paramString1.concat("?snapshot=").concat(paramString2);
    }
    paramString1 = null;
    if (paramBoolean1)
    {
      paramString1 = new UriQueryBuilder();
      paramString1.add("comp", "incrementalcopy");
    }
    paramURI = BaseRequest.createURLConnection(paramURI, paramBlobRequestOptions, paramString1, paramOperationContext);
    paramURI.setFixedLengthStreamingMode(0);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    paramURI.setRequestProperty("x-ms-copy-source", str);
    if (paramPremiumPageBlobTier != null) {
      paramURI.setRequestProperty("x-ms-access-tier", String.valueOf(paramPremiumPageBlobTier));
    }
    if (paramAccessCondition1 != null) {
      paramAccessCondition1.applySourceConditionToRequest(paramURI);
    }
    if (paramAccessCondition2 != null) {
      paramAccessCondition2.applyConditionToRequest(paramURI);
    }
    if (paramBoolean2) {
      paramURI.setRequestProperty("x-ms-requires-sync", "true");
    }
    if (!Utility.isNullOrEmpty(paramString3)) {
      paramURI.setRequestProperty("x-ms-source-content-md5", paramString3);
    }
    return paramURI;
  }
  
  public static HttpURLConnection createContainer(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, BlobContainerPublicAccessType paramBlobContainerPublicAccessType)
  {
    if (paramBlobContainerPublicAccessType != BlobContainerPublicAccessType.UNKNOWN)
    {
      paramURI = BaseRequest.create(paramURI, paramBlobRequestOptions, getContainerUriQueryBuilder(), paramOperationContext);
      if ((paramBlobContainerPublicAccessType != null) && (paramBlobContainerPublicAccessType != BlobContainerPublicAccessType.OFF)) {
        paramURI.setRequestProperty("x-ms-blob-public-access", paramBlobContainerPublicAccessType.toString().toLowerCase());
      }
      return paramURI;
    }
    throw new IllegalArgumentException(String.format(Utility.LOCALE_US, "The argument is out of range. Argument name: %s, Value passed: %s.", new Object[] { "accessType", paramBlobContainerPublicAccessType }));
  }
  
  public static HttpURLConnection createURLConnection(URI paramURI, UriQueryBuilder paramUriQueryBuilder, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    return BaseRequest.createURLConnection(paramURI, paramBlobRequestOptions, paramUriQueryBuilder, paramOperationContext);
  }
  
  public static HttpURLConnection deleteBlob(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, String paramString, DeleteSnapshotsOption paramDeleteSnapshotsOption)
  {
    if ((paramString != null) && (paramDeleteSnapshotsOption != DeleteSnapshotsOption.NONE)) {
      throw new IllegalArgumentException(String.format("The option '%s' must be 'None' to delete a specific snapshot specified by '%s'.", new Object[] { "deleteSnapshotsOption", "snapshot" }));
    }
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    addSnapshot(localUriQueryBuilder, paramString);
    paramURI = BaseRequest.delete(paramURI, paramBlobRequestOptions, localUriQueryBuilder, paramOperationContext);
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    int i = paramDeleteSnapshotsOption.ordinal();
    if (i != 0)
    {
      if (i == 1) {
        paramURI.setRequestProperty("x-ms-delete-snapshots", "include");
      }
    }
    else {
      paramURI.setRequestProperty("x-ms-delete-snapshots", "only");
    }
    return paramURI;
  }
  
  public static HttpURLConnection deleteContainer(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition)
  {
    paramURI = BaseRequest.delete(paramURI, paramBlobRequestOptions, getContainerUriQueryBuilder(), paramOperationContext);
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    return paramURI;
  }
  
  public static HttpURLConnection getAcl(URI paramURI, BlobRequestOptions paramBlobRequestOptions, AccessCondition paramAccessCondition, OperationContext paramOperationContext)
  {
    UriQueryBuilder localUriQueryBuilder = getContainerUriQueryBuilder();
    localUriQueryBuilder.add("comp", "acl");
    paramURI = createURLConnection(paramURI, localUriQueryBuilder, paramBlobRequestOptions, paramOperationContext);
    paramURI.setRequestMethod("GET");
    if (paramAccessCondition != null) {
      paramAccessCondition.applyLeaseConditionToRequest(paramURI);
    }
    return paramURI;
  }
  
  public static HttpURLConnection getBlob(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, String paramString, Long paramLong1, Long paramLong2, boolean paramBoolean)
  {
    if ((paramLong1 != null) && (paramBoolean))
    {
      Utility.assertNotNull("count", paramLong2);
      Utility.assertInBounds("count", paramLong2.longValue(), 1L, Constants.MAX_RANGE_CONTENT_MD5);
    }
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    addSnapshot(localUriQueryBuilder, paramString);
    paramURI = BaseRequest.createURLConnection(paramURI, paramBlobRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setRequestMethod("GET");
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    addRange(paramURI, paramLong1, paramLong2);
    if ((paramLong1 != null) && (paramBoolean)) {
      paramURI.setRequestProperty("x-ms-range-get-content-md5", "true");
    }
    return paramURI;
  }
  
  public static HttpURLConnection getBlobProperties(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, String paramString)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    addSnapshot(localUriQueryBuilder, paramString);
    return getProperties(paramURI, paramBlobRequestOptions, paramOperationContext, paramAccessCondition, localUriQueryBuilder);
  }
  
  public static HttpURLConnection getBlockList(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, String paramString, BlockListingFilter paramBlockListingFilter)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("comp", "blocklist");
    localUriQueryBuilder.add("blocklisttype", paramBlockListingFilter.toString());
    addSnapshot(localUriQueryBuilder, paramString);
    paramURI = BaseRequest.createURLConnection(paramURI, paramBlobRequestOptions, localUriQueryBuilder, paramOperationContext);
    paramURI.setRequestMethod("GET");
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    return paramURI;
  }
  
  public static HttpURLConnection getContainerProperties(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition)
  {
    return getProperties(paramURI, paramBlobRequestOptions, paramOperationContext, paramAccessCondition, getContainerUriQueryBuilder());
  }
  
  public static UriQueryBuilder getContainerUriQueryBuilder()
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    try
    {
      localUriQueryBuilder.add("restype", "container");
      return localUriQueryBuilder;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw Utility.generateNewUnexpectedStorageException(localIllegalArgumentException);
    }
  }
  
  public static HttpURLConnection getPageRanges(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, String paramString, Long paramLong1, Long paramLong2)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("comp", "pagelist");
    addSnapshot(localUriQueryBuilder, paramString);
    paramURI = createURLConnection(paramURI, localUriQueryBuilder, paramBlobRequestOptions, paramOperationContext);
    paramURI.setRequestMethod("GET");
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    addRange(paramURI, paramLong1, paramLong2);
    return paramURI;
  }
  
  public static HttpURLConnection getPageRangesDiff(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, String paramString1, String paramString2, Long paramLong1, Long paramLong2)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("comp", "pagelist");
    localUriQueryBuilder.add("prevsnapshot", paramString2);
    addSnapshot(localUriQueryBuilder, paramString1);
    paramURI = createURLConnection(paramURI, localUriQueryBuilder, paramBlobRequestOptions, paramOperationContext);
    paramURI.setRequestMethod("GET");
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    addRange(paramURI, paramLong1, paramLong2);
    return paramURI;
  }
  
  public static HttpURLConnection getProperties(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, UriQueryBuilder paramUriQueryBuilder)
  {
    paramURI = BaseRequest.getProperties(paramURI, paramBlobRequestOptions, paramUriQueryBuilder, paramOperationContext);
    if (paramAccessCondition != null) {
      paramAccessCondition.applyLeaseConditionToRequest(paramURI);
    }
    return paramURI;
  }
  
  public static HttpURLConnection lease(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, LeaseAction paramLeaseAction, Integer paramInteger1, String paramString, Integer paramInteger2, UriQueryBuilder paramUriQueryBuilder)
  {
    paramBlobRequestOptions = createURLConnection(paramURI, paramUriQueryBuilder, paramBlobRequestOptions, paramOperationContext);
    paramBlobRequestOptions.setDoOutput(true);
    paramBlobRequestOptions.setRequestMethod("PUT");
    paramBlobRequestOptions.setFixedLengthStreamingMode(0);
    paramBlobRequestOptions.setRequestProperty("x-ms-lease-action", paramLeaseAction.toString());
    if (paramLeaseAction == LeaseAction.ACQUIRE)
    {
      if ((paramInteger1 != null) && (paramInteger1.intValue() != -1)) {
        Utility.assertInBounds("leaseTimeInSeconds", paramInteger1.intValue(), 15L, 60L);
      }
      if (paramInteger1 == null) {
        paramURI = "-1";
      } else {
        paramURI = paramInteger1.toString();
      }
      paramBlobRequestOptions.setRequestProperty("x-ms-lease-duration", paramURI);
    }
    if (paramString != null) {
      paramBlobRequestOptions.setRequestProperty("x-ms-proposed-lease-id", paramString);
    }
    if (paramInteger2 != null)
    {
      Utility.assertInBounds("breakPeriodInSeconds", paramInteger2.intValue(), 0L, 60L);
      paramBlobRequestOptions.setRequestProperty("x-ms-lease-break-period", paramInteger2.toString());
    }
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramBlobRequestOptions);
    }
    return paramBlobRequestOptions;
  }
  
  public static HttpURLConnection leaseBlob(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, LeaseAction paramLeaseAction, Integer paramInteger1, String paramString, Integer paramInteger2)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("comp", "lease");
    return lease(paramURI, paramBlobRequestOptions, paramOperationContext, paramAccessCondition, paramLeaseAction, paramInteger1, paramString, paramInteger2, localUriQueryBuilder);
  }
  
  public static HttpURLConnection leaseContainer(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, LeaseAction paramLeaseAction, Integer paramInteger1, String paramString, Integer paramInteger2)
  {
    UriQueryBuilder localUriQueryBuilder = getContainerUriQueryBuilder();
    localUriQueryBuilder.add("comp", "lease");
    return lease(paramURI, paramBlobRequestOptions, paramOperationContext, paramAccessCondition, paramLeaseAction, paramInteger1, paramString, paramInteger2, localUriQueryBuilder);
  }
  
  public static HttpURLConnection listBlobs(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, BlobListingContext paramBlobListingContext)
  {
    UriQueryBuilder localUriQueryBuilder = getContainerUriQueryBuilder();
    localUriQueryBuilder.add("comp", "list");
    if (paramBlobListingContext != null)
    {
      if (!Utility.isNullOrEmpty(paramBlobListingContext.getPrefix())) {
        localUriQueryBuilder.add("prefix", paramBlobListingContext.getPrefix());
      }
      if (!Utility.isNullOrEmpty(paramBlobListingContext.getDelimiter())) {
        localUriQueryBuilder.add("delimiter", paramBlobListingContext.getDelimiter());
      }
      if (!Utility.isNullOrEmpty(paramBlobListingContext.getMarker())) {
        localUriQueryBuilder.add("marker", paramBlobListingContext.getMarker());
      }
      if ((paramBlobListingContext.getMaxResults() != null) && (paramBlobListingContext.getMaxResults().intValue() > 0)) {
        localUriQueryBuilder.add("maxresults", paramBlobListingContext.getMaxResults().toString());
      }
      if ((paramBlobListingContext.getListingDetails() != null) && (paramBlobListingContext.getListingDetails().size() > 0))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        int i = 0;
        boolean bool = paramBlobListingContext.getListingDetails().contains(BlobListingDetails.SNAPSHOTS);
        int j = 1;
        if (bool)
        {
          localStringBuilder.append("snapshots");
          i = 1;
        }
        int k = i;
        if (paramBlobListingContext.getListingDetails().contains(BlobListingDetails.UNCOMMITTED_BLOBS))
        {
          if (i == 0)
          {
            k = 1;
          }
          else
          {
            localStringBuilder.append(",");
            k = i;
          }
          localStringBuilder.append("uncommittedblobs");
        }
        i = k;
        if (paramBlobListingContext.getListingDetails().contains(BlobListingDetails.COPY))
        {
          if (k == 0) {
            k = 1;
          } else {
            localStringBuilder.append(",");
          }
          localStringBuilder.append("copy");
          i = k;
        }
        k = i;
        if (paramBlobListingContext.getListingDetails().contains(BlobListingDetails.METADATA))
        {
          if (i == 0)
          {
            k = j;
          }
          else
          {
            localStringBuilder.append(",");
            k = i;
          }
          localStringBuilder.append("metadata");
        }
        if (paramBlobListingContext.getListingDetails().contains(BlobListingDetails.DELETED))
        {
          if (k != 0) {
            localStringBuilder.append(",");
          }
          localStringBuilder.append("deleted");
        }
        localUriQueryBuilder.add("include", localStringBuilder.toString());
      }
    }
    paramURI = createURLConnection(paramURI, localUriQueryBuilder, paramBlobRequestOptions, paramOperationContext);
    paramURI.setRequestMethod("GET");
    return paramURI;
  }
  
  public static HttpURLConnection listContainers(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, ListingContext paramListingContext, ContainerListingDetails paramContainerListingDetails)
  {
    paramListingContext = BaseRequest.getListUriQueryBuilder(paramListingContext);
    if ((paramContainerListingDetails == ContainerListingDetails.ALL) || (paramContainerListingDetails == ContainerListingDetails.METADATA)) {
      paramListingContext.add("include", "metadata");
    }
    paramURI = createURLConnection(paramURI, paramListingContext, paramBlobRequestOptions, paramOperationContext);
    paramURI.setRequestMethod("GET");
    return paramURI;
  }
  
  public static HttpURLConnection putBlob(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, BlobProperties paramBlobProperties, BlobType paramBlobType, long paramLong)
  {
    return putBlob(paramURI, paramBlobRequestOptions, paramOperationContext, paramAccessCondition, paramBlobProperties, paramBlobType, paramLong, null);
  }
  
  public static HttpURLConnection putBlob(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, BlobProperties paramBlobProperties, BlobType paramBlobType, long paramLong, PremiumPageBlobTier paramPremiumPageBlobTier)
  {
    if (paramBlobType != BlobType.UNSPECIFIED)
    {
      paramURI = createURLConnection(paramURI, null, paramBlobRequestOptions, paramOperationContext);
      paramURI.setDoOutput(true);
      paramURI.setRequestMethod("PUT");
      addProperties(paramURI, paramBlobProperties);
      if (paramBlobType == BlobType.PAGE_BLOB)
      {
        paramURI.setFixedLengthStreamingMode(0);
        paramURI.setRequestProperty("Content-Length", "0");
        paramURI.setRequestProperty("x-ms-blob-type", "PageBlob");
        paramURI.setRequestProperty("x-ms-blob-content-length", String.valueOf(paramLong));
        if (paramPremiumPageBlobTier != null) {
          paramURI.setRequestProperty("x-ms-access-tier", String.valueOf(paramPremiumPageBlobTier));
        }
        paramBlobProperties.setLength(paramLong);
      }
      else if (paramBlobType == BlobType.BLOCK_BLOB)
      {
        paramURI.setRequestProperty("x-ms-blob-type", "BlockBlob");
      }
      else if (paramBlobType == BlobType.APPEND_BLOB)
      {
        paramURI.setFixedLengthStreamingMode(0);
        paramURI.setRequestProperty("x-ms-blob-type", "AppendBlob");
        paramURI.setRequestProperty("Content-Length", "0");
      }
      if (paramAccessCondition != null) {
        paramAccessCondition.applyConditionToRequest(paramURI);
      }
      return paramURI;
    }
    throw new IllegalArgumentException("The blob type is not defined.  Allowed types are BlobType.BLOCK_BLOB and BlobType.Page_BLOB.");
  }
  
  public static HttpURLConnection putBlock(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, String paramString)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("comp", "block");
    localUriQueryBuilder.add("blockid", paramString);
    paramURI = createURLConnection(paramURI, localUriQueryBuilder, paramBlobRequestOptions, paramOperationContext);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    return paramURI;
  }
  
  public static HttpURLConnection putBlock(URI paramURI, String paramString1, long paramLong, Long paramLong1, BlobRequestOptions paramBlobRequestOptions, String paramString2, OperationContext paramOperationContext, AccessCondition paramAccessCondition, String paramString3)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("comp", "block");
    localUriQueryBuilder.add("blockid", paramString3);
    paramURI = createURLConnection(paramURI, localUriQueryBuilder, paramBlobRequestOptions, paramOperationContext);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    paramURI.setFixedLengthStreamingMode(0);
    paramURI.setRequestProperty("Content-Length", "0");
    paramURI.setRequestProperty("x-ms-copy-source", paramString1);
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    addSourceRange(paramURI, Long.valueOf(paramLong), paramLong1);
    BaseRequest.addOptionalHeader(paramURI, "x-ms-source-content-md5", paramString2);
    return paramURI;
  }
  
  public static HttpURLConnection putBlockList(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, BlobProperties paramBlobProperties)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("comp", "blocklist");
    paramURI = createURLConnection(paramURI, localUriQueryBuilder, paramBlobRequestOptions, paramOperationContext);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    addProperties(paramURI, paramBlobProperties);
    return paramURI;
  }
  
  public static HttpURLConnection putPage(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, PageRange paramPageRange, PageOperationType paramPageOperationType)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("comp", "page");
    paramURI = createURLConnection(paramURI, localUriQueryBuilder, paramBlobRequestOptions, paramOperationContext);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    if (paramPageOperationType == PageOperationType.CLEAR) {
      paramURI.setFixedLengthStreamingMode(0);
    }
    paramURI.setRequestProperty("x-ms-page-write", paramPageOperationType.toString());
    paramURI.setRequestProperty("x-ms-range", paramPageRange.toString());
    if (paramAccessCondition != null)
    {
      paramAccessCondition.applyConditionToRequest(paramURI);
      paramAccessCondition.applySequenceConditionToRequest(paramURI);
    }
    return paramURI;
  }
  
  public static HttpURLConnection resize(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, Long paramLong)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("comp", "properties");
    paramURI = createURLConnection(paramURI, localUriQueryBuilder, paramBlobRequestOptions, paramOperationContext);
    paramURI.setFixedLengthStreamingMode(0);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    if (paramLong != null) {
      paramURI.setRequestProperty("x-ms-blob-content-length", paramLong.toString());
    }
    return paramURI;
  }
  
  public static HttpURLConnection setAcl(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, BlobContainerPublicAccessType paramBlobContainerPublicAccessType)
  {
    if (paramBlobContainerPublicAccessType != BlobContainerPublicAccessType.UNKNOWN)
    {
      UriQueryBuilder localUriQueryBuilder = getContainerUriQueryBuilder();
      localUriQueryBuilder.add("comp", "acl");
      paramURI = createURLConnection(paramURI, localUriQueryBuilder, paramBlobRequestOptions, paramOperationContext);
      paramURI.setRequestMethod("PUT");
      paramURI.setDoOutput(true);
      if (paramBlobContainerPublicAccessType != BlobContainerPublicAccessType.OFF) {
        paramURI.setRequestProperty("x-ms-blob-public-access", paramBlobContainerPublicAccessType.toString().toLowerCase());
      }
      if (paramAccessCondition != null) {
        paramAccessCondition.applyLeaseConditionToRequest(paramURI);
      }
      return paramURI;
    }
    throw new IllegalArgumentException(String.format(Utility.LOCALE_US, "The argument is out of range. Argument name: %s, Value passed: %s.", new Object[] { "accessType", paramBlobContainerPublicAccessType }));
  }
  
  public static HttpURLConnection setBlobMetadata(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition)
  {
    return setMetadata(paramURI, paramBlobRequestOptions, paramOperationContext, paramAccessCondition, null);
  }
  
  public static HttpURLConnection setBlobProperties(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, BlobProperties paramBlobProperties)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("comp", "properties");
    paramURI = createURLConnection(paramURI, localUriQueryBuilder, paramBlobRequestOptions, paramOperationContext);
    paramURI.setFixedLengthStreamingMode(0);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    if (paramBlobProperties != null) {
      addProperties(paramURI, paramBlobProperties);
    }
    return paramURI;
  }
  
  public static HttpURLConnection setBlobTier(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, String paramString)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("comp", "tier");
    paramURI = createURLConnection(paramURI, localUriQueryBuilder, paramBlobRequestOptions, paramOperationContext);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    paramURI.setFixedLengthStreamingMode(0);
    paramURI.setRequestProperty("Content-Length", "0");
    paramURI.setRequestProperty("x-ms-access-tier", paramString);
    return paramURI;
  }
  
  public static HttpURLConnection setContainerMetadata(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition)
  {
    return setMetadata(paramURI, paramBlobRequestOptions, paramOperationContext, paramAccessCondition, getContainerUriQueryBuilder());
  }
  
  public static HttpURLConnection setMetadata(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition, UriQueryBuilder paramUriQueryBuilder)
  {
    paramURI = BaseRequest.setMetadata(paramURI, paramBlobRequestOptions, paramUriQueryBuilder, paramOperationContext);
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    return paramURI;
  }
  
  public static HttpURLConnection snapshot(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext, AccessCondition paramAccessCondition)
  {
    UriQueryBuilder localUriQueryBuilder = new UriQueryBuilder();
    localUriQueryBuilder.add("comp", "snapshot");
    paramURI = createURLConnection(paramURI, localUriQueryBuilder, paramBlobRequestOptions, paramOperationContext);
    paramURI.setFixedLengthStreamingMode(0);
    paramURI.setDoOutput(true);
    paramURI.setRequestMethod("PUT");
    if (paramAccessCondition != null) {
      paramAccessCondition.applyConditionToRequest(paramURI);
    }
    return paramURI;
  }
  
  public static HttpURLConnection undeleteBlob(URI paramURI, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    return BaseRequest.undelete(paramURI, paramBlobRequestOptions, new UriQueryBuilder(), paramOperationContext);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.BlobRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */