package no.simula.corona;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import d.b.a.h;
import h.e;
import j.b.a.a0;
import j.b.a.e0.a;
import j.b.a.y;
import j.b.a.z;

public final class SplashActivity
  extends a
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558433);
    paramBundle = Build.FINGERPRINT;
    h.k.b.g.a(paramBundle, "Build.FINGERPRINT");
    if (!h.o.g.a(paramBundle, "generic", false, 2))
    {
      paramBundle = Build.FINGERPRINT;
      h.k.b.g.a(paramBundle, "Build.FINGERPRINT");
      if (!h.o.g.a(paramBundle, "unknown", false, 2))
      {
        paramBundle = Build.MODEL;
        h.k.b.g.a(paramBundle, "Build.MODEL");
        if (!h.o.g.a(paramBundle, "google_sdk", false, 2))
        {
          paramBundle = Build.MODEL;
          h.k.b.g.a(paramBundle, "Build.MODEL");
          if (!h.o.g.a(paramBundle, "Emulator", false, 2))
          {
            paramBundle = Build.MODEL;
            h.k.b.g.a(paramBundle, "Build.MODEL");
            if ((!h.o.g.a(paramBundle, "Android SDK built for x86", false, 2)) && (!h.k.b.g.a(Build.BOARD, "QC_Reference_Phone")))
            {
              paramBundle = Build.MANUFACTURER;
              h.k.b.g.a(paramBundle, "Build.MANUFACTURER");
              if (!h.o.g.a(paramBundle, "Genymotion", false, 2))
              {
                paramBundle = Build.BRAND;
                h.k.b.g.a(paramBundle, "Build.BRAND");
                if (h.o.g.a(paramBundle, "generic", false, 2))
                {
                  paramBundle = Build.DEVICE;
                  h.k.b.g.a(paramBundle, "Build.DEVICE");
                  if (h.o.g.a(paramBundle, "generic", false, 2)) {}
                }
                else if (!h.k.b.g.a("google_sdk", Build.PRODUCT))
                {
                  i = 0;
                  break label211;
                }
              }
            }
          }
        }
      }
    }
    int i = 1;
    label211:
    if (i != 0)
    {
      paramBundle = new AlertDialog.Builder(this);
      paramBundle.setTitle(2131886111);
      paramBundle.setMessage("This app cannot run on this system");
      paramBundle.setPositiveButton(2131886196, new y(this));
      paramBundle.setOnDismissListener(new z(this));
      paramBundle.create();
      paramBundle.show();
      return;
    }
    paramBundle = new SplashActivity.a(this);
    long l;
    if (a0.i(this)) {
      l = 2000L;
    } else {
      l = 1000L;
    }
    paramBundle.sendEmptyMessageDelayed(0, l);
    paramBundle = getSystemService("notification");
    if (paramBundle != null)
    {
      NotificationManager localNotificationManager = (NotificationManager)paramBundle;
      paramBundle = CoronaApp.z;
      if (paramBundle != null) {
        y = false;
      }
      localNotificationManager.cancel(13);
      return;
    }
    throw new e("null cannot be cast to non-null type android.app.NotificationManager");
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.SplashActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */