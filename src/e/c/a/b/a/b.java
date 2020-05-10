package e.c.a.b.a;

import android.animation.TypeEvaluator;

public class b
  implements TypeEvaluator<Integer>
{
  public static final b a = new b();
  
  public Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
  {
    paramObject1 = (Integer)paramObject1;
    paramObject2 = (Integer)paramObject2;
    int i = ((Integer)paramObject1).intValue();
    float f1 = (i >> 24 & 0xFF) / 255.0F;
    float f2 = (i >> 16 & 0xFF) / 255.0F;
    float f3 = (i >> 8 & 0xFF) / 255.0F;
    float f4 = (i & 0xFF) / 255.0F;
    i = ((Integer)paramObject2).intValue();
    float f5 = (i >> 24 & 0xFF) / 255.0F;
    float f6 = (i >> 16 & 0xFF) / 255.0F;
    float f7 = (i >> 8 & 0xFF) / 255.0F;
    float f8 = (i & 0xFF) / 255.0F;
    f2 = (float)Math.pow(f2, 2.2D);
    f3 = (float)Math.pow(f3, 2.2D);
    f4 = (float)Math.pow(f4, 2.2D);
    f6 = (float)Math.pow(f6, 2.2D);
    f7 = (float)Math.pow(f7, 2.2D);
    f8 = (float)Math.pow(f8, 2.2D);
    f2 = (float)Math.pow((f6 - f2) * paramFloat + f2, 0.45454545454545453D);
    f3 = (float)Math.pow((f7 - f3) * paramFloat + f3, 0.45454545454545453D);
    f8 = (float)Math.pow((f8 - f4) * paramFloat + f4, 0.45454545454545453D);
    i = Math.round(((f5 - f1) * paramFloat + f1) * 255.0F);
    return Integer.valueOf(Math.round(f2 * 255.0F) << 16 | i << 24 | Math.round(f3 * 255.0F) << 8 | Math.round(f8 * 255.0F));
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.b.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */