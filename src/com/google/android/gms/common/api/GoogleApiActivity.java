package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import e.c.a.a.b.a;
import e.c.a.a.b.d;
import e.c.a.a.b.i.k.c;

@KeepName
public class GoogleApiActivity
  extends Activity
  implements DialogInterface.OnCancelListener
{
  public int x = 0;
  
  public static PendingIntent a(Context paramContext, PendingIntent paramPendingIntent, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, GoogleApiActivity.class);
    localIntent.putExtra("pending_intent", paramPendingIntent);
    localIntent.putExtra("failing_client_id", paramInt);
    localIntent.putExtra("notify_manager", true);
    return PendingIntent.getActivity(paramContext, 0, localIntent, 134217728);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      boolean bool = getIntent().getBooleanExtra("notify_manager", true);
      x = 0;
      setResult(paramInt2, paramIntent);
      if (bool)
      {
        Object localObject = c.a(this);
        if (paramInt2 != -1)
        {
          if (paramInt2 == 0)
          {
            paramIntent = new a(13, null);
            paramInt1 = getIntent().getIntExtra("failing_client_id", -1);
            if (!((c)localObject).a(paramIntent, paramInt1))
            {
              localObject = m;
              ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(5, paramInt1, 0, paramIntent));
            }
          }
        }
        else
        {
          paramIntent = m;
          paramIntent.sendMessage(paramIntent.obtainMessage(3));
        }
      }
    }
    else if (paramInt1 == 2)
    {
      x = 0;
      setResult(paramInt2, paramIntent);
    }
    finish();
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    x = 0;
    setResult(0);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null) {
      x = paramBundle.getInt("resolution");
    }
    if (x != 1)
    {
      Object localObject = getIntent().getExtras();
      if (localObject == null)
      {
        Log.e("GoogleApiActivity", "Activity started without extras");
        finish();
        return;
      }
      paramBundle = (PendingIntent)((Bundle)localObject).get("pending_intent");
      localObject = (Integer)((Bundle)localObject).get("error_code");
      if ((paramBundle == null) && (localObject == null))
      {
        Log.e("GoogleApiActivity", "Activity started without resolution");
        finish();
        return;
      }
      if (paramBundle != null) {
        try
        {
          startIntentSenderForResult(paramBundle.getIntentSender(), 1, null, 0, 0, 0);
          x = 1;
          return;
        }
        catch (IntentSender.SendIntentException paramBundle)
        {
          Log.e("GoogleApiActivity", "Failed to launch pendingIntent", paramBundle);
          finish();
          return;
        }
      }
      d.c.a(this, ((Integer)localObject).intValue(), 2, this);
      x = 1;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("resolution", x);
    super.onSaveInstanceState(paramBundle);
  }
}

/* Location:
 * Qualified Name:     base.com.google.android.gms.common.api.GoogleApiActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */