package l.d.b.i;

import l.d.b.g.a;
import l.d.b.g.c;

public class e
{
  public final a a;
  public final String b;
  public final String[] c;
  public final String[] d;
  public c e;
  public c f;
  public c g;
  public volatile String h;
  
  public e(a parama, String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    a = parama;
    b = paramString;
    c = paramArrayOfString1;
    d = paramArrayOfString2;
  }
  
  public c a()
  {
    if (f == null)
    {
      Object localObject1 = d.a("INSERT OR REPLACE INTO ", b, c);
      localObject1 = a.compileStatement((String)localObject1);
      try
      {
        if (f == null) {
          f = ((c)localObject1);
        }
        if (f != localObject1) {
          ((c)localObject1).close();
        }
      }
      finally {}
    }
    return f;
  }
  
  public c b()
  {
    if (e == null)
    {
      Object localObject1 = d.a("INSERT INTO ", b, c);
      localObject1 = a.compileStatement((String)localObject1);
      try
      {
        if (e == null) {
          e = ((c)localObject1);
        }
        if (e != localObject1) {
          ((c)localObject1).close();
        }
      }
      finally {}
    }
    return e;
  }
  
  public c c()
  {
    if (g == null)
    {
      Object localObject1 = d.a(b, c, d);
      localObject1 = a.compileStatement((String)localObject1);
      try
      {
        if (g == null) {
          g = ((c)localObject1);
        }
        if (g != localObject1) {
          ((c)localObject1).close();
        }
      }
      finally {}
    }
    return g;
  }
}

/* Location:
 * Qualified Name:     l.d.b.i.e
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */