package d.b.e;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.PopupWindow;

public class k0$c
  implements AbsListView.OnScrollListener
{
  public k0$c(k0 paramk0) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    int i = 1;
    if (paramInt == 1)
    {
      if (a.Y.getInputMethodMode() == 2) {
        paramInt = i;
      } else {
        paramInt = 0;
      }
      if ((paramInt == 0) && (a.Y.getContentView() != null))
      {
        paramAbsListView = a;
        U.removeCallbacks(Q);
        a.Q.run();
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.k0.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */