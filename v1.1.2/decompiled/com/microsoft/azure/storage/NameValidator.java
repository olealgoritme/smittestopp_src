package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.Utility;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator
{
  public static final int BLOB_FILE_DIRECTORY_MIN_LENGTH = 1;
  public static final int BLOB_MAX_LENGTH = 1024;
  public static final int CONTAINER_SHARE_QUEUE_TABLE_MAX_LENGTH = 63;
  public static final int CONTAINER_SHARE_QUEUE_TABLE_MIN_LENGTH = 3;
  public static final int FILE_DIRECTORY_MAX_LENGTH = 255;
  public static final Pattern FILE_DIRECTORY_REGEX = Pattern.compile("^[^\"\\/:|<>*?]*/{0,1}");
  public static final Pattern METRICS_TABLE_REGEX = Pattern.compile("^\\$Metrics(HourPrimary|MinutePrimary|HourSecondary|MinuteSecondary)?(Transactions)(Blob|Queue|Table)$");
  public static final String[] RESERVED_FILE_NAMES = { ".", "..", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "PRN", "AUX", "NUL", "CON", "CLOCK$" };
  public static final Pattern SHARE_CONTAINER_QUEUE_REGEX = Pattern.compile("^[a-z0-9]+(-[a-z0-9]+)*$");
  public static final Pattern TABLE_REGEX = Pattern.compile("^[A-Za-z][A-Za-z0-9]*$");
  
  public static void ValidateFileDirectoryHelper(String paramString1, String paramString2)
  {
    if (!Utility.isNullOrEmptyOrWhitespace(paramString1))
    {
      if ((paramString1.length() >= 1) && (paramString1.length() <= 255))
      {
        if (FILE_DIRECTORY_REGEX.matcher(paramString1).matches()) {
          return;
        }
        throw new IllegalArgumentException(String.format(Utility.LOCALE_US, "Invalid %s name. Check MSDN for more information about valid naming.", new Object[] { paramString2 }));
      }
      throw new IllegalArgumentException(String.format(Utility.LOCALE_US, "Invalid %s name length. The name must be between %s and %s characters long.", new Object[] { paramString2, Integer.valueOf(1), Integer.valueOf(255) }));
    }
    throw new IllegalArgumentException(String.format(Utility.LOCALE_US, "Invalid %s name. The name may not be null, empty, or whitespace only.", new Object[] { paramString2 }));
  }
  
  public static void validateBlobName(String paramString)
  {
    boolean bool = Utility.isNullOrEmptyOrWhitespace(paramString);
    int i = 0;
    if (!bool)
    {
      if ((paramString.length() >= 1) && (paramString.length() <= 1024))
      {
        int k;
        for (int j = 0; i < paramString.length(); j = k)
        {
          k = j;
          if (paramString.charAt(i) == '/') {
            k = j + 1;
          }
          i++;
        }
        if (j < 254) {
          return;
        }
        throw new IllegalArgumentException("The count of URL path segments (strings between '/' characters) as part of the blob name cannot exceed 254.");
      }
      throw new IllegalArgumentException(String.format(Utility.LOCALE_US, "Invalid %s name length. The name must be between %s and %s characters long.", new Object[] { "blob", Integer.valueOf(1), Integer.valueOf(1024) }));
    }
    throw new IllegalArgumentException(String.format(Utility.LOCALE_US, "Invalid %s name. The name may not be null, empty, or whitespace only.", new Object[] { "blob" }));
  }
  
  public static void validateContainerName(String paramString)
  {
    if ((!"$root".equals(paramString)) && (!"$logs".equals(paramString)) && (!"$web".equals(paramString))) {
      validateShareContainerQueueHelper(paramString, "container");
    }
  }
  
  public static void validateDirectoryName(String paramString)
  {
    ValidateFileDirectoryHelper(paramString, "directory");
  }
  
  public static void validateFileName(String paramString)
  {
    ValidateFileDirectoryHelper(paramString, "file");
    if (!paramString.endsWith("/"))
    {
      String[] arrayOfString = RESERVED_FILE_NAMES;
      int i = arrayOfString.length;
      int j = 0;
      while (j < i) {
        if (!arrayOfString[j].equalsIgnoreCase(paramString)) {
          j++;
        } else {
          throw new IllegalArgumentException(String.format(Utility.LOCALE_US, "Invalid %s name. This name is reserved.", new Object[] { "file" }));
        }
      }
      return;
    }
    throw new IllegalArgumentException(String.format(Utility.LOCALE_US, "Invalid %s name. Check MSDN for more information about valid naming.", new Object[] { "file" }));
  }
  
  public static void validateQueueName(String paramString)
  {
    validateShareContainerQueueHelper(paramString, "queue");
  }
  
  public static void validateShareContainerQueueHelper(String paramString1, String paramString2)
  {
    if (!Utility.isNullOrEmptyOrWhitespace(paramString1))
    {
      if ((paramString1.length() >= 3) && (paramString1.length() <= 63))
      {
        if (SHARE_CONTAINER_QUEUE_REGEX.matcher(paramString1).matches()) {
          return;
        }
        throw new IllegalArgumentException(String.format(Utility.LOCALE_US, "Invalid %s name. Check MSDN for more information about valid naming.", new Object[] { paramString2 }));
      }
      throw new IllegalArgumentException(String.format(Utility.LOCALE_US, "Invalid %s name length. The name must be between %s and %s characters long.", new Object[] { paramString2, Integer.valueOf(3), Integer.valueOf(63) }));
    }
    throw new IllegalArgumentException(String.format(Utility.LOCALE_US, "Invalid %s name. The name may not be null, empty, or whitespace only.", new Object[] { paramString2 }));
  }
  
  public static void validateShareName(String paramString)
  {
    validateShareContainerQueueHelper(paramString, "share");
  }
  
  public static void validateTableName(String paramString)
  {
    if (!Utility.isNullOrEmptyOrWhitespace(paramString))
    {
      if ((paramString.length() >= 3) && (paramString.length() <= 63))
      {
        if ((!TABLE_REGEX.matcher(paramString).matches()) && (!METRICS_TABLE_REGEX.matcher(paramString).matches()) && (!paramString.equalsIgnoreCase("$MetricsCapacityBlob"))) {
          throw new IllegalArgumentException(String.format(Utility.LOCALE_US, "Invalid %s name. Check MSDN for more information about valid naming.", new Object[] { "table" }));
        }
        return;
      }
      throw new IllegalArgumentException(String.format(Utility.LOCALE_US, "Invalid %s name length. The name must be between %s and %s characters long.", new Object[] { "table", Integer.valueOf(3), Integer.valueOf(63) }));
    }
    throw new IllegalArgumentException(String.format(Utility.LOCALE_US, "Invalid %s name. The name may not be null, empty, or whitespace only.", new Object[] { "table" }));
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.NameValidator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */