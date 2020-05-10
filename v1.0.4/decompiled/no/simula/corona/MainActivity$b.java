package no.simula.corona;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import h.k.a.a;
import j.b.a.a0;

public final class MainActivity$b
  extends h.k.b.h
  implements a<h.h>
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
        return h.h.a;
      }
      throw null;
    }
    a0.c((MainActivity)y, false);
    MainActivity.b((MainActivity)y);
    return h.h.a;
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.MainActivity.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */