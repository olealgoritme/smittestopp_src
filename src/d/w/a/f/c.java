package d.w.a.f;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import d.w.a.b;

public class c
  implements d.w.a.c
{
  public final c.a a;
  
  public c(Context paramContext, String paramString, d.w.a.c.a parama)
  {
    a = new c.a(paramContext, paramString, new a[1], parama);
  }
  
  public b a()
  {
    return a.a();
  }
  
  public void a(boolean paramBoolean)
  {
    a.setWriteAheadLoggingEnabled(paramBoolean);
  }
  
  public String b()
  {
    return a.getDatabaseName();
  }
}

/* Location:
 * Qualified Name:     base.d.w.a.f.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */