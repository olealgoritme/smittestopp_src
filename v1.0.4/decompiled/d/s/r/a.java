package d.s.r;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import d.m.a.f0;
import d.m.a.l;
import d.m.a.p.f;
import d.m.a.y;
import d.s.i;
import d.s.p.a;
import d.s.p.b;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@p.b("fragment")
public class a
  extends d.s.p<a.a>
{
  public final Context a;
  public final d.m.a.p b;
  public final int c;
  public ArrayDeque<Integer> d = new ArrayDeque();
  
  public a(Context paramContext, d.m.a.p paramp, int paramInt)
  {
    a = paramContext;
    b = paramp;
    c = paramInt;
  }
  
  public i a()
  {
    return new a.a(this);
  }
  
  public i a(i parami, Bundle paramBundle, d.s.n paramn, p.a parama)
  {
    a.a locala = (a.a)parami;
    if (b.i())
    {
      Log.i("FragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
    }
    else
    {
      Object localObject = F;
      if (localObject == null) {
        break label839;
      }
      parami = (i)localObject;
      if (((String)localObject).charAt(0) == '.')
      {
        parami = new StringBuilder();
        parami.append(a.getPackageName());
        parami.append((String)localObject);
        parami = parami.toString();
      }
      localObject = a;
      localObject = b.h().a(((Context)localObject).getClassLoader(), parami);
      ((Fragment)localObject).setArguments(paramBundle);
      parami = b;
      if (parami == null) {
        break label837;
      }
      parami = new d.m.a.a(parami);
      int i;
      if (paramn != null) {
        i = d;
      } else {
        i = -1;
      }
      int j;
      if (paramn != null) {
        j = e;
      } else {
        j = -1;
      }
      if (paramn != null) {
        k = f;
      } else {
        k = -1;
      }
      if (paramn != null) {
        m = g;
      } else {
        m = -1;
      }
      if ((i != -1) || (j != -1) || (k != -1) || (m != -1))
      {
        if (i == -1) {
          i = 0;
        }
        if (j == -1) {
          j = 0;
        }
        if (k == -1) {
          k = 0;
        }
        if (m == -1) {
          m = 0;
        }
        b = i;
        c = j;
        d = k;
        e = m;
      }
      int m = c;
      if (m == 0) {
        break label826;
      }
      parami.a(m, (Fragment)localObject, null, 2);
      parami.b((Fragment)localObject);
      int k = z;
      boolean bool = d.isEmpty();
      if ((paramn != null) && (!bool) && (a) && (((Integer)d.peekLast()).intValue() == k)) {
        m = 1;
      } else {
        m = 0;
      }
      if (!bool)
      {
        if (m != 0)
        {
          if (d.size() > 1)
          {
            paramn = b;
            paramBundle = a(d.size(), ((Integer)d.peekLast()).intValue());
            if (paramn != null)
            {
              paramn.a(new p.f(paramn, paramBundle, -1, 1), false);
              paramBundle = a(d.size(), k);
              if (h)
              {
                g = true;
                i = paramBundle;
              }
              else
              {
                throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
              }
            }
            else
            {
              throw null;
            }
          }
          m = 0;
        }
        else
        {
          paramBundle = a(d.size() + 1, k);
          if (!h) {
            break label816;
          }
          g = true;
          i = paramBundle;
        }
      }
      else {
        m = 1;
      }
      if ((parama instanceof a.b))
      {
        if ((a.b)parama != null)
        {
          paramBundle = Collections.unmodifiableMap(null).entrySet().iterator();
          for (;;)
          {
            if (!paramBundle.hasNext()) {
              break label778;
            }
            paramn = (Map.Entry)paramBundle.next();
            parama = (View)paramn.getKey();
            paramn = (String)paramn.getValue();
            if ((f0.b == null) && (f0.c == null)) {
              i = 0;
            } else {
              i = 1;
            }
            if (i != 0)
            {
              parama = d.i.i.n.n(parama);
              if (parama == null) {
                break label765;
              }
              if (n == null)
              {
                n = new ArrayList();
                o = new ArrayList();
              }
              else
              {
                if (o.contains(paramn)) {
                  break label748;
                }
                if (n.contains(parama)) {
                  break;
                }
              }
              n.add(parama);
              o.add(paramn);
            }
          }
          throw new IllegalArgumentException(e.a.a.a.a.a("A shared element with the source name '", parama, "' has already been added to the transaction."));
          label748:
          throw new IllegalArgumentException(e.a.a.a.a.a("A shared element with the target name '", paramn, "' has already been added to the transaction."));
          label765:
          throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
        }
        throw null;
      }
      label778:
      p = true;
      parami.a();
      if (m != 0)
      {
        d.add(Integer.valueOf(k));
        parami = locala;
        break label814;
      }
    }
    parami = null;
    label814:
    return parami;
    label816:
    throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    label826:
    throw new IllegalArgumentException("Must use non-zero containerViewId");
    label837:
    throw null;
    label839:
    throw new IllegalStateException("Fragment class was not set");
  }
  
  public final String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt2);
    return localStringBuilder.toString();
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getIntArray("androidx-nav-fragment:navigator:backStackIds");
      if (paramBundle != null)
      {
        d.clear();
        int i = paramBundle.length;
        for (int j = 0; j < i; j++)
        {
          int k = paramBundle[j];
          d.add(Integer.valueOf(k));
        }
      }
    }
  }
  
  public Bundle b()
  {
    Bundle localBundle = new Bundle();
    int[] arrayOfInt = new int[d.size()];
    Iterator localIterator = d.iterator();
    for (int i = 0; localIterator.hasNext(); i++) {
      arrayOfInt[i] = ((Integer)localIterator.next()).intValue();
    }
    localBundle.putIntArray("androidx-nav-fragment:navigator:backStackIds", arrayOfInt);
    return localBundle;
  }
  
  public boolean c()
  {
    if (d.isEmpty()) {
      return false;
    }
    if (b.i())
    {
      Log.i("FragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
      return false;
    }
    d.m.a.p localp = b;
    String str = a(d.size(), ((Integer)d.peekLast()).intValue());
    if (localp != null)
    {
      localp.a(new p.f(localp, str, -1, 1), false);
      d.removeLast();
      return true;
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.d.s.r.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */