package d.b.e;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import d.b.a.s;
import d.b.b.a.a;

public class h
  extends CheckedTextView
{
  public static final int[] y = { 16843016 };
  public final x x;
  
  public h(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 16843720);
    paramContext = new x(this);
    x = paramContext;
    paramContext.a(paramAttributeSet, 16843720);
    x.a();
    paramContext = u0.a(getContext(), paramAttributeSet, y, 16843720, 0);
    setCheckMarkDrawable(paramContext.b(0));
    b.recycle();
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    x localx = x;
    if (localx != null) {
      localx.a();
    }
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    s.a(localInputConnection, paramEditorInfo, this);
    return localInputConnection;
  }
  
  public void setCheckMarkDrawable(int paramInt)
  {
    setCheckMarkDrawable(a.c(getContext(), paramInt));
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(s.a(this, paramCallback));
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    x localx = x;
    if (localx != null) {
      localx.a(paramContext, paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */