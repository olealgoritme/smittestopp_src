package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.core.ListResponse;
import com.microsoft.azure.storage.core.Utility;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public final class ShareListHandler
  extends DefaultHandler
{
  public FileShareAttributes attributes;
  public StringBuilder bld = new StringBuilder();
  public final Stack<String> elementStack = new Stack();
  public final ListResponse<CloudFileShare> response = new ListResponse();
  public final CloudFileClient serviceClient;
  public String shareName;
  public String snapshotID;
  
  public ShareListHandler(CloudFileClient paramCloudFileClient)
  {
    serviceClient = paramCloudFileClient;
  }
  
  private void getProperties(String paramString1, String paramString2)
  {
    if (paramString1.equals("Last-Modified"))
    {
      attributes.getProperties().setLastModified(Utility.parseRFC1123DateFromStringInGMT(paramString2));
    }
    else if (paramString1.equals("Etag"))
    {
      attributes.getProperties().setEtag(Utility.formatETag(paramString2));
    }
    else if (paramString1.equals("Quota"))
    {
      FileShareProperties localFileShareProperties = attributes.getProperties();
      if (Utility.isNullOrEmpty(paramString2)) {
        paramString1 = null;
      } else {
        paramString1 = Integer.valueOf(Integer.parseInt(paramString2));
      }
      localFileShareProperties.setShareQuota(paramString1);
    }
  }
  
  public static ListResponse<CloudFileShare> getShareList(InputStream paramInputStream, CloudFileClient paramCloudFileClient)
  {
    SAXParser localSAXParser = Utility.getSAXParser();
    paramCloudFileClient = new ShareListHandler(paramCloudFileClient);
    localSAXParser.parse(paramInputStream, paramCloudFileClient);
    return response;
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
      paramString1 = null;
      if (!bool) {
        paramString2 = (String)elementStack.peek();
      } else {
        paramString2 = null;
      }
      paramString3 = bld.toString();
      if (!paramString3.isEmpty()) {
        paramString1 = paramString3;
      }
      if ("Share".equals(str))
      {
        try
        {
          paramString1 = serviceClient.getShareReference(shareName);
          paramString1.setMetadata(attributes.getMetadata());
          paramString1.setProperties(attributes.getProperties());
          snapshotID = snapshotID;
          response.getResults().add(paramString1);
        }
        catch (StorageException paramString1)
        {
          throw new SAXException(paramString1);
        }
        catch (URISyntaxException paramString1)
        {
          throw new SAXException(paramString1);
        }
      }
      else if ("EnumerationResults".equals(paramString2))
      {
        if ("Prefix".equals(str)) {
          response.setPrefix(paramString1);
        } else if ("Marker".equals(str)) {
          response.setMarker(paramString1);
        } else if ("NextMarker".equals(str)) {
          response.setNextMarker(paramString1);
        } else if ("MaxResults".equals(str)) {
          response.setMaxResults(Integer.valueOf(Integer.parseInt(paramString1)));
        }
      }
      else if ("Share".equals(paramString2))
      {
        if ("Name".equals(str)) {
          shareName = paramString1;
        } else if ("snapshot".equals(str.toLowerCase())) {
          snapshotID = paramString1;
        }
      }
      else if ("Properties".equals(paramString2))
      {
        try
        {
          getProperties(str, paramString1);
        }
        catch (ParseException paramString1)
        {
          throw new SAXException(paramString1);
        }
      }
      else if ("Metadata".equals(paramString2))
      {
        paramString2 = paramString1;
        if (paramString1 == null) {
          paramString2 = "";
        }
        attributes.getMetadata().put(str, paramString2);
      }
      bld = new StringBuilder();
      return;
    }
    throw new SAXException("The response received is invalid or improperly formatted.");
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    elementStack.push(paramString2);
    if ("Share".equals(paramString2))
    {
      shareName = "";
      snapshotID = null;
      attributes = new FileShareAttributes();
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.file.ShareListHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */