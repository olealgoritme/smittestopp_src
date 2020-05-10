package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccountInformation;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.core.BaseResponse;
import com.microsoft.azure.storage.core.PathUtility;
import com.microsoft.azure.storage.core.Utility;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;

public final class BlobResponse
  extends BaseResponse
{
  public static AccountInformation getAccountInformation(HttpURLConnection paramHttpURLConnection)
  {
    AccountInformation localAccountInformation = new AccountInformation();
    localAccountInformation.setSkuName(paramHttpURLConnection.getHeaderField("x-ms-sku-name"));
    localAccountInformation.setAccountKind(paramHttpURLConnection.getHeaderField("x-ms-account-kind"));
    return localAccountInformation;
  }
  
  public static String getAcl(HttpURLConnection paramHttpURLConnection)
  {
    return paramHttpURLConnection.getHeaderField("x-ms-blob-public-access");
  }
  
  public static BlobAttributes getBlobAttributes(HttpURLConnection paramHttpURLConnection, StorageUri paramStorageUri, String paramString)
  {
    BlobAttributes localBlobAttributes = new BlobAttributes(BlobType.parse(paramHttpURLConnection.getHeaderField("x-ms-blob-type")));
    BlobProperties localBlobProperties = localBlobAttributes.getProperties();
    localBlobProperties.setCacheControl(paramHttpURLConnection.getHeaderField("Cache-Control"));
    localBlobProperties.setContentDisposition(paramHttpURLConnection.getHeaderField("Content-Disposition"));
    localBlobProperties.setContentEncoding(paramHttpURLConnection.getHeaderField("Content-Encoding"));
    localBlobProperties.setContentLanguage(paramHttpURLConnection.getHeaderField("Content-Language"));
    if (!Utility.isNullOrEmpty(paramHttpURLConnection.getHeaderField("Content-Range"))) {
      localBlobProperties.setContentMD5(paramHttpURLConnection.getHeaderField("x-ms-blob-content-md5"));
    } else {
      localBlobProperties.setContentMD5(paramHttpURLConnection.getHeaderField("Content-MD5"));
    }
    localBlobProperties.setContentType(paramHttpURLConnection.getHeaderField("Content-Type"));
    localBlobProperties.setEtag(BaseResponse.getEtag(paramHttpURLConnection));
    localBlobProperties.setServerEncrypted("true".equals(paramHttpURLConnection.getHeaderField("x-ms-server-encrypted")));
    Object localObject1 = Calendar.getInstance(Utility.LOCALE_US);
    ((Calendar)localObject1).setTimeZone(Utility.UTC_ZONE);
    ((Calendar)localObject1).setTime(new Date(paramHttpURLConnection.getLastModified()));
    localBlobProperties.setLastModified(((Calendar)localObject1).getTime());
    localBlobProperties.setLeaseStatus(getLeaseStatus(paramHttpURLConnection));
    localBlobProperties.setLeaseState(getLeaseState(paramHttpURLConnection));
    localBlobProperties.setLeaseDuration(getLeaseDuration(paramHttpURLConnection));
    localObject1 = paramHttpURLConnection.getHeaderField("Content-Range");
    Object localObject2 = paramHttpURLConnection.getHeaderField("x-ms-blob-content-length");
    if (!Utility.isNullOrEmpty((String)localObject1))
    {
      localBlobProperties.setLength(Long.parseLong(localObject1.split("/")[1]));
    }
    else if (!Utility.isNullOrEmpty((String)localObject2))
    {
      localBlobProperties.setLength(Long.parseLong((String)localObject2));
    }
    else
    {
      localObject1 = paramHttpURLConnection.getHeaderField("Content-Length");
      if (!Utility.isNullOrEmpty((String)localObject1)) {
        localBlobProperties.setLength(Long.parseLong((String)localObject1));
      }
    }
    localObject1 = paramHttpURLConnection.getHeaderField("x-ms-blob-sequence-number");
    if (!Utility.isNullOrEmpty((String)localObject1)) {
      localBlobProperties.setPageBlobSequenceNumber(Long.valueOf(Long.parseLong((String)localObject1)));
    }
    localObject1 = paramHttpURLConnection.getHeaderField("x-ms-blob-committed-block-count");
    if (!Utility.isNullOrEmpty((String)localObject1)) {
      localBlobProperties.setAppendBlobCommittedBlockCount(Integer.valueOf(Integer.parseInt((String)localObject1)));
    }
    localObject2 = paramHttpURLConnection.getHeaderField("x-ms-access-tier");
    if ((!Utility.isNullOrEmpty((String)localObject2)) && (localBlobProperties.getBlobType().equals(BlobType.PAGE_BLOB)))
    {
      localBlobProperties.setPremiumPageBlobTier(PremiumPageBlobTier.parse((String)localObject2));
    }
    else if ((!Utility.isNullOrEmpty((String)localObject2)) && (localBlobProperties.getBlobType().equals(BlobType.BLOCK_BLOB)))
    {
      localBlobProperties.setStandardBlobTier(StandardBlobTier.parse((String)localObject2));
    }
    else if ((!Utility.isNullOrEmpty((String)localObject2)) && (localBlobProperties.getBlobType().equals(BlobType.UNSPECIFIED)))
    {
      localObject1 = PremiumPageBlobTier.parse((String)localObject2);
      localObject2 = StandardBlobTier.parse((String)localObject2);
      if (!((Enum)localObject1).equals(PremiumPageBlobTier.UNKNOWN))
      {
        localBlobProperties.setPremiumPageBlobTier((PremiumPageBlobTier)localObject1);
      }
      else if (!((Enum)localObject2).equals(StandardBlobTier.UNKNOWN))
      {
        localBlobProperties.setStandardBlobTier((StandardBlobTier)localObject2);
      }
      else
      {
        localBlobProperties.setPremiumPageBlobTier(PremiumPageBlobTier.UNKNOWN);
        localBlobProperties.setStandardBlobTier(StandardBlobTier.UNKNOWN);
      }
    }
    localObject1 = paramHttpURLConnection.getHeaderField("x-ms-access-tier-inferred");
    if (!Utility.isNullOrEmpty((String)localObject1)) {
      localBlobProperties.setBlobTierInferred(Boolean.valueOf(Boolean.parseBoolean((String)localObject1)));
    } else if ((localBlobProperties.getPremiumPageBlobTier() != null) || (localBlobProperties.getStandardBlobTier() != null)) {
      localBlobProperties.setBlobTierInferred(Boolean.valueOf(false));
    }
    localObject1 = paramHttpURLConnection.getHeaderField("x-ms-archive-status");
    if (!Utility.isNullOrEmpty((String)localObject1)) {
      localBlobProperties.setRehydrationStatus(RehydrationStatus.parse((String)localObject1));
    } else {
      localBlobProperties.setRehydrationStatus(null);
    }
    long l = paramHttpURLConnection.getHeaderFieldDate("x-ms-access-tier-change-time", 0L);
    if (l != 0L) {
      localBlobProperties.setTierChangeTime(new Date(l));
    }
    l = paramHttpURLConnection.getHeaderFieldDate("x-ms-creation-time", 0L);
    if (l != 0L) {
      localBlobProperties.setCreatedTime(new Date(l));
    }
    localObject1 = paramHttpURLConnection.getHeaderField("x-ms-incremental-copy");
    if (!Utility.isNullOrEmpty((String)localObject1)) {
      localBlobProperties.setIncrementalCopy("true".equals(localObject1));
    }
    localBlobAttributes.setStorageUri(paramStorageUri);
    localBlobAttributes.setSnapshotID(paramString);
    localBlobAttributes.setMetadata(BaseResponse.getMetadata(paramHttpURLConnection));
    localBlobProperties.setCopyState(getCopyState(paramHttpURLConnection));
    localBlobAttributes.setProperties(localBlobProperties);
    return localBlobAttributes;
  }
  
  public static BlobContainerAttributes getBlobContainerAttributes(HttpURLConnection paramHttpURLConnection, boolean paramBoolean)
  {
    BlobContainerAttributes localBlobContainerAttributes = new BlobContainerAttributes();
    try
    {
      Object localObject = PathUtility.stripSingleURIQueryAndFragment(paramHttpURLConnection.getURL().toURI());
      localBlobContainerAttributes.setName(PathUtility.getContainerNameFromUri((URI)localObject, paramBoolean));
      localObject = localBlobContainerAttributes.getProperties();
      ((BlobContainerProperties)localObject).setEtag(BaseResponse.getEtag(paramHttpURLConnection));
      ((BlobContainerProperties)localObject).setLastModified(new Date(paramHttpURLConnection.getLastModified()));
      localBlobContainerAttributes.setMetadata(BaseResponse.getMetadata(paramHttpURLConnection));
      ((BlobContainerProperties)localObject).setLeaseStatus(getLeaseStatus(paramHttpURLConnection));
      ((BlobContainerProperties)localObject).setLeaseState(getLeaseState(paramHttpURLConnection));
      ((BlobContainerProperties)localObject).setLeaseDuration(getLeaseDuration(paramHttpURLConnection));
      ((BlobContainerProperties)localObject).setPublicAccess(getPublicAccessLevel(paramHttpURLConnection));
      String str = paramHttpURLConnection.getHeaderField("x-ms-has-immutability-policy");
      if (!Utility.isNullOrEmpty(str)) {
        ((BlobContainerProperties)localObject).setHasImmutabilityPolicy(Boolean.valueOf(Boolean.parseBoolean(str)));
      }
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("x-ms-has-legal-hold");
      if (!Utility.isNullOrEmpty(paramHttpURLConnection)) {
        ((BlobContainerProperties)localObject).setHasLegalHold(Boolean.valueOf(Boolean.parseBoolean(paramHttpURLConnection)));
      }
      return localBlobContainerAttributes;
    }
    catch (URISyntaxException paramHttpURLConnection)
    {
      throw Utility.generateNewUnexpectedStorageException(paramHttpURLConnection);
    }
  }
  
  public static CopyState getCopyState(HttpURLConnection paramHttpURLConnection)
  {
    Object localObject = paramHttpURLConnection.getHeaderField("x-ms-copy-status");
    if (!Utility.isNullOrEmpty((String)localObject))
    {
      CopyState localCopyState = new CopyState();
      localCopyState.setStatus(CopyStatus.parse((String)localObject));
      localCopyState.setCopyId(paramHttpURLConnection.getHeaderField("x-ms-copy-id"));
      localCopyState.setStatusDescription(paramHttpURLConnection.getHeaderField("x-ms-copy-status-description"));
      localObject = paramHttpURLConnection.getHeaderField("x-ms-copy-progress");
      if (!Utility.isNullOrEmpty((String)localObject))
      {
        localObject = ((String)localObject).split("/");
        localCopyState.setBytesCopied(Long.valueOf(Long.parseLong(localObject[0])));
        localCopyState.setTotalBytes(Long.valueOf(Long.parseLong(localObject[1])));
      }
      localObject = paramHttpURLConnection.getHeaderField("x-ms-copy-source");
      if (!Utility.isNullOrEmpty((String)localObject)) {
        localCopyState.setSource(new URI((String)localObject));
      }
      localObject = paramHttpURLConnection.getHeaderField("x-ms-copy-completion-time");
      if (!Utility.isNullOrEmpty((String)localObject)) {
        localCopyState.setCompletionTime(Utility.parseRFC1123DateFromStringInGMT((String)localObject));
      }
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("x-ms-copy-destination-snapshot");
      if (!Utility.isNullOrEmpty(paramHttpURLConnection)) {
        localCopyState.setCopyDestinationSnapshotID(paramHttpURLConnection);
      }
      return localCopyState;
    }
    return null;
  }
  
  public static LeaseDuration getLeaseDuration(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("x-ms-lease-duration");
    if (!Utility.isNullOrEmpty(paramHttpURLConnection)) {
      return LeaseDuration.parse(paramHttpURLConnection);
    }
    return LeaseDuration.UNSPECIFIED;
  }
  
  public static String getLeaseID(HttpURLConnection paramHttpURLConnection)
  {
    return paramHttpURLConnection.getHeaderField("x-ms-lease-id");
  }
  
  public static LeaseState getLeaseState(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("x-ms-lease-state");
    if (!Utility.isNullOrEmpty(paramHttpURLConnection)) {
      return LeaseState.parse(paramHttpURLConnection);
    }
    return LeaseState.UNSPECIFIED;
  }
  
  public static LeaseStatus getLeaseStatus(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("x-ms-lease-status");
    if (!Utility.isNullOrEmpty(paramHttpURLConnection)) {
      return LeaseStatus.parse(paramHttpURLConnection);
    }
    return LeaseStatus.UNSPECIFIED;
  }
  
  public static String getLeaseTime(HttpURLConnection paramHttpURLConnection)
  {
    return paramHttpURLConnection.getHeaderField("x-ms-lease-time");
  }
  
  public static BlobContainerPublicAccessType getPublicAccessLevel(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("x-ms-blob-public-access");
    if (!Utility.isNullOrEmpty(paramHttpURLConnection)) {
      return BlobContainerPublicAccessType.parse(paramHttpURLConnection);
    }
    return BlobContainerPublicAccessType.OFF;
  }
  
  public static String getSnapshotTime(HttpURLConnection paramHttpURLConnection)
  {
    return paramHttpURLConnection.getHeaderField("x-ms-snapshot");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.BlobResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */