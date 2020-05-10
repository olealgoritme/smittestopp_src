package e.c.a.a.b.j;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import d.b.a.s;

public final class b$i
  extends l.a
{
  public b a;
  public final int b;
  
  public b$i(b paramb, int paramInt)
  {
    a = paramb;
    b = paramInt;
  }
  
  public final void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    s.b(a, "onPostInitComplete can be called only once per call to getRemoteService");
    b localb = a;
    int i = b;
    Handler localHandler = d;
    localHandler.sendMessage(localHandler.obtainMessage(1, i, -1, new b.k(localb, paramInt, paramIBinder, paramBundle)));
    a = null;
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.j.b.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */