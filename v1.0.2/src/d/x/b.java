package d.x;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import d.b.a.r;
import d.i.i.n;
import java.util.Map;

public class b
  extends h
{
  public static final String[] i0 = { "android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY" };
  public static final Property<Drawable, PointF> j0 = new b.b(PointF.class, "boundsOrigin");
  public static final Property<b.k, PointF> k0 = new b.c(PointF.class, "topLeft");
  public static final Property<b.k, PointF> l0 = new b.d(PointF.class, "bottomRight");
  public static final Property<View, PointF> m0 = new b.e(PointF.class, "bottomRight");
  public static final Property<View, PointF> n0 = new b.f(PointF.class, "topLeft");
  public static final Property<View, PointF> o0 = new b.g(PointF.class, "position");
  public static f p0 = new f();
  public int[] f0 = new int[2];
  public boolean g0 = false;
  public boolean h0 = false;
  
  public Animator a(ViewGroup paramViewGroup, p paramp1, p paramp2)
  {
    if ((paramp1 != null) && (paramp2 != null))
    {
      Object localObject1 = a;
      Object localObject2 = a;
      localObject1 = (ViewGroup)((Map)localObject1).get("android:changeBounds:parent");
      Object localObject3 = (ViewGroup)((Map)localObject2).get("android:changeBounds:parent");
      if ((localObject1 != null) && (localObject3 != null))
      {
        localObject2 = b;
        if (h0)
        {
          p localp = b((View)localObject1, true);
          if (localp == null ? localObject1 != localObject3 : localObject3 != b)
          {
            i = 0;
            break label123;
          }
        }
        int i = 1;
        label123:
        int k;
        int i6;
        int i9;
        if (i != 0)
        {
          paramViewGroup = (Rect)a.get("android:changeBounds:bounds");
          localObject1 = (Rect)a.get("android:changeBounds:bounds");
          int j = left;
          k = left;
          int m = top;
          int n = top;
          int i1 = right;
          int i2 = right;
          int i3 = bottom;
          int i4 = bottom;
          int i5 = i1 - j;
          i6 = i3 - m;
          int i7 = i2 - k;
          int i8 = i4 - n;
          paramp1 = (Rect)a.get("android:changeBounds:clip");
          localObject1 = (Rect)a.get("android:changeBounds:clip");
          if (((i5 != 0) && (i6 != 0)) || ((i7 != 0) && (i8 != 0)))
          {
            if ((j == k) && (m == n)) {
              i9 = 0;
            } else {
              i9 = 1;
            }
            if (i1 == i2)
            {
              i = i9;
              if (i3 == i4) {}
            }
            else
            {
              i = i9 + 1;
            }
          }
          else
          {
            i = 0;
          }
          if ((paramp1 == null) || (paramp1.equals(localObject1)))
          {
            i9 = i;
            if (paramp1 == null)
            {
              i9 = i;
              if (localObject1 == null) {}
            }
          }
          else
          {
            i9 = i + 1;
          }
          if (i9 > 0)
          {
            if (!g0)
            {
              paramViewGroup = (ViewGroup)localObject2;
              v.a(paramViewGroup, j, m, i1, i3);
              if (i9 == 2)
              {
                if ((i5 == i7) && (i6 == i8))
                {
                  paramp1 = b0.a(j, m, k, n);
                  paramViewGroup = r.a(paramViewGroup, o0, paramp1);
                }
                else
                {
                  paramp1 = new b.k(paramViewGroup);
                  paramViewGroup = b0.a(j, m, k, n);
                  paramp2 = r.a(paramp1, k0, paramViewGroup);
                  paramViewGroup = b0.a(i1, i3, i2, i4);
                  localObject1 = r.a(paramp1, l0, paramViewGroup);
                  paramViewGroup = new AnimatorSet();
                  paramViewGroup.playTogether(new Animator[] { paramp2, localObject1 });
                  paramViewGroup.addListener(new b.h(this, paramp1));
                }
              }
              else if ((j == k) && (m == n))
              {
                paramp1 = b0.a(i1, i3, i2, i4);
                paramViewGroup = r.a(paramViewGroup, m0, paramp1);
              }
              else
              {
                paramp1 = b0.a(j, m, k, n);
                paramViewGroup = r.a(paramViewGroup, n0, paramp1);
              }
            }
            else
            {
              localObject3 = localObject2;
              v.a((View)localObject3, j, m, Math.max(i5, i7) + j, Math.max(i6, i8) + m);
              if ((j == k) && (m == n))
              {
                paramViewGroup = null;
              }
              else
              {
                paramViewGroup = b0.a(j, m, k, n);
                paramViewGroup = r.a(localObject3, o0, paramViewGroup);
              }
              if (paramp1 == null) {
                paramp1 = new Rect(0, 0, i5, i6);
              }
              if (localObject1 == null) {
                paramp2 = new Rect(0, 0, i7, i8);
              } else {
                paramp2 = (p)localObject1;
              }
              if (!paramp1.equals(paramp2))
              {
                n.a((View)localObject3, paramp1);
                paramp1 = ObjectAnimator.ofObject(localObject3, "clipBounds", p0, new Object[] { paramp1, paramp2 });
                paramp1.addListener(new b.i(this, (View)localObject3, (Rect)localObject1, k, n, i2, i4));
              }
              else
              {
                paramp1 = null;
              }
              paramViewGroup = o.a(paramViewGroup, paramp1);
            }
            if ((((View)localObject2).getParent() instanceof ViewGroup))
            {
              paramp1 = (ViewGroup)((View)localObject2).getParent();
              r.a(paramp1, true);
              a(new b.j(this, paramp1));
            }
            return paramViewGroup;
          }
        }
        else
        {
          i6 = ((Integer)a.get("android:changeBounds:windowX")).intValue();
          i = ((Integer)a.get("android:changeBounds:windowY")).intValue();
          k = ((Integer)a.get("android:changeBounds:windowX")).intValue();
          i9 = ((Integer)a.get("android:changeBounds:windowY")).intValue();
          if ((i6 != k) || (i != i9)) {
            break label990;
          }
        }
        return null;
        label990:
        paramViewGroup.getLocationInWindow(f0);
        paramp1 = Bitmap.createBitmap(((View)localObject2).getWidth(), ((View)localObject2).getHeight(), Bitmap.Config.ARGB_8888);
        ((View)localObject2).draw(new Canvas(paramp1));
        paramp1 = new BitmapDrawable(paramp1);
        float f = v.b((View)localObject2);
        v.a.a((View)localObject2, 0.0F);
        paramViewGroup.getOverlay().add(paramp1);
        localObject1 = b0;
        paramp2 = f0;
        paramp2 = ((e)localObject1).a(i6 - paramp2[0], i - paramp2[1], k - paramp2[0], i9 - paramp2[1]);
        paramp2 = ObjectAnimator.ofPropertyValuesHolder(paramp1, new PropertyValuesHolder[] { PropertyValuesHolder.ofObject(j0, null, paramp2) });
        paramp2.addListener(new b.a(this, paramViewGroup, paramp1, (View)localObject2, f));
        return paramp2;
      }
      return null;
    }
    return null;
  }
  
  public void a(p paramp)
  {
    d(paramp);
  }
  
  public String[] b()
  {
    return i0;
  }
  
  public void c(p paramp)
  {
    d(paramp);
  }
  
  public final void d(p paramp)
  {
    View localView = b;
    if ((n.t(localView)) || (localView.getWidth() != 0) || (localView.getHeight() != 0))
    {
      a.put("android:changeBounds:bounds", new Rect(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom()));
      a.put("android:changeBounds:parent", b.getParent());
      if (h0)
      {
        b.getLocationInWindow(f0);
        a.put("android:changeBounds:windowX", Integer.valueOf(f0[0]));
        a.put("android:changeBounds:windowY", Integer.valueOf(f0[1]));
      }
      if (g0) {
        a.put("android:changeBounds:clip", localView.getClipBounds());
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.d.x.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */