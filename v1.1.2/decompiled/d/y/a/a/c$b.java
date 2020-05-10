package d.y.a.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import d.f.a;
import d.f.h;
import java.util.ArrayList;

public class c$b
  extends Drawable.ConstantState
{
  public int a;
  public g b;
  public AnimatorSet c;
  public ArrayList<Animator> d;
  public a<Animator, String> e;
  
  public c$b(b paramb, Drawable.Callback paramCallback, Resources paramResources)
  {
    if (paramb != null)
    {
      a = a;
      Object localObject = b;
      int i = 0;
      if (localObject != null)
      {
        localObject = ((g)localObject).getConstantState();
        if (paramResources != null) {
          b = ((g)((Drawable.ConstantState)localObject).newDrawable(paramResources));
        } else {
          b = ((g)((Drawable.ConstantState)localObject).newDrawable());
        }
        paramResources = b;
        paramResources.mutate();
        b = paramResources;
        paramResources.setCallback(paramCallback);
        b.setBounds(b.getBounds());
        b.C = false;
      }
      paramCallback = d;
      if (paramCallback != null)
      {
        int j = paramCallback.size();
        d = new ArrayList(j);
        e = new a(j);
        while (i < j)
        {
          paramResources = (Animator)d.get(i);
          paramCallback = paramResources.clone();
          paramResources = (String)e.getOrDefault(paramResources, null);
          paramCallback.setTarget(b.y.b.p.getOrDefault(paramResources, null));
          d.add(paramCallback);
          e.put(paramCallback, paramResources);
          i++;
        }
        if (c == null) {
          c = new AnimatorSet();
        }
        c.playTogether(d);
      }
    }
  }
  
  public int getChangingConfigurations()
  {
    return a;
  }
  
  public Drawable newDrawable()
  {
    throw new IllegalStateException("No constant state support for SDK < 24.");
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    throw new IllegalStateException("No constant state support for SDK < 24.");
  }
}

/* Location:
 * Qualified Name:     d.y.a.a.c.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */