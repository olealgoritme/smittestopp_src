package l.b.a;

import e.a.a.a.a;
import java.io.OutputStream;
import java.util.Enumeration;

public class n0
  extends b0
{
  public n0(int paramInt, e parame)
  {
    super(true, paramInt, parame);
  }
  
  public n0(boolean paramBoolean, int paramInt, e parame)
  {
    super(paramBoolean, paramInt, parame);
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    paramr.a(paramBoolean, 160, x);
    a.write(128);
    if (!y)
    {
      Object localObject = z;
      if ((localObject instanceof p))
      {
        if ((localObject instanceof h0)) {
          localObject = ((h0)localObject).k();
        } else {
          localObject = new h0(((p)localObject).j()).k();
        }
      }
      else if ((localObject instanceof u))
      {
        localObject = ((u)localObject).j();
      }
      else
      {
        if (!(localObject instanceof x)) {
          break label133;
        }
        localObject = (x)localObject;
        if (localObject == null) {
          break label131;
        }
        localObject = new w((x)localObject);
      }
      paramr.a((Enumeration)localObject);
      break label180;
      label131:
      throw null;
      label133:
      paramr = a.a("not implemented: ");
      paramr.append(z.getClass().getName());
      throw new h(paramr.toString());
    }
    else
    {
      paramr.a(z.b(), true);
    }
    label180:
    a.write(0);
    a.write(0);
  }
  
  public int f()
  {
    int i = z.b().f();
    if (y)
    {
      int j = d2.b(x);
      return d2.a(i) + j + i;
    }
    return d2.b(x) + (i - 1);
  }
  
  public boolean g()
  {
    boolean bool;
    if ((!y) && (!z.b().g())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     l.b.a.n0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */