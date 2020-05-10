package e.c.a.a.b.i.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import d.b.a.s;
import e.c.a.a.d.a.c;

public final class f<L>
{
  public final c a;
  public volatile L b;
  public final a<L> c;
  
  public f(Looper paramLooper, L paramL, String paramString)
  {
    a = new c(paramLooper);
    s.b(paramL, "Listener must not be null");
    b = paramL;
    s.a(paramString);
    c = new a(paramL, paramString);
  }
  
  public final void a(b<? super L> paramb)
  {
    s.b(paramb, "Notifier must not be null");
    paramb = a.obtainMessage(1, paramb);
    a.sendMessage(paramb);
  }
  
  public static final class a<L>
  {
    public final L a;
    public final String b;
    
    public a(L paramL, String paramString)
    {
      a = paramL;
      b = paramString;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      return (a == a) && (b.equals(b));
    }
    
    public final int hashCode()
    {
      int i = System.identityHashCode(a);
      return b.hashCode() + i * 31;
    }
  }
  
  public static abstract interface b<L>
  {
    public abstract void a();
    
    public abstract void a(L paramL);
  }
  
  public final class c
    extends c
  {
    public c(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int i = what;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      s.a(bool);
      Object localObject = f.this;
      paramMessage = (f.b)obj;
      localObject = b;
      if (localObject == null) {
        paramMessage.a();
      }
      try
      {
        paramMessage.a(localObject);
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        paramMessage.a();
        throw localRuntimeException;
      }
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.i.k.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */