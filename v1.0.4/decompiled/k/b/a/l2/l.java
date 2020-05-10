package k.b.a.l2;

import e.a.a.a.a;
import java.io.IOException;
import k.b.a.b0;
import k.b.a.d;
import k.b.a.e;
import k.b.a.h1;
import k.b.a.k2.c;
import k.b.a.n;
import k.b.a.o;
import k.b.a.p;
import k.b.a.t;
import k.b.a.u;
import k.b.a.x0;

public class l
  extends n
  implements d
{
  public e x;
  public int y;
  
  public l(int paramInt, e parame)
  {
    x = parame;
    y = paramInt;
  }
  
  public static l a(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof l)))
    {
      if ((paramObject instanceof b0))
      {
        paramObject = (b0)paramObject;
        int i = x;
        switch (i)
        {
        default: 
          throw new IllegalArgumentException(a.a("unknown tag: ", i));
        case 8: 
          return new l(i, o.a((b0)paramObject, false));
        case 7: 
          return new l(i, p.a((b0)paramObject, false));
        case 4: 
          return new l(i, c.a((b0)paramObject));
        case 1: 
        case 2: 
        case 6: 
          paramObject = ((b0)paramObject).j();
          if ((paramObject instanceof x0)) {
            paramObject = x0.a(paramObject);
          } else {
            paramObject = new x0(p.a(paramObject).j());
          }
          return new l(i, (e)paramObject);
        }
        return new l(i, u.a((b0)paramObject, false));
      }
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = a(t.a((byte[])paramObject));
          return (l)paramObject;
        }
        catch (IOException paramObject)
        {
          throw new IllegalArgumentException("unable to parse encoded general name");
        }
      }
      throw new IllegalArgumentException(a.a(paramObject, a.a("unknown object in getInstance: ")));
    }
    return (l)paramObject;
  }
  
  public t c()
  {
    boolean bool;
    if (y == 4) {
      bool = true;
    } else {
      bool = false;
    }
    return new h1(bool, y, x);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(y);
    localStringBuffer.append(": ");
    int i = y;
    if ((i != 1) && (i != 2)) {
      if (i != 4)
      {
        if (i != 6)
        {
          str = x.toString();
          break label86;
        }
      }
      else
      {
        str = c.a(x).toString();
        break label86;
      }
    }
    String str = x0.a(x).d();
    label86:
    localStringBuffer.append(str);
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.l2.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */