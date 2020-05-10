package e.c.a.a.b.j;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import d.b.a.s;
import java.util.Arrays;

public abstract class i
{
  public static final Object a = new Object();
  public static i b;
  
  public static i a(Context paramContext)
  {
    synchronized (a)
    {
      if (b == null)
      {
        c0 localc0 = new e/c/a/a/b/j/c0;
        localc0.<init>(paramContext.getApplicationContext());
        b = localc0;
      }
      return b;
    }
  }
  
  public abstract boolean a(a parama, ServiceConnection paramServiceConnection, String paramString);
  
  public abstract void b(a parama, ServiceConnection paramServiceConnection, String paramString);
  
  public static final class a
  {
    public final String a;
    public final String b;
    public final ComponentName c;
    public final int d;
    
    public a(String paramString1, String paramString2, int paramInt)
    {
      s.a(paramString1);
      a = paramString1;
      s.a(paramString2);
      b = paramString2;
      c = null;
      d = paramInt;
    }
    
    public final Intent a()
    {
      Intent localIntent;
      if (a != null) {
        localIntent = new Intent(a).setPackage(b);
      } else {
        localIntent = new Intent().setComponent(c);
      }
      return localIntent;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      return (s.c(a, a)) && (s.c(b, b)) && (s.c(c, c)) && (d == d);
    }
    
    public final int hashCode()
    {
      return Arrays.hashCode(new Object[] { a, b, c, Integer.valueOf(d) });
    }
    
    public final String toString()
    {
      String str1 = a;
      String str2 = str1;
      if (str1 == null) {
        str2 = c.flattenToString();
      }
      return str2;
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.j.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */