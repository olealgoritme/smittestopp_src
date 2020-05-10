package com.microsoft.appcenter.crashes.ingestion.models.json;

import com.microsoft.appcenter.crashes.ingestion.models.StackFrame;
import com.microsoft.appcenter.ingestion.models.json.ModelFactory;
import java.util.ArrayList;
import java.util.List;

public class StackFrameFactory
  implements ModelFactory<StackFrame>
{
  public static final StackFrameFactory sInstance = new StackFrameFactory();
  
  public static StackFrameFactory getInstance()
  {
    return sInstance;
  }
  
  public StackFrame create()
  {
    return new StackFrame();
  }
  
  public List<StackFrame> createList(int paramInt)
  {
    return new ArrayList(paramInt);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.ingestion.models.json.StackFrameFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */