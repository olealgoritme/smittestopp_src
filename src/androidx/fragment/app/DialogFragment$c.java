package androidx.fragment.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

public class DialogFragment$c
  implements DialogInterface.OnDismissListener
{
  public DialogFragment$c(DialogFragment paramDialogFragment) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    DialogFragment localDialogFragment = x;
    paramDialogInterface = G;
    if (paramDialogInterface != null) {
      localDialogFragment.onDismiss(paramDialogInterface);
    }
  }
}

/* Location:
 * Qualified Name:     base.androidx.fragment.app.DialogFragment.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */