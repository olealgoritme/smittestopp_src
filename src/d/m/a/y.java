package d.m.a;

import androidx.fragment.app.Fragment;
import d.o.g.b;
import e.a.a.a.a;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public abstract class y
{
  public ArrayList<y.a> a = new ArrayList();
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public boolean g;
  public boolean h = true;
  public String i;
  public int j;
  public CharSequence k;
  public int l;
  public CharSequence m;
  public ArrayList<String> n;
  public ArrayList<String> o;
  public boolean p = false;
  public ArrayList<Runnable> q;
  
  public y(l paraml, ClassLoader paramClassLoader) {}
  
  public abstract int a();
  
  public y a(Fragment paramFragment)
  {
    a(new y.a(3, paramFragment));
    return this;
  }
  
  public y a(Fragment paramFragment, g.b paramb)
  {
    a(new y.a(10, paramFragment, paramb));
    return this;
  }
  
  public void a(int paramInt1, Fragment paramFragment, String paramString, int paramInt2)
  {
    Object localObject = paramFragment.getClass();
    int i1 = ((Class)localObject).getModifiers();
    if ((!((Class)localObject).isAnonymousClass()) && (Modifier.isPublic(i1)) && ((!((Class)localObject).isMemberClass()) || (Modifier.isStatic(i1))))
    {
      if (paramString != null)
      {
        localObject = mTag;
        if ((localObject != null) && (!paramString.equals(localObject)))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Can't change tag of fragment ");
          ((StringBuilder)localObject).append(paramFragment);
          ((StringBuilder)localObject).append(": was ");
          throw new IllegalStateException(a.a((StringBuilder)localObject, mTag, " now ", paramString));
        }
        mTag = paramString;
      }
      if (paramInt1 != 0) {
        if (paramInt1 != -1)
        {
          i1 = mFragmentId;
          if ((i1 != 0) && (i1 != paramInt1))
          {
            paramString = new StringBuilder();
            paramString.append("Can't change container ID of fragment ");
            paramString.append(paramFragment);
            paramString.append(": was ");
            paramString.append(mFragmentId);
            paramString.append(" now ");
            paramString.append(paramInt1);
            throw new IllegalStateException(paramString.toString());
          }
          mFragmentId = paramInt1;
          mContainerId = paramInt1;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Can't add fragment ");
          ((StringBuilder)localObject).append(paramFragment);
          ((StringBuilder)localObject).append(" with tag ");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(" to container view with no id");
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      a(new y.a(paramInt2, paramFragment));
      return;
    }
    paramFragment = a.a("Fragment ");
    paramFragment.append(((Class)localObject).getCanonicalName());
    paramFragment.append(" must be a public static class to be  properly recreated from instance state.");
    throw new IllegalStateException(paramFragment.toString());
  }
  
  public void a(y.a parama)
  {
    a.add(parama);
    c = b;
    d = c;
    e = d;
    f = e;
  }
  
  public y b(Fragment paramFragment)
  {
    a(new y.a(8, paramFragment));
    return this;
  }
  
  public abstract void b();
}

/* Location:
 * Qualified Name:     base.d.m.a.y
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */