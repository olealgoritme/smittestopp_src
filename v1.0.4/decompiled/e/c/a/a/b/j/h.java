package e.c.a.a.b.j;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import e.c.a.a.b.e;
import e.c.a.a.b.i.a.f;
import e.c.a.a.b.i.d.a;
import e.c.a.a.b.i.d.b;
import java.util.Iterator;
import java.util.Set;

public abstract class h<T extends IInterface>
  extends b<T>
  implements a.f, Object
{
  public final Set<Scope> v;
  public final Account w;
  
  public h(Context paramContext, Looper paramLooper, int paramInt, d paramd, d.a parama, d.b paramb)
  {
    super(paramContext, paramLooper, locali, locald, paramInt, parama, paramb, f);
    w = a;
    paramLooper = c;
    paramContext = paramLooper.iterator();
    while (paramContext.hasNext()) {
      if (!paramLooper.contains((Scope)paramContext.next())) {
        throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
      }
    }
    v = paramLooper;
  }
  
  public int i()
  {
    return e.a;
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.j.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */