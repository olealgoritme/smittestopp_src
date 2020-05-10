package com.microsoft.appcenter.http;

import android.os.AsyncTask;
import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.HandlerUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;

public class DefaultHttpClient
  implements HttpClient, DefaultHttpClientCallTask.Tracker
{
  public static final String CHARSET_NAME = "UTF-8";
  public static final String CONTENT_ENCODING_KEY = "Content-Encoding";
  public static final String CONTENT_ENCODING_VALUE = "gzip";
  public static final String CONTENT_TYPE_KEY = "Content-Type";
  public static final String CONTENT_TYPE_VALUE = "application/json";
  public static final String METHOD_DELETE = "DELETE";
  public static final String METHOD_GET = "GET";
  public static final String METHOD_POST = "POST";
  public static final String X_MS_RETRY_AFTER_MS_HEADER = "x-ms-retry-after-ms";
  public final boolean mCompressionEnabled;
  public final Set<DefaultHttpClientCallTask> mTasks = new HashSet();
  
  public DefaultHttpClient()
  {
    this(true);
  }
  
  public DefaultHttpClient(boolean paramBoolean)
  {
    mCompressionEnabled = paramBoolean;
  }
  
  public ServiceCall callAsync(String paramString1, String paramString2, Map<String, String> paramMap, HttpClient.CallTemplate paramCallTemplate, ServiceCallback paramServiceCallback)
  {
    paramString1 = new DefaultHttpClientCallTask(paramString1, paramString2, paramMap, paramCallTemplate, paramServiceCallback, this, mCompressionEnabled);
    try
    {
      paramString1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
    catch (RejectedExecutionException paramString2)
    {
      HandlerUtils.runOnUiThread(new DefaultHttpClient.1(this, paramServiceCallback, paramString2));
    }
    return new DefaultHttpClient.2(this, paramString1);
  }
  
  public void close()
  {
    try
    {
      if (mTasks.size() > 0)
      {
        Object localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        ((StringBuilder)localObject1).append("Cancelling ");
        ((StringBuilder)localObject1).append(mTasks.size());
        ((StringBuilder)localObject1).append(" network call(s).");
        AppCenterLog.debug("AppCenter", ((StringBuilder)localObject1).toString());
        localObject1 = mTasks.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((DefaultHttpClientCallTask)((Iterator)localObject1).next()).cancel(true);
        }
        mTasks.clear();
      }
      return;
    }
    finally {}
  }
  
  public Set<DefaultHttpClientCallTask> getTasks()
  {
    return mTasks;
  }
  
  public boolean isCompressionEnabled()
  {
    return mCompressionEnabled;
  }
  
  public void onFinish(DefaultHttpClientCallTask paramDefaultHttpClientCallTask)
  {
    try
    {
      mTasks.remove(paramDefaultHttpClientCallTask);
      return;
    }
    finally
    {
      paramDefaultHttpClientCallTask = finally;
      throw paramDefaultHttpClientCallTask;
    }
  }
  
  public void onStart(DefaultHttpClientCallTask paramDefaultHttpClientCallTask)
  {
    try
    {
      mTasks.add(paramDefaultHttpClientCallTask);
      return;
    }
    finally
    {
      paramDefaultHttpClientCallTask = finally;
      throw paramDefaultHttpClientCallTask;
    }
  }
  
  public void reopen() {}
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.http.DefaultHttpClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */