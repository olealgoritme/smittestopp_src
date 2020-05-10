package com.microsoft.azure.storage.blob;

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

public final class ContainerListHandler
  extends DefaultHandler
{
  public BlobContainerAttributes attributes;
  public StringBuilder bld = new StringBuilder();
  public String containerName;
  public final Stack<String> elementStack = new Stack();
  public final ListResponse<CloudBlobContainer> response = new ListResponse();
  public final CloudBlobClient serviceClient;
  
  public ContainerListHandler(CloudBlobClient paramCloudBlobClient)
  {
    serviceClient = paramCloudBlobClient;
  }
  
  public static ListResponse<CloudBlobContainer> getContainerList(InputStream paramInputStream, CloudBlobClient paramCloudBlobClient)
  {
    SAXParser localSAXParser = Utility.getSAXParser();
    paramCloudBlobClient = new ContainerListHandler(paramCloudBlobClient);
    localSAXParser.parse(paramInputStream, paramCloudBlobClient);
    return response;
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
    else if (paramString1.equals("LeaseStatus"))
    {
      paramString1 = LeaseStatus.parse(paramString2);
      if (!paramString1.equals(LeaseStatus.UNSPECIFIED)) {
        attributes.getProperties().setLeaseStatus(paramString1);
      } else {
        throw new SAXException("The response received is invalid or improperly formatted.");
      }
    }
    else if (paramString1.equals("LeaseState"))
    {
      paramString1 = LeaseState.parse(paramString2);
      if (!paramString1.equals(LeaseState.UNSPECIFIED)) {
        attributes.getProperties().setLeaseState(paramString1);
      } else {
        throw new SAXException("The response received is invalid or improperly formatted.");
      }
    }
    else if (paramString1.equals("LeaseDuration"))
    {
      paramString1 = LeaseDuration.parse(paramString2);
      if (!paramString1.equals(LeaseDuration.UNSPECIFIED)) {
        attributes.getProperties().setLeaseDuration(paramString1);
      } else {
        throw new SAXException("The response received is invalid or improperly formatted.");
      }
    }
    else if (paramString1.equals("PublicAccess"))
    {
      paramString1 = BlobContainerPublicAccessType.parse(paramString2);
      if (!paramString1.equals(BlobContainerPublicAccessType.OFF)) {
        attributes.getProperties().setPublicAccess(paramString1);
      } else {
        throw new SAXException("The response received is invalid or improperly formatted.");
      }
    }
    else if (paramString1.equals("HasImmutabilityPolicy"))
    {
      attributes.getProperties().setHasImmutabilityPolicy(Boolean.valueOf(Boolean.parseBoolean(paramString2)));
    }
    else if (paramString1.equals("HasLegalHold"))
    {
      attributes.getProperties().setHasLegalHold(Boolean.valueOf(Boolean.parseBoolean(paramString2)));
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
      if ("Container".equals(str))
      {
        try
        {
          paramString1 = serviceClient.getContainerReference(containerName);
          paramString1.setMetadata(attributes.getMetadata());
          paramString1.setProperties(attributes.getProperties());
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
      else if ("Container".equals(paramString2))
      {
        if ("Name".equals(str)) {
          containerName = paramString1;
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
    if ("Container".equals(paramString2))
    {
      containerName = "";
      paramString1 = new BlobContainerAttributes();
      attributes = paramString1;
      paramString1.getProperties().setPublicAccess(BlobContainerPublicAccessType.OFF);
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.ContainerListHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */