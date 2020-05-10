package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

import android.app.Activity;
import android.security.KeyChain;
import android.security.KeyChainAliasCallback;
import android.security.KeyChainException;
import android.webkit.ClientCertRequest;
import com.microsoft.identity.common.internal.logging.Logger;
import java.security.cert.X509Certificate;

public class ClientCertAuthChallengeHandler$1
  implements KeyChainAliasCallback
{
  public ClientCertAuthChallengeHandler$1(ClientCertAuthChallengeHandler paramClientCertAuthChallengeHandler, ClientCertRequest paramClientCertRequest) {}
  
  public void alias(String paramString)
  {
    if (paramString == null)
    {
      Logger.info(ClientCertAuthChallengeHandler.access$000(), "No certificate chosen by user, cancelling the TLS request.");
      val$request.cancel();
      return;
    }
    try
    {
      X509Certificate[] arrayOfX509Certificate = KeyChain.getCertificateChain(ClientCertAuthChallengeHandler.access$100(this$0).getApplicationContext(), paramString);
      paramString = KeyChain.getPrivateKey(ClientCertAuthChallengeHandler.access$100(this$0), paramString);
      Logger.info(ClientCertAuthChallengeHandler.access$000(), "Certificate is chosen by user, proceed with TLS request.");
      val$request.proceed(paramString, arrayOfX509Certificate);
      return;
    }
    catch (InterruptedException paramString)
    {
      Logger.errorPII(ClientCertAuthChallengeHandler.access$000(), "InterruptedException exception", paramString);
    }
    catch (KeyChainException paramString)
    {
      Logger.errorPII(ClientCertAuthChallengeHandler.access$000(), "KeyChain exception", paramString);
    }
    val$request.cancel();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.ui.webview.challengehandlers.ClientCertAuthChallengeHandler.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */