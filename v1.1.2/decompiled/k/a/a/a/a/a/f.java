package k.a.a.a.a.a;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class f
  extends g
{
  public final PendingIntent a;
  public Context b;
  public Context c;
  public long d;
  public long e;
  
  public f(PendingIntent paramPendingIntent, k paramk)
  {
    a = paramPendingIntent;
    e = B;
  }
  
  public f(PendingIntent paramPendingIntent, k paramk, Service paramService)
  {
    a = paramPendingIntent;
    e = B;
    c = paramService;
  }
  
  public void a(int paramInt)
  {
    Context localContext = b;
    if (localContext == null) {
      localContext = c;
    }
    if (localContext == null) {
      return;
    }
    try
    {
      Intent localIntent = new android/content/Intent;
      localIntent.<init>();
      localIntent.putExtra("android.bluetooth.le.extra.ERROR_CODE", paramInt);
      a.send(localContext, 0, localIntent);
      return;
    }
    catch (PendingIntent.CanceledException localCanceledException)
    {
      for (;;) {}
    }
  }
  
  public void a(int paramInt, j paramj)
  {
    Context localContext = b;
    if (localContext == null) {
      localContext = c;
    }
    if (localContext == null) {
      return;
    }
    try
    {
      Intent localIntent = new android/content/Intent;
      localIntent.<init>();
      localIntent.putExtra("android.bluetooth.le.extra.CALLBACK_TYPE", paramInt);
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>(Collections.singletonList(paramj));
      localIntent.putParcelableArrayListExtra("android.bluetooth.le.extra.LIST_SCAN_RESULT", localArrayList);
      a.send(localContext, 0, localIntent);
      return;
    }
    catch (PendingIntent.CanceledException paramj)
    {
      for (;;) {}
    }
  }
  
  public void a(List<j> paramList)
  {
    Context localContext = b;
    if (localContext == null) {
      localContext = c;
    }
    if (localContext == null) {
      return;
    }
    long l = SystemClock.elapsedRealtime();
    if (d > l - e + 5L) {
      return;
    }
    d = l;
    try
    {
      Intent localIntent = new android/content/Intent;
      localIntent.<init>();
      localIntent.putExtra("android.bluetooth.le.extra.CALLBACK_TYPE", 1);
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>(paramList);
      localIntent.putParcelableArrayListExtra("android.bluetooth.le.extra.LIST_SCAN_RESULT", localArrayList);
      localIntent.setExtrasClassLoader(j.class.getClassLoader());
      a.send(localContext, 0, localIntent);
      return;
    }
    catch (PendingIntent.CanceledException paramList)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     k.a.a.a.a.a.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */