package net.sqlcipher.database;

import android.content.Context;
import d.u.h;
import d.w.a.c.a;
import d.w.a.c.b;

public class SupportHelper$1
  extends SQLiteOpenHelper
{
  public SupportHelper$1(SupportHelper paramSupportHelper, Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt, SQLiteDatabaseHook paramSQLiteDatabaseHook, c.b paramb)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt, paramSQLiteDatabaseHook);
  }
  
  public void onConfigure(SQLiteDatabase paramSQLiteDatabase)
  {
    if ((h)val$configuration.c != null) {
      return;
    }
    throw null;
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    val$configuration.c.a(paramSQLiteDatabase);
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    ((h)val$configuration.c).a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    val$configuration.c.b(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    val$configuration.c.a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     net.sqlcipher.database.SupportHelper.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */