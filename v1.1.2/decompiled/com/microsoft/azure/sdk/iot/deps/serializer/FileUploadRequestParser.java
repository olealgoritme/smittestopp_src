package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import e.c.c.e;
import e.c.c.v.a;
import e.c.c.v.c;

public class FileUploadRequestParser
{
  public static final String BLOB_NAME_TAG = "blobName";
  @a(deserialize=true, serialize=true)
  @c("blobName")
  public String blobName;
  
  public FileUploadRequestParser() {}
  
  public FileUploadRequestParser(String paramString)
  {
    ParserUtility.validateBlobName(paramString);
    blobName = paramString;
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
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.serializer.FileUploadRequestParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */