package com.microsoft.azure.storage.analytics;

import com.microsoft.azure.storage.LoggingOperations;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageCredentials;
import com.microsoft.azure.storage.StorageLocation;
import com.microsoft.azure.storage.StorageUri;
import com.microsoft.azure.storage.blob.BlobListingDetails;
import com.microsoft.azure.storage.blob.BlobRequestOptions;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlobDirectory;
import com.microsoft.azure.storage.blob.ListBlobItem;
import com.microsoft.azure.storage.core.Utility;
import com.microsoft.azure.storage.table.CloudTable;
import com.microsoft.azure.storage.table.CloudTableClient;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumSet;
import java.util.Locale;

public class CloudAnalyticsClient
{
  public String LogContainer = "$logs";
  public final CloudBlobClient blobClient;
  public final CloudTableClient tableClient;
  
  public CloudAnalyticsClient(StorageUri paramStorageUri1, StorageUri paramStorageUri2, StorageCredentials paramStorageCredentials)
  {
    Utility.assertNotNull("blobStorageUri", paramStorageUri1);
    Utility.assertNotNull("tableStorageUri", paramStorageUri2);
    blobClient = new CloudBlobClient(paramStorageUri1, paramStorageCredentials);
    tableClient = new CloudTableClient(paramStorageUri2, paramStorageCredentials);
  }
  
  public static Iterable<LogRecord> parseLogBlob(ListBlobItem paramListBlobItem)
  {
    Utility.assertNotNull("logBlob", paramListBlobItem);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramListBlobItem);
    return new LogRecordIterable(localArrayList.iterator());
  }
  
  public static Iterable<LogRecord> parseLogBlobs(Iterable<ListBlobItem> paramIterable)
  {
    Utility.assertNotNull("logBlobs", paramIterable);
    return new LogRecordIterable(paramIterable.iterator());
  }
  
  public CloudTable getCapacityTable()
  {
    return tableClient.getTableReference("$MetricsCapacityBlob");
  }
  
  public CloudTable getHourMetricsTable(StorageService paramStorageService)
  {
    return getHourMetricsTable(paramStorageService, null);
  }
  
  public CloudTable getHourMetricsTable(StorageService paramStorageService, StorageLocation paramStorageLocation)
  {
    Utility.assertNotNull("service", paramStorageService);
    StorageLocation localStorageLocation = paramStorageLocation;
    if (paramStorageLocation == null) {
      localStorageLocation = StorageLocation.PRIMARY;
    }
    int i = paramStorageService.ordinal();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            if (localStorageLocation == StorageLocation.PRIMARY) {
              return tableClient.getTableReference("$MetricsHourPrimaryTransactionsTable");
            }
            return tableClient.getTableReference("$MetricsHourSecondaryTransactionsTable");
          }
          throw new IllegalArgumentException("Invalid storage service specified.");
        }
        if (localStorageLocation == StorageLocation.PRIMARY) {
          return tableClient.getTableReference("$MetricsHourPrimaryTransactionsQueue");
        }
        return tableClient.getTableReference("$MetricsHourSecondaryTransactionsQueue");
      }
      if (localStorageLocation == StorageLocation.PRIMARY) {
        return tableClient.getTableReference("$MetricsHourPrimaryTransactionsFile");
      }
      return tableClient.getTableReference("$MetricsHourSecondaryTransactionsFile");
    }
    if (localStorageLocation == StorageLocation.PRIMARY) {
      return tableClient.getTableReference("$MetricsHourPrimaryTransactionsBlob");
    }
    return tableClient.getTableReference("$MetricsHourSecondaryTransactionsBlob");
  }
  
  public CloudBlobDirectory getLogDirectory(StorageService paramStorageService)
  {
    Utility.assertNotNull("service", paramStorageService);
    return blobClient.getContainerReference(LogContainer).getDirectoryReference(paramStorageService.toString().toLowerCase(Locale.US));
  }
  
  public CloudTable getMinuteMetricsTable(StorageService paramStorageService)
  {
    return getMinuteMetricsTable(paramStorageService, null);
  }
  
  public CloudTable getMinuteMetricsTable(StorageService paramStorageService, StorageLocation paramStorageLocation)
  {
    Utility.assertNotNull("service", paramStorageService);
    StorageLocation localStorageLocation = paramStorageLocation;
    if (paramStorageLocation == null) {
      localStorageLocation = StorageLocation.PRIMARY;
    }
    int i = paramStorageService.ordinal();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            if (localStorageLocation == StorageLocation.PRIMARY) {
              return tableClient.getTableReference("$MetricsMinutePrimaryTransactionsTable");
            }
            return tableClient.getTableReference("$MetricsMinuteSecondaryTransactionsTable");
          }
          throw new IllegalArgumentException("Invalid storage service specified.");
        }
        if (localStorageLocation == StorageLocation.PRIMARY) {
          return tableClient.getTableReference("$MetricsMinutePrimaryTransactionsQueue");
        }
        return tableClient.getTableReference("$MetricsMinuteSecondaryTransactionsQueue");
      }
      if (localStorageLocation == StorageLocation.PRIMARY) {
        return tableClient.getTableReference("$MetricsMinutePrimaryTransactionsFile");
      }
      return tableClient.getTableReference("$MetricsMinuteSecondaryTransactionsFile");
    }
    if (localStorageLocation == StorageLocation.PRIMARY) {
      return tableClient.getTableReference("$MetricsMinutePrimaryTransactionsBlob");
    }
    return tableClient.getTableReference("$MetricsMinuteSecondaryTransactionsBlob");
  }
  
  public Iterable<ListBlobItem> listLogBlobs(StorageService paramStorageService)
  {
    return listLogBlobs(paramStorageService, null, null, null, null, null, null);
  }
  
  public Iterable<ListBlobItem> listLogBlobs(StorageService paramStorageService, Date paramDate1, Date paramDate2, EnumSet<LoggingOperations> paramEnumSet, BlobListingDetails paramBlobListingDetails, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("service", paramStorageService);
    Object localObject = paramEnumSet;
    if (paramEnumSet == null) {
      localObject = EnumSet.allOf(LoggingOperations.class);
    }
    if ((paramBlobListingDetails != null) && (!paramBlobListingDetails.equals(BlobListingDetails.METADATA))) {
      throw new IllegalArgumentException("Invalid blob listing details specified.");
    }
    if (!((EnumSet)localObject).equals(EnumSet.noneOf(LoggingOperations.class)))
    {
      if ((paramBlobListingDetails != null) && ((paramBlobListingDetails.equals(BlobListingDetails.METADATA)) || (!((EnumSet)localObject).equals(EnumSet.allOf(LoggingOperations.class))))) {
        paramEnumSet = EnumSet.of(BlobListingDetails.METADATA);
      } else {
        paramEnumSet = EnumSet.noneOf(BlobListingDetails.class);
      }
      return new LogBlobIterable(getLogDirectory(paramStorageService), paramDate1, paramDate2, (EnumSet)localObject, paramEnumSet, paramBlobRequestOptions, paramOperationContext);
    }
    throw new IllegalArgumentException("Invalid logging operations specified.");
  }
  
  public Iterable<LogRecord> listLogRecords(StorageService paramStorageService)
  {
    return listLogRecords(paramStorageService, null, null, null, null);
  }
  
  public Iterable<LogRecord> listLogRecords(StorageService paramStorageService, Date paramDate1, Date paramDate2, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    Utility.assertNotNull("service", paramStorageService);
    EnumSet localEnumSet1 = EnumSet.allOf(LoggingOperations.class);
    EnumSet localEnumSet2 = EnumSet.noneOf(BlobListingDetails.class);
    return new LogRecordIterable(new LogBlobIterable(getLogDirectory(paramStorageService), paramDate1, paramDate2, localEnumSet1, localEnumSet2, paramBlobRequestOptions, paramOperationContext).iterator());
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.analytics.CloudAnalyticsClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */