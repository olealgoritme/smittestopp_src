package l.a.a.b.e;

public class a<L, R>
  extends b<L, R>
{
  public L x;
  public R y;
  
  public a(L paramL, R paramR)
  {
    x = paramL;
    y = paramR;
  }
  
  public R setValue(R paramR)
  {
    Object localObject = y;
    y = paramR;
    return (R)localObject;
  }
}

/* Location:
 * Qualified Name:     l.a.a.b.e.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */