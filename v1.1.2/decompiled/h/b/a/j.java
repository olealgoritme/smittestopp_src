package h.b.a;

import h.a.d.b;
import h.c.f;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.AbstractSelectionKey;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class j
  extends AbstractSelector
{
  public final int[] A = { -1, -1 };
  public final Object B = new Object();
  public final Map<SelectionKey, Boolean> C = new ConcurrentHashMap();
  public final Set<SelectionKey> D = new HashSet();
  public i[] x = new i[0];
  public ByteBuffer y = null;
  public int z;
  
  public j(SelectorProvider paramSelectorProvider)
  {
    super(paramSelectorProvider);
    d.a.a(A);
    y = ByteBuffer.allocateDirect(8).order(ByteOrder.nativeOrder());
    b(0, A[0]);
    a(0, 1);
    z = 1;
    x = new i[1];
  }
  
  public final int a(long paramLong)
  {
    synchronized (cancelledKeys())
    {
      Object localObject3 = ((Set)???).iterator();
      while (((Iterator)localObject3).hasNext()) {
        b((i)((Iterator)localObject3).next());
      }
      ((Set)???).clear();
      try
      {
        begin();
        int i;
        boolean bool;
        do
        {
          i = d.a.a(y, z, (int)paramLong);
          if (i >= 0) {
            break;
          }
          bool = b.EINTR.equals(b.valueOf(d.b.a()));
        } while (bool);
        end();
        if (i < 1) {
          return i;
        }
        if ((y.getShort(6) & 0x1) != 0) {
          e.c.a.a.b.l.c.a(A[0], ByteBuffer.allocate(1));
        }
        Iterator localIterator = C.keySet().iterator();
        int j = 0;
        while (localIterator.hasNext())
        {
          localObject3 = (SelectionKey)localIterator.next();
          ??? = (i)localObject3;
          i = e;
          int k = y.getShort(i * 8 + 6);
          if (k != 0)
          {
            i = e;
            y.putShort(i * 8 + 6, (short)0);
            int m = ((SelectionKey)localObject3).interestOps();
            if ((k & 0x1) != 0) {
              i = m & 0x11 | 0x0;
            } else {
              i = 0;
            }
            int n = i;
            if ((k & 0x4) != 0) {
              n = i | m & 0xC;
            }
            if ((k & 0x18) != 0) {
              n = m;
            }
            d = n;
            i = j + 1;
            j = i;
            if (!D.contains(localObject3))
            {
              D.add(localObject3);
              j = i;
            }
          }
        }
        return j;
      }
      finally
      {
        end();
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    y.putShort(paramInt1 * 8 + 4, (short)paramInt2);
  }
  
  public final void a(i parami)
  {
    synchronized (B)
    {
      int i = z + 1;
      z = i;
      if (x.length < i)
      {
        j = i / 2 + i;
        Object localObject2 = new i[j];
        System.arraycopy(x, 0, localObject2, 0, i - 1);
        x = ((i[])localObject2);
        localObject2 = ByteBuffer.allocateDirect(j * 8);
        if (y != null) {
          ((ByteBuffer)localObject2).put(y);
        }
        ((ByteBuffer)localObject2).position(0);
        y = ((ByteBuffer)localObject2).order(ByteOrder.nativeOrder());
      }
      int j = z - 1;
      e = j;
      x[(z - 1)] = parami;
      b(j, b.getFD());
      a(e, 0);
      C.put(parami, Boolean.valueOf(true));
      return;
    }
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    y.putInt(paramInt1 * 8 + 0, paramInt2);
  }
  
  public final void b(i parami)
  {
    int i = e;
    synchronized (B)
    {
      if (i < z - 1)
      {
        ??? = x[(z - 1)];
        x[i] = ???;
        int j = e;
        b(i, y.getInt(j * 8 + 0));
        j = e;
        a(i, y.getShort(j * 8 + 4));
        e = i;
      }
      else
      {
        b(i, -1);
        a(i, 0);
      }
      x[(z - 1)] = null;
      z -= 1;
      synchronized (D)
      {
        D.remove(parami);
        C.remove(parami);
        deregister(parami);
        return;
      }
    }
  }
  
  public void implCloseSelector()
  {
    Object localObject = A;
    if (localObject[0] != -1) {
      e.c.a.a.b.l.c.a(localObject[0]);
    }
    localObject = A;
    if (localObject[1] != -1) {
      e.c.a.a.b.l.c.a(localObject[1]);
    }
    localObject = C.keySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      b((i)((Iterator)localObject).next());
    }
  }
  
  public Set<SelectionKey> keys()
  {
    return new HashSet(Arrays.asList(x).subList(0, z));
  }
  
  public SelectionKey register(AbstractSelectableChannel paramAbstractSelectableChannel, int paramInt, Object paramObject)
  {
    paramAbstractSelectableChannel = new i(this, (g)paramAbstractSelectableChannel);
    a(paramAbstractSelectableChannel);
    paramAbstractSelectableChannel.attach(paramObject);
    paramAbstractSelectableChannel.interestOps(paramInt);
    return paramAbstractSelectableChannel;
  }
  
  public int select()
  {
    return a(-1L);
  }
  
  public int select(long paramLong)
  {
    if (paramLong <= 0L) {
      paramLong = -1L;
    }
    return a(paramLong);
  }
  
  public int selectNow()
  {
    return a(0L);
  }
  
  public Set<SelectionKey> selectedKeys()
  {
    return D;
  }
  
  public Selector wakeup()
  {
    try
    {
      e.c.a.a.b.l.c.b(A[1], ByteBuffer.allocate(1));
      return this;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }
}

/* Location:
 * Qualified Name:     h.b.a.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */