package d.b.c.a;

import android.animation.TimeInterpolator;
import android.graphics.drawable.AnimationDrawable;

public class a$f
  implements TimeInterpolator
{
  public int[] a;
  public int b;
  public int c;
  
  public a$f(AnimationDrawable paramAnimationDrawable, boolean paramBoolean)
  {
    int i = paramAnimationDrawable.getNumberOfFrames();
    b = i;
    int[] arrayOfInt = a;
    if ((arrayOfInt == null) || (arrayOfInt.length < i)) {
      a = new int[i];
    }
    arrayOfInt = a;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      if (paramBoolean) {
        m = i - j - 1;
      } else {
        m = j;
      }
      int m = paramAnimationDrawable.getDuration(m);
      arrayOfInt[j] = m;
      k += m;
      j++;
    }
    c = k;
  }
  
  public float getInterpolation(float paramFloat)
  {
    int i = (int)(paramFloat * c + 0.5F);
    int j = b;
    int[] arrayOfInt = a;
    for (int k = 0; (k < j) && (i >= arrayOfInt[k]); k++) {
      i -= arrayOfInt[k];
    }
    if (k < j) {
      paramFloat = i / c;
    } else {
      paramFloat = 0.0F;
    }
    return k / j + paramFloat;
  }
}

/* Location:
 * Qualified Name:     d.b.c.a.a.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */