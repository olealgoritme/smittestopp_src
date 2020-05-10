package d.i.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import d.b.a.s;
import d.i.b.a;
import java.util.ArrayList;
import java.util.Iterator;

public final class j
  implements Iterable<Intent>
{
  public final ArrayList<Intent> x = new ArrayList();
  public final Context y;
  
  public j(Context paramContext)
  {
    y = paramContext;
  }
  
  public j a(ComponentName paramComponentName)
  {
    int i = x.size();
    try
    {
      for (paramComponentName = s.a(y, paramComponentName); paramComponentName != null; paramComponentName = s.a(y, paramComponentName.getComponent())) {
        x.add(i, paramComponentName);
      }
      return this;
    }
    catch (PackageManager.NameNotFoundException paramComponentName)
    {
      Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
      throw new IllegalArgumentException(paramComponentName);
    }
  }
  
  public void a()
  {
    if (!x.isEmpty())
    {
      Object localObject = x;
      localObject = (Intent[])((ArrayList)localObject).toArray(new Intent[((ArrayList)localObject).size()]);
      localObject[0] = new Intent(localObject[0]).addFlags(268484608);
      a.a(y, (Intent[])localObject, null);
      return;
    }
    throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
  }
  
  @Deprecated
  public Iterator<Intent> iterator()
  {
    return x.iterator();
  }
  
  public static abstract interface a
  {
    public abstract Intent g();
  }
}

/* Location:
 * Qualified Name:     d.i.a.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */