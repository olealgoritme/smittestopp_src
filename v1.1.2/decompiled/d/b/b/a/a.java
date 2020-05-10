package d.b.b.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import d.b.a.s;
import d.b.e.j;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class a
{
  public static final ThreadLocal<TypedValue> a = new ThreadLocal();
  public static final WeakHashMap<Context, SparseArray<a>> b = new WeakHashMap(0);
  public static final Object c = new Object();
  
  public static ColorStateList a(Context paramContext, int paramInt)
  {
    synchronized (c)
    {
      SparseArray localSparseArray = (SparseArray)b.get(paramContext);
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        a locala = (a)localSparseArray.get(paramInt);
        if (locala != null)
        {
          if (b.equals(paramContext.getResources().getConfiguration()))
          {
            paramContext = a;
            return paramContext;
          }
          localSparseArray.remove(paramInt);
        }
      }
      return null;
    }
  }
  
  public static void a(Context paramContext, int paramInt, ColorStateList paramColorStateList)
  {
    synchronized (c)
    {
      Object localObject2 = (SparseArray)b.get(paramContext);
      Object localObject3 = localObject2;
      if (localObject2 == null)
      {
        localObject3 = new android/util/SparseArray;
        ((SparseArray)localObject3).<init>();
        b.put(paramContext, localObject3);
      }
      localObject2 = new d/b/b/a/a$a;
      ((a)localObject2).<init>(paramColorStateList, paramContext.getResources().getConfiguration());
      ((SparseArray)localObject3).append(paramInt, localObject2);
      return;
    }
  }
  
  public static ColorStateList b(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColorStateList(paramInt);
    }
    Object localObject1 = a(paramContext, paramInt);
    if (localObject1 != null) {
      return (ColorStateList)localObject1;
    }
    Object localObject2 = paramContext.getResources();
    Object localObject3 = (TypedValue)a.get();
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      localObject1 = new TypedValue();
      a.set(localObject1);
    }
    int i = 1;
    ((Resources)localObject2).getValue(paramInt, (TypedValue)localObject1, true);
    int j = type;
    if ((j < 28) || (j > 31)) {
      i = 0;
    }
    localObject1 = null;
    if (i == 0)
    {
      localObject3 = paramContext.getResources();
      localObject2 = ((Resources)localObject3).getXml(paramInt);
      try
      {
        localObject3 = s.a((Resources)localObject3, (XmlPullParser)localObject2, paramContext.getTheme());
        localObject1 = localObject3;
      }
      catch (Exception localException)
      {
        Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", localException);
      }
    }
    if (localObject1 != null)
    {
      a(paramContext, paramInt, (ColorStateList)localObject1);
      return (ColorStateList)localObject1;
    }
    return d.i.b.a.b(paramContext, paramInt);
  }
  
  public static Drawable c(Context paramContext, int paramInt)
  {
    return j.a().c(paramContext, paramInt);
  }
  
  public static class a
  {
    public final ColorStateList a;
    public final Configuration b;
    
    public a(ColorStateList paramColorStateList, Configuration paramConfiguration)
    {
      a = paramColorStateList;
      b = paramConfiguration;
    }
  }
}

/* Location:
 * Qualified Name:     d.b.b.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */