package d.i.a;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

public class a
  extends d.i.b.a
{
  public static <T extends View> T a(Activity paramActivity, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramActivity.requireViewById(paramInt);
    }
    paramActivity = paramActivity.findViewById(paramInt);
    if (paramActivity != null) {
      return paramActivity;
    }
    throw new IllegalArgumentException("ID does not reference a View inside this Activity");
  }
  
  public static a.c a()
  {
    return null;
  }
  
  public static void a(Activity paramActivity)
  {
    paramActivity.finishAffinity();
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    paramActivity.startActivityForResult(paramIntent, paramInt, paramBundle);
  }
  
  public static void a(Activity paramActivity, IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
  }
  
  public static void a(Activity paramActivity, String[] paramArrayOfString, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if ((paramActivity instanceof a.d)) {
        ((a.d)paramActivity).validateRequestPermissionsRequestCode(paramInt);
      }
      paramActivity.requestPermissions(paramArrayOfString, paramInt);
    }
    else if ((paramActivity instanceof a.b))
    {
      new Handler(Looper.getMainLooper()).post(new a.a(paramArrayOfString, paramActivity, paramInt));
    }
  }
  
  public static boolean a(Activity paramActivity, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramActivity.shouldShowRequestPermissionRationale(paramString);
    }
    return false;
  }
  
  public static void b(Activity paramActivity)
  {
    paramActivity.finishAfterTransition();
  }
  
  public static void c(Activity paramActivity)
  {
    paramActivity.postponeEnterTransition();
  }
  
  public static void d(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      paramActivity.recreate();
    } else if (!b.a(paramActivity)) {
      paramActivity.recreate();
    }
  }
  
  public static void e(Activity paramActivity)
  {
    paramActivity.setEnterSharedElementCallback(null);
  }
  
  public static void f(Activity paramActivity)
  {
    paramActivity.setExitSharedElementCallback(null);
  }
  
  public static void g(Activity paramActivity)
  {
    paramActivity.startPostponedEnterTransition();
  }
}

/* Location:
 * Qualified Name:     base.d.i.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */