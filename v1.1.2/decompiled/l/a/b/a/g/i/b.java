package l.a.b.a.g.i;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.Channel;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import l.a.b.a.d.c;
import l.a.b.a.d.c0;
import l.a.b.a.d.d0;
import l.a.b.a.d.g0.a0;
import l.a.b.a.d.g0.r;
import l.a.b.a.d.g0.v;
import l.a.b.a.d.h;
import l.a.b.a.g.g.a;

public class b
  extends l.a.b.a.d.a
{
  public static g.a a = new a();
  public static g.a b = new b();
  public static g.a c = new c();
  public static g.a d = new d();
  public static g.a e = new e();
  
  public static int a(l.a.b.a.g.g paramg)
  {
    c0 localc0 = J;
    int i = localc0.capacity();
    if ((i < 0) && (localc0.isClosed())) {
      paramg.m();
    }
    return i;
  }
  
  public static int b(l.a.b.a.g.g paramg)
  {
    c0 localc0 = J;
    int i = localc0.pending();
    if ((i < 0) && (localc0.isClosed())) {
      paramg.m();
    }
    return i;
  }
  
  public static void c(l.a.b.a.g.g paramg)
  {
    j localj = (j)paramg;
    int i = a(localj);
    int j = b(localj);
    boolean bool1 = true;
    boolean bool2;
    if (i > 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    paramg.a(bool2);
    if (j > 0) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    paramg.b(bool2);
    l.a.b.a.g.d locald = I;
    paramg.a(J.b(locald.S()));
  }
  
  public final void a(l.a.b.a.g.d paramd, h paramh)
  {
    l.a.b.a.d.g0.g localg = (l.a.b.a.d.g0.g)paramh;
    paramh = localg.T();
    if (l.a.b.a.g.a.class.cast(Ba.get("pn_reactor_connection_acceptor")) != null) {
      return;
    }
    String str = paramd.b(paramh);
    Object localObject1 = paramh.f();
    int i = 5672;
    Object localObject2 = null;
    Object localObject3;
    int j;
    Object localObject4;
    if (str != null)
    {
      i = str.indexOf("://", 0);
      if (i >= 0)
      {
        localObject3 = str.substring(0, i);
        i += 3;
      }
      else
      {
        i = 0;
        localObject3 = null;
      }
      j = str.indexOf("/", i);
      if (j >= 0)
      {
        paramh = str.substring(i, j);
        str.substring(j + 1);
      }
      else
      {
        paramh = str.substring(i);
      }
      i = paramh.indexOf('@');
      localObject4 = paramh;
      if (i >= 0)
      {
        localObject1 = paramh.substring(0, i);
        paramh = paramh.substring(i + 1);
        i = ((String)localObject1).indexOf(':');
        localObject4 = paramh;
        if (i >= 0)
        {
          ((String)localObject1).substring(0, i);
          ((String)localObject1).substring(i + 1);
          localObject4 = paramh;
        }
      }
      if (((String)localObject4).startsWith("["))
      {
        i = ((String)localObject4).indexOf(']');
        if (i >= 0)
        {
          paramh = ((String)localObject4).substring(1, i);
          if (((String)localObject4).substring(i + 1).startsWith(":"))
          {
            localObject1 = ((String)localObject4).substring(i + 2);
            break label301;
          }
          localObject1 = null;
          break label301;
        }
      }
      localObject1 = null;
      paramh = (h)localObject1;
      label301:
      if (paramh == null)
      {
        i = ((String)localObject4).indexOf(':');
        paramh = (h)localObject4;
        if (i >= 0)
        {
          paramh = ((String)localObject4).substring(0, i);
          localObject1 = ((String)localObject4).substring(i + 1);
        }
      }
      localObject4 = paramh;
      if (paramh.startsWith("~")) {
        localObject4 = paramh.substring(1);
      }
      paramh = (h)localObject1;
      if (localObject1 == null) {}
      try
      {
        if ("amqps".equals(localObject3)) {
          paramh = "5671";
        } else {
          paramh = "5672";
        }
        i = Integer.parseInt(paramh);
        paramh = (h)localObject4;
      }
      catch (NumberFormatException paramd)
      {
        throw new IllegalArgumentException(e.a.a.a.a.b("Not a valid host: ", str), paramd);
      }
    }
    if ((localObject1 != null) && (!((String)localObject1).equals("")))
    {
      j = ((String)localObject1).indexOf(':');
      paramh = (h)localObject1;
      if (j >= 0) {
        try
        {
          i = Integer.parseInt(((String)localObject1).substring(j + 1));
          paramh = ((String)localObject1).substring(0, j);
        }
        catch (NumberFormatException paramd)
        {
          throw new IllegalArgumentException(e.a.a.a.a.b("Not a valid host: ", (String)localObject1), paramd);
        }
      }
      localObject4 = localg.T().j();
      try
      {
        if (M != null)
        {
          localObject3 = SocketChannel.open();
          ((SocketChannel)localObject3).configureBlocking(false);
          localObject1 = new java/net/InetSocketAddress;
          ((InetSocketAddress)localObject1).<init>(paramh, i);
          ((SocketChannel)localObject3).connect((SocketAddress)localObject1);
          paramh = ((SocketChannel)localObject3).socket();
        }
        else
        {
          throw null;
        }
      }
      catch (Exception paramh)
      {
        localObject1 = new l.a.b.a.b.n.j();
        ((l.a.b.a.b.n.j)localObject1).a(l.a.b.a.b.f.a("proton:io"));
        b = paramh.getMessage();
        ((l.a.b.a.d.f)localObject4).a((l.a.b.a.b.n.j)localObject1);
        ((c0)localObject4).close_tail();
        ((c0)localObject4).close_head();
        ((c0)localObject4).pop(Math.max(0, ((c0)localObject4).pending()));
        paramh = null;
        localObject3 = paramd.p();
        localObject1 = localObject2;
        if (paramh != null) {
          localObject1 = paramh.getChannel();
        }
        ((l.a.b.a.g.g)localObject3).a((SelectableChannel)localObject1);
        ((l.a.b.a.g.g)localObject3).d(a);
        ((l.a.b.a.g.g)localObject3).a(b);
        ((l.a.b.a.g.g)localObject3).c(c);
        ((l.a.b.a.g.g)localObject3).e(d);
        ((l.a.b.a.g.g)localObject3).b(e);
        J = ((c0)localObject4);
        paramh = (a0)localObject4;
        v0 = ((l.a.b.a.g.g)localObject3);
        w0 = paramd;
        c((l.a.b.a.g.g)localObject3);
        paramd.a((l.a.b.a.g.g)localObject3);
        return;
      }
    }
    throw new IllegalStateException("No address provided for Connection");
  }
  
  public final void a(l.a.b.a.g.d paramd, k paramk)
  {
    if (!paramd.l()) {
      return;
    }
    long l1 = paramd.z();
    if (paramk != null)
    {
      long l2 = System.currentTimeMillis();
      long l3 = l1;
      if (l1 > 0L)
      {
        localObject1 = b.iterator();
        l4 = 0L;
        while (((Iterator)localObject1).hasNext())
        {
          l3 = ((l.a.b.a.g.g)((Iterator)localObject1).next()).R();
          if (l3 > 0L) {
            if (l4 == 0L) {
              l4 = l3;
            } else {
              l4 = Math.min(l4, l3);
            }
          }
        }
        l3 = l1;
        if (l4 > 0L)
        {
          l4 -= l2;
          if (l4 < 0L)
          {
            l3 = 0L;
          }
          else
          {
            l3 = l1;
            if (l4 < l1) {
              l3 = l4;
            }
          }
        }
      }
      f.clear();
      if (l3 > 0L)
      {
        l4 = 0L;
        while (l3 > 0L)
        {
          a.select(l3);
          l4 = System.currentTimeMillis();
          localObject1 = a.selectedKeys().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (SelectionKey)((Iterator)localObject1).next();
            if (((SelectionKey)localObject2).isConnectable())
            {
              try
              {
                ((SocketChannel)((SelectionKey)localObject2).channel()).finishConnect();
                paramk.a((l.a.b.a.g.g)((SelectionKey)localObject2).attachment());
              }
              catch (IOException localIOException)
              {
                j localj = (j)((SelectionKey)localObject2).attachment();
                localObject2 = new l.a.b.a.b.n.j();
                ((l.a.b.a.b.n.j)localObject2).a(l.a.b.a.b.f.a("proton:io"));
                b = localIOException.getMessage();
                localObject3 = J;
                if (localObject3 != null)
                {
                  ((l.a.b.a.d.f)localObject3).a((l.a.b.a.b.n.j)localObject2);
                  ((c0)localObject3).close_tail();
                  ((c0)localObject3).close_head();
                  ((c0)localObject3).pop(Math.max(0, ((c0)localObject3).pending()));
                }
                f.add(localj);
              }
              ((Iterator)localObject1).remove();
            }
          }
          if (!a.selectedKeys().isEmpty()) {
            break;
          }
          l3 -= l4 - l2;
        }
      }
      a.selectNow();
      long l4 = System.currentTimeMillis();
      c.clear();
      d.clear();
      e.clear();
      Object localObject3 = a.selectedKeys().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject1 = (SelectionKey)((Iterator)localObject3).next();
        localObject2 = (l.a.b.a.g.g)((SelectionKey)localObject1).attachment();
        if (((SelectionKey)localObject1).isReadable()) {
          c.add(localObject2);
        }
        if (((SelectionKey)localObject1).isAcceptable()) {
          c.add(localObject2);
        }
        if (((SelectionKey)localObject1).isWritable()) {
          d.add(localObject2);
        }
      }
      a.selectedKeys().clear();
      Object localObject2 = b.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (l.a.b.a.g.g)((Iterator)localObject2).next();
        l3 = ((l.a.b.a.g.g)localObject1).R();
        if ((l3 > 0L) && (l4 >= l3)) {
          e.add(localObject1);
        }
      }
      paramd.k();
      Object localObject1 = c.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((l.a.b.a.g.g)((Iterator)localObject1).next()).K();
      }
      localObject1 = d.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((l.a.b.a.g.g)((Iterator)localObject1).next()).E();
      }
      localObject1 = e.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((l.a.b.a.g.g)((Iterator)localObject1).next()).G();
      }
      paramk = f.iterator();
      while (paramk.hasNext()) {
        ((l.a.b.a.g.g)paramk.next()).O();
      }
      paramd.h();
      return;
    }
    throw null;
  }
  
  public final void b(l.a.b.a.g.d paramd, h paramh)
  {
    c localc = ((l.a.b.a.d.g0.g)paramh).T();
    if (localc.e() != l.a.b.a.d.g.UNINITIALIZED) {
      return;
    }
    paramh = localc.f();
    if (paramh == null)
    {
      Object localObject = paramd.b(localc);
      if (localObject != null)
      {
        int i = ((String)localObject).indexOf("://", 0);
        if (i >= 0)
        {
          ((String)localObject).substring(0, i);
          i += 3;
        }
        else
        {
          i = 0;
        }
        int j = ((String)localObject).indexOf("/", i);
        if (j >= 0)
        {
          paramh = ((String)localObject).substring(i, j);
          ((String)localObject).substring(j + 1);
        }
        else
        {
          paramh = ((String)localObject).substring(i);
        }
        i = paramh.indexOf('@');
        localObject = paramh;
        String str;
        if (i >= 0)
        {
          str = paramh.substring(0, i);
          paramh = paramh.substring(i + 1);
          i = str.indexOf(':');
          localObject = paramh;
          if (i >= 0)
          {
            str.substring(0, i);
            str.substring(i + 1);
            localObject = paramh;
          }
        }
        if (((String)localObject).startsWith("["))
        {
          i = ((String)localObject).indexOf(']');
          if (i >= 0)
          {
            str = ((String)localObject).substring(1, i);
            paramh = str;
            if (!((String)localObject).substring(i + 1).startsWith(":")) {
              break label271;
            }
            ((String)localObject).substring(i + 2);
            paramh = str;
            break label271;
          }
        }
        paramh = null;
        label271:
        if (paramh == null)
        {
          i = ((String)localObject).indexOf(':');
          paramh = (h)localObject;
          if (i >= 0)
          {
            paramh = ((String)localObject).substring(0, i);
            ((String)localObject).substring(i + 1);
          }
        }
        localObject = paramh;
        if (paramh.startsWith("~")) {
          localObject = paramh.substring(1);
        }
        localc.a((String)localObject);
      }
    }
    else if (paramh.isEmpty())
    {
      localc.a(null);
    }
    paramh = new a0();
    if (paramd.J() != null)
    {
      if (Ja)
      {
        paramd = (v)paramh.L();
        paramd.a();
        paramd.a(new String[] { "ANONYMOUS" });
      }
      paramh.a(localc);
      return;
    }
    throw null;
  }
  
  public void onUnhandled(h paramh)
  {
    l.a.b.a.d.g0.g localg = (l.a.b.a.d.g0.g)paramh;
    try
    {
      Object localObject1 = (d)localg.b();
      Object localObject2 = K;
      paramh = (h)localObject2;
      if (localObject2 == null)
      {
        paramh = new l/a/b/a/g/i/k;
        paramh.<init>(M);
        K = paramh;
      }
      int i = localg.z().ordinal();
      if (i != 1)
      {
        if (i != 5)
        {
          if (i != 7)
          {
            if (i != 28)
            {
              if (i != 39)
              {
                switch (i)
                {
                default: 
                  break;
                case 34: 
                  paramh.a(localg.l());
                  break;
                case 33: 
                  localObject2 = localg.l();
                  if (((l.a.b.a.g.g)localObject2).N() != null)
                  {
                    ((l.a.b.a.g.g)localObject2).N().configureBlocking(false);
                    ((l.a.b.a.g.g)localObject2).N().register(a, 0).attach(localObject2);
                  }
                  b.add(localObject2);
                  paramh.a((l.a.b.a.g.g)localObject2);
                  break;
                case 32: 
                  localg.j().o();
                  break;
                }
              }
              else
              {
                localObject1 = localg.l();
                if (((l.a.b.a.g.g)localObject1).N() != null)
                {
                  localObject2 = ((l.a.b.a.g.g)localObject1).N().keyFor(a);
                  if (localObject2 != null)
                  {
                    ((SelectionKey)localObject2).cancel();
                    ((SelectionKey)localObject2).attach(null);
                  }
                }
                b.remove(localObject1);
                ((l.a.b.a.g.g)localObject1).c();
              }
            }
            else
            {
              paramh = jv0;
              if ((paramh != null) && (!paramh.Q()))
              {
                c(paramh);
                ((l.a.b.a.g.d)localObject1).a(paramh);
              }
            }
          }
          else {
            b((l.a.b.a.g.d)localObject1, localg);
          }
        }
        else {
          a((l.a.b.a.g.d)localObject1, localg);
        }
      }
      else {
        a((l.a.b.a.g.d)localObject1, paramh);
      }
      return;
    }
    catch (IOException paramh)
    {
      throw new e(paramh);
    }
  }
  
  public static final class a
    implements g.a
  {
    public void a(l.a.b.a.g.g paramg)
    {
      l.a.b.a.g.d locald = paramg.b();
      c0 localc0 = J;
      if (localc0.capacity() > 0)
      {
        SocketChannel localSocketChannel = (SocketChannel)paramg.N();
        try
        {
          if (localSocketChannel.read(localc0.tail()) == -1) {
            localc0.close_tail();
          } else {
            localc0.process();
          }
        }
        catch (d0 locald0) {}catch (IOException localIOException) {}
        l.a.b.a.b.n.j localj = new l.a.b.a.b.n.j();
        localj.a(l.a.b.a.b.f.a("proton:io"));
        b = localIOException.getMessage();
        localc0.a(localj);
        localc0.close_tail();
      }
      b.c(paramg);
      locald.a(paramg);
    }
  }
  
  public static final class b
    implements g.a
  {
    public void a(l.a.b.a.g.g paramg)
    {
      l.a.b.a.g.d locald = paramg.b();
      c0 localc0 = J;
      int i = localc0.pending();
      if (i > 0)
      {
        Object localObject = (SocketChannel)paramg.N();
        try
        {
          int j = ((SocketChannel)localObject).write(localc0.head());
          if (j < 0) {
            localc0.close_head();
          } else {
            localc0.pop(j);
          }
        }
        catch (IOException localIOException)
        {
          localObject = new l.a.b.a.b.n.j();
          ((l.a.b.a.b.n.j)localObject).a(l.a.b.a.b.f.a("proton:io"));
          b = localIOException.getMessage();
          localc0.a((l.a.b.a.b.n.j)localObject);
          localc0.close_head();
        }
      }
      if (localc0.pending() != i)
      {
        b.c(paramg);
        locald.a(paramg);
      }
    }
  }
  
  public static final class c
    implements g.a
  {
    public void a(l.a.b.a.g.g paramg)
    {
      l.a.b.a.g.d locald = paramg.b();
      paramg.m();
      locald.a(paramg);
    }
  }
  
  public static final class d
    implements g.a
  {
    public void a(l.a.b.a.g.g paramg)
    {
      l.a.b.a.g.d locald = paramg.b();
      paramg.a(J.b(locald.S()));
      int i = b.a(paramg);
      int j = b.b(paramg);
      boolean bool1 = true;
      boolean bool2;
      if (i > 0) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      paramg.a(bool2);
      if (j > 0) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
      paramg.b(bool2);
      locald.a(paramg);
    }
  }
  
  public static final class e
    implements g.a
  {
    public void a(l.a.b.a.g.g paramg)
    {
      paramg = paramg.N();
      if (paramg != null) {}
      try
      {
        paramg.close();
        return;
      }
      catch (IOException paramg)
      {
        for (;;) {}
      }
    }
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.g.i.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */