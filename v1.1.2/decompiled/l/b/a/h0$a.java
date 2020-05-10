package l.b.a;

import java.util.Enumeration;

public class h0$a
  implements Enumeration
{
  public int a = 0;
  
  public h0$a(h0 paramh0) {}
  
  public boolean hasMoreElements()
  {
    boolean bool;
    if (a < b.z.length) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Object nextElement()
  {
    p[] arrayOfp = b.z;
    int i = a;
    a = (i + 1);
    return arrayOfp[i];
  }
}

/* Location:
 * Qualified Name:     l.b.a.h0.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */