package d.u;

import d.w.a.f;

public abstract class b<T>
  extends k
{
  public b(g paramg)
  {
    super(paramg);
  }
  
  public abstract void a(f paramf, T paramT);
  
  public final void a(T[] paramArrayOfT)
  {
    f localf = a();
    try
    {
      int i = paramArrayOfT.length;
      for (int j = 0; j < i; j++)
      {
        a(localf, paramArrayOfT[j]);
        localf.executeInsert();
      }
      return;
    }
    finally
    {
      a(localf);
    }
  }
}

/* Location:
 * Qualified Name:     d.u.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */