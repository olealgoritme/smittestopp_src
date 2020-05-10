package com.microsoft.identity.common.adal.internal;

import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public enum AuthenticationSettings
{
  public static final int DEFAULT_EXPIRATION_BUFFER = 300;
  public static final int DEFAULT_READ_CONNECT_TIMEOUT = 30000;
  public static final int SECRET_RAW_KEY_LENGTH = 32;
  public String mActivityPackageName;
  public String mBrokerPackageName = "com.microsoft.windowsintune.companyportal";
  public final Map<String, byte[]> mBrokerSecretKeys = new HashMap(2);
  public String mBrokerSignature = "1L4Z9FJCgn5c0VLhyAxC5O9LdlE=";
  public Class<?> mClazzDeviceCertProxy;
  public int mConnectTimeOut = 30000;
  public boolean mEnableHardwareAcceleration = true;
  public int mExpirationBuffer = 300;
  public int mReadTimeOut = 30000;
  public AtomicReference<byte[]> mSecretKeyData = new AtomicReference();
  public String mSharedPrefPackageName;
  public boolean mUseBroker = false;
  
  static
  {
    AuthenticationSettings localAuthenticationSettings = new AuthenticationSettings("INSTANCE", 0);
    INSTANCE = localAuthenticationSettings;
    $VALUES = new AuthenticationSettings[] { localAuthenticationSettings };
  }
  
  public AuthenticationSettings() {}
  
  public void clearBrokerSecretKeys()
  {
    mBrokerSecretKeys.clear();
  }
  
  public void clearSecretKeysForTestCases()
  {
    mBrokerSecretKeys.clear();
    mSecretKeyData.set(null);
  }
  
  public String getActivityPackageName()
  {
    return mActivityPackageName;
  }
  
  public String getBrokerPackageName()
  {
    return mBrokerPackageName;
  }
  
  public Map<String, byte[]> getBrokerSecretKeys()
  {
    return Collections.unmodifiableMap(mBrokerSecretKeys);
  }
  
  public String getBrokerSignature()
  {
    return mBrokerSignature;
  }
  
  public int getConnectTimeOut()
  {
    return mConnectTimeOut;
  }
  
  public Class<?> getDeviceCertificateProxy()
  {
    return mClazzDeviceCertProxy;
  }
  
  public boolean getDisableWebViewHardwareAcceleration()
  {
    return mEnableHardwareAcceleration;
  }
  
  public int getExpirationBuffer()
  {
    return mExpirationBuffer;
  }
  
  public int getReadTimeOut()
  {
    return mReadTimeOut;
  }
  
  public byte[] getSecretKeyData()
  {
    return (byte[])mSecretKeyData.get();
  }
  
  public String getSharedPrefPackageName()
  {
    return mSharedPrefPackageName;
  }
  
  @Deprecated
  public boolean getSkipBroker()
  {
    return mUseBroker ^ true;
  }
  
  public boolean getUseBroker()
  {
    return mUseBroker;
  }
  
  public void setActivityPackageName(String paramString)
  {
    if (!StringExtensions.isNullOrBlank(paramString))
    {
      mActivityPackageName = paramString;
      return;
    }
    throw new IllegalArgumentException("activityPackageName cannot be empty or null");
  }
  
  public void setBrokerPackageName(String paramString)
  {
    if (!StringExtensions.isNullOrBlank(paramString))
    {
      mBrokerPackageName = paramString;
      return;
    }
    throw new IllegalArgumentException("packageName cannot be empty or null");
  }
  
  public void setBrokerSecretKeys(Map<String, byte[]> paramMap)
  {
    if (paramMap != null)
    {
      if (paramMap.size() == 2)
      {
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramMap.next();
          if ((localEntry.getValue() != null) && (((byte[])localEntry.getValue()).length == 32)) {
            mBrokerSecretKeys.put(localEntry.getKey(), localEntry.getValue());
          } else {
            throw new IllegalArgumentException("Passed in raw key is null or length is not as expected. ");
          }
        }
        return;
      }
      throw new IllegalArgumentException("Expect two keys are passed in.");
    }
    throw new IllegalArgumentException("The passed in secret key map is null.");
  }
  
  public void setBrokerSignature(String paramString)
  {
    if (!StringExtensions.isNullOrBlank(paramString))
    {
      mBrokerSignature = paramString;
      return;
    }
    throw new IllegalArgumentException("brokerSignature cannot be empty or null");
  }
  
  public void setConnectTimeOut(int paramInt)
  {
    if (paramInt >= 0)
    {
      mConnectTimeOut = paramInt;
      return;
    }
    throw new IllegalArgumentException("Invalid timeOutMillis");
  }
  
  public void setDeviceCertificateProxyClass(Class paramClass)
  {
    if (IDeviceCertificate.class.isAssignableFrom(paramClass))
    {
      mClazzDeviceCertProxy = paramClass;
      return;
    }
    throw new IllegalArgumentException("clazz");
  }
  
  public void setDisableWebViewHardwareAcceleration(boolean paramBoolean)
  {
    mEnableHardwareAcceleration = paramBoolean;
  }
  
  public void setExpirationBuffer(int paramInt)
  {
    mExpirationBuffer = paramInt;
  }
  
  public void setReadTimeOut(int paramInt)
  {
    if (paramInt >= 0)
    {
      mReadTimeOut = paramInt;
      return;
    }
    throw new IllegalArgumentException("Invalid timeOutMillis");
  }
  
  public void setSecretKey(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length == 32))
    {
      mSecretKeyData.set(paramArrayOfByte);
      return;
    }
    throw new IllegalArgumentException("rawKey");
  }
  
  public void setSharedPrefPackageName(String paramString)
  {
    mSharedPrefPackageName = paramString;
  }
  
  @Deprecated
  public void setSkipBroker(boolean paramBoolean)
  {
    mUseBroker = (paramBoolean ^ true);
  }
  
  public void setUseBroker(boolean paramBoolean)
  {
    mUseBroker = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.adal.internal.AuthenticationSettings
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */