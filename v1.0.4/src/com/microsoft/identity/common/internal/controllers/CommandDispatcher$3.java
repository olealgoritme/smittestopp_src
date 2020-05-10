package com.microsoft.identity.common.internal.controllers;

import d.q.a.a;

public final class CommandDispatcher$3
  implements Runnable
{
  public CommandDispatcher$3(InteractiveTokenCommand paramInteractiveTokenCommand, a parama) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/microsoft/identity/common/internal/controllers/CommandDispatcher$3:val$command	Lcom/microsoft/identity/common/internal/controllers/InteractiveTokenCommand;
    //   4: invokevirtual 44	com/microsoft/identity/common/internal/controllers/BaseCommand:getParameters	()Lcom/microsoft/identity/common/internal/request/OperationParameters;
    //   7: invokevirtual 50	com/microsoft/identity/common/internal/request/OperationParameters:getCorrelationId	()Ljava/lang/String;
    //   10: invokestatic 54	com/microsoft/identity/common/internal/controllers/CommandDispatcher:initializeDiagnosticContext	(Ljava/lang/String;)Ljava/lang/String;
    //   13: astore_1
    //   14: invokestatic 60	com/microsoft/identity/common/internal/eststelemetry/EstsTelemetry:getInstance	()Lcom/microsoft/identity/common/internal/eststelemetry/EstsTelemetry;
    //   17: aload_0
    //   18: getfield 29	com/microsoft/identity/common/internal/controllers/CommandDispatcher$3:val$command	Lcom/microsoft/identity/common/internal/controllers/InteractiveTokenCommand;
    //   21: invokevirtual 63	com/microsoft/identity/common/internal/controllers/BaseCommand:getPublicApiId	()Ljava/lang/String;
    //   24: invokevirtual 67	com/microsoft/identity/common/internal/eststelemetry/EstsTelemetry:emitApiId	(Ljava/lang/String;)V
    //   27: aload_0
    //   28: getfield 29	com/microsoft/identity/common/internal/controllers/CommandDispatcher$3:val$command	Lcom/microsoft/identity/common/internal/controllers/InteractiveTokenCommand;
    //   31: invokevirtual 44	com/microsoft/identity/common/internal/controllers/BaseCommand:getParameters	()Lcom/microsoft/identity/common/internal/request/OperationParameters;
    //   34: instanceof 69
    //   37: ifeq +18 -> 55
    //   40: ldc 71
    //   42: aload_0
    //   43: getfield 29	com/microsoft/identity/common/internal/controllers/CommandDispatcher$3:val$command	Lcom/microsoft/identity/common/internal/controllers/InteractiveTokenCommand;
    //   46: invokevirtual 44	com/microsoft/identity/common/internal/controllers/BaseCommand:getParameters	()Lcom/microsoft/identity/common/internal/request/OperationParameters;
    //   49: checkcast 69	com/microsoft/identity/common/internal/request/AcquireTokenOperationParameters
    //   52: invokestatic 75	com/microsoft/identity/common/internal/controllers/CommandDispatcher:access$600	(Ljava/lang/String;Lcom/microsoft/identity/common/internal/request/AcquireTokenOperationParameters;)V
    //   55: new 13	com/microsoft/identity/common/internal/controllers/CommandDispatcher$3$1
    //   58: dup
    //   59: aload_0
    //   60: invokespecial 78	com/microsoft/identity/common/internal/controllers/CommandDispatcher$3$1:<init>	(Lcom/microsoft/identity/common/internal/controllers/CommandDispatcher$3;)V
    //   63: astore_2
    //   64: aconst_null
    //   65: astore_3
    //   66: aload_0
    //   67: getfield 31	com/microsoft/identity/common/internal/controllers/CommandDispatcher$3:val$localBroadcastManager	Ld/q/a/a;
    //   70: astore 4
    //   72: new 80	android/content/IntentFilter
    //   75: astore 5
    //   77: aload 5
    //   79: ldc 82
    //   81: invokespecial 84	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   84: aload 4
    //   86: aload_2
    //   87: aload 5
    //   89: invokevirtual 90	d/q/a/a:a	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V
    //   92: aload_0
    //   93: getfield 29	com/microsoft/identity/common/internal/controllers/CommandDispatcher$3:val$command	Lcom/microsoft/identity/common/internal/controllers/InteractiveTokenCommand;
    //   96: invokestatic 94	com/microsoft/identity/common/internal/controllers/CommandDispatcher:access$802	(Lcom/microsoft/identity/common/internal/controllers/InteractiveTokenCommand;)Lcom/microsoft/identity/common/internal/controllers/InteractiveTokenCommand;
    //   99: pop
    //   100: aload_0
    //   101: getfield 29	com/microsoft/identity/common/internal/controllers/CommandDispatcher$3:val$command	Lcom/microsoft/identity/common/internal/controllers/InteractiveTokenCommand;
    //   104: invokevirtual 100	com/microsoft/identity/common/internal/controllers/InteractiveTokenCommand:execute	()Lcom/microsoft/identity/common/internal/result/AcquireTokenResult;
    //   107: astore 4
    //   109: aconst_null
    //   110: invokestatic 94	com/microsoft/identity/common/internal/controllers/CommandDispatcher:access$802	(Lcom/microsoft/identity/common/internal/controllers/InteractiveTokenCommand;)Lcom/microsoft/identity/common/internal/controllers/InteractiveTokenCommand;
    //   113: pop
    //   114: aload_0
    //   115: getfield 31	com/microsoft/identity/common/internal/controllers/CommandDispatcher$3:val$localBroadcastManager	Ld/q/a/a;
    //   118: aload_2
    //   119: invokevirtual 103	d/q/a/a:a	(Landroid/content/BroadcastReceiver;)V
    //   122: goto +82 -> 204
    //   125: astore_3
    //   126: goto +206 -> 332
    //   129: astore 4
    //   131: new 105	java/lang/StringBuilder
    //   134: astore_3
    //   135: aload_3
    //   136: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   139: aload_3
    //   140: invokestatic 109	com/microsoft/identity/common/internal/controllers/CommandDispatcher:access$400	()Ljava/lang/String;
    //   143: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload_3
    //   148: ldc 71
    //   150: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload_3
    //   155: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: ldc 118
    //   160: aload 4
    //   162: invokestatic 124	com/microsoft/identity/common/internal/logging/Logger:errorPII	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   165: aload 4
    //   167: instanceof 126
    //   170: ifeq +12 -> 182
    //   173: aload 4
    //   175: checkcast 126	com/microsoft/identity/common/exception/BaseException
    //   178: astore_3
    //   179: goto +9 -> 188
    //   182: aload 4
    //   184: invokestatic 132	com/microsoft/identity/common/internal/controllers/ExceptionAdapter:baseExceptionFromException	(Ljava/lang/Exception;)Lcom/microsoft/identity/common/exception/BaseException;
    //   187: astore_3
    //   188: aconst_null
    //   189: invokestatic 94	com/microsoft/identity/common/internal/controllers/CommandDispatcher:access$802	(Lcom/microsoft/identity/common/internal/controllers/InteractiveTokenCommand;)Lcom/microsoft/identity/common/internal/controllers/InteractiveTokenCommand;
    //   192: pop
    //   193: aload_0
    //   194: getfield 31	com/microsoft/identity/common/internal/controllers/CommandDispatcher$3:val$localBroadcastManager	Ld/q/a/a;
    //   197: aload_2
    //   198: invokevirtual 103	d/q/a/a:a	(Landroid/content/BroadcastReceiver;)V
    //   201: aconst_null
    //   202: astore 4
    //   204: new 134	android/os/Handler
    //   207: dup
    //   208: invokestatic 140	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   211: invokespecial 143	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   214: astore_2
    //   215: aload_3
    //   216: ifnull +20 -> 236
    //   219: aload_2
    //   220: new 15	com/microsoft/identity/common/internal/controllers/CommandDispatcher$3$2
    //   223: dup
    //   224: aload_0
    //   225: aload_3
    //   226: invokespecial 146	com/microsoft/identity/common/internal/controllers/CommandDispatcher$3$2:<init>	(Lcom/microsoft/identity/common/internal/controllers/CommandDispatcher$3;Lcom/microsoft/identity/common/exception/BaseException;)V
    //   229: invokevirtual 150	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   232: pop
    //   233: goto +83 -> 316
    //   236: aload 4
    //   238: ifnull +35 -> 273
    //   241: aload 4
    //   243: invokevirtual 156	com/microsoft/identity/common/internal/result/AcquireTokenResult:getSucceeded	()Ljava/lang/Boolean;
    //   246: invokevirtual 162	java/lang/Boolean:booleanValue	()Z
    //   249: ifeq +24 -> 273
    //   252: aload_2
    //   253: new 17	com/microsoft/identity/common/internal/controllers/CommandDispatcher$3$3
    //   256: dup
    //   257: aload_0
    //   258: aload 4
    //   260: invokevirtual 166	com/microsoft/identity/common/internal/result/AcquireTokenResult:getLocalAuthenticationResult	()Lcom/microsoft/identity/common/internal/result/ILocalAuthenticationResult;
    //   263: invokespecial 169	com/microsoft/identity/common/internal/controllers/CommandDispatcher$3$3:<init>	(Lcom/microsoft/identity/common/internal/controllers/CommandDispatcher$3;Lcom/microsoft/identity/common/internal/result/ILocalAuthenticationResult;)V
    //   266: invokevirtual 150	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   269: pop
    //   270: goto +46 -> 316
    //   273: aload 4
    //   275: invokestatic 173	com/microsoft/identity/common/internal/controllers/ExceptionAdapter:exceptionFromAcquireTokenResult	(Lcom/microsoft/identity/common/internal/result/AcquireTokenResult;)Lcom/microsoft/identity/common/exception/BaseException;
    //   278: astore_3
    //   279: aload_3
    //   280: instanceof 175
    //   283: ifeq +19 -> 302
    //   286: aload_2
    //   287: new 19	com/microsoft/identity/common/internal/controllers/CommandDispatcher$3$4
    //   290: dup
    //   291: aload_0
    //   292: invokespecial 176	com/microsoft/identity/common/internal/controllers/CommandDispatcher$3$4:<init>	(Lcom/microsoft/identity/common/internal/controllers/CommandDispatcher$3;)V
    //   295: invokevirtual 150	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   298: pop
    //   299: goto +17 -> 316
    //   302: aload_2
    //   303: new 21	com/microsoft/identity/common/internal/controllers/CommandDispatcher$3$5
    //   306: dup
    //   307: aload_0
    //   308: aload_3
    //   309: invokespecial 177	com/microsoft/identity/common/internal/controllers/CommandDispatcher$3$5:<init>	(Lcom/microsoft/identity/common/internal/controllers/CommandDispatcher$3;Lcom/microsoft/identity/common/exception/BaseException;)V
    //   312: invokevirtual 150	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   315: pop
    //   316: invokestatic 60	com/microsoft/identity/common/internal/eststelemetry/EstsTelemetry:getInstance	()Lcom/microsoft/identity/common/internal/eststelemetry/EstsTelemetry;
    //   319: aload_1
    //   320: aload_3
    //   321: invokevirtual 181	com/microsoft/identity/common/internal/eststelemetry/EstsTelemetry:flush	(Ljava/lang/String;Lcom/microsoft/identity/common/exception/BaseException;)V
    //   324: invokestatic 186	com/microsoft/identity/common/internal/telemetry/Telemetry:getInstance	()Lcom/microsoft/identity/common/internal/telemetry/Telemetry;
    //   327: aload_1
    //   328: invokevirtual 188	com/microsoft/identity/common/internal/telemetry/Telemetry:flush	(Ljava/lang/String;)V
    //   331: return
    //   332: aconst_null
    //   333: invokestatic 94	com/microsoft/identity/common/internal/controllers/CommandDispatcher:access$802	(Lcom/microsoft/identity/common/internal/controllers/InteractiveTokenCommand;)Lcom/microsoft/identity/common/internal/controllers/InteractiveTokenCommand;
    //   336: pop
    //   337: aload_0
    //   338: getfield 31	com/microsoft/identity/common/internal/controllers/CommandDispatcher$3:val$localBroadcastManager	Ld/q/a/a;
    //   341: aload_2
    //   342: invokevirtual 103	d/q/a/a:a	(Landroid/content/BroadcastReceiver;)V
    //   345: aload_3
    //   346: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	this	3
    //   13	315	1	str	String
    //   63	279	2	localObject1	Object
    //   65	1	3	localObject2	Object
    //   125	1	3	localObject3	Object
    //   134	212	3	localObject4	Object
    //   70	38	4	localObject5	Object
    //   129	54	4	localException	Exception
    //   202	72	4	localAcquireTokenResult	com.microsoft.identity.common.internal.result.AcquireTokenResult
    //   75	13	5	localIntentFilter	android.content.IntentFilter
    // Exception table:
    //   from	to	target	type
    //   66	109	125	finally
    //   131	179	125	finally
    //   182	188	125	finally
    //   66	109	129	java/lang/Exception
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.controllers.CommandDispatcher.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */