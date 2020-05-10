package com.microsoft.appcenter.crashes.ingestion.models.json;

import com.microsoft.appcenter.crashes.ingestion.models.Exception;
import com.microsoft.appcenter.ingestion.models.json.ModelFactory;
import java.util.ArrayList;
import java.util.List;

public class ExceptionFactory
  implements ModelFactory<Exception>
{
  public static final ExceptionFactory sInstance = new ExceptionFactory();
  
  public static ExceptionFactory getInstance()
  {
    return sInstance;
  }
  
  public Exception create()
  {
    return new Exception();
  }
  
  public List<Exception> createList(int paramInt)
  {
    return new ArrayList(paramInt);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.ingestion.models.json.ExceptionFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */