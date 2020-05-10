package e.c.a.a.b.j;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import d.f.c;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class d
{
  public final Account a;
  public final Set<Scope> b;
  public final Set<Scope> c;
  public final Map<e.c.a.a.b.i.a<?>, b> d;
  public final String e;
  public final String f;
  public final e.c.a.a.f.a g;
  public Integer h;
  
  public d(Account paramAccount, Set<Scope> paramSet, Map<e.c.a.a.b.i.a<?>, b> paramMap, int paramInt, View paramView, String paramString1, String paramString2, e.c.a.a.f.a parama, boolean paramBoolean)
  {
    a = paramAccount;
    if (paramSet == null) {
      paramAccount = Collections.EMPTY_SET;
    } else {
      paramAccount = Collections.unmodifiableSet(paramSet);
    }
    b = paramAccount;
    paramAccount = paramMap;
    if (paramMap == null) {
      paramAccount = Collections.EMPTY_MAP;
    }
    d = paramAccount;
    e = paramString1;
    f = paramString2;
    g = parama;
    paramSet = new HashSet(b);
    paramAccount = d.values().iterator();
    while (paramAccount.hasNext()) {
      paramSet.addAll(nexta);
    }
    c = Collections.unmodifiableSet(paramSet);
  }
  
  public static final class a
  {
    public Account a;
    public c<Scope> b;
    public int c = 0;
    public String d;
    public String e;
    public e.c.a.a.f.a f = e.c.a.a.f.a.i;
    
    public final d a()
    {
      return new d(a, b, null, c, null, d, e, f, false);
    }
  }
  
  public static final class b
  {
    public final Set<Scope> a;
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.j.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */