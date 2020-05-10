package h.e;

import h.a.d.h;
import h.a.d.i;
import h.c.d.f;
import h.c.d.g;
import h.c.f;
import h.c.f.a;
import h.c.g;
import h.c.g.c;
import h.c.g.g;
import h.c.m.a.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

public class d
{
  public static final String[] a;
  public static final a b;
  
  static
  {
    Object localObject1 = da;
    Object localObject2 = d.f.SOLARIS;
    int i = 0;
    if (localObject1 == localObject2)
    {
      localObject2 = new String[3];
      localObject2[0] = "socket";
      localObject2[1] = "nsl";
      localObject2[2] = d.g.a.a();
    }
    else
    {
      localObject2 = new String[1];
      localObject2[0] = d.g.a.a();
    }
    a = (String[])localObject2;
    localObject2 = (h.c.m.c)a.a.a;
    if (localObject2 != null)
    {
      h.c.m.b localb = new h.c.m.b((h.c.m.c)localObject2, a.class);
      localObject1 = a;
      int j = localObject1.length;
      while (i < j)
      {
        localObject2 = localObject1[i];
        b.add(localObject2);
        i++;
      }
      b = (a)localb.a();
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
      localObject2 = new h.c.k.a(4);
      b.a(paramInt1, paramh.intValue(), paramInt2, (ByteBuffer)localObject1, (h.c.k.a)localObject2);
      return ((ByteBuffer)localObject1).getInt();
    }
    Object localObject2 = new h.d.a(f.a.a);
    Object localObject1 = new h.c.k.a(a.b());
    b.a(paramInt1, paramh.intValue(), paramInt2, (h.d.b)localObject2, (h.c.k.a)localObject1);
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
    paramh = new h.d.a(f.a.a);
    long l1 = paramInt2 / 1000;
    long l2 = paramInt2;
    c.a(new long[] { l1, l2 % 1000L * 1000L }[0]);
    throw null;
  }
  
  public static int a(int paramInt, h paramh, i parami, g paramg)
  {
    a.a(0);
    new h.c.k.a(a.b());
    throw null;
  }
  
  public static String a()
  {
    int i = f.a.a.a();
    return b.a(i);
  }
  
  public static abstract interface a
  {
    static
    {
      h.a.d.c.F_GETFL.intValue();
      h.a.d.c.F_SETFL.intValue();
      h.a.d.d.O_NONBLOCK.intValue();
    }
    
    public abstract int a(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract int a(int paramInt1, int paramInt2, int paramInt3, h.d.b paramb, h.c.k.a parama);
    
    public abstract int a(int paramInt1, int paramInt2, int paramInt3, ByteBuffer paramByteBuffer, int paramInt4);
    
    public abstract int a(int paramInt1, int paramInt2, int paramInt3, ByteBuffer paramByteBuffer, h.c.k.a parama);
    
    public abstract int a(int paramInt1, e parame, int paramInt2);
    
    public abstract int a(int paramInt, e parame, h.c.k.a parama);
    
    public abstract String a(int paramInt);
    
    public abstract int b(int paramInt1, e parame, int paramInt2);
    
    public abstract int b(int paramInt, e parame, h.c.k.a parama);
  }
}

/* Location:
 * Qualified Name:     h.e.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */