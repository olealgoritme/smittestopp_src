package com.microsoft.identity.common.internal.ui.browser;

import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Browser
{
  public static final String DIGEST_SHA_512 = "SHA-512";
  public static final int PRIME_HASH_FACTOR = 92821;
  public final Boolean mIsCustomTabsServiceSupported;
  public final String mPackageName;
  public final Set<String> mSignatureHashes;
  public final String mVersion;
  
  public Browser(PackageInfo paramPackageInfo)
  {
    this(packageName, generateSignatureHashes(signatures), versionName, false);
  }
  
  public Browser(PackageInfo paramPackageInfo, Boolean paramBoolean)
  {
    this(packageName, generateSignatureHashes(signatures), versionName, paramBoolean.booleanValue());
  }
  
  public Browser(String paramString1, Set<String> paramSet, String paramString2, boolean paramBoolean)
  {
    mPackageName = paramString1;
    mSignatureHashes = paramSet;
    mVersion = paramString2;
    mIsCustomTabsServiceSupported = Boolean.valueOf(paramBoolean);
  }
  
  public static Set<String> generateSignatureHashes(Signature[] paramArrayOfSignature)
  {
    HashSet localHashSet = new HashSet();
    int i = paramArrayOfSignature.length;
    int j = 0;
    while (j < i)
    {
      Signature localSignature = paramArrayOfSignature[j];
      try
      {
        localHashSet.add(Base64.encodeToString(MessageDigest.getInstance("SHA-512").digest(localSignature.toByteArray()), 10));
        j++;
      }
      catch (NoSuchAlgorithmException paramArrayOfSignature)
      {
        throw new IllegalStateException("Platform does not supportSHA-512 hashing");
      }
    }
    return localHashSet;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && ((paramObject instanceof Browser)))
    {
      paramObject = (Browser)paramObject;
      if ((!mPackageName.equals(((Browser)paramObject).getPackageName())) || (!mVersion.equals(((Browser)paramObject).getVersion())) || (!mSignatureHashes.equals(((Browser)paramObject).getSignatureHashes()))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getPackageName()
  {
    return mPackageName;
  }
  
  public Set<String> getSignatureHashes()
  {
    return mSignatureHashes;
  }
  
  public String getVersion()
  {
    return mVersion;
  }
  
  public int hashCode()
  {
    int i = mPackageName.hashCode();
    i = (mVersion.hashCode() + i * 92821) * 92821 + mIsCustomTabsServiceSupported.booleanValue();
    Iterator localIterator = mSignatureHashes.iterator();
    while (localIterator.hasNext()) {
      i = i * 92821 + ((String)localIterator.next()).hashCode();
    }
    return i;
  }
  
  public boolean isCustomTabsServiceSupported()
  {
    return mIsCustomTabsServiceSupported.booleanValue();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.ui.browser.Browser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */