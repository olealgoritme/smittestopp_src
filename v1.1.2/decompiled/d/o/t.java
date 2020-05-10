package d.o;

import android.os.Handler;

public class t
  implements l
{
  public static final t F = new t();
  public boolean A = true;
  public Handler B;
  public final m C = new m(this);
  public Runnable D = new a();
  public v.a E = new b();
  public int x = 0;
  public int y = 0;
  public boolean z = true;
  
  public g getLifecycle()
  {
    return C;
  }
  
  public class a
    implements Runnable
  {
    public a() {}
    
    public void run()
    {
      t localt = t.this;
      if (y == 0)
      {
        z = true;
        C.a(g.a.ON_PAUSE);
      }
      localt = t.this;
      if ((x == 0) && (z))
      {
        C.a(g.a.ON_STOP);
        A = true;
      }
    }
  }
  
  public class b
    implements v.a
  {
    public b() {}
  }
}

/* Location:
 * Qualified Name:     d.o.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */