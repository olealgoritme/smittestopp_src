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
    StringWriter localStringWriter = new StringWriter();
    paramOperationContext = Utility.createXMLStreamWriter(localStringWriter);
    paramOperationContext.writeStartDocument();
    paramOperationContext.writeStartElement("BlockList");
    Iterator localIterator = paramIterable.iterator();
    while (localIterator.hasNext())
    {
      paramIterable = (BlockEntry)localIterator.next();
      if (paramIterable.getSearchMode() == BlockSearchMode.COMMITTED) {
        paramOperationContext.writeStartElement("Committed");
      } else if (paramIterable.getSearchMode() == BlockSearchMode.UNCOMMITTED) {
        paramOperationContext.writeStartElement("Uncommitted");
      } else if (paramIterable.getSearchMode() == BlockSearchMode.LATEST) {
        paramOperationContext.writeStartElement("Latest");
      }
      paramOperationContext.writeCharacters(paramIterable.getId());
      paramOperationContext.writeEndElement();
    }
    paramOperationContext.writeEndElement();
    paramOperationContext.writeEndDocument();
    try
    {
      paramIterable = localStringWriter.toString().getBytes("UTF8");
      return paramIterable;
    }
    catch (UnsupportedEncodingException paramIterable)
    {
      throw Utility.generateNewUnexpectedStorageException(paramIterable);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.BlockEntryListSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */