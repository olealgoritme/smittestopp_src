package g.b.a;

import g.c.f;
import g.c.f.a;
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
  public final Map<Integer, b.b> C = new ConcurrentHashMap();
  public final Set<SelectionKey> D = new LinkedHashSet();
  public final e E;
  public int x = -1;
  public final f y = f.a.a;
  public final b.c z = b.c.c;
  
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
          b.b localb = (b.b)C.get(Integer.valueOf(locala.a()));
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
    //   1: invokevirtual 148	g/b/a/b:a	()I
    //   4: istore_3
    //   5: lload_1
    //   6: lconst_0
    //   7: lcmp
    //   8: ifge +125 -> 133
    //   11: aload_0
    //   12: invokevirtual 151	java/nio/channels/spi/AbstractSelector:begin	()V
    //   15: getstatic 133	g/b/a/d:a	Lg/b/a/c;
    //   18: aload_0
    //   19: getfield 40	g/b/a/b:x	I
    //   22: aconst_null
    //   23: iload_3
    //   24: aconst_null
    //   25: bipush 100
    //   27: aconst_null
    //   28: invokeinterface 140 7 0
    //   33: istore 4
    //   35: iload 4
    //   37: ifge +26 -> 63
    //   40: getstatic 157	g/a/d/b:EINTR	Lg/a/d/b;
    //   43: getstatic 159	g/b/a/d:b	Lg/c/f;
    //   46: invokevirtual 162	g/c/f:a	()I
    //   49: i2l
    //   50: invokestatic 165	g/a/d/b:valueOf	(J)Lg/a/d/b;
    //   53: invokevirtual 170	java/lang/Enum:equals	(Ljava/lang/Object;)Z
    //   56: istore 5
    //   58: iload 5
    //   60: ifne -45 -> 15
    //   63: aload_0
    //   64: invokevirtual 173	java/nio/channels/spi/AbstractSelector:end	()V
    //   67: aload_0
    //   68: getfield 60	g/b/a/b:B	Ljava/lang/Object;
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
    //   88: goto +30 -> 118
    //   91: aload_0
    //   92: getfield 51	g/b/a/b:z	Lg/b/a/b$c;
    //   95: getfield 176	g/b/a/b$c:a	Lg/b/a/b$d;
    //   98: astore 7
    //   100: aload 7
    //   102: getfield 181	g/c/h:f	I
    //   105: istore 4
    //   107: aload 7
    //   109: getfield 185	g/b/a/b$d:g	Lg/c/h$i;
    //   112: invokevirtual 190	g/c/h$a:a	()J
    //   115: pop2
    //   116: aconst_null
    //   117: athrow
    //   118: aload 6
    //   120: monitorexit
    //   121: aload 7
    //   123: athrow
    //   124: astore 6
    //   126: aload_0
    //   127: invokevirtual 173	java/nio/channels/spi/AbstractSelector:end	()V
    //   130: aload 6
    //   132: athrow
    //   133: new 72	g/b/a/e
    //   136: dup
    //   137: getstatic 196	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   140: lload_1
    //   141: invokevirtual 200	java/util/concurrent/TimeUnit:toSeconds	(J)J
    //   144: getstatic 196	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   147: lload_1
    //   148: ldc2_w 201
    //   151: lrem
    //   152: invokevirtual 205	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   155: invokespecial 75	g/b/a/e:<init>	(JJ)V
    //   158: pop
    //   159: aconst_null
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	b
    //   0	161	1	paramLong	long
    //   4	20	3	i	int
    //   33	73	4	j	int
    //   56	3	5	bool	boolean
    //   71	48	6	localObject1	Object
    //   124	7	6	localObject2	Object
    //   86	1	7	localObject3	Object
    //   98	24	7	locald	b.d
    // Exception table:
    //   from	to	target	type
    //   81	84	86	finally
    //   91	118	86	finally
    //   118	121	86	finally
    //   11	15	124	finally
    //   15	35	124	finally
    //   40	58	124	finally
  }
  
  public void a(a parama)
  {
    synchronized (B)
    {
      a((b.b)C.get(Integer.valueOf(parama.a())));
      return;
    }
  }
  
  public final void a(b.b paramb)
  {
    synchronized (B)
    {
      Object localObject2 = b.iterator();
      int i = 0;
      int j = 0;
      int k;
      while (((Iterator)localObject2).hasNext())
      {
        a locala = (a)((Iterator)localObject2).next();
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
            break label180;
          }
          if ((i == 0) && (d))
          {
            d = false;
            k = 8;
            break label180;
          }
        }
        k = 0;
        label180:
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
    Iterator localIterator = C.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = nextgetValueb.iterator();
      while (((Iterator)localObject).hasNext()) {
        deregister((a)((Iterator)localObject).next());
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
      b.b localb = new g/b/a/b$b;
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
}

/* Location:
 * Qualified Name:     base.g.b.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */