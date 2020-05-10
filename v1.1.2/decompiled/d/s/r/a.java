package d.s.r;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.R.styleable;
import d.m.a.e0;
import d.m.a.l;
import d.m.a.p.f;
import d.m.a.x;
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
  extends d.s.p<a>
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
    return new a(this);
  }
  
  public i a(i parami, Bundle paramBundle, d.s.n paramn, p.a parama)
  {
    a locala = (a)parami;
    if (b.i())
    {
      Log.i("FragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
    }
    else
    {
      Object localObject = F;
      if (localObject == null) {
        break label818;
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
        break label816;
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
      int m;
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
      parami.a(c, (Fragment)localObject);
      parami.b((Fragment)localObject);
      int k = z;
      boolean bool = d.isEmpty();
      if ((paramn != null) && (!bool) && (a) && (((Integer)d.peekLast()).intValue() == k)) {
        i = 1;
      } else {
        i = 0;
      }
      if (!bool)
      {
        if (i != 0)
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
          i = 0;
        }
        else
        {
          paramBundle = a(d.size() + 1, k);
          if (!h) {
            break label806;
          }
          g = true;
          i = paramBundle;
        }
      }
      else {
        i = 1;
      }
      if ((parama instanceof b))
      {
        if ((b)parama != null)
        {
          paramBundle = Collections.unmodifiableMap(null).entrySet().iterator();
          for (;;)
          {
            if (!paramBundle.hasNext()) {
              break label768;
            }
            parama = (Map.Entry)paramBundle.next();
            paramn = (View)parama.getKey();
            parama = (String)parama.getValue();
            if ((e0.b == null) && (e0.c == null)) {
              j = 0;
            } else {
              j = 1;
            }
            if (j != 0)
            {
              paramn = d.i.i.n.n(paramn);
              if (paramn == null) {
                break label755;
              }
              if (n == null)
              {
                n = new ArrayList();
                o = new ArrayList();
              }
              else
              {
                if (o.contains(parama)) {
                  break label737;
                }
                if (n.contains(paramn)) {
                  break;
                }
              }
              n.add(paramn);
              o.add(parama);
            }
          }
          throw new IllegalArgumentException(e.a.a.a.a.a("A shared element with the source name '", paramn, "' has already been added to the transaction."));
          label737:
          throw new IllegalArgumentException(e.a.a.a.a.a("A shared element with the target name '", parama, "' has already been added to the transaction."));
          label755:
          throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
        }
        throw null;
      }
      label768:
      p = true;
      parami.a();
      if (i != 0)
      {
        d.add(Integer.valueOf(k));
        parami = locala;
        break label804;
      }
    }
    parami = null;
    label804:
    return parami;
    label806:
    throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    label816:
    throw null;
    label818:
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
  
  public static class a
    extends i
  {
    public String F;
    
    public a(d.s.p<? extends a> paramp)
    {
      super();
    }
    
    public void a(Context paramContext, AttributeSet paramAttributeSet)
    {
      super.a(paramContext, paramAttributeSet);
      paramContext = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.FragmentNavigator);
      paramAttributeSet = paramContext.getString(R.styleable.FragmentNavigator_android_name);
      if (paramAttributeSet != null) {
        F = paramAttributeSet;
      }
      paramContext.recycle();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(super.toString());
      localStringBuilder.append(" class=");
      String str = F;
      if (str == null) {
        localStringBuilder.append("null");
      } else {
        localStringBuilder.append(str);
      }
      return localStringBuilder.toString();
    }
  }
  
  public static final class b
    implements p.a
  {}
}

/* Location:
 * Qualified Name:     d.s.r.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */