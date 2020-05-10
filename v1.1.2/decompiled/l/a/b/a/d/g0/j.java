package l.a.b.a.d.g0;

import java.nio.ByteBuffer;
import l.a.b.a.b.l.c;
import l.a.b.a.b.n.h;
import l.a.b.a.b.n.l;
import l.a.b.a.c.k0;
import l.a.b.a.c.x;

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
      j -= i;
    } else {
      j = Integer.MAX_VALUE;
    }
    if (paramk0 == null) {
      i = 0;
    } else {
      i = paramk0.c();
    }
    i = Math.min(i, j);
    if (a.W())
    {
      p localp = a.U();
      Object localObject;
      if (e == 0)
      {
        if (paramk0 != null)
        {
          paramRunnable = paramk0.l();
          paramRunnable.b(i);
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
          paramRunnable.j().a((byte[])localObject);
          paramRunnable = new l.a.b.a.b.a((byte[])localObject);
        }
        else
        {
          localObject = paramRunnable.m();
          j = paramRunnable.k();
          paramRunnable = new l.a.b.a.b.a((byte[])localObject, paramRunnable.position() + j, paramRunnable.c());
        }
        if (paramObject == null) {
          paramObject = h.a;
        } else {
          paramObject = (l)paramObject;
        }
        paramObject = new l.a.b.a.e.a(paramInt, (l)paramObject, paramRunnable);
        localObject = a;
        paramRunnable = a0.F0;
        if (((a0)localObject).Y()) {
          ((a0)localObject).a(paramRunnable, a, b, c);
        }
        if (localp != null) {
          localp.a((l.a.b.a.e.a)paramObject);
        }
      }
      else
      {
        paramObject = (c)paramObject;
        localObject = a;
        paramRunnable = a0.F0;
        if (((a0)localObject).Y()) {
          ((a0)localObject).a(paramRunnable, 0, paramObject, null);
        }
        if (localp != null) {
          localp.c();
        }
      }
    }
    if (i > 0)
    {
      j = paramk0.a();
      paramk0.b(paramk0.position() + i);
      paramObject = c;
      if (paramObject != null)
      {
        i = paramk0.c();
        ((k)paramObject).b(i);
        if (paramk0.o())
        {
          paramRunnable = paramk0.m();
          int k = paramk0.k();
          System.arraycopy(paramRunnable, paramk0.position() + k, a, b, i);
          paramk0.a(paramk0.position() + i);
        }
        else
        {
          paramk0.a(a, b, i);
        }
        b += i;
        paramk0.b(j);
      }
      else
      {
        throw null;
      }
    }
    paramObject = c;
    j = b;
    i = g;
    ((k)paramObject).a(i);
    c.c(j - i);
    c.a((byte)2);
    c.a(e);
    c.a((short)paramInt);
    c.a(j);
    h += 1L;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.d.g0.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */