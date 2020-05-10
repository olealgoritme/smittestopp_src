package d.y.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.graphics.Shader;
import d.f.h;
import d.i.c.b;
import java.util.ArrayList;

public class g$g
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
  
  public g$g()
  {
    p = new d.f.a();
    h = new g.d();
    a = new Path();
    b = new Path();
  }
  
  public g$g(g paramg)
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
        float f6 = paramMatrix[0];
        f1 = paramMatrix[1];
        f2 = paramMatrix[2];
        float f7 = paramMatrix[3];
        f5 = Math.max(f4, f5);
        if (f5 > 0.0F) {
          f1 = Math.abs(f6 * f7 - f1 * f2) / f5;
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
                f6 = k;
                f5 = m;
                f7 = l;
                if (f == null) {
                  f = new PathMeasure();
                }
                f.setPath(a, false);
                f2 = f.getLength();
                f6 = (f6 + f5) % 1.0F * f2;
                f7 = (f7 + f5) % 1.0F * f2;
                ((Path)localObject3).reset();
                if (f6 > f7)
                {
                  f.getSegment(f6, f2, (Path)localObject3, true);
                  f.getSegment(0.0F, f7, (Path)localObject3, true);
                }
                else
                {
                  f.getSegment(f6, f7, (Path)localObject3, true);
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

/* Location:
 * Qualified Name:     base.d.y.a.a.g.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */