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
  public final Map<String, a> e = new HashMap();
  
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
    StringBuilder localStringBuilder1 = new StringBuilder("^");
    if (!f.matcher(paramString).find()) {
      localStringBuilder1.append("http[s]?://");
    }
    Pattern localPattern = Pattern.compile("\\{(.+?)\\}");
    if (d)
    {
      Object localObject = Pattern.compile("(\\?)").matcher(paramString);
      if (((Matcher)localObject).find()) {
        a(paramString.substring(0, ((Matcher)localObject).start()), localStringBuilder1, localPattern);
      }
      c = false;
      paramString = localUri.getQueryParameterNames().iterator();
      while (paramString.hasNext())
      {
        String str1 = (String)paramString.next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        String str2 = localUri.getQueryParameter(str1);
        Matcher localMatcher = localPattern.matcher(str2);
        a locala = new a();
        for (int i = 0; localMatcher.find(); i = localMatcher.end())
        {
          localObject = localMatcher.group(1);
          b.add(localObject);
          localStringBuilder2.append(Pattern.quote(str2.substring(i, localMatcher.start())));
          localStringBuilder2.append("(.+?)?");
        }
        if (i < str2.length()) {
          localStringBuilder2.append(Pattern.quote(str2.substring(i)));
        }
        a = localStringBuilder2.toString().replace(".*", "\\E.*\\Q");
        e.put(str1, locala);
      }
    }
    c = a(paramString, localStringBuilder1, localPattern);
    b = Pattern.compile(localStringBuilder1.toString().replace(".*", "\\E.*\\Q"));
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
    paramPattern = paramPattern.matcher(paramString);
    boolean bool = paramString.contains(".*") ^ true;
    int i = 0;
    while (paramPattern.find())
    {
      String str = paramPattern.group(1);
      a.add(str);
      paramStringBuilder.append(Pattern.quote(paramString.substring(i, paramPattern.start())));
      paramStringBuilder.append("(.+?)");
      i = paramPattern.end();
      bool = false;
    }
    if (i < paramString.length()) {
      paramStringBuilder.append(Pattern.quote(paramString.substring(i)));
    }
    paramStringBuilder.append("($|(\\?(.)*))");
    return bool;
  }
  
  public static class a
  {
    public String a;
    public ArrayList<String> b = new ArrayList();
  }
}

/* Location:
 * Qualified Name:     d.s.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */