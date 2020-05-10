package j.b.a.b0;

import android.app.Application;
import j.a.a.a.a.a.k;
import java.util.List;
import l.a.a.b;

public final class g
{
  public final j.a.a.a.a.a.h a;
  public final j.a.a.a.a.a.h b;
  public final List<j.a.a.a.a.a.h> c;
  public final k d;
  public final j e;
  public final j.a.a.a.a.a.a f;
  
  public g(Application paramApplication, h paramh, j.a.a.a.a.a.a parama) {}
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      f.a(c, d, e);
    }
    catch (Exception localException)
    {
      l.a.a.d.a(localException);
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
 * Qualified Name:     base.j.b.a.b0.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */