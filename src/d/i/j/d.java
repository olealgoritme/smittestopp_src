package d.i.j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.Editable;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d
  implements ActionMode.Callback
{
  public final ActionMode.Callback a;
  public final TextView b;
  public Class<?> c;
  public Method d;
  public boolean e;
  public boolean f;
  
  public d(ActionMode.Callback paramCallback, TextView paramTextView)
  {
    a = paramCallback;
    b = paramTextView;
    f = false;
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return a.onActionItemClicked(paramActionMode, paramMenuItem);
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return a.onCreateActionMode(paramActionMode, paramMenu);
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode)
  {
    a.onDestroyActionMode(paramActionMode);
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    Object localObject1 = b.getContext();
    PackageManager localPackageManager = ((Context)localObject1).getPackageManager();
    if (!f)
    {
      f = true;
      try
      {
        Class localClass = Class.forName("com.android.internal.view.menu.MenuBuilder");
        c = localClass;
        d = localClass.getDeclaredMethod("removeItemAt", new Class[] { Integer.TYPE });
        e = true;
      }
      catch (ClassNotFoundException|NoSuchMethodException localClassNotFoundException)
      {
        c = null;
        d = null;
        e = false;
      }
    }
    try
    {
      if ((e) && (c.isInstance(paramMenu))) {
        localObject2 = d;
      } else {
        localObject2 = paramMenu.getClass().getDeclaredMethod("removeItemAt", new Class[] { Integer.TYPE });
      }
      int i = paramMenu.size();
      i--;
      Object localObject3;
      while (i >= 0)
      {
        localObject3 = paramMenu.getItem(i);
        if ((((MenuItem)localObject3).getIntent() != null) && ("android.intent.action.PROCESS_TEXT".equals(((MenuItem)localObject3).getIntent().getAction()))) {
          ((Method)localObject2).invoke(paramMenu, new Object[] { Integer.valueOf(i) });
        }
        i--;
      }
      Object localObject2 = new ArrayList();
      Object localObject4;
      Object localObject5;
      if ((localObject1 instanceof Activity))
      {
        localObject4 = localPackageManager.queryIntentActivities(new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain"), 0).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject3 = (ResolveInfo)((Iterator)localObject4).next();
          if (!((Context)localObject1).getPackageName().equals(activityInfo.packageName))
          {
            localObject5 = activityInfo;
            if (exported)
            {
              localObject5 = permission;
              if ((localObject5 == null) || (((Context)localObject1).checkSelfPermission((String)localObject5) == 0)) {}
            }
            else
            {
              i = 0;
              break label355;
            }
          }
          i = 1;
          label355:
          if (i != 0) {
            ((ArrayList)localObject2).add(localObject3);
          }
        }
      }
      for (i = 0; i < ((ArrayList)localObject2).size(); i++)
      {
        localObject3 = (ResolveInfo)((ArrayList)localObject2).get(i);
        localObject1 = paramMenu.add(0, 0, i + 100, ((ResolveInfo)localObject3).loadLabel(localPackageManager));
        localObject4 = b;
        localObject5 = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        int j;
        if (((localObject4 instanceof Editable)) && (((TextView)localObject4).onCheckIsTextEditor()) && (((TextView)localObject4).isEnabled())) {
          j = 1;
        } else {
          j = 0;
        }
        localObject4 = ((Intent)localObject5).putExtra("android.intent.extra.PROCESS_TEXT_READONLY", j ^ 0x1);
        localObject3 = activityInfo;
        ((MenuItem)localObject1).setIntent(((Intent)localObject4).setClassName(packageName, name)).setShowAsAction(1);
      }
    }
    catch (NoSuchMethodException|IllegalAccessException|InvocationTargetException localNoSuchMethodException)
    {
      for (;;) {}
    }
    return a.onPrepareActionMode(paramActionMode, paramMenu);
  }
}

/* Location:
 * Qualified Name:     base.d.i.j.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */