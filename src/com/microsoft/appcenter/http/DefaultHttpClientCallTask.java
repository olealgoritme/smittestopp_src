package com.microsoft.appcenter.http;

import android.os.AsyncTask;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Map;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;

public class DefaultHttpClientCallTask
  extends AsyncTask<Void, Void, Object>
{
  public static final int DEFAULT_STRING_BUILDER_CAPACITY = 16;
  public static final int MAX_PRETTIFY_LOG_LENGTH = 4096;
  public static final int MIN_GZIP_LENGTH = 1400;
  public static final Pattern REDIRECT_URI_REGEX_JSON = Pattern.compile("redirect_uri\":\"[^\"]+\"");
  public static final Pattern TOKEN_REGEX_JSON;
  public static final Pattern TOKEN_REGEX_URL_ENCODED = Pattern.compile("token=[^&]+");
  public final HttpClient.CallTemplate mCallTemplate;
  public final boolean mCompressionEnabled;
  public final Map<String, String> mHeaders;
  public final String mMethod;
  public final ServiceCallback mServiceCallback;
  public final DefaultHttpClientCallTask.Tracker mTracker;
  public final String mUrl;
  
  static
  {
    TOKEN_REGEX_JSON = Pattern.compile("token\":\"[^\"]+\"");
  }
  
  public DefaultHttpClientCallTask(String paramString1, String paramString2, Map<String, String> paramMap, HttpClient.CallTemplate paramCallTemplate, ServiceCallback paramServiceCallback, DefaultHttpClientCallTask.Tracker paramTracker, boolean paramBoolean)
  {
    mUrl = paramString1;
    mMethod = paramString2;
    mHeaders = paramMap;
    mCallTemplate = paramCallTemplate;
    mServiceCallback = paramServiceCallback;
    mTracker = paramTracker;
    mCompressionEnabled = paramBoolean;
  }
  
  /* Error */
  private HttpResponse doHttpCall()
  {
    // Byte code:
    //   0: new 78	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: getfield 60	com/microsoft/appcenter/http/DefaultHttpClientCallTask:mUrl	Ljava/lang/String;
    //   8: invokespecial 81	java/net/URL:<init>	(Ljava/lang/String;)V
    //   11: astore_1
    //   12: aload_1
    //   13: invokestatic 87	com/microsoft/appcenter/http/HttpUtils:createHttpsConnection	(Ljava/net/URL;)Ljavax/net/ssl/HttpsURLConnection;
    //   16: astore_2
    //   17: aload_2
    //   18: aload_0
    //   19: getfield 62	com/microsoft/appcenter/http/DefaultHttpClientCallTask:mMethod	Ljava/lang/String;
    //   22: invokevirtual 92	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: getfield 62	com/microsoft/appcenter/http/DefaultHttpClientCallTask:mMethod	Ljava/lang/String;
    //   29: ldc 94
    //   31: invokevirtual 100	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: istore_3
    //   35: iconst_0
    //   36: istore 4
    //   38: iconst_0
    //   39: istore 5
    //   41: iload_3
    //   42: ifeq +112 -> 154
    //   45: aload_0
    //   46: getfield 66	com/microsoft/appcenter/http/DefaultHttpClientCallTask:mCallTemplate	Lcom/microsoft/appcenter/http/HttpClient$CallTemplate;
    //   49: ifnull +105 -> 154
    //   52: aload_0
    //   53: getfield 66	com/microsoft/appcenter/http/DefaultHttpClientCallTask:mCallTemplate	Lcom/microsoft/appcenter/http/HttpClient$CallTemplate;
    //   56: invokeinterface 106 1 0
    //   61: astore 6
    //   63: aload 6
    //   65: ldc 108
    //   67: invokevirtual 112	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   70: astore 7
    //   72: iload 5
    //   74: istore 4
    //   76: aload_0
    //   77: getfield 72	com/microsoft/appcenter/http/DefaultHttpClientCallTask:mCompressionEnabled	Z
    //   80: ifeq +19 -> 99
    //   83: iload 5
    //   85: istore 4
    //   87: aload 7
    //   89: arraylength
    //   90: sipush 1400
    //   93: if_icmplt +6 -> 99
    //   96: iconst_1
    //   97: istore 4
    //   99: aload 6
    //   101: astore 8
    //   103: iload 4
    //   105: istore 5
    //   107: aload 7
    //   109: astore 9
    //   111: aload_0
    //   112: getfield 64	com/microsoft/appcenter/http/DefaultHttpClientCallTask:mHeaders	Ljava/util/Map;
    //   115: ldc 114
    //   117: invokeinterface 119 2 0
    //   122: ifne +43 -> 165
    //   125: aload_0
    //   126: getfield 64	com/microsoft/appcenter/http/DefaultHttpClientCallTask:mHeaders	Ljava/util/Map;
    //   129: ldc 114
    //   131: ldc 121
    //   133: invokeinterface 125 3 0
    //   138: pop
    //   139: aload 6
    //   141: astore 8
    //   143: iload 4
    //   145: istore 5
    //   147: aload 7
    //   149: astore 9
    //   151: goto +14 -> 165
    //   154: aconst_null
    //   155: astore 8
    //   157: aload 8
    //   159: astore 9
    //   161: iload 4
    //   163: istore 5
    //   165: iload 5
    //   167: ifeq +17 -> 184
    //   170: aload_0
    //   171: getfield 64	com/microsoft/appcenter/http/DefaultHttpClientCallTask:mHeaders	Ljava/util/Map;
    //   174: ldc 127
    //   176: ldc -127
    //   178: invokeinterface 125 3 0
    //   183: pop
    //   184: aload_0
    //   185: getfield 64	com/microsoft/appcenter/http/DefaultHttpClientCallTask:mHeaders	Ljava/util/Map;
    //   188: invokeinterface 133 1 0
    //   193: invokeinterface 139 1 0
    //   198: astore 6
    //   200: aload 6
    //   202: invokeinterface 145 1 0
    //   207: ifeq +42 -> 249
    //   210: aload 6
    //   212: invokeinterface 149 1 0
    //   217: checkcast 151	java/util/Map$Entry
    //   220: astore 7
    //   222: aload_2
    //   223: aload 7
    //   225: invokeinterface 154 1 0
    //   230: checkcast 96	java/lang/String
    //   233: aload 7
    //   235: invokeinterface 157 1 0
    //   240: checkcast 96	java/lang/String
    //   243: invokevirtual 161	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   246: goto -46 -> 200
    //   249: aload_0
    //   250: invokevirtual 164	android/os/AsyncTask:isCancelled	()Z
    //   253: istore_3
    //   254: iload_3
    //   255: ifeq +9 -> 264
    //   258: aload_2
    //   259: invokevirtual 167	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   262: aconst_null
    //   263: areturn
    //   264: aload_0
    //   265: getfield 66	com/microsoft/appcenter/http/DefaultHttpClientCallTask:mCallTemplate	Lcom/microsoft/appcenter/http/HttpClient$CallTemplate;
    //   268: ifnull +17 -> 285
    //   271: aload_0
    //   272: getfield 66	com/microsoft/appcenter/http/DefaultHttpClientCallTask:mCallTemplate	Lcom/microsoft/appcenter/http/HttpClient$CallTemplate;
    //   275: aload_1
    //   276: aload_0
    //   277: getfield 64	com/microsoft/appcenter/http/DefaultHttpClientCallTask:mHeaders	Ljava/util/Map;
    //   280: invokeinterface 171 3 0
    //   285: aload 9
    //   287: ifnull +187 -> 474
    //   290: invokestatic 177	com/microsoft/appcenter/utils/AppCenterLog:getLogLevel	()I
    //   293: iconst_2
    //   294: if_icmpgt +83 -> 377
    //   297: aload 8
    //   299: astore 7
    //   301: aload 8
    //   303: invokevirtual 180	java/lang/String:length	()I
    //   306: sipush 4096
    //   309: if_icmpge +61 -> 370
    //   312: getstatic 45	com/microsoft/appcenter/http/DefaultHttpClientCallTask:TOKEN_REGEX_URL_ENCODED	Ljava/util/regex/Pattern;
    //   315: aload 8
    //   317: invokevirtual 184	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   320: ldc -70
    //   322: invokevirtual 192	java/util/regex/Matcher:replaceAll	(Ljava/lang/String;)Ljava/lang/String;
    //   325: astore 8
    //   327: aload 8
    //   329: astore 7
    //   331: ldc 121
    //   333: aload_0
    //   334: getfield 64	com/microsoft/appcenter/http/DefaultHttpClientCallTask:mHeaders	Ljava/util/Map;
    //   337: ldc 114
    //   339: invokeinterface 196 2 0
    //   344: invokevirtual 100	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   347: ifeq +23 -> 370
    //   350: new 198	org/json/JSONObject
    //   353: astore 7
    //   355: aload 7
    //   357: aload 8
    //   359: invokespecial 199	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   362: aload 7
    //   364: iconst_2
    //   365: invokevirtual 203	org/json/JSONObject:toString	(I)Ljava/lang/String;
    //   368: astore 7
    //   370: ldc -51
    //   372: aload 7
    //   374: invokestatic 208	com/microsoft/appcenter/utils/AppCenterLog:verbose	(Ljava/lang/String;Ljava/lang/String;)V
    //   377: aload 9
    //   379: astore 8
    //   381: iload 5
    //   383: ifeq +47 -> 430
    //   386: new 210	java/io/ByteArrayOutputStream
    //   389: astore 8
    //   391: aload 8
    //   393: aload 9
    //   395: arraylength
    //   396: invokespecial 213	java/io/ByteArrayOutputStream:<init>	(I)V
    //   399: new 215	java/util/zip/GZIPOutputStream
    //   402: astore 7
    //   404: aload 7
    //   406: aload 8
    //   408: invokespecial 218	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   411: aload 7
    //   413: aload 9
    //   415: invokevirtual 222	java/util/zip/GZIPOutputStream:write	([B)V
    //   418: aload 7
    //   420: invokevirtual 225	java/util/zip/GZIPOutputStream:close	()V
    //   423: aload 8
    //   425: invokevirtual 229	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   428: astore 8
    //   430: aload_2
    //   431: iconst_1
    //   432: invokevirtual 233	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   435: aload_2
    //   436: aload 8
    //   438: arraylength
    //   439: invokevirtual 236	javax/net/ssl/HttpsURLConnection:setFixedLengthStreamingMode	(I)V
    //   442: aload_2
    //   443: invokevirtual 240	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   446: astore 9
    //   448: aload_0
    //   449: aload 9
    //   451: aload 8
    //   453: invokespecial 244	com/microsoft/appcenter/http/DefaultHttpClientCallTask:writePayload	(Ljava/io/OutputStream;[B)V
    //   456: aload 9
    //   458: invokevirtual 247	java/io/OutputStream:close	()V
    //   461: goto +13 -> 474
    //   464: astore 8
    //   466: aload 9
    //   468: invokevirtual 247	java/io/OutputStream:close	()V
    //   471: aload 8
    //   473: athrow
    //   474: aload_0
    //   475: invokevirtual 164	android/os/AsyncTask:isCancelled	()Z
    //   478: istore_3
    //   479: iload_3
    //   480: ifeq +9 -> 489
    //   483: aload_2
    //   484: invokevirtual 167	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   487: aconst_null
    //   488: areturn
    //   489: aload_2
    //   490: invokevirtual 250	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   493: istore 4
    //   495: aload_0
    //   496: aload_2
    //   497: invokespecial 254	com/microsoft/appcenter/http/DefaultHttpClientCallTask:readResponse	(Ljavax/net/ssl/HttpsURLConnection;)Ljava/lang/String;
    //   500: astore 8
    //   502: invokestatic 177	com/microsoft/appcenter/utils/AppCenterLog:getLogLevel	()I
    //   505: iconst_2
    //   506: if_icmpgt +135 -> 641
    //   509: aload_2
    //   510: ldc 114
    //   512: invokevirtual 257	javax/net/ssl/HttpsURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   515: astore 9
    //   517: aload 9
    //   519: ifnull +36 -> 555
    //   522: aload 9
    //   524: ldc_w 259
    //   527: invokevirtual 263	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   530: ifne +25 -> 555
    //   533: aload 9
    //   535: ldc_w 265
    //   538: invokevirtual 263	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   541: ifeq +6 -> 547
    //   544: goto +11 -> 555
    //   547: ldc_w 267
    //   550: astore 9
    //   552: goto +35 -> 587
    //   555: getstatic 49	com/microsoft/appcenter/http/DefaultHttpClientCallTask:TOKEN_REGEX_JSON	Ljava/util/regex/Pattern;
    //   558: aload 8
    //   560: invokevirtual 184	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   563: ldc_w 269
    //   566: invokevirtual 192	java/util/regex/Matcher:replaceAll	(Ljava/lang/String;)Ljava/lang/String;
    //   569: astore 9
    //   571: getstatic 53	com/microsoft/appcenter/http/DefaultHttpClientCallTask:REDIRECT_URI_REGEX_JSON	Ljava/util/regex/Pattern;
    //   574: aload 9
    //   576: invokevirtual 184	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   579: ldc_w 271
    //   582: invokevirtual 192	java/util/regex/Matcher:replaceAll	(Ljava/lang/String;)Ljava/lang/String;
    //   585: astore 9
    //   587: new 273	java/lang/StringBuilder
    //   590: astore 7
    //   592: aload 7
    //   594: invokespecial 274	java/lang/StringBuilder:<init>	()V
    //   597: aload 7
    //   599: ldc_w 276
    //   602: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: pop
    //   606: aload 7
    //   608: iload 4
    //   610: invokevirtual 283	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   613: pop
    //   614: aload 7
    //   616: ldc_w 285
    //   619: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: pop
    //   623: aload 7
    //   625: aload 9
    //   627: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: pop
    //   631: ldc -51
    //   633: aload 7
    //   635: invokevirtual 287	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: invokestatic 208	com/microsoft/appcenter/utils/AppCenterLog:verbose	(Ljava/lang/String;Ljava/lang/String;)V
    //   641: new 289	java/util/HashMap
    //   644: astore 9
    //   646: aload 9
    //   648: invokespecial 290	java/util/HashMap:<init>	()V
    //   651: aload_2
    //   652: invokevirtual 294	javax/net/ssl/HttpsURLConnection:getHeaderFields	()Ljava/util/Map;
    //   655: invokeinterface 133 1 0
    //   660: invokeinterface 139 1 0
    //   665: astore 7
    //   667: aload 7
    //   669: invokeinterface 145 1 0
    //   674: ifeq +51 -> 725
    //   677: aload 7
    //   679: invokeinterface 149 1 0
    //   684: checkcast 151	java/util/Map$Entry
    //   687: astore 6
    //   689: aload 9
    //   691: aload 6
    //   693: invokeinterface 154 1 0
    //   698: aload 6
    //   700: invokeinterface 157 1 0
    //   705: checkcast 296	java/util/List
    //   708: invokeinterface 297 1 0
    //   713: invokeinterface 149 1 0
    //   718: invokevirtual 298	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   721: pop
    //   722: goto -55 -> 667
    //   725: new 300	com/microsoft/appcenter/http/HttpResponse
    //   728: astore 7
    //   730: aload 7
    //   732: iload 4
    //   734: aload 8
    //   736: aload 9
    //   738: invokespecial 303	com/microsoft/appcenter/http/HttpResponse:<init>	(ILjava/lang/String;Ljava/util/Map;)V
    //   741: iload 4
    //   743: sipush 200
    //   746: if_icmplt +18 -> 764
    //   749: iload 4
    //   751: sipush 300
    //   754: if_icmpge +10 -> 764
    //   757: aload_2
    //   758: invokevirtual 167	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   761: aload 7
    //   763: areturn
    //   764: new 305	com/microsoft/appcenter/http/HttpException
    //   767: astore 9
    //   769: aload 9
    //   771: aload 7
    //   773: invokespecial 308	com/microsoft/appcenter/http/HttpException:<init>	(Lcom/microsoft/appcenter/http/HttpResponse;)V
    //   776: aload 9
    //   778: athrow
    //   779: astore 9
    //   781: aload_2
    //   782: invokevirtual 167	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   785: aload 9
    //   787: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	788	0	this	DefaultHttpClientCallTask
    //   11	265	1	localURL	java.net.URL
    //   16	766	2	localHttpsURLConnection	HttpsURLConnection
    //   34	446	3	bool	boolean
    //   36	719	4	i	int
    //   39	343	5	j	int
    //   61	638	6	localObject1	Object
    //   70	702	7	localObject2	Object
    //   101	351	8	localObject3	Object
    //   464	8	8	localObject4	Object
    //   500	235	8	str	String
    //   109	668	9	localObject5	Object
    //   779	7	9	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   448	456	464	finally
    //   17	35	779	finally
    //   45	72	779	finally
    //   76	83	779	finally
    //   87	96	779	finally
    //   111	139	779	finally
    //   170	184	779	finally
    //   184	200	779	finally
    //   200	246	779	finally
    //   249	254	779	finally
    //   264	285	779	finally
    //   290	297	779	finally
    //   301	327	779	finally
    //   331	370	779	finally
    //   370	377	779	finally
    //   386	430	779	finally
    //   430	448	779	finally
    //   456	461	779	finally
    //   466	474	779	finally
    //   474	479	779	finally
    //   489	517	779	finally
    //   522	544	779	finally
    //   555	587	779	finally
    //   587	641	779	finally
    //   641	667	779	finally
    //   667	722	779	finally
    //   725	741	779	finally
    //   764	779	779	finally
  }
  
  public static InputStream getInputStream(HttpsURLConnection paramHttpsURLConnection)
  {
    int i = paramHttpsURLConnection.getResponseCode();
    if ((i >= 200) && (i < 400)) {
      return paramHttpsURLConnection.getInputStream();
    }
    return paramHttpsURLConnection.getErrorStream();
  }
  
  private String readResponse(HttpsURLConnection paramHttpsURLConnection)
  {
    Object localObject1 = new StringBuilder(Math.max(paramHttpsURLConnection.getContentLength(), 16));
    paramHttpsURLConnection = getInputStream(paramHttpsURLConnection);
    try
    {
      InputStreamReader localInputStreamReader = new java/io/InputStreamReader;
      localInputStreamReader.<init>(paramHttpsURLConnection, "UTF-8");
      char[] arrayOfChar = new char['Ѐ'];
      do
      {
        int i = localInputStreamReader.read(arrayOfChar);
        if (i <= 0) {
          break;
        }
        ((StringBuilder)localObject1).append(arrayOfChar, 0, i);
      } while (!isCancelled());
      localObject1 = ((StringBuilder)localObject1).toString();
      return (String)localObject1;
    }
    finally
    {
      paramHttpsURLConnection.close();
    }
  }
  
  private void writePayload(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    for (int i = 0; i < paramArrayOfByte.length; i += 1024)
    {
      paramOutputStream.write(paramArrayOfByte, i, Math.min(paramArrayOfByte.length - i, 1024));
      if (isCancelled()) {
        break;
      }
    }
  }
  
  /* Error */
  public Object doInBackground(Void... paramVarArgs)
  {
    // Byte code:
    //   0: ldc_w 361
    //   3: invokestatic 366	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   6: aload_0
    //   7: invokespecial 368	com/microsoft/appcenter/http/DefaultHttpClientCallTask:doHttpCall	()Lcom/microsoft/appcenter/http/HttpResponse;
    //   10: astore_1
    //   11: invokestatic 371	android/net/TrafficStats:clearThreadStatsTag	()V
    //   14: aload_1
    //   15: areturn
    //   16: astore_1
    //   17: invokestatic 371	android/net/TrafficStats:clearThreadStatsTag	()V
    //   20: aload_1
    //   21: athrow
    //   22: astore_1
    //   23: invokestatic 371	android/net/TrafficStats:clearThreadStatsTag	()V
    //   26: aload_1
    //   27: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	DefaultHttpClientCallTask
    //   0	28	1	paramVarArgs	Void[]
    // Exception table:
    //   from	to	target	type
    //   6	11	16	finally
    //   6	11	22	java/lang/Exception
  }
  
  public void onCancelled(Object paramObject)
  {
    if ((!(paramObject instanceof HttpResponse)) && (!(paramObject instanceof HttpException))) {
      mTracker.onFinish(this);
    } else {
      onPostExecute(paramObject);
    }
  }
  
  public void onPostExecute(Object paramObject)
  {
    mTracker.onFinish(this);
    if ((paramObject instanceof Exception))
    {
      mServiceCallback.onCallFailed((Exception)paramObject);
    }
    else
    {
      paramObject = (HttpResponse)paramObject;
      mServiceCallback.onCallSucceeded((HttpResponse)paramObject);
    }
  }
  
  public void onPreExecute()
  {
    mTracker.onStart(this);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.http.DefaultHttpClientCallTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */