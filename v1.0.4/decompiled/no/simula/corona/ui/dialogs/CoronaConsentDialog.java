package no.simula.corona.ui.dialogs;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import h.k.b.g;

public final class CoronaConsentDialog
  extends DialogFragment
{
  public Dialog a(Bundle paramBundle)
  {
    paramBundle = getArguments();
    if (paramBundle != null) {
      paramBundle = Integer.valueOf(paramBundle.getInt("title"));
    } else {
      paramBundle = null;
    }
    if (paramBundle != null)
    {
      int i = paramBundle.intValue();
      paramBundle = getArguments();
      if (paramBundle != null) {
        paramBundle = Integer.valueOf(paramBundle.getInt("message"));
      } else {
        paramBundle = null;
      }
      if (paramBundle != null)
      {
        int j = paramBundle.intValue();
        paramBundle = new AlertDialog.Builder(getActivity()).setTitle(i).setMessage(j).setCancelable(false).setPositiveButton(17039379, null).setNegativeButton(17039369, null).create();
        g.a(paramBundle, "AlertDialog.Builder(getA…er)\n            .create()");
        return paramBundle;
      }
      g.a();
      throw null;
    }
    g.a();
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.ui.dialogs.CoronaConsentDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */