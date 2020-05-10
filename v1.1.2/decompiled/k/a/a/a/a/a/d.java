package k.a.a.a.a.a;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.bluetooth.le.ScanSettings.Builder;
import android.os.Handler;
import java.util.HashMap;
import java.util.List;

@TargetApi(26)
public class d
  extends c
{
  public final HashMap<PendingIntent, a> c = new HashMap();
  
  public ScanSettings a(BluetoothAdapter paramBluetoothAdapter, k paramk, boolean paramBoolean)
  {
    ScanSettings.Builder localBuilder = new ScanSettings.Builder();
    if ((paramBoolean) || ((paramBluetoothAdapter.isOffloadedScanBatchingSupported()) && (F))) {
      localBuilder.setReportDelay(B);
    }
    if ((paramBoolean) || (G)) {
      localBuilder.setCallbackType(A).setMatchMode(C).setNumOfMatches(D);
    }
    localBuilder.setScanMode(z).setLegacy(J).setPhy(K);
    return localBuilder.build();
  }
  
  public a a(PendingIntent paramPendingIntent)
  {
    synchronized (c)
    {
      if (c.containsKey(paramPendingIntent))
      {
        paramPendingIntent = (a)c.get(paramPendingIntent);
        if (paramPendingIntent != null) {
          return paramPendingIntent;
        }
        paramPendingIntent = new java/lang/IllegalStateException;
        paramPendingIntent.<init>("Scanning has been stopped");
        throw paramPendingIntent;
      }
      return null;
    }
  }
  
  public j a(ScanResult paramScanResult)
  {
    int i = paramScanResult.getDataStatus();
    int j;
    if (paramScanResult.isLegacy()) {
      j = 16;
    } else {
      j = 0;
    }
    int k = paramScanResult.isConnectable();
    byte[] arrayOfByte;
    if (paramScanResult.getScanRecord() != null) {
      arrayOfByte = paramScanResult.getScanRecord().getBytes();
    } else {
      arrayOfByte = null;
    }
    return new j(paramScanResult.getDevice(), i << 5 | j | k, paramScanResult.getPrimaryPhy(), paramScanResult.getSecondaryPhy(), paramScanResult.getAdvertisingSid(), paramScanResult.getTxPower(), paramScanResult.getRssi(), paramScanResult.getPeriodicAdvertisingInterval(), i.a(arrayOfByte), paramScanResult.getTimestampNanos());
  }
  
  public void a(PendingIntent paramPendingIntent, a parama)
  {
    synchronized (c)
    {
      c.put(paramPendingIntent, parama);
      return;
    }
  }
  
  public static class a
    extends a.a
  {
    public final f o = (f)h;
    
    public a(boolean paramBoolean1, boolean paramBoolean2, List<h> paramList, k paramk, PendingIntent paramPendingIntent)
    {
      super(paramBoolean2, paramList, paramk, new f(paramPendingIntent, paramk), new Handler());
    }
  }
}

/* Location:
 * Qualified Name:     k.a.a.a.a.a.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */