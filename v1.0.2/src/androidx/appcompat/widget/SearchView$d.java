package androidx.appcompat.widget;

import android.view.View;
import android.view.View.OnFocusChangeListener;

public class SearchView$d
  implements View.OnFocusChangeListener
{
  public SearchView$d(SearchView paramSearchView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    SearchView localSearchView = x;
    paramView = m0;
    if (paramView != null) {
      paramView.onFocusChange(localSearchView, paramBoolean);
    }
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.widget.SearchView.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */