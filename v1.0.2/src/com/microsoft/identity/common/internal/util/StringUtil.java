package com.microsoft.identity.common.internal.util;

import android.util.Pair;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public final class StringUtil
{
  public static int compareSemanticVersion(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      return 1;
    }
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int i = Math.max(paramString1.length, paramString2.length);
    for (int j = 0; j < i; j++)
    {
      int k;
      if (j < paramString1.length) {
        k = Integer.parseInt(paramString1[j]);
      } else {
        k = 0;
      }
      int m;
      if (j < paramString2.length) {
        m = Integer.parseInt(paramString2[j]);
      } else {
        m = 0;
      }
      if (k < m) {
        return -1;
      }
      if (k > m) {
        return 1;
      }
    }
    return 0;
  }
  
  public static String convertSetToString(Set<String> paramSet, String paramString)
  {
    if ((paramSet != null) && (!paramSet.isEmpty()) && (paramString != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramSet = paramSet.iterator();
      localStringBuilder.append((String)paramSet.next());
      while (paramSet.hasNext())
      {
        localStringBuilder.append(paramString);
        localStringBuilder.append((String)paramSet.next());
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static int countMatches(String paramString1, String paramString2)
  {
    boolean bool = isEmpty(paramString1);
    int i = 0;
    if ((!bool) && (!isEmpty(paramString2)))
    {
      int k;
      for (int j = 0; i <= paramString1.length() - paramString2.length(); j = k)
      {
        k = j;
        if (paramString1.substring(i, paramString2.length() + i).equalsIgnoreCase(paramString2)) {
          k = j + 1;
        }
        i++;
      }
      return j;
    }
    return 0;
  }
  
  public static Pair<String, String> getTenantInfo(String paramString)
  {
    Object localObject = paramString.split("\\.");
    int i = localObject.length;
    paramString = null;
    if ((2 == i) && (!StringExtensions.isNullOrBlank(localObject[0])) && (!StringExtensions.isNullOrBlank(localObject[1])))
    {
      paramString = localObject[0];
      localObject = localObject[1];
    }
    else
    {
      localObject = null;
    }
    return new Pair(paramString, localObject);
  }
  
  public static boolean isEmpty(String paramString)
  {
    boolean bool;
    if ((paramString != null) && (paramString.trim().length() != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isUuid(String paramString)
  {
    try
    {
      UUID.fromString(paramString);
      return true;
    }
    catch (IllegalArgumentException paramString) {}
    return false;
  }
  
  public static String join(char paramChar, List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramList.iterator();
    char c1 = '\000';
    for (char c2 = c1; localIterator.hasNext(); c2 = c1)
    {
      paramList = (String)localIterator.next();
      if (c2 != 0) {
        localStringBuilder.append(c2);
      }
      localStringBuilder.append(paramList);
      c1 = paramChar;
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.util.StringUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */