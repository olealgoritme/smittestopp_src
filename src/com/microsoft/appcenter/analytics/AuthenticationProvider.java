package com.microsoft.appcenter.analytics;

import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.HashUtils;
import com.microsoft.appcenter.utils.TicketCache;
import java.util.Date;

public class AuthenticationProvider
{
  public static final long REFRESH_THRESHOLD = 600000L;
  public AuthenticationProvider.AuthenticationCallback mCallback;
  public Date mExpiryDate;
  public final String mTicketKey;
  public final String mTicketKeyHash;
  public final AuthenticationProvider.TokenProvider mTokenProvider;
  public final AuthenticationProvider.Type mType;
  
  public AuthenticationProvider(AuthenticationProvider.Type paramType, String paramString, AuthenticationProvider.TokenProvider paramTokenProvider)
  {
    mType = paramType;
    mTicketKey = paramString;
    if (paramString == null) {
      paramType = null;
    } else {
      paramType = HashUtils.sha256(paramString);
    }
    mTicketKeyHash = paramType;
    mTokenProvider = paramTokenProvider;
  }
  
  private void handleTokenUpdate(String paramString, Date paramDate, AuthenticationProvider.AuthenticationCallback paramAuthenticationCallback)
  {
    try
    {
      if (mCallback != paramAuthenticationCallback)
      {
        paramString = new java/lang/StringBuilder;
        paramString.<init>();
        paramString.append("Ignore duplicate authentication callback calls, provider=");
        paramString.append(mType);
        AppCenterLog.debug("AppCenterAnalytics", paramString.toString());
        return;
      }
      mCallback = null;
      paramAuthenticationCallback = new java/lang/StringBuilder;
      paramAuthenticationCallback.<init>();
      paramAuthenticationCallback.append("Got result back from token provider=");
      paramAuthenticationCallback.append(mType);
      AppCenterLog.debug("AppCenterAnalytics", paramAuthenticationCallback.toString());
      if (paramString == null)
      {
        paramString = new java/lang/StringBuilder;
        paramString.<init>();
        paramString.append("Authentication failed for ticketKey=");
        paramString.append(mTicketKey);
        AppCenterLog.error("AppCenterAnalytics", paramString.toString());
        return;
      }
      if (paramDate == null)
      {
        paramString = new java/lang/StringBuilder;
        paramString.<init>();
        paramString.append("No expiry date provided for ticketKey=");
        paramString.append(mTicketKey);
        AppCenterLog.error("AppCenterAnalytics", paramString.toString());
        return;
      }
      paramAuthenticationCallback = mTicketKeyHash;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append(AuthenticationProvider.Type.access$100(mType));
      localStringBuilder.append(paramString);
      TicketCache.putTicket(paramAuthenticationCallback, localStringBuilder.toString());
      mExpiryDate = paramDate;
      return;
    }
    finally {}
  }
  
  public void acquireTokenAsync()
  {
    try
    {
      Object localObject1 = mCallback;
      if (localObject1 != null) {
        return;
      }
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      ((StringBuilder)localObject1).append("Calling token provider=");
      ((StringBuilder)localObject1).append(mType);
      ((StringBuilder)localObject1).append(" callback.");
      AppCenterLog.debug("AppCenterAnalytics", ((StringBuilder)localObject1).toString());
      localObject1 = new com/microsoft/appcenter/analytics/AuthenticationProvider$1;
      ((AuthenticationProvider.1)localObject1).<init>(this);
      mCallback = ((AuthenticationProvider.AuthenticationCallback)localObject1);
      mTokenProvider.acquireToken(mTicketKey, (AuthenticationProvider.AuthenticationCallback)localObject1);
      return;
    }
    finally {}
  }
  
  public void checkTokenExpiry()
  {
    try
    {
      if ((mExpiryDate != null) && (mExpiryDate.getTime() <= System.currentTimeMillis() + 600000L)) {
        acquireTokenAsync();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getTicketKey()
  {
    return mTicketKey;
  }
  
  public String getTicketKeyHash()
  {
    return mTicketKeyHash;
  }
  
  public AuthenticationProvider.TokenProvider getTokenProvider()
  {
    return mTokenProvider;
  }
  
  public AuthenticationProvider.Type getType()
  {
    return mType;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.analytics.AuthenticationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */