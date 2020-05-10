package com.microsoft.identity.common.internal.telemetry;

import com.microsoft.identity.common.adal.internal.util.StringExtensions;
import com.microsoft.identity.common.internal.logging.Logger;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CliTelemInfo
  implements Serializable
{
  public static final String TAG = CliTelemInfo.class.getSimpleName();
  public String mRefreshTokenAge;
  public String mServerErrorCode;
  public String mServerSubErrorCode;
  public String mSpeRing;
  public String mVersion;
  
  public CliTelemInfo() {}
  
  public CliTelemInfo(CliTelemInfo paramCliTelemInfo)
  {
    if (paramCliTelemInfo != null)
    {
      mVersion = mVersion;
      mServerErrorCode = mServerErrorCode;
      mServerSubErrorCode = mServerSubErrorCode;
      mRefreshTokenAge = mRefreshTokenAge;
      mSpeRing = mSpeRing;
    }
  }
  
  public static CliTelemInfo fromXMsCliTelemHeader(String paramString)
  {
    if (StringExtensions.isNullOrBlank(paramString)) {
      return null;
    }
    Object localObject = paramString.split(",");
    if (localObject.length == 0)
    {
      Logger.warn(TAG, "SPE Ring header missing version field.");
      return null;
    }
    String str = localObject[0];
    localObject = new CliTelemInfo();
    ((CliTelemInfo)localObject).setVersion(str);
    if (str.equals("1"))
    {
      if (!Pattern.compile("^[1-9]+\\.?[0-9|\\.]*,[0-9|\\.]*,[0-9|\\.]*,[^,]*[0-9\\.]*,[^,]*$").matcher(paramString).matches())
      {
        Logger.warn(TAG, "Malformed x-ms-clitelem header");
        return null;
      }
      paramString = paramString.split(",", 5);
      ((CliTelemInfo)localObject).setServerErrorCode(paramString[1]);
      ((CliTelemInfo)localObject).setServerSubErrorCode(paramString[2]);
      ((CliTelemInfo)localObject).setRefreshTokenAge(paramString[3]);
      ((CliTelemInfo)localObject).setSpeRing(paramString[4]);
      return (CliTelemInfo)localObject;
    }
    Logger.warn(TAG, "Unrecognized x-ms-clitelem header version");
    return null;
  }
  
  public String getRefreshTokenAge()
  {
    return mRefreshTokenAge;
  }
  
  public String getServerErrorCode()
  {
    return mServerErrorCode;
  }
  
  public String getServerSubErrorCode()
  {
    return mServerSubErrorCode;
  }
  
  public String getSpeRing()
  {
    return mSpeRing;
  }
  
  public String getVersion()
  {
    return mVersion;
  }
  
  public void setRefreshTokenAge(String paramString)
  {
    mRefreshTokenAge = paramString;
  }
  
  public void setServerErrorCode(String paramString)
  {
    mServerErrorCode = paramString;
  }
  
  public void setServerSubErrorCode(String paramString)
  {
    mServerSubErrorCode = paramString;
  }
  
  public void setSpeRing(String paramString)
  {
    mSpeRing = paramString;
  }
  
  public void setVersion(String paramString)
  {
    mVersion = paramString;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.telemetry.CliTelemInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */