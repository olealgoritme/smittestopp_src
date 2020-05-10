package com.microsoft.appcenter.ingestion.models;

import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import org.json.JSONObject;
import org.json.JSONStringer;

public class WrapperSdk
  implements Model
{
  public static final String LIVE_UPDATE_DEPLOYMENT_KEY = "liveUpdateDeploymentKey";
  public static final String LIVE_UPDATE_PACKAGE_HASH = "liveUpdatePackageHash";
  public static final String LIVE_UPDATE_RELEASE_LABEL = "liveUpdateReleaseLabel";
  public static final String WRAPPER_RUNTIME_VERSION = "wrapperRuntimeVersion";
  public static final String WRAPPER_SDK_NAME = "wrapperSdkName";
  public static final String WRAPPER_SDK_VERSION = "wrapperSdkVersion";
  public String liveUpdateDeploymentKey;
  public String liveUpdatePackageHash;
  public String liveUpdateReleaseLabel;
  public String wrapperRuntimeVersion;
  public String wrapperSdkName;
  public String wrapperSdkVersion;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (WrapperSdk)paramObject;
      String str = wrapperSdkVersion;
      if (str != null ? !str.equals(wrapperSdkVersion) : wrapperSdkVersion != null) {
        return false;
      }
      str = wrapperSdkName;
      if (str != null ? !str.equals(wrapperSdkName) : wrapperSdkName != null) {
        return false;
      }
      str = wrapperRuntimeVersion;
      if (str != null ? !str.equals(wrapperRuntimeVersion) : wrapperRuntimeVersion != null) {
        return false;
      }
      str = liveUpdateReleaseLabel;
      if (str != null ? !str.equals(liveUpdateReleaseLabel) : liveUpdateReleaseLabel != null) {
        return false;
      }
      str = liveUpdateDeploymentKey;
      if (str != null ? !str.equals(liveUpdateDeploymentKey) : liveUpdateDeploymentKey != null) {
        return false;
      }
      str = liveUpdatePackageHash;
      paramObject = liveUpdatePackageHash;
      if (str != null) {
        bool = str.equals(paramObject);
      } else if (paramObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getLiveUpdateDeploymentKey()
  {
    return liveUpdateDeploymentKey;
  }
  
  public String getLiveUpdatePackageHash()
  {
    return liveUpdatePackageHash;
  }
  
  public String getLiveUpdateReleaseLabel()
  {
    return liveUpdateReleaseLabel;
  }
  
  public String getWrapperRuntimeVersion()
  {
    return wrapperRuntimeVersion;
  }
  
  public String getWrapperSdkName()
  {
    return wrapperSdkName;
  }
  
  public String getWrapperSdkVersion()
  {
    return wrapperSdkVersion;
  }
  
  public int hashCode()
  {
    String str = wrapperSdkVersion;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = wrapperSdkName;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = wrapperRuntimeVersion;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = liveUpdateReleaseLabel;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = liveUpdateDeploymentKey;
    int i1;
    if (str != null) {
      i1 = str.hashCode();
    } else {
      i1 = 0;
    }
    str = liveUpdatePackageHash;
    if (str != null) {
      i = str.hashCode();
    }
    return ((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    setWrapperSdkVersion(paramJSONObject.optString("wrapperSdkVersion", null));
    setWrapperSdkName(paramJSONObject.optString("wrapperSdkName", null));
    setWrapperRuntimeVersion(paramJSONObject.optString("wrapperRuntimeVersion", null));
    setLiveUpdateReleaseLabel(paramJSONObject.optString("liveUpdateReleaseLabel", null));
    setLiveUpdateDeploymentKey(paramJSONObject.optString("liveUpdateDeploymentKey", null));
    setLiveUpdatePackageHash(paramJSONObject.optString("liveUpdatePackageHash", null));
  }
  
  public void setLiveUpdateDeploymentKey(String paramString)
  {
    liveUpdateDeploymentKey = paramString;
  }
  
  public void setLiveUpdatePackageHash(String paramString)
  {
    liveUpdatePackageHash = paramString;
  }
  
  public void setLiveUpdateReleaseLabel(String paramString)
  {
    liveUpdateReleaseLabel = paramString;
  }
  
  public void setWrapperRuntimeVersion(String paramString)
  {
    wrapperRuntimeVersion = paramString;
  }
  
  public void setWrapperSdkName(String paramString)
  {
    wrapperSdkName = paramString;
  }
  
  public void setWrapperSdkVersion(String paramString)
  {
    wrapperSdkVersion = paramString;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    JSONUtils.write(paramJSONStringer, "wrapperSdkVersion", getWrapperSdkVersion());
    JSONUtils.write(paramJSONStringer, "wrapperSdkName", getWrapperSdkName());
    JSONUtils.write(paramJSONStringer, "wrapperRuntimeVersion", getWrapperRuntimeVersion());
    JSONUtils.write(paramJSONStringer, "liveUpdateReleaseLabel", getLiveUpdateReleaseLabel());
    JSONUtils.write(paramJSONStringer, "liveUpdateDeploymentKey", getLiveUpdateDeploymentKey());
    JSONUtils.write(paramJSONStringer, "liveUpdatePackageHash", getLiveUpdatePackageHash());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.models.WrapperSdk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */