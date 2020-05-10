package d.s;

import android.os.Bundle;

public class i$a
  implements Comparable<a>
{
  public final i x;
  public final Bundle y;
  public final boolean z;
  
  public i$a(i parami, Bundle paramBundle, boolean paramBoolean)
  {
    x = parami;
    y = paramBundle;
    z = paramBoolean;
  }
  
  public int a(a parama)
  {
    if ((z) && (!z)) {
      return 1;
    }
    if ((!z) && (z)) {
      return -1;
    }
    return y.size() - y.size();
  }
}

/* Location:
 * Qualified Name:     d.s.i.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */