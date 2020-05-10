package com.microsoft.identity.common.adal.internal.util;

import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Base64;
import android.util.Log;
import com.microsoft.identity.common.internal.logging.Logger;
import e.a.a.a.a;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public final class StringExtensions
{
  public static final String ENCODING_UTF8 = "UTF-8";
  public static final String TAG = "StringExtensions";
  public static final String TOKEN_HASH_ALGORITHM = "SHA256";
  
  public static String appendQueryParameterToUrl(String paramString, Map<String, String> paramMap)
  {
    if (!isNullOrBlank(paramString))
    {
      if (paramMap.isEmpty()) {
        return paramString;
      }
      paramString = Uri.parse(paramString).buildUpon();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        paramString.appendQueryParameter((String)paramMap.getKey(), (String)paramMap.getValue());
      }
      return paramString.build().toString();
    }
    throw new IllegalArgumentException("Empty authority endpoint parameter.");
  }
  
  public static String base64UrlEncodeToString(String paramString)
  {
    return Base64.encodeToString(paramString.getBytes(Charset.forName("UTF-8")), 10);
  }
  
  public static String createHash(String paramString)
  {
    if (!isNullOrBlank(paramString)) {
      return new String(Base64.encode(MessageDigest.getInstance("SHA256").digest(paramString.getBytes("UTF-8")), 2), "UTF-8");
    }
    return paramString;
  }
  
  public static String encodeBase64URLSafeString(byte[] paramArrayOfByte)
  {
    return new String(Base64.encode(paramArrayOfByte, 11), "UTF-8");
  }
  
  public static List<String> getStringTokens(String paramString1, String paramString2)
  {
    paramString1 = new StringTokenizer(paramString1, paramString2);
    paramString2 = new ArrayList();
    while (paramString1.hasMoreTokens())
    {
      String str = paramString1.nextToken();
      if (!isNullOrBlank(str)) {
        paramString2.add(str);
      }
    }
    return paramString2;
  }
  
  public static URL getUrl(String paramString)
  {
    try
    {
      URL localURL = new java/net/URL;
      localURL.<init>(paramString);
      paramString = localURL;
    }
    catch (MalformedURLException paramString)
    {
      Log.e(TAG, "authority_url_not_valid");
      paramString = null;
    }
    return paramString;
  }
  
  public static HashMap<String, String> getUrlParameters(String paramString)
  {
    Uri localUri = Uri.parse(paramString);
    if (!HashMapExtensions.urlFormDecode(localUri.getFragment()).isEmpty())
    {
      Logger.warn(TAG, "Received url contains unexpected fragment parameters.");
      String str = TAG;
      paramString = a.a("Unexpected fragment: ");
      paramString.append(localUri.getFragment());
      Logger.warnPII(str, paramString.toString());
    }
    return HashMapExtensions.urlFormDecode(localUri.getEncodedQuery());
  }
  
  public static boolean hasPrefixInHeader(String paramString1, String paramString2)
  {
    boolean bool;
    if ((paramString1.startsWith(paramString2)) && (paramString1.length() > paramString2.length() + 2) && (Character.isWhitespace(paramString1.charAt(paramString2.length())))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean isNullOrBlank(String paramString)
  {
    boolean bool;
    if ((paramString != null) && (paramString.trim().length() != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static String removeQueryParameterFromUrl(String paramString)
  {
    paramString = new URI(paramString);
    return new URI(paramString.getScheme(), paramString.getAuthority(), paramString.getPath(), null, paramString.getFragment()).toString();
  }
  
  public static String removeQuoteInHeaderValue(String paramString)
  {
    if (!isNullOrBlank(paramString)) {
      return paramString.replace("\"", "");
    }
    return null;
  }
  
  public static ArrayList<String> splitWithQuotes(String paramString, char paramChar)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = 0;
    int n;
    for (int k = 0; i < paramString.length(); k = n)
    {
      int m;
      if ((paramString.charAt(i) == paramChar) && (k == 0))
      {
        String str = paramString.substring(j, i);
        if (!isNullOrBlank(str.trim())) {
          localArrayList.add(str);
        }
        m = i + 1;
        n = k;
      }
      else
      {
        m = j;
        n = k;
        if (paramString.charAt(i) == '"')
        {
          n = k ^ 0x1;
          m = j;
        }
      }
      i++;
      j = m;
    }
    paramString = paramString.substring(j);
    if (!isNullOrBlank(paramString.trim())) {
      localArrayList.add(paramString);
    }
    return localArrayList;
  }
  
  public static String urlFormDecode(String paramString)
  {
    return URLDecoder.decode(paramString, "UTF-8");
  }
  
  public static String urlFormEncode(String paramString)
  {
    return URLEncoder.encode(paramString, "UTF-8");
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.adal.internal.util.StringExtensions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */