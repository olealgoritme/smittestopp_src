package k.a.b.a.d.g0;

import e.a.a.a.a;
import k.a.b.a.d.c;
import k.a.b.a.d.c0;
import k.a.b.a.d.e;
import k.a.b.a.d.h.b;
import k.a.b.a.d.i;
import k.a.b.a.d.l;
import k.a.b.a.d.n;
import k.a.b.a.d.t;
import k.a.b.a.d.u;
import k.a.b.a.d.x;
import k.a.b.a.d.y;
import k.a.b.a.g.d;

public class g
  implements k.a.b.a.d.h
{
  public r A = new r();
  public l B = null;
  public i x = null;
  public Object y;
  public g z;
  
  public n G()
  {
    Object localObject = y;
    if ((localObject instanceof n)) {
      return (n)localObject;
    }
    localObject = h();
    if (localObject == null) {
      return null;
    }
    return ((e)localObject).G();
  }
  
  public y T()
  {
    Object localObject = y;
    if ((localObject instanceof y)) {
      return (y)localObject;
    }
    localObject = G();
    if (localObject == null) {
      return null;
    }
    return ((n)localObject).T();
  }
  
  public c U()
  {
    Object localObject = y;
    if ((localObject instanceof c)) {
      return (c)localObject;
    }
    if ((localObject instanceof c0))
    {
      localObject = l();
      if (localObject == null) {
        return null;
      }
      return J;
    }
    localObject = T();
    if (localObject == null) {
      return null;
    }
    return ((y)localObject).U();
  }
  
  /* Error */
  public void a(l paraml)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 27	k/a/b/a/d/g0/g:B	Lk/a/b/a/d/l;
    //   4: astore_2
    //   5: aload_0
    //   6: aload_1
    //   7: putfield 27	k/a/b/a/d/g0/g:B	Lk/a/b/a/d/l;
    //   10: aload_1
    //   11: aload_0
    //   12: invokeinterface 82 2 0
    //   17: aload_0
    //   18: getfield 27	k/a/b/a/d/g0/g:B	Lk/a/b/a/d/l;
    //   21: astore_1
    //   22: aload_1
    //   23: ifnonnull +6 -> 29
    //   26: goto +40 -> 66
    //   29: aload_1
    //   30: invokeinterface 86 1 0
    //   35: astore_1
    //   36: aload_0
    //   37: aconst_null
    //   38: putfield 27	k/a/b/a/d/g0/g:B	Lk/a/b/a/d/l;
    //   41: aload_1
    //   42: invokeinterface 92 1 0
    //   47: ifeq +19 -> 66
    //   50: aload_0
    //   51: aload_1
    //   52: invokeinterface 96 1 0
    //   57: checkcast 78	k/a/b/a/d/l
    //   60: invokevirtual 98	k/a/b/a/d/g0/g:a	(Lk/a/b/a/d/l;)V
    //   63: goto -22 -> 41
    //   66: aload_0
    //   67: aload_2
    //   68: putfield 27	k/a/b/a/d/g0/g:B	Lk/a/b/a/d/l;
    //   71: return
    //   72: astore_3
    //   73: new 74	k/a/b/a/d/m
    //   76: astore 4
    //   78: aload 4
    //   80: aload_1
    //   81: aload_3
    //   82: invokespecial 101	k/a/b/a/d/m:<init>	(Lk/a/b/a/d/l;Ljava/lang/Throwable;)V
    //   85: aload 4
    //   87: athrow
    //   88: astore_1
    //   89: aload_1
    //   90: athrow
    //   91: astore_1
    //   92: aload_0
    //   93: aload_2
    //   94: putfield 27	k/a/b/a/d/g0/g:B	Lk/a/b/a/d/l;
    //   97: aload_1
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	g
    //   0	99	1	paraml	l
    //   4	90	2	locall	l
    //   72	10	3	localRuntimeException	RuntimeException
    //   76	10	4	localm	k.a.b.a.d.m
    // Exception table:
    //   from	to	target	type
    //   10	17	72	java/lang/RuntimeException
    //   10	17	88	k/a/b/a/d/m
    //   5	10	91	finally
    //   10	17	91	finally
    //   17	22	91	finally
    //   29	41	91	finally
    //   41	63	91	finally
    //   73	88	91	finally
    //   89	91	91	finally
  }
  
  public d b()
  {
    Object localObject = y;
    if ((localObject instanceof d)) {
      return (d)localObject;
    }
    if ((localObject instanceof k.a.b.a.g.h)) {
      return ((k.a.b.a.g.h)localObject).b();
    }
    if ((localObject instanceof c0)) {
      return w0;
    }
    if ((localObject instanceof e)) {
      return ((e)localObject).G().T().U().b();
    }
    if ((localObject instanceof n)) {
      return ((n)localObject).T().U().b();
    }
    if ((localObject instanceof y)) {
      return ((y)localObject).U().b();
    }
    if ((localObject instanceof c)) {
      return ((c)localObject).b();
    }
    if ((localObject instanceof k.a.b.a.g.g)) {
      return ((k.a.b.a.g.g)localObject).b();
    }
    return null;
  }
  
  public e h()
  {
    Object localObject = y;
    if ((localObject instanceof e)) {
      return (e)localObject;
    }
    return null;
  }
  
  public t i()
  {
    Object localObject = y;
    if ((localObject instanceof t)) {
      return (t)localObject;
    }
    localObject = G();
    if ((localObject instanceof t)) {
      return (t)localObject;
    }
    return null;
  }
  
  public c0 l()
  {
    Object localObject = y;
    if ((localObject instanceof c0)) {
      return (c0)localObject;
    }
    if ((localObject instanceof c)) {
      return ((c)localObject).l();
    }
    localObject = T();
    if (localObject == null) {
      return null;
    }
    localObject = ((y)localObject).U();
    if (localObject == null) {
      return null;
    }
    return ((c)localObject).l();
  }
  
  public k.a.b.a.g.g n()
  {
    Object localObject = y;
    if ((localObject instanceof k.a.b.a.g.g)) {
      return (k.a.b.a.g.g)localObject;
    }
    return null;
  }
  
  public x o()
  {
    Object localObject = y;
    if ((localObject instanceof x)) {
      return (x)localObject;
    }
    localObject = G();
    if ((localObject instanceof x)) {
      return (x)localObject;
    }
    return null;
  }
  
  public u q()
  {
    return A;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("EventImpl{type=");
    localStringBuilder.append(x);
    localStringBuilder.append(", context=");
    localStringBuilder.append(y);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public h.b w()
  {
    i locali = x;
    if ((locali instanceof h.b)) {
      return (h.b)locali;
    }
    return h.b.NON_CORE_EVENT;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.d.g0.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */