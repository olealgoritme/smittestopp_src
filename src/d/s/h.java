package d.s;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class h
{
  public static final Pattern f = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
  public final ArrayList<String> a = new ArrayList();
  public final Pattern b;
  public final boolean c;
  public final boolean d;
  public final Map<String, h.a> e = new HashMap();
  
  public h(String paramString)
  {
    Uri localUri = Uri.parse(paramString);
    boolean bool;
    if (localUri.getQuery() != null) {
      bool = true;
    } else {
      bool = false;
    }
    d = bool;
    StringBuilder localStringBuilder = new StringBuilder("^");
    if (!f.matcher(paramString).find()) {
      localStringBuilder.append("http[s]?://");
    }
    Pattern localPattern = Pattern.compile("\\{(.+?)\\}");
    if (d)
    {
      Object localObject = Pattern.compile("(\\?)").matcher(paramString);
      if (((Matcher)localObject).find()) {
        a(paramString.substring(0, ((Matcher)localObject).start()), localStringBuilder, localPattern);
      }
      c = false;
      Iterator localIterator = localUri.getQueryParameterNames().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        paramString = new StringBuilder();
        String str2 = localUri.getQueryParameter(str1);
        Matcher localMatcher = localPattern.matcher(str2);
        localObject = new h.a();
        for (int i = 0; localMatcher.find(); i = localMatcher.end())
        {
          String str3 = localMatcher.group(1);
          b.add(str3);
          paramString.append(Pattern.quote(str2.substring(i, localMatcher.start())));
          paramString.append("(.+?)?");
        }
        if (i < str2.length()) {
          paramString.append(Pattern.quote(str2.substring(i)));
        }
        a = paramString.toString().replace(".*", "\\E.*\\Q");
        e.put(str1, localObject);
      }
    }
    c = a(paramString, localStringBuilder, localPattern);
    b = Pattern.compile(localStringBuilder.toString().replace(".*", "\\E.*\\Q"));
  }
  
  public final boolean a(Bundle paramBundle, String paramString1, String paramString2, d paramd)
  {
    if (paramd != null)
    {
      paramd = a;
      try
      {
        paramd.a(paramBundle, paramString1, paramd.a(paramString2));
      }
      catch (IllegalArgumentException paramBundle)
      {
        return true;
      }
    }
    else
    {
      paramBundle.putString(paramString1, paramString2);
    }
    return false;
  }
  
  public final boolean a(String paramString, StringBuilder paramStringBuilder, Pattern paramPattern)
  {
    Matcher localMatcher = paramPattern.matcher(paramString);
    boolean bool = paramString.contains(".*") ^ true;
    int i = 0;
    while (localMatcher.find())
    {
      paramPattern = localMatcher.group(1);
      a.add(paramPattern);
      paramStringBuilder.append(Pattern.quote(paramString.substring(i, localMatcher.start())));
      paramStringBuilder.append("(.+?)");
      i = localMatcher.end();
      bool = false;
    }
    if (i < paramString.length()) {
      paramStringBuilder.append(Pattern.quote(paramString.substring(i)));
    }
    paramStringBuilder.append("($|(\\?(.)*))");
    return bool;
  }
}

/* Location:
 * Qualified Name:     base.d.s.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */