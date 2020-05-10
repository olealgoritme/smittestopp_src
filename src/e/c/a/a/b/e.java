package e.c.a.a.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import e.c.a.a.b.j.e0;
import e.c.a.a.b.l.c;
import e.c.a.a.b.m.b;
import java.util.Iterator;
import java.util.List;

public class e
{
  public static final int a = g.a;
  
  public int a(Context paramContext, int paramInt)
  {
    paramInt = g.a(paramContext, paramInt);
    boolean bool = true;
    if ((paramInt == 18) || (paramInt == 1)) {}
    try
    {
      Object localObject = paramContext.getPackageManager().getPackageInstaller().getAllSessions();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if ("com.google.android.gms".equals(((PackageInstaller.SessionInfo)((Iterator)localObject).next()).getAppPackageName())) {
          break label100;
        }
      }
      paramContext = paramContext.getPackageManager();
      bool = getApplicationInfo"com.google.android.gms"8192enabled;
    }
    catch (Exception|PackageManager.NameNotFoundException paramContext)
    {
      label100:
      for (;;) {}
    }
    bool = false;
    if (bool) {
      paramInt = 18;
    }
    return paramInt;
  }
  
  public Intent a(Context paramContext, int paramInt, String paramString)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      if (paramInt != 3) {
        return null;
      }
      return e0.a("com.google.android.gms");
    }
    if ((paramContext != null) && (c.b(paramContext))) {
      return e0.a();
    }
    StringBuilder localStringBuilder = e.a.a.a.a.a("gcore_");
    localStringBuilder.append(a);
    localStringBuilder.append("-");
    if (!TextUtils.isEmpty(paramString)) {
      localStringBuilder.append(paramString);
    }
    localStringBuilder.append("-");
    if (paramContext != null) {
      localStringBuilder.append(paramContext.getPackageName());
    }
    localStringBuilder.append("-");
    if (paramContext != null) {}
    try
    {
      paramString = b.b(paramContext);
      paramContext = paramContext.getPackageName();
      localStringBuilder.append(a.getPackageManager().getPackageInfo(paramContext, 0).versionCode);
      return e0.a("com.google.android.gms", localStringBuilder.toString());
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */