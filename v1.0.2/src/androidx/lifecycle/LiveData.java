package androidx.lifecycle;

import d.c.a.a.c;
import d.c.a.b.b;
import d.c.a.b.b.d;
import d.o.g.b;
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
    LiveData.a locala = (LiveData.a)b.remove(paramr);
    if (locala == null) {
      return;
    }
    paramr = (LiveData.LifecycleBoundObserver)locala;
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
    LiveData<T>.a localLiveData = paramLiveData;
    do
    {
      h = false;
      if (localLiveData != null)
      {
        a(localLiveData);
        paramLiveData = null;
      }
      else
      {
        b.d locald = b.a();
        do
        {
          paramLiveData = localLiveData;
          if (!locald.hasNext()) {
            break;
          }
          a((LiveData.a)((Map.Entry)locald.next()).getValue());
        } while (!h);
        paramLiveData = localLiveData;
      }
      localLiveData = paramLiveData;
    } while (h);
    g = false;
  }
}

/* Location:
 * Qualified Name:     base.androidx.lifecycle.LiveData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */