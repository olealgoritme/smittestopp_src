package com.microsoft.azure.storage.core;

import com.microsoft.azure.storage.OperationContext;
import com.microsoft.azure.storage.ResultSegment;
import com.microsoft.azure.storage.RetryPolicyFactory;
import java.util.Iterator;

public final class LazySegmentedIterable<CLIENT_TYPE, PARENT_TYPE, ENTITY_TYPE>
  implements Iterable<ENTITY_TYPE>
{
  public final CLIENT_TYPE client;
  public final OperationContext opContext;
  public final PARENT_TYPE parentObject;
  public final RetryPolicyFactory policyFactory;
  public final StorageRequest<CLIENT_TYPE, PARENT_TYPE, ResultSegment<ENTITY_TYPE>> segmentGenerator;
  
  public LazySegmentedIterable(StorageRequest<CLIENT_TYPE, PARENT_TYPE, ResultSegment<ENTITY_TYPE>> paramStorageRequest, CLIENT_TYPE paramCLIENT_TYPE, PARENT_TYPE paramPARENT_TYPE, RetryPolicyFactory paramRetryPolicyFactory, OperationContext paramOperationContext)
  {
    segmentGenerator = paramStorageRequest;
    parentObject = paramPARENT_TYPE;
    opContext = paramOperationContext;
    policyFactory = paramRetryPolicyFactory;
    client = paramCLIENT_TYPE;
  }
  
  public Iterator<ENTITY_TYPE> iterator()
  {
    return new LazySegmentedIterator(segmentGenerator, client, parentObject, policyFactory, opContext);
  }
}

/* Location:
 * Qualified Name:     base.com.microsoft.azure.storage.core.LazySegmentedIterable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */