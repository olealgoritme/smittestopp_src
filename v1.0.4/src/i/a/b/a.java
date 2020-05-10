package i.a.b;

import i.a.b.m.l;
import i.a.b.m.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class a
  extends ArrayList<Object>
  implements List<Object>, c, f
{
  public static void a(Iterable<? extends Object> paramIterable, Appendable paramAppendable, g paramg)
  {
    if (paramIterable == null)
    {
      paramAppendable.append("null");
      return;
    }
    l.g.a(paramIterable, paramAppendable, paramg);
  }
  
  public String a()
  {
    g localg = i.a;
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      a(this, localStringBuilder, localg);
      return localStringBuilder.toString();
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public String a(g paramg)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      a(this, localStringBuilder, paramg);
      return localStringBuilder.toString();
    }
    catch (IOException paramg)
    {
      for (;;) {}
    }
  }
  
  public void a(Appendable paramAppendable)
  {
    a(this, paramAppendable, i.a);
  }
  
  public void a(Appendable paramAppendable, g paramg)
  {
    a(this, paramAppendable, paramg);
  }
  
  public String toString()
  {
    g localg = i.a;
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      a(this, localStringBuilder, localg);
      return localStringBuilder.toString();
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     base.i.a.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */