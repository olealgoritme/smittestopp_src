package d.s;

import e.a.a.a.a;

public final class d
{
  public final o a;
  public final boolean b;
  public final boolean c;
  public final Object d;
  
  public d(o<?> paramo, boolean paramBoolean1, Object paramObject, boolean paramBoolean2)
  {
    if ((!a) && (paramBoolean1))
    {
      paramObject = new StringBuilder();
      ((StringBuilder)paramObject).append(paramo.a());
      ((StringBuilder)paramObject).append(" does not allow nullable values");
      throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
    }
    if ((!paramBoolean1) && (paramBoolean2) && (paramObject == null))
    {
      paramObject = a.a("Argument with type ");
      ((StringBuilder)paramObject).append(paramo.a());
      ((StringBuilder)paramObject).append(" has null value but is not nullable.");
      throw new IllegalArgumentException(((StringBuilder)paramObject).toString());
    }
    a = paramo;
    b = paramBoolean1;
    d = paramObject;
    c = paramBoolean2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (d.class == paramObject.getClass()))
    {
      Object localObject = (d)paramObject;
      if (b != b) {
        return false;
      }
      if (c != c) {
        return false;
      }
      if (!a.equals(a)) {
        return false;
      }
      paramObject = d;
      localObject = d;
      if (paramObject != null) {
        bool = paramObject.equals(localObject);
      } else if (localObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = a.hashCode();
    int j = b;
    int k = c;
    Object localObject = d;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
}

/* Location:
 * Qualified Name:     d.s.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */