package k.b.a;

import java.util.Enumeration;
import java.util.NoSuchElementException;

public class w
  implements Enumeration
{
  public int a = 0;
  
  public w(x paramx) {}
  
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
    throw new NoSuchElementException("ASN1Set Enumeration");
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */