package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

import android.annotation.TargetApi;
import android.app.Activity;
import android.security.KeyChain;
import android.webkit.ClientCertRequest;
import com.microsoft.identity.common.internal.logging.Logger;
import java.security.Principal;

public final class ClientCertAuthChallengeHandler
  implements IChallengeHandler<ClientCertRequest, Void>
{
  public static final String ACCEPTABLE_ISSUER = "CN=MS-Organization-Access";
  public static final String TAG = "ClientCertAuthChallengeHandler";
  public Activity mActivity;
  
  public ClientCertAuthChallengeHandler(Activity paramActivity)
  {
    mActivity = paramActivity;
  }
  
  @TargetApi(21)
  public Void processChallenge(ClientCertRequest paramClientCertRequest)
  {
    Principal[] arrayOfPrincipal = paramClientCertRequest.getPrincipals();
    if (arrayOfPrincipal != null)
    {
      int i = arrayOfPrincipal.length;
      for (int j = 0; j < i; j++) {
        if (arrayOfPrincipal[j].getName().contains("CN=MS-Organization-Access"))
        {
          Logger.info(TAG, "Cancelling the TLS request, not respond to TLS challenge triggered by device authentication.");
          paramClientCertRequest.cancel();
          return null;
        }
      }
    }
    KeyChain.choosePrivateKeyAlias(mActivity, new ClientCertAuthChallengeHandler.1(this, paramClientCertRequest), paramClientCertRequest.getKeyTypes(), paramClientCertRequest.getPrincipals(), paramClientCertRequest.getHost(), paramClientCertRequest.getPort(), null);
    return null;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.ui.webview.challengehandlers.ClientCertAuthChallengeHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */