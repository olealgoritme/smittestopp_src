package e.c.a.a.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.base.R.drawable;
import com.google.android.gms.base.R.string;
import com.google.android.gms.common.SupportErrorDialogFragment;
import d.b.a.s;
import d.i.a.f;
import e.c.a.a.b.j.u;
import java.util.concurrent.atomic.AtomicBoolean;

public class d
  extends e
{
  public static final Object b = new Object();
  public static final d c = new d();
  
  public int a(Context paramContext, int paramInt)
  {
    return super.a(paramContext, paramInt);
  }
  
  public Intent a(Context paramContext, int paramInt, String paramString)
  {
    return super.a(paramContext, paramInt, paramString);
  }
  
  public final String a()
  {
    synchronized (b)
    {
      return null;
    }
  }
  
  @TargetApi(20)
  public final void a(Context paramContext, int paramInt, PendingIntent paramPendingIntent)
  {
    if (paramInt == 18)
    {
      new a(paramContext).sendEmptyMessageDelayed(1, 120000L);
      return;
    }
    if (paramPendingIntent == null)
    {
      if (paramInt == 6) {
        Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
      }
      return;
    }
    String str;
    if (paramInt == 6) {
      str = e.c.a.a.b.j.e.a(paramContext, "common_google_play_services_resolution_required_title");
    } else {
      str = e.c.a.a.b.j.e.b(paramContext, paramInt);
    }
    Object localObject = str;
    if (str == null) {
      localObject = paramContext.getResources().getString(R.string.common_google_play_services_notification_ticker);
    }
    if (paramInt == 6) {
      str = e.c.a.a.b.j.e.a(paramContext, "common_google_play_services_resolution_required_text", e.c.a.a.b.j.e.a(paramContext));
    } else {
      str = e.c.a.a.b.j.e.a(paramContext, paramInt);
    }
    Resources localResources = paramContext.getResources();
    NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
    d.i.a.e locale = new d.i.a.e(paramContext);
    x = true;
    locale.a(true);
    locale.b((CharSequence)localObject);
    localObject = new d.i.a.d();
    c = d.i.a.e.c(str);
    if (o != localObject)
    {
      o = ((f)localObject);
      if (a != locale)
      {
        a = locale;
        locale.a((f)localObject);
      }
    }
    if (e.c.a.a.b.l.c.d(paramContext))
    {
      int i = getApplicationInfoicon;
      O.icon = i;
      l = 2;
      if (e.c.a.a.b.l.c.e(paramContext)) {
        locale.a(R.drawable.common_full_open_on_phone, localResources.getString(R.string.common_open_on_phone), paramPendingIntent);
      } else {
        f = paramPendingIntent;
      }
    }
    else
    {
      O.icon = 17301642;
      localObject = localResources.getString(R.string.common_google_play_services_notification_ticker);
      O.tickerText = d.i.a.e.c((CharSequence)localObject);
      long l = System.currentTimeMillis();
      O.when = l;
      f = paramPendingIntent;
      locale.a(str);
    }
    if (e.c.a.a.b.l.c.d()) {
      if (e.c.a.a.b.l.c.d())
      {
        a();
        paramPendingIntent = localNotificationManager.getNotificationChannel("com.google.android.gms.availability");
        paramContext = e.c.a.a.b.j.e.b(paramContext);
        if (paramPendingIntent == null)
        {
          localNotificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", paramContext, 4));
        }
        else if (!paramContext.contentEquals(paramPendingIntent.getName()))
        {
          paramPendingIntent.setName(paramContext);
          localNotificationManager.createNotificationChannel(paramPendingIntent);
        }
        I = "com.google.android.gms.availability";
      }
      else
      {
        throw new IllegalStateException();
      }
    }
    paramContext = locale.a();
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
    {
      paramInt = 39789;
    }
    else
    {
      paramInt = 10436;
      g.b.set(false);
    }
    localNotificationManager.notify(paramInt, paramContext);
  }
  
  public boolean a(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    u localu = new u(super.a(paramActivity, paramInt1, "d"), paramActivity, paramInt2);
    Object localObject1;
    Object localObject2;
    if (paramInt1 == 0)
    {
      localObject1 = null;
    }
    else
    {
      localObject1 = new TypedValue();
      paramActivity.getTheme().resolveAttribute(16843529, (TypedValue)localObject1, true);
      if ("Theme.Dialog.Alert".equals(paramActivity.getResources().getResourceEntryName(resourceId))) {
        localObject1 = new AlertDialog.Builder(paramActivity, 5);
      } else {
        localObject1 = null;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new AlertDialog.Builder(paramActivity);
      }
      ((AlertDialog.Builder)localObject2).setMessage(e.c.a.a.b.j.e.a(paramActivity, paramInt1));
      if (paramOnCancelListener != null) {
        ((AlertDialog.Builder)localObject2).setOnCancelListener(paramOnCancelListener);
      }
      localObject1 = paramActivity.getResources();
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 3) {
            localObject1 = ((Resources)localObject1).getString(17039370);
          } else {
            localObject1 = ((Resources)localObject1).getString(R.string.common_google_play_services_enable_button);
          }
        }
        else {
          localObject1 = ((Resources)localObject1).getString(R.string.common_google_play_services_update_button);
        }
      }
      else {
        localObject1 = ((Resources)localObject1).getString(R.string.common_google_play_services_install_button);
      }
      if (localObject1 != null) {
        ((AlertDialog.Builder)localObject2).setPositiveButton((CharSequence)localObject1, localu);
      }
      localObject1 = e.c.a.a.b.j.e.b(paramActivity, paramInt1);
      if (localObject1 != null) {
        ((AlertDialog.Builder)localObject2).setTitle((CharSequence)localObject1);
      }
      localObject1 = ((AlertDialog.Builder)localObject2).create();
    }
    if (localObject1 == null) {
      return false;
    }
    if ((paramActivity instanceof d.m.a.c))
    {
      paramActivity = ((d.m.a.c)paramActivity).getSupportFragmentManager();
      localObject2 = new SupportErrorDialogFragment();
      s.b(localObject1, "Cannot display null dialog");
      ((Dialog)localObject1).setOnCancelListener(null);
      ((Dialog)localObject1).setOnDismissListener(null);
      K = ((Dialog)localObject1);
      if (paramOnCancelListener != null) {
        L = paramOnCancelListener;
      }
      ((SupportErrorDialogFragment)localObject2).a(paramActivity, "GooglePlayServicesErrorDialog");
    }
    else
    {
      localObject2 = paramActivity.getFragmentManager();
      paramActivity = new b();
      s.b(localObject1, "Cannot display null dialog");
      ((Dialog)localObject1).setOnCancelListener(null);
      ((Dialog)localObject1).setOnDismissListener(null);
      x = ((Dialog)localObject1);
      if (paramOnCancelListener != null) {
        y = paramOnCancelListener;
      }
      paramActivity.show((FragmentManager)localObject2, "GooglePlayServicesErrorDialog");
    }
    return true;
  }
  
  @SuppressLint({"HandlerLeak"})
  public final class a
    extends e.c.a.a.d.a.c
  {
    public final Context a;
    
    public a(Context paramContext)
    {
      super();
      a = paramContext.getApplicationContext();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int i = what;
      if (i != 1)
      {
        paramMessage = new StringBuilder(50);
        paramMessage.append("Don't know how to handle this message: ");
        paramMessage.append(i);
        Log.w("GoogleApiAvailability", paramMessage.toString());
      }
      else
      {
        i = a(a, e.a);
        d locald = d.this;
        paramMessage = null;
        if (locald == null) {
          break label129;
        }
        if (g.b(i))
        {
          locald = d.this;
          Context localContext = a;
          Intent localIntent = locald.a(localContext, i, "n");
          if (localIntent != null) {
            paramMessage = PendingIntent.getActivity(localContext, 0, localIntent, 134217728);
          }
          locald.a(localContext, i, paramMessage);
        }
      }
      return;
      label129:
      throw null;
    }
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */