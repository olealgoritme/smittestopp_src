package com.microsoft.identity.common.internal.eststelemetry;

import com.microsoft.identity.common.internal.util.StringUtil;
import java.util.Arrays;
import java.util.List;

public class Schema
{
  public static final String CURRENT_REQUEST_HEADER_NAME = "x-client-current-telemetry";
  public static final String CURRENT_SCHEMA_VERSION = "1";
  public static final String LAST_REQUEST_HEADER_NAME = "x-client-last-telemetry";
  public static final String SCHEMA_VERSION_KEY = "schema_version";
  public static final String[] currentRequestCommonFields = { "Microsoft.MSAL.api_id", "Microsoft.MSAL.force_refresh" };
  public static final String[] currentRequestPlatformFields = { "Microsoft.MSAL.account_status", "Microsoft.MSAL.id_token_status", "Microsoft.MSAL.at_status", "Microsoft.MSAL.rt_status", "Microsoft.MSAL.frt_status", "Microsoft.MSAL.mrrt_status" };
  public static final String[] lastRequestCommonFields = { "Microsoft.MSAL.api_id", "Microsoft.MSAL.correlation_id", "Microsoft.MSAL.api_error_code" };
  public static final String[] lastRequestPlatformFields = new String[0];
  
  public static String[] getCommonFields(boolean paramBoolean)
  {
    String[] arrayOfString;
    if (paramBoolean) {
      arrayOfString = getCurrentRequestCommonFields();
    } else {
      arrayOfString = getLastRequestCommonFields();
    }
    return arrayOfString;
  }
  
  public static String[] getCurrentRequestCommonFields()
  {
    return currentRequestCommonFields;
  }
  
  public static String[] getCurrentRequestPlatformFields()
  {
    return currentRequestPlatformFields;
  }
  
  public static String[] getLastRequestCommonFields()
  {
    return lastRequestCommonFields;
  }
  
  public static String[] getLastRequestPlatformFields()
  {
    return lastRequestPlatformFields;
  }
  
  public static String[] getPlatformFields(boolean paramBoolean)
  {
    String[] arrayOfString;
    if (paramBoolean) {
      arrayOfString = getCurrentRequestPlatformFields();
    } else {
      arrayOfString = getLastRequestPlatformFields();
    }
    return arrayOfString;
  }
  
  public static String getSchemaCompliantString(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return "";
    }
    if (paramString.equals("true")) {
      return "1";
    }
    String str = paramString;
    if (paramString.equals("false")) {
      str = "0";
    }
    return str;
  }
  
  public static String getSchemaCompliantStringFromBoolean(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "1";
    } else {
      str = "0";
    }
    return str;
  }
  
  public static boolean isCommonField(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramBoolean = isCurrentCommonField(paramString);
    } else {
      paramBoolean = isLastCommonField(paramString);
    }
    return paramBoolean;
  }
  
  public static boolean isCurrentCommonField(String paramString)
  {
    return Arrays.asList(currentRequestCommonFields).contains(paramString);
  }
  
  public static boolean isCurrentPlatformField(String paramString)
  {
    return Arrays.asList(currentRequestPlatformFields).contains(paramString);
  }
  
  public static boolean isLastCommonField(String paramString)
  {
    return Arrays.asList(lastRequestCommonFields).contains(paramString);
  }
  
  public static boolean isLastPlatformField(String paramString)
  {
    return Arrays.asList(lastRequestPlatformFields).contains(paramString);
  }
  
  public static boolean isPlatformField(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramBoolean = isCurrentPlatformField(paramString);
    } else {
      paramBoolean = isLastPlatformField(paramString);
    }
    return paramBoolean;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.identity.common.internal.eststelemetry.Schema
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */