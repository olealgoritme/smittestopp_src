package no.simula.corona.data.legacy;

import android.content.Context;
import d.u.g.a;
import k.b.a.v.f.b;
import k.b.a.v.f.f;

public abstract class MeasurementDatabase
  extends d.u.g
{
  public static volatile MeasurementDatabase j;
  public static final a k = new a(null);
  
  public abstract b g();
  
  public abstract f h();
  
  public static final class a
  {
    public final MeasurementDatabase a(Context paramContext)
    {
      if (paramContext != null)
      {
        Object localObject = MeasurementDatabase.j;
        if (localObject != null) {
          return (MeasurementDatabase)localObject;
        }
        try
        {
          paramContext = paramContext.getApplicationContext();
          localObject = MeasurementDatabase.k;
          MeasurementDatabase.i();
          if (("measurement_database" != null) && ("measurement_database".trim().length() != 0))
          {
            localObject = new d/u/g$a;
            ((g.a)localObject).<init>(paramContext, MeasurementDatabase.class, "measurement_database");
            g = true;
            i = false;
            j = true;
            paramContext = ((g.a)localObject).a();
            i.k.b.g.a(paramContext, "Room.databaseBuilder(\n  …                 .build()");
            paramContext = (MeasurementDatabase)paramContext;
            MeasurementDatabase.j = paramContext;
            return paramContext;
          }
          paramContext = new java/lang/IllegalArgumentException;
          paramContext.<init>("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
          throw paramContext;
        }
        finally {}
      }
      i.k.b.g.a("context");
      throw null;
    }
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.data.legacy.MeasurementDatabase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */