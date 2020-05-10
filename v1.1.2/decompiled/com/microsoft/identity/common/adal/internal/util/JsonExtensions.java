package com.microsoft.identity.common.adal.internal.util;

import com.google.gson.Gson;
import com.microsoft.identity.common.internal.broker.BrokerResult;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.util.ICacheRecordGsonAdapter;
import e.c.c.e;
import e.c.c.w.t;
import e.c.c.x.a;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class JsonExtensions
{
  public static Map<String, String> extractJsonObjectIntoMap(String paramString)
  {
    JSONObject localJSONObject = new JSONObject(paramString);
    Iterator localIterator = localJSONObject.keys();
    HashMap localHashMap = new HashMap();
    while (localIterator.hasNext())
    {
      paramString = (String)localIterator.next();
      localHashMap.put(paramString, localJSONObject.getString(paramString));
    }
    return localHashMap;
  }
  
  public static BrokerResult getBrokerResultFromJsonString(String paramString)
  {
    e locale = new e();
    locale.a(ICacheRecord.class, new ICacheRecordGsonAdapter());
    paramString = locale.a().a(paramString, BrokerResult.class);
    return (BrokerResult)t.a(BrokerResult.class).cast(paramString);
  }
  
  public static List<ICacheRecord> getICacheRecordListFromJsonString(String paramString)
  {
    e locale = new e();
    locale.a(ICacheRecord.class, new ICacheRecordGsonAdapter());
    Type localType = new a() {}.getType();
    return (List)locale.a().a(paramString, localType);
  }
  
  public static String getJsonStringFromICacheRecordList(List<ICacheRecord> paramList)
  {
    Type localType = new a() {}.getType();
    return new Gson().a(paramList, localType);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.adal.internal.util.JsonExtensions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */