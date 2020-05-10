package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import d.b.a.s;
import d.i.i.x.d;
import d.i.i.x.d.b;
import d.t.a.n;
import d.t.a.r;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager
  extends RecyclerView.LayoutManager
{
  public int A;
  public d B;
  public int C;
  public boolean D;
  public boolean E;
  public e F;
  public final Rect G;
  public final b H;
  public boolean I;
  public boolean J;
  public final Runnable K;
  public int q = -1;
  public f[] r;
  public r s;
  public r t;
  public int u;
  public final n v;
  public boolean w;
  public boolean x;
  public BitSet y;
  public int z;
  
  public StaggeredGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    int i = 0;
    w = false;
    x = false;
    z = -1;
    A = Integer.MIN_VALUE;
    B = new d();
    C = 2;
    G = new Rect();
    H = new b();
    I = false;
    J = true;
    K = new a();
    paramAttributeSet = RecyclerView.LayoutManager.a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    paramInt1 = orientation;
    if ((paramInt1 != 0) && (paramInt1 != 1)) {
      throw new IllegalArgumentException("invalid orientation.");
    }
    a(null);
    if (paramInt1 != u)
    {
      u = paramInt1;
      paramContext = s;
      s = t;
      t = paramContext;
      l();
    }
    paramInt1 = spanCount;
    a(null);
    if (paramInt1 != q)
    {
      B.a();
      l();
      q = paramInt1;
      y = new BitSet(q);
      r = new f[q];
      for (paramInt1 = i; paramInt1 < q; paramInt1++) {
        r[paramInt1] = new f(paramInt1);
      }
      l();
    }
    boolean bool = reverseLayout;
    a(null);
    paramContext = F;
    if ((paramContext != null) && (E != bool)) {
      E = bool;
    }
    w = bool;
    l();
    v = new n();
    s = r.a(this, u);
    t = r.a(this, 1 - u);
  }
  
  public int a(RecyclerView.p paramp, RecyclerView.t paramt)
  {
    if (u == 1) {
      return q;
    }
    return 1;
  }
  
  public int a(RecyclerView.t paramt)
  {
    return g(paramt);
  }
  
  public View a(boolean paramBoolean)
  {
    int i = s.b();
    int j = s.a();
    int k = d() - 1;
    Object localObject2;
    for (Object localObject1 = null; k >= 0; localObject1 = localObject2)
    {
      View localView = a(k);
      int m = s.b(localView);
      int n = s.a(localView);
      localObject2 = localObject1;
      if (n > i) {
        if (m >= j)
        {
          localObject2 = localObject1;
        }
        else if ((n > j) && (paramBoolean))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localView;
          }
        }
        else
        {
          return localView;
        }
      }
      k--;
    }
    return (View)localObject1;
  }
  
  public RecyclerView.k a(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new c(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.k a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new c((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new c(paramLayoutParams);
  }
  
  public void a(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof e))
    {
      F = ((e)paramParcelable);
      l();
    }
  }
  
  public void a(AccessibilityEvent paramAccessibilityEvent)
  {
    super.a(paramAccessibilityEvent);
    if (d() > 0)
    {
      View localView1 = b(false);
      View localView2 = a(false);
      if ((localView1 != null) && (localView2 != null))
      {
        int i = a(localView1);
        int j = a(localView2);
        if (i < j)
        {
          paramAccessibilityEvent.setFromIndex(i);
          paramAccessibilityEvent.setToIndex(j);
        }
        else
        {
          paramAccessibilityEvent.setFromIndex(j);
          paramAccessibilityEvent.setToIndex(i);
        }
      }
    }
  }
  
  public void a(RecyclerView.p paramp, RecyclerView.t paramt, View paramView, d paramd)
  {
    paramp = paramView.getLayoutParams();
    if (!(paramp instanceof c))
    {
      super.a(paramView, paramd);
      return;
    }
    paramp = (c)paramp;
    int i;
    int j;
    if (u == 0)
    {
      paramt = e;
      if (paramt == null) {
        i = -1;
      } else {
        i = e;
      }
      if (f) {
        j = q;
      } else {
        j = 1;
      }
      paramd.a(d.b.a(i, j, -1, -1, f, false));
    }
    else
    {
      paramt = e;
      if (paramt == null) {
        i = -1;
      } else {
        i = e;
      }
      if (f) {
        j = q;
      } else {
        j = 1;
      }
      paramd.a(d.b.a(-1, -1, i, j, f, false));
    }
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    B.a();
    l();
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2, 1);
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1, paramInt2, 8);
  }
  
  public void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    b(paramInt1, paramInt2, 4);
  }
  
  public void a(RecyclerView paramRecyclerView, RecyclerView.p paramp)
  {
    paramp = K;
    RecyclerView localRecyclerView = b;
    if (localRecyclerView != null) {
      localRecyclerView.removeCallbacks(paramp);
    }
    for (int i = 0; i < q; i++) {
      r[i].c();
    }
    paramRecyclerView.requestLayout();
  }
  
  public void a(String paramString)
  {
    if (F == null)
    {
      RecyclerView localRecyclerView = b;
      if (localRecyclerView != null) {
        localRecyclerView.a(paramString);
      }
    }
  }
  
  public boolean a()
  {
    boolean bool;
    if (u == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean a(RecyclerView.k paramk)
  {
    return paramk instanceof c;
  }
  
  public int b(RecyclerView.p paramp, RecyclerView.t paramt)
  {
    if (u == 0) {
      return q;
    }
    return 1;
  }
  
  public int b(RecyclerView.t paramt)
  {
    return h(paramt);
  }
  
  public View b(boolean paramBoolean)
  {
    int i = s.b();
    int j = s.a();
    int k = d();
    Object localObject1 = null;
    int m = 0;
    while (m < k)
    {
      View localView = a(m);
      int n = s.b(localView);
      Object localObject2 = localObject1;
      if (s.a(localView) > i) {
        if (n >= j)
        {
          localObject2 = localObject1;
        }
        else if ((n < i) && (paramBoolean))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = localView;
          }
        }
        else
        {
          return localView;
        }
      }
      m++;
      localObject1 = localObject2;
    }
    return (View)localObject1;
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 0) {
      n();
    }
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i;
    if (x) {
      i = p();
    } else {
      i = o();
    }
    int j;
    if (paramInt3 == 8)
    {
      if (paramInt1 < paramInt2)
      {
        j = paramInt2 + 1;
      }
      else
      {
        j = paramInt1 + 1;
        k = paramInt2;
        break label60;
      }
    }
    else {
      j = paramInt1 + paramInt2;
    }
    int k = paramInt1;
    label60:
    B.d(k);
    if (paramInt3 != 1)
    {
      if (paramInt3 != 2)
      {
        if (paramInt3 == 8)
        {
          B.b(paramInt1, 1);
          B.a(paramInt2, 1);
        }
      }
      else {
        B.b(paramInt1, paramInt2);
      }
    }
    else {
      B.a(paramInt1, paramInt2);
    }
    if (j <= i) {
      return;
    }
    if (x) {
      paramInt1 = o();
    } else {
      paramInt1 = p();
    }
    if (k <= paramInt1) {
      l();
    }
  }
  
  public void b(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    b(paramInt1, paramInt2, 2);
  }
  
  public boolean b()
  {
    int i = u;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public int c(RecyclerView.t paramt)
  {
    return i(paramt);
  }
  
  public RecyclerView.k c()
  {
    if (u == 0) {
      return new c(-2, -1);
    }
    return new c(-1, -2);
  }
  
  public int d(RecyclerView.t paramt)
  {
    return g(paramt);
  }
  
  public int e(RecyclerView.t paramt)
  {
    return h(paramt);
  }
  
  public int f(RecyclerView.t paramt)
  {
    return i(paramt);
  }
  
  public final int g(RecyclerView.t paramt)
  {
    if (d() == 0) {
      return 0;
    }
    return s.a(paramt, s, b(J ^ true), a(J ^ true), this, J);
  }
  
  public final int h(RecyclerView.t paramt)
  {
    if (d() == 0) {
      return 0;
    }
    return s.a(paramt, s, b(J ^ true), a(J ^ true), this, J, x);
  }
  
  public final int i(RecyclerView.t paramt)
  {
    if (d() == 0) {
      return 0;
    }
    return s.b(paramt, s, b(J ^ true), a(J ^ true), this, J);
  }
  
  public boolean j()
  {
    boolean bool;
    if (C != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Parcelable k()
  {
    if (F != null) {
      return new e(F);
    }
    e locale = new e();
    E = w;
    F = D;
    G = E;
    d locald = B;
    int i = 0;
    Object localObject;
    if (locald != null)
    {
      localObject = a;
      if (localObject != null)
      {
        C = ((int[])localObject);
        B = localObject.length;
        D = b;
        break label102;
      }
    }
    B = 0;
    label102:
    int j = d();
    int k = -1;
    if (j > 0)
    {
      if (D) {
        j = p();
      } else {
        j = o();
      }
      x = j;
      if (x) {
        localObject = a(true);
      } else {
        localObject = b(true);
      }
      if (localObject == null) {
        j = k;
      } else {
        j = a((View)localObject);
      }
      y = j;
      j = q;
      z = j;
      A = new int[j];
      while (i < q)
      {
        if (D)
        {
          k = r[i].a(Integer.MIN_VALUE);
          j = k;
          if (k == Integer.MIN_VALUE) {
            break label305;
          }
          j = s.a();
        }
        else
        {
          k = r[i].b(Integer.MIN_VALUE);
          j = k;
          if (k == Integer.MIN_VALUE) {
            break label305;
          }
          j = s.b();
        }
        j = k - j;
        label305:
        A[i] = j;
        i++;
      }
    }
    x = -1;
    y = -1;
    z = 0;
    return locale;
  }
  
  public boolean m()
  {
    boolean bool;
    if (F == null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean n()
  {
    if ((d() != 0) && (C != 0) && (h))
    {
      int i;
      int j;
      if (x)
      {
        i = p();
        j = o();
      }
      else
      {
        i = o();
        j = p();
      }
      if ((i == 0) && (q() != null))
      {
        B.a();
        g = true;
        l();
        return true;
      }
      if (!I) {
        return false;
      }
      int k;
      if (x) {
        k = -1;
      } else {
        k = 1;
      }
      Object localObject = B;
      j++;
      localObject = ((d)localObject).a(i, j, k, true);
      if (localObject == null)
      {
        I = false;
        B.b(j);
        return false;
      }
      StaggeredGridLayoutManager.d.a locala = B.a(i, x, k * -1, true);
      if (locala == null) {
        B.b(x);
      } else {
        B.b(x + 1);
      }
      g = true;
      l();
      return true;
    }
    return false;
  }
  
  public int o()
  {
    int i = d();
    int j = 0;
    if (i != 0) {
      j = a(a(0));
    }
    return j;
  }
  
  public int p()
  {
    int i = d();
    if (i == 0) {
      i = 0;
    } else {
      i = a(a(i - 1));
    }
    return i;
  }
  
  public View q()
  {
    int i = d() - 1;
    BitSet localBitSet = new BitSet(q);
    localBitSet.set(0, q, true);
    int j;
    if ((u == 1) && (r())) {
      j = 1;
    } else {
      j = -1;
    }
    int k;
    if (x)
    {
      k = -1;
    }
    else
    {
      k = i + 1;
      i = 0;
    }
    int m;
    if (i < k) {
      m = 1;
    } else {
      m = -1;
    }
    while (i != k)
    {
      View localView = a(i);
      c localc = (c)localView.getLayoutParams();
      Object localObject;
      int n;
      if (localBitSet.get(e.e))
      {
        localObject = e;
        boolean bool;
        if (x)
        {
          n = c;
          if (n == Integer.MIN_VALUE)
          {
            ((f)localObject).a();
            n = c;
          }
          if (n >= s.a()) {
            break label286;
          }
          ArrayList localArrayList = a;
          bool = agetsize1f;
        }
        else
        {
          n = b;
          if (n == Integer.MIN_VALUE)
          {
            ((f)localObject).b();
            n = b;
          }
          if (n <= s.b()) {
            break label286;
          }
          bool = aa.get(0)).f;
        }
        n = bool ^ true;
        break label289;
        label286:
        n = 0;
        label289:
        if (n != 0) {
          return localView;
        }
        localBitSet.clear(e.e);
      }
      if (!f)
      {
        n = i + m;
        if (n != k)
        {
          localObject = a(n);
          int i1;
          if (x)
          {
            i1 = s.a(localView);
            n = s.a((View)localObject);
            if (i1 < n) {
              return localView;
            }
            if (i1 != n) {
              break label435;
            }
          }
          else
          {
            i1 = s.b(localView);
            n = s.b((View)localObject);
            if (i1 > n) {
              return localView;
            }
            if (i1 != n) {
              break label435;
            }
          }
          n = 1;
          break label438;
          label435:
          n = 0;
          label438:
          if (n != 0)
          {
            localObject = (c)((View)localObject).getLayoutParams();
            if (e.e - e.e < 0) {
              n = 1;
            } else {
              n = 0;
            }
            if (j < 0) {
              i1 = 1;
            } else {
              i1 = 0;
            }
            if (n != i1) {
              return localView;
            }
          }
        }
      }
      i += m;
    }
    return null;
  }
  
  public boolean r()
  {
    int i = e();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public class a
    implements Runnable
  {
    public a() {}
    
    public void run()
    {
      n();
    }
  }
  
  public class b
  {
    public int a;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public int[] f;
    
    public b()
    {
      a();
    }
    
    public void a()
    {
      a = -1;
      b = Integer.MIN_VALUE;
      c = false;
      d = false;
      e = false;
      int[] arrayOfInt = f;
      if (arrayOfInt != null) {
        Arrays.fill(arrayOfInt, -1);
      }
    }
  }
  
  public static class c
    extends RecyclerView.k
  {
    public StaggeredGridLayoutManager.f e;
    public boolean f;
    
    public c(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public c(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public c(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public c(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  public static class d
  {
    public int[] a;
    public List<a> b;
    
    public a a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      Object localObject = b;
      if (localObject == null) {
        return null;
      }
      int i = ((List)localObject).size();
      for (int j = 0; j < i; j++)
      {
        localObject = (a)b.get(j);
        int k = x;
        if (k >= paramInt2) {
          return null;
        }
        if ((k >= paramInt1) && ((paramInt3 == 0) || (y == paramInt3) || ((paramBoolean) && (A)))) {
          return (a)localObject;
        }
      }
      return null;
    }
    
    public void a()
    {
      int[] arrayOfInt = a;
      if (arrayOfInt != null) {
        Arrays.fill(arrayOfInt, -1);
      }
      b = null;
    }
    
    public void a(int paramInt)
    {
      int[] arrayOfInt1 = a;
      if (arrayOfInt1 == null)
      {
        arrayOfInt1 = new int[Math.max(paramInt, 10) + 1];
        a = arrayOfInt1;
        Arrays.fill(arrayOfInt1, -1);
      }
      else if (paramInt >= arrayOfInt1.length)
      {
        int i = arrayOfInt1.length;
        while (i <= paramInt) {
          i *= 2;
        }
        int[] arrayOfInt2 = new int[i];
        a = arrayOfInt2;
        System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, arrayOfInt1.length);
        arrayOfInt2 = a;
        Arrays.fill(arrayOfInt2, arrayOfInt1.length, arrayOfInt2.length, -1);
      }
    }
    
    public void a(int paramInt1, int paramInt2)
    {
      Object localObject = a;
      if ((localObject != null) && (paramInt1 < localObject.length))
      {
        int i = paramInt1 + paramInt2;
        a(i);
        localObject = a;
        System.arraycopy(localObject, paramInt1, localObject, i, localObject.length - paramInt1 - paramInt2);
        Arrays.fill(a, paramInt1, i, -1);
        localObject = b;
        if (localObject != null) {
          for (i = ((List)localObject).size() - 1; i >= 0; i--)
          {
            localObject = (a)b.get(i);
            int j = x;
            if (j >= paramInt1) {
              x = (j + paramInt2);
            }
          }
        }
      }
    }
    
    public int b(int paramInt)
    {
      List localList = b;
      if (localList != null) {
        for (int i = localList.size() - 1; i >= 0; i--) {
          if (b.get(i)).x >= paramInt) {
            b.remove(i);
          }
        }
      }
      return d(paramInt);
    }
    
    public void b(int paramInt1, int paramInt2)
    {
      Object localObject = a;
      if ((localObject != null) && (paramInt1 < localObject.length))
      {
        int i = paramInt1 + paramInt2;
        a(i);
        localObject = a;
        System.arraycopy(localObject, i, localObject, paramInt1, localObject.length - paramInt1 - paramInt2);
        localObject = a;
        Arrays.fill((int[])localObject, localObject.length - paramInt2, localObject.length, -1);
        localObject = b;
        if (localObject != null) {
          for (int j = ((List)localObject).size() - 1; j >= 0; j--)
          {
            localObject = (a)b.get(j);
            int k = x;
            if (k >= paramInt1) {
              if (k < i) {
                b.remove(j);
              } else {
                x = (k - paramInt2);
              }
            }
          }
        }
      }
    }
    
    public a c(int paramInt)
    {
      Object localObject = b;
      if (localObject == null) {
        return null;
      }
      for (int i = ((List)localObject).size() - 1; i >= 0; i--)
      {
        localObject = (a)b.get(i);
        if (x == paramInt) {
          return (a)localObject;
        }
      }
      return null;
    }
    
    public int d(int paramInt)
    {
      Object localObject = a;
      if (localObject == null) {
        return -1;
      }
      if (paramInt >= localObject.length) {
        return -1;
      }
      if (b == null) {}
      label102:
      do
      {
        i = -1;
        break;
        localObject = c(paramInt);
        if (localObject != null) {
          b.remove(localObject);
        }
        int j = b.size();
        for (i = 0; i < j; i++) {
          if (b.get(i)).x >= paramInt) {
            break label102;
          }
        }
        i = -1;
      } while (i == -1);
      localObject = (a)b.get(i);
      b.remove(i);
      int i = x;
      if (i == -1)
      {
        localObject = a;
        Arrays.fill((int[])localObject, paramInt, localObject.length, -1);
        return a.length;
      }
      localObject = a;
      i++;
      Arrays.fill((int[])localObject, paramInt, i, -1);
      return i;
    }
    
    public static class a
      implements Parcelable
    {
      public static final Parcelable.Creator<a> CREATOR = new a();
      public boolean A;
      public int x;
      public int y;
      public int[] z;
      
      public a() {}
      
      public a(Parcel paramParcel)
      {
        x = paramParcel.readInt();
        y = paramParcel.readInt();
        int i = paramParcel.readInt();
        boolean bool = true;
        if (i != 1) {
          bool = false;
        }
        A = bool;
        i = paramParcel.readInt();
        if (i > 0)
        {
          int[] arrayOfInt = new int[i];
          z = arrayOfInt;
          paramParcel.readIntArray(arrayOfInt);
        }
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public String toString()
      {
        StringBuilder localStringBuilder = a.a("FullSpanItem{mPosition=");
        localStringBuilder.append(x);
        localStringBuilder.append(", mGapDir=");
        localStringBuilder.append(y);
        localStringBuilder.append(", mHasUnwantedGapAfter=");
        localStringBuilder.append(A);
        localStringBuilder.append(", mGapPerSpan=");
        localStringBuilder.append(Arrays.toString(z));
        localStringBuilder.append('}');
        return localStringBuilder.toString();
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeInt(x);
        paramParcel.writeInt(y);
        paramParcel.writeInt(A);
        int[] arrayOfInt = z;
        if ((arrayOfInt != null) && (arrayOfInt.length > 0))
        {
          paramParcel.writeInt(arrayOfInt.length);
          paramParcel.writeIntArray(z);
        }
        else
        {
          paramParcel.writeInt(0);
        }
      }
      
      public static final class a
        implements Parcelable.Creator<StaggeredGridLayoutManager.d.a>
      {
        public Object createFromParcel(Parcel paramParcel)
        {
          return new StaggeredGridLayoutManager.d.a(paramParcel);
        }
        
        public Object[] newArray(int paramInt)
        {
          return new StaggeredGridLayoutManager.d.a[paramInt];
        }
      }
    }
  }
  
  public static class e
    implements Parcelable
  {
    public static final Parcelable.Creator<e> CREATOR = new a();
    public int[] A;
    public int B;
    public int[] C;
    public List<StaggeredGridLayoutManager.d.a> D;
    public boolean E;
    public boolean F;
    public boolean G;
    public int x;
    public int y;
    public int z;
    
    public e() {}
    
    public e(Parcel paramParcel)
    {
      x = paramParcel.readInt();
      y = paramParcel.readInt();
      int i = paramParcel.readInt();
      z = i;
      int[] arrayOfInt;
      if (i > 0)
      {
        arrayOfInt = new int[i];
        A = arrayOfInt;
        paramParcel.readIntArray(arrayOfInt);
      }
      i = paramParcel.readInt();
      B = i;
      if (i > 0)
      {
        arrayOfInt = new int[i];
        C = arrayOfInt;
        paramParcel.readIntArray(arrayOfInt);
      }
      i = paramParcel.readInt();
      boolean bool1 = false;
      if (i == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      E = bool2;
      if (paramParcel.readInt() == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      F = bool2;
      boolean bool2 = bool1;
      if (paramParcel.readInt() == 1) {
        bool2 = true;
      }
      G = bool2;
      D = paramParcel.readArrayList(StaggeredGridLayoutManager.d.a.class.getClassLoader());
    }
    
    public e(e parame)
    {
      z = z;
      x = x;
      y = y;
      A = A;
      B = B;
      C = C;
      E = E;
      F = F;
      G = G;
      D = D;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(x);
      paramParcel.writeInt(y);
      paramParcel.writeInt(z);
      if (z > 0) {
        paramParcel.writeIntArray(A);
      }
      paramParcel.writeInt(B);
      if (B > 0) {
        paramParcel.writeIntArray(C);
      }
      paramParcel.writeInt(E);
      paramParcel.writeInt(F);
      paramParcel.writeInt(G);
      paramParcel.writeList(D);
    }
    
    public static final class a
      implements Parcelable.Creator<StaggeredGridLayoutManager.e>
    {
      public Object createFromParcel(Parcel paramParcel)
      {
        return new StaggeredGridLayoutManager.e(paramParcel);
      }
      
      public Object[] newArray(int paramInt)
      {
        return new StaggeredGridLayoutManager.e[paramInt];
      }
    }
  }
  
  public class f
  {
    public ArrayList<View> a = new ArrayList();
    public int b = Integer.MIN_VALUE;
    public int c = Integer.MIN_VALUE;
    public int d = 0;
    public final int e;
    
    public f(int paramInt)
    {
      e = paramInt;
    }
    
    public int a(int paramInt)
    {
      int i = c;
      if (i != Integer.MIN_VALUE) {
        return i;
      }
      if (a.size() == 0) {
        return paramInt;
      }
      a();
      return c;
    }
    
    public StaggeredGridLayoutManager.c a(View paramView)
    {
      return (StaggeredGridLayoutManager.c)paramView.getLayoutParams();
    }
    
    public void a()
    {
      Object localObject = a;
      View localView = (View)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
      localObject = a(localView);
      c = s.a(localView);
      if (f)
      {
        localObject = B.c(((RecyclerView.k)localObject).a());
        if ((localObject != null) && (y == 1))
        {
          int i = c;
          int j = e;
          localObject = z;
          if (localObject == null) {
            j = 0;
          } else {
            j = localObject[j];
          }
          c = (i + j);
        }
      }
    }
    
    public int b(int paramInt)
    {
      int i = b;
      if (i != Integer.MIN_VALUE) {
        return i;
      }
      if (a.size() == 0) {
        return paramInt;
      }
      b();
      return b;
    }
    
    public void b()
    {
      Object localObject = a;
      int i = 0;
      View localView = (View)((ArrayList)localObject).get(0);
      localObject = a(localView);
      b = s.b(localView);
      if (f)
      {
        localObject = B.c(((RecyclerView.k)localObject).a());
        if ((localObject != null) && (y == -1))
        {
          int j = b;
          int k = e;
          localObject = z;
          if (localObject != null) {
            i = localObject[k];
          }
          b = (j - i);
        }
      }
    }
    
    public void c()
    {
      a.clear();
      b = Integer.MIN_VALUE;
      c = Integer.MIN_VALUE;
      d = 0;
    }
  }
}

/* Location:
 * Qualified Name:     androidx.recyclerview.widget.StaggeredGridLayoutManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */