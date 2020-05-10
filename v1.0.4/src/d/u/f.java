package d.u;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import androidx.room.MultiInstanceInvalidationService;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class f
{
  public final Context a;
  public final String b;
  public int c;
  public final e d;
  public final e.c e;
  public d f;
  public final Executor g;
  public final c h = new f.a(this);
  public final AtomicBoolean i = new AtomicBoolean(false);
  public final ServiceConnection j = new f.b(this);
  public final Runnable k = new f.c(this);
  public final Runnable l = new f.d(this);
  
  public f(Context paramContext, String paramString, e parame, Executor paramExecutor)
  {
    a = paramContext.getApplicationContext();
    b = paramString;
    d = parame;
    g = paramExecutor;
    e = new f.e(this, b);
    paramContext = new Intent(a, MultiInstanceInvalidationService.class);
    a.bindService(paramContext, j, 1);
  }
}

/* Location:
 * Qualified Name:     base.d.u.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */