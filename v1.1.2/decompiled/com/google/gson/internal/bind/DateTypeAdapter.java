package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.u;
import e.c.c.w.o;
import e.c.c.y.b;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class DateTypeAdapter
  extends TypeAdapter<Date>
{
  public static final u b = new u()
  {
    public <T> TypeAdapter<T> a(Gson paramAnonymousGson, e.c.c.x.a<T> paramAnonymousa)
    {
      if (paramAnonymousa.getRawType() == Date.class) {
        paramAnonymousGson = new DateTypeAdapter();
      } else {
        paramAnonymousGson = null;
      }
      return paramAnonymousGson;
    }
  };
  public final List<DateFormat> a;
  
  public DateTypeAdapter()
  {
    ArrayList localArrayList = new ArrayList();
    a = localArrayList;
    localArrayList.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
    if (!Locale.getDefault().equals(Locale.US)) {
      a.add(DateFormat.getDateTimeInstance(2, 2));
    }
    int i;
    if (o.a >= 9) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      a.add(e.c.a.a.b.l.c.a(2, 2));
    }
  }
  
  /* Error */
  public final Date a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	com/google/gson/internal/bind/DateTypeAdapter:a	Ljava/util/List;
    //   6: invokeinterface 71 1 0
    //   11: astore_2
    //   12: aload_2
    //   13: invokeinterface 77 1 0
    //   18: ifeq +23 -> 41
    //   21: aload_2
    //   22: invokeinterface 81 1 0
    //   27: checkcast 34	java/text/DateFormat
    //   30: astore_3
    //   31: aload_3
    //   32: aload_1
    //   33: invokevirtual 84	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   36: astore_3
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_3
    //   40: areturn
    //   41: new 86	java/text/ParsePosition
    //   44: astore_2
    //   45: aload_2
    //   46: iconst_0
    //   47: invokespecial 89	java/text/ParsePosition:<init>	(I)V
    //   50: aload_1
    //   51: aload_2
    //   52: invokestatic 94	e/c/c/w/z/d/a:a	(Ljava/lang/String;Ljava/text/ParsePosition;)Ljava/util/Date;
    //   55: astore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: areturn
    //   60: astore_2
    //   61: new 96	e/c/c/s
    //   64: astore_3
    //   65: aload_3
    //   66: aload_1
    //   67: aload_2
    //   68: invokespecial 99	e/c/c/s:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   71: aload_3
    //   72: athrow
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    //   78: astore_3
    //   79: goto -67 -> 12
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	DateTypeAdapter
    //   0	82	1	paramString	String
    //   11	48	2	localObject1	Object
    //   60	8	2	localParseException1	java.text.ParseException
    //   30	42	3	localObject2	Object
    //   78	1	3	localParseException2	java.text.ParseException
    // Exception table:
    //   from	to	target	type
    //   41	56	60	java/text/ParseException
    //   2	12	73	finally
    //   12	31	73	finally
    //   31	37	73	finally
    //   41	56	73	finally
    //   61	73	73	finally
    //   31	37	78	java/text/ParseException
  }
  
  public void a(e.c.c.y.c paramc, Date paramDate)
  {
    if (paramDate == null) {}
    try
    {
      paramc.g();
      return;
    }
    finally {}
    paramc.c(((DateFormat)a.get(0)).format(paramDate));
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
    }
    return parama;
  }
}

/* Location:
 * Qualified Name:     com.google.gson.internal.bind.DateTypeAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */