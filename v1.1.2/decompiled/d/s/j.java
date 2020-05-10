package d.s;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import androidx.navigation.common.R.styleable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class j
  extends i
  implements Iterable<i>
{
  public final d.f.i<i> F = new d.f.i(10);
  public int G;
  public String H;
  
  public j(p<? extends j> paramp)
  {
    super(paramp);
  }
  
  public i.a a(Uri paramUri)
  {
    Object localObject = super.a(paramUri);
    a locala = new a();
    while (locala.hasNext())
    {
      i.a locala1 = ((i)locala.next()).a(paramUri);
      if ((locala1 != null) && ((localObject == null) || (locala1.a((i.a)localObject) > 0))) {
        localObject = locala1;
      }
    }
    return (i.a)localObject;
  }
  
  public final i a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = F;
    Object localObject2 = null;
    localObject1 = (i)((d.f.i)localObject1).b(paramInt, null);
    if (localObject1 == null)
    {
      localObject1 = localObject2;
      if (paramBoolean)
      {
        j localj = y;
        localObject1 = localObject2;
        if (localj != null) {
          localObject1 = localj.b(paramInt);
        }
      }
    }
    return (i)localObject1;
  }
  
  public void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.NavGraphNavigator);
    int i = paramAttributeSet.getResourceId(R.styleable.NavGraphNavigator_startDestination, 0);
    G = i;
    H = null;
    H = i.a(paramContext, i);
    paramAttributeSet.recycle();
  }
  
  public final void a(i parami)
  {
    int i = z;
    if (i != 0)
    {
      i locali = (i)F.a(i);
      if (locali == parami) {
        return;
      }
      if (y == null)
      {
        if (locali != null) {
          y = null;
        }
        y = this;
        F.c(z, parami);
        return;
      }
      throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
    }
    throw new IllegalArgumentException("Destinations must have an id. Call setId() or include an android:id in your navigation XML.");
  }
  
  public final i b(int paramInt)
  {
    return a(paramInt, true);
  }
  
  public final Iterator<i> iterator()
  {
    return new a();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" startDestination=");
    Object localObject = b(G);
    if (localObject == null)
    {
      localObject = H;
      if (localObject == null)
      {
        localStringBuilder.append("0x");
        localStringBuilder.append(Integer.toHexString(G));
      }
      else
      {
        localStringBuilder.append((String)localObject);
      }
    }
    else
    {
      localStringBuilder.append("{");
      localStringBuilder.append(((i)localObject).toString());
      localStringBuilder.append("}");
    }
    return localStringBuilder.toString();
  }
  
  public class a
    implements Iterator<i>
  {
    public int x = -1;
    public boolean y = false;
    
    public a() {}
    
    public boolean hasNext()
    {
      int i = x;
      boolean bool = true;
      if (i + 1 >= F.b()) {
        bool = false;
      }
      return bool;
    }
    
    public Object next()
    {
      if (hasNext())
      {
        y = true;
        d.f.i locali = F;
        int i = x + 1;
        x = i;
        return (i)locali.d(i);
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      if (y)
      {
        F.d(x)).y = null;
        d.f.i locali = F;
        int i = x;
        Object[] arrayOfObject = z;
        Object localObject1 = arrayOfObject[i];
        Object localObject2 = d.f.i.B;
        if (localObject1 != localObject2)
        {
          arrayOfObject[i] = localObject2;
          x = true;
        }
        x -= 1;
        y = false;
        return;
      }
      throw new IllegalStateException("You must call next() before you can remove an element");
    }
  }
}

/* Location:
 * Qualified Name:     d.s.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */