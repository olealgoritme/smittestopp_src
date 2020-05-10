package com.microsoft.appcenter.crashes.ingestion.models.json;

import com.microsoft.appcenter.crashes.ingestion.models.ErrorAttachmentLog;
import com.microsoft.appcenter.ingestion.models.json.AbstractLogFactory;

public class ErrorAttachmentLogFactory
  extends AbstractLogFactory
{
  public static final ErrorAttachmentLogFactory sInstance = new ErrorAttachmentLogFactory();
  
  public static ErrorAttachmentLogFactory getInstance()
  {
    return sInstance;
  }
  
  public ErrorAttachmentLog create()
  {
    return new ErrorAttachmentLog();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.ingestion.models.json.ErrorAttachmentLogFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */