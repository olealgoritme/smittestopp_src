package d.b.d.i;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

public class h
  implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, m.a
{
  public g x;
  public d.b.a.g y;
  public e z;
  
  public h(g paramg)
  {
    x = paramg;
  }
  
  public void a(g paramg, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramg == x))
    {
      paramg = y;
      if (paramg != null) {
        paramg.dismiss();
      }
    }
  }
  
  public boolean a(g paramg)
  {
    return false;
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    x.a((i)z.a().getItem(paramInt), 0);
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    Object localObject = z;
    paramDialogInterface = x;
    localObject = E;
    if (localObject != null) {
      ((m.a)localObject).a(paramDialogInterface, true);
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
 * Qualified Name:     base.d.b.d.i.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */