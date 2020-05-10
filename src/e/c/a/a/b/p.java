package e.c.a.a.b;

import android.content.Context;
import android.util.Log;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
public final class p
{
  public static Context a;
  
  public static void a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        if (paramContext != null) {
          a = paramContext.getApplicationContext();
        }
      }
      else {
        Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
      }
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */