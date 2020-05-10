package d.i.c;

import android.graphics.Color;

public final class a
{
  static
  {
    new ThreadLocal();
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i = Color.alpha(paramInt2);
    int j = Color.alpha(paramInt1);
    int k = 255 - (255 - j) * (255 - i) / 255;
    return Color.argb(k, a(Color.red(paramInt1), j, Color.red(paramInt2), i, k), a(Color.green(paramInt1), j, Color.green(paramInt2), i, k), a(Color.blue(paramInt1), j, Color.blue(paramInt2), i, k));
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 == 0) {
      return 0;
    }
    return ((255 - paramInt2) * (paramInt3 * paramInt4) + paramInt1 * 255 * paramInt2) / (paramInt5 * 255);
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    if ((paramInt2 >= 0) && (paramInt2 <= 255)) {
      return paramInt1 & 0xFFFFFF | paramInt2 << 24;
    }
    throw new IllegalArgumentException("alpha must be between 0 and 255.");
  }
}

/* Location:
 * Qualified Name:     base.d.i.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */