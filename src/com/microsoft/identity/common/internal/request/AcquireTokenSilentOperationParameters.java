package com.microsoft.identity.common.internal.request;

import com.microsoft.identity.common.exception.ArgumentException;
import com.microsoft.identity.common.internal.authorities.Authority;
import com.microsoft.identity.common.internal.authorities.AzureActiveDirectoryB2CAuthority;
import com.microsoft.identity.common.internal.dto.IAccountRecord;
import com.microsoft.identity.common.internal.dto.RefreshTokenRecord;
import com.microsoft.identity.common.internal.logging.Logger;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.internal.providers.microsoft.azureactivedirectory.AzureActiveDirectoryCloud;
import e.a.a.a.a;
import java.io.IOException;
import java.net.URL;

public class AcquireTokenSilentOperationParameters
  extends OperationParameters
{
  public static final String TAG = "AcquireTokenSilentOperationParameters";
  public static final Object sLock = new Object();
  public transient RefreshTokenRecord mRefreshToken;
  
  private boolean authorityMatchesAccountEnvironment()
  {
    boolean bool1 = false;
    try
    {
      if (!AzureActiveDirectory.isInitialized()) {
        performCloudDiscovery();
      }
      AzureActiveDirectoryCloud localAzureActiveDirectoryCloud = AzureActiveDirectory.getAzureActiveDirectoryCloudFromHostName(mAccount.getEnvironment());
      boolean bool2 = bool1;
      if (localAzureActiveDirectoryCloud != null)
      {
        boolean bool3 = localAzureActiveDirectoryCloud.getPreferredNetworkHostName().equals(getAuthority().getAuthorityURL().getAuthority());
        bool2 = bool1;
        if (bool3) {
          bool2 = true;
        }
      }
      return bool2;
    }
    catch (IOException localIOException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(TAG);
      localStringBuilder.append(":authorityMatchesAccountEnvironment");
      Logger.error(localStringBuilder.toString(), "Unable to perform cloud discovery", localIOException);
    }
    return false;
  }
  
  private boolean isAuthorityB2C()
  {
    return getAuthority() instanceof AzureActiveDirectoryB2CAuthority;
  }
  
  public static void performCloudDiscovery()
  {
    a.b(new StringBuilder(), TAG, ":performCloudDiscovery", "Performing cloud discovery...");
    synchronized (sLock)
    {
      AzureActiveDirectory.performCloudDiscovery();
      return;
    }
  }
  
  public RefreshTokenRecord getRefreshToken()
  {
    return mRefreshToken;
  }
  
  public void setRefreshToken(RefreshTokenRecord paramRefreshTokenRecord)
  {
    mRefreshToken = paramRefreshTokenRecord;
  }
  
  public void validate()
  {
    super.validate();
    if (mAccount == null) {
      Logger.warn(TAG, "The account set on silent operation parameters is NULL.");
    } else if ((!isAuthorityB2C()) && (!authorityMatchesAccountEnvironment())) {
      throw new ArgumentException("acquireTokenSilent", "authority", "Authority passed to silent parameters does not match with the cloud associated to the account.");
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.request.AcquireTokenSilentOperationParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */