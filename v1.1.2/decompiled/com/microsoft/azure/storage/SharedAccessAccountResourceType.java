package com.microsoft.azure.storage;

import java.util.EnumSet;
import java.util.Iterator;

public enum SharedAccessAccountResourceType
{
  public char value;
  
  static
  {
    CONTAINER = new SharedAccessAccountResourceType("CONTAINER", 1, 'c');
    SharedAccessAccountResourceType localSharedAccessAccountResourceType = new SharedAccessAccountResourceType("OBJECT", 2, 'o');
    OBJECT = localSharedAccessAccountResourceType;
    $VALUES = new SharedAccessAccountResourceType[] { SERVICE, CONTAINER, localSharedAccessAccountResourceType };
  }
  
  public SharedAccessAccountResourceType(char paramChar)
  {
    value = ((char)paramChar);
  }
  
  public static EnumSet<SharedAccessAccountResourceType> resourceTypesFromString(String paramString)
  {
    EnumSet localEnumSet = EnumSet.noneOf(SharedAccessAccountResourceType.class);
    char[] arrayOfChar = paramString.toLowerCase().toCharArray();
    int i = arrayOfChar.length;
    int j = 0;
    while (j < i)
    {
      int k = arrayOfChar[j];
      for (SharedAccessAccountResourceType localSharedAccessAccountResourceType : values()) {
        if (k == value)
        {
          localEnumSet.add(localSharedAccessAccountResourceType);
          ??? = 0;
          break label91;
        }
      }
      ??? = 1;
      label91:
      if (??? == 0) {
        j++;
      } else {
        throw new IllegalArgumentException(String.format("%s could not be parsed from '%s'.", new Object[] { "Resource Types", paramString }));
      }
    }
    return localEnumSet;
  }
  
  public static String resourceTypesToString(EnumSet<SharedAccessAccountResourceType> paramEnumSet)
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
 * Qualified Name:     com.microsoft.azure.storage.SharedAccessAccountResourceType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */