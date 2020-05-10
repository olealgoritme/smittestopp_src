package d.b.c.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import androidx.appcompat.R.attr;
import androidx.appcompat.R.style;
import androidx.appcompat.R.styleable;

import d.b.a.r;

public class d
  extends Drawable
{
  public static final float m = (float)Math.toRadians(45.0D);
  public final Paint a = new Paint();
  public float b;
  public float c;
  public float d;
  public float e;
  public boolean f;
  public final Path g = new Path();
  public final int h;
  public boolean i = false;
  public float j;
  public float k;
  public int l = 2;
  
  public d(Context paramContext)
  {
    a.setStyle(Paint.Style.STROKE);
    a.setStrokeJoin(Paint.Join.MITER);
    a.setStrokeCap(Paint.Cap.BUTT);
    a.setAntiAlias(true);
    paramContext = paramContext.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
    int n = paramContext.getColor(R.styleable.DrawerArrowToggle_color, 0);
    if (n != a.getColor())
    {
      a.setColor(n);
      invalidateSelf();
    }
    float f1 = paramContext.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0F);
    if (a.getStrokeWidth() != f1)
    {
      a.setStrokeWidth(f1);
      double d1 = f1 / 2.0F;
      k = ((float)(Math.cos(m) * d1));
      invalidateSelf();
    }
    boolean bool = paramContext.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true);
    if (f != bool)
    {
      f = bool;
      invalidateSelf();
    }
    f1 = Math.round(paramContext.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0F));
    if (f1 != e)
    {
      e = f1;
      invalidateSelf();
    }
    h = paramContext.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
    c = Math.round(paramContext.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0F));
    b = Math.round(paramContext.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0F));
    d = paramContext.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0F);
    paramContext.recycle();
  }
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat2 - paramFloat1) * paramFloat3 + paramFloat1;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int n = l;
    int i1 = 0;
    int i2 = i1;
    if (n != 0)
    {
      if (n != 1) {
        if (n != 3)
        {
          i2 = i1;
          if (r.b(this) != 1) {
            break label60;
          }
        }
        else
        {
          i2 = i1;
          if (r.b(this) != 0) {
            break label60;
          }
        }
      }
      i2 = 1;
    }
    label60:
    float f1 = b;
    f1 = (float)Math.sqrt(f1 * f1 * 2.0F);
    float f2 = a(c, f1, j);
    float f3 = a(c, d, j);
    float f4 = Math.round(a(0.0F, k, j));
    float f5 = a(0.0F, m, j);
    if (i2 != 0) {
      f1 = 0.0F;
    } else {
      f1 = -180.0F;
    }
    if (i2 != 0) {
      f6 = 180.0F;
    } else {
      f6 = 0.0F;
    }
    f1 = a(f1, f6, j);
    double d1 = f2;
    double d2 = f5;
    f5 = (float)Math.round(Math.cos(d2) * d1);
    float f6 = (float)Math.round(Math.sin(d2) * d1);
    g.rewind();
    f2 = e;
    f2 = a(a.getStrokeWidth() + f2, -k, j);
    float f7 = -f3 / 2.0F;
    g.moveTo(f7 + f4, 0.0F);
    g.rLineTo(f3 - f4 * 2.0F, 0.0F);
    g.moveTo(f7, f2);
    g.rLineTo(f5, f6);
    g.moveTo(f7, -f2);
    g.rLineTo(f5, -f6);
    g.close();
    paramCanvas.save();
    f4 = a.getStrokeWidth();
    f3 = localRect.height();
    f6 = e;
    f3 = (int)(f3 - 3.0F * f4 - 2.0F * f6) / 4 * 2;
    paramCanvas.translate(localRect.centerX(), f4 * 1.5F + f6 + f3);
    if (f)
    {
      if ((i ^ i2)) {
        i2 = -1;
      } else {
        i2 = 1;
      }
      paramCanvas.rotate(f1 * i2);
    }
    else if (i2 != 0)
    {
      paramCanvas.rotate(180.0F);
    }
    paramCanvas.drawPath(g, a);
    paramCanvas.restore();
  }
  
  public int getIntrinsicHeight()
  {
    return h;
  }
  
  public int getIntrinsicWidth()
  {
    return h;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != a.getAlpha())
    {
      a.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    a.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setProgress(float paramFloat)
  {
    if (j != paramFloat)
    {
      j = paramFloat;
      invalidateSelf();
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.c.a.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */