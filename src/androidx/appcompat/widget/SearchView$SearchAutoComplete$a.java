package androidx.appcompat.widget;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;

public class SearchView$SearchAutoComplete$a
  implements Runnable
{
  public SearchView$SearchAutoComplete$a(SearchView.SearchAutoComplete paramSearchAutoComplete) {}
  
  public void run()
  {
    SearchView.SearchAutoComplete localSearchAutoComplete = x;
    if (C)
    {
      ((InputMethodManager)localSearchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(localSearchAutoComplete, 0);
      C = false;
    }
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.widget.SearchView.SearchAutoComplete.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */