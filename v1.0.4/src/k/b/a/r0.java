package k.b.a;

import e.a.a.a.a;
import java.io.OutputStream;

public class r0
  extends b
{
  public r0(e parame)
  {
    super(parame.c().a("DER"), 0);
  }
  
  public r0(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte, 0);
  }
  
  public r0(byte[] paramArrayOfByte, int paramInt)
  {
    super(paramArrayOfByte, paramInt);
  }
  
  public static r0 a(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof r0)))
    {
      if ((paramObject instanceof n1))
      {
        paramObject = (n1)paramObject;
        return new r0(x, y);
      }
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = (r0)t.a((byte[])paramObject);
          return (r0)paramObject;
        }
        catch (Exception paramObject)
        {
          throw new IllegalArgumentException(a.a((Exception)paramObject, a.a("encoding error in getInstance: ")));
        }
      }
      throw new IllegalArgumentException(a.a(paramObject, a.a("illegal object in getInstance: ")));
    }
    return (r0)paramObject;
  }
  
  public static r0 a(b0 paramb0, boolean paramBoolean)
  {
    paramb0 = paramb0.j();
    if ((!paramBoolean) && (!(paramb0 instanceof r0)))
    {
      byte[] arrayOfByte = p.a(paramb0).j();
      if (arrayOfByte.length >= 1)
      {
        int i = arrayOfByte[0];
        int j = arrayOfByte.length - 1;
        paramb0 = new byte[j];
        if (j != 0) {
          System.arraycopy(arrayOfByte, 1, paramb0, 0, arrayOfByte.length - 1);
        }
        return new r0(paramb0, i);
      }
      throw new IllegalArgumentException("truncated BIT STRING detected");
    }
    return a(paramb0);
  }
  
  public void a(r paramr, boolean paramBoolean)
  {
    byte[] arrayOfByte = x;
    int i = arrayOfByte.length;
    if (i != 0)
    {
      int j = y;
      if (j != 0)
      {
        i--;
        if (arrayOfByte[i] != (byte)(arrayOfByte[i] & 255 << j))
        {
          int k = (byte)(arrayOfByte[i] & 255 << j);
          j = (byte)j;
          if (paramBoolean) {
            a.write(3);
          }
          paramr.a(i + 2);
          a.write(j);
          a.write(arrayOfByte, 0, i);
          a.write(k);
          return;
        }
      }
    }
    paramr.a(paramBoolean, 3, (byte)y, x);
  }
  
  public int f()
  {
    return d2.a(x.length + 1) + 1 + x.length + 1;
  }
  
  public boolean g()
  {
    return false;
  }
  
  public t h()
  {
    return this;
  }
  
  public t i()
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.r0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */