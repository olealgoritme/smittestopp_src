package d.s.s;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.navigation.NavController;
import androidx.navigation.NavController.b;
import androidx.navigation.ui.R.string;
import d.b.a.h;
import d.b.c.a.d;
import d.s.i;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class a
  implements NavController.b
{
  public final Context a;
  public final Set<Integer> b;
  public final WeakReference<d.l.a.a> c;
  public d d;
  public ValueAnimator e;
  
  public a(Context paramContext, c paramc)
  {
    a = paramContext;
    b = a;
    paramContext = b;
    if (paramContext != null) {
      c = new WeakReference(paramContext);
    } else {
      c = null;
    }
  }
  
  public abstract void a(Drawable paramDrawable, int paramInt);
  
  public void a(NavController paramNavController, i parami, Bundle paramBundle)
  {
    if ((parami instanceof d.s.b)) {
      return;
    }
    Object localObject = c;
    if (localObject != null) {
      localObject = (d.l.a.a)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if ((c != null) && (localObject == null))
    {
      l.remove(this);
      return;
    }
    paramNavController = B;
    if (!TextUtils.isEmpty(paramNavController))
    {
      StringBuffer localStringBuffer = new StringBuffer();
      Matcher localMatcher = Pattern.compile("\\{(.+?)\\}").matcher(paramNavController);
      while (localMatcher.find())
      {
        String str = localMatcher.group(1);
        if ((paramBundle != null) && (paramBundle.containsKey(str)))
        {
          localMatcher.appendReplacement(localStringBuffer, "");
          localStringBuffer.append(paramBundle.get(str).toString());
        }
        else
        {
          parami = new StringBuilder();
          parami.append("Could not find ");
          parami.append(str);
          parami.append(" in ");
          parami.append(paramBundle);
          parami.append(" to fill label ");
          parami.append(paramNavController);
          throw new IllegalArgumentException(parami.toString());
        }
      }
      localMatcher.appendTail(localStringBuffer);
      f.k().a(localStringBuffer);
    }
    paramBundle = b;
    do
    {
      if (paramBundle.contains(Integer.valueOf(z)))
      {
        i = 1;
        break;
      }
      paramNavController = y;
      parami = paramNavController;
    } while (paramNavController != null);
    int i = 0;
    if ((localObject == null) && (i != 0))
    {
      a(null, 0);
    }
    else
    {
      if ((localObject != null) && (i != 0)) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if (d == null)
      {
        d = new d(a);
        j = 0;
      }
      else
      {
        j = 1;
      }
      paramNavController = d;
      int k;
      if (i != 0) {
        k = R.string.nav_app_bar_open_drawer_description;
      } else {
        k = R.string.nav_app_bar_navigate_up_description;
      }
      a(paramNavController, k);
      float f1;
      if (i != 0) {
        f1 = 0.0F;
      } else {
        f1 = 1.0F;
      }
      if (j != 0)
      {
        float f2 = d.j;
        paramNavController = e;
        if (paramNavController != null) {
          paramNavController.cancel();
        }
        paramNavController = ObjectAnimator.ofFloat(d, "progress", new float[] { f2, f1 });
        e = paramNavController;
        paramNavController.start();
      }
      else
      {
        d.setProgress(f1);
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.s.s.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */