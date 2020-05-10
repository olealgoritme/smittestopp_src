package com.microsoft.azure.storage;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class StorageEventMultiCaster<EVENT_TYPE extends BaseEvent, EVENT_LISTENER_TYPE extends StorageEvent<EVENT_TYPE>>
{
  public final CopyOnWriteArrayList<EVENT_LISTENER_TYPE> listeners = new CopyOnWriteArrayList();
  
  public void addListener(EVENT_LISTENER_TYPE paramEVENT_LISTENER_TYPE)
  {
    listeners.add(paramEVENT_LISTENER_TYPE);
  }
  
  public void fireEvent(EVENT_TYPE paramEVENT_TYPE)
  {
    Iterator localIterator = listeners.iterator();
    while (localIterator.hasNext()) {
      ((StorageEvent)localIterator.next()).eventOccurred(paramEVENT_TYPE);
    }
  }
  
  public boolean hasListeners()
  {
    boolean bool;
    if (listeners.size() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void removeListener(EVENT_LISTENER_TYPE paramEVENT_LISTENER_TYPE)
  {
    listeners.remove(paramEVENT_LISTENER_TYPE);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.StorageEventMultiCaster
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */