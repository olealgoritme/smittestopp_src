package androidx.fragment.app;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

public class DialogFragment$c
  implements DialogInterface.OnDismissListener
{
  public DialogFragment$c(DialogFragment paramDialogFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = x;
    Dialog localDialog = G;
    if (localDialog != null) {
      paramDialogInterface.onDismiss(localDialog);
    }
  }
}

/* Location:
 * Qualified Name:     androidx.fragment.app.DialogFragment.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */