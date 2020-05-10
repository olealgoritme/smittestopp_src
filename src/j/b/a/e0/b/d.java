package j.b.a.e0.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import no.simula.corona.ui.main.SettingsFragment;

public final class d
  implements DialogInterface.OnClickListener
{
  public d(SettingsFragment paramSettingsFragment) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1) {
      SettingsFragment.a(x);
    }
  }
}

/* Location:
 * Qualified Name:     base.j.b.a.e0.b.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */