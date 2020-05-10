package com.microsoft.appcenter.crashes.ingestion.models.json;

import com.microsoft.appcenter.crashes.ingestion.models.Thread;
import com.microsoft.appcenter.ingestion.models.json.ModelFactory;
import java.util.ArrayList;
import java.util.List;

public class ThreadFactory
  implements ModelFactory<Thread>
{
  public static final ThreadFactory sInstance = new ThreadFactory();
  
  public static ThreadFactory getInstance()
  {
    return sInstance;
  }
  
  public Thread create()
  {
    return new Thread();
  }
  
  public List<Thread> createList(int paramInt)
  {
    return new ArrayList(paramInt);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.crashes.ingestion.models.json.ThreadFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */