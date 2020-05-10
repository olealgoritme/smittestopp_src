package k.a.b.a.d.g0;

import java.util.List;
import java.util.Map;
import k.a.b.a.c.l;
import k.a.b.a.d.g;

public class x
  extends m
  implements k.a.b.a.d.x
{
  public int Z;
  public j0 a0;
  
  public x(y paramy, String paramString)
  {
    super(paramy, paramString);
  }
  
  public e0 V()
  {
    return a0;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (x != g.CLOSED)
    {
      e locale = K;
      if ((locale != null) && (H == this))
      {
        byte[] arrayOfByte = new byte[paramInt2];
        System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
        if (T == null)
        {
          paramArrayOfByte = new l();
          T = paramArrayOfByte;
          U = paramArrayOfByte;
        }
        T.b(arrayOfByte);
        locale.h();
        if (paramInt2 > 0)
        {
          paramArrayOfByte = H;
          O += paramInt2;
        }
        return paramInt2;
      }
      throw new IllegalArgumentException();
    }
    throw new IllegalStateException("send not allowed after the sender is closed.");
  }
  
  public void b(int paramInt)
  {
    R = paramInt;
  }
  
  public boolean d()
  {
    Object localObject = K;
    if (localObject != null) {
      Q = true;
    }
    boolean bool = super.d();
    if (bool)
    {
      int i = Z;
      if (i > 0) {
        Z = (i - 1);
      }
    }
    if (bool)
    {
      R -= 1;
      ((e)localObject).h();
      localObject = H;
      Q += 1;
    }
    return bool;
  }
  
  public void n()
  {
    y localy = H;
    if (localy != null)
    {
      String str = L;
      if (equals((x)I.get(str))) {
        I.remove(str);
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
 * Qualified Name:     base.k.a.b.a.d.g0.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */