package com.microsoft.azure.storage.core;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class UriQueryBuilder
{
  public final HashMap<String, ArrayList<String>> parameters = new HashMap();
  
  private void insertKeyValue(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 != null) {
      str = Utility.safeEncode(paramString2);
    }
    paramString2 = paramString1;
    if (!paramString1.startsWith("$")) {
      paramString2 = Utility.safeEncode(paramString1);
    }
    paramString1 = (ArrayList)parameters.get(paramString2);
    if (paramString1 == null)
    {
      paramString1 = new ArrayList();
      paramString1.add(str);
      parameters.put(paramString2, paramString1);
    }
    else if (!paramString1.contains(str))
    {
      paramString1.add(str);
    }
  }
  
  public void add(String paramString1, String paramString2)
  {
    if (!Utility.isNullOrEmpty(paramString1))
    {
      insertKeyValue(paramString1, paramString2);
      return;
    }
    throw new IllegalArgumentException("Cannot encode a query parameter with a null or empty key.");
  }
  
  public URI addToURI(URI paramURI)
  {
    String str1 = paramURI.getRawQuery();
    String str2 = paramURI.getRawFragment();
    String str3 = paramURI.resolve(paramURI).toASCIIString();
    Object localObject = PathUtility.parseQueryString(str1).entrySet().iterator();
    for (;;)
    {
      boolean bool = ((Iterator)localObject).hasNext();
      int i = 0;
      if (!bool) {
        break;
      }
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      String[] arrayOfString = (String[])localEntry.getValue();
      int j = arrayOfString.length;
      while (i < j)
      {
        String str4 = arrayOfString[i];
        insertKeyValue((String)localEntry.getKey(), str4);
        i++;
      }
    }
    localObject = new StringBuilder();
    if ((Utility.isNullOrEmpty(str1)) && (!Utility.isNullOrEmpty(str2)))
    {
      ((StringBuilder)localObject).append(str3.substring(0, str3.indexOf('#')));
    }
    else if (!Utility.isNullOrEmpty(str1))
    {
      ((StringBuilder)localObject).append(str3.substring(0, str3.indexOf('?')));
    }
    else
    {
      ((StringBuilder)localObject).append(str3);
      if (paramURI.getRawPath().length() <= 0) {
        ((StringBuilder)localObject).append("/");
      }
    }
    paramURI = toString();
    if (paramURI.length() > 0)
    {
      ((StringBuilder)localObject).append("?");
      ((StringBuilder)localObject).append(paramURI);
    }
    if (!Utility.isNullOrEmpty(str2))
    {
      ((StringBuilder)localObject).append("#");
      ((StringBuilder)localObject).append(str2);
    }
    return new URI(((StringBuilder)localObject).toString());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = Boolean.valueOf(true);
    Iterator localIterator1 = parameters.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      if (parameters.get(str) != null)
      {
        Iterator localIterator2 = ((ArrayList)parameters.get(str)).iterator();
        Object localObject2 = localObject1;
        for (;;)
        {
          localObject1 = localObject2;
          if (!localIterator2.hasNext()) {
            break;
          }
          localObject1 = (String)localIterator2.next();
          if (((Boolean)localObject2).booleanValue()) {
            localObject2 = Boolean.valueOf(false);
          } else {
            localStringBuilder.append("&");
          }
          localStringBuilder.append(String.format("%s=%s", new Object[] { str, localObject1 }));
        }
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.core.UriQueryBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */