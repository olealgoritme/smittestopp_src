package com.microsoft.identity.common.internal.platform;

import android.content.Context;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.controllers.TaskCompletedCallbackWithError;
import java.net.URL;

public abstract interface IDevicePopManager
{
  public abstract boolean asymmetricKeyExists();
  
  public abstract boolean asymmetricKeyExists(String paramString);
  
  public abstract boolean clearAsymmetricKey();
  
  public abstract String generateAsymmetricKey(Context paramContext);
  
  public abstract void generateAsymmetricKey(Context paramContext, TaskCompletedCallbackWithError<String, ClientException> paramTaskCompletedCallbackWithError);
  
  public abstract String getAsymmetricKeyThumbprint();
  
  public abstract String getRequestConfirmation();
  
  public abstract void getRequestConfirmation(TaskCompletedCallbackWithError<String, ClientException> paramTaskCompletedCallbackWithError);
  
  public abstract String mintSignedAccessToken(String paramString1, URL paramURL, String paramString2, String paramString3);
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.platform.IDevicePopManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */