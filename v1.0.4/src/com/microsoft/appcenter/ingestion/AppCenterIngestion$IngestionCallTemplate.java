package com.microsoft.appcenter.ingestion;

import com.microsoft.appcenter.http.AbstractAppCallTemplate;
import com.microsoft.appcenter.ingestion.models.LogContainer;
import com.microsoft.appcenter.ingestion.models.json.LogSerializer;

public class AppCenterIngestion$IngestionCallTemplate
  extends AbstractAppCallTemplate
{
  public final LogContainer mLogContainer;
  public final LogSerializer mLogSerializer;
  
  public AppCenterIngestion$IngestionCallTemplate(LogSerializer paramLogSerializer, LogContainer paramLogContainer)
  {
    mLogSerializer = paramLogSerializer;
    mLogContainer = paramLogContainer;
  }
  
  public String buildRequestBody()
  {
    return mLogSerializer.serializeContainer(mLogContainer);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.AppCenterIngestion.IngestionCallTemplate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */