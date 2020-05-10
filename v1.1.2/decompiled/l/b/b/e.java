package l.b.b;

import java.io.Serializable;
import l.b.a.l2.f;
import l.b.a.n;

public class e
  implements Serializable
{
  public transient f x;
  
  public e(byte[] paramArrayOfByte) {}
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof e)) {
      return false;
    }
    paramObject = (e)paramObject;
    return x.equals(x);
  }
  
  public int hashCode()
  {
    return x.hashCode();
  }
}

/* Location:
 * Qualified Name:     l.b.b.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */