package k.b.a.v.f;

import i.k.b.g;

public final class e
{
  public Integer a;
  public final long b;
  public final Double c;
  public final Double d;
  public final Double e;
  public final Double f;
  public final Double g;
  public final Double h;
  public final Double i;
  public final boolean j;
  
  public e(long paramLong, Double paramDouble1, Double paramDouble2, Double paramDouble3, Double paramDouble4, Double paramDouble5, Double paramDouble6, Double paramDouble7, boolean paramBoolean)
  {
    b = paramLong;
    c = paramDouble1;
    d = paramDouble2;
    e = paramDouble3;
    f = paramDouble4;
    g = paramDouble5;
    h = paramDouble6;
    i = paramDouble7;
    j = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
        if ((b == b) && (g.a(c, c)) && (g.a(d, d)) && (g.a(e, e)) && (g.a(f, f)) && (g.a(g, g)) && (g.a(h, h)) && (g.a(i, i)) && (j == j)) {}
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
    int k = a.a(b);
    Double localDouble = c;
    int m = 0;
    int n;
    if (localDouble != null) {
      n = localDouble.hashCode();
    } else {
      n = 0;
    }
    localDouble = d;
    int i1;
    if (localDouble != null) {
      i1 = localDouble.hashCode();
    } else {
      i1 = 0;
    }
    localDouble = e;
    int i2;
    if (localDouble != null) {
      i2 = localDouble.hashCode();
    } else {
      i2 = 0;
    }
    localDouble = f;
    int i3;
    if (localDouble != null) {
      i3 = localDouble.hashCode();
    } else {
      i3 = 0;
    }
    localDouble = g;
    int i4;
    if (localDouble != null) {
      i4 = localDouble.hashCode();
    } else {
      i4 = 0;
    }
    localDouble = h;
    int i5;
    if (localDouble != null) {
      i5 = localDouble.hashCode();
    } else {
      i5 = 0;
    }
    localDouble = i;
    if (localDouble != null) {
      m = localDouble.hashCode();
    }
    int i6 = j;
    int i7 = i6;
    if (i6 != 0) {
      i7 = 1;
    }
    return (((((((k * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + m) * 31 + i7;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("Measurement(timestamp=");
    localStringBuilder.append(b);
    localStringBuilder.append(", latitude=");
    localStringBuilder.append(c);
    localStringBuilder.append(", longitude=");
    localStringBuilder.append(d);
    localStringBuilder.append(", latLongAccuracy=");
    localStringBuilder.append(e);
    localStringBuilder.append(", altitude=");
    localStringBuilder.append(f);
    localStringBuilder.append(", altitudeAccuracy=");
    localStringBuilder.append(g);
    localStringBuilder.append(", speed=");
    localStringBuilder.append(h);
    localStringBuilder.append(", speedAccuracy=");
    localStringBuilder.append(i);
    localStringBuilder.append(", isUploaded=");
    localStringBuilder.append(j);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     k.b.a.v.f.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */