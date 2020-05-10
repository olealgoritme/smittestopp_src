package com.microsoft.identity.common.internal.net;

import com.google.gson.Gson;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.util.StringUtil;
import e.c.c.e;
import e.c.c.w.t;
import e.c.c.x.a;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public final class ObjectMapper
{
  public static final String ENCODING_SCHEME = "UTF-8";
  public static final String TAG = "ObjectMapper";
  
  public static <T> T deserializeJsonStringToObject(String paramString, Class<T> paramClass)
  {
    paramString = new Gson().a(paramString, paramClass);
    return (T)t.a(paramClass).cast(paramString);
  }
  
  public static Map<String, String> deserializeQueryStringToMap(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (StringUtil.isEmpty(paramString)) {
      return localHashMap;
    }
    paramString = new StringTokenizer(paramString, "&");
    while (paramString.hasMoreTokens())
    {
      Object localObject = paramString.nextToken().split("=");
      if (localObject.length == 2) {
        try
        {
          String str = URLDecoder.decode(localObject[0], "UTF-8");
          localObject = URLDecoder.decode(localObject[1], "UTF-8");
          if ((!StringUtil.isEmpty(str)) && (!StringUtil.isEmpty((String)localObject))) {
            localHashMap.put(str, localObject);
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          Logger.error(TAG, null, "Decode failed.", localUnsupportedEncodingException);
        }
      }
    }
    return localHashMap;
  }
  
  public static String serializeExposedFieldsOfObjectToJsonString(Object paramObject)
  {
    e locale = new e();
    locale.b();
    return locale.a().a(paramObject);
  }
  
  public static Map<String, Object> serializeObjectHashMap(Object paramObject)
  {
    paramObject = serializeObjectToJsonString(paramObject);
    return (Map)new Gson().a((String)paramObject, Map.class);
  }
  
  public static String serializeObjectToFormUrlEncoded(Object paramObject)
  {
    Object localObject = serializeObjectToJsonString(paramObject);
    paramObject = new ObjectMapper.1().getType();
    localObject = (TreeMap)new Gson().a((String)localObject, (Type)paramObject);
    paramObject = new StringBuilder();
    Iterator localIterator = ((TreeMap)localObject).entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (Map.Entry)localIterator.next();
      ((StringBuilder)paramObject).append(URLEncoder.encode((String)((Map.Entry)localObject).getKey(), "UTF-8"));
      ((StringBuilder)paramObject).append('=');
      ((StringBuilder)paramObject).append(URLEncoder.encode((String)((Map.Entry)localObject).getValue(), "UTF-8"));
      if (localIterator.hasNext()) {
        ((StringBuilder)paramObject).append('&');
      }
    }
    return ((StringBuilder)paramObject).toString();
  }
  
  public static String serializeObjectToJsonString(Object paramObject)
  {
    return new Gson().a(paramObject);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.net.ObjectMapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */