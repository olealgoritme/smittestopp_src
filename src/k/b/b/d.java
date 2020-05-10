package k.b.b;

import java.io.IOException;
import java.io.Serializable;
import k.b.a.l2.g;
import k.b.a.l2.k;
import k.b.a.n;

public class d
  implements Serializable
{
  public transient g x;
  public transient k y;
  
  public d(byte[] paramArrayOfByte) {}
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof d)) {
      return false;
    }
    paramObject = (d)paramObject;
    return x.equals(x);
  }
  
  public int hashCode()
  {
    return x.hashCode();
  }
}

/* Location:
 * Qualified Name:     base.k.b.b.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */