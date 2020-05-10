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
    final Object localObject1 = l.a();
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
    x.a(new a((a)localObject1));
    x.a(y, false);
    if (localObject2 != null)
    {
      localObject3 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((h)((Iterator)localObject3).next()).e(y);
      }
    }
    localObject1 = x;
    Object localObject4 = y;
    if (localObject1 != null)
    {
      Q = new ArrayList();
      R = new ArrayList();
      localObject3 = M;
      Object localObject5 = N;
      Object localObject6 = new a(a);
      Object localObject7 = new a(a);
      int j;
      Object localObject9;
      Object localObject10;
      Object localObject11;
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
                  if ((localObject10 != null) && (((h)localObject1).b((View)localObject10)))
                  {
                    if (x) {
                      ((e)localObject8).b();
                    }
                    localView = (View)((e)localObject9).a(y[j]);
                    if ((localView != null) && (((h)localObject1).b(localView)))
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
              localObject9 = b;
              localObject8 = b;
              k = ((SparseArray)localObject9).size();
              for (j = 0;; j++)
              {
                localObject3 = localObject2;
                if (j >= k) {
                  break;
                }
                localView = (View)((SparseArray)localObject9).valueAt(j);
                if ((localView != null) && (((h)localObject1).b(localView)))
                {
                  localObject10 = (View)((SparseArray)localObject8).get(((SparseArray)localObject9).keyAt(j));
                  if ((localObject10 != null) && (((h)localObject1).b((View)localObject10)))
                  {
                    localObject11 = (p)((d.f.h)localObject6).getOrDefault(localView, null);
                    localObject3 = (p)((d.f.h)localObject7).getOrDefault(localObject10, null);
                    if ((localObject11 != null) && (localObject3 != null))
                    {
                      Q.add(localObject11);
                      R.add(localObject3);
                      ((d.f.h)localObject6).remove(localView);
                      ((d.f.h)localObject7).remove(localObject10);
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
              localView = (View)((d.f.h)localObject8).e(j);
              if ((localView != null) && (((h)localObject1).b(localView)))
              {
                localObject11 = (View)((d.f.h)localObject9).get(((d.f.h)localObject8).c(j));
                if ((localObject11 != null) && (((h)localObject1).b((View)localObject11)))
                {
                  localObject10 = (p)((d.f.h)localObject6).getOrDefault(localView, null);
                  localObject3 = (p)((d.f.h)localObject7).getOrDefault(localObject11, null);
                  if ((localObject10 != null) && (localObject3 != null))
                  {
                    Q.add(localObject10);
                    R.add(localObject3);
                    ((d.f.h)localObject6).remove(localView);
                    ((d.f.h)localObject7).remove(localObject11);
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
              if (((h)localObject1).b((View)localObject3))
              {
                localObject3 = (p)((d.f.h)localObject7).remove(localObject3);
                j = k;
                if (localObject3 != null)
                {
                  localObject9 = b;
                  j = k;
                  if (localObject9 != null)
                  {
                    j = k;
                    if (((h)localObject1).b((View)localObject9))
                    {
                      localObject9 = (p)((d.f.h)localObject6).d(k);
                      Q.add(localObject9);
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
        if (((h)localObject1).b(b))
        {
          Q.add(localObject3);
          R.add(null);
        }
      }
      for (i = 0; i < z; i++)
      {
        localObject3 = (p)((d.f.h)localObject7).e(i);
        if (((h)localObject1).b(b))
        {
          R.add(localObject3);
          Q.add(null);
        }
      }
      Object localObject8 = h.e();
      i = z;
      localObject6 = v.c((View)localObject4);
      i--;
      while (i >= 0)
      {
        localObject11 = (Animator)((d.f.h)localObject8).c(i);
        if (localObject11 != null)
        {
          localObject9 = (h.b)((d.f.h)localObject8).getOrDefault(localObject11, null);
          if ((localObject9 != null) && (a != null) && (localObject6.equals(d)))
          {
            localObject5 = c;
            localObject10 = a;
            localObject7 = ((h)localObject1).c((View)localObject10, true);
            localObject2 = ((h)localObject1).b((View)localObject10, true);
            localObject3 = localObject2;
            if (localObject7 == null)
            {
              localObject3 = localObject2;
              if (localObject2 == null) {
                localObject3 = (p)N.a.get(localObject10);
              }
            }
            if (((localObject7 != null) || (localObject3 != null)) && (e.a((p)localObject5, (p)localObject3))) {
              j = 1;
            } else {
              j = 0;
            }
            if (j != 0) {
              if ((!((Animator)localObject11).isRunning()) && (!((Animator)localObject11).isStarted())) {
                ((d.f.h)localObject8).remove(localObject11);
              } else {
                ((Animator)localObject11).cancel();
              }
            }
          }
        }
        i--;
      }
      ((h)localObject1).a((ViewGroup)localObject4, M, N, Q, R);
      ((h)localObject1).c();
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
  
  public class a
    extends k
  {
    public a(a parama) {}
    
    public void d(h paramh)
    {
      ((ArrayList)localObject1.get(y)).remove(paramh);
    }
  }
}

/* Location:
 * Qualified Name:     d.x.l.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */