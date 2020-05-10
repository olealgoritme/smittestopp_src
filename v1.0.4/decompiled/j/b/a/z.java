package j.b.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import no.simula.corona.SplashActivity;

public final class z
  implements DialogInterface.OnDismissListener
{
  public z(SplashActivity paramSplashActivity) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    x.finishAffinity();
  }
}

/* Location:
 * Qualified Name:     base.j.b.a.z
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */