package com.microsoft.identity.common.internal.result;

import android.text.TextUtils;
import com.microsoft.identity.common.internal.cache.ICacheRecord;
import com.microsoft.identity.common.internal.dto.AccessTokenRecord;
import com.microsoft.identity.common.internal.dto.Credential;
import com.microsoft.identity.common.internal.dto.IAccountRecord;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.request.SdkType;
import e.a.a.a.a;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LocalAuthenticationResult
  implements ILocalAuthenticationResult
{
  public static final String TAG = "com.microsoft.identity.common.internal.result.LocalAuthenticationResult";
  public AccessTokenRecord mAccessTokenRecord;
  public IAccountRecord mAccountRecord;
  public List<ICacheRecord> mCompleteResultFromCache;
  public String mFamilyId;
  public String mRawIdToken;
  public String mRefreshToken;
  public String mRefreshTokenAge;
  public String mSpeRing;
  
  public LocalAuthenticationResult(ICacheRecord paramICacheRecord, SdkType paramSdkType)
  {
    mAccessTokenRecord = paramICacheRecord.getAccessToken();
    mAccountRecord = paramICacheRecord.getAccount();
    if (paramICacheRecord.getRefreshToken() != null) {
      mRefreshToken = paramICacheRecord.getRefreshToken().getSecret();
    }
    if (paramSdkType == SdkType.ADAL) {
      paramSdkType = paramICacheRecord.getV1IdToken();
    } else {
      paramSdkType = paramICacheRecord.getIdToken();
    }
    if (paramSdkType != null)
    {
      mRawIdToken = paramSdkType.getSecret();
      str = TAG;
      paramICacheRecord = a.a("Id Token type: ");
      paramICacheRecord.append(paramSdkType.getCredentialType());
      Logger.info(str, paramICacheRecord.toString());
    }
    else if (paramICacheRecord.getV1IdToken() != null)
    {
      Logger.info(TAG, "V1 Id Token returned here, ");
      mRawIdToken = paramICacheRecord.getV1IdToken().getSecret();
    }
    String str = TAG;
    StringBuilder localStringBuilder = a.a("Constructing LocalAuthentication result, AccessTokenRecord null: ");
    paramICacheRecord = mAccessTokenRecord;
    boolean bool1 = true;
    boolean bool2;
    if (paramICacheRecord == null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    localStringBuilder.append(bool2);
    localStringBuilder.append(", AccountRecord null: ");
    if (mAccountRecord == null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    localStringBuilder.append(bool2);
    localStringBuilder.append(", RefreshTokenRecord null or empty: ");
    localStringBuilder.append(TextUtils.isEmpty(mRefreshToken));
    localStringBuilder.append(", IdTokenRecord null: ");
    if (paramSdkType == null) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    localStringBuilder.append(bool2);
    Logger.info(str, localStringBuilder.toString());
  }
  
  public LocalAuthenticationResult(ICacheRecord paramICacheRecord, List<ICacheRecord> paramList, SdkType paramSdkType)
  {
    this(paramICacheRecord, paramSdkType);
    mCompleteResultFromCache = paramList;
  }
  
  public String getAccessToken()
  {
    return mAccessTokenRecord.getSecret();
  }
  
  public AccessTokenRecord getAccessTokenRecord()
  {
    return mAccessTokenRecord;
  }
  
  public IAccountRecord getAccountRecord()
  {
    return mAccountRecord;
  }
  
  public List<ICacheRecord> getCacheRecordWithTenantProfileData()
  {
    return mCompleteResultFromCache;
  }
  
  public Date getExpiresOn()
  {
    return new Date(TimeUnit.SECONDS.toMillis(Long.parseLong(mAccessTokenRecord.getExpiresOn())));
  }
  
  public String getFamilyId()
  {
    return mFamilyId;
  }
  
  public String getIdToken()
  {
    return mRawIdToken;
  }
  
  public String getRefreshToken()
  {
    return mRefreshToken;
  }
  
  public String getRefreshTokenAge()
  {
    return mRefreshTokenAge;
  }
  
  public String[] getScope()
  {
    return mAccessTokenRecord.getTarget().split("\\s");
  }
  
  public String getSpeRing()
  {
    return mSpeRing;
  }
  
  public String getTenantId()
  {
    return mAccessTokenRecord.getRealm();
  }
  
  public String getUniqueId()
  {
    return mAccessTokenRecord.getHomeAccountId();
  }
  
  public void setRefreshTokenAge(String paramString)
  {
    mRefreshTokenAge = paramString;
  }
  
  public void setSpeRing(String paramString)
  {
    mSpeRing = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.result.LocalAuthenticationResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */