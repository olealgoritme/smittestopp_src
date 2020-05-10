package com.microsoft.appcenter.crashes.model;

import com.microsoft.appcenter.ingestion.models.Device;
import java.util.Date;

public class ErrorReport
{
  public Date appErrorTime;
  public Date appStartTime;
  public Device device;
  public String id;
  public String stackTrace;
  public String threadName;
  
  public Date getAppErrorTime()
  {
    return appErrorTime;
  }
  
  public Date getAppStartTime()
  {
    return appStartTime;
  }
  
  public Device getDevice()
  {
    return device;
  }
  
  public String getId()
  {
    return id;
  }
  
  public String getStackTrace()
  {
    return stackTrace;
  }
  
  public String getThreadName()
  {
    return threadName;
  }
  
  @Deprecated
  public Throwable getThrowable()
  {
    return null;
  }
  
  public void setAppErrorTime(Date paramDate)
  {
    appErrorTime = paramDate;
  }
  
  public void setAppStartTime(Date paramDate)
  {
    appStartTime = paramDate;
  }
  
  public void setDevice(Device paramDevice)
  {
    device = paramDevice;
  }
  
  public void setId(String paramString)
  {
    id = paramString;
  }
  
  public void setStackTrace(String paramString)
  {
    stackTrace = paramString;
  }
  
  public void setThreadName(String paramString)
  {
    threadName = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.crashes.model.ErrorReport
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */