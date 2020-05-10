package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

import com.microsoft.identity.common.adal.internal.AuthenticationSettings;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.util.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public class PKeyAuthChallengeFactory
{
  public static final String CHALLENGE_REQUEST_CERT_AUTH_DELIMITER = ";";
  public static final String TAG = "PKeyAuthChallengeFactory";
  
  private Map<String, String> getPKeyAuthHeader(String paramString)
  {
    paramString = paramString.substring(8);
    Object localObject1 = StringExtensions.splitWithQuotes(paramString, ',');
    HashMap localHashMap = new HashMap();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = StringExtensions.splitWithQuotes((String)((Iterator)localObject1).next(), '=');
      if ((((ArrayList)localObject2).size() == 2) && (!StringExtensions.isNullOrBlank((String)((ArrayList)localObject2).get(0))) && (!StringExtensions.isNullOrBlank((String)((ArrayList)localObject2).get(1))))
      {
        String str = (String)((ArrayList)localObject2).get(0);
        localObject2 = (String)((ArrayList)localObject2).get(1);
        str = StringExtensions.urlFormDecode(str);
        localObject2 = StringExtensions.urlFormDecode((String)localObject2);
        localHashMap.put(str.trim(), StringExtensions.removeQuoteInHeaderValue(((String)localObject2).trim()));
      }
      else if ((((ArrayList)localObject2).size() == 1) && (!StringExtensions.isNullOrBlank((String)((ArrayList)localObject2).get(0))))
      {
        localHashMap.put(StringExtensions.urlFormDecode((String)((ArrayList)localObject2).get(0)).trim(), StringExtensions.urlFormDecode(""));
      }
      else
      {
        throw new ClientException("Device certificate request is invalid", paramString);
      }
    }
    return localHashMap;
  }
  
  private boolean isWorkplaceJoined()
  {
    boolean bool;
    if (AuthenticationSettings.INSTANCE.getDeviceCertificateProxy() != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void validateHeaderForPkeyAuthChallenge(String paramString)
  {
    if (!StringUtil.isEmpty(paramString))
    {
      if (StringExtensions.hasPrefixInHeader(paramString, "PKeyAuth")) {
        return;
      }
      throw new ClientException("Device certificate request is invalid", "challenge response type is wrong.");
    }
    throw new ClientException("Device certificate request is invalid", "header value is empty.");
  }
  
  private void validatePKeyAuthChallenge(Map<String, String> paramMap)
  {
    PKeyAuthChallengeHandler.RequestField localRequestField = PKeyAuthChallengeHandler.RequestField.Nonce;
    if (!paramMap.containsKey("Nonce"))
    {
      localRequestField = PKeyAuthChallengeHandler.RequestField.Nonce;
      if (!paramMap.containsKey("Nonce".toLowerCase(Locale.US))) {
        throw new ClientException("Device certificate request is invalid", "Nonce is empty.");
      }
    }
    localRequestField = PKeyAuthChallengeHandler.RequestField.Version;
    if (paramMap.containsKey("Version"))
    {
      localRequestField = PKeyAuthChallengeHandler.RequestField.SubmitUrl;
      if (paramMap.containsKey("SubmitUrl"))
      {
        localRequestField = PKeyAuthChallengeHandler.RequestField.Context;
        if (paramMap.containsKey("Context"))
        {
          localRequestField = PKeyAuthChallengeHandler.RequestField.CertAuthorities;
          if (paramMap.containsKey("CertAuthorities")) {
            return;
          }
          throw new ClientException("Device certificate request is invalid", "CertAuthorities is empty");
        }
        throw new ClientException("Device certificate request is invalid", "Context is empty");
      }
      throw new ClientException("Device certificate request is invalid", "SubmitUrl is empty");
    }
    throw new ClientException("Device certificate request is invalid", "Version name is empty");
  }
  
  public PKeyAuthChallenge getPKeyAuthChallenge(String paramString)
  {
    paramString = StringExtensions.getUrlParameters(paramString);
    validatePKeyAuthChallenge(paramString);
    PKeyAuthChallenge.Builder localBuilder = new PKeyAuthChallenge.Builder();
    Object localObject1 = PKeyAuthChallengeHandler.RequestField.Nonce;
    Object localObject2 = localBuilder.setNonce((String)paramString.get("Nonce".toLowerCase(Locale.US)));
    localObject1 = PKeyAuthChallengeHandler.RequestField.Context;
    localObject1 = ((PKeyAuthChallenge.Builder)localObject2).setContext((String)paramString.get("Context"));
    localObject2 = PKeyAuthChallengeHandler.RequestField.CertAuthorities;
    localObject1 = ((PKeyAuthChallenge.Builder)localObject1).setCertAuthorities(StringExtensions.getStringTokens((String)paramString.get("CertAuthorities"), ";"));
    localObject2 = PKeyAuthChallengeHandler.RequestField.Version;
    localObject2 = ((PKeyAuthChallenge.Builder)localObject1).setVersion((String)paramString.get("Version"));
    localObject1 = PKeyAuthChallengeHandler.RequestField.SubmitUrl;
    ((PKeyAuthChallenge.Builder)localObject2).setSubmitUrl((String)paramString.get("SubmitUrl"));
    return localBuilder.build();
  }
  
  public PKeyAuthChallenge getPKeyAuthChallenge(String paramString1, String paramString2)
  {
    validateHeaderForPkeyAuthChallenge(paramString1);
    paramString1 = getPKeyAuthHeader(paramString1);
    validatePKeyAuthChallenge(paramString1);
    PKeyAuthChallenge.Builder localBuilder = new PKeyAuthChallenge.Builder();
    paramString2 = localBuilder.setSubmitUrl(paramString2);
    Object localObject = PKeyAuthChallengeHandler.RequestField.Nonce;
    paramString2 = paramString2.setNonce((String)paramString1.get("Nonce".toLowerCase(Locale.US)));
    localObject = PKeyAuthChallengeHandler.RequestField.Version;
    localObject = paramString2.setVersion((String)paramString1.get("Version"));
    paramString2 = PKeyAuthChallengeHandler.RequestField.Context;
    ((PKeyAuthChallenge.Builder)localObject).setContext((String)paramString1.get("Context"));
    if (!isWorkplaceJoined())
    {
      Logger.info(TAG, "Device is not workplace joined. ");
    }
    else
    {
      paramString2 = PKeyAuthChallengeHandler.RequestField.CertThumbprint;
      if (!StringExtensions.isNullOrBlank((String)paramString1.get("CertThumbprint")))
      {
        Logger.info(TAG, "CertThumbprint exists in the device auth challenge.");
        paramString2 = PKeyAuthChallengeHandler.RequestField.CertThumbprint;
        localBuilder.setThumbprint((String)paramString1.get("CertThumbprint"));
      }
      else
      {
        paramString2 = PKeyAuthChallengeHandler.RequestField.CertAuthorities;
        if (!paramString1.containsKey("CertAuthorities")) {
          break label223;
        }
        Logger.info(TAG, "CertAuthorities exists in the device auth challenge.");
        paramString2 = PKeyAuthChallengeHandler.RequestField.CertAuthorities;
        localBuilder.setCertAuthorities(StringExtensions.getStringTokens((String)paramString1.get("CertAuthorities"), ";"));
      }
    }
    return localBuilder.build();
    label223:
    throw new ClientException("Device certificate request is invalid", "Both certThumbprint and cert authorities are not present");
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.ui.webview.challengehandlers.PKeyAuthChallengeFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */