package k.b.a.v.f;

import android.content.Context;
import android.database.Cursor;
import d.b.a.s;
import d.u.i;
import d.u.k;
import d.w.a.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import no.simula.corona.data.legacy.MeasurementDatabase;

public final class d
  implements k.b.a.v.a
{
  public MeasurementDatabase a;
  
  public d(Context paramContext) {}
  
  public void a()
  {
    Object localObject1 = (c)a.g();
    a.b();
    f localf = c.a();
    a.c();
    try
    {
      localf.executeUpdateDelete();
      a.f();
      a.d();
      localObject1 = c;
      if (localf == c) {
        a.set(false);
      }
      return;
    }
    finally
    {
      a.d();
      c.a(localf);
    }
  }
  
  public void a(List<Long> paramList)
  {
    if (paramList != null)
    {
      Object localObject1 = new ArrayList();
      Object localObject3 = new ArrayList(e.c.a.a.b.l.c.a(paramList, 10));
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((Collection)localObject3).add(Boolean.valueOf(((ArrayList)localObject1).add(Integer.valueOf((int)((Number)paramList.next()).longValue()))));
      }
      paramList = (c)a.g();
      a.b();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("UPDATE bluetoothcontact SET isUploaded = 1 WHERE id in (");
      d.u.m.c.a((StringBuilder)localObject3, ((List)localObject1).size());
      ((StringBuilder)localObject3).append(")");
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject3 = a.a((String)localObject3);
      localObject1 = ((List)localObject1).iterator();
      for (int i = 1; ((Iterator)localObject1).hasNext(); i++)
      {
        Integer localInteger = (Integer)((Iterator)localObject1).next();
        if (localInteger == null) {
          ((d.w.a.d)localObject3).bindNull(i);
        } else {
          ((d.w.a.d)localObject3).bindLong(i, localInteger.intValue());
        }
      }
      a.c();
      try
      {
        ((f)localObject3).executeUpdateDelete();
        a.f();
        return;
      }
      finally
      {
        a.d();
      }
    }
    i.k.b.g.a("ids");
    throw null;
  }
  
  public void a(k.b.a.v.g.a parama)
  {
    if (parama != null)
    {
      b localb = a.g();
      a locala = new a(b, c, d, e, f);
      parama = (c)localb;
      a.b();
      a.c();
      try
      {
        b.a(new a[] { locala });
        a.f();
        return;
      }
      finally
      {
        a.d();
      }
    }
    i.k.b.g.a("bluetoothContact");
    throw null;
  }
  
  public void a(k.b.a.v.g.b paramb)
  {
    if (paramb != null)
    {
      Object localObject = a.h();
      paramb = new e(d, e, f, g, h, i, j, k, l);
      localObject = (g)localObject;
      a.b();
      a.c();
      try
      {
        b.a(new e[] { paramb });
        a.f();
        return;
      }
      finally
      {
        a.d();
      }
    }
    i.k.b.g.a("measurment");
    throw null;
  }
  
  public List<k.b.a.v.g.b> b()
  {
    Object localObject1 = (g)a.h();
    if (localObject1 != null)
    {
      i locali = i.a("SELECT * from measurement WHERE isUploaded is 0", 0);
      a.b();
      Cursor localCursor = d.u.m.b.a(a, locali, false, null);
      try
      {
        int i = s.a(localCursor, "id");
        int j = s.a(localCursor, "timestamp");
        int k = s.a(localCursor, "latitude");
        int m = s.a(localCursor, "longitude");
        int n = s.a(localCursor, "latLongAccuracy");
        int i1 = s.a(localCursor, "altitude");
        int i2 = s.a(localCursor, "altitudeAccuracy");
        int i3 = s.a(localCursor, "speed");
        int i4 = s.a(localCursor, "speedAccuracy");
        int i5 = s.a(localCursor, "isUploaded");
        ArrayList localArrayList = new java/util/ArrayList;
        localArrayList.<init>(localCursor.getCount());
        for (;;)
        {
          Object localObject3 = null;
          if (!localCursor.moveToNext()) {
            break;
          }
          long l = localCursor.getLong(j);
          if (localCursor.isNull(k)) {
            localObject1 = null;
          } else {
            localObject1 = Double.valueOf(localCursor.getDouble(k));
          }
          Double localDouble1;
          if (localCursor.isNull(m)) {
            localDouble1 = null;
          } else {
            localDouble1 = Double.valueOf(localCursor.getDouble(m));
          }
          Double localDouble2;
          if (localCursor.isNull(n)) {
            localDouble2 = null;
          } else {
            localDouble2 = Double.valueOf(localCursor.getDouble(n));
          }
          Double localDouble3;
          if (localCursor.isNull(i1)) {
            localDouble3 = null;
          } else {
            localDouble3 = Double.valueOf(localCursor.getDouble(i1));
          }
          Double localDouble4;
          if (localCursor.isNull(i2)) {
            localDouble4 = null;
          } else {
            localDouble4 = Double.valueOf(localCursor.getDouble(i2));
          }
          Double localDouble5;
          if (localCursor.isNull(i3)) {
            localDouble5 = null;
          } else {
            localDouble5 = Double.valueOf(localCursor.getDouble(i3));
          }
          Double localDouble6;
          if (localCursor.isNull(i4)) {
            localDouble6 = null;
          } else {
            localDouble6 = Double.valueOf(localCursor.getDouble(i4));
          }
          boolean bool;
          if (localCursor.getInt(i5) != 0) {
            bool = true;
          } else {
            bool = false;
          }
          e locale = new k/b/a/v/f/e;
          locale.<init>(l, (Double)localObject1, localDouble1, localDouble2, localDouble3, localDouble4, localDouble5, localDouble6, bool);
          if (localCursor.isNull(i)) {
            localObject1 = localObject3;
          } else {
            localObject1 = Integer.valueOf(localCursor.getInt(i));
          }
          a = ((Integer)localObject1);
          localArrayList.add(locale);
        }
        return k.b.a.v.g.b.a(localArrayList);
      }
      finally
      {
        localCursor.close();
        locali.b();
      }
    }
    throw null;
  }
  
  public void b(List<Long> paramList)
  {
    if (paramList != null)
    {
      Object localObject1 = new ArrayList();
      Object localObject3 = new ArrayList(e.c.a.a.b.l.c.a(paramList, 10));
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((Collection)localObject3).add(Boolean.valueOf(((ArrayList)localObject1).add(Integer.valueOf((int)((Number)paramList.next()).longValue()))));
      }
      paramList = (g)a.h();
      a.b();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("UPDATE measurement SET isUploaded = 1 WHERE id in (");
      d.u.m.c.a((StringBuilder)localObject3, ((List)localObject1).size());
      ((StringBuilder)localObject3).append(")");
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject3 = a.a((String)localObject3);
      localObject1 = ((List)localObject1).iterator();
      for (int i = 1; ((Iterator)localObject1).hasNext(); i++)
      {
        Integer localInteger = (Integer)((Iterator)localObject1).next();
        if (localInteger == null) {
          ((d.w.a.d)localObject3).bindNull(i);
        } else {
          ((d.w.a.d)localObject3).bindLong(i, localInteger.intValue());
        }
      }
      a.c();
      try
      {
        ((f)localObject3).executeUpdateDelete();
        a.f();
        return;
      }
      finally
      {
        a.d();
      }
    }
    i.k.b.g.a("ids");
    throw null;
  }
  
  public void c()
  {
    g localg = (g)a.h();
    a.b();
    f localf = c.a();
    a.c();
    try
    {
      localf.executeUpdateDelete();
      a.f();
      a.d();
      k localk = c;
      if (localf == c) {
        a.set(false);
      }
      return;
    }
    finally
    {
      a.d();
      c.a(localf);
    }
  }
  
  public void close() {}
  
  public List<k.b.a.v.g.a> d()
  {
    Object localObject1 = (c)a.g();
    if (localObject1 != null)
    {
      i locali = i.a("SELECT * from bluetoothcontact WHERE isUploaded is 0", 0);
      a.b();
      Cursor localCursor = d.u.m.b.a(a, locali, false, null);
      try
      {
        int i = s.a(localCursor, "id");
        int j = s.a(localCursor, "timestamp");
        int k = s.a(localCursor, "deviceId");
        int m = s.a(localCursor, "rssi");
        int n = s.a(localCursor, "txPower");
        int i1 = s.a(localCursor, "isUploaded");
        ArrayList localArrayList = new java/util/ArrayList;
        localArrayList.<init>(localCursor.getCount());
        while (localCursor.moveToNext())
        {
          long l = localCursor.getLong(j);
          localObject1 = localCursor.getString(k);
          int i2 = localCursor.getInt(m);
          int i3 = localCursor.getInt(n);
          boolean bool;
          if (localCursor.getInt(i1) != 0) {
            bool = true;
          } else {
            bool = false;
          }
          a locala = new k/b/a/v/f/a;
          locala.<init>(l, (String)localObject1, i2, i3, bool);
          if (localCursor.isNull(i)) {
            localObject1 = null;
          } else {
            localObject1 = Integer.valueOf(localCursor.getInt(i));
          }
          a = ((Integer)localObject1);
          localArrayList.add(locala);
        }
        return k.b.a.v.g.a.a(localArrayList);
      }
      finally
      {
        localCursor.close();
        locali.b();
      }
    }
    throw null;
  }
  
  public void e()
  {
    c localc = (c)a.g();
    a.b();
    f localf = d.a();
    a.c();
    try
    {
      localf.executeUpdateDelete();
      a.f();
      a.d();
      k localk = d;
      if (localf == c) {
        a.set(false);
      }
      return;
    }
    finally
    {
      a.d();
      d.a(localf);
    }
  }
  
  public void f()
  {
    g localg = (g)a.h();
    a.b();
    f localf = d.a();
    a.c();
    try
    {
      localf.executeUpdateDelete();
      a.f();
      a.d();
      k localk = d;
      if (localf == c) {
        a.set(false);
      }
      return;
    }
    finally
    {
      a.d();
      d.a(localf);
    }
  }
}

/* Location:
 * Qualified Name:     k.b.a.v.f.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */