package d.b.a;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import androidx.appcompat.app.AlertController;

public class d
  implements AbsListView.OnScrollListener
{
  public d(AlertController paramAlertController, View paramView1, View paramView2) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AlertController.a(paramAbsListView, a, b);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}

/* Location:
 * Qualified Name:     d.b.a.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */