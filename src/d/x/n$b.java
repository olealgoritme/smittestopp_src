package d.x;

public class n$b
  extends k
{
  public n a;
  
  public n$b(n paramn)
  {
    a = paramn;
  }
  
  public void c(h paramh)
  {
    paramh = a;
    if (!i0)
    {
      paramh.d();
      a.i0 = true;
    }
  }
  
  public void d(h paramh)
  {
    n localn = a;
    int i = h0 - 1;
    h0 = i;
    if (i == 0)
    {
      i0 = false;
      localn.a();
    }
    paramh.b(this);
  }
}

/* Location:
 * Qualified Name:     base.d.x.n.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */