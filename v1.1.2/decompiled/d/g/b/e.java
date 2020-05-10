package d.g.b;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout.a;

public class e
  extends View
{
  public e(Context paramContext)
  {
    super(paramContext);
    super.setVisibility(8);
  }
  
  public void draw(Canvas paramCanvas) {}
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(0, 0);
  }
  
  public void setGuidelineBegin(int paramInt)
  {
    ConstraintLayout.a locala = (ConstraintLayout.a)getLayoutParams();
    a = paramInt;
    setLayoutParams(locala);
  }
  
  public void setGuidelineEnd(int paramInt)
  {
    ConstraintLayout.a locala = (ConstraintLayout.a)getLayoutParams();
    b = paramInt;
    setLayoutParams(locala);
  }
  
  public void setGuidelinePercent(float paramFloat)
  {
    ConstraintLayout.a locala = (ConstraintLayout.a)getLayoutParams();
    c = paramFloat;
    setLayoutParams(locala);
  }
  
  public void setVisibility(int paramInt) {}
}

/* Location:
 * Qualified Name:     d.g.b.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */