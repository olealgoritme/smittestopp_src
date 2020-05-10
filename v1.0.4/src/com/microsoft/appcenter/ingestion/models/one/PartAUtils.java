package com.microsoft.appcenter.ingestion.models.one;

import com.microsoft.appcenter.ingestion.models.AbstractLog;
import com.microsoft.appcenter.ingestion.models.Device;
import com.microsoft.appcenter.ingestion.models.Log;
import com.microsoft.appcenter.utils.context.UserIdContext;
import e.a.a.a.a;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartAUtils
{
  public static final Pattern NAME_REGEX = Pattern.compile("^[a-zA-Z0-9]((\\.(?!(\\.|$)))|[_a-zA-Z0-9]){3,99}$");
  
  public static void addPartAFromLog(Log paramLog, CommonSchemaLog paramCommonSchemaLog, String paramString)
  {
    Device localDevice = paramLog.getDevice();
    paramCommonSchemaLog.setVer("3.0");
    paramCommonSchemaLog.setTimestamp(paramLog.getTimestamp());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("o:");
    ((StringBuilder)localObject).append(getTargetKey(paramString));
    paramCommonSchemaLog.setIKey(((StringBuilder)localObject).toString());
    paramCommonSchemaLog.addTransmissionTarget(paramString);
    if (paramCommonSchemaLog.getExt() == null) {
      paramCommonSchemaLog.setExt(new Extensions());
    }
    paramCommonSchemaLog.getExt().setProtocol(new ProtocolExtension());
    paramCommonSchemaLog.getExt().getProtocol().setDevModel(localDevice.getModel());
    paramCommonSchemaLog.getExt().getProtocol().setDevMake(localDevice.getOemName());
    paramCommonSchemaLog.getExt().setUser(new UserExtension());
    paramCommonSchemaLog.getExt().getUser().setLocalId(UserIdContext.getPrefixedUserId(paramLog.getUserId()));
    localObject = paramCommonSchemaLog.getExt().getUser();
    paramString = localDevice.getLocale();
    paramLog = "-";
    ((UserExtension)localObject).setLocale(paramString.replace("_", "-"));
    paramCommonSchemaLog.getExt().setOs(new OsExtension());
    paramCommonSchemaLog.getExt().getOs().setName(localDevice.getOsName());
    localObject = paramCommonSchemaLog.getExt().getOs();
    paramString = new StringBuilder();
    paramString.append(localDevice.getOsVersion());
    paramString.append("-");
    paramString.append(localDevice.getOsBuild());
    paramString.append("-");
    paramString.append(localDevice.getOsApiLevel());
    ((OsExtension)localObject).setVer(paramString.toString());
    paramCommonSchemaLog.getExt().setApp(new AppExtension());
    paramCommonSchemaLog.getExt().getApp().setVer(localDevice.getAppVersion());
    paramString = paramCommonSchemaLog.getExt().getApp();
    localObject = a.a("a:");
    ((StringBuilder)localObject).append(localDevice.getAppNamespace());
    paramString.setId(((StringBuilder)localObject).toString());
    paramCommonSchemaLog.getExt().setNet(new NetExtension());
    paramCommonSchemaLog.getExt().getNet().setProvider(localDevice.getCarrierName());
    paramCommonSchemaLog.getExt().setSdk(new SdkExtension());
    localObject = paramCommonSchemaLog.getExt().getSdk();
    paramString = new StringBuilder();
    paramString.append(localDevice.getSdkName());
    paramString.append("-");
    paramString.append(localDevice.getSdkVersion());
    ((SdkExtension)localObject).setLibVer(paramString.toString());
    paramCommonSchemaLog.getExt().setLoc(new LocExtension());
    paramString = Locale.US;
    if (localDevice.getTimeZoneOffset().intValue() >= 0) {
      paramLog = "+";
    }
    paramLog = String.format(paramString, "%s%02d:%02d", new Object[] { paramLog, Integer.valueOf(Math.abs(localDevice.getTimeZoneOffset().intValue() / 60)), Integer.valueOf(Math.abs(localDevice.getTimeZoneOffset().intValue() % 60)) });
    paramCommonSchemaLog.getExt().getLoc().setTz(paramLog);
    paramCommonSchemaLog.getExt().setDevice(new DeviceExtension());
  }
  
  public static String getTargetKey(String paramString)
  {
    return paramString.split("-")[0];
  }
  
  public static void setName(CommonSchemaLog paramCommonSchemaLog, String paramString)
  {
    if (paramString != null)
    {
      if (NAME_REGEX.matcher(paramString).matches())
      {
        paramCommonSchemaLog.setName(paramString);
        return;
      }
      paramCommonSchemaLog = a.a("Name must match '");
      paramCommonSchemaLog.append(NAME_REGEX);
      paramCommonSchemaLog.append("' but was '");
      paramCommonSchemaLog.append(paramString);
      paramCommonSchemaLog.append("'.");
      throw new IllegalArgumentException(paramCommonSchemaLog.toString());
    }
    throw new IllegalArgumentException("Name cannot be null.");
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.appcenter.ingestion.models.one.PartAUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */