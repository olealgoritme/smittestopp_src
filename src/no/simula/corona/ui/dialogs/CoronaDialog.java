package no.simula.corona.ui.dialogs;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import h.k.b.g;

public final class CoronaDialog
  extends DialogFragment
{
  public DialogInterface.OnClickListener K;
  
  public static final CoronaDialog a(int paramInt1, int paramInt2)
  {
    CoronaDialog localCoronaDialog = new CoronaDialog();
    Bundle localBundle = new Bundle();
    localBundle.putInt("title", paramInt1);
    localBundle.putInt("message", paramInt2);
    localCoronaDialog.setArguments(localBundle);
    return localCoronaDialog;
  }
  
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
        paramBundle = new AlertDialog.Builder(getActivity()).setTitle(i).setMessage(j).setPositiveButton(17039370, K).setNegativeButton(17039360, K).create();
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
 * Qualified Name:     base.no.simula.corona.ui.dialogs.CoronaDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */