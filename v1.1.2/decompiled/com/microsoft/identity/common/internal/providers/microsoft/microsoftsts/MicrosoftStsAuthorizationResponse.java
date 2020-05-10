package com.microsoft.identity.common.internal.providers.microsoft.microsoftsts;

import com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAuthorizationResponse;
import java.util.HashMap;

public class MicrosoftStsAuthorizationResponse
  extends MicrosoftAuthorizationResponse
{
  public MicrosoftStsAuthorizationResponse(String paramString1, String paramString2, HashMap<String, String> paramHashMap)
  {
    super(paramString1, paramString2);
    mCloudGraphHostName = ((String)paramHashMap.get("cloud_graph_host_name"));
    mCloudInstanceHostName = ((String)paramHashMap.get("cloud_instance_host_name"));
    mCloudInstanceName = ((String)paramHashMap.get("cloud_instance_name"));
    mSessionState = ((String)paramHashMap.get("session_state"));
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */