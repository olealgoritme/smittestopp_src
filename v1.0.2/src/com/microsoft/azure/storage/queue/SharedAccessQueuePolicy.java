package com.microsoft.azure.storage.queue;

import com.microsoft.azure.storage.SharedAccessPolicy;
import java.util.EnumSet;

public final class SharedAccessQueuePolicy
  extends SharedAccessPolicy
{
  public EnumSet<SharedAccessQueuePermissions> permissions;
  
  public EnumSet<SharedAccessQueuePermissions> getPermissions()
  {
    return permissions;
  }
  
  public String permissionsToString()
  {
    if (permissions == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    if (permissions.contains(SharedAccessQueuePermissions.READ)) {
      localStringBuilder.append("r");
    }
    if (permissions.contains(SharedAccessQueuePermissions.ADD)) {
      localStringBuilder.append("a");
    }
    if (permissions.contains(SharedAccessQueuePermissions.UPDATE)) {
      localStringBuilder.append("u");
    }
    if (permissions.contains(SharedAccessQueuePermissions.PROCESSMESSAGES)) {
      localStringBuilder.append("p");
    }
    return localStringBuilder.toString();
  }
  
  public void setPermissions(EnumSet<SharedAccessQueuePermissions> paramEnumSet)
  {
    permissions = paramEnumSet;
  }
  
  public void setPermissionsFromString(String paramString)
  {
    paramString = paramString.toCharArray();
    EnumSet localEnumSet = EnumSet.noneOf(SharedAccessQueuePermissions.class);
    int i = paramString.length;
    for (int j = 0; j < i; j++)
    {
      int k = paramString[j];
      if (k != 97)
      {
        if (k != 112)
        {
          if (k != 114)
          {
            if (k == 117) {
              localEnumSet.add(SharedAccessQueuePermissions.UPDATE);
            } else {
              throw new IllegalArgumentException("value");
            }
          }
          else {
            localEnumSet.add(SharedAccessQueuePermissions.READ);
          }
        }
        else {
          localEnumSet.add(SharedAccessQueuePermissions.PROCESSMESSAGES);
        }
      }
      else {
        localEnumSet.add(SharedAccessQueuePermissions.ADD);
      }
    }
    permissions = localEnumSet;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.queue.SharedAccessQueuePolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */