package e.c.a.b.a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

public class f
  implements TypeEvaluator<Matrix>
{
  public final float[] a = new float[9];
  public final float[] b = new float[9];
  public final Matrix c = new Matrix();
  
  public Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
  {
    paramObject1 = (Matrix)paramObject1;
    paramObject2 = (Matrix)paramObject2;
    ((Matrix)paramObject1).getValues(a);
    ((Matrix)paramObject2).getValues(b);
    for (int i = 0; i < 9; i++)
    {
      paramObject1 = b;
      float f = paramObject1[i];
      paramObject2 = a;
      paramObject1[i] = ((f - paramObject2[i]) * paramFloat + paramObject2[i]);
    }
    c.setValues(b);
    return c;
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.a.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */