package j.b.a;

import h.k.b.g;

public final class a
{
  public Integer a;
  public final long b;
  public final String c;
  public final int d;
  public final int e;
  public final boolean f;
  
  public a(long paramLong, String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
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
 * Qualified Name:     base.j.b.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */