package d.i.e;

import android.os.Build.VERSION;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Field;

public final class b
{
  static
  {
    if (Build.VERSION.SDK_INT < 29) {
      try
      {
        Trace.class.getField("TRACE_TAG_APP").getLong(null);
        Trace.class.getMethod("isTagEnabled", new Class[] { Long.TYPE });
        Trace.class.getMethod("asyncTraceBegin", new Class[] { Long.TYPE, String.class, Integer.TYPE });
        Trace.class.getMethod("asyncTraceEnd", new Class[] { Long.TYPE, String.class, Integer.TYPE });
        Trace.class.getMethod("traceCounter", new Class[] { Long.TYPE, String.class, Integer.TYPE });
      }
      catch (Exception localException)
      {
        Log.i("TraceCompat", "Unable to initialize via reflection.", localException);
      }
    }
  }
  
  public static void a() {}
  
  public static void a(String paramString)
  {
    Trace.beginSection(paramString);
  }
}

/* Location:
 * Qualified Name:     d.i.e.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */