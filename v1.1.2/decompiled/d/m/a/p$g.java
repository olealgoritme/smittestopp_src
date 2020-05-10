package d.m.a;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment.f;
import java.util.Iterator;
import java.util.List;

public class p$g
  implements Fragment.f
{
  public final boolean a;
  public final a b;
  public int c;
  
  public p$g(a parama, boolean paramBoolean)
  {
    a = paramBoolean;
    b = parama;
  }
  
  public void a()
  {
    int i;
    if (c > 0) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject = b.r.c.c().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Fragment localFragment = (Fragment)((Iterator)localObject).next();
      localFragment.setOnStartEnterTransitionListener(null);
      if ((i != 0) && (localFragment.isPostponed())) {
        localFragment.startPostponedEnterTransition();
      }
    }
    localObject = b;
    r.a((a)localObject, a, i ^ 0x1, true);
  }
}

/* Location:
 * Qualified Name:     d.m.a.p.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */