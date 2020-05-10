package k.a.b.a.g.i;

import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;
import k.a.b.a.d.b;
import k.a.b.a.d.g0.c;
import k.a.b.a.g.h;

public class m
{
  public c a;
  public PriorityQueue<l> b = new PriorityQueue();
  public AtomicInteger c = new AtomicInteger();
  
  public m(b paramb)
  {
    a = ((c)paramb);
  }
  
  public long a()
  {
    b();
    if (b.size() > 0) {
      return ((h)b.peek()).j();
    }
    return 0L;
  }
  
  public final void b()
  {
    while ((!b.isEmpty()) && (b.peek()).z)) {
      b.poll();
    }
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.g.i.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */