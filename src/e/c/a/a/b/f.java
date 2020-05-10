package e.c.a.a.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;

public final class f
  extends g
{
  public static Resources a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getResourcesForApplication("com.google.android.gms");
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext = null;
    }
    return paramContext;
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */