package d.i.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;

public class a
{
  public static final Object a = new Object();
  
  public static int a(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColor(paramInt);
    }
    return paramContext.getResources().getColor(paramInt);
  }
  
  public static int a(Context paramContext, String paramString)
  {
    if (paramString != null) {
      return paramContext.checkPermission(paramString, Process.myPid(), Process.myUid());
    }
    throw new IllegalArgumentException("permission is null");
  }
  
  public static void a(Context paramContext, Intent paramIntent, Bundle paramBundle)
  {
    paramContext.startActivity(paramIntent, paramBundle);
  }
  
  public static boolean a(Context paramContext, Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    paramContext.startActivities(paramArrayOfIntent, paramBundle);
    return true;
  }
  
  public static ColorStateList b(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColorStateList(paramInt);
    }
    return paramContext.getResources().getColorStateList(paramInt);
  }
  
  public static Drawable c(Context paramContext, int paramInt)
  {
    return paramContext.getDrawable(paramInt);
  }
}

/* Location:
 * Qualified Name:     base.d.i.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */