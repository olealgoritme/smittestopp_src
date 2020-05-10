package com.microsoft.identity.common.internal.providers.oauth2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.telemetry.Telemetry;
import com.microsoft.identity.common.internal.telemetry.events.UiEndEvent;
import com.microsoft.identity.common.internal.util.StringUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class BrowserAuthorizationFragment
  extends AuthorizationFragment
{
  public static final String BROWSER_FLOW_STARTED = "browserFlowStarted";
  public static final String TAG = BrowserAuthorizationFragment.class.getSimpleName();
  public static Class<?> sCallingActivityClass;
  public static String sCustomTabResponseUri;
  public Intent mAuthIntent;
  public boolean mBrowserFlowStarted = false;
  
  private void completeAuthorizationInBrowserFlow(String paramString)
  {
    Logger.info(TAG, null, "Received redirect from customTab/browser.");
    Intent localIntent = createResultIntent(paramString);
    Object localObject = StringExtensions.getUrlParameters(paramString);
    String str = (String)((Map)localObject).get("username");
    if ((isDeviceRegisterRedirect(paramString)) && (!TextUtils.isEmpty(str)))
    {
      Logger.info(TAG, " Device needs to be registered, sending BROWSER_CODE_DEVICE_REGISTER");
      paramString = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Device Registration triggered for user: ");
      ((StringBuilder)localObject).append(str);
      Logger.infoPII(paramString, ((StringBuilder)localObject).toString());
      localIntent.putExtra("username", str);
      sendResult(2007, localIntent);
      return;
    }
    if (((Map)localObject).containsKey("app_link"))
    {
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)((Map)localObject).get("app_link"))));
      Logger.info(TAG, "Return to caller with BROKER_REQUEST_RESUME, and waiting for result.");
      sendResult(2006, localIntent);
    }
    else if (!StringUtil.isEmpty(localIntent.getStringExtra("com.microsoft.identity.client.final.url")))
    {
      sendResult(2003, localIntent);
      Telemetry.emit(new UiEndEvent().isUiComplete());
    }
    else if ((!StringUtil.isEmpty(localIntent.getStringExtra("com.microsoft.aad.adal:BrowserErrorSubCode"))) && (localIntent.getStringExtra("com.microsoft.aad.adal:BrowserErrorSubCode").equalsIgnoreCase("cancel")))
    {
      Telemetry.emit(new UiEndEvent().isUserCancelled());
      sendResult(2008, localIntent);
    }
    else
    {
      Telemetry.emit(new UiEndEvent().isUiCancelled());
      sendResult(2002, localIntent);
    }
    finish();
  }
  
  public static Intent createCustomTabResponseIntent(Context paramContext, String paramString)
  {
    sCustomTabResponseUri = paramString;
    paramContext = new Intent(paramContext, sCallingActivityClass);
    paramContext.addFlags(603979776);
    return paramContext;
  }
  
  private Intent createResultIntent(String paramString)
  {
    Intent localIntent = new Intent();
    HashMap localHashMap = StringExtensions.getUrlParameters(paramString);
    if (!StringExtensions.isNullOrBlank((String)localHashMap.get("error")))
    {
      Logger.info(TAG, "Sending intent to cancel authentication activity");
      localIntent.putExtra("com.microsoft.aad.adal:BrowserErrorCode", (String)localHashMap.get("error"));
      localIntent.putExtra("com.microsoft.aad.adal:BrowserErrorSubCode", (String)localHashMap.get("error_subcode"));
      if (!StringUtil.isEmpty((String)localHashMap.get("error_description"))) {
        localIntent.putExtra("com.microsoft.aad.adal:BrowserErrorMessage", (String)localHashMap.get("error_description"));
      } else {
        localIntent.putExtra("com.microsoft.aad.adal:BrowserErrorMessage", (String)localHashMap.get("error_subcode"));
      }
    }
    else
    {
      Logger.info(TAG, "It is pointing to redirect. Final url can be processed to get the code or error.");
      localIntent.putExtra("com.microsoft.identity.client.final.url", paramString);
    }
    return localIntent;
  }
  
  private boolean isDeviceRegisterRedirect(String paramString)
  {
    boolean bool1 = false;
    try
    {
      URI localURI = new java/net/URI;
      localURI.<init>(paramString);
      boolean bool2 = bool1;
      if (localURI.getScheme().equalsIgnoreCase("msauth"))
      {
        boolean bool3 = localURI.getHost().equalsIgnoreCase("wpj");
        bool2 = bool1;
        if (bool3) {
          bool2 = true;
        }
      }
      return bool2;
    }
    catch (URISyntaxException paramString)
    {
      Logger.error(TAG, "Uri construction failed", paramString);
    }
    return false;
  }
  
  public void extractState(Bundle paramBundle)
  {
    super.extractState(paramBundle);
    mAuthIntent = ((Intent)paramBundle.getParcelable("com.microsoft.identity.auth.intent"));
    mBrowserFlowStarted = paramBundle.getBoolean("browserFlowStarted", false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    sCallingActivityClass = getActivity().getClass();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!mBrowserFlowStarted)
    {
      mBrowserFlowStarted = true;
      Intent localIntent = mAuthIntent;
      if (localIntent != null)
      {
        startActivity(localIntent);
      }
      else
      {
        localIntent = new Intent();
        localIntent.putExtra("com.microsoft.aad.adal:AuthenticationException", new ClientException("Authorization intent is null."));
        sendResult(2005, localIntent);
        finish();
      }
    }
    else if (!StringUtil.isEmpty(sCustomTabResponseUri))
    {
      completeAuthorizationInBrowserFlow(sCustomTabResponseUri);
    }
    else
    {
      cancelAuthorization(true);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("com.microsoft.identity.auth.intent", mAuthIntent);
    paramBundle.putBoolean("browserFlowStarted", mBrowserFlowStarted);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.oauth2.BrowserAuthorizationFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */