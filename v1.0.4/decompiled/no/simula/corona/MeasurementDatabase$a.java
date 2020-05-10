package no.simula.corona;

import android.content.Context;
import d.u.g.a;
import h.k.b.g;

public final class MeasurementDatabase$a
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
        if ("measurement_database".trim().length() != 0)
        {
          localObject = new d/u/g$a;
          ((g.a)localObject).<init>(paramContext, MeasurementDatabase.class, "measurement_database");
          g = true;
          i = false;
          j = true;
          paramContext = ((g.a)localObject).a();
          g.a(paramContext, "Room.databaseBuilder(\n  …                 .build()");
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
    g.a("context");
    throw null;
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.MeasurementDatabase.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */