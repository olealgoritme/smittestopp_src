package g.e;

import g.a.d.h;
import g.a.d.i;
import g.c.d.f;
import g.c.d.g;
import g.c.f;
import g.c.f.a;
import g.c.g;
import g.c.g.c;
import g.c.g.g;
import g.c.m.a.a;
import g.c.m.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

public class d
{
  public static final String[] a;
  public static final d.a b;
  
  static
  {
    Object localObject = da;
    d.f localf = d.f.SOLARIS;
    int i = 0;
    if (localObject == localf)
    {
      localObject = new String[3];
      localObject[0] = "socket";
      localObject[1] = "nsl";
      localObject[2] = d.g.a.a();
    }
    else
    {
      localObject = new String[1];
      localObject[0] = d.g.a.a();
    }
    a = (String[])localObject;
    localObject = (c)a.a.a;
    if (localObject != null)
    {
      g.c.m.b localb = new g.c.m.b((c)localObject, d.a.class);
      localObject = a;
      int j = localObject.length;
      while (i < j)
      {
        localf = localObject[i];
        b.add(localf);
        i++;
      }
      b = (d.a)localb.a();
      return;
    }
    throw null;
  }
  
  public static int a(int paramInt1, h paramh, int paramInt2)
  {
    if ((paramInt2 != i.SO_RCVTIMEO.intValue()) && (paramInt2 != i.SO_SNDTIMEO.intValue()))
    {
      localObject1 = ByteBuffer.allocate(4);
      ((ByteBuffer)localObject1).order(ByteOrder.nativeOrder());
      localObject2 = new g.c.k.a(4);
      b.a(paramInt1, paramh.intValue(), paramInt2, (ByteBuffer)localObject1, (g.c.k.a)localObject2);
      return ((ByteBuffer)localObject1).getInt();
    }
    Object localObject2 = new g.d.a(f.a.a);
    Object localObject1 = new g.c.k.a(a.b());
    b.a(paramInt1, paramh.intValue(), paramInt2, (g.d.b)localObject2, (g.c.k.a)localObject1);
    c.b();
    throw null;
  }
  
  public static int a(int paramInt1, h paramh, i parami, int paramInt2)
  {
    if ((parami != i.SO_RCVTIMEO) && (parami != i.SO_SNDTIMEO))
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate(4);
      localByteBuffer.order(ByteOrder.nativeOrder());
      localByteBuffer.putInt(paramInt2).flip();
      return b.a(paramInt1, paramh.intValue(), parami.intValue(), localByteBuffer, localByteBuffer.remaining());
    }
    paramh = new g.d.a(f.a.a);
    long l1 = paramInt2 / 1000;
    long l2 = paramInt2;
    c.a(new long[] { l1, l2 % 1000L * 1000L }[0]);
    throw null;
  }
  
  public static int a(int paramInt, h paramh, i parami, g paramg)
  {
    a.a(0);
    new g.c.k.a(a.b());
    throw null;
  }
  
  public static String a()
  {
    int i = f.a.a.a();
    return b.a(i);
  }
}

/* Location:
 * Qualified Name:     base.g.e.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */