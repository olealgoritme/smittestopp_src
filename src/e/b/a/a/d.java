package e.b.a.a;

import e.b.a.a.q.f;
import java.io.Reader;
import java.io.Serializable;
import java.lang.ref.SoftReference;

public class d
  implements Serializable
{
  public static final int E = ;
  public static final int F = i.a.collectDefaults();
  public static final int G = f.a.collectDefaults();
  public static final n H = e.b.a.a.s.d.x;
  public int A;
  public int B;
  public int C;
  public n D;
  public final transient e.b.a.a.r.b x;
  public final transient e.b.a.a.r.a y;
  public m z;
  
  public d()
  {
    long l = System.currentTimeMillis();
    x = new e.b.a.a.r.b((int)l + (int)(l >>> 32) | 0x1);
    l = System.currentTimeMillis();
    y = new e.b.a.a.r.a(64, true, (int)l + (int)(l >>> 32) | 0x1, true);
    A = E;
    B = F;
    C = G;
    D = H;
    z = null;
  }
  
  public i a(Reader paramReader)
  {
    return new f(a(paramReader, false), B, paramReader, x.b(A));
  }
  
  public e.b.a.a.p.b a(Object paramObject, boolean paramBoolean)
  {
    Object localObject2;
    if (d.a.USE_THREAD_LOCAL_FOR_BUFFER_RECYCLING.enabledIn(A))
    {
      Object localObject1 = (SoftReference)e.b.a.a.s.b.a.get();
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = (e.b.a.a.s.a)((SoftReference)localObject1).get();
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new e.b.a.a.s.a();
        e.b.a.a.s.b.a.set(new SoftReference(localObject2));
      }
    }
    else
    {
      localObject2 = new e.b.a.a.s.a();
    }
    return new e.b.a.a.p.b((e.b.a.a.s.a)localObject2, paramObject, paramBoolean);
  }
}

/* Location:
 * Qualified Name:     base.e.b.a.a.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */