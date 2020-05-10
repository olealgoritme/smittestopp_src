package e.c.a.a.b;

import java.util.concurrent.atomic.AtomicBoolean;

public class g
{
  @Deprecated
  public static final int a = 12451000;
  public static final AtomicBoolean b = new AtomicBoolean();
  public static final AtomicBoolean c = new AtomicBoolean();
  
  /* Error */
  @Deprecated
  public static int a(android.content.Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 32	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4: getstatic 37	com/google/android/gms/common/R$string:common_google_play_services_unknown_issue	I
    //   7: invokevirtual 43	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   10: pop
    //   11: goto +12 -> 23
    //   14: astore_2
    //   15: ldc 45
    //   17: ldc 47
    //   19: invokestatic 53	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   22: pop
    //   23: ldc 55
    //   25: aload_0
    //   26: invokevirtual 59	android/content/Context:getPackageName	()Ljava/lang/String;
    //   29: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   32: ifne +100 -> 132
    //   35: getstatic 22	e/c/a/a/b/g:c	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   38: invokevirtual 69	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   41: ifne +91 -> 132
    //   44: aload_0
    //   45: invokestatic 74	e/c/a/a/b/j/h0:a	(Landroid/content/Context;)V
    //   48: getstatic 76	e/c/a/a/b/j/h0:c	I
    //   51: istore_3
    //   52: iload_3
    //   53: ifeq +69 -> 122
    //   56: iload_3
    //   57: ldc 7
    //   59: if_icmpne +6 -> 65
    //   62: goto +70 -> 132
    //   65: new 78	java/lang/StringBuilder
    //   68: dup
    //   69: sipush 320
    //   72: invokespecial 81	java/lang/StringBuilder:<init>	(I)V
    //   75: astore_0
    //   76: aload_0
    //   77: ldc 83
    //   79: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload_0
    //   84: ldc 7
    //   86: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_0
    //   91: ldc 92
    //   93: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_0
    //   98: iload_3
    //   99: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload_0
    //   104: ldc 94
    //   106: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: new 96	java/lang/IllegalStateException
    //   113: dup
    //   114: aload_0
    //   115: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokespecial 102	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   121: athrow
    //   122: new 96	java/lang/IllegalStateException
    //   125: dup
    //   126: ldc 104
    //   128: invokespecial 102	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   131: athrow
    //   132: aload_0
    //   133: invokestatic 109	e/c/a/a/b/l/c:b	(Landroid/content/Context;)Z
    //   136: istore 4
    //   138: iconst_1
    //   139: istore 5
    //   141: iload 4
    //   143: ifne +67 -> 210
    //   146: getstatic 112	e/c/a/a/b/l/c:c	Ljava/lang/Boolean;
    //   149: ifnonnull +47 -> 196
    //   152: aload_0
    //   153: invokevirtual 116	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   156: ldc 118
    //   158: invokevirtual 124	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   161: ifne +24 -> 185
    //   164: aload_0
    //   165: invokevirtual 116	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   168: ldc 126
    //   170: invokevirtual 124	android/content/pm/PackageManager:hasSystemFeature	(Ljava/lang/String;)Z
    //   173: ifeq +6 -> 179
    //   176: goto +9 -> 185
    //   179: iconst_0
    //   180: istore 4
    //   182: goto +6 -> 188
    //   185: iconst_1
    //   186: istore 4
    //   188: iload 4
    //   190: invokestatic 132	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   193: putstatic 112	e/c/a/a/b/l/c:c	Ljava/lang/Boolean;
    //   196: getstatic 112	e/c/a/a/b/l/c:c	Ljava/lang/Boolean;
    //   199: invokevirtual 135	java/lang/Boolean:booleanValue	()Z
    //   202: ifne +8 -> 210
    //   205: iconst_1
    //   206: istore_3
    //   207: goto +5 -> 212
    //   210: iconst_0
    //   211: istore_3
    //   212: iload_1
    //   213: iflt +9 -> 222
    //   216: iconst_1
    //   217: istore 4
    //   219: goto +6 -> 225
    //   222: iconst_0
    //   223: istore 4
    //   225: iload 4
    //   227: invokestatic 140	d/b/a/r:a	(Z)V
    //   230: aload_0
    //   231: invokevirtual 116	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   234: astore 6
    //   236: aconst_null
    //   237: astore_2
    //   238: iload_3
    //   239: ifeq +32 -> 271
    //   242: aload 6
    //   244: ldc -114
    //   246: sipush 8256
    //   249: invokevirtual 146	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   252: astore_2
    //   253: goto +18 -> 271
    //   256: astore_0
    //   257: ldc 45
    //   259: ldc -108
    //   261: invokestatic 151	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   264: pop
    //   265: bipush 9
    //   267: istore_1
    //   268: goto +253 -> 521
    //   271: aload 6
    //   273: ldc 55
    //   275: bipush 64
    //   277: invokevirtual 146	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   280: astore 7
    //   282: aload_0
    //   283: invokestatic 156	e/c/a/a/b/h:a	(Landroid/content/Context;)Le/c/a/a/b/h;
    //   286: pop
    //   287: aload 7
    //   289: iconst_1
    //   290: invokestatic 159	e/c/a/a/b/h:a	(Landroid/content/pm/PackageInfo;Z)Z
    //   293: ifne +14 -> 307
    //   296: ldc 45
    //   298: ldc -95
    //   300: invokestatic 151	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   303: pop
    //   304: goto -39 -> 265
    //   307: iload_3
    //   308: ifeq +41 -> 349
    //   311: aload_2
    //   312: iconst_1
    //   313: invokestatic 159	e/c/a/a/b/h:a	(Landroid/content/pm/PackageInfo;Z)Z
    //   316: ifeq +22 -> 338
    //   319: aload_2
    //   320: getfield 167	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   323: iconst_0
    //   324: aaload
    //   325: aload 7
    //   327: getfield 167	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   330: iconst_0
    //   331: aaload
    //   332: invokevirtual 170	android/content/pm/Signature:equals	(Ljava/lang/Object;)Z
    //   335: ifne +14 -> 349
    //   338: ldc 45
    //   340: ldc -84
    //   342: invokestatic 151	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   345: pop
    //   346: goto -81 -> 265
    //   349: aload 7
    //   351: getfield 175	android/content/pm/PackageInfo:versionCode	I
    //   354: istore_3
    //   355: iconst_m1
    //   356: istore 8
    //   358: iload_3
    //   359: iconst_m1
    //   360: if_icmpne +8 -> 368
    //   363: iconst_m1
    //   364: istore_3
    //   365: goto +9 -> 374
    //   368: iload_3
    //   369: sipush 1000
    //   372: idiv
    //   373: istore_3
    //   374: iload_1
    //   375: iconst_m1
    //   376: if_icmpne +6 -> 382
    //   379: goto +10 -> 389
    //   382: iload_1
    //   383: sipush 1000
    //   386: idiv
    //   387: istore 8
    //   389: iload_3
    //   390: iload 8
    //   392: if_icmpge +60 -> 452
    //   395: aload 7
    //   397: getfield 175	android/content/pm/PackageInfo:versionCode	I
    //   400: istore_3
    //   401: new 78	java/lang/StringBuilder
    //   404: dup
    //   405: bipush 77
    //   407: invokespecial 81	java/lang/StringBuilder:<init>	(I)V
    //   410: astore_0
    //   411: aload_0
    //   412: ldc -79
    //   414: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload_0
    //   419: iload_1
    //   420: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload_0
    //   425: ldc 92
    //   427: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload_0
    //   432: iload_3
    //   433: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: ldc 45
    //   439: aload_0
    //   440: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokestatic 151	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   446: pop
    //   447: iconst_2
    //   448: istore_1
    //   449: goto +72 -> 521
    //   452: aload 7
    //   454: getfield 181	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   457: astore_2
    //   458: aload_2
    //   459: astore_0
    //   460: aload_2
    //   461: ifnonnull +31 -> 492
    //   464: aload 6
    //   466: ldc 55
    //   468: iconst_0
    //   469: invokevirtual 185	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   472: astore_0
    //   473: goto +19 -> 492
    //   476: astore_0
    //   477: ldc 45
    //   479: ldc -69
    //   481: aload_0
    //   482: invokestatic 191	android/util/Log:wtf	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   485: pop
    //   486: iload 5
    //   488: istore_1
    //   489: goto +32 -> 521
    //   492: aload_0
    //   493: getfield 197	android/content/pm/ApplicationInfo:enabled	Z
    //   496: ifne +8 -> 504
    //   499: iconst_3
    //   500: istore_1
    //   501: goto +20 -> 521
    //   504: iconst_0
    //   505: istore_1
    //   506: goto +15 -> 521
    //   509: astore_0
    //   510: ldc 45
    //   512: ldc -57
    //   514: invokestatic 151	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   517: pop
    //   518: iload 5
    //   520: istore_1
    //   521: iload_1
    //   522: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	paramContext	android.content.Context
    //   0	523	1	paramInt	int
    //   14	1	2	localObject1	Object
    //   237	224	2	localObject2	Object
    //   51	382	3	i	int
    //   136	90	4	bool	boolean
    //   139	380	5	j	int
    //   234	231	6	localPackageManager	android.content.pm.PackageManager
    //   280	173	7	localPackageInfo	android.content.pm.PackageInfo
    //   356	37	8	k	int
    // Exception table:
    //   from	to	target	type
    //   0	11	14	finally
    //   242	253	256	android/content/pm/PackageManager$NameNotFoundException
    //   464	473	476	android/content/pm/PackageManager$NameNotFoundException
    //   271	282	509	android/content/pm/PackageManager$NameNotFoundException
  }
  
  @Deprecated
  public static String a(int paramInt)
  {
    return a.a(paramInt);
  }
  
  @Deprecated
  public static boolean b(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2) || (paramInt == 3) || (paramInt == 9);
  }
}

/* Location:
 * Qualified Name:     base.e.c.a.a.b.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */