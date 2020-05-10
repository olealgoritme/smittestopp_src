package l.a.b.a.c;

import e.a.a.a.a;

public class w
  implements q0
{
  public final s a;
  public final q0 b;
  
  public w(s params, q0 paramq0)
  {
    a = params;
    b = paramq0;
  }
  
  public Class b()
  {
    return a.b();
  }
  
  public Object i()
  {
    try
    {
      Object localObject = a.b(b.i());
      return localObject;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new q("Incorrect type used", localClassCastException);
    }
    catch (NullPointerException localNullPointerException)
    {
      StringBuilder localStringBuilder = a.a("Unexpected null value - mandatory field not set? (");
      localStringBuilder.append(localNullPointerException.getMessage());
      localStringBuilder.append(")");
      throw new q(localStringBuilder.toString(), localNullPointerException);
    }
  }
  
  public boolean j()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     l.a.b.a.c.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */