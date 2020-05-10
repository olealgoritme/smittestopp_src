package androidx.lifecycle;

import d.c.a.a.c;
import d.c.a.b.b;
import d.c.a.b.b.d;
import d.o.g.a;
import d.o.g.b;
import d.o.j;
import d.o.l;
import d.o.m;
import d.o.r;
import java.util.Map.Entry;

public abstract class LiveData<T>
{
  public static final Object i = new Object();
  public final Object a = new Object();
  public b<r<? super T>, LiveData<T>.a> b = new b();
  public int c = 0;
  public volatile Object d = i;
  public volatile Object e = i;
  public int f = -1;
  public boolean g;
  public boolean h;
  
  public static void a(String paramString)
  {
    if (ba.a()) {
      return;
    }
    throw new IllegalStateException(e.a.a.a.a.a("Cannot invoke ", paramString, " on a background thread"));
  }
  
  public void a() {}
  
  public final void a(LiveData<T>.a paramLiveData)
  {
    if (!y) {
      return;
    }
    if (!B.getLifecycle()).b.isAtLeast(g.b.STARTED))
    {
      paramLiveData.a(false);
      return;
    }
    int j = z;
    int k = f;
    if (j >= k) {
      return;
    }
    z = k;
    x.a(d);
  }
  
  public void a(r<? super T> paramr)
  {
    a("removeObserver");
    a locala = (a)b.remove(paramr);
    if (locala == null) {
      return;
    }
    paramr = (LifecycleBoundObserver)locala;
    B.getLifecycle()).a.remove(paramr);
    locala.a(false);
  }
  
  public void b() {}
  
  public void b(LiveData<T>.a paramLiveData)
  {
    if (g)
    {
      h = true;
      return;
    }
    g = true;
    do
    {
      h = false;
      LiveData<T>.a localLiveData;
      if (paramLiveData != null)
      {
        a(paramLiveData);
        localLiveData = null;
      }
      else
      {
        b.d locald = b.a();
        do
        {
          localLiveData = paramLiveData;
          if (!locald.hasNext()) {
            break;
          }
          a((a)((Map.Entry)locald.next()).getValue());
        } while (!h);
        localLiveData = paramLiveData;
      }
      paramLiveData = localLiveData;
    } while (h);
    g = false;
  }
  
  public class LifecycleBoundObserver
    extends LiveData<T>.a
    implements j
  {
    public final l B;
    
    public void a(l paraml, g.a parama)
    {
      if (B.getLifecycle()).b == g.b.DESTROYED)
      {
        C.a(x);
        return;
      }
      a(B.getLifecycle()).b.isAtLeast(g.b.STARTED));
    }
  }
  
  public abstract class a
  {
    public final r<? super T> x;
    public boolean y;
    public int z;
    
    public void a(boolean paramBoolean)
    {
      if (paramBoolean == y) {
        return;
      }
      y = paramBoolean;
      int i = A.c;
      int j = 1;
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      LiveData localLiveData = A;
      int k = c;
      if (!y) {
        j = -1;
      }
      c = (k + j);
      if ((i != 0) && (y)) {
        A.a();
      }
      localLiveData = A;
      if ((c == 0) && (!y)) {
        localLiveData.b();
      }
      if (y) {
        A.b(this);
      }
    }
  }
}

/* Location:
 * Qualified Name:     androidx.lifecycle.LiveData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */