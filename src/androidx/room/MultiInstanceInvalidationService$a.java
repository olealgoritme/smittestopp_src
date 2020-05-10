package androidx.room;

import android.os.IInterface;
import android.os.RemoteCallbackList;
import d.u.c;
import java.util.HashMap;

public class MultiInstanceInvalidationService$a
  extends RemoteCallbackList<c>
{
  public MultiInstanceInvalidationService$a(MultiInstanceInvalidationService paramMultiInstanceInvalidationService) {}
  
  public void onCallbackDied(IInterface paramIInterface, Object paramObject)
  {
    paramIInterface = (c)paramIInterface;
    a.y.remove(Integer.valueOf(((Integer)paramObject).intValue()));
  }
}

/* Location:
 * Qualified Name:     base.androidx.room.MultiInstanceInvalidationService.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */