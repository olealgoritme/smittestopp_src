package e.c.a.a.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
public class h
{
  public static h a;
  
  public h(Context paramContext)
  {
    paramContext.getApplicationContext();
  }
  
  public static h a(Context paramContext)
  {
    d.b.a.r.a(paramContext);
    try
    {
      if (a == null)
      {
        p.a(paramContext);
        h localh = new e/c/a/a/b/h;
        localh.<init>(paramContext);
        a = localh;
      }
      return a;
    }
    finally {}
  }
  
  public static q a(PackageInfo paramPackageInfo, q... paramVarArgs)
  {
    Signature[] arrayOfSignature = signatures;
    if (arrayOfSignature == null) {
      return null;
    }
    if (arrayOfSignature.length != 1)
    {
      Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
      return null;
    }
    paramPackageInfo = signatures;
    int i = 0;
    paramPackageInfo = new r(paramPackageInfo[0].toByteArray());
    while (i < paramVarArgs.length)
    {
      if (paramVarArgs[i].equals(paramPackageInfo)) {
        return paramVarArgs[i];
      }
      i++;
    }
    return null;
  }
  
  public static boolean a(PackageInfo paramPackageInfo, boolean paramBoolean)
  {
    if ((paramPackageInfo != null) && (signatures != null))
    {
      if (paramBoolean) {
        paramPackageInfo = a(paramPackageInfo, t.a);
      } else {
        paramPackageInfo = a(paramPackageInfo, new q[] { t.a[0] });
      }
      if (paramPackageInfo != null) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */