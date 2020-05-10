package d.e.a;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

public class b
  implements d
{
  public final e a(c paramc)
  {
    return (e)paramc.b();
  }
  
  public void a(c paramc, float paramFloat)
  {
    e locale = a(paramc);
    boolean bool1 = paramc.a();
    boolean bool2 = paramc.c();
    if ((paramFloat == b) && (c == bool1) && (d == bool2))
    {
      if (!paramc.a())
      {
        paramc.a(0, 0, 0, 0);
      }
      else
      {
        float f = ab;
        paramFloat = aa;
        int i = (int)Math.ceil(f.a(f, paramFloat, paramc.c()));
        int j = (int)Math.ceil(f.b(f, paramFloat, paramc.c()));
        paramc.a(i, j, i, j);
      }
      return;
    }
    b = paramFloat;
    c = bool1;
    d = bool2;
    locale.a(null);
    throw null;
  }
  
  public void a(c paramc, ColorStateList paramColorStateList)
  {
    e locale = a(paramc);
    if (locale != null)
    {
      paramc = paramColorStateList;
      if (paramColorStateList == null) {
        paramc = ColorStateList.valueOf(0);
      }
      e = paramc;
      paramc.getColorForState(locale.getState(), e.getDefaultColor());
      throw null;
    }
    throw null;
  }
  
  public float b(c paramc)
  {
    return ab;
  }
  
  public float c(c paramc)
  {
    return aa;
  }
}

/* Location:
 * Qualified Name:     base.d.e.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */