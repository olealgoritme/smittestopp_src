package com.microsoft.identity.common.internal.controllers;

import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.request.OperationParameters;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.List;

public class LoadAccountCommand
  extends BaseCommand<List<ICacheRecord>>
{
  public static final String TAG = "LoadAccountCommand";
  
  public LoadAccountCommand(OperationParameters paramOperationParameters, BaseController paramBaseController, CommandCallback paramCommandCallback)
  {
    super(paramOperationParameters, paramBaseController, paramCommandCallback);
  }
  
  public LoadAccountCommand(OperationParameters paramOperationParameters, List<BaseController> paramList, CommandCallback paramCommandCallback)
  {
    super(paramOperationParameters, paramList, paramCommandCallback);
  }
  
  public List<ICacheRecord> execute()
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < getControllers().size(); i++)
    {
      BaseController localBaseController = (BaseController)getControllers().get(i);
      String str = a.a(new StringBuilder(), TAG, ":execute");
      StringBuilder localStringBuilder = a.a("Executing with controller: ");
      localStringBuilder.append(localBaseController.getClass().getSimpleName());
      Logger.verbose(str, localStringBuilder.toString());
      localArrayList.addAll(localBaseController.getAccounts(getParameters()));
    }
    return localArrayList;
  }
  
  public int getCommandNameHashCode()
  {
    return TAG.hashCode();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.controllers.LoadAccountCommand
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */