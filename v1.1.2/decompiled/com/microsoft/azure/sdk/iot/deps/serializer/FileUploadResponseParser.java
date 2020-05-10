package com.microsoft.azure.sdk.iot.deps.serializer;

import com.google.gson.Gson;
import e.c.c.e;
import e.c.c.s;
import e.c.c.v.a;
import e.c.c.v.c;
import e.c.c.w.t;

public class FileUploadResponseParser
{
  public static final String BLOB_NAME_TAG = "blobName";
  public static final String CONTAINER_NAME_TAG = "containerName";
  public static final String CORRELATION_ID_TAG = "correlationId";
  public static final String HOST_NAME_TAG = "hostName";
  public static final String SAS_TOKEN_TAG = "sasToken";
  @a(deserialize=true, serialize=true)
  @c("blobName")
  public String blobName = null;
  @a(deserialize=true, serialize=true)
  @c("containerName")
  public String containerName = null;
  @a(deserialize=true, serialize=true)
  @c("correlationId")
  public String correlationId = null;
  @a(deserialize=true, serialize=true)
  @c("hostName")
  public String hostName = null;
  @a(deserialize=true, serialize=true)
  @c("sasToken")
  public String sasToken = null;
  
  public FileUploadResponseParser() {}
  
  public FileUploadResponseParser(String paramString)
  {
    Object localObject = new e();
    l = false;
    g = true;
    localObject = ((e)localObject).a();
    ParserUtility.validateStringUTF8(paramString);
    try
    {
      paramString = ((Gson)localObject).a(paramString, FileUploadResponseParser.class);
      paramString = (FileUploadResponseParser)t.a(FileUploadResponseParser.class).cast(paramString);
      ParserUtility.validateStringUTF8(hostName);
      ParserUtility.validateStringUTF8(containerName);
      ParserUtility.validateStringUTF8(correlationId);
      ParserUtility.validateBlobName(blobName);
      ParserUtility.validateStringUTF8(sasToken);
      hostName = hostName;
      containerName = containerName;
      correlationId = correlationId;
      blobName = blobName;
      sasToken = sasToken;
      return;
    }
    catch (s locals)
    {
      paramString = new StringBuilder();
      paramString.append("Malformed json:");
      paramString.append(locals);
      throw new IllegalArgumentException(paramString.toString());
    }
  }
  
  public String getBlobName()
  {
    return blobName;
  }
  
  public String getContainerName()
  {
    return containerName;
  }
  
  public String getCorrelationId()
  {
    return correlationId;
  }
  
  public String getHostName()
  {
    return hostName;
  }
  
  public String getSasToken()
  {
    return sasToken;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.deps.serializer.FileUploadResponseParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */