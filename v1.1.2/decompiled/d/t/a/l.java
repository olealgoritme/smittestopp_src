package d.t.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.j;
import androidx.recyclerview.widget.RecyclerView.m;
import androidx.recyclerview.widget.RecyclerView.n;
import d.i.i.n;
import java.util.ArrayList;
import java.util.List;

public class l
  extends RecyclerView.j
  implements RecyclerView.m
{
  public static final int[] D = { 16842919 };
  public static final int[] E = new int[0];
  public int A = 0;
  public final Runnable B = new a();
  public final RecyclerView.n C = new b();
  public final int a;
  public final int b;
  public final StateListDrawable c;
  public final Drawable d;
  public final int e;
  public final int f;
  public final StateListDrawable g;
  public final Drawable h;
  public final int i;
  public final int j;
  public int k;
  public int l;
  public float m;
  public int n;
  public int o;
  public float p;
  public int q = 0;
  public int r = 0;
  public RecyclerView s;
  public boolean t = false;
  public boolean u = false;
  public int v = 0;
  public int w = 0;
  public final int[] x = new int[2];
  public final int[] y = new int[2];
  public final ValueAnimator z = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
  
  public l(RecyclerView paramRecyclerView, StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2, int paramInt1, int paramInt2, int paramInt3)
  {
    c = paramStateListDrawable1;
    d = paramDrawable1;
    g = paramStateListDrawable2;
    h = paramDrawable2;
    e = Math.max(paramInt1, paramStateListDrawable1.getIntrinsicWidth());
    f = Math.max(paramInt1, paramDrawable1.getIntrinsicWidth());
    i = Math.max(paramInt1, paramStateListDrawable2.getIntrinsicWidth());
    j = Math.max(paramInt1, paramDrawable2.getIntrinsicWidth());
    a = paramInt2;
    b = paramInt3;
    c.setAlpha(255);
    d.setAlpha(255);
    z.addListener(new c());
    z.addUpdateListener(new d());
    paramDrawable1 = s;
    if (paramDrawable1 != paramRecyclerView)
    {
      if (paramDrawable1 != null)
      {
        paramStateListDrawable1 = I;
        if (paramStateListDrawable1 != null) {
          paramStateListDrawable1.a("Cannot remove item decoration during a scroll  or layout");
        }
        K.remove(this);
        if (K.isEmpty())
        {
          boolean bool;
          if (paramDrawable1.getOverScrollMode() == 2) {
            bool = true;
          } else {
            bool = false;
          }
          paramDrawable1.setWillNotDraw(bool);
        }
        paramDrawable1.l();
        paramDrawable1.requestLayout();
        paramStateListDrawable1 = s;
        L.remove(this);
        if (M == this) {
          M = null;
        }
        paramDrawable1 = s;
        paramStateListDrawable1 = C;
        paramDrawable1 = E0;
        if (paramDrawable1 != null) {
          paramDrawable1.remove(paramStateListDrawable1);
        }
        a();
      }
      s = paramRecyclerView;
      if (paramRecyclerView != null)
      {
        paramStateListDrawable1 = I;
        if (paramStateListDrawable1 != null) {
          paramStateListDrawable1.a("Cannot add item decoration during a scroll  or layout");
        }
        if (K.isEmpty()) {
          paramRecyclerView.setWillNotDraw(false);
        }
        K.add(this);
        paramRecyclerView.l();
        paramRecyclerView.requestLayout();
        s.L.add(this);
        paramRecyclerView = s;
        paramStateListDrawable1 = C;
        if (E0 == null) {
          E0 = new ArrayList();
        }
        E0.add(paramStateListDrawable1);
      }
    }
  }
  
  public final int a(float paramFloat1, float paramFloat2, int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = paramArrayOfInt[1] - paramArrayOfInt[0];
    if (i1 == 0) {
      return 0;
    }
    paramFloat1 = (paramFloat2 - paramFloat1) / i1;
    paramInt1 -= paramInt3;
    paramInt3 = (int)(paramFloat1 * paramInt1);
    paramInt2 += paramInt3;
    if ((paramInt2 < paramInt1) && (paramInt2 >= 0)) {
      return paramInt3;
    }
    return 0;
  }
  
  public final void a()
  {
    s.removeCallbacks(B);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt == 2) && (v != 2))
    {
      c.setState(D);
      a();
    }
    if (paramInt == 0) {
      s.invalidate();
    } else {
      b();
    }
    if ((v == 2) && (paramInt != 2))
    {
      c.setState(E);
      a();
      s.postDelayed(B, 'Ұ');
    }
    else if (paramInt == 1)
    {
      a();
      s.postDelayed(B, 'ל');
    }
    v = paramInt;
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 >= r - i)
    {
      int i1 = o;
      int i2 = n;
      if ((paramFloat1 >= i1 - i2 / 2) && (paramFloat1 <= i2 / 2 + i1))
      {
        bool = true;
        break label59;
      }
    }
    boolean bool = false;
    label59:
    return bool;
  }
  
  public boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    int i1 = v;
    boolean bool1 = false;
    if (i1 == 1)
    {
      boolean bool2 = b(paramMotionEvent.getX(), paramMotionEvent.getY());
      boolean bool3 = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      bool4 = bool1;
      if (paramMotionEvent.getAction() != 0) {
        break label129;
      }
      if (!bool2)
      {
        bool4 = bool1;
        if (!bool3) {
          break label129;
        }
      }
      if (bool3)
      {
        w = 1;
        p = ((int)paramMotionEvent.getX());
      }
      else if (bool2)
      {
        w = 2;
        m = ((int)paramMotionEvent.getY());
      }
      a(2);
    }
    else
    {
      bool4 = bool1;
      if (i1 != 2) {
        break label129;
      }
    }
    boolean bool4 = true;
    label129:
    return bool4;
  }
  
  public void b()
  {
    int i1 = A;
    if (i1 != 0)
    {
      if (i1 == 3) {
        z.cancel();
      }
    }
    else
    {
      A = 1;
      ValueAnimator localValueAnimator = z;
      localValueAnimator.setFloatValues(new float[] { ((Float)localValueAnimator.getAnimatedValue()).floatValue(), 1.0F });
      z.setDuration(500L);
      z.setStartDelay(0L);
      z.start();
    }
  }
  
  public void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
  {
    if (v == 0) {
      return;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      boolean bool1 = b(paramMotionEvent.getX(), paramMotionEvent.getY());
      boolean bool2 = a(paramMotionEvent.getX(), paramMotionEvent.getY());
      if ((bool1) || (bool2))
      {
        if (bool2)
        {
          w = 1;
          p = ((int)paramMotionEvent.getX());
        }
        else if (bool1)
        {
          w = 2;
          m = ((int)paramMotionEvent.getY());
        }
        a(2);
      }
    }
    else if ((paramMotionEvent.getAction() == 1) && (v == 2))
    {
      m = 0.0F;
      p = 0.0F;
      a(1);
      w = 0;
    }
    else if ((paramMotionEvent.getAction() == 2) && (v == 2))
    {
      b();
      float f1;
      int i1;
      if (w == 1)
      {
        f1 = paramMotionEvent.getX();
        paramRecyclerView = y;
        i1 = b;
        paramRecyclerView[0] = i1;
        paramRecyclerView[1] = (q - i1);
        f1 = Math.max(paramRecyclerView[0], Math.min(paramRecyclerView[1], f1));
        if (Math.abs(o - f1) >= 2.0F)
        {
          i1 = a(p, f1, paramRecyclerView, s.computeHorizontalScrollRange(), s.computeHorizontalScrollOffset(), q);
          if (i1 != 0) {
            s.scrollBy(i1, 0);
          }
          p = f1;
        }
      }
      if (w == 2)
      {
        f1 = paramMotionEvent.getY();
        paramRecyclerView = x;
        i1 = b;
        paramRecyclerView[0] = i1;
        paramRecyclerView[1] = (r - i1);
        f1 = Math.max(paramRecyclerView[0], Math.min(paramRecyclerView[1], f1));
        if (Math.abs(l - f1) >= 2.0F)
        {
          i1 = a(m, f1, paramRecyclerView, s.computeVerticalScrollRange(), s.computeVerticalScrollOffset(), r);
          if (i1 != 0) {
            s.scrollBy(0, i1);
          }
          m = f1;
        }
      }
    }
  }
  
  public boolean b(float paramFloat1, float paramFloat2)
  {
    int i1 = n.i(s);
    boolean bool1 = false;
    if (i1 == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      bool2 = bool1;
      if (paramFloat1 > e / 2) {
        break label109;
      }
    }
    else
    {
      bool2 = bool1;
      if (paramFloat1 < q - e) {
        break label109;
      }
    }
    int i2 = l;
    i1 = k / 2;
    boolean bool2 = bool1;
    if (paramFloat2 >= i2 - i1)
    {
      bool2 = bool1;
      if (paramFloat2 <= i1 + i2) {
        bool2 = true;
      }
    }
    label109:
    return bool2;
  }
  
  public class a
    implements Runnable
  {
    public a() {}
    
    public void run()
    {
      l locall = l.this;
      int i = A;
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
      }
      else {
        z.cancel();
      }
      A = 3;
      ValueAnimator localValueAnimator = z;
      localValueAnimator.setFloatValues(new float[] { ((Float)localValueAnimator.getAnimatedValue()).floatValue(), 0.0F });
      z.setDuration('Ǵ');
      z.start();
    }
  }
  
  public class b
    extends RecyclerView.n
  {
    public b() {}
  }
  
  public class c
    extends AnimatorListenerAdapter
  {
    public boolean a = false;
    
    public c() {}
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      a = true;
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (a)
      {
        a = false;
        return;
      }
      if (((Float)z.getAnimatedValue()).floatValue() == 0.0F)
      {
        paramAnimator = l.this;
        A = 0;
        paramAnimator.a(0);
      }
      else
      {
        paramAnimator = l.this;
        A = 2;
        s.invalidate();
      }
    }
  }
  
  public class d
    implements ValueAnimator.AnimatorUpdateListener
  {
    public d() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F);
      c.setAlpha(i);
      d.setAlpha(i);
      s.invalidate();
    }
  }
}

/* Location:
 * Qualified Name:     d.t.a.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */