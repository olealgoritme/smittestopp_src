package d.w.a;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.io.File;

public abstract class c$a
{
  public final int a;
  
  public c$a(int paramInt)
  {
    a = paramInt;
  }
  
  public abstract void a(b paramb, int paramInt1, int paramInt2);
  
  public final void a(String paramString)
  {
    if ((!paramString.equalsIgnoreCase(":memory:")) && (paramString.trim().length() != 0))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleting the database file: ");
      ((StringBuilder)localObject).append(paramString);
      Log.w("SupportSQLite", ((StringBuilder)localObject).toString());
      try
      {
        localObject = new java/io/File;
        ((File)localObject).<init>(paramString);
        SQLiteDatabase.deleteDatabase((File)localObject);
      }
      catch (Exception paramString)
      {
        Log.w("SupportSQLite", "delete failed: ", paramString);
      }
    }
  }
}

/* Location:
 * Qualified Name:     base.d.w.a.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */