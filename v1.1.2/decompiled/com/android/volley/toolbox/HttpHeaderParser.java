package com.android.volley.toolbox;

import com.android.volley.Cache.Entry;
import com.android.volley.Header;
import com.android.volley.NetworkResponse;
import com.android.volley.VolleyLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;

public class HttpHeaderParser
{
  public static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
  public static final String HEADER_CONTENT_TYPE = "Content-Type";
  public static final String RFC1123_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz";
  
  public static String formatEpochAsRfc1123(long paramLong)
  {
    return newRfc1123Formatter().format(new Date(paramLong));
  }
  
  public static SimpleDateFormat newRfc1123Formatter()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    return localSimpleDateFormat;
  }
  
  public static Cache.Entry parseCacheHeaders(NetworkResponse paramNetworkResponse)
  {
    long l1 = System.currentTimeMillis();
    Map localMap = headers;
    Object localObject = (String)localMap.get("Date");
    long l2;
    if (localObject != null) {
      l2 = parseDateAsEpoch((String)localObject);
    } else {
      l2 = 0L;
    }
    localObject = (String)localMap.get("Cache-Control");
    int i = 0;
    int j = 0;
    if (localObject != null)
    {
      localObject = ((String)localObject).split(",", 0);
      i = 0;
      l3 = 0L;
      l4 = 0L;
      for (;;)
      {
        label83:
        if (j < localObject.length)
        {
          str = localObject[j].trim();
          if ((!str.equals("no-cache")) && (!str.equals("no-store")) && (!str.startsWith("max-age="))) {
            break;
          }
        }
      }
    }
    try
    {
      l5 = Long.parseLong(str.substring(8));
      l6 = l4;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l5 = l3;
        long l6 = l4;
      }
    }
    if (str.startsWith("stale-while-revalidate="))
    {
      l6 = Long.parseLong(str.substring(23));
      l5 = l3;
    }
    else if (!str.equals("must-revalidate"))
    {
      l5 = l3;
      l6 = l4;
      if (!str.equals("proxy-revalidate")) {}
    }
    else
    {
      i = 1;
      l6 = l4;
      l5 = l3;
    }
    j++;
    l3 = l5;
    l4 = l6;
    break label83;
    return null;
    j = 1;
    break label252;
    j = 0;
    l3 = 0L;
    l4 = 0L;
    label252:
    localObject = (String)localMap.get("Expires");
    if (localObject != null) {
      l6 = parseDateAsEpoch((String)localObject);
    } else {
      l6 = 0L;
    }
    localObject = (String)localMap.get("Last-Modified");
    if (localObject != null) {
      l5 = parseDateAsEpoch((String)localObject);
    } else {
      l5 = 0L;
    }
    String str = (String)localMap.get("ETag");
    if (j != 0)
    {
      l3 = l1 + l3 * 1000L;
      if (i != 0)
      {
        l4 = l3;
      }
      else
      {
        Long.signum(l4);
        l4 = l4 * 1000L + l3;
      }
      l6 = l4;
      l4 = l3;
      l3 = l6;
    }
    else
    {
      l3 = 0L;
      if ((l2 > 0L) && (l6 >= l2))
      {
        l4 = l1 + (l6 - l2);
        l3 = l4;
      }
      else
      {
        l4 = 0L;
      }
    }
    localObject = new Cache.Entry();
    data = data;
    etag = str;
    softTtl = l4;
    ttl = l3;
    serverDate = l2;
    lastModified = l5;
    responseHeaders = localMap;
    allResponseHeaders = allHeaders;
    return (Cache.Entry)localObject;
  }
  
  public static String parseCharset(Map<String, String> paramMap)
  {
    return parseCharset(paramMap, "ISO-8859-1");
  }
  
  public static String parseCharset(Map<String, String> paramMap, String paramString)
  {
    paramMap = (String)paramMap.get("Content-Type");
    if (paramMap != null)
    {
      String[] arrayOfString = paramMap.split(";", 0);
      for (int i = 1; i < arrayOfString.length; i++)
      {
        paramMap = arrayOfString[i].trim().split("=", 0);
        if ((paramMap.length == 2) && (paramMap[0].equals("charset"))) {
          return paramMap[1];
        }
      }
    }
    return paramString;
  }
  
  public static long parseDateAsEpoch(String paramString)
  {
    try
    {
      long l = newRfc1123Formatter().parse(paramString).getTime();
      return l;
    }
    catch (ParseException localParseException)
    {
      VolleyLog.e(localParseException, "Unable to parse dateStr: %s, falling back to 0", new Object[] { paramString });
    }
    return 0L;
  }
  
  public static List<Header> toAllHeaderList(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = (Map.Entry)localIterator.next();
      localArrayList.add(new Header((String)paramMap.getKey(), (String)paramMap.getValue()));
    }
    return localArrayList;
  }
  
  public static Map<String, String> toHeaderMap(List<Header> paramList)
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (Header)localIterator.next();
      localTreeMap.put(paramList.getName(), paramList.getValue());
    }
    return localTreeMap;
  }
}

/* Location:
 * Qualified Name:     com.android.volley.toolbox.HttpHeaderParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */