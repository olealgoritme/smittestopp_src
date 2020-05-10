package d.d.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.text.TextUtils;

public class b
{
  public final c.a.a.b a;
  public final ComponentName b;
  
  public b(c.a.a.b paramb, ComponentName paramComponentName)
  {
    a = paramb;
    b = paramComponentName;
  }
  
  public static boolean a(Context paramContext, String paramString, d paramd)
  {
    Intent localIntent = new Intent("android.support.customtabs.action.CustomTabsService");
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.setPackage(paramString);
    }
    return paramContext.bindService(localIntent, paramd, 33);
  }
  
  public e a(a parama)
  {
    b.a locala = new b.a(this);
    parama = null;
    try
    {
      boolean bool = a.a(locala);
      if (!bool) {
        return null;
      }
      parama = new e(a, locala, b);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
    return parama;
  }
}

/* Location:
 * Qualified Name:     base.d.d.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */