package k.b.a.v.g;

import e.c.a.a.b.l.c;
import i.k.b.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public Long a;
  public final long b;
  public final String c;
  public final int d;
  public final int e;
  public final boolean f;
  
  public a(long paramLong, String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public static final List<a> a(List<k.b.a.v.f.a> paramList)
  {
    if (paramList != null)
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList(c.a(paramList, 10));
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (k.b.a.v.f.a)localIterator.next();
        if (paramList != null)
        {
          a locala = new a(b, c, d, e, f);
          paramList = a;
          if (paramList != null) {
            paramList = Long.valueOf(paramList.intValue());
          } else {
            paramList = null;
          }
          a = paramList;
          localArrayList2.add(Boolean.valueOf(localArrayList1.add(locala)));
        }
        else
        {
          g.a("entity");
          throw null;
        }
      }
      return localArrayList1;
    }
    g.a("measurements");
    throw null;
  }
  
  public static final k.b.a.v.e.a a(a parama)
  {
    if (parama != null) {
      return new k.b.a.v.e.a(null, Long.valueOf(b), c, d, e, Boolean.valueOf(f));
    }
    g.a("model");
    throw null;
  }
  
  public static final List<a> b(List<? extends k.b.a.v.e.a> paramList)
  {
    if (paramList != null)
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList(c.a(paramList, 10));
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (k.b.a.v.e.a)localIterator.next();
        if (paramList != null)
        {
          Object localObject = b;
          g.a(localObject, "entity.timestamp");
          long l = ((Long)localObject).longValue();
          String str = c;
          g.a(str, "entity.deviceId");
          int i = d;
          int j = e;
          localObject = f;
          g.a(localObject, "entity.isUploaded");
          localObject = new a(l, str, i, j, ((Boolean)localObject).booleanValue());
          a = a;
          localArrayList2.add(Boolean.valueOf(localArrayList1.add(localObject)));
        }
        else
        {
          g.a("entity");
          throw null;
        }
      }
      return localArrayList1;
    }
    g.a("models");
    throw null;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((b == b) && (g.a(c, c)) && (d == d) && (e == e) && (f == f)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int i = a.a(b);
    String str = c;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    int k = d;
    int m = e;
    int n = f;
    int i1 = n;
    if (n != 0) {
      i1 = 1;
    }
    return (((i * 31 + j) * 31 + k) * 31 + m) * 31 + i1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("BluetoothContact(timestamp=");
    localStringBuilder.append(b);
    localStringBuilder.append(", deviceId=");
    localStringBuilder.append(c);
    localStringBuilder.append(", rssi=");
    localStringBuilder.append(d);
    localStringBuilder.append(", txPower=");
    localStringBuilder.append(e);
    localStringBuilder.append(", isUploaded=");
    localStringBuilder.append(f);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     k.b.a.v.g.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */