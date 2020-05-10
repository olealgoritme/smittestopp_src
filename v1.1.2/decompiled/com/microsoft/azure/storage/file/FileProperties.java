package com.microsoft.azure.storage.file;

import java.util.Date;

public final class FileProperties
{
  public String cacheControl;
  public String contentDisposition;
  public String contentEncoding;
  public String contentLanguage;
  public String contentMD5;
  public String contentType;
  public CopyState copyState;
  public String etag;
  public Date lastModified;
  public long length;
  public boolean serverEncrypted;
  
  public FileProperties() {}
  
  public FileProperties(FileProperties paramFileProperties)
  {
    cacheControl = cacheControl;
    contentDisposition = contentDisposition;
    contentEncoding = contentEncoding;
    contentLanguage = contentLanguage;
    contentMD5 = contentMD5;
    contentType = contentType;
    etag = etag;
    length = length;
    lastModified = lastModified;
    serverEncrypted = serverEncrypted;
  }
  
  public String getCacheControl()
  {
    return cacheControl;
  }
  
  public String getContentDisposition()
  {
    return contentDisposition;
  }
  
  public String getContentEncoding()
  {
    return contentEncoding;
  }
  
  public String getContentLanguage()
  {
    return contentLanguage;
  }
  
  public String getContentMD5()
  {
    return contentMD5;
  }
  
  public String getContentType()
  {
    return contentType;
  }
  
  public CopyState getCopyState()
  {
    return copyState;
  }
  
  public String getEtag()
  {
    return etag;
  }
  
  public Date getLastModified()
  {
    return lastModified;
  }
  
  public long getLength()
  {
    return length;
  }
  
  public boolean isServerEncrypted()
  {
    return serverEncrypted;
  }
  
  public void setCacheControl(String paramString)
  {
    cacheControl = paramString;
  }
  
  public void setContentDisposition(String paramString)
  {
    contentDisposition = paramString;
  }
  
  public void setContentEncoding(String paramString)
  {
    contentEncoding = paramString;
  }
  
  public void setContentLanguage(String paramString)
  {
    contentLanguage = paramString;
  }
  
  public void setContentMD5(String paramString)
  {
    contentMD5 = paramString;
  }
  
  public void setContentType(String paramString)
  {
    contentType = paramString;
  }
  
  public void setCopyState(CopyState paramCopyState)
  {
    copyState = paramCopyState;
  }
  
  public void setEtag(String paramString)
  {
    etag = paramString;
  }
  
  public void setLastModified(Date paramDate)
  {
    lastModified = paramDate;
  }
  
  public void setLength(long paramLong)
  {
    length = paramLong;
  }
  
  public void setServerEncrypted(boolean paramBoolean)
  {
    serverEncrypted = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.file.FileProperties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */