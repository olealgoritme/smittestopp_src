package com.microsoft.azure.sdk.iot.deps.transport.mqtt;

import java.io.IOException;
import javax.net.ssl.SSLContext;
import l.c.a.a.a.c;
import l.c.a.a.a.f;
import l.c.a.a.a.g;
import l.c.a.a.a.i;
import l.c.a.a.a.k;
import l.c.a.a.a.l;
import l.c.a.a.a.q;
import l.c.a.a.a.s.p;

public class MqttConnection
  implements g
{
  public static final int KEEP_ALIVE_INTERVAL = 230;
  public static final int MAX_WAIT_TIME = 1000;
  public static final int MQTT_VERSION = 4;
  public static final boolean SET_CLEAN_SESSION = false;
  public static final String SSL_URL_FORMAT = "ssl://%s:8883";
  public static final String WS_SSL_URL_FORMAT = "wss://%s:443";
  public i connectionOptions;
  public f mqttAsyncClient;
  public MqttListener mqttListener;
  
  public MqttConnection(String paramString1, String paramString2, String paramString3, String paramString4, SSLContext paramSSLContext, MqttListener paramMqttListener, boolean paramBoolean)
  {
    if ((paramString1 != null) && (paramString2 != null) && (paramString3 != null) && (paramSSLContext != null))
    {
      if ((!paramString1.isEmpty()) && (!paramString2.isEmpty()) && (!paramString3.isEmpty()))
      {
        if (paramMqttListener != null)
        {
          if (paramBoolean) {}
          try
          {
            paramString1 = String.format("wss://%s:443", new Object[] { paramString1 });
            break label83;
            paramString1 = String.format("ssl://%s:8883", new Object[] { paramString1 });
            label83:
            mqttListener = paramMqttListener;
            f localf = new l/c/a/a/a/f;
            paramMqttListener = new l/c/a/a/a/u/a;
            paramMqttListener.<init>();
            localf.<init>(paramString1, paramString2, paramMqttListener);
            mqttAsyncClient = localf;
            paramString1 = new l/c/a/a/a/i;
            paramString1.<init>();
            connectionOptions = paramString1;
            paramString1 = mqttAsyncClient;
            C = this;
            A.h.y = this;
            updateConnectionOptions(paramString3, paramString4, paramSSLContext);
            return;
          }
          catch (k paramString2)
          {
            mqttAsyncClient = null;
            connectionOptions = null;
            paramString1 = e.a.a.a.a.a("Error initializing MQTT connection:");
            paramString1.append(paramString2.getMessage());
            throw new IOException(paramString1.toString());
          }
        }
        throw new IllegalArgumentException("The listener cannot be null.");
      }
      throw new IllegalArgumentException();
    }
    throw new IllegalArgumentException();
  }
  
  private void updateConnectionOptions(String paramString1, String paramString2, SSLContext paramSSLContext)
  {
    i locali = connectionOptions;
    if (locali != null)
    {
      a = 230;
      k = false;
      locali.a(4);
      locali = connectionOptions;
      e = paramString1;
      g = paramSSLContext.getSocketFactory();
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
  
  /* Error */
  public void connect()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 58	com/microsoft/azure/sdk/iot/deps/transport/mqtt/MqttConnection:mqttAsyncClient	Ll/c/a/a/a/f;
    //   6: invokevirtual 156	l/c/a/a/a/f:b	()Z
    //   9: ifne +42 -> 51
    //   12: aload_0
    //   13: getfield 58	com/microsoft/azure/sdk/iot/deps/transport/mqtt/MqttConnection:mqttAsyncClient	Ll/c/a/a/a/f;
    //   16: aload_0
    //   17: getfield 63	com/microsoft/azure/sdk/iot/deps/transport/mqtt/MqttConnection:connectionOptions	Ll/c/a/a/a/i;
    //   20: aconst_null
    //   21: aconst_null
    //   22: invokevirtual 159	l/c/a/a/a/f:a	(Ll/c/a/a/a/i;Ljava/lang/Object;Ll/c/a/a/a/a;)Ll/c/a/a/a/e;
    //   25: astore_1
    //   26: aload_1
    //   27: checkcast 161	l/c/a/a/a/q
    //   30: astore_1
    //   31: aload_1
    //   32: invokevirtual 163	l/c/a/a/a/q:a	()V
    //   35: aload_0
    //   36: getfield 48	com/microsoft/azure/sdk/iot/deps/transport/mqtt/MqttConnection:mqttListener	Lcom/microsoft/azure/sdk/iot/deps/transport/mqtt/MqttListener;
    //   39: ifnull +12 -> 51
    //   42: aload_0
    //   43: getfield 48	com/microsoft/azure/sdk/iot/deps/transport/mqtt/MqttConnection:mqttListener	Lcom/microsoft/azure/sdk/iot/deps/transport/mqtt/MqttListener;
    //   46: invokeinterface 168 1 0
    //   51: aload_0
    //   52: monitorexit
    //   53: return
    //   54: astore_1
    //   55: goto +17 -> 72
    //   58: astore_1
    //   59: new 105	java/io/IOException
    //   62: astore_2
    //   63: aload_2
    //   64: ldc -86
    //   66: aload_1
    //   67: invokespecial 173	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   70: aload_2
    //   71: athrow
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	MqttConnection
    //   25	7	1	localObject1	Object
    //   54	1	1	localObject2	Object
    //   58	17	1	localk	k
    //   62	9	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	26	54	finally
    //   31	51	54	finally
    //   59	72	54	finally
    //   2	26	58	l/c/a/a/a/k
    //   31	51	58	l/c/a/a/a/k
  }
  
  public void connectionLost(Throwable paramThrowable)
  {
    try
    {
      mqttListener.connectionLost(paramThrowable);
      return;
    }
    finally
    {
      paramThrowable = finally;
      throw paramThrowable;
    }
  }
  
  public void deliveryComplete(c paramc) {}
  
  /* Error */
  public void disconnect()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 58	com/microsoft/azure/sdk/iot/deps/transport/mqtt/MqttConnection:mqttAsyncClient	Ll/c/a/a/a/f;
    //   6: invokevirtual 156	l/c/a/a/a/f:b	()Z
    //   9: ifeq +20 -> 29
    //   12: aload_0
    //   13: getfield 58	com/microsoft/azure/sdk/iot/deps/transport/mqtt/MqttConnection:mqttAsyncClient	Ll/c/a/a/a/f;
    //   16: invokevirtual 183	l/c/a/a/a/f:a	()Ll/c/a/a/a/e;
    //   19: astore_1
    //   20: aload_1
    //   21: checkcast 161	l/c/a/a/a/q
    //   24: astore_1
    //   25: aload_1
    //   26: invokevirtual 163	l/c/a/a/a/q:a	()V
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: astore_1
    //   33: goto +17 -> 50
    //   36: astore_1
    //   37: new 105	java/io/IOException
    //   40: astore_2
    //   41: aload_2
    //   42: ldc -86
    //   44: aload_1
    //   45: invokespecial 173	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   48: aload_2
    //   49: athrow
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	MqttConnection
    //   19	7	1	localObject1	Object
    //   32	1	1	localObject2	Object
    //   36	17	1	localk	k
    //   40	9	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	20	32	finally
    //   25	29	32	finally
    //   37	50	32	finally
    //   2	20	36	l/c/a/a/a/k
    //   25	29	36	l/c/a/a/a/k
  }
  
  public boolean isMqttConnected()
  {
    f localf = mqttAsyncClient;
    boolean bool;
    if (localf == null) {
      bool = false;
    } else {
      bool = localf.b();
    }
    return bool;
  }
  
  public void messageArrived(String paramString, l paraml)
  {
    try
    {
      MqttListener localMqttListener = mqttListener;
      MqttMessage localMqttMessage = new com/microsoft/azure/sdk/iot/deps/transport/mqtt/MqttMessage;
      localMqttMessage.<init>(paramString, paraml);
      localMqttListener.messageReceived(localMqttMessage);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void publishMessage(MqttMessage paramMqttMessage)
  {
    try
    {
      if (mqttAsyncClient != null)
      {
        boolean bool = mqttAsyncClient.b();
        if (bool)
        {
          if (paramMqttMessage != null) {
            try
            {
              localObject = mqttAsyncClient.a(paramMqttMessage.getTopic(), paramMqttMessage.getMqttMessage());
              localObject = (q)localObject;
              ((q)localObject).a();
              return;
            }
            catch (k localk)
            {
              Object localObject = new java/io/IOException;
              StringBuilder localStringBuilder = new java/lang/StringBuilder;
              localStringBuilder.<init>();
              localStringBuilder.append("Unable to publish message on topic : ");
              localStringBuilder.append(paramMqttMessage.getTopic());
              ((IOException)localObject).<init>(localStringBuilder.toString(), localk);
              throw ((Throwable)localObject);
            }
          }
          paramMqttMessage = new java/io/IOException;
          paramMqttMessage.<init>("MqttMessage is null");
          throw paramMqttMessage;
        }
      }
      paramMqttMessage = new java/io/IOException;
      paramMqttMessage.<init>("Mqtt is not connected");
      throw paramMqttMessage;
    }
    finally {}
  }
  
  public void publishMessage(String paramString, MqttQos paramMqttQos, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      if (paramArrayOfByte.length != 0)
      {
        paramString = new MqttMessage(paramString, paramArrayOfByte);
      }
      else
      {
        paramArrayOfByte = new com/microsoft/azure/sdk/iot/deps/transport/mqtt/MqttMessage;
        paramArrayOfByte.<init>(paramString);
        paramString = paramArrayOfByte;
      }
      paramString.setQos(paramMqttQos);
      publishMessage(paramString);
      return;
    }
    finally {}
  }
  
  public void subscribe(String paramString, MqttQos paramMqttQos)
  {
    try
    {
      if (mqttAsyncClient != null)
      {
        boolean bool = mqttAsyncClient.b();
        if (bool) {
          try
          {
            mqttAsyncClient.a(paramString, MqttMessage.retrieveQosValue(paramMqttQos))).a.a(1000L);
            return;
          }
          catch (k localk)
          {
            IOException localIOException = new java/io/IOException;
            paramMqttQos = new java/lang/StringBuilder;
            paramMqttQos.<init>();
            paramMqttQos.append("Unable to subscribe on topic : ");
            paramMqttQos.append(paramString);
            localIOException.<init>(paramMqttQos.toString(), localk);
            throw localIOException;
          }
        }
      }
      paramString = new java/io/IOException;
      paramString.<init>("Mqtt is not connected");
      throw paramString;
    }
    finally {}
  }
  
  /* Error */
  public void unsubscribe(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 58	com/microsoft/azure/sdk/iot/deps/transport/mqtt/MqttConnection:mqttAsyncClient	Ll/c/a/a/a/f;
    //   6: aload_1
    //   7: invokevirtual 248	l/c/a/a/a/f:a	(Ljava/lang/String;)Ll/c/a/a/a/e;
    //   10: astore_2
    //   11: aload_2
    //   12: checkcast 161	l/c/a/a/a/q
    //   15: astore_2
    //   16: aload_2
    //   17: invokevirtual 163	l/c/a/a/a/q:a	()V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: astore_1
    //   24: goto +43 -> 67
    //   27: astore_3
    //   28: new 105	java/io/IOException
    //   31: astore 4
    //   33: new 100	java/lang/StringBuilder
    //   36: astore_2
    //   37: aload_2
    //   38: invokespecial 206	java/lang/StringBuilder:<init>	()V
    //   41: aload_2
    //   42: ldc -6
    //   44: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_2
    //   49: aload_1
    //   50: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 4
    //   56: aload_2
    //   57: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: aload_3
    //   61: invokespecial 173	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   64: aload 4
    //   66: athrow
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	MqttConnection
    //   0	71	1	paramString	String
    //   10	47	2	localObject	Object
    //   27	34	3	localk	k
    //   31	34	4	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	11	23	finally
    //   16	20	23	finally
    //   28	67	23	finally
    //   2	11	27	l/c/a/a/a/k
    //   16	20	27	l/c/a/a/a/k
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.transport.mqtt.MqttConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */