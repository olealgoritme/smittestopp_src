package d.s;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import androidx.navigation.R.styleable;

public class a$a
  extends i
{
  public Intent F;
  public String G;
  
  public a$a(p<? extends a> paramp)
  {
    super(paramp);
  }
  
  public void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.ActivityNavigator);
    String str = localTypedArray.getString(R.styleable.ActivityNavigator_targetPackage);
    paramAttributeSet = str;
    if (str != null) {
      paramAttributeSet = str.replace("${applicationId}", paramContext.getPackageName());
    }
    if (F == null) {
      F = new Intent();
    }
    F.setPackage(paramAttributeSet);
    str = localTypedArray.getString(R.styleable.ActivityNavigator_android_name);
    if (str != null)
    {
      paramAttributeSet = str;
      if (str.charAt(0) == '.')
      {
        paramAttributeSet = new StringBuilder();
        paramAttributeSet.append(paramContext.getPackageName());
        paramAttributeSet.append(str);
        paramAttributeSet = paramAttributeSet.toString();
      }
      paramContext = new ComponentName(paramContext, paramAttributeSet);
      if (F == null) {
        F = new Intent();
      }
      F.setComponent(paramContext);
    }
    paramContext = localTypedArray.getString(R.styleable.ActivityNavigator_action);
    if (F == null) {
      F = new Intent();
    }
    F.setAction(paramContext);
    paramContext = localTypedArray.getString(R.styleable.ActivityNavigator_data);
    if (paramContext != null)
    {
      paramContext = Uri.parse(paramContext);
      if (F == null) {
        F = new Intent();
      }
      F.setData(paramContext);
    }
    G = localTypedArray.getString(R.styleable.ActivityNavigator_dataPattern);
    localTypedArray.recycle();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String toString()
  {
    Object localObject1 = F;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((Intent)localObject1).getComponent();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    if (localObject1 != null)
    {
      localStringBuilder.append(" class=");
      localStringBuilder.append(((ComponentName)localObject1).getClassName());
    }
    else
    {
      localObject1 = F;
      if (localObject1 == null) {
        localObject1 = localObject2;
      } else {
        localObject1 = ((Intent)localObject1).getAction();
      }
      if (localObject1 != null)
      {
        localStringBuilder.append(" action=");
        localStringBuilder.append((String)localObject1);
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     d.s.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */