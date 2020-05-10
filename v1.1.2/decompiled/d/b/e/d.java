package d.b.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.R.attr;
import d.b.a.s;
import d.b.b.a.a;

public class d
  extends AutoCompleteTextView
{
  public static final int[] z = { 16843126 };
  public final e x;
  public final x y;
  
  public d(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public d(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.autoCompleteTextViewStyle);
  }
  
  public d(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = u0.a(getContext(), paramAttributeSet, z, paramInt, 0);
    if (paramContext.e(0)) {
      setDropDownBackgroundDrawable(paramContext.b(0));
    }
    b.recycle();
    paramContext = new e(this);
    x = paramContext;
    paramContext.a(paramAttributeSet, paramInt);
    paramContext = new x(this);
    y = paramContext;
    paramContext.a(paramAttributeSet, paramInt);
    y.a();
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    Object localObject = x;
    if (localObject != null) {
      ((e)localObject).a();
    }
    localObject = y;
    if (localObject != null) {
      ((x)localObject).a();
    }
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    Object localObject = x;
    if (localObject != null) {
      localObject = ((e)localObject).b();
    } else {
      localObject = null;
    }
    return (ColorStateList)localObject;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    Object localObject = x;
    if (localObject != null) {
      localObject = ((e)localObject).c();
    } else {
      localObject = null;
    }
    return (PorterDuff.Mode)localObject;
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    s.a(localInputConnection, paramEditorInfo, this);
    return localInputConnection;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    paramDrawable = x;
    if (paramDrawable != null) {
      paramDrawable.d();
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    e locale = x;
    if (locale != null) {
      locale.a(paramInt);
    }
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(s.a(this, paramCallback));
  }
  
  public void setDropDownBackgroundResource(int paramInt)
  {
    setDropDownBackgroundDrawable(a.c(getContext(), paramInt));
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    e locale = x;
    if (locale != null) {
      locale.b(paramColorStateList);
    }
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    e locale = x;
    if (locale != null) {
      locale.a(paramMode);
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    x localx = y;
    if (localx != null) {
      localx.a(paramContext, paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */