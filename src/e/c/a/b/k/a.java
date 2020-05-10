package e.c.a.b.k;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.StateSet;

public class a
{
  public static final int[] a = { 16842919 };
  public static final int[] b = { 16843623, 16842908 };
  public static final int[] c = { 16842908 };
  public static final int[] d = { 16843623 };
  public static final int[] e = { 16842913, 16842919 };
  public static final int[] f = { 16842913, 16843623, 16842908 };
  public static final int[] g = { 16842913, 16842908 };
  public static final int[] h = { 16842913, 16843623 };
  public static final int[] i = { 16842913 };
  
  public static int a(ColorStateList paramColorStateList, int[] paramArrayOfInt)
  {
    int j;
    if (paramColorStateList != null) {
      j = paramColorStateList.getColorForState(paramArrayOfInt, paramColorStateList.getDefaultColor());
    } else {
      j = 0;
    }
    return d.i.c.a.b(j, Math.min(Color.alpha(j) * 2, 255));
  }
  
  public static ColorStateList a(ColorStateList paramColorStateList)
  {
    int[] arrayOfInt1 = i;
    int j = a(paramColorStateList, e);
    int[] arrayOfInt2 = StateSet.NOTHING;
    int k = a(paramColorStateList, a);
    return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2 }, new int[] { j, k });
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.b.k.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */