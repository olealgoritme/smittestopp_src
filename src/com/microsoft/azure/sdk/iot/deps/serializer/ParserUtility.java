package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import e.a.a.a.a;
import e.c.c.e;
import e.c.c.g;
import e.c.c.j;
import e.c.c.l;
import e.c.c.m;
import e.c.c.p;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;

public class ParserUtility
{
  public static final String DATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss";
  public static final int DATE_AND_TIME_IN_DATE = 0;
  public static final int EXPECTED_PARTS_IN_DATE = 2;
  public static final String FROM = "from";
  public static final int MAX_MILLISECONDS_LENGTH_IN_DATE = 3;
  public static final int MILLISECONDS_IN_DATE = 1;
  public static final double MILLISECONDS_NUMERIC_BASE = 10.0D;
  public static final String MILLISECONDS_REGEX = "[.,Z]";
  public static final int NO_MILLISECONDS_IN_DATE = 0;
  public static final String OFFSETFORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX";
  public static final String SELECT = "select";
  public static final String TIMEZONE = "UTC";
  
  public static String dateTimeUtcToString(Date paramDate)
  {
    if (paramDate != null)
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
      localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localSimpleDateFormat.format(paramDate));
      localStringBuilder.append(".");
      int i = (int)(paramDate.getTime() % 1000L);
      int j = i;
      if (i < 0) {
        j = i + 1000;
      }
      return a.a(localStringBuilder, j, "Z");
    }
    throw new IllegalArgumentException("date cannot be null");
  }
  
  public static String getDateStringFromDate(Date paramDate)
  {
    if (paramDate != null) {
      return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(paramDate);
    }
    throw new IllegalArgumentException("The provided date cannot be null");
  }
  
  public static Date getDateTimeUtc(String paramString)
  {
    Object localObject1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    ((SimpleDateFormat)localObject1).setTimeZone(TimeZone.getTimeZone("UTC"));
    if ((paramString != null) && (!paramString.isEmpty())) {
      try
      {
        Object localObject2 = paramString.split("[.,Z]");
        if (localObject2.length <= 2)
        {
          int j;
          if ((localObject2.length == 2) && (!localObject2[1].isEmpty()))
          {
            int i = localObject2[1].length();
            j = i;
            if (i > 3) {
              j = 3;
            }
            j = Integer.parseInt(localObject2[1].substring(0, j)) * (int)Math.pow(10.0D, 3 - j);
          }
          else
          {
            j = 0;
          }
          return new Date(((SimpleDateFormat)localObject1).parse(localObject2[0]).getTime() + j);
        }
        localObject2 = new java/lang/IllegalArgumentException;
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        ((StringBuilder)localObject1).append("invalid time:");
        ((StringBuilder)localObject1).append(paramString);
        ((IllegalArgumentException)localObject2).<init>(((StringBuilder)localObject1).toString());
        throw ((Throwable)localObject2);
      }
      catch (ParseException localParseException)
      {
        throw new IllegalArgumentException(a.b("invalid time:", paramString));
      }
    }
    throw new IllegalArgumentException("date is null, empty, or invalid");
  }
  
  public static List<Object> getJsonArrayValue(g paramg)
  {
    ArrayList localArrayList = new ArrayList();
    paramg = paramg.b().iterator();
    while (paramg.hasNext()) {
      localArrayList.add(resolveJsonElement((j)paramg.next()));
    }
    return localArrayList;
  }
  
  public static Map<String, Object> getJsonObjectValue(m paramm)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramm.g().iterator();
    while (localIterator.hasNext())
    {
      paramm = (Map.Entry)localIterator.next();
      localHashMap.put(paramm.getKey(), resolveJsonElement((j)paramm.getValue()));
    }
    return localHashMap;
  }
  
  public static Object getJsonPrimitiveValue(p paramp)
  {
    Object localObject = a;
    if ((localObject instanceof Number)) {
      return paramp.h();
    }
    if ((localObject instanceof Boolean)) {
      return Boolean.valueOf(paramp.g());
    }
    return paramp.f();
  }
  
  public static boolean mapOnlyContainsMetaData(Map<String, Object> paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = (String)localIterator.next();
      if ((!paramMap.equals("$lastUpdated")) && (!paramMap.equals("$lastUpdatedVersion"))) {
        return false;
      }
    }
    return true;
  }
  
  public static j mapToJsonElement(Map<String, Object> paramMap)
  {
    Object localObject = new e();
    g = true;
    localObject = ((e)localObject).a();
    m localm = new m();
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if (localEntry.getValue() == null) {
          localm.a((String)localEntry.getKey(), null);
        } else if ((localEntry.getValue() instanceof Map)) {
          localm.a((String)localEntry.getKey(), mapToJsonElement((Map)localEntry.getValue()));
        } else {
          localm.a((String)localEntry.getKey(), ((Gson)localObject).b(localEntry.getValue()));
        }
      }
      return localm;
    }
    throw new IllegalArgumentException("null map to parse");
  }
  
  public static Object resolveJsonElement(j paramj)
  {
    if ((paramj != null) && (!(paramj instanceof l)))
    {
      if ((paramj instanceof p)) {
        return getJsonPrimitiveValue(paramj.d());
      }
      if ((paramj instanceof m)) {
        return getJsonObjectValue(paramj.c());
      }
      if ((paramj instanceof g)) {
        return getJsonArrayValue(paramj.b());
      }
      StringBuilder localStringBuilder = a.a("Invalid DeviceMethodResponse payload: unknown payload type: ");
      localStringBuilder.append(paramj.getClass());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return null;
  }
  
  public static Date stringToDateTimeOffset(String paramString)
  {
    Object localObject = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
    ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("UTC"));
    if ((paramString != null) && (!paramString.isEmpty())) {
      try
      {
        paramString = ((SimpleDateFormat)localObject).parse(paramString);
        return paramString;
      }
      catch (ParseException paramString)
      {
        localObject = a.a("invalid time:");
        ((StringBuilder)localObject).append(paramString.toString());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    throw new IllegalArgumentException("date is null or empty");
  }
  
  public static void validateBlobName(String paramString)
  {
    try
    {
      validateStringUTF8(paramString);
      if (paramString.length() <= 1024)
      {
        if (paramString.split("/").length <= 254) {
          return;
        }
        throw new IllegalArgumentException("The provided blob name exceed 254 path segments");
      }
      throw new IllegalArgumentException("The provided blob name exceed maximum size of 1024 characters");
    }
    catch (IllegalArgumentException paramString)
    {
      throw new IllegalArgumentException("The provided blob name is not valid");
    }
  }
  
  public static void validateHostName(String paramString)
  {
    validateId(paramString);
    if (paramString.split(Pattern.quote(".")).length >= 2) {
      return;
    }
    throw new IllegalArgumentException("hostName is incomplete");
  }
  
  public static void validateId(String paramString)
  {
    try
    {
      validateStringUTF8(paramString);
      if (paramString.length() <= 128)
      {
        for (int k : paramString.getBytes()) {
          if (((k < 65) || (k > 90)) && ((k < 97) || (k > 122)) && ((k < 48) || (k > 57)) && (k != 45) && (k != 58) && (k != 46) && (k != 43) && (k != 37) && (k != 95) && (k != 35) && (k != 42) && (k != 63) && (k != 33) && (k != 40) && (k != 41) && (k != 44) && (k != 61) && (k != 64) && (k != 59) && (k != 36) && (k != 39)) {
            throw new IllegalArgumentException("The provided ID is not valid");
          }
        }
        return;
      }
      throw new IllegalArgumentException("The provided ID is bigger than 128 characters");
    }
    catch (IllegalArgumentException paramString)
    {
      throw new IllegalArgumentException("The provided ID is not valid");
    }
  }
  
  public static void validateMap(Map<String, Object> paramMap)
  {
    if (paramMap != null) {
      validateMapInternal(paramMap);
    }
  }
  
  public static void validateMapInternal(Map<String, Object> paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramMap = ((Map.Entry)localIterator.next()).getValue();
      if ((paramMap != null) && ((paramMap.getClass().isArray()) || (paramMap.getClass().isLocalClass()))) {
        throw new IllegalArgumentException(a.a(paramMap, a.a("Map contains illegal value type ")));
      }
      if ((paramMap != null) && ((paramMap instanceof Map))) {
        validateMapInternal((Map)paramMap);
      }
    }
  }
  
  public static void validateObject(Object paramObject)
  {
    if (paramObject != null) {
      return;
    }
    throw new IllegalArgumentException("parameter is null");
  }
  
  public static void validateQuery(String paramString)
  {
    try
    {
      validateStringUTF8(paramString);
      if ((paramString.toLowerCase().contains("select")) && (paramString.toLowerCase().contains("from"))) {
        return;
      }
      throw new IllegalArgumentException("Query must contain select and from");
    }
    catch (IllegalArgumentException paramString)
    {
      throw new IllegalArgumentException("The provided query is not valid");
    }
  }
  
  public static void validateStringUTF8(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty())) {
      try
      {
        if (paramString.getBytes("UTF-8").length == paramString.length()) {
          return;
        }
        paramString = new java/lang/IllegalArgumentException;
        paramString.<init>("parameter contains non UTF-8 character");
        throw paramString;
      }
      catch (UnsupportedEncodingException paramString)
      {
        throw new IllegalArgumentException("parameter contains non UTF-8 character");
      }
    }
    throw new IllegalArgumentException("parameter is null or empty");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.serializer.ParserUtility
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */