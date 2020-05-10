package com.microsoft.azure.storage.blob;

public enum BlobListingDetails
{
  public int value;
  
  static
  {
    METADATA = new BlobListingDetails("METADATA", 1, 2);
    UNCOMMITTED_BLOBS = new BlobListingDetails("UNCOMMITTED_BLOBS", 2, 4);
    COPY = new BlobListingDetails("COPY", 3, 8);
    BlobListingDetails localBlobListingDetails = new BlobListingDetails("DELETED", 4, 16);
    DELETED = localBlobListingDetails;
    $VALUES = new BlobListingDetails[] { SNAPSHOTS, METADATA, UNCOMMITTED_BLOBS, COPY, localBlobListingDetails };
  }
  
  public BlobListingDetails(int paramInt)
  {
    value = paramInt;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.BlobListingDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */