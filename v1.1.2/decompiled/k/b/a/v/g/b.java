package k.b.a.v.g;

import e.c.a.a.b.l.c;
import i.k.b.g;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import k.b.a.t;
import k.b.a.v.e.i;
import k.b.a.v.f.e;
import org.json.JSONObject;

public final class b
{
  public Long a;
  public long b;
  public long c;
  public final long d;
  public final Double e;
  public final Double f;
  public final Double g;
  public final Double h;
  public final Double i;
  public final Double j;
  public final Double k;
  public final boolean l;
  
  public b(long paramLong, Double paramDouble1, Double paramDouble2, Double paramDouble3, Double paramDouble4, Double paramDouble5, Double paramDouble6, Double paramDouble7, boolean paramBoolean)
  {
    d = paramLong;
    e = paramDouble1;
    f = paramDouble2;
    g = paramDouble3;
    h = paramDouble4;
    i = paramDouble5;
    j = paramDouble6;
    k = paramDouble7;
    l = paramBoolean;
    b = paramLong;
    c = paramLong;
  }
  
  public static final List<b> a(List<e> paramList)
  {
    if (paramList != null)
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList(c.a(paramList, 10));
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (locale != null)
        {
          b localb = new b(b, c, d, e, f, g, h, i, j);
          paramList = a;
          if (paramList != null) {
            paramList = Long.valueOf(paramList.intValue());
          } else {
            paramList = null;
          }
          a = paramList;
          long l1 = b;
          b = l1;
          c = l1;
          localArrayList2.add(Boolean.valueOf(localArrayList1.add(localb)));
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
  
  public static final i a(b paramb)
  {
    if (paramb != null) {
      return new i(null, Long.valueOf(d), e, f, g, h, i, j, k, Boolean.valueOf(l));
    }
    g.a("measurement");
    throw null;
  }
  
  public static final List<b> b(List<? extends i> paramList)
  {
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = new ArrayList(c.a(paramList, 10));
      Iterator localIterator = paramList.iterator();
      paramList = (List<? extends i>)localObject1;
      while (localIterator.hasNext())
      {
        localObject1 = (i)localIterator.next();
        if (localObject1 != null)
        {
          Object localObject2 = b;
          g.a(localObject2, "entity.timestamp");
          long l1 = ((Long)localObject2).longValue();
          Double localDouble1 = c;
          Double localDouble2 = d;
          Double localDouble3 = e;
          localObject2 = f;
          Object localObject3 = g;
          Double localDouble4 = h;
          Double localDouble5 = i;
          Boolean localBoolean = j;
          g.a(localBoolean, "entity.isUploaded");
          localObject2 = new b(l1, localDouble1, localDouble2, localDouble3, (Double)localObject2, (Double)localObject3, localDouble4, localDouble5, localBoolean.booleanValue());
          a = a;
          localObject3 = b;
          g.a(localObject3, "entity.timestamp");
          b = ((Long)localObject3).longValue();
          localObject1 = b;
          g.a(localObject1, "entity.timestamp");
          c = ((Long)localObject1).longValue();
          paramList.add(Boolean.valueOf(localArrayList.add(localObject2)));
        }
        else
        {
          g.a("entity");
          throw null;
        }
      }
      return localArrayList;
    }
    g.a("measurements");
    throw null;
  }
  
  public final JSONObject a()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("timeFrom", localSimpleDateFormat.format(Long.valueOf(t.a(b))));
    localJSONObject.put("timeTo", localSimpleDateFormat.format(Long.valueOf(t.a(c))));
    localJSONObject.put("latitude", e);
    localJSONObject.put("longitude", f);
    localJSONObject.put("accuracy", g);
    localJSONObject.put("altitude", h);
    localJSONObject.put("altitudeAccuracy", i);
    localJSONObject.put("speed", j);
    localJSONObject.put("speedAccuracy", k);
    return localJSONObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((d == d) && (g.a(e, e)) && (g.a(f, f)) && (g.a(g, g)) && (g.a(h, h)) && (g.a(i, i)) && (g.a(j, j)) && (g.a(k, k)) && (l == l)) {}
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
    int m = a.a(d);
    Double localDouble = e;
    int n = 0;
    int i1;
    if (localDouble != null) {
      i1 = localDouble.hashCode();
    } else {
      i1 = 0;
    }
    localDouble = f;
    int i2;
    if (localDouble != null) {
      i2 = localDouble.hashCode();
    } else {
      i2 = 0;
    }
    localDouble = g;
    int i3;
    if (localDouble != null) {
      i3 = localDouble.hashCode();
    } else {
      i3 = 0;
    }
    localDouble = h;
    int i4;
    if (localDouble != null) {
      i4 = localDouble.hashCode();
    } else {
      i4 = 0;
    }
    localDouble = i;
    int i5;
    if (localDouble != null) {
      i5 = localDouble.hashCode();
    } else {
      i5 = 0;
    }
    localDouble = j;
    int i6;
    if (localDouble != null) {
      i6 = localDouble.hashCode();
    } else {
      i6 = 0;
    }
    localDouble = k;
    if (localDouble != null) {
      n = localDouble.hashCode();
    }
    int i7 = l;
    int i8 = i7;
    if (i7 != 0) {
      i8 = 1;
    }
    return (((((((m * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + n) * 31 + i8;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("Measurement(timestamp=");
    localStringBuilder.append(d);
    localStringBuilder.append(", latitude=");
    localStringBuilder.append(e);
    localStringBuilder.append(", longitude=");
    localStringBuilder.append(f);
    localStringBuilder.append(", latLongAccuracy=");
    localStringBuilder.append(g);
    localStringBuilder.append(", altitude=");
    localStringBuilder.append(h);
    localStringBuilder.append(", altitudeAccuracy=");
    localStringBuilder.append(i);
    localStringBuilder.append(", speed=");
    localStringBuilder.append(j);
    localStringBuilder.append(", speedAccuracy=");
    localStringBuilder.append(k);
    localStringBuilder.append(", isUploaded=");
    localStringBuilder.append(l);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     k.b.a.v.g.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */