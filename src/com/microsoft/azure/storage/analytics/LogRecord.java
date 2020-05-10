package com.microsoft.azure.storage.analytics;

import com.microsoft.azure.storage.core.Utility;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

public class LogRecord
{
  public static final SimpleDateFormat LAST_MODIFIED_TIME_FORMAT = new SimpleDateFormat("E, dd-MMM-yy HH:mm:ss 'GMT'");
  public static final SimpleDateFormat REQUEST_START_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'");
  public String authenticationType;
  public String clientRequestId;
  public String conditionsUsed;
  public String eTagIdentifier;
  public Integer endToEndLatencyInMS;
  public String httpStatusCode;
  public Date lastModifiedTime;
  public Integer operationCount;
  public String operationType;
  public String ownerAccountName;
  public String referrerHeader;
  public Long requestContentLength;
  public Long requestHeaderSize;
  public UUID requestIdHeader;
  public String requestMD5;
  public Long requestPacketSize;
  public Date requestStartTime;
  public String requestStatus;
  public URI requestUrl;
  public String requestVersionHeader;
  public String requestedObjectKey;
  public String requesterAccountName;
  public String requesterIPAddress;
  public Long responseHeaderSize;
  public Long responsePacketSize;
  public Integer serverLatencyInMS;
  public String serverMD5;
  public String serviceType;
  public String userAgentHeader;
  public String versionNumber;
  
  public LogRecord() {}
  
  public LogRecord(LogRecordStreamReader paramLogRecordStreamReader)
  {
    LAST_MODIFIED_TIME_FORMAT.setTimeZone(TimeZone.getTimeZone("GMT"));
    REQUEST_START_TIME_FORMAT.setTimeZone(TimeZone.getTimeZone("GMT"));
    Utility.assertNotNull("reader", paramLogRecordStreamReader);
    String str = paramLogRecordStreamReader.readString();
    versionNumber = str;
    Utility.assertNotNullOrEmpty("versionNumber", str);
    if (versionNumber.equals("1.0"))
    {
      populateVersion1Log(paramLogRecordStreamReader);
      return;
    }
    throw new IllegalArgumentException(String.format("A storage log version of %s is unsupported.", new Object[] { versionNumber }));
  }
  
  private void populateVersion1Log(LogRecordStreamReader paramLogRecordStreamReader)
  {
    requestStartTime = paramLogRecordStreamReader.readDate(REQUEST_START_TIME_FORMAT);
    operationType = paramLogRecordStreamReader.readString();
    requestStatus = paramLogRecordStreamReader.readString();
    httpStatusCode = paramLogRecordStreamReader.readString();
    endToEndLatencyInMS = paramLogRecordStreamReader.readInteger();
    serverLatencyInMS = paramLogRecordStreamReader.readInteger();
    authenticationType = paramLogRecordStreamReader.readString();
    requesterAccountName = paramLogRecordStreamReader.readString();
    ownerAccountName = paramLogRecordStreamReader.readString();
    serviceType = paramLogRecordStreamReader.readString();
    requestUrl = paramLogRecordStreamReader.readUri();
    requestedObjectKey = paramLogRecordStreamReader.readQuotedString();
    requestIdHeader = paramLogRecordStreamReader.readUuid();
    operationCount = paramLogRecordStreamReader.readInteger();
    requesterIPAddress = paramLogRecordStreamReader.readString();
    requestVersionHeader = paramLogRecordStreamReader.readString();
    requestHeaderSize = paramLogRecordStreamReader.readLong();
    requestPacketSize = paramLogRecordStreamReader.readLong();
    responseHeaderSize = paramLogRecordStreamReader.readLong();
    responsePacketSize = paramLogRecordStreamReader.readLong();
    requestContentLength = paramLogRecordStreamReader.readLong();
    requestMD5 = paramLogRecordStreamReader.readQuotedString();
    serverMD5 = paramLogRecordStreamReader.readQuotedString();
    eTagIdentifier = paramLogRecordStreamReader.readQuotedString();
    lastModifiedTime = paramLogRecordStreamReader.readDate(LAST_MODIFIED_TIME_FORMAT);
    conditionsUsed = paramLogRecordStreamReader.readQuotedString();
    userAgentHeader = paramLogRecordStreamReader.readQuotedString();
    referrerHeader = paramLogRecordStreamReader.readQuotedString();
    clientRequestId = paramLogRecordStreamReader.readQuotedString();
    paramLogRecordStreamReader.endCurrentRecord();
  }
  
  public String getAuthenticationType()
  {
    return authenticationType;
  }
  
  public String getClientRequestId()
  {
    return clientRequestId;
  }
  
  public String getConditionsUsed()
  {
    return conditionsUsed;
  }
  
  public String getETagIdentifier()
  {
    return eTagIdentifier;
  }
  
  public Integer getEndToEndLatencyInMS()
  {
    return endToEndLatencyInMS;
  }
  
  public String getHttpStatusCode()
  {
    return httpStatusCode;
  }
  
  public Date getLastModifiedTime()
  {
    return lastModifiedTime;
  }
  
  public Integer getOperationCount()
  {
    return operationCount;
  }
  
  public String getOperationType()
  {
    return operationType;
  }
  
  public String getOwnerAccountName()
  {
    return ownerAccountName;
  }
  
  public String getReferrerHeader()
  {
    return referrerHeader;
  }
  
  public Long getRequestContentLength()
  {
    return requestContentLength;
  }
  
  public Long getRequestHeaderSize()
  {
    return requestHeaderSize;
  }
  
  public UUID getRequestIdHeader()
  {
    return requestIdHeader;
  }
  
  public String getRequestMD5()
  {
    return requestMD5;
  }
  
  public Long getRequestPacketSize()
  {
    return requestPacketSize;
  }
  
  public Date getRequestStartTime()
  {
    return requestStartTime;
  }
  
  public String getRequestStatus()
  {
    return requestStatus;
  }
  
  public URI getRequestUrl()
  {
    return requestUrl;
  }
  
  public String getRequestVersionHeader()
  {
    return requestVersionHeader;
  }
  
  public String getRequestedObjectKey()
  {
    return requestedObjectKey;
  }
  
  public String getRequesterAccountName()
  {
    return requesterAccountName;
  }
  
  public String getRequesterIPAddress()
  {
    return requesterIPAddress;
  }
  
  public Long getResponseHeaderSize()
  {
    return responseHeaderSize;
  }
  
  public Long getResponsePacketSize()
  {
    return responsePacketSize;
  }
  
  public Integer getServerLatencyInMS()
  {
    return serverLatencyInMS;
  }
  
  public String getServerMD5()
  {
    return serverMD5;
  }
  
  public String getServiceType()
  {
    return serviceType;
  }
  
  public String getUserAgentHeader()
  {
    return userAgentHeader;
  }
  
  public String getVersionNumber()
  {
    return versionNumber;
  }
  
  public void setAuthenticationType(String paramString)
  {
    authenticationType = paramString;
  }
  
  public void setClientRequestId(String paramString)
  {
    clientRequestId = paramString;
  }
  
  public void setConditionsUsed(String paramString)
  {
    conditionsUsed = paramString;
  }
  
  public void setETagIdentifier(String paramString)
  {
    eTagIdentifier = paramString;
  }
  
  public void setEndToEndLatencyInMS(Integer paramInteger)
  {
    endToEndLatencyInMS = paramInteger;
  }
  
  public void setHttpStatusCode(String paramString)
  {
    httpStatusCode = paramString;
  }
  
  public void setLastModifiedTime(Date paramDate)
  {
    lastModifiedTime = paramDate;
  }
  
  public void setOperationCount(Integer paramInteger)
  {
    operationCount = paramInteger;
  }
  
  public void setOperationType(String paramString)
  {
    operationType = paramString;
  }
  
  public void setOwnerAccountName(String paramString)
  {
    ownerAccountName = paramString;
  }
  
  public void setReferrerHeader(String paramString)
  {
    referrerHeader = paramString;
  }
  
  public void setRequestContentLength(Long paramLong)
  {
    requestContentLength = paramLong;
  }
  
  public void setRequestHeaderSize(Long paramLong)
  {
    requestHeaderSize = paramLong;
  }
  
  public void setRequestIdHeader(UUID paramUUID)
  {
    requestIdHeader = paramUUID;
  }
  
  public void setRequestMD5(String paramString)
  {
    requestMD5 = paramString;
  }
  
  public void setRequestPacketSize(Long paramLong)
  {
    requestPacketSize = paramLong;
  }
  
  public void setRequestStartTime(Date paramDate)
  {
    requestStartTime = paramDate;
  }
  
  public void setRequestStatus(String paramString)
  {
    requestStatus = paramString;
  }
  
  public void setRequestUrl(URI paramURI)
  {
    requestUrl = paramURI;
  }
  
  public void setRequestVersionHeader(String paramString)
  {
    requestVersionHeader = paramString;
  }
  
  public void setRequestedObjectKey(String paramString)
  {
    requestedObjectKey = paramString;
  }
  
  public void setRequesterAccountName(String paramString)
  {
    requesterAccountName = paramString;
  }
  
  public void setRequesterIPAddress(String paramString)
  {
    requesterIPAddress = paramString;
  }
  
  public void setResponseHeaderSize(Long paramLong)
  {
    responseHeaderSize = paramLong;
  }
  
  public void setResponsePacketSize(Long paramLong)
  {
    responsePacketSize = paramLong;
  }
  
  public void setServerLatencyInMS(Integer paramInteger)
  {
    serverLatencyInMS = paramInteger;
  }
  
  public void setServerMD5(String paramString)
  {
    serverMD5 = paramString;
  }
  
  public void setServiceType(String paramString)
  {
    serviceType = paramString;
  }
  
  public void setUserAgentHeader(String paramString)
  {
    userAgentHeader = paramString;
  }
  
  public void setVersionNumber(String paramString)
  {
    versionNumber = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.analytics.LogRecord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */