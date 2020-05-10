package e.c.a.a.d.c;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Log;
import e.c.a.a.b.i.d.a;
import e.c.a.a.b.i.d.b;
import e.c.a.a.b.i.k.f;
import javax.annotation.Nullable;

public final class o
  extends v
{
  public final i z = new i(paramContext, y);
  
  public o(Context paramContext, Looper paramLooper, d.a parama, d.b paramb, String paramString, @Nullable e.c.a.a.b.j.d paramd)
  {
    super(paramContext, paramLooper, parama, paramb, paramString, paramd);
  }
  
  public final void a(q paramq, f<e.c.a.a.e.b> paramf, d paramd)
  {
    synchronized (z)
    {
      Object localObject = z;
      a.a();
      paramf = ((i)localObject).a(paramf);
      localObject = (g)a.b();
      s locals = new e/c/a/a/d/c/s;
      IBinder localIBinder = paramf.asBinder();
      if (paramd != null) {
        paramf = paramd.asBinder();
      } else {
        paramf = null;
      }
      locals.<init>(1, paramq, null, null, localIBinder, paramf);
      ((g)localObject).a(locals);
      return;
    }
  }
  
  public final void e()
  {
    synchronized (z)
    {
      boolean bool = c();
      if (bool) {
        try
        {
          z.a();
          z.b();
        }
        catch (Exception localException)
        {
          Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", localException);
        }
      }
      super.e();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.d.c.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */