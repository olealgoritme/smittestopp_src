package com.microsoft.azure.sdk.iot.deps.transport.amqp;

import com.microsoft.azure.sdk.iot.deps.util.CustomLogger;
import com.microsoft.azure.sdk.iot.deps.util.ObjectLock;
import com.microsoft.azure.sdk.iot.deps.ws.impl.WebSocketImpl;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import l.a.b.a.d.a0;
import l.a.b.a.d.a0.a;
import l.a.b.a.d.a0.b;
import l.a.b.a.d.g0.d0;
import l.a.b.a.d.g0.g;
import l.a.b.a.d.h;
import l.a.b.a.d.h.b;
import l.a.b.a.d.l;
import l.a.b.a.d.m;
import l.a.b.a.d.n;
import l.a.b.a.d.w;
import l.a.b.a.d.y;
import l.a.b.a.g.b;
import l.a.b.a.g.d;

public class AmqpsConnection
  extends ErrorLoggingBaseHandlerWithCleanup
{
  public static final int AMQP_PORT = 5671;
  public static final int AMQP_WEB_SOCKET_PORT = 443;
  public static final int MAX_WAIT_TO_OPEN_CLOSE_CONNECTION = 60000;
  public static final int MAX_WAIT_TO_TERMINATE_EXECUTOR = 30;
  public static final int THREAD_POOL_MAX_NUMBER = 1;
  public static final String WEB_SOCKET_PATH = "/$iothub/websocket";
  public static final String WEB_SOCKET_SUB_PROTOCOL = "AMQPWSB10";
  public AmqpDeviceOperations amqpDeviceOperations;
  public final ObjectLock closeLock;
  public l.a.b.a.d.c connection;
  public ExecutorService executorService;
  public String fullHostAddress;
  public String hostName;
  public Boolean isOpen;
  public int linkCredit;
  public CustomLogger logger = new CustomLogger();
  public AmqpListener msgListener;
  public long nextTag;
  public CountDownLatch openLatch;
  public d reactor;
  public SaslListenerImpl saslListener;
  public y session;
  public SSLContext sslContext;
  public Boolean useWebSockets;
  
  public AmqpsConnection(String paramString, AmqpDeviceOperations paramAmqpDeviceOperations, SSLContext paramSSLContext, SaslHandler paramSaslHandler, boolean paramBoolean)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      linkCredit = -1;
      nextTag = 0L;
      amqpDeviceOperations = paramAmqpDeviceOperations;
      useWebSockets = Boolean.valueOf(paramBoolean);
      if (paramSaslHandler != null) {
        saslListener = new SaslListenerImpl(paramSaslHandler);
      }
      openLatch = new CountDownLatch(1);
      closeLock = new ObjectLock();
      sslContext = paramSSLContext;
      isOpen = Boolean.valueOf(false);
      int i;
      if (useWebSockets.booleanValue()) {
        i = 443;
      } else {
        i = 5671;
      }
      fullHostAddress = String.format("%s:%d", new Object[] { paramString, Integer.valueOf(i) });
      hostName = paramString;
      add(new l.a.b.a.g.c());
      add(new b());
      try
      {
        paramString = new l/a/b/a/g/f;
        paramString.<init>();
        a = false;
        reactor = e.c.a.a.b.l.c.a(paramString, new l[] { this });
        return;
      }
      catch (IOException paramString)
      {
        logger.LogError(paramString);
        throw new IOException("Could not create Proton reactor", paramString);
      }
    }
    throw new IllegalArgumentException("The hostname cannot be null or empty.");
  }
  
  private a0 makeDomain()
  {
    l.a.b.a.d.g0.m0.e locale = new l.a.b.a.d.g0.m0.e();
    b = a0.b.VERIFY_PEER;
    l.a.b.a.d.g0.m0.f localf = d;
    a = null;
    a0.a locala = a0.a.CLIENT;
    a = null;
    a = locala;
    c = sslContext;
    return locale;
  }
  
  public void close()
  {
    Object localObject1 = logger;
    ((CustomLogger)localObject1).LogDebug("Entered in method %s", new Object[] { ((CustomLogger)localObject1).getMethodName() });
    if (isOpen.booleanValue())
    {
      amqpDeviceOperations.closeLinks();
      localObject1 = session;
      if (localObject1 != null) {
        ((l.a.b.a.d.f)localObject1).close();
      }
      localObject1 = connection;
      if (localObject1 != null) {
        ((l.a.b.a.d.f)localObject1).close();
      }
      localObject1 = reactor;
      if (localObject1 != null) {
        ((d)localObject1).stop();
      }
      try
      {
        synchronized (closeLock)
        {
          closeLock.waitLock(60000L);
          localObject1 = executorService;
          if (localObject1 != null)
          {
            ((ExecutorService)localObject1).shutdown();
            try
            {
              if (!executorService.awaitTermination(30L, TimeUnit.SECONDS))
              {
                executorService.shutdownNow();
                if (!executorService.awaitTermination(30L, TimeUnit.SECONDS)) {
                  logger.LogInfo("Pool did not terminate", new Object[0]);
                }
              }
            }
            catch (InterruptedException localInterruptedException1)
            {
              executorService.shutdownNow();
            }
          }
          isOpen = Boolean.valueOf(false);
        }
        localCustomLogger = logger;
      }
      catch (InterruptedException localInterruptedException2)
      {
        logger.LogError(localInterruptedException2);
        throw new IOException("Waited too long for the connection to open.");
      }
    }
    CustomLogger localCustomLogger;
    localCustomLogger.LogDebug("Exited from method %s", new Object[] { localCustomLogger.getMethodName() });
  }
  
  public boolean isConnected()
  {
    SaslListenerImpl localSaslListenerImpl = saslListener;
    if ((localSaslListenerImpl != null) && (localSaslListenerImpl.getSavedException() != null)) {
      throw saslListener.getSavedException();
    }
    return isOpen.booleanValue();
  }
  
  public void onConnectionBound(h paramh)
  {
    Object localObject = logger;
    ((CustomLogger)localObject).LogDebug("Entered in method %s", new Object[] { ((CustomLogger)localObject).getMethodName() });
    paramh = ((g)paramh).T().j();
    if (paramh != null)
    {
      if (saslListener != null)
      {
        l.a.b.a.d.v localv = paramh.L();
        localObject = saslListener;
        x = ((w)localObject);
      }
      if (useWebSockets.booleanValue())
      {
        localObject = new WebSocketImpl();
        ((WebSocketImpl)localObject).configure(hostName, "/$iothub/websocket", 0, "AMQPWSB10", null, null);
        ((l.a.b.a.d.g0.c0)paramh).a((d0)localObject);
      }
      try
      {
        paramh.a(makeDomain());
      }
      catch (IOException paramh)
      {
        logger.LogDebug("onConnectionBound has thrown exception while creating ssl context: %s", new Object[] { paramh.getMessage() });
      }
    }
    paramh = logger;
    paramh.LogDebug("Exited from method %s", new Object[] { paramh.getMethodName() });
  }
  
  public void onConnectionInit(h paramh)
  {
    CustomLogger localCustomLogger = logger;
    localCustomLogger.LogDebug("Entered in method %s", new Object[] { localCustomLogger.getMethodName() });
    paramh = ((g)paramh).T();
    connection = paramh;
    paramh.a(fullHostAddress);
    session = connection.q();
    connection.open();
    session.open();
    try
    {
      amqpDeviceOperations.openLinks(session);
    }
    catch (Exception paramh)
    {
      logger.LogDebug("openLinks has thrown exception: %s", new Object[] { paramh.getMessage() });
    }
    paramh = logger;
    paramh.LogDebug("Exited from method %s", new Object[] { paramh.getMethodName() });
  }
  
  public void onConnectionUnbound(h paramh)
  {
    paramh = logger;
    paramh.LogDebug("Entered in method %s", new Object[] { paramh.getMethodName() });
    isOpen = Boolean.valueOf(false);
    paramh = logger;
    paramh.LogDebug("Exited from method %s", new Object[] { paramh.getMethodName() });
  }
  
  public void onDelivery(h paramh)
  {
    Object localObject = logger;
    ((CustomLogger)localObject).LogDebug("Entered in method %s", new Object[] { ((CustomLogger)localObject).getMethodName() });
    localObject = amqpDeviceOperations;
    paramh = (g)paramh;
    localObject = ((AmqpDeviceOperations)localObject).receiverMessageFromLink(paramh.r().getName());
    if (localObject == null)
    {
      if (paramh.z() == h.b.DELIVERY)
      {
        paramh = paramh.h();
        paramh.e().equals(l.a.b.a.b.k.a.a);
        paramh.a();
      }
    }
    else {
      msgListener.messageReceived((AmqpMessage)localObject);
    }
    paramh = logger;
    paramh.LogDebug("Exited from method %s", new Object[] { paramh.getMethodName() });
  }
  
  public void onLinkFlow(h paramh)
  {
    CustomLogger localCustomLogger = logger;
    localCustomLogger.LogDebug("Entered in method %s", new Object[] { localCustomLogger.getMethodName() });
    int i = ((g)paramh).r().F();
    linkCredit = i;
    logger.LogDebug("The link credit value is %s, method name is %s", new Object[] { Integer.valueOf(i), logger.getMethodName() });
    paramh = logger;
    paramh.LogDebug("Exited from method %s", new Object[] { paramh.getMethodName() });
  }
  
  public void onLinkInit(h paramh)
  {
    CustomLogger localCustomLogger = logger;
    localCustomLogger.LogDebug("Entered in method %s", new Object[] { localCustomLogger.getMethodName() });
    paramh = (g)paramh;
    try
    {
      paramh = paramh.r();
      amqpDeviceOperations.initLink(paramh);
    }
    catch (Exception paramh)
    {
      logger.LogDebug("Exception in onLinkInit: %s", new Object[] { paramh.getMessage() });
    }
    paramh = logger;
    paramh.LogDebug("Exited from method %s", new Object[] { paramh.getMethodName() });
  }
  
  public void onLinkRemoteOpen(h paramh)
  {
    CustomLogger localCustomLogger = logger;
    localCustomLogger.LogDebug("Entered in method %s", new Object[] { localCustomLogger.getMethodName() });
    paramh = ((g)paramh).r().getName();
    if (amqpDeviceOperations.isReceiverLinkTag(paramh))
    {
      isOpen = Boolean.valueOf(true);
      paramh = msgListener;
      if (paramh != null)
      {
        paramh.connectionEstablished();
        openLatch.countDown();
      }
    }
    paramh = logger;
    paramh.LogDebug("Exited from method %s", new Object[] { paramh.getMethodName() });
  }
  
  public void onReactorFinal(h arg1)
  {
    ??? = logger;
    ???.LogDebug("Entered in method %s", new Object[] { ???.getMethodName() });
    reactor = null;
    synchronized (closeLock)
    {
      closeLock.notifyLock();
      ??? = logger;
      ???.LogDebug("Exited from method %s", new Object[] { ???.getMethodName() });
      return;
    }
  }
  
  public void onReactorInit(h paramh)
  {
    Object localObject = logger;
    ((CustomLogger)localObject).LogDebug("Entered in method %s", new Object[] { ((CustomLogger)localObject).getMethodName() });
    localObject = ((g)paramh).b();
    paramh = hostName;
    int i;
    if (useWebSockets.booleanValue()) {
      i = 443;
    } else {
      i = 5671;
    }
    ((d)localObject).a(paramh, i, this);
    paramh = logger;
    paramh.LogDebug("Exited from method %s", new Object[] { paramh.getMethodName() });
  }
  
  public void onTransportError(h paramh)
  {
    super.onTransportError(paramh);
    isOpen = Boolean.valueOf(false);
  }
  
  public void onTransportHeadClosed(h paramh)
  {
    openLatch.countDown();
  }
  
  public void open()
  {
    CustomLogger localCustomLogger1 = logger;
    localCustomLogger1.LogDebug("Entered in method %s", new Object[] { localCustomLogger1.getMethodName() });
    if (!isOpen.booleanValue()) {
      try
      {
        openAmqpAsync();
        try
        {
          openLatch.await(60000L, TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException localInterruptedException)
        {
          logger.LogError(localInterruptedException);
          close();
          throw new IOException("Waited too long for the connection to open.");
        }
        if (!isOpen.booleanValue()) {
          break label136;
        }
      }
      catch (Exception localException)
      {
        logger.LogError(localException);
        close();
        throw new IOException("Error opening Amqp connection: ", localException);
      }
    }
    CustomLogger localCustomLogger2 = logger;
    localCustomLogger2.LogDebug("Exited from method %s", new Object[] { localCustomLogger2.getMethodName() });
    return;
    label136:
    throw new IOException("Failed to open the connection");
  }
  
  public void openAmqpAsync()
  {
    Object localObject = logger;
    ((CustomLogger)localObject).LogDebug("Entered in method %s", new Object[] { ((CustomLogger)localObject).getMethodName() });
    openLatch = new CountDownLatch(1);
    if (executorService == null) {
      executorService = Executors.newFixedThreadPool(1);
    }
    localObject = new ReactorRunner(new AmqpReactor(reactor), logger);
    executorService.submit((Callable)localObject);
    localObject = logger;
    ((CustomLogger)localObject).LogDebug("Exited from method %s", new Object[] { ((CustomLogger)localObject).getMethodName() });
  }
  
  public boolean sendAmqpMessage(AmqpMessage paramAmqpMessage)
  {
    Object localObject = saslListener;
    if ((localObject != null) && (((SaslListenerImpl)localObject).getSavedException() != null)) {
      throw saslListener.getSavedException();
    }
    localObject = logger;
    ((CustomLogger)localObject).LogDebug("Entered in method %s", new Object[] { ((CustomLogger)localObject).getMethodName() });
    if (!isOpen.booleanValue()) {}
    int k;
    byte[] arrayOfByte1;
    do
    {
      bool = false;
      break;
      byte[] arrayOfByte2 = new byte['Ѐ'];
      int i = 0;
      int j = 0;
      int m;
      do
      {
        try
        {
          k = paramAmqpMessage.encode(arrayOfByte2, 0);
          m = 1;
          localObject = arrayOfByte2;
        }
        catch (BufferOverflowException localBufferOverflowException)
        {
          arrayOfByte1 = new byte[arrayOfByte2.length * 2];
          k = j;
          m = i;
        }
        arrayOfByte2 = arrayOfByte1;
        i = m;
        j = k;
      } while (m == 0);
    } while (k <= 0);
    paramAmqpMessage = String.valueOf(nextTag).getBytes();
    long l = nextTag;
    if ((l != 2147483647L) && (l >= 0L)) {
      nextTag = (l + 1L);
    } else {
      nextTag = 0L;
    }
    amqpDeviceOperations.sendMessage(paramAmqpMessage, arrayOfByte1, k, 0);
    boolean bool = true;
    paramAmqpMessage = logger;
    paramAmqpMessage.LogDebug("Exited from method %s", new Object[] { paramAmqpMessage.getMethodName() });
    return bool;
  }
  
  public void setListener(AmqpListener paramAmqpListener)
  {
    if (paramAmqpListener != null)
    {
      msgListener = paramAmqpListener;
      return;
    }
    throw new IllegalArgumentException("The listener cannot be null.");
  }
  
  public class ReactorRunner
    implements Callable
  {
    public static final String THREAD_NAME = "azure-iot-sdk-ReactorRunner";
    public final AmqpReactor amqpReactor;
    public final CustomLogger logger;
    
    public ReactorRunner(AmqpReactor paramAmqpReactor, CustomLogger paramCustomLogger)
    {
      amqpReactor = paramAmqpReactor;
      logger = paramCustomLogger;
    }
    
    public Object call()
    {
      Thread.currentThread().setName("azure-iot-sdk-ReactorRunner");
      try
      {
        amqpReactor.run();
        return null;
      }
      catch (m localm)
      {
        logger.LogError(localm);
        throw localm;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.transport.amqp.AmqpsConnection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */