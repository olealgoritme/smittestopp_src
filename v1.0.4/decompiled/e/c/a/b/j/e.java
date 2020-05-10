package e.c.a.b.j;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R.attr;
import com.google.android.material.R.styleable;
import e.a.a.a.a;

public final class e
{
  public static final int[] a = { R.attr.colorPrimary };
  public static final int[] b = { R.attr.colorSecondary };
  
  public static void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ThemeEnforcement, paramInt1, paramInt2);
    boolean bool = paramAttributeSet.getBoolean(R.styleable.ThemeEnforcement_enforceMaterialTheme, false);
    paramAttributeSet.recycle();
    if (bool) {
      a(paramContext, b, "Theme.MaterialComponents");
    }
    a(paramContext, a, "Theme.AppCompat");
  }
  
  public static void a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int... paramVarArgs)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ThemeEnforcement, paramInt1, paramInt2);
    int i = R.styleable.ThemeEnforcement_enforceTextAppearance;
    int j = 0;
    if (!localTypedArray.getBoolean(i, false))
    {
      localTypedArray.recycle();
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
      paramInt2 = paramVarArgs.length;
      for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
        if (paramContext.getResourceId(paramVarArgs[paramInt1], -1) == -1)
        {
          paramContext.recycle();
          paramInt1 = j;
          break label132;
        }
      }
      paramContext.recycle();
    }
    do
    {
      paramInt1 = 1;
      break;
      paramInt1 = j;
    } while (localTypedArray.getResourceId(R.styleable.ThemeEnforcement_android_textAppearance, -1) != -1);
    label132:
    localTypedArray.recycle();
    if (paramInt1 != 0) {
      return;
    }
    throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
  }
  
  public static void a(Context paramContext, int[] paramArrayOfInt, String paramString)
  {
    paramContext = paramContext.obtainStyledAttributes(paramArrayOfInt);
    boolean bool = paramContext.hasValue(0);
    paramContext.recycle();
    if (bool) {
      return;
    }
    throw new IllegalArgumentException(a.a("The style on this component requires your app theme to be ", paramString, " (or a descendant)."));
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.b.j.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */