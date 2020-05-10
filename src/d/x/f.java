package d.x;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

public class f
  implements TypeEvaluator<Rect>
{
  public Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
  {
    paramObject1 = (Rect)paramObject1;
    paramObject2 = (Rect)paramObject2;
    int i = left;
    int j = (int)((left - i) * paramFloat);
    int k = top;
    int m = (int)((top - k) * paramFloat);
    int n = right;
    int i1 = (int)((right - n) * paramFloat);
    int i2 = bottom;
    return new Rect(i + j, k + m, n + i1, i2 + (int)((bottom - i2) * paramFloat));
  }
}

/* Location:
 * Qualified Name:     base.d.x.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */