package d.b.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;

public abstract class b$c
  extends Drawable.ConstantState
{
  public int A;
  public int B;
  public boolean C;
  public ColorFilter D;
  public boolean E;
  public ColorStateList F;
  public PorterDuff.Mode G;
  public boolean H;
  public boolean I;
  public final b a;
  public Resources b;
  public int c = 160;
  public int d;
  public int e;
  public SparseArray<Drawable.ConstantState> f;
  public Drawable[] g;
  public int h;
  public boolean i;
  public boolean j;
  public Rect k;
  public boolean l;
  public boolean m;
  public int n;
  public int o;
  public int p;
  public int q;
  public boolean r;
  public int s;
  public boolean t;
  public boolean u;
  public boolean v;
  public boolean w;
  public boolean x;
  public boolean y;
  public int z;
  
  public b$c(c paramc, b paramb, Resources paramResources)
  {
    int i1 = 0;
    i = false;
    l = false;
    x = true;
    A = 0;
    B = 0;
    a = paramb;
    if (paramResources != null) {
      paramb = paramResources;
    } else if (paramc != null) {
      paramb = b;
    } else {
      paramb = null;
    }
    b = paramb;
    if (paramc != null) {
      i2 = c;
    } else {
      i2 = 0;
    }
    int i2 = b.a(paramResources, i2);
    c = i2;
    if (paramc != null)
    {
      d = d;
      e = e;
      v = true;
      w = true;
      i = i;
      l = l;
      x = x;
      y = y;
      z = z;
      A = A;
      B = B;
      C = C;
      D = D;
      E = E;
      F = F;
      G = G;
      H = H;
      I = I;
      if (c == i2)
      {
        if (j)
        {
          k = new Rect(k);
          j = true;
        }
        if (m)
        {
          n = n;
          o = o;
          p = p;
          q = q;
          m = true;
        }
      }
      if (r)
      {
        s = s;
        r = true;
      }
      if (t)
      {
        u = u;
        t = true;
      }
      paramb = g;
      g = new Drawable[paramb.length];
      h = h;
      paramc = f;
      if (paramc != null) {
        f = paramc.clone();
      } else {
        f = new SparseArray(h);
      }
      int i3 = h;
      for (i2 = i1; i2 < i3; i2++) {
        if (paramb[i2] != null)
        {
          paramc = paramb[i2].getConstantState();
          if (paramc != null) {
            f.put(i2, paramc);
          } else {
            g[i2] = paramb[i2];
          }
        }
      }
    }
    g = new Drawable[10];
    h = 0;
  }
  
  public final int a(Drawable paramDrawable)
  {
    int i1 = h;
    if (i1 >= g.length)
    {
      i2 = i1 + 10;
      e.a locala = (e.a)this;
      Object localObject = new Drawable[i2];
      System.arraycopy(g, 0, localObject, 0, i1);
      g = ((Drawable[])localObject);
      localObject = new int[i2][];
      System.arraycopy(J, 0, localObject, 0, i1);
      J = ((int[][])localObject);
    }
    paramDrawable.mutate();
    paramDrawable.setVisible(false, true);
    paramDrawable.setCallback(a);
    g[i1] = paramDrawable;
    h += 1;
    int i2 = e;
    e = (paramDrawable.getChangingConfigurations() | i2);
    r = false;
    t = false;
    k = null;
    j = false;
    m = false;
    v = false;
    return i1;
  }
  
  public final Drawable a(int paramInt)
  {
    Object localObject = g[paramInt];
    if (localObject != null) {
      return (Drawable)localObject;
    }
    localObject = f;
    if (localObject != null)
    {
      int i1 = ((SparseArray)localObject).indexOfKey(paramInt);
      if (i1 >= 0)
      {
        localObject = ((Drawable.ConstantState)f.valueAt(i1)).newDrawable(b);
        if (Build.VERSION.SDK_INT >= 23) {
          ((Drawable)localObject).setLayoutDirection(z);
        }
        localObject = ((Drawable)localObject).mutate();
        ((Drawable)localObject).setCallback(a);
        g[paramInt] = localObject;
        f.removeAt(i1);
        if (f.size() == 0) {
          f = null;
        }
        return (Drawable)localObject;
      }
    }
    return null;
  }
  
  public final void a(Resources paramResources)
  {
    if (paramResources != null)
    {
      b = paramResources;
      int i1 = b.a(paramResources, c);
      int i2 = c;
      c = i1;
      if (i2 != i1)
      {
        m = false;
        j = false;
      }
    }
  }
  
  public boolean a()
  {
    try
    {
      if (v)
      {
        boolean bool = w;
        return bool;
      }
      c();
      v = true;
      int i1 = h;
      Drawable[] arrayOfDrawable = g;
      for (int i2 = 0; i2 < i1; i2++) {
        if (arrayOfDrawable[i2].getConstantState() == null)
        {
          w = false;
          return false;
        }
      }
      w = true;
      return true;
    }
    finally {}
  }
  
  public void b()
  {
    m = true;
    c();
    int i1 = h;
    Drawable[] arrayOfDrawable = g;
    o = -1;
    n = -1;
    int i2 = 0;
    q = 0;
    p = 0;
    while (i2 < i1)
    {
      Drawable localDrawable = arrayOfDrawable[i2];
      int i3 = localDrawable.getIntrinsicWidth();
      if (i3 > n) {
        n = i3;
      }
      i3 = localDrawable.getIntrinsicHeight();
      if (i3 > o) {
        o = i3;
      }
      i3 = localDrawable.getMinimumWidth();
      if (i3 > p) {
        p = i3;
      }
      i3 = localDrawable.getMinimumHeight();
      if (i3 > q) {
        q = i3;
      }
      i2++;
    }
  }
  
  public final void c()
  {
    Object localObject1 = f;
    if (localObject1 != null)
    {
      int i1 = ((SparseArray)localObject1).size();
      for (int i2 = 0; i2 < i1; i2++)
      {
        int i3 = f.keyAt(i2);
        Object localObject2 = (Drawable.ConstantState)f.valueAt(i2);
        localObject1 = g;
        localObject2 = ((Drawable.ConstantState)localObject2).newDrawable(b);
        if (Build.VERSION.SDK_INT >= 23) {
          ((Drawable)localObject2).setLayoutDirection(z);
        }
        localObject2 = ((Drawable)localObject2).mutate();
        ((Drawable)localObject2).setCallback(a);
        localObject1[i3] = localObject2;
      }
      f = null;
    }
  }
  
  public boolean canApplyTheme()
  {
    int i1 = h;
    Drawable[] arrayOfDrawable = g;
    for (int i2 = 0; i2 < i1; i2++)
    {
      Object localObject = arrayOfDrawable[i2];
      if (localObject != null)
      {
        if (((Drawable)localObject).canApplyTheme()) {
          return true;
        }
      }
      else
      {
        localObject = (Drawable.ConstantState)f.get(i2);
        if ((localObject != null) && (((Drawable.ConstantState)localObject).canApplyTheme())) {
          return true;
        }
      }
    }
    return false;
  }
  
  public abstract void d();
  
  public int getChangingConfigurations()
  {
    return d | e;
  }
}

/* Location:
 * Qualified Name:     base.d.b.c.a.b.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */