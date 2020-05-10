package com.microsoft.azure.sdk.iot.device.fileupload;

import com.microsoft.azure.sdk.iot.deps.serializer.FileUploadRequestParser;
import com.microsoft.azure.sdk.iot.deps.serializer.FileUploadResponseParser;
import com.microsoft.azure.sdk.iot.deps.serializer.FileUploadStatusParser;
import com.microsoft.azure.sdk.iot.device.IotHubEventCallback;
import com.microsoft.azure.sdk.iot.device.IotHubMethod;
import com.microsoft.azure.sdk.iot.device.IotHubStatusCode;
import com.microsoft.azure.sdk.iot.device.Message;
import com.microsoft.azure.sdk.iot.device.ObjectLock;
import com.microsoft.azure.sdk.iot.device.ResponseMessage;
import com.microsoft.azure.sdk.iot.device.transport.IotHubTransportMessage;
import com.microsoft.azure.sdk.iot.device.transport.https.HttpsTransportManager;
import e.c.c.k;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import l.f.b;
import l.f.c;

public final class FileUploadTask
  implements Runnable
{
  public static final Charset DEFAULT_IOTHUB_MESSAGE_CHARSET = StandardCharsets.UTF_8;
  public static final ObjectLock FILE_UPLOAD_LOCK = new ObjectLock();
  public static final String HTTPS_URL_STRING = "https://";
  public static final String PATH_SEPARATOR_STRING = "/";
  public static final String THREAD_NAME = "azure-iot-sdk-FileUploadTask";
  public static final String UTF_8_STRING = "UTF-8";
  public static final b log = c.a(FileUploadTask.class);
  public String blobName;
  public URI blobURI;
  public String correlationId;
  public HttpsTransportManager httpsTransportManager;
  public InputStream inputStream;
  public long streamLength;
  public IotHubEventCallback userCallback;
  public Object userCallbackContext;
  
  public FileUploadTask(String paramString, InputStream paramInputStream, long paramLong, HttpsTransportManager paramHttpsTransportManager, IotHubEventCallback paramIotHubEventCallback, Object paramObject)
  {
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      if (paramInputStream != null)
      {
        if (paramLong >= 0L)
        {
          if (paramHttpsTransportManager != null)
          {
            if (paramIotHubEventCallback != null)
            {
              blobName = paramString;
              inputStream = paramInputStream;
              streamLength = paramLong;
              userCallback = paramIotHubEventCallback;
              userCallbackContext = paramObject;
              httpsTransportManager = paramHttpsTransportManager;
              log.d("HttpsFileUpload object is created successfully");
              return;
            }
            throw new IllegalArgumentException("statusCallback is null");
          }
          throw new IllegalArgumentException("httpsTransportManager is null");
        }
        throw new IllegalArgumentException("streamLength is negative");
      }
      throw new IllegalArgumentException("inputStream is null or empty");
    }
    throw new IllegalArgumentException("blobName is null or empty");
  }
  
  private void addBlobInformation(Message paramMessage)
  {
    Object localObject = new FileUploadResponseParser(new String(paramMessage.getBytes(), DEFAULT_IOTHUB_MESSAGE_CHARSET));
    correlationId = ((FileUploadResponseParser)localObject).getCorrelationId();
    blobName = ((FileUploadResponseParser)localObject).getBlobName();
    String str = ((FileUploadResponseParser)localObject).getHostName();
    paramMessage = ((FileUploadResponseParser)localObject).getContainerName();
    localObject = ((FileUploadResponseParser)localObject).getSasToken();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://");
    localStringBuilder.append(str);
    localStringBuilder.append("/");
    localStringBuilder.append(paramMessage);
    localStringBuilder.append("/");
    localStringBuilder.append(URLEncoder.encode(blobName, "UTF-8"));
    localStringBuilder.append((String)localObject);
    blobURI = new URI(localStringBuilder.toString());
  }
  
  private IotHubStatusCode getContainer()
  {
    Object localObject1 = new IotHubTransportMessage(new FileUploadRequestParser(blobName).toJson());
    ((IotHubTransportMessage)localObject1).setIotHubMethod(IotHubMethod.POST);
    synchronized (FILE_UPLOAD_LOCK)
    {
      httpsTransportManager.open();
      ResponseMessage localResponseMessage = httpsTransportManager.sendFileUploadMessage((IotHubTransportMessage)localObject1);
      httpsTransportManager.close();
      localObject1 = localResponseMessage.getStatus();
      if (localObject1 == IotHubStatusCode.OK)
      {
        addBlobInformation(localResponseMessage);
        ??? = localObject1;
      }
      else
      {
        ??? = localObject1;
        if (localObject1 == IotHubStatusCode.OK_EMPTY) {
          ??? = IotHubStatusCode.ERROR;
        }
      }
      return (IotHubStatusCode)???;
    }
  }
  
  private IotHubStatusCode sendNotification(FileUploadStatusParser arg1)
  {
    try
    {
      Object localObject1 = new com/microsoft/azure/sdk/iot/device/transport/IotHubTransportMessage;
      ((IotHubTransportMessage)localObject1).<init>(???.toJson());
      ((IotHubTransportMessage)localObject1).setIotHubMethod(IotHubMethod.POST);
      synchronized (FILE_UPLOAD_LOCK)
      {
        httpsTransportManager.open();
        localObject1 = httpsTransportManager.sendFileUploadNotification((IotHubTransportMessage)localObject1);
        httpsTransportManager.close();
        ??? = ((ResponseMessage)localObject1).getStatus();
      }
      log.e("File upload failed to report status to the iothub", ???);
    }
    catch (k ???) {}catch (IOException ???) {}catch (IllegalArgumentException ???) {}
    ??? = IotHubStatusCode.ERROR;
    return (IotHubStatusCode)???;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 242	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3: ldc 20
    //   5: invokevirtual 245	java/lang/Thread:setName	(Ljava/lang/String;)V
    //   8: getstatic 203	com/microsoft/azure/sdk/iot/device/IotHubStatusCode:OK	Lcom/microsoft/azure/sdk/iot/device/IotHubStatusCode;
    //   11: astore_1
    //   12: aload_0
    //   13: invokespecial 247	com/microsoft/azure/sdk/iot/device/fileupload/FileUploadTask:getContainer	()Lcom/microsoft/azure/sdk/iot/device/IotHubStatusCode;
    //   16: astore_2
    //   17: goto +31 -> 48
    //   20: astore_1
    //   21: goto +12 -> 33
    //   24: astore_1
    //   25: goto +8 -> 33
    //   28: astore_1
    //   29: goto +4 -> 33
    //   32: astore_1
    //   33: getstatic 49	com/microsoft/azure/sdk/iot/device/fileupload/FileUploadTask:log	Ll/f/b;
    //   36: ldc -7
    //   38: aload_1
    //   39: invokeinterface 229 3 0
    //   44: getstatic 211	com/microsoft/azure/sdk/iot/device/IotHubStatusCode:ERROR	Lcom/microsoft/azure/sdk/iot/device/IotHubStatusCode;
    //   47: astore_2
    //   48: aload_2
    //   49: astore_1
    //   50: aload_2
    //   51: getstatic 203	com/microsoft/azure/sdk/iot/device/IotHubStatusCode:OK	Lcom/microsoft/azure/sdk/iot/device/IotHubStatusCode;
    //   54: if_acmpne +191 -> 245
    //   57: aconst_null
    //   58: astore_2
    //   59: new 251	com/microsoft/azure/storage/blob/CloudBlockBlob
    //   62: astore_1
    //   63: aload_1
    //   64: aload_0
    //   65: getfield 159	com/microsoft/azure/sdk/iot/device/fileupload/FileUploadTask:blobURI	Ljava/net/URI;
    //   68: invokespecial 254	com/microsoft/azure/storage/blob/CloudBlockBlob:<init>	(Ljava/net/URI;)V
    //   71: aload_1
    //   72: aload_0
    //   73: getfield 76	com/microsoft/azure/sdk/iot/device/fileupload/FileUploadTask:inputStream	Ljava/io/InputStream;
    //   76: aload_0
    //   77: getfield 78	com/microsoft/azure/sdk/iot/device/fileupload/FileUploadTask:streamLength	J
    //   80: invokevirtual 258	com/microsoft/azure/storage/blob/CloudBlockBlob:upload	(Ljava/io/InputStream;J)V
    //   83: new 219	com/microsoft/azure/sdk/iot/deps/serializer/FileUploadStatusParser
    //   86: astore_3
    //   87: aload_3
    //   88: aload_0
    //   89: getfield 126	com/microsoft/azure/sdk/iot/device/fileupload/FileUploadTask:correlationId	Ljava/lang/String;
    //   92: iconst_1
    //   93: invokestatic 264	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   96: iconst_0
    //   97: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   100: ldc_w 271
    //   103: invokespecial 274	com/microsoft/azure/sdk/iot/deps/serializer/FileUploadStatusParser:<init>	(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)V
    //   106: aload_3
    //   107: astore_2
    //   108: getstatic 203	com/microsoft/azure/sdk/iot/device/IotHubStatusCode:OK	Lcom/microsoft/azure/sdk/iot/device/IotHubStatusCode;
    //   111: astore 4
    //   113: aload_0
    //   114: aload_3
    //   115: invokespecial 276	com/microsoft/azure/sdk/iot/device/fileupload/FileUploadTask:sendNotification	(Lcom/microsoft/azure/sdk/iot/deps/serializer/FileUploadStatusParser;)Lcom/microsoft/azure/sdk/iot/device/IotHubStatusCode;
    //   118: astore_2
    //   119: aload 4
    //   121: astore_1
    //   122: aload 4
    //   124: getstatic 203	com/microsoft/azure/sdk/iot/device/IotHubStatusCode:OK	Lcom/microsoft/azure/sdk/iot/device/IotHubStatusCode;
    //   127: if_acmpne +8 -> 135
    //   130: aload_2
    //   131: astore_1
    //   132: goto +113 -> 245
    //   135: goto +110 -> 245
    //   138: astore_1
    //   139: goto +26 -> 165
    //   142: astore_1
    //   143: goto +22 -> 165
    //   146: astore_1
    //   147: goto +18 -> 165
    //   150: astore_1
    //   151: goto +82 -> 233
    //   154: astore_1
    //   155: goto +8 -> 163
    //   158: astore_1
    //   159: goto +4 -> 163
    //   162: astore_1
    //   163: aconst_null
    //   164: astore_3
    //   165: aload_3
    //   166: astore_2
    //   167: getstatic 49	com/microsoft/azure/sdk/iot/device/fileupload/FileUploadTask:log	Ll/f/b;
    //   170: ldc -7
    //   172: aload_1
    //   173: invokeinterface 229 3 0
    //   178: aload_3
    //   179: astore_2
    //   180: getstatic 211	com/microsoft/azure/sdk/iot/device/IotHubStatusCode:ERROR	Lcom/microsoft/azure/sdk/iot/device/IotHubStatusCode;
    //   183: astore 4
    //   185: aload_3
    //   186: astore_2
    //   187: new 219	com/microsoft/azure/sdk/iot/deps/serializer/FileUploadStatusParser
    //   190: dup
    //   191: aload_0
    //   192: getfield 126	com/microsoft/azure/sdk/iot/device/fileupload/FileUploadTask:correlationId	Ljava/lang/String;
    //   195: iconst_0
    //   196: invokestatic 264	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   199: iconst_m1
    //   200: invokestatic 269	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   203: ldc_w 278
    //   206: invokespecial 274	com/microsoft/azure/sdk/iot/deps/serializer/FileUploadStatusParser:<init>	(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)V
    //   209: astore_1
    //   210: aload_0
    //   211: aload_1
    //   212: invokespecial 276	com/microsoft/azure/sdk/iot/device/fileupload/FileUploadTask:sendNotification	(Lcom/microsoft/azure/sdk/iot/deps/serializer/FileUploadStatusParser;)Lcom/microsoft/azure/sdk/iot/device/IotHubStatusCode;
    //   215: astore_2
    //   216: aload 4
    //   218: astore_1
    //   219: aload 4
    //   221: getstatic 203	com/microsoft/azure/sdk/iot/device/IotHubStatusCode:OK	Lcom/microsoft/azure/sdk/iot/device/IotHubStatusCode;
    //   224: if_acmpne +21 -> 245
    //   227: aload_2
    //   228: astore_1
    //   229: goto -94 -> 135
    //   232: astore_1
    //   233: aload_0
    //   234: aload_2
    //   235: invokespecial 276	com/microsoft/azure/sdk/iot/device/fileupload/FileUploadTask:sendNotification	(Lcom/microsoft/azure/sdk/iot/deps/serializer/FileUploadStatusParser;)Lcom/microsoft/azure/sdk/iot/device/IotHubStatusCode;
    //   238: pop
    //   239: getstatic 203	com/microsoft/azure/sdk/iot/device/IotHubStatusCode:OK	Lcom/microsoft/azure/sdk/iot/device/IotHubStatusCode;
    //   242: astore_2
    //   243: aload_1
    //   244: athrow
    //   245: aload_0
    //   246: getfield 80	com/microsoft/azure/sdk/iot/device/fileupload/FileUploadTask:userCallback	Lcom/microsoft/azure/sdk/iot/device/IotHubEventCallback;
    //   249: aload_1
    //   250: aload_0
    //   251: getfield 82	com/microsoft/azure/sdk/iot/device/fileupload/FileUploadTask:userCallbackContext	Ljava/lang/Object;
    //   254: invokeinterface 284 3 0
    //   259: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	this	FileUploadTask
    //   11	1	1	localIotHubStatusCode1	IotHubStatusCode
    //   20	1	1	localNullPointerException	NullPointerException
    //   24	1	1	localURISyntaxException	java.net.URISyntaxException
    //   28	1	1	localIllegalArgumentException1	IllegalArgumentException
    //   32	7	1	localIOException1	IOException
    //   49	83	1	localObject1	Object
    //   138	1	1	localIllegalArgumentException2	IllegalArgumentException
    //   142	1	1	localIOException2	IOException
    //   146	1	1	localStorageException1	com.microsoft.azure.storage.StorageException
    //   150	1	1	localObject2	Object
    //   154	1	1	localIllegalArgumentException3	IllegalArgumentException
    //   158	1	1	localIOException3	IOException
    //   162	11	1	localStorageException2	com.microsoft.azure.storage.StorageException
    //   209	20	1	localObject3	Object
    //   232	18	1	localIotHubStatusCode2	IotHubStatusCode
    //   16	227	2	localObject4	Object
    //   86	100	3	localFileUploadStatusParser	FileUploadStatusParser
    //   111	109	4	localIotHubStatusCode3	IotHubStatusCode
    // Exception table:
    //   from	to	target	type
    //   12	17	20	java/lang/NullPointerException
    //   12	17	24	java/net/URISyntaxException
    //   12	17	28	java/lang/IllegalArgumentException
    //   12	17	32	java/io/IOException
    //   108	113	138	java/lang/IllegalArgumentException
    //   108	113	142	java/io/IOException
    //   108	113	146	com/microsoft/azure/storage/StorageException
    //   59	106	150	finally
    //   59	106	154	java/lang/IllegalArgumentException
    //   59	106	158	java/io/IOException
    //   59	106	162	com/microsoft/azure/storage/StorageException
    //   108	113	232	finally
    //   167	178	232	finally
    //   180	185	232	finally
    //   187	210	232	finally
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.sdk.iot.device.fileupload.FileUploadTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */