package com.microsoft.azure.sdk.iot.deps.util;

import g.a.a;
import g.a.b;
import g.a.c;
import g.a.e;
import java.util.Map;

public class Tools
{
  public static void appendJsonAttribute(StringBuilder paramStringBuilder, String paramString1, String paramString2, Boolean paramBoolean1, Boolean paramBoolean2)
  {
    if (paramStringBuilder != null)
    {
      paramStringBuilder.append("\"");
      if (isNullOrEmpty(paramString1).booleanValue()) {
        paramStringBuilder.append("");
      } else {
        paramStringBuilder.append(paramString1);
      }
      paramStringBuilder.append("\"");
      paramStringBuilder.append(":");
      if (isNullOrEmpty(paramString2).booleanValue())
      {
        paramStringBuilder.append("null");
      }
      else
      {
        if (paramBoolean1.booleanValue()) {
          paramStringBuilder.append("\"");
        }
        paramStringBuilder.append(paramString2);
        if (paramBoolean1.booleanValue()) {
          paramStringBuilder.append("\"");
        }
      }
      if (!paramBoolean2.booleanValue()) {
        paramStringBuilder.append(",");
      }
    }
  }
  
  public static boolean areEqual(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 != null) && (paramObject2 != null)) {
      return paramObject1.equals(paramObject2);
    }
    return false;
  }
  
  public static long getNumberValueFromJsonObject(b paramb, String paramString)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramb != null)
    {
      l2 = l1;
      if (paramb != e.b)
      {
        l2 = l1;
        if (paramString != null) {
          if (paramString.length() == 0)
          {
            l2 = l1;
          }
          else
          {
            l2 = l1;
            if ((e)paramb.get(paramString) != e.b)
            {
              paramb = paramb.b(paramString);
              l2 = l1;
              if (paramb != null) {
                l2 = paramb.longValue();
              }
            }
          }
        }
      }
    }
    return l2;
  }
  
  public static String getValueFromJsonObject(b paramb, String paramString)
  {
    String str1 = "";
    String str2 = str1;
    if (paramb != null)
    {
      str2 = str1;
      if (paramb != e.b)
      {
        str2 = str1;
        if (paramString != null) {
          if (paramString.length() == 0)
          {
            str2 = str1;
          }
          else
          {
            str2 = str1;
            if ((e)paramb.get(paramString) != e.b) {
              str2 = getValueFromJsonString(paramb.a(paramString));
            }
          }
        }
      }
    }
    return str2;
  }
  
  public static String getValueFromJsonString(c paramc)
  {
    Object localObject = "";
    if (paramc == null)
    {
      paramc = (c)localObject;
    }
    else
    {
      localObject = paramc.toString();
      paramc = (c)localObject;
      if (((String)localObject).startsWith("\"")) {
        paramc = ((String)localObject).replaceFirst("\"", "");
      }
      localObject = paramc;
      paramc = (c)localObject;
      if (((String)localObject).endsWith("\"")) {
        paramc = ((String)localObject).substring(0, ((String)localObject).length() - 1);
      }
    }
    return paramc;
  }
  
  public static String getValueStringByKey(Map paramMap, String paramString)
  {
    String str1 = "";
    String str2 = str1;
    if (paramMap != null) {
      if (paramString == null)
      {
        str2 = str1;
      }
      else
      {
        paramMap = paramMap.get(paramString);
        str2 = str1;
        if (paramMap != null) {
          str2 = paramMap.toString().trim();
        }
      }
    }
    return str2;
  }
  
  public static Boolean isNullOrEmpty(String paramString)
  {
    boolean bool = true;
    if (paramString == null)
    {
      paramString = Boolean.valueOf(true);
    }
    else
    {
      if (paramString.length() != 0) {
        bool = false;
      }
      paramString = Boolean.valueOf(bool);
    }
    return paramString;
  }
  
  public static Boolean isNullOrWhiteSpace(String paramString)
  {
    if (paramString == null) {
      paramString = Boolean.valueOf(true);
    } else {
      paramString = isNullOrEmpty(paramString.trim());
    }
    return paramString;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.util.Tools
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */