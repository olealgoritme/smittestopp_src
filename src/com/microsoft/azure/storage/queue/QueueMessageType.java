package com.microsoft.azure.storage.queue;

public enum QueueMessageType
{
  static
  {
    QueueMessageType localQueueMessageType = new QueueMessageType("BASE_64_ENCODED", 1);
    BASE_64_ENCODED = localQueueMessageType;
    $VALUES = new QueueMessageType[] { RAW_STRING, localQueueMessageType };
  }
  
  public QueueMessageType() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.queue.QueueMessageType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */