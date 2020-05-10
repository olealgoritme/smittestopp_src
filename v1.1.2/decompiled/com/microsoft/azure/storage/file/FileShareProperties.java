package com.microsoft.azure.storage.file;

import java.util.Date;

public final class FileShareProperties
{
  public String etag;
  public Date lastModified;
  public Integer shareQuota;
  
  public FileShareProperties() {}
  
  public FileShareProperties(FileShareProperties paramFileShareProperties)
  {
    if (paramFileShareProperties != null)
    {
      setEtag(paramFileShareProperties.getEtag());
      setLastModified(paramFileShareProperties.getLastModified());
      setShareQuota(paramFileShareProperties.getShareQuota());
    }
  }
  
  public String getEtag()
  {
    return etag;
  }
  
  public Date getLastModified()
  {
    return lastModified;
  }
  
  public Integer getShareQuota()
  {
    return shareQuota;
  }
  
  public void setEtag(String paramString)
  {
    etag = paramString;
  }
  
  public void setLastModified(Date paramDate)
  {
    lastModified = paramDate;
  }
  
  public void setShareQuota(Integer paramInteger)
  {
    shareQuota = paramInteger;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.file.FileShareProperties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */