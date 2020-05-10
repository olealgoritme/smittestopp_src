package k.b.a.u;

import android.app.Application;
import java.util.List;
import k.a.a.a.a.a.k;
import m.a.a.b;

public final class g
{
  public final k.a.a.a.a.a.h a;
  public final k.a.a.a.a.a.h b;
  public final List<k.a.a.a.a.a.h> c;
  public final k d;
  public final j e;
  public final k.a.a.a.a.a.a f;
  
  public g(Application paramApplication, h paramh, k.a.a.a.a.a.a parama) {}
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      f.a(c, d, e);
    }
    catch (Exception localException)
    {
      m.a.a.d.b(localException);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      f.b(e);
      if (!paramBoolean) {
        a(true);
      }
    }
  }
}

/* Location:
 * Qualified Name:     k.b.a.u.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */