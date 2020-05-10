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
      String str1 = g.getInterfaceDescriptor();
      if (!h.l().equals(str1))
      {
        String str2 = h.l();
        int i = String.valueOf(str2).length();
        localObject = new StringBuilder(String.valueOf(str1).length() + (i + 34));
        ((StringBuilder)localObject).append("service descriptor mismatch: ");
        ((StringBuilder)localObject).append(str2);
        ((StringBuilder)localObject).append(" vs. ");
        ((StringBuilder)localObject).append(str1);
        Log.e("GmsClient", ((StringBuilder)localObject).toString());
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
 * Qualified Name:     e.c.a.a.b.j.b.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */