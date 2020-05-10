package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import d.s.b;
import d.s.i;
import d.s.p;

public class DialogFragmentNavigator$a
  extends i
  implements b
{
  public String F;
  
  public DialogFragmentNavigator$a(p<? extends a> paramp)
  {
    super(paramp);
  }
  
  public void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.DialogFragmentNavigator);
    paramContext = paramAttributeSet.getString(R.styleable.DialogFragmentNavigator_android_name);
    if (paramContext != null) {
      F = paramContext;
    }
    paramAttributeSet.recycle();
  }
}

/* Location:
 * Qualified Name:     androidx.navigation.fragment.DialogFragmentNavigator.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */