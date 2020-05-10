package androidx.fragment.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

public class DialogFragment$b
  implements DialogInterface.OnCancelListener
{
  public DialogFragment$b(DialogFragment paramDialogFragment) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    DialogFragment localDialogFragment = x;
    paramDialogInterface = G;
    if (paramDialogInterface != null) {
      localDialogFragment.onCancel(paramDialogInterface);
    }
  }
}

/* Location:
 * Qualified Name:     androidx.fragment.app.DialogFragment.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */