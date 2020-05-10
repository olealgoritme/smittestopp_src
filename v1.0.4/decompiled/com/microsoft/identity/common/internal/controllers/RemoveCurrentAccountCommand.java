package com.microsoft.identity.common.internal.controllers;

import com.microsoft.identity.common.internal.request.OperationParameters;

public class RemoveCurrentAccountCommand
  extends BaseCommand<Boolean>
{
  public static final String TAG = "RemoveCurrentAccountCommand";
  
  public RemoveCurrentAccountCommand(OperationParameters paramOperationParameters, BaseController paramBaseController, CommandCallback paramCommandCallback)
  {
    super(paramOperationParameters, paramBaseController, paramCommandCallback);
  }
  
  public Boolean execute()
  {
    return Boolean.valueOf(getDefaultController().removeCurrentAccount(getParameters()));
  }
  
  public int getCommandNameHashCode()
  {
    return TAG.hashCode();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.controllers.RemoveCurrentAccountCommand
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */