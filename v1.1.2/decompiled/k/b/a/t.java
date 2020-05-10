package k.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import e.g.a.b;
import java.util.UUID;
import k.b.a.v.c;
import k.b.a.v.d;

public final class t
{
  public static d a = new c();
  public static final UUID b;
  public static final UUID c;
  public static final int d = 1;
  
  static
  {
    UUID localUUID = UUID.fromString("e45c1747-a0a4-44ab-8c06-a956df58d93a");
    i.k.b.g.a(localUUID, "UUID.fromString(\n       …6-a956df58d93a\"\n        )");
    b = localUUID;
    localUUID = UUID.fromString("64b81e3c-d60c-4f08-8396-9351b04f7591");
    i.k.b.g.a(localUUID, "UUID.fromString(\n       …6-9351b04f7591\"\n        )");
    c = localUUID;
  }
  
  public static final long a()
  {
    return System.currentTimeMillis() / 'Ϩ';
  }
  
  public static final long a(long paramLong)
  {
    return paramLong * 'Ϩ';
  }
  
  public static final String a(Context paramContext)
  {
    if (paramContext != null)
    {
      Object localObject = (e.g.a)((c)a).a(paramContext);
      paramContext = "";
      localObject = ((e.g.a)localObject).getString("connection-data", "");
      if (localObject != null) {
        paramContext = (Context)localObject;
      }
      return paramContext;
    }
    i.k.b.g.a("context");
    throw null;
  }
  
  public static final void a(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      c localc = (c)a;
      paramContext = paramContext.getSharedPreferences(a, 0).edit();
      paramContext.putBoolean(c, paramBoolean);
      paramContext.apply();
      return;
    }
    i.k.b.g.a("context");
    throw null;
  }
  
  public static final boolean a(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (paramString != null)
      {
        boolean bool;
        if (d.i.b.a.a(paramContext, paramString) == 0) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
      i.k.b.g.a("permission");
      throw null;
    }
    i.k.b.g.a("context");
    throw null;
  }
  
  public static final void b(Context paramContext)
  {
    if (paramContext != null)
    {
      c localc = (c)a;
      paramContext.getSharedPreferences(a, 0).edit().clear().apply();
      paramContext = (a.b)((e.g.a)localc.a(paramContext)).edit();
      a.clear();
      paramContext.apply();
      return;
    }
    i.k.b.g.a("context");
    throw null;
  }
  
  public static final void b(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      c localc = (c)a;
      paramContext = paramContext.getSharedPreferences(a, 0).edit();
      paramContext.putBoolean(e, paramBoolean);
      paramContext.apply();
      return;
    }
    i.k.b.g.a("context");
    throw null;
  }
  
  public static final void c(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      c localc = (c)a;
      paramContext = paramContext.getSharedPreferences(a, 0).edit();
      paramContext.putBoolean(f, paramBoolean);
      paramContext.apply();
      return;
    }
    i.k.b.g.a("context");
    throw null;
  }
  
  public static final boolean c(Context paramContext)
  {
    if (paramContext != null)
    {
      c localc = (c)a;
      return paramContext.getSharedPreferences(a, 0).getBoolean(e, true);
    }
    i.k.b.g.a("context");
    throw null;
  }
  
  public static final void d(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      c localc = (c)a;
      paramContext = paramContext.getSharedPreferences(a, 0).edit();
      paramContext.putBoolean(d, paramBoolean);
      paramContext.apply();
      return;
    }
    i.k.b.g.a("context");
    throw null;
  }
  
  public static final boolean d(Context paramContext)
  {
    if (paramContext != null)
    {
      c localc = (c)a;
      return paramContext.getSharedPreferences(a, 0).getBoolean(f, true);
    }
    i.k.b.g.a("context");
    throw null;
  }
  
  public static final String e(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = (e.g.a)((c)a).a(paramContext);
      String str1 = "";
      String str2 = paramContext.getString("device-id-string", "");
      paramContext = str1;
      if (str2 != null)
      {
        paramContext = str1;
        if (!i.o.g.b(str2)) {
          paramContext = str2;
        }
      }
      return paramContext;
    }
    i.k.b.g.a("context");
    throw null;
  }
  
  public static final String f(Context paramContext)
  {
    if (paramContext != null)
    {
      Object localObject = (e.g.a)((c)a).a(paramContext);
      paramContext = "";
      localObject = ((e.g.a)localObject).getString("token", "");
      if (localObject != null) {
        paramContext = (Context)localObject;
      }
      i.k.b.g.a(paramContext, "preferences.getString(Secured.token, \"\") ?: \"\"");
      return paramContext;
    }
    i.k.b.g.a("context");
    throw null;
  }
  
  public static final boolean g(Context paramContext)
  {
    if (paramContext != null)
    {
      c localc = (c)a;
      return paramContext.getSharedPreferences(a, 0).getBoolean(c, false);
    }
    i.k.b.g.a("context");
    throw null;
  }
  
  public static final boolean h(Context paramContext)
  {
    if (paramContext != null) {
      return i.o.g.b(f(paramContext)) ^ true;
    }
    i.k.b.g.a("context");
    throw null;
  }
  
  public static final boolean i(Context paramContext)
  {
    if (paramContext != null)
    {
      boolean bool1 = k(paramContext);
      boolean bool2 = true;
      if (bool1) {
        return true;
      }
      if ((!(i.o.g.b(f(paramContext)) ^ true)) || (l(paramContext))) {
        bool2 = false;
      }
      return bool2;
    }
    i.k.b.g.a("context");
    throw null;
  }
  
  public static final boolean j(Context paramContext)
  {
    if (paramContext != null) {
      return ((e.g.a)((c)a).a(paramContext)).getBoolean("firstland", true);
    }
    i.k.b.g.a("context");
    throw null;
  }
  
  public static final boolean k(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = e(paramContext);
      if (paramContext != null) {
        paramContext = Boolean.valueOf(i.o.g.b(paramContext) ^ true);
      } else {
        paramContext = null;
      }
      if (paramContext != null) {
        return paramContext.booleanValue();
      }
      i.k.b.g.a();
      throw null;
    }
    i.k.b.g.a("context");
    throw null;
  }
  
  public static final boolean l(Context paramContext)
  {
    if (paramContext != null)
    {
      long l1 = 60;
      long l2 = 'Ϩ';
      long l3 = ((e.g.a)((c)a).a(paramContext)).getLong("timestamp", 0L);
      boolean bool;
      if (System.currentTimeMillis() - l3 >= 12L * l1 * l1 * l2) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    i.k.b.g.a("context");
    throw null;
  }
}

/* Location:
 * Qualified Name:     k.b.a.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */