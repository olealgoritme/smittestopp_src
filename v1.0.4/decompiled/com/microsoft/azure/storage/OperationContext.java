package com.microsoft.azure.storage;

import java.net.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import k.f.b;
import k.f.c;

public final class OperationContext
{
  public static final String defaultLoggerName = "ROOT";
  public static boolean enableLoggingByDefault = false;
  public static StorageEventMultiCaster<ErrorReceivingResponseEvent, StorageEvent<ErrorReceivingResponseEvent>> globalErrorReceivingResponseEventHandler = new StorageEventMultiCaster();
  public static StorageEventMultiCaster<RequestCompletedEvent, StorageEvent<RequestCompletedEvent>> globalRequestCompletedEventHandler = new StorageEventMultiCaster();
  public static StorageEventMultiCaster<ResponseReceivedEvent, StorageEvent<ResponseReceivedEvent>> globalResponseReceivedEventHandler;
  public static StorageEventMultiCaster<RetryingEvent, StorageEvent<RetryingEvent>> globalRetryingEventHandler = new StorageEventMultiCaster();
  public static StorageEventMultiCaster<SendingRequestEvent, StorageEvent<SendingRequestEvent>> globalSendingRequestEventHandler = new StorageEventMultiCaster();
  public static Proxy proxyDefault;
  public String clientRequestID = UUID.randomUUID().toString();
  public long clientTimeInMs;
  public Boolean enableLogging;
  public StorageEventMultiCaster<ErrorReceivingResponseEvent, StorageEvent<ErrorReceivingResponseEvent>> errorReceivingResponseEventHandler = new StorageEventMultiCaster();
  public b logger;
  public Proxy proxy;
  public StorageEventMultiCaster<RequestCompletedEvent, StorageEvent<RequestCompletedEvent>> requestCompletedEventHandler = new StorageEventMultiCaster();
  public final ArrayList<RequestResult> requestResults = new ArrayList();
  public StorageEventMultiCaster<ResponseReceivedEvent, StorageEvent<ResponseReceivedEvent>> responseReceivedEventHandler = new StorageEventMultiCaster();
  public StorageEventMultiCaster<RetryingEvent, StorageEvent<RetryingEvent>> retryingEventHandler = new StorageEventMultiCaster();
  public StorageEventMultiCaster<SendingRequestEvent, StorageEvent<SendingRequestEvent>> sendingRequestEventHandler = new StorageEventMultiCaster();
  public HashMap<String, String> userHeaders;
  
  static
  {
    globalResponseReceivedEventHandler = new StorageEventMultiCaster();
  }
  
  public static Proxy getDefaultProxy()
  {
    return proxyDefault;
  }
  
  public static StorageEventMultiCaster<ErrorReceivingResponseEvent, StorageEvent<ErrorReceivingResponseEvent>> getGlobalErrorReceivingResponseEventHandler()
  {
    return globalErrorReceivingResponseEventHandler;
  }
  
  public static StorageEventMultiCaster<RequestCompletedEvent, StorageEvent<RequestCompletedEvent>> getGlobalRequestCompletedEventHandler()
  {
    return globalRequestCompletedEventHandler;
  }
  
  public static StorageEventMultiCaster<ResponseReceivedEvent, StorageEvent<ResponseReceivedEvent>> getGlobalResponseReceivedEventHandler()
  {
    return globalResponseReceivedEventHandler;
  }
  
  public static StorageEventMultiCaster<RetryingEvent, StorageEvent<RetryingEvent>> getGlobalRetryingEventHandler()
  {
    return globalRetryingEventHandler;
  }
  
  public static StorageEventMultiCaster<SendingRequestEvent, StorageEvent<SendingRequestEvent>> getGlobalSendingRequestEventHandler()
  {
    return globalSendingRequestEventHandler;
  }
  
  public static boolean isLoggingEnabledByDefault()
  {
    return enableLoggingByDefault;
  }
  
  private void setDefaultLoggerSynchronized()
  {
    try
    {
      if (logger == null) {
        logger = c.a("ROOT");
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void setDefaultProxy(Proxy paramProxy)
  {
    proxyDefault = paramProxy;
  }
  
  public static void setGlobalErrorReceivingResponseEventHandler(StorageEventMultiCaster<ErrorReceivingResponseEvent, StorageEvent<ErrorReceivingResponseEvent>> paramStorageEventMultiCaster)
  {
    globalErrorReceivingResponseEventHandler = paramStorageEventMultiCaster;
  }
  
  public static void setGlobalRequestCompletedEventHandler(StorageEventMultiCaster<RequestCompletedEvent, StorageEvent<RequestCompletedEvent>> paramStorageEventMultiCaster)
  {
    globalRequestCompletedEventHandler = paramStorageEventMultiCaster;
  }
  
  public static void setGlobalResponseReceivedEventHandler(StorageEventMultiCaster<ResponseReceivedEvent, StorageEvent<ResponseReceivedEvent>> paramStorageEventMultiCaster)
  {
    globalResponseReceivedEventHandler = paramStorageEventMultiCaster;
  }
  
  public static void setGlobalRetryingEventHandler(StorageEventMultiCaster<RetryingEvent, StorageEvent<RetryingEvent>> paramStorageEventMultiCaster)
  {
    globalRetryingEventHandler = paramStorageEventMultiCaster;
  }
  
  public static void setGlobalSendingRequestEventHandler(StorageEventMultiCaster<SendingRequestEvent, StorageEvent<SendingRequestEvent>> paramStorageEventMultiCaster)
  {
    globalSendingRequestEventHandler = paramStorageEventMultiCaster;
  }
  
  public static void setLoggingEnabledByDefault(boolean paramBoolean)
  {
    enableLoggingByDefault = paramBoolean;
  }
  
  public void appendRequestResult(RequestResult paramRequestResult)
  {
    try
    {
      requestResults.add(paramRequestResult);
      return;
    }
    finally
    {
      paramRequestResult = finally;
      throw paramRequestResult;
    }
  }
  
  public String getClientRequestID()
  {
    return clientRequestID;
  }
  
  public long getClientTimeInMs()
  {
    return clientTimeInMs;
  }
  
  public StorageEventMultiCaster<ErrorReceivingResponseEvent, StorageEvent<ErrorReceivingResponseEvent>> getErrorReceivingResponseEventHandler()
  {
    return errorReceivingResponseEventHandler;
  }
  
  public RequestResult getLastResult()
  {
    try
    {
      if ((requestResults != null) && (requestResults.size() != 0))
      {
        RequestResult localRequestResult = (RequestResult)requestResults.get(requestResults.size() - 1);
        return localRequestResult;
      }
      return null;
    }
    finally {}
  }
  
  public b getLogger()
  {
    if (logger == null) {
      setDefaultLoggerSynchronized();
    }
    return logger;
  }
  
  public Proxy getProxy()
  {
    return proxy;
  }
  
  public StorageEventMultiCaster<RequestCompletedEvent, StorageEvent<RequestCompletedEvent>> getRequestCompletedEventHandler()
  {
    return requestCompletedEventHandler;
  }
  
  public ArrayList<RequestResult> getRequestResults()
  {
    return requestResults;
  }
  
  public StorageEventMultiCaster<ResponseReceivedEvent, StorageEvent<ResponseReceivedEvent>> getResponseReceivedEventHandler()
  {
    return responseReceivedEventHandler;
  }
  
  public StorageEventMultiCaster<RetryingEvent, StorageEvent<RetryingEvent>> getRetryingEventHandler()
  {
    return retryingEventHandler;
  }
  
  public StorageEventMultiCaster<SendingRequestEvent, StorageEvent<SendingRequestEvent>> getSendingRequestEventHandler()
  {
    return sendingRequestEventHandler;
  }
  
  public HashMap<String, String> getUserHeaders()
  {
    return userHeaders;
  }
  
  public void initialize()
  {
    setClientTimeInMs(0L);
    requestResults.clear();
  }
  
  public boolean isLoggingEnabled()
  {
    Boolean localBoolean = enableLogging;
    if (localBoolean == null) {
      return enableLoggingByDefault;
    }
    return localBoolean.booleanValue();
  }
  
  public void setClientRequestID(String paramString)
  {
    clientRequestID = paramString;
  }
  
  public void setClientTimeInMs(long paramLong)
  {
    clientTimeInMs = paramLong;
  }
  
  public void setErrorReceivingResponseEventHandler(StorageEventMultiCaster<ErrorReceivingResponseEvent, StorageEvent<ErrorReceivingResponseEvent>> paramStorageEventMultiCaster)
  {
    errorReceivingResponseEventHandler = paramStorageEventMultiCaster;
  }
  
  public void setLogger(b paramb)
  {
    logger = paramb;
  }
  
  public void setLoggingEnabled(boolean paramBoolean)
  {
    enableLogging = Boolean.valueOf(paramBoolean);
  }
  
  public void setProxy(Proxy paramProxy)
  {
    proxy = paramProxy;
  }
  
  public void setRequestCompletedEventHandler(StorageEventMultiCaster<RequestCompletedEvent, StorageEvent<RequestCompletedEvent>> paramStorageEventMultiCaster)
  {
    requestCompletedEventHandler = paramStorageEventMultiCaster;
  }
  
  public void setResponseReceivedEventHandler(StorageEventMultiCaster<ResponseReceivedEvent, StorageEvent<ResponseReceivedEvent>> paramStorageEventMultiCaster)
  {
    responseReceivedEventHandler = paramStorageEventMultiCaster;
  }
  
  public void setRetryingEventHandler(StorageEventMultiCaster<RetryingEvent, StorageEvent<RetryingEvent>> paramStorageEventMultiCaster)
  {
    retryingEventHandler = paramStorageEventMultiCaster;
  }
  
  public void setSendingRequestEventHandler(StorageEventMultiCaster<SendingRequestEvent, StorageEvent<SendingRequestEvent>> paramStorageEventMultiCaster)
  {
    sendingRequestEventHandler = paramStorageEventMultiCaster;
  }
  
  public void setUserHeaders(HashMap<String, String> paramHashMap)
  {
    userHeaders = paramHashMap;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.OperationContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */