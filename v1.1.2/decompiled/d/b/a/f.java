package d.b.a;

import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertController.b;

public class f
  implements AdapterView.OnItemClickListener
{
  public f(AlertController.b paramb, AlertController paramAlertController) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    y.k.onClick(x.b, paramInt);
    if (!y.m) {
      x.b.dismiss();
    }
  }
}

/* Location:
 * Qualified Name:     d.b.a.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */