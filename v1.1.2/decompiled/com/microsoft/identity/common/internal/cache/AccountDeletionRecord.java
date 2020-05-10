package com.microsoft.identity.common.internal.cache;

import com.microsoft.identity.common.internal.dto.AccountRecord;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AccountDeletionRecord
  implements List<AccountRecord>
{
  public static final String RESULT_IS_READ_ONLY = "Result is read-only";
  public final List<AccountRecord> mAccountRecordList;
  
  public AccountDeletionRecord(List<AccountRecord> paramList)
  {
    if (paramList == null) {
      mAccountRecordList = new ArrayList();
    } else {
      mAccountRecordList = paramList;
    }
  }
  
  public void add(int paramInt, AccountRecord paramAccountRecord)
  {
    throw new UnsupportedOperationException("Result is read-only");
  }
  
  public boolean add(AccountRecord paramAccountRecord)
  {
    throw new UnsupportedOperationException("Result is read-only");
  }
  
  public boolean addAll(int paramInt, Collection<? extends AccountRecord> paramCollection)
  {
    throw new UnsupportedOperationException("Result is read-only");
  }
  
  public boolean addAll(Collection<? extends AccountRecord> paramCollection)
  {
    throw new UnsupportedOperationException("Result is read-only");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException("Result is read-only");
  }
  
  public boolean contains(Object paramObject)
  {
    return mAccountRecordList.contains(paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return mAccountRecordList.containsAll(paramCollection);
  }
  
  public AccountRecord get(int paramInt)
  {
    return (AccountRecord)mAccountRecordList.get(paramInt);
  }
  
  public int indexOf(Object paramObject)
  {
    return mAccountRecordList.indexOf(paramObject);
  }
  
  public boolean isEmpty()
  {
    return mAccountRecordList.isEmpty();
  }
  
  public Iterator<AccountRecord> iterator()
  {
    return mAccountRecordList.iterator();
  }
  
  public int lastIndexOf(Object paramObject)
  {
    return mAccountRecordList.lastIndexOf(paramObject);
  }
  
  public ListIterator<AccountRecord> listIterator()
  {
    return mAccountRecordList.listIterator();
  }
  
  public ListIterator<AccountRecord> listIterator(int paramInt)
  {
    return mAccountRecordList.listIterator(paramInt);
  }
  
  public AccountRecord remove(int paramInt)
  {
    throw new UnsupportedOperationException("Result is read-only");
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException("Result is read-only");
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException("Result is read-only");
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException("Result is read-only");
  }
  
  public AccountRecord set(int paramInt, AccountRecord paramAccountRecord)
  {
    throw new UnsupportedOperationException("Result is read-only");
  }
  
  public int size()
  {
    return mAccountRecordList.size();
  }
  
  public List<AccountRecord> subList(int paramInt1, int paramInt2)
  {
    return mAccountRecordList.subList(paramInt1, paramInt2);
  }
  
  public Object[] toArray()
  {
    return mAccountRecordList.toArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return mAccountRecordList.toArray(paramArrayOfT);
  }
}

/* Location:
 * Qualified Name:     com.microsoft.identity.common.internal.cache.AccountDeletionRecord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */