package d.b.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;

import d.b.a.r;

public class k
  extends EditText
{
  public final e x;
  public final y y;
  public final x z;
  
  public k(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, i);
    paramContext = new e(this);
    x = paramContext;
    paramContext.a(paramAttributeSet, i);
    paramContext = new y(this);
    y = paramContext;
    paramContext.a(paramAttributeSet, i);
    y.a();
    z = new x(this);
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
  
  public Editable getText()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return super.getText();
    }
    return super.getEditableText();
  }
  
  public TextClassifier getTextClassifier()
  {
    if (Build.VERSION.SDK_INT < 28)
    {
      x localx = z;
      if (localx != null) {
        return localx.a();
      }
    }
    return super.getTextClassifier();
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
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(r.a(this, paramCallback));
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
  
  public void setTextClassifier(TextClassifier paramTextClassifier)
  {
    if (Build.VERSION.SDK_INT < 28)
    {
      x localx = z;
      if (localx != null)
      {
        b = paramTextClassifier;
        return;
      }
    }
    super.setTextClassifier(paramTextClassifier);
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */