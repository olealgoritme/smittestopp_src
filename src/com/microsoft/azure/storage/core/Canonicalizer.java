package com.microsoft.azure.storage.core;

import e.a.a.a.a;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Canonicalizer
{
  public static final Pattern CRLF = Pattern.compile("\r\n", 16);
  public static final int ExpectedBlobQueueCanonicalizedStringLength = 300;
  public static final int ExpectedTableCanonicalizedStringLength = 200;
  
  public static void addCanonicalizedHeaders(HttpURLConnection paramHttpURLConnection, StringBuilder paramStringBuilder)
  {
    Map localMap = paramHttpURLConnection.getRequestProperties();
    Object localObject1 = new ArrayList();
    paramHttpURLConnection = localMap.keySet().iterator();
    while (paramHttpURLConnection.hasNext())
    {
      localObject2 = (String)paramHttpURLConnection.next();
      if (((String)localObject2).toLowerCase(Utility.LOCALE_US).startsWith("x-ms-")) {
        ((ArrayList)localObject1).add(((String)localObject2).toLowerCase(Utility.LOCALE_US));
      }
    }
    Collections.sort((List)localObject1);
    Object localObject2 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramHttpURLConnection = (String)((Iterator)localObject2).next();
      localObject1 = new StringBuilder(paramHttpURLConnection);
      paramHttpURLConnection = getHeaderValues(localMap, paramHttpURLConnection);
      int i = 0;
      Iterator localIterator = paramHttpURLConnection.iterator();
      for (paramHttpURLConnection = ":"; localIterator.hasNext(); paramHttpURLConnection = ",")
      {
        String str = (String)localIterator.next();
        if (str != null) {
          i = 1;
        }
        str = CRLF.matcher(str).replaceAll(Matcher.quoteReplacement(""));
        ((StringBuilder)localObject1).append(paramHttpURLConnection);
        ((StringBuilder)localObject1).append(str);
      }
      if (i != 0) {
        appendCanonicalizedElement(paramStringBuilder, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public static void appendCanonicalizedElement(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append("\n");
    paramStringBuilder.append(paramString);
  }
  
  public static String canonicalizeHttpRequest(URL paramURL, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, HttpURLConnection paramHttpURLConnection)
  {
    StringBuilder localStringBuilder = new StringBuilder(300);
    localStringBuilder.append(paramHttpURLConnection.getRequestMethod());
    appendCanonicalizedElement(localStringBuilder, Utility.getStandardHeaderValue(paramHttpURLConnection, "Content-Encoding"));
    appendCanonicalizedElement(localStringBuilder, Utility.getStandardHeaderValue(paramHttpURLConnection, "Content-Language"));
    if (paramLong <= 0L) {
      paramString2 = "";
    } else {
      paramString2 = String.valueOf(paramLong);
    }
    appendCanonicalizedElement(localStringBuilder, paramString2);
    appendCanonicalizedElement(localStringBuilder, Utility.getStandardHeaderValue(paramHttpURLConnection, "Content-MD5"));
    if (paramString3 == null) {
      paramString3 = "";
    }
    appendCanonicalizedElement(localStringBuilder, paramString3);
    if (!Utility.getStandardHeaderValue(paramHttpURLConnection, "x-ms-date").equals("")) {
      paramString4 = "";
    }
    appendCanonicalizedElement(localStringBuilder, paramString4);
    appendCanonicalizedElement(localStringBuilder, Utility.getStandardHeaderValue(paramHttpURLConnection, "If-Modified-Since"));
    appendCanonicalizedElement(localStringBuilder, Utility.getStandardHeaderValue(paramHttpURLConnection, "If-Match"));
    appendCanonicalizedElement(localStringBuilder, Utility.getStandardHeaderValue(paramHttpURLConnection, "If-None-Match"));
    appendCanonicalizedElement(localStringBuilder, Utility.getStandardHeaderValue(paramHttpURLConnection, "If-Unmodified-Since"));
    appendCanonicalizedElement(localStringBuilder, Utility.getStandardHeaderValue(paramHttpURLConnection, "Range"));
    addCanonicalizedHeaders(paramHttpURLConnection, localStringBuilder);
    appendCanonicalizedElement(localStringBuilder, getCanonicalizedResource(paramURL, paramString1));
    return localStringBuilder.toString();
  }
  
  public static String canonicalizeTableHttpRequest(URL paramURL, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, HttpURLConnection paramHttpURLConnection)
  {
    StringBuilder localStringBuilder = new StringBuilder(200);
    localStringBuilder.append(paramHttpURLConnection.getRequestMethod());
    appendCanonicalizedElement(localStringBuilder, Utility.getStandardHeaderValue(paramHttpURLConnection, "Content-MD5"));
    appendCanonicalizedElement(localStringBuilder, paramString3);
    paramString2 = Utility.getStandardHeaderValue(paramHttpURLConnection, "x-ms-date");
    if (paramString2.equals("")) {
      paramString2 = paramString4;
    }
    appendCanonicalizedElement(localStringBuilder, paramString2);
    appendCanonicalizedElement(localStringBuilder, getCanonicalizedResourceLite(paramURL, paramString1));
    return localStringBuilder.toString();
  }
  
  public static String getCanonicalizedResource(URL paramURL, String paramString)
  {
    Object localObject1 = new StringBuilder("/");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(paramURL.getPath());
    paramString = new StringBuilder(((StringBuilder)localObject1).toString());
    if ((paramURL.getQuery() != null) && (paramURL.getQuery().contains("=")))
    {
      paramURL = PathUtility.parseQueryString(paramURL.getQuery());
      localObject1 = new HashMap();
      Object localObject2 = paramURL.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramURL = (Map.Entry)((Iterator)localObject2).next();
        Object localObject3 = Arrays.asList((Object[])paramURL.getValue());
        Collections.sort((List)localObject3);
        localObject4 = new StringBuilder();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          if (((StringBuilder)localObject4).length() > 0) {
            ((StringBuilder)localObject4).append(",");
          }
          ((StringBuilder)localObject4).append(str);
        }
        if (paramURL.getKey() == null) {
          paramURL = null;
        } else {
          paramURL = ((String)paramURL.getKey()).toLowerCase(Utility.LOCALE_US);
        }
        ((HashMap)localObject1).put(paramURL, ((StringBuilder)localObject4).toString());
      }
      paramURL = new ArrayList(((HashMap)localObject1).keySet());
      Collections.sort(paramURL);
      Object localObject4 = paramURL.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject2 = (String)((Iterator)localObject4).next();
        paramURL = a.a((String)localObject2, ":");
        paramURL.append((String)((HashMap)localObject1).get(localObject2));
        appendCanonicalizedElement(paramString, paramURL.toString());
      }
      return paramString.toString();
    }
    return paramString.toString();
  }
  
  public static String getCanonicalizedResourceLite(URL paramURL, String paramString)
  {
    Object localObject = new StringBuilder("/");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(paramURL.getPath());
    paramString = new StringBuilder(((StringBuilder)localObject).toString());
    paramURL = (String[])PathUtility.parseQueryString(paramURL.getQuery()).get("comp");
    if (paramURL != null)
    {
      localObject = Arrays.asList(paramURL);
      Collections.sort((List)localObject);
      paramString.append("?comp=");
      paramURL = new StringBuilder();
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        if (paramURL.length() > 0) {
          paramURL.append(",");
        }
        paramURL.append((String)localObject);
      }
      paramString.append(paramURL);
    }
    return paramString.toString();
  }
  
  public static ArrayList<String> getHeaderValues(Map<String, List<String>> paramMap, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (((String)localEntry.getKey()).toLowerCase(Utility.LOCALE_US).equals(paramString))
      {
        paramMap = (List)localEntry.getValue();
        break label76;
      }
    }
    paramMap = null;
    label76:
    if (paramMap != null)
    {
      paramMap = paramMap.iterator();
      while (paramMap.hasNext()) {
        localArrayList.add(Utility.trimStart((String)paramMap.next()));
      }
    }
    return localArrayList;
  }
  
  public abstract String canonicalize(HttpURLConnection paramHttpURLConnection, String paramString, Long paramLong);
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.core.Canonicalizer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */