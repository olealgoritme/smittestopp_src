package k.a.a.a.a.a;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.os.Handler;
import android.os.SystemClock;
import java.util.List;

public class b$b
  extends a.a
{
  public final ScanCallback o;
  
  public class a
    extends ScanCallback
  {
    public long a;
    
    public a() {}
    
    public void onBatchScanResults(final List<ScanResult> paramList)
    {
      i.post(new b(paramList));
    }
    
    public void onScanFailed(final int paramInt)
    {
      i.post(new c(paramInt));
    }
    
    public void onScanResult(final int paramInt, final ScanResult paramScanResult)
    {
      i.post(new a(paramScanResult, paramInt));
    }
    
    public class a
      implements Runnable
    {
      public a(ScanResult paramScanResult, int paramInt) {}
      
      public void run()
      {
        j localj = ((b)a.a()).a(paramScanResult);
        a(paramInt, localj);
      }
    }
    
    public class b
      implements Runnable
    {
      public b(List paramList) {}
      
      public void run()
      {
        long l = SystemClock.elapsedRealtime();
        Object localObject = b.b.a.this;
        if (a > l - b.g.B + 5L) {
          return;
        }
        a = l;
        localObject = ((b)a.a()).a(paramList);
        a((List)localObject);
      }
    }
    
    public class c
      implements Runnable
    {
      public c(int paramInt) {}
      
      public void run()
      {
        Object localObject = g;
        if ((G) && (A != 1))
        {
          G = false;
          localObject = a.a();
        }
        try
        {
          ((a)localObject).b(h);
        }
        catch (Exception localException2)
        {
          try
          {
            for (;;)
            {
              ((a)localObject).a(f, g, h, b.b.this.i);
              return;
              localObject = b.b.this;
              int i = paramInt;
              h.a(i);
              return;
              localException2 = localException2;
            }
          }
          catch (Exception localException1)
          {
            for (;;) {}
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     k.a.a.a.a.a.b.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */