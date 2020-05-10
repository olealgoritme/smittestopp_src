package d.d.a;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import java.util.ArrayList;

public final class c
{
  public final Intent a;
  public final Bundle b;
  
  public c(Intent paramIntent, Bundle paramBundle)
  {
    a = paramIntent;
    b = paramBundle;
  }
  
  public static final class a
  {
    public final Intent a;
    public ArrayList<Bundle> b;
    public Bundle c;
    public ArrayList<Bundle> d;
    public boolean e;
    
    public a(e parame)
    {
      Object localObject1 = new Intent("android.intent.action.VIEW");
      a = ((Intent)localObject1);
      Object localObject2 = null;
      b = null;
      c = null;
      d = null;
      e = true;
      if (parame != null) {
        ((Intent)localObject1).setPackage(b.getPackageName());
      }
      localObject1 = new Bundle();
      if (parame == null) {
        parame = (e)localObject2;
      } else {
        parame = a.asBinder();
      }
      ((Bundle)localObject1).putBinder("android.support.customtabs.extra.SESSION", parame);
      a.putExtras((Bundle)localObject1);
    }
    
    public c a()
    {
      ArrayList localArrayList = b;
      if (localArrayList != null) {
        a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", localArrayList);
      }
      localArrayList = d;
      if (localArrayList != null) {
        a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", localArrayList);
      }
      a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", e);
      return new c(a, c);
    }
  }
}

/* Location:
 * Qualified Name:     d.d.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */