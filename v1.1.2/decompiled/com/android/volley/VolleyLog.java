package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class VolleyLog
{
  public static final String CLASS_NAME = VolleyLog.class.getName();
  public static boolean DEBUG = Log.isLoggable("Volley", 2);
  public static String TAG = "Volley";
  
  public static String buildMessage(String paramString, Object... paramVarArgs)
  {
    if (paramVarArgs != null) {
      paramString = String.format(Locale.US, paramString, paramVarArgs);
    }
    paramVarArgs = new Throwable().fillInStackTrace().getStackTrace();
    for (int i = 2; i < paramVarArgs.length; i++) {
      if (!paramVarArgs[i].getClassName().equals(CLASS_NAME))
      {
        Object localObject = paramVarArgs[i].getClassName();
        localObject = ((String)localObject).substring(((String)localObject).lastIndexOf('.') + 1);
        localObject = a.a(((String)localObject).substring(((String)localObject).lastIndexOf('$') + 1), ".");
        ((StringBuilder)localObject).append(paramVarArgs[i].getMethodName());
        paramVarArgs = ((StringBuilder)localObject).toString();
        break label119;
      }
    }
    paramVarArgs = "<unknown>";
    label119:
    return String.format(Locale.US, "[%d] %s: %s", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramVarArgs, paramString });
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    Log.d(TAG, buildMessage(paramString, paramVarArgs));
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    Log.e(TAG, buildMessage(paramString, paramVarArgs));
  }
  
  public static void e(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    Log.e(TAG, buildMessage(paramString, paramVarArgs), paramThrowable);
  }
  
  public static void setTag(String paramString)
  {
    d("Changing log tag to %s", new Object[] { paramString });
    TAG = paramString;
    DEBUG = Log.isLoggable(paramString, 2);
  }
  
  public static void v(String paramString, Object... paramVarArgs)
  {
    if (DEBUG) {
      Log.v(TAG, buildMessage(paramString, paramVarArgs));
    }
  }
  
  public static void wtf(String paramString, Object... paramVarArgs)
  {
    Log.wtf(TAG, buildMessage(paramString, paramVarArgs));
  }
  
  public static void wtf(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    Log.wtf(TAG, buildMessage(paramString, paramVarArgs), paramThrowable);
  }
  
  public static class MarkerLog
  {
    public static final boolean ENABLED = VolleyLog.DEBUG;
    public static final long MIN_DURATION_FOR_LOGGING_MS = 0L;
    public boolean mFinished = false;
    public final List<Marker> mMarkers = new ArrayList();
    
    private long getTotalDuration()
    {
      if (mMarkers.size() == 0) {
        return 0L;
      }
      long l = mMarkers.get(0)).time;
      List localList = mMarkers;
      return getsize1time - l;
    }
    
    public void add(String paramString, long paramLong)
    {
      try
      {
        if (!mFinished)
        {
          List localList = mMarkers;
          Marker localMarker = new com/android/volley/VolleyLog$MarkerLog$Marker;
          localMarker.<init>(paramString, paramLong, SystemClock.elapsedRealtime());
          localList.add(localMarker);
          return;
        }
        paramString = new java/lang/IllegalStateException;
        paramString.<init>("Marker added to finished log");
        throw paramString;
      }
      finally {}
    }
    
    public void finalize()
    {
      if (!mFinished)
      {
        finish("Request on the loose");
        VolleyLog.e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
      }
    }
    
    public void finish(String paramString)
    {
      try
      {
        mFinished = true;
        long l1 = getTotalDuration();
        if (l1 <= 0L) {
          return;
        }
        long l2 = mMarkers.get(0)).time;
        VolleyLog.d("(%-4d ms) %s", new Object[] { Long.valueOf(l1), paramString });
        Iterator localIterator = mMarkers.iterator();
        while (localIterator.hasNext())
        {
          paramString = (Marker)localIterator.next();
          l1 = time;
          VolleyLog.d("(+%-4d) [%2d] %s", new Object[] { Long.valueOf(l1 - l2), Long.valueOf(thread), name });
          l2 = l1;
        }
        return;
      }
      finally {}
    }
    
    public static class Marker
    {
      public final String name;
      public final long thread;
      public final long time;
      
      public Marker(String paramString, long paramLong1, long paramLong2)
      {
        name = paramString;
        thread = paramLong1;
        time = paramLong2;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.android.volley.VolleyLog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */