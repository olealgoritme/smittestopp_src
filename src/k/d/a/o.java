package k.d.a;

import java.lang.reflect.Method;
import org.greenrobot.eventbus.ThreadMode;

public class o
{
  public final Method a;
  public final ThreadMode b;
  public final Class<?> c;
  public final int d;
  public final boolean e;
  public String f;
  
  public o(Method paramMethod, Class<?> paramClass, ThreadMode paramThreadMode, int paramInt, boolean paramBoolean)
  {
    a = paramMethod;
    b = paramThreadMode;
    c = paramClass;
    d = paramInt;
    e = paramBoolean;
  }
  
  public final void a()
  {
    try
    {
      if (f == null)
      {
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>(64);
        localStringBuilder.append(a.getDeclaringClass().getName());
        localStringBuilder.append('#');
        localStringBuilder.append(a.getName());
        localStringBuilder.append('(');
        localStringBuilder.append(c.getName());
        f = localStringBuilder.toString();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof o))
    {
      a();
      paramObject = (o)paramObject;
      ((o)paramObject).a();
      return f.equals(f);
    }
    return false;
  }
  
  public int hashCode()
  {
    return a.hashCode();
  }
}

/* Location:
 * Qualified Name:     base.k.d.a.o
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */