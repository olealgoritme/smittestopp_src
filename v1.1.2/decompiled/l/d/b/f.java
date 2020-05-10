package l.d.b;

import java.util.Collection;
import l.d.b.i.d;
import l.d.b.j.i;
import l.d.b.j.i.b;

public class f
{
  public final int a;
  public final Class<?> b;
  public final String c;
  public final boolean d;
  public final String e;
  
  public f(int paramInt, Class<?> paramClass, String paramString1, boolean paramBoolean, String paramString2)
  {
    a = paramInt;
    b = paramClass;
    c = paramString1;
    d = paramBoolean;
    e = paramString2;
  }
  
  public i a(Object paramObject)
  {
    return new i.b(this, "=?", paramObject);
  }
  
  public i a(Collection<?> paramCollection)
  {
    Object[] arrayOfObject = paramCollection.toArray();
    paramCollection = new StringBuilder(" IN (");
    d.a(paramCollection, arrayOfObject.length);
    paramCollection.append(')');
    return new i.b(this, paramCollection.toString(), arrayOfObject);
  }
}

/* Location:
 * Qualified Name:     l.d.b.f
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */