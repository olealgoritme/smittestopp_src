package d.b.e;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class t
  extends SeekBar
{
  public final u x;
  
  public t(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, i);
    paramContext = new u(this);
    x = paramContext;
    paramContext.a(paramAttributeSet, i);
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    u localu = x;
    Drawable localDrawable = e;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(d.getDrawableState()))) {
      d.invalidateDrawable(localDrawable);
    }
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    Drawable localDrawable = x.e;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      x.a(paramCanvas);
      return;
    }
    finally
    {
      paramCanvas = finally;
      throw paramCanvas;
    }
  }
}

/* Location:
 * Qualified Name:     d.b.e.t
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */