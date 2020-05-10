package d.i.a;

import android.app.Activity;
import android.content.pm.PackageManager;

public final class a$a
  implements Runnable
{
  public a$a(String[] paramArrayOfString, Activity paramActivity, int paramInt) {}
  
  public void run()
  {
    int[] arrayOfInt = new int[x.length];
    PackageManager localPackageManager = y.getPackageManager();
    String str = y.getPackageName();
    int i = x.length;
    for (int j = 0; j < i; j++) {
      arrayOfInt[j] = localPackageManager.checkPermission(x[j], str);
    }
    ((a.b)y).onRequestPermissionsResult(z, x, arrayOfInt);
  }
}

/* Location:
 * Qualified Name:     base.d.i.a.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */