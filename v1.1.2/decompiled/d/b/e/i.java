package d.b.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.R.styleable;
import d.b.a.s;
import d.b.b.a.a;

public class i
{
  public final CompoundButton a;
  public ColorStateList b = null;
  public PorterDuff.Mode c = null;
  public boolean d = false;
  public boolean e = false;
  public boolean f;
  
  public i(CompoundButton paramCompoundButton)
  {
    a = paramCompoundButton;
  }
  
  public void a()
  {
    Drawable localDrawable = s.a(a);
    if ((localDrawable != null) && ((d) || (e)))
    {
      localDrawable = s.c(localDrawable).mutate();
      if (d) {
        localDrawable.setTintList(b);
      }
      if (e) {
        localDrawable.setTintMode(c);
      }
      if (localDrawable.isStateful()) {
        localDrawable.setState(a.getDrawableState());
      }
      a.setButtonDrawable(localDrawable);
    }
  }
  
  public void a(AttributeSet paramAttributeSet, int paramInt)
  {
    TypedArray localTypedArray = a.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.CompoundButton, paramInt, 0);
    try
    {
      if (localTypedArray.hasValue(R.styleable.CompoundButton_android_button))
      {
        paramInt = localTypedArray.getResourceId(R.styleable.CompoundButton_android_button, 0);
        if (paramInt != 0) {
          a.setButtonDrawable(a.c(a.getContext(), paramInt));
        }
      }
      if (localTypedArray.hasValue(R.styleable.CompoundButton_buttonTint)) {
        a.setButtonTintList(localTypedArray.getColorStateList(R.styleable.CompoundButton_buttonTint));
      }
      if (localTypedArray.hasValue(R.styleable.CompoundButton_buttonTintMode)) {
        a.setButtonTintMode(c0.a(localTypedArray.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));
      }
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */