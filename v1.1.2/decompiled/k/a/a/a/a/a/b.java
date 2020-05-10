package k.a.a.a.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter.Builder;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.bluetooth.le.ScanSettings.Builder;
import android.os.Handler;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@TargetApi(21)
public class b
  extends a
{
  public final Map<g, b> b = new HashMap();
  
  public ScanSettings a(BluetoothAdapter paramBluetoothAdapter, k paramk, boolean paramBoolean)
  {
    ScanSettings.Builder localBuilder = new ScanSettings.Builder();
    if ((paramBoolean) || ((paramBluetoothAdapter.isOffloadedScanBatchingSupported()) && (F))) {
      localBuilder.setReportDelay(B);
    }
    int i = z;
    if (i != -1) {
      localBuilder.setScanMode(i);
    } else {
      localBuilder.setScanMode(0);
    }
    G = false;
    return localBuilder.build();
  }
  
  public ArrayList<j> a(List<ScanResult> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((ScanResult)paramList.next()));
    }
    return localArrayList;
  }
  
  public j a(ScanResult paramScanResult)
  {
    byte[] arrayOfByte;
    if (paramScanResult.getScanRecord() != null) {
      arrayOfByte = paramScanResult.getScanRecord().getBytes();
    } else {
      arrayOfByte = null;
    }
    return new j(paramScanResult.getDevice(), i.a(arrayOfByte), paramScanResult.getRssi(), paramScanResult.getTimestampNanos());
  }
  
  public void a(List<h> paramList, k paramk, g paramg, Handler paramHandler)
  {
    Object localObject1 = BluetoothAdapter.getDefaultAdapter();
    BluetoothLeScanner localBluetoothLeScanner = ((BluetoothAdapter)localObject1).getBluetoothLeScanner();
    if (localBluetoothLeScanner != null)
    {
      boolean bool1 = ((BluetoothAdapter)localObject1).isOffloadedScanBatchingSupported();
      boolean bool2 = ((BluetoothAdapter)localObject1).isOffloadedFilteringSupported();
      synchronized (b)
      {
        if (!b.containsKey(paramg))
        {
          b localb = new k/a/a/a/a/a/b$b;
          localb.<init>(bool1, bool2, paramList, paramk, paramg, paramHandler, null);
          b.put(paramg, localb);
          ??? = a((BluetoothAdapter)localObject1, paramk, false);
          paramHandler = null;
          paramg = paramHandler;
          if (!paramList.isEmpty())
          {
            paramg = paramHandler;
            if (bool2)
            {
              paramg = paramHandler;
              if (E)
              {
                paramk = new ArrayList();
                paramList = paramList.iterator();
                for (;;)
                {
                  paramg = paramk;
                  if (!paramList.hasNext()) {
                    break;
                  }
                  localObject1 = (h)paramList.next();
                  paramHandler = new ScanFilter.Builder();
                  paramHandler.setDeviceAddress(y).setDeviceName(x).setServiceUuid(z, A).setManufacturerData(E, F, G);
                  paramg = B;
                  if (paramg != null) {
                    paramHandler.setServiceData(paramg, C, D);
                  }
                  paramk.add(paramHandler.build());
                }
              }
            }
          }
          localBluetoothLeScanner.startScan(paramg, (ScanSettings)???, o);
          return;
        }
        paramList = new java/lang/IllegalArgumentException;
        paramList.<init>("scanner already started with given callback");
        throw paramList;
      }
    }
    throw new IllegalStateException("BT le scanner not available");
  }
  
  public void a(g paramg)
  {
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (paramg != null) {
      synchronized (b)
      {
        paramg = (b)b.get(paramg);
        if (paramg != null)
        {
          ??? = g;
          if ((localBluetoothAdapter.isOffloadedScanBatchingSupported()) && (F))
          {
            ??? = localBluetoothAdapter.getBluetoothLeScanner();
            if (??? == null) {
              return;
            }
            ((BluetoothLeScanner)???).flushPendingScanResults(o);
          }
          else
          {
            paramg.b();
          }
          return;
        }
        throw new IllegalArgumentException("callback not registered!");
      }
    }
    throw new IllegalArgumentException("callback cannot be null!");
  }
  
  public void c(g paramg)
  {
    synchronized (b)
    {
      paramg = (b)b.remove(paramg);
      if (paramg == null) {
        return;
      }
      paramg.a();
      ??? = BluetoothAdapter.getDefaultAdapter();
      if (??? != null)
      {
        ??? = ((BluetoothAdapter)???).getBluetoothLeScanner();
        if (??? != null) {
          ((BluetoothLeScanner)???).stopScan(o);
        }
      }
      return;
    }
  }
  
  public static class b
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
}

/* Location:
 * Qualified Name:     k.a.a.a.a.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */