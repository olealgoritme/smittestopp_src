package k.a.b.a.d.g0;

import java.nio.ByteBuffer;
import k.a.b.a.b.l.c;
import k.a.b.a.b.n.h;
import k.a.b.a.b.n.l;
import k.a.b.a.c.k0;
import k.a.b.a.c.x;

public class j
{
  public final a0 a;
  public final x b;
  public final k c;
  public int d;
  public final byte e;
  public int f;
  public int g;
  public long h;
  
  public j(x paramx, int paramInt, byte paramByte, a0 parama0)
  {
    k localk = new k();
    c = localk;
    f = 65536;
    b = paramx;
    d = paramInt;
    e = ((byte)paramByte);
    a = parama0;
    a = localk;
  }
  
  public final int a(Object paramObject, k0 paramk0, Runnable paramRunnable)
  {
    c.a(g + 8);
    if (paramObject != null) {
      b.b(paramObject);
    }
    int i = c.b - g;
    int j = i;
    if (paramRunnable != null)
    {
      j = i;
      if (d > 0)
      {
        j = i;
        if (paramk0 != null)
        {
          j = i;
          if (paramk0.c() + i > d)
          {
            paramRunnable.run();
            j = a(paramObject, paramk0, null);
          }
        }
      }
    }
    return j;
  }
  
  public int a(ByteBuffer paramByteBuffer)
  {
    k localk = c;
    int i = Math.min(b, paramByteBuffer.remaining());
    if (i == 0)
    {
      i = 0;
    }
    else
    {
      if (paramByteBuffer.hasArray())
      {
        byte[] arrayOfByte1 = a;
        byte[] arrayOfByte2 = paramByteBuffer.array();
        j = paramByteBuffer.arrayOffset();
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, paramByteBuffer.position() + j, i);
        paramByteBuffer.position(paramByteBuffer.position() + i);
      }
      else
      {
        paramByteBuffer.put(a, 0, i);
      }
      int j = b;
      if (i != j)
      {
        j -= i;
        paramByteBuffer = a;
        System.arraycopy(paramByteBuffer, i, paramByteBuffer, 0, j);
        b = j;
      }
      else
      {
        b = 0;
      }
    }
    return i;
  }
  
  public void a(int paramInt, Object paramObject, k0 paramk0, Runnable paramRunnable)
  {
    g = c.b;
    int i = a(paramObject, paramk0, paramRunnable);
    int j = d;
    if (j > 0) {
      i = j - i;
    } else {
      i = Integer.MAX_VALUE;
    }
    if (paramk0 == null) {
      j = 0;
    } else {
      j = paramk0.c();
    }
    j = Math.min(j, i);
    if (a.X())
    {
      p localp = a.V();
      Object localObject;
      if (e == 0)
      {
        if (paramk0 != null)
        {
          paramRunnable = paramk0.i();
          paramRunnable.b(j);
        }
        else
        {
          paramRunnable = null;
        }
        if (paramRunnable == null)
        {
          paramRunnable = null;
        }
        else if (!paramRunnable.o())
        {
          localObject = new byte[paramRunnable.c()];
          paramRunnable.g().a((byte[])localObject);
          paramRunnable = new k.a.b.a.b.a((byte[])localObject);
        }
        else
        {
          localObject = paramRunnable.j();
          i = paramRunnable.h();
          paramRunnable = new k.a.b.a.b.a((byte[])localObject, paramRunnable.position() + i, paramRunnable.c());
        }
        if (paramObject == null) {
          paramObject = h.a;
        } else {
          paramObject = (l)paramObject;
        }
        localObject = new k.a.b.a.e.a(paramInt, (l)paramObject, paramRunnable);
        paramObject = a;
        paramRunnable = a0.F0;
        if (((a0)paramObject).Z()) {
          ((a0)paramObject).a(paramRunnable, a, b, c);
        }
        if (localp != null) {
          localp.a((k.a.b.a.e.a)localObject);
        }
      }
      else
      {
        paramObject = (c)paramObject;
        paramRunnable = a;
        localObject = a0.F0;
        if (paramRunnable.Z()) {
          paramRunnable.a((String)localObject, 0, paramObject, null);
        }
        if (localp != null) {
          localp.b();
        }
      }
    }
    if (j > 0)
    {
      i = paramk0.a();
      paramk0.b(paramk0.position() + j);
      paramRunnable = c;
      if (paramRunnable != null)
      {
        int k = paramk0.c();
        paramRunnable.c(k);
        if (paramk0.o())
        {
          paramObject = paramk0.j();
          j = paramk0.h();
          System.arraycopy(paramObject, paramk0.position() + j, a, b, k);
          paramk0.a(paramk0.position() + k);
        }
        else
        {
          paramk0.a(a, b, k);
        }
        b += k;
        paramk0.b(i);
      }
      else
      {
        throw null;
      }
    }
    paramObject = c;
    i = b;
    j = g;
    ((k)paramObject).a(j);
    c.b(i - j);
    c.a((byte)2);
    c.a(e);
    c.a((short)paramInt);
    c.a(i);
    h += 1L;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.d.g0.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */