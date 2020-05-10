package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.SharedAccessPolicy;
import java.util.EnumSet;

public final class SharedAccessTablePolicy
  extends SharedAccessPolicy
{
  public EnumSet<SharedAccessTablePermissions> permissions;
  
  public EnumSet<SharedAccessTablePermissions> getPermissions()
  {
    return permissions;
  }
  
  public String permissionsToString()
  {
    if (permissions == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (permissions.contains(SharedAccessTablePermissions.QUERY)) {
      localStringBuilder.append("r");
    }
    if (permissions.contains(SharedAccessTablePermissions.ADD)) {
      localStringBuilder.append("a");
    }
    if (permissions.contains(SharedAccessTablePermissions.UPDATE)) {
      localStringBuilder.append("u");
    }
    if (permissions.contains(SharedAccessTablePermissions.DELETE)) {
      localStringBuilder.append("d");
    }
    return localStringBuilder.toString();
  }
  
  public void setPermissions(EnumSet<SharedAccessTablePermissions> paramEnumSet)
  {
    permissions = paramEnumSet;
  }
  
  public void setPermissionsFromString(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    EnumSet localEnumSet = EnumSet.noneOf(SharedAccessTablePermissions.class);
    int i = arrayOfChar.length;
    for (int j = 0; j < i; j++)
    {
      int k = arrayOfChar[j];
      if (k != 97)
      {
        if (k != 100)
        {
          if (k != 114)
          {
            if (k == 117) {
              localEnumSet.add(SharedAccessTablePermissions.UPDATE);
            } else {
              throw new IllegalArgumentException(String.format("%s could not be parsed from '%s'.", new Object[] { "Permissions", paramString }));
            }
          }
          else {
            localEnumSet.add(SharedAccessTablePermissions.QUERY);
          }
        }
        else {
          localEnumSet.add(SharedAccessTablePermissions.DELETE);
        }
      }
      else {
        localEnumSet.add(SharedAccessTablePermissions.ADD);
      }
    }
    permissions = localEnumSet;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.table.SharedAccessTablePolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */