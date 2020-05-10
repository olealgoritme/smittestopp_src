package com.microsoft.identity.common.internal.controllers;

import com.microsoft.identity.common.internal.request.OperationParameters;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseCommand<T>
  implements Command<T>
{
  public CommandCallback mCallback;
  public List<BaseController> mControllers;
  public OperationParameters mParameters;
  public String mPublicApiId;
  
  public BaseCommand(OperationParameters paramOperationParameters, BaseController paramBaseController, CommandCallback paramCommandCallback)
  {
    mParameters = paramOperationParameters;
    paramOperationParameters = new ArrayList();
    mControllers = paramOperationParameters;
    mCallback = paramCommandCallback;
    paramOperationParameters.add(paramBaseController);
  }
  
  public BaseCommand(OperationParameters paramOperationParameters, List<BaseController> paramList, CommandCallback paramCommandCallback)
  {
    mParameters = paramOperationParameters;
    mControllers = paramList;
    mCallback = paramCommandCallback;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof BaseCommand)) {
      return false;
    }
    paramObject = (BaseCommand)paramObject;
    return mParameters.equals(mParameters);
  }
  
  public abstract T execute();
  
  public CommandCallback getCallback()
  {
    return mCallback;
  }
  
  public abstract int getCommandNameHashCode();
  
  public List<BaseController> getControllers()
  {
    return mControllers;
  }
  
  public BaseController getDefaultController()
  {
    return (BaseController)mControllers.get(0);
  }
  
  public OperationParameters getParameters()
  {
    return mParameters;
  }
  
  public String getPublicApiId()
  {
    return mPublicApiId;
  }
  
  public int hashCode()
  {
    int i = getCommandNameHashCode();
    return mParameters.hashCode() + i * 31;
  }
  
  public boolean isEligibleForCaching()
  {
    return false;
  }
  
  public void setCallback(CommandCallback paramCommandCallback)
  {
    mCallback = paramCommandCallback;
  }
  
  public void setControllers(List<BaseController> paramList)
  {
    mControllers = paramList;
  }
  
  public void setParameters(OperationParameters paramOperationParameters)
  {
    mParameters = paramOperationParameters;
  }
  
  public void setPublicApiId(String paramString)
  {
    mPublicApiId = paramString;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.controllers.BaseCommand
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */