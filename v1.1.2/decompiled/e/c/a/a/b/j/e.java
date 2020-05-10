package e.c.a.a.b.j;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import d.f.h;
import e.c.a.a.b.f;
import e.c.a.a.b.l.c;
import e.c.a.a.b.m.a;
import e.c.a.a.b.m.b;
import javax.annotation.concurrent.GuardedBy;

public final class e
{
  @GuardedBy("sCache")
  public static final h<String, String> a = new h();
  
  public static String a(Context paramContext)
  {
    String str = paramContext.getPackageName();
    try
    {
      Object localObject = b.b(paramContext);
      localObject = a.getPackageManager().getApplicationLabel(a.getPackageManager().getApplicationInfo(str, 0)).toString();
      return (String)localObject;
    }
    catch (PackageManager.NameNotFoundException|NullPointerException localNameNotFoundException)
    {
      paramContext = getApplicationInfoname;
      if (TextUtils.isEmpty(paramContext)) {
        return str;
      }
    }
    return paramContext;
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    String str = a(paramContext);
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 5)
          {
            if (paramInt != 7)
            {
              if (paramInt != 9)
              {
                if (paramInt != 20)
                {
                  switch (paramInt)
                  {
                  default: 
                    return localResources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue, new Object[] { str });
                  case 18: 
                    return localResources.getString(com.google.android.gms.base.R.string.common_google_play_services_updating_text, new Object[] { str });
                  case 17: 
                    return a(paramContext, "common_google_play_services_sign_in_failed_text", str);
                  }
                  return a(paramContext, "common_google_play_services_api_unavailable_text", str);
                }
                return a(paramContext, "common_google_play_services_restricted_profile_text", str);
              }
              return localResources.getString(com.google.android.gms.base.R.string.common_google_play_services_unsupported_text, new Object[] { str });
            }
            return a(paramContext, "common_google_play_services_network_error_text", str);
          }
          return a(paramContext, "common_google_play_services_invalid_account_text", str);
        }
        return localResources.getString(com.google.android.gms.base.R.string.common_google_play_services_enable_text, new Object[] { str });
      }
      if (c.e(paramContext)) {
        return localResources.getString(com.google.android.gms.base.R.string.common_google_play_services_wear_update_text);
      }
      return localResources.getString(com.google.android.gms.base.R.string.common_google_play_services_update_text, new Object[] { str });
    }
    return localResources.getString(com.google.android.gms.base.R.string.common_google_play_services_install_text, new Object[] { str });
  }
  
  public static String a(Context paramContext, String paramString)
  {
    synchronized (a)
    {
      String str = (String)a.getOrDefault(paramString, null);
      if (str != null) {
        return str;
      }
      paramContext = f.a(paramContext);
      if (paramContext == null) {
        return null;
      }
      int i = paramContext.getIdentifier(paramString, "string", "com.google.android.gms");
      if (i == 0)
      {
        paramContext = String.valueOf(paramString);
        if (paramContext.length() != 0) {
          paramContext = "Missing resource: ".concat(paramContext);
        } else {
          paramContext = new String("Missing resource: ");
        }
        Log.w("GoogleApiAvailability", paramContext);
        return null;
      }
      paramContext = paramContext.getString(i);
      if (TextUtils.isEmpty(paramContext))
      {
        paramContext = String.valueOf(paramString);
        if (paramContext.length() != 0) {
          paramContext = "Got empty resource: ".concat(paramContext);
        } else {
          paramContext = new String("Got empty resource: ");
        }
        Log.w("GoogleApiAvailability", paramContext);
        return null;
      }
      a.put(paramString, paramContext);
      return paramContext;
    }
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    Resources localResources = paramContext.getResources();
    paramString1 = a(paramContext, paramString1);
    paramContext = paramString1;
    if (paramString1 == null) {
      paramContext = localResources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue);
    }
    return String.format(getConfigurationlocale, paramContext, new Object[] { paramString2 });
  }
  
  public static String b(Context paramContext)
  {
    return paramContext.getResources().getString(com.google.android.gms.base.R.string.common_google_play_services_notification_channel_name);
  }
  
  public static String b(Context paramContext, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    switch (paramInt)
    {
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 19: 
    default: 
      paramContext = new StringBuilder(33);
      paramContext.append("Unexpected error code ");
      paramContext.append(paramInt);
      Log.e("GoogleApiAvailability", paramContext.toString());
      return null;
    case 20: 
      Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
      return a(paramContext, "common_google_play_services_restricted_profile_title");
    case 17: 
      Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
      return a(paramContext, "common_google_play_services_sign_in_failed_title");
    case 16: 
      Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
      return null;
    case 11: 
      Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
      return null;
    case 10: 
      Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
      return null;
    case 9: 
      Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
      return null;
    case 8: 
      Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
      return null;
    case 7: 
      Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
      return a(paramContext, "common_google_play_services_network_error_title");
    case 5: 
      Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
      return a(paramContext, "common_google_play_services_invalid_account_title");
    case 4: 
    case 6: 
    case 18: 
      return null;
    case 3: 
      return localResources.getString(com.google.android.gms.base.R.string.common_google_play_services_enable_title);
    case 2: 
      return localResources.getString(com.google.android.gms.base.R.string.common_google_play_services_update_title);
    }
    return localResources.getString(com.google.android.gms.base.R.string.common_google_play_services_install_title);
  }
}

/* Location:
 * Qualified Name:     e.c.a.a.b.j.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */