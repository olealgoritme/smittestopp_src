package d.b.e;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;

import androidx.appcompat.R.styleable;

import d.b.a.r;

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
    Drawable localDrawable = r.a(a);
    if ((localDrawable != null) && ((d) || (e)))
    {
      localDrawable = r.c(localDrawable).mutate();
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
    paramAttributeSet = a.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.CompoundButton, paramInt, 0);
    for (;;)
    {
      try
      {
        if (paramAttributeSet.hasValue(R.styleable.CompoundButton_buttonCompat))
        {
          paramInt = paramAttributeSet.getResourceId(R.styleable.CompoundButton_buttonCompat, 0);
          if (paramInt == 0) {}
        }
      }
      finally
      {
        paramAttributeSet.recycle();
      }
      try
      {
        a.setButtonDrawable(a.c(a.getContext(), paramInt));
        paramInt = 1;
      }
      catch (Resources.NotFoundException localNotFoundException) {}
    }
    paramInt = 0;
    if ((paramInt == 0) && (paramAttributeSet.hasValue(R.styleable.CompoundButton_android_button)))
    {
      paramInt = paramAttributeSet.getResourceId(R.styleable.CompoundButton_android_button, 0);
      if (paramInt != 0) {
        a.setButtonDrawable(a.c(a.getContext(), paramInt));
      }
    }
    if (paramAttributeSet.hasValue(R.styleable.CompoundButton_buttonTint)) {
      a.setButtonTintList(paramAttributeSet.getColorStateList(R.styleable.CompoundButton_buttonTint));
    }
    if (paramAttributeSet.hasValue(R.styleable.CompoundButton_buttonTintMode)) {
      a.setButtonTintMode(e0.a(paramAttributeSet.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));
    }
    paramAttributeSet.recycle();
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */