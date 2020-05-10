package com.microsoft.azure.storage.queue;

public enum QueueListingDetails
{
  public int value;
  
  static
  {
    QueueListingDetails localQueueListingDetails = new QueueListingDetails("NONE", 2, 0);
    NONE = localQueueListingDetails;
    $VALUES = new QueueListingDetails[] { ALL, METADATA, localQueueListingDetails };
  }
  
  public QueueListingDetails(int paramInt)
  {
    value = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.queue.QueueListingDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */