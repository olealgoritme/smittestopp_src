package j.b.a;

import android.content.Context;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import com.microsoft.appcenter.crashes.Crashes;
import h.k.b.g;
import java.util.HashMap;
import java.util.LinkedHashMap;
import no.simula.corona.MeasurementDatabase;

public final class f
  extends AsyncTask<Object, Object, p>
{
  public final MeasurementDatabase a;
  public Context b;
  public e c;
  
  public f(Context paramContext, e parame) {}
  
  public final boolean a()
  {
    boolean bool;
    if ((getStatus() != AsyncTask.Status.RUNNING) && (getStatus() != AsyncTask.Status.PENDING)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  /* Error */
  public final p b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	j/b/a/f:a	Lno/simula/corona/MeasurementDatabase;
    //   4: invokevirtual 62	no/simula/corona/MeasurementDatabase:i	()Lj/b/a/s;
    //   7: checkcast 64	j/b/a/t
    //   10: astore_1
    //   11: aload_1
    //   12: getfield 67	j/b/a/t:a	Ld/u/g;
    //   15: invokevirtual 71	d/u/g:b	()V
    //   18: aload_1
    //   19: getfield 74	j/b/a/t:c	Ld/u/k;
    //   22: invokevirtual 79	d/u/k:a	()Ld/w/a/f/f;
    //   25: astore_2
    //   26: aload_1
    //   27: getfield 67	j/b/a/t:a	Ld/u/g;
    //   30: invokevirtual 81	d/u/g:c	()V
    //   33: aload_2
    //   34: invokevirtual 86	d/w/a/f/f:a	()I
    //   37: pop
    //   38: aload_1
    //   39: getfield 67	j/b/a/t:a	Ld/u/g;
    //   42: invokevirtual 89	d/u/g:g	()V
    //   45: aload_1
    //   46: getfield 67	j/b/a/t:a	Ld/u/g;
    //   49: invokevirtual 92	d/u/g:d	()V
    //   52: aload_1
    //   53: getfield 74	j/b/a/t:c	Ld/u/k;
    //   56: astore_3
    //   57: aload_2
    //   58: aload_3
    //   59: getfield 95	d/u/k:c	Ld/w/a/f/f;
    //   62: if_acmpne +11 -> 73
    //   65: aload_3
    //   66: getfield 98	d/u/k:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   69: iconst_0
    //   70: invokevirtual 104	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   73: aload_0
    //   74: getfield 33	j/b/a/f:a	Lno/simula/corona/MeasurementDatabase;
    //   77: invokevirtual 108	no/simula/corona/MeasurementDatabase:h	()Lj/b/a/b;
    //   80: checkcast 110	j/b/a/c
    //   83: astore_1
    //   84: aload_1
    //   85: getfield 111	j/b/a/c:a	Ld/u/g;
    //   88: invokevirtual 71	d/u/g:b	()V
    //   91: aload_1
    //   92: getfield 112	j/b/a/c:c	Ld/u/k;
    //   95: invokevirtual 79	d/u/k:a	()Ld/w/a/f/f;
    //   98: astore_2
    //   99: aload_1
    //   100: getfield 111	j/b/a/c:a	Ld/u/g;
    //   103: invokevirtual 81	d/u/g:c	()V
    //   106: aload_2
    //   107: invokevirtual 86	d/w/a/f/f:a	()I
    //   110: pop
    //   111: aload_1
    //   112: getfield 111	j/b/a/c:a	Ld/u/g;
    //   115: invokevirtual 89	d/u/g:g	()V
    //   118: aload_1
    //   119: getfield 111	j/b/a/c:a	Ld/u/g;
    //   122: invokevirtual 92	d/u/g:d	()V
    //   125: aload_1
    //   126: getfield 112	j/b/a/c:c	Ld/u/k;
    //   129: astore_3
    //   130: aload_2
    //   131: aload_3
    //   132: getfield 95	d/u/k:c	Ld/w/a/f/f;
    //   135: if_acmpne +11 -> 146
    //   138: aload_3
    //   139: getfield 98	d/u/k:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   142: iconst_0
    //   143: invokevirtual 104	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   146: new 114	j/b/a/n
    //   149: dup
    //   150: invokespecial 115	j/b/a/n:<init>	()V
    //   153: astore 4
    //   155: aload_0
    //   156: getfield 33	j/b/a/f:a	Lno/simula/corona/MeasurementDatabase;
    //   159: invokevirtual 62	no/simula/corona/MeasurementDatabase:i	()Lj/b/a/s;
    //   162: checkcast 64	j/b/a/t
    //   165: astore_2
    //   166: aload_2
    //   167: ifnull +1420 -> 1587
    //   170: ldc 117
    //   172: iconst_0
    //   173: invokestatic 122	d/u/i:a	(Ljava/lang/String;I)Ld/u/i;
    //   176: astore 5
    //   178: aload_2
    //   179: getfield 67	j/b/a/t:a	Ld/u/g;
    //   182: invokevirtual 71	d/u/g:b	()V
    //   185: aload_2
    //   186: getfield 67	j/b/a/t:a	Ld/u/g;
    //   189: aload 5
    //   191: iconst_0
    //   192: aconst_null
    //   193: invokestatic 127	d/u/m/b:a	(Ld/u/g;Ld/w/a/e;ZLandroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   196: astore 6
    //   198: aload 6
    //   200: ldc -127
    //   202: invokestatic 134	d/b/a/r:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   205: istore 7
    //   207: aload 6
    //   209: ldc -120
    //   211: invokestatic 134	d/b/a/r:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   214: istore 8
    //   216: aload 6
    //   218: ldc -118
    //   220: invokestatic 134	d/b/a/r:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   223: istore 9
    //   225: aload 6
    //   227: ldc -116
    //   229: invokestatic 134	d/b/a/r:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   232: istore 10
    //   234: aload 6
    //   236: ldc -114
    //   238: invokestatic 134	d/b/a/r:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   241: istore 11
    //   243: aload 6
    //   245: ldc -112
    //   247: invokestatic 134	d/b/a/r:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   250: istore 12
    //   252: aload 6
    //   254: ldc -110
    //   256: invokestatic 134	d/b/a/r:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   259: istore 13
    //   261: aload 6
    //   263: ldc -108
    //   265: invokestatic 134	d/b/a/r:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   268: istore 14
    //   270: aload 6
    //   272: ldc -106
    //   274: invokestatic 134	d/b/a/r:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   277: istore 15
    //   279: aload 6
    //   281: ldc -104
    //   283: invokestatic 134	d/b/a/r:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   286: istore 16
    //   288: new 154	java/util/ArrayList
    //   291: astore 17
    //   293: aload 17
    //   295: aload 6
    //   297: invokeinterface 159 1 0
    //   302: invokespecial 162	java/util/ArrayList:<init>	(I)V
    //   305: aload 6
    //   307: invokeinterface 165 1 0
    //   312: ifeq +346 -> 658
    //   315: aload 6
    //   317: iload 8
    //   319: invokeinterface 169 2 0
    //   324: lstore 18
    //   326: aload 6
    //   328: iload 9
    //   330: invokeinterface 173 2 0
    //   335: ifeq +8 -> 343
    //   338: aconst_null
    //   339: astore_2
    //   340: goto +19 -> 359
    //   343: aload 6
    //   345: iload 9
    //   347: invokeinterface 177 2 0
    //   352: invokestatic 183	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   355: astore_2
    //   356: goto -16 -> 340
    //   359: aload 6
    //   361: iload 10
    //   363: invokeinterface 173 2 0
    //   368: ifeq +8 -> 376
    //   371: aconst_null
    //   372: astore_3
    //   373: goto +19 -> 392
    //   376: aload 6
    //   378: iload 10
    //   380: invokeinterface 177 2 0
    //   385: invokestatic 183	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   388: astore_3
    //   389: goto -16 -> 373
    //   392: aload 6
    //   394: iload 11
    //   396: invokeinterface 173 2 0
    //   401: ifeq +8 -> 409
    //   404: aconst_null
    //   405: astore_1
    //   406: goto +19 -> 425
    //   409: aload 6
    //   411: iload 11
    //   413: invokeinterface 177 2 0
    //   418: invokestatic 183	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   421: astore_1
    //   422: goto -16 -> 406
    //   425: aload 6
    //   427: iload 12
    //   429: invokeinterface 173 2 0
    //   434: ifeq +9 -> 443
    //   437: aconst_null
    //   438: astore 20
    //   440: goto +20 -> 460
    //   443: aload 6
    //   445: iload 12
    //   447: invokeinterface 177 2 0
    //   452: invokestatic 183	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   455: astore 20
    //   457: goto -17 -> 440
    //   460: aload 6
    //   462: iload 13
    //   464: invokeinterface 173 2 0
    //   469: ifeq +9 -> 478
    //   472: aconst_null
    //   473: astore 21
    //   475: goto +20 -> 495
    //   478: aload 6
    //   480: iload 13
    //   482: invokeinterface 177 2 0
    //   487: invokestatic 183	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   490: astore 21
    //   492: goto -17 -> 475
    //   495: aload 6
    //   497: iload 14
    //   499: invokeinterface 173 2 0
    //   504: ifeq +9 -> 513
    //   507: aconst_null
    //   508: astore 22
    //   510: goto +20 -> 530
    //   513: aload 6
    //   515: iload 14
    //   517: invokeinterface 177 2 0
    //   522: invokestatic 183	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   525: astore 22
    //   527: goto -17 -> 510
    //   530: aload 6
    //   532: iload 15
    //   534: invokeinterface 173 2 0
    //   539: ifeq +9 -> 548
    //   542: aconst_null
    //   543: astore 23
    //   545: goto +20 -> 565
    //   548: aload 6
    //   550: iload 15
    //   552: invokeinterface 177 2 0
    //   557: invokestatic 183	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   560: astore 23
    //   562: goto -17 -> 545
    //   565: aload 6
    //   567: iload 16
    //   569: invokeinterface 187 2 0
    //   574: ifeq +9 -> 583
    //   577: iconst_1
    //   578: istore 24
    //   580: goto +6 -> 586
    //   583: iconst_0
    //   584: istore 24
    //   586: new 189	j/b/a/r
    //   589: astore 25
    //   591: aload 25
    //   593: lload 18
    //   595: aload_2
    //   596: aload_3
    //   597: aload_1
    //   598: aload 20
    //   600: aload 21
    //   602: aload 22
    //   604: aload 23
    //   606: iload 24
    //   608: invokespecial 192	j/b/a/r:<init>	(JLjava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Z)V
    //   611: aload 6
    //   613: iload 7
    //   615: invokeinterface 173 2 0
    //   620: ifeq +8 -> 628
    //   623: aconst_null
    //   624: astore_2
    //   625: goto +16 -> 641
    //   628: aload 6
    //   630: iload 7
    //   632: invokeinterface 187 2 0
    //   637: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   640: astore_2
    //   641: aload 25
    //   643: aload_2
    //   644: putfield 200	j/b/a/r:a	Ljava/lang/Integer;
    //   647: aload 17
    //   649: aload 25
    //   651: invokevirtual 204	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   654: pop
    //   655: goto -350 -> 305
    //   658: aload 6
    //   660: invokeinterface 207 1 0
    //   665: aload 5
    //   667: invokevirtual 208	d/u/i:b	()V
    //   670: new 210	java/lang/StringBuilder
    //   673: dup
    //   674: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   677: astore_2
    //   678: aload_2
    //   679: ldc -43
    //   681: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: pop
    //   685: aload_2
    //   686: aload 17
    //   688: invokevirtual 220	java/util/ArrayList:size	()I
    //   691: invokevirtual 223	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   694: pop
    //   695: aload_2
    //   696: ldc -31
    //   698: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: pop
    //   702: aload_2
    //   703: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   706: astore_2
    //   707: getstatic 234	l/a/a:d	Ll/a/a$b;
    //   710: aload_2
    //   711: iconst_0
    //   712: anewarray 236	java/lang/Object
    //   715: invokevirtual 241	l/a/a$b:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   718: aload 17
    //   720: invokevirtual 244	java/util/ArrayList:isEmpty	()Z
    //   723: ifeq +12 -> 735
    //   726: aload 4
    //   728: invokevirtual 247	j/b/a/n:a	()Lj/b/a/o;
    //   731: astore_2
    //   732: goto +364 -> 1096
    //   735: aload 17
    //   737: invokevirtual 220	java/util/ArrayList:size	()I
    //   740: iconst_1
    //   741: isub
    //   742: istore 7
    //   744: aload 17
    //   746: iconst_0
    //   747: invokevirtual 251	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   750: checkcast 189	j/b/a/r
    //   753: astore_2
    //   754: aload 4
    //   756: aload_2
    //   757: getfield 200	j/b/a/r:a	Ljava/lang/Integer;
    //   760: invokevirtual 254	j/b/a/n:a	(Ljava/lang/Integer;)V
    //   763: iconst_0
    //   764: istore 16
    //   766: iconst_1
    //   767: istore 8
    //   769: iload 8
    //   771: iload 7
    //   773: if_icmpge +246 -> 1019
    //   776: aload_2
    //   777: aload 17
    //   779: iload 8
    //   781: invokevirtual 251	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   784: checkcast 189	j/b/a/r
    //   787: getfield 257	j/b/a/r:d	J
    //   790: putfield 259	j/b/a/r:c	J
    //   793: aload 17
    //   795: iload 8
    //   797: invokevirtual 251	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   800: checkcast 189	j/b/a/r
    //   803: astore_3
    //   804: aload_3
    //   805: getfield 263	j/b/a/r:f	Ljava/lang/Double;
    //   808: ifnull +141 -> 949
    //   811: aload_3
    //   812: getfield 266	j/b/a/r:e	Ljava/lang/Double;
    //   815: ifnull +134 -> 949
    //   818: aload_3
    //   819: getfield 268	j/b/a/r:h	Ljava/lang/Double;
    //   822: ifnull +127 -> 949
    //   825: aload_2
    //   826: getfield 263	j/b/a/r:f	Ljava/lang/Double;
    //   829: ifnull +120 -> 949
    //   832: aload_2
    //   833: getfield 266	j/b/a/r:e	Ljava/lang/Double;
    //   836: ifnull +113 -> 949
    //   839: aload_2
    //   840: getfield 268	j/b/a/r:h	Ljava/lang/Double;
    //   843: ifnonnull +6 -> 849
    //   846: goto +103 -> 949
    //   849: aload_3
    //   850: getfield 270	j/b/a/r:g	Ljava/lang/Double;
    //   853: astore_1
    //   854: aload_1
    //   855: ifnull +89 -> 944
    //   858: aload_1
    //   859: invokevirtual 274	java/lang/Double:doubleValue	()D
    //   862: dstore 26
    //   864: aload_2
    //   865: getfield 270	j/b/a/r:g	Ljava/lang/Double;
    //   868: astore_1
    //   869: aload_1
    //   870: ifnull +69 -> 939
    //   873: dload 26
    //   875: aload_1
    //   876: invokevirtual 274	java/lang/Double:doubleValue	()D
    //   879: invokestatic 280	java/lang/Math:max	(DD)D
    //   882: dstore 26
    //   884: iconst_1
    //   885: newarray <illegal type>
    //   887: astore_1
    //   888: aload_3
    //   889: getfield 266	j/b/a/r:e	Ljava/lang/Double;
    //   892: invokevirtual 274	java/lang/Double:doubleValue	()D
    //   895: aload_3
    //   896: getfield 263	j/b/a/r:f	Ljava/lang/Double;
    //   899: invokevirtual 274	java/lang/Double:doubleValue	()D
    //   902: aload_2
    //   903: getfield 266	j/b/a/r:e	Ljava/lang/Double;
    //   906: invokevirtual 274	java/lang/Double:doubleValue	()D
    //   909: aload_2
    //   910: getfield 263	j/b/a/r:f	Ljava/lang/Double;
    //   913: invokevirtual 274	java/lang/Double:doubleValue	()D
    //   916: aload_1
    //   917: invokestatic 286	android/location/Location:distanceBetween	(DDDD[F)V
    //   920: aload_1
    //   921: iconst_0
    //   922: faload
    //   923: f2d
    //   924: dload 26
    //   926: dcmpl
    //   927: ifle +6 -> 933
    //   930: goto +19 -> 949
    //   933: iconst_1
    //   934: istore 15
    //   936: goto +16 -> 952
    //   939: invokestatic 288	h/k/b/g:a	()V
    //   942: aconst_null
    //   943: athrow
    //   944: invokestatic 288	h/k/b/g:a	()V
    //   947: aconst_null
    //   948: athrow
    //   949: iconst_0
    //   950: istore 15
    //   952: aload_2
    //   953: astore_3
    //   954: iload 16
    //   956: istore 9
    //   958: iload 15
    //   960: ifne +29 -> 989
    //   963: aload 4
    //   965: aload_2
    //   966: invokevirtual 291	j/b/a/r:a	()Lorg/json/JSONObject;
    //   969: invokevirtual 294	j/b/a/n:a	(Lorg/json/JSONObject;)V
    //   972: iload 16
    //   974: iconst_1
    //   975: iadd
    //   976: istore 9
    //   978: aload 17
    //   980: iload 8
    //   982: invokevirtual 251	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   985: checkcast 189	j/b/a/r
    //   988: astore_3
    //   989: aload 4
    //   991: aload 17
    //   993: iload 8
    //   995: invokevirtual 251	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   998: checkcast 189	j/b/a/r
    //   1001: getfield 200	j/b/a/r:a	Ljava/lang/Integer;
    //   1004: invokevirtual 254	j/b/a/n:a	(Ljava/lang/Integer;)V
    //   1007: iinc 8 1
    //   1010: aload_3
    //   1011: astore_2
    //   1012: iload 9
    //   1014: istore 16
    //   1016: goto -247 -> 769
    //   1019: aload 4
    //   1021: aload_2
    //   1022: invokevirtual 291	j/b/a/r:a	()Lorg/json/JSONObject;
    //   1025: invokevirtual 294	j/b/a/n:a	(Lorg/json/JSONObject;)V
    //   1028: aload 4
    //   1030: aload 17
    //   1032: iload 7
    //   1034: invokevirtual 251	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1037: checkcast 189	j/b/a/r
    //   1040: invokevirtual 291	j/b/a/r:a	()Lorg/json/JSONObject;
    //   1043: invokevirtual 294	j/b/a/n:a	(Lorg/json/JSONObject;)V
    //   1046: aload 4
    //   1048: aload 17
    //   1050: iload 7
    //   1052: invokevirtual 251	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1055: checkcast 189	j/b/a/r
    //   1058: getfield 200	j/b/a/r:a	Ljava/lang/Integer;
    //   1061: invokevirtual 254	j/b/a/n:a	(Ljava/lang/Integer;)V
    //   1064: ldc_w 296
    //   1067: iload 16
    //   1069: iconst_1
    //   1070: iadd
    //   1071: iconst_1
    //   1072: iadd
    //   1073: ldc -31
    //   1075: invokestatic 301	e/a/a/a/a:b	(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    //   1078: astore_2
    //   1079: getstatic 234	l/a/a:d	Ll/a/a$b;
    //   1082: aload_2
    //   1083: iconst_0
    //   1084: anewarray 236	java/lang/Object
    //   1087: invokevirtual 241	l/a/a$b:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1090: aload 4
    //   1092: invokevirtual 247	j/b/a/n:a	()Lj/b/a/o;
    //   1095: astore_2
    //   1096: new 114	j/b/a/n
    //   1099: dup
    //   1100: invokespecial 115	j/b/a/n:<init>	()V
    //   1103: astore_1
    //   1104: aload_0
    //   1105: getfield 33	j/b/a/f:a	Lno/simula/corona/MeasurementDatabase;
    //   1108: invokevirtual 108	no/simula/corona/MeasurementDatabase:h	()Lj/b/a/b;
    //   1111: checkcast 110	j/b/a/c
    //   1114: astore_3
    //   1115: aload_3
    //   1116: ifnull +454 -> 1570
    //   1119: ldc_w 303
    //   1122: iconst_0
    //   1123: invokestatic 122	d/u/i:a	(Ljava/lang/String;I)Ld/u/i;
    //   1126: astore 20
    //   1128: aload_3
    //   1129: getfield 111	j/b/a/c:a	Ld/u/g;
    //   1132: invokevirtual 71	d/u/g:b	()V
    //   1135: aload_3
    //   1136: getfield 111	j/b/a/c:a	Ld/u/g;
    //   1139: aload 20
    //   1141: iconst_0
    //   1142: aconst_null
    //   1143: invokestatic 127	d/u/m/b:a	(Ld/u/g;Ld/w/a/e;ZLandroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   1146: astore 21
    //   1148: aload 21
    //   1150: ldc -127
    //   1152: invokestatic 134	d/b/a/r:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   1155: istore 10
    //   1157: aload 21
    //   1159: ldc -120
    //   1161: invokestatic 134	d/b/a/r:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   1164: istore 14
    //   1166: aload 21
    //   1168: ldc_w 305
    //   1171: invokestatic 134	d/b/a/r:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   1174: istore 9
    //   1176: aload 21
    //   1178: ldc_w 307
    //   1181: invokestatic 134	d/b/a/r:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   1184: istore 8
    //   1186: aload 21
    //   1188: ldc_w 309
    //   1191: invokestatic 134	d/b/a/r:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   1194: istore 7
    //   1196: aload 21
    //   1198: ldc -104
    //   1200: invokestatic 134	d/b/a/r:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   1203: istore 15
    //   1205: new 154	java/util/ArrayList
    //   1208: astore 22
    //   1210: aload 22
    //   1212: aload 21
    //   1214: invokeinterface 159 1 0
    //   1219: invokespecial 162	java/util/ArrayList:<init>	(I)V
    //   1222: aload 21
    //   1224: invokeinterface 165 1 0
    //   1229: ifeq +136 -> 1365
    //   1232: aload 21
    //   1234: iload 14
    //   1236: invokeinterface 169 2 0
    //   1241: lstore 18
    //   1243: aload 21
    //   1245: iload 9
    //   1247: invokeinterface 313 2 0
    //   1252: astore_3
    //   1253: aload 21
    //   1255: iload 8
    //   1257: invokeinterface 187 2 0
    //   1262: istore 16
    //   1264: aload 21
    //   1266: iload 7
    //   1268: invokeinterface 187 2 0
    //   1273: istore 13
    //   1275: aload 21
    //   1277: iload 15
    //   1279: invokeinterface 187 2 0
    //   1284: ifeq +9 -> 1293
    //   1287: iconst_1
    //   1288: istore 24
    //   1290: goto +6 -> 1296
    //   1293: iconst_0
    //   1294: istore 24
    //   1296: new 315	j/b/a/a
    //   1299: astore 23
    //   1301: aload 23
    //   1303: lload 18
    //   1305: aload_3
    //   1306: iload 16
    //   1308: iload 13
    //   1310: iload 24
    //   1312: invokespecial 318	j/b/a/a:<init>	(JLjava/lang/String;IIZ)V
    //   1315: aload 21
    //   1317: iload 10
    //   1319: invokeinterface 173 2 0
    //   1324: ifeq +8 -> 1332
    //   1327: aconst_null
    //   1328: astore_3
    //   1329: goto +19 -> 1348
    //   1332: aload 21
    //   1334: iload 10
    //   1336: invokeinterface 187 2 0
    //   1341: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1344: astore_3
    //   1345: goto -16 -> 1329
    //   1348: aload 23
    //   1350: aload_3
    //   1351: putfield 319	j/b/a/a:a	Ljava/lang/Integer;
    //   1354: aload 22
    //   1356: aload 23
    //   1358: invokevirtual 204	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1361: pop
    //   1362: goto -140 -> 1222
    //   1365: aload 21
    //   1367: invokeinterface 207 1 0
    //   1372: aload 20
    //   1374: invokevirtual 208	d/u/i:b	()V
    //   1377: aload 22
    //   1379: invokevirtual 244	java/util/ArrayList:isEmpty	()Z
    //   1382: ifeq +11 -> 1393
    //   1385: aload_1
    //   1386: invokevirtual 247	j/b/a/n:a	()Lj/b/a/o;
    //   1389: astore_3
    //   1390: goto +155 -> 1545
    //   1393: aload 22
    //   1395: invokevirtual 323	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1398: astore 20
    //   1400: aload 20
    //   1402: invokeinterface 328 1 0
    //   1407: ifeq +133 -> 1540
    //   1410: aload 20
    //   1412: invokeinterface 332 1 0
    //   1417: checkcast 315	j/b/a/a
    //   1420: astore 21
    //   1422: aload 21
    //   1424: ifnull +114 -> 1538
    //   1427: new 334	java/text/SimpleDateFormat
    //   1430: dup
    //   1431: ldc_w 336
    //   1434: invokespecial 338	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   1437: astore 22
    //   1439: aload 22
    //   1441: ldc_w 340
    //   1444: invokestatic 346	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   1447: invokevirtual 350	java/text/SimpleDateFormat:setTimeZone	(Ljava/util/TimeZone;)V
    //   1450: new 352	org/json/JSONObject
    //   1453: dup
    //   1454: invokespecial 353	org/json/JSONObject:<init>	()V
    //   1457: astore_3
    //   1458: aload_3
    //   1459: ldc_w 355
    //   1462: aload 22
    //   1464: aload 21
    //   1466: getfield 357	j/b/a/a:b	J
    //   1469: invokestatic 362	j/b/a/a0:a	(J)J
    //   1472: invokestatic 367	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1475: invokevirtual 371	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   1478: invokevirtual 375	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1481: pop
    //   1482: aload_3
    //   1483: ldc_w 305
    //   1486: aload 21
    //   1488: getfield 378	j/b/a/a:c	Ljava/lang/String;
    //   1491: invokevirtual 375	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1494: pop
    //   1495: aload_3
    //   1496: ldc_w 307
    //   1499: aload 21
    //   1501: getfield 381	j/b/a/a:d	I
    //   1504: invokevirtual 384	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1507: pop
    //   1508: aload_3
    //   1509: ldc_w 309
    //   1512: aload 21
    //   1514: getfield 386	j/b/a/a:e	I
    //   1517: invokevirtual 384	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1520: pop
    //   1521: aload_1
    //   1522: aload_3
    //   1523: invokevirtual 294	j/b/a/n:a	(Lorg/json/JSONObject;)V
    //   1526: aload_1
    //   1527: aload 21
    //   1529: getfield 319	j/b/a/a:a	Ljava/lang/Integer;
    //   1532: invokevirtual 254	j/b/a/n:a	(Ljava/lang/Integer;)V
    //   1535: goto -135 -> 1400
    //   1538: aconst_null
    //   1539: athrow
    //   1540: aload_1
    //   1541: invokevirtual 247	j/b/a/n:a	()Lj/b/a/o;
    //   1544: astore_3
    //   1545: new 388	j/b/a/p
    //   1548: dup
    //   1549: aload_2
    //   1550: aload_3
    //   1551: invokespecial 391	j/b/a/p:<init>	(Lj/b/a/o;Lj/b/a/o;)V
    //   1554: areturn
    //   1555: astore_2
    //   1556: aload 21
    //   1558: invokeinterface 207 1 0
    //   1563: aload 20
    //   1565: invokevirtual 208	d/u/i:b	()V
    //   1568: aload_2
    //   1569: athrow
    //   1570: aconst_null
    //   1571: athrow
    //   1572: astore_2
    //   1573: aload 6
    //   1575: invokeinterface 207 1 0
    //   1580: aload 5
    //   1582: invokevirtual 208	d/u/i:b	()V
    //   1585: aload_2
    //   1586: athrow
    //   1587: aconst_null
    //   1588: athrow
    //   1589: astore_3
    //   1590: aload_1
    //   1591: getfield 111	j/b/a/c:a	Ld/u/g;
    //   1594: invokevirtual 92	d/u/g:d	()V
    //   1597: aload_1
    //   1598: getfield 112	j/b/a/c:c	Ld/u/k;
    //   1601: aload_2
    //   1602: invokevirtual 394	d/u/k:a	(Ld/w/a/f/f;)V
    //   1605: aload_3
    //   1606: athrow
    //   1607: astore_3
    //   1608: aload_1
    //   1609: getfield 67	j/b/a/t:a	Ld/u/g;
    //   1612: invokevirtual 92	d/u/g:d	()V
    //   1615: aload_1
    //   1616: getfield 74	j/b/a/t:c	Ld/u/k;
    //   1619: aload_2
    //   1620: invokevirtual 394	d/u/k:a	(Ld/w/a/f/f;)V
    //   1623: aload_3
    //   1624: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1625	0	this	f
    //   10	1606	1	localObject1	Object
    //   25	1525	2	localObject2	Object
    //   1555	14	2	localObject3	Object
    //   1572	48	2	localf	d.w.a.f.f
    //   56	1495	3	localObject4	Object
    //   1589	17	3	localObject5	Object
    //   1607	17	3	localObject6	Object
    //   153	938	4	localn	n
    //   176	1405	5	locali	d.u.i
    //   196	1378	6	localCursor	android.database.Cursor
    //   205	1062	7	i	int
    //   214	1042	8	j	int
    //   223	1023	9	k	int
    //   232	1103	10	m	int
    //   241	171	11	n	int
    //   250	196	12	i1	int
    //   259	1050	13	i2	int
    //   268	967	14	i3	int
    //   277	1001	15	i4	int
    //   286	1021	16	i5	int
    //   291	758	17	localArrayList	java.util.ArrayList
    //   324	980	18	l	long
    //   438	1126	20	localObject7	Object
    //   473	1084	21	localObject8	Object
    //   508	955	22	localObject9	Object
    //   543	814	23	localObject10	Object
    //   578	733	24	bool	boolean
    //   589	61	25	localr	r
    //   862	63	26	d	double
    // Exception table:
    //   from	to	target	type
    //   1148	1222	1555	finally
    //   1222	1287	1555	finally
    //   1296	1327	1555	finally
    //   1332	1345	1555	finally
    //   1348	1362	1555	finally
    //   198	305	1572	finally
    //   305	338	1572	finally
    //   343	356	1572	finally
    //   359	371	1572	finally
    //   376	389	1572	finally
    //   392	404	1572	finally
    //   409	422	1572	finally
    //   425	437	1572	finally
    //   443	457	1572	finally
    //   460	472	1572	finally
    //   478	492	1572	finally
    //   495	507	1572	finally
    //   513	527	1572	finally
    //   530	542	1572	finally
    //   548	562	1572	finally
    //   565	577	1572	finally
    //   586	623	1572	finally
    //   628	641	1572	finally
    //   641	655	1572	finally
    //   106	118	1589	finally
    //   33	45	1607	finally
  }
  
  public Object doInBackground(Object[] paramArrayOfObject)
  {
    Object localObject = null;
    if (paramArrayOfObject != null)
    {
      try
      {
        paramArrayOfObject = b();
      }
      catch (Exception paramArrayOfObject)
      {
        LinkedHashMap localLinkedHashMap = new LinkedHashMap();
        localLinkedHashMap.put("where", "DataAggregator::doInBackground");
        Crashes.trackError(paramArrayOfObject, localLinkedHashMap, null);
        paramArrayOfObject = (Object[])localObject;
      }
      return paramArrayOfObject;
    }
    g.a("params");
    throw null;
  }
  
  public void onPostExecute(Object paramObject)
  {
    paramObject = (p)paramObject;
    super.onPostExecute(paramObject);
    try
    {
      c.a((p)paramObject);
    }
    catch (Exception paramObject)
    {
      LinkedHashMap localLinkedHashMap = new LinkedHashMap();
      localLinkedHashMap.put("where", "DataAggregator::postExecute");
      Crashes.trackError((Throwable)paramObject, localLinkedHashMap, null);
    }
  }
}

/* Location:
 * Qualified Name:     base.j.b.a.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */