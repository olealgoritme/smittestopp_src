package e.c.a.a.b.j;

import android.content.Context;
import android.content.ServiceConnection;

public abstract class i
{
  public static final Object a = new Object();
  public static i b;
  
  public static i a(Context paramContext)
  {
    synchronized (a)
    {
      if (b == null)
      {
        c0 localc0 = new e/c/a/a/b/j/c0;
        localc0.<init>(paramContext.getApplicationContext());
        b = localc0;
      }
      return b;
    }
  }
  
  public abstract boolean a(i.a parama, ServiceConnection paramServiceConnection, String paramString);
  
  public abstract void b(i.a parama, ServiceConnection paramServiceConnection, String paramString);
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.j.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */