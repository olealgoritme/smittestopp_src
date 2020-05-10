package com.microsoft.azure.storage;

public final class StaticWebsiteProperties
{
  public boolean enabled = false;
  public String errorDocument404Path;
  public String indexDocument;
  
  public boolean getEnabled()
  {
    return enabled;
  }
  
  public String getErrorDocument404Path()
  {
    return errorDocument404Path;
  }
  
  public String getIndexDocument()
  {
    return indexDocument;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    enabled = paramBoolean;
  }
  
  public void setErrorDocument404Path(String paramString)
  {
    errorDocument404Path = paramString;
  }
  
  public void setIndexDocument(String paramString)
  {
    indexDocument = paramString;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.StaticWebsiteProperties
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */