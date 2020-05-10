package no.simula.corona;

import j.b.a.b;
import j.b.a.c;
import j.b.a.s;
import j.b.a.t;

public final class MeasurementDatabase_Impl
  extends MeasurementDatabase
{
  public volatile s l;
  public volatile b m;
  
  public b h()
  {
    if (m != null) {
      return m;
    }
    try
    {
      if (m == null)
      {
        localObject1 = new j/b/a/c;
        ((c)localObject1).<init>(this);
        m = ((b)localObject1);
      }
      Object localObject1 = m;
      return (b)localObject1;
    }
    finally {}
  }
  
  public s i()
  {
    if (l != null) {
      return l;
    }
    try
    {
      if (l == null)
      {
        localObject1 = new j/b/a/t;
        ((t)localObject1).<init>(this);
        l = ((s)localObject1);
      }
      Object localObject1 = l;
      return (s)localObject1;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     base.no.simula.corona.MeasurementDatabase_Impl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */