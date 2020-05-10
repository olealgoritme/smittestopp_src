package com.microsoft.azure.storage.blob;

import java.net.URI;
import java.util.Date;

public final class CopyState
{
  public Long bytesCopied;
  public Date completionTime;
  public String copyDestinationSnapshotID;
  public String copyId;
  public URI source;
  public CopyStatus status;
  public String statusDescription;
  public Long totalBytes;
  
  public Long getBytesCopied()
  {
    return bytesCopied;
  }
  
  public Date getCompletionTime()
  {
    return completionTime;
  }
  
  public String getCopyDestinationSnapshotID()
  {
    return copyDestinationSnapshotID;
  }
  
  public String getCopyId()
  {
    return copyId;
  }
  
  public URI getSource()
  {
    return source;
  }
  
  public CopyStatus getStatus()
  {
    return status;
  }
  
  public String getStatusDescription()
  {
    return statusDescription;
  }
  
  public Long getTotalBytes()
  {
    return totalBytes;
  }
  
  public void setBytesCopied(Long paramLong)
  {
    bytesCopied = paramLong;
  }
  
  public void setCompletionTime(Date paramDate)
  {
    completionTime = paramDate;
  }
  
  public void setCopyDestinationSnapshotID(String paramString)
  {
    copyDestinationSnapshotID = paramString;
  }
  
  public void setCopyId(String paramString)
  {
    copyId = paramString;
  }
  
  public void setSource(URI paramURI)
  {
    source = paramURI;
  }
  
  public void setStatus(CopyStatus paramCopyStatus)
  {
    status = paramCopyStatus;
  }
  
  public void setStatusDescription(String paramString)
  {
    statusDescription = paramString;
  }
  
  public void setTotalBytes(Long paramLong)
  {
    totalBytes = paramLong;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.blob.CopyState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */