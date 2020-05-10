package com.microsoft.appcenter.http;

import android.os.Handler;
import android.os.Looper;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HttpClientRetryer
  extends HttpClientDecorator
{
  public static final long[] RETRY_INTERVALS = { TimeUnit.SECONDS.toMillis(10L), TimeUnit.MINUTES.toMillis(5L), TimeUnit.MINUTES.toMillis(20L) };
  public final Handler mHandler;
  public final Random mRandom = new Random();
  
  public HttpClientRetryer(HttpClient paramHttpClient)
  {
    this(paramHttpClient, new Handler(Looper.getMainLooper()));
  }
  
  public HttpClientRetryer(HttpClient paramHttpClient, Handler paramHandler)
  {
    super(paramHttpClient);
    mHandler = paramHandler;
  }
  
  public ServiceCall callAsync(String paramString1, String paramString2, Map<String, String> paramMap, HttpClient.CallTemplate paramCallTemplate, ServiceCallback paramServiceCallback)
  {
    paramString1 = new HttpClientRetryer.RetryableCall(this, mDecoratedApi, paramString1, paramString2, paramMap, paramCallTemplate, paramServiceCallback);
    paramString1.run();
    return paramString1;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.http.HttpClientRetryer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */