package k.b.a;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import k.b.j.c;

public abstract class u
  extends t
  implements c<e>
{
  public e[] x;
  
  public u()
  {
    x = f.d;
  }
  
  public u(e parame)
  {
    if (parame != null)
    {
      x = new e[] { parame };
      return;
    }
    throw new NullPointerException("'element' cannot be null");
  }
  
  public u(f paramf)
  {
    if (paramf != null)
    {
      x = paramf.a();
      return;
    }
    throw new NullPointerException("'elementVector' cannot be null");
  }
  
  public u(e[] paramArrayOfe)
  {
    int i = 0;
    int j;
    if (paramArrayOfe == null)
    {
      j = 1;
    }
    else
    {
      int k = paramArrayOfe.length;
      for (int m = 0;; m++)
      {
        j = i;
        if (m >= k) {
          break label47;
        }
        if (paramArrayOfe[m] == null) {
          break;
        }
      }
    }
    label47:
    if (j == 0)
    {
      x = f.a(paramArrayOfe);
      return;
    }
    throw new NullPointerException("'elements' cannot be null, or contain null");
  }
  
  public u(e[] paramArrayOfe, boolean paramBoolean)
  {
    e[] arrayOfe = paramArrayOfe;
    if (paramBoolean) {
      arrayOfe = f.a(paramArrayOfe);
    }
    x = arrayOfe;
  }
  
  public static u a(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof u)))
    {
      if ((paramObject instanceof v)) {
        return a(((v)paramObject).c());
      }
      Object localObject;
      if ((paramObject instanceof byte[])) {
        try
        {
          paramObject = a(t.a((byte[])paramObject));
          return (u)paramObject;
        }
        catch (IOException paramObject)
        {
          localObject = e.a.a.a.a.a("failed to construct sequence from byte[]: ");
          ((StringBuilder)localObject).append(((IOException)paramObject).getMessage());
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      if ((paramObject instanceof e))
      {
        localObject = ((e)paramObject).c();
        if ((localObject instanceof u)) {
          return (u)localObject;
        }
      }
      throw new IllegalArgumentException(e.a.a.a.a.a(paramObject, e.a.a.a.a.a("unknown object in getInstance: ")));
    }
    return (u)paramObject;
  }
  
  public static u a(b0 paramb0, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (y) {
        return a(paramb0.j());
      }
      throw new IllegalArgumentException("object implicit - explicit expected.");
    }
    Object localObject = paramb0.j();
    if (y)
    {
      if ((paramb0 instanceof n0)) {
        return new j0((e)localObject);
      }
      return new r1((e)localObject);
    }
    if ((localObject instanceof u))
    {
      localObject = (u)localObject;
      if ((paramb0 instanceof n0)) {
        return (u)localObject;
      }
      return (u)((u)localObject).i();
    }
    localObject = e.a.a.a.a.a("unknown object in getInstance: ");
    ((StringBuilder)localObject).append(paramb0.getClass().getName());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public e a(int paramInt)
  {
    return x[paramInt];
  }
  
  public boolean a(t paramt)
  {
    if (!(paramt instanceof u)) {
      return false;
    }
    u localu = (u)paramt;
    int i = size();
    if (localu.size() != i) {
      return false;
    }
    for (int j = 0; j < i; j++)
    {
      t localt = x[j].c();
      paramt = x[j].c();
      if ((localt != paramt) && (!localt.a(paramt))) {
        return false;
      }
    }
    return true;
  }
  
  public boolean g()
  {
    return true;
  }
  
  public t h()
  {
    return new e1(x, false);
  }
  
  public int hashCode()
  {
    int i = x.length;
    for (int j = i + 1;; j = j * 257 ^ x[i].c().hashCode())
    {
      i--;
      if (i < 0) {
        break;
      }
    }
    return j;
  }
  
  public t i()
  {
    return new r1(x, false);
  }
  
  public Iterator<e> iterator()
  {
    return new k.b.j.a(x);
  }
  
  public Enumeration j()
  {
    return new u.a(this);
  }
  
  public e[] k()
  {
    return x;
  }
  
  public int size()
  {
    return x.length;
  }
  
  public String toString()
  {
    int i = size();
    if (i == 0) {
      return "[]";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append('[');
    int j = 0;
    for (;;)
    {
      localStringBuffer.append(x[j]);
      j++;
      if (j >= i)
      {
        localStringBuffer.append(']');
        return localStringBuffer.toString();
      }
      localStringBuffer.append(", ");
    }
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.u
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */