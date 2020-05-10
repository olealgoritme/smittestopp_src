package com.microsoft.azure.storage.analytics;

import com.microsoft.azure.storage.blob.ListBlobItem;
import java.util.Iterator;

public class LogRecordIterable
  implements Iterable<LogRecord>
{
  public final Iterator<ListBlobItem> logBlobIterator;
  
  public LogRecordIterable(Iterator<ListBlobItem> paramIterator)
  {
    logBlobIterator = paramIterator;
  }
  
  public Iterator<LogRecord> iterator()
  {
    return new LogRecordIterator(logBlobIterator);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.analytics.LogRecordIterable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */