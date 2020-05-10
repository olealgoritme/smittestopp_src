package com.microsoft.azure.storage.file;

import java.util.Date;

public final class FileDirectoryProperties
{
  public String etag;
  public Date lastModified;
  public boolean serverEncrypted;
  
  public String getEtag()
  {
    return etag;
  }
  
  public Date getLastModified()
  {
    return lastModified;
  }
  
  public boolean isServerEncrypted()
  {
    return serverEncrypted;
  }
  
  public void setEtag(String paramString)
  {
    etag = paramString;
  }
  
  public void setLastModified(Date paramDate)
  {
    lastModified = paramDate;
  }
  
  public void setServerEncrypted(boolean paramBoolean)
  {
    serverEncrypted = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.file.FileDirectoryProperties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */