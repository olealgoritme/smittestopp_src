package d.v;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.savedstate.Recreator.a;
import d.c.a.b.b;
import java.util.Set;

@SuppressLint({"RestrictedApi"})
public final class a
{
  public b<String, a.b> a = new b();
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
  
  public void a(Class<? extends a.a> paramClass)
  {
    if (e)
    {
      if (d == null) {
        d = new Recreator.a(this);
      }
      try
      {
        paramClass.getDeclaredConstructor(new Class[0]);
        Recreator.a locala = d;
        paramClass = paramClass.getName();
        a.add(paramClass);
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        StringBuilder localStringBuilder = e.a.a.a.a.a("Class");
        localStringBuilder.append(paramClass.getSimpleName());
        localStringBuilder.append(" must have default constructor in order to be automatically recreated");
        throw new IllegalArgumentException(localStringBuilder.toString(), localNoSuchMethodException);
      }
    }
    throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
  }
}

/* Location:
 * Qualified Name:     base.d.v.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */