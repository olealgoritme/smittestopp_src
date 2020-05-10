package j.a.a.a.a.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.ScanSettings;
import android.bluetooth.le.ScanSettings.Builder;

@TargetApi(23)
public class c
  extends b
{
  public ScanSettings a(BluetoothAdapter paramBluetoothAdapter, k paramk, boolean paramBoolean)
  {
    ScanSettings.Builder localBuilder = new ScanSettings.Builder();
    if ((paramBoolean) || ((paramBluetoothAdapter.isOffloadedScanBatchingSupported()) && (F))) {
      localBuilder.setReportDelay(B);
    }
    if ((paramBoolean) || (G)) {
      localBuilder.setCallbackType(A).setMatchMode(C).setNumOfMatches(D);
    }
    localBuilder.setScanMode(z);
    return localBuilder.build();
  }
}

/* Location:
 * Qualified Name:     base.j.a.a.a.a.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */