package d.i.j;

import android.content.res.Resources;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ListView;
import d.i.i.n;

public abstract class a
  implements View.OnTouchListener
{
  public static final int N = ;
  public Runnable A;
  public float[] B = { 0.0F, 0.0F };
  public float[] C = { Float.MAX_VALUE, Float.MAX_VALUE };
  public int D;
  public int E;
  public float[] F = { 0.0F, 0.0F };
  public float[] G = { 0.0F, 0.0F };
  public float[] H = { Float.MAX_VALUE, Float.MAX_VALUE };
  public boolean I;
  public boolean J;
  public boolean K;
  public boolean L;
  public boolean M;
  public final a x = new a();
  public final Interpolator y = new AccelerateInterpolator();
  public final View z;
  
  public a(View paramView)
  {
    z = paramView;
    float f = getSystemgetDisplayMetricsdensity;
    int i = (int)(1575.0F * f + 0.5F);
    int j = (int)(f * 315.0F + 0.5F);
    f = i;
    paramView = H;
    f /= 1000.0F;
    paramView[0] = f;
    paramView[1] = f;
    f = j;
    paramView = G;
    f /= 1000.0F;
    paramView[0] = f;
    paramView[1] = f;
    D = 1;
    paramView = C;
    paramView[0] = Float.MAX_VALUE;
    paramView[1] = Float.MAX_VALUE;
    paramView = B;
    paramView[0] = 0.2F;
    paramView[1] = 0.2F;
    paramView = F;
    paramView[0] = 0.001F;
    paramView[1] = 0.001F;
    E = N;
    paramView = x;
    a = 500;
    b = 500;
  }
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    return paramFloat1;
  }
  
  public final float a(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 == 0.0F) {
      return 0.0F;
    }
    int i = D;
    if ((i != 0) && (i != 1))
    {
      if ((i == 2) && (paramFloat1 < 0.0F)) {
        return paramFloat1 / -paramFloat2;
      }
    }
    else if (paramFloat1 < paramFloat2)
    {
      if (paramFloat1 >= 0.0F) {
        return 1.0F - paramFloat1 / paramFloat2;
      }
      if ((L) && (D == 1)) {
        return 1.0F;
      }
    }
    return 0.0F;
  }
  
  public final float a(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = a(B[paramInt] * paramFloat2, 0.0F, C[paramInt]);
    float f2 = a(paramFloat1, f1);
    paramFloat1 = a(paramFloat2 - paramFloat1, f1) - f2;
    if (paramFloat1 < 0.0F)
    {
      paramFloat1 = -y.getInterpolation(-paramFloat1);
    }
    else
    {
      if (paramFloat1 <= 0.0F) {
        break label92;
      }
      paramFloat1 = y.getInterpolation(paramFloat1);
    }
    paramFloat1 = a(paramFloat1, -1.0F, 1.0F);
    break label94;
    label92:
    paramFloat1 = 0.0F;
    label94:
    boolean bool = paramFloat1 < 0.0F;
    if (!bool) {
      return 0.0F;
    }
    f1 = F[paramInt];
    f2 = G[paramInt];
    paramFloat2 = H[paramInt];
    paramFloat3 = f1 * paramFloat3;
    if (bool) {
      return a(paramFloat1 * paramFloat3, f2, paramFloat2);
    }
    return -a(-paramFloat1 * paramFloat3, f2, paramFloat2);
  }
  
  public final void a()
  {
    boolean bool = J;
    int i = 0;
    if (bool)
    {
      L = false;
    }
    else
    {
      a locala = x;
      if (locala == null) {
        break label97;
      }
      long l = AnimationUtils.currentAnimationTimeMillis();
      int j = (int)(l - e);
      int k = b;
      if (j <= k) {
        if (j < 0) {
          k = i;
        } else {
          k = j;
        }
      }
      k = k;
      j = locala.a(l);
      i = l;
    }
    return;
    label97:
    throw null;
  }
  
  public boolean b()
  {
    Object localObject = x;
    float f = d;
    int i = (int)(f / Math.abs(f));
    f = c;
    int j = (int)(f / Math.abs(f));
    boolean bool = true;
    if (i != 0)
    {
      localObject = O;
      j = ((ListView)localObject).getCount();
      if (j == 0) {}
      int k;
      int m;
      do
      {
        i = 0;
        break;
        k = ((ListView)localObject).getChildCount();
        m = ((ListView)localObject).getFirstVisiblePosition();
      } while (i > 0 ? (m + k >= j) || (((ListView)localObject).getChildAt(k - 1).getBottom() <= ((ListView)localObject).getHeight()) : (i >= 0) || ((m <= 0) && (((ListView)localObject).getChildAt(0).getTop() >= 0)));
      i = 1;
      if (i != 0) {}
    }
    else
    {
      bool = false;
    }
    return bool;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (!M) {
      return false;
    }
    int i = paramMotionEvent.getActionMasked();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          if (i != 3) {
            break label207;
          }
        }
      }
      else
      {
        a();
        break label207;
      }
    }
    else
    {
      K = true;
      I = false;
    }
    float f1 = a(0, paramMotionEvent.getX(), paramView.getWidth(), z.getWidth());
    float f2 = a(1, paramMotionEvent.getY(), paramView.getHeight(), z.getHeight());
    paramView = x;
    c = f1;
    d = f2;
    if ((!L) && (b()))
    {
      if (A == null) {
        A = new b();
      }
      L = true;
      J = true;
      if (!I)
      {
        i = E;
        if (i > 0)
        {
          n.a(z, A, i);
          break label202;
        }
      }
      A.run();
      label202:
      I = true;
    }
    label207:
    return false;
  }
  
  public static class a
  {
    public int a;
    public int b;
    public float c;
    public float d;
    public long e = Long.MIN_VALUE;
    public long f = 0L;
    public int g = 0;
    public int h = 0;
    public long i = -1L;
    public float j;
    public int k;
    
    public final float a(long paramLong)
    {
      if (paramLong < e) {
        return 0.0F;
      }
      long l = i;
      if ((l >= 0L) && (paramLong >= l))
      {
        float f1 = j;
        return a.a((float)(paramLong - l) / k, 0.0F, 1.0F) * f1 + (1.0F - f1);
      }
      return a.a((float)(paramLong - e) / a, 0.0F, 1.0F) * 0.5F;
    }
  }
  
  public class b
    implements Runnable
  {
    public b() {}
    
    public void run()
    {
      Object localObject = a.this;
      if (!L) {
        return;
      }
      long l1;
      if (J)
      {
        J = false;
        localObject = x;
        if (localObject != null)
        {
          l1 = AnimationUtils.currentAnimationTimeMillis();
          e = l1;
          i = -1L;
          f = l1;
          j = 0.5F;
          g = 0;
          h = 0;
        }
        else
        {
          throw null;
        }
      }
      a.a locala = x;
      int i;
      if ((i > 0L) && (AnimationUtils.currentAnimationTimeMillis() > i + k)) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i == 0) && (b()))
      {
        localObject = a.this;
        if (K)
        {
          K = false;
          if (localObject != null)
          {
            l1 = SystemClock.uptimeMillis();
            MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
            z.onTouchEvent(localMotionEvent);
            localMotionEvent.recycle();
          }
          else
          {
            throw null;
          }
        }
        if (f != 0L)
        {
          l1 = AnimationUtils.currentAnimationTimeMillis();
          float f = locala.a(l1);
          long l2 = f;
          f = l1;
          f = (float)(l1 - l2) * (f * 4.0F + -4.0F * f * f);
          g = ((int)(c * f));
          i = (int)(f * d);
          h = i;
          O.scrollListBy(i);
          n.a(z, this);
          return;
        }
        throw new RuntimeException("Cannot compute scroll delta before calling start()");
      }
      L = false;
    }
  }
}

/* Location:
 * Qualified Name:     d.i.j.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */