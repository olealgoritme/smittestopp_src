package com.microsoft.identity.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.microsoft.identity.common.internal.providers.oauth2.BrowserAuthorizationFragment;
import com.microsoft.identity.common.internal.util.StringUtil;

public final class BrowserTabActivity
  extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((paramBundle == null) && (getIntent() != null) && (!StringUtil.isEmpty(getIntent().getDataString())))
    {
      startActivity(BrowserAuthorizationFragment.createCustomTabResponseIntent(this, getIntent().getDataString()));
      finish();
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.BrowserTabActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */