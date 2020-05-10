package k.b.b;

import java.io.Serializable;
import k.b.a.l2.f;
import k.b.a.n;

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
 * Qualified Name:     base.k.b.b.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */