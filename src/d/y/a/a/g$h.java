package d.y.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

public class g$h
  extends Drawable.ConstantState
{
  public int a;
  public g.g b;
  public ColorStateList c = null;
  public PorterDuff.Mode d = g.G;
  public boolean e;
  public Bitmap f;
  public ColorStateList g;
  public PorterDuff.Mode h;
  public int i;
  public boolean j;
  public boolean k;
  public Paint l;
  
  public g$h()
  {
    b = new g.g();
  }
  
  public g$h(h paramh)
  {
    if (paramh != null)
    {
      a = a;
      g.g localg = new g.g(b);
      b = localg;
      if (b.e != null) {
        e = new Paint(b.e);
      }
      if (b.d != null) {
        b.d = new Paint(b.d);
      }
      c = c;
      d = d;
      e = e;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    f.eraseColor(0);
    Canvas localCanvas = new Canvas(f);
    g.g localg = b;
    localg.a(h, g.g.q, localCanvas, paramInt1, paramInt2, null);
  }
  
  public boolean a()
  {
    g.g localg = b;
    if (o == null) {
      o = Boolean.valueOf(h.a());
    }
    return o.booleanValue();
  }
  
  public int getChangingConfigurations()
  {
    return a;
  }
  
  public Drawable newDrawable()
  {
    return new g(this);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new g(this);
  }
}

/* Location:
 * Qualified Name:     base.d.y.a.a.g.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */