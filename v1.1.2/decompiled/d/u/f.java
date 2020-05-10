package d.u;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.MultiInstanceInvalidationService;
import java.util.Set;
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
  public final c h = new a();
  public final AtomicBoolean i = new AtomicBoolean(false);
  public final ServiceConnection j = new b();
  public final Runnable k = new c();
  public final Runnable l = new d();
  
  public f(Context paramContext, String paramString, e parame, Executor paramExecutor)
  {
    a = paramContext.getApplicationContext();
    b = paramString;
    d = parame;
    g = paramExecutor;
    e = new e(b);
    paramContext = new Intent(a, MultiInstanceInvalidationService.class);
    a.bindService(paramContext, j, 1);
  }
  
  public class a
    extends c.a
  {
    public a() {}
    
    public void a(final String[] paramArrayOfString)
    {
      g.execute(new a(paramArrayOfString));
    }
    
    public class a
      implements Runnable
    {
      public a(String[] paramArrayOfString) {}
      
      public void run()
      {
        d.a(paramArrayOfString);
      }
    }
  }
  
  public class b
    implements ServiceConnection
  {
    public b() {}
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      f = d.a.a(paramIBinder);
      paramComponentName = f.this;
      g.execute(k);
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      paramComponentName = f.this;
      g.execute(l);
      f = null;
    }
  }
  
  public class c
    implements Runnable
  {
    public c() {}
    
    public void run()
    {
      try
      {
        d locald = f;
        if (locald != null)
        {
          c = locald.a(h, b);
          d.a(e);
        }
      }
      catch (RemoteException localRemoteException)
      {
        Log.w("ROOM", "Cannot register multi-instance invalidation callback", localRemoteException);
      }
    }
  }
  
  public class d
    implements Runnable
  {
    public d() {}
    
    public void run()
    {
      f localf = f.this;
      d.b(e);
    }
  }
  
  public class e
    extends e.c
  {
    public e(String[] paramArrayOfString)
    {
      super();
    }
    
    public void a(Set<String> paramSet)
    {
      if (i.get()) {
        return;
      }
      try
      {
        d locald = f;
        if (locald != null) {
          locald.a(c, (String[])paramSet.toArray(new String[0]));
        }
      }
      catch (RemoteException paramSet)
      {
        Log.w("ROOM", "Cannot broadcast invalidation", paramSet);
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.u.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */