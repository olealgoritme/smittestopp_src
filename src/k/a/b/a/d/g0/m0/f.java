package k.a.b.a.d.g0.m0;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import k.a.b.a.d.a0;
import k.a.b.a.d.d0;

public class f
{
  public static final Logger b = Logger.getLogger(f.class.getName());
  public static final Constructor<?> c;
  public static final Method d;
  public static final Constructor<?> e;
  public static final Class<?> f;
  public static final Method g;
  public static final Method h;
  public static final Class<?> i;
  public static final Method j;
  public static final Constructor<?> k;
  public static final Method l;
  public static final Class<?> m;
  public static final Exception n;
  public static final List<String> o = Arrays.asList(tmp1011_1006);
  public SSLContext a;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 2
    //   2: invokevirtual 43	java/lang/Class:getName	()Ljava/lang/String;
    //   5: invokestatic 49	java/util/logging/Logger:getLogger	(Ljava/lang/String;)Ljava/util/logging/Logger;
    //   8: putstatic 51	k/a/b/a/d/g0/m0/f:b	Ljava/util/logging/Logger;
    //   11: aconst_null
    //   12: astore_0
    //   13: ldc 53
    //   15: invokestatic 57	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   18: astore_1
    //   19: aload_1
    //   20: iconst_1
    //   21: anewarray 39	java/lang/Class
    //   24: dup
    //   25: iconst_0
    //   26: ldc 59
    //   28: aastore
    //   29: invokevirtual 63	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   32: astore_2
    //   33: aload_1
    //   34: ldc 65
    //   36: iconst_0
    //   37: anewarray 39	java/lang/Class
    //   40: invokevirtual 69	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   43: astore_1
    //   44: ldc 71
    //   46: invokestatic 57	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   49: astore_3
    //   50: aload_3
    //   51: iconst_0
    //   52: anewarray 39	java/lang/Class
    //   55: invokevirtual 63	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   58: astore 4
    //   60: ldc 73
    //   62: invokestatic 57	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   65: astore 5
    //   67: aload_3
    //   68: ldc 75
    //   70: iconst_1
    //   71: anewarray 39	java/lang/Class
    //   74: dup
    //   75: iconst_0
    //   76: aload 5
    //   78: aastore
    //   79: invokevirtual 69	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   82: astore 6
    //   84: ldc 77
    //   86: invokestatic 57	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   89: astore 7
    //   91: ldc 79
    //   93: invokestatic 57	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   96: astore 8
    //   98: aload 8
    //   100: ldc 81
    //   102: iconst_1
    //   103: anewarray 39	java/lang/Class
    //   106: dup
    //   107: iconst_0
    //   108: aload 7
    //   110: aastore
    //   111: invokevirtual 69	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   114: astore 9
    //   116: ldc 83
    //   118: invokestatic 57	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   121: astore 7
    //   123: aload 7
    //   125: iconst_0
    //   126: anewarray 39	java/lang/Class
    //   129: invokevirtual 63	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   132: astore 10
    //   134: aload 7
    //   136: ldc 85
    //   138: iconst_1
    //   139: anewarray 39	java/lang/Class
    //   142: dup
    //   143: iconst_0
    //   144: ldc 87
    //   146: aastore
    //   147: invokevirtual 69	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   150: astore 11
    //   152: ldc 89
    //   154: invokestatic 57	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   157: astore 12
    //   159: aload_3
    //   160: ldc 91
    //   162: iconst_1
    //   163: anewarray 39	java/lang/Class
    //   166: dup
    //   167: iconst_0
    //   168: aload 12
    //   170: aastore
    //   171: invokevirtual 69	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   174: astore 7
    //   176: invokestatic 93	k/a/b/a/d/g0/m0/f:a	()V
    //   179: aload_2
    //   180: putstatic 95	k/a/b/a/d/g0/m0/f:c	Ljava/lang/reflect/Constructor;
    //   183: aload_1
    //   184: putstatic 97	k/a/b/a/d/g0/m0/f:d	Ljava/lang/reflect/Method;
    //   187: aload 4
    //   189: putstatic 99	k/a/b/a/d/g0/m0/f:e	Ljava/lang/reflect/Constructor;
    //   192: aload 5
    //   194: putstatic 101	k/a/b/a/d/g0/m0/f:f	Ljava/lang/Class;
    //   197: aload 6
    //   199: putstatic 103	k/a/b/a/d/g0/m0/f:g	Ljava/lang/reflect/Method;
    //   202: aload 7
    //   204: putstatic 105	k/a/b/a/d/g0/m0/f:h	Ljava/lang/reflect/Method;
    //   207: aload 8
    //   209: putstatic 107	k/a/b/a/d/g0/m0/f:i	Ljava/lang/Class;
    //   212: aload 9
    //   214: putstatic 109	k/a/b/a/d/g0/m0/f:j	Ljava/lang/reflect/Method;
    //   217: aload 10
    //   219: putstatic 111	k/a/b/a/d/g0/m0/f:k	Ljava/lang/reflect/Constructor;
    //   222: aload 11
    //   224: putstatic 113	k/a/b/a/d/g0/m0/f:l	Ljava/lang/reflect/Method;
    //   227: aload 12
    //   229: putstatic 115	k/a/b/a/d/g0/m0/f:m	Ljava/lang/Class;
    //   232: aconst_null
    //   233: putstatic 117	k/a/b/a/d/g0/m0/f:n	Ljava/lang/Exception;
    //   236: goto +756 -> 992
    //   239: astore_3
    //   240: aload_1
    //   241: astore 13
    //   243: aload 4
    //   245: astore 14
    //   247: aload 11
    //   249: astore_1
    //   250: aload 12
    //   252: astore 4
    //   254: goto +560 -> 814
    //   257: astore_3
    //   258: aload_1
    //   259: astore 13
    //   261: aload 4
    //   263: astore 14
    //   265: aload 5
    //   267: astore 15
    //   269: aload 11
    //   271: astore 4
    //   273: aload 10
    //   275: astore 5
    //   277: aload 12
    //   279: astore_1
    //   280: goto +436 -> 716
    //   283: astore_3
    //   284: aconst_null
    //   285: astore 7
    //   287: aload_1
    //   288: astore 13
    //   290: aload 4
    //   292: astore 14
    //   294: aload 11
    //   296: astore_1
    //   297: aload 12
    //   299: astore 4
    //   301: goto +513 -> 814
    //   304: astore_3
    //   305: aconst_null
    //   306: astore 7
    //   308: aload_1
    //   309: astore 13
    //   311: aload 4
    //   313: astore 14
    //   315: aload 5
    //   317: astore 15
    //   319: aload 11
    //   321: astore 4
    //   323: aload 10
    //   325: astore 5
    //   327: aload 12
    //   329: astore_1
    //   330: goto +386 -> 716
    //   333: astore_3
    //   334: aconst_null
    //   335: astore 7
    //   337: aload 7
    //   339: astore 15
    //   341: aload_1
    //   342: astore 13
    //   344: aload 4
    //   346: astore 14
    //   348: aload 11
    //   350: astore_1
    //   351: aload 15
    //   353: astore 4
    //   355: goto +459 -> 814
    //   358: astore_3
    //   359: aconst_null
    //   360: astore 7
    //   362: aload 7
    //   364: astore 12
    //   366: aload_1
    //   367: astore 13
    //   369: aload 4
    //   371: astore 14
    //   373: aload 5
    //   375: astore 15
    //   377: aload 11
    //   379: astore 4
    //   381: aload 10
    //   383: astore 5
    //   385: aload 12
    //   387: astore_1
    //   388: goto +328 -> 716
    //   391: astore_3
    //   392: aconst_null
    //   393: astore 7
    //   395: aload 7
    //   397: astore 15
    //   399: aload 15
    //   401: astore 11
    //   403: aload_1
    //   404: astore 13
    //   406: aload 4
    //   408: astore 14
    //   410: aload 15
    //   412: astore_1
    //   413: aload 11
    //   415: astore 4
    //   417: goto +397 -> 814
    //   420: astore_3
    //   421: aconst_null
    //   422: astore 7
    //   424: aload 7
    //   426: astore 11
    //   428: aload 11
    //   430: astore 12
    //   432: aload_1
    //   433: astore 13
    //   435: aload 4
    //   437: astore 14
    //   439: aload 5
    //   441: astore 15
    //   443: aload 11
    //   445: astore 4
    //   447: aload 10
    //   449: astore 5
    //   451: aload 12
    //   453: astore_1
    //   454: goto +262 -> 716
    //   457: astore_3
    //   458: aconst_null
    //   459: astore 14
    //   461: aload_1
    //   462: astore 7
    //   464: aload 4
    //   466: astore 15
    //   468: aload 14
    //   470: astore_1
    //   471: goto +317 -> 788
    //   474: astore_3
    //   475: aconst_null
    //   476: astore 13
    //   478: aload_1
    //   479: astore 7
    //   481: aload 4
    //   483: astore 14
    //   485: aload 5
    //   487: astore 15
    //   489: aload 13
    //   491: astore 4
    //   493: goto +205 -> 698
    //   496: astore_3
    //   497: aconst_null
    //   498: astore 9
    //   500: aload 9
    //   502: astore 14
    //   504: aload_1
    //   505: astore 7
    //   507: aload 4
    //   509: astore 15
    //   511: aload 14
    //   513: astore_1
    //   514: goto +274 -> 788
    //   517: astore_3
    //   518: aconst_null
    //   519: astore 9
    //   521: aload 9
    //   523: astore 13
    //   525: aload_1
    //   526: astore 7
    //   528: aload 4
    //   530: astore 14
    //   532: aload 5
    //   534: astore 15
    //   536: aload 13
    //   538: astore 4
    //   540: goto +158 -> 698
    //   543: astore_3
    //   544: aconst_null
    //   545: astore 9
    //   547: aload_1
    //   548: astore 7
    //   550: goto +227 -> 777
    //   553: astore_3
    //   554: aconst_null
    //   555: astore 9
    //   557: aload 4
    //   559: astore 14
    //   561: goto +122 -> 683
    //   564: astore_3
    //   565: aconst_null
    //   566: astore 6
    //   568: aload_1
    //   569: astore 7
    //   571: aload 6
    //   573: astore_1
    //   574: goto +197 -> 771
    //   577: astore_3
    //   578: aconst_null
    //   579: astore 6
    //   581: aload_1
    //   582: astore 7
    //   584: aload 6
    //   586: astore_1
    //   587: goto +83 -> 670
    //   590: astore_3
    //   591: aconst_null
    //   592: astore 5
    //   594: aload_1
    //   595: astore 7
    //   597: aload 4
    //   599: astore 6
    //   601: aload 5
    //   603: astore 4
    //   605: goto +155 -> 760
    //   608: astore_3
    //   609: aconst_null
    //   610: astore 5
    //   612: aload_1
    //   613: astore 7
    //   615: aload 4
    //   617: astore 6
    //   619: aload 5
    //   621: astore 4
    //   623: goto +36 -> 659
    //   626: astore_3
    //   627: aconst_null
    //   628: astore 4
    //   630: aload_1
    //   631: astore 7
    //   633: aload 4
    //   635: astore_1
    //   636: goto +118 -> 754
    //   639: astore_3
    //   640: goto +10 -> 650
    //   643: astore_3
    //   644: goto +105 -> 749
    //   647: astore_3
    //   648: aconst_null
    //   649: astore_1
    //   650: aconst_null
    //   651: astore 6
    //   653: aconst_null
    //   654: astore 4
    //   656: aload_1
    //   657: astore 7
    //   659: aload 4
    //   661: astore_1
    //   662: aload 4
    //   664: astore 5
    //   666: aload 6
    //   668: astore 4
    //   670: aload_1
    //   671: astore 9
    //   673: aload_1
    //   674: astore 6
    //   676: aload 4
    //   678: astore 14
    //   680: aload 7
    //   682: astore_1
    //   683: aload 9
    //   685: astore 8
    //   687: aload 8
    //   689: astore 4
    //   691: aload 5
    //   693: astore 15
    //   695: aload_1
    //   696: astore 7
    //   698: aconst_null
    //   699: astore 11
    //   701: aload 4
    //   703: astore 5
    //   705: aload 5
    //   707: astore_1
    //   708: aload 7
    //   710: astore 13
    //   712: aload 11
    //   714: astore 7
    //   716: aload 7
    //   718: astore 11
    //   720: aload 15
    //   722: astore 10
    //   724: aload 6
    //   726: astore 15
    //   728: aload 9
    //   730: astore 6
    //   732: aload 4
    //   734: astore 7
    //   736: aload 5
    //   738: astore 16
    //   740: aload_1
    //   741: astore 12
    //   743: goto +191 -> 934
    //   746: astore_3
    //   747: aconst_null
    //   748: astore_2
    //   749: aconst_null
    //   750: astore 7
    //   752: aconst_null
    //   753: astore_1
    //   754: aload_1
    //   755: astore 4
    //   757: aload_1
    //   758: astore 6
    //   760: aload 4
    //   762: astore_1
    //   763: aload 4
    //   765: astore 5
    //   767: aload 6
    //   769: astore 4
    //   771: aload_1
    //   772: astore 9
    //   774: aload_1
    //   775: astore 6
    //   777: aload 9
    //   779: astore 8
    //   781: aload 8
    //   783: astore_1
    //   784: aload 4
    //   786: astore 15
    //   788: aconst_null
    //   789: astore 11
    //   791: aload_1
    //   792: astore 14
    //   794: aload 14
    //   796: astore 4
    //   798: aload 14
    //   800: astore 10
    //   802: aload 15
    //   804: astore 14
    //   806: aload 7
    //   808: astore 13
    //   810: aload 11
    //   812: astore 7
    //   814: aload_2
    //   815: putstatic 95	k/a/b/a/d/g0/m0/f:c	Ljava/lang/reflect/Constructor;
    //   818: aload 13
    //   820: putstatic 97	k/a/b/a/d/g0/m0/f:d	Ljava/lang/reflect/Method;
    //   823: aload 14
    //   825: putstatic 99	k/a/b/a/d/g0/m0/f:e	Ljava/lang/reflect/Constructor;
    //   828: aload 5
    //   830: putstatic 101	k/a/b/a/d/g0/m0/f:f	Ljava/lang/Class;
    //   833: aload 6
    //   835: putstatic 103	k/a/b/a/d/g0/m0/f:g	Ljava/lang/reflect/Method;
    //   838: aload 7
    //   840: putstatic 105	k/a/b/a/d/g0/m0/f:h	Ljava/lang/reflect/Method;
    //   843: aload 8
    //   845: putstatic 107	k/a/b/a/d/g0/m0/f:i	Ljava/lang/Class;
    //   848: aload 9
    //   850: putstatic 109	k/a/b/a/d/g0/m0/f:j	Ljava/lang/reflect/Method;
    //   853: aload 10
    //   855: putstatic 111	k/a/b/a/d/g0/m0/f:k	Ljava/lang/reflect/Constructor;
    //   858: aload_1
    //   859: putstatic 113	k/a/b/a/d/g0/m0/f:l	Ljava/lang/reflect/Method;
    //   862: aload 4
    //   864: putstatic 115	k/a/b/a/d/g0/m0/f:m	Ljava/lang/Class;
    //   867: aconst_null
    //   868: putstatic 117	k/a/b/a/d/g0/m0/f:n	Ljava/lang/Exception;
    //   871: aload_3
    //   872: athrow
    //   873: astore 9
    //   875: aconst_null
    //   876: astore 11
    //   878: aload 11
    //   880: astore_1
    //   881: aload_1
    //   882: astore 4
    //   884: aload 4
    //   886: astore_2
    //   887: aload_2
    //   888: astore 5
    //   890: aload 5
    //   892: astore 6
    //   894: aload 6
    //   896: astore_3
    //   897: aload_3
    //   898: astore 7
    //   900: aload 7
    //   902: astore 8
    //   904: aload 8
    //   906: astore 12
    //   908: aload 8
    //   910: astore 16
    //   912: aload_3
    //   913: astore 8
    //   915: aload 5
    //   917: astore 15
    //   919: aload_2
    //   920: astore 10
    //   922: aload 4
    //   924: astore 14
    //   926: aload_1
    //   927: astore 13
    //   929: aload_0
    //   930: astore_2
    //   931: aload 9
    //   933: astore_3
    //   934: aload_2
    //   935: putstatic 95	k/a/b/a/d/g0/m0/f:c	Ljava/lang/reflect/Constructor;
    //   938: aload 13
    //   940: putstatic 97	k/a/b/a/d/g0/m0/f:d	Ljava/lang/reflect/Method;
    //   943: aload 14
    //   945: putstatic 99	k/a/b/a/d/g0/m0/f:e	Ljava/lang/reflect/Constructor;
    //   948: aload 10
    //   950: putstatic 101	k/a/b/a/d/g0/m0/f:f	Ljava/lang/Class;
    //   953: aload 15
    //   955: putstatic 103	k/a/b/a/d/g0/m0/f:g	Ljava/lang/reflect/Method;
    //   958: aload 11
    //   960: putstatic 105	k/a/b/a/d/g0/m0/f:h	Ljava/lang/reflect/Method;
    //   963: aload 8
    //   965: putstatic 107	k/a/b/a/d/g0/m0/f:i	Ljava/lang/Class;
    //   968: aload 6
    //   970: putstatic 109	k/a/b/a/d/g0/m0/f:j	Ljava/lang/reflect/Method;
    //   973: aload 16
    //   975: putstatic 111	k/a/b/a/d/g0/m0/f:k	Ljava/lang/reflect/Constructor;
    //   978: aload 7
    //   980: putstatic 113	k/a/b/a/d/g0/m0/f:l	Ljava/lang/reflect/Method;
    //   983: aload 12
    //   985: putstatic 115	k/a/b/a/d/g0/m0/f:m	Ljava/lang/Class;
    //   988: aload_3
    //   989: putstatic 117	k/a/b/a/d/g0/m0/f:n	Ljava/lang/Exception;
    //   992: iconst_4
    //   993: anewarray 119	java/lang/String
    //   996: dup
    //   997: iconst_0
    //   998: ldc 121
    //   1000: aastore
    //   1001: dup
    //   1002: iconst_1
    //   1003: ldc 123
    //   1005: aastore
    //   1006: dup
    //   1007: iconst_2
    //   1008: ldc 125
    //   1010: aastore
    //   1011: dup
    //   1012: iconst_3
    //   1013: ldc 127
    //   1015: aastore
    //   1016: invokestatic 133	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   1019: putstatic 135	k/a/b/a/d/g0/m0/f:o	Ljava/util/List;
    //   1022: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	918	0	localObject1	Object
    //   18	909	1	localObject2	Object
    //   32	903	2	localObject3	Object
    //   49	111	3	localClass	Class
    //   239	1	3	localObject4	Object
    //   257	1	3	localException1	Exception
    //   283	1	3	localObject5	Object
    //   304	1	3	localException2	Exception
    //   333	1	3	localObject6	Object
    //   358	1	3	localException3	Exception
    //   391	1	3	localObject7	Object
    //   420	1	3	localException4	Exception
    //   457	1	3	localObject8	Object
    //   474	1	3	localException5	Exception
    //   496	1	3	localObject9	Object
    //   517	1	3	localException6	Exception
    //   543	1	3	localObject10	Object
    //   553	1	3	localException7	Exception
    //   564	1	3	localObject11	Object
    //   577	1	3	localException8	Exception
    //   590	1	3	localObject12	Object
    //   608	1	3	localException9	Exception
    //   626	1	3	localObject13	Object
    //   639	1	3	localException10	Exception
    //   643	1	3	localObject14	Object
    //   647	1	3	localException11	Exception
    //   746	126	3	localObject15	Object
    //   896	93	3	localObject16	Object
    //   58	865	4	localObject17	Object
    //   65	851	5	localObject18	Object
    //   82	887	6	localObject19	Object
    //   89	890	7	localObject20	Object
    //   96	868	8	localObject21	Object
    //   114	735	9	localObject22	Object
    //   873	59	9	localException12	Exception
    //   132	817	10	localObject23	Object
    //   150	809	11	localObject24	Object
    //   157	827	12	localObject25	Object
    //   241	698	13	localObject26	Object
    //   245	699	14	localObject27	Object
    //   267	687	15	localObject28	Object
    //   738	236	16	localObject29	Object
    // Exception table:
    //   from	to	target	type
    //   176	179	239	finally
    //   176	179	257	java/lang/Exception
    //   159	176	283	finally
    //   159	176	304	java/lang/Exception
    //   152	159	333	finally
    //   152	159	358	java/lang/Exception
    //   134	152	391	finally
    //   134	152	420	java/lang/Exception
    //   116	134	457	finally
    //   116	134	474	java/lang/Exception
    //   98	116	496	finally
    //   98	116	517	java/lang/Exception
    //   84	98	543	finally
    //   84	98	553	java/lang/Exception
    //   67	84	564	finally
    //   67	84	577	java/lang/Exception
    //   60	67	590	finally
    //   60	67	608	java/lang/Exception
    //   44	60	626	finally
    //   44	60	639	java/lang/Exception
    //   33	44	643	finally
    //   33	44	647	java/lang/Exception
    //   13	33	746	finally
    //   13	33	873	java/lang/Exception
  }
  
  public static void a()
  {
    Provider localProvider = (Provider)Class.forName("k.b.e.a.a").getConstructor(new Class[0]).newInstance(new Object[0]);
    try
    {
      if (Security.getProvider(localProvider.getName()) == null) {
        Security.addProvider(localProvider);
      }
      return;
    }
    finally {}
  }
  
  public final KeyStore a(a0 parama0, char[] paramArrayOfChar)
  {
    try
    {
      paramArrayOfChar = KeyStore.getInstance(KeyStore.getDefaultType());
      paramArrayOfChar.load(null, null);
      if ((e)parama0 != null) {
        return paramArrayOfChar;
      }
      throw null;
    }
    catch (IOException parama0)
    {
      throw new d0("Unexpected exception creating keystore", parama0);
    }
    catch (CertificateException parama0)
    {
      throw new d0("Unexpected exception creating keystore", parama0);
    }
    catch (NoSuchAlgorithmException parama0)
    {
      throw new d0("Unexpected exception creating keystore", parama0);
    }
    catch (KeyStoreException parama0)
    {
      throw new d0("Unexpected exception creating keystore", parama0);
    }
  }
}

/* Location:
 * Qualified Name:     base.k.a.b.a.d.g0.m0.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */