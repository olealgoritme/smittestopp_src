package com.microsoft.identity.common.adal.internal.cache;

import e.c.c.i;
import e.c.c.j;
import e.c.c.p;
import e.c.c.q;
import e.c.c.r;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateTimeAdapter
  implements i<Date>, r<Date>
{
  public static final String TAG = "DateTimeAdapter";
  public final DateFormat mEnUs24HourFormat = buildEnUs24HourDateFormat();
  public final DateFormat mEnUsFormat = DateFormat.getDateTimeInstance(2, 2, Locale.US);
  public final DateFormat mISO8601Format = buildIso8601Format();
  public final DateFormat mLocal24HourFormat = buildLocal24HourDateFormat();
  public final DateFormat mLocalFormat = DateFormat.getDateTimeInstance(2, 2);
  
  public static DateFormat buildEnUs24HourDateFormat()
  {
    return new SimpleDateFormat("MMM dd, yyyy HH:mm:ss", Locale.US);
  }
  
  public static DateFormat buildIso8601Format()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    return localSimpleDateFormat;
  }
  
  public static DateFormat buildLocal24HourDateFormat()
  {
    return new SimpleDateFormat("MMM dd, yyyy HH:mm:ss", Locale.getDefault());
  }
  
  /* Error */
  public Date deserialize(j paramj, Type paramType, e.c.c.h paramh)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 97	e/c/c/j:f	()Ljava/lang/String;
    //   6: astore_1
    //   7: aload_0
    //   8: getfield 48	com/microsoft/identity/common/adal/internal/cache/DateTimeAdapter:mISO8601Format	Ljava/text/DateFormat;
    //   11: aload_1
    //   12: invokevirtual 101	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   15: astore_2
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_2
    //   19: areturn
    //   20: astore_2
    //   21: ldc 13
    //   23: ldc 103
    //   25: invokestatic 109	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   28: pop
    //   29: aload_0
    //   30: getfield 42	com/microsoft/identity/common/adal/internal/cache/DateTimeAdapter:mLocalFormat	Ljava/text/DateFormat;
    //   33: aload_1
    //   34: invokevirtual 101	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: areturn
    //   42: astore_2
    //   43: ldc 13
    //   45: ldc 111
    //   47: invokestatic 109	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   50: pop
    //   51: aload_0
    //   52: getfield 58	com/microsoft/identity/common/adal/internal/cache/DateTimeAdapter:mLocal24HourFormat	Ljava/text/DateFormat;
    //   55: aload_1
    //   56: invokevirtual 101	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   59: astore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_2
    //   63: areturn
    //   64: astore_2
    //   65: ldc 13
    //   67: ldc 113
    //   69: invokestatic 109	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   72: pop
    //   73: aload_0
    //   74: getfield 37	com/microsoft/identity/common/adal/internal/cache/DateTimeAdapter:mEnUsFormat	Ljava/text/DateFormat;
    //   77: aload_1
    //   78: invokevirtual 101	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   81: astore_2
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_2
    //   85: areturn
    //   86: astore_2
    //   87: ldc 13
    //   89: ldc 115
    //   91: invokestatic 109	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   94: pop
    //   95: aload_0
    //   96: getfield 53	com/microsoft/identity/common/adal/internal/cache/DateTimeAdapter:mEnUs24HourFormat	Ljava/text/DateFormat;
    //   99: aload_1
    //   100: invokevirtual 101	java/text/DateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   103: astore_2
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_2
    //   107: areturn
    //   108: astore_3
    //   109: new 117	java/lang/StringBuilder
    //   112: astore_2
    //   113: aload_2
    //   114: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   117: aload_2
    //   118: ldc 120
    //   120: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_2
    //   125: aload_3
    //   126: invokevirtual 127	java/text/ParseException:getMessage	()Ljava/lang/String;
    //   129: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: ldc 13
    //   135: aload_2
    //   136: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: aload_3
    //   140: invokestatic 134	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   143: pop
    //   144: new 136	e/c/c/n
    //   147: astore_3
    //   148: new 117	java/lang/StringBuilder
    //   151: astore_2
    //   152: aload_2
    //   153: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   156: aload_2
    //   157: ldc 120
    //   159: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_2
    //   164: aload_1
    //   165: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_3
    //   170: aload_2
    //   171: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokespecial 139	e/c/c/n:<init>	(Ljava/lang/String;)V
    //   177: aload_3
    //   178: athrow
    //   179: astore_1
    //   180: aload_0
    //   181: monitorexit
    //   182: aload_1
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	DateTimeAdapter
    //   0	184	1	paramj	j
    //   0	184	2	paramType	Type
    //   0	184	3	paramh	e.c.c.h
    // Exception table:
    //   from	to	target	type
    //   7	16	20	java/text/ParseException
    //   29	38	42	java/text/ParseException
    //   51	60	64	java/text/ParseException
    //   73	82	86	java/text/ParseException
    //   95	104	108	java/text/ParseException
    //   2	7	179	finally
    //   7	16	179	finally
    //   21	29	179	finally
    //   29	38	179	finally
    //   43	51	179	finally
    //   51	60	179	finally
    //   65	73	179	finally
    //   73	82	179	finally
    //   87	95	179	finally
    //   95	104	179	finally
    //   109	179	179	finally
  }
  
  public j serialize(Date paramDate, Type paramType, q paramq)
  {
    try
    {
      paramDate = new p(mISO8601Format.format(paramDate));
      return paramDate;
    }
    finally
    {
      paramDate = finally;
      throw paramDate;
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.adal.internal.cache.DateTimeAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */