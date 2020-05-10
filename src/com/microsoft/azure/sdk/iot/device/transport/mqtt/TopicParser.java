package com.microsoft.azure.sdk.iot.device.transport.mqtt;

import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;

public class TopicParser
{
  public final String QUESTION = "?";
  public final String REQ_ID = "$rid=";
  public final String VERSION = "$version=";
  public String[] topicTokens = null;
  
  public TopicParser(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      topicTokens = paramString.split("/");
      return;
    }
    throw new TransportException(new IllegalArgumentException("topic cannot be null or empty"));
  }
  
  public String getMethodName(int paramInt)
  {
    if (paramInt > 0)
    {
      Object localObject = topicTokens;
      if (paramInt < localObject.length)
      {
        if (localObject.length > paramInt)
        {
          localObject = localObject[paramInt];
          if (localObject == null) {
            throw new TransportException(new IllegalArgumentException("method name could not be parsed"));
          }
        }
        else
        {
          localObject = null;
        }
        return (String)localObject;
      }
    }
    throw new TransportException(new IllegalArgumentException("Invalid token Index for Method Name"));
  }
  
  public String getRequestId(int paramInt)
  {
    if (paramInt > 0)
    {
      Object localObject = topicTokens;
      if (paramInt < localObject.length)
      {
        if (localObject.length > paramInt)
        {
          localObject = localObject[paramInt];
          if ((((String)localObject).contains("$rid=")) && (((String)localObject).contains("?")))
          {
            int i = ((String)localObject).indexOf("$rid=");
            int j = ((String)localObject).length();
            paramInt = j;
            if (((String)localObject).contains("$version="))
            {
              paramInt = j;
              if (!((String)localObject).contains("?$version=")) {
                paramInt = ((String)localObject).indexOf("$version=") - 1;
              }
            }
            localObject = ((String)localObject).substring(i + 5, paramInt);
            break label103;
          }
        }
        localObject = null;
        label103:
        return (String)localObject;
      }
    }
    throw new TransportException(new IllegalArgumentException("Invalid token Index for request id"));
  }
  
  public String getStatus(int paramInt)
  {
    if (paramInt > 0)
    {
      Object localObject = topicTokens;
      if (paramInt < localObject.length)
      {
        if (localObject.length > paramInt)
        {
          localObject = localObject[paramInt];
          if (localObject == null) {
            throw new TransportException("Status could not be parsed");
          }
        }
        else
        {
          localObject = null;
        }
        return (String)localObject;
      }
    }
    throw new TransportException(new IllegalArgumentException("Invalid token Index for status"));
  }
  
  public String getVersion(int paramInt)
  {
    if (paramInt > 0)
    {
      Object localObject = topicTokens;
      if (paramInt < localObject.length)
      {
        if (localObject.length > paramInt)
        {
          localObject = localObject[paramInt];
          if ((((String)localObject).contains("$version=")) && (((String)localObject).contains("?")))
          {
            int i = ((String)localObject).indexOf("$version=");
            int j = ((String)localObject).length();
            paramInt = j;
            if (!((String)localObject).contains("?$rid="))
            {
              paramInt = j;
              if (((String)localObject).contains("$rid=")) {
                paramInt = ((String)localObject).indexOf("$rid=") - 1;
              }
            }
            localObject = ((String)localObject).substring(i + 9, paramInt);
            break label104;
          }
        }
        localObject = null;
        label104:
        return (String)localObject;
      }
    }
    throw new TransportException(new IllegalArgumentException("Invalid token Index for Version"));
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.device.transport.mqtt.TopicParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */