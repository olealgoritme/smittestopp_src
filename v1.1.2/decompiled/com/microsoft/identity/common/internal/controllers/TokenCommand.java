package com.microsoft.identity.common.internal.controllers;

import android.content.Intent;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.exception.UiRequiredException;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.request.AcquireTokenSilentOperationParameters;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.result.AcquireTokenResult;
import java.util.List;

public class TokenCommand
  extends BaseCommand<AcquireTokenResult>
  implements TokenOperation
{
  public static final String TAG = "TokenCommand";
  
  public TokenCommand(OperationParameters paramOperationParameters, BaseController paramBaseController, CommandCallback paramCommandCallback)
  {
    super(paramOperationParameters, paramBaseController, paramCommandCallback);
  }
  
  public TokenCommand(OperationParameters paramOperationParameters, List<BaseController> paramList, CommandCallback paramCommandCallback)
  {
    super(paramOperationParameters, paramList, paramCommandCallback);
  }
  
  public AcquireTokenResult execute()
  {
    AcquireTokenResult localAcquireTokenResult1 = null;
    int i = 0;
    label440:
    Object localObject1;
    while (i < getControllers().size())
    {
      BaseController localBaseController = (BaseController)getControllers().get(i);
      AcquireTokenResult localAcquireTokenResult2 = localAcquireTokenResult1;
      AcquireTokenResult localAcquireTokenResult3 = localAcquireTokenResult1;
      Object localObject2;
      try
      {
        localObject2 = new java/lang/StringBuilder;
        localAcquireTokenResult2 = localAcquireTokenResult1;
        localAcquireTokenResult3 = localAcquireTokenResult1;
        ((StringBuilder)localObject2).<init>();
        localAcquireTokenResult2 = localAcquireTokenResult1;
        localAcquireTokenResult3 = localAcquireTokenResult1;
        ((StringBuilder)localObject2).append(TAG);
        localAcquireTokenResult2 = localAcquireTokenResult1;
        localAcquireTokenResult3 = localAcquireTokenResult1;
        ((StringBuilder)localObject2).append(":execute");
        localAcquireTokenResult2 = localAcquireTokenResult1;
        localAcquireTokenResult3 = localAcquireTokenResult1;
        String str = ((StringBuilder)localObject2).toString();
        localAcquireTokenResult2 = localAcquireTokenResult1;
        localAcquireTokenResult3 = localAcquireTokenResult1;
        localObject2 = new java/lang/StringBuilder;
        localAcquireTokenResult2 = localAcquireTokenResult1;
        localAcquireTokenResult3 = localAcquireTokenResult1;
        ((StringBuilder)localObject2).<init>();
        localAcquireTokenResult2 = localAcquireTokenResult1;
        localAcquireTokenResult3 = localAcquireTokenResult1;
        ((StringBuilder)localObject2).append("Executing with controller: ");
        localAcquireTokenResult2 = localAcquireTokenResult1;
        localAcquireTokenResult3 = localAcquireTokenResult1;
        ((StringBuilder)localObject2).append(localBaseController.getClass().getSimpleName());
        localAcquireTokenResult2 = localAcquireTokenResult1;
        localAcquireTokenResult3 = localAcquireTokenResult1;
        Logger.verbose(str, ((StringBuilder)localObject2).toString());
        localAcquireTokenResult2 = localAcquireTokenResult1;
        localAcquireTokenResult3 = localAcquireTokenResult1;
        localAcquireTokenResult1 = localBaseController.acquireTokenSilent((AcquireTokenSilentOperationParameters)getParameters());
        localAcquireTokenResult2 = localAcquireTokenResult1;
        localAcquireTokenResult3 = localAcquireTokenResult1;
        localObject2 = localAcquireTokenResult1;
        if (!localAcquireTokenResult1.getSucceeded().booleanValue()) {
          break label440;
        }
        localAcquireTokenResult2 = localAcquireTokenResult1;
        localAcquireTokenResult3 = localAcquireTokenResult1;
        localObject2 = new java/lang/StringBuilder;
        localAcquireTokenResult2 = localAcquireTokenResult1;
        localAcquireTokenResult3 = localAcquireTokenResult1;
        ((StringBuilder)localObject2).<init>();
        localAcquireTokenResult2 = localAcquireTokenResult1;
        localAcquireTokenResult3 = localAcquireTokenResult1;
        ((StringBuilder)localObject2).append(TAG);
        localAcquireTokenResult2 = localAcquireTokenResult1;
        localAcquireTokenResult3 = localAcquireTokenResult1;
        ((StringBuilder)localObject2).append(":execute");
        localAcquireTokenResult2 = localAcquireTokenResult1;
        localAcquireTokenResult3 = localAcquireTokenResult1;
        str = ((StringBuilder)localObject2).toString();
        localAcquireTokenResult2 = localAcquireTokenResult1;
        localAcquireTokenResult3 = localAcquireTokenResult1;
        localObject2 = new java/lang/StringBuilder;
        localAcquireTokenResult2 = localAcquireTokenResult1;
        localAcquireTokenResult3 = localAcquireTokenResult1;
        ((StringBuilder)localObject2).<init>();
        localAcquireTokenResult2 = localAcquireTokenResult1;
        localAcquireTokenResult3 = localAcquireTokenResult1;
        ((StringBuilder)localObject2).append("Executing with controller: ");
        localAcquireTokenResult2 = localAcquireTokenResult1;
        localAcquireTokenResult3 = localAcquireTokenResult1;
        ((StringBuilder)localObject2).append(localBaseController.getClass().getSimpleName());
        localAcquireTokenResult2 = localAcquireTokenResult1;
        localAcquireTokenResult3 = localAcquireTokenResult1;
        ((StringBuilder)localObject2).append(": Succeeded");
        localAcquireTokenResult2 = localAcquireTokenResult1;
        localAcquireTokenResult3 = localAcquireTokenResult1;
        Logger.verbose(str, ((StringBuilder)localObject2).toString());
        return localAcquireTokenResult1;
      }
      catch (ClientException localClientException)
      {
        localAcquireTokenResult3 = localAcquireTokenResult2;
      }
      catch (UiRequiredException localUiRequiredException) {}
      if ((localUiRequiredException.getErrorCode().equals("invalid_grant")) && (getControllers().size() > i + 1))
      {
        localObject2 = localAcquireTokenResult3;
      }
      else
      {
        if (((!localUiRequiredException.getErrorCode().equals("no_tokens_found")) && (!localUiRequiredException.getErrorCode().equals("no_account_found"))) || (getControllers().size() <= i + 1)) {
          break label449;
        }
        localObject2 = localAcquireTokenResult3;
      }
      i++;
      localObject1 = localObject2;
      continue;
      label449:
      throw ((Throwable)localObject1);
    }
    return (AcquireTokenResult)localObject1;
  }
  
  public int getCommandNameHashCode()
  {
    return TAG.hashCode();
  }
  
  public boolean isEligibleForCaching()
  {
    return false;
  }
  
  public void notify(int paramInt1, int paramInt2, Intent paramIntent)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.controllers.TokenCommand
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */