package d.i.g;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.PrecomputedText.Params;
import android.text.PrecomputedText.Params.Builder;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.Locale;
import java.util.Objects;

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
  
  public static final class a
  {
    public final TextPaint a;
    public final TextDirectionHeuristic b;
    public final int c;
    public final int d;
    
    public a(PrecomputedText.Params paramParams)
    {
      a = paramParams.getTextPaint();
      b = paramParams.getTextDirection();
      c = paramParams.getBreakStrategy();
      d = paramParams.getHyphenationFrequency();
      int i = Build.VERSION.SDK_INT;
    }
    
    @SuppressLint({"NewApi"})
    public a(TextPaint paramTextPaint, TextDirectionHeuristic paramTextDirectionHeuristic, int paramInt1, int paramInt2)
    {
      if (Build.VERSION.SDK_INT >= 29) {
        new PrecomputedText.Params.Builder(paramTextPaint).setBreakStrategy(paramInt1).setHyphenationFrequency(paramInt2).setTextDirection(paramTextDirectionHeuristic).build();
      }
      a = paramTextPaint;
      b = paramTextDirectionHeuristic;
      c = paramInt1;
      d = paramInt2;
    }
    
    public boolean a(a parama)
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        if (c != c) {
          return false;
        }
        if (d != d) {
          return false;
        }
      }
      if (a.getTextSize() != a.getTextSize()) {
        return false;
      }
      if (a.getTextScaleX() != a.getTextScaleX()) {
        return false;
      }
      if (a.getTextSkewX() != a.getTextSkewX()) {
        return false;
      }
      if (a.getLetterSpacing() != a.getLetterSpacing()) {
        return false;
      }
      if (!TextUtils.equals(a.getFontFeatureSettings(), a.getFontFeatureSettings())) {
        return false;
      }
      if (a.getFlags() != a.getFlags()) {
        return false;
      }
      if (Build.VERSION.SDK_INT >= 24)
      {
        if (!a.getTextLocales().equals(a.getTextLocales())) {
          return false;
        }
      }
      else if (!a.getTextLocale().equals(a.getTextLocale())) {
        return false;
      }
      if (a.getTypeface() == null)
      {
        if (a.getTypeface() != null) {
          return false;
        }
      }
      else if (!a.getTypeface().equals(a.getTypeface())) {
        return false;
      }
      return true;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof a)) {
        return false;
      }
      paramObject = (a)paramObject;
      if (!a((a)paramObject)) {
        return false;
      }
      return b == b;
    }
    
    public int hashCode()
    {
      if (Build.VERSION.SDK_INT >= 24) {
        return Objects.hash(new Object[] { Float.valueOf(a.getTextSize()), Float.valueOf(a.getTextScaleX()), Float.valueOf(a.getTextSkewX()), Float.valueOf(a.getLetterSpacing()), Integer.valueOf(a.getFlags()), a.getTextLocales(), a.getTypeface(), Boolean.valueOf(a.isElegantTextHeight()), b, Integer.valueOf(c), Integer.valueOf(d) });
      }
      return Objects.hash(new Object[] { Float.valueOf(a.getTextSize()), Float.valueOf(a.getTextScaleX()), Float.valueOf(a.getTextSkewX()), Float.valueOf(a.getLetterSpacing()), Integer.valueOf(a.getFlags()), a.getTextLocale(), a.getTypeface(), Boolean.valueOf(a.isElegantTextHeight()), b, Integer.valueOf(c), Integer.valueOf(d) });
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder1 = new StringBuilder("{");
      StringBuilder localStringBuilder2 = e.a.a.a.a.a("textSize=");
      localStringBuilder2.append(a.getTextSize());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", textScaleX=");
      localStringBuilder2.append(a.getTextScaleX());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", textSkewX=");
      localStringBuilder2.append(a.getTextSkewX());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", letterSpacing=");
      localStringBuilder2.append(a.getLetterSpacing());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", elegantTextHeight=");
      localStringBuilder2.append(a.isElegantTextHeight());
      localStringBuilder1.append(localStringBuilder2.toString());
      if (Build.VERSION.SDK_INT >= 24)
      {
        localStringBuilder2 = e.a.a.a.a.a(", textLocale=");
        localStringBuilder2.append(a.getTextLocales());
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      else
      {
        localStringBuilder2 = e.a.a.a.a.a(", textLocale=");
        localStringBuilder2.append(a.getTextLocale());
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      localStringBuilder2 = e.a.a.a.a.a(", typeface=");
      localStringBuilder2.append(a.getTypeface());
      localStringBuilder1.append(localStringBuilder2.toString());
      if (Build.VERSION.SDK_INT >= 26)
      {
        localStringBuilder2 = e.a.a.a.a.a(", variationSettings=");
        localStringBuilder2.append(a.getFontVariationSettings());
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      localStringBuilder2 = e.a.a.a.a.a(", textDir=");
      localStringBuilder2.append(b);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", breakStrategy=");
      localStringBuilder2.append(c);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", hyphenationFrequency=");
      localStringBuilder2.append(d);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder1.append("}");
      return localStringBuilder1.toString();
    }
  }
}

/* Location:
 * Qualified Name:     d.i.g.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */