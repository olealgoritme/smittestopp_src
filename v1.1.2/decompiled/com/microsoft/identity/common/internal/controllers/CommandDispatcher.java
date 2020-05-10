package com.microsoft.identity.common.internal.controllers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.exception.IntuneAppProtectionPolicyRequiredException;
import com.microsoft.identity.common.exception.UserCancelException;
import com.microsoft.identity.common.internal.dto.IAccountRecord;
import com.microsoft.identity.common.internal.eststelemetry.EstsTelemetry;
import com.microsoft.identity.common.internal.logging.DiagnosticContext;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.logging.RequestContext;
import com.microsoft.identity.common.internal.request.AcquireTokenOperationParameters;
import com.microsoft.identity.common.internal.request.AcquireTokenSilentOperationParameters;
import com.microsoft.identity.common.internal.request.BrokerAcquireTokenOperationParameters;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.result.AcquireTokenResult;
import com.microsoft.identity.common.internal.result.ILocalAuthenticationResult;
import com.microsoft.identity.common.internal.telemetry.Telemetry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CommandDispatcher
{
  public static final String TAG = "CommandDispatcher";
  public static InteractiveTokenCommand sCommand = null;
  public static final CommandResultCache sCommandResultCache = new CommandResultCache();
  public static final ExecutorService sInteractiveExecutor = ;
  public static final Object sLock;
  public static final ExecutorService sSilentExecutor = Executors.newCachedThreadPool();
  
  static
  {
    sLock = new Object();
  }
  
  public static void beginInteractive(InteractiveTokenCommand paramInteractiveTokenCommand)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append(TAG);
    ((StringBuilder)???).append(":beginInteractive");
    Logger.info(((StringBuilder)???).toString(), "Beginning interactive request");
    synchronized (sLock)
    {
      d.q.a.a locala = d.q.a.a.a(paramInteractiveTokenCommand.getParameters().getAppContext());
      if ((paramInteractiveTokenCommand.getParameters() instanceof BrokerAcquireTokenOperationParameters))
      {
        localObject2 = new android/content/Intent;
        ((Intent)localObject2).<init>("cancel_interactive_request");
        locala.a((Intent)localObject2);
      }
      ExecutorService localExecutorService = sInteractiveExecutor;
      Object localObject2 = new com/microsoft/identity/common/internal/controllers/CommandDispatcher$3;
      ((3)localObject2).<init>(paramInteractiveTokenCommand, locala);
      localExecutorService.execute((Runnable)localObject2);
      return;
    }
  }
  
  public static void cacheCommandResult(BaseCommand paramBaseCommand, CommandResult paramCommandResult)
  {
    if ((paramBaseCommand.isEligibleForCaching()) && (eligibleToCache(paramCommandResult))) {
      sCommandResultCache.put(paramBaseCommand, paramCommandResult);
    }
  }
  
  public static void clearCommandCache()
  {
    sCommandResultCache.clear();
  }
  
  public static void completeInteractive(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("com.microsoft.identity.client.request.code", 0);
    int j = paramIntent.getIntExtra("com.microsoft.identity.client.result.code", 0);
    InteractiveTokenCommand localInteractiveTokenCommand = sCommand;
    if (localInteractiveTokenCommand != null) {
      localInteractiveTokenCommand.notify(i, j, paramIntent);
    } else {
      e.a.a.a.a.c(new StringBuilder(), TAG, ":completeInteractive", "sCommand is null, No interactive call in progress to complete.");
    }
  }
  
  public static boolean eligibleToCache(CommandResult paramCommandResult)
  {
    int i = paramCommandResult.getStatus().ordinal();
    if (i != 1)
    {
      if (i != 2) {
        return false;
      }
      return eligibleToCacheException((BaseException)paramCommandResult.getResult());
    }
    return true;
  }
  
  public static boolean eligibleToCacheException(BaseException paramBaseException)
  {
    return !(paramBaseException instanceof IntuneAppProtectionPolicyRequiredException);
  }
  
  public static CommandResult executeCommand(BaseCommand paramBaseCommand)
  {
    BaseCommand localBaseCommand = null;
    try
    {
      paramBaseCommand = paramBaseCommand.execute();
    }
    catch (Exception paramBaseCommand)
    {
      if ((paramBaseCommand instanceof BaseException)) {
        paramBaseCommand = (BaseException)paramBaseCommand;
      } else {
        paramBaseCommand = ExceptionAdapter.baseExceptionFromException(paramBaseCommand);
      }
      localBaseCommand = paramBaseCommand;
      paramBaseCommand = null;
    }
    if (localBaseCommand != null) {
      paramBaseCommand = new CommandResult(CommandResult.ResultStatus.ERROR, localBaseCommand);
    } else if ((paramBaseCommand != null) && ((paramBaseCommand instanceof AcquireTokenResult))) {
      paramBaseCommand = getCommandResultFromTokenResult(localBaseCommand, (AcquireTokenResult)paramBaseCommand);
    } else {
      paramBaseCommand = new CommandResult(CommandResult.ResultStatus.COMPLETED, paramBaseCommand);
    }
    return paramBaseCommand;
  }
  
  public static int getCachedResultCount()
  {
    return sCommandResultCache.getSize();
  }
  
  public static CommandResult getCommandResultFromTokenResult(BaseException paramBaseException, AcquireTokenResult paramAcquireTokenResult)
  {
    if (paramAcquireTokenResult.getSucceeded().booleanValue()) {
      return new CommandResult(CommandResult.ResultStatus.COMPLETED, paramAcquireTokenResult.getLocalAuthenticationResult());
    }
    paramBaseException = ExceptionAdapter.exceptionFromAcquireTokenResult(paramAcquireTokenResult);
    if ((paramBaseException instanceof UserCancelException)) {
      return new CommandResult(CommandResult.ResultStatus.CANCEL, null);
    }
    return new CommandResult(CommandResult.ResultStatus.ERROR, paramBaseException);
  }
  
  public static String initializeDiagnosticContext(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = UUID.randomUUID().toString();
    }
    paramString = new RequestContext();
    paramString.put("correlation_id", str);
    DiagnosticContext.setRequestContext(paramString);
    e.a.a.a.a.b(new StringBuilder(), TAG, ":initializeDiagnosticContext", "Initialized new DiagnosticContext");
    return str;
  }
  
  public static void logInteractiveRequestParameters(String paramString, AcquireTokenOperationParameters paramAcquireTokenOperationParameters)
  {
    Object localObject1 = e.a.a.a.a.a(new StringBuilder(), TAG, paramString);
    Object localObject2 = e.a.a.a.a.a("Requested ");
    ((StringBuilder)localObject2).append(paramAcquireTokenOperationParameters.getScopes().size());
    ((StringBuilder)localObject2).append(" scopes");
    Logger.info((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(TAG);
    ((StringBuilder)localObject1).append(paramString);
    Logger.infoPII(((StringBuilder)localObject1).toString(), "----\nRequested scopes:");
    localObject2 = paramAcquireTokenOperationParameters.getScopes().iterator();
    String str;
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (String)((Iterator)localObject2).next();
      str = e.a.a.a.a.a(new StringBuilder(), TAG, paramString);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("\t");
      ((StringBuilder)localObject3).append((String)localObject1);
      Logger.infoPII(str, ((StringBuilder)localObject3).toString());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(TAG);
    ((StringBuilder)localObject1).append(paramString);
    Logger.infoPII(((StringBuilder)localObject1).toString(), "----");
    localObject1 = e.a.a.a.a.a(new StringBuilder(), TAG, paramString);
    localObject2 = e.a.a.a.a.a("ClientId: [");
    ((StringBuilder)localObject2).append(paramAcquireTokenOperationParameters.getClientId());
    ((StringBuilder)localObject2).append("]");
    Logger.infoPII((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = e.a.a.a.a.a(new StringBuilder(), TAG, paramString);
    localObject2 = e.a.a.a.a.a("RedirectUri: [");
    ((StringBuilder)localObject2).append(paramAcquireTokenOperationParameters.getRedirectUri());
    ((StringBuilder)localObject2).append("]");
    Logger.infoPII((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject2 = e.a.a.a.a.a(new StringBuilder(), TAG, paramString);
    localObject1 = e.a.a.a.a.a("Login hint: [");
    ((StringBuilder)localObject1).append(paramAcquireTokenOperationParameters.getLoginHint());
    ((StringBuilder)localObject1).append("]");
    Logger.infoPII((String)localObject2, ((StringBuilder)localObject1).toString());
    if (paramAcquireTokenOperationParameters.getExtraQueryStringParameters() != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(TAG);
      ((StringBuilder)localObject1).append(paramString);
      Logger.infoPII(((StringBuilder)localObject1).toString(), "Extra query params:");
      localObject1 = paramAcquireTokenOperationParameters.getExtraQueryStringParameters().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Pair)((Iterator)localObject1).next();
        str = e.a.a.a.a.a(new StringBuilder(), TAG, paramString);
        localObject2 = e.a.a.a.a.a("\t\"");
        ((StringBuilder)localObject2).append((String)first);
        ((StringBuilder)localObject2).append("\":\"");
        ((StringBuilder)localObject2).append((String)second);
        ((StringBuilder)localObject2).append("\"");
        Logger.infoPII(str, ((StringBuilder)localObject2).toString());
      }
    }
    if (paramAcquireTokenOperationParameters.getExtraScopesToConsent() != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(TAG);
      ((StringBuilder)localObject1).append(paramString);
      Logger.infoPII(((StringBuilder)localObject1).toString(), "Extra scopes to consent:");
      localObject2 = paramAcquireTokenOperationParameters.getExtraScopesToConsent().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        str = (String)((Iterator)localObject2).next();
        localObject3 = e.a.a.a.a.a(new StringBuilder(), TAG, paramString);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("\t");
        ((StringBuilder)localObject1).append(str);
        Logger.infoPII((String)localObject3, ((StringBuilder)localObject1).toString());
      }
    }
    localObject2 = e.a.a.a.a.a(new StringBuilder(), TAG, paramString);
    localObject1 = e.a.a.a.a.a("Using authorization agent: ");
    ((StringBuilder)localObject1).append(paramAcquireTokenOperationParameters.getAuthorizationAgent().toString());
    Logger.info((String)localObject2, ((StringBuilder)localObject1).toString());
    if (paramAcquireTokenOperationParameters.getAccount() != null)
    {
      localObject1 = e.a.a.a.a.a(new StringBuilder(), TAG, paramString);
      paramString = e.a.a.a.a.a("Using account: ");
      paramString.append(paramAcquireTokenOperationParameters.getAccount().getHomeAccountId());
      Logger.infoPII((String)localObject1, paramString.toString());
    }
  }
  
  public static void logSilentRequestParams(String paramString, AcquireTokenSilentOperationParameters paramAcquireTokenSilentOperationParameters)
  {
    Object localObject1 = e.a.a.a.a.a(new StringBuilder(), TAG, paramString);
    Object localObject2 = e.a.a.a.a.a("ClientId: [");
    ((StringBuilder)localObject2).append(paramAcquireTokenSilentOperationParameters.getClientId());
    ((StringBuilder)localObject2).append("]");
    Logger.infoPII((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(TAG);
    ((StringBuilder)localObject1).append(paramString);
    Logger.infoPII(((StringBuilder)localObject1).toString(), "----\nRequested scopes:");
    localObject2 = paramAcquireTokenSilentOperationParameters.getScopes().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (String)((Iterator)localObject2).next();
      String str = e.a.a.a.a.a(new StringBuilder(), TAG, paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\t");
      localStringBuilder.append((String)localObject1);
      Logger.infoPII(str, localStringBuilder.toString());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(TAG);
    ((StringBuilder)localObject1).append(paramString);
    Logger.infoPII(((StringBuilder)localObject1).toString(), "----");
    if (paramAcquireTokenSilentOperationParameters.getAccount() != null)
    {
      localObject1 = e.a.a.a.a.a(new StringBuilder(), TAG, paramString);
      localObject2 = e.a.a.a.a.a("Using account: ");
      ((StringBuilder)localObject2).append(paramAcquireTokenSilentOperationParameters.getAccount().getHomeAccountId());
      Logger.infoPII((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    paramString = e.a.a.a.a.a(new StringBuilder(), TAG, paramString);
    localObject1 = e.a.a.a.a.a("Force refresh? [");
    ((StringBuilder)localObject1).append(paramAcquireTokenSilentOperationParameters.getForceRefresh());
    ((StringBuilder)localObject1).append("]");
    Logger.info(paramString, ((StringBuilder)localObject1).toString());
  }
  
  public static void returnCommandResult(final BaseCommand paramBaseCommand, CommandResult paramCommandResult, Handler paramHandler)
  {
    paramHandler.post(new Runnable()
    {
      public void run()
      {
        int i = val$result.getStatus().ordinal();
        if (i != 0)
        {
          if (i != 1)
          {
            if (i == 2) {
              paramBaseCommand.getCallback().onError(val$result.getResult());
            }
          }
          else {
            paramBaseCommand.getCallback().onTaskCompleted(val$result.getResult());
          }
        }
        else {
          paramBaseCommand.getCallback().onCancel();
        }
      }
    });
  }
  
  public static void submitSilent(BaseCommand paramBaseCommand)
  {
    e.a.a.a.a.b(new StringBuilder(), TAG, ":submitSilent", "Beginning execution of silent command.");
    sSilentExecutor.execute(new Runnable()
    {
      public void run()
      {
        String str = CommandDispatcher.initializeDiagnosticContext(val$command.getParameters().getCorrelationId());
        EstsTelemetry.getInstance().emitApiId(val$command.getPublicApiId());
        Handler localHandler = new Handler(Looper.getMainLooper());
        if ((val$command.getParameters() instanceof AcquireTokenSilentOperationParameters))
        {
          CommandDispatcher.access$000(":submitSilent", (AcquireTokenSilentOperationParameters)val$command.getParameters());
          EstsTelemetry.getInstance().emitForceRefresh(val$command.getParameters().getForceRefresh());
        }
        CommandResult localCommandResult = CommandDispatcher.access$100().get(val$command);
        if (localCommandResult == null)
        {
          localCommandResult = CommandDispatcher.access$200(val$command);
          CommandDispatcher.access$300(val$command, localCommandResult);
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(CommandDispatcher.access$400());
          localStringBuilder.append(":submitSilent");
          Logger.info(localStringBuilder.toString(), "Silent command result returned from cache.");
        }
        CommandDispatcher.access$500(val$command, localCommandResult, localHandler);
        Telemetry.getInstance().flush(str);
        if ((localCommandResult.getResult() instanceof BaseException)) {
          EstsTelemetry.getInstance().flush(str, (BaseException)localCommandResult.getResult());
        } else {
          EstsTelemetry.getInstance().flush(str);
        }
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.controllers.CommandDispatcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */