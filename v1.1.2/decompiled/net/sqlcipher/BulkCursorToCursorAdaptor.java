package net.sqlcipher;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import e.a.a.a.a;

public final class BulkCursorToCursorAdaptor
  extends AbstractWindowedCursor
{
  public static final String TAG = "BulkCursor";
  public IBulkCursor mBulkCursor;
  public String[] mColumns;
  public int mCount;
  public AbstractCursor.SelfContentObserver mObserverBridge;
  public boolean mWantsAllOnMoveCalls;
  
  public static int findRowIdColumnIndex(String[] paramArrayOfString)
  {
    int i = paramArrayOfString.length;
    for (int j = 0; j < i; j++) {
      if (paramArrayOfString[j].equals("_id")) {
        return j;
      }
    }
    return -1;
  }
  
  public void close()
  {
    super.close();
    try
    {
      mBulkCursor.close();
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("BulkCursor", "Remote process exception when closing");
    }
    mWindow = null;
  }
  
  /* Error */
  public boolean commitUpdates(java.util.Map<? extends Long, ? extends java.util.Map<String, Object>> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 63	net/sqlcipher/AbstractCursor:supportsUpdates	()Z
    //   4: ifne +13 -> 17
    //   7: ldc 8
    //   9: ldc 65
    //   11: invokestatic 68	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   14: pop
    //   15: iconst_0
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 72	net/sqlcipher/AbstractCursor:mUpdatedRows	Ljava/util/HashMap;
    //   21: astore_2
    //   22: aload_2
    //   23: monitorenter
    //   24: aload_1
    //   25: ifnull +11 -> 36
    //   28: aload_0
    //   29: getfield 72	net/sqlcipher/AbstractCursor:mUpdatedRows	Ljava/util/HashMap;
    //   32: aload_1
    //   33: invokevirtual 78	java/util/HashMap:putAll	(Ljava/util/Map;)V
    //   36: aload_0
    //   37: getfield 72	net/sqlcipher/AbstractCursor:mUpdatedRows	Ljava/util/HashMap;
    //   40: invokevirtual 82	java/util/HashMap:size	()I
    //   43: ifgt +7 -> 50
    //   46: aload_2
    //   47: monitorexit
    //   48: iconst_0
    //   49: ireturn
    //   50: aload_0
    //   51: getfield 42	net/sqlcipher/BulkCursorToCursorAdaptor:mBulkCursor	Lnet/sqlcipher/IBulkCursor;
    //   54: aload_0
    //   55: getfield 72	net/sqlcipher/AbstractCursor:mUpdatedRows	Ljava/util/HashMap;
    //   58: invokeinterface 85 2 0
    //   63: istore_3
    //   64: iload_3
    //   65: iconst_1
    //   66: if_icmpne +15 -> 81
    //   69: aload_0
    //   70: getfield 72	net/sqlcipher/AbstractCursor:mUpdatedRows	Ljava/util/HashMap;
    //   73: invokevirtual 88	java/util/HashMap:clear	()V
    //   76: aload_0
    //   77: iconst_1
    //   78: invokevirtual 92	net/sqlcipher/AbstractCursor:onChange	(Z)V
    //   81: aload_2
    //   82: monitorexit
    //   83: iload_3
    //   84: ireturn
    //   85: astore_1
    //   86: ldc 8
    //   88: ldc 94
    //   90: invokestatic 68	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   93: pop
    //   94: aload_2
    //   95: monitorexit
    //   96: iconst_0
    //   97: ireturn
    //   98: astore_1
    //   99: aload_2
    //   100: monitorexit
    //   101: aload_1
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	BulkCursorToCursorAdaptor
    //   0	103	1	paramMap	java.util.Map<? extends Long, ? extends java.util.Map<String, Object>>
    //   21	79	2	localHashMap	java.util.HashMap
    //   63	21	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   50	64	85	android/os/RemoteException
    //   69	81	85	android/os/RemoteException
    //   28	36	98	finally
    //   36	48	98	finally
    //   50	64	98	finally
    //   69	81	98	finally
    //   81	83	98	finally
    //   86	96	98	finally
    //   99	101	98	finally
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer) {}
  
  public void deactivate()
  {
    super.deactivate();
    try
    {
      mBulkCursor.deactivate();
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("BulkCursor", "Remote process exception when deactivating");
    }
    mWindow = null;
  }
  
  public boolean deleteRow()
  {
    try
    {
      boolean bool = mBulkCursor.deleteRow(mPos);
      if (bool)
      {
        mWindow = null;
        int i = mBulkCursor.count();
        mCount = i;
        if (mPos < i)
        {
          i = mPos;
          mPos = -1;
          moveToPosition(i);
        }
        else
        {
          mPos = i;
        }
        onChange(true);
      }
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("BulkCursor", "Unable to delete row because the remote process is dead");
    }
    return false;
  }
  
  public String[] getColumnNames()
  {
    if (mColumns == null) {
      try
      {
        mColumns = mBulkCursor.getColumnNames();
      }
      catch (RemoteException localRemoteException)
      {
        Log.e("BulkCursor", "Unable to fetch column names because the remote process is dead");
        return null;
      }
    }
    return mColumns;
  }
  
  public int getCount()
  {
    return mCount;
  }
  
  public Bundle getExtras()
  {
    try
    {
      Bundle localBundle = mBulkCursor.getExtras();
      return localBundle;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeException(localRemoteException);
    }
  }
  
  public IContentObserver getObserver()
  {
    try
    {
      if (mObserverBridge == null)
      {
        AbstractCursor.SelfContentObserver localSelfContentObserver = new net/sqlcipher/AbstractCursor$SelfContentObserver;
        localSelfContentObserver.<init>(this);
        mObserverBridge = localSelfContentObserver;
      }
      return null;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean onMove(int paramInt1, int paramInt2)
  {
    try
    {
      if (mWindow != null)
      {
        if ((paramInt2 >= mWindow.getStartPosition()) && (paramInt2 < mWindow.getStartPosition() + mWindow.getNumRows()))
        {
          if (mWantsAllOnMoveCalls) {
            mBulkCursor.onMove(paramInt2);
          }
        }
        else {
          mWindow = mBulkCursor.getWindow(paramInt2);
        }
      }
      else {
        mWindow = mBulkCursor.getWindow(paramInt2);
      }
      return mWindow != null;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("BulkCursor", "Unable to get window because the remote process is dead");
    }
    return false;
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver) {}
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver) {}
  
  public boolean requery()
  {
    try
    {
      localObject = mBulkCursor;
      IContentObserver localIContentObserver = getObserver();
      CursorWindow localCursorWindow = new net/sqlcipher/CursorWindow;
      localCursorWindow.<init>(false);
      int i = ((IBulkCursor)localObject).requery(localIContentObserver, localCursorWindow);
      mCount = i;
      if (i != -1)
      {
        mPos = -1;
        mWindow = null;
        super.requery();
        return true;
      }
      deactivate();
      return false;
    }
    catch (Exception localException)
    {
      Object localObject = a.a("Unable to requery because the remote process exception ");
      ((StringBuilder)localObject).append(localException.getMessage());
      Log.e("BulkCursor", ((StringBuilder)localObject).toString());
      deactivate();
    }
    return false;
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    try
    {
      paramBundle = mBulkCursor.respond(paramBundle);
      return paramBundle;
    }
    catch (RemoteException paramBundle)
    {
      Log.w("BulkCursor", "respond() threw RemoteException, returning an empty bundle.", paramBundle);
    }
    return Bundle.EMPTY;
  }
  
  public void set(IBulkCursor paramIBulkCursor)
  {
    mBulkCursor = paramIBulkCursor;
    try
    {
      mCount = paramIBulkCursor.count();
      mWantsAllOnMoveCalls = mBulkCursor.getWantsAllOnMoveCalls();
      paramIBulkCursor = mBulkCursor.getColumnNames();
      mColumns = paramIBulkCursor;
      mRowIdColumnIndex = findRowIdColumnIndex(paramIBulkCursor);
    }
    catch (RemoteException paramIBulkCursor)
    {
      Log.e("BulkCursor", "Setup failed because the remote process is dead");
    }
  }
  
  public void set(IBulkCursor paramIBulkCursor, int paramInt1, int paramInt2)
  {
    mBulkCursor = paramIBulkCursor;
    mColumns = null;
    mCount = paramInt1;
    mRowIdColumnIndex = paramInt2;
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver) {}
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {}
}

/* Location:
 * Qualified Name:     net.sqlcipher.BulkCursorToCursorAdaptor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */