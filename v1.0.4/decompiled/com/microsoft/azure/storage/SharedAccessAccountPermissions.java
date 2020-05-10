package com.microsoft.azure.storage;

import java.util.EnumSet;
import java.util.Iterator;

public enum SharedAccessAccountPermissions
{
  public final char value;
  
  static
  {
    ADD = new SharedAccessAccountPermissions("ADD", 1, 'a');
    CREATE = new SharedAccessAccountPermissions("CREATE", 2, 'c');
    WRITE = new SharedAccessAccountPermissions("WRITE", 3, 'w');
    DELETE = new SharedAccessAccountPermissions("DELETE", 4, 'd');
    LIST = new SharedAccessAccountPermissions("LIST", 5, 'l');
    UPDATE = new SharedAccessAccountPermissions("UPDATE", 6, 'u');
    SharedAccessAccountPermissions localSharedAccessAccountPermissions = new SharedAccessAccountPermissions("PROCESS_MESSAGES", 7, 'p');
    PROCESS_MESSAGES = localSharedAccessAccountPermissions;
    $VALUES = new SharedAccessAccountPermissions[] { READ, ADD, CREATE, WRITE, DELETE, LIST, UPDATE, localSharedAccessAccountPermissions };
  }
  
  public SharedAccessAccountPermissions(char paramChar)
  {
    value = ((char)paramChar);
  }
  
  public static EnumSet<SharedAccessAccountPermissions> permissionsFromString(String paramString)
  {
    EnumSet localEnumSet = EnumSet.noneOf(SharedAccessAccountPermissions.class);
    char[] arrayOfChar = paramString.toLowerCase().toCharArray();
    int i = arrayOfChar.length;
    int j = 0;
    while (j < i)
    {
      int k = arrayOfChar[j];
      for (SharedAccessAccountPermissions localSharedAccessAccountPermissions : values()) {
        if (k == value)
        {
          localEnumSet.add(localSharedAccessAccountPermissions);
          ??? = 0;
          break label91;
        }
      }
      ??? = 1;
      label91:
      if (??? == 0) {
        j++;
      } else {
        throw new IllegalArgumentException(String.format("%s could not be parsed from '%s'.", new Object[] { "Permissions", paramString }));
      }
    }
    return localEnumSet;
  }
  
  public static String permissionsToString(EnumSet<SharedAccessAccountPermissions> paramEnumSet)
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
 * Qualified Name:     base.com.microsoft.azure.storage.SharedAccessAccountPermissions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */