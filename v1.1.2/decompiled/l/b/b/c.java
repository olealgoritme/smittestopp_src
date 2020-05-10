package l.b.b;

import java.io.Serializable;
import l.b.a.l2.d;
import l.b.a.n;

public class c
  implements Serializable
{
  public transient d x;
  
  public c(byte[] paramArrayOfByte) {}
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof c)) {
      return false;
    }
    paramObject = (c)paramObject;
    return x.equals(x);
  }
  
  public int hashCode()
  {
    return x.hashCode();
  }
}

/* Location:
 * Qualified Name:     l.b.b.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */