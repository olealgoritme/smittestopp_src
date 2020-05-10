package com.microsoft.azure.storage.core;

import com.microsoft.azure.storage.DoesServiceRequest;
import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.ResultSegment;
import com.microsoft.azure.storage.RetryPolicyFactory;
import com.microsoft.azure.storage.StorageException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class LazySegmentedIterator<CLIENT_TYPE, PARENT_TYPE, ENTITY_TYPE>
  implements Iterator<ENTITY_TYPE>
{
  public final CLIENT_TYPE client;
  public ResultSegment<ENTITY_TYPE> currentSegment;
  public Iterator<ENTITY_TYPE> currentSegmentIterator;
  public final OperationContext opContext;
  public final PARENT_TYPE parentObject;
  public final RetryPolicyFactory policyFactory;
  public final StorageRequest<CLIENT_TYPE, PARENT_TYPE, ResultSegment<ENTITY_TYPE>> segmentGenerator;
  
  public LazySegmentedIterator(StorageRequest<CLIENT_TYPE, PARENT_TYPE, ResultSegment<ENTITY_TYPE>> paramStorageRequest, CLIENT_TYPE paramCLIENT_TYPE, PARENT_TYPE paramPARENT_TYPE, RetryPolicyFactory paramRetryPolicyFactory, OperationContext paramOperationContext)
  {
    segmentGenerator = paramStorageRequest;
    parentObject = paramPARENT_TYPE;
    opContext = paramOperationContext;
    policyFactory = paramRetryPolicyFactory;
    client = paramCLIENT_TYPE;
  }
  
  @DoesServiceRequest
  public boolean hasNext()
  {
    for (;;)
    {
      Object localObject;
      if (currentSegment != null) {
        if (!currentSegmentIterator.hasNext())
        {
          localObject = currentSegment;
          if ((localObject != null) && (((ResultSegment)localObject).getHasMoreResults())) {}
        }
        else
        {
          return currentSegmentIterator.hasNext();
        }
      }
      try
      {
        localObject = (ResultSegment)ExecutionEngine.executeWithRetry(client, parentObject, segmentGenerator, policyFactory, opContext);
        currentSegment = ((ResultSegment)localObject);
        localObject = ((ResultSegment)localObject).getResults().iterator();
        currentSegmentIterator = ((Iterator)localObject);
        if ((((Iterator)localObject).hasNext()) || (currentSegment.getHasMoreResults())) {
          continue;
        }
        return false;
      }
      catch (StorageException localStorageException)
      {
        localObject = new NoSuchElementException("An error occurred while enumerating the result, check the original exception for details.");
        ((NoSuchElementException)localObject).initCause(localStorageException);
        throw ((Throwable)localObject);
      }
    }
  }
  
  public ENTITY_TYPE next()
  {
    if (hasNext()) {
      return (ENTITY_TYPE)currentSegmentIterator.next();
    }
    throw new NoSuchElementException();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.microsoft.azure.storage.core.LazySegmentedIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */