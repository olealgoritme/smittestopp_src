package com.microsoft.azure.storage.core;

import com.microsoft.azure.storage.ErrorReceivingResponseEvent;
import com.microsoft.azure.storage.LocationMode;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.RequestCompletedEvent;
import com.microsoft.azure.storage.RequestOptions;
import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.ResponseReceivedEvent;
import com.microsoft.azure.storage.RetryContext;
import com.microsoft.azure.storage.RetryingEvent;
import com.microsoft.azure.storage.SendingRequestEvent;
import com.microsoft.azure.storage.StorageEventMultiCaster;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.StorageLocation;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeoutException;

public final class ExecutionEngine
{
  /* Error */
  public static <CLIENT_TYPE, PARENT_TYPE, RESULT_TYPE> RESULT_TYPE executeWithRetry(CLIENT_TYPE paramCLIENT_TYPE, PARENT_TYPE paramPARENT_TYPE, StorageRequest<CLIENT_TYPE, PARENT_TYPE, RESULT_TYPE> paramStorageRequest, com.microsoft.azure.storage.RetryPolicyFactory paramRetryPolicyFactory, OperationContext paramOperationContext)
  {
    // Byte code:
    //   0: aload 4
    //   2: astore 5
    //   4: ldc 23
    //   6: astore 6
    //   8: ldc 25
    //   10: astore 7
    //   12: aload_3
    //   13: ifnonnull +14 -> 27
    //   16: new 27	com/microsoft/azure/storage/RetryNoRetry
    //   19: dup
    //   20: invokespecial 28	com/microsoft/azure/storage/RetryNoRetry:<init>	()V
    //   23: astore_3
    //   24: goto +29 -> 53
    //   27: aload_3
    //   28: aload 4
    //   30: invokeinterface 34 2 0
    //   35: astore 8
    //   37: aload 8
    //   39: astore_3
    //   40: aload 8
    //   42: ifnonnull +11 -> 53
    //   45: new 27	com/microsoft/azure/storage/RetryNoRetry
    //   48: dup
    //   49: invokespecial 28	com/microsoft/azure/storage/RetryNoRetry:<init>	()V
    //   52: astore_3
    //   53: aload_3
    //   54: astore 9
    //   56: new 36	java/util/Date
    //   59: dup
    //   60: invokespecial 37	java/util/Date:<init>	()V
    //   63: invokevirtual 41	java/util/Date:getTime	()J
    //   66: lstore 10
    //   68: aconst_null
    //   69: astore 12
    //   71: aconst_null
    //   72: astore 8
    //   74: iconst_0
    //   75: istore 13
    //   77: aload 5
    //   79: astore_3
    //   80: aload 8
    //   82: astore 5
    //   84: aload_0
    //   85: aload_1
    //   86: aload_2
    //   87: iload 13
    //   89: aload_3
    //   90: invokestatic 45	com/microsoft/azure/storage/core/ExecutionEngine:setupStorageRequest	(Ljava/lang/Object;Ljava/lang/Object;Lcom/microsoft/azure/storage/core/StorageRequest;ILcom/microsoft/azure/storage/OperationContext;)Ljava/net/HttpURLConnection;
    //   93: astore 8
    //   95: aload 8
    //   97: astore 5
    //   99: aload_3
    //   100: ldc 47
    //   102: aload 5
    //   104: invokevirtual 53	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   107: aload 5
    //   109: ldc 55
    //   111: invokevirtual 59	java/net/HttpURLConnection:getRequestProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   114: invokestatic 65	com/microsoft/azure/storage/core/Logger:info	(Lcom/microsoft/azure/storage/OperationContext;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   117: aload_2
    //   118: invokevirtual 71	com/microsoft/azure/storage/core/StorageRequest:getSendStream	()Ljava/io/InputStream;
    //   121: ifnull +70 -> 191
    //   124: aload_3
    //   125: ldc 73
    //   127: invokestatic 76	com/microsoft/azure/storage/core/Logger:info	(Lcom/microsoft/azure/storage/OperationContext;Ljava/lang/String;)V
    //   130: aload_2
    //   131: invokevirtual 80	com/microsoft/azure/storage/core/StorageRequest:getLength	()Ljava/lang/Long;
    //   134: invokevirtual 85	java/lang/Long:longValue	()J
    //   137: lconst_0
    //   138: lcmp
    //   139: iflt +15 -> 154
    //   142: aload 5
    //   144: aload_2
    //   145: invokevirtual 80	com/microsoft/azure/storage/core/StorageRequest:getLength	()Ljava/lang/Long;
    //   148: invokevirtual 85	java/lang/Long:longValue	()J
    //   151: invokevirtual 89	java/net/HttpURLConnection:setFixedLengthStreamingMode	(J)V
    //   154: aload_2
    //   155: aload_2
    //   156: invokevirtual 71	com/microsoft/azure/storage/core/StorageRequest:getSendStream	()Ljava/io/InputStream;
    //   159: aload 5
    //   161: invokevirtual 93	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   164: aload_2
    //   165: invokevirtual 80	com/microsoft/azure/storage/core/StorageRequest:getLength	()Ljava/lang/Long;
    //   168: invokevirtual 85	java/lang/Long:longValue	()J
    //   171: iconst_0
    //   172: iconst_0
    //   173: aload 4
    //   175: aload_2
    //   176: invokevirtual 97	com/microsoft/azure/storage/core/StorageRequest:getRequestOptions	()Lcom/microsoft/azure/storage/RequestOptions;
    //   179: invokestatic 103	com/microsoft/azure/storage/core/Utility:writeToOutputStream	(Ljava/io/InputStream;Ljava/io/OutputStream;JZZLcom/microsoft/azure/storage/OperationContext;Lcom/microsoft/azure/storage/RequestOptions;)Lcom/microsoft/azure/storage/core/StreamMd5AndLength;
    //   182: invokevirtual 107	com/microsoft/azure/storage/core/StorageRequest:validateStreamWrite	(Lcom/microsoft/azure/storage/core/StreamMd5AndLength;)V
    //   185: aload_3
    //   186: ldc 109
    //   188: invokestatic 76	com/microsoft/azure/storage/core/Logger:info	(Lcom/microsoft/azure/storage/OperationContext;Ljava/lang/String;)V
    //   191: aload 5
    //   193: aload_3
    //   194: invokestatic 113	com/microsoft/azure/storage/core/Utility:logHttpRequest	(Ljava/net/HttpURLConnection;Lcom/microsoft/azure/storage/OperationContext;)V
    //   197: aload_2
    //   198: invokevirtual 117	com/microsoft/azure/storage/core/StorageRequest:getResult	()Lcom/microsoft/azure/storage/RequestResult;
    //   201: astore 14
    //   203: new 36	java/util/Date
    //   206: astore 15
    //   208: aload 15
    //   210: invokespecial 37	java/util/Date:<init>	()V
    //   213: aload 14
    //   215: aload 15
    //   217: invokevirtual 123	com/microsoft/azure/storage/RequestResult:setStartDate	(Ljava/util/Date;)V
    //   220: aload_3
    //   221: ldc 125
    //   223: invokestatic 76	com/microsoft/azure/storage/core/Logger:info	(Lcom/microsoft/azure/storage/OperationContext;Ljava/lang/String;)V
    //   226: aload 14
    //   228: aload 5
    //   230: invokevirtual 129	java/net/HttpURLConnection:getResponseCode	()I
    //   233: invokevirtual 133	com/microsoft/azure/storage/RequestResult:setStatusCode	(I)V
    //   236: aload 14
    //   238: aload 5
    //   240: invokevirtual 137	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   243: invokevirtual 141	com/microsoft/azure/storage/RequestResult:setStatusMessage	(Ljava/lang/String;)V
    //   246: new 36	java/util/Date
    //   249: astore 15
    //   251: aload 15
    //   253: invokespecial 37	java/util/Date:<init>	()V
    //   256: aload 14
    //   258: aload 15
    //   260: invokevirtual 144	com/microsoft/azure/storage/RequestResult:setStopDate	(Ljava/util/Date;)V
    //   263: aload 14
    //   265: aload 5
    //   267: invokestatic 150	com/microsoft/azure/storage/core/BaseResponse:getRequestId	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   270: invokevirtual 153	com/microsoft/azure/storage/RequestResult:setServiceRequestID	(Ljava/lang/String;)V
    //   273: aload 14
    //   275: aload 5
    //   277: invokestatic 156	com/microsoft/azure/storage/core/BaseResponse:getEtag	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   280: invokevirtual 159	com/microsoft/azure/storage/RequestResult:setEtag	(Ljava/lang/String;)V
    //   283: aload 14
    //   285: aload 5
    //   287: invokestatic 162	com/microsoft/azure/storage/core/BaseResponse:getDate	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   290: invokevirtual 165	com/microsoft/azure/storage/RequestResult:setRequestDate	(Ljava/lang/String;)V
    //   293: aload 14
    //   295: aload 5
    //   297: invokestatic 168	com/microsoft/azure/storage/core/BaseResponse:getContentMD5	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   300: invokevirtual 171	com/microsoft/azure/storage/RequestResult:setContentMD5	(Ljava/lang/String;)V
    //   303: aload 14
    //   305: aload 5
    //   307: invokestatic 174	com/microsoft/azure/storage/core/BaseResponse:getErrorCode	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    //   310: invokevirtual 177	com/microsoft/azure/storage/RequestResult:setErrorCode	(Ljava/lang/String;)V
    //   313: aload_3
    //   314: aload 5
    //   316: aload_2
    //   317: invokevirtual 117	com/microsoft/azure/storage/core/StorageRequest:getResult	()Lcom/microsoft/azure/storage/RequestResult;
    //   320: invokestatic 181	com/microsoft/azure/storage/core/ExecutionEngine:fireResponseReceivedEvent	(Lcom/microsoft/azure/storage/OperationContext;Ljava/net/HttpURLConnection;Lcom/microsoft/azure/storage/RequestResult;)V
    //   323: aload_3
    //   324: ldc -73
    //   326: iconst_5
    //   327: anewarray 4	java/lang/Object
    //   330: dup
    //   331: iconst_0
    //   332: aload 14
    //   334: invokevirtual 186	com/microsoft/azure/storage/RequestResult:getStatusCode	()I
    //   337: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   340: aastore
    //   341: dup
    //   342: iconst_1
    //   343: aload 14
    //   345: invokevirtual 195	com/microsoft/azure/storage/RequestResult:getServiceRequestID	()Ljava/lang/String;
    //   348: aastore
    //   349: dup
    //   350: iconst_2
    //   351: aload 14
    //   353: invokevirtual 197	com/microsoft/azure/storage/RequestResult:getContentMD5	()Ljava/lang/String;
    //   356: aastore
    //   357: dup
    //   358: iconst_3
    //   359: aload 14
    //   361: invokevirtual 199	com/microsoft/azure/storage/RequestResult:getEtag	()Ljava/lang/String;
    //   364: aastore
    //   365: dup
    //   366: iconst_4
    //   367: aload 14
    //   369: invokevirtual 202	com/microsoft/azure/storage/RequestResult:getRequestDate	()Ljava/lang/String;
    //   372: aastore
    //   373: invokestatic 205	com/microsoft/azure/storage/core/Logger:info	(Lcom/microsoft/azure/storage/OperationContext;Ljava/lang/String;[Ljava/lang/Object;)V
    //   376: aload 5
    //   378: aload_3
    //   379: invokestatic 208	com/microsoft/azure/storage/core/Utility:logHttpResponse	(Ljava/net/HttpURLConnection;Lcom/microsoft/azure/storage/OperationContext;)V
    //   382: aload_3
    //   383: aload 6
    //   385: invokestatic 76	com/microsoft/azure/storage/core/Logger:info	(Lcom/microsoft/azure/storage/OperationContext;Ljava/lang/String;)V
    //   388: aload_3
    //   389: ldc -46
    //   391: invokestatic 76	com/microsoft/azure/storage/core/Logger:info	(Lcom/microsoft/azure/storage/OperationContext;Ljava/lang/String;)V
    //   394: aload_2
    //   395: aload_1
    //   396: aload_0
    //   397: aload_3
    //   398: invokevirtual 214	com/microsoft/azure/storage/core/StorageRequest:preProcessResponse	(Ljava/lang/Object;Ljava/lang/Object;Lcom/microsoft/azure/storage/OperationContext;)Ljava/lang/Object;
    //   401: astore 15
    //   403: aload_3
    //   404: ldc -40
    //   406: invokestatic 76	com/microsoft/azure/storage/core/Logger:info	(Lcom/microsoft/azure/storage/OperationContext;Ljava/lang/String;)V
    //   409: aload_2
    //   410: invokevirtual 220	com/microsoft/azure/storage/core/StorageRequest:isNonExceptionedRetryableFailure	()Z
    //   413: ifne +151 -> 564
    //   416: aload_3
    //   417: ldc -34
    //   419: invokestatic 76	com/microsoft/azure/storage/core/Logger:info	(Lcom/microsoft/azure/storage/OperationContext;Ljava/lang/String;)V
    //   422: aload 5
    //   424: astore 14
    //   426: aload_3
    //   427: astore 5
    //   429: aload_2
    //   430: aload 14
    //   432: aload_1
    //   433: aload_0
    //   434: aload 4
    //   436: aload 15
    //   438: invokevirtual 226	com/microsoft/azure/storage/core/StorageRequest:postProcessResponse	(Ljava/net/HttpURLConnection;Ljava/lang/Object;Ljava/lang/Object;Lcom/microsoft/azure/storage/OperationContext;Ljava/lang/Object;)Ljava/lang/Object;
    //   441: astore 16
    //   443: aload 5
    //   445: ldc -28
    //   447: invokestatic 76	com/microsoft/azure/storage/core/Logger:info	(Lcom/microsoft/azure/storage/OperationContext;Ljava/lang/String;)V
    //   450: aload_2
    //   451: invokevirtual 117	com/microsoft/azure/storage/core/StorageRequest:getResult	()Lcom/microsoft/azure/storage/RequestResult;
    //   454: invokevirtual 186	com/microsoft/azure/storage/RequestResult:getStatusCode	()I
    //   457: sipush 200
    //   460: if_icmplt +58 -> 518
    //   463: aload_2
    //   464: invokevirtual 117	com/microsoft/azure/storage/core/StorageRequest:getResult	()Lcom/microsoft/azure/storage/RequestResult;
    //   467: invokevirtual 186	com/microsoft/azure/storage/RequestResult:getStatusCode	()I
    //   470: sipush 300
    //   473: if_icmpge +45 -> 518
    //   476: aload 14
    //   478: invokevirtual 231	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   481: astore 15
    //   483: aload 15
    //   485: aconst_null
    //   486: ldc2_w 232
    //   489: iconst_0
    //   490: iconst_0
    //   491: aconst_null
    //   492: aload_2
    //   493: invokevirtual 97	com/microsoft/azure/storage/core/StorageRequest:getRequestOptions	()Lcom/microsoft/azure/storage/RequestOptions;
    //   496: invokestatic 103	com/microsoft/azure/storage/core/Utility:writeToOutputStream	(Ljava/io/InputStream;Ljava/io/OutputStream;JZZLcom/microsoft/azure/storage/OperationContext;Lcom/microsoft/azure/storage/RequestOptions;)Lcom/microsoft/azure/storage/core/StreamMd5AndLength;
    //   499: pop
    //   500: aload 15
    //   502: invokevirtual 238	java/io/InputStream:close	()V
    //   505: goto +13 -> 518
    //   508: astore 5
    //   510: aload 15
    //   512: invokevirtual 238	java/io/InputStream:close	()V
    //   515: aload 5
    //   517: athrow
    //   518: aload 5
    //   520: ldc -16
    //   522: invokestatic 76	com/microsoft/azure/storage/core/Logger:info	(Lcom/microsoft/azure/storage/OperationContext;Ljava/lang/String;)V
    //   525: aload 5
    //   527: new 36	java/util/Date
    //   530: dup
    //   531: invokespecial 37	java/util/Date:<init>	()V
    //   534: invokevirtual 41	java/util/Date:getTime	()J
    //   537: lload 10
    //   539: lsub
    //   540: invokevirtual 245	com/microsoft/azure/storage/OperationContext:setClientTimeInMs	(J)V
    //   543: aload_2
    //   544: invokevirtual 248	com/microsoft/azure/storage/core/StorageRequest:isSent	()Z
    //   547: ifeq +14 -> 561
    //   550: aload 5
    //   552: aload 14
    //   554: aload_2
    //   555: invokevirtual 117	com/microsoft/azure/storage/core/StorageRequest:getResult	()Lcom/microsoft/azure/storage/RequestResult;
    //   558: invokestatic 251	com/microsoft/azure/storage/core/ExecutionEngine:fireRequestCompletedEvent	(Lcom/microsoft/azure/storage/OperationContext;Ljava/net/HttpURLConnection;Lcom/microsoft/azure/storage/RequestResult;)V
    //   561: aload 16
    //   563: areturn
    //   564: aload_3
    //   565: astore 15
    //   567: aload 15
    //   569: ldc -3
    //   571: invokestatic 256	com/microsoft/azure/storage/core/Logger:warn	(Lcom/microsoft/azure/storage/OperationContext;Ljava/lang/String;)V
    //   574: aload_2
    //   575: aload 15
    //   577: invokevirtual 260	com/microsoft/azure/storage/core/StorageRequest:materializeException	(Lcom/microsoft/azure/storage/OperationContext;)Lcom/microsoft/azure/storage/StorageException;
    //   580: astore 14
    //   582: aload_2
    //   583: invokevirtual 117	com/microsoft/azure/storage/core/StorageRequest:getResult	()Lcom/microsoft/azure/storage/RequestResult;
    //   586: aload 14
    //   588: invokevirtual 264	com/microsoft/azure/storage/RequestResult:setException	(Ljava/lang/Exception;)V
    //   591: aload_2
    //   592: invokevirtual 117	com/microsoft/azure/storage/core/StorageRequest:getResult	()Lcom/microsoft/azure/storage/RequestResult;
    //   595: invokevirtual 186	com/microsoft/azure/storage/RequestResult:getStatusCode	()I
    //   598: sipush 501
    //   601: if_icmpeq +73 -> 674
    //   604: aload_2
    //   605: invokevirtual 117	com/microsoft/azure/storage/core/StorageRequest:getResult	()Lcom/microsoft/azure/storage/RequestResult;
    //   608: invokevirtual 186	com/microsoft/azure/storage/RequestResult:getStatusCode	()I
    //   611: sipush 505
    //   614: if_icmpeq +60 -> 674
    //   617: aload 14
    //   619: invokevirtual 266	com/microsoft/azure/storage/StorageException:getErrorCode	()Ljava/lang/String;
    //   622: ldc_w 268
    //   625: invokevirtual 274	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   628: istore 17
    //   630: iload 17
    //   632: ifne +42 -> 674
    //   635: aload 15
    //   637: new 36	java/util/Date
    //   640: dup
    //   641: invokespecial 37	java/util/Date:<init>	()V
    //   644: invokevirtual 41	java/util/Date:getTime	()J
    //   647: lload 10
    //   649: lsub
    //   650: invokevirtual 245	com/microsoft/azure/storage/OperationContext:setClientTimeInMs	(J)V
    //   653: aload_2
    //   654: invokevirtual 248	com/microsoft/azure/storage/core/StorageRequest:isSent	()Z
    //   657: ifeq +14 -> 671
    //   660: aload 15
    //   662: aload 5
    //   664: aload_2
    //   665: invokevirtual 117	com/microsoft/azure/storage/core/StorageRequest:getResult	()Lcom/microsoft/azure/storage/RequestResult;
    //   668: invokestatic 251	com/microsoft/azure/storage/core/ExecutionEngine:fireRequestCompletedEvent	(Lcom/microsoft/azure/storage/OperationContext;Ljava/net/HttpURLConnection;Lcom/microsoft/azure/storage/RequestResult;)V
    //   671: goto +228 -> 899
    //   674: aload 14
    //   676: athrow
    //   677: astore 5
    //   679: iconst_1
    //   680: istore 18
    //   682: goto +8 -> 690
    //   685: astore 5
    //   687: iconst_0
    //   688: istore 18
    //   690: aload_3
    //   691: astore 14
    //   693: aload 14
    //   695: aload 6
    //   697: invokestatic 76	com/microsoft/azure/storage/core/Logger:info	(Lcom/microsoft/azure/storage/OperationContext;Ljava/lang/String;)V
    //   700: iload 18
    //   702: ifne +47 -> 749
    //   705: aload_2
    //   706: invokevirtual 117	com/microsoft/azure/storage/core/StorageRequest:getResult	()Lcom/microsoft/azure/storage/RequestResult;
    //   709: invokevirtual 278	com/microsoft/azure/storage/RequestResult:getStartDate	()Ljava/util/Date;
    //   712: ifnonnull +26 -> 738
    //   715: aload_2
    //   716: invokevirtual 117	com/microsoft/azure/storage/core/StorageRequest:getResult	()Lcom/microsoft/azure/storage/RequestResult;
    //   719: astore 16
    //   721: new 36	java/util/Date
    //   724: astore 15
    //   726: aload 15
    //   728: invokespecial 37	java/util/Date:<init>	()V
    //   731: aload 16
    //   733: aload 15
    //   735: invokevirtual 123	com/microsoft/azure/storage/RequestResult:setStartDate	(Ljava/util/Date;)V
    //   738: aload 14
    //   740: aload 8
    //   742: aload_2
    //   743: invokevirtual 117	com/microsoft/azure/storage/core/StorageRequest:getResult	()Lcom/microsoft/azure/storage/RequestResult;
    //   746: invokestatic 281	com/microsoft/azure/storage/core/ExecutionEngine:fireErrorReceivingResponseEvent	(Lcom/microsoft/azure/storage/OperationContext;Ljava/net/HttpURLConnection;Lcom/microsoft/azure/storage/RequestResult;)V
    //   749: aload 5
    //   751: athrow
    //   752: astore_0
    //   753: aload 8
    //   755: astore 5
    //   757: goto +584 -> 1341
    //   760: astore 14
    //   762: goto +32 -> 794
    //   765: astore 15
    //   767: goto +141 -> 908
    //   770: astore_0
    //   771: goto +14 -> 785
    //   774: astore 14
    //   776: goto +14 -> 790
    //   779: astore 15
    //   781: goto +123 -> 904
    //   784: astore_0
    //   785: goto +556 -> 1341
    //   788: astore 14
    //   790: aload 5
    //   792: astore 8
    //   794: aload_3
    //   795: astore 16
    //   797: aload 8
    //   799: astore 5
    //   801: aload 16
    //   803: aload 7
    //   805: aload 14
    //   807: invokevirtual 285	java/lang/Object:getClass	()Ljava/lang/Class;
    //   810: invokevirtual 290	java/lang/Class:getName	()Ljava/lang/String;
    //   813: aload 14
    //   815: invokevirtual 293	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   818: invokestatic 295	com/microsoft/azure/storage/core/Logger:warn	(Lcom/microsoft/azure/storage/OperationContext;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   821: aload 8
    //   823: astore 5
    //   825: aload_2
    //   826: aload 14
    //   828: aload 16
    //   830: invokestatic 299	com/microsoft/azure/storage/StorageException:translateException	(Lcom/microsoft/azure/storage/core/StorageRequest;Ljava/lang/Exception;Lcom/microsoft/azure/storage/OperationContext;)Lcom/microsoft/azure/storage/StorageException;
    //   833: astore 15
    //   835: aload 8
    //   837: astore 5
    //   839: aload_2
    //   840: invokevirtual 117	com/microsoft/azure/storage/core/StorageRequest:getResult	()Lcom/microsoft/azure/storage/RequestResult;
    //   843: aload 15
    //   845: invokevirtual 264	com/microsoft/azure/storage/RequestResult:setException	(Ljava/lang/Exception;)V
    //   848: aload 16
    //   850: new 36	java/util/Date
    //   853: dup
    //   854: invokespecial 37	java/util/Date:<init>	()V
    //   857: invokevirtual 41	java/util/Date:getTime	()J
    //   860: lload 10
    //   862: lsub
    //   863: invokevirtual 245	com/microsoft/azure/storage/OperationContext:setClientTimeInMs	(J)V
    //   866: aload 15
    //   868: astore 14
    //   870: aload 8
    //   872: astore 5
    //   874: aload_2
    //   875: invokevirtual 248	com/microsoft/azure/storage/core/StorageRequest:isSent	()Z
    //   878: ifeq +21 -> 899
    //   881: aload 8
    //   883: astore 5
    //   885: aload 15
    //   887: astore 14
    //   889: aload_3
    //   890: aload 5
    //   892: aload_2
    //   893: invokevirtual 117	com/microsoft/azure/storage/core/StorageRequest:getResult	()Lcom/microsoft/azure/storage/RequestResult;
    //   896: invokestatic 251	com/microsoft/azure/storage/core/ExecutionEngine:fireRequestCompletedEvent	(Lcom/microsoft/azure/storage/OperationContext;Ljava/net/HttpURLConnection;Lcom/microsoft/azure/storage/RequestResult;)V
    //   899: goto +125 -> 1024
    //   902: astore 15
    //   904: aload 5
    //   906: astore 8
    //   908: aload_3
    //   909: astore 14
    //   911: aload 8
    //   913: astore 5
    //   915: aload_2
    //   916: invokevirtual 117	com/microsoft/azure/storage/core/StorageRequest:getResult	()Lcom/microsoft/azure/storage/RequestResult;
    //   919: aload 15
    //   921: invokevirtual 302	com/microsoft/azure/storage/StorageException:getHttpStatusCode	()I
    //   924: invokevirtual 133	com/microsoft/azure/storage/RequestResult:setStatusCode	(I)V
    //   927: aload 8
    //   929: astore 5
    //   931: aload_2
    //   932: invokevirtual 117	com/microsoft/azure/storage/core/StorageRequest:getResult	()Lcom/microsoft/azure/storage/RequestResult;
    //   935: aload 15
    //   937: invokevirtual 293	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   940: invokevirtual 141	com/microsoft/azure/storage/RequestResult:setStatusMessage	(Ljava/lang/String;)V
    //   943: aload 8
    //   945: astore 5
    //   947: aload_2
    //   948: invokevirtual 117	com/microsoft/azure/storage/core/StorageRequest:getResult	()Lcom/microsoft/azure/storage/RequestResult;
    //   951: aload 15
    //   953: invokevirtual 264	com/microsoft/azure/storage/RequestResult:setException	(Ljava/lang/Exception;)V
    //   956: aload 8
    //   958: astore 5
    //   960: aload 14
    //   962: aload 7
    //   964: aload 15
    //   966: invokevirtual 285	java/lang/Object:getClass	()Ljava/lang/Class;
    //   969: invokevirtual 290	java/lang/Class:getName	()Ljava/lang/String;
    //   972: aload 15
    //   974: invokevirtual 293	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   977: invokestatic 295	com/microsoft/azure/storage/core/Logger:warn	(Lcom/microsoft/azure/storage/OperationContext;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   980: aload 14
    //   982: new 36	java/util/Date
    //   985: dup
    //   986: invokespecial 37	java/util/Date:<init>	()V
    //   989: invokevirtual 41	java/util/Date:getTime	()J
    //   992: lload 10
    //   994: lsub
    //   995: invokevirtual 245	com/microsoft/azure/storage/OperationContext:setClientTimeInMs	(J)V
    //   998: aload 15
    //   1000: astore 14
    //   1002: aload 8
    //   1004: astore 5
    //   1006: aload_2
    //   1007: invokevirtual 248	com/microsoft/azure/storage/core/StorageRequest:isSent	()Z
    //   1010: ifeq -111 -> 899
    //   1013: aload 15
    //   1015: astore 14
    //   1017: aload 8
    //   1019: astore 5
    //   1021: goto -132 -> 889
    //   1024: aload_2
    //   1025: invokevirtual 117	com/microsoft/azure/storage/core/StorageRequest:getResult	()Lcom/microsoft/azure/storage/RequestResult;
    //   1028: invokevirtual 186	com/microsoft/azure/storage/RequestResult:getStatusCode	()I
    //   1031: istore 18
    //   1033: aload 14
    //   1035: ifnonnull +9 -> 1044
    //   1038: aconst_null
    //   1039: astore 8
    //   1041: goto +10 -> 1051
    //   1044: aload 14
    //   1046: invokevirtual 293	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1049: astore 8
    //   1051: aload_3
    //   1052: ldc_w 304
    //   1055: iconst_3
    //   1056: anewarray 4	java/lang/Object
    //   1059: dup
    //   1060: iconst_0
    //   1061: iload 13
    //   1063: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1066: aastore
    //   1067: dup
    //   1068: iconst_1
    //   1069: iload 18
    //   1071: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1074: aastore
    //   1075: dup
    //   1076: iconst_2
    //   1077: aload 8
    //   1079: aastore
    //   1080: invokestatic 205	com/microsoft/azure/storage/core/Logger:info	(Lcom/microsoft/azure/storage/OperationContext;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1083: aload_2
    //   1084: aload_2
    //   1085: invokevirtual 308	com/microsoft/azure/storage/core/StorageRequest:getCurrentLocation	()Lcom/microsoft/azure/storage/StorageLocation;
    //   1088: aload_2
    //   1089: invokevirtual 312	com/microsoft/azure/storage/core/StorageRequest:getLocationMode	()Lcom/microsoft/azure/storage/LocationMode;
    //   1092: invokestatic 316	com/microsoft/azure/storage/core/ExecutionEngine:getNextLocation	(Lcom/microsoft/azure/storage/StorageLocation;Lcom/microsoft/azure/storage/LocationMode;)Lcom/microsoft/azure/storage/StorageLocation;
    //   1095: invokevirtual 320	com/microsoft/azure/storage/core/StorageRequest:setCurrentLocation	(Lcom/microsoft/azure/storage/StorageLocation;)V
    //   1098: aload_3
    //   1099: ldc_w 322
    //   1102: aload_2
    //   1103: invokevirtual 308	com/microsoft/azure/storage/core/StorageRequest:getCurrentLocation	()Lcom/microsoft/azure/storage/StorageLocation;
    //   1106: aload_2
    //   1107: invokevirtual 312	com/microsoft/azure/storage/core/StorageRequest:getLocationMode	()Lcom/microsoft/azure/storage/LocationMode;
    //   1110: invokestatic 65	com/microsoft/azure/storage/core/Logger:info	(Lcom/microsoft/azure/storage/OperationContext;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   1113: new 324	com/microsoft/azure/storage/RetryContext
    //   1116: dup
    //   1117: iload 13
    //   1119: aload_2
    //   1120: invokevirtual 117	com/microsoft/azure/storage/core/StorageRequest:getResult	()Lcom/microsoft/azure/storage/RequestResult;
    //   1123: aload_2
    //   1124: invokevirtual 308	com/microsoft/azure/storage/core/StorageRequest:getCurrentLocation	()Lcom/microsoft/azure/storage/StorageLocation;
    //   1127: aload_2
    //   1128: invokevirtual 312	com/microsoft/azure/storage/core/StorageRequest:getLocationMode	()Lcom/microsoft/azure/storage/LocationMode;
    //   1131: invokespecial 327	com/microsoft/azure/storage/RetryContext:<init>	(ILcom/microsoft/azure/storage/RequestResult;Lcom/microsoft/azure/storage/StorageLocation;Lcom/microsoft/azure/storage/LocationMode;)V
    //   1134: astore 8
    //   1136: aload 9
    //   1138: aload 8
    //   1140: aload_3
    //   1141: invokevirtual 333	com/microsoft/azure/storage/RetryPolicy:evaluate	(Lcom/microsoft/azure/storage/RetryContext;Lcom/microsoft/azure/storage/OperationContext;)Lcom/microsoft/azure/storage/RetryInfo;
    //   1144: astore 15
    //   1146: aload 15
    //   1148: ifnonnull +31 -> 1179
    //   1151: aload 14
    //   1153: ifnonnull +9 -> 1162
    //   1156: aload 12
    //   1158: astore_0
    //   1159: goto +9 -> 1168
    //   1162: aload 14
    //   1164: invokevirtual 293	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1167: astore_0
    //   1168: aload_3
    //   1169: ldc_w 335
    //   1172: aload_0
    //   1173: invokestatic 339	com/microsoft/azure/storage/core/Logger:error	(Lcom/microsoft/azure/storage/OperationContext;Ljava/lang/String;Ljava/lang/Object;)V
    //   1176: aload 14
    //   1178: athrow
    //   1179: aload_2
    //   1180: invokevirtual 97	com/microsoft/azure/storage/core/StorageRequest:getRequestOptions	()Lcom/microsoft/azure/storage/RequestOptions;
    //   1183: invokevirtual 344	com/microsoft/azure/storage/RequestOptions:getOperationExpiryTimeInMs	()Ljava/lang/Long;
    //   1186: aload 15
    //   1188: invokevirtual 349	com/microsoft/azure/storage/RetryInfo:getRetryInterval	()I
    //   1191: i2l
    //   1192: invokestatic 353	com/microsoft/azure/storage/core/Utility:validateMaxExecutionTimeout	(Ljava/lang/Long;J)Z
    //   1195: ifeq +57 -> 1252
    //   1198: new 15	com/microsoft/azure/storage/StorageException
    //   1201: dup
    //   1202: ldc_w 355
    //   1205: ldc_w 357
    //   1208: sipush 306
    //   1211: aconst_null
    //   1212: new 359	java/util/concurrent/TimeoutException
    //   1215: dup
    //   1216: ldc_w 357
    //   1219: invokespecial 361	java/util/concurrent/TimeoutException:<init>	(Ljava/lang/String;)V
    //   1222: invokespecial 364	com/microsoft/azure/storage/StorageException:<init>	(Ljava/lang/String;Ljava/lang/String;ILcom/microsoft/azure/storage/StorageExtendedErrorInformation;Ljava/lang/Exception;)V
    //   1225: astore_0
    //   1226: aload_2
    //   1227: aload_3
    //   1228: invokevirtual 368	com/microsoft/azure/storage/core/StorageRequest:initialize	(Lcom/microsoft/azure/storage/OperationContext;)V
    //   1231: aload_2
    //   1232: invokevirtual 117	com/microsoft/azure/storage/core/StorageRequest:getResult	()Lcom/microsoft/azure/storage/RequestResult;
    //   1235: aload_0
    //   1236: invokevirtual 264	com/microsoft/azure/storage/RequestResult:setException	(Ljava/lang/Exception;)V
    //   1239: aload_3
    //   1240: ldc_w 370
    //   1243: aload_0
    //   1244: invokevirtual 293	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1247: invokestatic 339	com/microsoft/azure/storage/core/Logger:error	(Lcom/microsoft/azure/storage/OperationContext;Ljava/lang/String;Ljava/lang/Object;)V
    //   1250: aload_0
    //   1251: athrow
    //   1252: aload_2
    //   1253: aload 15
    //   1255: invokevirtual 373	com/microsoft/azure/storage/RetryInfo:getTargetLocation	()Lcom/microsoft/azure/storage/StorageLocation;
    //   1258: invokevirtual 320	com/microsoft/azure/storage/core/StorageRequest:setCurrentLocation	(Lcom/microsoft/azure/storage/StorageLocation;)V
    //   1261: aload_2
    //   1262: aload 15
    //   1264: invokevirtual 376	com/microsoft/azure/storage/RetryInfo:getUpdatedLocationMode	()Lcom/microsoft/azure/storage/LocationMode;
    //   1267: invokevirtual 380	com/microsoft/azure/storage/core/StorageRequest:setLocationMode	(Lcom/microsoft/azure/storage/LocationMode;)V
    //   1270: aload_3
    //   1271: ldc_w 382
    //   1274: aload_2
    //   1275: invokevirtual 308	com/microsoft/azure/storage/core/StorageRequest:getCurrentLocation	()Lcom/microsoft/azure/storage/StorageLocation;
    //   1278: aload_2
    //   1279: invokevirtual 312	com/microsoft/azure/storage/core/StorageRequest:getLocationMode	()Lcom/microsoft/azure/storage/LocationMode;
    //   1282: invokestatic 65	com/microsoft/azure/storage/core/Logger:info	(Lcom/microsoft/azure/storage/OperationContext;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   1285: aload_3
    //   1286: aload_2
    //   1287: invokevirtual 386	com/microsoft/azure/storage/core/StorageRequest:getConnection	()Ljava/net/HttpURLConnection;
    //   1290: aload_2
    //   1291: invokevirtual 117	com/microsoft/azure/storage/core/StorageRequest:getResult	()Lcom/microsoft/azure/storage/RequestResult;
    //   1294: aload 8
    //   1296: invokestatic 390	com/microsoft/azure/storage/core/ExecutionEngine:fireRetryingEvent	(Lcom/microsoft/azure/storage/OperationContext;Ljava/net/HttpURLConnection;Lcom/microsoft/azure/storage/RequestResult;Lcom/microsoft/azure/storage/RetryContext;)V
    //   1299: aload_3
    //   1300: ldc_w 392
    //   1303: aload 15
    //   1305: invokevirtual 349	com/microsoft/azure/storage/RetryInfo:getRetryInterval	()I
    //   1308: invokestatic 192	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1311: invokestatic 394	com/microsoft/azure/storage/core/Logger:info	(Lcom/microsoft/azure/storage/OperationContext;Ljava/lang/String;Ljava/lang/Object;)V
    //   1314: aload 15
    //   1316: invokevirtual 349	com/microsoft/azure/storage/RetryInfo:getRetryInterval	()I
    //   1319: i2l
    //   1320: invokestatic 399	java/lang/Thread:sleep	(J)V
    //   1323: goto +11 -> 1334
    //   1326: astore 8
    //   1328: invokestatic 403	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1331: invokevirtual 406	java/lang/Thread:interrupt	()V
    //   1334: iinc 13 1
    //   1337: goto -1253 -> 84
    //   1340: astore_0
    //   1341: aload_3
    //   1342: new 36	java/util/Date
    //   1345: dup
    //   1346: invokespecial 37	java/util/Date:<init>	()V
    //   1349: invokevirtual 41	java/util/Date:getTime	()J
    //   1352: lload 10
    //   1354: lsub
    //   1355: invokevirtual 245	com/microsoft/azure/storage/OperationContext:setClientTimeInMs	(J)V
    //   1358: aload_2
    //   1359: invokevirtual 248	com/microsoft/azure/storage/core/StorageRequest:isSent	()Z
    //   1362: ifeq +13 -> 1375
    //   1365: aload_3
    //   1366: aload 5
    //   1368: aload_2
    //   1369: invokevirtual 117	com/microsoft/azure/storage/core/StorageRequest:getResult	()Lcom/microsoft/azure/storage/RequestResult;
    //   1372: invokestatic 251	com/microsoft/azure/storage/core/ExecutionEngine:fireRequestCompletedEvent	(Lcom/microsoft/azure/storage/OperationContext;Ljava/net/HttpURLConnection;Lcom/microsoft/azure/storage/RequestResult;)V
    //   1375: aload_0
    //   1376: athrow
    //   1377: astore 19
    //   1379: goto -879 -> 500
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1382	0	paramCLIENT_TYPE	CLIENT_TYPE
    //   0	1382	1	paramPARENT_TYPE	PARENT_TYPE
    //   0	1382	2	paramStorageRequest	StorageRequest<CLIENT_TYPE, PARENT_TYPE, RESULT_TYPE>
    //   0	1382	3	paramRetryPolicyFactory	com.microsoft.azure.storage.RetryPolicyFactory
    //   0	1382	4	paramOperationContext	OperationContext
    //   2	442	5	localObject1	Object
    //   508	155	5	localOperationContext	OperationContext
    //   677	1	5	localObject2	Object
    //   685	65	5	localObject3	Object
    //   755	612	5	localObject4	Object
    //   6	690	6	str1	String
    //   10	953	7	str2	String
    //   35	1260	8	localObject5	Object
    //   1326	1	8	localInterruptedException	InterruptedException
    //   54	1083	9	localRetryPolicyFactory	com.microsoft.azure.storage.RetryPolicyFactory
    //   66	1287	10	l	long
    //   69	1088	12	localObject6	Object
    //   75	1260	13	i	int
    //   201	538	14	localObject7	Object
    //   760	1	14	localException1	Exception
    //   774	1	14	localException2	Exception
    //   788	39	14	localException3	Exception
    //   868	309	14	localObject8	Object
    //   206	528	15	localObject9	Object
    //   765	1	15	localStorageException1	StorageException
    //   779	1	15	localStorageException2	StorageException
    //   833	53	15	localStorageException3	StorageException
    //   902	112	15	localStorageException4	StorageException
    //   1144	171	15	localRetryInfo	com.microsoft.azure.storage.RetryInfo
    //   441	408	16	localObject10	Object
    //   628	3	17	bool	boolean
    //   680	390	18	j	int
    //   1377	1	19	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   483	500	508	finally
    //   313	382	677	finally
    //   117	154	685	finally
    //   154	191	685	finally
    //   191	313	685	finally
    //   429	483	752	finally
    //   500	505	752	finally
    //   510	518	752	finally
    //   518	525	752	finally
    //   567	630	752	finally
    //   674	677	752	finally
    //   693	700	752	finally
    //   705	738	752	finally
    //   738	749	752	finally
    //   749	752	752	finally
    //   429	483	760	java/lang/Exception
    //   500	505	760	java/lang/Exception
    //   510	518	760	java/lang/Exception
    //   518	525	760	java/lang/Exception
    //   567	630	760	java/lang/Exception
    //   674	677	760	java/lang/Exception
    //   693	700	760	java/lang/Exception
    //   705	738	760	java/lang/Exception
    //   738	749	760	java/lang/Exception
    //   749	752	760	java/lang/Exception
    //   429	483	765	com/microsoft/azure/storage/StorageException
    //   500	505	765	com/microsoft/azure/storage/StorageException
    //   510	518	765	com/microsoft/azure/storage/StorageException
    //   518	525	765	com/microsoft/azure/storage/StorageException
    //   567	630	765	com/microsoft/azure/storage/StorageException
    //   674	677	765	com/microsoft/azure/storage/StorageException
    //   693	700	765	com/microsoft/azure/storage/StorageException
    //   705	738	765	com/microsoft/azure/storage/StorageException
    //   738	749	765	com/microsoft/azure/storage/StorageException
    //   749	752	765	com/microsoft/azure/storage/StorageException
    //   99	117	770	finally
    //   382	422	770	finally
    //   99	117	774	java/lang/Exception
    //   382	422	774	java/lang/Exception
    //   99	117	779	com/microsoft/azure/storage/StorageException
    //   382	422	779	com/microsoft/azure/storage/StorageException
    //   84	95	784	finally
    //   84	95	788	java/lang/Exception
    //   84	95	902	com/microsoft/azure/storage/StorageException
    //   1285	1323	1326	java/lang/InterruptedException
    //   801	821	1340	finally
    //   825	835	1340	finally
    //   839	848	1340	finally
    //   915	927	1340	finally
    //   931	943	1340	finally
    //   947	956	1340	finally
    //   960	980	1340	finally
    //   483	500	1377	java/io/IOException
    //   483	500	1377	com/microsoft/azure/storage/StorageException
  }
  
  public static void fireErrorReceivingResponseEvent(OperationContext paramOperationContext, HttpURLConnection paramHttpURLConnection, RequestResult paramRequestResult)
  {
    if ((paramOperationContext.getErrorReceivingResponseEventHandler().hasListeners()) || (OperationContext.getGlobalErrorReceivingResponseEventHandler().hasListeners()))
    {
      paramHttpURLConnection = new ErrorReceivingResponseEvent(paramOperationContext, paramHttpURLConnection, paramRequestResult);
      paramOperationContext.getErrorReceivingResponseEventHandler().fireEvent(paramHttpURLConnection);
      OperationContext.getGlobalErrorReceivingResponseEventHandler().fireEvent(paramHttpURLConnection);
    }
  }
  
  public static void fireRequestCompletedEvent(OperationContext paramOperationContext, HttpURLConnection paramHttpURLConnection, RequestResult paramRequestResult)
  {
    if ((paramOperationContext.getRequestCompletedEventHandler().hasListeners()) || (OperationContext.getGlobalRequestCompletedEventHandler().hasListeners()))
    {
      paramHttpURLConnection = new RequestCompletedEvent(paramOperationContext, paramHttpURLConnection, paramRequestResult);
      paramOperationContext.getRequestCompletedEventHandler().fireEvent(paramHttpURLConnection);
      OperationContext.getGlobalRequestCompletedEventHandler().fireEvent(paramHttpURLConnection);
    }
  }
  
  public static void fireResponseReceivedEvent(OperationContext paramOperationContext, HttpURLConnection paramHttpURLConnection, RequestResult paramRequestResult)
  {
    if ((paramOperationContext.getResponseReceivedEventHandler().hasListeners()) || (OperationContext.getGlobalResponseReceivedEventHandler().hasListeners()))
    {
      paramHttpURLConnection = new ResponseReceivedEvent(paramOperationContext, paramHttpURLConnection, paramRequestResult);
      paramOperationContext.getResponseReceivedEventHandler().fireEvent(paramHttpURLConnection);
      OperationContext.getGlobalResponseReceivedEventHandler().fireEvent(paramHttpURLConnection);
    }
  }
  
  public static void fireRetryingEvent(OperationContext paramOperationContext, HttpURLConnection paramHttpURLConnection, RequestResult paramRequestResult, RetryContext paramRetryContext)
  {
    if ((paramOperationContext.getRetryingEventHandler().hasListeners()) || (OperationContext.getGlobalRetryingEventHandler().hasListeners()))
    {
      paramHttpURLConnection = new RetryingEvent(paramOperationContext, paramHttpURLConnection, paramRequestResult, paramRetryContext);
      paramOperationContext.getRetryingEventHandler().fireEvent(paramHttpURLConnection);
      OperationContext.getGlobalRetryingEventHandler().fireEvent(paramHttpURLConnection);
    }
  }
  
  public static void fireSendingRequestEvent(OperationContext paramOperationContext, HttpURLConnection paramHttpURLConnection, RequestResult paramRequestResult)
  {
    if ((paramOperationContext.getSendingRequestEventHandler().hasListeners()) || (OperationContext.getGlobalSendingRequestEventHandler().hasListeners()))
    {
      paramHttpURLConnection = new SendingRequestEvent(paramOperationContext, paramHttpURLConnection, paramRequestResult);
      paramOperationContext.getSendingRequestEventHandler().fireEvent(paramHttpURLConnection);
      OperationContext.getGlobalSendingRequestEventHandler().fireEvent(paramHttpURLConnection);
    }
  }
  
  public static StorageLocation getNextLocation(StorageLocation paramStorageLocation, LocationMode paramLocationMode)
  {
    int i = paramLocationMode.ordinal();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return StorageLocation.PRIMARY;
          }
        }
        else {
          return StorageLocation.SECONDARY;
        }
      }
      StorageLocation localStorageLocation = StorageLocation.PRIMARY;
      paramLocationMode = localStorageLocation;
      if (paramStorageLocation == localStorageLocation) {
        paramLocationMode = StorageLocation.SECONDARY;
      }
      return paramLocationMode;
    }
    return StorageLocation.PRIMARY;
  }
  
  public static <CLIENT_TYPE, PARENT_TYPE, RESULT_TYPE> HttpURLConnection setupStorageRequest(CLIENT_TYPE paramCLIENT_TYPE, PARENT_TYPE paramPARENT_TYPE, StorageRequest<CLIENT_TYPE, PARENT_TYPE, RESULT_TYPE> paramStorageRequest, int paramInt, OperationContext paramOperationContext)
  {
    try
    {
      paramStorageRequest.initialize(paramOperationContext);
      if (!Utility.validateMaxExecutionTimeout(paramStorageRequest.getRequestOptions().getOperationExpiryTimeInMs()))
      {
        if (paramInt > 0)
        {
          paramStorageRequest.recoveryAction(paramOperationContext);
          Logger.info(paramOperationContext, "Retrying failed operation.");
        }
        else
        {
          paramStorageRequest.applyLocationModeToRequest();
          paramStorageRequest.initializeLocation();
          Logger.info(paramOperationContext, "Starting operation.");
        }
        paramStorageRequest.setRequestLocationMode();
        paramStorageRequest.validateLocation();
        Logger.info(paramOperationContext, "Starting operation with location '%s' per location mode '%s'.", paramStorageRequest.getCurrentLocation(), paramStorageRequest.getLocationMode());
        HttpURLConnection localHttpURLConnection = paramStorageRequest.buildRequest(paramCLIENT_TYPE, paramPARENT_TYPE, paramOperationContext);
        paramStorageRequest.setHeaders(localHttpURLConnection, paramPARENT_TYPE, paramOperationContext);
        if (paramOperationContext.getUserHeaders() != null)
        {
          Iterator localIterator = paramOperationContext.getUserHeaders().entrySet().iterator();
          while (localIterator.hasNext())
          {
            paramPARENT_TYPE = (Map.Entry)localIterator.next();
            localHttpURLConnection.setRequestProperty((String)paramPARENT_TYPE.getKey(), (String)paramPARENT_TYPE.getValue());
          }
        }
        fireSendingRequestEvent(paramOperationContext, localHttpURLConnection, paramStorageRequest.getResult());
        paramStorageRequest.setIsSent(true);
        paramStorageRequest.signRequest(localHttpURLConnection, paramCLIENT_TYPE, paramOperationContext);
        paramStorageRequest.setConnection(localHttpURLConnection);
        return localHttpURLConnection;
      }
      paramPARENT_TYPE = new java/util/concurrent/TimeoutException;
      paramPARENT_TYPE.<init>("The client could not finish the operation within specified maximum execution timeout.");
      paramCLIENT_TYPE = new com/microsoft/azure/storage/StorageException;
      paramCLIENT_TYPE.<init>("OperationTimedOut", "The client could not finish the operation within specified maximum execution timeout.", 306, null, paramPARENT_TYPE);
      throw paramCLIENT_TYPE;
    }
    catch (Exception paramCLIENT_TYPE)
    {
      throw new StorageException(null, paramCLIENT_TYPE.getMessage(), 306, null, paramCLIENT_TYPE);
    }
    catch (StorageException paramCLIENT_TYPE)
    {
      throw paramCLIENT_TYPE;
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.core.ExecutionEngine
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */