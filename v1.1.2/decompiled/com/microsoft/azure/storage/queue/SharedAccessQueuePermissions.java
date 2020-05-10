package com.microsoft.azure.storage.queue;

import java.util.EnumSet;

public enum SharedAccessQueuePermissions
{
  public byte value;
  
  static
  {
    ADD = new SharedAccessQueuePermissions("ADD", 2, (byte)2);
    UPDATE = new SharedAccessQueuePermissions("UPDATE", 3, (byte)4);
    SharedAccessQueuePermissions localSharedAccessQueuePermissions = new SharedAccessQueuePermissions("PROCESSMESSAGES", 4, (byte)8);
    PROCESSMESSAGES = localSharedAccessQueuePermissions;
    $VALUES = new SharedAccessQueuePermissions[] { NONE, READ, ADD, UPDATE, localSharedAccessQueuePermissions };
  }
  
  public SharedAccessQueuePermissions(byte paramByte)
  {
    value = ((byte)paramByte);
  }
  
  public static EnumSet<SharedAccessQueuePermissions> fromByte(byte paramByte)
  {
    EnumSet localEnumSet = EnumSet.noneOf(SharedAccessQueuePermissions.class);
    SharedAccessQueuePermissions localSharedAccessQueuePermissions = READ;
    if (paramByte == value) {
      localEnumSet.add(localSharedAccessQueuePermissions);
    }
    localSharedAccessQueuePermissions = PROCESSMESSAGES;
    if (paramByte == value) {
      localEnumSet.add(localSharedAccessQueuePermissions);
    }
    localSharedAccessQueuePermissions = ADD;
    if (paramByte == value) {
      localEnumSet.add(localSharedAccessQueuePermissions);
    }
    localSharedAccessQueuePermissions = UPDATE;
    if (paramByte == value) {
      localEnumSet.add(localSharedAccessQueuePermissions);
    }
    return localEnumSet;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.queue.SharedAccessQueuePermissions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */