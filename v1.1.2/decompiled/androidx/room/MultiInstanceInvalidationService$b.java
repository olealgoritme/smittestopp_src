package androidx.room;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import d.u.c;
import d.u.d.a;
import java.util.HashMap;

public class MultiInstanceInvalidationService$b
  extends d.a
{
  public MultiInstanceInvalidationService$b(MultiInstanceInvalidationService paramMultiInstanceInvalidationService) {}
  
  public int a(c paramc, String paramString)
  {
    if (paramString == null) {
      return 0;
    }
    synchronized (a.z)
    {
      MultiInstanceInvalidationService localMultiInstanceInvalidationService = a;
      int i = x + 1;
      x = i;
      if (a.z.register(paramc, Integer.valueOf(i)))
      {
        a.y.put(Integer.valueOf(i), paramString);
        return i;
      }
      paramc = a;
      x -= 1;
      return 0;
    }
  }
  
  public void a(int paramInt, String[] paramArrayOfString)
  {
    synchronized (a.z)
    {
      String str1 = (String)a.y.get(Integer.valueOf(paramInt));
      if (str1 == null)
      {
        Log.w("ROOM", "Remote invalidation client ID not registered");
        return;
      }
      int i = a.z.beginBroadcast();
      int j = 0;
      while (j < i) {
        try
        {
          int k = ((Integer)a.z.getBroadcastCookie(j)).intValue();
          String str2 = (String)a.y.get(Integer.valueOf(k));
          if (paramInt != k)
          {
            boolean bool = str1.equals(str2);
            if (bool) {
              try
              {
                ((c)a.z.getBroadcastItem(j)).a(paramArrayOfString);
              }
              catch (RemoteException localRemoteException)
              {
                Log.w("ROOM", "Error invoking a remote callback", localRemoteException);
              }
            }
          }
          j++;
        }
        finally
        {
          a.z.finishBroadcast();
        }
      }
      a.z.finishBroadcast();
      return;
    }
  }
  
  public void a(c paramc, int paramInt)
  {
    synchronized (a.z)
    {
      a.z.unregister(paramc);
      a.y.remove(Integer.valueOf(paramInt));
      return;
    }
  }
}

/* Location:
 * Qualified Name:     androidx.room.MultiInstanceInvalidationService.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */