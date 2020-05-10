package e.f.a;

import java.util.ArrayList;
import java.util.Arrays;

public final class a
{
  public static final String[] a = { "com.noshufou.android.su", "com.noshufou.android.su.elite", "eu.chainfire.supersu", "com.koushikdutta.superuser", "com.thirdparty.superuser", "com.yellowes.su", "com.topjohnwu.magisk", "com.kingroot.kinguser", "com.kingo.root", "com.smedialink.oneclickroot", "com.zhiqupk.root.global", "com.alephzain.framaroot" };
  public static final String[] b = { "/data/local/", "/data/local/bin/", "/data/local/xbin/", "/sbin/", "/su/bin/", "/system/bin/", "/system/bin/.ext/", "/system/bin/failsafe/", "/system/sd/xbin/", "/system/usr/we-need-root/", "/system/xbin/", "/cache/", "/data/", "/dev/" };
  public static final String[] c = { "/system", "/system/bin", "/system/sbin", "/system/xbin", "/vendor/bin", "/sbin", "/etc" };
  
  public static String[] a()
  {
    ArrayList localArrayList = new ArrayList(Arrays.asList(b));
    Object localObject = System.getenv("PATH");
    if ((localObject != null) && (!"".equals(localObject)))
    {
      for (String str : ((String)localObject).split(":"))
      {
        localObject = str;
        if (!str.endsWith("/"))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append('/');
          localObject = ((StringBuilder)localObject).toString();
        }
        if (!localArrayList.contains(localObject)) {
          localArrayList.add(localObject);
        }
      }
      return (String[])localArrayList.toArray(new String[0]);
    }
    return (String[])localArrayList.toArray(new String[0]);
  }
}

/* Location:
 * Qualified Name:     e.f.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */