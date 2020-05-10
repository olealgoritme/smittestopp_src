package no.simula.corona;

import com.microsoft.appcenter.crashes.Crashes;
import d.o.g.a;
import d.o.k;
import d.o.s;
import d.r.b;
import i.k.b.g;
import m.a.a.b;

public final class CoronaApp
  extends b
  implements k
{
  public static CoronaApp z;
  public boolean x;
  public boolean y;
  
  @s(g.a.ON_STOP)
  public final void onAppBackgrounded()
  {
    x = true;
  }
  
  @s(g.a.ON_START)
  public final void onAppForegrounded()
  {
    x = false;
  }
  
  /* Error */
  public void onCreate()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 36	android/app/Application:onCreate	()V
    //   4: aload_0
    //   5: putstatic 38	no/simula/corona/CoronaApp:z	Lno/simula/corona/CoronaApp;
    //   8: getstatic 44	d/o/t:F	Ld/o/t;
    //   11: invokeinterface 50 1 0
    //   16: aload_0
    //   17: invokevirtual 55	d/o/g:a	(Ld/o/k;)V
    //   20: aload_0
    //   21: aload_0
    //   22: ldc 56
    //   24: invokevirtual 60	android/app/Application:getString	(I)Ljava/lang/String;
    //   27: iconst_2
    //   28: anewarray 62	java/lang/Class
    //   31: dup
    //   32: iconst_0
    //   33: ldc 64
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: ldc 66
    //   40: aastore
    //   41: invokestatic 72	com/microsoft/appcenter/AppCenter:start	(Landroid/app/Application;Ljava/lang/String;[Ljava/lang/Class;)V
    //   44: new 8	no/simula/corona/CoronaApp$a
    //   47: dup
    //   48: invokespecial 73	no/simula/corona/CoronaApp$a:<init>	()V
    //   51: invokestatic 78	m/a/a:a	(Lm/a/a$b;)V
    //   54: getstatic 82	m/a/a:d	Lm/a/a$b;
    //   57: ldc 84
    //   59: iconst_0
    //   60: anewarray 86	java/lang/Object
    //   63: invokevirtual 91	m/a/a$b:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   66: getstatic 96	k/b/a/y/b:a	Ljava/lang/String;
    //   69: ifnonnull +12 -> 81
    //   72: aload_0
    //   73: ldc 98
    //   75: invokestatic 101	k/b/a/y/b:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   78: putstatic 96	k/b/a/y/b:a	Ljava/lang/String;
    //   81: getstatic 104	k/b/a/y/b:b	Ljava/lang/String;
    //   84: ifnonnull +12 -> 96
    //   87: aload_0
    //   88: ldc 106
    //   90: invokestatic 101	k/b/a/y/b:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   93: putstatic 104	k/b/a/y/b:b	Ljava/lang/String;
    //   96: getstatic 112	no/simula/corona/data/legacy/MeasurementDatabase:k	Lno/simula/corona/data/legacy/MeasurementDatabase$a;
    //   99: astore_1
    //   100: aload_0
    //   101: ldc 114
    //   103: invokevirtual 120	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   106: astore_1
    //   107: aload_1
    //   108: ldc 122
    //   110: invokestatic 127	i/k/b/g:a	(Ljava/lang/Object;Ljava/lang/String;)V
    //   113: aload_1
    //   114: invokevirtual 133	java/io/File:exists	()Z
    //   117: istore_2
    //   118: iload_2
    //   119: ifeq +15 -> 134
    //   122: getstatic 82	m/a/a:d	Lm/a/a$b;
    //   125: ldc -121
    //   127: iconst_0
    //   128: anewarray 86	java/lang/Object
    //   131: invokevirtual 91	m/a/a$b:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   134: iload_2
    //   135: ifne +18 -> 153
    //   138: getstatic 82	m/a/a:d	Lm/a/a$b;
    //   141: ldc -119
    //   143: iconst_0
    //   144: anewarray 86	java/lang/Object
    //   147: invokevirtual 91	m/a/a$b:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: goto +1173 -> 1323
    //   153: new 139	k/b/a/v/f/d
    //   156: dup
    //   157: aload_0
    //   158: invokespecial 142	k/b/a/v/f/d:<init>	(Landroid/content/Context;)V
    //   161: astore_3
    //   162: new 144	k/b/a/v/e/d
    //   165: dup
    //   166: aload_0
    //   167: invokespecial 145	k/b/a/v/e/d:<init>	(Landroid/content/Context;)V
    //   170: astore 4
    //   172: aload_3
    //   173: getfield 148	k/b/a/v/f/d:a	Lno/simula/corona/data/legacy/MeasurementDatabase;
    //   176: invokevirtual 152	no/simula/corona/data/legacy/MeasurementDatabase:h	()Lk/b/a/v/f/f;
    //   179: checkcast 154	k/b/a/v/f/g
    //   182: astore_1
    //   183: aload_1
    //   184: ifnull +1176 -> 1360
    //   187: ldc -100
    //   189: iconst_0
    //   190: invokestatic 161	d/u/i:a	(Ljava/lang/String;I)Ld/u/i;
    //   193: astore 5
    //   195: aload_1
    //   196: getfield 164	k/b/a/v/f/g:a	Ld/u/g;
    //   199: invokevirtual 168	d/u/g:b	()V
    //   202: aload_1
    //   203: getfield 164	k/b/a/v/f/g:a	Ld/u/g;
    //   206: aload 5
    //   208: iconst_0
    //   209: aconst_null
    //   210: invokestatic 173	d/u/m/b:a	(Ld/u/g;Ld/w/a/e;ZLandroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   213: astore 6
    //   215: aload 6
    //   217: ldc -81
    //   219: invokestatic 180	d/b/a/s:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   222: istore 7
    //   224: aload 6
    //   226: ldc -74
    //   228: invokestatic 180	d/b/a/s:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   231: istore 8
    //   233: aload 6
    //   235: ldc -72
    //   237: invokestatic 180	d/b/a/s:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   240: istore 9
    //   242: aload 6
    //   244: ldc -70
    //   246: invokestatic 180	d/b/a/s:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   249: istore 10
    //   251: aload 6
    //   253: ldc -68
    //   255: invokestatic 180	d/b/a/s:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   258: istore 11
    //   260: aload 6
    //   262: ldc -66
    //   264: invokestatic 180	d/b/a/s:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   267: istore 12
    //   269: aload 6
    //   271: ldc -64
    //   273: invokestatic 180	d/b/a/s:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   276: istore 13
    //   278: aload 6
    //   280: ldc -62
    //   282: invokestatic 180	d/b/a/s:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   285: istore 14
    //   287: aload 6
    //   289: ldc -60
    //   291: invokestatic 180	d/b/a/s:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   294: istore 15
    //   296: aload 6
    //   298: ldc -58
    //   300: invokestatic 180	d/b/a/s:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   303: istore 16
    //   305: new 200	java/util/ArrayList
    //   308: astore 17
    //   310: aload 17
    //   312: aload 6
    //   314: invokeinterface 206 1 0
    //   319: invokespecial 209	java/util/ArrayList:<init>	(I)V
    //   322: aload 6
    //   324: invokeinterface 212 1 0
    //   329: ifeq +352 -> 681
    //   332: aload 6
    //   334: iload 8
    //   336: invokeinterface 216 2 0
    //   341: lstore 18
    //   343: aload 6
    //   345: iload 9
    //   347: invokeinterface 220 2 0
    //   352: ifeq +8 -> 360
    //   355: aconst_null
    //   356: astore_1
    //   357: goto +19 -> 376
    //   360: aload 6
    //   362: iload 9
    //   364: invokeinterface 224 2 0
    //   369: invokestatic 230	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   372: astore_1
    //   373: goto -16 -> 357
    //   376: aload 6
    //   378: iload 10
    //   380: invokeinterface 220 2 0
    //   385: ifeq +9 -> 394
    //   388: aconst_null
    //   389: astore 20
    //   391: goto +20 -> 411
    //   394: aload 6
    //   396: iload 10
    //   398: invokeinterface 224 2 0
    //   403: invokestatic 230	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   406: astore 20
    //   408: goto -17 -> 391
    //   411: aload 6
    //   413: iload 11
    //   415: invokeinterface 220 2 0
    //   420: ifeq +9 -> 429
    //   423: aconst_null
    //   424: astore 21
    //   426: goto +20 -> 446
    //   429: aload 6
    //   431: iload 11
    //   433: invokeinterface 224 2 0
    //   438: invokestatic 230	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   441: astore 21
    //   443: goto -17 -> 426
    //   446: aload 6
    //   448: iload 12
    //   450: invokeinterface 220 2 0
    //   455: ifeq +9 -> 464
    //   458: aconst_null
    //   459: astore 22
    //   461: goto +20 -> 481
    //   464: aload 6
    //   466: iload 12
    //   468: invokeinterface 224 2 0
    //   473: invokestatic 230	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   476: astore 22
    //   478: goto -17 -> 461
    //   481: aload 6
    //   483: iload 13
    //   485: invokeinterface 220 2 0
    //   490: ifeq +9 -> 499
    //   493: aconst_null
    //   494: astore 23
    //   496: goto +20 -> 516
    //   499: aload 6
    //   501: iload 13
    //   503: invokeinterface 224 2 0
    //   508: invokestatic 230	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   511: astore 23
    //   513: goto -17 -> 496
    //   516: aload 6
    //   518: iload 14
    //   520: invokeinterface 220 2 0
    //   525: ifeq +9 -> 534
    //   528: aconst_null
    //   529: astore 24
    //   531: goto +20 -> 551
    //   534: aload 6
    //   536: iload 14
    //   538: invokeinterface 224 2 0
    //   543: invokestatic 230	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   546: astore 24
    //   548: goto -17 -> 531
    //   551: aload 6
    //   553: iload 15
    //   555: invokeinterface 220 2 0
    //   560: ifeq +9 -> 569
    //   563: aconst_null
    //   564: astore 25
    //   566: goto +20 -> 586
    //   569: aload 6
    //   571: iload 15
    //   573: invokeinterface 224 2 0
    //   578: invokestatic 230	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   581: astore 25
    //   583: goto -17 -> 566
    //   586: aload 6
    //   588: iload 16
    //   590: invokeinterface 234 2 0
    //   595: ifeq +8 -> 603
    //   598: iconst_1
    //   599: istore_2
    //   600: goto +5 -> 605
    //   603: iconst_0
    //   604: istore_2
    //   605: new 236	k/b/a/v/f/e
    //   608: astore 26
    //   610: aload 26
    //   612: lload 18
    //   614: aload_1
    //   615: aload 20
    //   617: aload 21
    //   619: aload 22
    //   621: aload 23
    //   623: aload 24
    //   625: aload 25
    //   627: iload_2
    //   628: invokespecial 239	k/b/a/v/f/e:<init>	(JLjava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Z)V
    //   631: aload 6
    //   633: iload 7
    //   635: invokeinterface 220 2 0
    //   640: ifeq +8 -> 648
    //   643: aconst_null
    //   644: astore_1
    //   645: goto +19 -> 664
    //   648: aload 6
    //   650: iload 7
    //   652: invokeinterface 234 2 0
    //   657: invokestatic 244	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   660: astore_1
    //   661: goto -16 -> 645
    //   664: aload 26
    //   666: aload_1
    //   667: putfield 247	k/b/a/v/f/e:a	Ljava/lang/Integer;
    //   670: aload 17
    //   672: aload 26
    //   674: invokevirtual 251	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   677: pop
    //   678: goto -356 -> 322
    //   681: aload 6
    //   683: invokeinterface 254 1 0
    //   688: aload 5
    //   690: invokevirtual 255	d/u/i:b	()V
    //   693: aload 17
    //   695: invokestatic 260	k/b/a/v/g/b:a	(Ljava/util/List;)Ljava/util/List;
    //   698: astore 20
    //   700: aload 20
    //   702: invokeinterface 265 1 0
    //   707: iconst_1
    //   708: ixor
    //   709: ifeq +70 -> 779
    //   712: aload 4
    //   714: new 267	k/b/a/v/e/h
    //   717: dup
    //   718: aload 4
    //   720: aload 20
    //   722: invokespecial 270	k/b/a/v/e/h:<init>	(Lk/b/a/v/e/d;Ljava/util/List;)V
    //   725: invokevirtual 273	k/b/a/v/e/d:a	(Ljava/lang/Runnable;)V
    //   728: aload_3
    //   729: invokevirtual 276	k/b/a/v/f/d:f	()V
    //   732: new 278	java/lang/StringBuilder
    //   735: dup
    //   736: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   739: astore_1
    //   740: aload_1
    //   741: ldc_w 281
    //   744: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload_1
    //   749: aload 20
    //   751: invokeinterface 290 1 0
    //   756: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   759: pop
    //   760: aload_1
    //   761: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   764: astore_1
    //   765: getstatic 82	m/a/a:d	Lm/a/a$b;
    //   768: aload_1
    //   769: iconst_0
    //   770: anewarray 86	java/lang/Object
    //   773: invokevirtual 91	m/a/a$b:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   776: goto +16 -> 792
    //   779: getstatic 82	m/a/a:d	Lm/a/a$b;
    //   782: ldc_w 299
    //   785: iconst_0
    //   786: anewarray 86	java/lang/Object
    //   789: invokevirtual 91	m/a/a$b:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   792: aload_3
    //   793: getfield 148	k/b/a/v/f/d:a	Lno/simula/corona/data/legacy/MeasurementDatabase;
    //   796: invokevirtual 303	no/simula/corona/data/legacy/MeasurementDatabase:g	()Lk/b/a/v/f/b;
    //   799: checkcast 305	k/b/a/v/f/c
    //   802: astore_1
    //   803: aload_1
    //   804: ifnull +535 -> 1339
    //   807: ldc_w 307
    //   810: iconst_0
    //   811: invokestatic 161	d/u/i:a	(Ljava/lang/String;I)Ld/u/i;
    //   814: astore 20
    //   816: aload_1
    //   817: getfield 308	k/b/a/v/f/c:a	Ld/u/g;
    //   820: invokevirtual 168	d/u/g:b	()V
    //   823: aload_1
    //   824: getfield 308	k/b/a/v/f/c:a	Ld/u/g;
    //   827: aload 20
    //   829: iconst_0
    //   830: aconst_null
    //   831: invokestatic 173	d/u/m/b:a	(Ld/u/g;Ld/w/a/e;ZLandroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   834: astore 21
    //   836: aload 21
    //   838: ldc -81
    //   840: invokestatic 180	d/b/a/s:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   843: istore 9
    //   845: aload 21
    //   847: ldc -74
    //   849: invokestatic 180	d/b/a/s:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   852: istore 14
    //   854: aload 21
    //   856: ldc_w 310
    //   859: invokestatic 180	d/b/a/s:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   862: istore 8
    //   864: aload 21
    //   866: ldc_w 312
    //   869: invokestatic 180	d/b/a/s:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   872: istore 11
    //   874: aload 21
    //   876: ldc_w 314
    //   879: invokestatic 180	d/b/a/s:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   882: istore 10
    //   884: aload 21
    //   886: ldc -58
    //   888: invokestatic 180	d/b/a/s:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   891: istore 12
    //   893: new 200	java/util/ArrayList
    //   896: astore 23
    //   898: aload 23
    //   900: aload 21
    //   902: invokeinterface 206 1 0
    //   907: invokespecial 209	java/util/ArrayList:<init>	(I)V
    //   910: aload 21
    //   912: invokeinterface 212 1 0
    //   917: ifeq +130 -> 1047
    //   920: aload 21
    //   922: iload 14
    //   924: invokeinterface 216 2 0
    //   929: lstore 18
    //   931: aload 21
    //   933: iload 8
    //   935: invokeinterface 315 2 0
    //   940: astore_1
    //   941: aload 21
    //   943: iload 11
    //   945: invokeinterface 234 2 0
    //   950: istore 16
    //   952: aload 21
    //   954: iload 10
    //   956: invokeinterface 234 2 0
    //   961: istore 7
    //   963: aload 21
    //   965: iload 12
    //   967: invokeinterface 234 2 0
    //   972: ifeq +8 -> 980
    //   975: iconst_1
    //   976: istore_2
    //   977: goto +5 -> 982
    //   980: iconst_0
    //   981: istore_2
    //   982: new 317	k/b/a/v/f/a
    //   985: astore 22
    //   987: aload 22
    //   989: lload 18
    //   991: aload_1
    //   992: iload 16
    //   994: iload 7
    //   996: iload_2
    //   997: invokespecial 320	k/b/a/v/f/a:<init>	(JLjava/lang/String;IIZ)V
    //   1000: aload 21
    //   1002: iload 9
    //   1004: invokeinterface 220 2 0
    //   1009: ifeq +8 -> 1017
    //   1012: aconst_null
    //   1013: astore_1
    //   1014: goto +16 -> 1030
    //   1017: aload 21
    //   1019: iload 9
    //   1021: invokeinterface 234 2 0
    //   1026: invokestatic 244	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1029: astore_1
    //   1030: aload 22
    //   1032: aload_1
    //   1033: putfield 321	k/b/a/v/f/a:a	Ljava/lang/Integer;
    //   1036: aload 23
    //   1038: aload 22
    //   1040: invokevirtual 251	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1043: pop
    //   1044: goto -134 -> 910
    //   1047: aload 21
    //   1049: invokeinterface 254 1 0
    //   1054: aload 20
    //   1056: invokevirtual 255	d/u/i:b	()V
    //   1059: aload 23
    //   1061: invokestatic 324	k/b/a/v/g/a:a	(Ljava/util/List;)Ljava/util/List;
    //   1064: astore_1
    //   1065: aload_1
    //   1066: invokeinterface 265 1 0
    //   1071: iconst_1
    //   1072: ixor
    //   1073: ifeq +72 -> 1145
    //   1076: aload 4
    //   1078: new 326	k/b/a/v/e/g
    //   1081: dup
    //   1082: aload 4
    //   1084: aload_1
    //   1085: invokespecial 327	k/b/a/v/e/g:<init>	(Lk/b/a/v/e/d;Ljava/util/List;)V
    //   1088: invokevirtual 273	k/b/a/v/e/d:a	(Ljava/lang/Runnable;)V
    //   1091: aload_3
    //   1092: invokevirtual 330	k/b/a/v/f/d:e	()V
    //   1095: new 278	java/lang/StringBuilder
    //   1098: dup
    //   1099: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   1102: astore 20
    //   1104: aload 20
    //   1106: ldc_w 332
    //   1109: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: pop
    //   1113: aload 20
    //   1115: aload_1
    //   1116: invokeinterface 290 1 0
    //   1121: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1124: pop
    //   1125: aload 20
    //   1127: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1130: astore_1
    //   1131: getstatic 82	m/a/a:d	Lm/a/a$b;
    //   1134: aload_1
    //   1135: iconst_0
    //   1136: anewarray 86	java/lang/Object
    //   1139: invokevirtual 91	m/a/a$b:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1142: goto +16 -> 1158
    //   1145: getstatic 82	m/a/a:d	Lm/a/a$b;
    //   1148: ldc_w 334
    //   1151: iconst_0
    //   1152: anewarray 86	java/lang/Object
    //   1155: invokevirtual 91	m/a/a$b:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1158: ldc_w 336
    //   1161: invokestatic 340	e/a/a/a/a:a	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1164: astore_1
    //   1165: aload_1
    //   1166: aload 4
    //   1168: new 342	k/b/a/v/e/f
    //   1171: dup
    //   1172: aload 4
    //   1174: invokespecial 345	k/b/a/v/e/f:<init>	(Lk/b/a/v/e/d;)V
    //   1177: new 200	java/util/ArrayList
    //   1180: dup
    //   1181: invokespecial 346	java/util/ArrayList:<init>	()V
    //   1184: invokevirtual 349	k/b/a/v/e/d:a	(Lk/b/a/v/e/d$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   1187: checkcast 287	java/util/List
    //   1190: invokeinterface 290 1 0
    //   1195: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1198: pop
    //   1199: aload_1
    //   1200: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1203: astore_1
    //   1204: getstatic 82	m/a/a:d	Lm/a/a$b;
    //   1207: aload_1
    //   1208: iconst_0
    //   1209: anewarray 86	java/lang/Object
    //   1212: invokevirtual 91	m/a/a$b:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1215: new 278	java/lang/StringBuilder
    //   1218: dup
    //   1219: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   1222: astore_1
    //   1223: aload_1
    //   1224: ldc_w 351
    //   1227: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1230: pop
    //   1231: aload_1
    //   1232: aload 4
    //   1234: new 353	k/b/a/v/e/e
    //   1237: dup
    //   1238: aload 4
    //   1240: invokespecial 354	k/b/a/v/e/e:<init>	(Lk/b/a/v/e/d;)V
    //   1243: new 200	java/util/ArrayList
    //   1246: dup
    //   1247: invokespecial 346	java/util/ArrayList:<init>	()V
    //   1250: invokevirtual 349	k/b/a/v/e/d:a	(Lk/b/a/v/e/d$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   1253: checkcast 287	java/util/List
    //   1256: invokeinterface 290 1 0
    //   1261: invokevirtual 293	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1264: pop
    //   1265: aload_1
    //   1266: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1269: astore_1
    //   1270: getstatic 82	m/a/a:d	Lm/a/a$b;
    //   1273: aload_1
    //   1274: iconst_0
    //   1275: anewarray 86	java/lang/Object
    //   1278: invokevirtual 91	m/a/a$b:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1281: aload 4
    //   1283: invokevirtual 355	k/b/a/v/e/d:close	()V
    //   1286: getstatic 112	no/simula/corona/data/legacy/MeasurementDatabase:k	Lno/simula/corona/data/legacy/MeasurementDatabase$a;
    //   1289: astore_1
    //   1290: aload_0
    //   1291: ldc 114
    //   1293: invokevirtual 359	android/content/Context:deleteDatabase	(Ljava/lang/String;)Z
    //   1296: ifeq +27 -> 1323
    //   1299: getstatic 82	m/a/a:d	Lm/a/a$b;
    //   1302: ldc_w 361
    //   1305: iconst_0
    //   1306: anewarray 86	java/lang/Object
    //   1309: invokevirtual 91	m/a/a$b:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1312: goto +11 -> 1323
    //   1315: astore_1
    //   1316: getstatic 82	m/a/a:d	Lm/a/a$b;
    //   1319: aload_1
    //   1320: invokevirtual 364	m/a/a$b:b	(Ljava/lang/Throwable;)V
    //   1323: return
    //   1324: astore_1
    //   1325: aload 21
    //   1327: invokeinterface 254 1 0
    //   1332: aload 20
    //   1334: invokevirtual 255	d/u/i:b	()V
    //   1337: aload_1
    //   1338: athrow
    //   1339: aconst_null
    //   1340: athrow
    //   1341: astore_1
    //   1342: goto +4 -> 1346
    //   1345: astore_1
    //   1346: aload 6
    //   1348: invokeinterface 254 1 0
    //   1353: aload 5
    //   1355: invokevirtual 255	d/u/i:b	()V
    //   1358: aload_1
    //   1359: athrow
    //   1360: aconst_null
    //   1361: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1362	0	this	CoronaApp
    //   99	1191	1	localObject1	Object
    //   1315	5	1	localException	Exception
    //   1324	14	1	localObject2	Object
    //   1341	1	1	localObject3	Object
    //   1345	14	1	localObject4	Object
    //   117	880	2	bool	boolean
    //   161	931	3	locald	k.b.a.v.f.d
    //   170	1112	4	locald1	k.b.a.v.e.d
    //   193	1161	5	locali	d.u.i
    //   213	1134	6	localCursor	android.database.Cursor
    //   222	773	7	i	int
    //   231	703	8	j	int
    //   240	780	9	k	int
    //   249	706	10	m	int
    //   258	686	11	n	int
    //   267	699	12	i1	int
    //   276	226	13	i2	int
    //   285	638	14	i3	int
    //   294	278	15	i4	int
    //   303	690	16	i5	int
    //   308	386	17	localArrayList	java.util.ArrayList
    //   341	649	18	l	long
    //   389	944	20	localObject5	Object
    //   424	902	21	localObject6	Object
    //   459	580	22	localObject7	Object
    //   494	566	23	localObject8	Object
    //   529	95	24	localDouble1	Double
    //   564	62	25	localDouble2	Double
    //   608	65	26	locale	k.b.a.v.f.e
    // Exception table:
    //   from	to	target	type
    //   1290	1312	1315	java/lang/Exception
    //   836	910	1324	finally
    //   910	975	1324	finally
    //   982	1012	1324	finally
    //   1017	1030	1324	finally
    //   1030	1044	1324	finally
    //   278	322	1341	finally
    //   322	355	1341	finally
    //   360	373	1341	finally
    //   376	388	1341	finally
    //   394	408	1341	finally
    //   411	423	1341	finally
    //   429	443	1341	finally
    //   446	458	1341	finally
    //   464	478	1341	finally
    //   481	493	1341	finally
    //   499	513	1341	finally
    //   516	528	1341	finally
    //   534	548	1341	finally
    //   551	563	1341	finally
    //   569	583	1341	finally
    //   586	598	1341	finally
    //   605	643	1341	finally
    //   648	661	1341	finally
    //   664	678	1341	finally
    //   215	278	1345	finally
  }
  
  public static final class a
    extends a.b
  {
    public void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
    {
      if ((paramString2 == null) || ((paramInt != 2) && (paramInt != 3))) {}
      try
      {
        Crashes.trackError(paramThrowable);
        return;
        g.a("message");
        throw null;
      }
      catch (Exception paramString1)
      {
        for (;;) {}
      }
    }
  }
}

/* Location:
 * Qualified Name:     no.simula.corona.CoronaApp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */