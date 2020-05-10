package d.t.a;

public class a$b
{
  public int a;
  public int b;
  public Object c;
  public int d;
  
  public a$b(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    a = paramInt1;
    b = paramInt2;
    d = paramInt3;
    c = paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (b.class == paramObject.getClass()))
    {
      paramObject = (b)paramObject;
      int i = a;
      if (i != a) {
        return false;
      }
      if ((i == 8) && (Math.abs(d - b) == 1) && (d == b) && (b == d)) {
        return true;
      }
      if (d != d) {
        return false;
      }
      if (b != b) {
        return false;
      }
      Object localObject = c;
      if (localObject != null)
      {
        if (!localObject.equals(c)) {
          return false;
        }
      }
      else if (c != null) {
        return false;
      }
      return true;
    }
    return false;
  }
  
  public int hashCode()
  {
    return (a * 31 + b) * 31 + d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append("[");
    int i = a;
    String str;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i != 8) {
            str = "??";
          } else {
            str = "mv";
          }
        }
        else {
          str = "up";
        }
      }
      else {
        str = "rm";
      }
    }
    else {
      str = "add";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(",s:");
    localStringBuilder.append(b);
    localStringBuilder.append("c:");
    localStringBuilder.append(d);
    localStringBuilder.append(",p:");
    localStringBuilder.append(c);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */