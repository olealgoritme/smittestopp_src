package com.microsoft.appcenter.http;

import android.content.Context;
import android.os.Build.VERSION;
import com.microsoft.appcenter.utils.NetworkStateHelper;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;

public class HttpUtils
{
  public static final Pattern API_KEY_PATTERN = Pattern.compile("-[^,]+(,|$)");
  public static final Pattern CONNECTION_ISSUE_PATTERN;
  public static final int CONNECT_TIMEOUT = 10000;
  public static final int MAX_CHARACTERS_DISPLAYED_FOR_SECRET = 8;
  public static final int READ_BUFFER_SIZE = 1024;
  public static final int READ_TIMEOUT = 10000;
  public static final Class[] RECOVERABLE_EXCEPTIONS = { EOFException.class, InterruptedIOException.class, SocketException.class, UnknownHostException.class, RejectedExecutionException.class };
  public static final int THREAD_STATS_TAG = -667034599;
  public static final Pattern TOKEN_VALUE_PATTERN;
  public static final int WRITE_BUFFER_SIZE = 1024;
  
  static
  {
    CONNECTION_ISSUE_PATTERN = Pattern.compile("connection (time|reset|abort)|failure in ssl library, usually a protocol error|anchor for certification path not found");
    TOKEN_VALUE_PATTERN = Pattern.compile(":[^\"]+");
  }
  
  public static HttpClient createHttpClient(Context paramContext)
  {
    return createHttpClient(paramContext, true);
  }
  
  public static HttpClient createHttpClient(Context paramContext, boolean paramBoolean)
  {
    return new HttpClientRetryer(createHttpClientWithoutRetryer(paramContext, paramBoolean));
  }
  
  public static HttpClient createHttpClientWithoutRetryer(Context paramContext, boolean paramBoolean)
  {
    return new HttpClientNetworkStateHandler(new DefaultHttpClient(paramBoolean), NetworkStateHelper.getSharedInstance(paramContext));
  }
  
  public static HttpsURLConnection createHttpsConnection(URL paramURL)
  {
    if ("https".equals(paramURL.getProtocol()))
    {
      paramURL = paramURL.openConnection();
      if ((paramURL instanceof HttpsURLConnection))
      {
        paramURL = (HttpsURLConnection)paramURL;
        if (Build.VERSION.SDK_INT <= 21) {
          paramURL.setSSLSocketFactory(new TLS1_2SocketFactory());
        }
        paramURL.setConnectTimeout(10000);
        paramURL.setReadTimeout(10000);
        return paramURL;
      }
      throw new IOException("App Center supports only HTTPS connection.");
    }
    throw new IOException("App Center support only HTTPS connection.");
  }
  
  public static String hideApiKeys(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Matcher localMatcher = API_KEY_PATTERN.matcher(paramString);
    for (int i = 0; localMatcher.find(); i = localMatcher.end())
    {
      localStringBuilder.append(paramString.substring(i, localMatcher.start()));
      localStringBuilder.append("-***");
      localStringBuilder.append(localMatcher.group(1));
    }
    if (i < paramString.length()) {
      localStringBuilder.append(paramString.substring(i));
    }
    return localStringBuilder.toString();
  }
  
  public static String hideSecret(String paramString)
  {
    int i = paramString.length();
    int j = paramString.length();
    int k = 8;
    if (j < 8) {
      k = 0;
    }
    k = i - k;
    char[] arrayOfChar = new char[k];
    Arrays.fill(arrayOfChar, '*');
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(new String(arrayOfChar));
    localStringBuilder.append(paramString.substring(k));
    return localStringBuilder.toString();
  }
  
  public static String hideTickets(String paramString)
  {
    return TOKEN_VALUE_PATTERN.matcher(paramString).replaceAll(":***");
  }
  
  public static boolean isRecoverableError(Throwable paramThrowable)
  {
    boolean bool1 = paramThrowable instanceof HttpException;
    boolean bool2 = false;
    if (bool1)
    {
      i = ((HttpException)paramThrowable).getHttpResponse().getStatusCode();
      if ((i >= 500) || (i == 408) || (i == 429)) {
        bool2 = true;
      }
      return bool2;
    }
    Class[] arrayOfClass = RECOVERABLE_EXCEPTIONS;
    int j = arrayOfClass.length;
    for (int i = 0; i < j; i++) {
      if (arrayOfClass[i].isAssignableFrom(paramThrowable.getClass())) {
        return true;
      }
    }
    Throwable localThrowable = paramThrowable.getCause();
    if (localThrowable != null)
    {
      arrayOfClass = RECOVERABLE_EXCEPTIONS;
      j = arrayOfClass.length;
      for (i = 0; i < j; i++) {
        if (arrayOfClass[i].isAssignableFrom(localThrowable.getClass())) {
          return true;
        }
      }
    }
    if ((paramThrowable instanceof SSLException))
    {
      paramThrowable = paramThrowable.getMessage();
      if ((paramThrowable != null) && (CONNECTION_ISSUE_PATTERN.matcher(paramThrowable.toLowerCase(Locale.US)).find())) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.http.HttpUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */