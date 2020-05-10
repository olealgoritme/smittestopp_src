package com.microsoft.identity.common.internal.providers.oauth2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import com.microsoft.identity.common.R.id;
import com.microsoft.identity.common.R.layout;
import com.microsoft.identity.common.internal.logging.DiagnosticContext;
import com.microsoft.identity.common.internal.telemetry.Telemetry;
import com.microsoft.identity.common.internal.telemetry.events.UiStartEvent;
import com.microsoft.identity.common.internal.ui.AuthorizationAgent;
import d.m.a.a;
import d.m.a.c;
import d.m.a.y;
import java.util.HashMap;
import java.util.Map;

public final class AuthorizationActivity
  extends c
{
  public AuthorizationFragment mFragment;
  
  public static Intent createStartIntent(Context paramContext, Intent paramIntent, String paramString1, String paramString2, HashMap<String, String> paramHashMap, AuthorizationAgent paramAuthorizationAgent, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramContext = new Intent(paramContext, AuthorizationActivity.class);
    paramContext.putExtra("com.microsoft.identity.auth.intent", paramIntent);
    paramContext.putExtra("com.microsoft.identity.request.url", paramString1);
    paramContext.putExtra("com.microsoft.identity.request.redirect.uri", paramString2);
    paramContext.putExtra("com.microsoft.identity.request.headers", paramHashMap);
    paramContext.putExtra("com.microsoft.identity.client.authorization.agent", paramAuthorizationAgent);
    paramContext.putExtra("com.microsoft.identity.web.view.zoom.controls.enabled", paramBoolean2);
    paramContext.putExtra("com.microsoft.identity.web.view.zoom.enabled", paramBoolean1);
    paramContext.putExtra("correlation_id", (String)DiagnosticContext.getRequestContext().get("correlation_id"));
    return paramContext;
  }
  
  public static AuthorizationFragment getAuthorizationFragmentFromStartIntent(Intent paramIntent)
  {
    Object localObject = (AuthorizationAgent)paramIntent.getSerializableExtra("com.microsoft.identity.client.authorization.agent");
    Telemetry.emit(new UiStartEvent().putUserAgent((AuthorizationAgent)localObject));
    if (localObject == AuthorizationAgent.WEBVIEW) {
      localObject = new WebViewAuthorizationFragment();
    } else {
      localObject = new BrowserAuthorizationFragment();
    }
    ((AuthorizationFragment)localObject).setInstanceState(paramIntent.getExtras());
    return (AuthorizationFragment)localObject;
  }
  
  public void onBackPressed()
  {
    if (!mFragment.onBackPressed()) {
      super.onBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.authorization_activity);
    mFragment = getAuthorizationFragmentFromStartIntent(getIntent());
    paramBundle = getSupportFragmentManager();
    if (paramBundle != null)
    {
      a locala = new a(paramBundle);
      int i = R.id.authorization_activity_content;
      paramBundle = mFragment;
      if (i != 0)
      {
        locala.a(i, paramBundle, null, 2);
        locala.a();
        return;
      }
      throw new IllegalArgumentException("Must use non-zero containerViewId");
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.oauth2.AuthorizationActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */