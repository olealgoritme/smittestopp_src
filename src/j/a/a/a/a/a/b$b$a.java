package j.a.a.a.a.a;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.os.Handler;
import java.util.List;

public class b$b$a
  extends ScanCallback
{
  public long a;
  
  public b$b$a(b.b paramb) {}
  
  public void onBatchScanResults(List<ScanResult> paramList)
  {
    b.i.post(new b.b.a.b(this, paramList));
  }
  
  public void onScanFailed(int paramInt)
  {
    b.i.post(new b.b.a.c(this, paramInt));
  }
  
  public void onScanResult(int paramInt, ScanResult paramScanResult)
  {
    b.i.post(new b.b.a.a(this, paramScanResult, paramInt));
  }
}

/* Location:
 * Qualified Name:     base.j.a.a.a.a.a.b.b.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */