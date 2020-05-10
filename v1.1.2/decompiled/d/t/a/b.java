package d.t.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.w;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.List;

public class b
{
  public final b a;
  public final a b;
  public final List<View> c;
  
  public b(b paramb)
  {
    a = paramb;
    b = new a();
    c = new ArrayList();
  }
  
  public int a()
  {
    return ((s)a).a() - c.size();
  }
  
  public int a(View paramView)
  {
    int i = a).a.indexOfChild(paramView);
    if (i == -1) {
      return -1;
    }
    if (b.c(i)) {
      return -1;
    }
    return i - b.b(i);
  }
  
  public void a(int paramInt)
  {
    paramInt = c(paramInt);
    b.d(paramInt);
    s locals = (s)a;
    Object localObject = a.getChildAt(paramInt);
    if (localObject != null)
    {
      RecyclerView.w localw = RecyclerView.b((View)localObject);
      if (localw != null)
      {
        if ((localw.p()) && (!localw.u()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("called detach on an already detached child ");
          ((StringBuilder)localObject).append(localw);
          throw new IllegalArgumentException(a.a(a, (StringBuilder)localObject));
        }
        localw.a(256);
      }
    }
    RecyclerView.a(a, paramInt);
  }
  
  public int b()
  {
    return ((s)a).a();
  }
  
  public View b(int paramInt)
  {
    paramInt = c(paramInt);
    return ((s)a).a(paramInt);
  }
  
  public boolean b(View paramView)
  {
    return c.contains(paramView);
  }
  
  public final int c(int paramInt)
  {
    if (paramInt < 0) {
      return -1;
    }
    int i = ((s)a).a();
    int j = paramInt;
    while (j < i)
    {
      int k = paramInt - (j - b.b(j));
      if (k == 0)
      {
        while (b.c(j)) {
          j++;
        }
        return j;
      }
      j += k;
    }
    return -1;
  }
  
  public final boolean c(View paramView)
  {
    if (c.remove(paramView))
    {
      s locals = (s)a;
      if (locals != null)
      {
        paramView = RecyclerView.b(paramView);
        if (paramView != null) {
          paramView.a(a);
        }
        return true;
      }
      throw null;
    }
    return false;
  }
  
  public View d(int paramInt)
  {
    return a).a.getChildAt(paramInt);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b.toString());
    localStringBuilder.append(", hidden list:");
    localStringBuilder.append(c.size());
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    public long a = 0L;
    public a b;
    
    public final void a()
    {
      if (b == null) {
        b = new a();
      }
    }
    
    public void a(int paramInt)
    {
      if (paramInt >= 64)
      {
        a locala = b;
        if (locala != null) {
          locala.a(paramInt - 64);
        }
      }
      else
      {
        a &= 1L << paramInt;
      }
    }
    
    public int b(int paramInt)
    {
      a locala = b;
      if (locala == null)
      {
        if (paramInt >= 64) {
          return Long.bitCount(a);
        }
        return Long.bitCount(a & (1L << paramInt) - 1L);
      }
      if (paramInt < 64) {
        return Long.bitCount(a & (1L << paramInt) - 1L);
      }
      paramInt = locala.b(paramInt - 64);
      return Long.bitCount(a) + paramInt;
    }
    
    public void b()
    {
      a = 0L;
      a locala = b;
      if (locala != null) {
        locala.b();
      }
    }
    
    public boolean c(int paramInt)
    {
      if (paramInt >= 64)
      {
        a();
        return b.c(paramInt - 64);
      }
      boolean bool;
      if ((a & 1L << paramInt) != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean d(int paramInt)
    {
      if (paramInt >= 64)
      {
        a();
        return b.d(paramInt - 64);
      }
      long l1 = 1L << paramInt;
      boolean bool;
      if ((a & l1) != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      long l2 = a & l1;
      a = l2;
      l1 -= 1L;
      a = (l2 & l1 | Long.rotateRight(l1 & l2, 1));
      a locala = b;
      if (locala != null)
      {
        if (locala.c(0)) {
          e(63);
        }
        b.d(0);
      }
      return bool;
    }
    
    public void e(int paramInt)
    {
      if (paramInt >= 64)
      {
        a();
        b.e(paramInt - 64);
      }
      else
      {
        a |= 1L << paramInt;
      }
    }
    
    public String toString()
    {
      Object localObject;
      if (b == null)
      {
        localObject = Long.toBinaryString(a);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(b.toString());
        ((StringBuilder)localObject).append("xx");
        ((StringBuilder)localObject).append(Long.toBinaryString(a));
        localObject = ((StringBuilder)localObject).toString();
      }
      return (String)localObject;
    }
  }
  
  public static abstract interface b {}
}

/* Location:
 * Qualified Name:     d.t.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */