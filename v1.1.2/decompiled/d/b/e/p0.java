package d.b.e;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.TypedValue;

public class p0
{
  public static final ThreadLocal<TypedValue> a = new ThreadLocal();
  public static final int[] b = { -16842910 };
  public static final int[] c = { 16842908 };
  public static final int[] d = { 16842919 };
  public static final int[] e = { 16842912 };
  public static final int[] f = new int[0];
  public static final int[] g = new int[1];
  
  public static int a(Context paramContext, int paramInt)
  {
    Object localObject = c(paramContext, paramInt);
    if ((localObject != null) && (((ColorStateList)localObject).isStateful())) {
      return ((ColorStateList)localObject).getColorForState(b, ((ColorStateList)localObject).getDefaultColor());
    }
    TypedValue localTypedValue = (TypedValue)a.get();
    localObject = localTypedValue;
    if (localTypedValue == null)
    {
      localObject = new TypedValue();
      a.set(localObject);
    }
    paramContext.getTheme().resolveAttribute(16842803, (TypedValue)localObject, true);
    float f1 = ((TypedValue)localObject).getFloat();
    paramInt = b(paramContext, paramInt);
    return d.i.c.a.b(paramInt, Math.round(Color.alpha(paramInt) * f1));
  }
  
  public static int b(Context paramContext, int paramInt)
  {
    Object localObject = g;
    localObject[0] = paramInt;
    localObject = paramContext.obtainStyledAttributes(null, (int[])localObject);
    try
    {
      paramInt = ((TypedArray)localObject).getColor(0, 0);
      return paramInt;
    }
    finally
    {
      ((TypedArray)localObject).recycle();
    }
  }
  
  public static ColorStateList c(Context paramContext, int paramInt)
  {
    Object localObject = g;
    localObject[0] = paramInt;
    localObject = paramContext.obtainStyledAttributes(null, (int[])localObject);
    try
    {
      if (((TypedArray)localObject).hasValue(0))
      {
        paramInt = ((TypedArray)localObject).getResourceId(0, 0);
        if (paramInt != 0)
        {
          paramContext = d.b.b.a.a.b(paramContext, paramInt);
          if (paramContext != null) {
            break label57;
          }
        }
      }
      paramContext = ((TypedArray)localObject).getColorStateList(0);
    }
    finally
    {
      break label63;
    }
    label57:
    ((TypedArray)localObject).recycle();
    return paramContext;
    label63:
    ((TypedArray)localObject).recycle();
    throw paramContext;
  }
}

/* Location:
 * Qualified Name:     d.b.e.p0
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */