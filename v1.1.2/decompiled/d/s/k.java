package d.s;

import android.os.Bundle;
import e.a.a.a.a;

@p.b("navigation")
public class k
  extends p<j>
{
  public final q a;
  
  public k(q paramq)
  {
    a = paramq;
  }
  
  public i a()
  {
    return new j(this);
  }
  
  public i a(i parami, Bundle paramBundle, n paramn, p.a parama)
  {
    parami = (j)parami;
    int i = G;
    if (i == 0)
    {
      paramBundle = a.a("no start destination defined via app:startDestination for ");
      i = z;
      if (i != 0)
      {
        if (A == null) {
          A = Integer.toString(i);
        }
        parami = A;
      }
      else
      {
        parami = "the root navigation";
      }
      paramBundle.append(parami);
      throw new IllegalStateException(paramBundle.toString());
    }
    i locali = parami.a(i, false);
    if (locali == null)
    {
      if (H == null) {
        H = Integer.toString(G);
      }
      throw new IllegalArgumentException(a.a("navigation destination ", H, " is not a direct child of this NavGraph"));
    }
    return a.a(x).a(locali, locali.a(paramBundle), paramn, parama);
  }
  
  public boolean c()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     d.s.k
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */