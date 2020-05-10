package d.i.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;

@SuppressLint({"NewApi"})
public class c
{
  public static final i a;
  public static final d.f.f<String, Typeface> b;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 29)
    {
      a = new h();
    }
    else if (i >= 28)
    {
      a = new g();
    }
    else if (i >= 26)
    {
      a = new f();
    }
    else
    {
      if (i >= 24)
      {
        if (e.d == null) {
          Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        if (e.d != null) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          a = new e();
          break label121;
        }
      }
      a = new d();
    }
    label121:
    b = new d.f.f(16);
  }
  
  public static Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    paramContext = a.a(paramContext, paramResources, paramInt1, paramString, paramInt2);
    if (paramContext != null)
    {
      paramResources = a(paramResources, paramInt1, paramInt2);
      b.a(paramResources, paramContext);
    }
    return paramContext;
  }
  
  public static Typeface a(Context paramContext, Typeface paramTypeface, int paramInt)
  {
    if (paramContext != null) {
      return Typeface.create(paramTypeface, paramInt);
    }
    throw new IllegalArgumentException("Context cannot be null");
  }
  
  public static Typeface a(Context paramContext, d.i.b.b.b paramb, Resources paramResources, int paramInt1, int paramInt2, d.i.b.b.g paramg, Handler paramHandler, boolean paramBoolean)
  {
    if ((paramb instanceof d.i.b.b.e))
    {
      paramb = (d.i.b.b.e)paramb;
      boolean bool = false;
      if (paramBoolean ? c == 0 : paramg == null) {
        bool = true;
      }
      int i;
      if (paramBoolean) {
        i = b;
      } else {
        i = -1;
      }
      paramContext = d.i.f.b.a(paramContext, a, paramg, paramHandler, bool, i, paramInt2);
    }
    else
    {
      paramb = a.a(paramContext, (d.i.b.b.c)paramb, paramResources, paramInt2);
      paramContext = paramb;
      if (paramg != null) {
        if (paramb != null)
        {
          paramg.a(paramb, paramHandler);
          paramContext = paramb;
        }
        else
        {
          paramg.a(-3, paramHandler);
          paramContext = paramb;
        }
      }
    }
    if (paramContext != null) {
      b.a(a(paramResources, paramInt1, paramInt2), paramContext);
    }
    return paramContext;
  }
  
  public static String a(Resources paramResources, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramResources.getResourcePackageName(paramInt1));
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt2);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.d.i.c.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */