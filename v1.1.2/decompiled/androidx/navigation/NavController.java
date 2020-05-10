package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import d.o.e0;
import d.o.g.a;
import d.o.g.b;
import d.o.l;
import d.s.c;
import d.s.e;
import d.s.f;
import d.s.g;
import d.s.i;
import d.s.i.a;
import d.s.m;
import d.s.n;
import d.s.p;
import d.s.p.a;
import d.s.q;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class NavController
{
  public final Context a;
  public Activity b;
  public m c;
  public d.s.j d;
  public Bundle e;
  public Parcelable[] f;
  public boolean g;
  public final Deque<e> h = new ArrayDeque();
  public l i;
  public g j;
  public final q k = new q();
  public final CopyOnWriteArrayList<b> l = new CopyOnWriteArrayList();
  public final d.o.k m = new d.o.j()
  {
    public void a(l paramAnonymousl, g.a paramAnonymousa)
    {
      paramAnonymousl = NavController.this;
      if (d != null)
      {
        Iterator localIterator = h.iterator();
        while (localIterator.hasNext())
        {
          e locale = (e)localIterator.next();
          if (locale != null)
          {
            int i = paramAnonymousa.ordinal();
            if (i != 0)
            {
              if (i != 1) {
                if (i != 2)
                {
                  if (i != 3)
                  {
                    if (i == 4) {
                      break label142;
                    }
                    if (i == 5)
                    {
                      paramAnonymousl = g.b.DESTROYED;
                      break label146;
                    }
                    paramAnonymousl = new StringBuilder();
                    paramAnonymousl.append("Unexpected event value ");
                    paramAnonymousl.append(paramAnonymousa);
                    throw new IllegalArgumentException(paramAnonymousl.toString());
                  }
                }
                else
                {
                  paramAnonymousl = g.b.RESUMED;
                  break label146;
                }
              }
              paramAnonymousl = g.b.STARTED;
              break label146;
            }
            label142:
            paramAnonymousl = g.b.CREATED;
            label146:
            C = paramAnonymousl;
            locale.a();
          }
          else
          {
            throw null;
          }
        }
      }
    }
  };
  public final d.a.b n = new a(false);
  public boolean o = true;
  
  public NavController(Context paramContext)
  {
    a = paramContext;
    while ((paramContext instanceof ContextWrapper))
    {
      if ((paramContext instanceof Activity))
      {
        b = ((Activity)paramContext);
        break;
      }
      paramContext = ((ContextWrapper)paramContext).getBaseContext();
    }
    paramContext = k;
    paramContext.a(new d.s.k(paramContext));
    k.a(new d.s.a(a));
  }
  
  public i a(int paramInt)
  {
    Object localObject = d;
    if (localObject == null) {
      return null;
    }
    if (z == paramInt) {
      return (i)localObject;
    }
    if (h.isEmpty()) {
      localObject = d;
    } else {
      localObject = h.getLast()).x;
    }
    if ((localObject instanceof d.s.j)) {
      localObject = (d.s.j)localObject;
    } else {
      localObject = y;
    }
    return ((d.s.j)localObject).a(paramInt, true);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (c == null) {
      c = new m(a, k);
    }
    Object localObject1 = c.a(paramInt);
    Object localObject2 = d;
    int i1 = 1;
    if (localObject2 != null) {
      a(z, true);
    }
    d = ((d.s.j)localObject1);
    localObject1 = e;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject1 = ((Bundle)localObject1).getStringArrayList("android-support-nav:controller:navigatorState:names");
      if (localObject1 != null)
      {
        localObject2 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject1 = k.a((String)localObject3);
          localObject3 = e.getBundle((String)localObject3);
          if (localObject3 != null) {
            ((p)localObject1).a((Bundle)localObject3);
          }
        }
      }
    }
    localObject2 = f;
    int i2;
    Bundle localBundle;
    if (localObject2 != null)
    {
      i2 = localObject2.length;
      paramInt = 0;
      while (paramInt < i2)
      {
        localObject1 = (f)localObject2[paramInt];
        localObject3 = a(y);
        if (localObject3 != null)
        {
          localBundle = z;
          if (localBundle != null) {
            localBundle.setClassLoader(a.getClassLoader());
          }
          localObject1 = new e(a, (i)localObject3, localBundle, i, j, x, A);
          h.add(localObject1);
          paramInt++;
        }
        else
        {
          paramBundle = e.a.a.a.a.a("unknown destination during restore: ");
          paramBundle.append(a.getResources().getResourceName(y));
          throw new IllegalStateException(paramBundle.toString());
        }
      }
      c();
      f = null;
    }
    if ((d != null) && (h.isEmpty()))
    {
      if (!g)
      {
        localObject1 = b;
        if (localObject1 != null)
        {
          Intent localIntent = ((Activity)localObject1).getIntent();
          if (localIntent != null)
          {
            localObject2 = localIntent.getExtras();
            if (localObject2 != null) {
              localObject1 = ((Bundle)localObject2).getIntArray("android-support-nav:controller:deepLinkIds");
            } else {
              localObject1 = null;
            }
            localBundle = new Bundle();
            if (localObject2 != null) {
              localObject2 = ((Bundle)localObject2).getBundle("android-support-nav:controller:deepLinkExtras");
            } else {
              localObject2 = null;
            }
            if (localObject2 != null) {
              localBundle.putAll((Bundle)localObject2);
            }
            if (localObject1 != null)
            {
              localObject2 = localObject1;
              if (localObject1.length != 0) {}
            }
            else
            {
              localObject2 = localObject1;
              if (localIntent.getData() != null)
              {
                localObject3 = d.a(localIntent.getData());
                localObject2 = localObject1;
                if (localObject3 != null)
                {
                  localObject1 = x;
                  if (localObject1 != null)
                  {
                    ArrayDeque localArrayDeque = new ArrayDeque();
                    for (;;)
                    {
                      localObject2 = y;
                      if ((localObject2 == null) || (G != z)) {
                        localArrayDeque.addFirst(localObject1);
                      }
                      if (localObject2 == null)
                      {
                        localObject2 = new int[localArrayDeque.size()];
                        localObject1 = localArrayDeque.iterator();
                        for (paramInt = 0; ((Iterator)localObject1).hasNext(); paramInt++) {
                          localObject2[paramInt] = nextz;
                        }
                        localBundle.putAll(y);
                        break;
                      }
                      localObject1 = localObject2;
                    }
                  }
                  throw null;
                }
              }
            }
            if ((localObject2 != null) && (localObject2.length != 0))
            {
              localObject1 = d;
              for (paramInt = 0; paramInt < localObject2.length; paramInt++)
              {
                i2 = localObject2[paramInt];
                if (paramInt == 0) {
                  localObject3 = d;
                } else {
                  localObject3 = ((d.s.j)localObject1).b(i2);
                }
                if (localObject3 == null)
                {
                  localObject1 = i.a(a, i2);
                  break label722;
                }
                if (paramInt != localObject2.length - 1) {
                  for (localObject1 = (d.s.j)localObject3; (((d.s.j)localObject1).b(G) instanceof d.s.j); localObject1 = (d.s.j)((d.s.j)localObject1).b(G)) {}
                }
              }
              localObject1 = null;
              label722:
              if (localObject1 != null)
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("Could not find destination ");
                ((StringBuilder)localObject2).append((String)localObject1);
                ((StringBuilder)localObject2).append(" in the navigation graph, ignoring the deep link from ");
                ((StringBuilder)localObject2).append(localIntent);
                Log.i("NavController", ((StringBuilder)localObject2).toString());
              }
              else
              {
                localBundle.putParcelable("android-support-nav:controller:deepLinkIntent", localIntent);
                paramInt = localIntent.getFlags();
                i2 = 0x10000000 & paramInt;
                if ((i2 != 0) && ((paramInt & 0x8000) == 0))
                {
                  localIntent.addFlags(32768);
                  localObject3 = new d.i.a.j(a);
                  localObject2 = localIntent.getComponent();
                  localObject1 = localObject2;
                  if (localObject2 == null) {
                    localObject1 = localIntent.resolveActivity(y.getPackageManager());
                  }
                  if (localObject1 != null) {
                    ((d.i.a.j)localObject3).a((ComponentName)localObject1);
                  }
                  x.add(localIntent);
                  ((d.i.a.j)localObject3).a();
                  localObject1 = b;
                  if (localObject1 != null)
                  {
                    ((Activity)localObject1).finish();
                    b.overridePendingTransition(0, 0);
                  }
                }
                else
                {
                  if (i2 != 0)
                  {
                    if (!h.isEmpty()) {
                      a(d.z, true);
                    }
                    for (paramInt = 0;; paramInt++)
                    {
                      if (paramInt >= localObject2.length) {
                        break label1210;
                      }
                      i2 = localObject2[paramInt];
                      localObject1 = a(i2);
                      if (localObject1 == null) {
                        break;
                      }
                      a((i)localObject1, localBundle, new n(false, -1, false, 0, 0, -1, -1), null);
                    }
                    paramBundle = e.a.a.a.a.a("unknown destination during deep link: ");
                    paramBundle.append(i.a(a, i2));
                    throw new IllegalStateException(paramBundle.toString());
                  }
                  localObject1 = d;
                  paramInt = 0;
                  while (paramInt < localObject2.length)
                  {
                    i2 = localObject2[paramInt];
                    if (paramInt == 0) {
                      localObject3 = d;
                    } else {
                      localObject3 = ((d.s.j)localObject1).b(i2);
                    }
                    if (localObject3 != null)
                    {
                      if (paramInt != localObject2.length - 1) {
                        for (localObject1 = (d.s.j)localObject3; (((d.s.j)localObject1).b(G) instanceof d.s.j); localObject1 = (d.s.j)((d.s.j)localObject1).b(G)) {}
                      } else {
                        a((i)localObject3, ((i)localObject3).a(localBundle), new n(false, d.z, true, 0, 0, -1, -1), null);
                      }
                      paramInt++;
                    }
                    else
                    {
                      paramBundle = e.a.a.a.a.a("unknown destination during deep link: ");
                      paramBundle.append(i.a(a, i2));
                      throw new IllegalStateException(paramBundle.toString());
                    }
                  }
                  g = true;
                }
                label1210:
                paramInt = 1;
                break label1217;
              }
            }
          }
          paramInt = 0;
          label1217:
          if (paramInt != 0)
          {
            paramInt = i1;
            break label1229;
          }
        }
      }
      paramInt = 0;
      label1229:
      if (paramInt == 0) {
        a(d, paramBundle, null, null);
      }
    }
  }
  
  public void a(int paramInt, Bundle paramBundle, n paramn)
  {
    Object localObject1;
    if (h.isEmpty()) {
      localObject1 = d;
    } else {
      localObject1 = h.getLast()).x;
    }
    if (localObject1 != null)
    {
      c localc = ((i)localObject1).a(paramInt);
      int i1;
      int i2;
      if (localc != null)
      {
        localObject1 = paramn;
        if (paramn == null) {
          localObject1 = b;
        }
        i1 = a;
        localObject2 = c;
        i2 = i1;
        paramn = (n)localObject1;
        if (localObject2 != null)
        {
          paramn = new Bundle();
          paramn.putAll((Bundle)localObject2);
          i2 = i1;
          localObject2 = localObject1;
          break label133;
        }
      }
      else
      {
        i2 = paramInt;
      }
      localObject1 = null;
      Object localObject2 = paramn;
      paramn = (n)localObject1;
      label133:
      localObject1 = paramn;
      if (paramBundle != null)
      {
        localObject1 = paramn;
        if (paramn == null) {
          localObject1 = new Bundle();
        }
        ((Bundle)localObject1).putAll(paramBundle);
      }
      if ((i2 == 0) && (localObject2 != null))
      {
        i1 = b;
        if (i1 != -1)
        {
          if (!a(i1, c)) {
            break label302;
          }
          a();
          break label302;
        }
      }
      if (i2 != 0)
      {
        paramBundle = a(i2);
        if (paramBundle == null)
        {
          paramn = e.a.a.a.a.a("navigation destination ", i.a(a, i2));
          if (localc != null)
          {
            paramBundle = e.a.a.a.a.a(" referenced from action ");
            paramBundle.append(i.a(a, paramInt));
            paramBundle = paramBundle.toString();
          }
          else
          {
            paramBundle = "";
          }
          throw new IllegalArgumentException(e.a.a.a.a.a(paramn, paramBundle, " is unknown to this NavController"));
        }
        a(paramBundle, (Bundle)localObject1, (n)localObject2, null);
        label302:
        return;
      }
      throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
    }
    throw new IllegalStateException("no current navigation node");
  }
  
  public void a(b paramb)
  {
    if (!h.isEmpty())
    {
      e locale = (e)h.peekLast();
      paramb.a(this, x, y);
    }
    l.add(paramb);
  }
  
  public final void a(i parami, Bundle paramBundle, n paramn, p.a parama)
  {
    if (paramn != null)
    {
      int i1 = b;
      if (i1 != -1)
      {
        bool = a(i1, c);
        break label34;
      }
    }
    boolean bool = false;
    label34:
    p localp = k.a(x);
    Bundle localBundle = parami.a(paramBundle);
    paramBundle = localp.a(parami, localBundle, paramn, parama);
    while ((!(paramBundle instanceof d.s.b)) && (!h.isEmpty()) && ((h.peekLast()).x instanceof d.s.b)) && (a(h.peekLast()).x.z, true))) {}
    if (h.isEmpty())
    {
      parami = new e(a, d, localBundle, i, j);
      h.add(parami);
    }
    parama = new ArrayDeque();
    parami = paramBundle;
    while ((parami != null) && (a(z) == null))
    {
      paramn = y;
      parami = paramn;
      if (paramn != null)
      {
        parama.addFirst(new e(a, paramn, localBundle, i, j));
        parami = paramn;
      }
    }
    h.addAll(parama);
    parami = new e(a, paramBundle, paramBundle.a(localBundle), i, j);
    h.add(parami);
    c();
    if ((bool) || (paramBundle != null)) {
      a();
    }
  }
  
  public final boolean a()
  {
    while ((!h.isEmpty()) && ((h.peekLast()).x instanceof d.s.j)) && (a(h.peekLast()).x.z, true))) {}
    if (!h.isEmpty())
    {
      Object localObject1 = h.peekLast()).x;
      HashMap localHashMap = null;
      Object localObject2 = localHashMap;
      if ((localObject1 instanceof d.s.b))
      {
        localObject3 = h.descendingIterator();
        do
        {
          localObject2 = localHashMap;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject2 = nextx;
        } while (((localObject2 instanceof d.s.j)) || ((localObject2 instanceof d.s.b)));
      }
      localHashMap = new HashMap();
      Object localObject3 = h.descendingIterator();
      while (((Iterator)localObject3).hasNext())
      {
        e locale = (e)((Iterator)localObject3).next();
        g.b localb = D;
        Object localObject4 = x;
        if ((localObject1 != null) && (z == z))
        {
          localObject4 = g.b.RESUMED;
          if (localb != localObject4) {
            localHashMap.put(locale, localObject4);
          }
          localObject1 = y;
        }
        else if ((localObject2 != null) && (z == z))
        {
          if (localb == g.b.RESUMED)
          {
            D = g.b.STARTED;
            locale.a();
          }
          else
          {
            localObject4 = g.b.STARTED;
            if (localb != localObject4) {
              localHashMap.put(locale, localObject4);
            }
          }
          localObject2 = y;
        }
        else
        {
          D = g.b.CREATED;
          locale.a();
        }
      }
      localObject2 = h.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (e)((Iterator)localObject2).next();
        localObject3 = (g.b)localHashMap.get(localObject1);
        if (localObject3 != null)
        {
          D = ((g.b)localObject3);
          ((e)localObject1).a();
        }
      }
      localObject2 = (e)h.peekLast();
      localObject1 = l.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((b)((Iterator)localObject1).next()).a(this, x, y);
      }
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt, boolean paramBoolean)
  {
    boolean bool1 = h.isEmpty();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = h.descendingIterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = nextx;
      localObject3 = k.a(x);
      if ((paramBoolean) || (z != paramInt)) {
        localArrayList.add(localObject3);
      }
      if (z == paramInt)
      {
        i1 = 1;
        break label117;
      }
    }
    int i1 = 0;
    label117:
    if (i1 == 0)
    {
      localObject3 = i.a(a, paramInt);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Ignoring popBackStack to destination ");
      ((StringBuilder)localObject2).append((String)localObject3);
      ((StringBuilder)localObject2).append(" as it was not found on the current back stack");
      Log.i("NavController", ((StringBuilder)localObject2).toString());
      return false;
    }
    Object localObject2 = localArrayList.iterator();
    for (paramBoolean = bool2; (((Iterator)localObject2).hasNext()) && (((p)((Iterator)localObject2).next()).c()); paramBoolean = true)
    {
      localObject1 = (e)h.removeLast();
      D = g.b.DESTROYED;
      ((e)localObject1).a();
      localObject3 = j;
      if (localObject3 != null)
      {
        localObject1 = B;
        localObject3 = (e0)c.remove(localObject1);
        if (localObject3 != null) {
          ((e0)localObject3).a();
        }
      }
    }
    c();
    return paramBoolean;
  }
  
  public boolean b()
  {
    boolean bool1 = h.isEmpty();
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    i locali;
    if (h.isEmpty()) {
      locali = null;
    } else {
      locali = h.getLast()).x;
    }
    bool1 = bool2;
    if (a(z, true))
    {
      bool1 = bool2;
      if (a()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void c()
  {
    d.a.b localb = n;
    boolean bool1 = o;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      Iterator localIterator = h.iterator();
      int i1 = 0;
      while (localIterator.hasNext()) {
        if (!(nextx instanceof d.s.j)) {
          i1++;
        }
      }
      bool3 = bool2;
      if (i1 > 1) {
        bool3 = true;
      }
    }
    a = bool3;
  }
  
  public class a
    extends d.a.b
  {
    public a(boolean paramBoolean)
    {
      super();
    }
    
    public void a()
    {
      b();
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(NavController paramNavController, i parami, Bundle paramBundle);
  }
}

/* Location:
 * Qualified Name:     androidx.navigation.NavController
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */