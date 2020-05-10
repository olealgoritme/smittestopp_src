package e.c.a.b.a;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

public class h
{
  public long a = 0L;
  public long b = 300L;
  public TimeInterpolator c = null;
  public int d = 0;
  public int e = 1;
  
  public h(long paramLong1, long paramLong2)
  {
    a = paramLong1;
    b = paramLong2;
  }
  
  public h(long paramLong1, long paramLong2, TimeInterpolator paramTimeInterpolator)
  {
    a = paramLong1;
    b = paramLong2;
    c = paramTimeInterpolator;
  }
  
  public TimeInterpolator a()
  {
    TimeInterpolator localTimeInterpolator = c;
    if (localTimeInterpolator == null) {
      localTimeInterpolator = a.a;
    }
    return localTimeInterpolator;
  }
  
  public void a(Animator paramAnimator)
  {
    paramAnimator.setStartDelay(a);
    paramAnimator.setDuration(b);
    paramAnimator.setInterpolator(a());
    if ((paramAnimator instanceof ValueAnimator))
    {
      paramAnimator = (ValueAnimator)paramAnimator;
      paramAnimator.setRepeatCount(d);
      paramAnimator.setRepeatMode(e);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (h.class == paramObject.getClass()))
    {
      paramObject = (h)paramObject;
      if (a != a) {
        return false;
      }
      if (b != b) {
        return false;
      }
      if (d != d) {
        return false;
      }
      if (e != e) {
        return false;
      }
      return a().getClass().equals(((h)paramObject).a().getClass());
    }
    return false;
  }
  
  public int hashCode()
  {
    long l = a;
    int i = (int)(l ^ l >>> 32);
    l = b;
    int j = (int)(l ^ l >>> 32);
    return ((a().getClass().hashCode() + (i * 31 + j) * 31) * 31 + d) * 31 + e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('\n');
    localStringBuilder.append(h.class.getName());
    localStringBuilder.append('{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" delay: ");
    localStringBuilder.append(a);
    localStringBuilder.append(" duration: ");
    localStringBuilder.append(b);
    localStringBuilder.append(" interpolator: ");
    localStringBuilder.append(a().getClass());
    localStringBuilder.append(" repeatCount: ");
    localStringBuilder.append(d);
    localStringBuilder.append(" repeatMode: ");
    return e.a.a.a.a.a(localStringBuilder, e, "}\n");
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.b.a.h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */