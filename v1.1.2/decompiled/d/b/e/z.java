package d.b.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

public class z
{
  public static final RectF k = new RectF();
  public static ConcurrentHashMap<String, Method> l = new ConcurrentHashMap();
  public int a = 0;
  public boolean b = false;
  public float c = -1.0F;
  public float d = -1.0F;
  public float e = -1.0F;
  public int[] f = new int[0];
  public boolean g = false;
  public TextPaint h;
  public final TextView i;
  public final Context j;
  
  public z(TextView paramTextView)
  {
    i = paramTextView;
    j = paramTextView.getContext();
  }
  
  public final int a(RectF paramRectF)
  {
    int m = f.length;
    if (m != 0)
    {
      int n = m - 1;
      m = 1;
      int i1 = 0;
      while (m <= n)
      {
        int i2 = (m + n) / 2;
        i1 = f[i2];
        Object localObject1 = i.getText();
        Object localObject2 = i.getTransformationMethod();
        Object localObject3 = localObject1;
        if (localObject2 != null)
        {
          localObject2 = ((TransformationMethod)localObject2).getTransformation((CharSequence)localObject1, i);
          localObject3 = localObject1;
          if (localObject2 != null) {
            localObject3 = localObject2;
          }
        }
        int i3 = i.getMaxLines();
        localObject1 = h;
        if (localObject1 == null) {
          h = new TextPaint();
        } else {
          ((TextPaint)localObject1).reset();
        }
        h.set(i.getPaint());
        h.setTextSize(i1);
        localObject2 = (Layout.Alignment)a(i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
        if (Build.VERSION.SDK_INT >= 23)
        {
          i1 = Math.round(right);
          localObject1 = (TextDirectionHeuristic)a(i, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
          localObject2 = StaticLayout.Builder.obtain((CharSequence)localObject3, 0, ((CharSequence)localObject3).length(), h, i1).setAlignment((Layout.Alignment)localObject2).setLineSpacing(i.getLineSpacingExtra(), i.getLineSpacingMultiplier()).setIncludePad(i.getIncludeFontPadding()).setBreakStrategy(i.getBreakStrategy()).setHyphenationFrequency(i.getHyphenationFrequency());
          if (i3 == -1) {
            i1 = Integer.MAX_VALUE;
          } else {
            i1 = i3;
          }
          localObject1 = ((StaticLayout.Builder)localObject2).setMaxLines(i1).setTextDirection((TextDirectionHeuristic)localObject1).build();
        }
        else
        {
          i1 = Math.round(right);
          float f1 = i.getLineSpacingMultiplier();
          float f2 = i.getLineSpacingExtra();
          boolean bool = i.getIncludeFontPadding();
          localObject1 = new StaticLayout((CharSequence)localObject3, h, i1, (Layout.Alignment)localObject2, f1, f2, bool);
        }
        if (((i3 != -1) && ((((StaticLayout)localObject1).getLineCount() > i3) || (((StaticLayout)localObject1).getLineEnd(((StaticLayout)localObject1).getLineCount() - 1) != ((CharSequence)localObject3).length()))) || (((StaticLayout)localObject1).getHeight() > bottom)) {
          i1 = 0;
        } else {
          i1 = 1;
        }
        if (i1 != 0)
        {
          i1 = m;
          m = i2 + 1;
        }
        else
        {
          i1 = i2 - 1;
          n = i1;
        }
      }
      return f[i1];
    }
    throw new IllegalStateException("No available text sizes to choose from.");
  }
  
  /* Error */
  public final <T> T a(Object paramObject, String paramString, T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokevirtual 231	d/b/e/z:a	(Ljava/lang/String;)Ljava/lang/reflect/Method;
    //   5: aload_1
    //   6: iconst_0
    //   7: anewarray 4	java/lang/Object
    //   10: invokevirtual 237	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   13: astore_1
    //   14: aload_1
    //   15: astore_3
    //   16: goto +49 -> 65
    //   19: astore_1
    //   20: goto +47 -> 67
    //   23: astore 4
    //   25: new 239	java/lang/StringBuilder
    //   28: astore_1
    //   29: aload_1
    //   30: invokespecial 240	java/lang/StringBuilder:<init>	()V
    //   33: aload_1
    //   34: ldc -14
    //   36: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_1
    //   41: aload_2
    //   42: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_1
    //   47: ldc -8
    //   49: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc -6
    //   55: aload_1
    //   56: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: aload 4
    //   61: invokestatic 260	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   64: pop
    //   65: aload_3
    //   66: areturn
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	z
    //   0	69	1	paramObject	Object
    //   0	69	2	paramString	String
    //   0	69	3	paramT	T
    //   23	37	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	14	19	finally
    //   25	65	19	finally
    //   0	14	23	java/lang/Exception
  }
  
  public final Method a(String paramString)
  {
    try
    {
      localObject1 = (Method)l.get(paramString);
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = TextView.class.getDeclaredMethod(paramString, new Class[0]);
        localObject2 = localObject1;
        if (localObject1 != null)
        {
          ((Method)localObject1).setAccessible(true);
          l.put(paramString, localObject1);
          localObject2 = localObject1;
        }
      }
      return (Method)localObject2;
    }
    catch (Exception localException)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Failed to retrieve TextView#");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("() method");
      Log.w("ACTVAutoSizeHelper", ((StringBuilder)localObject1).toString(), localException);
    }
    return null;
  }
  
  public void a()
  {
    int m;
    if ((d()) && (a != 0)) {
      m = 1;
    } else {
      m = 0;
    }
    if (m == 0) {
      return;
    }
    if (b)
    {
      if ((i.getMeasuredHeight() > 0) && (i.getMeasuredWidth() > 0))
      {
        if (((Boolean)a(i, "getHorizontallyScrolling", Boolean.valueOf(false))).booleanValue()) {
          m = 1048576;
        } else {
          m = i.getMeasuredWidth() - i.getTotalPaddingLeft() - i.getTotalPaddingRight();
        }
        int n = i.getHeight() - i.getCompoundPaddingBottom() - i.getCompoundPaddingTop();
        if ((m > 0) && (n > 0)) {
          synchronized (k)
          {
            k.setEmpty();
            kright = m;
            kbottom = n;
            float f1 = a(k);
            if (f1 != i.getTextSize()) {
              a(0, f1);
            }
          }
        }
      }
      return;
    }
    b = true;
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > 0.0F)
    {
      if (paramFloat2 > paramFloat1)
      {
        if (paramFloat3 > 0.0F)
        {
          a = 1;
          d = paramFloat1;
          e = paramFloat2;
          c = paramFloat3;
          g = false;
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("The auto-size step granularity (");
        localStringBuilder.append(paramFloat3);
        localStringBuilder.append("px) is less or equal to (0px)");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Maximum auto-size text size (");
      localStringBuilder.append(paramFloat2);
      localStringBuilder.append("px) is less or equal to minimum auto-size ");
      localStringBuilder.append("text size (");
      localStringBuilder.append(paramFloat1);
      localStringBuilder.append("px)");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Minimum auto-size text size (");
    localStringBuilder.append(paramFloat1);
    localStringBuilder.append("px) is less or equal to (0px)");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void a(int paramInt, float paramFloat)
  {
    Object localObject = j;
    if (localObject == null) {
      localObject = Resources.getSystem();
    } else {
      localObject = ((Context)localObject).getResources();
    }
    paramFloat = TypedValue.applyDimension(paramInt, paramFloat, ((Resources)localObject).getDisplayMetrics());
    if (paramFloat != i.getPaint().getTextSize())
    {
      i.getPaint().setTextSize(paramFloat);
      boolean bool = i.isInLayout();
      if (i.getLayout() != null)
      {
        b = false;
        try
        {
          localObject = a("nullLayouts");
          if (localObject != null) {
            ((Method)localObject).invoke(i, new Object[0]);
          }
        }
        catch (Exception localException)
        {
          Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", localException);
        }
        if (!bool) {
          i.requestLayout();
        } else {
          i.forceLayout();
        }
        i.invalidate();
      }
    }
  }
  
  public final int[] a(int[] paramArrayOfInt)
  {
    int m = paramArrayOfInt.length;
    if (m == 0) {
      return paramArrayOfInt;
    }
    Arrays.sort(paramArrayOfInt);
    ArrayList localArrayList = new ArrayList();
    int n = 0;
    for (int i1 = 0; i1 < m; i1++)
    {
      int i2 = paramArrayOfInt[i1];
      if ((i2 > 0) && (Collections.binarySearch(localArrayList, Integer.valueOf(i2)) < 0)) {
        localArrayList.add(Integer.valueOf(i2));
      }
    }
    if (m == localArrayList.size()) {
      return paramArrayOfInt;
    }
    m = localArrayList.size();
    paramArrayOfInt = new int[m];
    for (i1 = n; i1 < m; i1++) {
      paramArrayOfInt[i1] = ((Integer)localArrayList.get(i1)).intValue();
    }
    return paramArrayOfInt;
  }
  
  public final boolean b()
  {
    boolean bool = d();
    int m = 0;
    if ((bool) && (a == 1))
    {
      if ((!g) || (f.length == 0))
      {
        float f1 = Math.round(d);
        int n = 1;
        while (Math.round(c + f1) <= Math.round(e))
        {
          n++;
          f1 += c;
        }
        int[] arrayOfInt = new int[n];
        f1 = d;
        while (m < n)
        {
          arrayOfInt[m] = Math.round(f1);
          f1 += c;
          m++;
        }
        f = a(arrayOfInt);
      }
      b = true;
    }
    else
    {
      b = false;
    }
    return b;
  }
  
  public final boolean c()
  {
    int m = f.length;
    boolean bool;
    if (m > 0) {
      bool = true;
    } else {
      bool = false;
    }
    g = bool;
    if (bool)
    {
      a = 1;
      int[] arrayOfInt = f;
      d = arrayOfInt[0];
      e = arrayOfInt[(m - 1)];
      c = -1.0F;
    }
    return g;
  }
  
  public final boolean d()
  {
    return i instanceof k ^ true;
  }
}

/* Location:
 * Qualified Name:     d.b.e.z
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */