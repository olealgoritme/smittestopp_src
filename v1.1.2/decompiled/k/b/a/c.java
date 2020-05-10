package k.b.a;

import android.content.Context;
import android.location.Location;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import com.microsoft.appcenter.crashes.Crashes;
import i.k.b.g;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import m.a.a.b;
import org.json.JSONObject;

public final class c
  extends AsyncTask<Object, Object, m>
{
  public final k.b.a.v.a a;
  public Context b;
  public b c;
  
  public c(Context paramContext, b paramb) {}
  
  public final boolean a()
  {
    boolean bool;
    if ((getStatus() != AsyncTask.Status.RUNNING) && (getStatus() != AsyncTask.Status.PENDING)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public final m b()
  {
    a.c();
    a.a();
    Object localObject1 = new k();
    Object localObject2 = a.b();
    Object localObject3 = e.a.a.a.a.a("Got ");
    ((StringBuilder)localObject3).append(((List)localObject2).size());
    ((StringBuilder)localObject3).append(" measurements to upload");
    localObject3 = ((StringBuilder)localObject3).toString();
    m.a.a.d.c((String)localObject3, new Object[0]);
    Object localObject5;
    if (((List)localObject2).isEmpty())
    {
      localObject3 = ((k)localObject1).a();
    }
    else
    {
      int i = ((List)localObject2).size() - 1;
      localObject3 = (k.b.a.v.g.b)((List)localObject2).get(0);
      ((k)localObject1).a(a);
      int j = 1;
      label329:
      int n;
      for (int k = 0; j < i; k = n)
      {
        c = getd;
        localObject4 = (k.b.a.v.g.b)((List)localObject2).get(j);
        if ((f != null) && (e != null) && (h != null) && (f != null) && (e != null) && (h != null))
        {
          localObject5 = g;
          if (localObject5 != null)
          {
            double d = ((Double)localObject5).doubleValue();
            localObject5 = g;
            if (localObject5 != null)
            {
              d = Math.max(d, ((Double)localObject5).doubleValue());
              localObject5 = new float[1];
              Location.distanceBetween(e.doubleValue(), f.doubleValue(), e.doubleValue(), f.doubleValue(), (float[])localObject5);
              if (localObject5[0] <= d)
              {
                m = 1;
                break label329;
              }
            }
            else
            {
              g.a();
              throw null;
            }
          }
          else
          {
            g.a();
            throw null;
          }
        }
        int m = 0;
        localObject4 = localObject3;
        n = k;
        if (m == 0)
        {
          ((k)localObject1).a(((k.b.a.v.g.b)localObject3).a());
          n = k + 1;
          localObject4 = (k.b.a.v.g.b)((List)localObject2).get(j);
        }
        ((k)localObject1).a(geta);
        j++;
        localObject3 = localObject4;
      }
      ((k)localObject1).a(((k.b.a.v.g.b)localObject3).a());
      ((k)localObject1).a(((k.b.a.v.g.b)((List)localObject2).get(i)).a());
      ((k)localObject1).a(geta);
      localObject3 = e.a.a.a.a.b("After cleaning there are ", k + 1 + 1, " measurements to upload");
      m.a.a.d.c((String)localObject3, new Object[0]);
      localObject3 = ((k)localObject1).a();
    }
    Object localObject4 = new k();
    localObject1 = a.d();
    if (((List)localObject1).isEmpty())
    {
      localObject4 = ((k)localObject4).a();
    }
    else
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (k.b.a.v.g.a)((Iterator)localObject1).next();
        if (localObject2 != null)
        {
          localObject5 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
          ((SimpleDateFormat)localObject5).setTimeZone(TimeZone.getTimeZone("UTC"));
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("time", ((SimpleDateFormat)localObject5).format(Long.valueOf(t.a(b))));
          localJSONObject.put("deviceId", c);
          localJSONObject.put("rssi", d);
          localJSONObject.put("txPower", e);
          ((k)localObject4).a(localJSONObject);
          ((k)localObject4).a(a);
        }
        else
        {
          throw null;
        }
      }
      localObject4 = ((k)localObject4).a();
    }
    return new m((l)localObject3, (l)localObject4);
  }
  
  public Object doInBackground(Object[] paramArrayOfObject)
  {
    Object localObject = null;
    if (paramArrayOfObject != null)
    {
      try
      {
        paramArrayOfObject = b();
      }
      catch (Exception localException)
      {
        paramArrayOfObject = new LinkedHashMap();
        paramArrayOfObject.put("where", "DataAggregator::doInBackground");
        Crashes.trackError(localException, paramArrayOfObject, null);
        paramArrayOfObject = (Object[])localObject;
      }
      return paramArrayOfObject;
    }
    g.a("params");
    throw null;
  }
  
  /* Error */
  public void onPostExecute(Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: checkcast 260	k/b/a/m
    //   4: astore_1
    //   5: aload_0
    //   6: aload_1
    //   7: invokespecial 293	android/os/AsyncTask:onPostExecute	(Ljava/lang/Object;)V
    //   10: aload_0
    //   11: getfield 20	k/b/a/c:c	Lk/b/a/b;
    //   14: aload_1
    //   15: invokeinterface 298 2 0
    //   20: goto +33 -> 53
    //   23: astore_1
    //   24: goto +39 -> 63
    //   27: astore_1
    //   28: new 271	java/util/LinkedHashMap
    //   31: astore_2
    //   32: aload_2
    //   33: invokespecial 272	java/util/LinkedHashMap:<init>	()V
    //   36: aload_2
    //   37: ldc_w 274
    //   40: ldc_w 300
    //   43: invokevirtual 281	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   46: pop
    //   47: aload_1
    //   48: aload_2
    //   49: aconst_null
    //   50: invokestatic 287	com/microsoft/appcenter/crashes/Crashes:trackError	(Ljava/lang/Throwable;Ljava/util/Map;Ljava/lang/Iterable;)V
    //   53: aload_0
    //   54: getfield 27	k/b/a/c:a	Lk/b/a/v/a;
    //   57: invokeinterface 303 1 0
    //   62: return
    //   63: aload_0
    //   64: getfield 27	k/b/a/c:a	Lk/b/a/v/a;
    //   67: invokeinterface 303 1 0
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	c
    //   0	74	1	paramObject	Object
    //   31	18	2	localLinkedHashMap	LinkedHashMap
    // Exception table:
    //   from	to	target	type
    //   10	20	23	finally
    //   28	53	23	finally
    //   10	20	27	java/lang/Exception
  }
}

/* Location:
 * Qualified Name:     k.b.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */