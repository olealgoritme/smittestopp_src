package com.microsoft.azure.storage;

import java.util.EnumSet;
import java.util.Iterator;

public enum SharedAccessAccountService
{
  public char value;
  
  static
  {
    SharedAccessAccountService localSharedAccessAccountService = new SharedAccessAccountService("TABLE", 3, 't');
    TABLE = localSharedAccessAccountService;
    $VALUES = new SharedAccessAccountService[] { BLOB, FILE, QUEUE, localSharedAccessAccountService };
  }
  
  public SharedAccessAccountService(char paramChar)
  {
    value = ((char)paramChar);
  }
  
  public static EnumSet<SharedAccessAccountService> servicesFromString(String paramString)
  {
    EnumSet localEnumSet = EnumSet.noneOf(SharedAccessAccountService.class);
    char[] arrayOfChar = paramString.toLowerCase().toCharArray();
    int i = arrayOfChar.length;
    int j = 0;
    while (j < i)
    {
      int k = arrayOfChar[j];
      for (SharedAccessAccountService localSharedAccessAccountService : values()) {
        if (k == value)
        {
          localEnumSet.add(localSharedAccessAccountService);
          ??? = 0;
          break label91;
        }
      }
      ??? = 1;
      label91:
      if (??? == 0) {
        j++;
      } else {
        throw new IllegalArgumentException(String.format("%s could not be parsed from '%s'.", new Object[] { "Services", paramString }));
      }
    }
    return localEnumSet;
  }
  
  public static String servicesToString(EnumSet<SharedAccessAccountService> paramEnumSet)
  {
    if (paramEnumSet == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramEnumSet = paramEnumSet.iterator();
    while (paramEnumSet.hasNext()) {
      localStringBuilder.append(nextvalue);
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.SharedAccessAccountService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */