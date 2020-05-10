package g.a;

import java.util.AbstractSet;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class b
  extends AbstractSet<a>
{
  public static final ConcurrentMap<String, b> B = new ConcurrentHashMap();
  public static final Object C = new Object();
  public static final ClassLoader D;
  public static final boolean E;
  public static volatile Throwable F;
  public final Class<Enum> A;
  public final Map<String, a> x;
  public final Map<Long, a> y;
  public final Set<Enum> z;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: new 38	java/util/concurrent/ConcurrentHashMap
    //   3: dup
    //   4: invokespecial 41	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   7: putstatic 43	g/a/b:B	Ljava/util/concurrent/ConcurrentMap;
    //   10: new 45	java/lang/Object
    //   13: dup
    //   14: invokespecial 46	java/lang/Object:<init>	()V
    //   17: putstatic 48	g/a/b:C	Ljava/lang/Object;
    //   20: ldc 2
    //   22: invokevirtual 54	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   25: astore_0
    //   26: aload_0
    //   27: ifnull +10 -> 37
    //   30: aload_0
    //   31: putstatic 56	g/a/b:D	Ljava/lang/ClassLoader;
    //   34: goto +9 -> 43
    //   37: invokestatic 61	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   40: putstatic 56	g/a/b:D	Ljava/lang/ClassLoader;
    //   43: iconst_0
    //   44: istore_1
    //   45: new 7	g/a/b$a
    //   48: astore_0
    //   49: aload_0
    //   50: invokespecial 62	g/a/b$a:<init>	()V
    //   53: aload_0
    //   54: invokestatic 68	java/security/AccessController:doPrivileged	(Ljava/security/PrivilegedAction;)Ljava/lang/Object;
    //   57: checkcast 70	java/net/URL
    //   60: invokevirtual 74	java/net/URL:openStream	()Ljava/io/InputStream;
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual 80	java/io/InputStream:read	()I
    //   68: pop
    //   69: aload_0
    //   70: invokevirtual 83	java/io/InputStream:close	()V
    //   73: goto +11 -> 84
    //   76: astore_2
    //   77: aload_2
    //   78: putstatic 85	g/a/b:F	Ljava/lang/Throwable;
    //   81: goto -12 -> 69
    //   84: iconst_1
    //   85: istore_3
    //   86: goto +25 -> 111
    //   89: astore_2
    //   90: aload_0
    //   91: invokevirtual 83	java/io/InputStream:close	()V
    //   94: aload_2
    //   95: athrow
    //   96: astore_0
    //   97: iload_1
    //   98: istore_3
    //   99: getstatic 85	g/a/b:F	Ljava/lang/Throwable;
    //   102: ifnonnull +9 -> 111
    //   105: aload_0
    //   106: putstatic 85	g/a/b:F	Ljava/lang/Throwable;
    //   109: iload_1
    //   110: istore_3
    //   111: iload_3
    //   112: putstatic 87	g/a/b:E	Z
    //   115: return
    //   116: astore_0
    //   117: goto -33 -> 84
    //   120: astore_0
    //   121: goto -27 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   25	66	0	localObject1	Object
    //   96	10	0	localThrowable1	Throwable
    //   116	1	0	localException1	Exception
    //   120	1	0	localException2	Exception
    //   44	66	1	bool1	boolean
    //   76	2	2	localThrowable2	Throwable
    //   89	6	2	localObject2	Object
    //   85	27	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   64	69	76	finally
    //   77	81	89	finally
    //   45	64	96	finally
    //   69	73	96	finally
    //   90	94	96	finally
    //   94	96	96	finally
    //   69	73	116	java/lang/Exception
    //   90	94	120	java/lang/Exception
  }
  
  public b(Class<Enum> paramClass)
  {
    A = paramClass;
    z = EnumSet.allOf(paramClass);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    paramClass = z.iterator();
    while (paramClass.hasNext())
    {
      Enum localEnum = (Enum)paramClass.next();
      if ((localEnum instanceof a))
      {
        a locala = (a)localEnum;
        localHashMap1.put(localEnum.name(), locala);
        localHashMap2.put(Long.valueOf(locala.longValue()), locala);
      }
    }
    x = Collections.unmodifiableMap(localHashMap1);
    y = Collections.unmodifiableMap(localHashMap2);
  }
  
  public static final Class<Enum> a(String paramString)
  {
    Object localObject1 = c.a;
    String[] arrayOfString;
    if (c.b)
    {
      arrayOfString = new String[3];
      arrayOfString[0] = ((c)localObject1).a();
      arrayOfString[1] = ((c)localObject1).b();
      arrayOfString[2] = String.format("%s.platform.fake", new Object[] { c.c.a });
    }
    else
    {
      arrayOfString = new String[2];
      arrayOfString[0] = ((c)localObject1).a();
      arrayOfString[1] = ((c)localObject1).b();
    }
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++)
    {
      localObject1 = e.a.a.a.a.a(arrayOfString[j], ".", paramString);
      if (E)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((String)localObject1).replace('.', '/'));
        ((StringBuilder)localObject2).append(".class");
        localObject2 = ((StringBuilder)localObject2).toString();
        if (D.getResource((String)localObject2) == null)
        {
          k = 0;
          break label156;
        }
      }
      int k = 1;
      label156:
      if (k != 0) {}
      try
      {
        localObject1 = Class.forName((String)localObject1, true, D).asSubclass(Enum.class);
        return (Class<Enum>)localObject1;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;) {}
      }
    }
    return null;
  }
  
  public static b b(String paramString)
  {
    synchronized (C)
    {
      Object localObject2 = (b)B.get(paramString);
      Object localObject3 = localObject2;
      if (localObject2 == null)
      {
        Class localClass = a(paramString);
        if (localClass == null) {
          return null;
        }
        if (a.class.isAssignableFrom(localClass))
        {
          localObject2 = B;
          localObject3 = new g/a/b;
          ((b)localObject3).<init>(localClass);
          ((ConcurrentMap)localObject2).put(paramString, localObject3);
        }
        else
        {
          localObject2 = new java/lang/ClassCastException;
          localObject3 = new java/lang/StringBuilder;
          ((StringBuilder)localObject3).<init>();
          ((StringBuilder)localObject3).append("class for ");
          ((StringBuilder)localObject3).append(paramString);
          ((StringBuilder)localObject3).append(" does not implement Constant interface");
          ((ClassCastException)localObject2).<init>(((StringBuilder)localObject3).toString());
          throw ((Throwable)localObject2);
        }
      }
      return (b)localObject3;
    }
  }
  
  public boolean contains(Object paramObject)
  {
    boolean bool;
    if ((paramObject != null) && (paramObject.getClass().equals(A))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Iterator<a> iterator()
  {
    return new b.b(this, z);
  }
  
  public int size()
  {
    return z.size();
  }
}

/* Location:
 * Qualified Name:     base.g.a.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */