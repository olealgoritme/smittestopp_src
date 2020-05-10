package net.sqlcipher.database;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.locks.ReentrantLock;
import net.sqlcipher.CursorWindow;

public final class SQLiteCursor$QueryThread
  implements Runnable
{
  public final int mThreadState;
  
  public SQLiteCursor$QueryThread(SQLiteCursor paramSQLiteCursor, int paramInt)
  {
    mThreadState = paramInt;
  }
  
  private void sendMessage()
  {
    SQLiteCursor localSQLiteCursor = this$0;
    SQLiteCursor.MainThreadNotificationHandler localMainThreadNotificationHandler = mNotificationHandler;
    if (localMainThreadNotificationHandler != null)
    {
      localMainThreadNotificationHandler.sendEmptyMessage(1);
      SQLiteCursor.access$002(this$0, false);
    }
    else
    {
      SQLiteCursor.access$002(localSQLiteCursor, true);
    }
  }
  
  public void run()
  {
    CursorWindow localCursorWindow = SQLiteCursor.access$100(this$0);
    Process.setThreadPriority(Process.myTid(), 10);
    for (;;)
    {
      if (SQLiteCursor.access$200(this$0) == null) {
        SQLiteCursor.access$202(this$0, new ReentrantLock(true));
      }
      SQLiteCursor.access$200(this$0).lock();
      if (SQLiteCursor.access$300(this$0) != mThreadState)
      {
        SQLiteCursor.access$200(this$0).unlock();
        break label193;
      }
      try
      {
        try
        {
          int i = SQLiteCursor.access$600(this$0).fillWindow(localCursorWindow, SQLiteCursor.access$400(this$0), SQLiteCursor.access$500(this$0));
          if (i != 0)
          {
            if (i == -1)
            {
              SQLiteCursor.access$502(this$0, SQLiteCursor.access$500(this$0) + SQLiteCursor.access$400(this$0));
              sendMessage();
              SQLiteCursor.access$200(this$0).unlock();
              continue;
            }
            SQLiteCursor.access$502(this$0, i);
            sendMessage();
          }
        }
        finally
        {
          SQLiteCursor.access$200(this$0).unlock();
        }
      }
      catch (Exception localException)
      {
        label193:
        for (;;) {}
      }
    }
    SQLiteCursor.access$200(this$0).unlock();
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SQLiteCursor.QueryThread
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */