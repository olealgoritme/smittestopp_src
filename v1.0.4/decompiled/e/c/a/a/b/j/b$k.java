package e.c.a.a.b.j;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import e.c.a.a.b.a;
import e.c.a.a.b.i.d.a;
import e.c.a.a.b.i.d.b;

public final class b$k
  extends b.f
{
  public final IBinder g;
  
  public b$k(b paramb, int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    super(paramb, paramInt, paramBundle);
    g = paramIBinder;
  }
  
  public final void a(a parama)
  {
    b.b localb = h.n;
    if (localb != null) {
      a.a(parama);
    }
    if (h != null)
    {
      int i = y;
      System.currentTimeMillis();
      return;
    }
    throw null;
  }
  
  public final boolean d()
  {
    try
    {
      String str = g.getInterfaceDescriptor();
      if (!h.l().equals(str))
      {
        localObject = h.l();
        int i = String.valueOf(localObject).length();
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str).length() + (i + 34));
        localStringBuilder.append("service descriptor mismatch: ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" vs. ");
        localStringBuilder.append(str);
        Log.e("GmsClient", localStringBuilder.toString());
        return false;
      }
      Object localObject = h.a(g);
      if ((localObject != null) && ((h.a(2, 4, (IInterface)localObject)) || (h.a(3, 4, (IInterface)localObject))))
      {
        localObject = h;
        q = null;
        localObject = m;
        if (localObject != null) {
          a.a(null);
        }
        return true;
      }
      return false;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("GmsClient", "service probably died");
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.j.b.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */