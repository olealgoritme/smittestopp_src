package e.c.a.b.g;

import android.animation.TypeEvaluator;
import e.c.a.a.b.l.c;

public class c$b
  implements TypeEvaluator<c.e>
{
  public static final TypeEvaluator<c.e> b = new b();
  public final c.e a = new c.e(null);
  
  public Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
  {
    paramObject1 = (c.e)paramObject1;
    c.e locale = (c.e)paramObject2;
    paramObject2 = a;
    float f1 = c.a(a, a, paramFloat);
    float f2 = c.a(b, b, paramFloat);
    paramFloat = c.a(c, c, paramFloat);
    a = f1;
    b = f2;
    c = paramFloat;
    return a;
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.g.c.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */