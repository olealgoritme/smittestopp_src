package com.microsoft.azure.storage.queue;

public enum MessageUpdateFields
{
  public int value;
  
  static
  {
    MessageUpdateFields localMessageUpdateFields = new MessageUpdateFields("CONTENT", 1, 2);
    CONTENT = localMessageUpdateFields;
    $VALUES = new MessageUpdateFields[] { VISIBILITY, localMessageUpdateFields };
  }
  
  public MessageUpdateFields(int paramInt)
  {
    value = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.queue.MessageUpdateFields
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */