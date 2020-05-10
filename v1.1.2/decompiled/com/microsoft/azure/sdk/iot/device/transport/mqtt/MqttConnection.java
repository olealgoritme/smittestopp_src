package com.microsoft.azure.sdk.iot.device.transport.mqtt;

import com.microsoft.azure.sdk.iot.device.ProxySettings;
import com.microsoft.azure.sdk.iot.device.transport.HttpProxySocketFactory;
import com.microsoft.azure.sdk.iot.device.transport.mqtt.exceptions.PahoExceptionTranslator;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.net.ssl.SSLContext;
import l.a.a.b.e.b;
import l.c.a.a.a.e;
import l.c.a.a.a.f;
import l.c.a.a.a.g;
import l.c.a.a.a.i;
import l.c.a.a.a.k;

public class MqttConnection
{
  public static final int KEEP_ALIVE_INTERVAL = 230;
  public static final int MAX_IN_FLIGHT_COUNT = 10;
  public static final int MAX_SUBSCRIBE_ACK_WAIT_TIME = 15000;
  public static final int MQTT_VERSION = 4;
  public static final int QOS = 1;
  public static final boolean SET_CLEAN_SESSION = false;
  public ConcurrentLinkedQueue<b<String, byte[]>> allReceivedMessages;
  public i connectionOptions = null;
  public f mqttAsyncClient = null;
  public Object mqttLock;
  
  public MqttConnection(String paramString1, String paramString2, String paramString3, String paramString4, SSLContext paramSSLContext, ProxySettings paramProxySettings)
  {
    if ((paramString1 != null) && (paramString2 != null) && (paramString3 != null) && (paramSSLContext != null))
    {
      if ((!paramString1.isEmpty()) && (!paramString2.isEmpty()) && (!paramString3.isEmpty())) {
        try
        {
          f localf = new l/c/a/a/a/f;
          l.c.a.a.a.u.a locala = new l/c/a/a/a/u/a;
          locala.<init>();
          localf.<init>(paramString1, paramString2, locala);
          mqttAsyncClient = localf;
          A.h.N = true;
          paramString1 = new l/c/a/a/a/i;
          paramString1.<init>();
          connectionOptions = paramString1;
          updateConnectionOptions(paramString3, paramString4, paramSSLContext, paramProxySettings);
          allReceivedMessages = new ConcurrentLinkedQueue();
          mqttLock = new Object();
          return;
        }
        catch (k paramString1)
        {
          mqttAsyncClient = null;
          connectionOptions = null;
          throw PahoExceptionTranslator.convertToMqttException(paramString1, "Unable to create mqttAsyncClient");
        }
      }
      throw new IllegalArgumentException("ServerURI, clientId, and userName may not be null or empty");
    }
    throw new IllegalArgumentException("ServerURI, clientId, and userName may not be null or empty");
  }
  
  private void updateConnectionOptions(String paramString1, String paramString2, SSLContext paramSSLContext, ProxySettings paramProxySettings)
  {
    i locali = connectionOptions;
    if (locali != null)
    {
      a = 230;
      k = false;
      locali.a(4);
      locali = connectionOptions;
      e = paramString1;
      if (paramProxySettings != null)
      {
        if (paramProxySettings.getProxy().type() == Proxy.Type.SOCKS) {
          connectionOptions.g = new Socks5SocketFactory(paramProxySettings.getHostname(), paramProxySettings.getPort());
        } else if (paramProxySettings.getProxy().type() == Proxy.Type.HTTP) {
          connectionOptions.g = new HttpProxySocketFactory(paramSSLContext.getSocketFactory(), paramProxySettings);
        } else {
          throw new IllegalArgumentException("Proxy settings must be configured to use either SOCKS or HTTP");
        }
      }
      else {
        g = paramSSLContext.getSocketFactory();
      }
      if ((paramString2 != null) && (!paramString2.isEmpty()))
      {
        paramString1 = connectionOptions;
        paramString2 = paramString2.toCharArray();
        if (paramString1 != null) {
          f = ((char[])paramString2.clone());
        } else {
          throw null;
        }
      }
      return;
    }
    throw null;
  }
  
  public void close()
  {
    f localf = mqttAsyncClient;
    if (localf != null) {
      localf.close();
    }
  }
  
  public e disconnect()
  {
    f localf = mqttAsyncClient;
    if (localf != null) {
      return localf.a();
    }
    return null;
  }
  
  public ConcurrentLinkedQueue<b<String, byte[]>> getAllReceivedMessages()
  {
    return allReceivedMessages;
  }
  
  public i getConnectionOptions()
  {
    return connectionOptions;
  }
  
  public f getMqttAsyncClient()
  {
    return mqttAsyncClient;
  }
  
  public Object getMqttLock()
  {
    return mqttLock;
  }
  
  public boolean isConnected()
  {
    f localf = mqttAsyncClient;
    if (localf != null) {
      return localf.b();
    }
    return false;
  }
  
  public boolean sendMessageAcknowledgement(int paramInt)
  {
    try
    {
      mqttAsyncClient.a(paramInt, 1);
      return true;
    }
    catch (k localk)
    {
      throw PahoExceptionTranslator.convertToMqttException(localk, "Error sending message ack");
    }
  }
  
  public void setMqttAsyncClient(f paramf)
  {
    mqttAsyncClient = paramf;
  }
  
  public void setMqttCallback(g paramg)
  {
    if (paramg != null)
    {
      f localf = getMqttAsyncClient();
      C = paramg;
      A.h.y = paramg;
      return;
    }
    throw new IllegalArgumentException("callback cannot be null");
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.transport.mqtt.MqttConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */