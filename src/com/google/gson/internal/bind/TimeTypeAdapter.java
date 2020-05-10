package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import e.c.c.u;
import e.c.c.y.c;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class TimeTypeAdapter
  extends TypeAdapter<Time>
{
  public static final u b = new TimeTypeAdapter.1();
  public final DateFormat a = new SimpleDateFormat("hh:mm:ss a");
  
  public void a(c paramc, Time paramTime)
  {
    if (paramTime == null) {
      paramTime = null;
    }
    try
    {
      paramTime = a.format(paramTime);
      paramc.c(paramTime);
      return;
    }
    finally {}
  }
  
  /* Error */
  public Time read(e.c.c.y.a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 55	e/c/c/y/a:r	()Le/c/c/y/b;
    //   6: getstatic 61	e/c/c/y/b:NULL	Le/c/c/y/b;
    //   9: if_acmpne +11 -> 20
    //   12: aload_1
    //   13: invokevirtual 64	e/c/c/y/a:o	()V
    //   16: aload_0
    //   17: monitorexit
    //   18: aconst_null
    //   19: areturn
    //   20: new 66	java/sql/Time
    //   23: dup
    //   24: aload_0
    //   25: getfield 29	com/google/gson/internal/bind/TimeTypeAdapter:a	Ljava/text/DateFormat;
    //   28: aload_1
    //   29: invokevirtual 70	e/c/c/y/a:p	()Ljava/lang/String;
    //   32: invokevirtual 74	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   35: invokevirtual 80	java/util/Date:getTime	()J
    //   38: invokespecial 83	java/sql/Time:<init>	(J)V
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: astore_2
    //   47: new 85	e/c/c/s
    //   50: astore_1
    //   51: aload_1
    //   52: aload_2
    //   53: invokespecial 88	e/c/c/s:<init>	(Ljava/lang/Throwable;)V
    //   56: aload_1
    //   57: athrow
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	TimeTypeAdapter
    //   0	63	1	parama	e.c.c.y.a
    //   46	7	2	localParseException	java.text.ParseException
    // Exception table:
    //   from	to	target	type
    //   20	42	46	java/text/ParseException
    //   2	16	58	finally
    //   20	42	58	finally
    //   47	58	58	finally
  }
}

/* Location:
 * Qualified Name:     base.com.google.gson.internal.bind.TimeTypeAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */