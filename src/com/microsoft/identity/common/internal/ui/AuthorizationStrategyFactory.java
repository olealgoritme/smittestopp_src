package com.microsoft.identity.common.internal.ui;

import android.content.Context;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.oauth2.AuthorizationStrategy;
import com.microsoft.identity.common.internal.request.AcquireTokenOperationParameters;
import com.microsoft.identity.common.internal.request.BrokerAcquireTokenOperationParameters;
import com.microsoft.identity.common.internal.request.OperationParameters;
import com.microsoft.identity.common.internal.ui.browser.BrowserAuthorizationStrategy;
import com.microsoft.identity.common.internal.ui.browser.BrowserSelector;
import com.microsoft.identity.common.internal.ui.webview.EmbeddedWebViewAuthorizationStrategy;
import java.util.List;

public class AuthorizationStrategyFactory<GenericAuthorizationStrategy extends AuthorizationStrategy>
{
  public static final String TAG = "AuthorizationStrategyFactory";
  public static AuthorizationStrategyFactory sInstance;
  
  public static AuthorizationStrategyFactory getInstance()
  {
    if (sInstance == null) {
      sInstance = new AuthorizationStrategyFactory();
    }
    return sInstance;
  }
  
  private AuthorizationAgent validAuthorizationAgent(AuthorizationAgent paramAuthorizationAgent, Context paramContext)
  {
    AuthorizationAgent localAuthorizationAgent = paramAuthorizationAgent;
    if (paramAuthorizationAgent != AuthorizationAgent.WEBVIEW)
    {
      localAuthorizationAgent = paramAuthorizationAgent;
      if (BrowserSelector.getAllBrowsers(paramContext).isEmpty())
      {
        Logger.verbose(TAG, "Unable to use browser to do the authorization because No available browser installed on the device. Use embedded webView instead.");
        localAuthorizationAgent = AuthorizationAgent.WEBVIEW;
      }
    }
    return localAuthorizationAgent;
  }
  
  public GenericAuthorizationStrategy getAuthorizationStrategy(AcquireTokenOperationParameters paramAcquireTokenOperationParameters)
  {
    AuthorizationAgent localAuthorizationAgent = validAuthorizationAgent(paramAcquireTokenOperationParameters.getAuthorizationAgent(), paramAcquireTokenOperationParameters.getAppContext());
    boolean bool = paramAcquireTokenOperationParameters instanceof BrokerAcquireTokenOperationParameters;
    if (localAuthorizationAgent == AuthorizationAgent.WEBVIEW)
    {
      Logger.info(TAG, "Use webView for authorization.");
      return new EmbeddedWebViewAuthorizationStrategy(paramAcquireTokenOperationParameters.getAppContext(), paramAcquireTokenOperationParameters.getActivity(), paramAcquireTokenOperationParameters.getFragment());
    }
    if (localAuthorizationAgent == AuthorizationAgent.DEFAULT)
    {
      try
      {
        BrowserSelector.select(paramAcquireTokenOperationParameters.getAppContext(), paramAcquireTokenOperationParameters.getBrowserSafeList());
      }
      catch (ClientException localClientException)
      {
        Logger.info(TAG, "No supported browser available found. Fallback to the webView authorization agent.");
        if (localClientException.getErrorCode().equalsIgnoreCase("No available browser installed on the device.")) {
          return new EmbeddedWebViewAuthorizationStrategy(paramAcquireTokenOperationParameters.getAppContext(), paramAcquireTokenOperationParameters.getActivity(), paramAcquireTokenOperationParameters.getFragment());
        }
      }
      Logger.info(TAG, "Use browser for authorization.");
      localBrowserAuthorizationStrategy = new BrowserAuthorizationStrategy(paramAcquireTokenOperationParameters.getAppContext(), paramAcquireTokenOperationParameters.getActivity(), paramAcquireTokenOperationParameters.getFragment(), bool);
      localBrowserAuthorizationStrategy.setBrowserSafeList(paramAcquireTokenOperationParameters.getBrowserSafeList());
      return localBrowserAuthorizationStrategy;
    }
    Logger.info(TAG, "Use browser for authorization.");
    BrowserAuthorizationStrategy localBrowserAuthorizationStrategy = new BrowserAuthorizationStrategy(paramAcquireTokenOperationParameters.getAppContext(), paramAcquireTokenOperationParameters.getActivity(), paramAcquireTokenOperationParameters.getFragment(), bool);
    localBrowserAuthorizationStrategy.setBrowserSafeList(paramAcquireTokenOperationParameters.getBrowserSafeList());
    return localBrowserAuthorizationStrategy;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.ui.AuthorizationStrategyFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */