package k.b.a.y;

import android.util.Base64;
import i.k.b.g;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import m.a.a;
import m.a.a.b;

public final class b
{
  public static String a;
  public static String b;
  
  public static final String a()
  {
    try
    {
      SecureRandom localSecureRandom = new java/security/SecureRandom;
      localSecureRandom.<init>();
      Object localObject = KeyGenerator.getInstance("AES");
      ((KeyGenerator)localObject).init(256, localSecureRandom);
      localObject = ((KeyGenerator)localObject).generateKey();
      g.a(localObject, "keyGenerator.generateKey()");
      localObject = Base64.encodeToString(((SecretKey)localObject).getEncoded(), 2);
      return (String)localObject;
    }
    catch (Exception localException)
    {
      a.d.b(localException);
    }
    return null;
  }
  
  /* Error */
  public static final String a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: aconst_null
    //   5: astore 4
    //   7: aload_0
    //   8: ifnull +190 -> 198
    //   11: aload_1
    //   12: ifnull +181 -> 193
    //   15: ldc 74
    //   17: astore 5
    //   19: aload_0
    //   20: invokevirtual 80	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   23: astore 6
    //   25: aload 6
    //   27: ldc 82
    //   29: iconst_0
    //   30: invokevirtual 86	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   33: aload_1
    //   34: aconst_null
    //   35: invokeinterface 92 3 0
    //   40: astore 7
    //   42: aload 5
    //   44: astore 8
    //   46: aload 7
    //   48: invokestatic 98	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: ifne +12 -> 63
    //   54: aload 6
    //   56: aload 7
    //   58: invokestatic 102	e/c/a/a/b/l/c:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   61: astore 8
    //   63: aload 8
    //   65: astore 5
    //   67: aload 8
    //   69: astore 7
    //   71: aload 8
    //   73: invokeinterface 108 1 0
    //   78: ifne +9 -> 87
    //   81: iconst_1
    //   82: istore 9
    //   84: goto +6 -> 90
    //   87: iconst_0
    //   88: istore 9
    //   90: aload 8
    //   92: astore 5
    //   94: iload 9
    //   96: iconst_1
    //   97: if_icmpne +167 -> 264
    //   100: aload 8
    //   102: astore 5
    //   104: aload 8
    //   106: astore 7
    //   108: invokestatic 110	k/b/a/y/b:a	()Ljava/lang/String;
    //   111: astore 8
    //   113: aload 8
    //   115: astore 5
    //   117: aload 8
    //   119: ifnull +145 -> 264
    //   122: aload 8
    //   124: astore 5
    //   126: aload 8
    //   128: astore 7
    //   130: aload 8
    //   132: invokeinterface 108 1 0
    //   137: ifle +9 -> 146
    //   140: iconst_1
    //   141: istore 9
    //   143: goto +6 -> 149
    //   146: iconst_0
    //   147: istore 9
    //   149: aload 8
    //   151: astore 5
    //   153: iload 9
    //   155: iconst_1
    //   156: if_icmpne +108 -> 264
    //   159: aload 8
    //   161: astore 5
    //   163: aload 8
    //   165: astore 7
    //   167: aload_0
    //   168: aload_1
    //   169: aload 8
    //   171: invokestatic 113	e/c/a/a/b/l/c:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload 8
    //   176: astore 5
    //   178: goto +86 -> 264
    //   181: astore_0
    //   182: goto +25 -> 207
    //   185: astore_0
    //   186: aload 7
    //   188: astore 5
    //   190: goto +31 -> 221
    //   193: invokestatic 115	i/k/b/g:a	()V
    //   196: aconst_null
    //   197: athrow
    //   198: invokestatic 115	i/k/b/g:a	()V
    //   201: aconst_null
    //   202: athrow
    //   203: astore_0
    //   204: aconst_null
    //   205: astore 5
    //   207: getstatic 57	m/a/a:d	Lm/a/a$b;
    //   210: aload_0
    //   211: invokevirtual 62	m/a/a$b:b	(Ljava/lang/Throwable;)V
    //   214: goto +50 -> 264
    //   217: astore_0
    //   218: aconst_null
    //   219: astore 5
    //   221: aload_0
    //   222: getfield 119	f/a/a/a/b:x	Lf/a/a/a/b$a;
    //   225: astore_1
    //   226: aload_1
    //   227: ifnonnull +6 -> 233
    //   230: goto +20 -> 250
    //   233: aload_1
    //   234: invokevirtual 124	java/lang/Enum:ordinal	()I
    //   237: istore 9
    //   239: iload 9
    //   241: ifeq +19 -> 260
    //   244: iload 9
    //   246: iconst_2
    //   247: if_icmpeq +13 -> 260
    //   250: getstatic 57	m/a/a:d	Lm/a/a$b;
    //   253: aload_0
    //   254: invokevirtual 62	m/a/a$b:b	(Ljava/lang/Throwable;)V
    //   257: goto +7 -> 264
    //   260: ldc 126
    //   262: astore 5
    //   264: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   267: lstore 10
    //   269: ldc -128
    //   271: invokestatic 133	e/a/a/a/a:a	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: astore_1
    //   275: aload_1
    //   276: lload 10
    //   278: lload_2
    //   279: lsub
    //   280: invokevirtual 139	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload_1
    //   285: ldc -115
    //   287: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload 4
    //   293: astore_0
    //   294: aload 5
    //   296: ifnull +12 -> 308
    //   299: aload 5
    //   301: invokevirtual 146	java/lang/String:length	()I
    //   304: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   307: astore_0
    //   308: aload_1
    //   309: aload_0
    //   310: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload_1
    //   315: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: astore_0
    //   319: getstatic 57	m/a/a:d	Lm/a/a$b;
    //   322: aload_0
    //   323: iconst_0
    //   324: anewarray 4	java/lang/Object
    //   327: invokevirtual 161	m/a/a$b:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   330: aload 5
    //   332: areturn
    //   333: astore 8
    //   335: aload 5
    //   337: astore 8
    //   339: goto -276 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	paramContext	android.content.Context
    //   0	342	1	paramString	String
    //   3	276	2	l1	long
    //   5	287	4	localObject1	Object
    //   17	319	5	localObject2	Object
    //   23	32	6	localContext	android.content.Context
    //   40	147	7	localObject3	Object
    //   44	131	8	localObject4	Object
    //   333	1	8	localb	f.a.a.a.b
    //   337	1	8	localObject5	Object
    //   82	166	9	i	int
    //   267	10	10	l2	long
    // Exception table:
    //   from	to	target	type
    //   71	81	181	java/lang/Exception
    //   108	113	181	java/lang/Exception
    //   130	140	181	java/lang/Exception
    //   167	174	181	java/lang/Exception
    //   71	81	185	f/a/a/a/b
    //   108	113	185	f/a/a/a/b
    //   130	140	185	f/a/a/a/b
    //   167	174	185	f/a/a/a/b
    //   19	42	203	java/lang/Exception
    //   46	63	203	java/lang/Exception
    //   193	196	203	java/lang/Exception
    //   198	201	203	java/lang/Exception
    //   19	42	217	f/a/a/a/b
    //   193	196	217	f/a/a/a/b
    //   198	201	217	f/a/a/a/b
    //   46	63	333	f/a/a/a/b
  }
}

/* Location:
 * Qualified Name:     k.b.a.y.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */