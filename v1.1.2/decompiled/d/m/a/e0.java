package d.m.a;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import d.f.g;
import d.f.h;
import d.i.i.l;
import d.i.i.n;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class e0
{
  public static final int[] a = { 0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10 };
  public static final j0 b = new f0();
  public static final j0 c;
  
  static
  {
    j0 localj02;
    try
    {
      j0 localj01 = (j0)Class.forName("d.x.d").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    }
    catch (Exception localException)
    {
      localj02 = null;
    }
    c = localj02;
  }
  
  public static View a(d.f.a<String, View> parama, b paramb, Object paramObject, boolean paramBoolean)
  {
    paramb = c;
    if ((paramObject != null) && (parama != null))
    {
      paramObject = n;
      if ((paramObject != null) && (!((ArrayList)paramObject).isEmpty()))
      {
        if (paramBoolean) {
          paramb = (String)n.get(0);
        } else {
          paramb = (String)o.get(0);
        }
        return (View)parama.get(paramb);
      }
    }
    return null;
  }
  
  public static d.f.a<String, View> a(j0 paramj0, d.f.a<String, String> parama, Object paramObject, b paramb)
  {
    Fragment localFragment = a;
    View localView = localFragment.getView();
    if ((!parama.isEmpty()) && (paramObject != null) && (localView != null))
    {
      paramObject = new d.f.a();
      paramj0.a((Map)paramObject, localView);
      paramj0 = c;
      if (b)
      {
        localFragment.getExitTransitionCallback();
        paramj0 = n;
      }
      else
      {
        localFragment.getEnterTransitionCallback();
        paramj0 = o;
      }
      if (paramj0 != null)
      {
        g.a((Map)paramObject, paramj0);
        g.a((Map)paramObject, parama.values());
      }
      int i = z;
      for (;;)
      {
        int j = i - 1;
        if (j < 0) {
          break;
        }
        i = j;
        if (!((h)paramObject).containsKey((String)parama.e(j)))
        {
          parama.d(j);
          i = j;
        }
      }
      return (d.f.a<String, View>)paramObject;
    }
    parama.clear();
    return null;
  }
  
  public static j0 a(Fragment paramFragment1, Fragment paramFragment2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramFragment1 != null)
    {
      Object localObject = paramFragment1.getExitTransition();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      localObject = paramFragment1.getReturnTransition();
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      paramFragment1 = paramFragment1.getSharedElementReturnTransition();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
    }
    if (paramFragment2 != null)
    {
      paramFragment1 = paramFragment2.getEnterTransition();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
      paramFragment1 = paramFragment2.getReenterTransition();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
      paramFragment1 = paramFragment2.getSharedElementEnterTransition();
      if (paramFragment1 != null) {
        localArrayList.add(paramFragment1);
      }
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    paramFragment1 = b;
    if ((paramFragment1 != null) && (a(paramFragment1, localArrayList))) {
      return b;
    }
    paramFragment1 = c;
    if ((paramFragment1 != null) && (a(paramFragment1, localArrayList))) {
      return c;
    }
    if ((b == null) && (c == null)) {
      return null;
    }
    throw new IllegalArgumentException("Invalid Transition types");
  }
  
  public static Object a(j0 paramj0, Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean)
  {
    if ((paramFragment1 != null) && (paramFragment2 != null))
    {
      if (paramBoolean) {
        paramFragment1 = paramFragment2.getSharedElementReturnTransition();
      } else {
        paramFragment1 = paramFragment1.getSharedElementEnterTransition();
      }
      return paramj0.c(paramj0.b(paramFragment1));
    }
    return null;
  }
  
  public static Object a(j0 paramj0, Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {
      paramFragment = paramFragment.getReenterTransition();
    } else {
      paramFragment = paramFragment.getEnterTransition();
    }
    return paramj0.b(paramFragment);
  }
  
  public static Object a(j0 paramj0, Object paramObject1, Object paramObject2, Object paramObject3, Fragment paramFragment, boolean paramBoolean)
  {
    if ((paramObject1 != null) && (paramObject2 != null) && (paramFragment != null))
    {
      if (paramBoolean) {
        paramBoolean = paramFragment.getAllowReturnTransitionOverlap();
      } else {
        paramBoolean = paramFragment.getAllowEnterTransitionOverlap();
      }
    }
    else {
      paramBoolean = true;
    }
    if (paramBoolean) {
      paramj0 = paramj0.b(paramObject2, paramObject1, paramObject3);
    } else {
      paramj0 = paramj0.a(paramObject2, paramObject1, paramObject3);
    }
    return paramj0;
  }
  
  public static ArrayList<View> a(j0 paramj0, Object paramObject, Fragment paramFragment, ArrayList<View> paramArrayList, View paramView)
  {
    if (paramObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramFragment = paramFragment.getView();
      if (paramFragment != null) {
        paramj0.a(localArrayList, paramFragment);
      }
      if (paramArrayList != null) {
        localArrayList.removeAll(paramArrayList);
      }
      paramFragment = localArrayList;
      if (!localArrayList.isEmpty())
      {
        localArrayList.add(paramView);
        paramj0.a(paramObject, localArrayList);
        paramFragment = localArrayList;
      }
    }
    else
    {
      paramFragment = null;
    }
    return paramFragment;
  }
  
  public static void a(Fragment paramFragment1, Fragment paramFragment2, boolean paramBoolean1, d.f.a<String, View> parama, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      paramFragment2.getEnterTransitionCallback();
    } else {
      paramFragment1.getEnterTransitionCallback();
    }
  }
  
  public static void a(a parama, x.a parama1, SparseArray<b> paramSparseArray, boolean paramBoolean1, boolean paramBoolean2)
  {
    Fragment localFragment = b;
    if (localFragment == null) {
      return;
    }
    int i = mContainerId;
    if (i == 0) {
      return;
    }
    if (paramBoolean1) {
      j = a[a];
    } else {
      j = a;
    }
    boolean bool = false;
    if (j != 1)
    {
      if (j != 3) {
        if (j != 4)
        {
          if (j != 5)
          {
            if (j != 6)
            {
              if (j == 7) {
                break label272;
              }
              bool = false;
              j = 0;
              break label315;
            }
          }
          else
          {
            if (paramBoolean2)
            {
              if ((!mHiddenChanged) || (mHidden) || (!mAdded)) {
                break label309;
              }
              break label303;
            }
            bool = mHidden;
            break label312;
          }
        }
        else
        {
          if (paramBoolean2)
          {
            if ((!mHiddenChanged) || (!mAdded) || (!mHidden)) {
              break label256;
            }
            break label250;
          }
          if ((!mAdded) || (mHidden)) {
            break label256;
          }
          break label250;
        }
      }
      if (paramBoolean2)
      {
        if (mAdded) {
          break label256;
        }
        parama1 = mView;
        if ((parama1 == null) || (parama1.getVisibility() != 0) || (mPostponedAlpha < 0.0F)) {
          break label256;
        }
      }
      else
      {
        if ((!mAdded) || (mHidden)) {
          break label256;
        }
      }
      label250:
      j = 1;
      break label259;
      label256:
      j = 0;
      label259:
      k = j;
      m = 1;
      j = 0;
      break label321;
    }
    label272:
    if (paramBoolean2) {
      bool = mIsNewlyAdded;
    } else if ((!mAdded) && (!mHidden)) {
      label303:
      bool = true;
    } else {
      label309:
      bool = false;
    }
    label312:
    int j = 1;
    label315:
    int m = 0;
    int k = 0;
    label321:
    Object localObject = (b)paramSparseArray.get(i);
    parama1 = (x.a)localObject;
    if (bool)
    {
      parama1 = (x.a)localObject;
      if (localObject == null)
      {
        parama1 = new b();
        paramSparseArray.put(i, parama1);
      }
      a = localFragment;
      b = paramBoolean1;
      c = parama;
    }
    if ((!paramBoolean2) && (j != 0))
    {
      if ((parama1 != null) && (d == localFragment)) {
        d = null;
      }
      localObject = r;
      if ((mState < 1) && (m >= 1) && (!p))
      {
        ((p)localObject).l(localFragment);
        ((p)localObject).a(localFragment, 1);
      }
    }
    localObject = parama1;
    if (k != 0) {
      if (parama1 != null)
      {
        localObject = parama1;
        if (d != null) {}
      }
      else
      {
        localObject = parama1;
        if (parama1 == null)
        {
          localObject = new b();
          paramSparseArray.put(i, localObject);
        }
        d = localFragment;
        e = paramBoolean1;
        f = parama;
      }
    }
    if ((!paramBoolean2) && (m != 0) && (localObject != null) && (a == localFragment)) {
      a = null;
    }
  }
  
  public static void a(j0 paramj0, Object paramObject1, Object paramObject2, d.f.a<String, View> parama, boolean paramBoolean, a parama1)
  {
    ArrayList localArrayList = n;
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      if (paramBoolean) {
        parama1 = (String)o.get(0);
      } else {
        parama1 = (String)n.get(0);
      }
      parama = (View)parama.get(parama1);
      paramj0.c(paramObject1, parama);
      if (paramObject2 != null) {
        paramj0.c(paramObject2, parama);
      }
    }
  }
  
  public static void a(p paramp, ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1, int paramInt1, int paramInt2, boolean paramBoolean, a parama)
  {
    Object localObject1 = paramp;
    boolean bool1 = paramBoolean;
    if (m < 1) {
      return;
    }
    SparseArray localSparseArray = new SparseArray();
    Object localObject2;
    int j;
    int k;
    for (int i = paramInt1; i < paramInt2; i++)
    {
      localObject2 = (a)paramArrayList.get(i);
      if (((Boolean)paramArrayList1.get(i)).booleanValue())
      {
        if (r.o.a()) {
          for (j = a.size() - 1; j >= 0; j--) {
            a((a)localObject2, (x.a)a.get(j), localSparseArray, true, bool1);
          }
        }
      }
      else
      {
        k = a.size();
        for (j = 0; j < k; j++) {
          a((a)localObject2, (x.a)a.get(j), localSparseArray, false, bool1);
        }
      }
    }
    if (localSparseArray.size() != 0)
    {
      View localView = new View(n.y);
      i = localSparseArray.size();
      for (j = 0;; j++)
      {
        Object localObject3 = paramp;
        if (j >= i) {
          break;
        }
        int m = localSparseArray.keyAt(j);
        localObject2 = new d.f.a();
        Object localObject4;
        int n;
        Object localObject5;
        int i1;
        Object localObject6;
        Object localObject7;
        for (k = paramInt2 - 1; k >= paramInt1; k--)
        {
          localObject4 = (a)paramArrayList.get(k);
          if (((a)localObject4).b(m))
          {
            bool1 = ((Boolean)paramArrayList1.get(k)).booleanValue();
            localObject1 = n;
            if (localObject1 != null)
            {
              n = ((ArrayList)localObject1).size();
              if (bool1)
              {
                localObject1 = n;
                localObject5 = o;
              }
              else
              {
                localObject5 = n;
                localObject1 = o;
              }
              for (i1 = 0; i1 < n; i1++)
              {
                localObject6 = (String)((ArrayList)localObject5).get(i1);
                localObject4 = (String)((ArrayList)localObject1).get(i1);
                localObject7 = (String)((h)localObject2).remove(localObject4);
                if (localObject7 != null) {
                  ((h)localObject2).put(localObject6, localObject7);
                } else {
                  ((h)localObject2).put(localObject6, localObject4);
                }
              }
            }
          }
        }
        Object localObject8 = (b)localSparseArray.valueAt(j);
        Object localObject9;
        Object localObject10;
        boolean bool2;
        Object localObject11;
        Object localObject12;
        Object localObject13;
        Object localObject14;
        Fragment localFragment;
        if (paramBoolean)
        {
          if (o.a()) {
            localObject5 = (ViewGroup)o.a(m);
          } else {
            localObject5 = null;
          }
          if (localObject5 != null)
          {
            do
            {
              localObject7 = a;
              localObject9 = d;
              localObject10 = a((Fragment)localObject9, (Fragment)localObject7);
            } while (localObject10 == null);
            bool1 = b;
            bool2 = e;
            localObject6 = new ArrayList();
            localObject11 = new ArrayList();
            localObject12 = a((j0)localObject10, (Fragment)localObject7, bool1);
            localObject13 = b((j0)localObject10, (Fragment)localObject9, bool2);
            localObject14 = a;
            localFragment = d;
            if (localObject14 != null) {
              ((Fragment)localObject14).requireView().setVisibility(0);
            }
            if ((localObject14 != null) && (localFragment != null))
            {
              bool2 = b;
              if (((h)localObject2).isEmpty()) {
                localObject1 = null;
              } else {
                localObject1 = a((j0)localObject10, (Fragment)localObject14, localFragment, bool2);
              }
              localObject3 = b((j0)localObject10, (d.f.a)localObject2, localObject1, (b)localObject8);
              d.f.a locala = a((j0)localObject10, (d.f.a)localObject2, localObject1, (b)localObject8);
              if (((h)localObject2).isEmpty())
              {
                if (localObject3 != null) {
                  ((h)localObject3).clear();
                }
                if (locala != null) {
                  locala.clear();
                }
                localObject1 = null;
              }
              else
              {
                a((ArrayList)localObject11, (d.f.a)localObject3, ((d.f.a)localObject2).keySet());
                a((ArrayList)localObject6, locala, ((d.f.a)localObject2).values());
              }
              if ((localObject12 != null) || (localObject13 != null) || (localObject1 != null))
              {
                a((Fragment)localObject14, localFragment, bool2, (d.f.a)localObject3, true);
                if (localObject1 != null)
                {
                  ((ArrayList)localObject6).add(localView);
                  ((j0)localObject10).b(localObject1, localView, (ArrayList)localObject11);
                  a((j0)localObject10, localObject1, localObject13, (d.f.a)localObject3, e, f);
                  localObject4 = new Rect();
                  localObject3 = a(locala, (b)localObject8, localObject12, bool2);
                  if (localObject3 != null) {
                    ((j0)localObject10).a(localObject12, (Rect)localObject4);
                  }
                }
                else
                {
                  localObject3 = null;
                  localObject4 = null;
                }
                l.a((View)localObject5, new c0((Fragment)localObject14, localFragment, bool2, locala, (View)localObject3, (j0)localObject10, (Rect)localObject4));
                break label888;
              }
            }
            localObject1 = null;
            label888:
            if ((localObject12 != null) || (localObject1 != null) || (localObject13 != null))
            {
              localObject8 = a((j0)localObject10, localObject13, (Fragment)localObject9, (ArrayList)localObject11, localView);
              localObject3 = a((j0)localObject10, localObject12, (Fragment)localObject7, (ArrayList)localObject6, localView);
              a((ArrayList)localObject3, 4);
              localObject7 = a((j0)localObject10, localObject12, localObject13, localObject1, (Fragment)localObject7, bool1);
              if ((localObject9 != null) && (localObject8 != null) && ((((ArrayList)localObject8).size() > 0) || (((ArrayList)localObject11).size() > 0)))
              {
                localObject4 = new d.i.e.a();
                localObject14 = (p.b)parama;
                ((p.b)localObject14).b((Fragment)localObject9, (d.i.e.a)localObject4);
                ((j0)localObject10).a((Fragment)localObject9, localObject7, (d.i.e.a)localObject4, new y((a)localObject14, (Fragment)localObject9, (d.i.e.a)localObject4));
              }
              if (localObject7 != null)
              {
                if ((localObject9 != null) && (localObject13 != null) && (mAdded) && (mHidden) && (mHiddenChanged))
                {
                  ((Fragment)localObject9).setHideReplaced(true);
                  ((j0)localObject10).a(localObject13, ((Fragment)localObject9).getView(), (ArrayList)localObject8);
                  l.a(mContainer, new z((ArrayList)localObject8));
                }
                localObject4 = new ArrayList();
                n = ((ArrayList)localObject6).size();
                for (k = 0; k < n; k++)
                {
                  localObject9 = (View)((ArrayList)localObject6).get(k);
                  ((ArrayList)localObject4).add(n.n((View)localObject9));
                  ((View)localObject9).setTransitionName(null);
                }
                ((j0)localObject10).a(localObject7, localObject12, (ArrayList)localObject3, localObject13, (ArrayList)localObject8, localObject1, (ArrayList)localObject6);
                ((j0)localObject10).a((ViewGroup)localObject5, localObject7);
                i1 = ((ArrayList)localObject6).size();
                localObject7 = new ArrayList();
                for (k = 0; k < i1; k++)
                {
                  localObject12 = (View)((ArrayList)localObject11).get(k);
                  localObject13 = n.n((View)localObject12);
                  ((ArrayList)localObject7).add(localObject13);
                  if (localObject13 != null)
                  {
                    ((View)localObject12).setTransitionName(null);
                    localObject12 = (String)((h)localObject2).get(localObject13);
                    for (n = 0; n < i1; n++) {
                      if (((String)localObject12).equals(((ArrayList)localObject4).get(n)))
                      {
                        ((View)((ArrayList)localObject6).get(n)).setTransitionName((String)localObject13);
                        break;
                      }
                    }
                  }
                }
                l.a((View)localObject5, new g0((j0)localObject10, i1, (ArrayList)localObject6, (ArrayList)localObject4, (ArrayList)localObject11, (ArrayList)localObject7));
                a((ArrayList)localObject3, 0);
                ((j0)localObject10).b(localObject1, (ArrayList)localObject11, (ArrayList)localObject6);
              }
            }
          }
        }
        for (;;)
        {
          break;
          k = j;
          k = i;
          if (o.a()) {
            localObject5 = (ViewGroup)o.a(m);
          } else {
            localObject5 = null;
          }
          if (localObject5 != null)
          {
            localObject10 = a;
            localObject11 = d;
            localObject9 = a((Fragment)localObject11, (Fragment)localObject10);
            if (localObject9 != null)
            {
              bool1 = b;
              bool2 = e;
              localObject14 = a((j0)localObject9, (Fragment)localObject10, bool1);
              localObject6 = b((j0)localObject9, (Fragment)localObject11, bool2);
              localObject13 = new ArrayList();
              localObject3 = new ArrayList();
              localFragment = a;
              localObject12 = d;
              if ((localFragment != null) && (localObject12 != null))
              {
                bool1 = b;
                if (((h)localObject2).isEmpty()) {
                  localObject1 = null;
                } else {
                  localObject1 = a((j0)localObject9, localFragment, (Fragment)localObject12, bool1);
                }
                localObject4 = b((j0)localObject9, (d.f.a)localObject2, localObject1, (b)localObject8);
                if (((h)localObject2).isEmpty()) {
                  localObject1 = null;
                } else {
                  ((ArrayList)localObject13).addAll(((d.f.a)localObject4).values());
                }
                if ((localObject14 != null) || (localObject6 != null) || (localObject1 != null))
                {
                  a(localFragment, (Fragment)localObject12, bool1, (d.f.a)localObject4, true);
                  if (localObject1 != null)
                  {
                    localObject7 = new Rect();
                    ((j0)localObject9).b(localObject1, localView, (ArrayList)localObject13);
                    a((j0)localObject9, localObject1, localObject6, (d.f.a)localObject4, e, f);
                    localObject4 = localObject7;
                    if (localObject14 != null)
                    {
                      ((j0)localObject9).a(localObject14, (Rect)localObject7);
                      localObject4 = localObject7;
                    }
                  }
                  else
                  {
                    localObject4 = null;
                  }
                  localObject7 = localObject3;
                  l.a((View)localObject5, new d0((j0)localObject9, (d.f.a)localObject2, localObject1, (b)localObject8, (ArrayList)localObject3, localView, localFragment, (Fragment)localObject12, bool1, (ArrayList)localObject13, localObject14, (Rect)localObject4));
                  localObject3 = localObject1;
                  localObject1 = localObject7;
                  break label1775;
                }
              }
              localObject1 = localObject3;
              localObject3 = null;
              label1775:
              k = i;
              localObject12 = null;
              n = j;
              localObject4 = localObject6;
              localObject7 = localObject2;
              if ((localObject14 == null) && (localObject3 == null) && (localObject4 == null))
              {
                j = n;
                i = k;
              }
              else
              {
                localObject6 = a((j0)localObject9, localObject4, (Fragment)localObject11, (ArrayList)localObject13, localView);
                localObject2 = localObject12;
                if (localObject6 != null) {
                  if (((ArrayList)localObject6).isEmpty()) {
                    localObject2 = localObject12;
                  } else {
                    localObject2 = localObject4;
                  }
                }
                ((j0)localObject9).a(localObject14, localView);
                localObject4 = a((j0)localObject9, localObject14, localObject2, localObject3, (Fragment)localObject10, b);
                if ((localObject11 != null) && (localObject6 != null) && ((((ArrayList)localObject6).size() > 0) || (((ArrayList)localObject13).size() > 0)))
                {
                  localObject13 = new d.i.e.a();
                  localObject12 = (p.b)parama;
                  ((p.b)localObject12).b((Fragment)localObject11, (d.i.e.a)localObject13);
                  ((j0)localObject9).a((Fragment)localObject11, localObject4, (d.i.e.a)localObject13, new a0((a)localObject12, (Fragment)localObject11, (d.i.e.a)localObject13));
                }
                j = n;
                i = k;
                if (localObject4 != null)
                {
                  localObject11 = new ArrayList();
                  ((j0)localObject9).a(localObject4, localObject14, (ArrayList)localObject11, localObject2, (ArrayList)localObject6, localObject3, (ArrayList)localObject1);
                  l.a((View)localObject5, new b0(localObject14, (j0)localObject9, localView, (Fragment)localObject10, (ArrayList)localObject1, (ArrayList)localObject11, (ArrayList)localObject6, localObject2));
                  l.a((View)localObject5, new h0((j0)localObject9, (ArrayList)localObject1, (Map)localObject7));
                  ((j0)localObject9).a((ViewGroup)localObject5, localObject4);
                  l.a((View)localObject5, new i0((j0)localObject9, (ArrayList)localObject1, (Map)localObject7));
                  i = k;
                  j = n;
                }
              }
            }
          }
        }
      }
    }
  }
  
  public static void a(ArrayList<View> paramArrayList, int paramInt)
  {
    if (paramArrayList == null) {
      return;
    }
    for (int i = paramArrayList.size() - 1; i >= 0; i--) {
      ((View)paramArrayList.get(i)).setVisibility(paramInt);
    }
  }
  
  public static void a(ArrayList<View> paramArrayList, d.f.a<String, View> parama, Collection<String> paramCollection)
  {
    for (int i = z - 1; i >= 0; i--)
    {
      View localView = (View)parama.e(i);
      if (paramCollection.contains(n.n(localView))) {
        paramArrayList.add(localView);
      }
    }
  }
  
  public static boolean a(j0 paramj0, List<Object> paramList)
  {
    int i = paramList.size();
    for (int j = 0; j < i; j++) {
      if (!paramj0.a(paramList.get(j))) {
        return false;
      }
    }
    return true;
  }
  
  public static d.f.a<String, View> b(j0 paramj0, d.f.a<String, String> parama, Object paramObject, b paramb)
  {
    if ((!parama.isEmpty()) && (paramObject != null))
    {
      Fragment localFragment = d;
      paramObject = new d.f.a();
      paramj0.a((Map)paramObject, localFragment.requireView());
      paramj0 = f;
      if (e)
      {
        localFragment.getEnterTransitionCallback();
        paramj0 = o;
      }
      else
      {
        localFragment.getExitTransitionCallback();
        paramj0 = n;
      }
      if (paramj0 != null) {
        g.a((Map)paramObject, paramj0);
      }
      g.a(parama, ((d.f.a)paramObject).keySet());
      return (d.f.a<String, View>)paramObject;
    }
    parama.clear();
    return null;
  }
  
  public static Object b(j0 paramj0, Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment == null) {
      return null;
    }
    if (paramBoolean) {
      paramFragment = paramFragment.getReturnTransition();
    } else {
      paramFragment = paramFragment.getExitTransition();
    }
    return paramj0.b(paramFragment);
  }
  
  public static abstract interface a {}
  
  public static class b
  {
    public Fragment a;
    public boolean b;
    public a c;
    public Fragment d;
    public boolean e;
    public a f;
  }
}

/* Location:
 * Qualified Name:     d.m.a.e0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */