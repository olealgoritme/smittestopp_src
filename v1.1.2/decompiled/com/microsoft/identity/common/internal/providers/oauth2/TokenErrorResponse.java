package com.microsoft.identity.common.internal.providers.oauth2;

import e.c.c.v.c;

public class TokenErrorResponse
  implements IErrorResponse
{
  @e.c.c.v.a
  @c("error")
  public String mError;
  @e.c.c.v.a
  @c("error_description")
  public String mErrorDescription;
  @e.c.c.v.a
  @c("error_uri")
  public String mErrorUri;
  public String mResponseBody;
  @e.c.c.v.a
  public String mResponseHeadersJson;
  @e.c.c.v.a
  public int mStatusCode;
  @e.c.c.v.a
  @c("suberror")
  public String mSubError;
  
  public String getError()
  {
    return mError;
  }
  
  public String getErrorDescription()
  {
    return mErrorDescription;
  }
  
  public String getErrorUri()
  {
    return mErrorUri;
  }
  
  public String getResponseBody()
  {
    return mResponseBody;
  }
  
  public String getResponseHeadersJson()
  {
    return mResponseHeadersJson;
  }
  
  public int getStatusCode()
  {
    return mStatusCode;
  }
  
  public String getSubError()
  {
    return mSubError;
  }
  
  public void setError(String paramString)
  {
    mError = paramString;
  }
  
  public void setErrorDescription(String paramString)
  {
    mErrorDescription = paramString;
  }
  
  public void setErrorUri(String paramString)
  {
    mErrorUri = paramString;
  }
  
  public void setResponseBody(String paramString)
  {
    mResponseBody = paramString;
  }
  
  public void setResponseHeadersJson(String paramString)
  {
    mResponseHeadersJson = paramString;
  }
  
  public void setStatusCode(int paramInt)
  {
    mStatusCode = paramInt;
  }
  
  public void setSubError(String paramString)
  {
    mSubError = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = e.a.a.a.a.a("TokenErrorResponse{mStatusCode=");
    localStringBuilder.append(mStatusCode);
    localStringBuilder.append(", mResponseBody='");
    e.a.a.a.a.a(localStringBuilder, mResponseBody, '\'', ", mResponseHeadersJson=");
    localStringBuilder.append(mResponseHeadersJson);
    localStringBuilder.append(", mError='");
    e.a.a.a.a.a(localStringBuilder, mError, '\'', ", mSubError='");
    e.a.a.a.a.a(localStringBuilder, mSubError, '\'', ", mErrorDescription='");
    e.a.a.a.a.a(localStringBuilder, mErrorDescription, '\'', ", mErrorUri='");
    localStringBuilder.append(mErrorUri);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.oauth2.TokenErrorResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */