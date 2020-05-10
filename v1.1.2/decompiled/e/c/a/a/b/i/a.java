package e.c.a.a.b.i;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import d.b.a.s;
import e.c.a.a.b.c;
import e.c.a.a.b.j.b.c;
import e.c.a.a.b.j.b.e;
import e.c.a.a.b.j.d;
import e.c.a.a.b.j.k;
import java.util.Set;

public final class a<O extends d>
{
  public final a<?, O> a;
  public final String b;
  
  public <C extends f> a(String paramString, a<C, O> parama, g<C> paramg)
  {
    s.b(parama, "Cannot construct an Api with a null ClientBuilder");
    s.b(paramg, "Cannot construct an Api with a null ClientKey");
    b = paramString;
    a = parama;
  }
  
  public static abstract class a<T extends a.f, O>
    extends a.e<T, O>
  {
    public abstract T a(Context paramContext, Looper paramLooper, d paramd, O paramO, d.a parama, d.b paramb);
  }
  
  public static abstract interface b {}
  
  public static class c<C extends a.b> {}
  
  public static abstract interface d
  {
    public static abstract interface a
      extends a.d.c, a.d.d
    {
      public abstract Account getAccount();
    }
    
    public static abstract interface b
      extends a.d.c
    {
      public abstract GoogleSignInAccount a();
    }
    
    public static abstract interface c
      extends a.d
    {}
    
    public static abstract interface d
      extends a.d
    {}
    
    public static abstract interface e
      extends a.d.c, a.d.d
    {}
  }
  
  public static class e<T extends a.b, O> {}
  
  public static abstract interface f
    extends a.b
  {
    public abstract void a(b.c paramc);
    
    public abstract void a(b.e parame);
    
    public abstract void a(k paramk, Set<Scope> paramSet);
    
    public abstract boolean a();
    
    public abstract boolean b();
    
    public abstract int c();
    
    public abstract boolean d();
    
    public abstract c[] e();
    
    public abstract String f();
    
    public abstract void g();
    
    public abstract boolean i();
  }
  
  public static final class g<C extends a.f>
    extends a.c<C>
  {}
}

/* Location:
 * Qualified Name:     e.c.a.a.b.i.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */