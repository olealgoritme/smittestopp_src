package k.b.a.l2;

import k.b.a.b0;
import k.b.a.e1;
import k.b.a.n;
import k.b.a.t;
import k.b.a.u;
import k.b.j.f;

public class m
  extends n
{
  public final l[] x;
  
  public m(u paramu)
  {
    x = new l[paramu.size()];
    for (int i = 0; i != paramu.size(); i++) {
      x[i] = l.a(paramu.a(i));
    }
  }
  
  public static m a(Object paramObject)
  {
    if ((paramObject instanceof m)) {
      return (m)paramObject;
    }
    if (paramObject != null) {
      return new m(u.a(paramObject));
    }
    return null;
  }
  
  public static m a(b0 paramb0, boolean paramBoolean)
  {
    return new m(u.a(paramb0, paramBoolean));
  }
  
  public t c()
  {
    return new e1(x);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = f.a;
    localStringBuffer.append("GeneralNames:");
    localStringBuffer.append(str);
    for (int i = 0; i != x.length; i++)
    {
      localStringBuffer.append("    ");
      localStringBuffer.append(x[i]);
      localStringBuffer.append(str);
    }
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     base.k.b.a.l2.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */