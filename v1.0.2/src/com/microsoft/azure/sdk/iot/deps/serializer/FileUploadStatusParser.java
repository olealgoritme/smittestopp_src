package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import e.c.c.e;
import e.c.c.v.a;
import e.c.c.v.c;

public class FileUploadStatusParser
{
  public static final String CORRELATION_ID_TAG = "correlationId";
  public static final String IS_SUCCESS_TAG = "isSuccess";
  public static final String STATUS_CODE_TAG = "statusCode";
  public static final String STATUS_DESCRIPTION_TAG = "statusDescription";
  @a(deserialize=true, serialize=true)
  @c("correlationId")
  public String correlationId = null;
  @a(deserialize=true, serialize=true)
  @c("isSuccess")
  public Boolean isSuccess = null;
  @a(deserialize=true, serialize=true)
  @c("statusCode")
  public Integer statusCode = null;
  @a(deserialize=true, serialize=true)
  @c("statusDescription")
  public String statusDescription = null;
  
  public FileUploadStatusParser() {}
  
  public FileUploadStatusParser(String paramString1, Boolean paramBoolean, Integer paramInteger, String paramString2)
  {
    setCorrelationId(paramString1);
    updateStatus(paramBoolean, paramInteger, paramString2);
  }
  
  private void setCorrelationId(String paramString)
  {
    ParserUtility.validateStringUTF8(paramString);
    correlationId = paramString;
  }
  
  private void updateStatus(Boolean paramBoolean, Integer paramInteger, String paramString)
  {
    ParserUtility.validateObject(paramBoolean);
    ParserUtility.validateObject(paramInteger);
    ParserUtility.validateStringUTF8(paramString);
    isSuccess = paramBoolean;
    statusCode = paramInteger;
    statusDescription = paramString;
  }
  
  public String toJson()
  {
    e locale = new e();
    l = false;
    g = true;
    return locale.a().a(this);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.sdk.iot.deps.serializer.FileUploadStatusParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */