package com.microsoft.azure.storage.analytics;

import com.microsoft.azure.storage.LoggingOperations;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.blob.BlobListingDetails;
import com.microsoft.azure.storage.blob.BlobRequestOptions;
import com.microsoft.azure.storage.blob.CloudBlobDirectory;
import com.microsoft.azure.storage.blob.ListBlobItem;
import java.util.Date;
import java.util.EnumSet;
import java.util.Iterator;

public class LogBlobIterable
  implements Iterable<ListBlobItem>
{
  public final EnumSet<BlobListingDetails> details;
  public final Date endTime;
  public final CloudBlobDirectory logDirectory;
  public final OperationContext opContext;
  public final EnumSet<LoggingOperations> operations;
  public final BlobRequestOptions options;
  public final Date startTime;
  
  public LogBlobIterable(CloudBlobDirectory paramCloudBlobDirectory, Date paramDate1, Date paramDate2, EnumSet<LoggingOperations> paramEnumSet, EnumSet<BlobListingDetails> paramEnumSet1, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    logDirectory = paramCloudBlobDirectory;
    startTime = paramDate1;
    endTime = paramDate2;
    operations = paramEnumSet;
    details = paramEnumSet1;
    options = paramBlobRequestOptions;
    opContext = paramOperationContext;
  }
  
  public Iterator<ListBlobItem> iterator()
  {
    return new LogBlobIterator(logDirectory, startTime, endTime, operations, details, options, opContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.analytics.LogBlobIterable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */