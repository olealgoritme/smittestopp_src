package com.microsoft.azure.storage;

import java.util.ArrayList;

public class ResultSegment<T>
{
  public final ResultContinuation continuationToken;
  public final int length;
  public final Integer pageSize;
  public final ArrayList<T> results;
  
  public ResultSegment(ArrayList<T> paramArrayList, Integer paramInteger, ResultContinuation paramResultContinuation)
  {
    results = paramArrayList;
    length = paramArrayList.size();
    pageSize = paramInteger;
    continuationToken = paramResultContinuation;
  }
  
  public ResultContinuation getContinuationToken()
  {
    return continuationToken;
  }
  
  public boolean getHasMoreResults()
  {
    boolean bool;
    if (continuationToken != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean getIsPageComplete()
  {
    return Integer.valueOf(length).equals(pageSize);
  }
  
  public int getLength()
  {
    return length;
  }
  
  public Integer getPageSize()
  {
    return pageSize;
  }
  
  public int getRemainingPageResults()
  {
    return pageSize.intValue() - length;
  }
  
  public ArrayList<T> getResults()
  {
    return results;
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.ResultSegment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */