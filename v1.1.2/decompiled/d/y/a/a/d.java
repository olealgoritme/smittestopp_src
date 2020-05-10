package d.y.a.a;

import android.animation.TypeEvaluator;
import d.b.a.s;
import d.i.c.b;

public class d
  implements TypeEvaluator<b[]>
{
  public b[] a;
  
  public Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
  {
    paramObject1 = (b[])paramObject1;
    paramObject2 = (b[])paramObject2;
    if (s.a((b[])paramObject1, (b[])paramObject2))
    {
      Object localObject1 = a;
      if ((localObject1 == null) || (!s.a((b[])localObject1, (b[])paramObject1))) {
        a = s.a((b[])paramObject1);
      }
      int i = 0;
      while (i < paramObject1.length)
      {
        b localb = a[i];
        Object localObject2 = paramObject1[i];
        Object localObject3 = paramObject2[i];
        if (localb != null)
        {
          a = ((char)a);
          for (int j = 0;; j++)
          {
            localObject1 = b;
            if (j >= localObject1.length) {
              break;
            }
            float[] arrayOfFloat = b;
            float f = localObject1[j];
            arrayOfFloat[j] = (b[j] * paramFloat + (1.0F - paramFloat) * f);
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
 * Qualified Name:     d.y.a.a.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */