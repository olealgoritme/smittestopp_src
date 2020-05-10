package d.b.a;

import android.content.Context;
import android.content.IntentFilter;
import android.os.PowerManager;

public class k$f
  extends k.g
{
  public final PowerManager c;
  
  public k$f(k paramk, Context paramContext)
  {
    super(paramk);
    c = ((PowerManager)paramContext.getSystemService("power"));
  }
  
  public IntentFilter b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
    return localIntentFilter;
  }
  
  public int c()
  {
    int i;
    if (c.isPowerSaveMode()) {
      i = 2;
    } else {
      i = 1;
    }
    return i;
  }
  
  public void d()
  {
    d.d();
  }
}

/* Location:
 * Qualified Name:     base.d.b.a.k.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */