package com.microsoft.appcenter.ingestion.models.json;

import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.ingestion.models.LogContainer;
import com.microsoft.appcenter.ingestion.models.Model;
import com.microsoft.appcenter.ingestion.models.one.CommonSchemaLog;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class DefaultLogSerializer
  implements LogSerializer
{
  public static final String LOGS = "logs";
  public final Map<String, LogFactory> mLogFactories = new HashMap();
  
  private Log readLog(JSONObject paramJSONObject, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = paramJSONObject.getString("type");
    }
    paramString = (LogFactory)mLogFactories.get(str);
    if (paramString != null)
    {
      paramString = paramString.create();
      paramString.read(paramJSONObject);
      return paramString;
    }
    throw new JSONException(a.b("Unknown log type: ", str));
  }
  
  private JSONStringer writeLog(JSONStringer paramJSONStringer, Log paramLog)
  {
    paramJSONStringer.object();
    paramLog.write(paramJSONStringer);
    paramJSONStringer.endObject();
    return paramJSONStringer;
  }
  
  public void addLogFactory(String paramString, LogFactory paramLogFactory)
  {
    mLogFactories.put(paramString, paramLogFactory);
  }
  
  public LogContainer deserializeContainer(String paramString1, String paramString2)
  {
    Object localObject = new JSONObject(paramString1);
    paramString1 = new LogContainer();
    JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("logs");
    localObject = new ArrayList();
    for (int i = 0; i < localJSONArray.length(); i++) {
      ((ArrayList)localObject).add(readLog(localJSONArray.getJSONObject(i), paramString2));
    }
    paramString1.setLogs((List)localObject);
    return paramString1;
  }
  
  public Log deserializeLog(String paramString1, String paramString2)
  {
    return readLog(new JSONObject(paramString1), paramString2);
  }
  
  public String serializeContainer(LogContainer paramLogContainer)
  {
    JSONStringer localJSONStringer = new JSONStringer();
    localJSONStringer.object();
    localJSONStringer.key("logs").array();
    paramLogContainer = paramLogContainer.getLogs().iterator();
    while (paramLogContainer.hasNext()) {
      writeLog(localJSONStringer, (Log)paramLogContainer.next());
    }
    localJSONStringer.endArray();
    localJSONStringer.endObject();
    return localJSONStringer.toString();
  }
  
  public String serializeLog(Log paramLog)
  {
    return writeLog(new JSONStringer(), paramLog).toString();
  }
  
  public Collection<CommonSchemaLog> toCommonSchemaLog(Log paramLog)
  {
    return ((LogFactory)mLogFactories.get(paramLog.getType())).toCommonSchemaLogs(paramLog);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.ingestion.models.json.DefaultLogSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */