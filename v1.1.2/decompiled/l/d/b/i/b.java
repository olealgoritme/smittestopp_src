package l.d.b.i;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

public final class b
  implements Cursor
{
  public final CursorWindow x;
  public int y;
  public final int z;
  
  public b(CursorWindow paramCursorWindow)
  {
    x = paramCursorWindow;
    z = paramCursorWindow.getNumRows();
  }
  
  public void close()
  {
    throw new UnsupportedOperationException();
  }
  
  public void copyStringToBuffer(int paramInt, CharArrayBuffer paramCharArrayBuffer)
  {
    throw new UnsupportedOperationException();
  }
  
  public void deactivate()
  {
    throw new UnsupportedOperationException();
  }
  
  public byte[] getBlob(int paramInt)
  {
    return x.getBlob(y, paramInt);
  }
  
  public int getColumnCount()
  {
    throw new UnsupportedOperationException();
  }
  
  public int getColumnIndex(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public int getColumnIndexOrThrow(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public String getColumnName(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public String[] getColumnNames()
  {
    throw new UnsupportedOperationException();
  }
  
  public int getCount()
  {
    return x.getNumRows();
  }
  
  public double getDouble(int paramInt)
  {
    return x.getDouble(y, paramInt);
  }
  
  public Bundle getExtras()
  {
    throw new UnsupportedOperationException();
  }
  
  public float getFloat(int paramInt)
  {
    return x.getFloat(y, paramInt);
  }
  
  public int getInt(int paramInt)
  {
    return x.getInt(y, paramInt);
  }
  
  public long getLong(int paramInt)
  {
    return x.getLong(y, paramInt);
  }
  
  public Uri getNotificationUri()
  {
    return null;
  }
  
  public int getPosition()
  {
    return y;
  }
  
  public short getShort(int paramInt)
  {
    return x.getShort(y, paramInt);
  }
  
  public String getString(int paramInt)
  {
    return x.getString(y, paramInt);
  }
  
  public int getType(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean getWantsAllOnMoveCalls()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isAfterLast()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isBeforeFirst()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isClosed()
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean isFirst()
  {
    boolean bool;
    if (y == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isLast()
  {
    int i = y;
    int j = z;
    boolean bool = true;
    if (i != j - 1) {
      bool = false;
    }
    return bool;
  }
  
  public boolean isNull(int paramInt)
  {
    return x.isNull(y, paramInt);
  }
  
  public boolean move(int paramInt)
  {
    return moveToPosition(y + paramInt);
  }
  
  public boolean moveToFirst()
  {
    boolean bool = false;
    y = 0;
    if (z > 0) {
      bool = true;
    }
    return bool;
  }
  
  public boolean moveToLast()
  {
    int i = z;
    if (i > 0)
    {
      y = (i - 1);
      return true;
    }
    return false;
  }
  
  public boolean moveToNext()
  {
    int i = y;
    if (i < z - 1)
    {
      y = (i + 1);
      return true;
    }
    return false;
  }
  
  public boolean moveToPosition(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < z))
    {
      y = paramInt;
      return true;
    }
    return false;
  }
  
  public boolean moveToPrevious()
  {
    int i = y;
    if (i > 0)
    {
      y = (i - 1);
      return true;
    }
    return false;
  }
  
  public void registerContentObserver(ContentObserver paramContentObserver)
  {
    throw new UnsupportedOperationException();
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean requery()
  {
    throw new UnsupportedOperationException();
  }
  
  public Bundle respond(Bundle paramBundle)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setNotificationUri(ContentResolver paramContentResolver, Uri paramUri)
  {
    throw new UnsupportedOperationException();
  }
  
  public void unregisterContentObserver(ContentObserver paramContentObserver)
  {
    throw new UnsupportedOperationException();
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     l.d.b.i.b
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */