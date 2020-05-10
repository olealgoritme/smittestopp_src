package e.c.a.b.i;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton.b;
import d.i.i.n;
import e.c.a.b.a.a;
import e.c.a.b.a.g;
import e.c.a.b.a.h;
import e.c.a.b.l.b;
import java.util.ArrayList;

public class e
{
  public static final int[] A = { 16842910 };
  public static final int[] B = new int[0];
  public static final TimeInterpolator v = a.b;
  public static final int[] w = { 16842919, 16842910 };
  public static final int[] x = { 16843623, 16842908, 16842910 };
  public static final int[] y = { 16842908, 16842910 };
  public static final int[] z = { 16843623, 16842910 };
  public int a = 0;
  public Animator b;
  public g c;
  public g d;
  public g e;
  public g f;
  public final e.c.a.b.j.c g;
  public float h;
  public float i;
  public float j;
  public float k;
  public float l = 1.0F;
  public ArrayList<Animator.AnimatorListener> m;
  public ArrayList<Animator.AnimatorListener> n;
  public final e.c.a.b.j.f o;
  public final b p;
  public final Rect q = new Rect();
  public final RectF r = new RectF();
  public final RectF s = new RectF();
  public final Matrix t = new Matrix();
  public ViewTreeObserver.OnPreDrawListener u;
  
  public e(e.c.a.b.j.f paramf, b paramb)
  {
    o = paramf;
    p = paramb;
    paramf = new e.c.a.b.j.c();
    g = paramf;
    paramf.a(w, a(new e.c(this)));
    g.a(x, a(new e.b(this)));
    g.a(y, a(new e.b(this)));
    g.a(z, a(new e.b(this)));
    g.a(A, a(new e.e(this)));
    g.a(B, a(new e.a(this)));
    h = o.getRotation();
  }
  
  public float a()
  {
    throw null;
  }
  
  public final AnimatorSet a(g paramg, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ArrayList localArrayList = new ArrayList();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(o, View.ALPHA, new float[] { paramFloat1 });
    paramg.a("opacity").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(o, View.SCALE_X, new float[] { paramFloat2 });
    paramg.a("scale").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(o, View.SCALE_Y, new float[] { paramFloat2 });
    paramg.a("scale").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    t.reset();
    o.getDrawable();
    localObjectAnimator = ObjectAnimator.ofObject(o, new e.c.a.b.a.e(), new e.c.a.b.a.f(), new Matrix[] { new Matrix(t) });
    paramg.a("iconScale").a(localObjectAnimator);
    localArrayList.add(localObjectAnimator);
    paramg = new AnimatorSet();
    e.c.a.a.b.l.c.a(paramg, localArrayList);
    return paramg;
  }
  
  public final ValueAnimator a(e.f paramf)
  {
    ValueAnimator localValueAnimator = new ValueAnimator();
    localValueAnimator.setInterpolator(v);
    localValueAnimator.setDuration(100L);
    localValueAnimator.addListener(paramf);
    localValueAnimator.addUpdateListener(paramf);
    localValueAnimator.setFloatValues(new float[] { 0.0F, 1.0F });
    return localValueAnimator;
  }
  
  public final void a(float paramFloat)
  {
    l = paramFloat;
    Matrix localMatrix = t;
    localMatrix.reset();
    o.getDrawable();
    o.setImageMatrix(localMatrix);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    throw null;
  }
  
  public void a(ColorStateList paramColorStateList)
  {
    throw null;
  }
  
  public void a(Rect paramRect)
  {
    throw null;
  }
  
  public void a(int[] paramArrayOfInt)
  {
    throw null;
  }
  
  public void b(Rect paramRect)
  {
    throw null;
  }
  
  public boolean b()
  {
    int i1 = o.getVisibility();
    boolean bool1 = false;
    boolean bool2 = false;
    if (i1 != 0)
    {
      if (a == 2) {
        bool2 = true;
      }
      return bool2;
    }
    bool2 = bool1;
    if (a != 1) {
      bool2 = true;
    }
    return bool2;
  }
  
  public void c()
  {
    throw null;
  }
  
  public void d()
  {
    throw null;
  }
  
  public boolean e()
  {
    throw null;
  }
  
  public final boolean f()
  {
    boolean bool;
    if ((n.t(o)) && (!o.isInEditMode())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final void g()
  {
    Rect localRect = q;
    a(localRect);
    b(localRect);
    Object localObject = p;
    int i1 = left;
    int i2 = top;
    int i3 = right;
    int i4 = bottom;
    localObject = (FloatingActionButton.b)localObject;
    a.H.set(i1, i2, i3, i4);
    localObject = a;
    int i5 = F;
    ((ImageButton)localObject).setPadding(i1 + i5, i2 + i5, i3 + i5, i4 + i5);
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.b.i.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */