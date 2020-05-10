package com.microsoft.azure.storage.analytics;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlob;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.ListBlobItem;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LogRecordIterator
  implements Iterator<LogRecord>
{
  public boolean isLogRecordPending = false;
  public final Iterator<ListBlobItem> logBlobIterator;
  public LogRecord pendingLogRecord;
  public LogRecordStreamReader reader;
  
  public LogRecordIterator(Iterator<ListBlobItem> paramIterator)
  {
    logBlobIterator = paramIterator;
  }
  
  public boolean hasNext()
  {
    if (isLogRecordPending) {
      return true;
    }
    try
    {
      if ((reader != null) && (!reader.isEndOfFile()))
      {
        localObject = new com/microsoft/azure/storage/analytics/LogRecord;
        ((LogRecord)localObject).<init>(reader);
        pendingLogRecord = ((LogRecord)localObject);
        isLogRecordPending = true;
        return true;
      }
      if (logBlobIterator.hasNext())
      {
        if (reader != null) {
          reader.close();
        }
        localObject = (CloudBlockBlob)logBlobIterator.next();
        LogRecordStreamReader localLogRecordStreamReader = new com/microsoft/azure/storage/analytics/LogRecordStreamReader;
        localLogRecordStreamReader.<init>(((CloudBlob)localObject).openInputStream());
        reader = localLogRecordStreamReader;
        boolean bool = hasNext();
        return bool;
      }
      return false;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      Object localObject = new NoSuchElementException("An error occurred while enumerating the result, check the original exception for details.");
      ((NoSuchElementException)localObject).initCause(localURISyntaxException);
      throw ((Throwable)localObject);
    }
    catch (ParseException localParseException)
    {
      localNoSuchElementException = new NoSuchElementException("An error occurred while enumerating the result, check the original exception for details.");
      localNoSuchElementException.initCause(localParseException);
      throw localNoSuchElementException;
    }
    catch (StorageException localStorageException)
    {
      localNoSuchElementException = new NoSuchElementException("An error occurred while enumerating the result, check the original exception for details.");
      localNoSuchElementException.initCause(localStorageException);
      throw localNoSuchElementException;
    }
    catch (IOException localIOException)
    {
      NoSuchElementException localNoSuchElementException = new NoSuchElementException("An error occurred while enumerating the result, check the original exception for details.");
      localNoSuchElementException.initCause(localIOException);
      throw localNoSuchElementException;
    }
  }
  
  public LogRecord next()
  {
    if (isLogRecordPending)
    {
      isLogRecordPending = false;
      return pendingLogRecord;
    }
    if (hasNext()) {
      return next();
    }
    throw new NoSuchElementException("There are no more elements in this enumeration.");
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.analytics.LogRecordIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */