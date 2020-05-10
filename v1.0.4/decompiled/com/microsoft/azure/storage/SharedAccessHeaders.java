package com.microsoft.azure.storage;

import com.microsoft.azure.storage.core.Utility;

public abstract class SharedAccessHeaders
{
  public String cacheControl;
  public String contentDisposition;
  public String contentEncoding;
  public String contentLanguage;
  public String contentType;
  
  public SharedAccessHeaders() {}
  
  public SharedAccessHeaders(SharedAccessHeaders paramSharedAccessHeaders)
  {
    Utility.assertNotNull("other", paramSharedAccessHeaders);
    contentType = contentType;
    contentDisposition = contentDisposition;
    contentEncoding = contentEncoding;
    contentLanguage = contentLanguage;
    cacheControl = cacheControl;
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
  
  public String getContentType()
  {
    return contentType;
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
  
  public void setContentType(String paramString)
  {
    contentType = paramString;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.SharedAccessHeaders
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */