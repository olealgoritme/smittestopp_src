package net.sqlcipher;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObservable;
import android.database.ContentObserver;
import android.database.CrossProcessCursor;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import e.a.a.a.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCursor
  implements CrossProcessCursor, Cursor
{
  public static final String TAG = "Cursor";
  public boolean mClosed = false;
  public ContentObservable mContentObservable = new ContentObservable();
  public ContentResolver mContentResolver;
  public Long mCurrentRowID = null;
  public DataSetObservable mDataSetObservable = new DataSetObservable();
  public Bundle mExtras = Bundle.EMPTY;
  public Uri mNotifyUri;
  public int mPos = -1;
  public int mRowIdColumnIndex = -1;
  public ContentObserver mSelfObserver;
  public final Object mSelfObserverLock = new Object();
  public boolean mSelfObserverRegistered;
  public HashMap<Long, Map<String, Object>> mUpdatedRows = new HashMap();
  
  public void abortUpdates()
  {
    synchronized (mUpdatedRows)
    {
      mUpdatedRows.clear();
      return;
    }
  }
  
  public void checkPosition()
  {
    if ((-1 != mPos) && (getCount() != mPos)) {
      return;
    }
    throw new CursorIndexOutOfBoundsException(mPos, getCount());
  }
  
  public void close()
  {
    mClosed = true;
    mContentObservable.unregisterAll();
    deactivateInternal();
  }
  
  public boolean commitUpdates()
  {
    return commitUpdates(null);
  }
  
  public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> paramMap)
  {
    return false;
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    String str = getString(paramInt);
    if (str != null)
    {
      char[] arrayOfChar = data;
      if ((arrayOfChar != null) && (arrayOfChar.length >= str.length())) {
        str.getChars(0, str.length(), arrayOfChar, 0);
      } else {
        data = str.toCharArray();
      }
      sizeCopied = str.length();
    }
    else
    {
      sizeCopied = 0;
    }
  }
  
  public void deactivate()
  {
    deactivateInternal();
  }
  
  public void deactivateInternal()
  {
    ContentObserver localContentObserver = mSelfObserver;
    if (localContentObserver != null)
    {
      mContentResolver.unregisterContentObserver(localContentObserver);
      mSelfObserverRegistered = false;
    }
    mDataSetObservable.notifyInvalidated();
  }
  
  public boolean deleteRow()
  {
    return false;
  }
  
  public void fillWindow(int paramInt, android.database.CursorWindow paramCursorWindow)
  {
    DatabaseUtils.cursorFillWindow(this, paramInt, paramCursorWindow);
  }
  
  public void finalize()
  {
    ContentObserver localContentObserver = mSelfObserver;
    if ((localContentObserver != null) && (mSelfObserverRegistered == true)) {
      mContentResolver.unregisterContentObserver(localContentObserver);
    }
  }
  
  public byte[] getBlob(int paramInt)
  {
    throw new UnsupportedOperationException("getBlob is not supported");
  }
  
  public int getColumnCount()
  {
    return getColumnNames().length;
  }
  
  public int getColumnIndex(String paramString)
  {
    int i = paramString.lastIndexOf('.');
    Object localObject = paramString;
    if (i != -1)
    {
      Exception localException = new Exception();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requesting column name with table name -- ");
      ((StringBuilder)localObject).append(paramString);
      Log.e("Cursor", ((StringBuilder)localObject).toString(), localException);
      localObject = paramString.substring(i + 1);
    }
    paramString = getColumnNames();
    int j = paramString.length;
    for (i = 0; i < j; i++) {
      if (paramString[i].equalsIgnoreCase((String)localObject)) {
        return i;
      }
    }
    return -1;
  }
  
  public int getColumnIndexOrThrow(String paramString)
  {
    int i = getColumnIndex(paramString);
    if (i >= 0) {
      return i;
    }
    throw new IllegalArgumentException(a.a("column '", paramString, "' does not exist"));
  }
  
  public String getColumnName(int paramInt)
  {
    return getColumnNames()[paramInt];
  }
  
  public abstract String[] getColumnNames();
  
  public abstract int getCount();
  
  public DataSetObservable getDataSetObservable()
  {
    return mDataSetObservable;
  }
  
  public abstract double getDouble(int paramInt);
  
  public Bundle getExtras()
  {
    return mExtras;
  }
  
  public abstract float getFloat(int paramInt);
  
  public abstract int getInt(int paramInt);
  
  public abstract long getLong(int paramInt);
  
  public Uri getNotificationUri()
  {
    return mNotifyUri;
  }
  
  public final int getPosition()
  {
    return mPos;
  }
  
  public abstract short getShort(int paramInt);
  
  public abstract String getString(int paramInt);
  
  public abstract int getType(int paramInt);
  
  public Object getUpdatedField(int paramInt)
  {
    return ((Map)mUpdatedRows.get(mCurrentRowID)).get(getColumnNames()[paramInt]);
  }
  
  public boolean getWantsAllOnMoveCalls()
  {
    return false;
  }
  
  public CursorWindow getWindow()
  {
    return null;
  }
  
  public boolean hasUpdates()
  {
    synchronized (mUpdatedRows)
    {
      boolean bool;
      if (mUpdatedRows.size() > 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public final boolean isAfterLast()
  {
    int i = getCount();
    boolean bool = true;
    if (i == 0) {
      return true;
    }
    if (mPos != getCount()) {
      bool = false;
    }
    return bool;
  }
  
  public final boolean isBeforeFirst()
  {
    int i = getCount();
    boolean bool = true;
    if (i == 0) {
      return true;
    }
    if (mPos != -1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean isClosed()
  {
    return mClosed;
  }
  
  public boolean isFieldUpdated(int paramInt)
  {
    if ((mRowIdColumnIndex != -1) && (mUpdatedRows.size() > 0))
    {
      Map localMap = (Map)mUpdatedRows.get(mCurrentRowID);
      if ((localMap != null) && (localMap.containsKey(getColumnNames()[paramInt]))) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean isFirst()
  {
    boolean bool;
    if ((mPos == 0) && (getCount() != 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean isLast()
  {
    int i = getCount();
    boolean bool;
    if ((mPos == i - 1) && (i != 0)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public abstract boolean isNull(int paramInt);
  
  public final boolean move(int paramInt)
  {
    return moveToPosition(mPos + paramInt);
  }
  
  public final boolean moveToFirst()
  {
    return moveToPosition(0);
  }
  
  public final boolean moveToLast()
  {
    return moveToPosition(getCount() - 1);
  }
  
  public final boolean moveToNext()
  {
    return moveToPosition(mPos + 1);
  }
  
  public final boolean moveToPosition(int paramInt)
  {
    int i = getCount();
    if (paramInt >= i)
    {
      mPos = i;
      return false;
    }
    if (paramInt < 0)
    {
      mPos = -1;
      return false;
    }
    i = mPos;
    if (paramInt == i) {
      return true;
    }
    boolean bool = onMove(i, paramInt);
    if (!bool)
    {
      mPos = -1;
    }
    else
    {
      mPos = paramInt;
      paramInt = mRowIdColumnIndex;
      if (paramInt != -1) {
        mCurrentRowID = Long.valueOf(getLong(paramInt));
      }
    }
    return bool;
  }
  
  public final boolean moveToPrevious()
  {
    return moveToPosition(mPos - 1);
  }
  
  public void notifyDataSetChange()
  {
    mDataSetObservable.notifyChanged();
  }
  
  public void onChange(boolean paramBoolean)
  {
    synchronized (mSelfObserverLock)
    {
      mContentObservable.dispatchChange(paramBoolean);
      if ((mNotifyUri != null) && (paramBoolean)) {
        mContentResolver.notifyChange(mNotifyUri, mSelfObserver);
      }
      return;
    }
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver)
  {
    mContentObservable.registerObserver(paramContentObserver);
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    mDataSetObservable.registerObserver(paramDataSetObserver);
  }
  
  public boolean requery()
  {
    ContentObserver localContentObserver = mSelfObserver;
    if ((localContentObserver != null) && (!mSelfObserverRegistered))
    {
      mContentResolver.registerContentObserver(mNotifyUri, true, localContentObserver);
      mSelfObserverRegistered = true;
    }
    mDataSetObservable.notifyChanged();
    return true;
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    return Bundle.EMPTY;
  }
  
  public void setExtras(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = Bundle.EMPTY;
    }
    mExtras = localBundle;
  }
  
  public void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri)
  {
    synchronized (mSelfObserverLock)
    {
      mNotifyUri = paramUri;
      mContentResolver = paramContentResolver;
      if (mSelfObserver != null) {
        paramContentResolver.unregisterContentObserver(mSelfObserver);
      }
      paramContentResolver = new net/sqlcipher/AbstractCursor$SelfContentObserver;
      paramContentResolver.<init>(this);
      mSelfObserver = paramContentResolver;
      mContentResolver.registerContentObserver(mNotifyUri, true, paramContentResolver);
      mSelfObserverRegistered = true;
      return;
    }
  }
  
  public boolean supportsUpdates()
  {
    boolean bool;
    if (mRowIdColumnIndex != -1) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    if (!mClosed) {
      mContentObservable.unregisterObserver(paramContentObserver);
    }
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    mDataSetObservable.unregisterObserver(paramDataSetObserver);
  }
  
  public boolean update(int paramInt, Object paramObject)
  {
    if (!supportsUpdates()) {
      return false;
    }
    Long localLong = Long.valueOf(getLong(mRowIdColumnIndex));
    if (localLong != null) {
      synchronized (mUpdatedRows)
      {
        Map localMap = (Map)mUpdatedRows.get(localLong);
        Object localObject = localMap;
        if (localMap == null)
        {
          localObject = new java/util/HashMap;
          ((HashMap)localObject).<init>();
          mUpdatedRows.put(localLong, localObject);
        }
        ((Map)localObject).put(getColumnNames()[paramInt], paramObject);
        return true;
      }
    }
    paramObject = a.a("null rowid. mRowIdColumnIndex = ");
    ((StringBuilder)paramObject).append(mRowIdColumnIndex);
    throw new IllegalStateException(((StringBuilder)paramObject).toString());
  }
  
  public boolean updateBlob(int paramInt, byte[] paramArrayOfByte)
  {
    return update(paramInt, paramArrayOfByte);
  }
  
  public boolean updateDouble(int paramInt, double paramDouble)
  {
    return update(paramInt, Double.valueOf(paramDouble));
  }
  
  public boolean updateFloat(int paramInt, float paramFloat)
  {
    return update(paramInt, Float.valueOf(paramFloat));
  }
  
  public boolean updateInt(int paramInt1, int paramInt2)
  {
    return update(paramInt1, Integer.valueOf(paramInt2));
  }
  
  public boolean updateLong(int paramInt, long paramLong)
  {
    return update(paramInt, Long.valueOf(paramLong));
  }
  
  public boolean updateShort(int paramInt, short paramShort)
  {
    return update(paramInt, Short.valueOf(paramShort));
  }
  
  public boolean updateString(int paramInt, String paramString)
  {
    return update(paramInt, paramString);
  }
  
  public boolean updateToNull(int paramInt)
  {
    return update(paramInt, null);
  }
  
  public static class SelfContentObserver
    extends ContentObserver
  {
    public WeakReference<AbstractCursor> mCursor;
    
    public SelfContentObserver(AbstractCursor paramAbstractCursor)
    {
      super();
      mCursor = new WeakReference(paramAbstractCursor);
    }
    
    public boolean deliverSelfNotifications()
    {
      return false;
    }
    
    public void onChange(boolean paramBoolean)
    {
      AbstractCursor localAbstractCursor = (AbstractCursor)mCursor.get();
      if (localAbstractCursor != null) {
        localAbstractCursor.onChange(false);
      }
    }
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.AbstractCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */