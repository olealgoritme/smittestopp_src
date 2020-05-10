package d.x;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import d.f.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class h
  implements Cloneable
{
  public static final int[] c0 = { 2, 1, 3, 4 };
  public static final e d0 = new a();
  public static ThreadLocal<d.f.a<Animator, b>> e0 = new ThreadLocal();
  public TimeInterpolator A = null;
  public ArrayList<Integer> B = new ArrayList();
  public ArrayList<View> C = new ArrayList();
  public ArrayList<String> D = null;
  public ArrayList<Class> E = null;
  public ArrayList<Integer> F = null;
  public ArrayList<View> G = null;
  public ArrayList<Class> H = null;
  public ArrayList<String> I = null;
  public ArrayList<Integer> J = null;
  public ArrayList<View> K = null;
  public ArrayList<Class> L = null;
  public q M = new q();
  public q N = new q();
  public n O = null;
  public int[] P = c0;
  public ArrayList<p> Q;
  public ArrayList<p> R;
  public boolean S = false;
  public ArrayList<Animator> T = new ArrayList();
  public int U = 0;
  public boolean V = false;
  public boolean W = false;
  public ArrayList<d> X = null;
  public ArrayList<Animator> Y = new ArrayList();
  public m Z;
  public c a0;
  public e b0 = d0;
  public String x = getClass().getName();
  public long y = -1L;
  public long z = -1L;
  
  public static void a(q paramq, View paramView, p paramp)
  {
    a.put(paramView, paramp);
    int i = paramView.getId();
    if (i >= 0) {
      if (b.indexOfKey(i) >= 0) {
        b.put(i, null);
      } else {
        b.put(i, paramView);
      }
    }
    paramp = d.i.i.n.n(paramView);
    if (paramp != null)
    {
      if (d.a(paramp) >= 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        d.put(paramp, null);
      } else {
        d.put(paramp, paramView);
      }
    }
    if ((paramView.getParent() instanceof ListView))
    {
      paramp = (ListView)paramView.getParent();
      if (paramp.getAdapter().hasStableIds())
      {
        long l = paramp.getItemIdAtPosition(paramp.getPositionForView(paramView));
        paramp = c;
        if (x) {
          paramp.b();
        }
        if (d.a(y, A, l) >= 0)
        {
          paramView = (View)c.a(l);
          if (paramView != null)
          {
            paramView.setHasTransientState(false);
            c.c(l, null);
          }
        }
        else
        {
          paramView.setHasTransientState(true);
          c.c(l, paramView);
        }
      }
    }
  }
  
  public static boolean a(p paramp1, p paramp2, String paramString)
  {
    paramp1 = a.get(paramString);
    paramp2 = a.get(paramString);
    boolean bool1 = true;
    boolean bool2;
    if ((paramp1 == null) && (paramp2 == null))
    {
      bool2 = false;
    }
    else
    {
      bool2 = bool1;
      if (paramp1 != null) {
        if (paramp2 == null) {
          bool2 = bool1;
        } else {
          bool2 = true ^ paramp1.equals(paramp2);
        }
      }
    }
    return bool2;
  }
  
  public static d.f.a<Animator, b> e()
  {
    d.f.a locala1 = (d.f.a)e0.get();
    d.f.a locala2 = locala1;
    if (locala1 == null)
    {
      locala2 = new d.f.a();
      e0.set(locala2);
    }
    return locala2;
  }
  
  public Animator a(ViewGroup paramViewGroup, p paramp1, p paramp2)
  {
    return null;
  }
  
  public h a(long paramLong)
  {
    z = paramLong;
    return this;
  }
  
  public h a(TimeInterpolator paramTimeInterpolator)
  {
    A = paramTimeInterpolator;
    return this;
  }
  
  public h a(View paramView)
  {
    C.add(paramView);
    return this;
  }
  
  public h a(d paramd)
  {
    if (X == null) {
      X = new ArrayList();
    }
    X.add(paramd);
    return this;
  }
  
  public String a(String paramString)
  {
    paramString = e.a.a.a.a.a(paramString);
    paramString.append(getClass().getSimpleName());
    paramString.append("@");
    paramString.append(Integer.toHexString(hashCode()));
    paramString.append(": ");
    String str = paramString.toString();
    paramString = str;
    if (z != -1L)
    {
      paramString = e.a.a.a.a.a(str, "dur(");
      paramString.append(z);
      paramString.append(") ");
      paramString = paramString.toString();
    }
    str = paramString;
    if (y != -1L)
    {
      paramString = e.a.a.a.a.a(paramString, "dly(");
      paramString.append(y);
      paramString.append(") ");
      str = paramString.toString();
    }
    paramString = str;
    if (A != null)
    {
      paramString = e.a.a.a.a.a(str, "interp(");
      paramString.append(A);
      paramString.append(") ");
      paramString = paramString.toString();
    }
    if (B.size() <= 0)
    {
      str = paramString;
      if (C.size() <= 0) {}
    }
    else
    {
      str = e.a.a.a.a.b(paramString, "tgts(");
      int i = B.size();
      int j = 0;
      paramString = str;
      if (i > 0) {
        for (i = 0;; i++)
        {
          paramString = str;
          if (i >= B.size()) {
            break;
          }
          paramString = str;
          if (i > 0) {
            paramString = e.a.a.a.a.b(str, ", ");
          }
          paramString = e.a.a.a.a.a(paramString);
          paramString.append(B.get(i));
          str = paramString.toString();
        }
      }
      str = paramString;
      if (C.size() > 0) {
        for (i = j;; i++)
        {
          str = paramString;
          if (i >= C.size()) {
            break;
          }
          str = paramString;
          if (i > 0) {
            str = e.a.a.a.a.b(paramString, ", ");
          }
          paramString = e.a.a.a.a.a(str);
          paramString.append(C.get(i));
          paramString = paramString.toString();
        }
      }
      str = e.a.a.a.a.b(str, ")");
    }
    return str;
  }
  
  public void a()
  {
    int i = U - 1;
    U = i;
    if (i == 0)
    {
      Object localObject = X;
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = (ArrayList)X.clone();
        int j = ((ArrayList)localObject).size();
        for (i = 0; i < j; i++) {
          ((d)((ArrayList)localObject).get(i)).d(this);
        }
      }
      for (i = 0; i < M.c.c(); i++)
      {
        localObject = (View)M.c.a(i);
        if (localObject != null) {
          d.i.i.n.a((View)localObject, false);
        }
      }
      for (i = 0; i < N.c.c(); i++)
      {
        localObject = (View)N.c.a(i);
        if (localObject != null) {
          d.i.i.n.a((View)localObject, false);
        }
      }
      W = true;
    }
  }
  
  public final void a(View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    int i = paramView.getId();
    Object localObject = F;
    if ((localObject != null) && (((ArrayList)localObject).contains(Integer.valueOf(i)))) {
      return;
    }
    localObject = G;
    if ((localObject != null) && (((ArrayList)localObject).contains(paramView))) {
      return;
    }
    localObject = H;
    int j = 0;
    int k;
    int m;
    if (localObject != null)
    {
      k = ((ArrayList)localObject).size();
      for (m = 0; m < k; m++) {
        if (((Class)H.get(m)).isInstance(paramView)) {
          return;
        }
      }
    }
    if ((paramView.getParent() instanceof ViewGroup))
    {
      localObject = new p();
      b = paramView;
      if (paramBoolean) {
        c((p)localObject);
      } else {
        a((p)localObject);
      }
      c.add(this);
      b((p)localObject);
      if (paramBoolean) {
        a(M, paramView, (p)localObject);
      } else {
        a(N, paramView, (p)localObject);
      }
    }
    if ((paramView instanceof ViewGroup))
    {
      localObject = J;
      if ((localObject != null) && (((ArrayList)localObject).contains(Integer.valueOf(i)))) {
        return;
      }
      localObject = K;
      if ((localObject != null) && (((ArrayList)localObject).contains(paramView))) {
        return;
      }
      localObject = L;
      if (localObject != null)
      {
        k = ((ArrayList)localObject).size();
        for (m = 0; m < k; m++) {
          if (((Class)L.get(m)).isInstance(paramView)) {
            return;
          }
        }
      }
      paramView = (ViewGroup)paramView;
      for (m = j; m < paramView.getChildCount(); m++) {
        a(paramView.getChildAt(m), paramBoolean);
      }
    }
  }
  
  public void a(ViewGroup paramViewGroup, q paramq1, q paramq2, ArrayList<p> paramArrayList1, ArrayList<p> paramArrayList2)
  {
    d.f.a locala = e();
    SparseIntArray localSparseIntArray = new SparseIntArray();
    int i = paramArrayList1.size();
    int k;
    for (int j = 0; j < i; j++)
    {
      Object localObject1 = (p)paramArrayList1.get(j);
      paramq1 = (p)paramArrayList2.get(j);
      Object localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (!c.contains(this)) {
          localObject2 = null;
        }
      }
      localObject1 = paramq1;
      if (paramq1 != null)
      {
        localObject1 = paramq1;
        if (!c.contains(this)) {
          localObject1 = null;
        }
      }
      if ((localObject2 != null) || (localObject1 != null))
      {
        do
        {
          do
          {
            if ((localObject2 != null) && (localObject1 != null) && (!a((p)localObject2, (p)localObject1))) {
              k = 0;
            } else {
              k = 1;
            }
          } while (k == 0);
          paramq1 = a(paramViewGroup, (p)localObject2, (p)localObject1);
        } while (paramq1 == null);
        if (localObject1 != null)
        {
          View localView = b;
          String[] arrayOfString = b();
          if ((localView != null) && (arrayOfString != null) && (arrayOfString.length > 0))
          {
            p localp = new p();
            b = localView;
            localObject1 = (p)a.getOrDefault(localView, null);
            localObject2 = paramq1;
            k = i;
            if (localObject1 != null) {
              for (m = 0;; m++)
              {
                localObject2 = paramq1;
                k = i;
                if (m >= arrayOfString.length) {
                  break;
                }
                a.put(arrayOfString[m], a.get(arrayOfString[m]));
              }
            }
            int m = z;
            for (i = 0; i < m; i++)
            {
              paramq1 = (b)locala.get((Animator)locala.c(i));
              if ((c != null) && (a == localView) && (b.equals(x)) && (c.equals(localp)))
              {
                paramq1 = null;
                localObject2 = localp;
                break label413;
              }
            }
            paramq1 = (q)localObject2;
            localObject2 = localp;
          }
          else
          {
            localObject2 = null;
            k = i;
          }
          label413:
          localObject1 = localView;
        }
        else
        {
          localObject1 = b;
          localObject2 = null;
          k = i;
        }
        i = k;
        if (paramq1 != null)
        {
          locala.put(paramq1, new b((View)localObject1, x, this, v.c(paramViewGroup), (p)localObject2));
          Y.add(paramq1);
          i = k;
        }
      }
    }
    if (localSparseIntArray.size() != 0) {
      for (i = 0; i < localSparseIntArray.size(); i++)
      {
        k = localSparseIntArray.keyAt(i);
        paramViewGroup = (Animator)Y.get(k);
        long l = localSparseIntArray.valueAt(i);
        paramViewGroup.setStartDelay(paramViewGroup.getStartDelay() + (l - Long.MAX_VALUE));
      }
    }
  }
  
  public void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    a(paramBoolean);
    Object localObject;
    if ((B.size() > 0) || (C.size() > 0))
    {
      localObject = D;
      if ((localObject == null) || (((ArrayList)localObject).isEmpty()))
      {
        localObject = E;
        if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
          break label69;
        }
      }
    }
    a(paramViewGroup, paramBoolean);
    return;
    label69:
    int i = 0;
    int k;
    for (int j = 0;; j++)
    {
      k = i;
      if (j >= B.size()) {
        break;
      }
      View localView = paramViewGroup.findViewById(((Integer)B.get(j)).intValue());
      if (localView != null)
      {
        localObject = new p();
        b = localView;
        if (paramBoolean) {
          c((p)localObject);
        } else {
          a((p)localObject);
        }
        c.add(this);
        b((p)localObject);
        if (paramBoolean) {
          a(M, localView, (p)localObject);
        } else {
          a(N, localView, (p)localObject);
        }
      }
    }
    while (k < C.size())
    {
      localObject = (View)C.get(k);
      paramViewGroup = new p();
      b = ((View)localObject);
      if (paramBoolean) {
        c(paramViewGroup);
      } else {
        a(paramViewGroup);
      }
      c.add(this);
      b(paramViewGroup);
      if (paramBoolean) {
        a(M, (View)localObject, paramViewGroup);
      } else {
        a(N, (View)localObject, paramViewGroup);
      }
      k++;
    }
  }
  
  public void a(e parame)
  {
    if (parame == null) {
      b0 = d0;
    } else {
      b0 = parame;
    }
  }
  
  public void a(c paramc)
  {
    a0 = paramc;
  }
  
  public void a(m paramm)
  {
    Z = paramm;
  }
  
  public abstract void a(p paramp);
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      M.a.clear();
      M.b.clear();
      M.c.a();
    }
    else
    {
      N.a.clear();
      N.b.clear();
      N.c.a();
    }
  }
  
  public boolean a(p paramp1, p paramp2)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramp1 != null)
    {
      bool2 = bool1;
      if (paramp2 != null)
      {
        Object localObject = b();
        if (localObject != null)
        {
          int i = localObject.length;
          for (int j = 0;; j++)
          {
            bool2 = bool1;
            if (j >= i) {
              break label117;
            }
            if (a(paramp1, paramp2, localObject[j])) {
              break;
            }
          }
        }
        localObject = a.keySet().iterator();
        do
        {
          bool2 = bool1;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
        } while (!a(paramp1, paramp2, (String)((Iterator)localObject).next()));
        bool2 = true;
      }
    }
    label117:
    return bool2;
  }
  
  public h b(long paramLong)
  {
    y = paramLong;
    return this;
  }
  
  public h b(d paramd)
  {
    ArrayList localArrayList = X;
    if (localArrayList == null) {
      return this;
    }
    localArrayList.remove(paramd);
    if (X.size() == 0) {
      X = null;
    }
    return this;
  }
  
  public p b(View paramView, boolean paramBoolean)
  {
    Object localObject1 = O;
    if (localObject1 != null) {
      return ((h)localObject1).b(paramView, paramBoolean);
    }
    if (paramBoolean) {
      localObject1 = Q;
    } else {
      localObject1 = R;
    }
    Object localObject2 = null;
    if (localObject1 == null) {
      return null;
    }
    int i = ((ArrayList)localObject1).size();
    int j = -1;
    int m;
    for (int k = 0;; k++)
    {
      m = j;
      if (k >= i) {
        break;
      }
      p localp = (p)((ArrayList)localObject1).get(k);
      if (localp == null) {
        return null;
      }
      if (b == paramView)
      {
        m = k;
        break;
      }
    }
    paramView = (View)localObject2;
    if (m >= 0)
    {
      if (paramBoolean) {
        paramView = R;
      } else {
        paramView = Q;
      }
      paramView = (p)paramView.get(m);
    }
    return paramView;
  }
  
  public void b(p paramp) {}
  
  public boolean b(View paramView)
  {
    int i = paramView.getId();
    ArrayList localArrayList = F;
    if ((localArrayList != null) && (localArrayList.contains(Integer.valueOf(i)))) {
      return false;
    }
    localArrayList = G;
    if ((localArrayList != null) && (localArrayList.contains(paramView))) {
      return false;
    }
    localArrayList = H;
    int k;
    if (localArrayList != null)
    {
      int j = localArrayList.size();
      for (k = 0; k < j; k++) {
        if (((Class)H.get(k)).isInstance(paramView)) {
          return false;
        }
      }
    }
    if ((I != null) && (d.i.i.n.n(paramView) != null) && (I.contains(paramView.getTransitionName()))) {
      return false;
    }
    if ((B.size() == 0) && (C.size() == 0))
    {
      localArrayList = E;
      if ((localArrayList == null) || (localArrayList.isEmpty()))
      {
        localArrayList = D;
        if ((localArrayList == null) || (localArrayList.isEmpty())) {
          return true;
        }
      }
    }
    if ((!B.contains(Integer.valueOf(i))) && (!C.contains(paramView)))
    {
      localArrayList = D;
      if ((localArrayList != null) && (localArrayList.contains(d.i.i.n.n(paramView)))) {
        return true;
      }
      if (E != null) {
        for (k = 0; k < E.size(); k++) {
          if (((Class)E.get(k)).isInstance(paramView)) {
            return true;
          }
        }
      }
      return false;
    }
    return true;
  }
  
  public String[] b()
  {
    return null;
  }
  
  public p c(View paramView, boolean paramBoolean)
  {
    Object localObject = O;
    if (localObject != null) {
      return ((h)localObject).c(paramView, paramBoolean);
    }
    if (paramBoolean) {
      localObject = M;
    } else {
      localObject = N;
    }
    return (p)a.getOrDefault(paramView, null);
  }
  
  public void c()
  {
    d();
    d.f.a locala = e();
    Iterator localIterator = Y.iterator();
    while (localIterator.hasNext())
    {
      Animator localAnimator = (Animator)localIterator.next();
      if (locala.containsKey(localAnimator))
      {
        d();
        if (localAnimator != null)
        {
          localAnimator.addListener(new i(this, locala));
          long l = z;
          if (l >= 0L) {
            localAnimator.setDuration(l);
          }
          l = y;
          if (l >= 0L) {
            localAnimator.setStartDelay(l);
          }
          TimeInterpolator localTimeInterpolator = A;
          if (localTimeInterpolator != null) {
            localAnimator.setInterpolator(localTimeInterpolator);
          }
          localAnimator.addListener(new j(this));
          localAnimator.start();
        }
      }
    }
    Y.clear();
    a();
  }
  
  public void c(View paramView)
  {
    if (!W)
    {
      d.f.a locala = e();
      int i = z;
      paramView = v.c(paramView);
      i--;
      while (i >= 0)
      {
        b localb = (b)locala.e(i);
        if ((a != null) && (paramView.equals(d))) {
          ((Animator)locala.c(i)).pause();
        }
        i--;
      }
      paramView = X;
      if ((paramView != null) && (paramView.size() > 0))
      {
        paramView = (ArrayList)X.clone();
        int j = paramView.size();
        for (i = 0; i < j; i++) {
          ((d)paramView.get(i)).b(this);
        }
      }
      V = true;
    }
  }
  
  public abstract void c(p paramp);
  
  public h clone()
  {
    try
    {
      h localh = (h)super.clone();
      Object localObject = new java/util/ArrayList;
      ((ArrayList)localObject).<init>();
      Y = ((ArrayList)localObject);
      localObject = new d/x/q;
      ((q)localObject).<init>();
      M = ((q)localObject);
      localObject = new d/x/q;
      ((q)localObject).<init>();
      N = ((q)localObject);
      Q = null;
      R = null;
      return localh;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public h d(View paramView)
  {
    C.remove(paramView);
    return this;
  }
  
  public void d()
  {
    if (U == 0)
    {
      ArrayList localArrayList = X;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        localArrayList = (ArrayList)X.clone();
        int i = localArrayList.size();
        for (int j = 0; j < i; j++) {
          ((d)localArrayList.get(j)).a(this);
        }
      }
      W = false;
    }
    U += 1;
  }
  
  public void e(View paramView)
  {
    if (V)
    {
      if (!W)
      {
        d.f.a locala = e();
        int i = z;
        paramView = v.c(paramView);
        i--;
        while (i >= 0)
        {
          b localb = (b)locala.e(i);
          if ((a != null) && (paramView.equals(d))) {
            ((Animator)locala.c(i)).resume();
          }
          i--;
        }
        paramView = X;
        if ((paramView != null) && (paramView.size() > 0))
        {
          paramView = (ArrayList)X.clone();
          int j = paramView.size();
          for (i = 0; i < j; i++) {
            ((d)paramView.get(i)).c(this);
          }
        }
      }
      V = false;
    }
  }
  
  public String toString()
  {
    return a("");
  }
  
  public static final class a
    extends e
  {
    public Path a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      Path localPath = new Path();
      localPath.moveTo(paramFloat1, paramFloat2);
      localPath.lineTo(paramFloat3, paramFloat4);
      return localPath;
    }
  }
  
  public static class b
  {
    public View a;
    public String b;
    public p c;
    public d0 d;
    public h e;
    
    public b(View paramView, String paramString, h paramh, d0 paramd0, p paramp)
    {
      a = paramView;
      b = paramString;
      c = paramp;
      d = paramd0;
      e = paramh;
    }
  }
  
  public static abstract class c {}
  
  public static abstract interface d
  {
    public abstract void a(h paramh);
    
    public abstract void b(h paramh);
    
    public abstract void c(h paramh);
    
    public abstract void d(h paramh);
  }
}

/* Location:
 * Qualified Name:     d.x.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */