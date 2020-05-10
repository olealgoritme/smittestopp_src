package com.microsoft.appcenter.ingestion;

import com.microsoft.appcenter.http.AbstractAppCallTemplate;
import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.http.ServiceCall;
import com.microsoft.appcenter.http.ServiceCallback;
import com.microsoft.appcenter.ingestion.models.LogContainer;
import com.microsoft.appcenter.ingestion.models.json.LogSerializer;
import e.a.a.a.a;
import java.io.Closeable;
import java.util.HashMap;
import java.util.UUID;

public class AppCenterIngestion
  implements Ingestion
{
  public static final String API_PATH = "/logs?api-version=1.0.0";
  public static final String DEFAULT_LOG_URL = "https://in.appcenter.ms";
  public static final String INSTALL_ID = "Install-ID";
  public final HttpClient mHttpClient;
  public final LogSerializer mLogSerializer;
  public String mLogUrl;
  
  public AppCenterIngestion(HttpClient paramHttpClient, LogSerializer paramLogSerializer)
  {
    mLogSerializer = paramLogSerializer;
    mHttpClient = paramHttpClient;
    mLogUrl = "https://in.appcenter.ms";
  }
  
  public void close()
  {
    mHttpClient.close();
  }
  
  public void reopen()
  {
    mHttpClient.reopen();
  }
  
  public ServiceCall sendAsync(String paramString, UUID paramUUID, LogContainer paramLogContainer, ServiceCallback paramServiceCallback)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Install-ID", paramUUID.toString());
    localHashMap.put("App-Secret", paramString);
    paramString = new IngestionCallTemplate(mLogSerializer, paramLogContainer);
    return mHttpClient.callAsync(a.a(new StringBuilder(), mLogUrl, "/logs?api-version=1.0.0"), "POST", localHashMap, paramString, paramServiceCallback);
  }
  
  public void setLogUrl(String paramString)
  {
    mLogUrl = paramString;
  }
  
  public static class IngestionCallTemplate
    extends AbstractAppCallTemplate
  {
    public final LogContainer mLogContainer;
    public final LogSerializer mLogSerializer;
    
    public IngestionCallTemplate(LogSerializer paramLogSerializer, LogContainer paramLogContainer)
    {
      mLogSerializer = paramLogSerializer;
      mLogContainer = paramLogContainer;
    }
    
    public String buildRequestBody()
    {
      return mLogSerializer.serializeContainer(mLogContainer);
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.ingestion.AppCenterIngestion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */