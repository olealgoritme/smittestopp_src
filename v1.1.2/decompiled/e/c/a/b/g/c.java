package e.c.a.b.g;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;

public abstract interface c
{
  public abstract void a();
  
  public abstract void b();
  
  public abstract int getCircularRevealScrimColor();
  
  public abstract e getRevealInfo();
  
  public abstract void setCircularRevealOverlayDrawable(Drawable paramDrawable);
  
  public abstract void setCircularRevealScrimColor(int paramInt);
  
  public abstract void setRevealInfo(e parame);
  
  public static class b
    implements TypeEvaluator<c.e>
  {
    public static final TypeEvaluator<c.e> b = new b();
    public final c.e a = new c.e(null);
    
    public Object evaluate(float paramFloat, Object paramObject1, Object paramObject2)
    {
      paramObject1 = (c.e)paramObject1;
      c.e locale = (c.e)paramObject2;
      paramObject2 = a;
      float f1 = e.c.a.a.b.l.c.a(a, a, paramFloat);
      float f2 = e.c.a.a.b.l.c.a(b, b, paramFloat);
      paramFloat = e.c.a.a.b.l.c.a(c, c, paramFloat);
      a = f1;
      b = f2;
      c = paramFloat;
      return a;
    }
  }
  
  public static class c
    extends Property<c, c.e>
  {
    public static final Property<c, c.e> a = new c("circularReveal");
    
    public c(String paramString)
    {
      super(paramString);
    }
    
    public Object get(Object paramObject)
    {
      return ((c)paramObject).getRevealInfo();
    }
    
    public void set(Object paramObject1, Object paramObject2)
    {
      ((c)paramObject1).setRevealInfo((c.e)paramObject2);
    }
  }
  
  public static class d
    extends Property<c, Integer>
  {
    public static final Property<c, Integer> a = new d("circularRevealScrimColor");
    
    public d(String paramString)
    {
      super(paramString);
    }
    
    public Object get(Object paramObject)
    {
      return Integer.valueOf(((c)paramObject).getCircularRevealScrimColor());
    }
    
    public void set(Object paramObject1, Object paramObject2)
    {
      ((c)paramObject1).setCircularRevealScrimColor(((Integer)paramObject2).intValue());
    }
  }
  
  public static class e
  {
    public float a;
    public float b;
    public float c;
    
    public e() {}
    
    public e(float paramFloat1, float paramFloat2, float paramFloat3)
    {
      a = paramFloat1;
      b = paramFloat2;
      c = paramFloat3;
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.g.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */