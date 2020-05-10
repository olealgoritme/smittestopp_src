package e.c.a.a.b.j;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import e.c.a.a.b.m.a;
import e.c.a.a.b.m.b;
import javax.annotation.concurrent.GuardedBy;

public final class h0
{
  public static Object a = new Object();
  @GuardedBy("sLock")
  public static boolean b;
  public static int c;
  
  public static void a(Context paramContext)
  {
    synchronized (a)
    {
      if (b) {
        return;
      }
      b = true;
      String str = paramContext.getPackageName();
      paramContext = b.b(paramContext);
      try
      {
        paramContext = a.getPackageManager().getApplicationInfo(str, 128).metaData;
        if (paramContext == null) {
          return;
        }
        paramContext.getString("com.google.app.id");
        c = paramContext.getInt("com.google.android.gms.version");
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.wtf("MetadataValueReader", "This should never happen.", paramContext);
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.j.h0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */