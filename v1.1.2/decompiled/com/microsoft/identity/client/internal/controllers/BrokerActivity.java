package com.microsoft.identity.client.internal.controllers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.microsoft.identity.common.internal.logging.Logger;

public final class BrokerActivity
  extends Activity
{
  public static final String BROKER_INTENT = "broker_intent";
  public static final int BROKER_INTENT_REQUEST_CODE = 1001;
  public static final String BROKER_INTENT_STARTED = "broker_intent_started";
  public static final String TAG = BrokerActivity.class.getSimpleName();
  public Boolean mBrokerIntentStarted = Boolean.valueOf(false);
  public Intent mBrokerInteractiveRequestIntent;
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str = e.a.a.a.a.a(new StringBuilder(), TAG, ":onActivityResult");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Result received from Broker Request code: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" Result code: ");
    localStringBuilder.append(paramInt1);
    Logger.info(str, localStringBuilder.toString());
    if ((paramInt2 == 2004) || (paramInt2 == 2001) || (paramInt2 == 2002))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append(":onActivityResult");
      Logger.verbose(localStringBuilder.toString(), "Completing interactive request ");
      paramIntent.setAction("return_interactive_request_result");
      paramIntent.putExtra("com.microsoft.identity.client.request.code", 1001);
      paramIntent.putExtra("com.microsoft.identity.client.result.code", paramInt2);
      d.q.a.a.a(getApplicationContext()).a(paramIntent);
    }
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null)
    {
      mBrokerInteractiveRequestIntent = ((Intent)getIntent().getExtras().getParcelable("broker_intent"));
    }
    else
    {
      mBrokerInteractiveRequestIntent = ((Intent)paramBundle.getParcelable("broker_intent"));
      mBrokerIntentStarted = Boolean.valueOf(paramBundle.getBoolean("broker_intent_started"));
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (!mBrokerIntentStarted.booleanValue())
    {
      mBrokerIntentStarted = Boolean.valueOf(true);
      startActivityForResult(mBrokerInteractiveRequestIntent, 1001);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("broker_intent", mBrokerInteractiveRequestIntent);
    paramBundle.putBoolean("broker_intent_started", mBrokerIntentStarted.booleanValue());
  }
  
  public void onStop()
  {
    super.onStop();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.internal.controllers.BrokerActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */