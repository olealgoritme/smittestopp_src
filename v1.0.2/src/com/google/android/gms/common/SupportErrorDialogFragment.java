package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import d.m.a.p;

public class SupportErrorDialogFragment
  extends DialogFragment
{
  public Dialog K = null;
  public DialogInterface.OnCancelListener L = null;
  
  public Dialog a(Bundle paramBundle)
  {
    if (K == null) {
      E = false;
    }
    return K;
  }
  
  public void a(p paramp, String paramString)
  {
    super.a(paramp, paramString);
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    DialogInterface.OnCancelListener localOnCancelListener = L;
    if (localOnCancelListener != null) {
      localOnCancelListener.onCancel(paramDialogInterface);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.gms.common.SupportErrorDialogFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */