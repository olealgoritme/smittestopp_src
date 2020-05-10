package d.t.a;

import android.view.View;

public class w
{
  public final b a;
  public a b;
  
  public w(b paramb)
  {
    a = paramb;
    b = new a();
  }
  
  public View a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = a.b();
    int j = a.a();
    int k;
    if (paramInt2 > paramInt1) {
      k = 1;
    } else {
      k = -1;
    }
    Object localObject2;
    for (Object localObject1 = null; paramInt1 != paramInt2; localObject1 = localObject2)
    {
      View localView = a.a(paramInt1);
      int m = a.a(localView);
      int n = a.b(localView);
      localObject2 = b;
      b = i;
      c = j;
      d = m;
      e = n;
      if (paramInt3 != 0)
      {
        a = 0;
        a = (paramInt3 | 0x0);
        if (((a)localObject2).a()) {
          return localView;
        }
      }
      localObject2 = localObject1;
      if (paramInt4 != 0)
      {
        a locala = b;
        a = 0;
        a = (paramInt4 | 0x0);
        localObject2 = localObject1;
        if (locala.a()) {
          localObject2 = localView;
        }
      }
      paramInt1 += k;
    }
    return (View)localObject1;
  }
  
  public static class a
  {
    public int a = 0;
    public int b;
    public int c;
    public int d;
    public int e;
    
    public int a(int paramInt1, int paramInt2)
    {
      if (paramInt1 > paramInt2) {
        return 1;
      }
      if (paramInt1 == paramInt2) {
        return 2;
      }
      return 4;
    }
    
    public boolean a()
    {
      int i = a;
      if (((i & 0x7) != 0) && ((i & a(d, b) << 0) == 0)) {
        return false;
      }
      i = a;
      if (((i & 0x70) != 0) && ((i & a(d, c) << 4) == 0)) {
        return false;
      }
      i = a;
      if (((i & 0x700) != 0) && ((i & a(e, b) << 8) == 0)) {
        return false;
      }
      i = a;
      return ((i & 0x7000) == 0) || ((i & a(e, c) << 12) != 0);
    }
  }
  
  public static abstract interface b
  {
    public abstract int a();
    
    public abstract int a(View paramView);
    
    public abstract View a(int paramInt);
    
    public abstract int b();
    
    public abstract int b(View paramView);
  }
}

/* Location:
 * Qualified Name:     d.t.a.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */