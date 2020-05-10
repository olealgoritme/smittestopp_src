package com.microsoft.azure.storage.file;

import com.microsoft.azure.storage.SharedAccessPolicy;
import java.util.EnumSet;

public final class SharedAccessFilePolicy
  extends SharedAccessPolicy
{
  public EnumSet<SharedAccessFilePermissions> permissions;
  
  public EnumSet<SharedAccessFilePermissions> getPermissions()
  {
    return permissions;
  }
  
  public String permissionsToString()
  {
    if (permissions == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (permissions.contains(SharedAccessFilePermissions.READ)) {
      localStringBuilder.append("r");
    }
    if (permissions.contains(SharedAccessFilePermissions.CREATE)) {
      localStringBuilder.append("c");
    }
    if (permissions.contains(SharedAccessFilePermissions.WRITE)) {
      localStringBuilder.append("w");
    }
    if (permissions.contains(SharedAccessFilePermissions.DELETE)) {
      localStringBuilder.append("d");
    }
    if (permissions.contains(SharedAccessFilePermissions.LIST)) {
      localStringBuilder.append("l");
    }
    return localStringBuilder.toString();
  }
  
  public void setPermissions(EnumSet<SharedAccessFilePermissions> paramEnumSet)
  {
    permissions = paramEnumSet;
  }
  
  public void setPermissionsFromString(String paramString)
  {
    EnumSet localEnumSet = EnumSet.noneOf(SharedAccessFilePermissions.class);
    for (int k : paramString.toCharArray()) {
      if (k != 99)
      {
        if (k != 100)
        {
          if (k != 108)
          {
            if (k != 114)
            {
              if (k == 119) {
                localEnumSet.add(SharedAccessFilePermissions.WRITE);
              } else {
                throw new IllegalArgumentException("value");
              }
            }
            else {
              localEnumSet.add(SharedAccessFilePermissions.READ);
            }
          }
          else {
            localEnumSet.add(SharedAccessFilePermissions.LIST);
          }
        }
        else {
          localEnumSet.add(SharedAccessFilePermissions.DELETE);
        }
      }
      else {
        localEnumSet.add(SharedAccessFilePermissions.CREATE);
      }
    }
    permissions = localEnumSet;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.file.SharedAccessFilePolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */