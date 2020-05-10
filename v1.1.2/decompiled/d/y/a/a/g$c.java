package d.y.a.a;

import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import d.i.b.b.a;

public class g$c
  extends g.f
{
  public int[] e;
  public a f;
  public float g = 0.0F;
  public a h;
  public float i = 1.0F;
  public float j = 1.0F;
  public float k = 0.0F;
  public float l = 1.0F;
  public float m = 0.0F;
  public Paint.Cap n = Paint.Cap.BUTT;
  public Paint.Join o = Paint.Join.MITER;
  public float p = 4.0F;
  
  public g$c() {}
  
  public g$c(c paramc)
  {
    super(paramc);
    e = e;
    f = f;
    g = g;
    i = i;
    h = h;
    c = c;
    j = j;
    k = k;
    l = l;
    m = m;
    n = n;
    o = o;
    p = p;
  }
  
  public boolean a()
  {
    boolean bool;
    if ((!h.b()) && (!f.b())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(int[] paramArrayOfInt)
  {
    boolean bool = h.a(paramArrayOfInt);
    return f.a(paramArrayOfInt) | bool;
  }
  
  public float getFillAlpha()
  {
    return j;
  }
  
  public int getFillColor()
  {
    return h.c;
  }
  
  public float getStrokeAlpha()
  {
    return i;
  }
  
  public int getStrokeColor()
  {
    return f.c;
  }
  
  public float getStrokeWidth()
  {
    return g;
  }
  
  public float getTrimPathEnd()
  {
    return l;
  }
  
  public float getTrimPathOffset()
  {
    return m;
  }
  
  public float getTrimPathStart()
  {
    return k;
  }
  
  public void setFillAlpha(float paramFloat)
  {
    j = paramFloat;
  }
  
  public void setFillColor(int paramInt)
  {
    h.c = paramInt;
  }
  
  public void setStrokeAlpha(float paramFloat)
  {
    i = paramFloat;
  }
  
  public void setStrokeColor(int paramInt)
  {
    f.c = paramInt;
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    g = paramFloat;
  }
  
  public void setTrimPathEnd(float paramFloat)
  {
    l = paramFloat;
  }
  
  public void setTrimPathOffset(float paramFloat)
  {
    m = paramFloat;
  }
  
  public void setTrimPathStart(float paramFloat)
  {
    k = paramFloat;
  }
}

/* Location:
 * Qualified Name:     d.y.a.a.g.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */