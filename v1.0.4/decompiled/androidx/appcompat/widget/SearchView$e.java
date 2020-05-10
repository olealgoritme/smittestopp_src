package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.R.dimen;
import d.b.e.d1;

public class SearchView$e
  implements View.OnLayoutChangeListener
{
  public SearchView$e(SearchView paramSearchView) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    SearchView localSearchView = a;
    if (U.getWidth() > 1)
    {
      Resources localResources = localSearchView.getContext().getResources();
      paramInt3 = O.getPaddingLeft();
      paramView = new Rect();
      boolean bool = d1.a(localSearchView);
      if (p0)
      {
        paramInt1 = localResources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width);
        paramInt1 = localResources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) + paramInt1;
      }
      else
      {
        paramInt1 = 0;
      }
      M.getDropDownBackground().getPadding(paramView);
      if (bool) {
        paramInt2 = -left;
      } else {
        paramInt2 = paramInt3 - (left + paramInt1);
      }
      M.setDropDownHorizontalOffset(paramInt2);
      paramInt4 = U.getWidth();
      paramInt5 = left;
      paramInt2 = right;
      M.setDropDownWidth(paramInt4 + paramInt5 + paramInt2 + paramInt1 - paramInt3);
    }
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.widget.SearchView.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */