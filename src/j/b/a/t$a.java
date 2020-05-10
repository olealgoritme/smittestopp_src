package j.b.a;

import android.database.sqlite.SQLiteProgram;
import d.u.b;
import d.u.g;
import d.w.a.f.e;
import d.w.a.f.f;

public class t$a
  extends b<r>
{
  public t$a(t paramt, g paramg)
  {
    super(paramg);
  }
  
  public void a(f paramf, Object paramObject)
  {
    paramObject = (r)paramObject;
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
    long l = d;
    x.bindLong(2, l);
    localObject = e;
    double d;
    if (localObject == null)
    {
      x.bindNull(3);
    }
    else
    {
      d = ((Double)localObject).doubleValue();
      x.bindDouble(3, d);
    }
    localObject = f;
    if (localObject == null)
    {
      x.bindNull(4);
    }
    else
    {
      d = ((Double)localObject).doubleValue();
      x.bindDouble(4, d);
    }
    localObject = g;
    if (localObject == null)
    {
      x.bindNull(5);
    }
    else
    {
      d = ((Double)localObject).doubleValue();
      x.bindDouble(5, d);
    }
    localObject = h;
    if (localObject == null)
    {
      x.bindNull(6);
    }
    else
    {
      d = ((Double)localObject).doubleValue();
      x.bindDouble(6, d);
    }
    localObject = i;
    if (localObject == null)
    {
      x.bindNull(7);
    }
    else
    {
      d = ((Double)localObject).doubleValue();
      x.bindDouble(7, d);
    }
    localObject = j;
    if (localObject == null)
    {
      x.bindNull(8);
    }
    else
    {
      d = ((Double)localObject).doubleValue();
      x.bindDouble(8, d);
    }
    localObject = k;
    if (localObject == null)
    {
      x.bindNull(9);
    }
    else
    {
      d = ((Double)localObject).doubleValue();
      x.bindDouble(9, d);
    }
    l = l;
    x.bindLong(10, l);
  }
  
  public String b()
  {
    return "INSERT OR ABORT INTO `Measurement` (`id`,`timestamp`,`latitude`,`longitude`,`latLongAccuracy`,`altitude`,`altitudeAccuracy`,`speed`,`speedAccuracy`,`isUploaded`) VALUES (?,?,?,?,?,?,?,?,?,?)";
  }
}

/* Location:
 * Qualified Name:     base.j.b.a.t.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */