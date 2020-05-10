package k.a.a.a.a.a;

import android.bluetooth.BluetoothDevice;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.ParcelUuid;
import android.os.SystemClock;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class a$a
{
  public final Object a = new Object();
  public final boolean b;
  public final boolean c;
  public final boolean d;
  public boolean e;
  public final List<h> f;
  public final k g;
  public final g h;
  public final Handler i;
  public final List<j> j = new ArrayList();
  public final Set<String> k = new HashSet();
  public final Map<String, j> l = new HashMap();
  public final Runnable m = new a();
  public final Runnable n = new b();
  
  public a$a(boolean paramBoolean1, boolean paramBoolean2, List<h> paramList, k paramk, g paramg, Handler paramHandler)
  {
    f = Collections.unmodifiableList(paramList);
    g = paramk;
    h = paramg;
    i = paramHandler;
    boolean bool1 = false;
    e = false;
    int i1;
    if (Build.VERSION.SDK_INT >= 23) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    boolean bool2;
    if ((A != 1) && ((i1 == 0) || (!G))) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    d = bool2;
    if ((!paramList.isEmpty()) && ((!paramBoolean2) || (!E))) {
      paramBoolean2 = true;
    } else {
      paramBoolean2 = false;
    }
    b = paramBoolean2;
    long l1 = B;
    paramBoolean2 = bool1;
    if (l1 > 0L) {
      if (paramBoolean1)
      {
        paramBoolean2 = bool1;
        if (F) {}
      }
      else
      {
        paramBoolean2 = true;
      }
    }
    c = paramBoolean2;
    if (paramBoolean2) {
      paramHandler.postDelayed(m, l1);
    }
  }
  
  public void a()
  {
    e = true;
    i.removeCallbacksAndMessages(null);
    synchronized (a)
    {
      l.clear();
      k.clear();
      j.clear();
      return;
    }
  }
  
  public void a(int paramInt, j paramj)
  {
    if ((!e) && ((f.isEmpty()) || (a(paramj))))
    {
      Object localObject1 = x.getAddress();
      if (d) {
        synchronized (l)
        {
          boolean bool = l.isEmpty();
          localObject1 = (j)l.put(localObject1, paramj);
          if ((localObject1 == null) && ((g.A & 0x2) > 0)) {
            h.a(2, paramj);
          }
          if ((!bool) || ((g.A & 0x4) <= 0)) {
            return;
          }
          i.removeCallbacks(n);
          i.postDelayed(n, g.I);
        }
      }
      if (c) {
        synchronized (a)
        {
          if (!k.contains(localObject1))
          {
            j.add(paramj);
            k.add(localObject1);
          }
          return;
        }
      }
      h.a(paramInt, paramj);
    }
  }
  
  public void a(List<j> paramList)
  {
    if (e) {
      return;
    }
    Object localObject = paramList;
    if (b)
    {
      localObject = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (j)localIterator.next();
        if (a(paramList)) {
          ((ArrayList)localObject).add(paramList);
        }
      }
    }
    h.a((List)localObject);
  }
  
  public final boolean a(j paramj)
  {
    Iterator localIterator = f.iterator();
    int i2;
    label373:
    label386:
    do
    {
      boolean bool = localIterator.hasNext();
      int i1 = 0;
      if (!bool) {
        break label577;
      }
      h localh = (h)localIterator.next();
      Object localObject1 = null;
      if (localh == null) {
        break;
      }
      if (paramj == null)
      {
        i2 = i1;
      }
      else
      {
        Object localObject2 = x;
        Object localObject3 = y;
        if ((localObject3 != null) && (!((String)localObject3).equals(((BluetoothDevice)localObject2).getAddress())))
        {
          i2 = i1;
        }
        else
        {
          localObject2 = y;
          if (localObject2 == null)
          {
            i2 = i1;
            if (x != null) {
              continue;
            }
            i2 = i1;
            if (z != null) {
              continue;
            }
            i2 = i1;
            if (F != null) {
              continue;
            }
            if (C != null)
            {
              i2 = i1;
              continue;
            }
          }
          localObject3 = x;
          if ((localObject3 != null) && (!((String)localObject3).equals(f)))
          {
            i2 = i1;
          }
          else
          {
            Object localObject4 = z;
            Object localObject5;
            if (localObject4 != null)
            {
              localObject5 = A;
              localObject3 = b;
              if (localObject3 != null)
              {
                localObject6 = ((List)localObject3).iterator();
                while (((Iterator)localObject6).hasNext())
                {
                  Object localObject7 = (ParcelUuid)((Iterator)localObject6).next();
                  if (localObject5 == null) {
                    localObject3 = null;
                  } else {
                    localObject3 = ((ParcelUuid)localObject5).getUuid();
                  }
                  UUID localUUID = ((ParcelUuid)localObject4).getUuid();
                  localObject7 = ((ParcelUuid)localObject7).getUuid();
                  if (localObject3 == null)
                  {
                    bool = localUUID.equals(localObject7);
                  }
                  else
                  {
                    if ((localUUID.getLeastSignificantBits() & ((UUID)localObject3).getLeastSignificantBits()) == (((UUID)localObject7).getLeastSignificantBits() & ((UUID)localObject3).getLeastSignificantBits()))
                    {
                      long l1 = localUUID.getMostSignificantBits();
                      long l2 = ((UUID)localObject3).getMostSignificantBits();
                      long l3 = ((UUID)localObject7).getMostSignificantBits();
                      if ((l1 & l2) == (((UUID)localObject3).getMostSignificantBits() & l3))
                      {
                        bool = true;
                        break label373;
                      }
                    }
                    bool = false;
                  }
                  if (bool)
                  {
                    i2 = 1;
                    break label386;
                  }
                }
              }
              i2 = 0;
              if (i2 == 0)
              {
                i2 = i1;
                continue;
              }
            }
            Object localObject6 = B;
            if ((localObject6 != null) && (localObject2 != null))
            {
              localObject5 = C;
              localObject4 = D;
              localObject3 = d;
              if (localObject3 == null) {
                localObject3 = null;
              } else {
                localObject3 = (byte[])((Map)localObject3).get(localObject6);
              }
              if (!localh.a((byte[])localObject5, (byte[])localObject4, (byte[])localObject3))
              {
                i2 = i1;
                continue;
              }
            }
            i2 = E;
            if ((i2 >= 0) && (localObject2 != null))
            {
              localObject5 = F;
              localObject4 = G;
              localObject3 = c;
              if (localObject3 == null) {
                localObject3 = localObject1;
              } else {
                localObject3 = (byte[])((SparseArray)localObject3).get(i2);
              }
              if (!localh.a((byte[])localObject5, (byte[])localObject4, (byte[])localObject3))
              {
                i2 = i1;
                continue;
              }
            }
            i2 = 1;
          }
        }
      }
    } while (i2 == 0);
    return true;
    throw null;
    label577:
    return false;
  }
  
  public void b()
  {
    if ((c) && (!e)) {
      synchronized (a)
      {
        g localg = h;
        ArrayList localArrayList = new java/util/ArrayList;
        localArrayList.<init>(j);
        localg.a(localArrayList);
        j.clear();
        k.clear();
      }
    }
  }
  
  public class a
    implements Runnable
  {
    public a() {}
    
    public void run()
    {
      a.a locala = a.a.this;
      if (!e)
      {
        locala.b();
        locala = a.a.this;
        i.postDelayed(this, g.B);
      }
    }
  }
  
  public class b
    implements Runnable
  {
    public b() {}
    
    public void run()
    {
      long l = SystemClock.elapsedRealtimeNanos();
      synchronized (a)
      {
        Iterator localIterator = a.a.this.l.values().iterator();
        while (localIterator.hasNext())
        {
          j localj = (j)localIterator.next();
          if (A < l - g.H)
          {
            localIterator.remove();
            Handler localHandler = i;
            a locala = new k/a/a/a/a/a/a$a$b$a;
            locala.<init>(this, localj);
            localHandler.post(locala);
          }
        }
        if (!a.a.this.l.isEmpty()) {
          i.postDelayed(this, g.I);
        }
        return;
      }
    }
    
    public class a
      implements Runnable
    {
      public a(j paramj) {}
      
      public void run()
      {
        h.a(4, x);
      }
    }
  }
}

/* Location:
 * Qualified Name:     k.a.a.a.a.a.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */