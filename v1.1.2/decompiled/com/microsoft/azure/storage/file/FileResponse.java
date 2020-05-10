package com.microsoft.azure.storage.file;

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

public final class FileResponse
  extends BaseResponse
{
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
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("x-ms-copy-completion-time");
      if (!Utility.isNullOrEmpty(paramHttpURLConnection)) {
        localCopyState.setCompletionTime(Utility.parseRFC1123DateFromStringInGMT(paramHttpURLConnection));
      }
      return localCopyState;
    }
    return null;
  }
  
  public static FileAttributes getFileAttributes(HttpURLConnection paramHttpURLConnection, StorageUri paramStorageUri)
  {
    FileAttributes localFileAttributes = new FileAttributes();
    FileProperties localFileProperties = localFileAttributes.getProperties();
    localFileProperties.setCacheControl(paramHttpURLConnection.getHeaderField("Cache-Control"));
    localFileProperties.setContentDisposition(paramHttpURLConnection.getHeaderField("Content-Disposition"));
    localFileProperties.setContentEncoding(paramHttpURLConnection.getHeaderField("Content-Encoding"));
    localFileProperties.setContentLanguage(paramHttpURLConnection.getHeaderField("Content-Language"));
    if (!Utility.isNullOrEmpty(paramHttpURLConnection.getHeaderField("Content-Range"))) {
      localFileProperties.setContentMD5(paramHttpURLConnection.getHeaderField("x-ms-content-md5"));
    } else {
      localFileProperties.setContentMD5(paramHttpURLConnection.getHeaderField("Content-MD5"));
    }
    localFileProperties.setContentType(paramHttpURLConnection.getHeaderField("Content-Type"));
    localFileProperties.setEtag(BaseResponse.getEtag(paramHttpURLConnection));
    localFileProperties.setCopyState(getCopyState(paramHttpURLConnection));
    localFileProperties.setServerEncrypted("true".equals(paramHttpURLConnection.getHeaderField("x-ms-server-encrypted")));
    Object localObject = Calendar.getInstance(Utility.LOCALE_US);
    ((Calendar)localObject).setTimeZone(Utility.UTC_ZONE);
    ((Calendar)localObject).setTime(new Date(paramHttpURLConnection.getLastModified()));
    localFileProperties.setLastModified(((Calendar)localObject).getTime());
    localObject = paramHttpURLConnection.getHeaderField("Content-Range");
    String str = paramHttpURLConnection.getHeaderField("x-ms-content-length");
    if (!Utility.isNullOrEmpty((String)localObject))
    {
      localFileProperties.setLength(Long.parseLong(localObject.split("/")[1]));
    }
    else if (!Utility.isNullOrEmpty(str))
    {
      localFileProperties.setLength(Long.parseLong(str));
    }
    else
    {
      localObject = paramHttpURLConnection.getHeaderField("Content-Length");
      if (!Utility.isNullOrEmpty((String)localObject)) {
        localFileProperties.setLength(Long.parseLong((String)localObject));
      }
    }
    localFileAttributes.setStorageUri(paramStorageUri);
    localFileAttributes.setMetadata(BaseResponse.getMetadata(paramHttpURLConnection));
    return localFileAttributes;
  }
  
  public static FileDirectoryAttributes getFileDirectoryAttributes(HttpURLConnection paramHttpURLConnection, boolean paramBoolean)
  {
    FileDirectoryAttributes localFileDirectoryAttributes = new FileDirectoryAttributes();
    try
    {
      Object localObject = PathUtility.stripSingleURIQueryAndFragment(paramHttpURLConnection.getURL().toURI());
      localFileDirectoryAttributes.setName(PathUtility.getDirectoryNameFromURI((URI)localObject, paramBoolean));
      localObject = localFileDirectoryAttributes.getProperties();
      ((FileDirectoryProperties)localObject).setEtag(BaseResponse.getEtag(paramHttpURLConnection));
      ((FileDirectoryProperties)localObject).setLastModified(new Date(paramHttpURLConnection.getLastModified()));
      localFileDirectoryAttributes.setMetadata(BaseResponse.getMetadata(paramHttpURLConnection));
      ((FileDirectoryProperties)localObject).setServerEncrypted("true".equals(paramHttpURLConnection.getHeaderField("x-ms-server-encrypted")));
      return localFileDirectoryAttributes;
    }
    catch (URISyntaxException paramHttpURLConnection)
    {
      throw Utility.generateNewUnexpectedStorageException(paramHttpURLConnection);
    }
  }
  
  public static FileShareAttributes getFileShareAttributes(HttpURLConnection paramHttpURLConnection, boolean paramBoolean)
  {
    FileShareAttributes localFileShareAttributes = new FileShareAttributes();
    FileShareProperties localFileShareProperties = localFileShareAttributes.getProperties();
    localFileShareProperties.setEtag(BaseResponse.getEtag(paramHttpURLConnection));
    localFileShareProperties.setShareQuota(parseShareQuota(paramHttpURLConnection));
    localFileShareProperties.setLastModified(new Date(paramHttpURLConnection.getLastModified()));
    localFileShareAttributes.setMetadata(BaseResponse.getMetadata(paramHttpURLConnection));
    return localFileShareAttributes;
  }
  
  public static String getSnapshotTime(HttpURLConnection paramHttpURLConnection)
  {
    return paramHttpURLConnection.getHeaderField("x-ms-snapshot");
  }
  
  public static Integer parseShareQuota(HttpURLConnection paramHttpURLConnection)
  {
    Integer localInteger = Integer.valueOf(paramHttpURLConnection.getHeaderFieldInt("x-ms-share-quota", -1));
    paramHttpURLConnection = localInteger;
    if (localInteger.intValue() == -1) {
      paramHttpURLConnection = null;
    }
    return paramHttpURLConnection;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.file.FileResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */