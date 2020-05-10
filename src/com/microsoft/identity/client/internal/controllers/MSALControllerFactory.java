package com.microsoft.identity.client.internal.controllers;

import android.accounts.AccountManager;
import android.accounts.AuthenticatorDescription;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.PowerManager;
import com.microsoft.identity.client.PublicClientApplicationConfiguration;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.common.internal.authorities.AnyPersonalAccount;
import com.microsoft.identity.common.internal.authorities.Authority;
import com.microsoft.identity.common.internal.authorities.AzureActiveDirectoryAuthority;
import com.microsoft.identity.common.internal.broker.BrokerValidator;
import com.microsoft.identity.common.internal.controllers.BaseController;
import com.microsoft.identity.common.internal.logging.Logger;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.List;

public class MSALControllerFactory
{
  public static final String TAG = "com.microsoft.identity.client.internal.controllers.MSALControllerFactory";
  
  public static boolean brokerEligible(Context paramContext, Authority paramAuthority, PublicClientApplicationConfiguration paramPublicClientApplicationConfiguration)
  {
    if ((paramPublicClientApplicationConfiguration.getUseBroker().booleanValue()) && ((paramAuthority instanceof AzureActiveDirectoryAuthority)))
    {
      if ((((AzureActiveDirectoryAuthority)paramAuthority).getAudience() instanceof AnyPersonalAccount))
      {
        paramContext = new StringBuilder();
        paramContext.append(TAG);
        paramContext.append(":brokerEligible");
        Logger.verbose(paramContext.toString(), "Eligible to call broker? [false]");
        a.b(new StringBuilder(), TAG, ":brokerEligible", "The audience is MSA only.");
        return false;
      }
      if (!brokerInstalled(paramContext))
      {
        paramContext = new StringBuilder();
        paramContext.append(TAG);
        paramContext.append(":brokerEligible");
        Logger.verbose(paramContext.toString(), "Eligible to call broker? [false]");
        a.b(new StringBuilder(), TAG, ":brokerEligible", "Broker application is not installed.");
        return false;
      }
      if ((!BrokerMsalController.isMicrosoftAuthServiceSupported(paramContext)) && (!BrokerMsalController.isAccountManagerPermissionsGranted(paramContext)))
      {
        if ((!BrokerMsalController.isMicrosoftAuthServiceSupported(paramContext)) && (powerOptimizationEnabled(paramContext)))
        {
          paramContext = new StringBuilder();
          paramContext.append(TAG);
          paramContext.append(":brokerEligible");
          Logger.verbose(paramContext.toString(), "Eligible to call broker? [false]");
          paramContext = new StringBuilder();
          paramContext.append(TAG);
          paramContext.append(":brokerEligible");
          Logger.warn(paramContext.toString(), "Is bound service supported? [false]");
          paramContext = new StringBuilder();
          paramContext.append(TAG);
          paramContext.append(":brokerEligible");
          Logger.warn(paramContext.toString(), "Is the power optimization enabled? [true]");
          throw new MsalClientException("Failed to bind the service in broker app", "Unable to connect to the broker.");
        }
        paramContext = new StringBuilder();
        paramContext.append(TAG);
        paramContext.append(":brokerEligible");
        Logger.verbose(paramContext.toString(), "Eligible to call broker? [false]");
        paramContext = new StringBuilder();
        paramContext.append(TAG);
        paramContext.append(":brokerEligible");
        Logger.warn(paramContext.toString(), "Is bound service supported? [false]");
        paramContext = new StringBuilder();
        paramContext.append(TAG);
        paramContext.append(":brokerEligible");
        Logger.warn(paramContext.toString(), "Is the power optimization enabled? [false]");
        paramContext = new StringBuilder();
        paramContext.append(TAG);
        paramContext.append(":brokerEligible");
        Logger.warn(paramContext.toString(), "Is AccountManager permission missing? [true]");
        throw new MsalClientException("Failed to bind the service in broker app", "Unable to connect to the broker.");
      }
      a.b(new StringBuilder(), TAG, ":brokerEligible", "Eligible to call broker? [true]");
      return true;
    }
    paramContext = new StringBuilder();
    paramContext.append(TAG);
    paramContext.append(":brokerEligible");
    Logger.verbose(paramContext.toString(), "Eligible to call broker? [false]");
    a.b(new StringBuilder(), TAG, ":brokerEligible", "App does not ask for Broker or the authority is not AAD authority.");
    return false;
  }
  
  public static boolean brokerInstalled(Context paramContext)
  {
    BrokerValidator localBrokerValidator = new BrokerValidator(paramContext);
    for (paramContext : AccountManager.get(paramContext).getAuthenticatorTypes()) {
      if ((type.equals("com.microsoft.workaccount")) && (localBrokerValidator.verifySignature(packageName))) {
        return true;
      }
    }
    return false;
  }
  
  public static List<BaseController> getAllControllers(Context paramContext, Authority paramAuthority, PublicClientApplicationConfiguration paramPublicClientApplicationConfiguration)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new LocalMSALController());
    if (brokerEligible(paramContext, paramAuthority, paramPublicClientApplicationConfiguration)) {
      localArrayList.add(new BrokerMsalController());
    }
    return localArrayList;
  }
  
  public static BaseController getDefaultController(Context paramContext, Authority paramAuthority, PublicClientApplicationConfiguration paramPublicClientApplicationConfiguration)
  {
    if (brokerEligible(paramContext, paramAuthority, paramPublicClientApplicationConfiguration)) {
      return new BrokerMsalController();
    }
    return new LocalMSALController();
  }
  
  @TargetApi(23)
  public static boolean powerOptimizationEnabled(Context paramContext)
  {
    String str = paramContext.getPackageName();
    paramContext = (PowerManager)paramContext.getSystemService("power");
    if ((Build.VERSION.SDK_INT >= 23) && (paramContext != null))
    {
      boolean bool = paramContext.isIgnoringBatteryOptimizations(str) ^ true;
      str = a.a(new StringBuilder(), TAG, ":powerOptimizationEnabled");
      paramContext = new StringBuilder();
      paramContext.append("Is power optimization on? [");
      paramContext.append(bool);
      paramContext.append("]");
      Logger.verbose(str, paramContext.toString());
      return bool;
    }
    a.b(new StringBuilder(), TAG, ":powerOptimizationEnabled", "Is power optimization on? [false]");
    return false;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.client.internal.controllers.MSALControllerFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */