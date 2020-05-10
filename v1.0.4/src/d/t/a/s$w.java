package d.t.a;

import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import d.i.i.n;
import java.util.ArrayList;
import java.util.Arrays;

public class s$w
  implements Runnable
{
  public Interpolator A = s.b1;
  public boolean B = false;
  public boolean C = false;
  public int x;
  public int y;
  public OverScroller z;
  
  public s$w(s params)
  {
    z = new OverScroller(params.getContext(), s.b1);
  }
  
  public void a()
  {
    if (B)
    {
      C = true;
    }
    else
    {
      D.removeCallbacks(this);
      n.a(D, this);
    }
  }
  
  public void run()
  {
    Object localObject1 = D;
    if (I == null)
    {
      ((ViewGroup)localObject1).removeCallbacks(this);
      z.abortAnimation();
      return;
    }
    C = false;
    B = true;
    ((s)localObject1).b();
    localObject1 = z;
    Object localObject2 = D.I;
    if (((OverScroller)localObject1).computeScrollOffset())
    {
      localObject2 = D.O0;
      int i = ((OverScroller)localObject1).getCurrX();
      int j = ((OverScroller)localObject1).getCurrY();
      int k = i - x;
      int m = j - y;
      x = i;
      y = j;
      i = k;
      j = m;
      if (D.a(k, m, (int[])localObject2, null, 1))
      {
        i = k - localObject2[0];
        j = m - localObject2[1];
      }
      if (!D.K.isEmpty()) {
        D.invalidate();
      }
      if (D.getOverScrollMode() != 2) {
        D.a(i, j);
      }
      D.a(0, 0, 0, 0, null, 1);
      if (!s.a(D)) {
        D.invalidate();
      }
      if ((j != 0) && (D.I.b()) && (j == 0)) {
        m = 1;
      } else {
        m = 0;
      }
      if ((i != 0) && (D.I.a()) && (i == 0)) {
        k = 1;
      } else {
        k = 0;
      }
      if (((i != 0) || (j != 0)) && (k == 0) && (m == 0)) {
        m = 0;
      } else {
        m = 1;
      }
      if ((!((OverScroller)localObject1).isFinished()) && ((m != 0) || (D.b(1))))
      {
        a();
        localObject1 = D;
        localObject2 = A0;
        if (localObject2 != null) {
          ((m)localObject2).a((s)localObject1, i, j);
        }
      }
      else
      {
        D.setScrollState(0);
        if (s.X0)
        {
          localObject1 = D.B0;
          localObject2 = c;
          if (localObject2 != null) {
            Arrays.fill((int[])localObject2, -1);
          }
          d = 0;
        }
        D.a(1);
      }
    }
    B = false;
    if (C) {
      a();
    }
  }
}

/* Location:
 * Qualified Name:     base.d.t.a.s.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */