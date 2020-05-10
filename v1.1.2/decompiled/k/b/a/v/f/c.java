package k.b.a.v.f;

import d.u.g;
import d.u.k;
import d.w.a.d;
import d.w.a.f;

public final class c
  implements b
{
  public final g a;
  public final d.u.b<a> b;
  public final k c;
  public final k d;
  
  public c(g paramg)
  {
    a = paramg;
    b = new a(paramg);
    c = new b(paramg);
    d = new c(paramg);
  }
  
  public class a
    extends d.u.b<a>
  {
    public a(g paramg)
    {
      super();
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
  
  public class b
    extends k
  {
    public b(g paramg)
    {
      super();
    }
    
    public String b()
    {
      return "DELETE from bluetoothcontact WHERE isUploaded is 1";
    }
  }
  
  public class c
    extends k
  {
    public c(g paramg)
    {
      super();
    }
    
    public String b()
    {
      return "DELETE from bluetoothcontact";
    }
  }
}

/* Location:
 * Qualified Name:     k.b.a.v.f.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */