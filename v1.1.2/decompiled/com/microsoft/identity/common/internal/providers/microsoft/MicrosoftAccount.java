package com.microsoft.identity.common.internal.providers.microsoft;

import android.net.Uri;
import com.microsoft.identity.common.BaseAccount;
import com.microsoft.identity.common.adal.internal.util.DateExtensions;
import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.internal.cache.SchemaUtil;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.ClientInfo;
import com.microsoft.identity.common.internal.providers.oauth2.IDToken;
import com.microsoft.identity.common.internal.util.StringUtil;
import e.a.a.a.a;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

public abstract class MicrosoftAccount
  extends BaseAccount
{
  public static final String AUTHORITY_TYPE_V1_V2 = "MSSTS";
  public static final String TAG = "MicrosoftAccount";
  public String mDisplayableId;
  public String mEnvironment;
  public String mFamilyName;
  public String mGivenName;
  public IDToken mIDToken;
  public String mMiddleName;
  public String mName;
  public Uri mPasswordChangeUrl;
  public Date mPasswordExpiresOn;
  public String mRawClientInfo;
  public String mTenantId;
  public String mUid;
  public String mUniqueId;
  public String mUtid;
  
  public MicrosoftAccount()
  {
    String str = TAG;
    StringBuilder localStringBuilder = a.a("Init: ");
    localStringBuilder.append(TAG);
    Logger.verbose(str, localStringBuilder.toString());
  }
  
  public MicrosoftAccount(IDToken paramIDToken, ClientInfo paramClientInfo)
  {
    String str = TAG;
    StringBuilder localStringBuilder = a.a("Init: ");
    localStringBuilder.append(TAG);
    Logger.verbose(str, localStringBuilder.toString());
    mIDToken = paramIDToken;
    mRawClientInfo = paramClientInfo.getRawClientInfo();
    paramIDToken = paramIDToken.getTokenClaims();
    mUniqueId = getUniqueId(paramIDToken);
    mDisplayableId = getDisplayableId(paramIDToken);
    mName = ((String)paramIDToken.get("name"));
    mGivenName = ((String)paramIDToken.get("given_name"));
    mFamilyName = ((String)paramIDToken.get("family_name"));
    mMiddleName = ((String)paramIDToken.get("middle_name"));
    if (!StringUtil.isEmpty((String)paramIDToken.get("tid")))
    {
      mTenantId = ((String)paramIDToken.get("tid"));
    }
    else if (!StringUtil.isEmpty(paramClientInfo.getUtid()))
    {
      Logger.warnPII(TAG, "realm is not returned from server. Use utid as realm.");
      mTenantId = paramClientInfo.getUtid();
    }
    else
    {
      Logger.warnPII(TAG, "realm and utid is not returned from server. Use empty string as default tid.");
      mTenantId = "";
    }
    mUid = paramClientInfo.getUid();
    mUtid = paramClientInfo.getUtid();
    paramClientInfo = paramIDToken.get("pwd_exp");
    long l;
    if (paramClientInfo != null) {
      l = Long.valueOf(paramClientInfo.toString()).longValue();
    } else {
      l = 0L;
    }
    if (l > 0L)
    {
      paramClientInfo = new GregorianCalendar();
      paramClientInfo.add(13, (int)l);
      mPasswordExpiresOn = paramClientInfo.getTime();
    }
    mPasswordChangeUrl = null;
    paramIDToken = (String)paramIDToken.get("pwd_url");
    if (!StringExtensions.isNullOrBlank(paramIDToken)) {
      mPasswordChangeUrl = Uri.parse(paramIDToken);
    }
  }
  
  private String getUniqueId(Map<String, ?> paramMap)
  {
    StringBuilder localStringBuilder;
    if (!StringExtensions.isNullOrBlank((String)paramMap.get("oid")))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append(":");
      localStringBuilder.append("getUniqueId");
      Logger.info(localStringBuilder.toString(), "Using ObjectId as uniqueId");
      paramMap = (String)paramMap.get("oid");
    }
    else if (!StringExtensions.isNullOrBlank((String)paramMap.get("sub")))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append(":");
      localStringBuilder.append("getUniqueId");
      Logger.info(localStringBuilder.toString(), "Using Subject as uniqueId");
      paramMap = (String)paramMap.get("sub");
    }
    else
    {
      paramMap = null;
    }
    return paramMap;
  }
  
  public String getAlternativeAccountId()
  {
    return SchemaUtil.getAlternativeAccountId(mIDToken);
  }
  
  public String getAvatarUrl()
  {
    return SchemaUtil.getAvatarUrl(mIDToken);
  }
  
  public List<String> getCacheIdentifiers()
  {
    ArrayList localArrayList = new ArrayList();
    String str = mDisplayableId;
    if (str != null) {
      localArrayList.add(str);
    }
    str = mUniqueId;
    if (str != null) {
      localArrayList.add(str);
    }
    if (getUniqueIdentifier() != null) {
      localArrayList.add(getUniqueIdentifier());
    }
    return localArrayList;
  }
  
  public String getClientInfo()
  {
    return mRawClientInfo;
  }
  
  public String getDisplayableId()
  {
    return mDisplayableId;
  }
  
  public abstract String getDisplayableId(Map<String, ?> paramMap);
  
  public String getEnvironment()
  {
    return mEnvironment;
  }
  
  public String getFamilyName()
  {
    return mFamilyName;
  }
  
  public String getFirstName()
  {
    return mGivenName;
  }
  
  public String getHomeAccountId()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getUid());
    localStringBuilder.append(".");
    localStringBuilder.append(getUtid());
    return localStringBuilder.toString();
  }
  
  public IDToken getIDToken()
  {
    return mIDToken;
  }
  
  public String getLocalAccountId()
  {
    return getUserId();
  }
  
  public String getMiddleName()
  {
    return mMiddleName;
  }
  
  public String getName()
  {
    return mName;
  }
  
  public Uri getPasswordChangeUrl()
  {
    return mPasswordChangeUrl;
  }
  
  public Date getPasswordExpiresOn()
  {
    return DateExtensions.createCopy(mPasswordExpiresOn);
  }
  
  public String getRealm()
  {
    return mTenantId;
  }
  
  public String getUid()
  {
    return mUid;
  }
  
  public String getUniqueIdentifier()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringExtensions.base64UrlEncodeToString(mUid));
    localStringBuilder.append(".");
    localStringBuilder.append(StringExtensions.base64UrlEncodeToString(mUtid));
    return localStringBuilder.toString();
  }
  
  public String getUserId()
  {
    return mUniqueId;
  }
  
  public String getUsername()
  {
    return getDisplayableId();
  }
  
  public String getUtid()
  {
    return mUtid;
  }
  
  public void setDisplayableId(String paramString)
  {
    mDisplayableId = paramString;
  }
  
  public void setEnvironment(String paramString)
  {
    mEnvironment = paramString;
  }
  
  public void setFamilyName(String paramString)
  {
    mFamilyName = paramString;
  }
  
  public void setFirstName(String paramString)
  {
    mGivenName = paramString;
  }
  
  public void setName(String paramString)
  {
    mName = paramString;
  }
  
  public void setUid(String paramString)
  {
    mUid = paramString;
  }
  
  public void setUserId(String paramString)
  {
    mUniqueId = paramString;
  }
  
  public void setUtid(String paramString)
  {
    mUtid = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = a.a("MicrosoftAccount{mDisplayableId='");
    a.a(localStringBuilder, mDisplayableId, '\'', ", mUniqueId='");
    a.a(localStringBuilder, mUniqueId, '\'', ", mName='");
    a.a(localStringBuilder, mName, '\'', ", mUid='");
    a.a(localStringBuilder, mUid, '\'', ", mUtid='");
    a.a(localStringBuilder, mUtid, '\'', ", mIDToken=");
    localStringBuilder.append(mIDToken);
    localStringBuilder.append(", mPasswordChangeUrl=");
    localStringBuilder.append(mPasswordChangeUrl);
    localStringBuilder.append(", mPasswordExpiresOn=");
    localStringBuilder.append(mPasswordExpiresOn);
    localStringBuilder.append(", mTenantId='");
    a.a(localStringBuilder, mTenantId, '\'', ", mGivenName='");
    a.a(localStringBuilder, mGivenName, '\'', ", mFamilyName='");
    a.a(localStringBuilder, mFamilyName, '\'', "} ");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.providers.microsoft.MicrosoftAccount
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */