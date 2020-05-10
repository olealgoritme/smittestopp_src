package d.b.d.i;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.widget.ListAdapter;
import d.b.a.g;

public class i
  implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, o.a
{
  public h x;
  public g y;
  public f z;
  
  public i(h paramh)
  {
    x = paramh;
  }
  
  public void a(h paramh, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramh == x))
    {
      paramh = y;
      if (paramh != null) {
        paramh.dismiss();
      }
    }
  }
  
  public boolean a(h paramh)
  {
    return false;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    x.a((j)z.a().getItem(paramInt), 0);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    Object localObject = z;
    paramDialogInterface = x;
    localObject = E;
    if (localObject != null) {
      ((o.a)localObject).a(paramDialogInterface, true);
    }
  }
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) || (paramInt == 4)) {
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        paramDialogInterface = y.getWindow();
        if (paramDialogInterface != null)
        {
          paramDialogInterface = paramDialogInterface.getDecorView();
          if (paramDialogInterface != null)
          {
            paramDialogInterface = paramDialogInterface.getKeyDispatcherState();
            if (paramDialogInterface != null)
            {
              paramDialogInterface.startTracking(paramKeyEvent, this);
              return true;
            }
          }
        }
      }
      else if ((paramKeyEvent.getAction() == 1) && (!paramKeyEvent.isCanceled()))
      {
        Object localObject = y.getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          if (localObject != null)
          {
            localObject = ((View)localObject).getKeyDispatcherState();
            if ((localObject != null) && (((KeyEvent.DispatcherState)localObject).isTracking(paramKeyEvent)))
            {
              x.a(true);
              paramDialogInterface.dismiss();
              return true;
            }
          }
        }
      }
    }
    return x.performShortcut(paramInt, paramKeyEvent, 0);
  }
}

/* Location:
 * Qualified Name:     d.b.d.i.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */