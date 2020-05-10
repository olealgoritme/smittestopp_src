package com.microsoft.appcenter.ingestion;

import com.microsoft.appcenter.http.ServiceCall;
import com.microsoft.appcenter.http.ServiceCallback;
import com.microsoft.appcenter.ingestion.models.LogContainer;
import java.io.Closeable;
import java.util.UUID;

public abstract interface Ingestion
  extends Closeable
{
  public abstract void reopen();
  
  public abstract ServiceCall sendAsync(String paramString, UUID paramUUID, LogContainer paramLogContainer, ServiceCallback paramServiceCallback);
  
  public abstract void setLogUrl(String paramString);
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.Ingestion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */