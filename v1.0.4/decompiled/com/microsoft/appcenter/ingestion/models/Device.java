package com.microsoft.appcenter.ingestion.models;

import com.microsoft.appcenter.ingestion.models.json.JSONUtils;
import org.json.JSONObject;
import org.json.JSONStringer;

public class Device
  extends WrapperSdk
{
  public static final String APP_BUILD = "appBuild";
  public static final String APP_NAMESPACE = "appNamespace";
  public static final String APP_VERSION = "appVersion";
  public static final String CARRIER_COUNTRY = "carrierCountry";
  public static final String CARRIER_NAME = "carrierName";
  public static final String LOCALE = "locale";
  public static final String MODEL = "model";
  public static final String OEM_NAME = "oemName";
  public static final String OS_API_LEVEL = "osApiLevel";
  public static final String OS_BUILD = "osBuild";
  public static final String OS_NAME = "osName";
  public static final String OS_VERSION = "osVersion";
  public static final String SCREEN_SIZE = "screenSize";
  public static final String SDK_NAME = "sdkName";
  public static final String SDK_VERSION = "sdkVersion";
  public static final String TIME_ZONE_OFFSET = "timeZoneOffset";
  public String appBuild;
  public String appNamespace;
  public String appVersion;
  public String carrierCountry;
  public String carrierName;
  public String locale;
  public String model;
  public String oemName;
  public Integer osApiLevel;
  public String osBuild;
  public String osName;
  public String osVersion;
  public String screenSize;
  public String sdkName;
  public String sdkVersion;
  public Integer timeZoneOffset;
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (Device.class == paramObject.getClass()))
    {
      if (!super.equals(paramObject)) {
        return false;
      }
      paramObject = (Device)paramObject;
      Object localObject = sdkName;
      if (localObject != null ? !((String)localObject).equals(sdkName) : sdkName != null) {
        return false;
      }
      localObject = sdkVersion;
      if (localObject != null ? !((String)localObject).equals(sdkVersion) : sdkVersion != null) {
        return false;
      }
      localObject = model;
      if (localObject != null ? !((String)localObject).equals(model) : model != null) {
        return false;
      }
      localObject = oemName;
      if (localObject != null ? !((String)localObject).equals(oemName) : oemName != null) {
        return false;
      }
      localObject = osName;
      if (localObject != null ? !((String)localObject).equals(osName) : osName != null) {
        return false;
      }
      localObject = osVersion;
      if (localObject != null ? !((String)localObject).equals(osVersion) : osVersion != null) {
        return false;
      }
      localObject = osBuild;
      if (localObject != null ? !((String)localObject).equals(osBuild) : osBuild != null) {
        return false;
      }
      localObject = osApiLevel;
      if (localObject != null ? !((Integer)localObject).equals(osApiLevel) : osApiLevel != null) {
        return false;
      }
      localObject = locale;
      if (localObject != null ? !((String)localObject).equals(locale) : locale != null) {
        return false;
      }
      localObject = timeZoneOffset;
      if (localObject != null ? !((Integer)localObject).equals(timeZoneOffset) : timeZoneOffset != null) {
        return false;
      }
      localObject = screenSize;
      if (localObject != null ? !((String)localObject).equals(screenSize) : screenSize != null) {
        return false;
      }
      localObject = appVersion;
      if (localObject != null ? !((String)localObject).equals(appVersion) : appVersion != null) {
        return false;
      }
      localObject = carrierName;
      if (localObject != null ? !((String)localObject).equals(carrierName) : carrierName != null) {
        return false;
      }
      localObject = carrierCountry;
      if (localObject != null ? !((String)localObject).equals(carrierCountry) : carrierCountry != null) {
        return false;
      }
      localObject = appBuild;
      if (localObject != null ? !((String)localObject).equals(appBuild) : appBuild != null) {
        return false;
      }
      localObject = appNamespace;
      paramObject = appNamespace;
      if (localObject != null) {
        bool = ((String)localObject).equals(paramObject);
      } else if (paramObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String getAppBuild()
  {
    return appBuild;
  }
  
  public String getAppNamespace()
  {
    return appNamespace;
  }
  
  public String getAppVersion()
  {
    return appVersion;
  }
  
  public String getCarrierCountry()
  {
    return carrierCountry;
  }
  
  public String getCarrierName()
  {
    return carrierName;
  }
  
  public String getLocale()
  {
    return locale;
  }
  
  public String getModel()
  {
    return model;
  }
  
  public String getOemName()
  {
    return oemName;
  }
  
  public Integer getOsApiLevel()
  {
    return osApiLevel;
  }
  
  public String getOsBuild()
  {
    return osBuild;
  }
  
  public String getOsName()
  {
    return osName;
  }
  
  public String getOsVersion()
  {
    return osVersion;
  }
  
  public String getScreenSize()
  {
    return screenSize;
  }
  
  public String getSdkName()
  {
    return sdkName;
  }
  
  public String getSdkVersion()
  {
    return sdkVersion;
  }
  
  public Integer getTimeZoneOffset()
  {
    return timeZoneOffset;
  }
  
  public int hashCode()
  {
    int i = super.hashCode();
    Object localObject = sdkName;
    int j = 0;
    int k;
    if (localObject != null) {
      k = ((String)localObject).hashCode();
    } else {
      k = 0;
    }
    localObject = sdkVersion;
    int m;
    if (localObject != null) {
      m = ((String)localObject).hashCode();
    } else {
      m = 0;
    }
    localObject = model;
    int n;
    if (localObject != null) {
      n = ((String)localObject).hashCode();
    } else {
      n = 0;
    }
    localObject = oemName;
    int i1;
    if (localObject != null) {
      i1 = ((String)localObject).hashCode();
    } else {
      i1 = 0;
    }
    localObject = osName;
    int i2;
    if (localObject != null) {
      i2 = ((String)localObject).hashCode();
    } else {
      i2 = 0;
    }
    localObject = osVersion;
    int i3;
    if (localObject != null) {
      i3 = ((String)localObject).hashCode();
    } else {
      i3 = 0;
    }
    localObject = osBuild;
    int i4;
    if (localObject != null) {
      i4 = ((String)localObject).hashCode();
    } else {
      i4 = 0;
    }
    localObject = osApiLevel;
    int i5;
    if (localObject != null) {
      i5 = ((Integer)localObject).hashCode();
    } else {
      i5 = 0;
    }
    localObject = locale;
    int i6;
    if (localObject != null) {
      i6 = ((String)localObject).hashCode();
    } else {
      i6 = 0;
    }
    localObject = timeZoneOffset;
    int i7;
    if (localObject != null) {
      i7 = ((Integer)localObject).hashCode();
    } else {
      i7 = 0;
    }
    localObject = screenSize;
    int i8;
    if (localObject != null) {
      i8 = ((String)localObject).hashCode();
    } else {
      i8 = 0;
    }
    localObject = appVersion;
    int i9;
    if (localObject != null) {
      i9 = ((String)localObject).hashCode();
    } else {
      i9 = 0;
    }
    localObject = carrierName;
    int i10;
    if (localObject != null) {
      i10 = ((String)localObject).hashCode();
    } else {
      i10 = 0;
    }
    localObject = carrierCountry;
    int i11;
    if (localObject != null) {
      i11 = ((String)localObject).hashCode();
    } else {
      i11 = 0;
    }
    localObject = appBuild;
    int i12;
    if (localObject != null) {
      i12 = ((String)localObject).hashCode();
    } else {
      i12 = 0;
    }
    localObject = appNamespace;
    if (localObject != null) {
      j = ((String)localObject).hashCode();
    }
    return (((((((((((((((i * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + j;
  }
  
  public void read(JSONObject paramJSONObject)
  {
    super.read(paramJSONObject);
    setSdkName(paramJSONObject.getString("sdkName"));
    setSdkVersion(paramJSONObject.getString("sdkVersion"));
    setModel(paramJSONObject.getString("model"));
    setOemName(paramJSONObject.getString("oemName"));
    setOsName(paramJSONObject.getString("osName"));
    setOsVersion(paramJSONObject.getString("osVersion"));
    setOsBuild(paramJSONObject.optString("osBuild", null));
    setOsApiLevel(JSONUtils.readInteger(paramJSONObject, "osApiLevel"));
    setLocale(paramJSONObject.getString("locale"));
    setTimeZoneOffset(Integer.valueOf(paramJSONObject.getInt("timeZoneOffset")));
    setScreenSize(paramJSONObject.getString("screenSize"));
    setAppVersion(paramJSONObject.getString("appVersion"));
    setCarrierName(paramJSONObject.optString("carrierName", null));
    setCarrierCountry(paramJSONObject.optString("carrierCountry", null));
    setAppBuild(paramJSONObject.getString("appBuild"));
    setAppNamespace(paramJSONObject.optString("appNamespace", null));
  }
  
  public void setAppBuild(String paramString)
  {
    appBuild = paramString;
  }
  
  public void setAppNamespace(String paramString)
  {
    appNamespace = paramString;
  }
  
  public void setAppVersion(String paramString)
  {
    appVersion = paramString;
  }
  
  public void setCarrierCountry(String paramString)
  {
    carrierCountry = paramString;
  }
  
  public void setCarrierName(String paramString)
  {
    carrierName = paramString;
  }
  
  public void setLocale(String paramString)
  {
    locale = paramString;
  }
  
  public void setModel(String paramString)
  {
    model = paramString;
  }
  
  public void setOemName(String paramString)
  {
    oemName = paramString;
  }
  
  public void setOsApiLevel(Integer paramInteger)
  {
    osApiLevel = paramInteger;
  }
  
  public void setOsBuild(String paramString)
  {
    osBuild = paramString;
  }
  
  public void setOsName(String paramString)
  {
    osName = paramString;
  }
  
  public void setOsVersion(String paramString)
  {
    osVersion = paramString;
  }
  
  public void setScreenSize(String paramString)
  {
    screenSize = paramString;
  }
  
  public void setSdkName(String paramString)
  {
    sdkName = paramString;
  }
  
  public void setSdkVersion(String paramString)
  {
    sdkVersion = paramString;
  }
  
  public void setTimeZoneOffset(Integer paramInteger)
  {
    timeZoneOffset = paramInteger;
  }
  
  public void write(JSONStringer paramJSONStringer)
  {
    super.write(paramJSONStringer);
    paramJSONStringer.key("sdkName").value(getSdkName());
    paramJSONStringer.key("sdkVersion").value(getSdkVersion());
    paramJSONStringer.key("model").value(getModel());
    paramJSONStringer.key("oemName").value(getOemName());
    paramJSONStringer.key("osName").value(getOsName());
    paramJSONStringer.key("osVersion").value(getOsVersion());
    JSONUtils.write(paramJSONStringer, "osBuild", getOsBuild());
    JSONUtils.write(paramJSONStringer, "osApiLevel", getOsApiLevel());
    paramJSONStringer.key("locale").value(getLocale());
    paramJSONStringer.key("timeZoneOffset").value(getTimeZoneOffset());
    paramJSONStringer.key("screenSize").value(getScreenSize());
    paramJSONStringer.key("appVersion").value(getAppVersion());
    JSONUtils.write(paramJSONStringer, "carrierName", getCarrierName());
    JSONUtils.write(paramJSONStringer, "carrierCountry", getCarrierCountry());
    paramJSONStringer.key("appBuild").value(getAppBuild());
    JSONUtils.write(paramJSONStringer, "appNamespace", getAppNamespace());
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.models.Device
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */