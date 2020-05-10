package d.b.c.a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;

import d.f.e;
import d.f.i;

public class a$c
  extends e.a
{
  public e<Long> K;
  public i<Integer> L;
  
  public a$c(c paramc, a parama, Resources paramResources)
  {
    super(paramc, parama, paramResources);
    if (paramc != null)
    {
      K = K;
      L = L;
    }
    else
    {
      K = new e();
      L = new i(10);
    }
  }
  
  public static long a(int paramInt1, int paramInt2)
  {
    long l = paramInt1;
    return paramInt2 | l << 32;
  }
  
  public int a(int paramInt1, int paramInt2, Drawable paramDrawable, boolean paramBoolean)
  {
    int i = super.a(paramDrawable);
    long l1 = a(paramInt1, paramInt2);
    long l2;
    if (paramBoolean) {
      l2 = 8589934592L;
    } else {
      l2 = 0L;
    }
    paramDrawable = K;
    long l3 = i;
    paramDrawable.a(l1, Long.valueOf(l3 | l2));
    if (paramBoolean)
    {
      l1 = a(paramInt2, paramInt1);
      K.a(l1, Long.valueOf(0x100000000 | l3 | l2));
    }
    return i;
  }
  
  public int b(int paramInt)
  {
    int i = 0;
    if (paramInt < 0) {
      paramInt = i;
    } else {
      paramInt = ((Integer)L.b(paramInt, Integer.valueOf(0))).intValue();
    }
    return paramInt;
  }
  
  public int b(int[] paramArrayOfInt)
  {
    int i = super.a(paramArrayOfInt);
    if (i >= 0) {
      return i;
    }
    return super.a(StateSet.WILD_CARD);
  }
  
  public void d()
  {
    K = K.clone();
    L = L.clone();
  }
  
  public Drawable newDrawable()
  {
    return new a(this, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new a(this, paramResources);
  }
}

/* Location:
 * Qualified Name:     base.d.b.c.a.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */