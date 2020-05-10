package d.i.g;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.style.MetricAffectingSpan;

public class a
  implements Spannable
{
  public char charAt(int paramInt)
  {
    throw null;
  }
  
  public int getSpanEnd(Object paramObject)
  {
    throw null;
  }
  
  public int getSpanFlags(Object paramObject)
  {
    throw null;
  }
  
  public int getSpanStart(Object paramObject)
  {
    throw null;
  }
  
  @SuppressLint({"NewApi"})
  public <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      throw null;
    }
    throw null;
  }
  
  public int length()
  {
    throw null;
  }
  
  public int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
  {
    throw null;
  }
  
  @SuppressLint({"NewApi"})
  public void removeSpan(Object paramObject)
  {
    if (!(paramObject instanceof MetricAffectingSpan))
    {
      if (Build.VERSION.SDK_INT >= 29) {
        throw null;
      }
      throw null;
    }
    throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
  }
  
  @SuppressLint({"NewApi"})
  public void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!(paramObject instanceof MetricAffectingSpan))
    {
      if (Build.VERSION.SDK_INT >= 29) {
        throw null;
      }
      throw null;
    }
    throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
  }
  
  public CharSequence subSequence(int paramInt1, int paramInt2)
  {
    throw null;
  }
  
  public String toString()
  {
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.d.i.g.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */