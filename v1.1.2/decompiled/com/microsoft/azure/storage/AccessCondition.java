package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.Utility;
import java.net.HttpURLConnection;
import java.util.Date;

public final class AccessCondition
{
  public Long ifAppendPositionEqual = null;
  public String ifMatchETag = null;
  public Long ifMaxSizeLessThanOrEqual = null;
  public Date ifModifiedSinceDate = null;
  public String ifNoneMatchETag = null;
  public Long ifSequenceNumberEqual = null;
  public Long ifSequenceNumberLessThan = null;
  public Long ifSequenceNumberLessThanOrEqual = null;
  public Date ifUnmodifiedSinceDate = null;
  public String leaseID = null;
  
  public static AccessCondition generateEmptyCondition()
  {
    return new AccessCondition();
  }
  
  public static AccessCondition generateIfExistsCondition()
  {
    AccessCondition localAccessCondition = new AccessCondition();
    localAccessCondition.setIfMatch("*");
    return localAccessCondition;
  }
  
  public static AccessCondition generateIfMatchCondition(String paramString)
  {
    AccessCondition localAccessCondition = new AccessCondition();
    localAccessCondition.setIfMatch(paramString);
    return localAccessCondition;
  }
  
  public static AccessCondition generateIfModifiedSinceCondition(Date paramDate)
  {
    AccessCondition localAccessCondition = new AccessCondition();
    ifModifiedSinceDate = paramDate;
    return localAccessCondition;
  }
  
  public static AccessCondition generateIfNoneMatchCondition(String paramString)
  {
    AccessCondition localAccessCondition = new AccessCondition();
    localAccessCondition.setIfNoneMatch(paramString);
    return localAccessCondition;
  }
  
  public static AccessCondition generateIfNotExistsCondition()
  {
    AccessCondition localAccessCondition = new AccessCondition();
    localAccessCondition.setIfNoneMatch("*");
    return localAccessCondition;
  }
  
  public static AccessCondition generateIfNotModifiedSinceCondition(Date paramDate)
  {
    AccessCondition localAccessCondition = new AccessCondition();
    ifUnmodifiedSinceDate = paramDate;
    return localAccessCondition;
  }
  
  public static AccessCondition generateIfSequenceNumberEqualCondition(long paramLong)
  {
    AccessCondition localAccessCondition = new AccessCondition();
    ifSequenceNumberEqual = Long.valueOf(paramLong);
    return localAccessCondition;
  }
  
  public static AccessCondition generateIfSequenceNumberLessThanCondition(long paramLong)
  {
    AccessCondition localAccessCondition = new AccessCondition();
    ifSequenceNumberLessThan = Long.valueOf(paramLong);
    return localAccessCondition;
  }
  
  public static AccessCondition generateIfSequenceNumberLessThanOrEqualCondition(long paramLong)
  {
    AccessCondition localAccessCondition = new AccessCondition();
    ifSequenceNumberLessThanOrEqual = Long.valueOf(paramLong);
    return localAccessCondition;
  }
  
  public static AccessCondition generateLeaseCondition(String paramString)
  {
    AccessCondition localAccessCondition = new AccessCondition();
    leaseID = paramString;
    return localAccessCondition;
  }
  
  public static String normalizeEtag(String paramString)
  {
    String str = paramString;
    if (!Utility.isNullOrEmpty(paramString)) {
      if (paramString.equals("*"))
      {
        str = paramString;
      }
      else
      {
        if ((paramString.startsWith("\"")) && (paramString.endsWith("\""))) {
          return paramString;
        }
        str = String.format("\"%s\"", new Object[] { paramString });
      }
    }
    return str;
  }
  
  public void applyAppendConditionToRequest(HttpURLConnection paramHttpURLConnection)
  {
    Long localLong = ifMaxSizeLessThanOrEqual;
    if (localLong != null) {
      paramHttpURLConnection.setRequestProperty("x-ms-blob-condition-maxsize", localLong.toString());
    }
    localLong = ifAppendPositionEqual;
    if (localLong != null) {
      paramHttpURLConnection.setRequestProperty("x-ms-blob-condition-appendpos", localLong.toString());
    }
  }
  
  public void applyConditionToRequest(HttpURLConnection paramHttpURLConnection)
  {
    applyLeaseConditionToRequest(paramHttpURLConnection);
    Date localDate = ifModifiedSinceDate;
    if (localDate != null) {
      paramHttpURLConnection.setRequestProperty("If-Modified-Since", Utility.getGMTTime(localDate));
    }
    localDate = ifUnmodifiedSinceDate;
    if (localDate != null) {
      paramHttpURLConnection.setRequestProperty("If-Unmodified-Since", Utility.getGMTTime(localDate));
    }
    if (!Utility.isNullOrEmpty(ifMatchETag)) {
      paramHttpURLConnection.setRequestProperty("If-Match", ifMatchETag);
    }
    if (!Utility.isNullOrEmpty(ifNoneMatchETag)) {
      paramHttpURLConnection.setRequestProperty("If-None-Match", ifNoneMatchETag);
    }
  }
  
  public void applyLeaseConditionToRequest(HttpURLConnection paramHttpURLConnection)
  {
    if (!Utility.isNullOrEmpty(leaseID)) {
      paramHttpURLConnection.setRequestProperty("x-ms-lease-id", leaseID);
    }
  }
  
  public void applySequenceConditionToRequest(HttpURLConnection paramHttpURLConnection)
  {
    Long localLong = ifSequenceNumberLessThanOrEqual;
    if (localLong != null) {
      paramHttpURLConnection.setRequestProperty("x-ms-if-sequence-number-le", localLong.toString());
    }
    localLong = ifSequenceNumberLessThan;
    if (localLong != null) {
      paramHttpURLConnection.setRequestProperty("x-ms-if-sequence-number-lt", localLong.toString());
    }
    localLong = ifSequenceNumberEqual;
    if (localLong != null) {
      paramHttpURLConnection.setRequestProperty("x-ms-if-sequence-number-eq", localLong.toString());
    }
  }
  
  public void applySourceConditionToRequest(HttpURLConnection paramHttpURLConnection)
  {
    if (Utility.isNullOrEmpty(leaseID))
    {
      Date localDate = ifModifiedSinceDate;
      if (localDate != null) {
        paramHttpURLConnection.setRequestProperty("x-ms-source-if-modified-since", Utility.getGMTTime(localDate));
      }
      localDate = ifUnmodifiedSinceDate;
      if (localDate != null) {
        paramHttpURLConnection.setRequestProperty("x-ms-source-if-unmodified-since", Utility.getGMTTime(localDate));
      }
      if (!Utility.isNullOrEmpty(ifMatchETag)) {
        paramHttpURLConnection.setRequestProperty("x-ms-source-if-match", ifMatchETag);
      }
      if (!Utility.isNullOrEmpty(ifNoneMatchETag)) {
        paramHttpURLConnection.setRequestProperty("x-ms-source-if-none-match", ifNoneMatchETag);
      }
      return;
    }
    throw new IllegalArgumentException("A lease condition cannot be specified on the source of a copy.");
  }
  
  public Long getIfAppendPositionEqual()
  {
    return ifAppendPositionEqual;
  }
  
  public String getIfMatch()
  {
    return ifMatchETag;
  }
  
  public Long getIfMaxSizeLessThanOrEqual()
  {
    return ifMaxSizeLessThanOrEqual;
  }
  
  public Date getIfModifiedSinceDate()
  {
    return ifModifiedSinceDate;
  }
  
  public String getIfNoneMatch()
  {
    return ifNoneMatchETag;
  }
  
  public Long getIfSequenceNumberEqual()
  {
    return ifSequenceNumberEqual;
  }
  
  public Long getIfSequenceNumberLessThan()
  {
    return ifSequenceNumberLessThan;
  }
  
  public Long getIfSequenceNumberLessThanOrEqual()
  {
    return ifSequenceNumberLessThanOrEqual;
  }
  
  public Date getIfUnmodifiedSinceDate()
  {
    return ifUnmodifiedSinceDate;
  }
  
  public String getLeaseID()
  {
    return leaseID;
  }
  
  public void setIfAppendPositionEqual(Long paramLong)
  {
    ifAppendPositionEqual = paramLong;
  }
  
  public void setIfMatch(String paramString)
  {
    ifMatchETag = normalizeEtag(paramString);
  }
  
  public void setIfMaxSizeLessThanOrEqual(Long paramLong)
  {
    ifMaxSizeLessThanOrEqual = paramLong;
  }
  
  public void setIfModifiedSinceDate(Date paramDate)
  {
    ifModifiedSinceDate = paramDate;
  }
  
  public void setIfNoneMatch(String paramString)
  {
    ifNoneMatchETag = normalizeEtag(paramString);
  }
  
  public void setIfSequenceNumberEqual(Long paramLong)
  {
    ifSequenceNumberEqual = paramLong;
  }
  
  public void setIfSequenceNumberLessThan(Long paramLong)
  {
    ifSequenceNumberLessThan = paramLong;
  }
  
  public void setIfSequenceNumberLessThanOrEqual(Long paramLong)
  {
    ifSequenceNumberLessThanOrEqual = paramLong;
  }
  
  public void setIfUnmodifiedSinceDate(Date paramDate)
  {
    ifUnmodifiedSinceDate = paramDate;
  }
  
  public void setLeaseID(String paramString)
  {
    leaseID = paramString;
  }
  
  public boolean verifyConditional(String paramString, Date paramDate)
  {
    Date localDate = ifModifiedSinceDate;
    if ((localDate != null) && (!paramDate.after(localDate))) {
      return false;
    }
    localDate = ifUnmodifiedSinceDate;
    if ((localDate != null) && (paramDate.after(localDate))) {
      return false;
    }
    if ((!Utility.isNullOrEmpty(ifMatchETag)) && (!ifMatchETag.equals(paramString)) && (!ifMatchETag.equals("*"))) {
      return false;
    }
    return (Utility.isNullOrEmpty(ifNoneMatchETag)) || (!ifNoneMatchETag.equals(paramString));
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.AccessCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */