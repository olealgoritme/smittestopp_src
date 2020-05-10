package i.l;

public final class c
  extends a
  implements Object<Integer>
{
  public static final c A = new c(1, 0);
  public static final c B;
  
  public c(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2, 1);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof c)) {
      if ((!isEmpty()) || (!((c)paramObject).isEmpty()))
      {
        int i = x;
        paramObject = (c)paramObject;
        if ((i != x) || (y != y)) {}
      }
      else
      {
        return true;
      }
    }
    boolean bool = false;
    return bool;
  }
  
  public int hashCode()
  {
    int i;
    if (isEmpty()) {
      i = -1;
    } else {
      i = x * 31 + y;
    }
    return i;
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (x > y) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(x);
    localStringBuilder.append("..");
    localStringBuilder.append(y);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     i.l.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */