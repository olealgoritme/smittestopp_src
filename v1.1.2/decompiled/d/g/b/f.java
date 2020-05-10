package d.g.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout.a;

public class f
  extends View
{
  public int x;
  public View y;
  public int z;
  
  public View getContent()
  {
    return y;
  }
  
  public int getEmptyVisibility()
  {
    return z;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (isInEditMode())
    {
      paramCanvas.drawRGB(223, 223, 223);
      Paint localPaint = new Paint();
      localPaint.setARGB(255, 210, 210, 210);
      localPaint.setTextAlign(Paint.Align.CENTER);
      localPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
      Rect localRect = new Rect();
      paramCanvas.getClipBounds(localRect);
      localPaint.setTextSize(localRect.height());
      int i = localRect.height();
      int j = localRect.width();
      localPaint.setTextAlign(Paint.Align.LEFT);
      localPaint.getTextBounds("?", 0, 1, localRect);
      float f1 = j / 2.0F;
      float f2 = localRect.width() / 2.0F;
      float f3 = left;
      float f4 = i / 2.0F;
      paramCanvas.drawText("?", f1 - f2 - f3, localRect.height() / 2.0F + f4 - bottom, localPaint);
    }
  }
  
  public void setContentId(int paramInt)
  {
    if (x == paramInt) {
      return;
    }
    View localView = y;
    if (localView != null)
    {
      localView.setVisibility(0);
      y.getLayoutParams()).Z = false;
      y = null;
    }
    x = paramInt;
    if (paramInt != -1)
    {
      localView = ((View)getParent()).findViewById(paramInt);
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
  }
  
  public void setEmptyVisibility(int paramInt)
  {
    z = paramInt;
  }
}

/* Location:
 * Qualified Name:     d.g.b.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */