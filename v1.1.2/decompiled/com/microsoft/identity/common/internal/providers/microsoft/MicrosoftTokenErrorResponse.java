package com.microsoft.identity.common.internal.providers.microsoft;

import com.microsoft.identity.common.internal.providers.oauth2.TokenErrorResponse;
import e.c.c.v.c;
import java.util.List;

public class MicrosoftTokenErrorResponse
  extends TokenErrorResponse
{
  @c("correlation_id")
  public String mCorrelationId;
  @c("error_codes")
  public List<Long> mErrorCodes;
  @c("oAuth_metadata")
  public String mOAuthErrorMetadata;
  @c("timestamp")
  public String mTimeStamp;
  @c("trace_id")
  public String mTraceId;
  
  public String getCorrelationId()
  {
    return mCorrelationId;
  }
  
  public List<Long> getErrorCodes()
  {
    return mErrorCodes;
  }
  
  public String getOAuthErrorMetadata()
  {
    return mOAuthErrorMetadata;
  }
  
  public String getTimeStamp()
  {
    return mTimeStamp;
  }
  
  public String getTraceId()
  {
    return mTraceId;
  }
  
  public void setCorrelationId(String paramString)
  {
    mCorrelationId = paramString;
  }
  
  public void setErrorCodes(List<Long> paramList)
  {
    mErrorCodes = paramList;
  }
  
  public void setOAuthErrorMetadata(String paramString)
  {
    mOAuthErrorMetadata = paramString;
  }
  
  public void setTimeStamp(String paramString)
  {
    mTimeStamp = paramString;
  }
  
  public void setTraceId(String paramString)
  {
    mTraceId = paramString;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.microsoft.MicrosoftTokenErrorResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */