package d.y.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import d.b.a.r;
import d.f.h;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class g
  extends f
{
  public static final PorterDuff.Mode G = PorterDuff.Mode.SRC_IN;
  public ColorFilter A;
  public boolean B;
  public boolean C = true;
  public final float[] D = new float[9];
  public final Matrix E = new Matrix();
  public final Rect F = new Rect();
  public g.h y;
  public PorterDuffColorFilter z;
  
  public g()
  {
    y = new g.h();
  }
  
  public g(g.h paramh)
  {
    y = paramh;
    z = a(c, d);
  }
  
  public static int a(int paramInt, float paramFloat)
  {
    return paramInt & 0xFFFFFF | (int)(Color.alpha(paramInt) * paramFloat) << 24;
  }
  
  public static g a(Resources paramResources, int paramInt, Resources.Theme paramTheme)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localObject = new g();
      x = paramResources.getDrawable(paramInt, paramTheme);
      new g.i(x.getConstantState());
      return (g)localObject;
    }
    try
    {
      XmlResourceParser localXmlResourceParser = paramResources.getXml(paramInt);
      localObject = Xml.asAttributeSet(localXmlResourceParser);
      do
      {
        paramInt = localXmlResourceParser.next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt == 2) {
        return createFromXmlInner(paramResources, localXmlResourceParser, (AttributeSet)localObject, paramTheme);
      }
      paramResources = new org/xmlpull/v1/XmlPullParserException;
      paramResources.<init>("No start tag found");
      throw paramResources;
    }
    catch (IOException paramResources)
    {
      Log.e("VectorDrawableCompat", "parser error", paramResources);
    }
    catch (XmlPullParserException paramResources)
    {
      Log.e("VectorDrawableCompat", "parser error", paramResources);
    }
    return null;
  }
  
  public static g createFromXmlInner(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    g localg = new g();
    localg.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return localg;
  }
  
  public PorterDuffColorFilter a(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList != null) && (paramMode != null)) {
      return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
    }
    return null;
  }
  
  public boolean canApplyTheme()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      localDrawable.canApplyTheme();
    }
    return false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject1 = x;
    if (localObject1 != null)
    {
      ((Drawable)localObject1).draw(paramCanvas);
      return;
    }
    copyBounds(F);
    if ((F.width() > 0) && (F.height() > 0))
    {
      Object localObject2 = A;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = z;
      }
      paramCanvas.getMatrix(E);
      E.getValues(D);
      localObject2 = D;
      int i = 0;
      float f1 = Math.abs(localObject2[0]);
      float f2 = Math.abs(D[4]);
      float f3 = Math.abs(D[1]);
      float f4 = Math.abs(D[3]);
      if ((f3 != 0.0F) || (f4 != 0.0F))
      {
        f1 = 1.0F;
        f2 = 1.0F;
      }
      int j = (int)(F.width() * f1);
      int k = (int)(F.height() * f2);
      int m = Math.min(2048, j);
      int n = Math.min(2048, k);
      if ((m > 0) && (n > 0))
      {
        j = paramCanvas.save();
        localObject2 = F;
        paramCanvas.translate(left, top);
        if ((isAutoMirrored()) && (r.b(this) == 1)) {
          k = 1;
        } else {
          k = 0;
        }
        if (k != 0)
        {
          paramCanvas.translate(F.width(), 0.0F);
          paramCanvas.scale(-1.0F, 1.0F);
        }
        F.offsetTo(0, 0);
        localObject2 = y;
        Object localObject3 = f;
        if (localObject3 != null)
        {
          if ((m == ((Bitmap)localObject3).getWidth()) && (n == f.getHeight())) {
            k = 1;
          } else {
            k = 0;
          }
          if (k != 0) {}
        }
        else
        {
          f = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_8888);
          k = true;
        }
        if (!C)
        {
          y.a(m, n);
        }
        else
        {
          localObject2 = y;
          if ((!k) && (g == c) && (h == d) && (j == e) && (i == b.getRootAlpha())) {
            k = 1;
          } else {
            k = 0;
          }
          if (k == 0)
          {
            y.a(m, n);
            localObject2 = y;
            g = c;
            h = d;
            i = b.getRootAlpha();
            j = e;
            k = false;
          }
        }
        localObject3 = y;
        localObject2 = F;
        k = i;
        if (b.getRootAlpha() < 255) {
          k = 1;
        }
        if ((k == 0) && (localObject1 == null))
        {
          localObject1 = null;
        }
        else
        {
          if (l == null)
          {
            Paint localPaint = new Paint();
            l = localPaint;
            localPaint.setFilterBitmap(true);
          }
          l.setAlpha(b.getRootAlpha());
          l.setColorFilter((ColorFilter)localObject1);
          localObject1 = l;
        }
        paramCanvas.drawBitmap(f, null, (Rect)localObject2, (Paint)localObject1);
        paramCanvas.restoreToCount(j);
      }
    }
  }
  
  public int getAlpha()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.getAlpha();
    }
    return y.b.getRootAlpha();
  }
  
  public int getChangingConfigurations()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | y.getChangingConfigurations();
  }
  
  public ColorFilter getColorFilter()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.getColorFilter();
    }
    return A;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if ((x != null) && (Build.VERSION.SDK_INT >= 24)) {
      return new g.i(x.getConstantState());
    }
    y.a = getChangingConfigurations();
    return y;
  }
  
  public int getIntrinsicHeight()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicHeight();
    }
    return (int)y.b.j;
  }
  
  public int getIntrinsicWidth()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.getIntrinsicWidth();
    }
    return (int)y.b.i;
  }
  
  public int getOpacity()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.getOpacity();
    }
    return -3;
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
  {
    Drawable localDrawable = x;
    if (localDrawable != null)
    {
      localDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
      return;
    }
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
  {
    Object localObject1 = x;
    if (localObject1 != null)
    {
      ((Drawable)localObject1).inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    g.h localh1 = y;
    b = new g.g();
    Object localObject3 = r.a(paramResources, paramTheme, paramAttributeSet, a.a);
    Object localObject4 = y;
    Object localObject5 = b;
    int i = r.b((TypedArray)localObject3, paramXmlPullParser, "tintMode", 6, -1);
    Object localObject6 = PorterDuff.Mode.SRC_IN;
    if (i != 3)
    {
      localObject1 = localObject6;
      if (i != 5) {
        if (i != 9) {
          switch (i)
          {
          default: 
            localObject1 = localObject6;
            break;
          case 16: 
            localObject1 = PorterDuff.Mode.ADD;
            break;
          case 15: 
            localObject1 = PorterDuff.Mode.SCREEN;
            break;
          case 14: 
            localObject1 = PorterDuff.Mode.MULTIPLY;
            break;
          }
        } else {
          localObject1 = PorterDuff.Mode.SRC_ATOP;
        }
      }
    }
    else
    {
      localObject1 = PorterDuff.Mode.SRC_OVER;
    }
    d = ((PorterDuff.Mode)localObject1);
    if (r.a(paramXmlPullParser, "tint"))
    {
      localObject1 = new TypedValue();
      ((TypedArray)localObject3).getValue(1, (TypedValue)localObject1);
      i = type;
      if (i != 2)
      {
        if ((i >= 28) && (i <= 31))
        {
          localObject1 = ColorStateList.valueOf(data);
          break label359;
        }
        localObject1 = ((TypedArray)localObject3).getResources();
        i = ((TypedArray)localObject3).getResourceId(1, 0);
        try
        {
          localObject1 = r.a((Resources)localObject1, ((Resources)localObject1).getXml(i), paramTheme);
        }
        catch (Exception localException)
        {
          Log.e("CSLCompat", "Failed to inflate ColorStateList.", localException);
          break label356;
        }
      }
      else
      {
        paramResources = new StringBuilder();
        paramResources.append("Failed to resolve attribute at index ");
        paramResources.append(1);
        paramResources.append(": ");
        paramResources.append(localException);
        throw new UnsupportedOperationException(paramResources.toString());
      }
    }
    label356:
    Object localObject2 = null;
    label359:
    if (localObject2 != null) {
      c = ((ColorStateList)localObject2);
    }
    boolean bool = e;
    if (r.a(paramXmlPullParser, "autoMirrored")) {
      bool = ((TypedArray)localObject3).getBoolean(5, bool);
    }
    e = bool;
    k = r.a((TypedArray)localObject3, paramXmlPullParser, "viewportWidth", 7, k);
    float f = r.a((TypedArray)localObject3, paramXmlPullParser, "viewportHeight", 8, l);
    l = f;
    if (k > 0.0F)
    {
      if (f > 0.0F)
      {
        i = ((TypedArray)localObject3).getDimension(3, i);
        f = ((TypedArray)localObject3).getDimension(2, j);
        j = f;
        if (i > 0.0F)
        {
          if (f > 0.0F)
          {
            ((g.g)localObject5).setAlpha(r.a((TypedArray)localObject3, paramXmlPullParser, "alpha", 4, ((g.g)localObject5).getAlpha()));
            localObject2 = ((TypedArray)localObject3).getString(0);
            if (localObject2 != null)
            {
              n = ((String)localObject2);
              p.put(localObject2, localObject5);
            }
            ((TypedArray)localObject3).recycle();
            a = getChangingConfigurations();
            k = true;
            g.h localh2 = y;
            localObject6 = b;
            localObject2 = new ArrayDeque();
            ((ArrayDeque)localObject2).push(h);
            int j = paramXmlPullParser.getEventType();
            int k = paramXmlPullParser.getDepth() + 1;
            int m;
            for (i = 1; (j != 1) && ((paramXmlPullParser.getDepth() >= k) || (j != 3)); i = m)
            {
              if (j == 2)
              {
                localObject3 = paramXmlPullParser.getName();
                g.d locald = (g.d)((ArrayDeque)localObject2).peek();
                if ("path".equals(localObject3))
                {
                  localObject5 = new g.c();
                  localObject4 = r.a(paramResources, paramTheme, paramAttributeSet, a.c);
                  e = null;
                  if (r.a(paramXmlPullParser, "pathData"))
                  {
                    localObject3 = ((TypedArray)localObject4).getString(0);
                    if (localObject3 != null) {
                      b = ((String)localObject3);
                    }
                    localObject3 = ((TypedArray)localObject4).getString(2);
                    if (localObject3 != null) {
                      a = r.b((String)localObject3);
                    }
                    Object localObject7 = localObject5;
                    h = r.a((TypedArray)localObject4, paramXmlPullParser, paramTheme, "fillColor", 1, 0);
                    j = r.a((TypedArray)localObject4, paramXmlPullParser, "fillAlpha", 12, j);
                    i = r.b((TypedArray)localObject4, paramXmlPullParser, "strokeLineCap", 8, -1);
                    localObject3 = n;
                    if (i != 0)
                    {
                      if (i != 1)
                      {
                        if (i == 2) {
                          localObject3 = Paint.Cap.SQUARE;
                        }
                      }
                      else {
                        localObject3 = Paint.Cap.ROUND;
                      }
                    }
                    else {
                      localObject3 = Paint.Cap.BUTT;
                    }
                    n = ((Paint.Cap)localObject3);
                    i = r.b((TypedArray)localObject4, paramXmlPullParser, "strokeLineJoin", 9, -1);
                    localObject3 = o;
                    if (i != 0)
                    {
                      if (i != 1)
                      {
                        if (i == 2) {
                          localObject3 = Paint.Join.BEVEL;
                        }
                      }
                      else {
                        localObject3 = Paint.Join.ROUND;
                      }
                    }
                    else {
                      localObject3 = Paint.Join.MITER;
                    }
                    o = ((Paint.Join)localObject3);
                    p = r.a((TypedArray)localObject4, paramXmlPullParser, "strokeMiterLimit", 10, p);
                    localObject3 = localObject4;
                    f = r.a((TypedArray)localObject4, paramXmlPullParser, paramTheme, "strokeColor", 3, 0);
                    i = r.a((TypedArray)localObject3, paramXmlPullParser, "strokeAlpha", 11, i);
                    g = r.a((TypedArray)localObject3, paramXmlPullParser, "strokeWidth", 4, g);
                    l = r.a((TypedArray)localObject3, paramXmlPullParser, "trimPathEnd", 6, l);
                    m = r.a((TypedArray)localObject3, paramXmlPullParser, "trimPathOffset", 7, m);
                    k = r.a((TypedArray)localObject3, paramXmlPullParser, "trimPathStart", 5, k);
                    c = r.b((TypedArray)localObject3, paramXmlPullParser, "fillType", 13, c);
                  }
                  ((TypedArray)localObject4).recycle();
                  b.add(localObject5);
                  if (((g.f)localObject5).getPathName() != null) {
                    p.put(((g.f)localObject5).getPathName(), localObject5);
                  }
                  a |= d;
                  i = 0;
                }
                else if ("clip-path".equals(localObject3))
                {
                  localObject3 = new g.b();
                  if (r.a(paramXmlPullParser, "pathData"))
                  {
                    localObject5 = r.a(paramResources, paramTheme, paramAttributeSet, a.d);
                    localObject4 = ((TypedArray)localObject5).getString(0);
                    if (localObject4 != null) {
                      b = ((String)localObject4);
                    }
                    localObject4 = ((TypedArray)localObject5).getString(1);
                    if (localObject4 != null) {
                      a = r.b((String)localObject4);
                    }
                    c = r.b((TypedArray)localObject5, paramXmlPullParser, "fillType", 2, 0);
                    ((TypedArray)localObject5).recycle();
                  }
                  b.add(localObject3);
                  if (((g.f)localObject3).getPathName() != null) {
                    p.put(((g.f)localObject3).getPathName(), localObject3);
                  }
                  m = a;
                  a = (d | m);
                }
                else if ("group".equals(localObject3))
                {
                  localObject3 = new g.d();
                  localObject5 = r.a(paramResources, paramTheme, paramAttributeSet, a.b);
                  l = null;
                  c = r.a((TypedArray)localObject5, paramXmlPullParser, "rotation", 5, c);
                  d = ((TypedArray)localObject5).getFloat(1, d);
                  e = ((TypedArray)localObject5).getFloat(2, e);
                  f = r.a((TypedArray)localObject5, paramXmlPullParser, "scaleX", 3, f);
                  g = r.a((TypedArray)localObject5, paramXmlPullParser, "scaleY", 4, g);
                  h = r.a((TypedArray)localObject5, paramXmlPullParser, "translateX", 6, h);
                  i = r.a((TypedArray)localObject5, paramXmlPullParser, "translateY", 7, i);
                  localObject4 = ((TypedArray)localObject5).getString(0);
                  if (localObject4 != null) {
                    m = ((String)localObject4);
                  }
                  ((g.d)localObject3).b();
                  ((TypedArray)localObject5).recycle();
                  b.add(localObject3);
                  ((ArrayDeque)localObject2).push(localObject3);
                  if (((g.d)localObject3).getGroupName() != null) {
                    p.put(((g.d)localObject3).getGroupName(), localObject3);
                  }
                  m = a;
                  a = (k | m);
                }
                m = i;
              }
              else
              {
                localObject3 = localObject2;
                localObject5 = localObject6;
                localObject6 = localObject5;
                localObject2 = localObject3;
                m = i;
                if (j == 3)
                {
                  localObject6 = localObject5;
                  localObject2 = localObject3;
                  m = i;
                  if ("group".equals(paramXmlPullParser.getName()))
                  {
                    ((ArrayDeque)localObject3).pop();
                    m = i;
                    localObject2 = localObject3;
                    localObject6 = localObject5;
                  }
                }
              }
              j = paramXmlPullParser.next();
            }
            if (i == 0)
            {
              z = a(c, d);
              return;
            }
            throw new XmlPullParserException("no path defined");
          }
          paramResources = new StringBuilder();
          paramResources.append(((TypedArray)localObject3).getPositionDescription());
          paramResources.append("<vector> tag requires height > 0");
          throw new XmlPullParserException(paramResources.toString());
        }
        paramResources = new StringBuilder();
        paramResources.append(((TypedArray)localObject3).getPositionDescription());
        paramResources.append("<vector> tag requires width > 0");
        throw new XmlPullParserException(paramResources.toString());
      }
      paramResources = new StringBuilder();
      paramResources.append(((TypedArray)localObject3).getPositionDescription());
      paramResources.append("<vector> tag requires viewportHeight > 0");
      throw new XmlPullParserException(paramResources.toString());
    }
    paramResources = new StringBuilder();
    paramResources.append(((TypedArray)localObject3).getPositionDescription());
    paramResources.append("<vector> tag requires viewportWidth > 0");
    throw new XmlPullParserException(paramResources.toString());
  }
  
  public void invalidateSelf()
  {
    Drawable localDrawable = x;
    if (localDrawable != null)
    {
      localDrawable.invalidateSelf();
      return;
    }
    super.invalidateSelf();
  }
  
  public boolean isAutoMirrored()
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.isAutoMirrored();
    }
    return y.e;
  }
  
  public boolean isStateful()
  {
    Object localObject = x;
    if (localObject != null) {
      return ((Drawable)localObject).isStateful();
    }
    if (!super.isStateful())
    {
      localObject = y;
      if (localObject != null)
      {
        if (!((g.h)localObject).a())
        {
          localObject = y.c;
          if ((localObject != null) && (((ColorStateList)localObject).isStateful())) {}
        }
      }
      else {
        return false;
      }
    }
    boolean bool = true;
    return bool;
  }
  
  public Drawable mutate()
  {
    Drawable localDrawable = x;
    if (localDrawable != null)
    {
      localDrawable.mutate();
      return this;
    }
    if ((!B) && (super.mutate() == this))
    {
      y = new g.h(y);
      B = true;
    }
    return this;
  }
  
  public void onBoundsChange(Rect paramRect)
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      localDrawable.setBounds(paramRect);
    }
  }
  
  public boolean onStateChange(int[] paramArrayOfInt)
  {
    Object localObject = x;
    if (localObject != null) {
      return ((Drawable)localObject).setState(paramArrayOfInt);
    }
    boolean bool1 = false;
    g.h localh = y;
    ColorStateList localColorStateList = c;
    boolean bool2 = true;
    boolean bool3 = bool1;
    if (localColorStateList != null)
    {
      localObject = d;
      bool3 = bool1;
      if (localObject != null)
      {
        z = a(localColorStateList, (PorterDuff.Mode)localObject);
        invalidateSelf();
        bool3 = true;
      }
    }
    if (localh.a())
    {
      bool1 = b.h.a(paramArrayOfInt);
      k |= bool1;
      if (bool1)
      {
        invalidateSelf();
        bool3 = bool2;
      }
    }
    return bool3;
  }
  
  public void scheduleSelf(Runnable paramRunnable, long paramLong)
  {
    Drawable localDrawable = x;
    if (localDrawable != null)
    {
      localDrawable.scheduleSelf(paramRunnable, paramLong);
      return;
    }
    super.scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt)
  {
    Drawable localDrawable = x;
    if (localDrawable != null)
    {
      localDrawable.setAlpha(paramInt);
      return;
    }
    if (y.b.getRootAlpha() != paramInt)
    {
      y.b.setRootAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setAutoMirrored(boolean paramBoolean)
  {
    Drawable localDrawable = x;
    if (localDrawable != null)
    {
      localDrawable.setAutoMirrored(paramBoolean);
      return;
    }
    y.e = paramBoolean;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    Drawable localDrawable = x;
    if (localDrawable != null)
    {
      localDrawable.setColorFilter(paramColorFilter);
      return;
    }
    A = paramColorFilter;
    invalidateSelf();
  }
  
  public void setTint(int paramInt)
  {
    Drawable localDrawable = x;
    if (localDrawable != null)
    {
      r.b(localDrawable, paramInt);
      return;
    }
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    Object localObject = x;
    if (localObject != null)
    {
      r.a((Drawable)localObject, paramColorStateList);
      return;
    }
    localObject = y;
    if (c != paramColorStateList)
    {
      c = paramColorStateList;
      z = a(paramColorStateList, d);
      invalidateSelf();
    }
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    Object localObject = x;
    if (localObject != null)
    {
      r.a((Drawable)localObject, paramMode);
      return;
    }
    localObject = y;
    if (d != paramMode)
    {
      d = paramMode;
      z = a(c, paramMode);
      invalidateSelf();
    }
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    Drawable localDrawable = x;
    if (localDrawable != null) {
      return localDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public void unscheduleSelf(Runnable paramRunnable)
  {
    Drawable localDrawable = x;
    if (localDrawable != null)
    {
      localDrawable.unscheduleSelf(paramRunnable);
      return;
    }
    super.unscheduleSelf(paramRunnable);
  }
}

/* Location:
 * Qualified Name:     base.d.y.a.a.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */