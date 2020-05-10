package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.core.ListResponse;
import com.microsoft.azure.storage.core.Utility;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Stack;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public final class FileListHandler
  extends DefaultHandler
{
  public StringBuilder bld = new StringBuilder();
  public final CloudFileDirectory directory;
  public FileDirectoryProperties directoryProperties;
  public final Stack<String> elementStack = new Stack();
  public FileProperties fileProperties;
  public String name;
  public final ListResponse<ListFileItem> response = new ListResponse();
  
  public FileListHandler(CloudFileDirectory paramCloudFileDirectory)
  {
    directory = paramCloudFileDirectory;
  }
  
  public static ListResponse<ListFileItem> getFileAndDirectoryList(InputStream paramInputStream, CloudFileDirectory paramCloudFileDirectory)
  {
    SAXParser localSAXParser = Utility.getSAXParser();
    paramCloudFileDirectory = new FileListHandler(paramCloudFileDirectory);
    localSAXParser.parse(paramInputStream, paramCloudFileDirectory);
    return response;
  }
  
  private void setProperties(String paramString1, String paramString2)
  {
    if ("Last-Modified".equals(paramString1)) {
      directoryProperties.setLastModified(Utility.parseRFC1123DateFromStringInGMT(paramString2));
    } else if ("Etag".equals(paramString1)) {
      directoryProperties.setEtag(Utility.formatETag(paramString2));
    } else if ("Content-Length".equals(paramString1)) {
      fileProperties.setLength(Long.parseLong(paramString2));
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
      if ("File".equals(str)) {
        try
        {
          paramString1 = directory.getFileReference(name);
          paramString1.setProperties(fileProperties);
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
      } else if ("Directory".equals(str)) {
        try
        {
          paramString1 = directory.getDirectoryReference(name);
          paramString1.setProperties(directoryProperties);
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
        }
      }
      else if ((!"File".equals(paramString1)) && (!"Directory".equals(paramString1)))
      {
        if ("Properties".equals(paramString1)) {
          try
          {
            setProperties(str, paramString2);
          }
          catch (ParseException paramString1)
          {
            throw new SAXException(paramString1);
          }
        }
      }
      else if ("Name".equals(str)) {
        name = paramString2;
      }
      bld = new StringBuilder();
      return;
    }
    throw new SAXException("The response received is invalid or improperly formatted.");
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    elementStack.push(paramString2);
    if ("File".equals(paramString2))
    {
      name = "";
      fileProperties = new FileProperties();
    }
    if ("Directory".equals(paramString2))
    {
      name = "";
      directoryProperties = new FileDirectoryProperties();
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.file.FileListHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */