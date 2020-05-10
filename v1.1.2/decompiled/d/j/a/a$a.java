package d.j.a;

import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;

public class a$a
  extends ContentObserver
{
  public a$a(a parama)
  {
    super(new Handler());
  }
  
  public boolean deliverSelfNotifications()
  {
    return true;
  }
  
  public void onChange(boolean paramBoolean)
  {
    a locala = a;
    if (y)
    {
      Cursor localCursor = z;
      if ((localCursor != null) && (!localCursor.isClosed())) {
        x = z.requery();
      }
    }
  }
}

/* Location:
 * Qualified Name:     d.j.a.a.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */