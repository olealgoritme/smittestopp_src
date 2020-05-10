package d.s.r;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.navigation.fragment.R.styleable;
import d.s.i;
import d.s.p;

public class a$a
  extends i
{
  public String F;
  
  public a$a(p<? extends a> paramp)
  {
    super(paramp);
  }
  
  public void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.FragmentNavigator);
    paramContext = paramAttributeSet.getString(R.styleable.FragmentNavigator_android_name);
    if (paramContext != null) {
      F = paramContext;
    }
    paramAttributeSet.recycle();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" class=");
    String str = F;
    if (str == null) {
      localStringBuilder.append("null");
    } else {
      localStringBuilder.append(str);
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     base.d.s.r.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */