package no.simula.corona.data.legacy;

import k.b.a.v.f.b;
import k.b.a.v.f.c;
import k.b.a.v.f.f;
import k.b.a.v.f.g;

public final class MeasurementDatabase_Impl
  extends MeasurementDatabase
{
  public volatile f l;
  public volatile b m;
  
  public b g()
  {
    if (m != null) {
      return m;
    }
    try
    {
      if (m == null)
      {
        localObject1 = new k/b/a/v/f/c;
        ((c)localObject1).<init>(this);
        m = ((b)localObject1);
      }
      Object localObject1 = m;
      return (b)localObject1;
    }
    finally {}
  }
  
  public f h()
  {
    if (l != null) {
      return l;
    }
    try
    {
      if (l == null)
      {
        localObject1 = new k/b/a/v/f/g;
        ((g)localObject1).<init>(this);
        l = ((f)localObject1);
      }
      Object localObject1 = l;
      return (f)localObject1;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.data.legacy.MeasurementDatabase_Impl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */