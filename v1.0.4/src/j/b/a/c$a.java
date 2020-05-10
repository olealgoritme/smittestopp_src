package j.b.a;

import android.database.sqlite.SQLiteProgram;
import d.u.b;
import d.u.g;
import d.w.a.f.e;
import d.w.a.f.f;

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
    if (localObject == null)
    {
      x.bindNull(1);
    }
    else
    {
      l = ((Integer)localObject).intValue();
      x.bindLong(1, l);
    }
    long l = b;
    x.bindLong(2, l);
    localObject = c;
    if (localObject == null) {
      x.bindNull(3);
    } else {
      x.bindString(3, (String)localObject);
    }
    l = d;
    x.bindLong(4, l);
    l = e;
    x.bindLong(5, l);
    l = f;
    x.bindLong(6, l);
  }
  
  public String b()
  {
    return "INSERT OR ABORT INTO `BluetoothContact` (`id`,`timestamp`,`deviceId`,`rssi`,`txPower`,`isUploaded`) VALUES (?,?,?,?,?,?)";
  }
}

/* Location:
 * Qualified Name:     base.j.b.a.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */