package d.m.a;

import android.content.Context;
import androidx.fragment.app.Fragment;

public class p$c
  extends l
{
  public p$c(p paramp) {}
  
  public Fragment a(ClassLoader paramClassLoader, String paramString)
  {
    paramClassLoader = b.n;
    Context localContext = y;
    if (paramClassLoader != null) {
      return Fragment.instantiate(localContext, paramString, null);
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.d.m.a.p.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */