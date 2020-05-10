package d.m.a;

import android.util.Log;
import androidx.fragment.app.Fragment;
import d.o.g.b;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class a
  extends y
  implements p.e
{
  public final p r;
  public boolean s;
  public int t = -1;
  
  public a(p paramp)
  {
    super(locall, (ClassLoader)localObject);
    r = paramp;
  }
  
  public static boolean b(y.a parama)
  {
    parama = b;
    boolean bool;
    if ((parama != null) && (mAdded) && (mView != null) && (!mDetached) && (!mHidden) && (parama.isPostponed())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public int a()
  {
    return a(false);
  }
  
  public int a(boolean paramBoolean)
  {
    if (!s)
    {
      if (p.c(2))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Commit: ");
        ((StringBuilder)localObject).append(this);
        Log.v("FragmentManager", ((StringBuilder)localObject).toString());
        localObject = new PrintWriter(new d.i.h.a("FragmentManager"));
        a("  ", (PrintWriter)localObject, true);
        ((PrintWriter)localObject).close();
      }
      s = true;
      if (g) {
        t = r.i.getAndIncrement();
      } else {
        t = -1;
      }
      r.a(this, paramBoolean);
      return t;
    }
    throw new IllegalStateException("commit already called");
  }
  
  public y a(Fragment paramFragment)
  {
    Object localObject = mFragmentManager;
    if ((localObject != null) && (localObject != r))
    {
      localObject = e.a.a.a.a.a("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
      ((StringBuilder)localObject).append(paramFragment.toString());
      ((StringBuilder)localObject).append(" is already attached to a FragmentManager.");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    super.a(paramFragment);
    return this;
  }
  
  public y a(Fragment paramFragment, g.b paramb)
  {
    if (mFragmentManager == r)
    {
      if (paramb.isAtLeast(g.b.CREATED))
      {
        super.a(paramFragment, paramb);
        return this;
      }
      paramFragment = e.a.a.a.a.a("Cannot set maximum Lifecycle below ");
      paramFragment.append(g.b.CREATED);
      throw new IllegalArgumentException(paramFragment.toString());
    }
    paramFragment = e.a.a.a.a.a("Cannot setMaxLifecycle for Fragment not attached to FragmentManager ");
    paramFragment.append(r);
    throw new IllegalArgumentException(paramFragment.toString());
  }
  
  public void a(int paramInt)
  {
    if (!g) {
      return;
    }
    Object localObject1;
    if (p.c(2))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Bump nesting in ");
      ((StringBuilder)localObject1).append(this);
      ((StringBuilder)localObject1).append(" by ");
      ((StringBuilder)localObject1).append(paramInt);
      Log.v("FragmentManager", ((StringBuilder)localObject1).toString());
    }
    int i = a.size();
    for (int j = 0; j < i; j++)
    {
      localObject1 = (y.a)a.get(j);
      Object localObject2 = b;
      if (localObject2 != null)
      {
        mBackStackNesting += paramInt;
        if (p.c(2))
        {
          localObject2 = e.a.a.a.a.a("Bump nesting of ");
          ((StringBuilder)localObject2).append(b);
          ((StringBuilder)localObject2).append(" to ");
          ((StringBuilder)localObject2).append(b.mBackStackNesting);
          Log.v("FragmentManager", ((StringBuilder)localObject2).toString());
        }
      }
    }
  }
  
  public void a(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    super.a(paramInt1, paramFragment, paramString, paramInt2);
    mFragmentManager = r;
  }
  
  public void a(String paramString, PrintWriter paramPrintWriter, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mName=");
      paramPrintWriter.print(this.i);
      paramPrintWriter.print(" mIndex=");
      paramPrintWriter.print(t);
      paramPrintWriter.print(" mCommitted=");
      paramPrintWriter.println(s);
      if (f != 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mTransition=#");
        paramPrintWriter.print(Integer.toHexString(f));
      }
      if ((b != 0) || (c != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(b));
        paramPrintWriter.print(" mExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(c));
      }
      if ((d != 0) || (e != 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mPopEnterAnim=#");
        paramPrintWriter.print(Integer.toHexString(d));
        paramPrintWriter.print(" mPopExitAnim=#");
        paramPrintWriter.println(Integer.toHexString(e));
      }
      if ((this.j != 0) || (k != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(this.j));
        paramPrintWriter.print(" mBreadCrumbTitleText=");
        paramPrintWriter.println(k);
      }
      if ((l != 0) || (m != null))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mBreadCrumbShortTitleRes=#");
        paramPrintWriter.print(Integer.toHexString(l));
        paramPrintWriter.print(" mBreadCrumbShortTitleText=");
        paramPrintWriter.println(m);
      }
    }
    if (!a.isEmpty())
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Operations:");
      int i = a.size();
      for (int j = 0; j < i; j++)
      {
        y.a locala = (y.a)a.get(j);
        Object localObject;
        switch (a)
        {
        default: 
          localObject = e.a.a.a.a.a("cmd=");
          ((StringBuilder)localObject).append(a);
          localObject = ((StringBuilder)localObject).toString();
          break;
        case 10: 
          localObject = "OP_SET_MAX_LIFECYCLE";
          break;
        case 9: 
          localObject = "UNSET_PRIMARY_NAV";
          break;
        case 8: 
          localObject = "SET_PRIMARY_NAV";
          break;
        case 7: 
          localObject = "ATTACH";
          break;
        case 6: 
          localObject = "DETACH";
          break;
        case 5: 
          localObject = "SHOW";
          break;
        case 4: 
          localObject = "HIDE";
          break;
        case 3: 
          localObject = "REMOVE";
          break;
        case 2: 
          localObject = "REPLACE";
          break;
        case 1: 
          localObject = "ADD";
          break;
        case 0: 
          localObject = "NULL";
        }
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  Op #");
        paramPrintWriter.print(j);
        paramPrintWriter.print(": ");
        paramPrintWriter.print((String)localObject);
        paramPrintWriter.print(" ");
        paramPrintWriter.println(b);
        if (paramBoolean)
        {
          if ((c != 0) || (d != 0))
          {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("enterAnim=#");
            paramPrintWriter.print(Integer.toHexString(c));
            paramPrintWriter.print(" exitAnim=#");
            paramPrintWriter.println(Integer.toHexString(d));
          }
          if ((e != 0) || (f != 0))
          {
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("popEnterAnim=#");
            paramPrintWriter.print(Integer.toHexString(e));
            paramPrintWriter.print(" popExitAnim=#");
            paramPrintWriter.println(Integer.toHexString(f));
          }
        }
      }
    }
  }
  
  public boolean a(ArrayList<a> paramArrayList, int paramInt1, int paramInt2)
  {
    if (paramInt2 == paramInt1) {
      return false;
    }
    int i = a.size();
    int j = -1;
    int k = 0;
    while (k < i)
    {
      Fragment localFragment = a.get(k)).b;
      int m;
      if (localFragment != null) {
        m = mContainerId;
      } else {
        m = 0;
      }
      int n = j;
      if (m != 0)
      {
        n = j;
        if (m != j)
        {
          for (j = paramInt1; j < paramInt2; j++)
          {
            a locala = (a)paramArrayList.get(j);
            int i1 = a.size();
            for (n = 0; n < i1; n++)
            {
              localFragment = a.get(n)).b;
              int i2;
              if (localFragment != null) {
                i2 = mContainerId;
              } else {
                i2 = 0;
              }
              if (i2 == m) {
                return true;
              }
            }
          }
          n = m;
        }
      }
      k++;
      j = n;
    }
    return false;
  }
  
  public boolean a(ArrayList<a> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    if (p.c(2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Run: ");
      localStringBuilder.append(this);
      Log.v("FragmentManager", localStringBuilder.toString());
    }
    paramArrayList.add(this);
    paramArrayList1.add(Boolean.valueOf(false));
    if (g)
    {
      paramArrayList = r;
      if (d == null) {
        d = new ArrayList();
      }
      d.add(this);
    }
    return true;
  }
  
  public y b(Fragment paramFragment)
  {
    if (paramFragment != null)
    {
      Object localObject = mFragmentManager;
      if ((localObject != null) && (localObject != r))
      {
        localObject = e.a.a.a.a.a("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment ");
        ((StringBuilder)localObject).append(paramFragment.toString());
        ((StringBuilder)localObject).append(" is already attached to a FragmentManager.");
        throw new IllegalStateException(((StringBuilder)localObject).toString());
      }
    }
    super.b(paramFragment);
    return this;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 128	d/m/a/y:g	Z
    //   4: ifne +99 -> 103
    //   7: aload_0
    //   8: iconst_0
    //   9: putfield 361	d/m/a/y:h	Z
    //   12: aload_0
    //   13: getfield 43	d/m/a/a:r	Ld/m/a/p;
    //   16: astore_1
    //   17: aload_1
    //   18: getfield 24	d/m/a/p:n	Ld/m/a/m;
    //   21: ifnull +81 -> 102
    //   24: aload_1
    //   25: getfield 364	d/m/a/p:w	Z
    //   28: ifeq +6 -> 34
    //   31: goto +71 -> 102
    //   34: aload_1
    //   35: iconst_1
    //   36: invokevirtual 366	d/m/a/p:c	(Z)V
    //   39: aload_0
    //   40: aload_1
    //   41: getfield 368	d/m/a/p:y	Ljava/util/ArrayList;
    //   44: aload_1
    //   45: getfield 371	d/m/a/p:z	Ljava/util/ArrayList;
    //   48: invokeinterface 373 3 0
    //   53: ifeq +34 -> 87
    //   56: aload_1
    //   57: iconst_1
    //   58: putfield 375	d/m/a/p:b	Z
    //   61: aload_1
    //   62: aload_1
    //   63: getfield 368	d/m/a/p:y	Ljava/util/ArrayList;
    //   66: aload_1
    //   67: getfield 371	d/m/a/p:z	Ljava/util/ArrayList;
    //   70: invokevirtual 378	d/m/a/p:c	(Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    //   73: aload_1
    //   74: invokevirtual 380	d/m/a/p:a	()V
    //   77: goto +10 -> 87
    //   80: astore_2
    //   81: aload_1
    //   82: invokevirtual 380	d/m/a/p:a	()V
    //   85: aload_2
    //   86: athrow
    //   87: aload_1
    //   88: invokevirtual 383	d/m/a/p:o	()V
    //   91: aload_1
    //   92: invokevirtual 385	d/m/a/p:e	()V
    //   95: aload_1
    //   96: getfield 388	d/m/a/p:c	Ld/m/a/x;
    //   99: invokevirtual 391	d/m/a/x:a	()V
    //   102: return
    //   103: new 142	java/lang/IllegalStateException
    //   106: dup
    //   107: ldc_w 393
    //   110: invokespecial 145	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	a
    //   16	80	1	localp	p
    //   80	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   61	73	80	finally
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject1;
    for (int i = a.size() - 1; i >= 0; i--)
    {
      localObject1 = (y.a)a.get(i);
      Object localObject2 = b;
      if (localObject2 != null)
      {
        int j = f;
        int k = 8194;
        if (j != 4097) {
          if (j != 4099)
          {
            if (j != 8194) {
              k = 0;
            } else {
              k = 4097;
            }
          }
          else {
            k = 4099;
          }
        }
        ((Fragment)localObject2).setNextTransition(k);
      }
      switch (a)
      {
      case 2: 
      default: 
        localObject2 = e.a.a.a.a.a("Unknown cmd: ");
        ((StringBuilder)localObject2).append(a);
        throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
      case 10: 
        r.a((Fragment)localObject2, g);
        break;
      case 9: 
        r.q((Fragment)localObject2);
        break;
      case 8: 
        r.q(null);
        break;
      case 7: 
        ((Fragment)localObject2).setNextAnim(f);
        r.a((Fragment)localObject2, true);
        r.f((Fragment)localObject2);
        break;
      case 6: 
        ((Fragment)localObject2).setNextAnim(e);
        r.c((Fragment)localObject2);
        break;
      case 5: 
        ((Fragment)localObject2).setNextAnim(f);
        r.a((Fragment)localObject2, true);
        r.i((Fragment)localObject2);
        break;
      case 4: 
        ((Fragment)localObject2).setNextAnim(e);
        r.s((Fragment)localObject2);
        break;
      case 3: 
        ((Fragment)localObject2).setNextAnim(e);
        r.a((Fragment)localObject2);
        break;
      case 1: 
        ((Fragment)localObject2).setNextAnim(f);
        r.a((Fragment)localObject2, true);
        r.o((Fragment)localObject2);
      }
      if ((!p) && (a != 3) && (localObject2 != null)) {
        r.m((Fragment)localObject2);
      }
    }
    if ((!p) && (paramBoolean))
    {
      localObject1 = r;
      ((p)localObject1).a(m, true);
    }
  }
  
  public boolean b(int paramInt)
  {
    int i = a.size();
    for (int j = 0; j < i; j++)
    {
      Fragment localFragment = a.get(j)).b;
      int k;
      if (localFragment != null) {
        k = mContainerId;
      } else {
        k = 0;
      }
      if ((k != 0) && (k == paramInt)) {
        return true;
      }
    }
    return false;
  }
  
  public void c()
  {
    int i = a.size();
    Object localObject1;
    for (int j = 0; j < i; j++)
    {
      localObject1 = (y.a)a.get(j);
      Object localObject2 = b;
      if (localObject2 != null) {
        ((Fragment)localObject2).setNextTransition(f);
      }
      switch (a)
      {
      case 2: 
      default: 
        localObject2 = e.a.a.a.a.a("Unknown cmd: ");
        ((StringBuilder)localObject2).append(a);
        throw new IllegalArgumentException(((StringBuilder)localObject2).toString());
      case 10: 
        r.a((Fragment)localObject2, h);
        break;
      case 9: 
        r.q(null);
        break;
      case 8: 
        r.q((Fragment)localObject2);
        break;
      case 7: 
        ((Fragment)localObject2).setNextAnim(c);
        r.a((Fragment)localObject2, false);
        r.c((Fragment)localObject2);
        break;
      case 6: 
        ((Fragment)localObject2).setNextAnim(d);
        r.f((Fragment)localObject2);
        break;
      case 5: 
        ((Fragment)localObject2).setNextAnim(c);
        r.a((Fragment)localObject2, false);
        r.s((Fragment)localObject2);
        break;
      case 4: 
        ((Fragment)localObject2).setNextAnim(d);
        r.i((Fragment)localObject2);
        break;
      case 3: 
        ((Fragment)localObject2).setNextAnim(d);
        r.o((Fragment)localObject2);
        break;
      case 1: 
        ((Fragment)localObject2).setNextAnim(c);
        r.a((Fragment)localObject2, false);
        r.a((Fragment)localObject2);
      }
      if ((!p) && (a != 1) && (localObject2 != null)) {
        r.m((Fragment)localObject2);
      }
    }
    if (!p)
    {
      localObject1 = r;
      ((p)localObject1).a(m, true);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("BackStackEntry{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    if (t >= 0)
    {
      localStringBuilder.append(" #");
      localStringBuilder.append(t);
    }
    if (i != null)
    {
      localStringBuilder.append(" ");
      localStringBuilder.append(i);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.d.m.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */