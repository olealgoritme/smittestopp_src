package androidx.lifecycle;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import d.o.g.a;
import d.o.i;
import d.o.i.a;
import d.o.m;
import d.o.t;
import d.o.u;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProcessLifecycleOwnerInitializer
  extends ContentProvider
{
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    Context localContext = getContext();
    if (!i.a.getAndSet(true)) {
      ((Application)localContext.getApplicationContext()).registerActivityLifecycleCallbacks(new i.a());
    }
    localContext = getContext();
    t localt = t.F;
    if (localt != null)
    {
      B = new Handler();
      C.a(g.a.ON_CREATE);
      ((Application)localContext.getApplicationContext()).registerActivityLifecycleCallbacks(new u(localt));
      return true;
    }
    throw null;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     base.androidx.lifecycle.ProcessLifecycleOwnerInitializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */