package com.microsoft.azure.storage.analytics;

import com.microsoft.azure.storage.LoggingOperations;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.BlobListingDetails;
import com.microsoft.azure.storage.blob.BlobRequestOptions;
import com.microsoft.azure.storage.blob.CloudBlob;
import com.microsoft.azure.storage.blob.CloudBlobDirectory;
import com.microsoft.azure.storage.blob.ListBlobItem;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumSet;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TimeZone;

public class LogBlobIterator
  implements Iterator<ListBlobItem>
{
  public static final DateFormat DAY_FORMAT;
  public static final int DAY_FORMAT_LENGTH = 10;
  public static final String DAY_STRING = "yyyy/MM/dd";
  public static final DateFormat HOUR_FORMAT = new SimpleDateFormat("yyyy/MM/dd/HH");
  public static final int HOUR_FORMAT_LENGTH;
  public static final String HOUR_STRING = "yyyy/MM/dd/HH";
  public static final DateFormat MONTH_FORMAT;
  public static final int MONTH_FORMAT_LENGTH = 7;
  public static final String MONTH_STRING = "yyyy/MM";
  public static final DateFormat YEAR_FORMAT;
  public static final String YEAR_STRING = "yyyy";
  public Iterator<ListBlobItem> currentIterator;
  public String currentPrefixTime = null;
  public final EnumSet<BlobListingDetails> details;
  public Calendar endDate = null;
  public String endPrefix;
  public Boolean isExpired;
  public Boolean isItemPending;
  public final CloudBlobDirectory logDirectory;
  public final OperationContext opContext;
  public final EnumSet<LoggingOperations> operations;
  public final BlobRequestOptions options;
  public ListBlobItem pendingItem;
  public Calendar startDate = null;
  
  static
  {
    DAY_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
    MONTH_FORMAT = new SimpleDateFormat("yyyy/MM");
    YEAR_FORMAT = new SimpleDateFormat("yyyy");
    HOUR_FORMAT_LENGTH = 13;
  }
  
  public LogBlobIterator(CloudBlobDirectory paramCloudBlobDirectory, Date paramDate1, Date paramDate2, EnumSet<LoggingOperations> paramEnumSet, EnumSet<BlobListingDetails> paramEnumSet1, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext)
  {
    Object localObject = Boolean.valueOf(false);
    isItemPending = ((Boolean)localObject);
    isExpired = ((Boolean)localObject);
    localObject = TimeZone.getTimeZone("GMT");
    HOUR_FORMAT.setTimeZone((TimeZone)localObject);
    DAY_FORMAT.setTimeZone((TimeZone)localObject);
    MONTH_FORMAT.setTimeZone((TimeZone)localObject);
    YEAR_FORMAT.setTimeZone((TimeZone)localObject);
    logDirectory = paramCloudBlobDirectory;
    operations = paramEnumSet;
    details = paramEnumSet1;
    opContext = paramOperationContext;
    if (paramBlobRequestOptions == null) {
      options = new BlobRequestOptions();
    } else {
      options = paramBlobRequestOptions;
    }
    if (paramDate1 != null)
    {
      paramCloudBlobDirectory = new GregorianCalendar();
      startDate = paramCloudBlobDirectory;
      paramCloudBlobDirectory.setTime(paramDate1);
      paramCloudBlobDirectory = startDate;
      paramCloudBlobDirectory.add(12, -paramCloudBlobDirectory.get(12));
      startDate.setTimeZone((TimeZone)localObject);
    }
    if (paramDate2 != null)
    {
      paramCloudBlobDirectory = new GregorianCalendar();
      endDate = paramCloudBlobDirectory;
      paramCloudBlobDirectory.setTime(paramDate2);
      endDate.setTimeZone((TimeZone)localObject);
      paramCloudBlobDirectory = new StringBuilder();
      paramCloudBlobDirectory.append(logDirectory.getPrefix());
      paramCloudBlobDirectory.append(HOUR_FORMAT.format(endDate.getTime()));
      endPrefix = paramCloudBlobDirectory.toString();
    }
  }
  
  private boolean isCorrectLogType(ListBlobItem paramListBlobItem)
  {
    paramListBlobItem = (String)((CloudBlob)paramListBlobItem).getMetadata().get("LogType");
    if (paramListBlobItem == null) {
      return true;
    }
    if ((operations.contains(LoggingOperations.READ)) && (paramListBlobItem.contains("read"))) {
      return true;
    }
    if ((operations.contains(LoggingOperations.WRITE)) && (paramListBlobItem.contains("write"))) {
      return true;
    }
    return (operations.contains(LoggingOperations.DELETE)) && (paramListBlobItem.contains("delete"));
  }
  
  private void updateIterator()
  {
    Object localObject = currentPrefixTime;
    Boolean localBoolean = Boolean.valueOf(true);
    if ((localObject != null) && (((String)localObject).isEmpty()))
    {
      isExpired = localBoolean;
      return;
    }
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    localGregorianCalendar.add(11, 1);
    localGregorianCalendar.setTimeZone(TimeZone.getTimeZone("GMT"));
    updatePrefix();
    localObject = startDate;
    if ((localObject == null) || (((Calendar)localObject).compareTo(localGregorianCalendar) <= 0))
    {
      if (endDate != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(logDirectory.getPrefix());
        ((StringBuilder)localObject).append(currentPrefixTime);
        if (((StringBuilder)localObject).toString().compareTo(endPrefix) <= 0) {}
      }
    }
    else
    {
      isExpired = localBoolean;
      return;
    }
    currentIterator = logDirectory.listBlobs(currentPrefixTime, true, details, options, opContext).iterator();
  }
  
  private void updatePrefix()
  {
    Calendar localCalendar = startDate;
    if (localCalendar == null)
    {
      currentPrefixTime = "";
    }
    else
    {
      String str = currentPrefixTime;
      if (str == null)
      {
        currentPrefixTime = HOUR_FORMAT.format(localCalendar.getTime());
      }
      else if (str.length() == HOUR_FORMAT_LENGTH)
      {
        startDate.add(11, 1);
        if (startDate.get(11) != 0) {
          currentPrefixTime = HOUR_FORMAT.format(startDate.getTime());
        } else {
          currentPrefixTime = DAY_FORMAT.format(startDate.getTime());
        }
      }
      else if (currentPrefixTime.length() == DAY_FORMAT_LENGTH)
      {
        startDate.add(5, 1);
        if (startDate.get(5) != 1) {
          currentPrefixTime = DAY_FORMAT.format(startDate.getTime());
        } else {
          currentPrefixTime = MONTH_FORMAT.format(startDate.getTime());
        }
      }
      else if (currentPrefixTime.length() == MONTH_FORMAT_LENGTH)
      {
        startDate.add(2, 1);
        if (startDate.get(2) != 13) {
          currentPrefixTime = MONTH_FORMAT.format(startDate.getTime());
        } else {
          currentPrefixTime = YEAR_FORMAT.format(startDate.getTime());
        }
      }
      else
      {
        startDate.add(1, 1);
        currentPrefixTime = YEAR_FORMAT.format(startDate.getTime());
      }
    }
  }
  
  public boolean hasNext()
  {
    boolean bool = isItemPending.booleanValue();
    Object localObject = Boolean.valueOf(true);
    if (bool) {
      return true;
    }
    try
    {
      if (currentIterator == null) {
        updateIterator();
      }
      while (!isExpired.booleanValue())
      {
        while (currentIterator.hasNext())
        {
          ListBlobItem localListBlobItem = (ListBlobItem)currentIterator.next();
          if ((endDate != null) && (localListBlobItem.getParent().getPrefix().compareTo(endPrefix) > 0))
          {
            isExpired = ((Boolean)localObject);
            return false;
          }
          if (isCorrectLogType(localListBlobItem))
          {
            pendingItem = localListBlobItem;
            isItemPending = ((Boolean)localObject);
            return true;
          }
        }
        updateIterator();
      }
      return false;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      localObject = new NoSuchElementException("An error occurred while enumerating the result, check the original exception for details.");
      ((NoSuchElementException)localObject).initCause(localURISyntaxException);
      throw ((Throwable)localObject);
    }
    catch (StorageException localStorageException)
    {
      NoSuchElementException localNoSuchElementException = new NoSuchElementException("An error occurred while enumerating the result, check the original exception for details.");
      localNoSuchElementException.initCause(localStorageException);
      throw localNoSuchElementException;
    }
  }
  
  public ListBlobItem next()
  {
    if (isItemPending.booleanValue())
    {
      isItemPending = Boolean.valueOf(false);
      return pendingItem;
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
 * Qualified Name:     base.com.microsoft.azure.storage.analytics.LogBlobIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */