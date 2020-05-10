package com.microsoft.identity.common.internal.providers.microsoft;

import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationResponse;
import e.c.c.v.a;

public class MicrosoftAuthorizationResponse
  extends AuthorizationResponse
{
  public static final String CLOUD_GRAPH_HOST_NAME = "cloud_graph_host_name";
  public static final String CLOUD_INSTANCE_HOST_NAME = "cloud_instance_host_name";
  public static final String CLOUD_INSTANCE_NAME = "cloud_instance_name";
  public static final String SESSION_STATE = "session_state";
  @a
  public String mCloudGraphHostName;
  @a
  public String mCloudInstanceHostName;
  @a
  public String mCloudInstanceName;
  @a
  public String mCorrelationId;
  @a
  public String mSessionState;
  
  public MicrosoftAuthorizationResponse(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public String getCloudGraphHostName()
  {
    return mCloudGraphHostName;
  }
  
  public String getCloudInstanceHostName()
  {
    return mCloudInstanceHostName;
  }
  
  public String getCloudInstanceName()
  {
    return mCloudInstanceName;
  }
  
  public String getCorrelationId()
  {
    return mCorrelationId;
  }
  
  public String getSessionState()
  {
    return mSessionState;
  }
  
  public void setCorrelationId(String paramString)
  {
    mCorrelationId = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */