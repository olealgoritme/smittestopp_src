package e.c.a.a.b.i.k;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import e.c.a.a.g.h;

public abstract class e0<T>
  extends w
{
  public final e.c.a.a.g.b<T> a;
  
  public e0(int paramInt, e.c.a.a.g.b<T> paramb)
  {
    super(paramInt);
    a = paramb;
  }
  
  public void a(Status paramStatus)
  {
    e.c.a.a.g.b localb = a;
    paramStatus = new e.c.a.a.b.i.b(paramStatus);
    a.b(paramStatus);
  }
  
  public final void a(c.a<?> parama)
  {
    try
    {
      d(parama);
      return;
    }
    catch (RuntimeException parama)
    {
      a.a.b(parama);
      return;
    }
    catch (RemoteException parama)
    {
      localObject1 = m.a(parama);
      parama = a;
      localObject1 = new e.c.a.a.b.i.b((Status)localObject1);
      a.b((Exception)localObject1);
      return;
    }
    catch (DeadObjectException parama)
    {
      Object localObject2 = m.a(parama);
      Object localObject1 = a;
      localObject2 = new e.c.a.a.b.i.b((Status)localObject2);
      a.b((Exception)localObject2);
      throw parama;
    }
  }
  
  public abstract void d(c.a<?> parama);
}

/* Location:
 * Qualified Name:     e.c.a.a.b.i.k.e0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */