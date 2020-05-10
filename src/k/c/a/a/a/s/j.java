package k.c.a.a.a.s;

import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k.c.a.a.a.t.b;
import k.c.a.a.a.t.c;
import k.c.a.a.a.v.a;

public class j
{
  public static b a = c.a("org.eclipse.paho.client.mqttv3.internal.nls.logcat", j.class.getSimpleName());
  public static final ServiceLoader<a> b = ServiceLoader.load(a.class, j.class.getClassLoader());
  public static final Pattern c = Pattern.compile("((.+)@)?([^:]*)(:(\\d+))?");
  
  public static i a(String paramString1, k.c.a.a.a.i parami, String paramString2)
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
    //   18: ifnull +127 -> 145
    //   21: aload_2
    //   22: invokevirtual 113	java/lang/String:isEmpty	()Z
    //   25: ifne +120 -> 145
    //   28: aload_2
    //   29: invokevirtual 75	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   32: astore_2
    //   33: getstatic 42	k/c/a/a/a/s/j:b	Ljava/util/ServiceLoader;
    //   36: invokevirtual 79	java/util/ServiceLoader:iterator	()Ljava/util/Iterator;
    //   39: astore_3
    //   40: aload_3
    //   41: invokeinterface 85 1 0
    //   46: ifeq +42 -> 88
    //   49: aload_3
    //   50: invokeinterface 89 1 0
    //   55: checkcast 30	k/c/a/a/a/v/a
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
    //   91: astore_1
    //   92: new 116	java/lang/StringBuilder
    //   95: astore 4
    //   97: aload 4
    //   99: ldc 118
    //   101: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   104: aload 4
    //   106: aload_2
    //   107: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 4
    //   113: ldc 125
    //   115: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload 4
    //   121: aload_0
    //   122: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 4
    //   128: ldc 127
    //   130: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload_1
    //   135: aload 4
    //   137: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokespecial 107	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   143: aload_1
    //   144: athrow
    //   145: new 103	java/lang/IllegalArgumentException
    //   148: astore_2
    //   149: new 116	java/lang/StringBuilder
    //   152: astore_1
    //   153: aload_1
    //   154: ldc -126
    //   156: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   159: aload_1
    //   160: aload_0
    //   161: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_2
    //   166: aload_1
    //   167: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokespecial 107	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   173: aload_2
    //   174: athrow
    //   175: astore_0
    //   176: goto +44 -> 220
    //   179: astore 4
    //   181: new 103	java/lang/IllegalArgumentException
    //   184: astore_2
    //   185: new 116	java/lang/StringBuilder
    //   188: astore_1
    //   189: aload_1
    //   190: ldc -124
    //   192: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   195: aload_1
    //   196: aload_0
    //   197: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload_1
    //   202: ldc 127
    //   204: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload_2
    //   209: aload_1
    //   210: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: aload 4
    //   215: invokespecial 110	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   218: aload_2
    //   219: athrow
    //   220: ldc 2
    //   222: monitorexit
    //   223: aload_0
    //   224: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	paramString	String
    //   6	204	1	localObject1	Object
    //   16	203	2	localObject2	Object
    //   39	11	3	localIterator	Iterator
    //   58	78	4	localObject3	Object
    //   179	35	4	localURISyntaxException	URISyntaxException
    // Exception table:
    //   from	to	target	type
    //   3	17	175	finally
    //   21	40	175	finally
    //   40	84	175	finally
    //   88	145	175	finally
    //   145	175	175	finally
    //   181	220	175	finally
    //   3	17	179	java/net/URISyntaxException
    //   21	40	179	java/net/URISyntaxException
    //   40	84	179	java/net/URISyntaxException
    //   88	145	179	java/net/URISyntaxException
    //   145	175	179	java/net/URISyntaxException
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
 * Qualified Name:     base.k.c.a.a.a.s.j
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */