package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import d.u.c;
import d.u.d.a;
import java.util.HashMap;

public class MultiInstanceInvalidationService
  extends Service
{
  public final d.a A = new MultiInstanceInvalidationService.b(this);
  public int x = 0;
  public final HashMap<Integer, String> y = new HashMap();
  public final RemoteCallbackList<c> z = new MultiInstanceInvalidationService.a(this);
  
  public IBinder onBind(Intent paramIntent)
  {
    return A;
  }
}

/* Location:
 * Qualified Name:     base.androidx.room.MultiInstanceInvalidationService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */