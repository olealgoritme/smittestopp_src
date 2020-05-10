package com.microsoft.appcenter.http;

import android.text.TextUtils;
import java.io.IOException;

public class HttpException
  extends IOException
{
  public final HttpResponse mHttpResponse;
  
  public HttpException(HttpResponse paramHttpResponse)
  {
    super(getDetailMessage(paramHttpResponse.getStatusCode(), paramHttpResponse.getPayload()));
    mHttpResponse = paramHttpResponse;
  }
  
  public static String getDetailMessage(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return String.valueOf(paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (HttpException.class == paramObject.getClass()))
    {
      paramObject = (HttpException)paramObject;
      return mHttpResponse.equals(mHttpResponse);
    }
    return false;
  }
  
  public HttpResponse getHttpResponse()
  {
    return mHttpResponse;
  }
  
  public int hashCode()
  {
    return mHttpResponse.hashCode();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.http.HttpException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */