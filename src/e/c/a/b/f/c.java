package e.c.a.b.f;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;

public class c
{
  public final a a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public PorterDuff.Mode h;
  public ColorStateList i;
  public ColorStateList j;
  public ColorStateList k;
  public final Paint l = new Paint(1);
  public final Rect m = new Rect();
  public final RectF n = new RectF();
  public GradientDrawable o;
  public GradientDrawable p;
  public GradientDrawable q;
  public boolean r = false;
  
  public c(a parama)
  {
    a = parama;
  }
  
  @TargetApi(21)
  public final Drawable a()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    o = localGradientDrawable;
    localGradientDrawable.setCornerRadius(f + 1.0E-5F);
    o.setColor(-1);
    b();
    localGradientDrawable = new GradientDrawable();
    p = localGradientDrawable;
    localGradientDrawable.setCornerRadius(f + 1.0E-5F);
    p.setColor(0);
    p.setStroke(g, j);
    InsetDrawable localInsetDrawable = new InsetDrawable(new LayerDrawable(new Drawable[] { o, p }), b, d, c, e);
    localGradientDrawable = new GradientDrawable();
    q = localGradientDrawable;
    localGradientDrawable.setCornerRadius(f + 1.0E-5F);
    q.setColor(-1);
    return new b(e.c.a.b.k.a.a(k), localInsetDrawable, q);
  }
  
  public final void b()
  {
    Object localObject = o;
    if (localObject != null)
    {
      ((Drawable)localObject).setTintList(i);
      localObject = h;
      if (localObject != null) {
        o.setTintMode((PorterDuff.Mode)localObject);
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.b.f.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */