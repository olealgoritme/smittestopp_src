package androidx.recyclerview.widget;

import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import d.i.i.n;
import d.t.a.m;
import d.t.a.m.b;
import java.util.ArrayList;
import java.util.Arrays;

public class RecyclerView$v
  implements Runnable
{
  public Interpolator A = RecyclerView.b1;
  public boolean B = false;
  public boolean C = false;
  public int x;
  public int y;
  public OverScroller z;
  
  public RecyclerView$v(RecyclerView paramRecyclerView)
  {
    z = new OverScroller(paramRecyclerView.getContext(), RecyclerView.b1);
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
    ((RecyclerView)localObject1).b();
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
      j = k;
      i = m;
      if (D.a(k, m, (int[])localObject2, null, 1))
      {
        j = k - localObject2[0];
        i = m - localObject2[1];
      }
      if (!D.K.isEmpty()) {
        D.invalidate();
      }
      if (D.getOverScrollMode() != 2) {
        D.a(j, i);
      }
      D.a(0, 0, 0, 0, null, 1);
      if (!RecyclerView.a(D)) {
        D.invalidate();
      }
      if ((i != 0) && (D.I.b()) && (i == 0)) {
        m = 1;
      } else {
        m = 0;
      }
      if ((j != 0) && (D.I.a()) && (j == 0)) {
        k = 1;
      } else {
        k = 0;
      }
      if (((j != 0) || (i != 0)) && (k == 0) && (m == 0)) {
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
          ((m)localObject2).a((RecyclerView)localObject1, j, i);
        }
      }
      else
      {
        D.setScrollState(0);
        if (RecyclerView.X0)
        {
          localObject2 = D.B0;
          localObject1 = c;
          if (localObject1 != null) {
            Arrays.fill((int[])localObject1, -1);
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
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.v
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */