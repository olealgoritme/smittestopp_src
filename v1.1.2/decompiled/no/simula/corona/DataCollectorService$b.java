package no.simula.corona;

import android.location.Location;
import com.google.android.gms.location.LocationResult;
import e.c.a.a.e.b;
import i.k.b.g;
import java.util.Iterator;
import java.util.List;
import m.a.a;
import m.a.a.b;

public final class DataCollectorService$b
  extends b
{
  public void a(LocationResult paramLocationResult)
  {
    if (paramLocationResult == null)
    {
      a.d.c("Location result is null", new Object[0]);
      return;
    }
    Iterator localIterator = x.iterator();
    while (localIterator.hasNext())
    {
      paramLocationResult = (Location)localIterator.next();
      DataCollectorService localDataCollectorService = a;
      g.a(paramLocationResult, "location");
      DataCollectorService.a(localDataCollectorService, paramLocationResult);
    }
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.DataCollectorService.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */