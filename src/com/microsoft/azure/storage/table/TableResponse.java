package com.microsoft.azure.storage.table;

import com.microsoft.azure.storage.ResultContinuation;
import com.microsoft.azure.storage.ResultContinuationType;
import java.net.HttpURLConnection;

public class TableResponse
{
  public static ResultContinuation getTableContinuationFromResponse(HttpURLConnection paramHttpURLConnection)
  {
    ResultContinuation localResultContinuation = new ResultContinuation();
    localResultContinuation.setContinuationType(ResultContinuationType.TABLE);
    String str = paramHttpURLConnection.getHeaderField("x-ms-continuation-".concat("NextPartitionKey"));
    int i = 1;
    int j;
    if (str != null)
    {
      localResultContinuation.setNextPartitionKey(str);
      j = 1;
    }
    else
    {
      j = 0;
    }
    str = paramHttpURLConnection.getHeaderField("x-ms-continuation-".concat("NextRowKey"));
    if (str != null)
    {
      localResultContinuation.setNextRowKey(str);
      j = 1;
    }
    str = paramHttpURLConnection.getHeaderField("x-ms-continuation-".concat("NextMarker"));
    if (str != null)
    {
      localResultContinuation.setNextMarker(str);
      j = 1;
    }
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("x-ms-continuation-".concat("NextTableName"));
    if (paramHttpURLConnection != null)
    {
      localResultContinuation.setNextTableName(paramHttpURLConnection);
      j = i;
    }
    if (j != 0) {
      paramHttpURLConnection = localResultContinuation;
    } else {
      paramHttpURLConnection = null;
    }
    return paramHttpURLConnection;
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.table.TableResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */