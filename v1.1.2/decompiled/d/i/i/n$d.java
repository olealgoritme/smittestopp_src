package d.i.i;

import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.R.id;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

public class n$d
{
  public static final ArrayList<WeakReference<View>> d = new ArrayList();
  public WeakHashMap<View, Boolean> a = null;
  public SparseArray<WeakReference<View>> b = null;
  public WeakReference<KeyEvent> c = null;
  
  public static d a(View paramView)
  {
    d locald1 = (d)paramView.getTag(R.id.tag_unhandled_key_event_manager);
    d locald2 = locald1;
    if (locald1 == null)
    {
      locald2 = new d();
      paramView.setTag(R.id.tag_unhandled_key_event_manager, locald2);
    }
    return locald2;
  }
  
  public final View a(View paramView, KeyEvent paramKeyEvent)
  {
    Object localObject = a;
    if ((localObject != null) && (((WeakHashMap)localObject).containsKey(paramView)))
    {
      if ((paramView instanceof ViewGroup))
      {
        ViewGroup localViewGroup = (ViewGroup)paramView;
        for (int i = localViewGroup.getChildCount() - 1; i >= 0; i--)
        {
          localObject = a(localViewGroup.getChildAt(i), paramKeyEvent);
          if (localObject != null) {
            return (View)localObject;
          }
        }
      }
      if (b(paramView, paramKeyEvent)) {
        return paramView;
      }
    }
    return null;
  }
  
  public final void a()
  {
    Object localObject1 = a;
    if (localObject1 != null) {
      ((WeakHashMap)localObject1).clear();
    }
    if (d.isEmpty()) {
      return;
    }
    synchronized (d)
    {
      if (a == null)
      {
        localObject1 = new java/util/WeakHashMap;
        ((WeakHashMap)localObject1).<init>();
        a = ((WeakHashMap)localObject1);
      }
      for (int i = d.size() - 1; i >= 0; i--)
      {
        localObject1 = (View)((WeakReference)d.get(i)).get();
        if (localObject1 == null)
        {
          d.remove(i);
        }
        else
        {
          a.put(localObject1, Boolean.TRUE);
          for (localObject1 = ((View)localObject1).getParent(); (localObject1 instanceof View); localObject1 = ((ViewParent)localObject1).getParent()) {
            a.put((View)localObject1, Boolean.TRUE);
          }
        }
      }
      return;
    }
  }
  
  public final boolean b(View paramView, KeyEvent paramKeyEvent)
  {
    ArrayList localArrayList = (ArrayList)paramView.getTag(R.id.tag_unhandled_key_listeners);
    if (localArrayList != null) {
      for (int i = localArrayList.size() - 1; i >= 0; i--) {
        if (((n.c)localArrayList.get(i)).a(paramView, paramKeyEvent)) {
          return true;
        }
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     d.i.i.n.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */