package d.u;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;

public enum g$c
{
  static
  {
    c localc = new c("WRITE_AHEAD_LOGGING", 2);
    WRITE_AHEAD_LOGGING = localc;
    $VALUES = new c[] { AUTOMATIC, TRUNCATE, localc };
  }
  
  public g$c() {}
  
  public static boolean isLowRamDevice(ActivityManager paramActivityManager)
  {
    return paramActivityManager.isLowRamDevice();
  }
  
  @SuppressLint({"NewApi"})
  public c resolve(Context paramContext)
  {
    if (this != AUTOMATIC) {
      return this;
    }
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if ((paramContext != null) && (!isLowRamDevice(paramContext))) {
      return WRITE_AHEAD_LOGGING;
    }
    return TRUNCATE;
  }
}

/* Location:
 * Qualified Name:     base.d.u.g.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */