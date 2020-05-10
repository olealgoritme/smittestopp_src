package com.microsoft.azure.storage.queue;

import com.microsoft.azure.storage.core.Utility;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import javax.xml.stream.XMLStreamWriter;

public final class QueueMessageSerializer
{
  public static byte[] generateMessageRequestBody(String paramString)
  {
    StringWriter localStringWriter = new StringWriter();
    XMLStreamWriter localXMLStreamWriter = Utility.createXMLStreamWriter(localStringWriter);
    localXMLStreamWriter.writeStartDocument();
    localXMLStreamWriter.writeStartElement("QueueMessage");
    localXMLStreamWriter.writeStartElement("MessageText");
    localXMLStreamWriter.writeCharacters(paramString);
    localXMLStreamWriter.writeEndElement();
    localXMLStreamWriter.writeEndElement();
    localXMLStreamWriter.writeEndDocument();
    try
    {
      paramString = localStringWriter.toString().getBytes("UTF8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw Utility.generateNewUnexpectedStorageException(paramString);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.queue.QueueMessageSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */