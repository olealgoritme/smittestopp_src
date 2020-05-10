package d.w.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.io.File;

public abstract interface c
{
  public abstract String getDatabaseName();
  
  public abstract b getWritableDatabase();
  
  public abstract void setWriteAheadLoggingEnabled(boolean paramBoolean);
  
  public static abstract class a
  {
    public final int a;
    
    public a(int paramInt)
    {
      a = paramInt;
    }
    
    public abstract void a(b paramb);
    
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
    
    public abstract void b(b paramb);
  }
  
  public static class b
  {
    public final Context a;
    public final String b;
    public final c.a c;
    
    public b(Context paramContext, String paramString, c.a parama)
    {
      a = paramContext;
      b = paramString;
      c = parama;
    }
  }
  
  public static abstract interface c
  {
    public abstract c create(c.b paramb);
  }
}

/* Location:
 * Qualified Name:     d.w.a.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */