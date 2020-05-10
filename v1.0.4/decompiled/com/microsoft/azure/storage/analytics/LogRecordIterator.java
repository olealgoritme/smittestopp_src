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
      Object localObject1;
      if ((reader != null) && (!reader.isEndOfFile()))
      {
        localObject1 = new com/microsoft/azure/storage/analytics/LogRecord;
        ((LogRecord)localObject1).<init>(reader);
        pendingLogRecord = ((LogRecord)localObject1);
        isLogRecordPending = true;
        return true;
      }
      if (logBlobIterator.hasNext())
      {
        if (reader != null) {
          reader.close();
        }
        localObject2 = (CloudBlockBlob)logBlobIterator.next();
        localObject1 = new com/microsoft/azure/storage/analytics/LogRecordStreamReader;
        ((LogRecordStreamReader)localObject1).<init>(((CloudBlob)localObject2).openInputStream());
        reader = ((LogRecordStreamReader)localObject1);
        boolean bool = hasNext();
        return bool;
      }
      return false;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      localObject2 = new NoSuchElementException("An error occurred while enumerating the result, check the original exception for details.");
      ((NoSuchElementException)localObject2).initCause(localURISyntaxException);
      throw ((Throwable)localObject2);
    }
    catch (ParseException localParseException)
    {
      localObject2 = new NoSuchElementException("An error occurred while enumerating the result, check the original exception for details.");
      ((NoSuchElementException)localObject2).initCause(localParseException);
      throw ((Throwable)localObject2);
    }
    catch (StorageException localStorageException)
    {
      localObject2 = new NoSuchElementException("An error occurred while enumerating the result, check the original exception for details.");
      ((NoSuchElementException)localObject2).initCause(localStorageException);
      throw ((Throwable)localObject2);
    }
    catch (IOException localIOException)
    {
      Object localObject2 = new NoSuchElementException("An error occurred while enumerating the result, check the original exception for details.");
      ((NoSuchElementException)localObject2).initCause(localIOException);
      throw ((Throwable)localObject2);
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
 * Qualified Name:     base.com.microsoft.azure.storage.analytics.LogRecordIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */