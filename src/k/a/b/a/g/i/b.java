package k.a.b.a.g.i;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import k.a.b.a.d.c;
import k.a.b.a.d.c0;
import k.a.b.a.d.g0.a0;
import k.a.b.a.d.g0.r;
import k.a.b.a.d.g0.v;
import k.a.b.a.d.h;
import k.a.b.a.g.g.a;

public class b
  extends k.a.b.a.d.a
{
  public static g.a a = new b.a();
  public static g.a b = new b.b();
  public static g.a c = new b.c();
  public static g.a d = new b.d();
  public static g.a e = new b.e();
  
  public static int a(k.a.b.a.g.g paramg)
  {
    c0 localc0 = J;
    int i = localc0.capacity();
    if ((i < 0) && (localc0.m())) {
      paramg.p();
    }
    return i;
  }
  
  public static int b(k.a.b.a.g.g paramg)
  {
    c0 localc0 = J;
    int i = localc0.pending();
    if ((i < 0) && (localc0.m())) {
      paramg.p();
    }
    return i;
  }
  
  public static void c(k.a.b.a.g.g paramg)
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
    k.a.b.a.g.d locald = I;
    paramg.c(J.a(locald.S()));
  }
  
  public final void a(k.a.b.a.g.d paramd, h paramh)
  {
    k.a.b.a.d.g0.g localg = (k.a.b.a.d.g0.g)paramh;
    paramh = localg.U();
    if (k.a.b.a.g.a.class.cast(qa.get("pn_reactor_connection_acceptor")) != null) {
      return;
    }
    String str = paramd.a(paramh);
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
      localObject4 = localg.U().l();
      try
      {
        if (M != null)
        {
          localObject1 = SocketChannel.open();
          ((SocketChannel)localObject1).configureBlocking(false);
          localObject3 = new java/net/InetSocketAddress;
          ((InetSocketAddress)localObject3).<init>(paramh, i);
          ((SocketChannel)localObject1).connect((SocketAddress)localObject3);
          paramh = ((SocketChannel)localObject1).socket();
        }
        else
        {
          throw null;
        }
      }
      catch (Exception paramh)
      {
        localObject1 = new k.a.b.a.b.n.j();
        ((k.a.b.a.b.n.j)localObject1).a(k.a.b.a.b.f.a("proton:io"));
        b = paramh.getMessage();
        ((k.a.b.a.d.f)localObject4).a((k.a.b.a.b.n.j)localObject1);
        ((c0)localObject4).close_tail();
        ((c0)localObject4).close_head();
        ((c0)localObject4).pop(Math.max(0, ((c0)localObject4).pending()));
        paramh = null;
        localObject3 = paramd.w();
        localObject1 = localObject2;
        if (paramh != null) {
          localObject1 = paramh.getChannel();
        }
        ((k.a.b.a.g.g)localObject3).a((SelectableChannel)localObject1);
        ((k.a.b.a.g.g)localObject3).a(a);
        ((k.a.b.a.g.g)localObject3).b(b);
        ((k.a.b.a.g.g)localObject3).d(c);
        ((k.a.b.a.g.g)localObject3).e(d);
        ((k.a.b.a.g.g)localObject3).c(e);
        J = ((c0)localObject4);
        paramh = (a0)localObject4;
        v0 = ((k.a.b.a.g.g)localObject3);
        w0 = paramd;
        c((k.a.b.a.g.g)localObject3);
        paramd.a((k.a.b.a.g.g)localObject3);
        return;
      }
    }
    throw new IllegalStateException("No address provided for Connection");
  }
  
  public final void a(k.a.b.a.g.d paramd, k paramk)
  {
    if (!paramd.o()) {
      return;
    }
    long l1 = paramd.h();
    if (paramk != null)
    {
      long l2 = System.currentTimeMillis();
      long l3 = l1;
      long l4;
      if (l1 > 0L)
      {
        localObject1 = b.iterator();
        l4 = 0L;
        while (((Iterator)localObject1).hasNext())
        {
          l3 = ((k.a.b.a.g.g)((Iterator)localObject1).next()).Q();
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
      Object localObject2;
      if (l3 > 0L)
      {
        l4 = 0L;
        l1 = l3;
        for (;;)
        {
          l3 = l4;
          if (l1 <= 0L) {
            break;
          }
          a.select(l1);
          l3 = System.currentTimeMillis();
          localObject1 = a.selectedKeys().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (SelectionKey)((Iterator)localObject1).next();
            if (((SelectionKey)localObject2).isConnectable())
            {
              try
              {
                ((SocketChannel)((SelectionKey)localObject2).channel()).finishConnect();
                paramk.a((k.a.b.a.g.g)((SelectionKey)localObject2).attachment());
              }
              catch (IOException localIOException)
              {
                j localj = (j)((SelectionKey)localObject2).attachment();
                localObject2 = new k.a.b.a.b.n.j();
                ((k.a.b.a.b.n.j)localObject2).a(k.a.b.a.b.f.a("proton:io"));
                b = localIOException.getMessage();
                localObject3 = J;
                if (localObject3 != null)
                {
                  ((k.a.b.a.d.f)localObject3).a((k.a.b.a.b.n.j)localObject2);
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
          l1 -= l3 - l2;
          l4 = l3;
        }
      }
      a.selectNow();
      l3 = System.currentTimeMillis();
      c.clear();
      d.clear();
      e.clear();
      Object localObject1 = a.selectedKeys().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SelectionKey)((Iterator)localObject1).next();
        localObject3 = (k.a.b.a.g.g)((SelectionKey)localObject2).attachment();
        if (((SelectionKey)localObject2).isReadable()) {
          c.add(localObject3);
        }
        if (((SelectionKey)localObject2).isAcceptable()) {
          c.add(localObject3);
        }
        if (((SelectionKey)localObject2).isWritable()) {
          d.add(localObject3);
        }
      }
      a.selectedKeys().clear();
      Object localObject3 = b.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject1 = (k.a.b.a.g.g)((Iterator)localObject3).next();
        l4 = ((k.a.b.a.g.g)localObject1).Q();
        if ((l4 > 0L) && (l3 >= l4)) {
          e.add(localObject1);
        }
      }
      paramd.n();
      localObject1 = c.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((k.a.b.a.g.g)((Iterator)localObject1).next()).C();
      }
      localObject1 = d.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((k.a.b.a.g.g)((Iterator)localObject1).next()).u();
      }
      localObject1 = e.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((k.a.b.a.g.g)((Iterator)localObject1).next()).y();
      }
      paramk = f.iterator();
      while (paramk.hasNext()) {
        ((k.a.b.a.g.g)paramk.next()).N();
      }
      paramd.i();
      return;
    }
    throw null;
  }
  
  public final void b(k.a.b.a.g.d paramd, h paramh)
  {
    c localc = ((k.a.b.a.d.g0.g)paramh).U();
    if (localc.e() != k.a.b.a.d.g.UNINITIALIZED) {
      return;
    }
    paramh = localc.f();
    if (paramh == null)
    {
      Object localObject = paramd.a(localc);
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
        localc.c((String)localObject);
      }
    }
    else if (paramh.isEmpty())
    {
      localc.c(null);
    }
    paramh = new a0();
    if (paramd.B() != null)
    {
      if (Ba)
      {
        paramd = (v)paramh.E();
        paramd.a();
        paramd.a(new String[] { "ANONYMOUS" });
      }
      paramh.b(localc);
      return;
    }
    throw null;
  }
  
  public void onUnhandled(h paramh)
  {
    k.a.b.a.d.g0.g localg = (k.a.b.a.d.g0.g)paramh;
    try
    {
      Object localObject1 = (d)localg.b();
      Object localObject2 = K;
      paramh = (h)localObject2;
      if (localObject2 == null)
      {
        paramh = new k/a/b/a/g/i/k;
        paramh.<init>(M);
        K = paramh;
      }
      int i = localg.w().ordinal();
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
                  paramh.a(localg.n());
                  break;
                case 33: 
                  localObject2 = localg.n();
                  if (((k.a.b.a.g.g)localObject2).I() != null)
                  {
                    ((k.a.b.a.g.g)localObject2).I().configureBlocking(false);
                    ((k.a.b.a.g.g)localObject2).I().register(a, 0).attach(localObject2);
                  }
                  b.add(localObject2);
                  paramh.a((k.a.b.a.g.g)localObject2);
                  break;
                case 32: 
                  localg.l().v();
                  break;
                }
              }
              else
              {
                localObject2 = localg.n();
                if (((k.a.b.a.g.g)localObject2).I() != null)
                {
                  localObject1 = ((k.a.b.a.g.g)localObject2).I().keyFor(a);
                  if (localObject1 != null)
                  {
                    ((SelectionKey)localObject1).cancel();
                    ((SelectionKey)localObject1).attach(null);
                  }
                }
                b.remove(localObject2);
                ((k.a.b.a.g.g)localObject2).c();
              }
            }
            else
            {
              paramh = lv0;
              if ((paramh != null) && (!paramh.P()))
              {
                c(paramh);
                ((k.a.b.a.g.d)localObject1).a(paramh);
              }
            }
          }
          else {
            b((k.a.b.a.g.d)localObject1, localg);
          }
        }
        else {
          a((k.a.b.a.g.d)localObject1, localg);
        }
      }
      else {
        a((k.a.b.a.g.d)localObject1, paramh);
      }
      return;
    }
    catch (IOException paramh)
    {
      throw new e(paramh);
    }
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.g.i.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */