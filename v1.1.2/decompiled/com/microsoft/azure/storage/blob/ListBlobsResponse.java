package com.microsoft.azure.storage.blob;

import com.microsoft.azure.storage.core.ListResponse;

public final class ListBlobsResponse
  extends ListResponse<ListBlobItem>
{
  public String delimiter;
  
  public String getDelimiter()
  {
    return delimiter;
  }
  
  public void setDelimiter(String paramString)
  {
    delimiter = paramString;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.ListBlobsResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */