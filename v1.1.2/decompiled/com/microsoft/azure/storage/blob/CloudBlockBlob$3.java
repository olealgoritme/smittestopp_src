package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.AccessCondition;
import com.microsoft.azure.storage.OperationContext;
import java.io.InputStream;
import java.util.concurrent.Callable;

public class CloudBlockBlob$3
  implements Callable<Void>
{
  public CloudBlockBlob$3(CloudBlockBlob paramCloudBlockBlob, String paramString, InputStream paramInputStream, long paramLong, AccessCondition paramAccessCondition, BlobRequestOptions paramBlobRequestOptions, OperationContext paramOperationContext) {}
  
  public Void call()
  {
    this$0.uploadBlock(val$blockId, val$sourceStream, val$blockSize, val$_accessCondition, val$_requestOptions, val$_operationContext);
    val$sourceStream.close();
    return null;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.CloudBlockBlob.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */