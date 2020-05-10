package k.d.a.r;

import android.util.Log;
import java.util.logging.Level;
import k.d.a.g;

public class a
  implements g
{
  public static final boolean b;
  public final String a;
  
  static
  {
    boolean bool;
    try
    {
      Class.forName("android.util.Log");
      bool = true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      bool = false;
    }
    b = bool;
  }
  
  public a(String paramString)
  {
    a = paramString;
  }
  
  public final int a(Level paramLevel)
  {
    int i = paramLevel.intValue();
    if (i < 800)
    {
      if (i < 500) {
        return 2;
      }
      return 3;
    }
    if (i < 900) {
      return 4;
    }
    if (i < 1000) {
      return 5;
    }
    return 6;
  }
  
  public void a(Level paramLevel, String paramString)
  {
    if (paramLevel != Level.OFF) {
      Log.println(a(paramLevel), a, paramString);
    }
  }
  
  public void a(Level paramLevel, String paramString, Throwable paramThrowable)
  {
    if (paramLevel != Level.OFF)
    {
      int i = a(paramLevel);
      paramLevel = a;
      paramString = e.a.a.a.a.a(paramString, "\n");
      paramString.append(Log.getStackTraceString(paramThrowable));
      Log.println(i, paramLevel, paramString.toString());
    }
  }
}

/* Location:
 * Qualified Name:     base.k.d.a.r.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */