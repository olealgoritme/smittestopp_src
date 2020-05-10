package com.microsoft.appcenter.ingestion;

import com.microsoft.appcenter.Constants;
import com.microsoft.appcenter.http.HttpClient;
import com.microsoft.appcenter.http.ServiceCall;
import com.microsoft.appcenter.http.ServiceCallback;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.LogContainer;
import com.microsoft.appcenter.ingestion.models.json.LogSerializer;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import com.microsoft.appcenter.ingestion.models.one.Extensions;
import com.microsoft.appcenter.ingestion.models.one.ProtocolExtension;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.TicketCache;
import java.io.Closeable;
import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class OneCollectorIngestion
  implements Ingestion
{
  public static final String API_KEY = "apikey";
  public static final String CLIENT_VERSION_FORMAT = "ACS-Android-Java-no-%s-no";
  public static final String CLIENT_VERSION_KEY = "Client-Version";
  public static final String CONTENT_TYPE_VALUE = "application/x-json-stream; charset=utf-8";
  public static final String DEFAULT_LOG_URL = "https://mobile.events.data.microsoft.com/OneCollector/1.0";
  public static final String STRICT = "Strict";
  public static final String TICKETS = "Tickets";
  public static final String UPLOAD_TIME_KEY = "Upload-Time";
  public final HttpClient mHttpClient;
  public final LogSerializer mLogSerializer;
  public String mLogUrl;
  
  public OneCollectorIngestion(HttpClient paramHttpClient, LogSerializer paramLogSerializer)
  {
    mLogSerializer = paramLogSerializer;
    mHttpClient = paramHttpClient;
    mLogUrl = "https://mobile.events.data.microsoft.com/OneCollector/1.0";
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
    paramString = new HashMap();
    paramUUID = new LinkedHashSet();
    Object localObject1 = paramLogContainer.getLogs().iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramUUID.addAll(((Log)((Iterator)localObject1).next()).getTransmissionTargetTokens());
    }
    localObject1 = new StringBuilder();
    Object localObject2 = paramUUID.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ((StringBuilder)localObject1).append((String)((Iterator)localObject2).next());
      ((StringBuilder)localObject1).append(",");
    }
    if (!paramUUID.isEmpty()) {
      ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
    }
    paramString.put("apikey", ((StringBuilder)localObject1).toString());
    paramUUID = new JSONObject();
    localObject1 = paramLogContainer.getLogs().iterator();
    for (;;)
    {
      label163:
      if (!((Iterator)localObject1).hasNext()) {
        break label271;
      }
      localObject2 = ((CommonSchemaLog)((Iterator)localObject1).next()).getExt().getProtocol().getTicketKeys();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label163;
          }
          String str1 = (String)((Iterator)localObject2).next();
          String str2 = TicketCache.getTicket(str1);
          if (str2 == null) {
            break;
          }
          try
          {
            paramUUID.put(str1, str2);
          }
          catch (JSONException localJSONException)
          {
            AppCenterLog.error("AppCenter", "Cannot serialize tickets, sending log anonymously", localJSONException);
          }
        }
      }
    }
    label271:
    if (paramUUID.length() > 0)
    {
      paramString.put("Tickets", paramUUID.toString());
      if (Constants.APPLICATION_DEBUGGABLE) {
        paramString.put("Strict", Boolean.TRUE.toString());
      }
    }
    paramString.put("Content-Type", "application/x-json-stream; charset=utf-8");
    paramString.put("Client-Version", String.format("ACS-Android-Java-no-%s-no", new Object[] { "3.1.0" }));
    paramString.put("Upload-Time", String.valueOf(System.currentTimeMillis()));
    paramUUID = new OneCollectorIngestion.IngestionCallTemplate(mLogSerializer, paramLogContainer);
    return mHttpClient.callAsync(mLogUrl, "POST", paramString, paramUUID, paramServiceCallback);
  }
  
  public void setLogUrl(String paramString)
  {
    mLogUrl = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.OneCollectorIngestion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */