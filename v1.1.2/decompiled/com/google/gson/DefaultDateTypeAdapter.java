package com.google.gson;

import e.c.c.s;
import e.c.c.w.o;
import e.c.c.y.b;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class DefaultDateTypeAdapter
  extends TypeAdapter<java.util.Date>
{
  public final Class<? extends java.util.Date> a;
  public final List<DateFormat> b = new ArrayList();
  
  public DefaultDateTypeAdapter(Class<? extends java.util.Date> paramClass, int paramInt1, int paramInt2)
  {
    a(paramClass);
    a = paramClass;
    b.add(DateFormat.getDateTimeInstance(paramInt1, paramInt2, Locale.US));
    if (!Locale.getDefault().equals(Locale.US)) {
      b.add(DateFormat.getDateTimeInstance(paramInt1, paramInt2));
    }
    int i;
    if (o.a >= 9) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      b.add(e.c.a.a.b.l.c.a(paramInt1, paramInt2));
    }
  }
  
  public static Class<? extends java.util.Date> a(Class<? extends java.util.Date> paramClass)
  {
    if ((paramClass != java.util.Date.class) && (paramClass != java.sql.Date.class) && (paramClass != Timestamp.class))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Date type must be one of ");
      localStringBuilder.append(java.util.Date.class);
      localStringBuilder.append(", ");
      localStringBuilder.append(Timestamp.class);
      localStringBuilder.append(", or ");
      localStringBuilder.append(java.sql.Date.class);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(paramClass);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return paramClass;
  }
  
  public final java.util.Date a(String paramString)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      synchronized (b)
      {
        localObject1 = b.iterator();
        if (((Iterator)localObject1).hasNext()) {
          localObject2 = (DateFormat)((Iterator)localObject1).next();
        }
      }
      for (;;)
      {
        try
        {
          localObject2 = ((DateFormat)localObject2).parse(paramString);
          return (java.util.Date)localObject2;
        }
        catch (ParseException localParseException2) {}
        try
        {
          localObject1 = new java/text/ParsePosition;
          ((ParsePosition)localObject1).<init>(0);
          localObject1 = e.c.c.w.z.d.a.a(paramString, (ParsePosition)localObject1);
          return (java.util.Date)localObject1;
        }
        catch (ParseException localParseException1)
        {
          localObject1 = new e/c/c/s;
          ((s)localObject1).<init>(paramString, localParseException1);
          throw ((Throwable)localObject1);
        }
      }
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(e.c.c.y.c paramc, java.util.Date paramDate)
  {
    if (paramDate == null)
    {
      paramc.g();
      return;
    }
    synchronized (b)
    {
      paramc.c(((DateFormat)b.get(0)).format(paramDate));
      return;
    }
  }
  
  public Object read(e.c.c.y.a parama)
  {
    if (parama.r() == b.NULL)
    {
      parama.o();
      parama = null;
    }
    else
    {
      parama = a(parama.p());
      Class localClass = a;
      if (localClass != java.util.Date.class)
      {
        if (localClass == Timestamp.class) {}
        for (parama = new Timestamp(parama.getTime());; parama = new java.sql.Date(parama.getTime()))
        {
          break;
          if (localClass != java.sql.Date.class) {
            break label86;
          }
        }
      }
    }
    return parama;
    label86:
    throw new AssertionError();
  }
  
  public String toString()
  {
    DateFormat localDateFormat = (DateFormat)b.get(0);
    if ((localDateFormat instanceof SimpleDateFormat))
    {
      localStringBuilder = e.a.a.a.a.a("DefaultDateTypeAdapter(");
      localStringBuilder.append(((SimpleDateFormat)localDateFormat).toPattern());
      localStringBuilder.append(')');
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = e.a.a.a.a.a("DefaultDateTypeAdapter(");
    localStringBuilder.append(localDateFormat.getClass().getSimpleName());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.google.gson.DefaultDateTypeAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */