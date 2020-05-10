package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.SharedAccessPolicy;
import java.util.EnumSet;

public final class SharedAccessBlobPolicy
  extends SharedAccessPolicy
{
  public EnumSet<SharedAccessBlobPermissions> permissions;
  
  public EnumSet<SharedAccessBlobPermissions> getPermissions()
  {
    return permissions;
  }
  
  public String permissionsToString()
  {
    if (permissions == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (permissions.contains(SharedAccessBlobPermissions.READ)) {
      localStringBuilder.append("r");
    }
    if (permissions.contains(SharedAccessBlobPermissions.ADD)) {
      localStringBuilder.append("a");
    }
    if (permissions.contains(SharedAccessBlobPermissions.CREATE)) {
      localStringBuilder.append("c");
    }
    if (permissions.contains(SharedAccessBlobPermissions.WRITE)) {
      localStringBuilder.append("w");
    }
    if (permissions.contains(SharedAccessBlobPermissions.DELETE)) {
      localStringBuilder.append("d");
    }
    if (permissions.contains(SharedAccessBlobPermissions.LIST)) {
      localStringBuilder.append("l");
    }
    return localStringBuilder.toString();
  }
  
  public void setPermissions(EnumSet<SharedAccessBlobPermissions> paramEnumSet)
  {
    permissions = paramEnumSet;
  }
  
  public void setPermissionsFromString(String paramString)
  {
    EnumSet localEnumSet = EnumSet.noneOf(SharedAccessBlobPermissions.class);
    for (int k : paramString.toCharArray()) {
      if (k != 97)
      {
        if (k != 108)
        {
          if (k != 114)
          {
            if (k != 119)
            {
              if (k != 99)
              {
                if (k == 100) {
                  localEnumSet.add(SharedAccessBlobPermissions.DELETE);
                } else {
                  throw new IllegalArgumentException("value");
                }
              }
              else {
                localEnumSet.add(SharedAccessBlobPermissions.CREATE);
              }
            }
            else {
              localEnumSet.add(SharedAccessBlobPermissions.WRITE);
            }
          }
          else {
            localEnumSet.add(SharedAccessBlobPermissions.READ);
          }
        }
        else {
          localEnumSet.add(SharedAccessBlobPermissions.LIST);
        }
      }
      else {
        localEnumSet.add(SharedAccessBlobPermissions.ADD);
      }
    }
    permissions = localEnumSet;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.SharedAccessBlobPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */