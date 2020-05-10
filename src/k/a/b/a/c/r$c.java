package k.a.b.a.c;

import k.a.b.a.b.e;

public class r$c
  implements e
{
  public final Object a;
  public final Object b;
  
  public r$c(Object paramObject1, Object paramObject2)
  {
    a = paramObject1;
    b = paramObject2;
  }
  
  public Object a()
  {
    return a;
  }
  
  public Object b()
  {
    return b;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof e;
    boolean bool2 = true;
    if ((bool1) && (a == null))
    {
      if (((e)paramObject).a() == null) {}
    }
    else
    {
      do
      {
        return false;
        Object localObject = a;
        paramObject = (e)paramObject;
        if ((!localObject.equals(((e)paramObject).a())) || (b != null)) {
          break;
        }
      } while (((e)paramObject).b() != null);
      return bool2;
      bool2 = b.equals(((e)paramObject).b());
    }
    return bool2;
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.c.r.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */