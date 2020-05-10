package com.microsoft.identity.common.internal.controllers;

import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.request.OperationParameters;
import e.a.a.a.a;
import java.util.List;

public class RemoveAccountCommand
  extends BaseCommand<Boolean>
{
  public static final String TAG = "RemoveAccountCommand";
  
  public RemoveAccountCommand(OperationParameters paramOperationParameters, List<BaseController> paramList, CommandCallback paramCommandCallback)
  {
    super(paramOperationParameters, paramList, paramCommandCallback);
  }
  
  public Boolean execute()
  {
    int i = 0;
    boolean bool = false;
    while (i < getControllers().size())
    {
      BaseController localBaseController = (BaseController)getControllers().get(i);
      String str = a.a(new StringBuilder(), TAG, ":execute");
      StringBuilder localStringBuilder = a.a("Executing with controller: ");
      localStringBuilder.append(localBaseController.getClass().getSimpleName());
      Logger.verbose(str, localStringBuilder.toString());
      bool = localBaseController.removeAccount(getParameters());
      i++;
    }
    return Boolean.valueOf(bool);
  }
  
  public int getCommandNameHashCode()
  {
    return TAG.hashCode();
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.controllers.RemoveAccountCommand
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */