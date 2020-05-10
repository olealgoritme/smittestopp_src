package d.x;

import android.animation.Animator;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import d.f.a;
import d.f.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class l$a
  implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener
{
  public h x;
  public ViewGroup y;
  
  public l$a(h paramh, ViewGroup paramViewGroup)
  {
    x = paramh;
    y = paramViewGroup;
  }
  
  public boolean onPreDraw()
  {
    y.getViewTreeObserver().removeOnPreDrawListener(this);
    y.removeOnAttachStateChangeListener(this);
    if (!l.c.remove(y)) {
      return true;
    }
    Object localObject1 = l.a();
    Object localObject2 = (ArrayList)((d.f.h)localObject1).get(y);
    Object localObject3;
    if (localObject2 == null)
    {
      localObject3 = new ArrayList();
      ((d.f.h)localObject1).put(y, localObject3);
    }
    else
    {
      localObject3 = localObject2;
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject4 = new ArrayList((Collection)localObject2);
        localObject3 = localObject2;
        localObject2 = localObject4;
        break label104;
      }
    }
    localObject2 = null;
    label104:
    ((ArrayList)localObject3).add(x);
    x.a(new l.a.a(this, (a)localObject1));
    x.a(y, false);
    if (localObject2 != null)
    {
      localObject3 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((h)((Iterator)localObject3).next()).e(y);
      }
    }
    Object localObject4 = x;
    localObject1 = y;
    if (localObject4 != null)
    {
      Q = new ArrayList();
      R = new ArrayList();
      localObject3 = M;
      Object localObject5 = N;
      Object localObject6 = new a(a);
      Object localObject7 = new a(a);
      int j;
      Object localObject8;
      Object localObject9;
      Object localObject10;
      for (int i = 0;; i++)
      {
        localObject2 = P;
        if (i >= localObject2.length) {
          break;
        }
        j = localObject2[i];
        int k;
        if (j != 1)
        {
          View localView;
          if (j != 2)
          {
            if (j != 3)
            {
              if (j != 4)
              {
                localObject2 = localObject3;
              }
              else
              {
                localObject8 = c;
                localObject9 = c;
                k = ((e)localObject8).c();
                for (j = 0;; j++)
                {
                  localObject2 = localObject3;
                  if (j >= k) {
                    break;
                  }
                  localObject10 = (View)((e)localObject8).a(j);
                  if ((localObject10 != null) && (((h)localObject4).b((View)localObject10)))
                  {
                    if (x) {
                      ((e)localObject8).b();
                    }
                    localView = (View)((e)localObject9).a(y[j]);
                    if ((localView != null) && (((h)localObject4).b(localView)))
                    {
                      localObject2 = (p)((d.f.h)localObject6).getOrDefault(localObject10, null);
                      localObject11 = (p)((d.f.h)localObject7).getOrDefault(localView, null);
                      if ((localObject2 != null) && (localObject11 != null))
                      {
                        Q.add(localObject2);
                        R.add(localObject11);
                        ((d.f.h)localObject6).remove(localObject10);
                        ((d.f.h)localObject7).remove(localView);
                      }
                    }
                  }
                }
              }
              localObject3 = localObject2;
            }
            else
            {
              localObject2 = localObject3;
              localObject8 = b;
              localObject9 = b;
              k = ((SparseArray)localObject8).size();
              for (j = 0;; j++)
              {
                localObject3 = localObject2;
                if (j >= k) {
                  break;
                }
                localView = (View)((SparseArray)localObject8).valueAt(j);
                if ((localView != null) && (((h)localObject4).b(localView)))
                {
                  localObject3 = (View)((SparseArray)localObject9).get(((SparseArray)localObject8).keyAt(j));
                  if ((localObject3 != null) && (((h)localObject4).b((View)localObject3)))
                  {
                    localObject10 = (p)((d.f.h)localObject6).getOrDefault(localView, null);
                    localObject11 = (p)((d.f.h)localObject7).getOrDefault(localObject3, null);
                    if ((localObject10 != null) && (localObject11 != null))
                    {
                      Q.add(localObject10);
                      R.add(localObject11);
                      ((d.f.h)localObject6).remove(localView);
                      ((d.f.h)localObject7).remove(localObject3);
                    }
                  }
                }
              }
            }
          }
          else
          {
            localObject2 = localObject3;
            localObject8 = d;
            localObject9 = d;
            k = z;
            for (j = 0;; j++)
            {
              localObject3 = localObject2;
              if (j >= k) {
                break;
              }
              localObject10 = (View)((d.f.h)localObject8).e(j);
              if ((localObject10 != null) && (((h)localObject4).b((View)localObject10)))
              {
                localView = (View)((d.f.h)localObject9).get(((d.f.h)localObject8).c(j));
                if ((localView != null) && (((h)localObject4).b(localView)))
                {
                  localObject3 = (p)((d.f.h)localObject6).getOrDefault(localObject10, null);
                  localObject11 = (p)((d.f.h)localObject7).getOrDefault(localView, null);
                  if ((localObject3 != null) && (localObject11 != null))
                  {
                    Q.add(localObject3);
                    R.add(localObject11);
                    ((d.f.h)localObject6).remove(localObject10);
                    ((d.f.h)localObject7).remove(localView);
                  }
                }
              }
            }
          }
        }
        else
        {
          localObject2 = localObject3;
          j = z;
          for (;;)
          {
            k = j - 1;
            localObject3 = localObject2;
            if (k < 0) {
              break;
            }
            localObject3 = (View)((d.f.h)localObject6).c(k);
            j = k;
            if (localObject3 != null)
            {
              j = k;
              if (((h)localObject4).b((View)localObject3))
              {
                localObject3 = (p)((d.f.h)localObject7).remove(localObject3);
                j = k;
                if (localObject3 != null)
                {
                  localObject8 = b;
                  j = k;
                  if (localObject8 != null)
                  {
                    j = k;
                    if (((h)localObject4).b((View)localObject8))
                    {
                      localObject8 = (p)((d.f.h)localObject6).d(k);
                      Q.add(localObject8);
                      R.add(localObject3);
                      j = k;
                    }
                  }
                }
              }
            }
          }
        }
      }
      for (i = 0; i < z; i++)
      {
        localObject3 = (p)((d.f.h)localObject6).e(i);
        if (((h)localObject4).b(b))
        {
          Q.add(localObject3);
          R.add(null);
        }
      }
      for (i = 0; i < z; i++)
      {
        localObject3 = (p)((d.f.h)localObject7).e(i);
        if (((h)localObject4).b(b))
        {
          R.add(localObject3);
          Q.add(null);
        }
      }
      Object localObject11 = h.e();
      i = z;
      localObject5 = v.c((View)localObject1);
      i--;
      while (i >= 0)
      {
        localObject9 = (Animator)((d.f.h)localObject11).c(i);
        if (localObject9 != null)
        {
          localObject6 = (h.b)((d.f.h)localObject11).getOrDefault(localObject9, null);
          if ((localObject6 != null) && (a != null) && (localObject5.equals(d)))
          {
            localObject7 = c;
            localObject10 = a;
            localObject8 = ((h)localObject4).c((View)localObject10, true);
            localObject2 = ((h)localObject4).b((View)localObject10, true);
            localObject3 = localObject2;
            if (localObject8 == null)
            {
              localObject3 = localObject2;
              if (localObject2 == null) {
                localObject3 = (p)N.a.get(localObject10);
              }
            }
            if (((localObject8 != null) || (localObject3 != null)) && (e.a((p)localObject7, (p)localObject3))) {
              j = 1;
            } else {
              j = 0;
            }
            if (j != 0) {
              if ((!((Animator)localObject9).isRunning()) && (!((Animator)localObject9).isStarted())) {
                ((d.f.h)localObject11).remove(localObject9);
              } else {
                ((Animator)localObject9).cancel();
              }
            }
          }
        }
        i--;
      }
      ((h)localObject4).a((ViewGroup)localObject1, M, N, Q, R);
      ((h)localObject4).c();
      return true;
    }
    throw null;
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    y.getViewTreeObserver().removeOnPreDrawListener(this);
    y.removeOnAttachStateChangeListener(this);
    l.c.remove(y);
    paramView = (ArrayList)l.a().get(y);
    if ((paramView != null) && (paramView.size() > 0))
    {
      paramView = paramView.iterator();
      while (paramView.hasNext()) {
        ((h)paramView.next()).e(y);
      }
    }
    x.a(true);
  }
}

/* Location:
 * Qualified Name:     base.d.x.l.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */