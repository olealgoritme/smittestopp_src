package e.c.c.w.z;

import e.a.a.a.a;
import e.c.c.g;
import e.c.c.j;
import e.c.c.l;
import e.c.c.m;
import e.c.c.p;
import e.c.c.y.c;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends c
{
  public static final Writer L = new b.a();
  public static final p M = new p("closed");
  public final List<j> I = new ArrayList();
  public String J;
  public j K = l.a;
  
  public b()
  {
    super(L);
  }
  
  public c a(long paramLong)
  {
    a(new p(Long.valueOf(paramLong)));
    return this;
  }
  
  public c a(Boolean paramBoolean)
  {
    if (paramBoolean == null)
    {
      a(l.a);
      return this;
    }
    a(new p(paramBoolean));
    return this;
  }
  
  public c a(Number paramNumber)
  {
    if (paramNumber == null)
    {
      a(l.a);
      return this;
    }
    if (!C)
    {
      double d = paramNumber.doubleValue();
      if ((Double.isNaN(d)) || (Double.isInfinite(d)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("JSON forbids NaN and infinities: ");
        localStringBuilder.append(paramNumber);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    a(new p(paramNumber));
    return this;
  }
  
  public c a(String paramString)
  {
    if ((!I.isEmpty()) && (J == null))
    {
      if ((h() instanceof m))
      {
        J = paramString;
        return this;
      }
      throw new IllegalStateException();
    }
    throw new IllegalStateException();
  }
  
  public c a(boolean paramBoolean)
  {
    a(new p(Boolean.valueOf(paramBoolean)));
    return this;
  }
  
  public final void a(j paramj)
  {
    if (J != null)
    {
      if (paramj != null)
      {
        if ((!(paramj instanceof l)) || (F)) {
          ((m)h()).a(J, paramj);
        }
        J = null;
      }
      else
      {
        throw null;
      }
    }
    else if (I.isEmpty())
    {
      K = paramj;
    }
    else
    {
      Object localObject = h();
      if (!(localObject instanceof g)) {
        break label115;
      }
      g localg = (g)localObject;
      if (localg == null) {
        break label113;
      }
      localObject = paramj;
      if (paramj == null) {
        localObject = l.a;
      }
      x.add(localObject);
    }
    return;
    label113:
    throw null;
    label115:
    throw new IllegalStateException();
  }
  
  public c b()
  {
    g localg = new g();
    a(localg);
    I.add(localg);
    return this;
  }
  
  public c c()
  {
    m localm = new m();
    a(localm);
    I.add(localm);
    return this;
  }
  
  public c c(String paramString)
  {
    if (paramString == null)
    {
      a(l.a);
      return this;
    }
    a(new p(paramString));
    return this;
  }
  
  public void close()
  {
    if (I.isEmpty())
    {
      I.add(M);
      return;
    }
    throw new IOException("Incomplete document");
  }
  
  public c d()
  {
    if ((!I.isEmpty()) && (J == null))
    {
      if ((h() instanceof g))
      {
        List localList = I;
        localList.remove(localList.size() - 1);
        return this;
      }
      throw new IllegalStateException();
    }
    throw new IllegalStateException();
  }
  
  public c e()
  {
    if ((!I.isEmpty()) && (J == null))
    {
      if ((h() instanceof m))
      {
        List localList = I;
        localList.remove(localList.size() - 1);
        return this;
      }
      throw new IllegalStateException();
    }
    throw new IllegalStateException();
  }
  
  public void flush() {}
  
  public c g()
  {
    a(l.a);
    return this;
  }
  
  public final j h()
  {
    List localList = I;
    return (j)localList.get(localList.size() - 1);
  }
  
  public j j()
  {
    if (I.isEmpty()) {
      return K;
    }
    StringBuilder localStringBuilder = a.a("Expected one JSON element but was ");
    localStringBuilder.append(I);
    throw new IllegalStateException(localStringBuilder.toString());
  }
}

/* Location:
 * Qualified Name:     base.e.c.c.w.z.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */