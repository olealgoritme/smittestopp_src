package d.b.e;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R.styleable;
import d.b.a.s;
import d.i.i.n;

public class u
  extends q
{
  public final SeekBar d;
  public Drawable e;
  public ColorStateList f = null;
  public PorterDuff.Mode g = null;
  public boolean h = false;
  public boolean i = false;
  
  public u(SeekBar paramSeekBar)
  {
    super(paramSeekBar);
    d = paramSeekBar;
  }
  
  public final void a()
  {
    if ((e != null) && ((h) || (i)))
    {
      Drawable localDrawable = s.c(e.mutate());
      e = localDrawable;
      if (h) {
        localDrawable.setTintList(f);
      }
      if (i) {
        e.setTintMode(g);
      }
      if (e.isStateful()) {
        e.setState(d.getDrawableState());
      }
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if (e != null)
    {
      int j = d.getMax();
      int k = 1;
      if (j > 1)
      {
        int m = e.getIntrinsicWidth();
        int n = e.getIntrinsicHeight();
        if (m >= 0) {
          m /= 2;
        } else {
          m = 1;
        }
        if (n >= 0) {
          k = n / 2;
        }
        e.setBounds(-m, -k, m, k);
        float f1 = (d.getWidth() - d.getPaddingLeft() - d.getPaddingRight()) / j;
        k = paramCanvas.save();
        paramCanvas.translate(d.getPaddingLeft(), d.getHeight() / 2);
        for (m = 0; m <= j; m++)
        {
          e.draw(paramCanvas);
          paramCanvas.translate(f1, 0.0F);
        }
        paramCanvas.restoreToCount(k);
      }
    }
  }
  
  public void a(AttributeSet paramAttributeSet, int paramInt)
  {
    super.a(paramAttributeSet, paramInt);
    paramAttributeSet = u0.a(d.getContext(), paramAttributeSet, R.styleable.AppCompatSeekBar, paramInt, 0);
    Drawable localDrawable1 = paramAttributeSet.c(R.styleable.AppCompatSeekBar_android_thumb);
    if (localDrawable1 != null) {
      d.setThumb(localDrawable1);
    }
    localDrawable1 = paramAttributeSet.b(R.styleable.AppCompatSeekBar_tickMark);
    Drawable localDrawable2 = e;
    if (localDrawable2 != null) {
      localDrawable2.setCallback(null);
    }
    e = localDrawable1;
    if (localDrawable1 != null)
    {
      localDrawable1.setCallback(d);
      s.a(localDrawable1, n.i(d));
      if (localDrawable1.isStateful()) {
        localDrawable1.setState(d.getDrawableState());
      }
      a();
    }
    d.invalidate();
    if (paramAttributeSet.e(R.styleable.AppCompatSeekBar_tickMarkTintMode))
    {
      g = c0.a(paramAttributeSet.d(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), g);
      i = true;
    }
    if (paramAttributeSet.e(R.styleable.AppCompatSeekBar_tickMarkTint))
    {
      f = paramAttributeSet.a(R.styleable.AppCompatSeekBar_tickMarkTint);
      h = true;
    }
    b.recycle();
    a();
  }
}

/* Location:
 * Qualified Name:     d.b.e.u
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */