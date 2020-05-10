package no.simula.corona.ui.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import d.i.b.a;
import i.k.b.g;
import no.simula.corona.R.styleable;

public final class DotPageIndicator
  extends View
{
  public int A;
  public Paint B;
  public Paint C;
  public int x;
  public int y;
  public int z;
  
  public DotPageIndicator(Context paramContext)
  {
    super(paramContext);
    a(null, 0);
  }
  
  public DotPageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramAttributeSet, 0);
  }
  
  public DotPageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet, paramInt);
  }
  
  public final void a(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.DotPageIndicator, paramInt, 0);
    z = paramAttributeSet.getColor(0, a.a(getContext(), 2131099794));
    A = paramAttributeSet.getColor(2, a.a(getContext(), 2131099803));
    y = paramAttributeSet.getColor(1, 3);
    paramAttributeSet.recycle();
    paramAttributeSet = new Paint(1);
    B = paramAttributeSet;
    if (paramAttributeSet != null)
    {
      paramAttributeSet.setColor(z);
      paramAttributeSet = new Paint(1);
      C = paramAttributeSet;
      if (paramAttributeSet != null)
      {
        paramAttributeSet.setColor(A);
        return;
      }
      g.a();
      throw null;
    }
    g.a();
    throw null;
  }
  
  public final int getSelected()
  {
    return x;
  }
  
  public final int getSelectedColor()
  {
    return z;
  }
  
  public final Paint getSelectedPaint()
  {
    return B;
  }
  
  public final int getTotalDots()
  {
    return y;
  }
  
  public final int getUnSelectedColor()
  {
    return A;
  }
  
  public final Paint getUnSelectedPaint()
  {
    return C;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (paramCanvas != null)
    {
      super.onDraw(paramCanvas);
      int i = getHeight();
      int j = i / 2;
      int k = i / 4;
      i = getWidth();
      int m = y;
      int n = i / m;
      i = 0;
      while (i < m)
      {
        int i1 = n * i + n / 2;
        float f1;
        float f2;
        float f3;
        Paint localPaint;
        if (i == x)
        {
          f1 = i1;
          f2 = j;
          f3 = k;
          localPaint = B;
          if (localPaint != null)
          {
            paramCanvas.drawCircle(f1, f2, f3, localPaint);
          }
          else
          {
            g.a();
            throw null;
          }
        }
        else
        {
          f3 = i1;
          f1 = j;
          f2 = k;
          localPaint = C;
          if (localPaint == null) {
            break label155;
          }
          paramCanvas.drawCircle(f3, f1, f2, localPaint);
        }
        i++;
        continue;
        label155:
        g.a();
        throw null;
      }
      return;
    }
    g.a("canvas");
    throw null;
  }
  
  public final void setSelected(int paramInt)
  {
    x = paramInt;
    invalidate();
  }
  
  public final void setSelectedColor(int paramInt)
  {
    z = paramInt;
  }
  
  public final void setSelectedPaint(Paint paramPaint)
  {
    B = paramPaint;
  }
  
  public final void setTotalDots(int paramInt)
  {
    y = paramInt;
  }
  
  public final void setUnSelectedColor(int paramInt)
  {
    A = paramInt;
  }
  
  public final void setUnSelectedPaint(Paint paramPaint)
  {
    C = paramPaint;
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.ui.widgets.DotPageIndicator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */