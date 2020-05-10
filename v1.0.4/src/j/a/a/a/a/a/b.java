package j.a.a.a.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanFilter.Builder;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.bluetooth.le.ScanSettings.Builder;
import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@TargetApi(21)
public class b
  extends a
{
  public final Map<g, b.b> b = new HashMap();
  
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
  
  public ArrayList<j> a(List<ScanResult> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((ScanResult)paramList.next()));
    }
    return localArrayList;
  }
  
  public void a(g paramg)
  {
    Object localObject1 = BluetoothAdapter.getDefaultAdapter();
    if (paramg != null) {
      synchronized (b)
      {
        paramg = (b.b)b.get(paramg);
        if (paramg != null)
        {
          ??? = g;
          if ((((BluetoothAdapter)localObject1).isOffloadedScanBatchingSupported()) && (F))
          {
            localObject1 = ((BluetoothAdapter)localObject1).getBluetoothLeScanner();
            if (localObject1 == null) {
              return;
            }
            ((BluetoothLeScanner)localObject1).flushPendingScanResults(o);
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
          b.b localb = new j/a/a/a/a/a/b$b;
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
                  paramg = (h)paramList.next();
                  localObject1 = new ScanFilter.Builder();
                  ((ScanFilter.Builder)localObject1).setDeviceAddress(y).setDeviceName(x).setServiceUuid(z, A).setManufacturerData(E, F, G);
                  paramHandler = B;
                  if (paramHandler != null) {
                    ((ScanFilter.Builder)localObject1).setServiceData(paramHandler, C, D);
                  }
                  paramk.add(((ScanFilter.Builder)localObject1).build());
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
  
  public void c(g paramg)
  {
    synchronized (b)
    {
      paramg = (b.b)b.remove(paramg);
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
}

/* Location:
 * Qualified Name:     base.j.a.a.a.a.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */