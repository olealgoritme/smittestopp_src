package com.android.volley;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VolleyLog$MarkerLog
{
  public static final boolean ENABLED = VolleyLog.DEBUG;
  public static final long MIN_DURATION_FOR_LOGGING_MS = 0L;
  public boolean mFinished = false;
  public final List<VolleyLog.MarkerLog.Marker> mMarkers = new ArrayList();
  
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
        VolleyLog.MarkerLog.Marker localMarker = new com/android/volley/VolleyLog$MarkerLog$Marker;
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
        paramString = (VolleyLog.MarkerLog.Marker)localIterator.next();
        l1 = time;
        VolleyLog.d("(+%-4d) [%2d] %s", new Object[] { Long.valueOf(l1 - l2), Long.valueOf(thread), name });
        l2 = l1;
      }
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     base.com.android.volley.VolleyLog.MarkerLog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */