package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.Permissions;

public final class BlobContainerPermissions
  extends Permissions<SharedAccessBlobPolicy>
{
  public BlobContainerPublicAccessType publicAccess;
  
  public BlobContainerPermissions()
  {
    setPublicAccess(BlobContainerPublicAccessType.OFF);
  }
  
  public BlobContainerPublicAccessType getPublicAccess()
  {
    return publicAccess;
  }
  
  public void setPublicAccess(BlobContainerPublicAccessType paramBlobContainerPublicAccessType)
  {
    publicAccess = paramBlobContainerPublicAccessType;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.BlobContainerPermissions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */