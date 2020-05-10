package com.microsoft.azure.storage.file;

public enum ShareListingDetails
{
  public int value;
  
  static
  {
    METADATA = new ShareListingDetails("METADATA", 1, 1);
    ShareListingDetails localShareListingDetails = new ShareListingDetails("SNAPSHOTS", 2, 2);
    SNAPSHOTS = localShareListingDetails;
    $VALUES = new ShareListingDetails[] { NONE, METADATA, localShareListingDetails };
  }
  
  public ShareListingDetails(int paramInt)
  {
    value = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.file.ShareListingDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */