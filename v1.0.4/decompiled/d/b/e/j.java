package d.b.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;

public final class j
{
  public static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
  public static j c;
  public n0 a;
  
  public static PorterDuffColorFilter a(int paramInt, PorterDuff.Mode paramMode)
  {
    try
    {
      paramMode = n0.a(paramInt, paramMode);
      return paramMode;
    }
    finally
    {
      paramMode = finally;
      throw paramMode;
    }
  }
  
  public static j a()
  {
    try
    {
      if (c == null) {
        b();
      }
      j localj = c;
      return localj;
    }
    finally {}
  }
  
  public static void a(Drawable paramDrawable, v0 paramv0, int[] paramArrayOfInt)
  {
    n0.a(paramDrawable, paramv0, paramArrayOfInt);
  }
  
  public static void b()
  {
    try
    {
      if (c == null)
      {
        Object localObject1 = new d/b/e/j;
        ((j)localObject1).<init>();
        c = (j)localObject1;
        a = n0.a();
        n0 localn0 = ca;
        localObject1 = new d/b/e/j$a;
        ((j.a)localObject1).<init>();
        localn0.a((n0.e)localObject1);
      }
      return;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public Drawable a(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = a.b(paramContext, paramInt);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public Drawable a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    try
    {
      paramContext = a.a(paramContext, paramInt, paramBoolean);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void a(Context paramContext)
  {
    try
    {
      a.a(paramContext);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public ColorStateList b(Context paramContext, int paramInt)
  {
    try
    {
      paramContext = a.c(paramContext, paramInt);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}

/* Location:
 * Qualified Name:     base.d.b.e.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */