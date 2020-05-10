package com.microsoft.identity.common.adal.internal.util;

import android.text.TextUtils;
import com.microsoft.identity.common.adal.internal.net.HttpWebResponse;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.net.HttpResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import org.json.JSONArray;
import org.json.JSONObject;

public final class HashMapExtensions
{
  public static final String TAG = "HashMapExtensions";
  
  public static HashMap<String, String> getJsonResponse(HttpWebResponse paramHttpWebResponse)
  {
    HashMap localHashMap = new HashMap();
    if ((paramHttpWebResponse != null) && (!TextUtils.isEmpty(paramHttpWebResponse.getBody())))
    {
      paramHttpWebResponse = new JSONObject(paramHttpWebResponse.getBody());
      Iterator localIterator = paramHttpWebResponse.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramHttpWebResponse.getString(str));
      }
    }
    return localHashMap;
  }
  
  public static HashMap<String, String> getJsonResponse(HttpResponse paramHttpResponse)
  {
    HashMap localHashMap = new HashMap();
    if ((paramHttpResponse != null) && (!TextUtils.isEmpty(paramHttpResponse.getBody())))
    {
      paramHttpResponse = new JSONObject(paramHttpResponse.getBody());
      Iterator localIterator = paramHttpResponse.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramHttpResponse.getString(str));
      }
    }
    return localHashMap;
  }
  
  public static HashMap<String, String> jsonStringAsMap(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (!StringExtensions.isNullOrBlank(paramString))
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, paramString.getString(str));
      }
    }
    return localHashMap;
  }
  
  public static HashMap<String, List<String>> jsonStringAsMapList(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (!StringExtensions.isNullOrBlank(paramString))
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      Iterator localIterator = localJSONObject.keys();
      while (localIterator.hasNext())
      {
        paramString = (String)localIterator.next();
        ArrayList localArrayList = new ArrayList();
        JSONArray localJSONArray = new JSONArray(localJSONObject.getString(paramString));
        for (int i = 0; i < localJSONArray.length(); i++) {
          localArrayList.add(localJSONArray.get(i).toString());
        }
        localHashMap.put(paramString, localArrayList);
      }
    }
    return localHashMap;
  }
  
  public static HashMap<String, String> urlFormDecode(String paramString)
  {
    return urlFormDecodeData(paramString, "&");
  }
  
  public static HashMap<String, String> urlFormDecodeData(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    if (!StringExtensions.isNullOrBlank(paramString1))
    {
      StringTokenizer localStringTokenizer = new StringTokenizer(paramString1, paramString2);
      while (localStringTokenizer.hasMoreTokens())
      {
        paramString2 = localStringTokenizer.nextToken().split("=");
        int i = paramString2.length;
        paramString1 = null;
        if (i == 2) {
          try
          {
            paramString1 = StringExtensions.urlFormDecode(paramString2[0].trim());
            paramString2 = StringExtensions.urlFormDecode(paramString2[1].trim());
          }
          catch (UnsupportedEncodingException paramString2)
          {
            paramString1 = new StringBuilder();
            paramString1.append(TAG);
            paramString1.append(":urlFormDecodeData");
            Logger.errorPII(paramString1.toString(), "Encoding format is not supported", paramString2);
          }
        } else if (paramString2.length == 1) {
          try
          {
            paramString1 = StringExtensions.urlFormDecode(paramString2[0].trim());
            paramString2 = "";
          }
          catch (UnsupportedEncodingException paramString2)
          {
            paramString1 = new StringBuilder();
            paramString1.append(TAG);
            paramString1.append(":urlFormDecodeData");
            Logger.errorPII(paramString1.toString(), "Encoding format is not supported", paramString2);
          }
        } else {
          paramString2 = null;
        }
        if (!StringExtensions.isNullOrBlank(paramString1)) {
          localHashMap.put(paramString1, paramString2);
        }
      }
    }
    return localHashMap;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.adal.internal.util.HashMapExtensions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */