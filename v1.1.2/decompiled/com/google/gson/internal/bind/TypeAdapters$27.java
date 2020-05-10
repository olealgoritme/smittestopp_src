package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.y.a;
import e.c.c.y.b;
import e.c.c.y.c;
import java.util.Calendar;
import java.util.GregorianCalendar;

public final class TypeAdapters$27
  extends TypeAdapter<Calendar>
{
  public Object read(a parama)
  {
    if (parama.r() == b.NULL)
    {
      parama.o();
      parama = null;
    }
    else
    {
      parama.b();
      int i = 0;
      int j = 0;
      int k = 0;
      int m = 0;
      int n = 0;
      int i1 = 0;
      while (parama.r() != b.END_OBJECT)
      {
        String str = parama.n();
        int i2 = parama.l();
        if ("year".equals(str)) {
          i = i2;
        } else if ("month".equals(str)) {
          j = i2;
        } else if ("dayOfMonth".equals(str)) {
          k = i2;
        } else if ("hourOfDay".equals(str)) {
          m = i2;
        } else if ("minute".equals(str)) {
          n = i2;
        } else if ("second".equals(str)) {
          i1 = i2;
        }
      }
      parama.f();
      parama = new GregorianCalendar(i, j, k, m, n, i1);
    }
    return parama;
  }
  
  public void write(c paramc, Object paramObject)
  {
    paramObject = (Calendar)paramObject;
    if (paramObject == null)
    {
      paramc.g();
    }
    else
    {
      paramc.c();
      paramc.a("year");
      paramc.a(((Calendar)paramObject).get(1));
      paramc.a("month");
      paramc.a(((Calendar)paramObject).get(2));
      paramc.a("dayOfMonth");
      paramc.a(((Calendar)paramObject).get(5));
      paramc.a("hourOfDay");
      paramc.a(((Calendar)paramObject).get(11));
      paramc.a("minute");
      paramc.a(((Calendar)paramObject).get(12));
      paramc.a("second");
      paramc.a(((Calendar)paramObject).get(13));
      paramc.e();
    }
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.TypeAdapters.27
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */