package j.b.a;


/*
 *
 *
 * orig: j/b/a/a0.java
 * */


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import d.i.b.a;
import java.util.UUID;

public final class a0
{
  public static final UUID a;
  public static final UUID b;
  public static final int c = 1;
  
  static
  {
    UUID localUUID = UUID.fromString("e45c1747-a0a4-44ab-8c06-a956df58d93a");
    h.k.b.g.a(localUUID, "UUID.fromString(\n       …6-a956df58d93a\"\n        )");
    a = localUUID;
    localUUID = UUID.fromString("64b81e3c-d60c-4f08-8396-9351b04f7591");
    h.k.b.g.a(localUUID, "UUID.fromString(\n       …6-9351b04f7591\"\n        )");
    b = localUUID;
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
      Object localObject = paramContext.getSharedPreferences("settings", 0);
      paramContext = "";
      localObject = ((SharedPreferences)localObject).getString("connection-data", "");
      if (localObject != null) {
        paramContext = (Context)localObject;
      }
      return paramContext;
    }
    h.k.b.g.a("context");
    throw null;
  }
  
  public static final void a(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("settings", 0).edit();
      paramContext.putBoolean("did-user-start-bt", paramBoolean);
      paramContext.apply();
      return;
    }
    h.k.b.g.a("context");
    throw null;
  }
  
  public static final boolean a(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (paramString != null)
      {
        boolean bool;
        if (a.a(paramContext, paramString) == 0) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
      h.k.b.g.a("permission");
      throw null;
    }
    h.k.b.g.a("context");
    throw null;
  }
  
  public static final void b(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext.getSharedPreferences("settings", 0).edit().clear().apply();
      return;
    }
    h.k.b.g.a("context");
    throw null;
  }
  
  public static final void b(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("settings", 0).edit();
      paramContext.putBoolean("did-user-start-loc", paramBoolean);
      paramContext.apply();
      return;
    }
    h.k.b.g.a("context");
    throw null;
  }
  
  public static final void c(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("settings", 0).edit();
      paramContext.putBoolean("dont-ask-again", paramBoolean);
      paramContext.apply();
      return;
    }
    h.k.b.g.a("context");
    throw null;
  }
  
  public static final boolean c(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences("settings", 0).getBoolean("did-user-start-bt", true);
    }
    h.k.b.g.a("context");
    throw null;
  }
  
  public static final boolean d(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences("settings", 0).getBoolean("did-user-start-loc", true);
    }
    h.k.b.g.a("context");
    throw null;
  }
  
  public static final String e(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("settings", 0).getString("device-id-string", "");
      if ((paramContext != null) && (!h.o.g.b(paramContext))) {
        return paramContext;
      }
      return "";
    }
    h.k.b.g.a("context");
    throw null;
  }
  
  public static final String f(Context paramContext)
  {
    if (paramContext != null)
    {
      Object localObject = paramContext.getSharedPreferences("settings", 0);
      paramContext = "";
      localObject = ((SharedPreferences)localObject).getString("token", "");
      if (localObject != null) {
        paramContext = (Context)localObject;
      }
      return paramContext;
    }
    h.k.b.g.a("context");
    throw null;
  }
  
  public static final boolean g(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences("settings", 0).getBoolean("consented", false);
    }
    h.k.b.g.a("context");
    throw null;
  }
  
  public static final boolean h(Context paramContext)
  {
    if (paramContext != null)
    {
      boolean bool1 = j(paramContext);
      boolean bool2 = true;
      if (bool1) {
        return true;
      }
      if ((!(h.o.g.b(f(paramContext)) ^ true)) || (k(paramContext))) {
        bool2 = false;
      }
      return bool2;
    }
    h.k.b.g.a("context");
    throw null;
  }
  
  public static final boolean i(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences("settings", 0).getBoolean("firstland", true);
    }
    h.k.b.g.a("context");
    throw null;
  }
  
  public static final boolean j(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = e(paramContext);
      if (paramContext != null) {
        paramContext = Boolean.valueOf(h.o.g.b(paramContext) ^ true);
      } else {
        paramContext = null;
      }
      if (paramContext != null) {
        return paramContext.booleanValue();
      }
      h.k.b.g.a();
      throw null;
    }
    h.k.b.g.a("context");
    throw null;
  }
  
  public static final boolean k(Context paramContext)
  {
    if (paramContext != null)
    {
      long l1 = 60;
      long l2 = 'Ϩ';
      boolean bool = false;
      long l3 = paramContext.getSharedPreferences("settings", 0).getLong("timestamp", 0L);
      if (System.currentTimeMillis() - l3 >= 12L * l1 * l1 * l2) {
        bool = true;
      }
      return bool;
    }
    h.k.b.g.a("context");
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.j.b.a.a0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */