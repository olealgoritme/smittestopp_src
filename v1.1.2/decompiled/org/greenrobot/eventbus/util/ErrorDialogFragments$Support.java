package org.greenrobot.eventbus.util;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class ErrorDialogFragments$Support
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  public Dialog a(Bundle paramBundle)
  {
    Object localObject = getActivity();
    paramBundle = getArguments();
    localObject = new AlertDialog.Builder((Context)localObject);
    ((AlertDialog.Builder)localObject).setTitle(paramBundle.getString("de.greenrobot.eventbus.errordialog.title"));
    ((AlertDialog.Builder)localObject).setMessage(paramBundle.getString("de.greenrobot.eventbus.errordialog.message"));
    ((AlertDialog.Builder)localObject).setPositiveButton(17039370, this);
    return ((AlertDialog.Builder)localObject).create();
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = getActivity();
    if ((getArguments().getBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", false)) && (paramDialogInterface != null)) {
      paramDialogInterface.finish();
    }
  }
}

/* Location:
 * Qualified Name:     org.greenrobot.eventbus.util.ErrorDialogFragments.Support
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */