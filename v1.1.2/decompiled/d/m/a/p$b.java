package d.m.a;

import androidx.fragment.app.Fragment;
import d.i.e.a;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

public class p$b
  implements e0.a
{
  public p$b(p paramp) {}
  
  public void a(Fragment paramFragment, a parama)
  {
    if (!parama.b())
    {
      p localp = a;
      HashSet localHashSet = (HashSet)j.get(paramFragment);
      if ((localHashSet != null) && (localHashSet.remove(parama)) && (localHashSet.isEmpty()))
      {
        j.remove(paramFragment);
        if (mState < 3)
        {
          localp.e(paramFragment);
          localp.a(paramFragment, paramFragment.getStateAfterAnimating());
        }
      }
    }
  }
  
  public void b(Fragment paramFragment, a parama)
  {
    p localp = a;
    if (j.get(paramFragment) == null) {
      j.put(paramFragment, new HashSet());
    }
    ((HashSet)j.get(paramFragment)).add(parama);
  }
}

/* Location:
 * Qualified Name:     d.m.a.p.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */