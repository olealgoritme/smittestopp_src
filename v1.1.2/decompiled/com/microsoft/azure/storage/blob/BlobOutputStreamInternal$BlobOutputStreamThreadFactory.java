package com.microsoft.azure.storage.blob;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class BlobOutputStreamInternal$BlobOutputStreamThreadFactory
  implements ThreadFactory
{
  public final ThreadGroup group;
  public final String namePrefix;
  public final AtomicInteger threadNumber = new AtomicInteger(1);
  
  public BlobOutputStreamInternal$BlobOutputStreamThreadFactory()
  {
    Object localObject = System.getSecurityManager();
    if (localObject != null) {
      localObject = ((SecurityManager)localObject).getThreadGroup();
    } else {
      localObject = Thread.currentThread().getThreadGroup();
    }
    group = ((ThreadGroup)localObject);
    namePrefix = "azure-storage-bloboutputstream-thread-";
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    ThreadGroup localThreadGroup = group;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(namePrefix);
    localStringBuilder.append(threadNumber.getAndIncrement());
    paramRunnable = new Thread(localThreadGroup, paramRunnable, localStringBuilder.toString(), 0L);
    paramRunnable.setDaemon(true);
    if (paramRunnable.getPriority() != 5) {
      paramRunnable.setPriority(5);
    }
    return paramRunnable;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.BlobOutputStreamInternal.BlobOutputStreamThreadFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */