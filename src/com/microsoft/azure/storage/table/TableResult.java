package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.core.Utility;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;

public class TableResult
{
  public String etag;
  public int httpStatusCode = -1;
  public HashMap<String, EntityProperty> properties;
  public Object result;
  
  public TableResult() {}
  
  public TableResult(int paramInt)
  {
    httpStatusCode = paramInt;
  }
  
  public static Date parseETagForTimestamp(String paramString)
  {
    String str = paramString;
    if (paramString.startsWith("W/")) {
      str = paramString.substring(2);
    }
    return Utility.parseDate(URLDecoder.decode(str.substring(10, str.length() - 2), "UTF-8"));
  }
  
  public String getEtag()
  {
    return etag;
  }
  
  public int getHttpStatusCode()
  {
    return httpStatusCode;
  }
  
  public HashMap<String, EntityProperty> getProperties()
  {
    return properties;
  }
  
  public Object getResult()
  {
    return result;
  }
  
  public <T> T getResultAsType()
  {
    return (T)getResult();
  }
  
  public void setEtag(String paramString)
  {
    etag = paramString;
  }
  
  public void setHttpStatusCode(int paramInt)
  {
    httpStatusCode = paramInt;
  }
  
  public void setProperties(HashMap<String, EntityProperty> paramHashMap)
  {
    properties = paramHashMap;
  }
  
  public void setResult(Object paramObject)
  {
    result = paramObject;
  }
  
  public void updateResultObject(TableEntity paramTableEntity)
  {
    result = paramTableEntity;
    paramTableEntity.setEtag(etag);
    String str = etag;
    if (str != null) {
      paramTableEntity.setTimestamp(parseETagForTimestamp(str));
    }
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.table.TableResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */