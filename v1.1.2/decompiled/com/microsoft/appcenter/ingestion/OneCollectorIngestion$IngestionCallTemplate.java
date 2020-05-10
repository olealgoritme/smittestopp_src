package com.microsoft.appcenter.ingestion;

import com.microsoft.appcenter.http.HttpClient.CallTemplate;
import com.microsoft.appcenter.http.HttpUtils;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.LogContainer;
import com.microsoft.appcenter.ingestion.models.json.LogSerializer;
import com.microsoft.appcenter.utils.AppCenterLog;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OneCollectorIngestion$IngestionCallTemplate
  implements HttpClient.CallTemplate
{
  public final LogContainer mLogContainer;
  public final LogSerializer mLogSerializer;
  
  public OneCollectorIngestion$IngestionCallTemplate(LogSerializer paramLogSerializer, LogContainer paramLogContainer)
  {
    mLogSerializer = paramLogSerializer;
    mLogContainer = paramLogContainer;
  }
  
  public String buildRequestBody()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = mLogContainer.getLogs().iterator();
    while (localIterator.hasNext())
    {
      Log localLog = (Log)localIterator.next();
      localStringBuilder.append(mLogSerializer.serializeLog(localLog));
      localStringBuilder.append('\n');
    }
    return localStringBuilder.toString();
  }
  
  public void onBeforeCalling(URL paramURL, Map<String, String> paramMap)
  {
    if (AppCenterLog.getLogLevel() <= 2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Calling ");
      localStringBuilder.append(paramURL);
      localStringBuilder.append("...");
      AppCenterLog.verbose("AppCenter", localStringBuilder.toString());
      paramURL = new HashMap(paramMap);
      paramMap = (String)paramURL.get("apikey");
      if (paramMap != null) {
        paramURL.put("apikey", HttpUtils.hideApiKeys(paramMap));
      }
      paramMap = (String)paramURL.get("Tickets");
      if (paramMap != null) {
        paramURL.put("Tickets", HttpUtils.hideTickets(paramMap));
      }
      paramMap = new StringBuilder();
      paramMap.append("Headers: ");
      paramMap.append(paramURL);
      AppCenterLog.verbose("AppCenter", paramMap.toString());
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.ingestion.OneCollectorIngestion.IngestionCallTemplate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */