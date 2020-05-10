package com.microsoft.appcenter.analytics;

import com.microsoft.appcenter.utils.AppCenterLog;
import com.microsoft.appcenter.utils.HashUtils;
import com.microsoft.appcenter.utils.TicketCache;
import e.a.a.a.a;
import java.util.Date;

public class AuthenticationProvider
{
  public static final long REFRESH_THRESHOLD = 600000L;
  public AuthenticationCallback mCallback;
  public Date mExpiryDate;
  public final String mTicketKey;
  public final String mTicketKeyHash;
  public final TokenProvider mTokenProvider;
  public final Type mType;
  
  public AuthenticationProvider(Type paramType, String paramString, TokenProvider paramTokenProvider)
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
  
  private void handleTokenUpdate(String paramString, Date paramDate, AuthenticationCallback paramAuthenticationCallback)
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
      String str = mTicketKeyHash;
      paramAuthenticationCallback = new java/lang/StringBuilder;
      paramAuthenticationCallback.<init>();
      paramAuthenticationCallback.append(Type.access$100(mType));
      paramAuthenticationCallback.append(paramString);
      TicketCache.putTicket(str, paramAuthenticationCallback.toString());
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
      ((1)localObject1).<init>(this);
      mCallback = ((AuthenticationCallback)localObject1);
      mTokenProvider.acquireToken(mTicketKey, (AuthenticationCallback)localObject1);
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
  
  public TokenProvider getTokenProvider()
  {
    return mTokenProvider;
  }
  
  public Type getType()
  {
    return mType;
  }
  
  public static abstract interface AuthenticationCallback
  {
    public abstract void onAuthenticationResult(String paramString, Date paramDate);
  }
  
  public static abstract interface TokenProvider
  {
    public abstract void acquireToken(String paramString, AuthenticationProvider.AuthenticationCallback paramAuthenticationCallback);
  }
  
  public static enum Type
  {
    public final String mTokenPrefix;
    
    static
    {
      Type localType = new Type("MSA_DELEGATE", 1, "d");
      MSA_DELEGATE = localType;
      $VALUES = new Type[] { MSA_COMPACT, localType };
    }
    
    public Type(String paramString)
    {
      mTokenPrefix = a.b(paramString, ":");
    }
  }
}

/* Location:
 * Qualified Name:     com.microsoft.appcenter.analytics.AuthenticationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */