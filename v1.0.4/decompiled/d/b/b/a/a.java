package d.b.b.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;

import org.xmlpull.v1.XmlPullParser;

import java.util.WeakHashMap;

import d.b.a.r;
import d.b.e.n0;

@SuppressLint({"RestrictedAPI"})
public final class a
{
  public static final ThreadLocal<TypedValue> a = new ThreadLocal();
  public static final WeakHashMap<Context, SparseArray<a.a>> b = new WeakHashMap(0);
  public static final Object c = new Object();
  
  public static ColorStateList a(Context paramContext, int paramInt)
  {
    synchronized (c)
    {
      SparseArray localSparseArray = (SparseArray)b.get(paramContext);
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        a.a locala = (a.a)localSparseArray.get(paramInt);
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
      ((a.a)localObject2).<init>(paramColorStateList, paramContext.getResources().getConfiguration());
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
    Resources localResources = paramContext.getResources();
    Object localObject2 = (TypedValue)a.get();
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new TypedValue();
      a.set(localObject1);
    }
    int i = 1;
    localResources.getValue(paramInt, (TypedValue)localObject1, true);
    int j = type;
    if ((j < 28) || (j > 31)) {
      i = 0;
    }
    localObject1 = null;
    if (i == 0)
    {
      localResources = paramContext.getResources();
      localObject2 = localResources.getXml(paramInt);
      try
      {
        localObject2 = r.a(localResources, (XmlPullParser)localObject2, paramContext.getTheme());
        localObject1 = localObject2;
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
    return n0.a().b(paramContext, paramInt);
  }
}

/* Location:
 * Qualified Name:     base.d.b.b.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */