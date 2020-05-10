package androidx.appcompat.widget;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.AutoCompleteTextView;

public class SearchView$a
  implements TextWatcher
{
  public SearchView$a(SearchView paramSearchView) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    SearchView localSearchView = x;
    Editable localEditable = M.getText();
    z0 = localEditable;
    boolean bool = TextUtils.isEmpty(localEditable) ^ true;
    localSearchView.a(bool);
    localSearchView.c(bool ^ true);
    localSearchView.h();
    localSearchView.k();
    if ((k0 != null) && (!TextUtils.equals(paramCharSequence, y0))) {
      k0.a(paramCharSequence.toString());
    }
    y0 = paramCharSequence.toString();
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.widget.SearchView.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */