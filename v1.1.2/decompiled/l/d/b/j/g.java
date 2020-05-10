package l.d.b.j;

import android.database.Cursor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g<T>
{
  public final h<T> a;
  public final List<Object> b;
  public final List<e<T, ?>> c;
  public final l.d.b.a<T, ?> d;
  public final String e;
  
  public g(l.d.b.a<T, ?> parama)
  {
    d = parama;
    e = "T";
    b = new ArrayList();
    c = new ArrayList();
    a = new h(parama, "T");
  }
  
  public d<T> a()
  {
    if (c.isEmpty())
    {
      String str1 = d.a.y;
      Object localObject = new StringBuilder(l.d.b.i.d.a(str1, null));
      a((StringBuilder)localObject, e);
      String str2 = ((StringBuilder)localObject).toString();
      localObject = e.a.a.a.a.a(new StringBuilder(), e, ".\"");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('"');
      localStringBuilder.append(str1);
      localStringBuilder.append("\".\"");
      str1 = str2.replace((CharSequence)localObject, localStringBuilder.toString());
      return (d)new d.b(d, str1, a.a(b.toArray()), null).b();
    }
    throw new l.d.b.d("JOINs are not supported for DELETE queries");
  }
  
  public g<T> a(i parami, i... paramVarArgs)
  {
    h localh = a;
    localh.a(parami);
    b.add(parami);
    int i = paramVarArgs.length;
    for (int j = 0; j < i; j++)
    {
      parami = paramVarArgs[j];
      localh.a(parami);
      b.add(parami);
    }
    return this;
  }
  
  public final void a(StringBuilder paramStringBuilder, String paramString)
  {
    b.clear();
    Object localObject = c.iterator();
    while (((Iterator)localObject).hasNext())
    {
      e locale = (e)((Iterator)localObject).next();
      paramStringBuilder.append(" JOIN ");
      paramStringBuilder.append(b.a.y);
      paramStringBuilder.append(' ');
      paramStringBuilder.append(e);
      paramStringBuilder.append(" ON ");
      l.d.b.i.d.a(paramStringBuilder, a, c);
      paramStringBuilder.append('=');
      l.d.b.i.d.a(paramStringBuilder, e, d);
    }
    boolean bool = a.b.isEmpty() ^ true;
    if (bool)
    {
      paramStringBuilder.append(" WHERE ");
      a.a(paramStringBuilder, paramString, b);
    }
    paramString = c.iterator();
    while (paramString.hasNext())
    {
      localObject = (e)paramString.next();
      if (!f.b.isEmpty())
      {
        if (!bool)
        {
          paramStringBuilder.append(" WHERE ");
          bool = true;
        }
        else
        {
          paramStringBuilder.append(" AND ");
        }
        f.a(paramStringBuilder, e, b);
      }
    }
  }
  
  public List<T> b()
  {
    Object localObject1 = d.a;
    localObject1 = new StringBuilder(l.d.b.i.d.a(y, e, A, false));
    a((StringBuilder)localObject1, e);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = (f)new f.b(d, (String)localObject1, a.a(b.toArray()), -1, -1).b();
    if (localObject2 != null)
    {
      if (Thread.currentThread() == e)
      {
        localObject1 = a.b.a(c, d);
        localObject2 = b.a;
        if (localObject2 != null) {
          try
          {
            localObject2 = ((l.d.b.a)localObject2).a((Cursor)localObject1);
            return (List<T>)localObject2;
          }
          finally
          {
            ((Cursor)localObject1).close();
          }
        }
        throw null;
      }
      throw new l.d.b.d("Method may be called only in owner thread, use forCurrentThread to get an instance for this thread");
    }
    throw null;
  }
}

/* Location:
 * Qualified Name:     l.d.b.j.g
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */