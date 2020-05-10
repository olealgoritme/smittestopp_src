package k.b.a.u;

import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCallback;
import android.os.Build.VERSION;
import java.util.Iterator;
import java.util.List;
import m.a.a.b;

public final class j
  extends k.a.a.a.a.a.g
{
  public long a;
  public final List<String> b;
  public final Application c;
  public h d;
  
  public j(Application paramApplication, h paramh) {}
  
  public void a(int paramInt)
  {
    String str = e.a.a.a.a.a("Scan failed ", paramInt);
    m.a.a.d.b(str, new Object[0]);
  }
  
  public void a(int paramInt, k.a.a.a.a.a.j paramj)
  {
    if (paramj != null)
    {
      a(paramj);
      return;
    }
    i.k.b.g.a("result");
    throw null;
  }
  
  public void a(List<k.a.a.a.a.a.j> paramList)
  {
    if (paramList != null)
    {
      Object localObject = e.a.a.a.a.a("onBatchScanResults size ");
      ((StringBuilder)localObject).append(paramList.size());
      localObject = ((StringBuilder)localObject).toString();
      m.a.a.d.c((String)localObject, new Object[0]);
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((k.a.a.a.a.a.j)paramList.next());
      }
      return;
    }
    i.k.b.g.a("results");
    throw null;
  }
  
  public final void a(k.a.a.a.a.a.j paramj)
  {
    List localList = b;
    Object localObject1 = x;
    i.k.b.g.a(localObject1, "result.device");
    if (!localList.contains(((BluetoothDevice)localObject1).getAddress()))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Received ");
      ((StringBuilder)localObject1).append(paramj);
      localObject1 = ((StringBuilder)localObject1).toString();
      m.a.a.d.c((String)localObject1, new Object[0]);
      a = System.currentTimeMillis();
      if (Build.VERSION.SDK_INT >= 26) {
        localObject1 = new f(d, z, F);
      } else {
        localObject1 = new f(d, z, 0);
      }
      localList = b;
      Object localObject2 = x;
      i.k.b.g.a(localObject2, "result.device");
      localObject2 = ((BluetoothDevice)localObject2).getAddress();
      i.k.b.g.a(localObject2, "result.device.address");
      localList.add(localObject2);
      paramj = x;
      i.k.b.g.a(paramj, "result.device");
      if (Build.VERSION.SDK_INT >= 23) {
        paramj.connectGatt(c, false, (BluetoothGattCallback)localObject1, 2);
      } else {
        paramj.connectGatt(c, false, (BluetoothGattCallback)localObject1);
      }
    }
  }
}

/* Location:
 * Qualified Name:     k.b.a.u.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */