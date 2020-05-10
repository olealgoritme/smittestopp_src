package com.microsoft.identity.common.internal.providers.oauth2;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.internal.logging.DiagnosticContext;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.logging.RequestContext;
import com.microsoft.identity.common.internal.telemetry.Telemetry;
import com.microsoft.identity.common.internal.telemetry.events.UiEndEvent;
import d.m.a.p;
import d.m.a.x;
import java.util.HashMap;

public abstract class AuthorizationFragment
  extends Fragment
{
  public static final String TAG = AuthorizationFragment.class.getSimpleName();
  public boolean mAuthResultSent = false;
  public BroadcastReceiver mCancelRequestReceiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      cancelAuthorization(paramAnonymousIntent.getBooleanExtra("com.microsoft.identity.client.request.cancelled.by.user", false));
    }
  };
  public Bundle mInstanceState;
  
  public static String setDiagnosticContextForNewThread(String paramString)
  {
    RequestContext localRequestContext = new RequestContext();
    localRequestContext.put("correlation_id", paramString);
    DiagnosticContext.setRequestContext(localRequestContext);
    e.a.a.a.a.b(new StringBuilder(), TAG, ":setDiagnosticContextForAuthorizationActivity", "Initializing diagnostic context for AuthorizationActivity");
    return paramString;
  }
  
  public void cancelAuthorization(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.setFlags(67108864);
    if (paramBoolean)
    {
      Logger.info(TAG, "Received Authorization flow cancelled by the user");
      sendResult(2001, localIntent);
    }
    else
    {
      Logger.info(TAG, "Received Authorization flow cancel request from SDK");
      sendResult(2008, localIntent);
    }
    Telemetry.emit(new UiEndEvent().isUserCancelled());
    finish();
  }
  
  public void extractState(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      Logger.warn(TAG, "No stored state. Unable to handle response");
      finish();
      return;
    }
    setDiagnosticContextForNewThread(paramBundle.getString("correlation_id"));
  }
  
  public void finish()
  {
    Object localObject = getActivity();
    if ((localObject instanceof AuthorizationActivity))
    {
      ((Activity)localObject).finish();
    }
    else
    {
      localObject = getFragmentManager();
      if (localObject == null) {
        break label49;
      }
      localObject = new d.m.a.a((p)localObject);
      ((x)localObject).a(this);
      ((x)localObject).a();
    }
    return;
    label49:
    throw null;
  }
  
  public boolean onBackPressed()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d.q.a.a.a(getContext()).a(mCancelRequestReceiver, new IntentFilter("cancel_interactive_request"));
    if (paramBundle == null)
    {
      e.a.a.a.a.b(new StringBuilder(), TAG, "#onCreate", "Extract state from the intent bundle.");
      extractState(mInstanceState);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append("#onCreate");
      Logger.verbose(localStringBuilder.toString(), "Extract state from the saved bundle.");
      extractState(paramBundle);
    }
  }
  
  public void onDestroy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TAG);
    localStringBuilder.append("#onDestroy");
    Logger.info(localStringBuilder.toString(), "");
    if (!mAuthResultSent)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append("#onDestroy");
      Logger.info(localStringBuilder.toString(), "Hosting Activity is destroyed before Auth request is completed, sending request cancel");
      Telemetry.emit(new UiEndEvent().isUserCancelled());
      sendResult(2008, new Intent());
    }
    d.q.a.a.a(getContext()).a(mCancelRequestReceiver);
    super.onDestroy();
  }
  
  public void onStop()
  {
    if ((!mAuthResultSent) && (getActivity().isFinishing()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append(":onStop");
      Logger.info(localStringBuilder.toString(), "Hosting Activity is destroyed before Auth request is completed, sending request cancel");
      Telemetry.emit(new UiEndEvent().isUserCancelled());
      sendResult(2008, new Intent());
    }
    super.onStop();
  }
  
  public void sendResult(int paramInt, Intent paramIntent)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Sending result from Authorization Activity, resultCode: ");
    localStringBuilder.append(paramInt);
    Logger.info(str, localStringBuilder.toString());
    paramIntent.setAction("return_interactive_request_result");
    paramIntent.putExtra("com.microsoft.identity.client.request.code", 1001);
    paramIntent.putExtra("com.microsoft.identity.client.result.code", paramInt);
    d.q.a.a.a(getContext()).a(paramIntent);
    mAuthResultSent = true;
  }
  
  public void setInstanceState(Bundle paramBundle)
  {
    mInstanceState = paramBundle;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.oauth2.AuthorizationFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */