package com.microsoft.azure.storage.table;

import java.util.EnumSet;

public enum SharedAccessTablePermissions
{
  public byte value;
  
  static
  {
    ADD = new SharedAccessTablePermissions("ADD", 2, (byte)2);
    UPDATE = new SharedAccessTablePermissions("UPDATE", 3, (byte)4);
    SharedAccessTablePermissions localSharedAccessTablePermissions = new SharedAccessTablePermissions("DELETE", 4, (byte)8);
    DELETE = localSharedAccessTablePermissions;
    $VALUES = new SharedAccessTablePermissions[] { NONE, QUERY, ADD, UPDATE, localSharedAccessTablePermissions };
  }
  
  public SharedAccessTablePermissions(byte paramByte)
  {
    value = ((byte)paramByte);
  }
  
  public static EnumSet<SharedAccessTablePermissions> fromByte(byte paramByte)
  {
    EnumSet localEnumSet = EnumSet.noneOf(SharedAccessTablePermissions.class);
    SharedAccessTablePermissions localSharedAccessTablePermissions = QUERY;
    if (paramByte == value) {
      localEnumSet.add(localSharedAccessTablePermissions);
    }
    localSharedAccessTablePermissions = ADD;
    if (paramByte == value) {
      localEnumSet.add(localSharedAccessTablePermissions);
    }
    localSharedAccessTablePermissions = UPDATE;
    if (paramByte == value) {
      localEnumSet.add(localSharedAccessTablePermissions);
    }
    localSharedAccessTablePermissions = DELETE;
    if (paramByte == value) {
      localEnumSet.add(localSharedAccessTablePermissions);
    }
    return localEnumSet;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.table.SharedAccessTablePermissions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */