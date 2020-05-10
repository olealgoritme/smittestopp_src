package d.v;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.savedstate.Recreator.a;
import d.c.a.b.b;
import java.util.Set;

@SuppressLint({"RestrictedApi"})
public final class a
{
  public b<String, b> a = new b();
  public Bundle b;
  public boolean c;
  public Recreator.a d;
  public boolean e = true;
  
  public Bundle a(String paramString)
  {
    if (c)
    {
      Bundle localBundle = b;
      if (localBundle != null)
      {
        localBundle = localBundle.getBundle(paramString);
        b.remove(paramString);
        if (b.isEmpty()) {
          b = null;
        }
        return localBundle;
      }
      return null;
    }
    throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
  }
  
  public void a(Class<? extends a> paramClass)
  {
    if (e)
    {
      if (d == null) {
        d = new Recreator.a(this);
      }
      try
      {
        paramClass.getDeclaredConstructor(new Class[0]);
        localObject = d;
        paramClass = paramClass.getName();
        a.add(paramClass);
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Object localObject = e.a.a.a.a.a("Class");
        ((StringBuilder)localObject).append(paramClass.getSimpleName());
        ((StringBuilder)localObject).append(" must have default constructor in order to be automatically recreated");
        throw new IllegalArgumentException(((StringBuilder)localObject).toString(), localNoSuchMethodException);
      }
    }
    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
  }
  
  public static abstract interface a
  {
    public abstract void a(c paramc);
  }
  
  public static abstract interface b
  {
    public abstract Bundle a();
  }
}

/* Location:
 * Qualified Name:     d.v.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */