package j.a.a.a.a.a;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.util.Collections;
import java.util.List;

public abstract class a
{
  public static a a;
  
  public static a a()
  {
    try
    {
      if (a != null)
      {
        localObject1 = a;
        return (a)localObject1;
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject1 = new j/a/a/a/a/a/d;
        ((d)localObject1).<init>();
        a = (a)localObject1;
        return (a)localObject1;
      }
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject1 = new j/a/a/a/a/a/c;
        ((c)localObject1).<init>();
        a = (a)localObject1;
        return (a)localObject1;
      }
      Object localObject1 = new j/a/a/a/a/a/b;
      ((b)localObject1).<init>();
      a = (a)localObject1;
      return (a)localObject1;
    }
    finally {}
  }
  
  public abstract void a(g paramg);
  
  public final void a(List<h> paramList, k paramk, g paramg)
  {
    if (paramg != null)
    {
      Handler localHandler = new Handler(Looper.getMainLooper());
      if (paramList == null) {
        paramList = Collections.emptyList();
      }
      if (paramk == null)
      {
        long l1;
        long l2;
        if ((0L == 0L) && (0L == 0L))
        {
          l1 = 500L;
          l2 = 4500L;
        }
        else
        {
          l1 = 0L;
          l2 = l1;
        }
        paramk = new k(0, 1, 0L, 1, 3, true, 255, true, true, true, 10000L, 10000L, l1, l2, null);
      }
      a(paramList, paramk, paramg, localHandler);
      return;
    }
    throw new IllegalArgumentException("callback is null");
  }
  
  public abstract void a(List<h> paramList, k paramk, g paramg, Handler paramHandler);
  
  public final void b(g paramg)
  {
    if (paramg != null)
    {
      c(paramg);
      return;
    }
    throw new IllegalArgumentException("callback is null");
  }
  
  public abstract void c(g paramg);
}

/* Location:
 * Qualified Name:     base.j.a.a.a.a.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */