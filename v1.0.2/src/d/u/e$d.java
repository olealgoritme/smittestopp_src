package d.u;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class e$d
{
  public final int[] a;
  public final String[] b;
  public final e.c c;
  public final Set<String> d;
  
  public e$d(e.c paramc, int[] paramArrayOfInt, String[] paramArrayOfString)
  {
    c = paramc;
    a = paramArrayOfInt;
    b = paramArrayOfString;
    if (paramArrayOfInt.length == 1)
    {
      paramc = new HashSet();
      paramc.add(b[0]);
      d = Collections.unmodifiableSet(paramc);
    }
    else
    {
      d = null;
    }
  }
}

/* Location:
 * Qualified Name:     base.d.u.e.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */