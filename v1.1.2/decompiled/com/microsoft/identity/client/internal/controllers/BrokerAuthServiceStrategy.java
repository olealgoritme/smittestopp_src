package com.microsoft.identity.client.internal.controllers;

import android.content.Intent;
import android.os.Bundle;
import com.microsoft.identity.client.IMicrosoftAuthService;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.request.AcquireTokenOperationParameters;
import com.microsoft.identity.common.internal.request.AcquireTokenSilentOperationParameters;
import com.microsoft.identity.common.internal.request.MsalBrokerRequestAdapter;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.result.AcquireTokenResult;
import com.microsoft.identity.common.internal.result.MsalBrokerResultAdapter;
import e.a.a.a.a;
import java.util.List;

public class BrokerAuthServiceStrategy
  extends BrokerBaseStrategy
{
  public static final String TAG = "BrokerAuthServiceStrategy";
  
  private Intent getBrokerAuthorizationIntentFromAuthService(AcquireTokenOperationParameters paramAcquireTokenOperationParameters)
  {
    (Intent)performAuthServiceOperation(paramAcquireTokenOperationParameters.getAppContext(), new AuthServiceOperation()
    {
      public String getOperationName()
      {
        return ":getBrokerAuthorizationIntentFromAuthService";
      }
      
      public Intent perform(IMicrosoftAuthService paramAnonymousIMicrosoftAuthService)
      {
        return paramAnonymousIMicrosoftAuthService.getIntentForInteractiveRequest();
      }
    });
  }
  
  /* Error */
  private <T> T performAuthServiceOperation(android.content.Context paramContext, AuthServiceOperation<T> paramAuthServiceOperation)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokeinterface 61 1 0
    //   6: astore_3
    //   7: new 63	com/microsoft/identity/common/internal/telemetry/events/BrokerStartEvent
    //   10: dup
    //   11: invokespecial 64	com/microsoft/identity/common/internal/telemetry/events/BrokerStartEvent:<init>	()V
    //   14: aload_3
    //   15: invokevirtual 68	com/microsoft/identity/common/internal/telemetry/events/BrokerStartEvent:putAction	(Ljava/lang/String;)Lcom/microsoft/identity/common/internal/telemetry/events/BrokerStartEvent;
    //   18: ldc 70
    //   20: invokevirtual 73	com/microsoft/identity/common/internal/telemetry/events/BrokerStartEvent:putStrategy	(Ljava/lang/String;)Lcom/microsoft/identity/common/internal/telemetry/events/BrokerStartEvent;
    //   23: invokestatic 79	com/microsoft/identity/common/internal/telemetry/Telemetry:emit	(Lcom/microsoft/identity/common/internal/telemetry/events/BaseEvent;)V
    //   26: new 81	com/microsoft/identity/common/internal/broker/MicrosoftAuthClient
    //   29: dup
    //   30: aload_1
    //   31: invokespecial 84	com/microsoft/identity/common/internal/broker/MicrosoftAuthClient:<init>	(Landroid/content/Context;)V
    //   34: astore 4
    //   36: aload_2
    //   37: aload 4
    //   39: invokevirtual 88	com/microsoft/identity/common/internal/broker/MicrosoftAuthClient:connect	()Lcom/microsoft/identity/common/internal/broker/MicrosoftAuthServiceFuture;
    //   42: invokevirtual 94	com/microsoft/identity/common/internal/broker/MicrosoftAuthServiceFuture:get	()Lcom/microsoft/identity/client/IMicrosoftAuthService;
    //   45: invokeinterface 98 2 0
    //   50: astore_1
    //   51: aload 4
    //   53: invokevirtual 101	com/microsoft/identity/common/internal/broker/MicrosoftAuthClient:disconnect	()V
    //   56: new 103	com/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent
    //   59: dup
    //   60: invokespecial 104	com/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent:<init>	()V
    //   63: aload_3
    //   64: invokevirtual 107	com/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent:putAction	(Ljava/lang/String;)Lcom/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent;
    //   67: iconst_1
    //   68: invokevirtual 111	com/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent:isSuccessful	(Z)Lcom/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent;
    //   71: invokestatic 79	com/microsoft/identity/common/internal/telemetry/Telemetry:emit	(Lcom/microsoft/identity/common/internal/telemetry/events/BaseEvent;)V
    //   74: aload_1
    //   75: areturn
    //   76: astore_1
    //   77: goto +182 -> 259
    //   80: astore_1
    //   81: new 113	java/lang/StringBuilder
    //   84: astore_2
    //   85: aload_2
    //   86: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   89: aload_2
    //   90: getstatic 116	com/microsoft/identity/client/internal/controllers/BrokerAuthServiceStrategy:TAG	Ljava/lang/String;
    //   93: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_2
    //   98: aload_3
    //   99: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload_2
    //   104: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: aload_1
    //   108: invokevirtual 126	com/microsoft/identity/common/exception/BaseException:getMessage	()Ljava/lang/String;
    //   111: aload_1
    //   112: invokestatic 132	com/microsoft/identity/common/internal/logging/Logger:error	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: new 103	com/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent
    //   118: astore_2
    //   119: aload_2
    //   120: invokespecial 104	com/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent:<init>	()V
    //   123: aload_2
    //   124: aload_3
    //   125: invokevirtual 107	com/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent:putAction	(Ljava/lang/String;)Lcom/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent;
    //   128: iconst_0
    //   129: invokevirtual 111	com/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent:isSuccessful	(Z)Lcom/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent;
    //   132: aload_1
    //   133: invokevirtual 135	com/microsoft/identity/common/exception/BaseException:getErrorCode	()Ljava/lang/String;
    //   136: invokevirtual 138	com/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent:putErrorCode	(Ljava/lang/String;)Lcom/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent;
    //   139: aload_1
    //   140: invokevirtual 126	com/microsoft/identity/common/exception/BaseException:getMessage	()Ljava/lang/String;
    //   143: invokevirtual 141	com/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent:putErrorDescription	(Ljava/lang/String;)Lcom/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent;
    //   146: invokestatic 79	com/microsoft/identity/common/internal/telemetry/Telemetry:emit	(Lcom/microsoft/identity/common/internal/telemetry/events/BaseEvent;)V
    //   149: aload_1
    //   150: athrow
    //   151: astore_1
    //   152: goto +8 -> 160
    //   155: astore_1
    //   156: goto +4 -> 160
    //   159: astore_1
    //   160: aload_1
    //   161: instanceof 51
    //   164: ifeq +9 -> 173
    //   167: ldc -113
    //   169: astore_2
    //   170: goto +6 -> 176
    //   173: ldc -111
    //   175: astore_2
    //   176: new 113	java/lang/StringBuilder
    //   179: astore 5
    //   181: aload 5
    //   183: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   186: aload 5
    //   188: getstatic 116	com/microsoft/identity/client/internal/controllers/BrokerAuthServiceStrategy:TAG	Ljava/lang/String;
    //   191: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 5
    //   197: aload_3
    //   198: invokevirtual 120	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload 5
    //   204: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: aload_2
    //   208: aload_1
    //   209: invokestatic 132	com/microsoft/identity/common/internal/logging/Logger:error	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   212: new 103	com/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent
    //   215: astore 5
    //   217: aload 5
    //   219: invokespecial 104	com/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent:<init>	()V
    //   222: aload 5
    //   224: aload_3
    //   225: invokevirtual 107	com/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent:putAction	(Ljava/lang/String;)Lcom/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent;
    //   228: iconst_0
    //   229: invokevirtual 111	com/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent:isSuccessful	(Z)Lcom/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent;
    //   232: ldc -109
    //   234: invokevirtual 138	com/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent:putErrorCode	(Ljava/lang/String;)Lcom/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent;
    //   237: aload_1
    //   238: invokevirtual 150	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   241: invokevirtual 141	com/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent:putErrorDescription	(Ljava/lang/String;)Lcom/microsoft/identity/common/internal/telemetry/events/BrokerEndEvent;
    //   244: invokestatic 79	com/microsoft/identity/common/internal/telemetry/Telemetry:emit	(Lcom/microsoft/identity/common/internal/telemetry/events/BaseEvent;)V
    //   247: new 152	com/microsoft/identity/client/exception/BrokerCommunicationException
    //   250: astore_3
    //   251: aload_3
    //   252: aload_2
    //   253: aload_1
    //   254: invokespecial 155	com/microsoft/identity/client/exception/BrokerCommunicationException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   257: aload_3
    //   258: athrow
    //   259: aload 4
    //   261: invokevirtual 101	com/microsoft/identity/common/internal/broker/MicrosoftAuthClient:disconnect	()V
    //   264: aload_1
    //   265: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	BrokerAuthServiceStrategy
    //   0	266	1	paramContext	android.content.Context
    //   0	266	2	paramAuthServiceOperation	AuthServiceOperation<T>
    //   6	252	3	localObject1	Object
    //   34	226	4	localMicrosoftAuthClient	com.microsoft.identity.common.internal.broker.MicrosoftAuthClient
    //   179	44	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   36	51	76	finally
    //   81	151	76	finally
    //   160	167	76	finally
    //   176	259	76	finally
    //   36	51	80	com/microsoft/identity/common/exception/BaseException
    //   36	51	151	java/util/concurrent/ExecutionException
    //   36	51	155	java/lang/InterruptedException
    //   36	51	159	android/os/RemoteException
  }
  
  public AcquireTokenResult acquireTokenSilent(final AcquireTokenSilentOperationParameters paramAcquireTokenSilentOperationParameters)
  {
    (AcquireTokenResult)performAuthServiceOperation(paramAcquireTokenSilentOperationParameters.getAppContext(), new AuthServiceOperation()
    {
      public String getOperationName()
      {
        return ":acquireTokenSilentWithAuthService";
      }
      
      public AcquireTokenResult perform(IMicrosoftAuthService paramAnonymousIMicrosoftAuthService)
      {
        Bundle localBundle = mRequestAdapter.getRequestBundleForAcquireTokenSilent(paramAcquireTokenSilentOperationParameters);
        return mResultAdapter.getAcquireTokenResultFromResultBundle(paramAnonymousIMicrosoftAuthService.acquireTokenSilently(localBundle));
      }
    });
  }
  
  public List<ICacheRecord> getBrokerAccounts(final OperationParameters paramOperationParameters)
  {
    (List)performAuthServiceOperation(paramOperationParameters.getAppContext(), new AuthServiceOperation()
    {
      public String getOperationName()
      {
        return ":getBrokerAccountsWithAuthService";
      }
      
      public List<ICacheRecord> perform(IMicrosoftAuthService paramAnonymousIMicrosoftAuthService)
      {
        Bundle localBundle = mRequestAdapter.getRequestBundleForGetAccounts(paramOperationParameters);
        return mResultAdapter.getAccountsFromResultBundle(paramAnonymousIMicrosoftAuthService.getAccounts(localBundle));
      }
    });
  }
  
  public Intent getBrokerAuthorizationIntent(AcquireTokenOperationParameters paramAcquireTokenOperationParameters)
  {
    a.b(new StringBuilder(), TAG, ":getBrokerAuthorizationIntent", "Get the broker authorization intent from auth service.");
    return completeInteractiveRequestIntent(getBrokerAuthorizationIntentFromAuthService(paramAcquireTokenOperationParameters), paramAcquireTokenOperationParameters);
  }
  
  public List<ICacheRecord> getCurrentAccountInSharedDevice(final OperationParameters paramOperationParameters)
  {
    (List)performAuthServiceOperation(paramOperationParameters.getAppContext(), new AuthServiceOperation()
    {
      public String getOperationName()
      {
        return ":getCurrentAccountInSharedDeviceWithAuthService";
      }
      
      public List<ICacheRecord> perform(IMicrosoftAuthService paramAnonymousIMicrosoftAuthService)
      {
        Bundle localBundle = mRequestAdapter.getRequestBundleForGetAccounts(paramOperationParameters);
        return mResultAdapter.getAccountsFromResultBundle(paramAnonymousIMicrosoftAuthService.getCurrentAccount(localBundle));
      }
    });
  }
  
  public boolean getDeviceMode(OperationParameters paramOperationParameters)
  {
    ((Boolean)performAuthServiceOperation(paramOperationParameters.getAppContext(), new AuthServiceOperation()
    {
      public String getOperationName()
      {
        return ":getDeviceModeWithAuthService";
      }
      
      public Boolean perform(IMicrosoftAuthService paramAnonymousIMicrosoftAuthService)
      {
        return Boolean.valueOf(mResultAdapter.getDeviceModeFromResultBundle(paramAnonymousIMicrosoftAuthService.getDeviceMode()));
      }
    })).booleanValue();
  }
  
  public void hello(final OperationParameters paramOperationParameters)
  {
    performAuthServiceOperation(paramOperationParameters.getAppContext(), new AuthServiceOperation()
    {
      public String getOperationName()
      {
        return ":helloWithMicrosoftAuthService";
      }
      
      public Void perform(IMicrosoftAuthService paramAnonymousIMicrosoftAuthService)
      {
        Bundle localBundle = mRequestAdapter.getRequestBundleForHello(paramOperationParameters);
        mResultAdapter.verifyHelloFromResultBundle(paramAnonymousIMicrosoftAuthService.hello(localBundle));
        return null;
      }
    });
  }
  
  public void removeBrokerAccount(final OperationParameters paramOperationParameters)
  {
    performAuthServiceOperation(paramOperationParameters.getAppContext(), new AuthServiceOperation()
    {
      public String getOperationName()
      {
        return ":removeBrokerAccountWithAuthService";
      }
      
      public Void perform(IMicrosoftAuthService paramAnonymousIMicrosoftAuthService)
      {
        Bundle localBundle = mRequestAdapter.getRequestBundleForRemoveAccount(paramOperationParameters);
        mResultAdapter.verifyRemoveAccountResultFromBundle(paramAnonymousIMicrosoftAuthService.removeAccount(localBundle));
        return null;
      }
    });
  }
  
  public void signOutFromSharedDevice(final OperationParameters paramOperationParameters)
  {
    performAuthServiceOperation(paramOperationParameters.getAppContext(), new AuthServiceOperation()
    {
      public String getOperationName()
      {
        return ":signOutFromSharedDeviceWithAuthService";
      }
      
      public Void perform(IMicrosoftAuthService paramAnonymousIMicrosoftAuthService)
      {
        Bundle localBundle = mRequestAdapter.getRequestBundleForRemoveAccountFromSharedDevice(paramOperationParameters);
        mResultAdapter.verifyRemoveAccountResultFromBundle(paramAnonymousIMicrosoftAuthService.removeAccountFromSharedDevice(localBundle));
        return null;
      }
    });
  }
  
  public static abstract interface AuthServiceOperation<T>
  {
    public abstract String getOperationName();
    
    public abstract T perform(IMicrosoftAuthService paramIMicrosoftAuthService);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.client.internal.controllers.BrokerAuthServiceStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */