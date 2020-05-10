package d.m.a;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public abstract class w
  extends d.a0.a.a
{
  public final p a;
  public final int b;
  public y c = null;
  public ArrayList<Fragment.g> d = new ArrayList();
  public ArrayList<Fragment> e = new ArrayList();
  public Fragment f = null;
  public boolean g;
  
  @Deprecated
  public w(p paramp)
  {
    a = paramp;
    b = 0;
  }
  
  public void a(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    if (paramParcelable != null)
    {
      Bundle localBundle = (Bundle)paramParcelable;
      localBundle.setClassLoader(paramClassLoader);
      paramParcelable = localBundle.getParcelableArray("states");
      d.clear();
      e.clear();
      int i;
      if (paramParcelable != null) {
        for (i = 0; i < paramParcelable.length; i++) {
          d.add((Fragment.g)paramParcelable[i]);
        }
      }
      Iterator localIterator = localBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        paramClassLoader = (String)localIterator.next();
        if (paramClassLoader.startsWith("f"))
        {
          i = Integer.parseInt(paramClassLoader.substring(1));
          p localp = a;
          if (localp != null)
          {
            String str = localBundle.getString(paramClassLoader);
            if (str == null)
            {
              paramParcelable = null;
            }
            else
            {
              paramParcelable = c.b(str);
              if (paramParcelable == null) {
                break label245;
              }
            }
            if (paramParcelable != null)
            {
              while (e.size() <= i) {
                e.add(null);
              }
              paramParcelable.setMenuVisibility(false);
              e.set(i, paramParcelable);
            }
            else
            {
              paramParcelable = new StringBuilder();
              paramParcelable.append("Bad fragment at key ");
              paramParcelable.append(paramClassLoader);
              Log.w("FragmentStatePagerAdapt", paramParcelable.toString());
              continue;
              label245:
              paramParcelable = new StringBuilder();
              paramParcelable.append("Fragment no longer exists for key ");
              paramParcelable.append(paramClassLoader);
              paramParcelable.append(": unique id ");
              paramParcelable.append(str);
              localp.a(new IllegalStateException(paramParcelable.toString()));
              throw null;
            }
          }
          else
          {
            throw null;
          }
        }
      }
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    paramViewGroup = c;
    if (paramViewGroup != null)
    {
      if (!g) {}
      try
      {
        g = true;
        paramViewGroup.b();
        g = false;
      }
      finally
      {
        g = false;
      }
    }
  }
  
  public void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (Fragment)paramObject;
    if (c == null)
    {
      paramViewGroup = a;
      if (paramViewGroup != null) {
        c = new a(paramViewGroup);
      } else {
        throw null;
      }
    }
    while (d.size() <= paramInt) {
      d.add(null);
    }
    ArrayList localArrayList = d;
    if (((Fragment)paramObject).isAdded())
    {
      paramViewGroup = a;
      Object localObject = c;
      String str = mWho;
      localObject = (v)b.get(str);
      if ((localObject != null) && (b.equals(paramObject)))
      {
        if (b.mState > -1)
        {
          paramViewGroup = ((v)localObject).a();
          if (paramViewGroup != null)
          {
            paramViewGroup = new Fragment.g(paramViewGroup);
            break label180;
          }
        }
      }
      else
      {
        paramViewGroup.a(new IllegalStateException(e.a.a.a.a.a("Fragment ", (Fragment)paramObject, " is not currently in the FragmentManager")));
        throw null;
      }
    }
    paramViewGroup = null;
    label180:
    localArrayList.set(paramInt, paramViewGroup);
    e.set(paramInt, null);
    c.a((Fragment)paramObject);
    if (((Fragment)paramObject).equals(f)) {
      f = null;
    }
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    if (paramViewGroup.getId() != -1) {
      return;
    }
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("ViewPager with adapter ");
    paramViewGroup.append(this);
    paramViewGroup.append(" requires a view id");
    throw new IllegalStateException(paramViewGroup.toString());
  }
}

/* Location:
 * Qualified Name:     base.d.m.a.w
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */