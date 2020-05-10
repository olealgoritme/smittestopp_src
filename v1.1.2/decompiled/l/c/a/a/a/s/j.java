package l.c.a.a.a.s;

import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l.c.a.a.a.t.b;
import l.c.a.a.a.t.c;
import l.c.a.a.a.v.a;

public class j
{
  public static b a = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", j.class.getSimpleName());
  public static final ServiceLoader<a> b = ServiceLoader.load(a.class, j.class.getClassLoader());
  public static final Pattern c = Pattern.compile("((.+)@)?([^:]*)(:(\\d+))?");
  
  public static i a(String paramString1, l.c.a.a.a.i parami, String paramString2)
  {
    try
    {
      URI localURI = new java/net/URI;
      localURI.<init>(paramString1);
      a(localURI);
      String str = localURI.getScheme().toLowerCase();
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.a().contains(str)) {
          return locala.a(localURI, parami, paramString2);
        }
      }
      parami = new java/lang/IllegalArgumentException;
      parami.<init>(localURI.toString());
      throw parami;
    }
    catch (URISyntaxException parami)
    {
      throw new IllegalArgumentException(paramString1, parami);
    }
  }
  
  /* Error */
  public static void a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 61	java/net/URI
    //   6: astore_1
    //   7: aload_1
    //   8: aload_0
    //   9: invokespecial 64	java/net/URI:<init>	(Ljava/lang/String;)V
    //   12: aload_1
    //   13: invokevirtual 70	java/net/URI:getScheme	()Ljava/lang/String;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull +123 -> 141
    //   21: aload_2
    //   22: invokevirtual 113	java/lang/String:isEmpty	()Z
    //   25: ifne +116 -> 141
    //   28: aload_2
    //   29: invokevirtual 75	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   32: astore_2
    //   33: getstatic 42	l/c/a/a/a/s/j:b	Ljava/util/ServiceLoader;
    //   36: invokevirtual 79	java/util/ServiceLoader:iterator	()Ljava/util/Iterator;
    //   39: astore_3
    //   40: aload_3
    //   41: invokeinterface 85 1 0
    //   46: ifeq +42 -> 88
    //   49: aload_3
    //   50: invokeinterface 89 1 0
    //   55: checkcast 30	l/c/a/a/a/v/a
    //   58: astore 4
    //   60: aload 4
    //   62: invokeinterface 92 1 0
    //   67: aload_2
    //   68: invokeinterface 98 2 0
    //   73: ifeq -33 -> 40
    //   76: aload 4
    //   78: aload_1
    //   79: invokeinterface 114 2 0
    //   84: ldc 2
    //   86: monitorexit
    //   87: return
    //   88: new 103	java/lang/IllegalArgumentException
    //   91: astore 4
    //   93: new 116	java/lang/StringBuilder
    //   96: astore_1
    //   97: aload_1
    //   98: ldc 118
    //   100: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   103: aload_1
    //   104: aload_2
    //   105: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_1
    //   110: ldc 125
    //   112: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_1
    //   117: aload_0
    //   118: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_1
    //   123: ldc 127
    //   125: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 4
    //   131: aload_1
    //   132: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokespecial 107	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   138: aload 4
    //   140: athrow
    //   141: new 103	java/lang/IllegalArgumentException
    //   144: astore_2
    //   145: new 116	java/lang/StringBuilder
    //   148: astore_1
    //   149: aload_1
    //   150: ldc -126
    //   152: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: aload_1
    //   156: aload_0
    //   157: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_2
    //   162: aload_1
    //   163: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokespecial 107	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   169: aload_2
    //   170: athrow
    //   171: astore_0
    //   172: goto +45 -> 217
    //   175: astore_2
    //   176: new 103	java/lang/IllegalArgumentException
    //   179: astore 4
    //   181: new 116	java/lang/StringBuilder
    //   184: astore_1
    //   185: aload_1
    //   186: ldc -124
    //   188: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   191: aload_1
    //   192: aload_0
    //   193: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload_1
    //   198: ldc 127
    //   200: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload 4
    //   206: aload_1
    //   207: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: aload_2
    //   211: invokespecial 110	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   214: aload 4
    //   216: athrow
    //   217: ldc 2
    //   219: monitorexit
    //   220: aload_0
    //   221: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	paramString	String
    //   6	201	1	localObject1	Object
    //   16	154	2	localObject2	Object
    //   175	36	2	localURISyntaxException	URISyntaxException
    //   39	11	3	localIterator	Iterator
    //   58	157	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   3	17	171	finally
    //   21	40	171	finally
    //   40	84	171	finally
    //   88	141	171	finally
    //   141	171	171	finally
    //   176	217	171	finally
    //   3	17	175	java/net/URISyntaxException
    //   21	40	175	java/net/URISyntaxException
    //   40	84	175	java/net/URISyntaxException
    //   88	141	175	java/net/URISyntaxException
    //   141	171	175	java/net/URISyntaxException
  }
  
  public static void a(URI paramURI)
  {
    if ((paramURI != null) && (paramURI.getHost() == null) && (paramURI.getAuthority() != null) && (!paramURI.getAuthority().isEmpty()))
    {
      Object localObject = c.matcher(paramURI.getAuthority());
      if (((Matcher)localObject).find())
      {
        a(paramURI, "userInfo", ((Matcher)localObject).group(2));
        a(paramURI, "host", ((Matcher)localObject).group(3));
        localObject = ((Matcher)localObject).group(5);
        int i;
        if (localObject != null) {
          i = Integer.parseInt((String)localObject);
        } else {
          i = -1;
        }
        a(paramURI, "port", Integer.valueOf(i));
      }
    }
  }
  
  public static void a(URI paramURI, String paramString, Object paramObject)
  {
    try
    {
      paramString = URI.class.getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramString.set(paramURI, paramObject);
    }
    catch (IllegalAccessException paramString) {}catch (IllegalArgumentException paramString) {}catch (SecurityException paramString) {}catch (NoSuchFieldException paramString) {}
    a.b(j.class.getName(), "setURIField", "115", new Object[] { paramURI.toString() }, paramString);
  }
}

/* Location:
 * Qualified Name:     l.c.a.a.a.s.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */