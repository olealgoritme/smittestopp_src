package com.microsoft.identity.common.internal.controllers;

import android.os.Handler;
import android.os.Looper;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.internal.eststelemetry.EstsTelemetry;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.request.AcquireTokenSilentOperationParameters;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.telemetry.Telemetry;

public final class CommandDispatcher$1
  implements Runnable
{
  public CommandDispatcher$1(BaseCommand paramBaseCommand) {}
  
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
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.controllers.CommandDispatcher.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */