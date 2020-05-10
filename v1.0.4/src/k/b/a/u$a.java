package k.b.a;

import java.util.Enumeration;
import java.util.NoSuchElementException;

public class u$a
  implements Enumeration
{
  public int a = 0;
  
  public u$a(u paramu) {}
  
  public boolean hasMoreElements()
  {
    boolean bool;
    if (a < b.x.length) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Object nextElement()
  {
    int i = a;
    e[] arrayOfe = b.x;
    if (i < arrayOfe.length)
    {
      a = (i + 1);
      return arrayOfe[i];
    }
    throw new NoSuchElementException("ASN1Sequence Enumeration");
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.u.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */