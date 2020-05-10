package com.microsoft.azure.storage.blob;

public enum ContainerListingDetails
{
  public int value;
  
  static
  {
    ContainerListingDetails localContainerListingDetails = new ContainerListingDetails("NONE", 2, 0);
    NONE = localContainerListingDetails;
    $VALUES = new ContainerListingDetails[] { ALL, METADATA, localContainerListingDetails };
  }
  
  public ContainerListingDetails(int paramInt)
  {
    value = paramInt;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.ContainerListingDetails
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */