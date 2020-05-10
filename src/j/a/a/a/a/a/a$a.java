package j.a.a.a.a.a;

import android.bluetooth.BluetoothDevice;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.ParcelUuid;
import android.util.SparseArray;
import java.util.ArrayList;
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
  public final Runnable m = new a.a.a(this);
  public final Runnable n = new a.a.b(this);
  
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
          localObject3 = y;
          if (localObject3 == null)
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
          localObject2 = x;
          if ((localObject2 != null) && (!((String)localObject2).equals(f)))
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
              localObject2 = b;
              if (localObject2 != null)
              {
                localObject6 = ((List)localObject2).iterator();
                while (((Iterator)localObject6).hasNext())
                {
                  Object localObject7 = (ParcelUuid)((Iterator)localObject6).next();
                  if (localObject5 == null) {
                    localObject2 = null;
                  } else {
                    localObject2 = ((ParcelUuid)localObject5).getUuid();
                  }
                  UUID localUUID = ((ParcelUuid)localObject4).getUuid();
                  localObject7 = ((ParcelUuid)localObject7).getUuid();
                  if (localObject2 == null)
                  {
                    bool = localUUID.equals(localObject7);
                  }
                  else
                  {
                    if ((localUUID.getLeastSignificantBits() & ((UUID)localObject2).getLeastSignificantBits()) == (((UUID)localObject7).getLeastSignificantBits() & ((UUID)localObject2).getLeastSignificantBits()))
                    {
                      long l1 = localUUID.getMostSignificantBits();
                      long l2 = ((UUID)localObject2).getMostSignificantBits();
                      long l3 = ((UUID)localObject7).getMostSignificantBits();
                      if ((l1 & l2) == (((UUID)localObject2).getMostSignificantBits() & l3))
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
            if ((localObject6 != null) && (localObject3 != null))
            {
              localObject5 = C;
              localObject4 = D;
              localObject2 = d;
              if (localObject2 == null) {
                localObject2 = null;
              } else {
                localObject2 = (byte[])((Map)localObject2).get(localObject6);
              }
              if (!localh.a((byte[])localObject5, (byte[])localObject4, (byte[])localObject2))
              {
                i2 = i1;
                continue;
              }
            }
            i2 = E;
            if ((i2 >= 0) && (localObject3 != null))
            {
              localObject4 = F;
              localObject5 = G;
              localObject2 = c;
              if (localObject2 == null) {
                localObject2 = localObject1;
              } else {
                localObject2 = (byte[])((SparseArray)localObject2).get(i2);
              }
              if (!localh.a((byte[])localObject4, (byte[])localObject5, (byte[])localObject2))
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
}

/* Location:
 * Qualified Name:     base.j.a.a.a.a.a.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */