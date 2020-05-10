package d.y.a.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import d.b.a.s;
import d.f.h;
import d.i.c.b;
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
  public h y;
  public PorterDuffColorFilter z;
  
  public g()
  {
    y = new h();
  }
  
  public g(h paramh)
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
      new i(x.getConstantState());
      return (g)localObject;
    }
    try
    {
      localObject = paramResources.getXml(paramInt);
      AttributeSet localAttributeSet = Xml.asAttributeSet((XmlPullParser)localObject);
      do
      {
        paramInt = ((XmlPullParser)localObject).next();
      } while ((paramInt != 2) && (paramInt != 1));
      if (paramInt == 2) {
        return createFromXmlInner(paramResources, (XmlPullParser)localObject, localAttributeSet, paramTheme);
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
        if ((isAutoMirrored()) && (s.b(this) == 1)) {
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
        Object localObject3 = y;
        localObject2 = f;
        if (localObject2 != null)
        {
          if ((m == ((Bitmap)localObject2).getWidth()) && (n == f.getHeight())) {
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
        localObject2 = y;
        localObject3 = F;
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
        paramCanvas.drawBitmap(f, null, (Rect)localObject3, (Paint)localObject1);
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
      return new i(x.getConstantState());
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
    h localh1 = y;
    b = new g();
    Object localObject3 = s.a(paramResources, paramTheme, paramAttributeSet, a.a);
    Object localObject4 = y;
    Object localObject5 = b;
    int i = s.b((TypedArray)localObject3, paramXmlPullParser, "tintMode", 6, -1);
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
    if (s.a(paramXmlPullParser, "tint"))
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
          localObject1 = s.a((Resources)localObject1, ((Resources)localObject1).getXml(i), paramTheme);
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
    if (s.a(paramXmlPullParser, "autoMirrored")) {
      bool = ((TypedArray)localObject3).getBoolean(5, bool);
    }
    e = bool;
    k = s.a((TypedArray)localObject3, paramXmlPullParser, "viewportWidth", 7, k);
    float f = s.a((TypedArray)localObject3, paramXmlPullParser, "viewportHeight", 8, l);
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
            ((g)localObject5).setAlpha(s.a((TypedArray)localObject3, paramXmlPullParser, "alpha", 4, ((g)localObject5).getAlpha()));
            localObject2 = ((TypedArray)localObject3).getString(0);
            if (localObject2 != null)
            {
              n = ((String)localObject2);
              p.put(localObject2, localObject5);
            }
            ((TypedArray)localObject3).recycle();
            a = getChangingConfigurations();
            k = true;
            h localh2 = y;
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
                d locald = (d)((ArrayDeque)localObject2).peek();
                if ("path".equals(localObject3))
                {
                  localObject5 = new c();
                  localObject4 = s.a(paramResources, paramTheme, paramAttributeSet, a.c);
                  e = null;
                  if (s.a(paramXmlPullParser, "pathData"))
                  {
                    localObject3 = ((TypedArray)localObject4).getString(0);
                    if (localObject3 != null) {
                      b = ((String)localObject3);
                    }
                    localObject3 = ((TypedArray)localObject4).getString(2);
                    if (localObject3 != null) {
                      a = s.b((String)localObject3);
                    }
                    Object localObject7 = localObject5;
                    h = s.a((TypedArray)localObject4, paramXmlPullParser, paramTheme, "fillColor", 1, 0);
                    j = s.a((TypedArray)localObject4, paramXmlPullParser, "fillAlpha", 12, j);
                    i = s.b((TypedArray)localObject4, paramXmlPullParser, "strokeLineCap", 8, -1);
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
                    i = s.b((TypedArray)localObject4, paramXmlPullParser, "strokeLineJoin", 9, -1);
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
                    p = s.a((TypedArray)localObject4, paramXmlPullParser, "strokeMiterLimit", 10, p);
                    localObject3 = localObject4;
                    f = s.a((TypedArray)localObject4, paramXmlPullParser, paramTheme, "strokeColor", 3, 0);
                    i = s.a((TypedArray)localObject3, paramXmlPullParser, "strokeAlpha", 11, i);
                    g = s.a((TypedArray)localObject3, paramXmlPullParser, "strokeWidth", 4, g);
                    l = s.a((TypedArray)localObject3, paramXmlPullParser, "trimPathEnd", 6, l);
                    m = s.a((TypedArray)localObject3, paramXmlPullParser, "trimPathOffset", 7, m);
                    k = s.a((TypedArray)localObject3, paramXmlPullParser, "trimPathStart", 5, k);
                    c = s.b((TypedArray)localObject3, paramXmlPullParser, "fillType", 13, c);
                  }
                  ((TypedArray)localObject4).recycle();
                  b.add(localObject5);
                  if (((f)localObject5).getPathName() != null) {
                    p.put(((f)localObject5).getPathName(), localObject5);
                  }
                  a |= d;
                  i = 0;
                }
                else if ("clip-path".equals(localObject3))
                {
                  localObject3 = new b();
                  if (s.a(paramXmlPullParser, "pathData"))
                  {
                    localObject5 = s.a(paramResources, paramTheme, paramAttributeSet, a.d);
                    localObject4 = ((TypedArray)localObject5).getString(0);
                    if (localObject4 != null) {
                      b = ((String)localObject4);
                    }
                    localObject4 = ((TypedArray)localObject5).getString(1);
                    if (localObject4 != null) {
                      a = s.b((String)localObject4);
                    }
                    c = s.b((TypedArray)localObject5, paramXmlPullParser, "fillType", 2, 0);
                    ((TypedArray)localObject5).recycle();
                  }
                  b.add(localObject3);
                  if (((f)localObject3).getPathName() != null) {
                    p.put(((f)localObject3).getPathName(), localObject3);
                  }
                  m = a;
                  a = (d | m);
                }
                else if ("group".equals(localObject3))
                {
                  localObject3 = new d();
                  localObject5 = s.a(paramResources, paramTheme, paramAttributeSet, a.b);
                  l = null;
                  c = s.a((TypedArray)localObject5, paramXmlPullParser, "rotation", 5, c);
                  d = ((TypedArray)localObject5).getFloat(1, d);
                  e = ((TypedArray)localObject5).getFloat(2, e);
                  f = s.a((TypedArray)localObject5, paramXmlPullParser, "scaleX", 3, f);
                  g = s.a((TypedArray)localObject5, paramXmlPullParser, "scaleY", 4, g);
                  h = s.a((TypedArray)localObject5, paramXmlPullParser, "translateX", 6, h);
                  i = s.a((TypedArray)localObject5, paramXmlPullParser, "translateY", 7, i);
                  localObject4 = ((TypedArray)localObject5).getString(0);
                  if (localObject4 != null) {
                    m = ((String)localObject4);
                  }
                  ((d)localObject3).b();
                  ((TypedArray)localObject5).recycle();
                  b.add(localObject3);
                  ((ArrayDeque)localObject2).push(localObject3);
                  if (((d)localObject3).getGroupName() != null) {
                    p.put(((d)localObject3).getGroupName(), localObject3);
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
        if (!((h)localObject).a())
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
      y = new h(y);
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
    localObject = y;
    ColorStateList localColorStateList = c;
    boolean bool2 = true;
    boolean bool3 = bool1;
    if (localColorStateList != null)
    {
      PorterDuff.Mode localMode = d;
      bool3 = bool1;
      if (localMode != null)
      {
        z = a(localColorStateList, localMode);
        invalidateSelf();
        bool3 = true;
      }
    }
    if (((h)localObject).a())
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
      s.b(localDrawable, paramInt);
      return;
    }
    setTintList(ColorStateList.valueOf(paramInt));
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    Object localObject = x;
    if (localObject != null)
    {
      s.a((Drawable)localObject, paramColorStateList);
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
      s.a((Drawable)localObject, paramMode);
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
  
  public static class b
    extends g.f
  {
    public b() {}
    
    public b(b paramb)
    {
      super();
    }
    
    public boolean b()
    {
      return true;
    }
  }
  
  public static class c
    extends g.f
  {
    public int[] e;
    public d.i.b.b.a f;
    public float g = 0.0F;
    public d.i.b.b.a h;
    public float i = 1.0F;
    public float j = 1.0F;
    public float k = 0.0F;
    public float l = 1.0F;
    public float m = 0.0F;
    public Paint.Cap n = Paint.Cap.BUTT;
    public Paint.Join o = Paint.Join.MITER;
    public float p = 4.0F;
    
    public c() {}
    
    public c(c paramc)
    {
      super();
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
  
  public static class d
    extends g.e
  {
    public final Matrix a = new Matrix();
    public final ArrayList<g.e> b = new ArrayList();
    public float c = 0.0F;
    public float d = 0.0F;
    public float e = 0.0F;
    public float f = 1.0F;
    public float g = 1.0F;
    public float h = 0.0F;
    public float i = 0.0F;
    public final Matrix j = new Matrix();
    public int k;
    public int[] l;
    public String m = null;
    
    public d()
    {
      super();
    }
    
    public d(d paramd, d.f.a<String, Object> parama)
    {
      super();
      c = c;
      d = d;
      e = e;
      f = f;
      g = g;
      h = h;
      i = i;
      l = l;
      Object localObject = m;
      m = ((String)localObject);
      k = k;
      if (localObject != null) {
        parama.put(localObject, this);
      }
      j.set(j);
      localObject = b;
      int n = 0;
      while (n < ((ArrayList)localObject).size())
      {
        paramd = ((ArrayList)localObject).get(n);
        if ((paramd instanceof d))
        {
          paramd = (d)paramd;
          b.add(new d(paramd, parama));
        }
        else
        {
          if ((paramd instanceof g.c))
          {
            paramd = new g.c((g.c)paramd);
          }
          else
          {
            if (!(paramd instanceof g.b)) {
              break label313;
            }
            paramd = new g.b((g.b)paramd);
          }
          b.add(paramd);
          String str = b;
          if (str != null) {
            parama.put(str, paramd);
          }
        }
        n++;
        continue;
        label313:
        throw new IllegalStateException("Unknown object in the tree!");
      }
    }
    
    public boolean a()
    {
      for (int n = 0; n < b.size(); n++) {
        if (((g.e)b.get(n)).a()) {
          return true;
        }
      }
      return false;
    }
    
    public boolean a(int[] paramArrayOfInt)
    {
      int n = 0;
      boolean bool = false;
      while (n < b.size())
      {
        bool |= ((g.e)b.get(n)).a(paramArrayOfInt);
        n++;
      }
      return bool;
    }
    
    public final void b()
    {
      j.reset();
      j.postTranslate(-d, -e);
      j.postScale(f, g);
      j.postRotate(c, 0.0F, 0.0F);
      j.postTranslate(h + d, i + e);
    }
    
    public String getGroupName()
    {
      return m;
    }
    
    public Matrix getLocalMatrix()
    {
      return j;
    }
    
    public float getPivotX()
    {
      return d;
    }
    
    public float getPivotY()
    {
      return e;
    }
    
    public float getRotation()
    {
      return c;
    }
    
    public float getScaleX()
    {
      return f;
    }
    
    public float getScaleY()
    {
      return g;
    }
    
    public float getTranslateX()
    {
      return h;
    }
    
    public float getTranslateY()
    {
      return i;
    }
    
    public void setPivotX(float paramFloat)
    {
      if (paramFloat != d)
      {
        d = paramFloat;
        b();
      }
    }
    
    public void setPivotY(float paramFloat)
    {
      if (paramFloat != e)
      {
        e = paramFloat;
        b();
      }
    }
    
    public void setRotation(float paramFloat)
    {
      if (paramFloat != c)
      {
        c = paramFloat;
        b();
      }
    }
    
    public void setScaleX(float paramFloat)
    {
      if (paramFloat != f)
      {
        f = paramFloat;
        b();
      }
    }
    
    public void setScaleY(float paramFloat)
    {
      if (paramFloat != g)
      {
        g = paramFloat;
        b();
      }
    }
    
    public void setTranslateX(float paramFloat)
    {
      if (paramFloat != h)
      {
        h = paramFloat;
        b();
      }
    }
    
    public void setTranslateY(float paramFloat)
    {
      if (paramFloat != i)
      {
        i = paramFloat;
        b();
      }
    }
  }
  
  public static abstract class e
  {
    public boolean a()
    {
      return false;
    }
    
    public boolean a(int[] paramArrayOfInt)
    {
      return false;
    }
  }
  
  public static abstract class f
    extends g.e
  {
    public b[] a = null;
    public String b;
    public int c = 0;
    public int d;
    
    public f()
    {
      super();
    }
    
    public f(f paramf)
    {
      super();
      b = b;
      d = d;
      a = s.a(a);
    }
    
    public boolean b()
    {
      return false;
    }
    
    public b[] getPathData()
    {
      return a;
    }
    
    public String getPathName()
    {
      return b;
    }
    
    public void setPathData(b[] paramArrayOfb)
    {
      if (!s.a(a, paramArrayOfb))
      {
        a = s.a(paramArrayOfb);
      }
      else
      {
        b[] arrayOfb = a;
        for (int i = 0; i < paramArrayOfb.length; i++)
        {
          a = ((char)a);
          for (int j = 0; j < b.length; j++) {
            b[j] = b[j];
          }
        }
      }
    }
  }
  
  public static class g
  {
    public static final Matrix q = new Matrix();
    public final Path a;
    public final Path b;
    public final Matrix c = new Matrix();
    public Paint d;
    public Paint e;
    public PathMeasure f;
    public int g;
    public final g.d h;
    public float i = 0.0F;
    public float j = 0.0F;
    public float k = 0.0F;
    public float l = 0.0F;
    public int m = 255;
    public String n = null;
    public Boolean o = null;
    public final d.f.a<String, Object> p;
    
    public g()
    {
      p = new d.f.a();
      h = new g.d();
      a = new Path();
      b = new Path();
    }
    
    public g(g paramg)
    {
      Object localObject = new d.f.a();
      p = ((d.f.a)localObject);
      h = new g.d(h, (d.f.a)localObject);
      a = new Path(a);
      b = new Path(b);
      i = i;
      j = j;
      k = k;
      l = l;
      g = g;
      m = m;
      n = n;
      localObject = n;
      if (localObject != null) {
        p.put(localObject, this);
      }
      o = o;
    }
    
    public final void a(g.d paramd, Matrix paramMatrix, Canvas paramCanvas, int paramInt1, int paramInt2, ColorFilter paramColorFilter)
    {
      Object localObject1 = this;
      a.set(paramMatrix);
      a.preConcat(j);
      paramCanvas.save();
      int i1 = 0;
      paramMatrix = (Matrix)localObject1;
      while (i1 < b.size())
      {
        localObject1 = (g.e)b.get(i1);
        if ((localObject1 instanceof g.d))
        {
          a((g.d)localObject1, a, paramCanvas, paramInt1, paramInt2, paramColorFilter);
        }
        else if ((localObject1 instanceof g.f))
        {
          Object localObject2 = (g.f)localObject1;
          float f1 = paramInt1 / k;
          float f2 = paramInt2 / l;
          float f3 = Math.min(f1, f2);
          localObject1 = a;
          c.set((Matrix)localObject1);
          c.postScale(f1, f2);
          paramMatrix = new float[4];
          Matrix tmp167_166 = paramMatrix;
          tmp167_166[0] = 0.0F;
          Matrix tmp171_167 = tmp167_166;
          tmp171_167[1] = 1.0F;
          Matrix tmp175_171 = tmp171_167;
          tmp175_171[2] = 1.0F;
          Matrix tmp179_175 = tmp175_171;
          tmp179_175[3] = 0.0F;
          tmp179_175;
          ((Matrix)localObject1).mapVectors(paramMatrix);
          float f4 = (float)Math.hypot(paramMatrix[0], paramMatrix[1]);
          float f5 = (float)Math.hypot(paramMatrix[2], paramMatrix[3]);
          f1 = paramMatrix[0];
          float f6 = paramMatrix[1];
          f2 = paramMatrix[2];
          float f7 = paramMatrix[3];
          f5 = Math.max(f4, f5);
          if (f5 > 0.0F) {
            f1 = Math.abs(f1 * f7 - f6 * f2) / f5;
          } else {
            f1 = 0.0F;
          }
          if (f1 == 0.0F)
          {
            paramMatrix = this;
          }
          else
          {
            localObject1 = this;
            Object localObject3 = a;
            if (localObject2 != null)
            {
              ((Path)localObject3).reset();
              paramMatrix = a;
              if (paramMatrix != null) {
                b.a(paramMatrix, (Path)localObject3);
              }
              localObject3 = a;
              b.reset();
              Object localObject4;
              if (((g.f)localObject2).b())
              {
                localObject4 = b;
                if (c == 0) {
                  paramMatrix = Path.FillType.WINDING;
                } else {
                  paramMatrix = Path.FillType.EVEN_ODD;
                }
                ((Path)localObject4).setFillType(paramMatrix);
                b.addPath((Path)localObject3, c);
                paramCanvas.clipPath(b);
                paramMatrix = (Matrix)localObject1;
              }
              else
              {
                localObject2 = (g.c)localObject2;
                if ((k != 0.0F) || (l != 1.0F))
                {
                  f5 = k;
                  f7 = m;
                  f6 = l;
                  if (f == null) {
                    f = new PathMeasure();
                  }
                  f.setPath(a, false);
                  f2 = f.getLength();
                  f5 = (f5 + f7) % 1.0F * f2;
                  f6 = (f6 + f7) % 1.0F * f2;
                  ((Path)localObject3).reset();
                  if (f5 > f6)
                  {
                    f.getSegment(f5, f2, (Path)localObject3, true);
                    f.getSegment(0.0F, f6, (Path)localObject3, true);
                  }
                  else
                  {
                    f.getSegment(f5, f6, (Path)localObject3, true);
                  }
                  ((Path)localObject3).rLineTo(0.0F, 0.0F);
                }
                b.addPath((Path)localObject3, c);
                paramMatrix = h;
                int i2;
                if ((!paramMatrix.a()) && (c == 0)) {
                  i2 = 0;
                } else {
                  i2 = 1;
                }
                if (i2 != 0)
                {
                  paramMatrix = h;
                  if (e == null)
                  {
                    localObject3 = new Paint(1);
                    e = ((Paint)localObject3);
                    ((Paint)localObject3).setStyle(Paint.Style.FILL);
                  }
                  localObject3 = e;
                  if (paramMatrix.a())
                  {
                    paramMatrix = a;
                    paramMatrix.setLocalMatrix(c);
                    ((Paint)localObject3).setShader(paramMatrix);
                    ((Paint)localObject3).setAlpha(Math.round(j * 255.0F));
                  }
                  else
                  {
                    ((Paint)localObject3).setShader(null);
                    ((Paint)localObject3).setAlpha(255);
                    ((Paint)localObject3).setColor(g.a(c, j));
                  }
                  ((Paint)localObject3).setColorFilter(paramColorFilter);
                  localObject4 = b;
                  if (c == 0) {
                    paramMatrix = Path.FillType.WINDING;
                  } else {
                    paramMatrix = Path.FillType.EVEN_ODD;
                  }
                  ((Path)localObject4).setFillType(paramMatrix);
                  paramCanvas.drawPath(b, (Paint)localObject3);
                }
                paramMatrix = f;
                if ((!paramMatrix.a()) && (c == 0)) {
                  i2 = 0;
                } else {
                  i2 = 1;
                }
                paramMatrix = (Matrix)localObject1;
                if (i2 != 0)
                {
                  localObject3 = f;
                  if (d == null)
                  {
                    paramMatrix = new Paint(1);
                    d = paramMatrix;
                    paramMatrix.setStyle(Paint.Style.STROKE);
                  }
                  paramMatrix = d;
                  localObject4 = o;
                  if (localObject4 != null) {
                    paramMatrix.setStrokeJoin((Paint.Join)localObject4);
                  }
                  localObject4 = n;
                  if (localObject4 != null) {
                    paramMatrix.setStrokeCap((Paint.Cap)localObject4);
                  }
                  paramMatrix.setStrokeMiter(p);
                  if (((d.i.b.b.a)localObject3).a())
                  {
                    localObject3 = a;
                    ((Shader)localObject3).setLocalMatrix(c);
                    paramMatrix.setShader((Shader)localObject3);
                    paramMatrix.setAlpha(Math.round(i * 255.0F));
                  }
                  else
                  {
                    paramMatrix.setShader(null);
                    paramMatrix.setAlpha(255);
                    paramMatrix.setColor(g.a(c, i));
                  }
                  paramMatrix.setColorFilter(paramColorFilter);
                  paramMatrix.setStrokeWidth(g * (f1 * f3));
                  paramCanvas.drawPath(b, paramMatrix);
                  paramMatrix = (Matrix)localObject1;
                }
              }
            }
            else
            {
              throw null;
            }
          }
        }
        i1++;
      }
      paramCanvas.restore();
    }
    
    public float getAlpha()
    {
      return getRootAlpha() / 255.0F;
    }
    
    public int getRootAlpha()
    {
      return m;
    }
    
    public void setAlpha(float paramFloat)
    {
      setRootAlpha((int)(paramFloat * 255.0F));
    }
    
    public void setRootAlpha(int paramInt)
    {
      m = paramInt;
    }
  }
  
  public static class h
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
    
    public h()
    {
      b = new g.g();
    }
    
    public h(h paramh)
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
  
  public static class i
    extends Drawable.ConstantState
  {
    public final Drawable.ConstantState a;
    
    public i(Drawable.ConstantState paramConstantState)
    {
      a = paramConstantState;
    }
    
    public boolean canApplyTheme()
    {
      return a.canApplyTheme();
    }
    
    public int getChangingConfigurations()
    {
      return a.getChangingConfigurations();
    }
    
    public Drawable newDrawable()
    {
      g localg = new g();
      x = ((VectorDrawable)a.newDrawable());
      return localg;
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      g localg = new g();
      x = ((VectorDrawable)a.newDrawable(paramResources));
      return localg;
    }
    
    public Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      g localg = new g();
      x = ((VectorDrawable)a.newDrawable(paramResources, paramTheme));
      return localg;
    }
  }
}

/* Location:
 * Qualified Name:     d.y.a.a.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */