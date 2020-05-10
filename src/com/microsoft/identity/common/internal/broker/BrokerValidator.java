package com.microsoft.identity.common.internal.broker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import com.microsoft.identity.common.adal.internal.AuthenticationSettings;
import com.microsoft.identity.common.exception.BaseException;
import com.microsoft.identity.common.exception.ClientException;
import com.microsoft.identity.common.internal.logging.Logger;
import e.a.a.a.a;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.cert.CertPathValidator;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BrokerValidator
{
  public static final String TAG = "BrokerValidator";
  public final String mCompanyPortalSignature;
  public final Context mContext;
  
  public BrokerValidator(Context paramContext)
  {
    mContext = paramContext;
    mCompanyPortalSignature = AuthenticationSettings.INSTANCE.getBrokerSignature();
  }
  
  public static String getBrokerRedirectUri(Context paramContext, String paramString)
  {
    return PackageHelper.getBrokerRedirectUrl(paramString, new PackageHelper(paramContext.getPackageManager()).getCurrentSignatureForPackage(paramString));
  }
  
  private X509Certificate getSelfSignedCert(List<X509Certificate> paramList)
  {
    Iterator localIterator = paramList.iterator();
    int i = 0;
    paramList = null;
    while (localIterator.hasNext())
    {
      X509Certificate localX509Certificate = (X509Certificate)localIterator.next();
      if (localX509Certificate.getSubjectDN().equals(localX509Certificate.getIssuerDN()))
      {
        i++;
        paramList = localX509Certificate;
      }
    }
    if ((i <= 1) && (paramList != null)) {
      return paramList;
    }
    throw new ClientException("Calling app could not be verified", "Multiple self signed certs found or no self signed cert existed.");
  }
  
  public static boolean isValidBrokerRedirect(String paramString1, Context paramContext, String paramString2)
  {
    boolean bool;
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equalsIgnoreCase(getBrokerRedirectUri(paramContext, paramString2)))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @SuppressLint({"PackageManagerGetSignatures"})
  private List<X509Certificate> readCertDataForBrokerApp(String paramString)
  {
    Object localObject = mContext.getPackageManager().getPackageInfo(paramString, 64);
    if (localObject != null)
    {
      paramString = signatures;
      if ((paramString != null) && (paramString.length != 0))
      {
        paramString = new ArrayList(signatures.length);
        localObject = signatures;
        int i = localObject.length;
        int j = 0;
        while (j < i)
        {
          ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(localObject[j].toByteArray());
          try
          {
            paramString.add((X509Certificate)CertificateFactory.getInstance("X509").generateCertificate(localByteArrayInputStream));
            j++;
          }
          catch (CertificateException paramString)
          {
            throw new ClientException("Calling app could not be verified");
          }
        }
        return paramString;
      }
      throw new ClientException("Calling app could not be verified", "No signature associated with the broker package.");
    }
    throw new ClientException("App package name is not found in the package manager", "No broker package existed.");
  }
  
  private void verifyCertificateChain(List<X509Certificate> paramList)
  {
    PKIXParameters localPKIXParameters = new PKIXParameters(Collections.singleton(new TrustAnchor(getSelfSignedCert(paramList), null)));
    localPKIXParameters.setRevocationEnabled(false);
    paramList = CertificateFactory.getInstance("X.509").generateCertPath(paramList);
    CertPathValidator.getInstance("PKIX").validate(paramList, localPKIXParameters);
  }
  
  private String verifySignatureHash(List<X509Certificate> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      X509Certificate localX509Certificate = (X509Certificate)paramList.next();
      Object localObject = MessageDigest.getInstance("SHA");
      ((MessageDigest)localObject).update(localX509Certificate.getEncoded());
      localObject = Base64.encodeToString(((MessageDigest)localObject).digest(), 2);
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(',');
      if ((mCompanyPortalSignature.equals(localObject)) || ("ho040S3ffZkmxqtQrSwpTVOn9r0=".equals(localObject))) {
        return (String)localObject;
      }
    }
    paramList = a.a("SignatureHashes: ");
    paramList.append(localStringBuilder.toString());
    throw new ClientException("Calling app could not be verified", paramList.toString());
  }
  
  public boolean verifySignature(String paramString)
  {
    boolean bool = false;
    try
    {
      paramString = verifySignatureAndThrow(paramString);
      if (paramString != null) {
        bool = true;
      }
      return bool;
    }
    catch (ClientException localClientException)
    {
      paramString = new StringBuilder();
      paramString.append(localClientException.getErrorCode());
      paramString.append(": ");
      paramString.append(localClientException.getMessage());
      Logger.error("BrokerValidator:verifySignature", paramString.toString(), localClientException);
    }
    return false;
  }
  
  public String verifySignatureAndThrow(String paramString)
  {
    try
    {
      try
      {
        paramString = readCertDataForBrokerApp(paramString);
        String str = verifySignatureHash(paramString);
        if (paramString.size() > 1) {
          verifyCertificateChain(paramString);
        }
        return str;
      }
      catch (GeneralSecurityException paramString) {}catch (IOException paramString) {}
      throw new ClientException("Signature could not be verified", paramString.getMessage(), paramString);
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new ClientException("no_such_algorithm", paramString.getMessage(), paramString);
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      throw new ClientException("App package name is not found in the package manager", paramString.getMessage(), paramString);
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.broker.BrokerValidator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */