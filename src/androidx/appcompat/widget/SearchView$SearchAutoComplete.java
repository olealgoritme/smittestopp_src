package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.R.attr;
import d.b.e.d;
import java.lang.reflect.Method;

public class SearchView$SearchAutoComplete
  extends d
{
  public int A = getThreshold();
  public SearchView B;
  public boolean C;
  public final Runnable D = new SearchView.SearchAutoComplete.a(this);
  
  public SearchView$SearchAutoComplete(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SearchView$SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.autoCompleteTextViewStyle);
  }
  
  public SearchView$SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int getSearchViewTextMinWidthDp()
  {
    Configuration localConfiguration = getResources().getConfiguration();
    int i = screenWidthDp;
    int j = screenHeightDp;
    if ((i >= 960) && (j >= 720) && (orientation == 2)) {
      return 256;
    }
    if ((i < 600) && ((i < 640) || (j < 480))) {
      return 160;
    }
    return 192;
  }
  
  public boolean enoughToFilter()
  {
    boolean bool;
    if ((A > 0) && (!super.enoughToFilter())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    paramEditorInfo = super.onCreateInputConnection(paramEditorInfo);
    if (C)
    {
      removeCallbacks(D);
      post(D);
    }
    return paramEditorInfo;
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    setMinWidth((int)TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), localDisplayMetrics));
  }
  
  public void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    paramRect = B;
    paramRect.b(q0);
    paramRect.post(E0);
    if (M.hasFocus()) {
      paramRect.d();
    }
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      KeyEvent.DispatcherState localDispatcherState;
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        localDispatcherState = getKeyDispatcherState();
        if (localDispatcherState != null) {
          localDispatcherState.startTracking(paramKeyEvent, this);
        }
        return true;
      }
      if (paramKeyEvent.getAction() == 1)
      {
        localDispatcherState = getKeyDispatcherState();
        if (localDispatcherState != null) {
          localDispatcherState.handleUpEvent(paramKeyEvent);
        }
        if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
        {
          B.clearFocus();
          setImeVisibility(false);
          return true;
        }
      }
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    Method localMethod;
    if ((paramBoolean) && (B.hasFocus()) && (getVisibility() == 0))
    {
      C = true;
      if (SearchView.a(getContext()))
      {
        localMethod = N0c;
        if (localMethod == null) {}
      }
    }
    try
    {
      localMethod.invoke(this, new Object[] { Boolean.valueOf(true) });
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void performCompletion() {}
  
  public void replaceText(CharSequence paramCharSequence) {}
  
  public void setImeVisibility(boolean paramBoolean)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (!paramBoolean)
    {
      C = false;
      removeCallbacks(D);
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      return;
    }
    if (localInputMethodManager.isActive(this))
    {
      C = false;
      removeCallbacks(D);
      localInputMethodManager.showSoftInput(this, 0);
      return;
    }
    C = true;
  }
  
  public void setSearchView(SearchView paramSearchView)
  {
    B = paramSearchView;
  }
  
  public void setThreshold(int paramInt)
  {
    super.setThreshold(paramInt);
    A = paramInt;
  }
}

/* Location:
 * Qualified Name:     base.androidx.appcompat.widget.SearchView.SearchAutoComplete
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */