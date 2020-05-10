package com.microsoft.azure.sdk.iot.device.transport.mqtt.exceptions;

import com.microsoft.azure.sdk.iot.device.exceptions.ProtocolException;
import com.microsoft.azure.sdk.iot.device.exceptions.TransportException;
import java.net.NoRouteToHostException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import l.c.a.a.a.k;

public class PahoExceptionTranslator
{
  public static final int UNDEFINED_MQTT_CONNECT_CODE_LOWER_BOUND = 6;
  public static final int UNDEFINED_MQTT_CONNECT_CODE_UPPER_BOUND = 255;
  
  public static ProtocolException convertToMqttException(k paramk, String paramString)
  {
    int i = x;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5)
              {
                if ((i != 128) && (i != 32000) && (i != 32002) && (i != 32103) && (i != 32104) && (i != 32109) && (i != 32110) && (i != 32201) && (i != 32202))
                {
                  if ((i >= 6) && (i <= 255)) {
                    return new MqttUnexpectedErrorException(paramString, paramk);
                  }
                  return new ProtocolException(paramString, paramk);
                }
                paramk = new ProtocolException(paramString, paramk);
                paramk.setRetryable(true);
                return paramk;
              }
              return new MqttUnauthorizedException(paramString, paramk);
            }
            return new MqttBadUsernameOrPasswordException(paramString, paramk);
          }
          return new MqttServerUnavailableException(paramString, paramk);
        }
        return new MqttIdentifierRejectedException(paramString, paramk);
      }
      return new MqttRejectedProtocolVersionException(paramString, paramk);
    }
    Throwable localThrowable = y;
    if ((!(localThrowable instanceof UnknownHostException)) && (!(localThrowable instanceof NoRouteToHostException)) && (!(localThrowable instanceof InterruptedException)) && (!(localThrowable instanceof SocketTimeoutException)) && (!(localThrowable instanceof SocketException))) {
      return new ProtocolException(paramString, paramk);
    }
    paramk = new ProtocolException(paramString, paramk);
    paramk.setRetryable(true);
    return paramk;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.mqtt.exceptions.PahoExceptionTranslator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */