package d.b.e;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

import d.b.a.r;
import d.b.b.a.a;

public class h
  extends CheckedTextView
{
  public static final int[] y = { 16843016 };
  public final y x;
  
  public h(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 16843720);
    paramContext = new y(this);
    x = paramContext;
    paramContext.a(paramAttributeSet, 16843720);
    x.a();
    paramContext = x0.a(getContext(), paramAttributeSet, y, 16843720, 0);
    setCheckMarkDrawable(paramContext.b(0));
    b.recycle();
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    y localy = x;
    if (localy != null) {
      localy.a();
    }
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    r.a(localInputConnection, paramEditorInfo, this);
    return localInputConnection;
  }
  
  public void setCheckMarkDrawable(int paramInt)
  {
    setCheckMarkDrawable(a.c(getContext(), paramInt));
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(r.a(this, paramCallback));
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    y localy = x;
    if (localy != null) {
      localy.a(paramContext, paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */