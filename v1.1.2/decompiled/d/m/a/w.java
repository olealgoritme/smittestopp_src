package d.m.a;

import android.util.Log;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class w
{
  public final ArrayList<Fragment> a = new ArrayList();
  public final HashMap<String, v> b = new HashMap();
  
  public void a()
  {
    b.values().removeAll(Collections.singleton(null));
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = a.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (Fragment)localIterator.next();
      localObject = (v)b.get(mWho);
      if (localObject != null) {
        c = paramInt;
      }
    }
    localIterator = b.values().iterator();
    while (localIterator.hasNext())
    {
      localObject = (v)localIterator.next();
      if (localObject != null) {
        c = paramInt;
      }
    }
  }
  
  public void a(Fragment paramFragment)
  {
    if (!a.contains(paramFragment)) {
      synchronized (a)
      {
        a.add(paramFragment);
        mAdded = true;
        return;
      }
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("Fragment already added: ");
    ((StringBuilder)???).append(paramFragment);
    throw new IllegalStateException(((StringBuilder)???).toString());
  }
  
  public boolean a(String paramString)
  {
    return b.containsKey(paramString);
  }
  
  public Fragment b(String paramString)
  {
    paramString = (v)b.get(paramString);
    if (paramString != null) {
      return b;
    }
    return null;
  }
  
  public List<Fragment> b()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = b.values().iterator();
    while (localIterator.hasNext())
    {
      v localv = (v)localIterator.next();
      if (localv != null) {
        localArrayList.add(b);
      } else {
        localArrayList.add(null);
      }
    }
    return localArrayList;
  }
  
  public void b(Fragment paramFragment)
  {
    synchronized (a)
    {
      a.remove(paramFragment);
      mAdded = false;
      return;
    }
  }
  
  public List<Fragment> c()
  {
    if (a.isEmpty()) {
      return Collections.emptyList();
    }
    synchronized (a)
    {
      ArrayList localArrayList2 = new java/util/ArrayList;
      localArrayList2.<init>(a);
      return localArrayList2;
    }
  }
  
  public ArrayList<String> d()
  {
    synchronized (a)
    {
      if (a.isEmpty()) {
        return null;
      }
      ArrayList localArrayList2 = new java/util/ArrayList;
      localArrayList2.<init>(a.size());
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        Fragment localFragment = (Fragment)localIterator.next();
        localArrayList2.add(mWho);
        if (p.c(2))
        {
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append("saveAllState: adding fragment (");
          localStringBuilder.append(mWho);
          localStringBuilder.append("): ");
          localStringBuilder.append(localFragment);
          Log.v("FragmentManager", localStringBuilder.toString());
        }
      }
      return localArrayList2;
    }
  }
}

/* Location:
 * Qualified Name:     d.m.a.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */