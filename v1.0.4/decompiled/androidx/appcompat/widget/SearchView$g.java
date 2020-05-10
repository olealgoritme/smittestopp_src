package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.AutoCompleteTextView;
import java.lang.reflect.Method;

public class SearchView$g
  implements View.OnKeyListener
{
  public SearchView$g(SearchView paramSearchView) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    SearchView localSearchView = x;
    SearchableInfo localSearchableInfo = C0;
    boolean bool1 = false;
    if (localSearchableInfo == null) {
      return false;
    }
    boolean bool2;
    if ((M.isPopupShowing()) && (x.M.getListSelection() != -1))
    {
      paramView = x;
      if (C0 == null)
      {
        bool2 = bool1;
      }
      else if (r0 == null)
      {
        bool2 = bool1;
      }
      else
      {
        bool2 = bool1;
        if (paramKeyEvent.getAction() == 0)
        {
          bool2 = bool1;
          if (paramKeyEvent.hasNoModifiers()) {
            if ((paramInt != 66) && (paramInt != 84) && (paramInt != 61))
            {
              if ((paramInt != 21) && (paramInt != 22))
              {
                bool2 = bool1;
                if (paramInt != 19) {
                  break label260;
                }
                M.getListSelection();
                bool2 = bool1;
                break label260;
              }
              if (paramInt == 21) {
                paramInt = 0;
              } else {
                paramInt = M.length();
              }
              M.setSelection(paramInt);
              M.setListSelection(0);
              M.clearListSelection();
              paramKeyEvent = SearchView.N0;
              paramView = M;
              paramKeyEvent = c;
              if (paramKeyEvent == null) {}
            }
          }
        }
      }
    }
    try
    {
      paramKeyEvent.invoke(paramView, new Object[] { Boolean.valueOf(true) });
      bool2 = true;
      break label260;
      bool2 = paramView.b(M.getListSelection());
      label260:
      return bool2;
      int i;
      if (TextUtils.getTrimmedLength(x.M.getText()) == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i == 0) && (paramKeyEvent.hasNoModifiers()) && (paramKeyEvent.getAction() == 1) && (paramInt == 66))
      {
        paramView.cancelLongPress();
        paramView = x;
        paramView.a(0, null, M.getText().toString());
        return true;
      }
      return false;
    }
    catch (Exception paramView)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.widget.SearchView.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */