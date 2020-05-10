package d.s;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.navigation.R.styleable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@p.b("activity")
public class a
  extends p<a>
{
  public Context a;
  public Activity b;
  
  public a(Context paramContext)
  {
    a = paramContext;
    while ((paramContext instanceof ContextWrapper))
    {
      if ((paramContext instanceof Activity))
      {
        b = ((Activity)paramContext);
        break;
      }
      paramContext = ((ContextWrapper)paramContext).getBaseContext();
    }
  }
  
  public i a()
  {
    return new a(this);
  }
  
  public i a(i parami, Bundle paramBundle, n paramn, p.a parama)
  {
    parami = (a)parami;
    if (F != null)
    {
      Intent localIntent = new Intent(F);
      if (paramBundle != null)
      {
        localIntent.putExtras(paramBundle);
        String str1 = G;
        if (!TextUtils.isEmpty(str1))
        {
          StringBuffer localStringBuffer = new StringBuffer();
          Matcher localMatcher = Pattern.compile("\\{(.+?)\\}").matcher(str1);
          while (localMatcher.find())
          {
            String str2 = localMatcher.group(1);
            if (paramBundle.containsKey(str2))
            {
              localMatcher.appendReplacement(localStringBuffer, "");
              localStringBuffer.append(Uri.encode(paramBundle.get(str2).toString()));
            }
            else
            {
              parami = new StringBuilder();
              parami.append("Could not find ");
              parami.append(str2);
              parami.append(" in ");
              parami.append(paramBundle);
              parami.append(" to fill data pattern ");
              parami.append(str1);
              throw new IllegalArgumentException(parami.toString());
            }
          }
          localMatcher.appendTail(localStringBuffer);
          localIntent.setData(Uri.parse(localStringBuffer.toString()));
        }
      }
      boolean bool = parama instanceof b;
      int i = 0;
      if (bool) {
        if ((b)parama != null) {
          localIntent.addFlags(0);
        } else {
          throw null;
        }
      }
      if (!(a instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      if ((paramn != null) && (a)) {
        localIntent.addFlags(536870912);
      }
      paramBundle = b;
      int j;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getIntent();
        if (paramBundle != null)
        {
          j = paramBundle.getIntExtra("android-support-navigation:ActivityNavigator:current", 0);
          if (j != 0) {
            localIntent.putExtra("android-support-navigation:ActivityNavigator:source", j);
          }
        }
      }
      localIntent.putExtra("android-support-navigation:ActivityNavigator:current", z);
      if (paramn != null)
      {
        localIntent.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", f);
        localIntent.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", g);
      }
      if (bool)
      {
        if ((b)parama != null) {
          a.startActivity(localIntent);
        } else {
          throw null;
        }
      }
      else {
        a.startActivity(localIntent);
      }
      if ((paramn != null) && (b != null))
      {
        j = d;
        int k = e;
        if ((j != -1) || (k != -1))
        {
          if (j == -1) {
            j = 0;
          }
          if (k != -1) {
            i = k;
          }
          b.overridePendingTransition(j, i);
        }
      }
      return null;
    }
    paramBundle = e.a.a.a.a.a("Destination ");
    paramBundle.append(z);
    paramBundle.append(" does not have an Intent set.");
    throw new IllegalStateException(paramBundle.toString());
  }
  
  public boolean c()
  {
    Activity localActivity = b;
    if (localActivity != null)
    {
      localActivity.finish();
      return true;
    }
    return false;
  }
  
  public static class a
    extends i
  {
    public Intent F;
    public String G;
    
    public a(p<? extends a> paramp)
    {
      super();
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
  
  public static final class b
    implements p.a
  {}
}

/* Location:
 * Qualified Name:     d.s.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */