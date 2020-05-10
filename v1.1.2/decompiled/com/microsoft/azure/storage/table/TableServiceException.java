package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.RequestResult;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.StorageExtendedErrorInformation;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public final class TableServiceException
  extends StorageException
{
  public static final long serialVersionUID = 6037366449663934891L;
  public TableOperation operation;
  
  public TableServiceException(int paramInt, String paramString, TableOperation paramTableOperation, Reader paramReader, TablePayloadFormat paramTablePayloadFormat)
  {
    super(null, paramString, paramInt, null, null);
    operation = paramTableOperation;
    if (paramReader != null) {}
    try
    {
      paramString = TableStorageErrorDeserializer.getExtendedErrorInformation(paramReader, paramTablePayloadFormat);
      extendedErrorInformation = paramString;
      errorCode = paramString.getErrorCode();
      return;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
  }
  
  public TableServiceException(String paramString1, String paramString2, int paramInt, StorageExtendedErrorInformation paramStorageExtendedErrorInformation, Exception paramException)
  {
    super(paramString1, paramString2, paramInt, paramStorageExtendedErrorInformation, paramException);
  }
  
  public static TableServiceException generateTableServiceException(RequestResult paramRequestResult, TableOperation paramTableOperation, InputStream paramInputStream, TablePayloadFormat paramTablePayloadFormat)
  {
    return new TableServiceException(paramRequestResult.getStatusCode(), paramRequestResult.getStatusMessage(), paramTableOperation, new InputStreamReader(paramInputStream), paramTablePayloadFormat);
  }
  
  public TableOperation getOperation()
  {
    return operation;
  }
  
  public void setOperation(TableOperation paramTableOperation)
  {
    operation = paramTableOperation;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.table.TableServiceException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */