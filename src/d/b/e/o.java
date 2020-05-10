package d.b.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;

import d.b.a.r;
import d.b.b.a.a;

public class o
  extends MultiAutoCompleteTextView
{
  public static final int[] z = { 16843126 };
  public final e x;
  public final y y;
  
  public o(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, i);
    paramContext = x0.a(getContext(), paramAttributeSet, z, i, 0);
    if (paramContext.f(0)) {
      setDropDownBackgroundDrawable(paramContext.b(0));
    }
    b.recycle();
    paramContext = new e(this);
    x = paramContext;
    paramContext.a(paramAttributeSet, i);
    paramContext = new y(this);
    y = paramContext;
    paramContext.a(paramAttributeSet, i);
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
      ((y)localObject).a();
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
    r.a(localInputConnection, paramEditorInfo, this);
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
    y localy = y;
    if (localy != null) {
      localy.a(paramContext, paramInt);
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */