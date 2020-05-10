package d.s;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@p.b("activity")
public class a
  extends p<a.a>
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
    return new a.a(this);
  }
  
  public i a(i parami, Bundle paramBundle, n paramn, p.a parama)
  {
    a.a locala = (a.a)parami;
    if (F != null)
    {
      parami = new Intent(F);
      if (paramBundle != null)
      {
        parami.putExtras(paramBundle);
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
          parami.setData(Uri.parse(localStringBuffer.toString()));
        }
      }
      boolean bool = parama instanceof a.b;
      int i = 0;
      if (bool) {
        if ((a.b)parama != null) {
          parami.addFlags(0);
        } else {
          throw null;
        }
      }
      if (!(a instanceof Activity)) {
        parami.addFlags(268435456);
      }
      if ((paramn != null) && (a)) {
        parami.addFlags(536870912);
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
            parami.putExtra("android-support-navigation:ActivityNavigator:source", j);
          }
        }
      }
      parami.putExtra("android-support-navigation:ActivityNavigator:current", z);
      if (paramn != null)
      {
        parami.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", f);
        parami.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", g);
      }
      if (bool)
      {
        if ((a.b)parama != null) {
          a.startActivity(parami);
        } else {
          throw null;
        }
      }
      else {
        a.startActivity(parami);
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
    throw new IllegalStateException(e.a.a.a.a.a(e.a.a.a.a.a("Destination "), z, " does not have an Intent set."));
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
}

/* Location:
 * Qualified Name:     base.d.s.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */