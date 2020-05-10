package k.b.f.b;

import java.util.Arrays;
import k.b.c.e.a;

public class c
{
  public final int[] a;
  
  public c(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      paramArrayOfInt = null;
    } else {
      paramArrayOfInt = (int[])paramArrayOfInt.clone();
    }
    a = paramArrayOfInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof c)) {
      return false;
    }
    paramObject = (c)paramObject;
    return Arrays.equals(a, a);
  }
  
  public int hashCode()
  {
    return a.b(a);
  }
}

/* Location:
 * Qualified Name:     base.k.b.f.b.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */