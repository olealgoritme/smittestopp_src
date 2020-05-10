package l.d.b.j;

public class d<T>
  extends a<T>
{
  public final b<T> f;
  
  public void a()
  {
    if (Thread.currentThread() == e)
    {
      l.d.b.g.a locala = a.b;
      if (locala.a()) {
        a.b.a(c, d);
      } else {
        locala.beginTransaction();
      }
      try
      {
        a.b.a(c, d);
        locala.setTransactionSuccessful();
        return;
      }
      finally
      {
        locala.endTransaction();
      }
    }
    throw new l.d.b.d("Method may be called only in owner thread, use forCurrentThread to get an instance for this thread");
  }
  
  public d<T> b()
  {
    Object localObject = f;
    if (localObject != null)
    {
      if (Thread.currentThread() == e)
      {
        localObject = c;
        System.arraycopy(localObject, 0, d, 0, localObject.length);
        localObject = this;
      }
      else
      {
        localObject = ((b)localObject).b();
      }
      return (d)localObject;
    }
    throw null;
  }
  
  public static final class b<T2>
    extends b<T2, d<T2>>
  {
    public a a()
    {
      return new d(this, b, a, (String[])c.clone(), null);
    }
  }
}

/* Location:
 * Qualified Name:     l.d.b.j.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */