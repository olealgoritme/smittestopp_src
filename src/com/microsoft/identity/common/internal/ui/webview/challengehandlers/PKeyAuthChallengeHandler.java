package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

import android.content.Intent;
import android.webkit.WebView;
import com.microsoft.identity.common.adal.internal.AuthenticationSettings;
import com.microsoft.identity.common.adal.internal.IDeviceCertificate;
import com.microsoft.identity.common.adal.internal.JWSBuilder;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.logging.Logger;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;

public final class PKeyAuthChallengeHandler
  implements IChallengeHandler<PKeyAuthChallenge, Void>
{
  public static final String TAG = "PKeyAuthChallengeHandler";
  public IAuthorizationCompletionCallback mChallengeCallback;
  public WebView mWebView;
  
  public PKeyAuthChallengeHandler(WebView paramWebView, IAuthorizationCompletionCallback paramIAuthorizationCompletionCallback)
  {
    mWebView = paramWebView;
    mChallengeCallback = paramIAuthorizationCompletionCallback;
  }
  
  public static Map<String, String> getChallengeHeader(PKeyAuthChallenge paramPKeyAuthChallenge)
  {
    String str = String.format("%s Context=\"%s\",Version=\"%s\"", new Object[] { "PKeyAuth", paramPKeyAuthChallenge.getContext(), paramPKeyAuthChallenge.getVersion() });
    Object localObject1 = AuthenticationSettings.INSTANCE.getDeviceCertificateProxy();
    Object localObject2 = str;
    if (localObject1 != null)
    {
      localObject1 = getWPJAPIInstance((Class)localObject1);
      if (!((IDeviceCertificate)localObject1).isValidIssuer(paramPKeyAuthChallenge.getCertAuthorities()))
      {
        localObject2 = str;
        if (((IDeviceCertificate)localObject1).getThumbPrint() != null)
        {
          localObject2 = str;
          if (!((IDeviceCertificate)localObject1).getThumbPrint().equalsIgnoreCase(paramPKeyAuthChallenge.getThumbprint())) {}
        }
      }
      else
      {
        localObject2 = ((IDeviceCertificate)localObject1).getRSAPrivateKey();
        if (localObject2 != null)
        {
          localObject2 = String.format("%s AuthToken=\"%s\",Context=\"%s\",Version=\"%s\"", new Object[] { "PKeyAuth", new JWSBuilder().generateSignedJWT(paramPKeyAuthChallenge.getNonce(), paramPKeyAuthChallenge.getSubmitUrl(), (RSAPrivateKey)localObject2, ((IDeviceCertificate)localObject1).getRSAPublicKey(), ((IDeviceCertificate)localObject1).getCertificate()), paramPKeyAuthChallenge.getContext(), paramPKeyAuthChallenge.getVersion() });
          Logger.info(TAG, "Receive challenge response. ");
        }
        else
        {
          throw new ClientException("Key Chain private key exception");
        }
      }
    }
    paramPKeyAuthChallenge = new HashMap();
    paramPKeyAuthChallenge.put("Authorization", localObject2);
    return paramPKeyAuthChallenge;
  }
  
  public static IDeviceCertificate getWPJAPIInstance(Class<IDeviceCertificate> paramClass)
  {
    try
    {
      paramClass = (IDeviceCertificate)paramClass.getDeclaredConstructor(new Class[0]).newInstance(null);
      return paramClass;
    }
    catch (InvocationTargetException paramClass) {}catch (IllegalArgumentException paramClass) {}catch (IllegalAccessException paramClass) {}catch (InstantiationException paramClass) {}catch (NoSuchMethodException paramClass) {}
    throw new ClientException("Device certificate API has exception", "WPJ Api constructor is not defined", paramClass);
  }
  
  public Void processChallenge(PKeyAuthChallenge paramPKeyAuthChallenge)
  {
    mWebView.stopLoading();
    mChallengeCallback.setPKeyAuthStatus(true);
    try
    {
      Map localMap = getChallengeHeader(paramPKeyAuthChallenge);
      WebView localWebView = mWebView;
      localObject = new com/microsoft/identity/common/internal/ui/webview/challengehandlers/PKeyAuthChallengeHandler$1;
      ((PKeyAuthChallengeHandler.1)localObject).<init>(this, paramPKeyAuthChallenge, localMap);
      localWebView.post((Runnable)localObject);
    }
    catch (ClientException paramPKeyAuthChallenge)
    {
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("com.microsoft.aad.adal:AuthenticationException", paramPKeyAuthChallenge);
      mChallengeCallback.onChallengeResponseReceived(2005, (Intent)localObject);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.ui.webview.challengehandlers.PKeyAuthChallengeHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */