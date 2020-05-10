package k.a.b.a.d.g0;

import java.util.List;
import java.util.Map;
import k.a.b.a.b.h;
import k.a.b.a.c.l;
import k.a.b.a.d.t;

public class q
  extends m
  implements t
{
  public boolean Z = true;
  public i0 a0;
  public int b0;
  
  public q(y paramy, String paramString)
  {
    super(paramy, paramString);
  }
  
  public e0 V()
  {
    return a0;
  }
  
  public void a(int paramInt)
  {
    R += paramInt;
    b0 += paramInt;
    c(true);
    if (!Z)
    {
      X = false;
      c(true);
      Z = true;
      Z = false;
    }
  }
  
  public int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    e locale = K;
    if (locale != null)
    {
      l locall = T;
      if ((locall != null) && (locall.b()))
      {
        paramInt2 = Math.min(paramInt2, T.c());
        T.a(paramArrayOfByte, paramInt1, paramInt2);
        T.n();
        paramInt1 = paramInt2;
      }
      else
      {
        paramInt1 = 0;
      }
      paramInt2 = paramInt1;
      if (Q)
      {
        paramInt2 = paramInt1;
        if (paramInt1 == 0) {
          paramInt2 = -1;
        }
      }
      if (paramInt2 > 0)
      {
        H.b(-paramInt2);
        if (H.L.g.equals(h.z)) {
          c(true);
        }
      }
      return paramInt2;
    }
    throw new IllegalStateException("no current delivery");
  }
  
  public boolean d()
  {
    Object localObject = K;
    if (localObject != null) {
      S = true;
    }
    boolean bool = super.d();
    if (bool)
    {
      Q -= 1;
      R -= 1;
      H.b(-((e)localObject).pending());
      localObject = H;
      P -= 1;
      if (L.g.equals(h.z)) {
        c(true);
      }
    }
    return bool;
  }
  
  public void n()
  {
    y localy = H;
    if (localy != null)
    {
      String str = L;
      if (equals((q)J.get(str))) {
        J.remove(str);
      } else {
        K.remove(this);
      }
      super.n();
      return;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.d.g0.q
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */