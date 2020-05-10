package com.microsoft.appcenter.http;

import android.os.Handler;
import android.os.Looper;
import com.microsoft.appcenter.utils.AppCenterLog;
import e.a.a.a.a;
import java.net.UnknownHostException;
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
    paramString1 = new RetryableCall(mDecoratedApi, paramString1, paramString2, paramMap, paramCallTemplate, paramServiceCallback);
    paramString1.run();
    return paramString1;
  }
  
  public class RetryableCall
    extends HttpClientCallDecorator
  {
    public int mRetryCount;
    
    public RetryableCall(String paramString1, String paramString2, Map<String, String> paramMap, HttpClient.CallTemplate paramCallTemplate, ServiceCallback paramServiceCallback)
    {
      super(paramString2, paramMap, paramCallTemplate, paramServiceCallback, localServiceCallback);
    }
    
    public void cancel()
    {
      try
      {
        HttpClientRetryer.access$000(HttpClientRetryer.this).removeCallbacks(this);
        super.cancel();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void onCallFailed(Exception paramException)
    {
      if ((mRetryCount < HttpClientRetryer.RETRY_INTERVALS.length) && (HttpUtils.isRecoverableError(paramException)))
      {
        if ((paramException instanceof HttpException))
        {
          localObject = (String)((HttpException)paramException).getHttpResponse().getHeaders().get("x-ms-retry-after-ms");
          if (localObject != null)
          {
            l1 = Long.parseLong((String)localObject);
            break label60;
          }
        }
        long l1 = 0L;
        label60:
        long l2 = l1;
        if (l1 == 0L)
        {
          localObject = HttpClientRetryer.RETRY_INTERVALS;
          int i = mRetryCount;
          mRetryCount = (i + 1);
          l1 = localObject[i] / 2L;
          l2 = HttpClientRetryer.access$100(HttpClientRetryer.this).nextInt((int)l1) + l1;
        }
        Object localObject = a.a("Try #");
        ((StringBuilder)localObject).append(mRetryCount);
        ((StringBuilder)localObject).append(" failed and will be retried in ");
        ((StringBuilder)localObject).append(l2);
        ((StringBuilder)localObject).append(" ms");
        String str = ((StringBuilder)localObject).toString();
        localObject = str;
        if ((paramException instanceof UnknownHostException)) {
          localObject = a.b(str, " (UnknownHostException)");
        }
        AppCenterLog.warn("AppCenter", (String)localObject, paramException);
        HttpClientRetryer.access$000(HttpClientRetryer.this).postDelayed(this, l2);
      }
      else
      {
        mServiceCallback.onCallFailed(paramException);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.http.HttpClientRetryer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */