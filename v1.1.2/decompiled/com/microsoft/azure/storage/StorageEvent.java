package com.microsoft.azure.storage;

import java.util.EventListener;

public abstract class StorageEvent<T extends BaseEvent>
  implements EventListener
{
  public abstract void eventOccurred(T paramT);
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.StorageEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */