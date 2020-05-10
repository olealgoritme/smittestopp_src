package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import e.c.c.u;
import e.c.c.x.a;
import e.c.c.y.c;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class SqlDateTypeAdapter
  extends TypeAdapter<Date>
{
  public static final u b = new u()
  {
    public <T> TypeAdapter<T> a(Gson paramAnonymousGson, a<T> paramAnonymousa)
    {
      if (paramAnonymousa.getRawType() == Date.class) {
        paramAnonymousGson = new SqlDateTypeAdapter();
      } else {
        paramAnonymousGson = null;
      }
      return paramAnonymousGson;
    }
  };
  public final DateFormat a = new SimpleDateFormat("MMM d, yyyy");
  
  public void a(c paramc, Date paramDate)
  {
    if (paramDate == null) {
      paramDate = null;
    }
    try
    {
      paramDate = a.format(paramDate);
      paramc.c(paramDate);
      return;
    }
    finally {}
  }
  
  /* Error */
  public Date read(e.c.c.y.a parama)
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
    //   20: new 66	java/sql/Date
    //   23: dup
    //   24: aload_0
    //   25: getfield 29	com/google/gson/internal/bind/SqlDateTypeAdapter:a	Ljava/text/DateFormat;
    //   28: aload_1
    //   29: invokevirtual 70	e/c/c/y/a:p	()Ljava/lang/String;
    //   32: invokevirtual 74	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   35: invokevirtual 80	java/util/Date:getTime	()J
    //   38: invokespecial 83	java/sql/Date:<init>	(J)V
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
    //   0	63	0	this	SqlDateTypeAdapter
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
 * Qualified Name:     com.google.gson.internal.bind.SqlDateTypeAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */