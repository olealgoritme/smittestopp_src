package androidx.appcompat.app;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

public class AlertController$a
  implements View.OnClickListener
{
  public AlertController$a(AlertController paramAlertController) {}
  
  public void onClick(View paramView)
  {
    Object localObject = x;
    if (paramView == o)
    {
      localObject = q;
      if (localObject != null)
      {
        paramView = Message.obtain((Message)localObject);
        break label92;
      }
    }
    localObject = x;
    if (paramView == s)
    {
      localObject = u;
      if (localObject != null)
      {
        paramView = Message.obtain((Message)localObject);
        break label92;
      }
    }
    localObject = x;
    if (paramView == w)
    {
      paramView = y;
      if (paramView != null)
      {
        paramView = Message.obtain(paramView);
        break label92;
      }
    }
    paramView = null;
    label92:
    if (paramView != null) {
      paramView.sendToTarget();
    }
    paramView = x;
    R.obtainMessage(1, b).sendToTarget();
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.app.AlertController.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */