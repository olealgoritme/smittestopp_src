package i.j;

import e.a.a.a.a;
import i.e;
import i.k.a.p;
import i.k.b.g;
import i.k.b.h;
import java.io.Serializable;

public final class b
  implements d, Serializable
{
  public final d x;
  public final d.a y;
  
  public b(d paramd, d.a parama) {}
  
  public final int a()
  {
    int i = 2;
    Object localObject = this;
    for (;;)
    {
      d locald = x;
      localObject = locald;
      if (!(locald instanceof b)) {
        localObject = null;
      }
      localObject = (b)localObject;
      if (localObject == null) {
        break;
      }
      i++;
    }
    return i;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = false;
    if (this != paramObject)
    {
      bool2 = bool1;
      if (!(paramObject instanceof b)) {
        return bool2;
      }
      b localb = (b)paramObject;
      bool2 = bool1;
      if (localb.a() != a()) {
        return bool2;
      }
      if (localb != null)
      {
        boolean bool3;
        for (paramObject = this;; paramObject = (b)paramObject)
        {
          d.a locala = y;
          if (!g.a(localb.get(locala.getKey()), locala))
          {
            bool3 = false;
            break label121;
          }
          paramObject = x;
          if (!(paramObject instanceof b)) {
            break;
          }
        }
        if (paramObject != null)
        {
          paramObject = (d.a)paramObject;
          bool3 = g.a(localb.get(((d.a)paramObject).getKey()), paramObject);
          label121:
          bool2 = bool1;
          if (!bool3) {
            return bool2;
          }
        }
        else
        {
          throw new e("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
        }
      }
      else
      {
        throw null;
      }
    }
    boolean bool2 = true;
    return bool2;
  }
  
  public <R> R fold(R paramR, p<? super R, ? super d.a, ? extends R> paramp)
  {
    if (paramp != null) {
      return (R)paramp.a(x.fold(paramR, paramp), y);
    }
    g.a("operation");
    throw null;
  }
  
  public <E extends d.a> E get(d.b<E> paramb)
  {
    if (paramb != null)
    {
      for (Object localObject = this;; localObject = (b)localObject)
      {
        d.a locala = y.get(paramb);
        if (locala != null) {
          return locala;
        }
        localObject = x;
        if (!(localObject instanceof b)) {
          break;
        }
      }
      return ((d)localObject).get(paramb);
    }
    g.a("key");
    throw null;
  }
  
  public int hashCode()
  {
    int i = x.hashCode();
    return y.hashCode() + i;
  }
  
  public d minusKey(d.b<?> paramb)
  {
    if (paramb != null)
    {
      if (y.get(paramb) != null) {
        return x;
      }
      paramb = x.minusKey(paramb);
      if (paramb == x) {
        paramb = this;
      } else if (paramb == f.x) {
        paramb = y;
      } else {
        paramb = new b(paramb, y);
      }
      return paramb;
    }
    g.a("key");
    throw null;
  }
  
  public String toString()
  {
    return a.a(a.a("["), (String)fold("", a.x), "]");
  }
  
  public static final class a
    extends h
    implements p<String, d.a, String>
  {
    public static final a x = new a();
    
    public a()
    {
      super();
    }
    
    public Object a(Object paramObject1, Object paramObject2)
    {
      paramObject1 = (String)paramObject1;
      paramObject2 = (d.a)paramObject2;
      if (paramObject1 != null)
      {
        if (paramObject2 != null)
        {
          int i;
          if (((CharSequence)paramObject1).length() == 0) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            paramObject1 = paramObject2.toString();
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)paramObject1);
            localStringBuilder.append(", ");
            localStringBuilder.append(paramObject2);
            paramObject1 = localStringBuilder.toString();
          }
          return paramObject1;
        }
        g.a("element");
        throw null;
      }
      g.a("acc");
      throw null;
    }
  }
}

/* Location:
 * Qualified Name:     i.j.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */