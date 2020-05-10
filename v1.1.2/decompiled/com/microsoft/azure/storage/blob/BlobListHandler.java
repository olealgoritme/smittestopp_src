package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.core.ListResponse;
import com.microsoft.azure.storage.core.Utility;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public final class BlobListHandler
  extends DefaultHandler
{
  public StringBuilder bld = new StringBuilder();
  public String blobName;
  public final CloudBlobContainer container;
  public CopyState copyState;
  public boolean deleted;
  public final Stack<String> elementStack = new Stack();
  public HashMap<String, String> metadata;
  public BlobProperties properties;
  public final ListBlobsResponse response = new ListBlobsResponse();
  public String snapshotID;
  
  public BlobListHandler(CloudBlobContainer paramCloudBlobContainer)
  {
    container = paramCloudBlobContainer;
  }
  
  public static ListBlobsResponse getBlobList(InputStream paramInputStream, CloudBlobContainer paramCloudBlobContainer)
  {
    SAXParser localSAXParser = Utility.getSAXParser();
    paramCloudBlobContainer = new BlobListHandler(paramCloudBlobContainer);
    localSAXParser.parse(paramInputStream, paramCloudBlobContainer);
    return response;
  }
  
  private void setProperties(String paramString1, String paramString2)
  {
    if ("Last-Modified".equals(paramString1))
    {
      properties.setLastModified(Utility.parseRFC1123DateFromStringInGMT(paramString2));
    }
    else if ("Etag".equals(paramString1))
    {
      properties.setEtag(Utility.formatETag(paramString2));
    }
    else if ("Content-Length".equals(paramString1))
    {
      properties.setLength(Long.parseLong(paramString2));
    }
    else if ("Content-Type".equals(paramString1))
    {
      properties.setContentType(paramString2);
    }
    else if ("Content-Encoding".equals(paramString1))
    {
      properties.setContentEncoding(paramString2);
    }
    else if ("Content-Language".equals(paramString1))
    {
      properties.setContentLanguage(paramString2);
    }
    else if ("Content-MD5".equals(paramString1))
    {
      properties.setContentMD5(paramString2);
    }
    else if ("Cache-Control".equals(paramString1))
    {
      properties.setCacheControl(paramString2);
    }
    else if ("Content-Disposition".equals(paramString1))
    {
      properties.setContentDisposition(paramString2);
    }
    else if ("BlobType".equals(paramString1))
    {
      if (paramString2.equals("BlockBlob")) {
        properties.setBlobType(BlobType.BLOCK_BLOB);
      } else if (paramString2.equals("PageBlob")) {
        properties.setBlobType(BlobType.PAGE_BLOB);
      } else if (paramString2.equals("AppendBlob")) {
        properties.setBlobType(BlobType.APPEND_BLOB);
      } else {
        throw new SAXException("The response received is invalid or improperly formatted.");
      }
    }
    else if ("LeaseStatus".equals(paramString1))
    {
      paramString1 = LeaseStatus.parse(paramString2);
      if (!paramString1.equals(LeaseStatus.UNSPECIFIED)) {
        properties.setLeaseStatus(paramString1);
      }
    }
    else if ("LeaseState".equals(paramString1))
    {
      paramString1 = LeaseState.parse(paramString2);
      if (!paramString1.equals(LeaseState.UNSPECIFIED)) {
        properties.setLeaseState(paramString1);
      } else {
        throw new SAXException("The response received is invalid or improperly formatted.");
      }
    }
    else if ("LeaseDuration".equals(paramString1))
    {
      paramString1 = LeaseDuration.parse(paramString2);
      if (!paramString1.equals(LeaseDuration.UNSPECIFIED)) {
        properties.setLeaseDuration(paramString1);
      } else {
        throw new SAXException("The response received is invalid or improperly formatted.");
      }
    }
    else if ("ServerEncrypted".equals(paramString1))
    {
      properties.setServerEncrypted("true".equals(paramString2));
    }
    else if ("CopyId".equals(paramString1))
    {
      if (copyState == null) {
        copyState = new CopyState();
      }
      copyState.setCopyId(paramString2);
    }
    else if ("CopyCompletionTime".equals(paramString1))
    {
      if (copyState == null) {
        copyState = new CopyState();
      }
      copyState.setCompletionTime(Utility.parseRFC1123DateFromStringInGMT(paramString2));
    }
    else if ("CopyStatus".equals(paramString1))
    {
      if (copyState == null) {
        copyState = new CopyState();
      }
      copyState.setStatus(CopyStatus.parse(paramString2));
    }
    else if ("CopySource".equals(paramString1))
    {
      if (copyState == null) {
        copyState = new CopyState();
      }
      copyState.setSource(new URI(paramString2));
    }
    else if ("CopyProgress".equals(paramString1))
    {
      if (copyState == null) {
        copyState = new CopyState();
      }
      paramString1 = paramString2.split("/");
      copyState.setBytesCopied(Long.valueOf(Long.parseLong(paramString1[0])));
      copyState.setTotalBytes(Long.valueOf(Long.parseLong(paramString1[1])));
    }
    else if ("CopyStatusDescription".equals(paramString1))
    {
      if (copyState == null) {
        copyState = new CopyState();
      }
      copyState.setStatusDescription(paramString2);
    }
    else if ("IncrementalCopy".equals(paramString1))
    {
      properties.setIncrementalCopy("true".equals(paramString2));
    }
    else if ("CopyDestinationSnapshot".equals(paramString1))
    {
      if (copyState == null) {
        copyState = new CopyState();
      }
      copyState.setCopyDestinationSnapshotID(paramString2);
    }
    else if ("AccessTier".equals(paramString1))
    {
      if (properties.getBlobType().equals(BlobType.PAGE_BLOB))
      {
        paramString1 = PremiumPageBlobTier.parse(paramString2);
        properties.setPremiumPageBlobTier(paramString1);
      }
      else if (properties.getBlobType().equals(BlobType.BLOCK_BLOB))
      {
        paramString1 = StandardBlobTier.parse(paramString2);
        properties.setStandardBlobTier(paramString1);
      }
      else if (properties.getBlobType().equals(BlobType.UNSPECIFIED))
      {
        paramString1 = PremiumPageBlobTier.parse(paramString2);
        paramString2 = StandardBlobTier.parse(paramString2);
        if (!paramString1.equals(PremiumPageBlobTier.UNKNOWN))
        {
          properties.setPremiumPageBlobTier(paramString1);
        }
        else if (!paramString2.equals(StandardBlobTier.UNKNOWN))
        {
          properties.setStandardBlobTier(paramString2);
        }
        else
        {
          properties.setPremiumPageBlobTier(PremiumPageBlobTier.UNKNOWN);
          properties.setStandardBlobTier(StandardBlobTier.UNKNOWN);
        }
      }
    }
    else if ("AccessTierInferred".equals(paramString1))
    {
      properties.setBlobTierInferred(Boolean.valueOf(Boolean.parseBoolean(paramString2)));
    }
    else if ("AccessTierChangeTime".equals(paramString1))
    {
      properties.setTierChangeTime(Utility.parseRFC1123DateFromStringInGMT(paramString2));
    }
    else if ("ArchiveStatus".equals(paramString1))
    {
      properties.setRehydrationStatus(RehydrationStatus.parse(paramString2));
    }
    else if ("DeletedTime".equals(paramString1))
    {
      properties.setDeletedTime(Utility.parseRFC1123DateFromStringInGMT(paramString2));
    }
    else if ("RemainingRetentionDays".equals(paramString1))
    {
      properties.setRemainingRetentionDays(Integer.valueOf(Integer.parseInt(paramString2)));
    }
    else if ("Creation-Time".equals(paramString1))
    {
      properties.setCreatedTime(Utility.parseRFC1123DateFromStringInGMT(paramString2));
    }
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    bld.append(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    String str = (String)elementStack.pop();
    if (paramString2.equals(str))
    {
      boolean bool = elementStack.isEmpty();
      paramString2 = null;
      if (!bool) {
        paramString1 = (String)elementStack.peek();
      } else {
        paramString1 = null;
      }
      paramString3 = bld.toString();
      if (!paramString3.isEmpty()) {
        paramString2 = paramString3;
      }
      if ("Blob".equals(str)) {
        try
        {
          if (properties.getBlobType() == BlobType.BLOCK_BLOB)
          {
            paramString1 = container.getBlockBlobReference(blobName);
          }
          else if (properties.getBlobType() == BlobType.PAGE_BLOB)
          {
            paramString1 = container.getPageBlobReference(blobName);
          }
          else
          {
            if (properties.getBlobType() != BlobType.APPEND_BLOB) {
              break label222;
            }
            paramString1 = container.getAppendBlobReference(blobName);
          }
          snapshotID = snapshotID;
          paramString2 = properties;
          properties = paramString2;
          metadata = metadata;
          paramString2.setCopyState(copyState);
          deleted = deleted;
          response.getResults().add(paramString1);
          break label586;
          label222:
          paramString1 = new org/xml/sax/SAXException;
          paramString1.<init>("The response received is invalid or improperly formatted.");
          throw paramString1;
        }
        catch (URISyntaxException paramString1)
        {
          throw new SAXException(paramString1);
        }
        catch (StorageException paramString1)
        {
          throw new SAXException(paramString1);
        }
      }
      if ("BlobPrefix".equals(str)) {
        try
        {
          response.getResults().add(container.getDirectoryReference(blobName));
        }
        catch (URISyntaxException paramString1)
        {
          throw new SAXException(paramString1);
        }
      } else if ("EnumerationResults".equals(paramString1))
      {
        if ("Prefix".equals(str)) {
          response.setPrefix(paramString2);
        } else if ("Marker".equals(str)) {
          response.setMarker(paramString2);
        } else if ("NextMarker".equals(str)) {
          response.setNextMarker(paramString2);
        } else if ("MaxResults".equals(str)) {
          response.setMaxResults(Integer.valueOf(Integer.parseInt(paramString2)));
        } else if ("Delimiter".equals(str)) {
          response.setDelimiter(paramString2);
        }
      }
      else if ("Blob".equals(paramString1))
      {
        if ("Name".equals(str)) {
          blobName = paramString2;
        } else if ("Snapshot".equals(str)) {
          snapshotID = paramString2;
        } else if ("Deleted".equals(str)) {
          deleted = Boolean.parseBoolean(paramString2);
        }
      }
      else if ("BlobPrefix".equals(paramString1))
      {
        if ("Name".equals(str)) {
          blobName = paramString2;
        }
      }
      else if ("Properties".equals(paramString1)) {
        try
        {
          setProperties(str, paramString2);
        }
        catch (URISyntaxException paramString1)
        {
          throw new SAXException(paramString1);
        }
        catch (ParseException paramString1)
        {
          throw new SAXException(paramString1);
        }
      } else if ("Metadata".equals(paramString1)) {
        metadata.put(str, paramString2);
      }
      label586:
      bld = new StringBuilder();
      return;
    }
    throw new SAXException("The response received is invalid or improperly formatted.");
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    elementStack.push(paramString2);
    if (("Blob".equals(paramString2)) || ("BlobPrefix".equals(paramString2)))
    {
      blobName = "";
      snapshotID = null;
      properties = new BlobProperties();
      metadata = new HashMap();
      copyState = null;
      deleted = false;
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.BlobListHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */