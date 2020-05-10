package com.microsoft.azure.storage;

import java.io.Serializable;
import java.util.HashMap;

public final class StorageExtendedErrorInformation
  implements Serializable
{
  public static final long serialVersionUID = 1527013626991334677L;
  public HashMap<String, String[]> additionalDetails;
  public String errorCode;
  public String errorMessage;
  
  public StorageExtendedErrorInformation()
  {
    setAdditionalDetails(new HashMap());
  }
  
  public HashMap<String, String[]> getAdditionalDetails()
  {
    return additionalDetails;
  }
  
  @Deprecated
  public String getErrorCode()
  {
    return errorCode;
  }
  
  public String getErrorMessage()
  {
    return errorMessage;
  }
  
  public void setAdditionalDetails(HashMap<String, String[]> paramHashMap)
  {
    additionalDetails = paramHashMap;
  }
  
  public void setErrorCode(String paramString)
  {
    errorCode = paramString;
  }
  
  public void setErrorMessage(String paramString)
  {
    errorMessage = paramString;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.StorageExtendedErrorInformation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */