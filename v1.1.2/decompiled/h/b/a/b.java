package h.b.a;

import h.c.f;
import h.c.f.a;
import h.c.h.a;
import h.c.h.e;
import h.c.h.g;
import h.c.h.i;
import h.c.i;
import h.c.j;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.AbstractSelectionKey;
import java.nio.channels.spi.AbstractSelector;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class b
  extends AbstractSelector
{
  public final int[] A = { -1, -1 };
  public final Object B = new Object();
  public final Map<Integer, b> C = new ConcurrentHashMap();
  public final Set<SelectionKey> D = new LinkedHashSet();
  public final e E;
  public int x = -1;
  public final f y = f.a.a;
  public final c z = c.c;
  
  public b(h paramh)
  {
    super(paramh);
    new e(0L, 0L);
    throw null;
  }
  
  public final int a()
  {
    synchronized (cancelledKeys())
    {
      synchronized (B)
      {
        Iterator localIterator = ???.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          b localb = (b)C.get(Integer.valueOf(locala.a()));
          deregister(locala);
          synchronized (D)
          {
            D.remove(locala);
            b.remove(locala);
            if (!b.isEmpty())
            {
              if (100 >= 0) {
                d.a.a(x, null, 0, null, 0, E);
              }
            }
            else
            {
              z.a(null, 0, locala.a(), -1, 2);
              throw null;
            }
          }
        }
        ???.clear();
        return 0;
      }
    }
  }
  
  /* Error */
  public final int a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 148	h/b/a/b:a	()I
    //   4: istore_3
    //   5: lload_1
    //   6: lconst_0
    //   7: lcmp
    //   8: ifge +124 -> 132
    //   11: aload_0
    //   12: invokevirtual 151	java/nio/channels/spi/AbstractSelector:begin	()V
    //   15: getstatic 133	h/b/a/d:a	Lh/b/a/c;
    //   18: aload_0
    //   19: getfield 40	h/b/a/b:x	I
    //   22: aconst_null
    //   23: iload_3
    //   24: aconst_null
    //   25: bipush 100
    //   27: aconst_null
    //   28: invokeinterface 140 7 0
    //   33: istore 4
    //   35: iload 4
    //   37: ifge +26 -> 63
    //   40: getstatic 157	h/a/d/b:EINTR	Lh/a/d/b;
    //   43: getstatic 159	h/b/a/d:b	Lh/c/f;
    //   46: invokevirtual 162	h/c/f:a	()I
    //   49: i2l
    //   50: invokestatic 165	h/a/d/b:valueOf	(J)Lh/a/d/b;
    //   53: invokevirtual 170	java/lang/Enum:equals	(Ljava/lang/Object;)Z
    //   56: istore 5
    //   58: iload 5
    //   60: ifne -45 -> 15
    //   63: aload_0
    //   64: invokevirtual 173	java/nio/channels/spi/AbstractSelector:end	()V
    //   67: aload_0
    //   68: getfield 60	h/b/a/b:B	Ljava/lang/Object;
    //   71: astore 6
    //   73: aload 6
    //   75: monitorenter
    //   76: iload 4
    //   78: ifgt +13 -> 91
    //   81: aload 6
    //   83: monitorexit
    //   84: iconst_0
    //   85: ireturn
    //   86: astore 7
    //   88: goto +29 -> 117
    //   91: aload_0
    //   92: getfield 51	h/b/a/b:z	Lh/b/a/b$c;
    //   95: getfield 176	h/b/a/b$c:a	Lh/b/a/b$d;
    //   98: astore 7
    //   100: aload 7
    //   102: getfield 181	h/c/h:f	I
    //   105: istore_3
    //   106: aload 7
    //   108: getfield 185	h/b/a/b$d:g	Lh/c/h$i;
    //   111: invokevirtual 190	h/c/h$a:a	()J
    //   114: pop2
    //   115: aconst_null
    //   116: athrow
    //   117: aload 6
    //   119: monitorexit
    //   120: aload 7
    //   122: athrow
    //   123: astore 6
    //   125: aload_0
    //   126: invokevirtual 173	java/nio/channels/spi/AbstractSelector:end	()V
    //   129: aload 6
    //   131: athrow
    //   132: new 72	h/b/a/e
    //   135: dup
    //   136: getstatic 196	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   139: lload_1
    //   140: invokevirtual 200	java/util/concurrent/TimeUnit:toSeconds	(J)J
    //   143: getstatic 196	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   146: lload_1
    //   147: ldc2_w 201
    //   150: lrem
    //   151: invokevirtual 205	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   154: invokespecial 75	h/b/a/e:<init>	(JJ)V
    //   157: pop
    //   158: aconst_null
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	b
    //   0	160	1	paramLong	long
    //   4	102	3	i	int
    //   33	44	4	j	int
    //   56	3	5	bool	boolean
    //   71	47	6	localObject1	Object
    //   123	7	6	localObject2	Object
    //   86	1	7	localObject3	Object
    //   98	23	7	locald	d
    // Exception table:
    //   from	to	target	type
    //   81	84	86	finally
    //   91	117	86	finally
    //   117	120	86	finally
    //   11	15	123	finally
    //   15	35	123	finally
    //   40	58	123	finally
  }
  
  public void a(a parama)
  {
    synchronized (B)
    {
      a((b)C.get(Integer.valueOf(parama.a())));
      return;
    }
  }
  
  public final void a(b paramb)
  {
    synchronized (B)
    {
      Iterator localIterator = b.iterator();
      int i = 0;
      int j = 0;
      Object localObject2;
      int k;
      while (localIterator.hasNext())
      {
        localObject2 = (a)localIterator.next();
        k = i;
        if ((c & 0x11) != 0) {
          k = i + 1;
        }
        i = k;
        if ((c & 0xC) != 0)
        {
          j++;
          i = k;
        }
      }
      int m = 0;
      while (m < 2)
      {
        localObject2 = new Integer[] { Integer.valueOf(-1), Integer.valueOf(-2) }[m];
        if (((Integer)localObject2).intValue() == -1)
        {
          if ((i > 0) && (!d))
          {
            d = true;
            k = 37;
            break label182;
          }
          if ((i == 0) && (d))
          {
            d = false;
            k = 8;
            break label182;
          }
        }
        k = 0;
        label182:
        if (((Integer)localObject2).intValue() == -2) {
          if ((j > 0) && (!c))
          {
            c = true;
            k = 37;
          }
          else if ((j == 0) && (c))
          {
            c = false;
            k = 8;
          }
        }
        if (k == 0)
        {
          m++;
        }
        else
        {
          z.a(null, 0, a, ((Integer)localObject2).intValue(), k);
          throw null;
        }
      }
      d.a.a(x, null, 0, null, 0, E);
      return;
    }
  }
  
  public void implCloseSelector()
  {
    int i = x;
    if (i != -1) {
      e.c.a.a.b.l.c.a(i);
    }
    Object localObject = A;
    if (localObject[0] != -1) {
      e.c.a.a.b.l.c.a(localObject[0]);
    }
    localObject = A;
    if (localObject[1] != -1) {
      e.c.a.a.b.l.c.a(localObject[1]);
    }
    localObject = A;
    x = -1;
    localObject[1] = -1;
    localObject[0] = -1;
    localObject = C.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Iterator localIterator = nextgetValueb.iterator();
      while (localIterator.hasNext()) {
        deregister((a)localIterator.next());
      }
    }
  }
  
  public Set<SelectionKey> keys()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = C.values().iterator();
    while (localIterator.hasNext()) {
      localHashSet.addAll(nextb);
    }
    return Collections.unmodifiableSet(localHashSet);
  }
  
  public SelectionKey register(AbstractSelectableChannel arg1, int paramInt, Object paramObject)
  {
    a locala = new a(this, (g)???, paramInt);
    synchronized (B)
    {
      b localb = new h/b/a/b$b;
      localb.<init>(locala.a());
      C.put(Integer.valueOf(locala.a()), localb);
      b.add(locala);
      a(localb);
      locala.attach(paramObject);
      return locala;
    }
  }
  
  public int select()
  {
    a(-1L);
    return 0;
  }
  
  public int select(long paramLong)
  {
    a(paramLong);
    return 0;
  }
  
  public int selectNow()
  {
    a(0L);
    return 0;
  }
  
  public Set<SelectionKey> selectedKeys()
  {
    return D;
  }
  
  public Selector wakeup()
  {
    d.a.a(A[1], new byte[1], 1L);
    return this;
  }
  
  public static class b
  {
    public final int a;
    public final Set<a> b = new HashSet();
    public boolean c = false;
    public boolean d = false;
    
    public b(int paramInt)
    {
      a = paramInt;
    }
  }
  
  public static final class c
  {
    public static final c c = new c();
    public final b.d a;
    public final i b;
    
    public c()
    {
      b.d locald = new b.d(f.a.a, null);
      a = locald;
      b = a.a(j.uintptr_t);
    }
    
    public final void a(h.c.e parame, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      parame = a;
      paramInt1 = f;
      g.a();
      throw null;
    }
  }
  
  public static class d
    extends h.c.h
  {
    public final h.i g;
    public final h.e h;
    public final h.g i;
  }
}

/* Location:
 * Qualified Name:     h.b.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */