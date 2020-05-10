package androidx.recyclerview.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import d.b.a.s;
import d.t.a.r;
import d.t.a.w;
import e.a.a.a.a;
import java.util.List;

public class LinearLayoutManager
  extends RecyclerView.LayoutManager
{
  public d A = null;
  public final a B = new a();
  public final b C = new b();
  public int D = 2;
  public int q = 1;
  public c r;
  public r s;
  public boolean t;
  public boolean u = false;
  public boolean v = false;
  public boolean w = false;
  public boolean x = true;
  public int y = -1;
  public int z = Integer.MIN_VALUE;
  
  public LinearLayoutManager(int paramInt, boolean paramBoolean)
  {
    d(paramInt);
    a(null);
    if (paramBoolean != u)
    {
      u = paramBoolean;
      l();
    }
  }
  
  public LinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = RecyclerView.LayoutManager.a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    d(orientation);
    boolean bool = reverseLayout;
    a(null);
    if (bool != u)
    {
      u = bool;
      l();
    }
    a(stackFromEnd);
  }
  
  public int a(RecyclerView.t paramt)
  {
    return g(paramt);
  }
  
  public View a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    n();
    int i = 320;
    int j;
    if (paramBoolean1) {
      j = 24579;
    } else {
      j = 320;
    }
    if (!paramBoolean2) {
      i = 0;
    }
    View localView;
    if (q == 0) {
      localView = e.a(paramInt1, paramInt2, j, i);
    } else {
      localView = f.a(paramInt1, paramInt2, j, i);
    }
    return localView;
  }
  
  public final View a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (v) {
      return a(0, d(), paramBoolean1, paramBoolean2);
    }
    return a(d() - 1, -1, paramBoolean1, paramBoolean2);
  }
  
  public void a(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof d))
    {
      A = ((d)paramParcelable);
      l();
    }
  }
  
  public void a(AccessibilityEvent paramAccessibilityEvent)
  {
    super.a(paramAccessibilityEvent);
    if (d() > 0)
    {
      View localView = a(0, d(), false, true);
      int i = -1;
      int j;
      if (localView == null) {
        j = -1;
      } else {
        j = a(localView);
      }
      paramAccessibilityEvent.setFromIndex(j);
      localView = a(d() - 1, -1, false, true);
      if (localView == null) {
        j = i;
      } else {
        j = a(localView);
      }
      paramAccessibilityEvent.setToIndex(j);
    }
  }
  
  public void a(RecyclerView paramRecyclerView, RecyclerView.p paramp) {}
  
  public void a(String paramString)
  {
    if (A == null)
    {
      RecyclerView localRecyclerView = b;
      if (localRecyclerView != null) {
        localRecyclerView.a(paramString);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(null);
    if (w == paramBoolean) {
      return;
    }
    w = paramBoolean;
    l();
  }
  
  public boolean a()
  {
    boolean bool;
    if (q == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int b(RecyclerView.t paramt)
  {
    return h(paramt);
  }
  
  public final View b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (v) {
      return a(d() - 1, -1, paramBoolean1, paramBoolean2);
    }
    return a(0, d(), paramBoolean1, paramBoolean2);
  }
  
  public boolean b()
  {
    int i = q;
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
    return new RecyclerView.k(-2, -2);
  }
  
  public int d(RecyclerView.t paramt)
  {
    return g(paramt);
  }
  
  public void d(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      throw new IllegalArgumentException(a.a("invalid orientation:", paramInt));
    }
    a(null);
    if ((paramInt != q) || (s == null))
    {
      r localr = r.a(this, paramInt);
      s = localr;
      B.a = localr;
      q = paramInt;
      l();
    }
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
    n();
    return s.a(paramt, s, b(x ^ true, true), a(x ^ true, true), this, x);
  }
  
  public final int h(RecyclerView.t paramt)
  {
    if (d() == 0) {
      return 0;
    }
    n();
    return s.a(paramt, s, b(x ^ true, true), a(x ^ true, true), this, x, v);
  }
  
  public final int i(RecyclerView.t paramt)
  {
    if (d() == 0) {
      return 0;
    }
    n();
    return s.b(paramt, s, b(x ^ true, true), a(x ^ true, true), this, x);
  }
  
  public boolean j()
  {
    return true;
  }
  
  public Parcelable k()
  {
    if (A != null) {
      return new d(A);
    }
    d locald = new d();
    if (d() > 0)
    {
      n();
      boolean bool = t ^ v;
      z = bool;
      View localView;
      if (bool)
      {
        localView = o();
        y = (s.a() - s.a(localView));
        x = a(localView);
      }
      else
      {
        localView = p();
        x = a(localView);
        y = (s.b(localView) - s.b());
      }
    }
    else
    {
      x = -1;
    }
    return locald;
  }
  
  public boolean m()
  {
    boolean bool;
    if ((A == null) && (t == w)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void n()
  {
    if (r == null) {
      r = new c();
    }
  }
  
  public final View o()
  {
    int i;
    if (v) {
      i = 0;
    } else {
      i = d() - 1;
    }
    return a(i);
  }
  
  public final View p()
  {
    int i;
    if (v) {
      i = d() - 1;
    } else {
      i = 0;
    }
    return a(i);
  }
  
  public static class a
  {
    public r a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    
    public a()
    {
      a();
    }
    
    public void a()
    {
      b = -1;
      c = Integer.MIN_VALUE;
      d = false;
      e = false;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = a.a("AnchorInfo{mPosition=");
      localStringBuilder.append(b);
      localStringBuilder.append(", mCoordinate=");
      localStringBuilder.append(c);
      localStringBuilder.append(", mLayoutFromEnd=");
      localStringBuilder.append(d);
      localStringBuilder.append(", mValid=");
      localStringBuilder.append(e);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  public static class b {}
  
  public static class c
  {
    public boolean a = true;
    public int b = 0;
    public List<RecyclerView.w> c = null;
  }
  
  public static class d
    implements Parcelable
  {
    public static final Parcelable.Creator<d> CREATOR = new a();
    public int x;
    public int y;
    public boolean z;
    
    public d() {}
    
    public d(Parcel paramParcel)
    {
      x = paramParcel.readInt();
      y = paramParcel.readInt();
      int i = paramParcel.readInt();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      z = bool;
    }
    
    public d(d paramd)
    {
      x = x;
      y = y;
      z = z;
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
    }
    
    public static final class a
      implements Parcelable.Creator<LinearLayoutManager.d>
    {
      public Object createFromParcel(Parcel paramParcel)
      {
        return new LinearLayoutManager.d(paramParcel);
      }
      
      public Object[] newArray(int paramInt)
      {
        return new LinearLayoutManager.d[paramInt];
      }
    }
  }
}

/* Location:
 * Qualified Name:     androidx.recyclerview.widget.LinearLayoutManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */