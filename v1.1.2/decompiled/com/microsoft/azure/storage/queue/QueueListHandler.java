package com.microsoft.azure.storage.queue;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.core.ListResponse;
import com.microsoft.azure.storage.core.Utility;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public final class QueueListHandler
  extends DefaultHandler
{
  public StringBuilder bld = new StringBuilder();
  public final Stack<String> elementStack = new Stack();
  public HashMap<String, String> metadata;
  public String queueName;
  public final ListResponse<CloudQueue> response = new ListResponse();
  public final CloudQueueClient serviceClient;
  
  public QueueListHandler(CloudQueueClient paramCloudQueueClient)
  {
    serviceClient = paramCloudQueueClient;
  }
  
  public static ListResponse<CloudQueue> getQueues(InputStream paramInputStream, CloudQueueClient paramCloudQueueClient)
  {
    SAXParser localSAXParser = Utility.getSAXParser();
    paramCloudQueueClient = new QueueListHandler(paramCloudQueueClient);
    localSAXParser.parse(paramInputStream, paramCloudQueueClient);
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
      if ("Queue".equals(str)) {
        try
        {
          paramString1 = serviceClient.getQueueReference(queueName);
          paramString1.setMetadata(metadata);
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
      else if ("Metadata".equals(paramString1)) {
        metadata.put(str, paramString2);
      } else if (("Queue".equals(paramString1)) && ("Name".equals(str))) {
        queueName = paramString2;
      }
      bld = new StringBuilder();
      return;
    }
    throw new SAXException("The response received is invalid or improperly formatted.");
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    elementStack.push(paramString2);
    if ("Queue".equals(paramString2))
    {
      queueName = "";
      metadata = new HashMap();
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.queue.QueueListHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */