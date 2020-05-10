package net.sqlcipher.database;

public abstract class SQLiteClosable
{
  public Object mLock = new Object();
  public int mReferenceCount = 1;
  
  private String getObjInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getName());
    localStringBuilder.append(" (");
    if ((this instanceof SQLiteDatabase))
    {
      localStringBuilder.append("database = ");
      localStringBuilder.append(((SQLiteDatabase)this).getPath());
    }
    else if (((this instanceof SQLiteProgram)) || ((this instanceof SQLiteStatement)) || ((this instanceof SQLiteQuery)))
    {
      localStringBuilder.append("mSql = ");
      localStringBuilder.append(mSql);
    }
    localStringBuilder.append(") ");
    return localStringBuilder.toString();
  }
  
  public void acquireReference()
  {
    synchronized (mLock)
    {
      if (mReferenceCount > 0)
      {
        mReferenceCount += 1;
        return;
      }
      IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append("attempt to re-open an already-closed object: ");
      localStringBuilder.append(getObjInfo());
      localIllegalStateException.<init>(localStringBuilder.toString());
      throw localIllegalStateException;
    }
  }
  
  public abstract void onAllReferencesReleased();
  
  public void onAllReferencesReleasedFromContainer() {}
  
  public void releaseReference()
  {
    synchronized (mLock)
    {
      int i = mReferenceCount - 1;
      mReferenceCount = i;
      if (i == 0) {
        onAllReferencesReleased();
      }
      return;
    }
  }
  
  public void releaseReferenceFromContainer()
  {
    synchronized (mLock)
    {
      int i = mReferenceCount - 1;
      mReferenceCount = i;
      if (i == 0) {
        onAllReferencesReleasedFromContainer();
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteClosable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */