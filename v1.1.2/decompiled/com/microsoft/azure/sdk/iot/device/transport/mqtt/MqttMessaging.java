package com.microsoft.azure.sdk.iot.device.transport.mqtt;

import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.MessageProperty;
import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;
import com.microsoft.azure.sdk.iot.device.transport.IotHubListener;
import e.a.a.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class MqttMessaging
  extends Mqtt
{
  public String eventsSubscribeTopic;
  public String inputsSubscribeTopic;
  public boolean isEdgeHub;
  public String moduleId;
  public String publishTopic;
  
  public MqttMessaging(MqttConnection paramMqttConnection, String paramString1, IotHubListener paramIotHubListener, MqttMessageListener paramMqttMessageListener, String paramString2, String paramString3, boolean paramBoolean, Map<Integer, Message> paramMap)
  {
    super(paramMqttConnection, paramIotHubListener, paramMqttMessageListener, paramString2, paramMap);
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      if ((paramString3 != null) && (!paramString3.isEmpty()))
      {
        paramMqttConnection = new StringBuilder();
        paramMqttConnection.append("devices/");
        paramMqttConnection.append(paramString1);
        paramMqttConnection.append("/modules/");
        paramMqttConnection.append(paramString3);
        paramMqttConnection.append("/messages/events/");
        publishTopic = paramMqttConnection.toString();
        paramMqttConnection = new StringBuilder();
        paramMqttConnection.append("devices/");
        paramMqttConnection.append(paramString1);
        paramMqttConnection.append("/modules/");
        paramMqttConnection.append(paramString3);
        paramMqttConnection.append("/messages/devicebound/#");
        eventsSubscribeTopic = paramMqttConnection.toString();
        paramMqttConnection = new StringBuilder();
        paramMqttConnection.append("devices/");
        paramMqttConnection.append(paramString1);
        paramMqttConnection.append("/modules/");
        paramMqttConnection.append(paramString3);
        paramMqttConnection.append("/inputs/#");
        inputsSubscribeTopic = paramMqttConnection.toString();
      }
      else
      {
        publishTopic = a.a("devices/", paramString1, "/messages/events/");
        eventsSubscribeTopic = a.a("devices/", paramString1, "/messages/devicebound/#");
        inputsSubscribeTopic = null;
      }
      moduleId = paramString3;
      isEdgeHub = paramBoolean;
      return;
    }
    throw new IllegalArgumentException("Device id cannot be null or empty");
  }
  
  private boolean appendPropertyIfPresent(StringBuilder paramStringBuilder, boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      try
      {
        if (!paramString2.isEmpty())
        {
          if (paramBoolean) {
            paramStringBuilder.append('&');
          }
          paramStringBuilder.append(paramString1);
          paramStringBuilder.append('=');
          paramStringBuilder.append(URLEncoder.encode(paramString2, StandardCharsets.UTF_8.name()));
          return true;
        }
      }
      catch (UnsupportedEncodingException paramStringBuilder)
      {
        throw new TransportException("Could not utf-8 encode the mqtt property", paramStringBuilder);
      }
    }
    return paramBoolean;
  }
  
  public void send(Message paramMessage)
  {
    if ((paramMessage != null) && (paramMessage.getBytes() != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(publishTopic);
      String str = paramMessage.getMessageId();
      int i = 0;
      boolean bool1 = appendPropertyIfPresent(localStringBuilder, appendPropertyIfPresent(localStringBuilder, appendPropertyIfPresent(localStringBuilder, appendPropertyIfPresent(localStringBuilder, appendPropertyIfPresent(localStringBuilder, appendPropertyIfPresent(localStringBuilder, appendPropertyIfPresent(localStringBuilder, appendPropertyIfPresent(localStringBuilder, appendPropertyIfPresent(localStringBuilder, appendPropertyIfPresent(localStringBuilder, false, "$.mid", str), "$.cid", paramMessage.getCorrelationId()), "$.uid", paramMessage.getUserId()), "$.to", paramMessage.getTo()), "$.on", paramMessage.getOutputName()), "$.cdid", paramMessage.getConnectionDeviceId()), "$.cmid", paramMessage.getConnectionModuleId()), "$.ce", paramMessage.getContentEncoding()), "$.ct", paramMessage.getContentType()), "$.ctime", paramMessage.getCreationTimeUTCString());
      boolean bool2 = bool1;
      if (paramMessage.isSecurityMessage()) {
        bool2 = appendPropertyIfPresent(localStringBuilder, bool1, "$.ifid", "urn:azureiot:Security:SecurityAgent:1");
      }
      MessageProperty[] arrayOfMessageProperty = paramMessage.getProperties();
      int j = arrayOfMessageProperty.length;
      while (i < j)
      {
        str = arrayOfMessageProperty[i];
        bool2 = appendPropertyIfPresent(localStringBuilder, bool2, str.getName(), str.getValue());
        i++;
      }
      str = moduleId;
      if ((str != null) && (!str.isEmpty())) {
        localStringBuilder.append("/");
      }
      publish(localStringBuilder.toString(), paramMessage);
      return;
    }
    throw new IllegalArgumentException("Message cannot be null");
  }
  
  public void start()
  {
    connect();
    if (!isEdgeHub)
    {
      subscribe(eventsSubscribeTopic);
    }
    else
    {
      String str = moduleId;
      if ((str != null) && (!str.isEmpty())) {
        subscribe(inputsSubscribeTopic);
      }
    }
  }
  
  public void stop()
  {
    disconnect();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.mqtt.MqttMessaging
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */