package l.d.a;

public final class q
{
  public final Object a;
  public final o b;
  public volatile boolean c;
  
  public q(Object paramObject, o paramo)
  {
    a = paramObject;
    b = paramo;
    c = true;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof q;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = (q)paramObject;
      bool3 = bool2;
      if (a == a)
      {
        bool3 = bool2;
        if (b.equals(b)) {
          bool3 = true;
        }
      }
    }
    return bool3;
  }
  
  public int hashCode()
  {
    int i = a.hashCode();
    return b.f.hashCode() + i;
  }
}

/* Location:
 * Qualified Name:     l.d.a.q
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */