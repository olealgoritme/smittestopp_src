package k.e.a;

public final class o
{
  public final int a;
  public final String b;
  public final String c;
  public final String d;
  public final boolean e;
  
  public o(int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    a = paramInt;
    b = paramString1;
    c = paramString2;
    d = paramString3;
    e = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof o)) {
      return false;
    }
    paramObject = (o)paramObject;
    if ((a != a) || (e != e) || (!b.equals(b)) || (!c.equals(c)) || (!d.equals(d))) {
      bool = false;
    }
    return bool;
  }
  
  public int hashCode()
  {
    int i = a;
    int j;
    if (e) {
      j = 64;
    } else {
      j = 0;
    }
    int k = b.hashCode();
    int m = c.hashCode();
    return d.hashCode() * (m * k) + (i + j);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append('.');
    localStringBuilder.append(c);
    localStringBuilder.append(d);
    localStringBuilder.append(" (");
    localStringBuilder.append(a);
    String str;
    if (e) {
      str = " itf";
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.e.a.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */