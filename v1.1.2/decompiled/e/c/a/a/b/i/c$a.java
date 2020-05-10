package e.c.a.a.b.i;

import android.os.Looper;
import e.c.a.a.b.i.k.a;

public class c$a
{
  public final a a;
  public final Looper b;
  
  static
  {
    new a().a();
  }
  
  public static class a
  {
    public a a;
    public Looper b;
    
    public c.a a()
    {
      if (a == null) {
        a = new a();
      }
      if (b == null) {
        b = Looper.getMainLooper();
      }
      return new c.a(a, null, b);
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.i.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */