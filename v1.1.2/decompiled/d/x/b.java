package d.x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
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
import d.b.a.s;
import d.i.i.n;
import java.util.Map;

public class b
  extends h
{
  public static final String[] i0 = { "android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY" };
  public static final Property<Drawable, PointF> j0 = new b(PointF.class, "boundsOrigin");
  public static final Property<k, PointF> k0 = new c(PointF.class, "topLeft");
  public static final Property<k, PointF> l0 = new d(PointF.class, "bottomRight");
  public static final Property<View, PointF> m0 = new e(PointF.class, "bottomRight");
  public static final Property<View, PointF> n0 = new f(PointF.class, "topLeft");
  public static final Property<View, PointF> o0 = new g(PointF.class, "position");
  public static f p0 = new f();
  public int[] f0 = new int[2];
  public boolean g0 = false;
  public boolean h0 = false;
  
  public Animator a(final ViewGroup paramViewGroup, final p paramp1, p paramp2)
  {
    if ((paramp1 != null) && (paramp2 != null))
    {
      final Object localObject1 = a;
      final Object localObject2 = a;
      localObject1 = (ViewGroup)((Map)localObject1).get("android:changeBounds:parent");
      ViewGroup localViewGroup = (ViewGroup)((Map)localObject2).get("android:changeBounds:parent");
      if ((localObject1 != null) && (localViewGroup != null))
      {
        localObject2 = b;
        final Object localObject3;
        if (h0)
        {
          localObject3 = b((View)localObject1, true);
          if (localObject3 == null ? localObject1 != localViewGroup : localViewGroup != b)
          {
            i = 0;
            break label123;
          }
        }
        int i = 1;
        label123:
        final int k;
        int i8;
        int i9;
        if (i != 0)
        {
          paramViewGroup = (Rect)a.get("android:changeBounds:bounds");
          localObject1 = (Rect)a.get("android:changeBounds:bounds");
          int j = left;
          k = left;
          int m = top;
          final int n = top;
          int i1 = right;
          final int i2 = right;
          int i3 = bottom;
          final int i4 = bottom;
          int i5 = i1 - j;
          int i6 = i3 - m;
          int i7 = i2 - k;
          i8 = i4 - n;
          paramp1 = (Rect)a.get("android:changeBounds:clip");
          localObject3 = (Rect)a.get("android:changeBounds:clip");
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
          if ((paramp1 == null) || (paramp1.equals(localObject3)))
          {
            i9 = i;
            if (paramp1 == null)
            {
              i9 = i;
              if (localObject3 == null) {}
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
                  paramViewGroup = s.a(paramViewGroup, o0, paramp1);
                }
                else
                {
                  paramp1 = new k(paramViewGroup);
                  paramViewGroup = b0.a(j, m, k, n);
                  paramp2 = s.a(paramp1, k0, paramViewGroup);
                  paramViewGroup = b0.a(i1, i3, i2, i4);
                  localObject1 = s.a(paramp1, l0, paramViewGroup);
                  paramViewGroup = new AnimatorSet();
                  paramViewGroup.playTogether(new Animator[] { paramp2, localObject1 });
                  paramViewGroup.addListener(new h(paramp1));
                }
              }
              else if ((j == k) && (m == n))
              {
                paramp1 = b0.a(i1, i3, i2, i4);
                paramViewGroup = s.a(paramViewGroup, m0, paramp1);
              }
              else
              {
                paramp1 = b0.a(j, m, k, n);
                paramViewGroup = s.a(paramViewGroup, n0, paramp1);
              }
            }
            else
            {
              localObject1 = localObject2;
              v.a((View)localObject1, j, m, Math.max(i5, i7) + j, Math.max(i6, i8) + m);
              if ((j == k) && (m == n))
              {
                paramViewGroup = null;
              }
              else
              {
                paramViewGroup = b0.a(j, m, k, n);
                paramViewGroup = s.a(localObject1, o0, paramViewGroup);
              }
              if (paramp1 == null) {
                paramp1 = new Rect(0, 0, i5, i6);
              }
              if (localObject3 == null) {
                paramp2 = new Rect(0, 0, i7, i8);
              } else {
                paramp2 = (p)localObject3;
              }
              if (!paramp1.equals(paramp2))
              {
                n.a((View)localObject1, paramp1);
                paramp1 = ObjectAnimator.ofObject(localObject1, "clipBounds", p0, new Object[] { paramp1, paramp2 });
                paramp1.addListener(new i((View)localObject1, (Rect)localObject3, k, n, i2, i4));
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
              s.a(paramp1, true);
              a(new j(paramp1));
            }
            return paramViewGroup;
          }
        }
        else
        {
          i9 = ((Integer)a.get("android:changeBounds:windowX")).intValue();
          i = ((Integer)a.get("android:changeBounds:windowY")).intValue();
          k = ((Integer)a.get("android:changeBounds:windowX")).intValue();
          i8 = ((Integer)a.get("android:changeBounds:windowY")).intValue();
          if ((i9 != k) || (i != i8)) {
            break label990;
          }
        }
        return null;
        label990:
        paramViewGroup.getLocationInWindow(f0);
        paramp1 = Bitmap.createBitmap(((View)localObject2).getWidth(), ((View)localObject2).getHeight(), Bitmap.Config.ARGB_8888);
        ((View)localObject2).draw(new Canvas(paramp1));
        paramp1 = new BitmapDrawable(paramp1);
        final float f = v.b((View)localObject2);
        v.a.a((View)localObject2, 0.0F);
        paramViewGroup.getOverlay().add(paramp1);
        paramp2 = b0;
        localObject1 = f0;
        paramp2 = paramp2.a(i9 - localObject1[0], i - localObject1[1], k - localObject1[0], i8 - localObject1[1]);
        paramp2 = ObjectAnimator.ofPropertyValuesHolder(paramp1, new PropertyValuesHolder[] { PropertyValuesHolder.ofObject(j0, null, paramp2) });
        paramp2.addListener(new a(paramViewGroup, paramp1, (View)localObject2, f));
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
  
  public class a
    extends AnimatorListenerAdapter
  {
    public a(ViewGroup paramViewGroup, BitmapDrawable paramBitmapDrawable, View paramView, float paramFloat) {}
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      u localu = v.a(paramViewGroup);
      paramAnimator = paramp1;
      a.remove(paramAnimator);
      paramAnimator = localObject2;
      float f = f;
      v.a.a(paramAnimator, f);
    }
  }
  
  public static final class b
    extends Property<Drawable, PointF>
  {
    public Rect a = new Rect();
    
    public b(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public Object get(Object paramObject)
    {
      ((Drawable)paramObject).copyBounds(a);
      paramObject = a;
      return new PointF(left, top);
    }
    
    public void set(Object paramObject1, Object paramObject2)
    {
      paramObject1 = (Drawable)paramObject1;
      paramObject2 = (PointF)paramObject2;
      ((Drawable)paramObject1).copyBounds(a);
      a.offsetTo(Math.round(x), Math.round(y));
      ((Drawable)paramObject1).setBounds(a);
    }
  }
  
  public static final class c
    extends Property<b.k, PointF>
  {
    public c(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public Object get(Object paramObject)
    {
      paramObject = (b.k)paramObject;
      return null;
    }
    
    public void set(Object paramObject1, Object paramObject2)
    {
      paramObject1 = (b.k)paramObject1;
      paramObject2 = (PointF)paramObject2;
      if (paramObject1 != null)
      {
        a = Math.round(x);
        int i = Math.round(y);
        b = i;
        int j = f + 1;
        f = j;
        if (j == g)
        {
          v.a(e, a, i, c, d);
          f = 0;
          g = 0;
        }
        return;
      }
      throw null;
    }
  }
  
  public static final class d
    extends Property<b.k, PointF>
  {
    public d(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public Object get(Object paramObject)
    {
      paramObject = (b.k)paramObject;
      return null;
    }
    
    public void set(Object paramObject1, Object paramObject2)
    {
      paramObject1 = (b.k)paramObject1;
      paramObject2 = (PointF)paramObject2;
      if (paramObject1 != null)
      {
        c = Math.round(x);
        int i = Math.round(y);
        d = i;
        int j = g + 1;
        g = j;
        if (f == j)
        {
          v.a(e, a, b, c, i);
          f = 0;
          g = 0;
        }
        return;
      }
      throw null;
    }
  }
  
  public static final class e
    extends Property<View, PointF>
  {
    public e(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public Object get(Object paramObject)
    {
      paramObject = (View)paramObject;
      return null;
    }
    
    public void set(Object paramObject1, Object paramObject2)
    {
      paramObject1 = (View)paramObject1;
      paramObject2 = (PointF)paramObject2;
      v.a((View)paramObject1, ((View)paramObject1).getLeft(), ((View)paramObject1).getTop(), Math.round(x), Math.round(y));
    }
  }
  
  public static final class f
    extends Property<View, PointF>
  {
    public f(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public Object get(Object paramObject)
    {
      paramObject = (View)paramObject;
      return null;
    }
    
    public void set(Object paramObject1, Object paramObject2)
    {
      paramObject1 = (View)paramObject1;
      paramObject2 = (PointF)paramObject2;
      v.a((View)paramObject1, Math.round(x), Math.round(y), ((View)paramObject1).getRight(), ((View)paramObject1).getBottom());
    }
  }
  
  public static final class g
    extends Property<View, PointF>
  {
    public g(Class paramClass, String paramString)
    {
      super(paramString);
    }
    
    public Object get(Object paramObject)
    {
      paramObject = (View)paramObject;
      return null;
    }
    
    public void set(Object paramObject1, Object paramObject2)
    {
      paramObject1 = (View)paramObject1;
      paramObject2 = (PointF)paramObject2;
      int i = Math.round(x);
      int j = Math.round(y);
      v.a((View)paramObject1, i, j, ((View)paramObject1).getWidth() + i, ((View)paramObject1).getHeight() + j);
    }
  }
  
  public class h
    extends AnimatorListenerAdapter
  {
    public b.k mViewBounds = paramp1;
    
    public h(b.k paramk) {}
  }
  
  public class i
    extends AnimatorListenerAdapter
  {
    public boolean a;
    
    public i(View paramView, Rect paramRect, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      a = true;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (!a)
      {
        n.a(localObject1, localObject3);
        v.a(localObject1, k, n, i2, i4);
      }
    }
  }
  
  public class j
    extends k
  {
    public boolean a = false;
    
    public j(ViewGroup paramViewGroup) {}
    
    public void b(h paramh)
    {
      s.a(paramp1, false);
    }
    
    public void c(h paramh)
    {
      s.a(paramp1, true);
    }
    
    public void d(h paramh)
    {
      if (!a) {
        s.a(paramp1, false);
      }
      paramh.b(this);
    }
  }
  
  public static class k
  {
    public int a;
    public int b;
    public int c;
    public int d;
    public View e;
    public int f;
    public int g;
    
    public k(View paramView)
    {
      e = paramView;
    }
  }
}

/* Location:
 * Qualified Name:     d.x.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */