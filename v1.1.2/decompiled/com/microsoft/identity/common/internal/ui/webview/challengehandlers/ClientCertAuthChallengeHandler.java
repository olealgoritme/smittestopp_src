package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

import android.annotation.TargetApi;
import android.app.Activity;
import android.security.KeyChain;
import android.security.KeyChainAliasCallback;
import android.security.KeyChainException;
import android.webkit.ClientCertRequest;
import com.microsoft.identity.common.internal.logging.Logger;
import java.security.Principal;
import java.security.cert.X509Certificate;

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
  public Void processChallenge(final ClientCertRequest paramClientCertRequest)
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
    KeyChain.choosePrivateKeyAlias(mActivity, new KeyChainAliasCallback()
    {
      public void alias(String paramAnonymousString)
      {
        if (paramAnonymousString == null)
        {
          Logger.info(ClientCertAuthChallengeHandler.access$000(), "No certificate chosen by user, cancelling the TLS request.");
          paramClientCertRequest.cancel();
          return;
        }
        try
        {
          X509Certificate[] arrayOfX509Certificate = KeyChain.getCertificateChain(ClientCertAuthChallengeHandler.access$100(ClientCertAuthChallengeHandler.this).getApplicationContext(), paramAnonymousString);
          paramAnonymousString = KeyChain.getPrivateKey(ClientCertAuthChallengeHandler.access$100(ClientCertAuthChallengeHandler.this), paramAnonymousString);
          Logger.info(ClientCertAuthChallengeHandler.access$000(), "Certificate is chosen by user, proceed with TLS request.");
          paramClientCertRequest.proceed(paramAnonymousString, arrayOfX509Certificate);
          return;
        }
        catch (InterruptedException paramAnonymousString)
        {
          Logger.errorPII(ClientCertAuthChallengeHandler.access$000(), "InterruptedException exception", paramAnonymousString);
        }
        catch (KeyChainException paramAnonymousString)
        {
          Logger.errorPII(ClientCertAuthChallengeHandler.access$000(), "KeyChain exception", paramAnonymousString);
        }
        paramClientCertRequest.cancel();
      }
    }, paramClientCertRequest.getKeyTypes(), paramClientCertRequest.getPrincipals(), paramClientCertRequest.getHost(), paramClientCertRequest.getPort(), null);
    return null;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.ui.webview.challengehandlers.ClientCertAuthChallengeHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */