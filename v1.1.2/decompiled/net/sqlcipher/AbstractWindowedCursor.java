package net.sqlcipher;

import android.database.CharArrayBuffer;

public abstract class AbstractWindowedCursor
  extends AbstractCursor
{
  public CursorWindow mWindow;
  
  public void checkPosition()
  {
    super.checkPosition();
    if (mWindow != null) {
      return;
    }
    throw new StaleDataException("Access closed cursor");
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    checkPosition();
    synchronized (mUpdatedRows)
    {
      if (isFieldUpdated(paramInt)) {
        super.copyStringToBuffer(paramInt, paramCharArrayBuffer);
      }
      mWindow.copyStringToBuffer(mPos, paramInt, paramCharArrayBuffer);
      return;
    }
  }
  
  public byte[] getBlob(int paramInt)
  {
    checkPosition();
    synchronized (mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        byte[] arrayOfByte = (byte[])getUpdatedField(paramInt);
        return arrayOfByte;
      }
      return mWindow.getBlob(mPos, paramInt);
    }
  }
  
  public double getDouble(int paramInt)
  {
    checkPosition();
    synchronized (mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        double d = ((Number)getUpdatedField(paramInt)).doubleValue();
        return d;
      }
      return mWindow.getDouble(mPos, paramInt);
    }
  }
  
  public float getFloat(int paramInt)
  {
    checkPosition();
    synchronized (mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        float f = ((Number)getUpdatedField(paramInt)).floatValue();
        return f;
      }
      return mWindow.getFloat(mPos, paramInt);
    }
  }
  
  public int getInt(int paramInt)
  {
    checkPosition();
    synchronized (mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        paramInt = ((Number)getUpdatedField(paramInt)).intValue();
        return paramInt;
      }
      return mWindow.getInt(mPos, paramInt);
    }
  }
  
  public long getLong(int paramInt)
  {
    checkPosition();
    synchronized (mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        long l = ((Number)getUpdatedField(paramInt)).longValue();
        return l;
      }
      return mWindow.getLong(mPos, paramInt);
    }
  }
  
  public short getShort(int paramInt)
  {
    checkPosition();
    synchronized (mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        short s = ((Number)getUpdatedField(paramInt)).shortValue();
        return s;
      }
      return mWindow.getShort(mPos, paramInt);
    }
  }
  
  public String getString(int paramInt)
  {
    checkPosition();
    synchronized (mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        String str = (String)getUpdatedField(paramInt);
        return str;
      }
      return mWindow.getString(mPos, paramInt);
    }
  }
  
  public int getType(int paramInt)
  {
    checkPosition();
    return mWindow.getType(mPos, paramInt);
  }
  
  public CursorWindow getWindow()
  {
    return mWindow;
  }
  
  public boolean hasWindow()
  {
    boolean bool;
    if (mWindow != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isBlob(int paramInt)
  {
    checkPosition();
    synchronized (mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        Object localObject1 = getUpdatedField(paramInt);
        boolean bool;
        if ((localObject1 != null) && (!(localObject1 instanceof byte[]))) {
          bool = false;
        } else {
          bool = true;
        }
        return bool;
      }
      return mWindow.isBlob(mPos, paramInt);
    }
  }
  
  public boolean isFloat(int paramInt)
  {
    checkPosition();
    synchronized (mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        Object localObject1 = getUpdatedField(paramInt);
        boolean bool;
        if ((localObject1 != null) && (((localObject1 instanceof Float)) || ((localObject1 instanceof Double)))) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
      return mWindow.isFloat(mPos, paramInt);
    }
  }
  
  public boolean isLong(int paramInt)
  {
    checkPosition();
    synchronized (mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        Object localObject1 = getUpdatedField(paramInt);
        boolean bool;
        if ((localObject1 != null) && (((localObject1 instanceof Integer)) || ((localObject1 instanceof Long)))) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
      return mWindow.isLong(mPos, paramInt);
    }
  }
  
  public boolean isNull(int paramInt)
  {
    checkPosition();
    synchronized (mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        boolean bool;
        if (getUpdatedField(paramInt) == null) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
      return mWindow.isNull(mPos, paramInt);
    }
  }
  
  public boolean isString(int paramInt)
  {
    checkPosition();
    synchronized (mUpdatedRows)
    {
      if (isFieldUpdated(paramInt))
      {
        Object localObject1 = getUpdatedField(paramInt);
        boolean bool;
        if ((localObject1 != null) && (!(localObject1 instanceof String))) {
          bool = false;
        } else {
          bool = true;
        }
        return bool;
      }
      return mWindow.isString(mPos, paramInt);
    }
  }
  
  public void setWindow(CursorWindow paramCursorWindow)
  {
    CursorWindow localCursorWindow = mWindow;
    if (localCursorWindow != null) {
      localCursorWindow.close();
    }
    mWindow = paramCursorWindow;
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.AbstractWindowedCursor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */