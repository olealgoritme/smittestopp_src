package no.nordicsemi.android.support.v18.scanner;

import android.content.BroadcastReceiver;

public class PendingIntentReceiver
  extends BroadcastReceiver
{
  /* Error */
  public void onReceive(android.content.Context paramContext, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +807 -> 808
    //   4: aload_2
    //   5: ifnonnull +6 -> 11
    //   8: goto +800 -> 808
    //   11: aload_2
    //   12: ldc 15
    //   14: invokevirtual 21	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   17: checkcast 23	android/app/PendingIntent
    //   20: astore_3
    //   21: aload_3
    //   22: ifnonnull +4 -> 26
    //   25: return
    //   26: aload_2
    //   27: ldc 25
    //   29: invokevirtual 29	android/content/Intent:getParcelableArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   32: astore 4
    //   34: aload_2
    //   35: ldc 31
    //   37: invokevirtual 21	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   40: checkcast 33	android/bluetooth/le/ScanSettings
    //   43: astore 5
    //   45: aload 4
    //   47: ifnull +761 -> 808
    //   50: aload 5
    //   52: ifnonnull +6 -> 58
    //   55: goto +753 -> 808
    //   58: aload_2
    //   59: ldc 35
    //   61: iconst_1
    //   62: invokevirtual 39	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   65: istore 6
    //   67: aload_2
    //   68: ldc 41
    //   70: iconst_1
    //   71: invokevirtual 39	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   74: istore 7
    //   76: aload_2
    //   77: ldc 43
    //   79: iconst_1
    //   80: invokevirtual 39	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   83: istore 8
    //   85: aload_2
    //   86: ldc 45
    //   88: ldc2_w 46
    //   91: invokevirtual 51	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   94: lstore 9
    //   96: aload_2
    //   97: ldc 53
    //   99: ldc2_w 46
    //   102: invokevirtual 51	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   105: lstore 11
    //   107: aload_2
    //   108: ldc 55
    //   110: iconst_1
    //   111: invokevirtual 59	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   114: istore 13
    //   116: aload_2
    //   117: ldc 61
    //   119: iconst_3
    //   120: invokevirtual 59	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   123: istore 14
    //   125: invokestatic 67	k/a/a/a/a/a/a:a	()Lk/a/a/a/a/a/a;
    //   128: astore 15
    //   130: aload 15
    //   132: checkcast 69	k/a/a/a/a/a/d
    //   135: astore 16
    //   137: aload 16
    //   139: ifnull +667 -> 806
    //   142: new 71	java/util/ArrayList
    //   145: dup
    //   146: invokespecial 72	java/util/ArrayList:<init>	()V
    //   149: astore 17
    //   151: aload 4
    //   153: invokeinterface 78 1 0
    //   158: astore 4
    //   160: aload 4
    //   162: invokeinterface 84 1 0
    //   167: ifeq +160 -> 327
    //   170: aload 4
    //   172: invokeinterface 88 1 0
    //   177: checkcast 90	android/bluetooth/le/ScanFilter
    //   180: astore 18
    //   182: new 92	k/a/a/a/a/a/h$b
    //   185: dup
    //   186: invokespecial 93	k/a/a/a/a/a/h$b:<init>	()V
    //   189: astore 19
    //   191: aload 19
    //   193: aload 18
    //   195: invokevirtual 97	android/bluetooth/le/ScanFilter:getDeviceAddress	()Ljava/lang/String;
    //   198: invokevirtual 100	k/a/a/a/a/a/h$b:a	(Ljava/lang/String;)Lk/a/a/a/a/a/h$b;
    //   201: pop
    //   202: aload 19
    //   204: aload 18
    //   206: invokevirtual 103	android/bluetooth/le/ScanFilter:getDeviceName	()Ljava/lang/String;
    //   209: putfield 106	k/a/a/a/a/a/h$b:a	Ljava/lang/String;
    //   212: aload 18
    //   214: invokevirtual 110	android/bluetooth/le/ScanFilter:getServiceUuid	()Landroid/os/ParcelUuid;
    //   217: astore 20
    //   219: aload 18
    //   221: invokevirtual 113	android/bluetooth/le/ScanFilter:getServiceUuidMask	()Landroid/os/ParcelUuid;
    //   224: astore 21
    //   226: aload 21
    //   228: ifnull +21 -> 249
    //   231: aload 20
    //   233: ifnull +6 -> 239
    //   236: goto +13 -> 249
    //   239: new 115	java/lang/IllegalArgumentException
    //   242: dup
    //   243: ldc 117
    //   245: invokespecial 120	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   248: athrow
    //   249: aload 19
    //   251: aload 20
    //   253: putfield 124	k/a/a/a/a/a/h$b:c	Landroid/os/ParcelUuid;
    //   256: aload 19
    //   258: aload 21
    //   260: putfield 127	k/a/a/a/a/a/h$b:d	Landroid/os/ParcelUuid;
    //   263: aload 19
    //   265: aload 18
    //   267: invokevirtual 131	android/bluetooth/le/ScanFilter:getManufacturerId	()I
    //   270: aload 18
    //   272: invokevirtual 135	android/bluetooth/le/ScanFilter:getManufacturerData	()[B
    //   275: aload 18
    //   277: invokevirtual 138	android/bluetooth/le/ScanFilter:getManufacturerDataMask	()[B
    //   280: invokevirtual 141	k/a/a/a/a/a/h$b:a	(I[B[B)Lk/a/a/a/a/a/h$b;
    //   283: pop
    //   284: aload 18
    //   286: invokevirtual 144	android/bluetooth/le/ScanFilter:getServiceDataUuid	()Landroid/os/ParcelUuid;
    //   289: ifnull +24 -> 313
    //   292: aload 19
    //   294: aload 18
    //   296: invokevirtual 144	android/bluetooth/le/ScanFilter:getServiceDataUuid	()Landroid/os/ParcelUuid;
    //   299: aload 18
    //   301: invokevirtual 147	android/bluetooth/le/ScanFilter:getServiceData	()[B
    //   304: aload 18
    //   306: invokevirtual 150	android/bluetooth/le/ScanFilter:getServiceDataMask	()[B
    //   309: invokevirtual 153	k/a/a/a/a/a/h$b:a	(Landroid/os/ParcelUuid;[B[B)Lk/a/a/a/a/a/h$b;
    //   312: pop
    //   313: aload 17
    //   315: aload 19
    //   317: invokevirtual 156	k/a/a/a/a/a/h$b:a	()Lk/a/a/a/a/a/h;
    //   320: invokevirtual 160	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   323: pop
    //   324: goto -164 -> 160
    //   327: new 162	k/a/a/a/a/a/k$b
    //   330: dup
    //   331: invokespecial 163	k/a/a/a/a/a/k$b:<init>	()V
    //   334: astore 4
    //   336: aload 4
    //   338: aload 5
    //   340: invokevirtual 166	android/bluetooth/le/ScanSettings:getLegacy	()Z
    //   343: putfield 170	k/a/a/a/a/a/k$b:f	Z
    //   346: aload 4
    //   348: aload 5
    //   350: invokevirtual 173	android/bluetooth/le/ScanSettings:getPhy	()I
    //   353: putfield 177	k/a/a/a/a/a/k$b:g	I
    //   356: aload 5
    //   358: invokevirtual 180	android/bluetooth/le/ScanSettings:getCallbackType	()I
    //   361: istore 22
    //   363: iload 22
    //   365: iconst_1
    //   366: if_icmpeq +34 -> 400
    //   369: iload 22
    //   371: iconst_2
    //   372: if_icmpeq +28 -> 400
    //   375: iload 22
    //   377: iconst_4
    //   378: if_icmpne +6 -> 384
    //   381: goto +19 -> 400
    //   384: iload 22
    //   386: bipush 6
    //   388: if_icmpne +6 -> 394
    //   391: goto +9 -> 400
    //   394: iconst_0
    //   395: istore 23
    //   397: goto +6 -> 403
    //   400: iconst_1
    //   401: istore 23
    //   403: iload 23
    //   405: ifeq +385 -> 790
    //   408: aload 4
    //   410: iload 22
    //   412: putfield 183	k/a/a/a/a/a/k$b:b	I
    //   415: aload 4
    //   417: aload 5
    //   419: invokevirtual 186	android/bluetooth/le/ScanSettings:getScanMode	()I
    //   422: invokevirtual 189	k/a/a/a/a/a/k$b:a	(I)Lk/a/a/a/a/a/k$b;
    //   425: pop
    //   426: aload 5
    //   428: invokevirtual 193	android/bluetooth/le/ScanSettings:getReportDelayMillis	()J
    //   431: lstore 24
    //   433: lload 24
    //   435: lconst_0
    //   436: lcmp
    //   437: iflt +342 -> 779
    //   440: aload 4
    //   442: lload 24
    //   444: putfield 196	k/a/a/a/a/a/k$b:c	J
    //   447: aload 4
    //   449: iload 6
    //   451: putfield 199	k/a/a/a/a/a/k$b:i	Z
    //   454: aload 4
    //   456: iload 7
    //   458: putfield 202	k/a/a/a/a/a/k$b:h	Z
    //   461: aload 4
    //   463: iload 8
    //   465: putfield 205	k/a/a/a/a/a/k$b:j	Z
    //   468: lload 9
    //   470: lconst_0
    //   471: lcmp
    //   472: ifle +296 -> 768
    //   475: lload 11
    //   477: lconst_0
    //   478: lcmp
    //   479: ifle +289 -> 768
    //   482: aload 4
    //   484: lload 9
    //   486: putfield 208	k/a/a/a/a/a/k$b:k	J
    //   489: aload 4
    //   491: lload 11
    //   493: putfield 211	k/a/a/a/a/a/k$b:l	J
    //   496: iload 13
    //   498: iconst_1
    //   499: if_icmplt +253 -> 752
    //   502: iload 13
    //   504: iconst_2
    //   505: if_icmpgt +247 -> 752
    //   508: aload 4
    //   510: iload 13
    //   512: putfield 213	k/a/a/a/a/a/k$b:d	I
    //   515: iload 14
    //   517: iconst_1
    //   518: if_icmplt +218 -> 736
    //   521: iload 14
    //   523: iconst_3
    //   524: if_icmpgt +212 -> 736
    //   527: aload 4
    //   529: iload 14
    //   531: putfield 216	k/a/a/a/a/a/k$b:e	I
    //   534: aload 4
    //   536: invokevirtual 219	k/a/a/a/a/a/k$b:a	()Lk/a/a/a/a/a/k;
    //   539: astore 5
    //   541: invokestatic 225	android/bluetooth/BluetoothAdapter:getDefaultAdapter	()Landroid/bluetooth/BluetoothAdapter;
    //   544: astore 4
    //   546: aload 4
    //   548: invokevirtual 228	android/bluetooth/BluetoothAdapter:isOffloadedScanBatchingSupported	()Z
    //   551: istore 7
    //   553: aload 4
    //   555: invokevirtual 231	android/bluetooth/BluetoothAdapter:isOffloadedFilteringSupported	()Z
    //   558: istore 6
    //   560: aload 15
    //   562: monitorenter
    //   563: aload 16
    //   565: aload_3
    //   566: invokevirtual 234	k/a/a/a/a/a/d:a	(Landroid/app/PendingIntent;)Lk/a/a/a/a/a/d$a;
    //   569: astore 4
    //   571: aload 4
    //   573: ifnonnull +36 -> 609
    //   576: new 236	k/a/a/a/a/a/d$a
    //   579: astore 4
    //   581: aload 4
    //   583: iload 7
    //   585: iload 6
    //   587: aload 17
    //   589: aload 5
    //   591: aload_3
    //   592: invokespecial 239	k/a/a/a/a/a/d$a:<init>	(ZZLjava/util/List;Lk/a/a/a/a/a/k;Landroid/app/PendingIntent;)V
    //   595: aload 16
    //   597: aload_3
    //   598: aload 4
    //   600: invokevirtual 242	k/a/a/a/a/a/d:a	(Landroid/app/PendingIntent;Lk/a/a/a/a/a/d$a;)V
    //   603: aload 4
    //   605: astore_3
    //   606: goto +6 -> 612
    //   609: aload 4
    //   611: astore_3
    //   612: aload 15
    //   614: monitorexit
    //   615: aload_3
    //   616: getfield 246	k/a/a/a/a/a/d$a:o	Lk/a/a/a/a/a/f;
    //   619: aload_1
    //   620: putfield 251	k/a/a/a/a/a/f:b	Landroid/content/Context;
    //   623: aload_2
    //   624: ldc -3
    //   626: invokevirtual 29	android/content/Intent:getParcelableArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   629: astore_1
    //   630: aload_1
    //   631: ifnull +58 -> 689
    //   634: aload 16
    //   636: aload_1
    //   637: invokevirtual 258	k/a/a/a/a/a/b:a	(Ljava/util/List;)Ljava/util/ArrayList;
    //   640: astore_1
    //   641: aload 5
    //   643: getfield 263	k/a/a/a/a/a/k:B	J
    //   646: lconst_0
    //   647: lcmp
    //   648: ifle +11 -> 659
    //   651: aload_3
    //   652: aload_1
    //   653: invokevirtual 268	k/a/a/a/a/a/a$a:a	(Ljava/util/List;)V
    //   656: goto +57 -> 713
    //   659: aload_1
    //   660: invokevirtual 271	java/util/ArrayList:isEmpty	()Z
    //   663: ifne +50 -> 713
    //   666: aload_3
    //   667: aload_2
    //   668: ldc_w 273
    //   671: iconst_1
    //   672: invokevirtual 59	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   675: aload_1
    //   676: iconst_0
    //   677: invokevirtual 277	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   680: checkcast 279	k/a/a/a/a/a/j
    //   683: invokevirtual 282	k/a/a/a/a/a/a$a:a	(ILk/a/a/a/a/a/j;)V
    //   686: goto +27 -> 713
    //   689: aload_2
    //   690: ldc_w 284
    //   693: iconst_0
    //   694: invokevirtual 59	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   697: istore 23
    //   699: iload 23
    //   701: ifeq +12 -> 713
    //   704: aload_3
    //   705: getfield 287	k/a/a/a/a/a/a$a:h	Lk/a/a/a/a/a/g;
    //   708: iload 23
    //   710: invokevirtual 292	k/a/a/a/a/a/g:a	(I)V
    //   713: aload_3
    //   714: getfield 246	k/a/a/a/a/a/d$a:o	Lk/a/a/a/a/a/f;
    //   717: aconst_null
    //   718: putfield 251	k/a/a/a/a/a/f:b	Landroid/content/Context;
    //   721: return
    //   722: astore_1
    //   723: goto +8 -> 731
    //   726: astore_1
    //   727: aload 15
    //   729: monitorexit
    //   730: return
    //   731: aload 15
    //   733: monitorexit
    //   734: aload_1
    //   735: athrow
    //   736: new 115	java/lang/IllegalArgumentException
    //   739: dup
    //   740: ldc_w 294
    //   743: iload 14
    //   745: invokestatic 299	e/a/a/a/a:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   748: invokespecial 120	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   751: athrow
    //   752: new 115	java/lang/IllegalArgumentException
    //   755: dup
    //   756: ldc_w 301
    //   759: iload 13
    //   761: invokestatic 299	e/a/a/a/a:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   764: invokespecial 120	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   767: athrow
    //   768: new 115	java/lang/IllegalArgumentException
    //   771: dup
    //   772: ldc_w 303
    //   775: invokespecial 120	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   778: athrow
    //   779: new 115	java/lang/IllegalArgumentException
    //   782: dup
    //   783: ldc_w 305
    //   786: invokespecial 120	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   789: athrow
    //   790: new 115	java/lang/IllegalArgumentException
    //   793: dup
    //   794: ldc_w 307
    //   797: iload 22
    //   799: invokestatic 299	e/a/a/a/a:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   802: invokespecial 120	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   805: athrow
    //   806: aconst_null
    //   807: athrow
    //   808: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	809	0	this	PendingIntentReceiver
    //   0	809	1	paramContext	android.content.Context
    //   0	809	2	paramIntent	android.content.Intent
    //   20	694	3	localObject1	Object
    //   32	578	4	localObject2	Object
    //   43	599	5	localObject3	Object
    //   65	521	6	bool1	boolean
    //   74	510	7	bool2	boolean
    //   83	381	8	bool3	boolean
    //   94	391	9	l1	long
    //   105	387	11	l2	long
    //   114	646	13	i	int
    //   123	621	14	j	int
    //   128	604	15	locala	k.a.a.a.a.a.a
    //   135	500	16	locald	k.a.a.a.a.a.d
    //   149	439	17	localArrayList	java.util.ArrayList
    //   180	125	18	localScanFilter	android.bluetooth.le.ScanFilter
    //   189	127	19	localb	k.a.a.a.a.a.h.b
    //   217	35	20	localParcelUuid1	android.os.ParcelUuid
    //   224	35	21	localParcelUuid2	android.os.ParcelUuid
    //   361	437	22	k	int
    //   395	314	23	m	int
    //   431	12	24	l3	long
    // Exception table:
    //   from	to	target	type
    //   563	571	722	finally
    //   576	603	722	finally
    //   612	615	722	finally
    //   727	730	722	finally
    //   731	734	722	finally
    //   563	571	726	java/lang/IllegalStateException
  }
}

/* Location:
 * Qualified Name:     no.nordicsemi.android.support.v18.scanner.PendingIntentReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */