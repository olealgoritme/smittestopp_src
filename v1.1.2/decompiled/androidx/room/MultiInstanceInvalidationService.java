package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import d.u.c;
import d.u.d.a;
import java.util.HashMap;

public class MultiInstanceInvalidationService
  extends Service
{
  public final d.a A = new b();
  public int x = 0;
  public final HashMap<Integer, String> y = new HashMap();
  public final RemoteCallbackList<c> z = new a();
  
  public IBinder onBind(Intent paramIntent)
  {
    return A;
  }
  
  public class a
    extends RemoteCallbackList<c>
  {
    public a() {}
    
    public void onCallbackDied(IInterface paramIInterface, Object paramObject)
    {
      paramIInterface = (c)paramIInterface;
      y.remove(Integer.valueOf(((Integer)paramObject).intValue()));
    }
  }
  
  public class b
    extends d.a
  {
    public b() {}
    
    public int a(c paramc, String paramString)
    {
      if (paramString == null) {
        return 0;
      }
      synchronized (z)
      {
        MultiInstanceInvalidationService localMultiInstanceInvalidationService = MultiInstanceInvalidationService.this;
        int i = x + 1;
        x = i;
        if (z.register(paramc, Integer.valueOf(i)))
        {
          y.put(Integer.valueOf(i), paramString);
          return i;
        }
        paramc = MultiInstanceInvalidationService.this;
        x -= 1;
        return 0;
      }
    }
    
    public void a(int paramInt, String[] paramArrayOfString)
    {
      synchronized (z)
      {
        String str1 = (String)y.get(Integer.valueOf(paramInt));
        if (str1 == null)
        {
          Log.w("ROOM", "Remote invalidation client ID not registered");
          return;
        }
        int i = z.beginBroadcast();
        int j = 0;
        while (j < i) {
          try
          {
            int k = ((Integer)z.getBroadcastCookie(j)).intValue();
            String str2 = (String)y.get(Integer.valueOf(k));
            if (paramInt != k)
            {
              boolean bool = str1.equals(str2);
              if (bool) {
                try
                {
                  ((c)z.getBroadcastItem(j)).a(paramArrayOfString);
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
            z.finishBroadcast();
          }
        }
        z.finishBroadcast();
        return;
      }
    }
    
    public void a(c paramc, int paramInt)
    {
      synchronized (z)
      {
        z.unregister(paramc);
        y.remove(Integer.valueOf(paramInt));
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     androidx.room.MultiInstanceInvalidationService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */