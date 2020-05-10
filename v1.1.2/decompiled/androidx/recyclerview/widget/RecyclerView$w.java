package androidx.recyclerview.widget;

import android.util.Log;
import android.view.View;
import e.a.a.a.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class RecyclerView$w
{
  public static final List<Object> r = ;
  public final View a;
  public WeakReference<RecyclerView> b;
  public int c;
  public int d;
  public long e;
  public int f;
  public w g;
  public w h;
  public int i;
  public List<Object> j;
  public List<Object> k;
  public int l;
  public RecyclerView.p m;
  public boolean n;
  public int o;
  public int p;
  public RecyclerView q;
  
  public void a()
  {
    List localList = j;
    if (localList != null) {
      localList.clear();
    }
    i &= 0xFBFF;
  }
  
  public void a(int paramInt)
  {
    i = (paramInt | i);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    i = (paramInt1 & paramInt2 | i & paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(8);
    a(paramInt2, paramBoolean);
    c = paramInt1;
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (d == -1) {
      d = c;
    }
    if (f == -1) {
      f = c;
    }
    if (paramBoolean) {
      f += paramInt;
    }
    c += paramInt;
    throw null;
  }
  
  public void a(RecyclerView.p paramp, boolean paramBoolean)
  {
    m = paramp;
    n = paramBoolean;
  }
  
  public void a(RecyclerView paramRecyclerView)
  {
    paramRecyclerView.a(this, o);
    o = 0;
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null)
    {
      a(1024);
    }
    else if ((0x400 & i) == 0)
    {
      if (j == null)
      {
        ArrayList localArrayList = new ArrayList();
        j = localArrayList;
        k = Collections.unmodifiableList(localArrayList);
      }
      j.add(paramObject);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    int i1 = l;
    if (paramBoolean) {
      i1--;
    } else {
      i1++;
    }
    l = i1;
    if (i1 < 0)
    {
      l = 0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
      localStringBuilder.append(this);
      Log.e("View", localStringBuilder.toString());
    }
    else if ((!paramBoolean) && (i1 == 1))
    {
      i |= 0x10;
    }
    else if ((paramBoolean) && (l == 0))
    {
      i &= 0xFFFFFFEF;
    }
  }
  
  public void b()
  {
    i &= 0xFFFFFFDF;
  }
  
  public boolean b(int paramInt)
  {
    boolean bool;
    if ((paramInt & i) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void c()
  {
    i &= 0xFEFF;
  }
  
  public boolean d()
  {
    if ((i & 0x10) != 0) {
      return false;
    }
    throw null;
  }
  
  public final int e()
  {
    RecyclerView localRecyclerView = q;
    if (localRecyclerView == null) {
      return -1;
    }
    return localRecyclerView.a(this);
  }
  
  public final int f()
  {
    return 0;
  }
  
  public final int g()
  {
    int i1 = f;
    int i2 = i1;
    if (i1 == -1) {
      i2 = c;
    }
    return i2;
  }
  
  public final int h()
  {
    return d;
  }
  
  public List<Object> i()
  {
    if ((i & 0x400) == 0)
    {
      List localList = j;
      if ((localList != null) && (localList.size() != 0)) {
        return k;
      }
      return r;
    }
    return r;
  }
  
  public boolean j()
  {
    boolean bool;
    if (((i & 0x200) == 0) && (!l())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean k()
  {
    int i1 = i;
    boolean bool = true;
    if ((i1 & 0x1) == 0) {
      bool = false;
    }
    return bool;
  }
  
  public boolean l()
  {
    boolean bool;
    if ((i & 0x4) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean m()
  {
    if ((i & 0x10) != 0) {
      return false;
    }
    throw null;
  }
  
  public boolean n()
  {
    boolean bool;
    if ((i & 0x8) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean o()
  {
    boolean bool;
    if (m != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean p()
  {
    boolean bool;
    if ((i & 0x100) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean q()
  {
    boolean bool;
    if ((i & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean r()
  {
    boolean bool;
    if ((i & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void s()
  {
    i = 0;
    c = -1;
    d = -1;
    e = -1L;
    f = -1;
    l = 0;
    g = null;
    h = null;
    a();
    o = 0;
    p = -1;
    RecyclerView.b(this);
  }
  
  public boolean t()
  {
    boolean bool;
    if ((i & 0x10) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    Object localObject = a.a("ViewHolder{");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    ((StringBuilder)localObject).append(" position=");
    ((StringBuilder)localObject).append(c);
    ((StringBuilder)localObject).append(" id=");
    ((StringBuilder)localObject).append(e);
    ((StringBuilder)localObject).append(", oldPos=");
    ((StringBuilder)localObject).append(d);
    ((StringBuilder)localObject).append(", pLpos:");
    ((StringBuilder)localObject).append(f);
    StringBuilder localStringBuilder = new StringBuilder(((StringBuilder)localObject).toString());
    if (o())
    {
      localStringBuilder.append(" scrap ");
      if (n) {
        localObject = "[changeScrap]";
      } else {
        localObject = "[attachedScrap]";
      }
      localStringBuilder.append((String)localObject);
    }
    if (l()) {
      localStringBuilder.append(" invalid");
    }
    if (!k()) {
      localStringBuilder.append(" unbound");
    }
    if (r()) {
      localStringBuilder.append(" update");
    }
    if (n()) {
      localStringBuilder.append(" removed");
    }
    if (u()) {
      localStringBuilder.append(" ignored");
    }
    if (p()) {
      localStringBuilder.append(" tmpDetached");
    }
    if (!m())
    {
      localObject = a.a(" not recyclable(");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(")");
      localStringBuilder.append(((StringBuilder)localObject).toString());
    }
    if (j()) {
      localStringBuilder.append(" undefined adapter position");
    }
    throw null;
  }
  
  public boolean u()
  {
    boolean bool;
    if ((i & 0x80) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void v()
  {
    m.b(this);
  }
  
  public boolean w()
  {
    boolean bool;
    if ((i & 0x20) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */