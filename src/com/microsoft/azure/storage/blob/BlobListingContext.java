package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.core.ListingContext;
import java.util.EnumSet;

public final class BlobListingContext
  extends ListingContext
{
  public String delimiter;
  public EnumSet<BlobListingDetails> listingDetails;
  
  public BlobListingContext(String paramString1, Integer paramInteger, String paramString2, EnumSet<BlobListingDetails> paramEnumSet)
  {
    super(paramString1, paramInteger);
    setDelimiter(paramString2);
    setListingDetails(paramEnumSet);
  }
  
  public String getDelimiter()
  {
    return delimiter;
  }
  
  public EnumSet<BlobListingDetails> getListingDetails()
  {
    return listingDetails;
  }
  
  public void setDelimiter(String paramString)
  {
    delimiter = paramString;
  }
  
  public void setListingDetails(EnumSet<BlobListingDetails> paramEnumSet)
  {
    listingDetails = paramEnumSet;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.blob.BlobListingContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */