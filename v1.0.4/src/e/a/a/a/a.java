package e.a.a.a;

import android.util.Log;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.internal.logging.Logger;
import d.t.a.s;
import java.util.HashMap;
import k.b.a.o;
import k.b.i.b.g.d;
import org.xmlpull.v1.XmlPullParser;

public class a
{
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return paramInt1 + paramInt2 + paramInt3 + paramInt4;
  }
  
  public static String a(s params, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(params.h());
    return paramStringBuilder.toString();
  }
  
  public static String a(Exception paramException, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(paramException.toString());
    return paramStringBuilder.toString();
  }
  
  public static String a(Object paramObject, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(paramObject.getClass().getName());
    return paramStringBuilder.toString();
  }
  
  public static String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, Fragment paramFragment, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramFragment);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString3);
    return localStringBuilder.toString();
  }
  
  public static String a(StringBuilder paramStringBuilder, int paramInt, String paramString)
  {
    paramStringBuilder.append(paramInt);
    paramStringBuilder.append(paramString);
    return paramStringBuilder.toString();
  }
  
  public static String a(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(paramString2);
    return paramStringBuilder.toString();
  }
  
  public static String a(StringBuilder paramStringBuilder, String paramString1, String paramString2, String paramString3)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(paramString2);
    paramStringBuilder.append(paramString3);
    return paramStringBuilder.toString();
  }
  
  public static String a(XmlPullParser paramXmlPullParser, StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append(paramXmlPullParser.getPositionDescription());
    paramStringBuilder.append(paramString);
    return paramStringBuilder.toString();
  }
  
  public static StringBuilder a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    return localStringBuilder;
  }
  
  public static StringBuilder a(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramInt);
    localStringBuilder.append(paramString2);
    return localStringBuilder;
  }
  
  public static StringBuilder a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return localStringBuilder;
  }
  
  public static void a(int paramInt, String paramString1, HashMap paramHashMap, String paramString2)
  {
    paramHashMap.put(paramString2, new d(paramInt, paramString1));
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, StringBuilder paramStringBuilder, String paramString2)
  {
    paramStringBuilder.append(paramString1.substring(paramInt1, paramInt2));
    paramStringBuilder.append(paramString2);
  }
  
  public static void a(StringBuilder paramStringBuilder, Fragment paramFragment, String paramString)
  {
    paramStringBuilder.append(paramFragment);
    Log.d(paramString, paramStringBuilder.toString());
  }
  
  public static void a(StringBuilder paramStringBuilder, String paramString1, char paramChar, String paramString2)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(paramChar);
    paramStringBuilder.append(paramString2);
  }
  
  public static String b(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramInt);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static o b(String paramString)
  {
    return new o(paramString).k();
  }
  
  public static void b(StringBuilder paramStringBuilder, String paramString1, String paramString2, String paramString3)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(paramString2);
    Logger.verbose(paramStringBuilder.toString(), paramString3);
  }
  
  public static void c(StringBuilder paramStringBuilder, String paramString1, String paramString2, String paramString3)
  {
    paramStringBuilder.append(paramString1);
    paramStringBuilder.append(paramString2);
    Logger.warn(paramStringBuilder.toString(), paramString3);
  }
}

/* Location:
 * Qualified Name:     base.e.a.a.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */