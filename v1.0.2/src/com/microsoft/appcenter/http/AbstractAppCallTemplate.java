package com.microsoft.appcenter.http;

import com.microsoft.appcenter.utils.AppCenterLog;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractAppCallTemplate
  implements HttpClient.CallTemplate
{
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
      paramMap = (String)paramURL.get("App-Secret");
      if (paramMap != null) {
        paramURL.put("App-Secret", HttpUtils.hideSecret(paramMap));
      }
      paramMap = new StringBuilder();
      paramMap.append("Headers: ");
      paramMap.append(paramURL);
      AppCenterLog.verbose("AppCenter", paramMap.toString());
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.http.AbstractAppCallTemplate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */