package e.c.a.b.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import java.util.List;

public class g
{
  public final d.f.h<String, h> a = new d.f.h();
  
  public static g a(Context paramContext, int paramInt)
  {
    try
    {
      Animator localAnimator = AnimatorInflater.loadAnimator(paramContext, paramInt);
      if ((localAnimator instanceof AnimatorSet)) {
        return a(((AnimatorSet)localAnimator).getChildAnimations());
      }
      if (localAnimator != null)
      {
        paramContext = new java/util/ArrayList;
        paramContext.<init>();
        paramContext.add(localAnimator);
        paramContext = a(paramContext);
        return paramContext;
      }
      return null;
    }
    catch (Exception localException)
    {
      paramContext = e.a.a.a.a.a("Can't load animation resource ID #0x");
      paramContext.append(Integer.toHexString(paramInt));
      Log.w("MotionSpec", paramContext.toString(), localException);
    }
    return null;
  }
  
  public static g a(List<Animator> paramList)
  {
    g localg = new g();
    int i = paramList.size();
    int j = 0;
    while (j < i)
    {
      Object localObject = (Animator)paramList.get(j);
      if ((localObject instanceof ObjectAnimator))
      {
        ObjectAnimator localObjectAnimator = (ObjectAnimator)localObject;
        String str = localObjectAnimator.getPropertyName();
        long l1 = localObjectAnimator.getStartDelay();
        long l2 = localObjectAnimator.getDuration();
        TimeInterpolator localTimeInterpolator = localObjectAnimator.getInterpolator();
        if ((!(localTimeInterpolator instanceof AccelerateDecelerateInterpolator)) && (localTimeInterpolator != null))
        {
          if ((localTimeInterpolator instanceof AccelerateInterpolator))
          {
            localObject = a.b;
          }
          else
          {
            localObject = localTimeInterpolator;
            if ((localTimeInterpolator instanceof DecelerateInterpolator)) {
              localObject = a.c;
            }
          }
        }
        else {
          localObject = a.a;
        }
        localObject = new h(l1, l2, (TimeInterpolator)localObject);
        d = localObjectAnimator.getRepeatCount();
        e = localObjectAnimator.getRepeatMode();
        a.put(str, localObject);
        j++;
      }
      else
      {
        paramList = new StringBuilder();
        paramList.append("Animator must be an ObjectAnimator: ");
        paramList.append(localObject);
        throw new IllegalArgumentException(paramList.toString());
      }
    }
    return localg;
  }
  
  public h a(String paramString)
  {
    int i;
    if (a.getOrDefault(paramString, null) != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return (h)a.getOrDefault(paramString, null);
    }
    throw new IllegalArgumentException();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (g.class == paramObject.getClass()))
    {
      paramObject = (g)paramObject;
      return a.equals(a);
    }
    return false;
  }
  
  public int hashCode()
  {
    return a.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\n');
    localStringBuilder.append(g.class.getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" timings: ");
    localStringBuilder.append(a);
    localStringBuilder.append("}\n");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     e.c.a.b.a.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */