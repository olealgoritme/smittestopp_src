package d.b.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

public class s
  extends RatingBar
{
  public final q x;
  
  public s(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, i);
    paramContext = new q(this);
    x = paramContext;
    paramContext.a(paramAttributeSet, i);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      Bitmap localBitmap = x.b;
      if (localBitmap != null) {
        setMeasuredDimension(View.resolveSizeAndState(localBitmap.getWidth() * getNumStars(), paramInt1, 0), getMeasuredHeight());
      }
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     d.b.e.s
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */