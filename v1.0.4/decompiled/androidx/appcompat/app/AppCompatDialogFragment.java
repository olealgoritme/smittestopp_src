package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import d.b.a.q;

public class AppCompatDialogFragment
  extends DialogFragment
{
  public Dialog a(Bundle paramBundle)
  {
    return new q(getContext(), C);
  }
  
  public void a(Dialog paramDialog, int paramInt)
  {
    if ((paramDialog instanceof q))
    {
      q localq = (q)paramDialog;
      if ((paramInt != 1) && (paramInt != 2))
      {
        if (paramInt == 3) {
          paramDialog.getWindow().addFlags(24);
        }
      }
      else {
        localq.a(1);
      }
    }
    else
    {
      super.a(paramDialog, paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.app.AppCompatDialogFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */