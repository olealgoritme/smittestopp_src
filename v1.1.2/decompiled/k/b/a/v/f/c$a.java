package k.b.a.v.f;

import d.u.b;
import d.u.g;
import d.w.a.d;
import d.w.a.f;

public class c$a
  extends b<a>
{
  public c$a(c paramc, g paramg)
  {
    super(paramg);
  }
  
  public void a(f paramf, Object paramObject)
  {
    paramObject = (a)paramObject;
    Object localObject = a;
    if (localObject == null) {
      paramf.bindNull(1);
    } else {
      paramf.bindLong(1, ((Integer)localObject).intValue());
    }
    paramf.bindLong(2, b);
    localObject = c;
    if (localObject == null) {
      paramf.bindNull(3);
    } else {
      paramf.bindString(3, (String)localObject);
    }
    paramf.bindLong(4, d);
    paramf.bindLong(5, e);
    paramf.bindLong(6, f);
  }
  
  public String b()
  {
    return "INSERT OR ABORT INTO `BluetoothContact` (`id`,`timestamp`,`deviceId`,`rssi`,`txPower`,`isUploaded`) VALUES (?,?,?,?,?,?)";
  }
}

/* Location:
 * Qualified Name:     k.b.a.v.f.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */