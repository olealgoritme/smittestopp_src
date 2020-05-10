package net.sqlcipher.database;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class SQLiteCursor$MainThreadNotificationHandler
  extends Handler
{
  public final WeakReference<SQLiteCursor> wrappedCursor;
  
  public SQLiteCursor$MainThreadNotificationHandler(SQLiteCursor paramSQLiteCursor)
  {
    wrappedCursor = new WeakReference(paramSQLiteCursor);
  }
  
  public void handleMessage(Message paramMessage)
  {
    paramMessage = (SQLiteCursor)wrappedCursor.get();
    if (paramMessage != null) {
      SQLiteCursor.access$700(paramMessage);
    }
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteCursor.MainThreadNotificationHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */