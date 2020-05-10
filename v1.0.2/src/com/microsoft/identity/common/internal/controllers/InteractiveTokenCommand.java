package com.microsoft.identity.common.internal.controllers;

import android.content.Intent;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.request.AcquireTokenOperationParameters;
import com.microsoft.identity.common.internal.result.AcquireTokenResult;

public class InteractiveTokenCommand
  extends TokenCommand
{
  public static final String TAG = "InteractiveTokenCommand";
  
  public InteractiveTokenCommand(AcquireTokenOperationParameters paramAcquireTokenOperationParameters, BaseController paramBaseController, CommandCallback paramCommandCallback)
  {
    super(paramAcquireTokenOperationParameters, paramBaseController, paramCommandCallback);
  }
  
  public AcquireTokenResult execute()
  {
    if ((getParameters() instanceof AcquireTokenOperationParameters))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append(":execute");
      Logger.info(localStringBuilder.toString(), "Executing interactive token command...");
      return getDefaultController().acquireToken((AcquireTokenOperationParameters)getParameters());
    }
    throw new IllegalArgumentException("Invalid operation parameters");
  }
  
  public int getCommandNameHashCode()
  {
    return TAG.hashCode();
  }
  
  public void notify(int paramInt1, int paramInt2, Intent paramIntent)
  {
    getDefaultController().completeAcquireToken(paramInt1, paramInt2, paramIntent);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.controllers.InteractiveTokenCommand
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */