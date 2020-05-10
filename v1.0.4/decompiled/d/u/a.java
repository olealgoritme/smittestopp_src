package d.u;

import android.content.Context;
import d.w.a.c.c;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public class a
{
  public final c.c a;
  public final Context b;
  public final String c;
  public final g.d d;
  public final List<g.b> e;
  public final boolean f;
  public final g.c g;
  public final Executor h;
  public final Executor i;
  public final boolean j;
  public final boolean k;
  public final boolean l;
  public final Set<Integer> m;
  
  public a(Context paramContext, String paramString1, c.c paramc, g.d paramd, List<g.b> paramList, boolean paramBoolean1, g.c paramc1, Executor paramExecutor1, Executor paramExecutor2, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, Set<Integer> paramSet, String paramString2, File paramFile)
  {
    a = paramc;
    b = paramContext;
    c = paramString1;
    d = paramd;
    e = paramList;
    f = paramBoolean1;
    g = paramc1;
    h = paramExecutor1;
    i = paramExecutor2;
    j = paramBoolean2;
    k = paramBoolean3;
    l = paramBoolean4;
    m = paramSet;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    boolean bool1 = true;
    if (paramInt1 > paramInt2) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    if ((paramInt2 != 0) && (l)) {
      return false;
    }
    if (k)
    {
      Set localSet = m;
      bool2 = bool1;
      if (localSet == null) {
        break label71;
      }
      if (!localSet.contains(Integer.valueOf(paramInt1)))
      {
        bool2 = bool1;
        break label71;
      }
    }
    boolean bool2 = false;
    label71:
    return bool2;
  }
}

/* Location:
 * Qualified Name:     base.d.u.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */