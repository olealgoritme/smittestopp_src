package androidx.appcompat.app;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public final class AlertController$c
  extends Handler
{
  public WeakReference<DialogInterface> a;
  
  public AlertController$c(DialogInterface paramDialogInterface)
  {
    a = new WeakReference(paramDialogInterface);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = what;
    if ((i != -3) && (i != -2) && (i != -1))
    {
      if (i == 1) {
        ((DialogInterface)obj).dismiss();
      }
    }
    else {
      ((DialogInterface.OnClickListener)obj).onClick((DialogInterface)a.get(), what);
    }
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.app.AlertController.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */