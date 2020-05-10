package h.c;

import h.c.l.c;
import h.c.l.c.a;
import h.c.l.f;
import h.c.l.g;
import h.c.l.h.a;
import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public abstract class a<T>
{
  public final List<String> a = new ArrayList();
  public final List<String> b = new ArrayList();
  public final List<h.c.l.d> c = new ArrayList();
  public final List<c> d = new ArrayList();
  public final Map<b, Object> e = new EnumMap(b.class);
  public final h.a f = new h.a();
  public final c.a g = new c.a();
  public final Class<T> h;
  public boolean i = false;
  
  public a(Class<T> paramClass)
  {
    h = paramClass;
  }
  
  public T a()
  {
    if (!b.isEmpty())
    {
      Object localObject1 = c;
      Object localObject2 = f;
      ((List)localObject1).add(0, new h.c.l.e(new g(a, b)));
      Object localObject3 = e;
      localObject2 = b.TypeMapper;
      if (c.size() > 1) {
        localObject1 = new h.c.l.b(c);
      } else {
        localObject1 = (h.c.l.d)c.get(0);
      }
      ((Map)localObject3).put(localObject2, localObject1);
      localObject2 = d;
      localObject1 = g;
      if (localObject1 != null)
      {
        ((List)localObject2).add(0, new f(a));
        localObject2 = e;
        localObject3 = b.FunctionMapper;
        if (d.size() > 1) {
          localObject1 = new h.c.l.a(d);
        } else {
          localObject1 = (c)d.get(0);
        }
        ((Map)localObject2).put(localObject3, localObject1);
        try
        {
          localObject2 = h;
          localObject3 = Collections.unmodifiableList(b);
          localObject1 = new java/util/ArrayList;
          ((ArrayList)localObject1).<init>(a);
          ((ArrayList)localObject1).addAll(b.a);
          a((Class)localObject2, (Collection)localObject3, Collections.unmodifiableList((List)localObject1), Collections.unmodifiableMap(e));
          throw null;
        }
        catch (Exception localException)
        {
          RuntimeException localRuntimeException;
          if ((localException instanceof RuntimeException)) {
            localRuntimeException = (RuntimeException)localException;
          } else {
            localRuntimeException = new RuntimeException(localRuntimeException);
          }
          if (!i) {
            return (T)a(localRuntimeException);
          }
          throw localRuntimeException;
        }
        catch (LinkageError localLinkageError)
        {
          if (!i) {
            return (T)a(localLinkageError);
          }
          throw localLinkageError;
        }
      }
      throw null;
    }
    throw new UnsatisfiedLinkError("no library names specified");
  }
  
  public abstract T a(Class<T> paramClass, Collection<String> paramCollection1, Collection<String> paramCollection2, Map<b, Object> paramMap);
  
  public final T a(final Throwable paramThrowable)
  {
    Class localClass1 = h;
    ClassLoader localClassLoader = localClass1.getClassLoader();
    Class localClass2 = h;
    paramThrowable = new a(paramThrowable);
    return (T)localClass1.cast(Proxy.newProxyInstance(localClassLoader, new Class[] { localClass2, h.c.m.e.class }, paramThrowable));
  }
  
  public class a
    implements InvocationHandler
  {
    public a(Throwable paramThrowable) {}
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    {
      throw paramThrowable;
    }
  }
  
  public static final class b
  {
    public static final List<String> a;
    
    static
    {
      ArrayList localArrayList = new ArrayList();
      try
      {
        localArrayList.addAll(a.a("jnr.ffi.library.path"));
        localArrayList.addAll(a.a("jaffl.library.path"));
        localArrayList.addAll(a.a("jna.library.path"));
        localArrayList.addAll(a.a("java.library.path"));
        int i = da.ordinal();
        if ((i == 1) || (i == 2) || (i == 3) || (i == 5) || (i == 9))
        {
          File localFile = new File("/etc/ld.so.conf");
          Object localObject = new File("/etc/ld.so.conf.d");
          if (localFile.exists()) {
            a(localArrayList, localFile);
          }
          if (((File)localObject).isDirectory())
          {
            localObject = ((File)localObject).listFiles();
            int j = localObject.length;
            for (i = 0; i < j; i++) {
              a(localArrayList, localObject[i]);
            }
          }
        }
        a = Collections.unmodifiableList(new ArrayList(localArrayList));
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
    
    /* Error */
    public static void a(List<String> paramList, File paramFile)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual 89	java/io/File:isFile	()Z
      //   4: ifeq +129 -> 133
      //   7: aload_1
      //   8: invokevirtual 62	java/io/File:exists	()Z
      //   11: ifne +6 -> 17
      //   14: goto +119 -> 133
      //   17: aconst_null
      //   18: astore_2
      //   19: aconst_null
      //   20: astore_3
      //   21: new 91	java/io/BufferedReader
      //   24: astore 4
      //   26: new 93	java/io/FileReader
      //   29: astore 5
      //   31: aload 5
      //   33: aload_1
      //   34: invokespecial 96	java/io/FileReader:<init>	(Ljava/io/File;)V
      //   37: aload 4
      //   39: aload 5
      //   41: invokespecial 99	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   44: aload 4
      //   46: invokevirtual 103	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   49: astore_1
      //   50: aload_1
      //   51: ifnull +36 -> 87
      //   54: new 51	java/io/File
      //   57: astore_3
      //   58: aload_3
      //   59: aload_1
      //   60: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
      //   63: aload_3
      //   64: invokevirtual 62	java/io/File:exists	()Z
      //   67: ifeq +11 -> 78
      //   70: aload_0
      //   71: aload_1
      //   72: invokeinterface 109 2 0
      //   77: pop
      //   78: aload 4
      //   80: invokevirtual 103	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   83: astore_1
      //   84: goto -34 -> 50
      //   87: aload 4
      //   89: invokevirtual 112	java/io/BufferedReader:close	()V
      //   92: goto +41 -> 133
      //   95: astore_0
      //   96: aload 4
      //   98: astore_1
      //   99: goto +10 -> 109
      //   102: astore_0
      //   103: goto +20 -> 123
      //   106: astore_0
      //   107: aload_3
      //   108: astore_1
      //   109: aload_1
      //   110: ifnull +7 -> 117
      //   113: aload_1
      //   114: invokevirtual 112	java/io/BufferedReader:close	()V
      //   117: aload_0
      //   118: athrow
      //   119: astore_0
      //   120: aload_2
      //   121: astore 4
      //   123: aload 4
      //   125: ifnull +8 -> 133
      //   128: aload 4
      //   130: invokevirtual 112	java/io/BufferedReader:close	()V
      //   133: return
      //   134: astore_0
      //   135: goto -2 -> 133
      //   138: astore_1
      //   139: goto -22 -> 117
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	142	0	paramList	List<String>
      //   0	142	1	paramFile	File
      //   18	103	2	localObject1	Object
      //   20	88	3	localFile	File
      //   24	105	4	localObject2	Object
      //   29	11	5	localFileReader	java.io.FileReader
      // Exception table:
      //   from	to	target	type
      //   44	50	95	finally
      //   54	78	95	finally
      //   78	84	95	finally
      //   44	50	102	java/io/IOException
      //   54	78	102	java/io/IOException
      //   78	84	102	java/io/IOException
      //   21	44	106	finally
      //   21	44	119	java/io/IOException
      //   87	92	134	java/io/IOException
      //   128	133	134	java/io/IOException
      //   113	117	138	java/io/IOException
    }
  }
}

/* Location:
 * Qualified Name:     h.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */