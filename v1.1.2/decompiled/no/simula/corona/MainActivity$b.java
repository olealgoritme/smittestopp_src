package no.simula.corona;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import i.k.a.a;
import k.b.a.t;

public final class MainActivity$b
  extends i.k.b.h
  implements a<i.h>
{
  public MainActivity$b(int paramInt, Object paramObject)
  {
    super(0);
  }
  
  public final Object invoke()
  {
    int i = x;
    if (i != 0)
    {
      if (i == 1)
      {
        Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        localIntent.setData(Uri.fromParts("package", ((MainActivity)y).getPackageName(), null));
        ((MainActivity)y).startActivity(localIntent);
        return i.h.a;
      }
      throw null;
    }
    t.d((MainActivity)y, false);
    MainActivity.b((MainActivity)y);
    return i.h.a;
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.MainActivity.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */