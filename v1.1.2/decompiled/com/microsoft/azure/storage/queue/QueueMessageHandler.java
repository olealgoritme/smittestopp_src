package com.microsoft.azure.storage.queue;

import com.microsoft.azure.storage.core.Utility;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Stack;
import javax.xml.parsers.SAXParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public final class QueueMessageHandler
  extends DefaultHandler
{
  public StringBuilder bld = new StringBuilder();
  public final Stack<String> elementStack = new Stack();
  public CloudQueueMessage message = new CloudQueueMessage();
  public final ArrayList<CloudQueueMessage> messages = new ArrayList();
  public final boolean shouldEncodeMessage;
  
  public QueueMessageHandler(boolean paramBoolean)
  {
    shouldEncodeMessage = paramBoolean;
  }
  
  public static ArrayList<CloudQueueMessage> readMessages(InputStream paramInputStream, boolean paramBoolean)
  {
    SAXParser localSAXParser = Utility.getSAXParser();
    QueueMessageHandler localQueueMessageHandler = new QueueMessageHandler(paramBoolean);
    localSAXParser.parse(paramInputStream, localQueueMessageHandler);
    return messages;
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
      paramString3 = bld.toString();
      paramString1 = paramString3;
      if (paramString3.isEmpty()) {
        paramString1 = null;
      }
      if ("QueueMessage".equals(paramString2)) {
        messages.add(message);
      } else if ("MessageId".equals(str)) {
        message.setMessageId(paramString1);
      } else if ("InsertionTime".equals(str)) {
        try
        {
          message.setInsertionTime(Utility.parseRFC1123DateFromStringInGMT(paramString1));
        }
        catch (ParseException paramString1)
        {
          throw new SAXException(paramString1);
        }
      } else if ("ExpirationTime".equals(str)) {
        try
        {
          message.setExpirationTime(Utility.parseRFC1123DateFromStringInGMT(paramString1));
        }
        catch (ParseException paramString1)
        {
          throw new SAXException(paramString1);
        }
      } else if ("PopReceipt".equals(str)) {
        message.setPopReceipt(paramString1);
      } else if ("TimeNextVisible".equals(str)) {
        try
        {
          message.setNextVisibleTime(Utility.parseRFC1123DateFromStringInGMT(paramString1));
        }
        catch (ParseException paramString1)
        {
          throw new SAXException(paramString1);
        }
      } else if ("DequeueCount".equals(str)) {
        message.setDequeueCount(Integer.parseInt(paramString1));
      } else if ("MessageText".equals(str)) {
        message.messageContent = paramString1;
      }
      bld = new StringBuilder();
      return;
    }
    throw new SAXException("The response received is invalid or improperly formatted.");
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    elementStack.push(paramString2);
    if ("QueueMessage".equals(paramString2))
    {
      paramString2 = new CloudQueueMessage();
      message = paramString2;
      if (shouldEncodeMessage) {
        paramString1 = QueueMessageType.BASE_64_ENCODED;
      } else {
        paramString1 = QueueMessageType.RAW_STRING;
      }
      paramString2.setMessageType(paramString1);
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.queue.QueueMessageHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */