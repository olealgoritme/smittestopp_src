package d.y.a.a;

import android.animation.TypeEvaluator;
import d.b.a.r;
import d.i.c.b;

public class d
  implements TypeEvaluator<b[]>
{
  public b[] a;
  
  public Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
  {
    paramObject1 = (b[])paramObject1;
    b[] arrayOfb = (b[])paramObject2;
    if (r.a((b[])paramObject1, arrayOfb))
    {
      if (!r.a(a, (b[])paramObject1)) {
        a = r.a((b[])paramObject1);
      }
      int i = 0;
      while (i < paramObject1.length)
      {
        paramObject2 = a[i];
        Object localObject = paramObject1[i];
        b localb = arrayOfb[i];
        if (paramObject2 != null)
        {
          a = ((char)a);
          for (int j = 0;; j++)
          {
            float[] arrayOfFloat1 = b;
            if (j >= arrayOfFloat1.length) {
              break;
            }
            float[] arrayOfFloat2 = b;
            float f = arrayOfFloat1[j];
            arrayOfFloat2[j] = (b[j] * paramFloat + (1.0F - paramFloat) * f);
          }
          i++;
        }
        else
        {
          throw null;
        }
      }
      return a;
    }
    throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
  }
}

/* Location:
 * Qualified Name:     base.d.y.a.a.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */