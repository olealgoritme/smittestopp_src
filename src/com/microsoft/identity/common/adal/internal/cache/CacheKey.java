package com.microsoft.identity.common.adal.internal.cache;

import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import e.a.a.a.a;
import java.io.Serializable;
import java.util.Locale;

public class CacheKey
  implements Serializable
{
  public static final String FRT_ENTRY_PREFIX = "foci-";
  public static final long serialVersionUID = 8067972995583126404L;
  public String mAuthority;
  public String mClientId;
  public String mFamilyClientId;
  public boolean mIsMultipleResourceRefreshToken;
  public String mResource;
  public String mUserId;
  
  public static String createCacheKey(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4, String paramString5)
  {
    if (paramString1 != null)
    {
      if ((paramString3 == null) && (paramString5 == null)) {
        throw new IllegalArgumentException("both clientId and familyClientId are null");
      }
      CacheKey localCacheKey = new CacheKey();
      if (!paramBoolean) {
        if (paramString2 != null) {
          mResource = paramString2;
        } else {
          throw new IllegalArgumentException("resource");
        }
      }
      paramString1 = paramString1.toLowerCase(Locale.US);
      mAuthority = paramString1;
      if (paramString1.endsWith("/"))
      {
        paramString1 = mAuthority;
        mAuthority = ((String)paramString1.subSequence(0, paramString1.length() - 1));
      }
      if (paramString3 != null) {
        mClientId = paramString3.toLowerCase(Locale.US);
      }
      if (paramString5 != null) {
        mFamilyClientId = a.b("foci-", paramString5).toLowerCase(Locale.US);
      }
      mIsMultipleResourceRefreshToken = paramBoolean;
      if (!StringExtensions.isNullOrBlank(paramString4)) {
        mUserId = paramString4.toLowerCase(Locale.US);
      }
      return localCacheKey.toString();
    }
    throw new IllegalArgumentException("authority");
  }
  
  public static String createCacheKeyForFRT(String paramString1, String paramString2, String paramString3)
  {
    return createCacheKey(paramString1, null, null, true, paramString3, paramString2);
  }
  
  public static String createCacheKeyForMRRT(String paramString1, String paramString2, String paramString3)
  {
    return createCacheKey(paramString1, null, paramString2, true, paramString3, null);
  }
  
  public static String createCacheKeyForRTEntry(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return createCacheKey(paramString1, paramString2, paramString3, false, paramString4, null);
  }
  
  public String getAuthority()
  {
    return mAuthority;
  }
  
  public String getClientId()
  {
    return mClientId;
  }
  
  public boolean getIsMultipleResourceRefreshToken()
  {
    return mIsMultipleResourceRefreshToken;
  }
  
  public String getResource()
  {
    return mResource;
  }
  
  public String getUserId()
  {
    return mUserId;
  }
  
  public String toString()
  {
    boolean bool = StringExtensions.isNullOrBlank(mFamilyClientId);
    String str1 = "y";
    if (bool)
    {
      localLocale = Locale.US;
      str2 = mAuthority;
      str3 = mResource;
      str4 = mClientId;
      if (!mIsMultipleResourceRefreshToken) {
        str1 = "n";
      }
      return String.format(localLocale, "%s$%s$%s$%s$%s", new Object[] { str2, str3, str4, str1, mUserId });
    }
    Locale localLocale = Locale.US;
    String str3 = mAuthority;
    String str2 = mResource;
    String str4 = mClientId;
    if (!mIsMultipleResourceRefreshToken) {
      str1 = "n";
    }
    return String.format(localLocale, "%s$%s$%s$%s$%s$%s", new Object[] { str3, str2, str4, str1, mUserId, mFamilyClientId });
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.adal.internal.cache.CacheKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */