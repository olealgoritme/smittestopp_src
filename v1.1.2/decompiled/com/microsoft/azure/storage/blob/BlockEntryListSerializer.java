package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.core.Utility;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import javax.xml.stream.XMLStreamWriter;

public final class BlockEntryListSerializer
{
  public static byte[] writeBlockListToStream(Iterable<BlockEntry> paramIterable, OperationContext paramOperationContext)
  {
    paramOperationContext = new StringWriter();
    XMLStreamWriter localXMLStreamWriter = Utility.createXMLStreamWriter(paramOperationContext);
    localXMLStreamWriter.writeStartDocument();
    localXMLStreamWriter.writeStartElement("BlockList");
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      paramIterable = (BlockEntry)localIterator.next();
      if (paramIterable.getSearchMode() == BlockSearchMode.COMMITTED) {
        localXMLStreamWriter.writeStartElement("Committed");
      } else if (paramIterable.getSearchMode() == BlockSearchMode.UNCOMMITTED) {
        localXMLStreamWriter.writeStartElement("Uncommitted");
      } else if (paramIterable.getSearchMode() == BlockSearchMode.LATEST) {
        localXMLStreamWriter.writeStartElement("Latest");
      }
      localXMLStreamWriter.writeCharacters(paramIterable.getId());
      localXMLStreamWriter.writeEndElement();
    }
    localXMLStreamWriter.writeEndElement();
    localXMLStreamWriter.writeEndDocument();
    try
    {
      paramIterable = paramOperationContext.toString().getBytes("UTF8");
      return paramIterable;
    }
    catch (UnsupportedEncodingException paramIterable)
    {
      throw Utility.generateNewUnexpectedStorageException(paramIterable);
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.BlockEntryListSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */