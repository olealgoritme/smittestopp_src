package k.b.a.z.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import no.simula.corona.ui.main.SettingsFragment;

public final class c
  implements DialogInterface.OnClickListener
{
  public c(SettingsFragment paramSettingsFragment) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != -2)
    {
      if (paramInt == -1) {
        SettingsFragment.d(x);
      }
    }
    else {
      SettingsFragment.f(x);
    }
  }
}

/* Location:
 * Qualified Name:     k.b.a.z.b.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */