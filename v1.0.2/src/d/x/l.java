package d.x;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.transition.R.id;
import d.i.i.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class l
{
  public static h a = new a();
  public static ThreadLocal<WeakReference<d.f.a<ViewGroup, ArrayList<h>>>> b = new ThreadLocal();
  public static ArrayList<ViewGroup> c = new ArrayList();
  
  public static d.f.a<ViewGroup, ArrayList<h>> a()
  {
    Object localObject = (WeakReference)b.get();
    if (localObject != null)
    {
      localObject = (d.f.a)((WeakReference)localObject).get();
      if (localObject != null) {
        return (d.f.a<ViewGroup, ArrayList<h>>)localObject;
      }
    }
    localObject = new d.f.a();
    WeakReference localWeakReference = new WeakReference(localObject);
    b.set(localWeakReference);
    return (d.f.a<ViewGroup, ArrayList<h>>)localObject;
  }
  
  public static void a(ViewGroup paramViewGroup, h paramh)
  {
    if ((!c.contains(paramViewGroup)) && (n.t(paramViewGroup)))
    {
      c.add(paramViewGroup);
      Object localObject = paramh;
      if (paramh == null) {
        localObject = a;
      }
      paramh = ((h)localObject).clone();
      localObject = (ArrayList)a().getOrDefault(paramViewGroup, null);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((h)((Iterator)localObject).next()).c(paramViewGroup);
        }
      }
      if (paramh != null) {
        paramh.a(paramViewGroup, true);
      }
      if ((g)paramViewGroup.getTag(R.id.transition_current_scene) == null)
      {
        paramViewGroup.setTag(R.id.transition_current_scene, null);
        if (paramh != null)
        {
          paramh = new l.a(paramh, paramViewGroup);
          paramViewGroup.addOnAttachStateChangeListener(paramh);
          paramViewGroup.getViewTreeObserver().addOnPreDrawListener(paramh);
        }
      }
      else
      {
        throw null;
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.d.x.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */